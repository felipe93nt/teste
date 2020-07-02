/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEstruturaSocie.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEstruturaSocie.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB5ERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB5ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB5E-HEADER", "RICCWB5E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB5E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB5E-HEADER", "RICCWB5E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB5E-REGISTRO", "RICCWA0E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWB5E-REGISTRO", "RICCWB5E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB5E-REGISTRO", "RICCWB5E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB5E-REGISTRO", "RICCWB5E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nestrtSoctr
     */
    @CommareaField(name = {"RICCWB5E-REGISTRO", "RICCWB5E-NESTRT-SOCTR"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nestrtSoctr = 0;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWB5E-REGISTRO", "RICCWB5E-IRZ-SCIAL"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo pprtcAcnst
     */
    @CommareaField(name = {"RICCWB5E-REGISTRO", "RICCWB5E-PPRTC-ACNST"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pprtcAcnst = null;

    /**
     * Atributo filler123
     */
    protected String filler123 = null;

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
     * Propósito:  Retornar o valor de nestrtSoctr
     *
     * @return nestrtSoctr
     */
    public int getNestrtSoctr() {
        return nestrtSoctr;
    }

    /**
     * Propósito:  Atribuir valor ao nestrtSoctr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNestrtSoctr(int value) {
        this.nestrtSoctr = value;
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
     * Propósito:  Retornar o valor de pprtcAcnst
     *
     * @return pprtcAcnst
     */
    public BigDecimal getPprtcAcnst() {
        return pprtcAcnst;
    }

    /**
     * Propósito:  Atribuir valor ao pprtcAcnst
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPprtcAcnst(BigDecimal value) {
        this.pprtcAcnst = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER123
     *
     * @return fILLER123
     */
    public String getFILLER123() {
        return filler123;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER123
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER123(String value) {
        this.filler123 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB5ERequest() {
        super();
    }
}
