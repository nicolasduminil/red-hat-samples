package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.rest;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.services.*;
import org.apache.karaf.shell.api.action.lifecycle.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.math.*;

@Path("/")
@Produces("application/json")
public class CustomerAPI
{
  @Reference
  private CustomerDataService customerDataService;

  @GET
  public Response getCustomers()
  {
    return Response.ok().entity(customerDataService.getCustomers()).build();
  }

  @GET
  @Path("/{id}")
  public Response getCustomer(@PathParam("id") BigInteger id)
  {
    return Response.ok().entity(customerDataService.getCustomer(id)).build();
  }

  @POST
  public Response createCustomer(Customer customer)
  {
    customerDataService.createCustomer(customer);
    return Response.status(Response.Status.CREATED).build();
  }

  @DELETE
  public Response removeCustomer(Customer customer)
  {
    customerDataService.removeCustomer(customer);
    return Response.ok().build();
  }
}

