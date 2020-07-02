/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPatrimonio.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPatrimonio.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBJERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBJERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBJE-HEADER", "RICCWBJE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBJE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBJE-HEADER", "RICCWBJE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo npatrmRelat
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-NPATRM-RELAT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int npatrmRelat = 0;

    /**
     * Atributo rpatrm
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-RPATRM"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 30, pic = "X(030)")
    protected String rpatrm = null;

    /**
     * Atributo vpatrm
     */
    @CommareaField(name = {"RICCWBJE-REGISTRO", "RICCWBJE-VPATRM"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vpatrm = null;

    /**
     * Atributo filler101
     */
    protected String filler101 = null;

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
     * Propósito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
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
     * Propósito:  Retornar o valor de nrelatCredt
     *
     * @return nrelatCredt
     */
    public int getNrelatCredt() {
        return nrelatCredt;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatCredt(int value) {
        this.nrelatCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de nrelatSgmto
     *
     * @return nrelatSgmto
     */
    public int getNrelatSgmto() {
        return nrelatSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatSgmto(int value) {
        this.nrelatSgmto = value;
    }

    /**
     * Propósito:  Retornar o valor de npatrmRelat
     *
     * @return npatrmRelat
     */
    public int getNpatrmRelat() {
        return npatrmRelat;
    }

    /**
     * Propósito:  Atribuir valor ao npatrmRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNpatrmRelat(int value) {
        this.npatrmRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de rpatrm
     *
     * @return rpatrm
     */
    public String getRpatrm() {
        return rpatrm;
    }

    /**
     * Propósito:  Atribuir valor ao rpatrm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRpatrm(String value) {
        this.rpatrm = value;
    }

    /**
     * Propósito:  Retornar o valor de vpatrm
     *
     * @return vpatrm
     */
    public BigDecimal getVpatrm() {
        return vpatrm;
    }

    /**
     * Propósito:  Atribuir valor ao vpatrm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVpatrm(BigDecimal value) {
        this.vpatrm = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER101
     *
     * @return fILLER101
     */
    public String getFILLER101() {
        return filler101;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER101
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER101(String value) {
        this.filler101 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBJERequest() {
        super();
    }
}
