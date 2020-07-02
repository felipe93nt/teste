/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutClienteFornec.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutClienteFornec.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBVERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBVERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBVE-HEADER", "RICCWBVE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBVE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBVE-HEADER", "RICCWBVE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo ncliFornc
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-NCLI-FORNC"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 9, pic = "9(009)")
    protected int ncliFornc = 0;

    /**
     * Atributo ctpoCli
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-CTPO-CLI"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 1, pic = "9(001)")
    protected int ctpoCli = 0;

    /**
     * Atributo rcliFornc
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-RCLI-FORNC"}, maxLength = 80, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 80, pic = "X(080)")
    protected String rcliFornc = null;

    /**
     * Atributo pcliFornc
     */
    @CommareaField(name = {"RICCWBVE-REGISTRO", "RICCWBVE-PCLI-FORNC"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pcliFornc = null;

    /**
     * Atributo filler113
     */
    protected String filler113 = null;

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
     * Prop�sito:  Retornar o valor de ncliFornc
     *
     * @return ncliFornc
     */
    public int getNcliFornc() {
        return ncliFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao ncliFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcliFornc(int value) {
        this.ncliFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ctpoCli
     *
     * @return ctpoCli
     */
    public int getCtpoCli() {
        return ctpoCli;
    }

    /**
     * Prop�sito:  Atribuir valor ao ctpoCli
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCtpoCli(int value) {
        this.ctpoCli = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rcliFornc
     *
     * @return rcliFornc
     */
    public String getRcliFornc() {
        return rcliFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao rcliFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRcliFornc(String value) {
        this.rcliFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pcliFornc
     *
     * @return pcliFornc
     */
    public BigDecimal getPcliFornc() {
        return pcliFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao pcliFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPcliFornc(BigDecimal value) {
        this.pcliFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER113
     *
     * @return fILLER113
     */
    public String getFILLER113() {
        return filler113;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER113
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER113(String value) {
        this.filler113 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBVERequest() {
        super();
    }
}
