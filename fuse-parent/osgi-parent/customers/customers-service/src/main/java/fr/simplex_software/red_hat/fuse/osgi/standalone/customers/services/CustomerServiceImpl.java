package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.services;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.*;

import javax.persistence.*;
import javax.transaction.*;
import java.math.*;
import java.util.*;

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
    TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
    return query.getResultList();
  }

  @Override
  @Transactional(Transactional.TxType.SUPPORTS)
  public Customer getCustomer(BigInteger id)
  {
    TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.id=:id", Customer.class);
    query.setParameter("id", id);
    return query.getSingleResult();
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
}
