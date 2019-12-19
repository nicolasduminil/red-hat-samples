//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.19 at 12:03:15 PM CET 
//


package fr.simplex_software.red_hat.fuse.osgi.standalone.customers.data.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="coorporateCustomerList"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="coorporateCustomer" type="{}CoorporateCustomerType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="individualCustomerList"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="individualCustomer" type="{}IndividualCustomerType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "coorporateCustomerList",
    "individualCustomerList"
})
@XmlRootElement(name = "customers")
public class Customers {

    @XmlElement(required = true)
    protected Customers.CoorporateCustomerList coorporateCustomerList;
    @XmlElement(required = true)
    protected Customers.IndividualCustomerList individualCustomerList;

    /**
     * Gets the value of the coorporateCustomerList property.
     * 
     * @return
     *     possible object is
     *     {@link Customers.CoorporateCustomerList }
     *     
     */
    public Customers.CoorporateCustomerList getCoorporateCustomerList() {
        return coorporateCustomerList;
    }

    /**
     * Sets the value of the coorporateCustomerList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customers.CoorporateCustomerList }
     *     
     */
    public void setCoorporateCustomerList(Customers.CoorporateCustomerList value) {
        this.coorporateCustomerList = value;
    }

    /**
     * Gets the value of the individualCustomerList property.
     * 
     * @return
     *     possible object is
     *     {@link Customers.IndividualCustomerList }
     *     
     */
    public Customers.IndividualCustomerList getIndividualCustomerList() {
        return individualCustomerList;
    }

    /**
     * Sets the value of the individualCustomerList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customers.IndividualCustomerList }
     *     
     */
    public void setIndividualCustomerList(Customers.IndividualCustomerList value) {
        this.individualCustomerList = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="coorporateCustomer" type="{}CoorporateCustomerType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "coorporateCustomers"
    })
    public static class CoorporateCustomerList {

        @XmlElement(name = "coorporateCustomer", required = true)
        protected List<CoorporateCustomerType> coorporateCustomers;

        /**
         * Gets the value of the coorporateCustomers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the coorporateCustomers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCoorporateCustomers().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CoorporateCustomerType }
         * 
         * 
         */
        public List<CoorporateCustomerType> getCoorporateCustomers() {
            if (coorporateCustomers == null) {
                coorporateCustomers = new ArrayList<CoorporateCustomerType>();
            }
            return this.coorporateCustomers;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="individualCustomer" type="{}IndividualCustomerType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "individualCustomers"
    })
    public static class IndividualCustomerList {

        @XmlElement(name = "individualCustomer", required = true)
        protected List<IndividualCustomerType> individualCustomers;

        /**
         * Gets the value of the individualCustomers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the individualCustomers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndividualCustomers().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IndividualCustomerType }
         * 
         * 
         */
        public List<IndividualCustomerType> getIndividualCustomers() {
            if (individualCustomers == null) {
                individualCustomers = new ArrayList<IndividualCustomerType>();
            }
            return this.individualCustomers;
        }

    }

}
