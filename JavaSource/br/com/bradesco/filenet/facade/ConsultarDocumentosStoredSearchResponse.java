
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
 *         &lt;element name="consultarDocumentosStoredSearchReturn" type="{http://facade.filenet.bradesco.com.br}ArrayOfArrayOf_xsd_nillable_string"/>
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
    "consultarDocumentosStoredSearchReturn"
})
@XmlRootElement(name = "consultarDocumentosStoredSearchResponse")
public class ConsultarDocumentosStoredSearchResponse {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfArrayOfXsdNillableString consultarDocumentosStoredSearchReturn;

    /**
     * Gets the value of the consultarDocumentosStoredSearchReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfXsdNillableString }
     *     
     */
    public ArrayOfArrayOfXsdNillableString getConsultarDocumentosStoredSearchReturn() {
        return consultarDocumentosStoredSearchReturn;
    }

    /**
     * Sets the value of the consultarDocumentosStoredSearchReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfXsdNillableString }
     *     
     */
    public void setConsultarDocumentosStoredSearchReturn(ArrayOfArrayOfXsdNillableString value) {
        this.consultarDocumentosStoredSearchReturn = value;
    }

}
