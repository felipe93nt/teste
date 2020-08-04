package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

import java.util.Date;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;


public class FluxoPagamentoVO implements Comparable<FluxoPagamentoVO> {
	
	/**
	 * NUM DESEMBOLSO CAMBIO MESA TRADE
	 */
	private Integer ndsembcmbiotrade;
	
	/**
	 * DATA PREVISTA DESEMBOLSO CAMBIO
	 */
	private String dprevtdsembcmbio;
	
	/**
	 * DIA FINANCIAMENTO DESEMBOLSO CAMBIO 
	 */
	private Integer tdiafinandsemb;
	
	/**
	 * VALOR PREVISTO DESEMBOLSO CAMBIO 
	 */
	private String vprevtdsembcmbio;
	
	/**
	 *PRAZO DIA CARENCIA PARCELA CAMBIO PRINCIPAL 
	 */
	private Integer tdiacarenprinc;
	
	/**
	 *COD TIPO FLUXO LIQUIDACAO CAMBIO PRINCIPAL (PERIODICIDADE)
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
	 * TIPO DE JURO
	 */
	private String tipojuros; 
	
	/**
	 * NUMERO DA PARCELA
	 */
	private Integer npceladsembtrade;
	
	/**
	 * DATA DE VENCIMENTO DA PARCELA
	 */
	private String dvctopcelatrade;
    private Date venctoFluxDate = null;
	
	/**
	 * VALOR DA PARCELA
	 */
	private String vpcelamesatrade;
	
	/**
	 * PRAZO 
	 */
	private Integer tdianegocpcela;
	
	/**
	 * DESCRICAO MOMENTO JUROS
	 */
	private String descrmomen;
	
	/**
	 * PRAZO MEDIO DO DESEMBOLSO
	 */
	private Integer przomediodsemb;
	
	private String valorPrincipalParcelaFluxoPgto = null;
	private String valorJurosParcelaFluxoPgto = null;
	private String valorSaldoDevedorFluxoPgto = null;
	
	private List<FluxoPagamentoVO> lista;

    @Override
    public int compareTo(FluxoPagamentoVO next) {
        Date dateComparer;
        Date dateActual;
        final int EQUAL = 0;
       
        int firstComparison = 0;
        int secondComparison = getTipojuros().compareTo(next.getTipojuros());
        int finalComparison  = 0;

        dateActual = getVenctoFluxDate();
        dateComparer = next.getVenctoFluxDate();

        firstComparison = 0;
        if (dateActual.after(dateComparer)) {
            firstComparison = 1;
        }
        if (dateActual.before(dateComparer)) {
            firstComparison = -1;
        }
        // Segue a ordem de prioridade e retorna o resultado da comparação
        if (firstComparison != EQUAL) {
            finalComparison = firstComparison;
        } else {
            finalComparison = secondComparison * -1;
        }
     
      return finalComparison;
    }

    /**
     * @return o valor do ndsembcmbiotrade
     */
    public Integer getNdsembcmbiotrade() {
        return ndsembcmbiotrade;
    }

    /**
     * @param ndsembcmbiotrade seta o novo valor para o campo ndsembcmbiotrade
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
     * @param dprevtdsembcmbio seta o novo valor para o campo dprevtdsembcmbio
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
     * @param tdiafinandsemb seta o novo valor para o campo tdiafinandsemb
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
     * @param vprevtdsembcmbio seta o novo valor para o campo vprevtdsembcmbio
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
     * @param tdiacarenprinc seta o novo valor para o campo tdiacarenprinc
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
     * @param cfluxoliqdcprinc seta o novo valor para o campo cfluxoliqdcprinc
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
     * @param dfluxoliqdcprinc seta o novo valor para o campo dfluxoliqdcprinc
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
     * @param qpcelatradeprinc seta o novo valor para o campo qpcelatradeprinc
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
     * @param tdiacarenjuro seta o novo valor para o campo tdiacarenjuro
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
     * @param cfluxoliqdcjuro seta o novo valor para o campo cfluxoliqdcjuro
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
     * @param dfluxoliqdcjuro seta o novo valor para o campo dfluxoliqdcjuro
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
     * @param qpcelatradejuro seta o novo valor para o campo qpcelatradejuro
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
     * @param cmonencobrcmbio seta o novo valor para o campo cmonencobrcmbio
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
     * @param prazodiasanos seta o novo valor para o campo prazodiasanos
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
     * @param cmomencobrcmbio seta o novo valor para o campo cmomencobrcmbio
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
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    /**
     * @return o valor do tipojuros
     */
    public String getTipojuros() {
        return tipojuros;
    }

