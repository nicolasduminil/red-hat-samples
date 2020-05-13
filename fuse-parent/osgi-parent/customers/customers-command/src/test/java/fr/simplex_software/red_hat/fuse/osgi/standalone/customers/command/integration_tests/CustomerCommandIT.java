package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command.integration_tests;

import lombok.extern.slf4j.*;
import org.apache.karaf.shell.api.console.*;
import org.junit.*;
import org.junit.runner.*;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.*;
import org.ops4j.pax.exam.junit.*;
import org.ops4j.pax.exam.karaf.options.*;

import javax.inject.*;
import java.io.*;
import java.util.concurrent.*;

import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;

@RunWith(PaxExam.class)
@Slf4j
public class CustomerCommandIT
{
  @Inject
  private SessionFactory sessionFactory;
  private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
  private final PrintStream printStream = new PrintStream(byteArrayOutputStream);
  private PrintStream errStream = new PrintStream(byteArrayOutputStream);
  private Session session;
  private ExecutorService executor = Executors.newCachedThreadPool();

  @Configuration
  public Option[] config()
  {
    return new Option[]
      {
        karafDistributionConfiguration().useDeployFolder(false)
          .frameworkUrl("mvn:org.apache.karaf/apache-karaf/4.2.8/tar.gz")
          .karafVersion("4.2.8"),
        logLevel(LogLevelOption.LogLevel.INFO),
        wrappedBundle(maven().groupId("com.oracle.jdbc").artifactId("ojdbc8").version("12.2.0.1")),
        features("mvn:fr.simplex-software.red-hat.fuse.osgi/customers-features/0.0.1-SNAPSHOT/xml", "customers-datasource", "customers-service"),
        mavenBundle().groupId("org.ops4j.pax.jdbc").artifactId("pax-jdbc-oracle").version("1.4.5"),
        features("mvn:fr.simplex-software.red-hat.fuse.osgi/customers-features/0.0.1-SNAPSHOT/xml", "customers-command"),
        configureConsole().ignoreLocalConsole(), junitBundles()
      };
  }

  @Before
  public void init()
  {
    session = sessionFactory.create(System.in, printStream, errStream);
  }

  @After
  public void cleanUp()
  {
    session = null;
  }

  @Test
  public void testCreateCoorporateCustomer()
  {
    String result = null;
    System.out.println(executeCommand("feature:list"));
    System.out.println(executeCommand("bundle:list"));
    result = executeCommand("customers:create-coorporate Gosselin Richard Carrière +33(0)647612309 richard.carriere@gosselin.fr \"49 rue de Penthièvre\" Quimper None 29000 France \"Gosselin S.A.\"");
    assertNotNull(result);
    result = executeCommand("customers:create-individual Charron Laurence Charron +33(0)615229808 nicolas.duminil@simplex-software.fr \"31 rue la Boétie\" Paris None 75008 France");
    assertNotNull(result);
    result = executeCommand("customers:findAll");
    assertNotNull(result);
    System.out.println(result);
    result = executeCommand("customers:findCustomerById 1");
    assertNotNull(result);
    System.out.println(result);
    result = executeCommand("customers:findCustomerById 2");
    assertNotNull(result);
    System.out.println(result);
    result = executeCommand("customers:removeCustomer 1");
    assertNotNull(result);
    result = executeCommand("customers:removeCustomer 2");
    assertNotNull(result);
  }

  private String executeCommand(final String command)
  {
    String resp = null;
    try
    {
      byteArrayOutputStream.flush();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    byteArrayOutputStream.reset();
    final Callable<String> commandCallable = () ->
    {
      try
      {
        System.err.println(command);
        session.execute(command);
      }
      catch (Exception ex)
      {
        ex.printStackTrace(System.err);
      }
      printStream.flush();
      return byteArrayOutputStream.toString();
    };
    FutureTask<String> commandFuture = new FutureTask<>(commandCallable);
    try
    {
      executor.submit(commandFuture);
      resp =  commandFuture.get(5000L, TimeUnit.MILLISECONDS);
    }
    catch (Exception ex)
    {
      ex.printStackTrace(System.err);
      resp = "SHELL COMMAND TIMED OUT: ";
    }
    return resp;
  }
}
