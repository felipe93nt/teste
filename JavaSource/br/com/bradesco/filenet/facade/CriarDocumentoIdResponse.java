
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
 *         &lt;element name="criarDocumentoIdReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "criarDocumentoIdReturn"
})
@XmlRootElement(name = "criarDocumentoIdResponse")
public class CriarDocumentoIdResponse {

    @XmlElement(required = true, nillable = true)
    protected String criarDocumentoIdReturn;

    /**
     * Gets the value of the criarDocumentoIdReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriarDocumentoIdReturn() {
        return criarDocumentoIdReturn;
    }

    /**
     * Sets the value of the criarDocumentoIdReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriarDocumentoIdReturn(String value) {
        this.criarDocumentoIdReturn = value;
    }

}
