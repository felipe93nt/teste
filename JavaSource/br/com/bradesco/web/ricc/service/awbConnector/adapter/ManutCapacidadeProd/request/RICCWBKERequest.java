/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 07/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBKERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBKERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBKE-HEADER", "RICCWBKE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBKE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBKE-HEADER", "RICCWBKE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo ncapacPrdtv
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-NCAPAC-PRDTV"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int ncapacPrdtv = 0;

    /**
     * Atributo rplanta
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-RPLANTA"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 30, pic = "X(030)")
    protected String rplanta = null;

    /**
     * Atributo qtCapac
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-QT-CAPAC"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 9, pic = "9(009)")
    protected int qtCapac = 0;

    /**
     * Atributo qtProduc
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-QT-PRODUC"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 9, pic = "9(009)")
    protected int qtProduc = 0;

    /**
     * Atributo putilzProd
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "RICCWBKE-PUTILZ-PROD"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal putilzProd = null;

    /**
     * Atributo filler0
     */
    @CommareaField(name = {"RICCWBKE-REGISTRO", "FILLER"}, maxLength = 194, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 194, pic = "X(194)")
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
     * Prop�sito:  Retornar o valor de ctpoManut
     *
     * @return ctpoManut
     */
    public int getCtpoManut() {
        return ctpoManut;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoManut(int value) {
        this.ctpoManut = value;
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
     * Prop�sito:  Retornar o valor de ncapacPrdtv
     *
     * @return ncapacPrdtv
     */
    public int getNcapacPrdtv() {
        return ncapacPrdtv;
    }

    /**
     * Prop�sito:  Atribuir valor ao ncapacPrdtv
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcapacPrdtv(int value) {
        this.ncapacPrdtv = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rplanta
     *
     * @return rplanta
     */
    public String getRplanta() {
        return rplanta;
    }

    /**
     * Prop�sito:  Atribuir valor ao rplanta
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRplanta(String value) {
        this.rplanta = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtCapac
     *
     * @return qtCapac
     */
    public int getQtCapac() {
        return qtCapac;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtCapac
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtCapac(int value) {
        this.qtCapac = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtProduc
     *
     * @return qtProduc
     */
    public int getQtProduc() {
        return qtProduc;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtProduc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtProduc(int value) {
        this.qtProduc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de putilzProd
     *
     * @return putilzProd
     */
    public BigDecimal getPutilzProd() {
        return putilzProd;
    }

    /**
     * Prop�sito:  Atribuir valor ao putilzProd
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPutilzProd(BigDecimal value) {
        this.putilzProd = value;
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
    public RICCWBKERequest() {
        super();
    }
}
