package fr.simplex_software.red_hat.fuse.standalone.customers.data.services;

import fr.simplex_software.red_hat.fuse.standalone.customers.data.entities.*;

import java.math.*;
import java.util.*;

public interface CustomerDataService
{
  public List<Customer> getCustomers();
  public Customer getCustomer (BigInteger id);
  public void createCustomer (Customer customer);
  public void removeCustomer (Customer customer);
  public List<Contact> getContacts();
  public Contact getContact (BigInteger id);
  public void createContact (Contact contact);
  public void removeContact (Contact contact);
  public List<Address> getAddresses(BigInteger id);
  public Address getAddress (BigInteger id);
  public void createAddress (Address address, BigInteger id);
  public void removeAddress (Address address, BigInteger id);
  public List<Contact> getContactsByCustomer (BigInteger id);
  public void removeCustomerById(BigInteger id);
}
