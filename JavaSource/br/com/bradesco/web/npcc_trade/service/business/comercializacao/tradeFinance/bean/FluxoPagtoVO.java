/**
 *
 * Nome: FluxoPagtoVO.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 25/04/2016
 *   - Autor: BRQ
 *   - Responsavel: Equipe Web
 *   _ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.tradeFinance.bean;

import java.util.Date;
import java.util.List;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

/**
 *
 * Nome: FluxoPagtoVO.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ <BR>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 25/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class FluxoPagtoVO {
    
    
    private Integer seqFluxoPagto = 0;
    
    private Integer tdiaopercmbio = 0;
    
    /**
     * DATA PREVISTA DESEMBOLSO CAMBIO
     */
    private String dprevtdsembcmbio;
    private Date dateFluxoPgto = null;
    
    
    

    
 
    
    
    
    
    private Integer codPrincPeriodicidade = 0;

    private String nomePrincPeriodicidade = null;

    private Integer princQtdParcelas = 0;
    
    private Integer jurosCarencia = 0;

    private Integer codJurosPeriodicidade = 0;

    private String nomeJurosPeriodicidade = null;
    
    private Integer jurosQtdParcelas = 0;

    private Integer codJurosMomento = 0;

    private String nomeJurosMomento = null;

    private Integer przomediooperd = null;

    private String przomedioopera = null;

    private Integer przomediodsembd = null;

    private String przomediodsemba = null;

    private Integer qtdeocorrprinc = 0;

    private Integer qtdeocorrjuros = 0;
    
    

    /**
     * NUM DESEMBOLSO CAMBIO MESA TRADE
     */
    private Integer ndsembcmbiotrade;

    

    /**
     * DIA FINANCIAMENTO DESEMBOLSO CAMBIO
     */
    private Integer tdiafinandsemb;

    /**
     * VALOR PREVISTO DESEMBOLSO CAMBIO
     */
    private String vprevtdsembcmbio;

    /**
     * PRAZO DIA CARENCIA PARCELA CAMBIO PRINCIPAL
     */
    private Integer tdiacarenprinc;

    /**
     * COD TIPO FLUXO LIQUIDACAO CAMBIO PRINCIPAL (PERIODICIDADE)
     */
    private Integer cfluxoliqdcprinc;

    /**
     * DESCRICAO PERIODICIDADE PRINCIPAL
     */
    private String dfluxoliqdcprinc;

    /**
     * QTD PARCELA CAMBIO MESA TRADE PRINCIPAL
     */
    private Integer qpcelatradeprinc;

    /**
     * PRAZO DIA CARENCIA PARCELA CAMBIO JURO
     */
    private Integer tdiacarenjuro;

    /**
     * COD TIPO FLUXO LIQUIDACAO CAMBIO JUROS (PERIODICIDADE)
     */
    private Integer cfluxoliqdcjuro;

    /**
     * DESCRICAO PERIODICIDADE JUROS
     */
    private String dfluxoliqdcjuro;

    /**
     * QTD PARCELA CAMBIO MESA TRADE JURO
     */
    private Integer qpcelatradejuro;

    /**
     * COD IDENTIFICADOR MOMENTO COBRANCA CAMBIO JURO
     */
    private Integer cmonencobrcmbio;

    /**
     * VARIAVEL DE CONCATENACAO PGMTO PRAZO MEDIO(ANOS&DIAS)
     */
    private Integer prazodiasanos;

    /**
     * COD IDENTIFICADOR MOMENTO COBRANCA CAMBIO JURO
     */
    private Integer cmomencobrcmbio;

    /**
     * NUMERO DO BOLETO DA NEGOCIACAO
     */
    private Long nbletonegoccmbio;

    /**
     * DESCRICAO MOMENTO JUROS
     */
    private String descrmomen;
    
    /** 
     * NPCCWYKE-REGISTRO.NPCCWYKE-HINCL-REG"
     */
    private String hinclreg = null;

    /**
     * LISTA DE PARCELAS
     */
    private List<FluxoPagtoParcelaVO> parcelas = null;

    /**
     * @return o valor do parcelas
     */
    public List<FluxoPagtoParcelaVO> getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas
     *            seta o novo valor para o campo parcelas
     */
    public void setParcelas(List<FluxoPagtoParcelaVO> parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return o valor do ndsembcmbiotrade
     */
    public Integer getNdsembcmbiotrade() {
        return ndsembcmbiotrade;
    }

    /**
     * @param ndsembcmbiotrade
     *            seta o novo valor para o campo ndsembcmbiotrade
     */
    public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
        this.ndsembcmbiotrade = ndsembcmbiotrade;
    }

    /**
     * @return o valor do dprevtdsembcmbio
     */
    public String getDprevtdsembcmbio() {
        return dprevtdsembcmbio;
    }

    /**
     * @param dprevtdsembcmbio
     *            seta o novo valor para o campo dprevtdsembcmbio
     */
    public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }

    /**
     * @return o valor do tdiafinandsemb
     */
    public Integer getTdiafinandsemb() {
        return tdiafinandsemb;
    }

    /**
     * @param tdiafinandsemb
     *            seta o novo valor para o campo tdiafinandsemb
     */
    public void setTdiafinandsemb(Integer tdiafinandsemb) {
        this.tdiafinandsemb = tdiafinandsemb;
    }

    /**
     * @return o valor do vprevtdsembcmbio
     */
    public String getVprevtdsembcmbio() {
        return vprevtdsembcmbio;
    }

    /**
     * @param vprevtdsembcmbio
     *            seta o novo valor para o campo vprevtdsembcmbio
     */
    public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
        this.vprevtdsembcmbio = vprevtdsembcmbio;
    }

    /**
     * @return o valor do tdiacarenprinc
     */
    public Integer getTdiacarenprinc() {
        return tdiacarenprinc;
    }

    /**
     * @param tdiacarenprinc
     *            seta o novo valor para o campo tdiacarenprinc
     */
    public void setTdiacarenprinc(Integer tdiacarenprinc) {
        this.tdiacarenprinc = tdiacarenprinc;
    }

    /**
     * @return o valor do cfluxoliqdcprinc
     */
    public Integer getCfluxoliqdcprinc() {
        return cfluxoliqdcprinc;
    }

    /**
     * @param cfluxoliqdcprinc
     *            seta o novo valor para o campo cfluxoliqdcprinc
     */
    public void setCfluxoliqdcprinc(Integer cfluxoliqdcprinc) {
        this.cfluxoliqdcprinc = cfluxoliqdcprinc;
    }

    /**
     * @return o valor do dfluxoliqdcprinc
     */
    public String getDfluxoliqdcprinc() {
        return dfluxoliqdcprinc;
    }

    /**
     * @param dfluxoliqdcprinc
     *            seta o novo valor para o campo dfluxoliqdcprinc
     */
    public void setDfluxoliqdcprinc(String dfluxoliqdcprinc) {
        this.dfluxoliqdcprinc = dfluxoliqdcprinc;
    }

    /**
     * @return o valor do qpcelatradeprinc
     */
    public Integer getQpcelatradeprinc() {
        return qpcelatradeprinc;
    }

    /**
     * @param qpcelatradeprinc
     *            seta o novo valor para o campo qpcelatradeprinc
     */
    public void setQpcelatradeprinc(Integer qpcelatradeprinc) {
        this.qpcelatradeprinc = qpcelatradeprinc;
    }

    /**
     * @return o valor do tdiacarenjuro
     */
    public Integer getTdiacarenjuro() {
        return tdiacarenjuro;
    }

    /**
     * @param tdiacarenjuro
     *            seta o novo valor para o campo tdiacarenjuro
     */
    public void setTdiacarenjuro(Integer tdiacarenjuro) {
        this.tdiacarenjuro = tdiacarenjuro;
    }

    /**
     * @return o valor do cfluxoliqdcjuro
     */
    public Integer getCfluxoliqdcjuro() {
        return cfluxoliqdcjuro;
    }

    /**
     * @param cfluxoliqdcjuro
     *            seta o novo valor para o campo cfluxoliqdcjuro
     */
    public void setCfluxoliqdcjuro(Integer cfluxoliqdcjuro) {
        this.cfluxoliqdcjuro = cfluxoliqdcjuro;
    }

    /**
     * @return o valor do dfluxoliqdcjuro
     */
    public String getDfluxoliqdcjuro() {
        return dfluxoliqdcjuro;
    }

    /**
     * @param dfluxoliqdcjuro
     *            seta o novo valor para o campo dfluxoliqdcjuro
     */
    public void setDfluxoliqdcjuro(String dfluxoliqdcjuro) {
        this.dfluxoliqdcjuro = dfluxoliqdcjuro;
    }

    /**
     * @return o valor do qpcelatradejuro
     */
    public Integer getQpcelatradejuro() {
        return qpcelatradejuro;
    }

    /**
     * @param qpcelatradejuro
     *            seta o novo valor para o campo qpcelatradejuro
     */
    public void setQpcelatradejuro(Integer qpcelatradejuro) {
        this.qpcelatradejuro = qpcelatradejuro;
    }

    /**
     * @return o valor do cmonencobrcmbio
     */
    public Integer getCmonencobrcmbio() {
        return cmonencobrcmbio;
    }

    /**
     * @param cmonencobrcmbio
     *            seta o novo valor para o campo cmonencobrcmbio
     */
    public void setCmonencobrcmbio(Integer cmonencobrcmbio) {
        this.cmonencobrcmbio = cmonencobrcmbio;
    }

    /**
     * @return o valor do prazodiasanos
     */
    public Integer getPrazodiasanos() {
        return prazodiasanos;
    }

    /**
     * @param prazodiasanos
     *            seta o novo valor para o campo prazodiasanos
     */
    public void setPrazodiasanos(Integer prazodiasanos) {
        this.prazodiasanos = prazodiasanos;
    }

    /**
     * @return o valor do cmomencobrcmbio
     */
    public Integer getCmomencobrcmbio() {
        return cmomencobrcmbio;
    }

    /**
     * @param cmomencobrcmbio
     *            seta o novo valor para o campo cmomencobrcmbio
     */
    public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
        this.cmomencobrcmbio = cmomencobrcmbio;
    }

    /**
     * @return o valor do nbletonegoccmbio
     */
    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio
     *            seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    /**
     * @return o valor do descrmomen
     */
    public String getDescrmomen() {
        return descrmomen;
    }

    /**
     * @param descrmomen
     *            seta o novo valor para o campo descrmomen
     */
    public void setDescrmomen(String descrmomen) {
        this.descrmomen = descrmomen;
    }

    /**
     * @return o valor do hinclreg
     */
    public String getHinclreg() {
        return hinclreg;
    }

    /**
     * @param hinclreg seta o novo valor para o campo hinclreg
     */
    public void setHinclreg(String hinclreg) {
        this.hinclreg = hinclreg;
    }

}
