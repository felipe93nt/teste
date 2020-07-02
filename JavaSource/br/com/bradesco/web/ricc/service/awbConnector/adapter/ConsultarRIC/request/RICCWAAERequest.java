/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAAERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAAERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAAE-HEADER", "RICCWAAE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAAE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAAE-HEADER", "RICCWAAE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWAAE-REGISTRO", "RICCWAAE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo maxOcorr
     */
    @CommareaField(name = {"RICCWAAE-REGISTRO", "RICCWAAE-MAX-OCORR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int maxOcorr = 0;

    /**
     * Atributo ctpoPsqsa
     */
    @CommareaField(name = {"RICCWAAE-REGISTRO", "RICCWAAE-CTPO-PSQSA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int ctpoPsqsa = 0;

    /**
     * Atributo cnpjEmpr
     */
    @CommareaField(name = {"RICCWAAE-REGISTRO", "RICCWAAE-CNPJ-EMPR"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int cnpjEmpr = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWAAE-REGISTRO", "RICCWAAE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nomeGrp
     */
    @CommareaField(name = {"RICCWAAE-REGISTRO", "RICCWAAE-NOME-GRP"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 30, pic = "X(030)")
    protected String nomeGrp = null;

    /**
     * Atributo statusRel
     */
    @CommareaField(name = {"RICCWAAE-REGISTRO", "RICCWAAE-STATUS-REL"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 1, pic = "9(001)")
    protected int statusRel = 0;

    /**
     * Atributo filler4
     */
    protected String filler4 = null;

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
     * Propósito:  Retornar o valor de maxOcorr
     *
     * @return maxOcorr
     */
    public int getMaxOcorr() {
        return maxOcorr;
    }

    /**
     * Propósito:  Atribuir valor ao maxOcorr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setMaxOcorr(int value) {
        this.maxOcorr = value;
    }

    /**
     * Propósito:  Retornar o valor de ctpoPsqsa
     *
     * @return ctpoPsqsa
     */
    public int getCtpoPsqsa() {
        return ctpoPsqsa;
    }

    /**
     * Propósito:  Atribuir valor ao ctpoPsqsa
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoPsqsa(int value) {
        this.ctpoPsqsa = value;
    }

    /**
     * Propósito:  Retornar o valor de cnpjEmpr
     *
     * @return cnpjEmpr
     */
    public int getCnpjEmpr() {
        return cnpjEmpr;
    }

    /**
     * Propósito:  Atribuir valor ao cnpjEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCnpjEmpr(int value) {
        this.cnpjEmpr = value;
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
     * Propósito:  Retornar o valor de nomeGrp
     *
     * @return nomeGrp
     */
    public String getNomeGrp() {
        return nomeGrp;
    }

    /**
     * Propósito:  Atribuir valor ao nomeGrp
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNomeGrp(String value) {
        this.nomeGrp = value;
    }

    /**
     * Propósito:  Retornar o valor de statusRel
     *
     * @return statusRel
     */
    public int getStatusRel() {
        return statusRel;
    }

    /**
     * Propósito:  Atribuir valor ao statusRel
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setStatusRel(int value) {
        this.statusRel = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER4
     *
     * @return fILLER4
     */
    public String getFILLER4() {
        return filler4;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER4
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER4(String value) {
        this.filler4 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAAERequest() {
        super();
    }
}
