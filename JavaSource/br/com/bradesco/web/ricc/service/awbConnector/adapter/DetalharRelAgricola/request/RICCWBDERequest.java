/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBDERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBDERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBDE-HEADER", "RICCWBDE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBDE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBDE-HEADER", "RICCWBDE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBDE-REGISTRO", "RICCWBDE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBDE-REGISTRO", "RICCWBDE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBDE-REGISTRO", "RICCWBDE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo ctpoRelato
     */
    @CommareaField(name = {"RICCWBDE-REGISTRO", "RICCWBDE-CTPO-RELATO"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 1, pic = "9(001)")
    protected int ctpoRelato = 0;

    /**
     * Atributo filler90
     */
    protected String filler90 = null;

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
     * Prop�sito:  Retornar o valor de ctpoRelato
     *
     * @return ctpoRelato
     */
    public int getCtpoRelato() {
        return ctpoRelato;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoRelato
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoRelato(int value) {
        this.ctpoRelato = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER90
     *
     * @return fILLER90
     */
    public String getFILLER90() {
        return filler90;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER90
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER90(String value) {
        this.filler90 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBDERequest() {
        super();
    }
}
