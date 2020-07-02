/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.response;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBHSResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBHSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBHS-HEADER", "RICCWBHS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBHS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBHS-HEADER", "RICCWBHS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBHS-REGISTRO", "RICCWBHS-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBHS-REGISTRO", "RICCWBHS-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo filler99
     */
    protected String filler99 = null;

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
     * Prop�sito:  Retornar o valor de fILLER99
     *
     * @return fILLER99
     */
    public String getFILLER99() {
        return filler99;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER99
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER99(String value) {
        this.filler99 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBHSResponse() {
        super();
    }
}
