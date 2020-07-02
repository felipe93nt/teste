/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaAtuacao.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaAtuacao.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCBERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCBERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCBE-HEADER", "RICCWCBE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCBE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCBE-HEADER", "RICCWCBE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCBE-REGISTRO", "RICCWCBE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWCBE-REGISTRO", "RICCWCBE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCBE-REGISTRO", "RICCWCBE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCBE-REGISTRO", "RICCWCBE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nareaAtuac
     */
    @CommareaField(name = {"RICCWCBE-REGISTRO", "RICCWCBE-NAREA-ATUAC"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nareaAtuac = 0;

    /**
     * Atributo restAtuac
     */
    @CommareaField(name = {"RICCWCBE-REGISTRO", "RICCWCBE-REST-ATUAC"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 40, pic = "X(040)")
    protected String restAtuac = null;

    /**
     * Atributo rrgiaoAtua
     */
    @CommareaField(name = {"RICCWCBE-REGISTRO", "RICCWCBE-RRGIAO-ATUA"}, maxLength = 40, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 40, pic = "X(040)")
    protected String rrgiaoAtua = null;

    /**
     * Atributo filler129
     */
    protected String filler129 = null;

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
     * Propósito:  Retornar o valor de nareaAtuac
     *
     * @return nareaAtuac
     */
    public int getNareaAtuac() {
        return nareaAtuac;
    }

    /**
     * Propósito:  Atribuir valor ao nareaAtuac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNareaAtuac(int value) {
        this.nareaAtuac = value;
    }

    /**
     * Propósito:  Retornar o valor de restAtuac
     *
     * @return restAtuac
     */
    public String getRestAtuac() {
        return restAtuac;
    }

    /**
     * Propósito:  Atribuir valor ao restAtuac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRestAtuac(String value) {
        this.restAtuac = value;
    }

    /**
     * Propósito:  Retornar o valor de rrgiaoAtua
     *
     * @return rrgiaoAtua
     */
    public String getRrgiaoAtua() {
        return rrgiaoAtua;
    }

    /**
     * Propósito:  Atribuir valor ao rrgiaoAtua
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRrgiaoAtua(String value) {
        this.rrgiaoAtua = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER129
     *
     * @return fILLER129
     */
    public String getFILLER129() {
        return filler129;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER129
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER129(String value) {
        this.filler129 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCBERequest() {
        super();
    }
}
