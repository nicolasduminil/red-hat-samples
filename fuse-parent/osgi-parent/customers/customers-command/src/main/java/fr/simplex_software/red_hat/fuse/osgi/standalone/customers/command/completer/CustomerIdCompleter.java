package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.command.completer;

import fr.simplex_software.red_hat.fuse.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.services.*;
import org.apache.karaf.shell.api.action.lifecycle.*;
import org.apache.karaf.shell.api.console.*;
import org.apache.karaf.shell.support.completers.*;

import java.util.*;

@Service
public class CustomerIdCompleter implements Completer
{
  @Reference
  private CustomerDataService customerManagementService;

  @Override
  public int complete(Session session, CommandLine commandLine, List<String> candidates)
  {
    StringsCompleter delegate = new StringsCompleter();
    for (Customer customer : customerManagementService.getCustomers())
      delegate.getStrings().add(String.valueOf(customer.getCustomerId()));
    return delegate.complete(session, commandLine, candidates);
  }
}
