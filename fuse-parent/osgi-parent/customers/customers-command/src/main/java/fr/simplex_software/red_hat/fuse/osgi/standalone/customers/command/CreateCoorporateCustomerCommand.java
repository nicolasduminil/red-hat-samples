package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.*;
import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;

@Service
@Command(scope = "customers", name = "create-coorporate", description = "Create a coorporate customer")
public class CreateCoorporateCustomerCommand implements Action
{
  @Reference
  private CustomerDataService customerManagementService;
  @Argument(index = 0, name = "internalName", description = "Customer internal name", required = true, multiValued = false)
  private String internalName;
  @Argument(index = 1, name = "firstName", description = "Customer first name", required = true, multiValued = false)
  private String firstName;
  @Argument(index = 2, name = "lastName", description = "Customer last name", required = true, multiValued = false)
  private String lastName;
  @Argument(index = 3, name = "phoneNumber", description = "Customer phone number", required = true, multiValued = false)
  private String phoneNumber;
  @Argument(index = 4, name = "emailAddress", description = "Customer email address", required = true, multiValued = false)
  private String emailAddress;
  @Argument(index = 5, name = "street", description = "Customer address: street", required = true, multiValued = false)
  private String street;
  @Argument(index = 6, name = "city", description = "Customer address: city", required = true, multiValued = false)
  private String city;
  @Argument(index = 7, name = "state", description = "Customer address: state", required = true, multiValued = false)
  private String state;
  @Argument(index = 8, name = "zip", description = "Customer address: zip code", required = true, multiValued = false)
  private String zip;
  @Argument(index = 9, name = "country", description = "Customer address: country", required = true, multiValued = false)
  private String country;
  @Argument(index = 10, name = "companyName", description = "Customer company name", required = true, multiValued = false)
  private String companyName;

  @Override
  public Object execute() throws Exception
  {
    Customer customer = new CoorporateCustomer(internalName, companyName);
    customer.addAddress(new Address (street, city, state, zip, country, Boolean.TRUE));
    customer.addContact(new Contact(firstName, lastName, phoneNumber, emailAddress, customer));
    customerManagementService.createCustomer(customer);
    return null;
  }
}
