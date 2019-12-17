package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.tests;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;
import lombok.extern.slf4j.*;
import org.junit.*;

import javax.xml.bind.*;
import java.io.*;

import static org.junit.Assert.*;

@Slf4j
public class TestEntities extends JPAHibernateTest
{
  private static JAXBContext jaxbContext = null;
  private static ObjectFactory objectFactory = null;

  @BeforeClass
  public static void setup() throws Exception
  {
    jaxbContext = JAXBContext.newInstance("fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb");
    objectFactory = new ObjectFactory();
  }

  @Test
  public void testCustomers() throws Exception
  {
    Customers customers = (Customers)jaxbContext.createUnmarshaller().unmarshal(new FileInputStream("src/test/resources/xml/customers2.xml"));
    assertNotNull(customers);
    customers.getCoorporateCustomerList().getCoorporateCustomers().forEach(c -> {
      Customer customer = new Customer (c);
      getEm().persist(customer);
    });
  }
}
