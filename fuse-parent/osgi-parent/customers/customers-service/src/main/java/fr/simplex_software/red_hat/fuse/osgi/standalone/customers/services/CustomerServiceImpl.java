package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.services;

import fr.simplex_software.red_hat.fuse.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.services.*;
import org.osgi.service.component.annotations.*;

import javax.persistence.*;
import javax.transaction.*;
import java.math.*;
import java.util.*;

@Component(service = CustomerServiceImpl.class, property = { "osgi.jaxrs.resource=true" })
public class CustomerServiceImpl implements CustomerDataService
{
  @PersistenceContext(unitName = "customers")
  private EntityManager entityManager;

  public void setEntityManager(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public List<Customer> getCustomers()
  {
    return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public Customer getCustomer(BigInteger id)
  {
    Customer customer = entityManager.createQuery("SELECT distinct c FROM Customer c join fetch c.contacts WHERE c.id=:id", Customer.class).setParameter("id", id).getSingleResult();
    customer.setAddresses(getAddresses(id));
    return customer;
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void createCustomer(Customer customer)
  {
    entityManager.persist(customer);
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void removeCustomer(Customer customer)
  {
    entityManager.remove(getCustomer(customer.getCustomerId()));
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public List<Contact> getContacts()
  {
    return entityManager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public Contact getContact(BigInteger id)
  {
    return entityManager.createQuery("SELECT c FROM Contact c where c.id=:id", Contact.class).setParameter("id", id).getSingleResult();
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void createContact(Contact contact)
  {
    entityManager.persist(contact);
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void removeContact(Contact contact)
  {
    entityManager.remove(getContact(contact.getContactId()));
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public List<Address> getAddresses(BigInteger id)
  {
    return entityManager.createQuery("SELECT a FROM Customer c join c.addresses a where c.id=:id", Address.class).setParameter("id", id).getResultList();
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public Address getAddress(BigInteger id)
  {
    return entityManager.createQuery("SELECT c FROM Customer c join c.addresses where c.id=:id", Address.class).setParameter("id", id).getSingleResult();
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void createAddress(Address address, BigInteger id)
  {
    Customer customer = entityManager.createQuery("SELECT c FROM Customer c where c.id=:id", Customer.class).setParameter("id", id).getSingleResult();
    customer.addAddress(address);
    entityManager.merge(customer);
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void removeAddress(Address address, BigInteger id)
  {
    Customer customer = entityManager.createQuery("SELECT c FROM Customer c where c.id=:id", Customer.class).setParameter("id", id).getSingleResult();
    customer.removeAddress(address);
    entityManager.merge(customer);
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public List<Contact> getContactsByCustomer(BigInteger id)
  {
    return entityManager.createQuery("SELECT c FROM Contact c join c.customer where c.customer.id=:id", Contact.class).setParameter("id", id).getResultList();
  }

  @Override
  @Transactional(Transactional.TxType.REQUIRES_NEW)
  public void removeCustomerById(BigInteger id)
  {
    removeCustomer(getCustomer(id));
  }
}
