package fr.simplex_software.red_hat.osgi.standalone.customers.data.jaxb.tests;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;
import org.junit.*;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class TestModel
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
  public void testUnmarshalling() throws Exception
  {
    Customers customers = (Customers)jaxbContext.createUnmarshaller().unmarshal(new FileInputStream("src/main/resources/xml/customers.xml"));
    assertNotNull(customers);
    List<CoorporateCustomerType> coorporateCustomers = customers.getCoorporateCustomerList().getCoorporateCustomers();
    assertNotNull(coorporateCustomers);
    assertEquals(2, coorporateCustomers.size());
    assertEquals ("Gosselin S.A.", coorporateCustomers.get(0).getCompanyName());
    List<IndividualCustomerType> individualCustomers = customers.getIndividualCustomerList().getIndividualCustomers();
    assertNotNull(individualCustomers);
    assertEquals(2, individualCustomers.size());
    assertEquals ("Laurence", individualCustomers.get(0).getContactList().getContacts().get(0).getFirstName());
  }

  @Test
  public void testMarshalling() throws Exception
  {
    Customers customers = (Customers)jaxbContext.createUnmarshaller().unmarshal(new FileInputStream("src/main/resources/xml/customers.xml"));
    assertNotNull(customers);
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(customers, new FileOutputStream( "src/main/resources/xml/customers2.xml"));
  }
}
