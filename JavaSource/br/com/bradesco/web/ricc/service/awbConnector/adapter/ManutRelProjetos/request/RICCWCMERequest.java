/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCMERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCMERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCME-HEADER", "RICCWCME-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCME";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCME-HEADER", "RICCWCME-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCME-REGISTRO", "RICCWCME-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWCME-REGISTRO", "RICCWCME-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCME-REGISTRO", "RICCWCME-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCME-REGISTRO", "RICCWCME-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo iprojEmpr
     */
    @CommareaField(name = {"RICCWCME-REGISTRO", "RICCWCME-IPROJ-EMPR"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 30, pic = "X(030)")
    protected String iprojEmpr = null;

    /**
     * Atributo filler140
     */
    protected String filler140 = null;

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
     * Propósito:  Retornar o valor de iprojEmpr
     *
     * @return iprojEmpr
     */
    public String getIprojEmpr() {
        return iprojEmpr;
    }

    /**
     * Propósito:  Atribuir valor ao iprojEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setIprojEmpr(String value) {
        this.iprojEmpr = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER140
     *
     * @return fILLER140
     */
    public String getFILLER140() {
        return filler140;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER140
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER140(String value) {
        this.filler140 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCMERequest() {
        super();
    }
}
