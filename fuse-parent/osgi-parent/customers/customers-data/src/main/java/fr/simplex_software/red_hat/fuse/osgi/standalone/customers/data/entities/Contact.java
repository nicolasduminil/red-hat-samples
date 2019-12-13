package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import javax.persistence.*;
import java.math.*;
import java.util.*;

@Entity
@Table (name="CONTACTS")
public class Contact
{
  private BigInteger contactId;
  private String firstName;
  private String lastName;
  private List<String> phoneNumbers;
  private String emailAddress;
  private Customer customer;

  public Contact()
  {
  }

  public Contact(BigInteger contactId, String firstName, String lastName, List<String> phoneNumbers, String emailAddress, CoorporateCustomer coorporateCustomer, IndividualCustomer individualCustomer)
  {
    this.contactId = contactId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumbers = phoneNumbers;
    this.emailAddress = emailAddress;
    this.customer = customer;
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

  public List<String> getPhoneNumbers()
  {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<String> phoneNumbers)
  {
    this.phoneNumbers = phoneNumbers;
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
