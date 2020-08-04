
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
 *         &lt;element name="pesquisarDocumentosPorQueryReturn" type="{http://facade.filenet.bradesco.com.br}ArrayOfArrayOf_xsd_nillable_string"/>
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
    "pesquisarDocumentosPorQueryReturn"
})
@XmlRootElement(name = "pesquisarDocumentosPorQueryResponse")
public class PesquisarDocumentosPorQueryResponse {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfArrayOfXsdNillableString pesquisarDocumentosPorQueryReturn;

    /**
     * Gets the value of the pesquisarDocumentosPorQueryReturn property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfXsdNillableString }
     *     
     */
    public ArrayOfArrayOfXsdNillableString getPesquisarDocumentosPorQueryReturn() {
        return pesquisarDocumentosPorQueryReturn;
    }

    /**
     * Sets the value of the pesquisarDocumentosPorQueryReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfXsdNillableString }
     *     
     */
    public void setPesquisarDocumentosPorQueryReturn(ArrayOfArrayOfXsdNillableString value) {
        this.pesquisarDocumentosPorQueryReturn = value;
    }

}
