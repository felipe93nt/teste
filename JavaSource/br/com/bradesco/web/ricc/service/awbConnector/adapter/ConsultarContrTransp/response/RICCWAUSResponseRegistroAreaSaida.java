/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.response;

import java.math.BigDecimal;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;

/**
 * Nome: RICCWAUSResponseRegistroAreaSaida 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
public class RICCWAUSResponseRegistroAreaSaida extends AnnotatedAdapter {

    /**
     * Atributo ncontrEmpr
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-NCONTR-EMPR"}, maxLength = 2,
        usage = "DISPLAY", fieldNumber = 0, maxBytes = 2, pic = "9(002)")
    protected int ncontrEmpr = 0;

    /**
     * Atributo nanoContr
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-NANO-CONTR"}, maxLength = 4,
        usage = "DISPLAY", fieldNumber = 1, maxBytes = 4, pic = "9(004)")
    protected int nanoContr = 0;

    /**
     * Atributo pperformar
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PPERFORMAR"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 2, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pperformar = null;

    /**
     * Atributo pperformarN
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PPERFORMAR-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 3, maxBytes = 1, pic = "X(001)")
    protected String pperformarN = null;

    /**
     * Atributo ptakePay
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PTAKE-PAY"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 4, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ptakePay = null;

    /**
     * Atributo ptakePayN
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PTAKE-PAY-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 5, maxBytes = 1, pic = "X(001)")
    protected String ptakePayN = null;

    /**
     * Atributo plocacao
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PLOCACAO"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 6, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal plocacao = null;

    /**
     * Atributo plocacaoN
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PLOCACAO-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 7, maxBytes = 1, pic = "X(001)")
    protected String plocacaoN = null;

    /**
     * Atributo pspot
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PSPOT"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 8, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal pspot = null;

    /**
     * Atributo pspotN
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PSPOT-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 9, maxBytes = 1, pic = "X(001)")
    protected String pspotN = null;

    /**
     * Atributo ptotal
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PTOTAL"}, maxLength = 5,
        usage = "DISPLAY", fieldNumber = 10, maxBytes = 5, pic = "9(003)V99")
    protected BigDecimal ptotal = null;

    /**
     * Atributo ptotalN
     */
    @CommareaField(name = {"RICCWAUS-REGISTRO", "RICCWAUS-AREA-SAIDA", "RICCWAUS-PTOTAL-N"}, maxLength = 1,
        usage = "DISPLAY", fieldNumber = 11, maxBytes = 1, pic = "X(001)")
    protected String ptotalN = null;

    /**
     * Propósito:  Retornar o valor de ncontrEmpr
     *
     * @return ncontrEmpr
     */
    public int getNcontrEmpr() {
        return ncontrEmpr;
    }

    /**
     * Propósito:  Atribuir valor ao ncontrEmpr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNcontrEmpr(int value) {
        this.ncontrEmpr = value;
    }

    /**
     * Propósito:  Retornar o valor de nanoContr
     *
     * @return nanoContr
     */
    public int getNanoContr() {
        return nanoContr;
    }

    /**
     * Propósito:  Atribuir valor ao nanoContr
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setNanoContr(int value) {
        this.nanoContr = value;
    }

    /**
     * Propósito:  Retornar o valor de pperformar
     *
     * @return pperformar
     */
    public BigDecimal getPperformar() {
        return pperformar;
    }

    /**
     * Propósito:  Atribuir valor ao pperformar
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPperformar(BigDecimal value) {
        this.pperformar = value;
    }

    /**
     * Propósito:  Retornar o valor de pperformarN
     *
     * @return pperformarN
     */
    public String getPperformarN() {
        return pperformarN;
    }

    /**
     * Propósito:  Atribuir valor ao pperformarN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPperformarN(String value) {
        this.pperformarN = value;
    }

    /**
     * Propósito:  Retornar o valor de ptakePay
     *
     * @return ptakePay
     */
    public BigDecimal getPtakePay() {
        return ptakePay;
    }

    /**
     * Propósito:  Atribuir valor ao ptakePay
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtakePay(BigDecimal value) {
        this.ptakePay = value;
    }

    /**
     * Propósito:  Retornar o valor de ptakePayN
     *
     * @return ptakePayN
     */
    public String getPtakePayN() {
        return ptakePayN;
    }

    /**
     * Propósito:  Atribuir valor ao ptakePayN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtakePayN(String value) {
        this.ptakePayN = value;
    }

    /**
     * Propósito:  Retornar o valor de plocacao
     *
     * @return plocacao
     */
    public BigDecimal getPlocacao() {
        return plocacao;
    }

    /**
     * Propósito:  Atribuir valor ao plocacao
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPlocacao(BigDecimal value) {
        this.plocacao = value;
    }

    /**
     * Propósito:  Retornar o valor de plocacaoN
     *
     * @return plocacaoN
     */
    public String getPlocacaoN() {
        return plocacaoN;
    }

    /**
     * Propósito:  Atribuir valor ao plocacaoN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPlocacaoN(String value) {
        this.plocacaoN = value;
    }

    /**
     * Propósito:  Retornar o valor de pspot
     *
     * @return pspot
     */
    public BigDecimal getPspot() {
        return pspot;
    }

    /**
     * Propósito:  Atribuir valor ao pspot
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPspot(BigDecimal value) {
        this.pspot = value;
    }

    /**
     * Propósito:  Retornar o valor de pspotN
     *
     * @return pspotN
     */
    public String getPspotN() {
        return pspotN;
    }

    /**
     * Propósito:  Atribuir valor ao pspotN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPspotN(String value) {
        this.pspotN = value;
    }

    /**
     * Propósito:  Retornar o valor de ptotal
     *
     * @return ptotal
     */
    public BigDecimal getPtotal() {
        return ptotal;
    }

    /**
     * Propósito:  Atribuir valor ao ptotal
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtotal(BigDecimal value) {
        this.ptotal = value;
    }

    /**
     * Propósito:  Retornar o valor de ptotalN
     *
     * @return ptotalN
     */
    public String getPtotalN() {
        return ptotalN;
    }

    /**
     * Propósito:  Atribuir valor ao ptotalN
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setPtotalN(String value) {
        this.ptotalN = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public RICCWAUSResponseRegistroAreaSaida() {
        super();
    }
}
