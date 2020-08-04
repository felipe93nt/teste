/**
 *
 * Nome: TradeFinanceLogFiltroVO.java
 * Propï¿½sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 30/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrï¿½o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean;

import java.io.Serializable;

import br.com.bradesco.web.aq.view.components.UICalendarPeriod.CalendarPeriodDataType;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;

/**
 * Nome: TradeFinanceLogFiltroVO.java
 * Propï¿½sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 */

/** ENTRADA DE DADOS PARA PEQUISAR OS LOGS COTACAO (Entrada)*/

public class TradeFinanceLogFiltroVO implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -2715756469203028450L;
    
    /** PERIODO DE COTACAO INICIO **/
    private String periodocotacaoi = null;

    /** PERIODO DE COTACAO FIM **/
    private String periodocotacaof = null;

    /** CODIGO UNICO CLIENTE **/
    private Long cunicclicmbio = 0L;

    /** NUMERO DA COTACAO (BOLETO) **/
    private Integer nbletocmbioano = 0;

    /** CODIGO UNIDADE NEGOCIO **/
    private String nsequndorgnz = null;

    /** CODIGO USUARIO **/
    private String cusuarinclt = null;
    
    /** ANO BASE COTACAO **/  
    private Integer danobase = 0;
    
    private String unidadeCambioCombo;
    
    
    /** Variavel do tipo CalendarPeriodDataType. */
    private CalendarPeriodDataType selectedPeriodDay = null;
    
    /**
     * CNPJ
     */
    private CnpjDataType cnpj = new CnpjDataType();
    
    /**
     * CPF
     */
    private CpfDataType cpf = new CpfDataType();
    
    /**
     * NOME DO CLIENTE
     */
    private String nmcliente = null;

    

    /**
     * @return o valor do periodocotacaoi
     */
    public String getPeriodocotacaoi() {
        return periodocotacaoi;
    }

    /**
     * @param periodocotacaoi seta o novo valor para o campo periodocotacaoi
     */
    public void setPeriodocotacaoi(String periodocotacaoi) {
        this.periodocotacaoi = periodocotacaoi;
    }

    /**
     * @return o valor do periodocotacaof
     */
    public String getPeriodocotacaof() {
        return periodocotacaof;
    }

    /**
     * @param periodocotacaof seta o novo valor para o campo periodocotacaof
     */
    public void setPeriodocotacaof(String periodocotacaof) {
        this.periodocotacaof = periodocotacaof;
    }

    /**
     * @return o valor do cunicclicmbio
     */
    public Long getCunicclicmbio() {
        return cunicclicmbio;
    }

    /**
     * @param cunicclicmbio seta o novo valor para o campo cunicclicmbio
     */
    public void setCunicclicmbio(Long cunicclicmbio) {
        this.cunicclicmbio = cunicclicmbio;
    }

    /**
     * @return o valor do nbletocmbioano
     */
    public Integer getNbletocmbioano() {
        return nbletocmbioano;
    }

    /**
     * @param nbletocmbioano seta o novo valor para o campo nbletocmbioano
     */
    public void setNbletocmbioano(Integer nbletocmbioano) {
        this.nbletocmbioano = nbletocmbioano;
    }

    /**
     * @return o valor do nsequndorgnz
     */
    public String getNsequndorgnz() {
        return nsequndorgnz;
    }

    /**
     * @param nsequndorgnz seta o novo valor para o campo nsequndorgnz
     */
    public void setNsequndorgnz(String nsequndorgnz) {
        this.nsequndorgnz = nsequndorgnz;
    }

    /**
     * @return o valor do cusuarinclt
     */
    public String getCusuarinclt() {
        return cusuarinclt;
    }

    /**
     * @param cusuarinclt seta o novo valor para o campo cusuarinclt
     */
    public void setCusuarinclt(String cusuarinclt) {
        this.cusuarinclt = cusuarinclt;
    }

    /**
     * @return o valor do selectedPeriodDay
     */
    public CalendarPeriodDataType getSelectedPeriodDay() {
        return selectedPeriodDay;
    }

    /**
     * @param selectedPeriodDay seta o novo valor para o campo selectedPeriodDay
     */
    public void setSelectedPeriodDay(CalendarPeriodDataType selectedPeriodDay) {
        this.selectedPeriodDay = selectedPeriodDay;
    }

    /**
     * @return o valor do danobase
     */
    public Integer getDanobase() {
        return danobase;
    }

    /**
     * @param danobase seta o novo valor para o campo danobase
     */
    public void setDanobase(Integer danobase) {
        this.danobase = danobase;
    }

    /**
     * @return o valor do unidadeCambioCombo
     */
    public String getUnidadeCambioCombo() {
        return unidadeCambioCombo;
    }

    /**
     * @param unidadeCambioCombo seta o novo valor para o campo unidadeCambioCombo
     */
    public void setUnidadeCambioCombo(String unidadeCambioCombo) {
        this.unidadeCambioCombo = unidadeCambioCombo;
    }

    /**
     * @return o valor do cnpj
     */
    public CnpjDataType getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj seta o novo valor para o campo cnpj
     */
    public void setCnpj(CnpjDataType cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return o valor do cpf
     */
    public CpfDataType getCpf() {
        return cpf;
    }

    /**
     * @param cpf seta o novo valor para o campo cpf
     */
    public void setCpf(CpfDataType cpf) {
        this.cpf = cpf;
    }

    /**
     * @return o valor do nmcliente
     */
    public String getNmcliente() {
        return nmcliente;
    }

    /**
     * @param nmcliente seta o novo valor para o campo nmcliente
     */
    public void setNmcliente(String nmcliente) {
        this.nmcliente = nmcliente;
    }

}