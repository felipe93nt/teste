/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA5SResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA5SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nareaProtr
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-NAREA-PROTR"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nareaProtr = 0;

    /**
     * Atributo ctpoArea
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-CTPO-AREA"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 1, pic = "9(001)")
    protected int ctpoArea = 0;

    /**
     * Atributo rareaProtr
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-RAREA-PROTR"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 50, pic = "X(050)")
    protected String rareaProtr = null;

    /**
     * Atributo qareaHtare
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-QAREA-HTARE"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int qareaHtare = 0;

    /**
     * Atributo qareaPrdtv
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-QAREA-PRDTV"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int qareaPrdtv = 0;

    /**
     * Atributo rciddeArea
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-RCIDDE-AREA"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 40, pic = "X(040)")
    protected String rciddeArea = null;

    /**
     * Atributo vareaMercd
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-VAREA-MERCD"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vareaMercd = null;

    /**
     * Atributo vmercHtare
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-VMERC-HTARE"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vmercHtare = null;

    /**
     * Atributo vcustoArre
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-VCUSTO-ARRE"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcustoArre = null;

    /**
     * Atributo dinicContr
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-DINIC-CONTR"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 10, pic = "X(010)")
    protected String dinicContr = null;

    /**
     * Atributo dfimContr
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-DFIM-CONTR"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 10, pic = "X(010)")
    protected String dfimContr = null;

    /**
     * Atributo cindcdArea
     */
    @CommareaField(name = {"RICCWA5S-REGISTRO", "RICCWA5S-AREA-SAIDA", "RICCWA5S-CINDCD-AREA"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "9(001)")
    protected int cindcdArea = 0;

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
     * Construtor Padrao
     * @see
     */
    public RICCWA5SResponseRegistroAreaSaida() {
        super();
    }
}