    /**
     * @param tipojuros seta o novo valor para o campo tipojuros
     */
    public void setTipojuros(String tipojuros) {
        this.tipojuros = tipojuros;
    }

    /**
     * @return o valor do npceladsembtrade
     */
    public Integer getNpceladsembtrade() {
        return npceladsembtrade;
    }

    /**
     * @param npceladsembtrade seta o novo valor para o campo npceladsembtrade
     */
    public void setNpceladsembtrade(Integer npceladsembtrade) {
        this.npceladsembtrade = npceladsembtrade;
    }

    /**
     * @return o valor do dvctopcelatrade
     */
    public String getDvctopcelatrade() {
        return dvctopcelatrade;
    }

    /**
     * @param dvctopcelatrade seta o novo valor para o campo dvctopcelatrade
     */
    public void setDvctopcelatrade(String dvctopcelatrade) {
        this.dvctopcelatrade = dvctopcelatrade;
    }

    /**
     * @return o valor do venctoFluxDate
     */
    public Date getVenctoFluxDate() {
        return venctoFluxDate;
    }

    /**
     * @param venctoFluxDate seta o novo valor para o campo venctoFluxDate
     */
    public void setVenctoFluxDate(Date venctoFluxDate) {
        this.venctoFluxDate = venctoFluxDate;
    }

    /**
     * @return o valor do vpcelamesatrade
     */
    public String getVpcelamesatrade() {
        return vpcelamesatrade;
    }

    /**
     * @param vpcelamesatrade seta o novo valor para o campo vpcelamesatrade
     */
    public void setVpcelamesatrade(String vpcelamesatrade) {
        this.vpcelamesatrade = vpcelamesatrade;
    }

    /**
     * @return o valor do tdianegocpcela
     */
    public Integer getTdianegocpcela() {
        return tdianegocpcela;
    }

    /**
     * @param tdianegocpcela seta o novo valor para o campo tdianegocpcela
     */
    public void setTdianegocpcela(Integer tdianegocpcela) {
        this.tdianegocpcela = tdianegocpcela;
    }

    /**
     * @return o valor do descrmomen
     */
    public String getDescrmomen() {
        return descrmomen;
    }

    /**
     * @param descrmomen seta o novo valor para o campo descrmomen
     */
    public void setDescrmomen(String descrmomen) {
        this.descrmomen = descrmomen;
    }

    /**
     * @return o valor do lista
     */
    public List<FluxoPagamentoVO> getLista() {
        return lista;
    }

    /**
     * @param lista seta o novo valor para o campo lista
     */
    public void setLista(List<FluxoPagamentoVO> lista) {
        this.lista = lista;
    }

    public Integer getPrzomediodsemb() {
        return przomediodsemb;
    }

    public void setPrzomediodsemb(Integer przomediodsemb) {
        this.przomediodsemb = przomediodsemb;
    }
    
    /**
     * @return o valor do valorPrincipalParcelaFluxoPgto
     */
	public String getValorPrincipalParcelaFluxoPgto() {
		return valorPrincipalParcelaFluxoPgto;
	}
	
	/**
     * @param valorPrincipalParcelaFluxoPgto seta o novo valor para o campo valorPrincipalParcelaFluxoPgto
     */
	public void setValorPrincipalParcelaFluxoPgto(String valorPrincipalParcelaFluxoPgto) {
		this.valorPrincipalParcelaFluxoPgto = valorPrincipalParcelaFluxoPgto;
	}
	
	/**
     * @return o valor do valorJurosParcelaFluxoPgto
     */
	public String getValorJurosParcelaFluxoPgto() {
		return valorJurosParcelaFluxoPgto;
	}
	
	/**
     * @param valorJurosParcelaFluxoPgto seta o novo valor para o campo valorJurosParcelaFluxoPgto
     */
	public void setValorJurosParcelaFluxoPgto(String valorJurosParcelaFluxoPgto) {
		this.valorJurosParcelaFluxoPgto = valorJurosParcelaFluxoPgto;
	}
	
	/**
     * @return o valor do valorSaldoDevedorFluxoPgto
     */
	public String getValorSaldoDevedorFluxoPgto() {
		return valorSaldoDevedorFluxoPgto;
	}
	
	/**
     * @param valorSaldoDevedorFluxoPgto seta o novo valor para o campo valorSaldoDevedorFluxoPgto
     */
	public void setValorSaldoDevedorFluxoPgto(String valorSaldoDevedorFluxoPgto) {
		this.valorSaldoDevedorFluxoPgto = valorSaldoDevedorFluxoPgto;
	}
}
