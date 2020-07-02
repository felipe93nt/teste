/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroUso.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroUso.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB4ERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB4ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB4E-HEADER", "RICCWB4E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB4E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB4E-HEADER", "RICCWB4E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nquadrUso
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-NQUADR-USO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nquadrUso = 0;

    /**
     * Atributo ctpoQuadr
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-CTPO-QUADR"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 1, pic = "9(001)")
    protected int ctpoQuadr = 0;

    /**
     * Atributo rquadrProj
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-RQUADR-PROJ"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 50, pic = "X(050)")
    protected String rquadrProj = null;

    /**
     * Atributo dinicQuadr
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-DINIC-QUADR"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 10, pic = "X(010)")
    protected String dinicQuadr = null;

    /**
     * Atributo dfimQuadr
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-DFIM-QUADR"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 10, pic = "X(010)")
    protected String dfimQuadr = null;

    /**
     * Atributo pquadrProj
     */
    @CommareaField(name = {"RICCWB4E-REGISTRO", "RICCWB4E-PQUADR-PROJ"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pquadrProj = null;

    /**
     * Atributo filler122
     */
    protected String filler122 = null;

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
     * Propósito:  Retornar o valor de nquadrUso
     *
     * @return nquadrUso
     */
    public int getNquadrUso() {
        return nquadrUso;
    }

    /**
     * Propósito:  Atribuir valor ao nquadrUso
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNquadrUso(int value) {
        this.nquadrUso = value;
    }

    /**
     * Propósito:  Retornar o valor de ctpoQuadr
     *
     * @return ctpoQuadr
     */
    public int getCtpoQuadr() {
        return ctpoQuadr;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoQuadr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoQuadr(int value) {
        this.ctpoQuadr = value;
    }

    /**
     * Propósito:  Retornar o valor de rquadrProj
     *
     * @return rquadrProj
     */
    public String getRquadrProj() {
        return rquadrProj;
    }

    /**
     * Propósito:  Atribuir valor ao rquadrProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRquadrProj(String value) {
        this.rquadrProj = value;
    }

    /**
     * Propósito:  Retornar o valor de dinicQuadr
     *
     * @return dinicQuadr
     */
    public String getDinicQuadr() {
        return dinicQuadr;
    }

    /**
     * Propósito:  Atribuir valor ao dinicQuadr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDinicQuadr(String value) {
        this.dinicQuadr = value;
    }

    /**
     * Propósito:  Retornar o valor de dfimQuadr
     *
     * @return dfimQuadr
     */
    public String getDfimQuadr() {
        return dfimQuadr;
    }

    /**
     * Propósito:  Atribuir valor ao dfimQuadr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDfimQuadr(String value) {
        this.dfimQuadr = value;
    }

    /**
     * Propósito:  Retornar o valor de pquadrProj
     *
     * @return pquadrProj
     */
    public BigDecimal getPquadrProj() {
        return pquadrProj;
    }

    /**
     * Propósito:  Atribuir valor ao pquadrProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPquadrProj(BigDecimal value) {
        this.pquadrProj = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER122
     *
     * @return fILLER122
     */
    public String getFILLER122() {
        return filler122;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER122
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER122(String value) {
        this.filler122 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB4ERequest() {
        super();
    }
}
