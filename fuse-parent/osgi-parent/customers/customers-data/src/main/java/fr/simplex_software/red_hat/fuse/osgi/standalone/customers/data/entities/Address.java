package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.entities;

import fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb.*;

import javax.persistence.*;
import java.math.*;

@Embeddable
public class Address
{
  private BigInteger pk;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String country;
  private Boolean shippingAddress;

  public Address()
  {
  }

  public Address(String street, String city, String state, String zip, String country, Boolean shippingAddress)
  {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
    this.shippingAddress = shippingAddress;
  }

  public Address (AddressType addressType)
  {
    this.city = addressType.getCity();
    this.country = addressType.getCountry();
    this.shippingAddress = addressType.isShippingAddress();
    this.state = addressType.getState();
    this.zip = addressType.getZip();
  }

  @Column(name = "ADDRESS_STREET", nullable = false, length = 80)
  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  @Column(name = "ADDRESS_CITY", nullable = false, length = 80)
  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  @Column(name = "ADDRESS_STATE", nullable = false, length = 40)
  public String getState()
  {
    return state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  @Column(name = "ADDRESS_ZIP", nullable = false, length = 8)
  public String getZip()
  {
    return zip;
  }

  public void setZip(String zip)
  {
    this.zip = zip;
  }

  @Column(name = "ADDRESS_COUNTRY", nullable = false, length = 40)
  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }
}
