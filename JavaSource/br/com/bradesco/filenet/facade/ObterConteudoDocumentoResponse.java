
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
 *         &lt;element name="obterConteudoDocumentoReturn" type="{http://facade.filenet.bradesco.com.br}ArrayOf_xsd_base64Binary"/>
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
    "obterConteudoDocumentoReturn"
})
@XmlRootElement(name = "obterConteudoDocumentoResponse")
public class ObterConteudoDocumentoResponse {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfXsdBase64Binary obterConteudoDocumentoReturn;

    /**
     * Gets the value of the obterConteudoDocumentoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfXsdBase64Binary }
     *     
     */
    public ArrayOfXsdBase64Binary getObterConteudoDocumentoReturn() {
        return obterConteudoDocumentoReturn;
    }

    /**
     * Sets the value of the obterConteudoDocumentoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfXsdBase64Binary }
     *     
     */
    public void setObterConteudoDocumentoReturn(ArrayOfXsdBase64Binary value) {
        this.obterConteudoDocumentoReturn = value;
    }

}
