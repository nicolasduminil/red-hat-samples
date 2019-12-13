package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "COORPORATE_CUSTOMER")
public class CoorporateCustomer extends Customer
{
  private String companyName;

  public CoorporateCustomer()
  {
  }

  public CoorporateCustomer(String customerInternalName, List<Address> addresses, String companyName)
  {
    super(customerInternalName, addresses, new ArrayList<Contact>());
    this.companyName = companyName;
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
