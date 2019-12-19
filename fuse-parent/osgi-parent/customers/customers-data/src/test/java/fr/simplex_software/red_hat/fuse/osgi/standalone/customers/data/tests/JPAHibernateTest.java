package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.tests;

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
