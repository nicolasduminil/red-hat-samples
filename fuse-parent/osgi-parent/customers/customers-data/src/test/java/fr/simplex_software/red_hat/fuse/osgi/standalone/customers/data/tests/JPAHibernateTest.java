package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.tests;

import org.h2.tools.*;
import org.hibernate.*;
import org.hibernate.jdbc.*;
import org.junit.*;

import javax.persistence.*;
import java.io.*;
import java.sql.*;

public class JPAHibernateTest
{
  private static EntityManagerFactory emf;
  private static EntityManager em;

  @BeforeClass
  public static void init() throws FileNotFoundException, SQLException
  {
    emf = Persistence.createEntityManagerFactory("mnf-pu-test");
    em = emf.createEntityManager();
  }

  /*@Before
  public void initializeDatabase()
  {
    Session session = em.unwrap(Session.class);
    session.doWork(new Work()
    {
      @Override
      public void execute(Connection connection) throws SQLException
      {
        try
        {
          File script = new File(getClass().getResource("/data.sql").getFile());
          RunScript.execute(connection, new FileReader(script));
        } catch (FileNotFoundException e)
        {
          throw new RuntimeException("could not initialize with script");
        }
      }
    });
  }*/

  @AfterClass
  public static void tearDown()
  {
    em.clear();
    em.close();
    emf.close();
  }

  public static EntityManagerFactory getEmf()
  {
    return emf;
  }

  public static EntityManager getEm()
  {
    return em;
  }
}
