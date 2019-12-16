package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.tests;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.*;
import org.apache.karaf.shell.api.action.lifecycle.*;
import org.junit.*;

import javax.xml.bind.*;
import java.io.*;

import static org.junit.Assert.*;

public class TestCustomerService
{
  private static JAXBContext jaxbContext = null;
  private static ObjectFactory objectFactory = null;

  @Reference
  private CustomerServiceImpl customerService;

  @BeforeClass
  public static void setup() throws Exception
  {
    jaxbContext = JAXBContext.newInstance("fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb");
    objectFactory = new ObjectFactory();
  }

  @Test
  public void testCustomers() throws Exception
  {
    Customers customers = (Customers)jaxbContext.createUnmarshaller().unmarshal(new FileInputStream("src/test/resources/xml/customers.xml"));
    assertNotNull(customers);
    //customers.getCoorporateCustomers().getCoorporateCustomers().forEach(customer -> customerService.createCustomer(customer));
  }
}
