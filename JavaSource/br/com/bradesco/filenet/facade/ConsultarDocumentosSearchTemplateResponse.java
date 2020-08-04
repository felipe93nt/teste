
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
 *         &lt;element name="consultarDocumentosSearchTemplateReturn" type="{http://facade.filenet.bradesco.com.br}ArrayOfArrayOf_xsd_nillable_string"/>
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
    "consultarDocumentosSearchTemplateReturn"
})
@XmlRootElement(name = "consultarDocumentosSearchTemplateResponse")
public class ConsultarDocumentosSearchTemplateResponse {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfArrayOfXsdNillableString consultarDocumentosSearchTemplateReturn;

    /**
     * Gets the value of the consultarDocumentosSearchTemplateReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfXsdNillableString }
     *     
     */
    public ArrayOfArrayOfXsdNillableString getConsultarDocumentosSearchTemplateReturn() {
        return consultarDocumentosSearchTemplateReturn;
    }

    /**
     * Sets the value of the consultarDocumentosSearchTemplateReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfXsdNillableString }
     *     
     */
    public void setConsultarDocumentosSearchTemplateReturn(ArrayOfArrayOfXsdNillableString value) {
        this.consultarDocumentosSearchTemplateReturn = value;
    }

}
