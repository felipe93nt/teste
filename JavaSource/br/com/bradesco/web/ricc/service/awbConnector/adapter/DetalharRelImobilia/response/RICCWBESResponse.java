/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBESResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBESResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBES-HEADER", "RICCWBES-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBES";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBES-HEADER", "RICCWBES-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 200;

    /**
     * Atributo cidtfdResid
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-CIDTFD-RESID"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 1, pic = "9(001)")
    protected int cidtfdResid = 0;

    /**
     * Atributo cidtfdComl
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-CIDTFD-COML"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int cidtfdComl = 0;

    /**
     * Atributo cbaixaRenda
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-CBAIXA-RENDA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 1, pic = "9(001)")
    protected int cbaixaRenda = 0;

    /**
     * Atributo cmedRenda
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-CMED-RENDA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 1, pic = "9(001)")
    protected int cmedRenda = 0;

    /**
     * Atributo caltaRenda
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-CALTA-RENDA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 1, pic = "9(001)")
    protected int caltaRenda = 0;

    /**
     * Atributo ppreChave
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-PPRE-CHAVE"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 7, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ppreChave = null;

    /**
     * Atributo pposChave
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-PPOS-CHAVE"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 8, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pposChave = null;

    /**
     * Atributo cconstPpria
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-CCONST-PPRIA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 9, maxBytes = 1, pic = "9(001)")
    protected int cconstPpria = 0;

    /**
     * Atributo cconstTceira
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-CCONST-TCEIRA"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 10, maxBytes = 1, pic = "9(001)")
    protected int cconstTceira = 0;

    /**
     * Atributo rconstTceira
     */
    @CommareaField(name = {"RICCWBES-REGISTRO", "RICCWBES-RCONST-TCEIRA"}, maxLength = 50, usage = "DISPLAY",
        fieldNumber = 11, maxBytes = 50, pic = "X(050)")
    protected String rconstTceira = null;

    /**
     * Atributo filler93
     */
    protected String filler93 = null;

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
     * Prop�sito:  Retornar o valor de fILLER93
     *
     * @return fILLER93
     */
    public String getFILLER93() {
        return filler93;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER93
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER93(String value) {
        this.filler93 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBESResponse() {
        super();
    }
}
