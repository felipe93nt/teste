/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBHERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBHERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBHE-HEADER", "RICCWBHE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBHE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBHE-HEADER", "RICCWBHE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoFuncao
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CTPO-FUNCAO"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoFuncao = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nomeRelat
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-NOME-RELAT"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 50, pic = "X(050)")
    protected String nomeRelat = null;

    /**
     * Atributo csgmtoRelat
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CSGMTO-RELAT"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 3, pic = "9(003)")
    protected int csgmtoRelat = 0;

    /**
     * Atributo cidtfdTrnsp
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CIDTFD-TRNSP"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 1, pic = "9(001)")
    protected int cidtfdTrnsp = 0;

    /**
     * Atributo cidtfdImobl
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CIDTFD-IMOBL"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 1, pic = "9(001)")
    protected int cidtfdImobl = 0;

    /**
     * Atributo cidtfdAgric
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CIDTFD-AGRIC"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 1, pic = "9(001)")
    protected int cidtfdAgric = 0;

    /**
     * Atributo cidtfdProj
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CIDTFD-PROJ"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 1, pic = "9(001)")
    protected int cidtfdProj = 0;

    /**
     * Atributo csitRelat
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CSIT-RELAT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 1, pic = "9(001)")
    protected int csitRelat = 0;

    /**
     * Atributo cusuarIncl
     */
    @CommareaField(name = {"RICCWBHE-REGISTRO", "RICCWBHE-CUSUAR-INCL"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 9, pic = "X(009)")
    protected String cusuarIncl = null;

    /**
     * Atributo filler98
     */
    protected String filler98 = null;

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
     * Prop�sito:  Retornar o valor de ctpoFuncao
     *
     * @return ctpoFuncao
     */
    public int getCtpoFuncao() {
        return ctpoFuncao;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoFuncao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoFuncao(int value) {
        this.ctpoFuncao = value;
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
     * Prop�sito:  Retornar o valor de nomeRelat
     *
     * @return nomeRelat
     */
    public String getNomeRelat() {
        return nomeRelat;
    }

    /**
     * Prop�sito:  Atribuir valor ao nomeRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNomeRelat(String value) {
        this.nomeRelat = value;
    }

    /**
     * Prop�sito:  Retornar o valor de csgmtoRelat
     *
     * @return csgmtoRelat
     */
    public int getCsgmtoRelat() {
        return csgmtoRelat;
    }

    /**
     * Prop�sito:  Atribuir valor ao csgmtoRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsgmtoRelat(int value) {
        this.csgmtoRelat = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdTrnsp
     *
     * @return cidtfdTrnsp
     */
    public int getCidtfdTrnsp() {
        return cidtfdTrnsp;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdTrnsp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdTrnsp(int value) {
        this.cidtfdTrnsp = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdImobl
     *
     * @return cidtfdImobl
     */
    public int getCidtfdImobl() {
        return cidtfdImobl;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdImobl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdImobl(int value) {
        this.cidtfdImobl = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdAgric
     *
     * @return cidtfdAgric
     */
    public int getCidtfdAgric() {
        return cidtfdAgric;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdAgric
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdAgric(int value) {
        this.cidtfdAgric = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdProj
     *
     * @return cidtfdProj
     */
    public int getCidtfdProj() {
        return cidtfdProj;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdProj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdProj(int value) {
        this.cidtfdProj = value;
    }

    /**
     * Prop�sito:  Retornar o valor de csitRelat
     *
     * @return csitRelat
     */
    public int getCsitRelat() {
        return csitRelat;
    }

    /**
     * Prop�sito:  Atribuir valor ao csitRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCsitRelat(int value) {
        this.csitRelat = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cusuarIncl
     *
     * @return cusuarIncl
     */
    public String getCusuarIncl() {
        return cusuarIncl;
    }

    /**
     * Prop�sito:  Atribuir valor ao cusuarIncl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCusuarIncl(String value) {
        this.cusuarIncl = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER98
     *
     * @return fILLER98
     */
    public String getFILLER98() {
        return filler98;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER98
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER98(String value) {
        this.filler98 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBHERequest() {
        super();
    }
}
