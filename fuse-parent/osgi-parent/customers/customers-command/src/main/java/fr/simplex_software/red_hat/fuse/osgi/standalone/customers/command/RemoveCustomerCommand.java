package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command.completer.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.services.*;
import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;

import java.math.*;

@Service
@Command(scope = "customers", name = "removeCustomer", description = "Remove a customer")
public class RemoveCustomerCommand implements Action
{
  @Reference
  private CustomerDataService customerManagementService;
  @Argument(index = 0, name = "id", description = "Customer id", required = true, multiValued = false)
  @Completion(CustomerIdCompleter.class)
  private BigInteger id;

  @Override
  public Object execute() throws Exception
  {
    customerManagementService.removeCustomerById(id);
    return null;
  }
}
