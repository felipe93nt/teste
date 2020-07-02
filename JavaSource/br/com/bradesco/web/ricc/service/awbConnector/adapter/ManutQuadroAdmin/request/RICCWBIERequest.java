/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAdmin.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAdmin.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBIERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBIERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBIE-HEADER", "RICCWBIE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBIE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBIE-HEADER", "RICCWBIE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo nseqQuadr
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-NSEQ-QUADR"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int nseqQuadr = 0;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-IRZ-SCIAL"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo rcargo
     */
    @CommareaField(name = {"RICCWBIE-REGISTRO", "RICCWBIE-RCARGO"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 30, pic = "X(030)")
    protected String rcargo = null;

    /**
     * Atributo filler100
     */
    protected String filler100 = null;

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
     * Propósito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
    }

    /**
     * Propósito:  Retornar o valor de cgrpEconm
     *
     * @return cgrpEconm
     */
    public int getCgrpEconm() {
        return cgrpEconm;
    }

    /**
     * Propósito:  Atribuir valor ao cgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCgrpEconm(int value) {
        this.cgrpEconm = value;
    }

    /**
     * Propósito:  Retornar o valor de nrelatCredt
     *
     * @return nrelatCredt
     */
    public int getNrelatCredt() {
        return nrelatCredt;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatCredt(int value) {
        this.nrelatCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de nrelatSgmto
     *
     * @return nrelatSgmto
     */
    public int getNrelatSgmto() {
        return nrelatSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatSgmto(int value) {
        this.nrelatSgmto = value;
    }

    /**
     * Propósito:  Retornar o valor de nseqQuadr
     *
     * @return nseqQuadr
     */
    public int getNseqQuadr() {
        return nseqQuadr;
    }

    /**
     * Propósito:  Atribuir valor ao nseqQuadr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNseqQuadr(int value) {
        this.nseqQuadr = value;
    }

    /**
     * Propósito:  Retornar o valor de irzScial
     *
     * @return irzScial
     */
    public String getIrzScial() {
        return irzScial;
    }

    /**
     * Propósito:  Atribuir valor ao irzScial
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIrzScial(String value) {
        this.irzScial = value;
    }

    /**
     * Propósito:  Retornar o valor de rcargo
     *
     * @return rcargo
     */
    public String getRcargo() {
        return rcargo;
    }

    /**
     * Propósito:  Atribuir valor ao rcargo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRcargo(String value) {
        this.rcargo = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER100
     *
     * @return fILLER100
     */
    public String getFILLER100() {
        return filler100;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER100
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER100(String value) {
        this.filler100 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBIERequest() {
        super();
    }
}
