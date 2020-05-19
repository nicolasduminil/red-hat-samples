package fr.simplex_software.red_hat.fuse.standalone.customers.data.entities;


import fr.simplex_software.red_hat.fuse.standalone.customers.data.jaxb.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "COORPORATE_CUSTOMERS")
public class CoorporateCustomer extends Customer
{
  private String companyName;

  public CoorporateCustomer()
  {
  }

  public CoorporateCustomer(String customerInternalName, String companyName)
  {
    super(customerInternalName, new ArrayList<Address>(), new ArrayList<Contact>());
    this.companyName = companyName;
  }

  public CoorporateCustomer(String customerInternalName, List<Address> addresses, String companyName)
  {
    super(customerInternalName, addresses, new ArrayList<Contact>());
    this.companyName = companyName;
  }

  public CoorporateCustomer (CoorporateCustomerType coorporateCustomerType)
  {
    super (coorporateCustomerType);
    this.companyName = coorporateCustomerType.getCompanyName();
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
}
