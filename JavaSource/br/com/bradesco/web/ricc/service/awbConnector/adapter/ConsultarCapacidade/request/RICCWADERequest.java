/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 14/11/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWADERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWADERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWADE-HEADER", "RICCWADE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWADE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWADE-HEADER", "RICCWADE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWADE-REGISTRO", "RICCWADE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo maxOcorr
     */
    @CommareaField(name = {"RICCWADE-REGISTRO", "RICCWADE-MAX-OCORR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int maxOcorr = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWADE-REGISTRO", "RICCWADE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWADE-REGISTRO", "RICCWADE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWADE-REGISTRO", "RICCWADE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo filler8
     */
    protected String filler8 = null;

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
     * Prop�sito:  Retornar o valor de maxOcorr
     *
     * @return maxOcorr
     */
    public int getMaxOcorr() {
        return maxOcorr;
    }

    /**
     * Prop�sito:  Atribuir valor ao maxOcorr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setMaxOcorr(int value) {
        this.maxOcorr = value;
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
     * Prop�sito:  Retornar o valor de nrelatSgmto
     *
     * @return nrelatSgmto
     */
    public int getNrelatSgmto() {
        return nrelatSgmto;
    }

    /**
     * Prop�sito:  Atribuir valor ao nrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatSgmto(int value) {
        this.nrelatSgmto = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER8
     *
     * @return fILLER8
     */
    public String getFILLER8() {
        return filler8;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER8
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER8(String value) {
        this.filler8 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWADERequest() {
        super();
    }
}
