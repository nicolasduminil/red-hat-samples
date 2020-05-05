//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.05 at 07:19:30 PM CEST 
//


package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Customers }
     * 
     */
    public Customers createCustomers() {
        return new Customers();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link Customers.CoorporateCustomerList }
     * 
     */
    public Customers.CoorporateCustomerList createCustomersCoorporateCustomerList() {
        return new Customers.CoorporateCustomerList();
    }

    /**
     * Create an instance of {@link Customers.IndividualCustomerList }
     * 
     */
    public Customers.IndividualCustomerList createCustomersIndividualCustomerList() {
        return new Customers.IndividualCustomerList();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link ContactType }
     * 
     */
    public ContactType createContactType() {
        return new ContactType();
    }

    /**
     * Create an instance of {@link CoorporateCustomerType }
     * 
     */
    public CoorporateCustomerType createCoorporateCustomerType() {
        return new CoorporateCustomerType();
    }

    /**
     * Create an instance of {@link IndividualCustomerType }
     * 
     */
    public IndividualCustomerType createIndividualCustomerType() {
        return new IndividualCustomerType();
    }

    /**
     * Create an instance of {@link CustomerType.AddressList }
     * 
     */
    public CustomerType.AddressList createCustomerTypeAddressList() {
        return new CustomerType.AddressList();
    }

    /**
     * Create an instance of {@link CustomerType.ContactList }
     * 
     */
    public CustomerType.ContactList createCustomerTypeContactList() {
        return new CustomerType.ContactList();
    }

}
