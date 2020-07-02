/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB7ERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB7ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB7E-HEADER", "RICCWB7E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB7E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB7E-HEADER", "RICCWB7E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWA0E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nprevtLcto
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-NPREVT-LCTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nprevtLcto = 0;

    /**
     * Atributo dbaseInfo
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-DBASE-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 10, pic = "X(010)")
    protected String dbaseInfo = null;

    /**
     * Atributo iemptoImob
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-IEMPTO-IMOB"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 50, pic = "X(050)")
    protected String iemptoImob = null;

    /**
     * Atributo rlocEmpto
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-RLOC-EMPTO"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 40, pic = "X(040)")
    protected String rlocEmpto = null;

    /**
     * Atributo vtotTerrn
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-VTOT-TERRN"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotTerrn = null;

    /**
     * Atributo vprevt
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-VPREVT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vprevt = null;

    /**
     * Atributo dprevtLcto
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-DPREVT-LCTO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 10, pic = "X(010)")
    protected String dprevtLcto = null;

    /**
     * Atributo csitLcto
     */
    @CommareaField(name = {"RICCWB7E-REGISTRO", "RICCWB7E-CSIT-LCTO"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 1, pic = "9(001)")
    protected int csitLcto = 0;

    /**
     * Atributo filler125
     */
    protected String filler125 = null;

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
     * Propósito:  Retornar o valor de nprevtLcto
     *
     * @return nprevtLcto
     */
    public int getNprevtLcto() {
        return nprevtLcto;
    }

    /**
     * Propósito:  Atribuir valor ao nprevtLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNprevtLcto(int value) {
        this.nprevtLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de dbaseInfo
     *
     * @return dbaseInfo
     */
    public String getDbaseInfo() {
        return dbaseInfo;
    }

    /**
     * Propósito:  Atribuir valor ao dbaseInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseInfo(String value) {
        this.dbaseInfo = value;
    }

    /**
     * Propósito:  Retornar o valor de iemptoImob
     *
     * @return iemptoImob
     */
    public String getIemptoImob() {
        return iemptoImob;
    }

    /**
     * Propósito:  Atribuir valor ao iemptoImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIemptoImob(String value) {
        this.iemptoImob = value;
    }

    /**
     * Propósito:  Retornar o valor de rlocEmpto
     *
     * @return rlocEmpto
     */
    public String getRlocEmpto() {
        return rlocEmpto;
    }

    /**
     * Propósito:  Atribuir valor ao rlocEmpto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRlocEmpto(String value) {
        this.rlocEmpto = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotTerrn
     *
     * @return vtotTerrn
     */
    public BigDecimal getVtotTerrn() {
        return vtotTerrn;
    }

    /**
     * Propósito:  Atribuir valor ao vtotTerrn
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotTerrn(BigDecimal value) {
        this.vtotTerrn = value;
    }

    /**
     * Propósito:  Retornar o valor de vprevt
     *
     * @return vprevt
     */
    public BigDecimal getVprevt() {
        return vprevt;
    }

    /**
     * Propósito:  Atribuir valor ao vprevt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVprevt(BigDecimal value) {
        this.vprevt = value;
    }

    /**
     * Propósito:  Retornar o valor de dprevtLcto
     *
     * @return dprevtLcto
     */
    public String getDprevtLcto() {
        return dprevtLcto;
    }

    /**
     * Propósito:  Atribuir valor ao dprevtLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDprevtLcto(String value) {
        this.dprevtLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de csitLcto
     *
     * @return csitLcto
     */
    public int getCsitLcto() {
        return csitLcto;
    }

    /**
     * Propósito:  Atribuir valor ao csitLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsitLcto(int value) {
        this.csitLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER125
     *
     * @return fILLER125
     */
    public String getFILLER125() {
        return filler125;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER125
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER125(String value) {
        this.filler125 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB7ERequest() {
        super();
    }
}
