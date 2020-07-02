/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB8ERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB8ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB8E-HEADER", "RICCWB8E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB8E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB8E-HEADER", "RICCWB8E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 500;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nobraConcl
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-NOBRA-CONCL"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nobraConcl = 0;

    /**
     * Atributo dbaseInfo
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-DBASE-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 10, pic = "X(010)")
    protected String dbaseInfo = null;

    /**
     * Atributo iincprImob
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-IINCPR-IMOB"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 30, pic = "X(030)")
    protected String iincprImob = null;

    /**
     * Atributo iemptoImob
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-IEMPTO-IMOB"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 50, pic = "X(050)")
    protected String iemptoImob = null;

    /**
     * Atributo rbairoEmpt
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-RBAIRO-EMPT"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 40, pic = "X(040)")
    protected String rbairoEmpt = null;

    /**
     * Atributo rciddeEmpt
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-RCIDDE-EMPT"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 40, pic = "X(040)")
    protected String rciddeEmpt = null;

    /**
     * Atributo cufEmpt
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-CUF-EMPT"}, maxLength = 2, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 2, pic = "X(002)")
    protected String cufEmpt = null;

    /**
     * Atributo dentrgEmpt
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-DENTRG-EMPT"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 10, pic = "X(010)")
    protected String dentrgEmpt = null;

    /**
     * Atributo vtotRecbd
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-VTOT-RECBD"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 14, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotRecbd = null;

    /**
     * Atributo vdoze
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-VDOZE"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 15, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vdoze = null;

    /**
     * Atributo vtrntaSeis
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-VTRNTA-SEIS"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 16, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtrntaSeis = null;

    /**
     * Atributo vposTrnta
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-VPOS-TRNTA"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 17, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vposTrnta = null;

    /**
     * Atributo qtotUnd
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-QTOT-UND"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 18, maxBytes = 9, pic = "9(009)")
    protected int qtotUnd = 0;

    /**
     * Atributo vtotEstoq
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-VTOT-ESTOQ"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 19, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotEstoq = null;

    /**
     * Atributo pvdaRealz
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-PVDA-REALZ"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 20, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pvdaRealz = null;

    /**
     * Atributo ragteFincr
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-RAGTE-FINCR"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 21, maxBytes = 30, pic = "X(030)")
    protected String ragteFincr = null;

    /**
     * Atributo vsdoDvdor
     */
    @CommareaField(name = {"RICCWB8E-REGISTRO", "RICCWB8E-VSDO-DVDOR"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 22, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vsdoDvdor = null;

    /**
     * Atributo filler126
     */
    protected String filler126 = null;

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
     * Prop�sito:  Retornar o valor de nobraConcl
     *
     * @return nobraConcl
     */
    public int getNobraConcl() {
        return nobraConcl;
    }

    /**
     * Prop�sito:  Atribuir valor ao nobraConcl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNobraConcl(int value) {
        this.nobraConcl = value;
    }

    /**
     * Prop�sito:  Retornar o valor de dbaseInfo
     *
     * @return dbaseInfo
     */
    public String getDbaseInfo() {
        return dbaseInfo;
    }

    /**
     * Prop�sito:  Atribuir valor ao dbaseInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDbaseInfo(String value) {
        this.dbaseInfo = value;
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
     * Prop�sito:  Retornar o valor de dentrgEmpt
     *
     * @return dentrgEmpt
     */
    public String getDentrgEmpt() {
        return dentrgEmpt;
    }

    /**
     * Prop�sito:  Atribuir valor ao dentrgEmpt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDentrgEmpt(String value) {
        this.dentrgEmpt = value;
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
     * Prop�sito:  Retornar o valor de vdoze
     *
     * @return vdoze
     */
    public BigDecimal getVdoze() {
        return vdoze;
    }

    /**
     * Prop�sito:  Atribuir valor ao vdoze
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdoze(BigDecimal value) {
        this.vdoze = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtrntaSeis
     *
     * @return vtrntaSeis
     */
    public BigDecimal getVtrntaSeis() {
        return vtrntaSeis;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtrntaSeis
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtrntaSeis(BigDecimal value) {
        this.vtrntaSeis = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vposTrnta
     *
     * @return vposTrnta
     */
    public BigDecimal getVposTrnta() {
        return vposTrnta;
    }

    /**
     * Prop�sito:  Atribuir valor ao vposTrnta
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVposTrnta(BigDecimal value) {
        this.vposTrnta = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtotUnd
     *
     * @return qtotUnd
     */
    public int getQtotUnd() {
        return qtotUnd;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtotUnd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotUnd(int value) {
        this.qtotUnd = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotEstoq
     *
     * @return vtotEstoq
     */
    public BigDecimal getVtotEstoq() {
        return vtotEstoq;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotEstoq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotEstoq(BigDecimal value) {
        this.vtotEstoq = value;
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
     * Prop�sito:  Retornar o valor de fILLER126
     *
     * @return fILLER126
     */
    public String getFILLER126() {
        return filler126;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER126
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER126(String value) {
        this.filler126 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB8ERequest() {
        super();
    }
}
