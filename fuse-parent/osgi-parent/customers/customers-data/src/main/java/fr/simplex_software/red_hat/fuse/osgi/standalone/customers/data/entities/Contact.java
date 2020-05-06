package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;
import lombok.*;
import lombok.extern.slf4j.*;

import javax.persistence.*;
import java.math.*;

@Entity
@Table (name="CONTACTS")
@Slf4j
@ToString
public class Contact
{
  @ToString.Exclude
  private BigInteger contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String emailAddress;
  @ToString.Exclude
  private Customer customer;

  public Contact()
  {
  }

  public Contact(String firstName, String lastName, String phoneNumber, String emailAddress)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public Contact(BigInteger contactId, String firstName, String lastName, String phoneNumber, String emailAddress)
  {
    this (firstName, lastName, phoneNumber, emailAddress);
    this.contactId = contactId;
  }

  public Contact(String firstName, String lastName, String phoneNumber, String emailAddress, Customer customer)
  {
    this (firstName, lastName, phoneNumber, emailAddress);
    this.customer = customer;
  }

  public Contact (ContactType contactType)
  {
    this.firstName = contactType.getFirstName();
    this.lastName = contactType.getLastName();
    this.emailAddress = contactType.getEmailAddress();
    this.phoneNumber = contactType.getPhoneNumber();
  }

  @Id
  @SequenceGenerator(name = "CONTACTS_ID_GENERATOR", sequenceName = "CONTACTS_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACTS_ID_GENERATOR")
  @Column(name = "CONTACT_ID", unique = true, nullable = false, length = 8)
  public BigInteger getContactId()
  {
    return contactId;
  }

  public void setContactId(BigInteger contactId)
  {
    this.contactId = contactId;
  }

  @Column(name = "FIRST_NAME", nullable = false, length = 40)
  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  @Column(name = "LAST_NAME", nullable = false, length = 40)
  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  @Column(name = "EMAIL_ADDRESS", nullable = false, length = 80)
  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CUSTOMER_ID")
  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }
}
