package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.rest;

import fr.simplex_software.red_hat.fuse.standalone.customers.data.dtos.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.entities.*;
import fr.simplex_software.red_hat.fuse.standalone.customers.data.services.*;
import org.apache.karaf.shell.api.action.lifecycle.*;


import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

@Path("/customers")
@Produces("application/xml")
@Consumes("application/xml")
public class CustomerAPI
{
  @Reference
  private CustomerDataService customerDataService;

  @GET
  public Response getCustomers()
  {
    return Response.ok().entity(Objects.requireNonNull(customerDataService, "CustomerDataService is null").getCustomers().stream().map(CustomerDto:: new).collect(Collectors.toList())).build();
  }

  @GET
  @Path("/{id}")
  public Response getCustomer(@PathParam("id") BigInteger id)
  {
    return Response.ok().entity(new CustomerDto(Objects.requireNonNull(customerDataService, "CustomerDataService is null").getCustomer(id))).build();
  }

  @POST
  public Response createCustomer(CustomerDto customer)
  {
    Objects.requireNonNull(customerDataService, "CustomerDataService is null").createCustomer(new Customer(customer));
    return Response.status(Response.Status.CREATED).build();
  }

  @DELETE
  public Response removeCustomer(CustomerDto customer)
  {
    Objects.requireNonNull(customerDataService, "CustomerDataService is null").removeCustomer(new Customer(customer));
    return Response.ok().build();
  }
}

