/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 13/01/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.Date;


/**
 * Nome: TrdFinNegParcelaVO.java
 * 
 * Propósito: Área com Dados Temporários de trabalho
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 13/01/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TrdFinNegParcelaVO implements Comparable<TrdFinNegParcelaVO>, Cloneable {

	/*** dados comum nas listas ***/
	private Integer tdianegocpcela = 0;
	private String dvctopcelatrade = null;
    private Date dateVctopcelatrade = null;

	/*** Lista Parcela Fluxo Pagto ***/
	private String tpparcela = null;
	 
	private Integer npceladsembtrade = 0;
	 
	private String vencimentoFluxoPgto = null;
    private Date venctoFluxDate = null;
	 
	private String vpcelamesatrade = null;
	private String valorParcelaFluxoPgto = null;

	/*** Lista Parcela Comissao ***/
	private Integer npcelacomis = 0;
	 
	private String vencimentoComissao = null;
	 
	private String vpcelacomiscmbio = null;
	private String valorParcelaComissao = null;

	private String vcustofincrcmbio = null;

	private String pjuronegoccmbio = null;

	private Integer cperdcjurocmbio = 0;
	
	private String mensagem = null;
	
	private String valorPrincipalParcelaFluxoPgto = null;
	private String valorJurosParcelaFluxoPgto = null;
	private String valorSaldoDevedorFluxoPgto = null;
	
	@Override
    public int compareTo(TrdFinNegParcelaVO next) {
        Date dateComparer;
        Date dateActual;
        final int EQUAL = 0;
       
        int firstComparison = 0;
        int secondComparison = getTpparcela().compareTo(next.getTpparcela());
        int finalComparison  = 0;

        dateActual = getVenctoFluxDate();
        dateComparer = next.getVenctoFluxDate();
        
        if (dateActual != null && dateComparer != null && dateActual.after(dateComparer)) {
            firstComparison = 1;
        }
        
        if (dateActual != null && dateComparer != null && dateActual.before(dateComparer)) {
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
	 * @return o valor do tpparcela
	 */
	public String getTpparcela() {
		return tpparcela;
	}

	/**
	 * @param tpparcela seta o novo valor para o campo tpparcela
	 */
	public void setTpparcela(String tpparcela) {
		this.tpparcela = tpparcela;
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
	 * @return o valor do vencimentoFluxoPgto
	 */
	public String getVencimentoFluxoPgto() {
		return vencimentoFluxoPgto;
	}

	/**
	 * @param vencimentoFluxoPgto seta o novo valor para o campo vencimentoFluxoPgto
	 */
	public void setVencimentoFluxoPgto(String vencimentoFluxoPgto) {
		this.vencimentoFluxoPgto = vencimentoFluxoPgto;
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
	 * @return o valor do valorParcelaFluxoPgto
	 */
	public String getValorParcelaFluxoPgto() {
		return valorParcelaFluxoPgto;
	}

	/**
	 * @param valorParcelaFluxoPgto seta o novo valor para o campo valorParcelaFluxoPgto
	 */
	public void setValorParcelaFluxoPgto(String valorParcelaFluxoPgto) {
		this.valorParcelaFluxoPgto = valorParcelaFluxoPgto;
	}

	/**
	 * @return o valor do npcelacomis
	 */
	public Integer getNpcelacomis() {
		return npcelacomis;
	}

	/**
	 * @param npcelacomis seta o novo valor para o campo npcelacomis
	 */
	public void setNpcelacomis(Integer npcelacomis) {
		this.npcelacomis = npcelacomis;
	}

	/**
	 * @return o valor do vencimentoComissao
	 */
	public String getVencimentoComissao() {
		return vencimentoComissao;
	}

	/**
	 * @param vencimentoComissao seta o novo valor para o campo vencimentoComissao
	 */
	public void setVencimentoComissao(String vencimentoComissao) {
		this.vencimentoComissao = vencimentoComissao;
	}

	/**
	 * @return o valor do vpcelacomiscmbio
	 */
	public String getVpcelacomiscmbio() {
		return vpcelacomiscmbio;
	}

	/**
	 * @param vpcelacomiscmbio seta o novo valor para o campo vpcelacomiscmbio
	 */
	public void setVpcelacomiscmbio(String vpcelacomiscmbio) {
		this.vpcelacomiscmbio = vpcelacomiscmbio;
	}

	/**
	 * @return o valor do valorParcelaComissao
	 */
	public String getValorParcelaComissao() {
		return valorParcelaComissao;
	}

	/**
	 * @param valorParcelaComissao seta o novo valor para o campo valorParcelaComissao
	 */
	public void setValorParcelaComissao(String valorParcelaComissao) {
		this.valorParcelaComissao = valorParcelaComissao;
	}

	/**
	 * @return o valor do vcustofincrcmbio
	 */
	public String getVcustofincrcmbio() {
		return vcustofincrcmbio;
	}

	/**
	 * @param vcustofincrcmbio seta o novo valor para o campo vcustofincrcmbio
	 */
	public void setVcustofincrcmbio(String vcustofincrcmbio) {
		this.vcustofincrcmbio = vcustofincrcmbio;
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
	 * @return o valor do cperdcjurocmbio
	 */
	public Integer getCperdcjurocmbio() {
		return cperdcjurocmbio;
	}

	/**
	 * @param cperdcjurocmbio seta o novo valor para o campo cperdcjurocmbio
	 */
	public void setCperdcjurocmbio(Integer cperdcjurocmbio) {
		this.cperdcjurocmbio = cperdcjurocmbio;
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
     * @return o valor do dateVctopcelatrade
     */
    public Date getDateVctopcelatrade() {
        return dateVctopcelatrade;
    }
    /**
     * @param dateVctopcelatrade seta o novo valor para o campo dateVctopcelatrade
     */
    public void setDateVctopcelatrade(Date dateVctopcelatrade) {
        this.dateVctopcelatrade = dateVctopcelatrade;
    }
    
    /**
     * @return o valor do mensagem
     */
    public String getMensagem() {
        return mensagem;
    }
    /**
     * @param mensagem seta o novo valor para o campo mensagem
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
	
	@Override
	public TrdFinNegParcelaVO clone() throws CloneNotSupportedException {
	   return (TrdFinNegParcelaVO) super.clone();
	}
}
