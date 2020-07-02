/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAMSResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAMSResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAMS-HEADER", "RICCWAMS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAMS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAMS-HEADER", "RICCWAMS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 400;

    /**
     * Atributo dtInfo
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-DT-INFO"}, maxLength = 10, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 10, pic = "X(010)")
    protected String dtInfo = null;

    /**
     * Atributo vvolumCobrS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-COBRANCA", "RICCWAMS-VVOLUM-COBR-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String vvolumCobrS = null;

    /**
     * Atributo vvolumCobr
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-COBRANCA", "RICCWAMS-VVOLUM-COBR"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 4, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvolumCobr = null;

    /**
     * Atributo vvolumCobrNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-COBRANCA", "RICCWAMS-VVOLUM-COBR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String vvolumCobrNull = null;

    /**
     * Atributo vresulCobrS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-COBRANCA", "RICCWAMS-VRESUL-COBR-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 6, maxBytes = 1, pic = "X(001)")
    protected String vresulCobrS = null;

    /**
     * Atributo vresulCobr
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-COBRANCA", "RICCWAMS-VRESUL-COBR"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 7, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vresulCobr = null;

    /**
     * Atributo vresulCobrNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-COBRANCA", "RICCWAMS-VRESUL-COBR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 8, maxBytes = 1, pic = "X(001)")
    protected String vresulCobrNull = null;

    /**
     * Atributo qtRecddCobr
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-COBRANCA", "RICCWAMS-QT-RECDD-COBR"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 9, maxBytes = 9, pic = "9(009)")
    protected int qtRecddCobr = 0;

    /**
     * Atributo qtRecddCobrNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-COBRANCA", "RICCWAMS-QT-RECDD-COBR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(001)")
    protected String qtRecddCobrNull = null;

    /**
     * Atributo vvolumForncS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-FORNECEDOR", "RICCWAMS-VVOLUM-FORNC-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String vvolumForncS = null;

    /**
     * Atributo vvolumFornc
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-FORNECEDOR", "RICCWAMS-VVOLUM-FORNC"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vvolumFornc = null;

    /**
     * Atributo vvolumForncNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-FORNECEDOR", "RICCWAMS-VVOLUM-FORNC-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(001)")
    protected String vvolumForncNull = null;

    /**
     * Atributo vrectaForncS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RECEITA-FORNECEDOR", "RICCWAMS-VRECTA-FORNC-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 14, maxBytes = 1, pic = "X(001)")
    protected String vrectaForncS = null;

    /**
     * Atributo vrectaFornc
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RECEITA-FORNECEDOR", "RICCWAMS-VRECTA-FORNC"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 15, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vrectaFornc = null;

    /**
     * Atributo vrectaForncNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RECEITA-FORNECEDOR", "RICCWAMS-VRECTA-FORNC-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 16, maxBytes = 1, pic = "X(001)")
    protected String vrectaForncNull = null;

    /**
     * Atributo qtRecddFornc
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-FORNECEDOR", "RICCWAMS-QT-RECDD-FORNC"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 17, maxBytes = 9, pic = "9(009)")
    protected int qtRecddFornc = 0;

    /**
     * Atributo qtRecddForncNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-FORNECEDOR", "RICCWAMS-QT-RECDD-FORNC-NUL"
        + "L"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 18, maxBytes = 1, pic = "X(001)")
    protected String qtRecddForncNull = null;

    /**
     * Atributo vrecddTribtS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-TRIBUTOS", "RICCWAMS-VRECDD-TRIBT-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 19, maxBytes = 1, pic = "X(001)")
    protected String vrecddTribtS = null;

    /**
     * Atributo vrecddTribt
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-TRIBUTOS", "RICCWAMS-VRECDD-TRIBT"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 20, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vrecddTribt = null;

    /**
     * Atributo vrecddTribtNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-TRIBUTOS", "RICCWAMS-VRECDD-TRIBT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 21, maxBytes = 1, pic = "X(001)")
    protected String vrecddTribtNull = null;

    /**
     * Atributo qtRecddTribt
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-TRIBUTOS", "RICCWAMS-QT-RECDD-TRIBT"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 22, maxBytes = 9, pic = "9(009)")
    protected int qtRecddTribt = 0;

    /**
     * Atributo qtRecddTribtNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-TRIBUTOS",
        "RICCWAMS-QT-RECDD-TRIBT-NULL"}, maxLength = 1, usage = "DISPLAY", fieldNumber = 23, maxBytes = 1,
        pic = "X(001)")
    protected String qtRecddTribtNull = null;

    /**
     * Atributo vemprBdscoS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-EMPRESA", "RICCWAMS-VEMPR-BDSCO-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 24, maxBytes = 1, pic = "X(001)")
    protected String vemprBdscoS = null;

    /**
     * Atributo vemprBdsco
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-EMPRESA", "RICCWAMS-VEMPR-BDSCO"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 25, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vemprBdsco = null;

    /**
     * Atributo vemprBdscoNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-EMPRESA", "RICCWAMS-VEMPR-BDSCO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 26, maxBytes = 1, pic = "X(001)")
    protected String vemprBdscoNull = null;

    /**
     * Atributo qtEmprBsdco
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-EMPRESA", "RICCWAMS-QT-EMPR-BSDCO"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 27, maxBytes = 9, pic = "9(009)")
    protected int qtEmprBsdco = 0;

    /**
     * Atributo qtEmprBsdcoNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-EMPRESA", "RICCWAMS-QT-EMPR-BSDCO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 28, maxBytes = 1, pic = "X(001)")
    protected String qtEmprBsdcoNull = null;

    /**
     * Atributo vflSalrlS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-FOLHA", "RICCWAMS-VFL-SALRL-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 29, maxBytes = 1, pic = "X(001)")
    protected String vflSalrlS = null;

    /**
     * Atributo vflSalrl
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-FOLHA", "RICCWAMS-VFL-SALRL"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 30, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vflSalrl = null;

    /**
     * Atributo vflSalrlNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-FOLHA", "RICCWAMS-VFL-SALRL-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 31, maxBytes = 1, pic = "X(001)")
    protected String vflSalrlNull = null;

    /**
     * Atributo qtTotFunc
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-FUNC", "RICCWAMS-QT-TOT-FUNC"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 32, maxBytes = 9, pic = "9(009)")
    protected int qtTotFunc = 0;

    /**
     * Atributo qtTotFuncNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-FUNC", "RICCWAMS-QT-TOT-FUNC-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 33, maxBytes = 1, pic = "X(001)")
    protected String qtTotFuncNull = null;

    /**
     * Atributo vresulEmprS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-EMPRESA", "RICCWAMS-VRESUL-EMPR-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 34, maxBytes = 1, pic = "X(001)")
    protected String vresulEmprS = null;

    /**
     * Atributo vresulEmpr
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-EMPRESA", "RICCWAMS-VRESUL-EMPR"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 35, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vresulEmpr = null;

    /**
     * Atributo vresulEmprNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-EMPRESA", "RICCWAMS-VRESUL-EMPR-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 36, maxBytes = 1, pic = "X(001)")
    protected String vresulEmprNull = null;

    /**
     * Atributo vtotCredtS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-CREDITO", "RICCWAMS-VTOT-CREDT-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 37, maxBytes = 1, pic = "X(001)")
    protected String vtotCredtS = null;

    /**
     * Atributo vtotCredt
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-CREDITO", "RICCWAMS-VTOT-CREDT"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 38, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotCredt = null;

    /**
     * Atributo vtotCredtNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-VALOR-CREDITO", "RICCWAMS-VTOT-CREDT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 39, maxBytes = 1, pic = "X(001)")
    protected String vtotCredtNull = null;

    /**
     * Atributo qtTotCredt
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-CREDITO", "RICCWAMS-QT-TOT-CREDT"},
        maxLength = 9, usage = "DISPLAY", fieldNumber = 40, maxBytes = 9, pic = "9(009)")
    protected int qtTotCredt = 0;

    /**
     * Atributo qtTotCredtNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-QUANTIDADE-CREDITO", "RICCWAMS-QT-TOT-CREDT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 41, maxBytes = 1, pic = "X(001)")
    protected String qtTotCredtNull = null;

    /**
     * Atributo vresulCredtS
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-CREDITO", "RICCWAMS-VRESUL-CREDT-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 42, maxBytes = 1, pic = "X(001)")
    protected String vresulCredtS = null;

    /**
     * Atributo vresulCredt
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-CREDITO", "RICCWAMS-VRESUL-CREDT"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 43, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vresulCredt = null;

    /**
     * Atributo vresulCredtNull
     */
    @CommareaField(name = {"RICCWAMS-REGISTRO", "RICCWAMS-RESULTADO-CREDITO", "RICCWAMS-VRESUL-CREDT-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 44, maxBytes = 1, pic = "X(001)")
    protected String vresulCredtNull = null;

    /**
     * Atributo filler33
     */
    protected String filler33 = null;

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
     * Propósito:  Retornar o valor de dtInfo
     *
     * @return dtInfo
     */
    public String getDtInfo() {
        return dtInfo;
    }

    /**
     * Propósito:  Atribuir valor ao dtInfo
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setDtInfo(String value) {
        this.dtInfo = value;
    }

    /**
     * Propósito:  Retornar o valor de vvolumCobrS
     *
     * @return vvolumCobrS
     */
    public String getVvolumCobrS() {
        return vvolumCobrS;
    }

    /**
     * Propósito:  Atribuir valor ao vvolumCobrS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumCobrS(String value) {
        this.vvolumCobrS = value;
    }

    /**
     * Propósito:  Retornar o valor de vvolumCobr
     *
     * @return vvolumCobr
     */
    public BigDecimal getVvolumCobr() {
        return vvolumCobr;
    }

    /**
     * Propósito:  Atribuir valor ao vvolumCobr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumCobr(BigDecimal value) {
        this.vvolumCobr = value;
    }

    /**
     * Propósito:  Retornar o valor de vvolumCobrNull
     *
     * @return vvolumCobrNull
     */
    public String getVvolumCobrNull() {
        return vvolumCobrNull;
    }

    /**
     * Propósito:  Atribuir valor ao vvolumCobrNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumCobrNull(String value) {
        this.vvolumCobrNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulCobrS
     *
     * @return vresulCobrS
     */
    public String getVresulCobrS() {
        return vresulCobrS;
    }

    /**
     * Propósito:  Atribuir valor ao vresulCobrS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCobrS(String value) {
        this.vresulCobrS = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulCobr
     *
     * @return vresulCobr
     */
    public BigDecimal getVresulCobr() {
        return vresulCobr;
    }

    /**
     * Propósito:  Atribuir valor ao vresulCobr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCobr(BigDecimal value) {
        this.vresulCobr = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulCobrNull
     *
     * @return vresulCobrNull
     */
    public String getVresulCobrNull() {
        return vresulCobrNull;
    }

    /**
     * Propósito:  Atribuir valor ao vresulCobrNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCobrNull(String value) {
        this.vresulCobrNull = value;
    }

    /**
     * Propósito:  Retornar o valor de qtRecddCobr
     *
     * @return qtRecddCobr
     */
    public int getQtRecddCobr() {
        return qtRecddCobr;
    }

    /**
     * Propósito:  Atribuir valor ao qtRecddCobr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddCobr(int value) {
        this.qtRecddCobr = value;
    }

    /**
     * Propósito:  Retornar o valor de qtRecddCobrNull
     *
     * @return qtRecddCobrNull
     */
    public String getQtRecddCobrNull() {
        return qtRecddCobrNull;
    }

    /**
     * Propósito:  Atribuir valor ao qtRecddCobrNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddCobrNull(String value) {
        this.qtRecddCobrNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vvolumForncS
     *
     * @return vvolumForncS
     */
    public String getVvolumForncS() {
        return vvolumForncS;
    }

    /**
     * Propósito:  Atribuir valor ao vvolumForncS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumForncS(String value) {
        this.vvolumForncS = value;
    }

    /**
     * Propósito:  Retornar o valor de vvolumFornc
     *
     * @return vvolumFornc
     */
    public BigDecimal getVvolumFornc() {
        return vvolumFornc;
    }

    /**
     * Propósito:  Atribuir valor ao vvolumFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumFornc(BigDecimal value) {
        this.vvolumFornc = value;
    }

    /**
     * Propósito:  Retornar o valor de vvolumForncNull
     *
     * @return vvolumForncNull
     */
    public String getVvolumForncNull() {
        return vvolumForncNull;
    }

    /**
     * Propósito:  Atribuir valor ao vvolumForncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVvolumForncNull(String value) {
        this.vvolumForncNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vrectaForncS
     *
     * @return vrectaForncS
     */
    public String getVrectaForncS() {
        return vrectaForncS;
    }

    /**
     * Propósito:  Atribuir valor ao vrectaForncS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectaForncS(String value) {
        this.vrectaForncS = value;
    }

    /**
     * Propósito:  Retornar o valor de vrectaFornc
     *
     * @return vrectaFornc
     */
    public BigDecimal getVrectaFornc() {
        return vrectaFornc;
    }

    /**
     * Propósito:  Atribuir valor ao vrectaFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectaFornc(BigDecimal value) {
        this.vrectaFornc = value;
    }

    /**
     * Propósito:  Retornar o valor de vrectaForncNull
     *
     * @return vrectaForncNull
     */
    public String getVrectaForncNull() {
        return vrectaForncNull;
    }

    /**
     * Propósito:  Atribuir valor ao vrectaForncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrectaForncNull(String value) {
        this.vrectaForncNull = value;
    }

    /**
     * Propósito:  Retornar o valor de qtRecddFornc
     *
     * @return qtRecddFornc
     */
    public int getQtRecddFornc() {
        return qtRecddFornc;
    }

    /**
     * Propósito:  Atribuir valor ao qtRecddFornc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddFornc(int value) {
        this.qtRecddFornc = value;
    }

    /**
     * Propósito:  Retornar o valor de qtRecddForncNull
     *
     * @return qtRecddForncNull
     */
    public String getQtRecddForncNull() {
        return qtRecddForncNull;
    }

    /**
     * Propósito:  Atribuir valor ao qtRecddForncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddForncNull(String value) {
        this.qtRecddForncNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vrecddTribtS
     *
     * @return vrecddTribtS
     */
    public String getVrecddTribtS() {
        return vrecddTribtS;
    }

    /**
     * Propósito:  Atribuir valor ao vrecddTribtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecddTribtS(String value) {
        this.vrecddTribtS = value;
    }

    /**
     * Propósito:  Retornar o valor de vrecddTribt
     *
     * @return vrecddTribt
     */
    public BigDecimal getVrecddTribt() {
        return vrecddTribt;
    }

    /**
     * Propósito:  Atribuir valor ao vrecddTribt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecddTribt(BigDecimal value) {
        this.vrecddTribt = value;
    }

    /**
     * Propósito:  Retornar o valor de vrecddTribtNull
     *
     * @return vrecddTribtNull
     */
    public String getVrecddTribtNull() {
        return vrecddTribtNull;
    }

    /**
     * Propósito:  Atribuir valor ao vrecddTribtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVrecddTribtNull(String value) {
        this.vrecddTribtNull = value;
    }

    /**
     * Propósito:  Retornar o valor de qtRecddTribt
     *
     * @return qtRecddTribt
     */
    public int getQtRecddTribt() {
        return qtRecddTribt;
    }

    /**
     * Propósito:  Atribuir valor ao qtRecddTribt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddTribt(int value) {
        this.qtRecddTribt = value;
    }

    /**
     * Propósito:  Retornar o valor de qtRecddTribtNull
     *
     * @return qtRecddTribtNull
     */
    public String getQtRecddTribtNull() {
        return qtRecddTribtNull;
    }

    /**
     * Propósito:  Atribuir valor ao qtRecddTribtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtRecddTribtNull(String value) {
        this.qtRecddTribtNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vemprBdscoS
     *
     * @return vemprBdscoS
     */
    public String getVemprBdscoS() {
        return vemprBdscoS;
    }

    /**
     * Propósito:  Atribuir valor ao vemprBdscoS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVemprBdscoS(String value) {
        this.vemprBdscoS = value;
    }

    /**
     * Propósito:  Retornar o valor de vemprBdsco
     *
     * @return vemprBdsco
     */
    public BigDecimal getVemprBdsco() {
        return vemprBdsco;
    }

    /**
     * Propósito:  Atribuir valor ao vemprBdsco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVemprBdsco(BigDecimal value) {
        this.vemprBdsco = value;
    }

    /**
     * Propósito:  Retornar o valor de vemprBdscoNull
     *
     * @return vemprBdscoNull
     */
    public String getVemprBdscoNull() {
        return vemprBdscoNull;
    }

    /**
     * Propósito:  Atribuir valor ao vemprBdscoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVemprBdscoNull(String value) {
        this.vemprBdscoNull = value;
    }

    /**
     * Propósito:  Retornar o valor de qtEmprBsdco
     *
     * @return qtEmprBsdco
     */
    public int getQtEmprBsdco() {
        return qtEmprBsdco;
    }

    /**
     * Propósito:  Atribuir valor ao qtEmprBsdco
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtEmprBsdco(int value) {
        this.qtEmprBsdco = value;
    }

    /**
     * Propósito:  Retornar o valor de qtEmprBsdcoNull
     *
     * @return qtEmprBsdcoNull
     */
    public String getQtEmprBsdcoNull() {
        return qtEmprBsdcoNull;
    }

    /**
     * Propósito:  Atribuir valor ao qtEmprBsdcoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtEmprBsdcoNull(String value) {
        this.qtEmprBsdcoNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vflSalrlS
     *
     * @return vflSalrlS
     */
    public String getVflSalrlS() {
        return vflSalrlS;
    }

    /**
     * Propósito:  Atribuir valor ao vflSalrlS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVflSalrlS(String value) {
        this.vflSalrlS = value;
    }

    /**
     * Propósito:  Retornar o valor de vflSalrl
     *
     * @return vflSalrl
     */
    public BigDecimal getVflSalrl() {
        return vflSalrl;
    }

    /**
     * Propósito:  Atribuir valor ao vflSalrl
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVflSalrl(BigDecimal value) {
        this.vflSalrl = value;
    }

    /**
     * Propósito:  Retornar o valor de vflSalrlNull
     *
     * @return vflSalrlNull
     */
    public String getVflSalrlNull() {
        return vflSalrlNull;
    }

    /**
     * Propósito:  Atribuir valor ao vflSalrlNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVflSalrlNull(String value) {
        this.vflSalrlNull = value;
    }

    /**
     * Propósito:  Retornar o valor de qtTotFunc
     *
     * @return qtTotFunc
     */
    public int getQtTotFunc() {
        return qtTotFunc;
    }

    /**
     * Propósito:  Atribuir valor ao qtTotFunc
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotFunc(int value) {
        this.qtTotFunc = value;
    }

    /**
     * Propósito:  Retornar o valor de qtTotFuncNull
     *
     * @return qtTotFuncNull
     */
    public String getQtTotFuncNull() {
        return qtTotFuncNull;
    }

    /**
     * Propósito:  Atribuir valor ao qtTotFuncNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotFuncNull(String value) {
        this.qtTotFuncNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulEmprS
     *
     * @return vresulEmprS
     */
    public String getVresulEmprS() {
        return vresulEmprS;
    }

    /**
     * Propósito:  Atribuir valor ao vresulEmprS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulEmprS(String value) {
        this.vresulEmprS = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulEmpr
     *
     * @return vresulEmpr
     */
    public BigDecimal getVresulEmpr() {
        return vresulEmpr;
    }

    /**
     * Propósito:  Atribuir valor ao vresulEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulEmpr(BigDecimal value) {
        this.vresulEmpr = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulEmprNull
     *
     * @return vresulEmprNull
     */
    public String getVresulEmprNull() {
        return vresulEmprNull;
    }

    /**
     * Propósito:  Atribuir valor ao vresulEmprNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulEmprNull(String value) {
        this.vresulEmprNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotCredtS
     *
     * @return vtotCredtS
     */
    public String getVtotCredtS() {
        return vtotCredtS;
    }

    /**
     * Propósito:  Atribuir valor ao vtotCredtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotCredtS(String value) {
        this.vtotCredtS = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotCredt
     *
     * @return vtotCredt
     */
    public BigDecimal getVtotCredt() {
        return vtotCredt;
    }

    /**
     * Propósito:  Atribuir valor ao vtotCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotCredt(BigDecimal value) {
        this.vtotCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotCredtNull
     *
     * @return vtotCredtNull
     */
    public String getVtotCredtNull() {
        return vtotCredtNull;
    }

    /**
     * Propósito:  Atribuir valor ao vtotCredtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotCredtNull(String value) {
        this.vtotCredtNull = value;
    }

    /**
     * Propósito:  Retornar o valor de qtTotCredt
     *
     * @return qtTotCredt
     */
    public int getQtTotCredt() {
        return qtTotCredt;
    }

    /**
     * Propósito:  Atribuir valor ao qtTotCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotCredt(int value) {
        this.qtTotCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de qtTotCredtNull
     *
     * @return qtTotCredtNull
     */
    public String getQtTotCredtNull() {
        return qtTotCredtNull;
    }

    /**
     * Propósito:  Atribuir valor ao qtTotCredtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setQtTotCredtNull(String value) {
        this.qtTotCredtNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulCredtS
     *
     * @return vresulCredtS
     */
    public String getVresulCredtS() {
        return vresulCredtS;
    }

    /**
     * Propósito:  Atribuir valor ao vresulCredtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCredtS(String value) {
        this.vresulCredtS = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulCredt
     *
     * @return vresulCredt
     */
    public BigDecimal getVresulCredt() {
        return vresulCredt;
    }

    /**
     * Propósito:  Atribuir valor ao vresulCredt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCredt(BigDecimal value) {
        this.vresulCredt = value;
    }

    /**
     * Propósito:  Retornar o valor de vresulCredtNull
     *
     * @return vresulCredtNull
     */
    public String getVresulCredtNull() {
        return vresulCredtNull;
    }

    /**
     * Propósito:  Atribuir valor ao vresulCredtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVresulCredtNull(String value) {
        this.vresulCredtNull = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER33
     *
     * @return fILLER33
     */
    public String getFILLER33() {
        return filler33;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER33
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER33(String value) {
        this.filler33 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAMSResponse() {
        super();
    }
}
