package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table (name = "INDIVIDUAL_CUSTOMERS")
public class IndividualCustomer extends Customer
{
  public IndividualCustomer()
  {
  }

  public IndividualCustomer(String customerInternalName)
  {
    super(customerInternalName, new ArrayList<Address>(), new ArrayList<Contact>());
  }

  public IndividualCustomer (IndividualCustomerType individualCustomerType)
  {
    super (individualCustomerType);
  }
}
