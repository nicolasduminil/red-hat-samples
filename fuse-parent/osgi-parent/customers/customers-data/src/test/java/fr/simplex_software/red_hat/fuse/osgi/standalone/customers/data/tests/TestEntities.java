package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.tests;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;
import lombok.extern.slf4j.*;
import org.junit.*;

import javax.persistence.*;
import javax.xml.bind.*;
import java.io.*;
import java.util.*;
import java.util.stream.*;

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
    Customers customers = (Customers)jaxbContext.createUnmarshaller().unmarshal(new FileInputStream("src/test/resources/xml/customers.xml"));
    assertNotNull(customers);
    List<CoorporateCustomer> coorporateCustomers = customers.getCoorporateCustomerList().getCoorporateCustomers().stream().map(coorporateCustomerType -> new CoorporateCustomer(coorporateCustomerType)).collect(Collectors.toList());
    getEm().getTransaction().begin();
    coorporateCustomers.forEach(c -> {
      log.debug("### Customer: {}", c.toString());
      c.getContacts().forEach(contact -> {
        contact.setCustomer(c);
        log.debug ("### Contact: {}", contact);
      });
      getEm().persist(c);
    });
    getEm().getTransaction().commit();
    Query q = getEm().createQuery("select cc from CoorporateCustomer cc");
    List<Customer> custs = q.getResultList();
    assertNotNull(custs);
    assertEquals(2, custs.size());
    List<IndividualCustomer> individualCustomers = customers.getIndividualCustomerList().getIndividualCustomers().stream().map(individualCustomerType -> new IndividualCustomer(individualCustomerType)).collect(Collectors.toList());
    getEm().getTransaction().begin();
    individualCustomers.forEach(c -> {
      log.debug("### Customer: {}", c.toString());
      c.getContacts().forEach(contact -> {
        contact.setCustomer(c);
        log.debug ("### Contact: {}", contact);
      });
      getEm().persist(c);
    });
    getEm().getTransaction().commit();
    q = getEm().createQuery("select ic from IndividualCustomer ic");
    custs = q.getResultList();
    assertNotNull(custs);
    assertEquals(2, custs.size());
  }
}
