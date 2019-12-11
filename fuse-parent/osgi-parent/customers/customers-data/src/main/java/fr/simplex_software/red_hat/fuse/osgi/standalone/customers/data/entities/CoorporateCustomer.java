package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "COORPORATE_CUSTOMER")
public class CoorporateCustomer extends Customer
{
  private String companyName;
  private List<Contact> contacts;

  public CoorporateCustomer()
  {
  }

  public CoorporateCustomer(String customerInternalName, List<Address> addresses, String companyName, List<Contact> contacts)
  {
    super(customerInternalName, addresses);
    this.companyName = companyName;
    this.contacts = contacts;
  }

  @Column(name = "COMPANY_NAME", nullable = false, length = 40)
  public String getCompanyName()
  {
    return companyName;
  }

  public void setCompanyName(String companyName)
  {
    this.companyName = companyName;
  }

  @OneToMany(mappedBy = "coorporateCustomer", cascade = CascadeType.ALL, orphanRemoval = true)
  public List<Contact> getContacts()
  {
    return contacts;
  }

  public void setContacts(List<Contact> contacts)
  {
    this.contacts = contacts;
  }
}
