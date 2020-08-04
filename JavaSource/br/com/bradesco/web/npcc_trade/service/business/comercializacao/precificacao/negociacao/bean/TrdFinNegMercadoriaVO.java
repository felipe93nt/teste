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
 * Nome: ClienteSelecaoVO.java
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
public class TrdFinNegMercadoriaVO {

    /***************  Tela Principal  **************/
	private Integer tipoPesquisaMercadoria = 0;

	private Integer ndsembcmbiotrade = 0;

	private Integer cpais = 0;
	private String nomeCpais = "";

	private Long cunicpssoamcado = 0L;

	private Integer cpaisbnefc = 0;
	private String nomeCpaisbnefc = "";

	private Date dprevtembrq = null;
	private String dataPrevEmbFormat = "";
	
	private Integer nmcadocmbiotrade;

	/***************  Tela Modal Selecionar Mercadoria  **************/

	private Integer cmcadoopercmbio = 0;

	private String rmcadoopercmbio = null;

	private Long cmcadocmbiomcsul = 0L;

	private String ringlsmcadocmbio = null;

	private String cindcdlicenmcado = null;

	private String cmcadorestcmbio = null;

	private Integer ntpositcmbio = 0;

	private String rjustfsitcmbio = null;

	private String cusuarincl = null;

	private String hinclreg = null;

	private String cusuarmanut = null;

	private String hmanutreg = null;
   
    /***************  Tela Modal Selecionar Beneficiário  **************/
	private Integer tipoPesquisaBeneficiario = 0;

	private Long cunicpssoacmbio = 0L;

	private String ipssoacmbio = null;

	private String iredzdpssoacmbio = null;

	private String iciddeender = null;

	private String ipaiscoplt = null;

	/** CODIGO DO PAIS DE EMBARQUE **/
	private Integer cpaisembrq = 0;
	
	/** NOME DO PAIS DE EMBARQUE **/
	private String nomePaisEmbrq;
	
	/** NUMERO DE EMBARQUES - LC IMPORT **/
	private Integer qprevtembrqcmbio = 0;
	
	/**
	 * @return o valor do tipoPesquisaMercadoria
	 */
	public Integer getTipoPesquisaMercadoria() {
		return tipoPesquisaMercadoria;
	}

	/**
	 * @param tipoPesquisaMercadoria seta o novo valor para o campo tipoPesquisaMercadoria
	 */
	public void setTipoPesquisaMercadoria(Integer tipoPesquisaMercadoria) {
		this.tipoPesquisaMercadoria = tipoPesquisaMercadoria;
	}

	/**
	 * @return o valor do cmcadoopercmbio
	 */
	public Integer getCmcadoopercmbio() {
		return cmcadoopercmbio;
	}

	/**
	 * @param cmcadoopercmbio seta o novo valor para o campo cmcadoopercmbio
	 */
	public void setCmcadoopercmbio(Integer cmcadoopercmbio) {
		this.cmcadoopercmbio = cmcadoopercmbio;
	}

	/**
	 * @return o valor do rmcadoopercmbio
	 */
	public String getRmcadoopercmbio() {
		return rmcadoopercmbio;
	}

	/**
	 * @param rmcadoopercmbio seta o novo valor para o campo rmcadoopercmbio
	 */
	public void setRmcadoopercmbio(String rmcadoopercmbio) {
		this.rmcadoopercmbio = rmcadoopercmbio;
	}

	/**
	 * @return o valor do cmcadocmbiomcsul
	 */
	public Long getCmcadocmbiomcsul() {
		return cmcadocmbiomcsul;
	}

	/**
	 * @param cmcadocmbiomcsul seta o novo valor para o campo cmcadocmbiomcsul
	 */
	public void setCmcadocmbiomcsul(Long cmcadocmbiomcsul) {
		this.cmcadocmbiomcsul = cmcadocmbiomcsul;
	}

	/**
	 * @return o valor do ringlsmcadocmbio
	 */
	public String getRinglsmcadocmbio() {
		return ringlsmcadocmbio;
	}

	/**
	 * @param ringlsmcadocmbio seta o novo valor para o campo ringlsmcadocmbio
	 */
	public void setRinglsmcadocmbio(String ringlsmcadocmbio) {
		this.ringlsmcadocmbio = ringlsmcadocmbio;
	}

