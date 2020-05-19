package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command.completer.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.services.*;
import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;

import java.math.*;

@Service
@Command(scope = "customers", name = "findCustomerById", description = "Find a customer by its id")
public class FindCustomerByIdCommand implements Action
{
  @Reference
  private CustomerDataService customerManagementService;
  @Argument(index = 0, name = "id", description = "Customer ID", required = true, multiValued = false)
  @Completion(CustomerIdCompleter.class)
  private BigInteger id;

  @Override
  public Object execute() throws Exception
  {
    return customerManagementService.getCustomer(id);
  }
}
