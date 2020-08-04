package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

/**
  * Nome: MercadoriaVO.java
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
  * Registro  de Manutenção: 14/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class MercadoriaVO {    	
	/**
	 * NUMERO DA PARCELA MERCADORIA
	 */
	private Integer nmcadocmbiotrade;
	
	/**
	 * CODIGO DA MERCADORIA
	 */
	private Integer cmcadoopercmbio;
	
	/**
	 * DESCRICAO DA MERCADORIA
	 */
	private String rmcadoopercmbio; 
	
	/** 
	 * CODIGO DO PAIS DE ORIGEM
	 */
	private Integer cpais;   
	
	/**
	 * NOME DO PAIS DE ORIGEM
	 */
	private String ipais;   
	
	/**
	 * CODIGO DO BENEFICIARIO
	 */
	private Long cunicpssoamcado; 
	
	/**
	 * NOME DO BENEFICIARIO
	 */
	private String iunicpssoamcado;
	
	/**
	 * CODIGO DO PAIS DO BENEFICIARIO
	 */
	private Integer cpaisbnefc;      
	
	/**
	 * NOME DO PAIS DO BENEFICIARIO
	 */
	private String ipaisbnefc;    
	
	/**
	 * PREVISAO DE EMBARQUE
	 */
	private String dprevtembrq;
	
	/**
	 * DATA INICIO EMBARQUE
	 */
	private String dprevtinicembrq;
	
	/**
	 * DATA FIM EMBARQUE
	 */
	private String dprevtfimembrq;
	
	/**
	 * CODIGO PAIS EMBARQUE
	 */
	private Integer cpaisembrq;
	
	/**
	 * NOME PAIS EMBARQUE
	 */
	private String ipaisembrq;
	
	/**
	 * NUMERO DESEMBOLSO 
	 */
	private Integer ndsembcmbiotrade;
	
	/**
	 * MERCADORIA CD  SEG TRANSPORTE
	 */
	private String csegurtrnspmcado;
	
	/**
	 * MERCAD. CD. CLAUS. BENEF BRAD
	 */
	private String csegurmcadoorgnz;
	
	
	public Integer getNmcadocmbiotrade() {
		return nmcadocmbiotrade;
	}

	public void setNmcadocmbiotrade(Integer nmcadocmbiotrade) {
		this.nmcadocmbiotrade = nmcadocmbiotrade;
	}

	public Integer getCmcadoopercmbio() {
		return cmcadoopercmbio;
	}

	public void setCmcadoopercmbio(Integer cmcadoopercmbio) {
		this.cmcadoopercmbio = cmcadoopercmbio;
	}

	public String getRmcadoopercmbio() {
		return rmcadoopercmbio;
	}

	public void setRmcadoopercmbio(String rmcadoopercmbio) {
		this.rmcadoopercmbio = rmcadoopercmbio;
	}

	public Integer getCpais() {
		return cpais;
	}

	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	public String getIpais() {
		return ipais;
	}

	public void setIpais(String ipais) {
		this.ipais = ipais;
	}

	public Long getCunicpssoamcado() {
		return cunicpssoamcado;
	}

	public void setCunicpssoamcado(Long cunicpssoamcado) {
		this.cunicpssoamcado = cunicpssoamcado;
	}

	public String getIunicpssoamcado() {
		return iunicpssoamcado;
	}

	public void setIunicpssoamcado(String iunicpssoamcado) {
		this.iunicpssoamcado = iunicpssoamcado;
	}

	public Integer getCpaisbnefc() {
		return cpaisbnefc;
	}

	public void setCpaisbnefc(Integer cpaisbnefc) {
		this.cpaisbnefc = cpaisbnefc;
	}

	public String getIpaisbnefc() {
		return ipaisbnefc;
	}

	public void setIpaisbnefc(String ipaisbnefc) {
		this.ipaisbnefc = ipaisbnefc;
	}

	public String getDprevtembrq() {
		return dprevtembrq;
	}

	public void setDprevtembrq(String dprevtembrq) {
		this.dprevtembrq = dprevtembrq;
	}

	public String getDprevtinicembrq() {
		return dprevtinicembrq;
	}

	public void setDprevtinicembrq(String dprevtinicembrq) {
		this.dprevtinicembrq = dprevtinicembrq;
	}

	public String getDprevtfimembrq() {
		return dprevtfimembrq;
	}

	public void setDprevtfimembrq(String dprevtfimembrq) {
		this.dprevtfimembrq = dprevtfimembrq;
	}

	public Integer getCpaisembrq() {
		return cpaisembrq;
	}

	public void setCpaisembrq(Integer cpaisembrq) {
		this.cpaisembrq = cpaisembrq;
	}

	public String getIpaisembrq() {
		return ipaisembrq;
	}

	public void setIpaisembrq(String ipaisembrq) {
		this.ipaisembrq = ipaisembrq;
	}

	public String getCsegurtrnspmcado() {
		return csegurtrnspmcado;
	}

	public void setCsegurtrnspmcado(String csegurtrnspmcado) {
		this.csegurtrnspmcado = csegurtrnspmcado;
	}

	public String getCsegurmcadoorgnz() {
		return csegurmcadoorgnz;
	}

	public void setCsegurmcadoorgnz(String csegurmcadoorgnz) {
		this.csegurmcadoorgnz = csegurmcadoorgnz;
	}

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}

	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}
}
