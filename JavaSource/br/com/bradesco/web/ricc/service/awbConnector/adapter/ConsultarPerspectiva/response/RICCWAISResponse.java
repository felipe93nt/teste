/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAISResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAISResponse extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWAIS-HEADER", "RICCWAIS-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWAIS";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWAIS-HEADER", "RICCWAIS-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 210;

    /**
     * Atributo vtotFtmtS
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-FATURAMENTO", "RICCWAIS-VTOT-FTMT-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 1, pic = "X(001)")
    protected String vtotFtmtS = null;

    /**
     * Atributo vtotFtmt
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-FATURAMENTO", "RICCWAIS-VTOT-FTMT"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotFtmt = null;

    /**
     * Atributo ftmtNull
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-FATURAMENTO", "RICCWAIS-FTMT-NULL"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 1, pic = "X(001)")
    protected String ftmtNull = null;

    /**
     * Atributo vebitdaS
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-EBITIDA", "RICCWAIS-VEBITDA-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String vebitdaS = null;

    /**
     * Atributo vebitda
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-EBITIDA", "RICCWAIS-VEBITDA"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vebitda = null;

    /**
     * Atributo vebitdaNull
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-EBITIDA", "RICCWAIS-VEBITDA-NULL"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String vebitdaNull = null;

    /**
     * Atributo vlucroLiqS
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-LUCRO-LIQUIDO", "RICCWAIS-VLUCRO-LIQ-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 8, maxBytes = 1, pic = "X(001)")
    protected String vlucroLiqS = null;

    /**
     * Atributo vlucroLiq
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-LUCRO-LIQUIDO", "RICCWAIS-VLUCRO-LIQ"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 9, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vlucroLiq = null;

    /**
     * Atributo vlucroNull
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-LUCRO-LIQUIDO", "RICCWAIS-VLUCRO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(001)")
    protected String vlucroNull = null;

    /**
     * Atributo vdividaBcaS
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-DIVIDA-BANCARIA", "RICCWAIS-VDIVIDA-BCA-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String vdividaBcaS = null;

    /**
     * Atributo vdividaBca
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-DIVIDA-BANCARIA", "RICCWAIS-VDIVIDA-BCA"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 12, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vdividaBca = null;

    /**
     * Atributo vdividaNull
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-DIVIDA-BANCARIA", "RICCWAIS-VDIVIDA-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(001)")
    protected String vdividaNull = null;

    /**
     * Atributo vposicaoCxS
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-POSICAO-CAIXA", "RICCWAIS-VPOSICAO-CX-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 14, maxBytes = 1, pic = "X(001)")
    protected String vposicaoCxS = null;

    /**
     * Atributo vposicaoCx
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-POSICAO-CAIXA", "RICCWAIS-VPOSICAO-CX"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 15, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vposicaoCx = null;

    /**
     * Atributo vposicaoNull
     */
    @CommareaField(name = {"RICCWAIS-REGISTRO", "RICCWAIS-POSICAO-CAIXA", "RICCWAIS-VPOSICAO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 16, maxBytes = 1, pic = "X(001)")
    protected String vposicaoNull = null;

    /**
     * Atributo filler25
     */
    protected String filler25 = null;

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
     * Propósito:  Retornar o valor de vtotFtmtS
     *
     * @return vtotFtmtS
     */
    public String getVtotFtmtS() {
        return vtotFtmtS;
    }

    /**
     * Propósito:  Atribuir valor ao vtotFtmtS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotFtmtS(String value) {
        this.vtotFtmtS = value;
    }

    /**
     * Propósito:  Retornar o valor de vtotFtmt
     *
     * @return vtotFtmt
     */
    public BigDecimal getVtotFtmt() {
        return vtotFtmt;
    }

    /**
     * Propósito:  Atribuir valor ao vtotFtmt
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVtotFtmt(BigDecimal value) {
        this.vtotFtmt = value;
    }

    /**
     * Propósito:  Retornar o valor de ftmtNull
     *
     * @return ftmtNull
     */
    public String getFtmtNull() {
        return ftmtNull;
    }

    /**
     * Propósito:  Atribuir valor ao ftmtNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFtmtNull(String value) {
        this.ftmtNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vebitdaS
     *
     * @return vebitdaS
     */
    public String getVebitdaS() {
        return vebitdaS;
    }

    /**
     * Propósito:  Atribuir valor ao vebitdaS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVebitdaS(String value) {
        this.vebitdaS = value;
    }

    /**
     * Propósito:  Retornar o valor de vebitda
     *
     * @return vebitda
     */
    public BigDecimal getVebitda() {
        return vebitda;
    }

    /**
     * Propósito:  Atribuir valor ao vebitda
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVebitda(BigDecimal value) {
        this.vebitda = value;
    }

    /**
     * Propósito:  Retornar o valor de vebitdaNull
     *
     * @return vebitdaNull
     */
    public String getVebitdaNull() {
        return vebitdaNull;
    }

    /**
     * Propósito:  Atribuir valor ao vebitdaNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVebitdaNull(String value) {
        this.vebitdaNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vlucroLiqS
     *
     * @return vlucroLiqS
     */
    public String getVlucroLiqS() {
        return vlucroLiqS;
    }

    /**
     * Propósito:  Atribuir valor ao vlucroLiqS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVlucroLiqS(String value) {
        this.vlucroLiqS = value;
    }

    /**
     * Propósito:  Retornar o valor de vlucroLiq
     *
     * @return vlucroLiq
     */
    public BigDecimal getVlucroLiq() {
        return vlucroLiq;
    }

    /**
     * Propósito:  Atribuir valor ao vlucroLiq
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVlucroLiq(BigDecimal value) {
        this.vlucroLiq = value;
    }

    /**
     * Propósito:  Retornar o valor de vlucroNull
     *
     * @return vlucroNull
     */
    public String getVlucroNull() {
        return vlucroNull;
    }

    /**
     * Propósito:  Atribuir valor ao vlucroNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVlucroNull(String value) {
        this.vlucroNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vdividaBcaS
     *
     * @return vdividaBcaS
     */
    public String getVdividaBcaS() {
        return vdividaBcaS;
    }

    /**
     * Propósito:  Atribuir valor ao vdividaBcaS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdividaBcaS(String value) {
        this.vdividaBcaS = value;
    }

    /**
     * Propósito:  Retornar o valor de vdividaBca
     *
     * @return vdividaBca
     */
    public BigDecimal getVdividaBca() {
        return vdividaBca;
    }

    /**
     * Propósito:  Atribuir valor ao vdividaBca
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdividaBca(BigDecimal value) {
        this.vdividaBca = value;
    }

    /**
     * Propósito:  Retornar o valor de vdividaNull
     *
     * @return vdividaNull
     */
    public String getVdividaNull() {
        return vdividaNull;
    }

    /**
     * Propósito:  Atribuir valor ao vdividaNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVdividaNull(String value) {
        this.vdividaNull = value;
    }

    /**
     * Propósito:  Retornar o valor de vposicaoCxS
     *
     * @return vposicaoCxS
     */
    public String getVposicaoCxS() {
        return vposicaoCxS;
    }

    /**
     * Propósito:  Atribuir valor ao vposicaoCxS
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVposicaoCxS(String value) {
        this.vposicaoCxS = value;
    }

    /**
     * Propósito:  Retornar o valor de vposicaoCx
     *
     * @return vposicaoCx
     */
    public BigDecimal getVposicaoCx() {
        return vposicaoCx;
    }

    /**
     * Propósito:  Atribuir valor ao vposicaoCx
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVposicaoCx(BigDecimal value) {
        this.vposicaoCx = value;
    }

    /**
     * Propósito:  Retornar o valor de vposicaoNull
     *
     * @return vposicaoNull
     */
    public String getVposicaoNull() {
        return vposicaoNull;
    }

    /**
     * Propósito:  Atribuir valor ao vposicaoNull
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setVposicaoNull(String value) {
        this.vposicaoNull = value;
    }

    /**
     * Propósito:  Retornar o valor de fILLER25
     *
     * @return fILLER25
     */
    public String getFILLER25() {
        return filler25;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER25
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER25(String value) {
        this.filler25 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAISResponse() {
        super();
    }
}
