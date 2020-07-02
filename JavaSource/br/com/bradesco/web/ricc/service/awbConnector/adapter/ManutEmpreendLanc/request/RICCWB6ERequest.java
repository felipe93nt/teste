/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEmpreendLanc.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 10/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEmpreendLanc.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWB6ERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWB6ERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWB6E-HEADER", "RICCWB6E-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWB6E";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWB6E-HEADER", "RICCWB6E-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nemptoImobl
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-NEMPTO-IMOBL"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nemptoImobl = 0;

    /**
     * Atributo nanoHistAnt
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-NANO-HIST-ANT"}, maxLength = 4, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 4, pic = "9(004)")
    protected int nanoHistAnt = 0;

    /**
     * Atributo nanoHistNovo
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-NANO-HIST-NOVO"}, maxLength = 4, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 4, pic = "9(004)")
    protected int nanoHistNovo = 0;

    /**
     * Atributo vtotLcto
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-VTOT-LCTO"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotLcto = null;

    /**
     * Atributo qtotLcto
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "RICCWB6E-QTOT-LCTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 9, pic = "9(009)")
    protected int qtotLcto = 0;

    /**
     * Atributo filler0
     */
    @CommareaField(name = {"RICCWB6E-REGISTRO", "FILLER"}, maxLength = 122, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 122, pic = "X(122)")
    protected String filler0 = null;

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
     * Propósito:  Retornar o valor de nemptoImobl
     *
     * @return nemptoImobl
     */
    public int getNemptoImobl() {
        return nemptoImobl;
    }

    /**
     * Propósito:  Atribuir valor ao nemptoImobl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNemptoImobl(int value) {
        this.nemptoImobl = value;
    }

    /**
     * Propósito:  Retornar o valor de nanoHistAnt
     *
     * @return nanoHistAnt
     */
    public int getNanoHistAnt() {
        return nanoHistAnt;
    }

    /**
     * Propósito:  Atribuir valor ao nanoHistAnt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoHistAnt(int value) {
        this.nanoHistAnt = value;
    }

    /**
     * Propósito:  Retornar o valor de nanoHistNovo
     *
     * @return nanoHistNovo
     */
    public int getNanoHistNovo() {
        return nanoHistNovo;
    }

    /**
     * Propósito:  Atribuir valor ao nanoHistNovo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoHistNovo(int value) {
        this.nanoHistNovo = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotLcto
     *
     * @return vtotLcto
     */
    public BigDecimal getVtotLcto() {
        return vtotLcto;
    }

    /**
     * Propósito:  Atribuir valor ao vtotLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotLcto(BigDecimal value) {
        this.vtotLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de qtotLcto
     *
     * @return qtotLcto
     */
    public int getQtotLcto() {
        return qtotLcto;
    }

    /**
     * Propósito:  Atribuir valor ao qtotLcto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtotLcto(int value) {
        this.qtotLcto = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER0
     *
     * @return fILLER0
     */
    public String getFILLER0() {
        return filler0;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER0
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
    public RICCWB6ERequest() {
        super();
    }
}