	/**
	 * @return o valor do cindcdlicenmcado
	 */
	public String getCindcdlicenmcado() {
		return cindcdlicenmcado;
	}

	/**
	 * @param cindcdlicenmcado seta o novo valor para o campo cindcdlicenmcado
	 */
	public void setCindcdlicenmcado(String cindcdlicenmcado) {
		this.cindcdlicenmcado = cindcdlicenmcado;
	}

	/**
	 * @return o valor do cmcadorestcmbio
	 */
	public String getCmcadorestcmbio() {
		return cmcadorestcmbio;
	}

	/**
	 * @param cmcadorestcmbio seta o novo valor para o campo cmcadorestcmbio
	 */
	public void setCmcadorestcmbio(String cmcadorestcmbio) {
		this.cmcadorestcmbio = cmcadorestcmbio;
	}

	/**
	 * @return o valor do ntpositcmbio
	 */
	public Integer getNtpositcmbio() {
		return ntpositcmbio;
	}

	/**
	 * @param ntpositcmbio seta o novo valor para o campo ntpositcmbio
	 */
	public void setNtpositcmbio(Integer ntpositcmbio) {
		this.ntpositcmbio = ntpositcmbio;
	}

	/**
	 * @return o valor do rjustfsitcmbio
	 */
	public String getRjustfsitcmbio() {
		return rjustfsitcmbio;
	}

	/**
	 * @param rjustfsitcmbio seta o novo valor para o campo rjustfsitcmbio
	 */
	public void setRjustfsitcmbio(String rjustfsitcmbio) {
		this.rjustfsitcmbio = rjustfsitcmbio;
	}

	/**
	 * @return o valor do cusuarincl
	 */
	public String getCusuarincl() {
		return cusuarincl;
	}

	/**
	 * @param cusuarincl seta o novo valor para o campo cusuarincl
	 */
	public void setCusuarincl(String cusuarincl) {
		this.cusuarincl = cusuarincl;
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
	 * @return o valor do cusuarmanut
	 */
	public String getCusuarmanut() {
		return cusuarmanut;
	}

	/**
	 * @param cusuarmanut seta o novo valor para o campo cusuarmanut
	 */
	public void setCusuarmanut(String cusuarmanut) {
		this.cusuarmanut = cusuarmanut;
	}

	/**
	 * @return o valor do hmanutreg
	 */
	public String getHmanutreg() {
		return hmanutreg;
	}

	/**
	 * @param hmanutreg seta o novo valor para o campo hmanutreg
	 */
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	/**
	 * @return o valor do tipoPesquisaBeneficiario
	 */
	public Integer getTipoPesquisaBeneficiario() {
		return tipoPesquisaBeneficiario;
	}

	/**
	 * @param tipoPesquisaBeneficiario seta o novo valor para o campo tipoPesquisaBeneficiario
	 */
	public void setTipoPesquisaBeneficiario(Integer tipoPesquisaBeneficiario) {
		this.tipoPesquisaBeneficiario = tipoPesquisaBeneficiario;
	}

	/**
	 * @return o valor do cunicpssoacmbio
	 */
	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}

	/**
	 * @param cunicpssoacmbio seta o novo valor para o campo cunicpssoacmbio
	 */
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	/**
	 * @return o valor do ipssoacmbio
	 */
	public String getIpssoacmbio() {
		return ipssoacmbio;
	}

	/**
	 * @param ipssoacmbio seta o novo valor para o campo ipssoacmbio
	 */
	public void setIpssoacmbio(String ipssoacmbio) {
		this.ipssoacmbio = ipssoacmbio;
	}

	/**
	 * @return o valor do iredzdpssoacmbio
	 */
	public String getIredzdpssoacmbio() {
		return iredzdpssoacmbio;
	}

	/**
	 * @param iredzdpssoacmbio seta o novo valor para o campo iredzdpssoacmbio
	 */
	public void setIredzdpssoacmbio(String iredzdpssoacmbio) {
		this.iredzdpssoacmbio = iredzdpssoacmbio;
	}

	/**
	 * @return o valor do iciddeender
	 */
	public String getIciddeender() {
		return iciddeender;
	}

