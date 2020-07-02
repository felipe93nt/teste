/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCartoesGpEcon.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCartoesGpEcon.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBOERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBOERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBOE-HEADER", "RICCWBOE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBOE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBOE-HEADER", "RICCWBOE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo eCtpoManut
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int eCtpoManut = 0;

    /**
     * Atributo eCgrpEconm
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int eCgrpEconm = 0;

    /**
     * Atributo eNrelatCredt
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int eNrelatCredt = 0;

    /**
     * Atributo eNrelatSgmto
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int eNrelatSgmto = 0;

    /**
     * Atributo eNcataoRelat
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-NCATAO-RELAT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int eNcataoRelat = 0;

    /**
     * Atributo eQtotCart
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-QTOT-CART"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 9, pic = "9(009)")
    protected int eQtotCart = 0;

    /**
     * Atributo eVresul
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-VRESUL"}, maxLength = 17, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal eVresul = null;

    /**
     * Atributo eRbande
     */
    @CommareaField(name = {"RICCWBOE-REGISTRO", "RICCWBOE-E-RBANDE"}, maxLength = 30, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 30, pic = "X(030)")
    protected String eRbande = null;

    /**
     * Atributo filler106
     */
    protected String filler106 = null;

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
     * Propósito:  Retornar o valor de eCtpoManut
     *
     * @return eCtpoManut
     */
    public int geteCtpoManut() {
        return eCtpoManut;
    }

    /**
     * Propósito:  Atribuir valor ao eCtpoManut
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteCtpoManut(int value) {
        this.eCtpoManut = value;
    }

    /**
     * Propósito:  Retornar o valor de eCgrpEconm
     *
     * @return eCgrpEconm
     */
    public int geteCgrpEconm() {
        return eCgrpEconm;
    }

    /**
     * Propósito:  Atribuir valor ao eCgrpEconm
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteCgrpEconm(int value) {
        this.eCgrpEconm = value;
    }

    /**
     * Propósito:  Retornar o valor de eNrelatCredt
     *
     * @return eNrelatCredt
     */
    public int geteNrelatCredt() {
        return eNrelatCredt;
    }

    /**
     * Propósito:  Atribuir valor ao eNrelatCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteNrelatCredt(int value) {
        this.eNrelatCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de eNrelatSgmto
     *
     * @return eNrelatSgmto
     */
    public int geteNrelatSgmto() {
        return eNrelatSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao eNrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteNrelatSgmto(int value) {
        this.eNrelatSgmto = value;
    }

    /**
     * Propósito:  Retornar o valor de eNcataoRelat
     *
     * @return eNcataoRelat
     */
    public int geteNcataoRelat() {
        return eNcataoRelat;
    }

    /**
     * Propósito:  Atribuir valor ao eNcataoRelat
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteNcataoRelat(int value) {
        this.eNcataoRelat = value;
    }

    /**
     * Propósito:  Retornar o valor de eQtotCart
     *
     * @return eQtotCart
     */
    public int geteQtotCart() {
        return eQtotCart;
    }

    /**
     * Propósito:  Atribuir valor ao eQtotCart
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteQtotCart(int value) {
        this.eQtotCart = value;
    }

    /**
     * Propósito:  Retornar o valor de eVresul
     *
     * @return eVresul
     */
    public BigDecimal geteVresul() {
        return eVresul;
    }

    /**
     * Propósito:  Atribuir valor ao eVresul
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteVresul(BigDecimal value) {
        this.eVresul = value;
    }

    /**
     * Propósito:  Retornar o valor de eRbande
     *
     * @return eRbande
     */
    public String geteRbande() {
        return eRbande;
    }

    /**
     * Propósito:  Atribuir valor ao eRbande
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void seteRbande(String value) {
        this.eRbande = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER106
     *
     * @return fILLER106
     */
    public String getFILLER106() {
        return filler106;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER106
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER106(String value) {
        this.filler106 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBOERequest() {
        super();
    }
}
