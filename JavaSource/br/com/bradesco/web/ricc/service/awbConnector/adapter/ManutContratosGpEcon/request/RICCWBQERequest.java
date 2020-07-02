/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBQERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBQERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBQE-HEADER", "RICCWBQE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBQE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBQE-HEADER", "RICCWBQE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo ndetlhContr
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-NDETLH-CONTR"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int ndetlhContr = 0;

    /**
     * Atributo rproj
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-RPROJ"}, maxLength = 100, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 100, pic = "X(100)")
    protected String rproj = null;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-IRZ-SCIAL"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo vcontr
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-VCONTR"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcontr = null;

    /**
     * Atributo vsaldo
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-VSALDO"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsaldo = null;

    /**
     * Atributo dtFim
     */
    @CommareaField(name = {"RICCWBQE-REGISTRO", "RICCWBQE-DT-FIM"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 10, pic = "X(010)")
    protected String dtFim = null;

    /**
     * Atributo filler108
     */
    protected String filler108 = null;

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
     * Propósito:  Retornar o valor de ndetlhContr
     *
     * @return ndetlhContr
     */
    public int getNdetlhContr() {
        return ndetlhContr;
    }

    /**
     * Propósito:  Atribuir valor ao ndetlhContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNdetlhContr(int value) {
        this.ndetlhContr = value;
    }

    /**
     * Propósito:  Retornar o valor de rproj
     *
     * @return rproj
     */
    public String getRproj() {
        return rproj;
    }

    /**
     * Propósito:  Atribuir valor ao rproj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRproj(String value) {
        this.rproj = value;
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
     * Propósito:  Retornar o valor de vcontr
     *
     * @return vcontr
     */
    public BigDecimal getVcontr() {
        return vcontr;
    }

    /**
     * Propósito:  Atribuir valor ao vcontr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcontr(BigDecimal value) {
        this.vcontr = value;
    }

    /**
     * Propósito:  Retornar o valor de vsaldo
     *
     * @return vsaldo
     */
    public BigDecimal getVsaldo() {
        return vsaldo;
    }

    /**
     * Propósito:  Atribuir valor ao vsaldo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsaldo(BigDecimal value) {
        this.vsaldo = value;
    }

    /**
     * Propósito:  Retornar o valor de dtFim
     *
     * @return dtFim
     */
    public String getDtFim() {
        return dtFim;
    }

    /**
     * Propósito:  Atribuir valor ao dtFim
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtFim(String value) {
        this.dtFim = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER108
     *
     * @return fILLER108
     */
    public String getFILLER108() {
        return filler108;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER108
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER108(String value) {
        this.filler108 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBQERequest() {
        super();
    }
}