	/**
	 * @param iciddeender seta o novo valor para o campo iciddeender
	 */
	public void setIciddeender(String iciddeender) {
		this.iciddeender = iciddeender;
	}

	/**
	 * @return o valor do ipaiscoplt
	 */
	public String getIpaiscoplt() {
		return ipaiscoplt;
	}

	/**
	 * @param ipaiscoplt seta o novo valor para o campo ipaiscoplt
	 */
	public void setIpaiscoplt(String ipaiscoplt) {
		this.ipaiscoplt = ipaiscoplt;
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
	 * @return o valor do cpais
	 */
	public Integer getCpais() {
		return cpais;
	}

	/**
	 * @param cpais seta o novo valor para o campo cpais
	 */
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	/**
	 * @return o valor do cunicpssoamcado
	 */
	public Long getCunicpssoamcado() {
		return cunicpssoamcado;
	}

	/**
	 * @param cunicpssoamcado seta o novo valor para o campo cunicpssoamcado
	 */
	public void setCunicpssoamcado(Long cunicpssoamcado) {
		this.cunicpssoamcado = cunicpssoamcado;
	}

	/**
	 * @return o valor do cpaisbnefc
	 */
	public Integer getCpaisbnefc() {
		return cpaisbnefc;
	}

	/**
	 * @param cpaisbnefc seta o novo valor para o campo cpaisbnefc
	 */
	public void setCpaisbnefc(Integer cpaisbnefc) {
		this.cpaisbnefc = cpaisbnefc;
	}

	/**
	 * @return o valor do dprevtembrq
	 */
	public Date getDprevtembrq() {
		return dprevtembrq;
	}

	/**
	 * @param dprevtembrq seta o novo valor para o campo dprevtembrq
	 */
	public void setDprevtembrq(Date dprevtembrq) {
		this.dprevtembrq = dprevtembrq;
	}

	/**
	 * @return o valor do nomeCpais
	 */
	public String getNomeCpais() {
		return nomeCpais;
	}

	/**
	 * @param nomeCpais seta o novo valor para o campo nomeCpais
	 */
	public void setNomeCpais(String nomeCpais) {
		this.nomeCpais = nomeCpais;
	}

	/**
	 * @return o valor do nomeCpaisbnefc
	 */
	public String getNomeCpaisbnefc() {
		return nomeCpaisbnefc;
	}

	/**
	 * @param nomeCpaisbnefc seta o novo valor para o campo nomeCpaisbnefc
	 */
	public void setNomeCpaisbnefc(String nomeCpaisbnefc) {
		this.nomeCpaisbnefc = nomeCpaisbnefc;
	}

	/**
	 * @return o valor do dataPrevEmbFormat
	 */
	public String getDataPrevEmbFormat() {
		return dataPrevEmbFormat;
	}

	/**
	 * @param dataPrevEmbFormat seta o novo valor para o campo dataPrevEmbFormat
	 */
	public void setDataPrevEmbFormat(String dataPrevEmbFormat) {
		this.dataPrevEmbFormat = dataPrevEmbFormat;
	}

    /**
     * @return o valor do nmcadocmbiotrade
     */
    public Integer getNmcadocmbiotrade() {
        return nmcadocmbiotrade;
    }

    /**
     * @param nmcadocmbiotrade seta o novo valor para o campo nmcadocmbiotrade
     */
    public void setNmcadocmbiotrade(Integer nmcadocmbiotrade) {
        this.nmcadocmbiotrade = nmcadocmbiotrade;
    }

    public Integer getCpaisembrq() {
        return cpaisembrq;
    }

    public void setCpaisembrq(Integer cpaisembrq) {
        this.cpaisembrq = cpaisembrq;
    }

    public String getNomePaisEmbrq() {
        return nomePaisEmbrq;
    }

    public void setNomePaisEmbrq(String nomePaisEmbrq) {
        this.nomePaisEmbrq = nomePaisEmbrq;
    }

    public Integer getQprevtembrqcmbio() {
        return qprevtembrqcmbio;
    }

    public void setQprevtembrqcmbio(Integer qprevtembrqcmbio) {
        this.qprevtembrqcmbio = qprevtembrqcmbio;
    }
 
}
