package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;
import lombok.*;
import lombok.extern.slf4j.*;

import javax.persistence.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CUSTOMERS")
@Slf4j
@ToString
public class Customer
{
  @ToString.Exclude
  private BigInteger customerId;
  private String customerInternalName;
  private List<Address> addresses;
  private List<Contact> contacts;

  public Customer()
  {
  }

  public Customer(String customerInternalName, List<Address> addresses, List<Contact> contacts)
  {
    this.customerInternalName = customerInternalName;
    this.addresses = addresses;
    this.contacts = contacts;
  }

  public Customer(CustomerType customerType)
  {
    this.customerInternalName = customerType.getInternalName();
    this.addresses = customerType.getAddressList().getAddresses().stream().map(address -> new Address(address)).collect(Collectors.toList());
    this.contacts = customerType.getContactList().getContacts().stream().map(contact -> new Contact(contact)).collect(Collectors.toList());
  }


  @Id
  @SequenceGenerator(name = "CUSTOMERS_ID_GENERATOR", sequenceName = "CUSTOMERS_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMERS_ID_GENERATOR")
  @Column(name = "CUSTOMER_ID", unique = true, nullable = false, length = 8)
  public BigInteger getCustomerId()
  {
    return customerId;
  }

  public void setCustomerId(BigInteger customerId)
  {
    this.customerId = customerId;
  }

  @Column(name = "CUSTOMER_INTERNAL_NAME", nullable = false, length = 40)
  public String getCustomerInternalName()
  {
    return customerInternalName;
  }

  public void setCustomerInternalName(String customerInternalName)
  {
    this.customerInternalName = customerInternalName;
  }

  @ElementCollection
  @CollectionTable(name = "ADDRESSES", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
  public List<Address> getAddresses()
  {
    return addresses;
  }

  public void setAddresses(List<Address> addresses)
  {
    this.addresses = addresses;
  }

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  public List<Contact> getContacts()
  {
    return contacts;
  }

  public void setContacts(List<Contact> contacts)
  {
    this.contacts = contacts;
  }

  public void addContact(Contact contact)
  {
    this.contacts.add(contact);
  }

  public void removeContact(Contact contact)
  {
    this.contacts.remove(contact);
  }

  public void addAddress(Address address)
  {
    this.getAddresses().add(address);
  }

  public void removeAddress(Address address)
  {
    this.getAddresses().remove(address);
  }
}
