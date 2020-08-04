package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.text.SimpleDateFormat;
import java.util.Date;




/**
 * Nome: TradeFinanceDesembolsoVO.java
 * 
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 29/04/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TradeFinanceDesembolsoVO {

    /** NUMERO BOLETO INCLUSAO **/
    private Long nbletonegoccmbio = 0L;

    /** DATA e HORA INCLUSAO **/
    private String hinclreg = null;
    
    /** DATA DO DESEMBOLSO **/
//    private String dprevtdsembcmbio = null;

    /** VALOR DO DESEMBOLSO **/
    private String vprevtdsembcmbio = null;

    /** LIBOR. TRAVADA **/
    private String vtxliborcmbio = null;

    /** JURO FUNDING **/
    private String ptxjurofndng = null;
    
    /** TAXA SPREAD **/
    private String pspreadtxcmbio = null;

    /** URO NEGOCIACAO (TAXA) **/
    private String pjuronegoccmbio = null;

    /** PRAZO **/
    private Integer tdiafinandsemb = null;
    
    /** VALOR DO JUROS **/
    private String vjurodsembcmbio = null;

    /** VALOR DO SAQUE **/
    private String vdsembnegoccmbio = null;
    
    /*** Atributos Auxiliares ****/
    
    private Integer seqDesembolso = 0;

    private String taxaDescontada = null;
    
    private String dataDesembolsoFormat = null;
    
    private Integer eventoForfaiting = 0;
    
    // Campo com saldo atualizado para mostrar na tela de Incluir Desembolso
    private String saldoDesembolsar = null;
    
    // Controla se a lista de desenbolso foi alterada, para liberar a baixa do saldo
    private boolean baixarSaldo = true;
    
    /**
     * VENCIMENTO DO SAQUE - FORFAITING
     */
    private Date dvctodsembcmbio = null;
    
    /**
     * DATA DE DESESEMBOLSO - FORFAITING
     */
    private Date dprevtdsembcmbio = null;
    
    /**
     * DATA DE EMBARQUE
     */
    private Date dprevtembrq = null;
    
    /**
     * MOMENTO QUE REALIZOU COBRANCA
     */
    private Integer cmomencobrcmbio = 0;
    
    public boolean isSaldoIgualZero() {
        
        if (saldoDesembolsar.equals("0,00") || saldoDesembolsar.equals("0.00")) {
            return true;
        }
        
        return false;
    }
    
    /**
     * @return o valor do dprevtdsembcmbio
     */
    public Date getDprevtdsembcmbio() {
        return dprevtdsembcmbio;
    }

    /**
     * @param dprevtdsembcmbio seta o novo valor para o campo dprevtdsembcmbio
     */
    public void setDprevtdsembcmbio(Date dprevtdsembcmbio) {
        this.dprevtdsembcmbio = dprevtdsembcmbio;
    }

    /**
     * @return o valor do vprevtdsembcmbio
     */
    public String getVprevtdsembcmbio() {
        return vprevtdsembcmbio;
    }

    /**
     * @param vprevtdsembcmbio seta o novo valor para o campo vprevtdsembcmbio
     */
    public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
        this.vprevtdsembcmbio = vprevtdsembcmbio;
    }

    /**
     * @return o valor do vtxliborcmbio
     */
    public String getVtxliborcmbio() {
        return vtxliborcmbio;
    }

    /**
     * @param vtxliborcmbio seta o novo valor para o campo vtxliborcmbio
     */
    public void setVtxliborcmbio(String vtxliborcmbio) {
        this.vtxliborcmbio = vtxliborcmbio;
    }

    /**
     * @return o valor do ptxjurofndng
     */
    public String getPtxjurofndng() {
        return ptxjurofndng;
    }

    /**
     * @param ptxjurofndng seta o novo valor para o campo ptxjurofndng
     */
    public void setPtxjurofndng(String ptxjurofndng) {
        this.ptxjurofndng = ptxjurofndng;
    }

    /**
     * @return o valor do pspreadtxcmbio
     */
    public String getPspreadtxcmbio() {
        return pspreadtxcmbio;
    }

    /**
     * @param pspreadtxcmbio seta o novo valor para o campo pspreadtxcmbio
     */
    public void setPspreadtxcmbio(String pspreadtxcmbio) {
        this.pspreadtxcmbio = pspreadtxcmbio;
    }

    /**
     * @return o valor do pjuronegoccmbio
     */
    public String getPjuronegoccmbio() {
        return pjuronegoccmbio;
    }

    /**
     * @param pjuronegoccmbio seta o novo valor para o campo pjuronegoccmbio
     */
    public void setPjuronegoccmbio(String pjuronegoccmbio) {
        this.pjuronegoccmbio = pjuronegoccmbio;
    }

    /**
     * @return o valor do tdiafinandsemb
     */
    public Integer getTdiafinandsemb() {
        return tdiafinandsemb;
    }

    /**
     * @param tdiafinandsemb seta o novo valor para o campo tdiafinandsemb
     */
    public void setTdiafinandsemb(Integer tdiafinandsemb) {
        this.tdiafinandsemb = tdiafinandsemb;
    }

    /**
     * @return o valor do vjurodsembcmbio
     */
    public String getVjurodsembcmbio() {
        return vjurodsembcmbio;
    }

    /**
     * @param vjurodsembcmbio seta o novo valor para o campo vjurodsembcmbio
     */
    public void setVjurodsembcmbio(String vjurodsembcmbio) {
        this.vjurodsembcmbio = vjurodsembcmbio;
    }

    /**
     * @return o valor do vdsembnegoccmbio
     */
    public String getVdsembnegoccmbio() {
        return vdsembnegoccmbio;
    }

    /**
     * @param vdsembnegoccmbio seta o novo valor para o campo vdsembnegoccmbio
     */
    public void setVdsembnegoccmbio(String vdsembnegoccmbio) {
        this.vdsembnegoccmbio = vdsembnegoccmbio;
    }

    /**
     * @return o valor do taxaDescontada
     */
    public String getTaxaDescontada() {
        return taxaDescontada;
    }

    /**
     * @param taxaDescontada seta o novo valor para o campo taxaDescontada
     */
    public void setTaxaDescontada(String taxaDescontada) {
        this.taxaDescontada = taxaDescontada;
    }

    /**
     * @return o valor do dataDesembolsoFormat
     */
    public String getDataDesembolsoFormat() {
        
        if (dprevtdsembcmbio != null) {

            dataDesembolsoFormat = new SimpleDateFormat("dd/MM/yyyy").format(dprevtdsembcmbio);
        }

        return dataDesembolsoFormat;
    }

    /**
     * @param dataDesembolsoFormat seta o novo valor para o campo dataDesembolsoFormat
     */
    public void setDataDesembolsoFormat(String dataDesembolsoFormat) {
        this.dataDesembolsoFormat = dataDesembolsoFormat;
    }

    /**
     * @return o valor do seqDesembolso
     */
    public Integer getSeqDesembolso() {
        return seqDesembolso;
    }

    /**
     * @param seqDesembolso seta o novo valor para o campo seqDesembolso
     */
    public void setSeqDesembolso(Integer seqDesembolso) {
        this.seqDesembolso = seqDesembolso;
    }

    /**
     * @return o valor do nbletonegoccmbio
     */
    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
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

    /**
     * @return o valor do eventoForfaiting
     */
    public Integer getEventoForfaiting() {
        return eventoForfaiting;
    }

    /**
     * @param eventoForfaiting seta o novo valor para o campo eventoForfaiting
     */
    public void setEventoForfaiting(Integer eventoForfaiting) {
        this.eventoForfaiting = eventoForfaiting;
    }

	public Date getDprevtembrq() {
		return dprevtembrq;
	}

	public void setDprevtembrq(Date dprevtembrq) {
		this.dprevtembrq = dprevtembrq;
	}

	public Date getDvctodsembcmbio() {
		return dvctodsembcmbio;
	}

	public void setDvctodsembcmbio(Date dvctodsembcmbio) {
		this.dvctodsembcmbio = dvctodsembcmbio;
	}

    /**
     * @return o valor do cmomencobrcmbio
     */
    public Integer getCmomencobrcmbio() {
        return cmomencobrcmbio;
    }

    /**
     * @param cmomencobrcmbio seta o novo valor para o campo cmomencobrcmbio
     */
    public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
        this.cmomencobrcmbio = cmomencobrcmbio;
    }

    /**
     * @return o valor do saldoDesembolsar
     */
    public String getSaldoDesembolsar() {
        return saldoDesembolsar;
    }

    /**
     * @param saldoDesembolsar seta o novo valor para o campo saldoDesembolsar
     */
    public void setSaldoDesembolsar(String saldoDesembolsar) {
        this.saldoDesembolsar = saldoDesembolsar;
    }

    /**
     * @return o valor do baixarSaldo
     */
    public boolean isBaixarSaldo() {
        return baixarSaldo;
    }

    /**
     * @param baixarSaldo seta o novo valor para o campo baixarSaldo
     */
    public void setBaixarSaldo(boolean baixarSaldo) {
        this.baixarSaldo = baixarSaldo;
    }
	
}
