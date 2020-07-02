/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutConstruFornec.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutConstruFornec.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB3ERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB3ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB3E-HEADER", "RICCWB3E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB3E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB3E-HEADER", "RICCWB3E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB3E-REGISTRO", "RICCWB3E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWB3E-REGISTRO", "RICCWB3E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB3E-REGISTRO", "RICCWB3E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB3E-REGISTRO", "RICCWB3E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nconstFornc
     */
    @CommareaField(name = {"RICCWB3E-REGISTRO", "RICCWB3E-NCONST-FORNC"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nconstFornc = 0;

    /**
     * Atributo ctpoFornc
     */
    @CommareaField(name = {"RICCWB3E-REGISTRO", "RICCWB3E-CTPO-FORNC"}, maxLength = 2, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 2, pic = "9(002)")
    protected int ctpoFornc = 0;

    /**
     * Atributo rconFornc
     */
    @CommareaField(name = {"RICCWB3E-REGISTRO", "RICCWB3E-RCON-FORNC"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 30, pic = "X(030)")
    protected String rconFornc = null;

    /**
     * Atributo filler121
     */
    protected String filler121 = null;

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
     * Prop�sito:  Retornar o valor de nconstFornc
     *
     * @return nconstFornc
     */
    public int getNconstFornc() {
        return nconstFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao nconstFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNconstFornc(int value) {
        this.nconstFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoFornc
     *
     * @return ctpoFornc
     */
    public int getCtpoFornc() {
        return ctpoFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoFornc(int value) {
        this.ctpoFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rconFornc
     *
     * @return rconFornc
     */
    public String getRconFornc() {
        return rconFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao rconFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRconFornc(String value) {
        this.rconFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER121
     *
     * @return fILLER121
     */
    public String getFILLER121() {
        return filler121;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER121
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER121(String value) {
        this.filler121 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWB3ERequest() {
        super();
    }
}
