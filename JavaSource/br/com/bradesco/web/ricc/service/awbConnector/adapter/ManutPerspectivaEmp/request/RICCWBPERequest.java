/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWBPERequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWBPERequest extends AnnotatedAdapter {

    /**
     * Atributo codLayout
     */
    @CommareaField(name = {"RICCWBPE-HEADER", "RICCWBPE-COD-LAYOUT"}, maxLength = 8, usage = "DISPLAY",
        fieldNumber = 0, maxBytes = 8, pic = "X(008)")
    protected String codLayout = "RICCWBPE";

    /**
     * Atributo tamLayout
     */
    @CommareaField(name = {"RICCWBPE-HEADER", "RICCWBPE-TAM-LAYOUT"}, maxLength = 5, usage = "DISPLAY",
        fieldNumber = 1, maxBytes = 5, pic = "9(005)")
    protected int tamLayout = 300;

    /**
     * Atributo nversaoOrige
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-NVERSAO-ORIGE"}, maxLength = 3, usage = "DISPLAY",
        fieldNumber = 2, maxBytes = 3, pic = "9(003)")
    protected int nversaoOrige = 0;

    /**
     * Atributo ctpoManut
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-CTPO-MANUT"}, maxLength = 1, usage = "DISPLAY",
        fieldNumber = 3, maxBytes = 1, pic = "9(001)")
    protected int ctpoManut = 0;

    /**
     * Atributo cgrpEconm
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-CGRP-ECONM"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 4, maxBytes = 9, pic = "9(009)")
    protected int cgrpEconm = 0;

    /**
     * Atributo nrelatCredt
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-NRELAT-CREDT"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 5, maxBytes = 9, pic = "9(009)")
    protected int nrelatCredt = 0;

    /**
     * Atributo nrelatSgmto
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-NRELAT-SGMTO"}, maxLength = 9, usage = "DISPLAY",
        fieldNumber = 6, maxBytes = 9, pic = "9(009)")
    protected int nrelatSgmto = 0;

    /**
     * Atributo vtotFtmtS
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-FATURAMENTO", "RICCWBPE-VTOT-FTMT-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String vtotFtmtS = null;

    /**
     * Atributo vtotFtmt
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-FATURAMENTO", "RICCWBPE-VTOT-FTMT"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vtotFtmt = null;

    /**
     * Atributo ftmtNull
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-FATURAMENTO", "RICCWBPE-FTMT-NULL"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String ftmtNull = null;

    /**
     * Atributo vebitdaS
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-EBITIDA", "RICCWBPE-VEBITDA-S"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 1, pic = "X(001)")
    protected String vebitdaS = null;

    /**
     * Atributo vebitda
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-EBITIDA", "RICCWBPE-VEBITDA"}, maxLength = 17,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vebitda = null;

    /**
     * Atributo vebitdaNull
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-EBITIDA", "RICCWBPE-VEBITDA-NULL"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 12, maxBytes = 1, pic = "X(001)")
    protected String vebitdaNull = null;

    /**
     * Atributo vlucroLiqS
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-LUCRO-LIQUIDO", "RICCWBPE-VLUCRO-LIQ-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 13, maxBytes = 1, pic = "X(001)")
    protected String vlucroLiqS = null;

    /**
     * Atributo vlucroLiq
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-LUCRO-LIQUIDO", "RICCWBPE-VLUCRO-LIQ"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 14, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vlucroLiq = null;

    /**
     * Atributo vlucroNull
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-LUCRO-LIQUIDO", "RICCWBPE-VLUCRO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 15, maxBytes = 1, pic = "X(001)")
    protected String vlucroNull = null;

    /**
     * Atributo vdividaBcaS
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-DIVIDA-BANCARIA", "RICCWBPE-VDIVIDA-BCA-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 16, maxBytes = 1, pic = "X(001)")
    protected String vdividaBcaS = null;

    /**
     * Atributo vdividaBca
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-DIVIDA-BANCARIA", "RICCWBPE-VDIVIDA-BCA"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 17, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vdividaBca = null;

    /**
     * Atributo vdividaNull
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-DIVIDA-BANCARIA", "RICCWBPE-VDIVIDA-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 18, maxBytes = 1, pic = "X(001)")
    protected String vdividaNull = null;

    /**
     * Atributo vposicaoCxS
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-POSICAO-CAIXA", "RICCWBPE-VPOSICAO-CX-S"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 19, maxBytes = 1, pic = "X(001)")
    protected String vposicaoCxS = null;

    /**
     * Atributo vposicaoCx
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-POSICAO-CAIXA", "RICCWBPE-VPOSICAO-CX"},
        maxLength = 17, usage = "DISPLAY", fieldNumber = 20, maxBytes = 17, pic = "9(015)V99")
    protected BigDecimal vposicaoCx = null;

    /**
     * Atributo vposicaoNull
     */
    @CommareaField(name = {"RICCWBPE-REGISTRO", "RICCWBPE-POSICAO-CAIXA", "RICCWBPE-VPOSICAO-NULL"},
        maxLength = 1, usage = "DISPLAY", fieldNumber = 21, maxBytes = 1, pic = "X(001)")
    protected String vposicaoNull = null;

    /**
     * Atributo filler107
     */
    protected String filler107 = null;

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
     * Propósito:  Retornar o valor de nrelatSgmto
     *
     * @return nrelatSgmto
     */
    public int getNrelatSgmto() {
        return nrelatSgmto;
    }

    /**
     * Propósito:  Atribuir valor ao nrelatSgmto
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNrelatSgmto(int value) {
        this.nrelatSgmto = value;
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
     * Propósito:  Retornar o valor de fILLER107
     *
     * @return fILLER107
     */
    public String getFILLER107() {
        return filler107;
    }

    /**
     * Propósito:  Atribuir valor ao fILLER107
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setFILLER107(String value) {
        this.filler107 = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWBPERequest() {
        super();
    }
}
