/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA6ERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA6ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA6E-HEADER", "RICCWA6E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA6E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA6E-HEADER", "RICCWA6E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWA6E-REGISTRO", "RICCWA6E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWA6E-REGISTRO", "RICCWA6E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWA6E-REGISTRO", "RICCWA6E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo ctpoRamo
     */
    @CommareaField(name = {"RICCWA6E-REGISTRO", "RICCWA6E-CTPO-RAMO"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 1, pic = "9(001)")
    protected int ctpoRamo = 0;

    /**
     * Atributo filler0
     */
    @CommareaField(name = {"RICCWA6E-REGISTRO", "FILLER"}, maxLength = 65, usage = "DISPLAY", fieldNumber = 6,
        maxBytes = 65, pic = "X(065)")
    protected String filler0 = null;

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
     * Prop�sito:  Retornar o valor de ctpoRamo
     *
     * @return ctpoRamo
     */
    public int getCtpoRamo() {
        return ctpoRamo;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoRamo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoRamo(int value) {
        this.ctpoRamo = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER0
     *
     * @return fILLER0
     */
    public String getFILLER0() {
        return filler0;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER0
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER0(String value) {
        this.filler0 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA6ERequest() {
        super();
    }
}
