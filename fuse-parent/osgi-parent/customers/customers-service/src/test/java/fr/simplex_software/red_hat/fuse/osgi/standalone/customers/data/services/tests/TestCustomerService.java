package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.tests;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.services.*;
import org.apache.karaf.shell.api.action.lifecycle.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;

import javax.xml.bind.*;
import java.io.*;
import java.math.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCustomerService
{
  @Mock
  private CustomerServiceImpl customerService;

  @Test
  public void testgetCustomer() throws Exception
  {
    when(customerService.getCustomer(any())).thenReturn(new Customer());
    Customer customer = customerService.getCustomer(new BigInteger("1"));
    assertNotNull (customer);
  }
}
