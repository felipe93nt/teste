/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSegmento.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSegmento.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCIERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCIERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCIE-HEADER", "RICCWCIE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCIE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCIE-HEADER", "RICCWCIE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCIE-REGISTRO", "RICCWCIE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWCIE-REGISTRO", "RICCWCIE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCIE-REGISTRO", "RICCWCIE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCIE-REGISTRO", "RICCWCIE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo ctpoAdmEmpr
     */
    @CommareaField(name = {"RICCWCIE-REGISTRO", "RICCWCIE-CTPO-ADM-EMPR"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 1, pic = "9(001)")
    protected int ctpoAdmEmpr = 0;

    /**
     * Atributo cplanoSucss
     */
    @CommareaField(name = {"RICCWCIE-REGISTRO", "RICCWCIE-CPLANO-SUCSS"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 1, pic = "9(001)")
    protected int cplanoSucss = 0;

    /**
     * Atributo rinadpCart
     */
    @CommareaField(name = {"RICCWCIE-REGISTRO", "RICCWCIE-RINADP-CART"}, maxLength = 100, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 100, pic = "X(100)")
    protected String rinadpCart = null;

    /**
     * Atributo filler136
     */
    protected String filler136 = null;

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
     * Prop�sito:  Retornar o valor de nversaoOrige
     *
     * @return nversaoOrige
     */
    public int getNversaoOrige() {
        return nversaoOrige;
    }

    /**
     * Prop�sito:  Atribuir valor ao nversaoOrige
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNversaoOrige(int value) {
        this.nversaoOrige = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cgrpEconm
     *
     * @return cgrpEconm
     */
    public int getCgrpEconm() {
        return cgrpEconm;
    }

    /**
     * Prop�sito:  Atribuir valor ao cgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCgrpEconm(int value) {
        this.cgrpEconm = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nrelatCredt
     *
     * @return nrelatCredt
     */
    public int getNrelatCredt() {
        return nrelatCredt;
    }

    /**
     * Prop�sito:  Atribuir valor ao nrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatCredt(int value) {
        this.nrelatCredt = value;
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
     * Prop�sito:  Retornar o valor de fILLER136
     *
     * @return fILLER136
     */
    public String getFILLER136() {
        return filler136;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER136
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER136(String value) {
        this.filler136 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCIERequest() {
        super();
    }
}
