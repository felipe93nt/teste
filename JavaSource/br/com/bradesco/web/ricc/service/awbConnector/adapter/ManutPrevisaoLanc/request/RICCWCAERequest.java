/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPrevisaoLanc.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPrevisaoLanc.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCAERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCAERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCAE-HEADER", "RICCWCAE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCAE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCAE-HEADER", "RICCWCAE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cpssoaJuridContr
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CPSSOA-JURID-CONTR"}, maxLength = 10, usage = "DISPL"
        + "AY", fieldNumber = 3, maxBytes = 10, pic = "9(010)")
    protected long cpssoaJuridContr = 0L;

    /**
     * Atributo ctpoContrNegoc
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CTPO-CONTR-NEGOC"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 3, pic = "9(003)")
    protected int ctpoContrNegoc = 0;

    /**
     * Atributo nseqContrNegoc
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-NSEQ-CONTR-NEGOC"}, maxLength = 10,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 10, pic = "9(010)")
    protected long nseqContrNegoc = 0L;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatInfoCredt
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-NRELAT-INFO-CREDT"}, maxLength = 9,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int nrelatInfoCredt = 0;

    /**
     * Atributo csgmtoRelat
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CSGMTO-RELAT"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 3, pic = "9(003)")
    protected int csgmtoRelat = 0;

    /**
     * Atributo cidtfdTrnsp
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CIDTFD-TRNSP"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 1, pic = "9(001)")
    protected int cidtfdTrnsp = 0;

    /**
     * Atributo cidtfdImobl
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CIDTFD-IMOBL"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 1, pic = "9(001)")
    protected int cidtfdImobl = 0;

    /**
     * Atributo cidtfdAgric
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CIDTFD-AGRIC"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 1, pic = "9(001)")
    protected int cidtfdAgric = 0;

    /**
     * Atributo cidtfdProj
     */
    @CommareaField(name = {"RICCWCAE-REGISTRO", "RICCWCAE-CIDTFD-PROJ"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 1, pic = "9(001)")
    protected int cidtfdProj = 0;

    /**
     * Atributo filler127
     */
    protected String filler127 = null;

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
     * Propósito:  Retornar o valor de cpssoaJuridContr
     *
     * @return cpssoaJuridContr
     */
    public long getCpssoaJuridContr() {
        return cpssoaJuridContr;
    }

    /**
     * Propósito:  Atribuir valor ao cpssoaJuridContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCpssoaJuridContr(long value) {
        this.cpssoaJuridContr = value;
    }

    /**
     * Propósito:  Retornar o valor de ctpoContrNegoc
     *
     * @return ctpoContrNegoc
     */
    public int getCtpoContrNegoc() {
        return ctpoContrNegoc;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoContrNegoc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoContrNegoc(int value) {
        this.ctpoContrNegoc = value;
    }

    /**
     * Propósito:  Retornar o valor de nseqContrNegoc
     *
     * @return nseqContrNegoc
     */
    public long getNseqContrNegoc() {
        return nseqContrNegoc;
    }

    /**
     * Propósito:  Atribuir valor ao nseqContrNegoc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNseqContrNegoc(long value) {
        this.nseqContrNegoc = value;
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
     * Propósito:  Retornar o valor de nrelatInfoCredt
     *
     * @return nrelatInfoCredt
     */
    public int getNrelatInfoCredt() {
        return nrelatInfoCredt;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatInfoCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatInfoCredt(int value) {
        this.nrelatInfoCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de csgmtoRelat
     *
     * @return csgmtoRelat
     */
    public int getCsgmtoRelat() {
        return csgmtoRelat;
    }

    /**
     * Propósito:  Atribuir valor ao csgmtoRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsgmtoRelat(int value) {
        this.csgmtoRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdTrnsp
     *
     * @return cidtfdTrnsp
     */
    public int getCidtfdTrnsp() {
        return cidtfdTrnsp;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdTrnsp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdTrnsp(int value) {
        this.cidtfdTrnsp = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdImobl
     *
     * @return cidtfdImobl
     */
    public int getCidtfdImobl() {
        return cidtfdImobl;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdImobl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdImobl(int value) {
        this.cidtfdImobl = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdAgric
     *
     * @return cidtfdAgric
     */
    public int getCidtfdAgric() {
        return cidtfdAgric;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdAgric
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdAgric(int value) {
        this.cidtfdAgric = value;
    }

    /**
     * Propósito:  Retornar o valor de cidtfdProj
     *
     * @return cidtfdProj
     */
    public int getCidtfdProj() {
        return cidtfdProj;
    }

    /**
     * Propósito:  Atribuir valor ao cidtfdProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdProj(int value) {
        this.cidtfdProj = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER127
     *
     * @return fILLER127
     */
    public String getFILLER127() {
        return filler127;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER127
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER127(String value) {
        this.filler127 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCAERequest() {
        super();
    }
}
