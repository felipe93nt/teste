/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasAndamento.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasAndamento.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB9ERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB9ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB9E-HEADER", "RICCWB9E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB9E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB9E-HEADER", "RICCWB9E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 600;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nobraRelat
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-NOBRA-RELAT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nobraRelat = 0;

    /**
     * Atributo dbaseRelat
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-DBASE-RELAT"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 10, pic = "X(010)")
    protected String dbaseRelat = null;

    /**
     * Atributo iincprImob
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-IINCPR-IMOB"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 30, pic = "X(030)")
    protected String iincprImob = null;

    /**
     * Atributo iemptoImob
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-IEMPTO-IMOB"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 50, pic = "X(050)")
    protected String iemptoImob = null;

    /**
     * Atributo rbairoEmpt
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-RBAIRO-EMPT"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 40, pic = "X(040)")
    protected String rbairoEmpt = null;

    /**
     * Atributo rciddeEmpt
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-RCIDDE-EMPT"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 40, pic = "X(040)")
    protected String rciddeEmpt = null;

    /**
     * Atributo cufEmpt
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-CUF-EMPT"}, maxLength = 2, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 2, pic = "X(002)")
    protected String cufEmpt = null;

    /**
     * Atributo pemptoImob
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-PEMPTO-IMOB"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pemptoImob = null;

    /**
     * Atributo dlctoEmpto
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-DLCTO-EMPTO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 14, maxBytes = 10, pic = "X(010)")
    protected String dlctoEmpto = null;

    /**
     * Atributo dprevtEntr
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-DPREVT-ENTR"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 15, maxBytes = 10, pic = "X(010)")
    protected String dprevtEntr = null;

    /**
     * Atributo pobraEmpto
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-POBRA-EMPTO"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 16, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pobraEmpto = null;

    /**
     * Atributo vcustoTot
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VCUSTO-TOT"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 17, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcustoTot = null;

    /**
     * Atributo vcustoInc
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VCUSTO-INC"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 18, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vcustoInc = null;

    /**
     * Atributo vtotGral
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VTOT-GRAL"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 19, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotGral = null;

    /**
     * Atributo vvdaPermu
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VVDA-PERMU"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 20, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvdaPermu = null;

    /**
     * Atributo qundMnor
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-QUND-MNOR"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 21, maxBytes = 9, pic = "9(009)")
    protected int qundMnor = 0;

    /**
     * Atributo qundPermu
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-QUND-PERMU"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 22, maxBytes = 9, pic = "9(009)")
    protected int qundPermu = 0;

    /**
     * Atributo qtotEstoq
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-QTOT-ESTOQ"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 23, maxBytes = 9, pic = "9(009)")
    protected int qtotEstoq = 0;

    /**
     * Atributo pvdaRealz
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-PVDA-REALZ"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 24, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pvdaRealz = null;

    /**
     * Atributo pdtroRealz
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-PDTRO-REALZ"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 25, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pdtroRealz = null;

    /**
     * Atributo vtotRecbd
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VTOT-RECBD"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 26, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotRecbd = null;

    /**
     * Atributo vpreChave
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VPRE-CHAVE"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 27, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vpreChave = null;

    /**
     * Atributo vposChave
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VPOS-CHAVE"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 28, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vposChave = null;

    /**
     * Atributo ragteFincr
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-RAGTE-FINCR"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 29, maxBytes = 30, pic = "X(030)")
    protected String ragteFincr = null;

    /**
     * Atributo vtotContr
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VTOT-CONTR"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 30, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotContr = null;

    /**
     * Atributo vsdoLibrd
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VSDO-LIBRD"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 31, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoLibrd = null;

    /**
     * Atributo vsdoDvdor
     */
    @CommareaField(name = {"RICCWB9E-REGISTRO", "RICCWB9E-VSDO-DVDOR"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 32, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoDvdor = null;

    /**
     * Atributo filler128
     */
    protected String filler128 = null;

    /**
     * Prop�sito:  Retornar o valor de codLayout
     *
     * @return codLayout
     */
    public String getCodLayout() {
        return codLayout;
    }

    /**
     * Prop�sito:  Atribuir valor ao codLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCodLayout(String value) {
        this.codLayout = value;
    }

    /**
     * Prop�sito:  Retornar o valor de tamLayout
     *
     * @return tamLayout
     */
    public int getTamLayout() {
        return tamLayout;
    }

    /**
     * Prop�sito:  Atribuir valor ao tamLayout
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTamLayout(int value) {
        this.tamLayout = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nversaoOrige
     *
     * @return nversaoOrige
     */
    public int getNversaoOrige() {
        return nversaoOrige;
    }

    /**
     * Prop�sito:  Atribuir valor ao nversaoOrige
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNversaoOrige(int value) {
        this.nversaoOrige = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cgrpEconm
     *
     * @return cgrpEconm
     */
    public int getCgrpEconm() {
        return cgrpEconm;
    }

    /**
     * Prop�sito:  Atribuir valor ao cgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCgrpEconm(int value) {
        this.cgrpEconm = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nrelatCredt
     *
     * @return nrelatCredt
     */
    public int getNrelatCredt() {
        return nrelatCredt;
    }

    /**
     * Prop�sito:  Atribuir valor ao nrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatCredt(int value) {
        this.nrelatCredt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de nobraRelat
     *
     * @return nobraRelat
     */
    public int getNobraRelat() {
        return nobraRelat;
    }

    /**
     * Prop�sito:  Atribuir valor ao nobraRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNobraRelat(int value) {
        this.nobraRelat = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dbaseRelat
     *
     * @return dbaseRelat
     */
    public String getDbaseRelat() {
        return dbaseRelat;
    }

    /**
     * Prop�sito:  Atribuir valor ao dbaseRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseRelat(String value) {
        this.dbaseRelat = value;
    }

    /**
     * Prop�sito:  Retornar o valor de iincprImob
     *
     * @return iincprImob
     */
    public String getIincprImob() {
        return iincprImob;
    }

    /**
     * Prop�sito:  Atribuir valor ao iincprImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIincprImob(String value) {
        this.iincprImob = value;
    }

    /**
     * Prop�sito:  Retornar o valor de iemptoImob
     *
     * @return iemptoImob
     */
    public String getIemptoImob() {
        return iemptoImob;
    }

    /**
     * Prop�sito:  Atribuir valor ao iemptoImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIemptoImob(String value) {
        this.iemptoImob = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rbairoEmpt
     *
     * @return rbairoEmpt
     */
    public String getRbairoEmpt() {
        return rbairoEmpt;
    }

    /**
     * Prop�sito:  Atribuir valor ao rbairoEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRbairoEmpt(String value) {
        this.rbairoEmpt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rciddeEmpt
     *
     * @return rciddeEmpt
     */
    public String getRciddeEmpt() {
        return rciddeEmpt;
    }

    /**
     * Prop�sito:  Atribuir valor ao rciddeEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRciddeEmpt(String value) {
        this.rciddeEmpt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cufEmpt
     *
     * @return cufEmpt
     */
    public String getCufEmpt() {
        return cufEmpt;
    }

    /**
     * Prop�sito:  Atribuir valor ao cufEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCufEmpt(String value) {
        this.cufEmpt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pemptoImob
     *
     * @return pemptoImob
     */
    public BigDecimal getPemptoImob() {
        return pemptoImob;
    }

    /**
     * Prop�sito:  Atribuir valor ao pemptoImob
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPemptoImob(BigDecimal value) {
        this.pemptoImob = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dlctoEmpto
     *
     * @return dlctoEmpto
     */
    public String getDlctoEmpto() {
        return dlctoEmpto;
    }

    /**
     * Prop�sito:  Atribuir valor ao dlctoEmpto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDlctoEmpto(String value) {
        this.dlctoEmpto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dprevtEntr
     *
     * @return dprevtEntr
     */
    public String getDprevtEntr() {
        return dprevtEntr;
    }

    /**
     * Prop�sito:  Atribuir valor ao dprevtEntr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDprevtEntr(String value) {
        this.dprevtEntr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pobraEmpto
     *
     * @return pobraEmpto
     */
    public BigDecimal getPobraEmpto() {
        return pobraEmpto;
    }

    /**
     * Prop�sito:  Atribuir valor ao pobraEmpto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPobraEmpto(BigDecimal value) {
        this.pobraEmpto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vcustoTot
     *
     * @return vcustoTot
     */
    public BigDecimal getVcustoTot() {
        return vcustoTot;
    }

    /**
     * Prop�sito:  Atribuir valor ao vcustoTot
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcustoTot(BigDecimal value) {
        this.vcustoTot = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vcustoInc
     *
     * @return vcustoInc
     */
    public BigDecimal getVcustoInc() {
        return vcustoInc;
    }

    /**
     * Prop�sito:  Atribuir valor ao vcustoInc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVcustoInc(BigDecimal value) {
        this.vcustoInc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotGral
     *
     * @return vtotGral
     */
    public BigDecimal getVtotGral() {
        return vtotGral;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotGral
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotGral(BigDecimal value) {
        this.vtotGral = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vvdaPermu
     *
     * @return vvdaPermu
     */
    public BigDecimal getVvdaPermu() {
        return vvdaPermu;
    }

    /**
     * Prop�sito:  Atribuir valor ao vvdaPermu
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvdaPermu(BigDecimal value) {
        this.vvdaPermu = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qundMnor
     *
     * @return qundMnor
     */
    public int getQundMnor() {
        return qundMnor;
    }

    /**
     * Prop�sito:  Atribuir valor ao qundMnor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQundMnor(int value) {
        this.qundMnor = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qundPermu
     *
     * @return qundPermu
     */
    public int getQundPermu() {
        return qundPermu;
    }

    /**
     * Prop�sito:  Atribuir valor ao qundPermu
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQundPermu(int value) {
        this.qundPermu = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtotEstoq
     *
     * @return qtotEstoq
     */
    public int getQtotEstoq() {
        return qtotEstoq;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtotEstoq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotEstoq(int value) {
        this.qtotEstoq = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pvdaRealz
     *
     * @return pvdaRealz
     */
    public BigDecimal getPvdaRealz() {
        return pvdaRealz;
    }

    /**
     * Prop�sito:  Atribuir valor ao pvdaRealz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPvdaRealz(BigDecimal value) {
        this.pvdaRealz = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pdtroRealz
     *
     * @return pdtroRealz
     */
    public BigDecimal getPdtroRealz() {
        return pdtroRealz;
    }

    /**
     * Prop�sito:  Atribuir valor ao pdtroRealz
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPdtroRealz(BigDecimal value) {
        this.pdtroRealz = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotRecbd
     *
     * @return vtotRecbd
     */
    public BigDecimal getVtotRecbd() {
        return vtotRecbd;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotRecbd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotRecbd(BigDecimal value) {
        this.vtotRecbd = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vpreChave
     *
     * @return vpreChave
     */
    public BigDecimal getVpreChave() {
        return vpreChave;
    }

    /**
     * Prop�sito:  Atribuir valor ao vpreChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVpreChave(BigDecimal value) {
        this.vpreChave = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vposChave
     *
     * @return vposChave
     */
    public BigDecimal getVposChave() {
        return vposChave;
    }

    /**
     * Prop�sito:  Atribuir valor ao vposChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVposChave(BigDecimal value) {
        this.vposChave = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ragteFincr
     *
     * @return ragteFincr
     */
    public String getRagteFincr() {
        return ragteFincr;
    }

    /**
     * Prop�sito:  Atribuir valor ao ragteFincr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRagteFincr(String value) {
        this.ragteFincr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotContr
     *
     * @return vtotContr
     */
    public BigDecimal getVtotContr() {
        return vtotContr;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotContr(BigDecimal value) {
        this.vtotContr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vsdoLibrd
     *
     * @return vsdoLibrd
     */
    public BigDecimal getVsdoLibrd() {
        return vsdoLibrd;
    }

    /**
     * Prop�sito:  Atribuir valor ao vsdoLibrd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoLibrd(BigDecimal value) {
        this.vsdoLibrd = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vsdoDvdor
     *
     * @return vsdoDvdor
     */
    public BigDecimal getVsdoDvdor() {
        return vsdoDvdor;
    }

    /**
     * Prop�sito:  Atribuir valor ao vsdoDvdor
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVsdoDvdor(BigDecimal value) {
        this.vsdoDvdor = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER128
     *
     * @return fILLER128
     */
    public String getFILLER128() {
        return filler128;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER128
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER128(String value) {
        this.filler128 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB9ERequest() {
        super();
    }
}
