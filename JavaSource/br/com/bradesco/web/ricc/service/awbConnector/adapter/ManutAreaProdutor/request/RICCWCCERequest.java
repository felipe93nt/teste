/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCCERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCCERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCCE-HEADER", "RICCWCCE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCCE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCCE-HEADER", "RICCWCCE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nareaProtr
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-NAREA-PROTR"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nareaProtr = 0;

    /**
     * Atributo ctpoArea
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-CTPO-AREA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 1, pic = "9(001)")
    protected int ctpoArea = 0;

    /**
     * Atributo iprotrAgri
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-IPROTR-AGRI"}, maxLength = 70, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 70, pic = "X(070)")
    protected String iprotrAgri = null;

    /**
     * Atributo rareaProtr
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-RAREA-PROTR"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 50, pic = "X(050)")
    protected String rareaProtr = null;

    /**
     * Atributo qareaHtare
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-QAREA-HTARE"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 9, pic = "9(009)")
    protected int qareaHtare = 0;

    /**
     * Atributo qareaPrdtv
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-QAREA-PRDTV"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 9, pic = "9(009)")
    protected int qareaPrdtv = 0;

    /**
     * Atributo rciddeArea
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-RCIDDE-AREA"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 40, pic = "X(040)")
    protected String rciddeArea = null;

    /**
     * Atributo vareaMercd
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-VAREA-MERCD"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vareaMercd = null;

    /**
     * Atributo vmercHtare
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-VMERC-HTARE"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 14, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmercHtare = null;

    /**
     * Atributo vcustoArre
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-VCUSTO-ARRE"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 15, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcustoArre = null;

    /**
     * Atributo dinicContr
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-DINIC-CONTR"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 16, maxBytes = 10, pic = "X(010)")
    protected String dinicContr = null;

    /**
     * Atributo dfimContr
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-DFIM-CONTR"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 17, maxBytes = 10, pic = "X(010)")
    protected String dfimContr = null;

    /**
     * Atributo cindcdArea
     */
    @CommareaField(name = {"RICCWCCE-REGISTRO", "RICCWCCE-CINDCD-AREA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 18, maxBytes = 1, pic = "9(001)")
    protected int cindcdArea = 0;

    /**
     * Atributo filler130
     */
    protected String filler130 = null;

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
     * Propósito:  Retornar o valor de nareaProtr
     *
     * @return nareaProtr
     */
    public int getNareaProtr() {
        return nareaProtr;
    }

    /**
     * Propósito:  Atribuir valor ao nareaProtr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNareaProtr(int value) {
        this.nareaProtr = value;
    }

    /**
     * Propósito:  Retornar o valor de ctpoArea
     *
     * @return ctpoArea
     */
    public int getCtpoArea() {
        return ctpoArea;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoArea
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoArea(int value) {
        this.ctpoArea = value;
    }

    /**
     * Propósito:  Retornar o valor de iprotrAgri
     *
     * @return iprotrAgri
     */
    public String getIprotrAgri() {
        return iprotrAgri;
    }

    /**
     * Propósito:  Atribuir valor ao iprotrAgri
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIprotrAgri(String value) {
        this.iprotrAgri = value;
    }

    /**
     * Propósito:  Retornar o valor de rareaProtr
     *
     * @return rareaProtr
     */
    public String getRareaProtr() {
        return rareaProtr;
    }

    /**
     * Propósito:  Atribuir valor ao rareaProtr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRareaProtr(String value) {
        this.rareaProtr = value;
    }

    /**
     * Propósito:  Retornar o valor de qareaHtare
     *
     * @return qareaHtare
     */
    public int getQareaHtare() {
        return qareaHtare;
    }

    /**
     * Propósito:  Atribuir valor ao qareaHtare
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQareaHtare(int value) {
        this.qareaHtare = value;
    }

    /**
     * Propósito:  Retornar o valor de qareaPrdtv
     *
     * @return qareaPrdtv
     */
    public int getQareaPrdtv() {
        return qareaPrdtv;
    }

    /**
     * Propósito:  Atribuir valor ao qareaPrdtv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQareaPrdtv(int value) {
        this.qareaPrdtv = value;
    }

    /**
     * Propósito:  Retornar o valor de rciddeArea
     *
     * @return rciddeArea
     */
    public String getRciddeArea() {
        return rciddeArea;
    }

    /**
     * Propósito:  Atribuir valor ao rciddeArea
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRciddeArea(String value) {
        this.rciddeArea = value;
    }

    /**
     * Propósito:  Retornar o valor de vareaMercd
     *
     * @return vareaMercd
     */
    public BigDecimal getVareaMercd() {
        return vareaMercd;
    }

    /**
     * Propósito:  Atribuir valor ao vareaMercd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVareaMercd(BigDecimal value) {
        this.vareaMercd = value;
    }

    /**
     * Propósito:  Retornar o valor de vmercHtare
     *
     * @return vmercHtare
     */
    public BigDecimal getVmercHtare() {
        return vmercHtare;
    }

    /**
     * Propósito:  Atribuir valor ao vmercHtare
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVmercHtare(BigDecimal value) {
        this.vmercHtare = value;
    }

    /**
     * Propósito:  Retornar o valor de vcustoArre
     *
     * @return vcustoArre
     */
    public BigDecimal getVcustoArre() {
        return vcustoArre;
    }

    /**
     * Propósito:  Atribuir valor ao vcustoArre
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcustoArre(BigDecimal value) {
        this.vcustoArre = value;
    }

    /**
     * Propósito:  Retornar o valor de dinicContr
     *
     * @return dinicContr
     */
    public String getDinicContr() {
        return dinicContr;
    }

    /**
     * Propósito:  Atribuir valor ao dinicContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDinicContr(String value) {
        this.dinicContr = value;
    }

    /**
     * Propósito:  Retornar o valor de dfimContr
     *
     * @return dfimContr
     */
    public String getDfimContr() {
        return dfimContr;
    }

    /**
     * Propósito:  Atribuir valor ao dfimContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDfimContr(String value) {
        this.dfimContr = value;
    }

    /**
     * Propósito:  Retornar o valor de cindcdArea
     *
     * @return cindcdArea
     */
    public int getCindcdArea() {
        return cindcdArea;
    }

    /**
     * Propósito:  Atribuir valor ao cindcdArea
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCindcdArea(int value) {
        this.cindcdArea = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER130
     *
     * @return fILLER130
     */
    public String getFILLER130() {
        return filler130;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER130
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER130(String value) {
        this.filler130 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCCERequest() {
        super();
    }
}
