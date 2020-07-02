/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 29/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA1SResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA1SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nobraConcl
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-NOBRA-CONCL"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nobraConcl = 0;

    /**
     * Atributo iincprImob
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-IINCPR-IMOB"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 30, pic = "X(030)")
    protected String iincprImob = null;

    /**
     * Atributo iemptoImob
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-IEMPTO-IMOB"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 50, pic = "X(050)")
    protected String iemptoImob = null;

    /**
     * Atributo rbairoEmpt
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-RBAIRO-EMPT"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 40, pic = "X(040)")
    protected String rbairoEmpt = null;

    /**
     * Atributo rciddeEmpt
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-RCIDDE-EMPT"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 40, pic = "X(040)")
    protected String rciddeEmpt = null;

    /**
     * Atributo cufEmpt
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-CUF-EMPT"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 2, pic = "X(002)")
    protected String cufEmpt = null;

    /**
     * Atributo dentrgEmpt
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-DENTRG-EMPT"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 10, pic = "X(010)")
    protected String dentrgEmpt = null;

    /**
     * Atributo vtotRecbd
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-VTOT-RECBD"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotRecbd = null;

    /**
     * Atributo vdoze
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-VDOZE"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vdoze = null;

    /**
     * Atributo vtrntaSeis
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-VTRNTA-SEIS"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtrntaSeis = null;

    /**
     * Atributo vposTrnta
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-VPOS-TRNTA"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vposTrnta = null;

    /**
     * Atributo qtotUnd
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-QTOT-UND"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 9, pic = "9(009)")
    protected int qtotUnd = 0;

    /**
     * Atributo vtotEstoq
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-VTOT-ESTOQ"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotEstoq = null;

    /**
     * Atributo pvdaRealz
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-PVDA-REALZ"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 13, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pvdaRealz = null;

    /**
     * Atributo ragteFincr
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-RAGTE-FINCR"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 14, maxBytes = 30, pic = "X(030)")
    protected String ragteFincr = null;

    /**
     * Atributo vsdoDvdor
     */
    @CommareaField(name = {"RICCWA1S-REGISTRO", "RICCWA1S-AREA-SAIDA", "RICCWA1S-VSDO-DVDOR"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 15, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoDvdor = null;

    /**
     * Propósito:  Retornar o valor de nobraConcl
     *
     * @return nobraConcl
     */
    public int getNobraConcl() {
        return nobraConcl;
    }

    /**
     * Propósito:  Atribuir valor ao nobraConcl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNobraConcl(int value) {
        this.nobraConcl = value;
    }

    /**
     * Propósito:  Retornar o valor de iincprImob
     *
     * @return iincprImob
     */
    public String getIincprImob() {
        return iincprImob;
    }

    /**
     * Propósito:  Atribuir valor ao iincprImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIincprImob(String value) {
        this.iincprImob = value;
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
     * Propósito:  Retornar o valor de rbairoEmpt
     *
     * @return rbairoEmpt
     */
    public String getRbairoEmpt() {
        return rbairoEmpt;
    }

    /**
     * Propósito:  Atribuir valor ao rbairoEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRbairoEmpt(String value) {
        this.rbairoEmpt = value;
    }

    /**
     * Propósito:  Retornar o valor de rciddeEmpt
     *
     * @return rciddeEmpt
     */
    public String getRciddeEmpt() {
        return rciddeEmpt;
    }

    /**
     * Propósito:  Atribuir valor ao rciddeEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRciddeEmpt(String value) {
        this.rciddeEmpt = value;
    }

    /**
     * Propósito:  Retornar o valor de cufEmpt
     *
     * @return cufEmpt
     */
    public String getCufEmpt() {
        return cufEmpt;
    }

    /**
     * Propósito:  Atribuir valor ao cufEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCufEmpt(String value) {
        this.cufEmpt = value;
    }

    /**
     * Propósito:  Retornar o valor de dentrgEmpt
     *
     * @return dentrgEmpt
     */
    public String getDentrgEmpt() {
        return dentrgEmpt;
    }

    /**
     * Propósito:  Atribuir valor ao dentrgEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDentrgEmpt(String value) {
        this.dentrgEmpt = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotRecbd
     *
     * @return vtotRecbd
     */
    public BigDecimal getVtotRecbd() {
        return vtotRecbd;
    }

    /**
     * Propósito:  Atribuir valor ao vtotRecbd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotRecbd(BigDecimal value) {
        this.vtotRecbd = value;
    }

    /**
     * Propósito:  Retornar o valor de vdoze
     *
     * @return vdoze
     */
    public BigDecimal getVdoze() {
        return vdoze;
    }

    /**
     * Propósito:  Atribuir valor ao vdoze
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdoze(BigDecimal value) {
        this.vdoze = value;
    }

    /**
     * Propósito:  Retornar o valor de vtrntaSeis
     *
     * @return vtrntaSeis
     */
    public BigDecimal getVtrntaSeis() {
        return vtrntaSeis;
    }

    /**
     * Propósito:  Atribuir valor ao vtrntaSeis
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtrntaSeis(BigDecimal value) {
        this.vtrntaSeis = value;
    }

    /**
     * Propósito:  Retornar o valor de vposTrnta
     *
     * @return vposTrnta
     */
    public BigDecimal getVposTrnta() {
        return vposTrnta;
    }

    /**
     * Propósito:  Atribuir valor ao vposTrnta
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVposTrnta(BigDecimal value) {
        this.vposTrnta = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotUnd
     *
     * @return qtotUnd
     */
    public int getQtotUnd() {
        return qtotUnd;
    }

    /**
     * Propósito:  Atribuir valor ao qtotUnd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotUnd(int value) {
        this.qtotUnd = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotEstoq
     *
     * @return vtotEstoq
     */
    public BigDecimal getVtotEstoq() {
        return vtotEstoq;
    }

    /**
     * Propósito:  Atribuir valor ao vtotEstoq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEstoq(BigDecimal value) {
        this.vtotEstoq = value;
    }

    /**
     * Propósito:  Retornar o valor de pvdaRealz
     *
     * @return pvdaRealz
     */
    public BigDecimal getPvdaRealz() {
        return pvdaRealz;
    }

    /**
     * Propósito:  Atribuir valor ao pvdaRealz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvdaRealz(BigDecimal value) {
        this.pvdaRealz = value;
    }

    /**
     * Propósito:  Retornar o valor de ragteFincr
     *
     * @return ragteFincr
     */
    public String getRagteFincr() {
        return ragteFincr;
    }

    /**
     * Propósito:  Atribuir valor ao ragteFincr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRagteFincr(String value) {
        this.ragteFincr = value;
    }

    /**
     * Propósito:  Retornar o valor de vsdoDvdor
     *
     * @return vsdoDvdor
     */
    public BigDecimal getVsdoDvdor() {
        return vsdoDvdor;
    }

    /**
     * Propósito:  Atribuir valor ao vsdoDvdor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoDvdor(BigDecimal value) {
        this.vsdoDvdor = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA1SResponseRegistroAreaSaida() {
        super();
    }
}
