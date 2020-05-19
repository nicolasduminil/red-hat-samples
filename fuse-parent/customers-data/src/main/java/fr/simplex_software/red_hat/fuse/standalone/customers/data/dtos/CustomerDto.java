package fr.simplex_software.red_hat.fuse.standalone.customers.data.dtos;

import fr.simplex_software.red_hat.fuse.standalone.customers.data.entities.*;

import javax.xml.bind.annotation.*;
import java.io.*;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CustomerDto implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String country;
  private String phoneNumber;
  private String emailAddress;

  public CustomerDto()
  {
  }

  public CustomerDto(String firstName, String lastName, String street, String city, String state, String zip, String country,
                     String phoneNumber, String emailAddress)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  public CustomerDto(String firstName, String lastName, String street, String city, String state, String zip, String country)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
  }


  public CustomerDto(Customer customer)
  {
    this(customer.getContacts().get(0).getFirstName(), customer.getContacts().get(0).getLastName(), customer.getAddresses().get(0).getStreet(),
      customer.getAddresses().get(0).getCity(), customer.getAddresses().get(0).getState(), customer.getAddresses().get(0).getZip(),
      customer.getAddresses().get(0).getCountry(), customer.getContacts().get(0).getPhoneNumber(), customer.getContacts().get(0).getEmailAddress());
  }

  @XmlElement
  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  @XmlElement
  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  @XmlElement
  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  @XmlElement
  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  @XmlElement
  public String getState()
  {
    return state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  @XmlElement
  public String getZip()
  {
    return zip;
  }

  public void setZip(String zip)
  {
    this.zip = zip;
  }

  @XmlElement
  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }
}
