/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.request;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWA3ERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWA3ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWA3E-HEADER", "RICCWA3E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWA3E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWA3E-HEADER", "RICCWA3E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 100;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWA3E-REGISTRO", "RICCWA3E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo maxOcorr
     */
    @CommareaField(name = {"RICCWA3E-REGISTRO", "RICCWA3E-MAX-OCORR"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 5, pic = "9(005)")
    protected int maxOcorr = 0;

    /**
     * Atributo tpoPsqsa
     */
    @CommareaField(name = {"RICCWA3E-REGISTRO", "RICCWA3E-TPO-PSQSA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int tpoPsqsa = 0;

    /**
     * Atributo cpssoaJurid
     */
    @CommareaField(name = {"RICCWA3E-REGISTRO", "RICCWA3E-CPSSOA-JURID"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 10, pic = "9(010)")
    protected long cpssoaJurid = 0L;

    /**
     * Atributo nseqUnidTrab
     */
    @CommareaField(name = {"RICCWA3E-REGISTRO", "RICCWA3E-NSEQ-UNID-TRAB"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 8, pic = "9(008)")
    protected int nseqUnidTrab = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWA3E-REGISTRO", "RICCWA3E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nroCnpj
     */
    @CommareaField(name = {"RICCWA3E-REGISTRO", "RICCWA3E-NRO-CNPJ"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 9, pic = "9(009)")
    protected int nroCnpj = 0;

    /**
     * Atributo filler68
     */
    protected String filler68 = null;

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
     * Propósito:  Retornar o valor de tpoPsqsa
     *
     * @return tpoPsqsa
     */
    public int getTpoPsqsa() {
        return tpoPsqsa;
    }

    /**
     * Propósito:  Atribuir valor ao tpoPsqsa
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setTpoPsqsa(int value) {
        this.tpoPsqsa = value;
    }

    /**
     * Propósito:  Retornar o valor de cpssoaJurid
     *
     * @return cpssoaJurid
     */
    public long getCpssoaJurid() {
        return cpssoaJurid;
    }

    /**
     * Propósito:  Atribuir valor ao cpssoaJurid
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCpssoaJurid(long value) {
        this.cpssoaJurid = value;
    }

    /**
     * Propósito:  Retornar o valor de nseqUnidTrab
     *
     * @return nseqUnidTrab
     */
    public int getNseqUnidTrab() {
        return nseqUnidTrab;
    }

    /**
     * Propósito:  Atribuir valor ao nseqUnidTrab
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNseqUnidTrab(int value) {
        this.nseqUnidTrab = value;
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
     * Propósito:  Retornar o valor de nroCnpj
     *
     * @return nroCnpj
     */
    public int getNroCnpj() {
        return nroCnpj;
    }

    /**
     * Propósito:  Atribuir valor ao nroCnpj
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNroCnpj(int value) {
        this.nroCnpj = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER68
     *
     * @return fILLER68
     */
    public String getFILLER68() {
        return filler68;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER68
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER68(String value) {
        this.filler68 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWA3ERequest() {
        super();
    }
}
