/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 31/03/2016
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

/**
 * Nome: TrdFinNegComumVO.java
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
 * Registro  de Manutenção: 31/03/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class TrdFinNegComumVO {

	private Long nbletonegoccmbio = 0L;

	private String hinclreg = null;

	private Integer nbletocmbioano = 0;

	private Integer danobase = 0;
	
	/**
     * NUMERO DA COTACAO FORMATADO
     */
    private String ncotacao;

	/** CODIGO UNICO CLIENTE */

	private Integer cdcpfcnpj = 0;

	private Integer cdfilial = 0;

	private Integer cdctrlcpfcnpj = 0;

	private Integer caditvbletocmbio = 0;

	private Long cunicclicmbio = 0L;

	private Long cpssoajurid = 0L;
	
	/**
     * CPF CNPJ FORMATADO
     */
    private String cpfCnpjFormatado;

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
	 * @return o valor do cdcpfcnpj
	 */
	public Integer getCdcpfcnpj() {
		return cdcpfcnpj;
	}

	/**
	 * @param cdcpfcnpj seta o novo valor para o campo cdcpfcnpj
	 */
	public void setCdcpfcnpj(Integer cdcpfcnpj) {
		this.cdcpfcnpj = cdcpfcnpj;
	}

	/**
	 * @return o valor do cdfilial
	 */
	public Integer getCdfilial() {
		return cdfilial;
	}

	/**
	 * @param cdfilial seta o novo valor para o campo cdfilial
	 */
	public void setCdfilial(Integer cdfilial) {
		this.cdfilial = cdfilial;
	}

	/**
	 * @return o valor do cdctrlcpfcnpj
	 */
	public Integer getCdctrlcpfcnpj() {
		return cdctrlcpfcnpj;
	}

	/**
	 * @param cdctrlcpfcnpj seta o novo valor para o campo cdctrlcpfcnpj
	 */
	public void setCdctrlcpfcnpj(Integer cdctrlcpfcnpj) {
		this.cdctrlcpfcnpj = cdctrlcpfcnpj;
	}

	/**
	 * @return o valor do caditvbletocmbio
	 */
	public Integer getCaditvbletocmbio() {
		return caditvbletocmbio;
	}

	/**
	 * @param caditvbletocmbio seta o novo valor para o campo caditvbletocmbio
	 */
	public void setCaditvbletocmbio(Integer caditvbletocmbio) {
		this.caditvbletocmbio = caditvbletocmbio;
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
	 * @return o valor do cpssoajurid
	 */
	public Long getCpssoajurid() {
		return cpssoajurid;
	}

	/**
	 * @param cpssoajurid seta o novo valor para o campo cpssoajurid
	 */
	public void setCpssoajurid(Long cpssoajurid) {
		this.cpssoajurid = cpssoajurid;
	}

    /**
     * @return o valor do cpfCnpjFormatado
     */
    public String getCpfCnpjFormatado() {
        return cpfCnpjFormatado;
    }

    /**
     * @param cpfCnpjFormatado seta o novo valor para o campo cpfCnpjFormatado
     */
    public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
        this.cpfCnpjFormatado = cpfCnpjFormatado;
    }

    /**
     * @return o valor do ncotacao
     */
    public String getNcotacao() {
        return ncotacao;
    }

    /**
     * @param ncotacao seta o novo valor para o campo ncotacao
     */
    public void setNcotacao(String ncotacao) {
        this.ncotacao = ncotacao;
    }

}
