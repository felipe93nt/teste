/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWCKERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWCKERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWCKE-HEADER", "RICCWCKE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWCKE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWCKE-HEADER", "RICCWCKE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo cidtfdResid
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CIDTFD-RESID"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 1, pic = "9(001)")
    protected int cidtfdResid = 0;

    /**
     * Atributo cidtfdComl
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CIDTFD-COML"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 1, pic = "9(001)")
    protected int cidtfdComl = 0;

    /**
     * Atributo cbaixaRenda
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CBAIXA-RENDA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 1, pic = "9(001)")
    protected int cbaixaRenda = 0;

    /**
     * Atributo cmedRenda
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CMED-RENDA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 1, pic = "9(001)")
    protected int cmedRenda = 0;

    /**
     * Atributo caltaRenda
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CALTA-RENDA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 1, pic = "9(001)")
    protected int caltaRenda = 0;

    /**
     * Atributo ppreChave
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-PPRE-CHAVE"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ppreChave = null;

    /**
     * Atributo pposChave
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-PPOS-CHAVE"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 12, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pposChave = null;

    /**
     * Atributo cconstPpria
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CCONST-PPRIA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 13, maxBytes = 1, pic = "9(001)")
    protected int cconstPpria = 0;

    /**
     * Atributo cconstTceira
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-CCONST-TCEIRA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 14, maxBytes = 1, pic = "9(001)")
    protected int cconstTceira = 0;

    /**
     * Atributo rconstTceira
     */
    @CommareaField(name = {"RICCWCKE-REGISTRO", "RICCWCKE-RCONST-TCEIRA"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 15, maxBytes = 50, pic = "X(050)")
    protected String rconstTceira = null;

    /**
     * Atributo filler138
     */
    protected String filler138 = null;

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
     * Prop�sito:  Retornar o valor de cidtfdResid
     *
     * @return cidtfdResid
     */
    public int getCidtfdResid() {
        return cidtfdResid;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdResid
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdResid(int value) {
        this.cidtfdResid = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cidtfdComl
     *
     * @return cidtfdComl
     */
    public int getCidtfdComl() {
        return cidtfdComl;
    }

    /**
     * Prop�sito:  Atribuir valor ao cidtfdComl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCidtfdComl(int value) {
        this.cidtfdComl = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cbaixaRenda
     *
     * @return cbaixaRenda
     */
    public int getCbaixaRenda() {
        return cbaixaRenda;
    }

    /**
     * Prop�sito:  Atribuir valor ao cbaixaRenda
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCbaixaRenda(int value) {
        this.cbaixaRenda = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cmedRenda
     *
     * @return cmedRenda
     */
    public int getCmedRenda() {
        return cmedRenda;
    }

    /**
     * Prop�sito:  Atribuir valor ao cmedRenda
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCmedRenda(int value) {
        this.cmedRenda = value;
    }

    /**
     * Prop�sito:  Retornar o valor de caltaRenda
     *
     * @return caltaRenda
     */
    public int getCaltaRenda() {
        return caltaRenda;
    }

    /**
     * Prop�sito:  Atribuir valor ao caltaRenda
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCaltaRenda(int value) {
        this.caltaRenda = value;
    }

    /**
     * Prop�sito:  Retornar o valor de ppreChave
     *
     * @return ppreChave
     */
    public BigDecimal getPpreChave() {
        return ppreChave;
    }

    /**
     * Prop�sito:  Atribuir valor ao ppreChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPpreChave(BigDecimal value) {
        this.ppreChave = value;
    }

    /**
     * Prop�sito:  Retornar o valor de pposChave
     *
     * @return pposChave
     */
    public BigDecimal getPposChave() {
        return pposChave;
    }

    /**
     * Prop�sito:  Atribuir valor ao pposChave
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPposChave(BigDecimal value) {
        this.pposChave = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cconstPpria
     *
     * @return cconstPpria
     */
    public int getCconstPpria() {
        return cconstPpria;
    }

    /**
     * Prop�sito:  Atribuir valor ao cconstPpria
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCconstPpria(int value) {
        this.cconstPpria = value;
    }

    /**
     * Prop�sito:  Retornar o valor de cconstTceira
     *
     * @return cconstTceira
     */
    public int getCconstTceira() {
        return cconstTceira;
    }

    /**
     * Prop�sito:  Atribuir valor ao cconstTceira
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setCconstTceira(int value) {
        this.cconstTceira = value;
    }

    /**
     * Prop�sito:  Retornar o valor de rconstTceira
     *
     * @return rconstTceira
     */
    public String getRconstTceira() {
        return rconstTceira;
    }

    /**
     * Prop�sito:  Atribuir valor ao rconstTceira
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRconstTceira(String value) {
        this.rconstTceira = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER138
     *
     * @return fILLER138
     */
    public String getFILLER138() {
        return filler138;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER138
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER138(String value) {
        this.filler138 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWCKERequest() {
        super();
    }
}
