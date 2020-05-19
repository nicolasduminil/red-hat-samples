package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.rest.integration_tests;

import fr.simplex_software.red_hat.fuse.standalone.customers.data.dtos.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.jaxb.*;
import lombok.extern.slf4j.*;
import org.junit.*;
import org.junit.runners.*;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import javax.xml.bind.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.*;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestIT
{
  private static final Client client = ClientBuilder.newClient();
  private static final WebTarget webTarget = client.target("http://localhost:8181/cxf/api/customers");
  private static Customers customers;

  static
  {
    try
    {
      JAXBContext jaxbContext = JAXBContext.newInstance("fr.simplex_software.red_hat.fuse.standalone.customers.data.jaxb");
      customers = (Customers) Objects.requireNonNull(jaxbContext).createUnmarshaller().unmarshal(new FileInputStream("src/test/resources/xml/customers.xml"));
    }
    catch (JAXBException | FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Test
  public void test1()
  {
    assertNotNull(customers);
    List<CoorporateCustomer> coorporateCustomers = customers.getCoorporateCustomerList().getCoorporateCustomers().stream().map(CoorporateCustomer::new).collect(Collectors.toList());
    coorporateCustomers.forEach(c -> {
      c.getContacts().forEach(contact -> contact.setCustomer(c));
      assertEquals (Response.Status.CREATED, webTarget.request().post(Entity.entity(new CustomerDto(c), "application/xml")).getStatus());
    });
  }
  @Test
  public void test2() throws MalformedURLException
  {
    /*assertNotNull(customers);
    Customers.CoorporateCustomerList coorporateCustomerList = customers.getCoorporateCustomerList();
    assertNotNull(coorporateCustomerList);
    List<CoorporateCustomerType> coorporateCustomerTypes = coorporateCustomerList.getCoorporateCustomers();
    assertTrue (coorporateCustomerTypes.size() > 0);
    CoorporateCustomerType coorporateCustomerType = coorporateCustomerTypes.get(0);
    assertNotNull(coorporateCustomerType);
    String customerId = coorporateCustomerType.get
    //String customerId = new Customer (customers.getCoorporateCustomerList().getCoorporateCustomers().get(0)).getCustomerId().toString();
    log.debug("*** Get a Customer with ID {} ***", customerId);*/
    //Response response = webTarget.path(customerId).request().get();
    log.debug("### URL: {}",webTarget.getUri().toURL().toString());
    Response response = webTarget.request().get();
    assertEquals(200, response.getStatus());
    List<CustomerDto> customerDtos = response.readEntity(new GenericType<List<CustomerDto>>(){});
    assertNotNull(customerDtos);
    assertTrue(customerDtos.size() > 0);
  }

  @Test
  public void test5()
  {
    assertNotNull(customers);
    String customerId = new Customer(customers.getCoorporateCustomerList().getCoorporateCustomers().get(0)).getCustomerId().toString();
    log.debug("*** Delete the customer with ID {} ***", customerId);
    Response response = webTarget.path(customerId).request().delete();
    assertEquals(200, response.getStatus());
  }
}

