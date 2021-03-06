
package br.com.bradesco.filenet.facade;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="negocio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="searchTemplatePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="whereProperties" type="{http://facade.filenet.bradesco.com.br}ArrayOf_xsd_nillable_string"/>
 *         &lt;element name="propertiesReturn" type="{http://facade.filenet.bradesco.com.br}ArrayOf_xsd_nillable_string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "user",
    "password",
    "negocio",
    "searchTemplatePath",
    "whereProperties",
    "propertiesReturn"
})
@XmlRootElement(name = "consultarDocumentosSearchTemplate")
public class ConsultarDocumentosSearchTemplate {

    @XmlElement(required = true, nillable = true)
    protected String user;
    @XmlElement(required = true, nillable = true)
    protected String password;
    @XmlElement(required = true, nillable = true)
    protected String negocio;
    @XmlElement(required = true, nillable = true)
    protected String searchTemplatePath;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfXsdNillableString whereProperties;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfXsdNillableString propertiesReturn;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the negocio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNegocio() {
        return negocio;
    }

    /**
     * Sets the value of the negocio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNegocio(String value) {
        this.negocio = value;
    }

    /**
     * Gets the value of the searchTemplatePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchTemplatePath() {
        return searchTemplatePath;
    }

    /**
     * Sets the value of the searchTemplatePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchTemplatePath(String value) {
        this.searchTemplatePath = value;
    }

    /**
     * Gets the value of the whereProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfXsdNillableString }
     *     
     */
    public ArrayOfXsdNillableString getWhereProperties() {
        return whereProperties;
    }

    /**
     * Sets the value of the whereProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfXsdNillableString }
     *     
     */
    public void setWhereProperties(ArrayOfXsdNillableString value) {
        this.whereProperties = value;
    }

    /**
     * Gets the value of the propertiesReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfXsdNillableString }
     *     
     */
    public ArrayOfXsdNillableString getPropertiesReturn() {
        return propertiesReturn;
    }

    /**
     * Sets the value of the propertiesReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfXsdNillableString }
     *     
     */
    public void setPropertiesReturn(ArrayOfXsdNillableString value) {
        this.propertiesReturn = value;
    }

}
