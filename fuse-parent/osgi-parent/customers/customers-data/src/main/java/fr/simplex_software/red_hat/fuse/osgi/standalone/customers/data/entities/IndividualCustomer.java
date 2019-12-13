package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "INDIVIDUAL_CUSTOMER")
public class IndividualCustomer extends Customer
{
  public IndividualCustomer()
  {
  }

  public IndividualCustomer(String customerInternalName)
  {
    super(customerInternalName, new ArrayList<Address>(), new ArrayList<Contact>());
  }
}
