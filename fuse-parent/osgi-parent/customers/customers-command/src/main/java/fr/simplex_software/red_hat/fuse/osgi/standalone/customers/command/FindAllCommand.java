package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.services.*;
import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;
import org.apache.karaf.shell.support.table.*;

@Service
@Command(scope = "customers", name = "findAll", description = "List of customers")
public class FindAllCommand implements Action
{
  @Reference
  private CustomerDataService customerManagementService;

  @Override
  public Object execute() throws Exception
  {
    ShellTable table = new ShellTable();
    table.column("ID");
    table.column("Internal Name");
    table.column("First Name");
    table.column("Last Name");
    table.column("Phone Number");
    table.column("Email Address");
    table.column("Street");
    table.column("City");
    table.column("State");
    table.column("Zip Code");
    table.column("Country");
    for (Customer customer : customerManagementService.getCustomers())
      table.addRow().addContent(customer.getCustomerId(), customer.getContacts().get(0).getFirstName(), customer.getContacts().get(0).getLastName(),
        customer.getAddresses().get(0).getStreet(), customer.getAddresses().get(0).getCity(), customer.getAddresses().get(0).getState(),
        customer.getAddresses().get(0).getZip(), customer.getAddresses().get(0).getCountry());
    table.print(System.out);
    return null;
  }
}
