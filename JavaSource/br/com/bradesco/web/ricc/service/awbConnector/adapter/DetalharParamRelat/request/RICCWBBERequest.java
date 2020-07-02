/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBBERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBBERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBBE-HEADER", "RICCWBBE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBBE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBBE-HEADER", "RICCWBBE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBBE-REGISTRO", "RICCWBBE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo nparmzRelat
     */
    @CommareaField(name = {"RICCWBBE-REGISTRO", "RICCWBBE-NPARMZ-RELAT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int nparmzRelat = 0;

    /**
     * Atributo filler1
     */
    protected String filler1 = null;

    /**
     * Propósito:  Retornar o valor de codLayout
     *
     * @return codLayout
     */
    public String getCodLayout() {
        return codLayout;
    }

    /**
     * Propósito:  Atribuir valor ao codLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCodLayout(String value) {
        this.codLayout = value;
    }

    /**
     * Propósito:  Retornar o valor de tamLayout
     *
     * @return tamLayout
     */
    public int getTamLayout() {
        return tamLayout;
    }

    /**
     * Propósito:  Atribuir valor ao tamLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTamLayout(int value) {
        this.tamLayout = value;
    }

    /**
     * Propósito:  Retornar o valor de nversaoOrige
     *
     * @return nversaoOrige
     */
    public int getNversaoOrige() {
        return nversaoOrige;
    }

    /**
     * Propósito:  Atribuir valor ao nversaoOrige
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNversaoOrige(int value) {
        this.nversaoOrige = value;
    }

    /**
     * Propósito:  Retornar o valor de nparmzRelat
     *
     * @return nparmzRelat
     */
    public int getNparmzRelat() {
        return nparmzRelat;
    }

    /**
     * Propósito:  Atribuir valor ao nparmzRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNparmzRelat(int value) {
        this.nparmzRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER1
     *
     * @return fILLER1
     */
    public String getFILLER1() {
        return filler1;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER1
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER1(String value) {
        this.filler1 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBBERequest() {
        super();
    }
}
