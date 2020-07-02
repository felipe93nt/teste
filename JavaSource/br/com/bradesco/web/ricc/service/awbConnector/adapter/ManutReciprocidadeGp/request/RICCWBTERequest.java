/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutReciprocidadeGp.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutReciprocidadeGp.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBTERequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBTERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBTE-HEADER", "RICCWBTE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBTE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBTE-HEADER", "RICCWBTE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 500;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo dtInfo
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-DT-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 10, pic = "X(010)")
    protected String dtInfo = null;

    /**
     * Atributo vvolumCobrS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-COBRANCA", "RICCWBTE-VVOLUM-COBR-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String vvolumCobrS = null;

    /**
     * Atributo vvolumCobr
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-COBRANCA", "RICCWBTE-VVOLUM-COBR"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 8, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvolumCobr = null;

    /**
     * Atributo vvolumCobrNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-COBRANCA", "RICCWBTE-VVOLUM-COBR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String vvolumCobrNull = null;

    /**
     * Atributo vresulCobrS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-COBRANCA", "RICCWBTE-VRESUL-COBR-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(001)")
    protected String vresulCobrS = null;

    /**
     * Atributo vresulCobr
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-COBRANCA", "RICCWBTE-VRESUL-COBR"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 11, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vresulCobr = null;

    /**
     * Atributo vresulCobrNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-COBRANCA", "RICCWBTE-VRESUL-COBR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 12, maxBytes = 1, pic = "X(001)")
    protected String vresulCobrNull = null;

    /**
     * Atributo qtRecddCobr
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-COBRANCA", "RICCWBTE-QT-RECDD-COBR"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 13, maxBytes = 9, pic = "9(009)")
    protected int qtRecddCobr = 0;

    /**
     * Atributo qtRecddCobrNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-COBRANCA", "RICCWBTE-QT-RECDD-COBR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 14, maxBytes = 1, pic = "X(001)")
    protected String qtRecddCobrNull = null;

    /**
     * Atributo vvolumForncS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-FORNECEDOR", "RICCWBTE-VVOLUM-FORNC-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 15, maxBytes = 1, pic = "X(001)")
    protected String vvolumForncS = null;

    /**
     * Atributo vvolumFornc
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-FORNECEDOR", "RICCWBTE-VVOLUM-FORNC"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 16, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvolumFornc = null;

    /**
     * Atributo vvolumForncNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-FORNECEDOR", "RICCWBTE-VVOLUM-FORNC-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 17, maxBytes = 1, pic = "X(001)")
    protected String vvolumForncNull = null;

    /**
     * Atributo vrectaForncS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RECEITA-FORNECEDOR", "RICCWBTE-VRECTA-FORNC-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 18, maxBytes = 1, pic = "X(001)")
    protected String vrectaForncS = null;

    /**
     * Atributo vrectaFornc
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RECEITA-FORNECEDOR", "RICCWBTE-VRECTA-FORNC"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 19, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vrectaFornc = null;

    /**
     * Atributo vrectaForncNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RECEITA-FORNECEDOR", "RICCWBTE-VRECTA-FORNC-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 20, maxBytes = 1, pic = "X(001)")
    protected String vrectaForncNull = null;

    /**
     * Atributo qtRecddFornc
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-FORNECEDOR", "RICCWBTE-QT-RECDD-FORNC"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 21, maxBytes = 9, pic = "9(009)")
    protected int qtRecddFornc = 0;

    /**
     * Atributo qtRecddForncNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-FORNECEDOR", "RICCWBTE-QT-RECDD-FORNC-NUL"
        + "L"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 22, maxBytes = 1, pic = "X(001)")
    protected String qtRecddForncNull = null;

    /**
     * Atributo vrecddTribtS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-TRIBUTOS", "RICCWBTE-VRECDD-TRIBT-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 23, maxBytes = 1, pic = "X(001)")
    protected String vrecddTribtS = null;

    /**
     * Atributo vrecddTribt
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-TRIBUTOS", "RICCWBTE-VRECDD-TRIBT"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 24, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vrecddTribt = null;

    /**
     * Atributo vrecddTribtNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-TRIBUTOS", "RICCWBTE-VRECDD-TRIBT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 25, maxBytes = 1, pic = "X(001)")
    protected String vrecddTribtNull = null;

    /**
     * Atributo qtRecddTribt
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-TRIBUTOS", "RICCWBTE-QT-RECDD-TRIBT"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 26, maxBytes = 9, pic = "9(009)")
    protected int qtRecddTribt = 0;

    /**
     * Atributo qtRecddTribtNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-TRIBUTOS",
        "RICCWBTE-QT-RECDD-TRIBT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 27, maxBytes = 1,
        pic = "X(001)")
    protected String qtRecddTribtNull = null;

    /**
     * Atributo vemprBdscoS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-EMPRESA", "RICCWBTE-VEMPR-BDSCO-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 28, maxBytes = 1, pic = "X(001)")
    protected String vemprBdscoS = null;

    /**
     * Atributo vemprBdsco
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-EMPRESA", "RICCWBTE-VEMPR-BDSCO"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 29, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vemprBdsco = null;

    /**
     * Atributo vemprBdscoNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-EMPRESA", "RICCWBTE-VEMPR-BDSCO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 30, maxBytes = 1, pic = "X(001)")
    protected String vemprBdscoNull = null;

    /**
     * Atributo qtEmprBsdco
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-EMPRESA", "RICCWBTE-QT-EMPR-BSDCO"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 31, maxBytes = 9, pic = "9(009)")
    protected int qtEmprBsdco = 0;

    /**
     * Atributo qtEmprBsdcoNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-EMPRESA", "RICCWBTE-QT-EMPR-BSDCO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 32, maxBytes = 1, pic = "X(001)")
    protected String qtEmprBsdcoNull = null;

    /**
     * Atributo vflSalrlS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-FOLHA", "RICCWBTE-VFL-SALRL-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 33, maxBytes = 1, pic = "X(001)")
    protected String vflSalrlS = null;

    /**
     * Atributo vflSalrl
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-FOLHA", "RICCWBTE-VFL-SALRL"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 34, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vflSalrl = null;

    /**
     * Atributo vflSalrlNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-FOLHA", "RICCWBTE-VFL-SALRL-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 35, maxBytes = 1, pic = "X(001)")
    protected String vflSalrlNull = null;

    /**
     * Atributo qtTotFunc
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-FUNC", "RICCWBTE-QT-TOT-FUNC"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 36, maxBytes = 9, pic = "9(009)")
    protected int qtTotFunc = 0;

    /**
     * Atributo qtTotFuncNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-FUNC", "RICCWBTE-QT-TOT-FUNC-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 37, maxBytes = 1, pic = "X(001)")
    protected String qtTotFuncNull = null;

    /**
     * Atributo vresulEmprS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-EMPRESA", "RICCWBTE-VRESUL-EMPR-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 38, maxBytes = 1, pic = "X(001)")
    protected String vresulEmprS = null;

    /**
     * Atributo vresulEmpr
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-EMPRESA", "RICCWBTE-VRESUL-EMPR"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 39, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vresulEmpr = null;

    /**
     * Atributo vresulEmprNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-EMPRESA", "RICCWBTE-VRESUL-EMPR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 40, maxBytes = 1, pic = "X(001)")
    protected String vresulEmprNull = null;

    /**
     * Atributo vtotCredtS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-CREDITO", "RICCWBTE-VTOT-CREDT-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 41, maxBytes = 1, pic = "X(001)")
    protected String vtotCredtS = null;

    /**
     * Atributo vtotCredt
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-CREDITO", "RICCWBTE-VTOT-CREDT"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 42, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotCredt = null;

    /**
     * Atributo vtotCredtNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-VALOR-CREDITO", "RICCWBTE-VTOT-CREDT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 43, maxBytes = 1, pic = "X(001)")
    protected String vtotCredtNull = null;

    /**
     * Atributo qtTotCredt
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-CREDITO", "RICCWBTE-QT-TOT-CREDT"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 44, maxBytes = 9, pic = "9(009)")
    protected int qtTotCredt = 0;

    /**
     * Atributo qtTotCredtNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-QUANTIDADE-CREDITO", "RICCWBTE-QT-TOT-CREDT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 45, maxBytes = 1, pic = "X(001)")
    protected String qtTotCredtNull = null;

    /**
     * Atributo vresulCredtS
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-CREDITO", "RICCWBTE-VRESUL-CREDT-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 46, maxBytes = 1, pic = "X(001)")
    protected String vresulCredtS = null;

    /**
     * Atributo vresulCredt
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-CREDITO", "RICCWBTE-VRESUL-CREDT"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 47, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vresulCredt = null;

    /**
     * Atributo vresulCredtNull
     */
    @CommareaField(name = {"RICCWBTE-REGISTRO", "RICCWBTE-RESULTADO-CREDITO", "RICCWBTE-VRESUL-CREDT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 48, maxBytes = 1, pic = "X(001)")
    protected String vresulCredtNull = null;

    /**
     * Atributo filler111
     */
    protected String filler111 = null;

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
     * Prop�sito:  Retornar o valor de dtInfo
     *
     * @return dtInfo
     */
    public String getDtInfo() {
        return dtInfo;
    }

    /**
     * Prop�sito:  Atribuir valor ao dtInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtInfo(String value) {
        this.dtInfo = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vvolumCobrS
     *
     * @return vvolumCobrS
     */
    public String getVvolumCobrS() {
        return vvolumCobrS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vvolumCobrS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumCobrS(String value) {
        this.vvolumCobrS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vvolumCobr
     *
     * @return vvolumCobr
     */
    public BigDecimal getVvolumCobr() {
        return vvolumCobr;
    }

    /**
     * Prop�sito:  Atribuir valor ao vvolumCobr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumCobr(BigDecimal value) {
        this.vvolumCobr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vvolumCobrNull
     *
     * @return vvolumCobrNull
     */
    public String getVvolumCobrNull() {
        return vvolumCobrNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vvolumCobrNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumCobrNull(String value) {
        this.vvolumCobrNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulCobrS
     *
     * @return vresulCobrS
     */
    public String getVresulCobrS() {
        return vresulCobrS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulCobrS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCobrS(String value) {
        this.vresulCobrS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulCobr
     *
     * @return vresulCobr
     */
    public BigDecimal getVresulCobr() {
        return vresulCobr;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulCobr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCobr(BigDecimal value) {
        this.vresulCobr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulCobrNull
     *
     * @return vresulCobrNull
     */
    public String getVresulCobrNull() {
        return vresulCobrNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulCobrNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCobrNull(String value) {
        this.vresulCobrNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtRecddCobr
     *
     * @return qtRecddCobr
     */
    public int getQtRecddCobr() {
        return qtRecddCobr;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtRecddCobr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddCobr(int value) {
        this.qtRecddCobr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtRecddCobrNull
     *
     * @return qtRecddCobrNull
     */
    public String getQtRecddCobrNull() {
        return qtRecddCobrNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtRecddCobrNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddCobrNull(String value) {
        this.qtRecddCobrNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vvolumForncS
     *
     * @return vvolumForncS
     */
    public String getVvolumForncS() {
        return vvolumForncS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vvolumForncS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumForncS(String value) {
        this.vvolumForncS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vvolumFornc
     *
     * @return vvolumFornc
     */
    public BigDecimal getVvolumFornc() {
        return vvolumFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao vvolumFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumFornc(BigDecimal value) {
        this.vvolumFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vvolumForncNull
     *
     * @return vvolumForncNull
     */
    public String getVvolumForncNull() {
        return vvolumForncNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vvolumForncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumForncNull(String value) {
        this.vvolumForncNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectaForncS
     *
     * @return vrectaForncS
     */
    public String getVrectaForncS() {
        return vrectaForncS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectaForncS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectaForncS(String value) {
        this.vrectaForncS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectaFornc
     *
     * @return vrectaFornc
     */
    public BigDecimal getVrectaFornc() {
        return vrectaFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectaFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectaFornc(BigDecimal value) {
        this.vrectaFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrectaForncNull
     *
     * @return vrectaForncNull
     */
    public String getVrectaForncNull() {
        return vrectaForncNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrectaForncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectaForncNull(String value) {
        this.vrectaForncNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtRecddFornc
     *
     * @return qtRecddFornc
     */
    public int getQtRecddFornc() {
        return qtRecddFornc;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtRecddFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddFornc(int value) {
        this.qtRecddFornc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtRecddForncNull
     *
     * @return qtRecddForncNull
     */
    public String getQtRecddForncNull() {
        return qtRecddForncNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtRecddForncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddForncNull(String value) {
        this.qtRecddForncNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecddTribtS
     *
     * @return vrecddTribtS
     */
    public String getVrecddTribtS() {
        return vrecddTribtS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecddTribtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecddTribtS(String value) {
        this.vrecddTribtS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecddTribt
     *
     * @return vrecddTribt
     */
    public BigDecimal getVrecddTribt() {
        return vrecddTribt;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecddTribt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecddTribt(BigDecimal value) {
        this.vrecddTribt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vrecddTribtNull
     *
     * @return vrecddTribtNull
     */
    public String getVrecddTribtNull() {
        return vrecddTribtNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vrecddTribtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecddTribtNull(String value) {
        this.vrecddTribtNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtRecddTribt
     *
     * @return qtRecddTribt
     */
    public int getQtRecddTribt() {
        return qtRecddTribt;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtRecddTribt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddTribt(int value) {
        this.qtRecddTribt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtRecddTribtNull
     *
     * @return qtRecddTribtNull
     */
    public String getQtRecddTribtNull() {
        return qtRecddTribtNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtRecddTribtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddTribtNull(String value) {
        this.qtRecddTribtNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vemprBdscoS
     *
     * @return vemprBdscoS
     */
    public String getVemprBdscoS() {
        return vemprBdscoS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vemprBdscoS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVemprBdscoS(String value) {
        this.vemprBdscoS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vemprBdsco
     *
     * @return vemprBdsco
     */
    public BigDecimal getVemprBdsco() {
        return vemprBdsco;
    }

    /**
     * Prop�sito:  Atribuir valor ao vemprBdsco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVemprBdsco(BigDecimal value) {
        this.vemprBdsco = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vemprBdscoNull
     *
     * @return vemprBdscoNull
     */
    public String getVemprBdscoNull() {
        return vemprBdscoNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vemprBdscoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVemprBdscoNull(String value) {
        this.vemprBdscoNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtEmprBsdco
     *
     * @return qtEmprBsdco
     */
    public int getQtEmprBsdco() {
        return qtEmprBsdco;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtEmprBsdco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtEmprBsdco(int value) {
        this.qtEmprBsdco = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtEmprBsdcoNull
     *
     * @return qtEmprBsdcoNull
     */
    public String getQtEmprBsdcoNull() {
        return qtEmprBsdcoNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtEmprBsdcoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtEmprBsdcoNull(String value) {
        this.qtEmprBsdcoNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vflSalrlS
     *
     * @return vflSalrlS
     */
    public String getVflSalrlS() {
        return vflSalrlS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vflSalrlS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVflSalrlS(String value) {
        this.vflSalrlS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vflSalrl
     *
     * @return vflSalrl
     */
    public BigDecimal getVflSalrl() {
        return vflSalrl;
    }

    /**
     * Prop�sito:  Atribuir valor ao vflSalrl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVflSalrl(BigDecimal value) {
        this.vflSalrl = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vflSalrlNull
     *
     * @return vflSalrlNull
     */
    public String getVflSalrlNull() {
        return vflSalrlNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vflSalrlNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVflSalrlNull(String value) {
        this.vflSalrlNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtTotFunc
     *
     * @return qtTotFunc
     */
    public int getQtTotFunc() {
        return qtTotFunc;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtTotFunc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotFunc(int value) {
        this.qtTotFunc = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtTotFuncNull
     *
     * @return qtTotFuncNull
     */
    public String getQtTotFuncNull() {
        return qtTotFuncNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtTotFuncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotFuncNull(String value) {
        this.qtTotFuncNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulEmprS
     *
     * @return vresulEmprS
     */
    public String getVresulEmprS() {
        return vresulEmprS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulEmprS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulEmprS(String value) {
        this.vresulEmprS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulEmpr
     *
     * @return vresulEmpr
     */
    public BigDecimal getVresulEmpr() {
        return vresulEmpr;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulEmpr(BigDecimal value) {
        this.vresulEmpr = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulEmprNull
     *
     * @return vresulEmprNull
     */
    public String getVresulEmprNull() {
        return vresulEmprNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulEmprNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulEmprNull(String value) {
        this.vresulEmprNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotCredtS
     *
     * @return vtotCredtS
     */
    public String getVtotCredtS() {
        return vtotCredtS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotCredtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotCredtS(String value) {
        this.vtotCredtS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotCredt
     *
     * @return vtotCredt
     */
    public BigDecimal getVtotCredt() {
        return vtotCredt;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotCredt(BigDecimal value) {
        this.vtotCredt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vtotCredtNull
     *
     * @return vtotCredtNull
     */
    public String getVtotCredtNull() {
        return vtotCredtNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vtotCredtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotCredtNull(String value) {
        this.vtotCredtNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtTotCredt
     *
     * @return qtTotCredt
     */
    public int getQtTotCredt() {
        return qtTotCredt;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtTotCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotCredt(int value) {
        this.qtTotCredt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de qtTotCredtNull
     *
     * @return qtTotCredtNull
     */
    public String getQtTotCredtNull() {
        return qtTotCredtNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao qtTotCredtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotCredtNull(String value) {
        this.qtTotCredtNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulCredtS
     *
     * @return vresulCredtS
     */
    public String getVresulCredtS() {
        return vresulCredtS;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulCredtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCredtS(String value) {
        this.vresulCredtS = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulCredt
     *
     * @return vresulCredt
     */
    public BigDecimal getVresulCredt() {
        return vresulCredt;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCredt(BigDecimal value) {
        this.vresulCredt = value;
    }

    /**
     * Prop�sito:  Retornar o valor de vresulCredtNull
     *
     * @return vresulCredtNull
     */
    public String getVresulCredtNull() {
        return vresulCredtNull;
    }

    /**
     * Prop�sito:  Atribuir valor ao vresulCredtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCredtNull(String value) {
        this.vresulCredtNull = value;
    }

    /**
     * Prop�sito:  Retornar o valor de fILLER111
     *
     * @return fILLER111
     */
    public String getFILLER111() {
        return filler111;
    }

    /**
     * Prop�sito:  Atribuir valor ao fILLER111
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER111(String value) {
        this.filler111 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBTERequest() {
        super();
    }
}
