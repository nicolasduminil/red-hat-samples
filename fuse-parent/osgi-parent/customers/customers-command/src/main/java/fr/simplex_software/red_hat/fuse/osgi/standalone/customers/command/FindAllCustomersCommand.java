package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.services.*;
import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;
import org.apache.karaf.shell.support.table.*;

import java.io.*;
import java.math.*;

@Service
@Command(scope = "customers", name = "findAll", description = "List of customers")
public class FindAllCustomersCommand implements Action
{
  @Reference
  private CustomerDataService customerManagementService;

  @Override
  public Object execute() throws Exception
  {
    ShellTable table = new ShellTable();
    table.column("ID");
    table.column("Internal Name");
    table.column("Contacts");
    table.column("Addresses");
    for (Customer customer : customerManagementService.getCustomers())
    {
      ByteArrayOutputStream contacts = new ByteArrayOutputStream();
      getContactsTable(customer.getCustomerId()).print(new PrintStream(contacts), true);
      ByteArrayOutputStream addresses = new ByteArrayOutputStream();
      getAddressesTable(customer.getCustomerId()).print(new PrintStream(addresses), true);
      table.addRow().addContent(customer.getCustomerId(), customer.getCustomerInternalName(), contacts.toString(), addresses.toString());
    }
    table.print(System.out);
    return null;
  }

  private ShellTable getContactsTable(BigInteger id)
  {
    ShellTable contactsTable = new ShellTable();
    contactsTable.column("First Name");
    contactsTable.column("Last Name");
    contactsTable.column("Phone Number");
    contactsTable.column("Email Address");
    for (Contact contact : customerManagementService.getContactsByCustomer(id))
      contactsTable.addRow().addContent(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress());
    return contactsTable;
  }

  private ShellTable getAddressesTable(BigInteger id)
  {
    ShellTable addressesTable = new ShellTable();
    addressesTable.column("Street");
    addressesTable.column("City");
    addressesTable.column("State");
    addressesTable.column("Zip Code");
    addressesTable.column("Country");
    for (Address address : customerManagementService.getAddresses(id))
      addressesTable.addRow().addContent(address.getStreet(), address.getCity(), address.getState(), address.getZip(), address.getCountry());
    return addressesTable;
  }
}
