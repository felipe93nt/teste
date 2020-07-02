/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA9ERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA9ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA9E-HEADER", "RICCWA9E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA9E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA9E-HEADER", "RICCWA9E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWA9E-REGISTRO", "RICCWA9E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWA9E-REGISTRO", "RICCWA9E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWA9E-REGISTRO", "RICCWA9E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo ctpoComent
     */
    @CommareaField(name = {"RICCWA9E-REGISTRO", "RICCWA9E-CTPO-COMENT"}, maxLength = 2, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 2, pic = "9(002)")
    protected int ctpoComent = 0;

    /**
     * Atributo filler80
     */
    protected String filler80 = null;

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
     * Prop�sito:  Retornar o valor de ctpoComent
     *
     * @return ctpoComent
     */
    public int getCtpoComent() {
        return ctpoComent;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoComent
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoComent(int value) {
        this.ctpoComent = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER80
     *
     * @return fILLER80
     */
    public String getFILLER80() {
        return filler80;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER80
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER80(String value) {
        this.filler80 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA9ERequest() {
        super();
    }
}
