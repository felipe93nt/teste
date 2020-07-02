/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEndividamenBanc.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEndividamenBanc.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBSERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBSERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBSE-HEADER", "RICCWBSE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBSE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBSE-HEADER", "RICCWBSE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 500;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo nendvtBrio
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWALS-NENDVT-BRIO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int nendvtBrio = 0;

    /**
     * Atributo irzScial
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-IRZ-SCIAL"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 70, pic = "X(070)")
    protected String irzScial = null;

    /**
     * Atributo rmodldBco
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-RMODLD-BCO"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 30, pic = "X(030)")
    protected String rmodldBco = null;

    /**
     * Atributo vsdoEndv
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-VSDO-ENDV"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoEndv = null;

    /**
     * Atributo dtVvcto
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-DT-VVCTO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 10, pic = "X(010)")
    protected String dtVvcto = null;

    /**
     * Atributo vvctoEndv
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-VVCTO-ENDV"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvctoEndv = null;

    /**
     * Atributo ramotzEndv
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-RAMOTZ-ENDV"}, maxLength = 20, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 20, pic = "X(020)")
    protected String ramotzEndv = null;

    /**
     * Atributo rgarntBco
     */
    @CommareaField(name = {"RICCWBSE-REGISTRO", "RICCWBSE-RGARNT-BCO"}, maxLength = 100, usage = "DISPLAY",
        fieldNumber = 14, maxBytes = 100, pic = "X(100)")
    protected String rgarntBco = null;

    /**
     * Atributo filler110
     */
    protected String filler110 = null;

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
     * Propósito:  Retornar o valor de nendvtBrio
     *
     * @return nendvtBrio
     */
    public int getNendvtBrio() {
        return nendvtBrio;
    }

    /**
     * Propósito:  Atribuir valor ao nendvtBrio
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNendvtBrio(int value) {
        this.nendvtBrio = value;
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
     * Propósito:  Retornar o valor de rmodldBco
     *
     * @return rmodldBco
     */
    public String getRmodldBco() {
        return rmodldBco;
    }

    /**
     * Propósito:  Atribuir valor ao rmodldBco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRmodldBco(String value) {
        this.rmodldBco = value;
    }

    /**
     * Propósito:  Retornar o valor de vsdoEndv
     *
     * @return vsdoEndv
     */
    public BigDecimal getVsdoEndv() {
        return vsdoEndv;
    }

    /**
     * Propósito:  Atribuir valor ao vsdoEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoEndv(BigDecimal value) {
        this.vsdoEndv = value;
    }

    /**
     * Propósito:  Retornar o valor de dtVvcto
     *
     * @return dtVvcto
     */
    public String getDtVvcto() {
        return dtVvcto;
    }

    /**
     * Propósito:  Atribuir valor ao dtVvcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtVvcto(String value) {
        this.dtVvcto = value;
    }

    /**
     * Propósito:  Retornar o valor de vvctoEndv
     *
     * @return vvctoEndv
     */
    public BigDecimal getVvctoEndv() {
        return vvctoEndv;
    }

    /**
     * Propósito:  Atribuir valor ao vvctoEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvctoEndv(BigDecimal value) {
        this.vvctoEndv = value;
    }

    /**
     * Propósito:  Retornar o valor de ramotzEndv
     *
     * @return ramotzEndv
     */
    public String getRamotzEndv() {
        return ramotzEndv;
    }

    /**
     * Propósito:  Atribuir valor ao ramotzEndv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRamotzEndv(String value) {
        this.ramotzEndv = value;
    }

    /**
     * Propósito:  Retornar o valor de rgarntBco
     *
     * @return rgarntBco
     */
    public String getRgarntBco() {
        return rgarntBco;
    }

    /**
     * Propósito:  Atribuir valor ao rgarntBco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRgarntBco(String value) {
        this.rgarntBco = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER110
     *
     * @return fILLER110
     */
    public String getFILLER110() {
        return filler110;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER110
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER110(String value) {
        this.filler110 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBSERequest() {
        super();
    }
}
