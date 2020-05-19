package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command.unit_tests;

import lombok.extern.slf4j.*;
import org.apache.karaf.shell.api.console.*;
import org.apache.log4j.*;
import org.junit.*;
import org.junit.runner.*;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.*;
import org.ops4j.pax.exam.container.remote.*;
import org.ops4j.pax.exam.junit.*;
import org.ops4j.pax.exam.karaf.options.*;
import org.ops4j.pax.exam.options.*;
import org.ops4j.pax.exam.options.extra.*;
import org.slf4j.*;
import org.slf4j.Logger;

import javax.inject.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;

@RunWith(PaxExam.class)
@Slf4j
public class TestCustomerCommand
{
  private static Logger LOG = LoggerFactory.getLogger(TestCustomerCommand.class);
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
        KarafDistributionOption.configureSecurity().disableKarafMBeanServerBuilder(),
        logLevel(LogLevelOption.LogLevel.INFO),
        CoreOptions.systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO"),
        wrappedBundle(maven().groupId("com.oracle.jdbc").artifactId("ojdbc8").version("12.2.0.1")),
        features("mvn:fr.simplex-software.red-hat.fuse.osgi/customers-features/0.0.1-SNAPSHOT/xml", "customers-datasource", "customers-service"),
        mavenBundle().groupId("org.ops4j.pax.jdbc").artifactId("pax-jdbc-oracle").version("1.4.5"),
        features("mvn:fr.simplex-software.red-hat.fuse.osgi/customers-features/0.0.1-SNAPSHOT/xml", "customers-command"),
        new VMOption("-classpath"),
        new VMOption("lib/jdk9plus/*" + File.pathSeparator + "lib/boot/*"),
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
  public void testCreateCoorporateCustomer() throws Exception
  {
    //System.out.println(executeCommand("feature:list | grep customers"));
    String result = executeCommand("customers:create-coorporate Gosselin Richard Carrière +33(0)647612309 richard.carriere@gosselin.fr \"49 rue de Penthièvre\" Quimper None 29000 France \"Gosselin S.A.\"");
    assertNotNull(result);
    result = executeCommand("customers:create-individual Charron Laurence Charron +33(0)615229808 nicolas.duminil@simplex-software.fr \"31 rue la Boétie\" Paris None 75008 France");
    assertNotNull(result);
    result = executeCommand("customers:findAll");
    assertNotNull(result);
    assertTrue(result.length() > 0);
  }

  private String executeCommand(final String command) throws IOException, InterruptedException, ExecutionException, TimeoutException
  {
    byteArrayOutputStream.flush();
    byteArrayOutputStream.reset();
    waitForCommandService(command);
    final Callable<String> commandCallable = () ->
    {
      session.execute(command);
      printStream.flush();
      return byteArrayOutputStream.toString();
    };
    FutureTask<String> commandFuture = new FutureTask<>(commandCallable);
    executor.submit(commandFuture);
    return commandFuture.get(5000L, TimeUnit.MILLISECONDS);
  }

  private void waitForCommandService(String command) throws InterruptedException
  {
    if (command != null && command.length() > 0)
    {
      int spaceIdx = command.indexOf(' ');
      if (spaceIdx > 0)
        command = command.substring(0, spaceIdx);
      int colonIndx = command.indexOf(':');
      String scope = (colonIndx > 0) ? command.substring(0, colonIndx) : "*";
      String name = (colonIndx > 0) ? command.substring(colonIndx + 1) : command;
      long start = System.currentTimeMillis();
      long cur = start;
      while (cur - start < 5000)
      {
        if (sessionFactory.getRegistry().getCommand(scope, name) != null)
          break;
        Thread.sleep(100);
        cur = System.currentTimeMillis();
      }
    }
  }
}
