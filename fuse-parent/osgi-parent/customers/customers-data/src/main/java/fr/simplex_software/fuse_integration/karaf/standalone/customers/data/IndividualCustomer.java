package fr.simplex_software.fuse_integration.karaf.standalone.customers.data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "INDIVIDUAL_CUSTOMER")
public class IndividualCustomer extends Customer
{
  private Contact contact;

  public IndividualCustomer(Contact contact)
  {
    this.contact = contact;
  }

  public IndividualCustomer(String customerInternalName, List<Address> addresses, Contact contact)
  {
    super(customerInternalName, addresses);
    this.contact = contact;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "CONTACT_ID", referencedColumnName = "CUSTOMER_ID")
  public Contact getContact()
  {
    return contact;
  }

  public void setContact(Contact contact)
  {
    this.contact = contact;
  }
}
