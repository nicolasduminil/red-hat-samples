package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;

import java.math.*;
import java.util.*;

public interface CustomerDataService
{
  public List<Customer> getCustomers();
  public Customer getCustomer (BigInteger id);
  public void createCustomer (Customer customer);
  public void removeCustomer (Customer customer);
}
