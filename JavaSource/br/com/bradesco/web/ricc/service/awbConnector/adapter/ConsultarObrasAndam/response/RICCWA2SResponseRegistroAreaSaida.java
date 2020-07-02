/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 29/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA2SResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA2SResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo nobraRelat
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-NOBRA-RELAT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 9, pic = "9(009)")
    protected int nobraRelat = 0;

    /**
     * Atributo iincprImob
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-IINCPR-IMOB"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 30, pic = "X(030)")
    protected String iincprImob = null;

    /**
     * Atributo iemptoImob
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-IEMPTO-IMOB"}, maxLength = 50,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 50, pic = "X(050)")
    protected String iemptoImob = null;

    /**
     * Atributo rbairoEmpt
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-RBAIRO-EMPT"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 40, pic = "X(040)")
    protected String rbairoEmpt = null;

    /**
     * Atributo rciddeEmpt
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-RCIDDE-EMPT"}, maxLength = 40,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 40, pic = "X(040)")
    protected String rciddeEmpt = null;

    /**
     * Atributo cufEmpt
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-CUF-EMPT"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 2, pic = "X(002)")
    protected String cufEmpt = null;

    /**
     * Atributo pemptoImob
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-PEMPTO-IMOB"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pemptoImob = null;

    /**
     * Atributo dlctoEmpto
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-DLCTO-EMPTO"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 10, pic = "X(010)")
    protected String dlctoEmpto = null;

    /**
     * Atributo dprevtEntr
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-DPREVT-ENTR"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 10, pic = "X(010)")
    protected String dprevtEntr = null;

    /**
     * Atributo pobraEmpto
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-POBRA-EMPTO"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pobraEmpto = null;

    /**
     * Atributo vcustoTot
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VCUSTO-TOT"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcustoTot = null;

    /**
     * Atributo vcustoInc
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VCUSTO-INC"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcustoInc = null;

    /**
     * Atributo vtotGral
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VTOT-GRAL"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotGral = null;

    /**
     * Atributo vvdaPermu
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VVDA-PERMU"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 13, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvdaPermu = null;

    /**
     * Atributo qundMnor
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-QUND-MNOR"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 14, maxBytes = 9, pic = "9(009)")
    protected int qundMnor = 0;

    /**
     * Atributo qundPermu
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-QUND-PERMU"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 15, maxBytes = 9, pic = "9(009)")
    protected int qundPermu = 0;

    /**
     * Atributo qtotEstoq
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-QTOT-ESTOQ"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 16, maxBytes = 9, pic = "9(009)")
    protected int qtotEstoq = 0;

    /**
     * Atributo pvdaRealz
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-PVDA-REALZ"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 17, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pvdaRealz = null;

    /**
     * Atributo pdtroRealz
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-PDTRO-REALZ"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 18, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pdtroRealz = null;

    /**
     * Atributo vtotRecbd
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VTOT-RECBD"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 19, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotRecbd = null;

    /**
     * Atributo vpreChave
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VPRE-CHAVE"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 20, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vpreChave = null;

    /**
     * Atributo vposChave
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VPOS-CHAVE"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 21, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vposChave = null;

    /**
     * Atributo ragteFincr
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-RAGTE-FINCR"}, maxLength = 30,
        usage = "DISPLAY", fieldNumber = 22, maxBytes = 30, pic = "X(030)")
    protected String ragteFincr = null;

    /**
     * Atributo vtotContr
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VTOT-CONTR"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 23, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotContr = null;

    /**
     * Atributo vsdoLibrd
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VSDO-LIBRD"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 24, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoLibrd = null;

    /**
     * Atributo vsdoDvdor
     */
    @CommareaField(name = {"RICCWA2S-REGISTRO", "RICCWA2S-AREA-SAIDA", "RICCWA2S-VSDO-DVDOR"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 25, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoDvdor = null;

    /**
     * Propósito:  Retornar o valor de nobraRelat
     *
     * @return nobraRelat
     */
    public int getNobraRelat() {
        return nobraRelat;
    }

    /**
     * Propósito:  Atribuir valor ao nobraRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNobraRelat(int value) {
        this.nobraRelat = value;
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
     * Propósito:  Retornar o valor de pemptoImob
     *
     * @return pemptoImob
     */
    public BigDecimal getPemptoImob() {
        return pemptoImob;
    }

    /**
     * Propósito:  Atribuir valor ao pemptoImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPemptoImob(BigDecimal value) {
        this.pemptoImob = value;
    }

    /**
     * Propósito:  Retornar o valor de dlctoEmpto
     *
     * @return dlctoEmpto
     */
    public String getDlctoEmpto() {
        return dlctoEmpto;
    }

    /**
     * Propósito:  Atribuir valor ao dlctoEmpto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDlctoEmpto(String value) {
        this.dlctoEmpto = value;
    }

    /**
     * Propósito:  Retornar o valor de dprevtEntr
     *
     * @return dprevtEntr
     */
    public String getDprevtEntr() {
        return dprevtEntr;
    }

    /**
     * Propósito:  Atribuir valor ao dprevtEntr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDprevtEntr(String value) {
        this.dprevtEntr = value;
    }

    /**
     * Propósito:  Retornar o valor de pobraEmpto
     *
     * @return pobraEmpto
     */
    public BigDecimal getPobraEmpto() {
        return pobraEmpto;
    }

    /**
     * Propósito:  Atribuir valor ao pobraEmpto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPobraEmpto(BigDecimal value) {
        this.pobraEmpto = value;
    }

    /**
     * Propósito:  Retornar o valor de vcustoTot
     *
     * @return vcustoTot
     */
    public BigDecimal getVcustoTot() {
        return vcustoTot;
    }

    /**
     * Propósito:  Atribuir valor ao vcustoTot
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcustoTot(BigDecimal value) {
        this.vcustoTot = value;
    }

    /**
     * Propósito:  Retornar o valor de vcustoInc
     *
     * @return vcustoInc
     */
    public BigDecimal getVcustoInc() {
        return vcustoInc;
    }

    /**
     * Propósito:  Atribuir valor ao vcustoInc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcustoInc(BigDecimal value) {
        this.vcustoInc = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotGral
     *
     * @return vtotGral
     */
    public BigDecimal getVtotGral() {
        return vtotGral;
    }

    /**
     * Propósito:  Atribuir valor ao vtotGral
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotGral(BigDecimal value) {
        this.vtotGral = value;
    }

    /**
     * Propósito:  Retornar o valor de vvdaPermu
     *
     * @return vvdaPermu
     */
    public BigDecimal getVvdaPermu() {
        return vvdaPermu;
    }

    /**
     * Propósito:  Atribuir valor ao vvdaPermu
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvdaPermu(BigDecimal value) {
        this.vvdaPermu = value;
    }

    /**
     * Propósito:  Retornar o valor de qundMnor
     *
     * @return qundMnor
     */
    public int getQundMnor() {
        return qundMnor;
    }

    /**
     * Propósito:  Atribuir valor ao qundMnor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQundMnor(int value) {
        this.qundMnor = value;
    }

    /**
     * Propósito:  Retornar o valor de qundPermu
     *
     * @return qundPermu
     */
    public int getQundPermu() {
        return qundPermu;
    }

    /**
     * Propósito:  Atribuir valor ao qundPermu
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQundPermu(int value) {
        this.qundPermu = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotEstoq
     *
     * @return qtotEstoq
     */
    public int getQtotEstoq() {
        return qtotEstoq;
    }

    /**
     * Propósito:  Atribuir valor ao qtotEstoq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotEstoq(int value) {
        this.qtotEstoq = value;
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
     * Propósito:  Retornar o valor de pdtroRealz
     *
     * @return pdtroRealz
     */
    public BigDecimal getPdtroRealz() {
        return pdtroRealz;
    }

    /**
     * Propósito:  Atribuir valor ao pdtroRealz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPdtroRealz(BigDecimal value) {
        this.pdtroRealz = value;
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
     * Propósito:  Retornar o valor de vpreChave
     *
     * @return vpreChave
     */
    public BigDecimal getVpreChave() {
        return vpreChave;
    }

    /**
     * Propósito:  Atribuir valor ao vpreChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVpreChave(BigDecimal value) {
        this.vpreChave = value;
    }

    /**
     * Propósito:  Retornar o valor de vposChave
     *
     * @return vposChave
     */
    public BigDecimal getVposChave() {
        return vposChave;
    }

    /**
     * Propósito:  Atribuir valor ao vposChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVposChave(BigDecimal value) {
        this.vposChave = value;
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
     * Propósito:  Retornar o valor de vtotContr
     *
     * @return vtotContr
     */
    public BigDecimal getVtotContr() {
        return vtotContr;
    }

    /**
     * Propósito:  Atribuir valor ao vtotContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotContr(BigDecimal value) {
        this.vtotContr = value;
    }

    /**
     * Propósito:  Retornar o valor de vsdoLibrd
     *
     * @return vsdoLibrd
     */
    public BigDecimal getVsdoLibrd() {
        return vsdoLibrd;
    }

    /**
     * Propósito:  Atribuir valor ao vsdoLibrd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoLibrd(BigDecimal value) {
        this.vsdoLibrd = value;
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
    public RICCWA2SResponseRegistroAreaSaida() {
        super();
    }
}
