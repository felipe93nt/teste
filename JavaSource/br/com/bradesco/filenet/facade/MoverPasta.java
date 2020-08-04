
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
 *         &lt;element name="pasta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pathOrigem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pathDestino" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "pasta",
    "pathOrigem",
    "pathDestino"
})
@XmlRootElement(name = "moverPasta")
public class MoverPasta {

    @XmlElement(required = true, nillable = true)
    protected String user;
    @XmlElement(required = true, nillable = true)
    protected String password;
    @XmlElement(required = true, nillable = true)
    protected String negocio;
    @XmlElement(required = true, nillable = true)
    protected String pasta;
    @XmlElement(required = true, nillable = true)
    protected String pathOrigem;
    @XmlElement(required = true, nillable = true)
    protected String pathDestino;

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
     * Gets the value of the pasta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasta() {
        return pasta;
    }

    /**
     * Sets the value of the pasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasta(String value) {
        this.pasta = value;
    }

    /**
     * Gets the value of the pathOrigem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathOrigem() {
        return pathOrigem;
    }

    /**
     * Sets the value of the pathOrigem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathOrigem(String value) {
        this.pathOrigem = value;
    }

    /**
     * Gets the value of the pathDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathDestino() {
        return pathDestino;
    }

    /**
     * Sets the value of the pathDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathDestino(String value) {
        this.pathDestino = value;
    }

}
