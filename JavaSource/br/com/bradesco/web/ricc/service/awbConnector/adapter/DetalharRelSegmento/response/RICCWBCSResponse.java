/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBCSResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBCSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBCS-HEADER", "RICCWBCS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBCS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBCS-HEADER", "RICCWBCS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 350;

    /**
     * Atributo rrelatInfoCred
     */
    @CommareaField(name = {"RICCWBCS-REGISTRO", "RICCWBCS-RRELAT-INFO-CRED"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 50, pic = "X(050)")
    protected String rrelatInfoCred = null;

    /**
     * Atributo ctpoAdmEmpr
     */
    @CommareaField(name = {"RICCWBCS-REGISTRO", "RICCWBCS-CTPO-ADM-EMPR"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoAdmEmpr = 0;

    /**
     * Atributo cplanoSucss
     */
    @CommareaField(name = {"RICCWBCS-REGISTRO", "RICCWBCS-CPLANO-SUCSS"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int cplanoSucss = 0;

    /**
     * Atributo rinadpCart
     */
    @CommareaField(name = {"RICCWBCS-REGISTRO", "RICCWBCS-RINADP-CART"}, maxLength = 100, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 100, pic = "X(100)")
    protected String rinadpCart = null;

    /**
     * Atributo filler89
     */
    protected String filler89 = null;

    /**
     * Prop�sito:  Retornar o valor de codLayout
     *
     * @return codLayout
     */
    public String getCodLayout() {
        return codLayout;
    }

    /**
     * Prop�sito:  Atribuir valor ao codLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCodLayout(String value) {
        this.codLayout = value;
    }

    /**
     * Prop�sito:  Retornar o valor de tamLayout
     *
     * @return tamLayout
     */
    public int getTamLayout() {
        return tamLayout;
    }

    /**
     * Prop�sito:  Atribuir valor ao tamLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTamLayout(int value) {
        this.tamLayout = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rrelatInfoCred
     *
     * @return rrelatInfoCred
     */
    public String getRrelatInfoCred() {
        return rrelatInfoCred;
    }

    /**
     * Prop�sito:  Atribuir valor ao rrelatInfoCred
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRrelatInfoCred(String value) {
        this.rrelatInfoCred = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoAdmEmpr
     *
     * @return ctpoAdmEmpr
     */
    public int getCtpoAdmEmpr() {
        return ctpoAdmEmpr;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoAdmEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoAdmEmpr(int value) {
        this.ctpoAdmEmpr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cplanoSucss
     *
     * @return cplanoSucss
     */
    public int getCplanoSucss() {
        return cplanoSucss;
    }

    /**
     * Prop�sito:  Atribuir valor ao cplanoSucss
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCplanoSucss(int value) {
        this.cplanoSucss = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rinadpCart
     *
     * @return rinadpCart
     */
    public String getRinadpCart() {
        return rinadpCart;
    }

    /**
     * Prop�sito:  Atribuir valor ao rinadpCart
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRinadpCart(String value) {
        this.rinadpCart = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER89
     *
     * @return fILLER89
     */
    public String getFILLER89() {
        return filler89;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER89
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER89(String value) {
        this.filler89 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBCSResponse() {
        super();
    }
}
