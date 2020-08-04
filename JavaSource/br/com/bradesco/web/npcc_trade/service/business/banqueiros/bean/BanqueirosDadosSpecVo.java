/**
 *
 * Nome: BanqueirosDadosSpecVo.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 09/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean;

import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;
//import br.com.bradesco.web.npcd.utils.SiteUtil;
//import br.com.bradesco.web.npcd.utils.enums.EnumSimNao;
//import br.com.bradesco.web.npcd.utils.enums.EnumSimNaoStr;
//import br.com.bradesco.web.npcd.utils.enums.EnumSituacaoAtivoInativo;
//import br.com.bradesco.web.npcd.utils.enums.EnumTipoConta;
//import br.com.bradesco.web.npcd.utils.enums.EnumTipoManutencao;
//import br.com.bradesco.web.npcd.utils.enums.EnumTipoUnidade;

/**
 *
 * Nome: BanqueirosDadosSpecVo.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 09/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class BanqueirosDadosSpecVo extends BaseVO implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 6488059104894970449L;

//	/** Variavel do tipo EnumTipoManutencao. */
//	private EnumTipoManutencao tipoManutencao = EnumTipoManutencao.DEFAULT;
//
//	/** Variavel do tipo EnumTipoConta. */
//	private EnumTipoConta tipoConta = null;
//
//	/** Fearful do tipo EnumTipoUnidade. */
//	private EnumTipoUnidade tipoUnidade = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao prioridade = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao ipssoapoltcexpsi = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao iindcdbanqrcorsp = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao itrocamsgemswift = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao iindcdbanqrscrtz = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao ibanqrscrtzprinc = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao iindcdconvecmbio = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao intpositcmbio = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao icindcdpapeloper = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao icindcdpapelativo = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNao icindcdbloqueado = null;
//
//	/** Variavel do tipo EnumSimNao. */
//	private EnumSimNaoStr ibanqrhedge = null;
//
//	/** Variavel do tipo EnumSituacaoAtivoInativo. */
//	private EnumSituacaoAtivoInativo isituacaoativoinativo = null;

	// Campos Lista Inicial
	/** Variavel do tipo String. */
	private String cidbanqrswift = null;

	/** Variavel do tipo String. */
	private String cflialbanqrswift = null;

	/** Variavel do tipo String. */
	private String catulzbanqrswift = null;

	/** Variavel do tipo String. */
	private String ibanqrcmbioswift = null;

	/** Variavel do tipo String. */
	private String rtpoestrtswift = null;

	/** Variavel do tipo String. */
	private String ebanqrcmbioswift = null;

	/** Variavel do tipo Long. */
	private Long cbanqrcmbio = null;

	/** Variavel do tipo String. */
	private String ibanqrcmbio = null;

	/** Variavel do tipo String. */
	private String ipais = null;

	// Campos Conta.

	/** Variavel do tipo String. */
	private String cctabanqrexter = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdeconmmoeda = null;

	/** Variavel do tipo String. */
	private String cutilzctabanqr = null;

	/** Variavel do tipo Integer. */
	private Integer ntpositcmbio = null;

	/** Variavel do tipo String. */
	private String rjustfsitcmbio = null;

	/** Variavel do tipo String. */
	private String iindcdeconmmoeda;

	/** Variavel do tipo Integer. */
	private Integer nctabanqrexter = null;

	/** Variavel do tipo String. */
	private String isglindcdfonte = null;

	/** Variavel do tipo String. */
	private String cindcdfontecons = null;

	// Campos Clearing.

	/** Variavel do tipo Integer. */
	private Integer ccmaracompeexter = null;

	/** Variavel do tipo String. */
	private String icmaracompeexter = null;

	/** Variavel do tipo String. */
	private String cexterbanqrcmara = null;

	/** Variavel do tipo String. */
	private Integer ccmaracompeprior = null;

	// Campos Endereço.

	/** Variavel do tipo Integer. */
	private Integer cpais = null;

	/** Variavel do tipo String. */
	private String cpstalexterzip = null;

	/** Variavel do tipo Integer. */
	private Integer ccep = null;

	/** Variavel do tipo String. */
	private String ccepText = null;

	/** Variavel do tipo Integer. */
	private Integer ccepcompl = null;

	/** Variavel do tipo String. */
	private String ccepcomplText = null;

	/** Variavel do tipo String. */
	private String elogdrpssoa = null;

	/** Variavel do tipo String. */
	private String elogdrnro = null;

	/** Variavel do tipo String. */
	private String rcomplender = null;

	/** Variavel do tipo String. */
	private String ebairoender = null;

	/** Variavel do tipo Long. */
	private Long cmunintlcmbio = null;

	/** Variavel do tipo Long. */
	private String imunintlcmbio = null;

	/** Variavel do tipo String. */
	private String iestendercmbio = null;

	/** Variavel do tipo String. */
	private String cddifone = null;

	/** Variavel do tipo String. */
	private String cdddfone = null;

	/** Variavel do tipo Long. */
	private Long nlintfonireft = null;

	/** Variavel do tipo String. */
	private String coduf = null;

	/** Variavel do tipo String. */
	private String icoduf = null;

	/** Variavel do tipo Integer. */
	private Integer nenderpssoacmbio = null;

	/** Variavel do tipo Integer. */
	private Integer ncntatpssoacmbio = null;

	// Lista Aprovação / Revisão

	/** Variavel do tipo String. */
	private String cdpais = null;

	/** Variavel do tipo String. */
	private String nomepais = null;

	/** Variavel do tipo String. */
	private String imun = null;

	/** Variavel do tipo Integer. */
	private Integer ctrocamsgemswift = null;

	// Lista Revisão

	/** Variavel do tipo String. */
	private String cusuaranlse = null;

	/** Variavel do tipo String. */
	private String iusuaranlse = null;

	/** Variavel do tipo String. */
	private String hanlsereg = null;

	// Lista Motivos / Bloqueio

	/** Variavel do tipo Integer. */
	private Integer ntpomotvoblqe = null;

	/** Variavel do tipo String. */
	private String rtpomotvoblqe = null;

	/** Variavel do tipo Integer. */
	private Integer ntpomotvodstv = null;

	/** Variavel do tipo String. */
	private String rtpomotvodstv = null;

	/** Variavel do tipo String. */
	private String cintlidfincr = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdbanqrcorsp = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdpapeloper = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdbloqueado = null;

	/** Variavel do tipo String. */
	private String rjustfinoprcmbio = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdpapelativo = null;

	/** Variavel do tipo String. */
	private String rjustfinatvcmbio = null;

	/** Variavel do tipo Integer. */
	private Integer ccpfcnpj = null;

	/** Variavel do tipo Integer. */
	private Integer cflialcnpj = null;

	/** Variavel do tipo Integer. */
	private Integer cctrlcpfcnpj = null;

	/** Variavel do tipo String. */
	private String rtpomotvorest = null;

	/** Variavel do tipo Integer. */
	private Integer ntpopapelcmbio = null;

	/** Variavel do tipo Integer. */
	private Integer ntpomotvorest = null;

	/** Variavel do tipo String. */
	private String iidtfdnvelrest = null;

	/** Variavel do tipo Integer. */
	private Integer cidtfdnvelrest = null;

	/** Variavel do tipo String. */
	private String itpositcmbio = null;

	/** Variavel do tipo Integer. */
	private Integer banqrcambio = null;

	/** Variavel do tipo String. */
	private String idclub = null;

	/** Variavel do tipo Long. */
	private Long cdclub = null;

	/** Variavel do tipo Long. */
	private Long cdempresa = null;

	/** Variavel do tipo Integer. */
	private Integer cdcpfcnpj = null;

	/** Variavel do tipo Integer. */
	private Integer cdfilial = null;

	/** Variavel do tipo Integer. */
	private Integer cdctrlcpfcnpj = null;

	/** Variavel do tipo String. */
	private String nmnomecliente = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdaprovreg = null;

	/** Variavel do tipo String. */
	private String rrejeiclibanqr = null;

	/** Variavel do tipo Long. */
	private Long cpssoa = null;

	/** Variavel do tipo String. */
	private String eciddebanqrswift = null;

	/** Variavel do tipo String. */
	private String ipaisbanqrswift = null;

	/** Variavel do tipo String. */
	private String descmanut = null;

	/** Variavel do tipo String. */
	private String teladetalhe = null;

	/**
	 * Método construtor da classe.
	 */
	public BanqueirosDadosSpecVo() {
		super();

	}

//	/**
//	 * @return o valor do tipoManutencao
//	 */
//	public EnumTipoManutencao getTipoManutencao() {
//		return tipoManutencao;
//	}

//	/**
//	 * @param tipoManutencao
//	 *            seta o novo valor para o campo tipoManutencao
//	 */
//	public void setTipoManutencao(EnumTipoManutencao tipoManutencao) {
//		this.tipoManutencao = tipoManutencao;
//	}
//
//	/**
//	 * @return o valor do tipoConta
//	 */
//	public EnumTipoConta getTipoConta() {
//		return tipoConta;
//	}
//
//	/**
//	 * @param tipoConta
//	 *            seta o novo valor para o campo tipoConta
//	 */
//	public void setTipoConta(EnumTipoConta tipoConta) {
//		this.tipoConta = tipoConta;
//	}
//
//	/**
//	 * @return o valor do tipoUnidade
//	 */
//	public EnumTipoUnidade getTipoUnidade() {
//		return tipoUnidade;
//	}
//
//	/**
//	 * @param tipoUnidade
//	 *            seta o novo valor para o campo tipoUnidade
//	 */
//	public void setTipoUnidade(EnumTipoUnidade tipoUnidade) {
//		this.tipoUnidade = tipoUnidade;
//	}
//
//	/**
//	 * @return o valor do prioridade
//	 */
//	public EnumSimNao getPrioridade() {
//		return prioridade;
//	}
//
//	/**
//	 * @param prioridade
//	 *            seta o novo valor para o campo prioridade
//	 */
//	public void setPrioridade(EnumSimNao prioridade) {
//		this.prioridade = prioridade;
//	}
//
//	/**
//	 * @return o valor do ipssoapoltcexpsi
//	 */
//	public EnumSimNao getIpssoapoltcexpsi() {
//		return ipssoapoltcexpsi;
//	}
//
//	/**
//	 * @param ipssoapoltcexpsi
//	 *            seta o novo valor para o campo ipssoapoltcexpsi
//	 */
//	public void setIpssoapoltcexpsi(EnumSimNao ipssoapoltcexpsi) {
//		this.ipssoapoltcexpsi = ipssoapoltcexpsi;
//	}
//
//	/**
//	 * @return o valor do iindcdbanqrcorsp
//	 */
//	public EnumSimNao getIindcdbanqrcorsp() {
//		return iindcdbanqrcorsp;
//	}
//
//	/**
//	 * @param iindcdbanqrcorsp
//	 *            seta o novo valor para o campo iindcdbanqrcorsp
//	 */
//	public void setIindcdbanqrcorsp(EnumSimNao iindcdbanqrcorsp) {
//		this.iindcdbanqrcorsp = iindcdbanqrcorsp;
//	}
//
//	/**
//	 * @return o valor do itrocamsgemswift
//	 */
//	public EnumSimNao getItrocamsgemswift() {
//		return itrocamsgemswift;
//	}
//
//	/**
//	 * @param itrocamsgemswift
//	 *            seta o novo valor para o campo itrocamsgemswift
//	 */
//	public void setItrocamsgemswift(EnumSimNao itrocamsgemswift) {
//		this.itrocamsgemswift = itrocamsgemswift;
//	}
//
//	/**
//	 * @return o valor do iindcdbanqrscrtz
//	 */
//	public EnumSimNao getIindcdbanqrscrtz() {
//		return iindcdbanqrscrtz;
//	}
//
//	/**
//	 * @param iindcdbanqrscrtz
//	 *            seta o novo valor para o campo iindcdbanqrscrtz
//	 */
//	public void setIindcdbanqrscrtz(EnumSimNao iindcdbanqrscrtz) {
//		this.iindcdbanqrscrtz = iindcdbanqrscrtz;
//	}
//
//	/**
//	 * @return o valor do ibanqrscrtzprinc
//	 */
//	public EnumSimNao getIbanqrscrtzprinc() {
//		return ibanqrscrtzprinc;
//	}
//
//	/**
//	 * @param ibanqrscrtzprinc
//	 *            seta o novo valor para o campo ibanqrscrtzprinc
//	 */
//	public void setIbanqrscrtzprinc(EnumSimNao ibanqrscrtzprinc) {
//		this.ibanqrscrtzprinc = ibanqrscrtzprinc;
//	}
//
//	/**
//	 * @return o valor do iindcdconvecmbio
//	 */
//	public EnumSimNao getIindcdconvecmbio() {
//		return iindcdconvecmbio;
//	}
//
//	/**
//	 * @param iindcdconvecmbio
//	 *            seta o novo valor para o campo iindcdconvecmbio
//	 */
//	public void setIindcdconvecmbio(EnumSimNao iindcdconvecmbio) {
//		this.iindcdconvecmbio = iindcdconvecmbio;
//	}
//
//	/**
//	 * @return o valor do intpositcmbio
//	 */
//	public EnumSimNao getIntpositcmbio() {
//		return intpositcmbio;
//	}
//
//	/**
//	 * @param intpositcmbio
//	 *            seta o novo valor para o campo intpositcmbio
//	 */
//	public void setIntpositcmbio(EnumSimNao intpositcmbio) {
//		this.intpositcmbio = intpositcmbio;
//	}
//
//	/**
//	 * @return o valor do icindcdpapeloper
//	 */
//	public EnumSimNao getIcindcdpapeloper() {
//		return icindcdpapeloper;
//	}
//
//	/**
//	 * @param icindcdpapeloper
//	 *            seta o novo valor para o campo icindcdpapeloper
//	 */
//	public void setIcindcdpapeloper(EnumSimNao icindcdpapeloper) {
//		this.icindcdpapeloper = icindcdpapeloper;
//	}
//
//	/**
//	 * @return o valor do icindcdpapelativo
//	 */
//	public EnumSimNao getIcindcdpapelativo() {
//		return icindcdpapelativo;
//	}
//
//	/**
//	 * @param icindcdpapelativo
//	 *            seta o novo valor para o campo icindcdpapelativo
//	 */
//	public void setIcindcdpapelativo(EnumSimNao icindcdpapelativo) {
//		this.icindcdpapelativo = icindcdpapelativo;
//	}

	/**
	 * @return o valor do cidbanqrswift
	 */
	public String getCidbanqrswift() {
		return cidbanqrswift;
	}

	/**
	 * @param cidbanqrswift
	 *            seta o novo valor para o campo cidbanqrswift
	 */
	public void setCidbanqrswift(String cidbanqrswift) {
		this.cidbanqrswift = cidbanqrswift;
	}

	/**
	 * @return o valor do cflialbanqrswift
	 */
	public String getCflialbanqrswift() {
		return cflialbanqrswift;
	}

	/**
	 * @param cflialbanqrswift
	 *            seta o novo valor para o campo cflialbanqrswift
	 */
	public void setCflialbanqrswift(String cflialbanqrswift) {
		this.cflialbanqrswift = cflialbanqrswift;
	}

	/**
	 * @return o valor do catulzbanqrswift
	 */
	public String getCatulzbanqrswift() {
		return catulzbanqrswift;
	}

	/**
	 * @param catulzbanqrswift
	 *            seta o novo valor para o campo catulzbanqrswift
	 */
	public void setCatulzbanqrswift(String catulzbanqrswift) {
		this.catulzbanqrswift = catulzbanqrswift;
	}

	/**
	 * @return o valor do ibanqrcmbioswift
	 */
	public String getIbanqrcmbioswift() {
		return ibanqrcmbioswift;
	}

	/**
	 * @param ibanqrcmbioswift
	 *            seta o novo valor para o campo ibanqrcmbioswift
	 */
	public void setIbanqrcmbioswift(String ibanqrcmbioswift) {
		this.ibanqrcmbioswift = ibanqrcmbioswift;
	}

	/**
	 * @return o valor do rtpoestrtswift
	 */
	public String getRtpoestrtswift() {
		return rtpoestrtswift;
	}

	/**
	 * @param rtpoestrtswift
	 *            seta o novo valor para o campo rtpoestrtswift
	 */
	public void setRtpoestrtswift(String rtpoestrtswift) {
		this.rtpoestrtswift = rtpoestrtswift;
	}

	/**
	 * @return o valor do ebanqrcmbioswift
	 */
	public String getEbanqrcmbioswift() {
		return ebanqrcmbioswift;
	}

	/**
	 * @param ebanqrcmbioswift
	 *            seta o novo valor para o campo ebanqrcmbioswift
	 */
	public void setEbanqrcmbioswift(String ebanqrcmbioswift) {
		this.ebanqrcmbioswift = ebanqrcmbioswift;
	}

	/**
	 * @return o valor do cbanqrcmbio
	 */
	public Long getCbanqrcmbio() {
		return cbanqrcmbio;
	}

	/**
	 * @param cbanqrcmbio
	 *            seta o novo valor para o campo cbanqrcmbio
	 */
	public void setCbanqrcmbio(Long cbanqrcmbio) {
		this.cbanqrcmbio = cbanqrcmbio;
	}

	/**
	 * @return o valor do ibanqrcmbio
	 */
	public String getIbanqrcmbio() {
		return ibanqrcmbio;
	}

	/**
	 * @param ibanqrcmbio
	 *            seta o novo valor para o campo ibanqrcmbio
	 */
	public void setIbanqrcmbio(String ibanqrcmbio) {
		this.ibanqrcmbio = ibanqrcmbio;
	}

	/**
	 * @return o valor do ipais
	 */
	public String getIpais() {
		return ipais;
	}

	/**
	 * @param ipais
	 *            seta o novo valor para o campo ipais
	 */
	public void setIpais(String ipais) {
		this.ipais = ipais;
	}

	/**
	 * @return o valor do cctabanqrexter
	 */
	public String getCctabanqrexter() {
		return cctabanqrexter;
	}

	/**
	 * @param cctabanqrexter
	 *            seta o novo valor para o campo cctabanqrexter
	 */
	public void setCctabanqrexter(String cctabanqrexter) {
		this.cctabanqrexter = cctabanqrexter;
	}

	/**
	 * @return o valor do cindcdeconmmoeda
	 */
	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}

	/**
	 * @param cindcdeconmmoeda
	 *            seta o novo valor para o campo cindcdeconmmoeda
	 */
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	/**
	 * @return o valor do cutilzctabanqr
	 */
	public String getCutilzctabanqr() {
		return cutilzctabanqr;
	}

	/**
	 * @param cutilzctabanqr
	 *            seta o novo valor para o campo cutilzctabanqr
	 */
	public void setCutilzctabanqr(String cutilzctabanqr) {
		this.cutilzctabanqr = cutilzctabanqr;
	}

	/**
	 * @return o valor do ntpositcmbio
	 */
	public Integer getNtpositcmbio() {
		return ntpositcmbio;
	}

	/**
	 * @param ntpositcmbio
	 *            seta o novo valor para o campo ntpositcmbio
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
	 * @param rjustfsitcmbio
	 *            seta o novo valor para o campo rjustfsitcmbio
	 */
	public void setRjustfsitcmbio(String rjustfsitcmbio) {
		this.rjustfsitcmbio = rjustfsitcmbio;
	}

	/**
	 * @return o valor do iindcdeconmmoeda
	 */
	public String getIindcdeconmmoeda() {
		return iindcdeconmmoeda;
	}

	/**
	 * @param iindcdeconmmoeda
	 *            seta o novo valor para o campo iindcdeconmmoeda
	 */
	public void setIindcdeconmmoeda(String iindcdeconmmoeda) {
		this.iindcdeconmmoeda = iindcdeconmmoeda;
	}

	/**
	 * @return o valor do nctabanqrexter
	 */
	public Integer getNctabanqrexter() {
		return nctabanqrexter;
	}

	/**
	 * @param nctabanqrexter
	 *            seta o novo valor para o campo nctabanqrexter
	 */
	public void setNctabanqrexter(Integer nctabanqrexter) {
		this.nctabanqrexter = nctabanqrexter;
	}

	/**
	 * @return o valor do isglindcdfonte
	 */
	public String getIsglindcdfonte() {
		return isglindcdfonte;
	}

	/**
	 * @param isglindcdfonte
	 *            seta o novo valor para o campo isglindcdfonte
	 */
	public void setIsglindcdfonte(String isglindcdfonte) {
		this.isglindcdfonte = isglindcdfonte;
	}

	/**
	 * @return o valor do cindcdfontecons
	 */
	public String getCindcdfontecons() {
		return cindcdfontecons;
	}

	/**
	 * @param cindcdfontecons
	 *            seta o novo valor para o campo cindcdfontecons
	 */
	public void setCindcdfontecons(String cindcdfontecons) {
		this.cindcdfontecons = cindcdfontecons;
	}

	/**
	 * @return o valor do ccmaracompeexter
	 */
	public Integer getCcmaracompeexter() {
		return ccmaracompeexter;
	}

	/**
	 * @param ccmaracompeexter
	 *            seta o novo valor para o campo ccmaracompeexter
	 */
	public void setCcmaracompeexter(Integer ccmaracompeexter) {
		this.ccmaracompeexter = ccmaracompeexter;
	}

	/**
	 * @return o valor do icmaracompeexter
	 */
	public String getIcmaracompeexter() {
		return icmaracompeexter;
	}

	/**
	 * @param icmaracompeexter
	 *            seta o novo valor para o campo icmaracompeexter
	 */
	public void setIcmaracompeexter(String icmaracompeexter) {
		this.icmaracompeexter = icmaracompeexter;
	}

	/**
	 * @return o valor do cexterbanqrcmara
	 */
	public String getCexterbanqrcmara() {
		return cexterbanqrcmara;
	}

	/**
	 * @param cexterbanqrcmara
	 *            seta o novo valor para o campo cexterbanqrcmara
	 */
	public void setCexterbanqrcmara(String cexterbanqrcmara) {
		this.cexterbanqrcmara = cexterbanqrcmara;
	}

	/**
	 * @return o valor do ccmaracompeprior
	 */
	public Integer getCcmaracompeprior() {
		return ccmaracompeprior;
	}

	/**
	 * @param ccmaracompeprior
	 *            seta o novo valor para o campo ccmaracompeprior
	 */
	public void setCcmaracompeprior(Integer ccmaracompeprior) {
		this.ccmaracompeprior = ccmaracompeprior;
	}

	/**
	 * @return o valor do cpais
	 */
	public Integer getCpais() {
		return cpais;
	}

	/**
	 * @param cpais
	 *            seta o novo valor para o campo cpais
	 */
	public void setCpais(Integer cpais) {
		this.cpais = cpais;
	}

	/**
	 * @return o valor do cpstalexterzip
	 */
	public String getCpstalexterzip() {
		return cpstalexterzip;
	}

	/**
	 * @param cpstalexterzip
	 *            seta o novo valor para o campo cpstalexterzip
	 */
	public void setCpstalexterzip(String cpstalexterzip) {
		this.cpstalexterzip = cpstalexterzip;
	}

	/**
	 * @return o valor do ccep
	 */
	public Integer getCcep() {
		return ccep;
	}

	/**
	 * @param ccep
	 *            seta o novo valor para o campo ccep
	 */
	public void setCcep(Integer ccep) {
		this.ccep = ccep;
	}

	/**
	 * @return o valor do ccepText
	 */
	public String getCcepText() {
		return ccepText;
	}

	/**
	 * @param ccepText
	 *            seta o novo valor para o campo ccepText
	 */
	public void setCcepText(String ccepText) {
		this.ccepText = ccepText;
	}

	/**
	 * @return o valor do ccepcompl
	 */
	public Integer getCcepcompl() {
		return ccepcompl;
	}

	/**
	 * @param ccepcompl
	 *            seta o novo valor para o campo ccepcompl
	 */
	public void setCcepcompl(Integer ccepcompl) {
		this.ccepcompl = ccepcompl;
	}

	/**
	 * @return o valor do ccepcomplText
	 */
	public String getCcepcomplText() {
		return ccepcomplText;
	}

	/**
	 * @param ccepcomplText
	 *            seta o novo valor para o campo ccepcomplText
	 */
	public void setCcepcomplText(String ccepcomplText) {
		this.ccepcomplText = ccepcomplText;
	}

//	/**
//	 * @return o valor do icepFormatado
//	 */
//	public String getIcepFormatado() {
//		// Verifica se há campos para serem formatados
//		if (getCcep() != null && getCcep() > 0 && getCcepcompl() != null) {
//
//			return SiteUtil.formatarCep(getCcep(), getCcepcompl());
//		} else {
//
//			return SiteUtil.STRING_EMPTY;
//		}
//	}

	/**
	 * @return o valor do elogdrpssoa
	 */
	public String getElogdrpssoa() {
		return elogdrpssoa;
	}

	/**
	 * @param elogdrpssoa
	 *            seta o novo valor para o campo elogdrpssoa
	 */
	public void setElogdrpssoa(String elogdrpssoa) {
		this.elogdrpssoa = elogdrpssoa;
	}

	/**
	 * @return o valor do elogdrnro
	 */
	public String getElogdrnro() {
		return elogdrnro;
	}

	/**
	 * @param elogdrnro
	 *            seta o novo valor para o campo elogdrnro
	 */
	public void setElogdrnro(String elogdrnro) {
		this.elogdrnro = elogdrnro;
	}

	/**
	 * @return o valor do rcomplender
	 */
	public String getRcomplender() {
		return rcomplender;
	}

	/**
	 * @param rcomplender
	 *            seta o novo valor para o campo rcomplender
	 */
	public void setRcomplender(String rcomplender) {
		this.rcomplender = rcomplender;
	}

	/**
	 * @return o valor do ebairoender
	 */
	public String getEbairoender() {
		return ebairoender;
	}

	/**
	 * @param ebairoender
	 *            seta o novo valor para o campo ebairoender
	 */
	public void setEbairoender(String ebairoender) {
		this.ebairoender = ebairoender;
	}

	/**
	 * @return o valor do cmunintlcmbio
	 */
	public Long getCmunintlcmbio() {
		return cmunintlcmbio;
	}

	/**
	 * @param cmunintlcmbio
	 *            seta o novo valor para o campo cmunintlcmbio
	 */
	public void setCmunintlcmbio(Long cmunintlcmbio) {
		this.cmunintlcmbio = cmunintlcmbio;
	}

	/**
	 * @return o valor do imunintlcmbio
	 */
	public String getImunintlcmbio() {
		return imunintlcmbio;
	}

	/**
	 * @param imunintlcmbio
	 *            seta o novo valor para o campo imunintlcmbio
	 */
	public void setImunintlcmbio(String imunintlcmbio) {
		this.imunintlcmbio = imunintlcmbio;
	}

	/**
	 * @return o valor do iestendercmbio
	 */
	public String getIestendercmbio() {
		return iestendercmbio;
	}

	/**
	 * @param iestendercmbio
	 *            seta o novo valor para o campo iestendercmbio
	 */
	public void setIestendercmbio(String iestendercmbio) {
		this.iestendercmbio = iestendercmbio;
	}

	/**
	 * @return o valor do cddifone
	 */
	public String getCddifone() {
		return cddifone;
	}

	/**
	 * @param cddifone
	 *            seta o novo valor para o campo cddifone
	 */
	public void setCddifone(String cddifone) {
		this.cddifone = cddifone;
	}

	/**
	 * @return o valor do cdddfone
	 */
	public String getCdddfone() {
		return cdddfone;
	}

	/**
	 * @param cdddfone
	 *            seta o novo valor para o campo cdddfone
	 */
	public void setCdddfone(String cdddfone) {
		this.cdddfone = cdddfone;
	}

	/**
	 * @return o valor do nlintfonireft
	 */
	public Long getNlintfonireft() {
		return nlintfonireft;
	}

	/**
	 * @param nlintfonireft
	 *            seta o novo valor para o campo nlintfonireft
	 */
	public void setNlintfonireft(Long nlintfonireft) {
		this.nlintfonireft = nlintfonireft;
	}

	/**
	 * @return o valor do coduf
	 */
	public String getCoduf() {
		return coduf;
	}

	/**
	 * @param coduf
	 *            seta o novo valor para o campo coduf
	 */
	public void setCoduf(String coduf) {
		this.coduf = coduf;
	}

	/**
	 * @return o valor do icoduf
	 */
	public String getIcoduf() {
		return icoduf;
	}

	/**
	 * @param icoduf
	 *            seta o novo valor para o campo icoduf
	 */
	public void setIcoduf(String icoduf) {
		this.icoduf = icoduf;
	}

	/**
	 * @return o valor do cdpais
	 */
	public String getCdpais() {
		return cdpais;
	}

	/**
	 * @param cdpais
	 *            seta o novo valor para o campo cdpais
	 */
	public void setCdpais(String cdpais) {
		this.cdpais = cdpais;
	}

	/**
	 * @return o valor do nomepais
	 */
	public String getNomepais() {
		return nomepais;
	}

	/**
	 * @param nomepais
	 *            seta o novo valor para o campo nomepais
	 */
	public void setNomepais(String nomepais) {
		this.nomepais = nomepais;
	}

	/**
	 * @return o valor do imun
	 */
	public String getImun() {
		return imun;
	}

	/**
	 * @param imun
	 *            seta o novo valor para o campo imun
	 */
	public void setImun(String imun) {
		this.imun = imun;
	}

	/**
	 * @return o valor do ctrocamsgemswift
	 */
	public Integer getCtrocamsgemswift() {
		return ctrocamsgemswift;
	}

	/**
	 * @param ctrocamsgemswift
	 *            seta o novo valor para o campo ctrocamsgemswift
	 */
	public void setCtrocamsgemswift(Integer ctrocamsgemswift) {
		this.ctrocamsgemswift = ctrocamsgemswift;
	}

	/**
	 * @return o valor do cusuaranlse
	 */
	public String getCusuaranlse() {
		return cusuaranlse;
	}

	/**
	 * @param cusuaranlse
	 *            seta o novo valor para o campo cusuaranlse
	 */
	public void setCusuaranlse(String cusuaranlse) {
		this.cusuaranlse = cusuaranlse;
	}

	/**
	 * @return o valor do iusuaranlse
	 */
	public String getIusuaranlse() {
		return iusuaranlse;
	}

	/**
	 * @param iusuaranlse
	 *            seta o novo valor para o campo iusuaranlse
	 */
	public void setIusuaranlse(String iusuaranlse) {
		this.iusuaranlse = iusuaranlse;
	}

	/**
	 * @return o valor do hanlsereg
	 */
	public String getHanlsereg() {
		return hanlsereg;
	}

//	/**
//	 * @return o valor do hanlsereg
//	 */
//	public String getHanlseregformated() {
//
//		return SiteUtil.dateTimeMainframeToWeb(hanlsereg);
//	}

	/**
	 * @param hanlsereg
	 *            seta o novo valor para o campo hanlsereg
	 */
	public void setHanlsereg(String hanlsereg) {
		this.hanlsereg = hanlsereg;
	}

	/**
	 * @return o valor do ntpomotvoblqe
	 */
	public Integer getNtpomotvoblqe() {
		return ntpomotvoblqe;
	}

	/**
	 * @param ntpomotvoblqe
	 *            seta o novo valor para o campo ntpomotvoblqe
	 */
	public void setNtpomotvoblqe(Integer ntpomotvoblqe) {
		this.ntpomotvoblqe = ntpomotvoblqe;
	}

	/**
	 * @return o valor do rtpomotvoblqe
	 */
	public String getRtpomotvoblqe() {
		return rtpomotvoblqe;
	}

	/**
	 * @param rtpomotvoblqe
	 *            seta o novo valor para o campo rtpomotvoblqe
	 */
	public void setRtpomotvoblqe(String rtpomotvoblqe) {
		this.rtpomotvoblqe = rtpomotvoblqe;
	}

	/**
	 * @return o valor do ntpomotvodstv
	 */
	public Integer getNtpomotvodstv() {
		return ntpomotvodstv;
	}

	/**
	 * @param ntpomotvodstv
	 *            seta o novo valor para o campo ntpomotvodstv
	 */
	public void setNtpomotvodstv(Integer ntpomotvodstv) {
		this.ntpomotvodstv = ntpomotvodstv;
	}

	/**
	 * @return o valor do rtpomotvodstv
	 */
	public String getRtpomotvodstv() {
		return rtpomotvodstv;
	}

	/**
	 * @param rtpomotvodstv
	 *            seta o novo valor para o campo rtpomotvodstv
	 */
	public void setRtpomotvodstv(String rtpomotvodstv) {
		this.rtpomotvodstv = rtpomotvodstv;
	}

	/**
	 * @return o valor do cintlidfincr
	 */
	public String getCintlidfincr() {
		return cintlidfincr;
	}

	/**
	 * @param cintlidfincr
	 *            seta o novo valor para o campo cintlidfincr
	 */
	public void setCintlidfincr(String cintlidfincr) {
		this.cintlidfincr = cintlidfincr;
	}

	/**
	 * @return o valor do cindcdbanqrcorsp
	 */
	public Integer getCindcdbanqrcorsp() {
		return cindcdbanqrcorsp;
	}

	/**
	 * @param cindcdbanqrcorsp
	 *            seta o novo valor para o campo cindcdbanqrcorsp
	 */
	public void setCindcdbanqrcorsp(Integer cindcdbanqrcorsp) {
		this.cindcdbanqrcorsp = cindcdbanqrcorsp;
	}

	/**
	 * @return o valor do cindcdpapeloper
	 */
	public Integer getCindcdpapeloper() {
		return cindcdpapeloper;
	}

	/**
	 * @param cindcdpapeloper
	 *            seta o novo valor para o campo cindcdpapeloper
	 */
	public void setCindcdpapeloper(Integer cindcdpapeloper) {
		this.cindcdpapeloper = cindcdpapeloper;
	}

	/**
	 * @return o valor do rjustfinoprcmbio
	 */
	public String getRjustfinoprcmbio() {
		return rjustfinoprcmbio;
	}

	/**
	 * @param rjustfinoprcmbio
	 *            seta o novo valor para o campo rjustfinoprcmbio
	 */
	public void setRjustfinoprcmbio(String rjustfinoprcmbio) {
		this.rjustfinoprcmbio = rjustfinoprcmbio;
	}

	/**
	 * @return o valor do cindcdpapelativo
	 */
	public Integer getCindcdpapelativo() {
		return cindcdpapelativo;
	}

	/**
	 * @param cindcdpapelativo
	 *            seta o novo valor para o campo cindcdpapelativo
	 */
	public void setCindcdpapelativo(Integer cindcdpapelativo) {
		this.cindcdpapelativo = cindcdpapelativo;
	}

	/**
	 * @return o valor do rjustfinatvcmbio
	 */
	public String getRjustfinatvcmbio() {
		return rjustfinatvcmbio;
	}

	/**
	 * @param rjustfinatvcmbio
	 *            seta o novo valor para o campo rjustfinatvcmbio
	 */
	public void setRjustfinatvcmbio(String rjustfinatvcmbio) {
		this.rjustfinatvcmbio = rjustfinatvcmbio;
	}

	/**
	 * @return o valor do ccpfcnpj
	 */
	public Integer getCcpfcnpj() {
		return ccpfcnpj;
	}

	/**
	 * @param ccpfcnpj
	 *            seta o novo valor para o campo ccpfcnpj
	 */
	public void setCcpfcnpj(Integer ccpfcnpj) {
		this.ccpfcnpj = ccpfcnpj;
	}

	/**
	 * @return o valor do cflialcnpj
	 */
	public Integer getCflialcnpj() {
		return cflialcnpj;
	}

	/**
	 * @param cflialcnpj
	 *            seta o novo valor para o campo cflialcnpj
	 */
	public void setCflialcnpj(Integer cflialcnpj) {
		this.cflialcnpj = cflialcnpj;
	}

	/**
	 * @return o valor do cctrlcpfcnpj
	 */
	public Integer getCctrlcpfcnpj() {
		return cctrlcpfcnpj;
	}

	/**
	 * @param cctrlcpfcnpj
	 *            seta o novo valor para o campo cctrlcpfcnpj
	 */
	public void setCctrlcpfcnpj(Integer cctrlcpfcnpj) {
		this.cctrlcpfcnpj = cctrlcpfcnpj;
	}

	/**
	 * @return o valor do cindcdbloqueado
	 */
	public Integer getCindcdbloqueado() {
		return cindcdbloqueado;
	}

	/**
	 * @param cindcdbloqueado
	 *            seta o novo valor para o campo cindcdbloqueado
	 */
	public void setCindcdbloqueado(Integer cindcdbloqueado) {
		this.cindcdbloqueado = cindcdbloqueado;
	}

//	/**
//	 * @return o valor do icindcdbloqueado
//	 */
//	public EnumSimNao getIcindcdbloqueado() {
//		return icindcdbloqueado;
//	}
//
//	/**
//	 * @param icindcdbloqueado
//	 *            seta o novo valor para o campo icindcdbloqueado
//	 */
//	public void setIcindcdbloqueado(EnumSimNao icindcdbloqueado) {
//		this.icindcdbloqueado = icindcdbloqueado;
//	}

	/**
	 * @return o valor do rtpomotvorest
	 */
	public String getRtpomotvorest() {
		return rtpomotvorest;
	}

	/**
	 * @param rtpomotvorest
	 *            seta o novo valor para o campo rtpomotvorest
	 */
	public void setRtpomotvorest(String rtpomotvorest) {
		this.rtpomotvorest = rtpomotvorest;
	}

	/**
	 * @return o valor do ntpopapelcmbio
	 */
	public Integer getNtpopapelcmbio() {
		return ntpopapelcmbio;
	}

	/**
	 * @param ntpopapelcmbio
	 *            seta o novo valor para o campo ntpopapelcmbio
	 */
	public void setNtpopapelcmbio(Integer ntpopapelcmbio) {
		this.ntpopapelcmbio = ntpopapelcmbio;
	}

	/**
	 * @return o valor do ntpomotvorest
	 */
	public Integer getNtpomotvorest() {
		return ntpomotvorest;
	}

	/**
	 * @param ntpomotvorest
	 *            seta o novo valor para o campo ntpomotvorest
	 */
	public void setNtpomotvorest(Integer ntpomotvorest) {
		this.ntpomotvorest = ntpomotvorest;
	}

	/**
	 * @return o valor do iidtfdnvelrest
	 */
	public String getIidtfdnvelrest() {
		return iidtfdnvelrest;
	}

	/**
	 * @param iidtfdnvelrest
	 *            seta o novo valor para o campo iidtfdnvelrest
	 */
	public void setIidtfdnvelrest(String iidtfdnvelrest) {
		this.iidtfdnvelrest = iidtfdnvelrest;
	}

	/**
	 * @return o valor do cidtfdnvelrest
	 */
	public Integer getCidtfdnvelrest() {
		return cidtfdnvelrest;
	}

	/**
	 * @param cidtfdnvelrest
	 *            seta o novo valor para o campo cidtfdnvelrest
	 */
	public void setCidtfdnvelrest(Integer cidtfdnvelrest) {
		this.cidtfdnvelrest = cidtfdnvelrest;
	}

	/**
	 * @return o valor do itpositcmbio
	 */
	public String getItpositcmbio() {
		return itpositcmbio;
	}

	/**
	 * @param itpositcmbio
	 *            seta o novo valor para o campo itpositcmbio
	 */
	public void setItpositcmbio(String itpositcmbio) {
		this.itpositcmbio = itpositcmbio;
	}

//	/**
//	 * @return o valor do isituacaoativoinativo
//	 */
//	public EnumSituacaoAtivoInativo getIsituacaoativoinativo() {
//		return isituacaoativoinativo;
//	}
//
//	/**
//	 * @param isituacaoativoinativo
//	 *            seta o novo valor para o campo isituacaoativoinativo
//	 */
//	public void setIsituacaoativoinativo(
//			EnumSituacaoAtivoInativo isituacaoativoinativo) {
//		this.isituacaoativoinativo = isituacaoativoinativo;
//	}

	/**
	 * @return o valor do idclub
	 */
	public String getIdclub() {
		return idclub;
	}

	/**
	 * @param idclub
	 *            seta o novo valor para o campo idclub
	 */
	public void setIdclub(String idclub) {
		this.idclub = idclub;
	}

	/**
	 * @return o valor do cdclub
	 */
	public Long getCdclub() {
		return cdclub;
	}

	/**
	 * @param cdclub
	 *            seta o novo valor para o campo cdclub
	 */
	public void setCdclub(Long cdclub) {
		this.cdclub = cdclub;
	}

	/**
	 * @return o valor do cdempresa
	 */
	public Long getCdempresa() {
		return cdempresa;
	}

	/**
	 * @param cdempresa
	 *            seta o novo valor para o campo cdempresa
	 */
	public void setCdempresa(Long cdempresa) {
		this.cdempresa = cdempresa;
	}

	/**
	 * @return o valor do cdcpfcnpj
	 */
	public Integer getCdcpfcnpj() {
		return cdcpfcnpj;
	}

	/**
	 * @param cdcpfcnpj
	 *            seta o novo valor para o campo cdcpfcnpj
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
	 * @param cdfilial
	 *            seta o novo valor para o campo cdfilial
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
	 * @param cdctrlcpfcnpj
	 *            seta o novo valor para o campo cdctrlcpfcnpj
	 */
	public void setCdctrlcpfcnpj(Integer cdctrlcpfcnpj) {
		this.cdctrlcpfcnpj = cdctrlcpfcnpj;
	}

	/**
	 * @return o valor do nmnomecliente
	 */
	public String getNmnomecliente() {
		return nmnomecliente;
	}

	/**
	 * @param nmnomecliente
	 *            seta o novo valor para o campo nmnomecliente
	 */
	public void setNmnomecliente(String nmnomecliente) {
		this.nmnomecliente = nmnomecliente;
	}

	/**
	 * @return o valor do cindcdaprovreg
	 */
	public Integer getCindcdaprovreg() {
		return cindcdaprovreg;
	}

	/**
	 * @param cindcdaprovreg
	 *            seta o novo valor para o campo cindcdaprovreg
	 */
	public void setCindcdaprovreg(Integer cindcdaprovreg) {
		this.cindcdaprovreg = cindcdaprovreg;
	}

	/**
	 * @return o valor do rrejeiclibanqr
	 */
	public String getRrejeiclibanqr() {
		return rrejeiclibanqr;
	}

	/**
	 * @param rrejeiclibanqr
	 *            seta o novo valor para o campo rrejeiclibanqr
	 */
	public void setRrejeiclibanqr(String rrejeiclibanqr) {
		this.rrejeiclibanqr = rrejeiclibanqr;
	}

	/**
	 * @return o valor do nenderpssoacmbio
	 */
	public Integer getNenderpssoacmbio() {
		return nenderpssoacmbio;
	}

	/**
	 * @param nenderpssoacmbio
	 *            seta o novo valor para o campo nenderpssoacmbio
	 */
	public void setNenderpssoacmbio(Integer nenderpssoacmbio) {
		this.nenderpssoacmbio = nenderpssoacmbio;
	}

	/**
	 * @return o valor do ncntatpssoacmbio
	 */
	public Integer getNcntatpssoacmbio() {
		return ncntatpssoacmbio;
	}

	/**
	 * @param ncntatpssoacmbio
	 *            seta o novo valor para o campo ncntatpssoacmbio
	 */
	public void setNcntatpssoacmbio(Integer ncntatpssoacmbio) {
		this.ncntatpssoacmbio = ncntatpssoacmbio;
	}

	/**
	 * @return o valor do banqrcambio
	 */
	public Integer getBanqrcambio() {
		return banqrcambio;
	}

	/**
	 * @param banqrcambio
	 *            seta o novo valor para o campo banqrcambio
	 */
	public void setBanqrcambio(Integer banqrcambio) {
		this.banqrcambio = banqrcambio;
	}

//	/**
//	 * @return o valor do CPF/CNPJ formatado.
//	 */
//	public String getCpfCnpjFormated() {
//
//		// Verifica se pode converter
//		if (getCdcpfcnpj() != null && getCdfilial() != null
//				&& getCdctrlcpfcnpj() != null && getCdcpfcnpj() > 0) {
//			return SiteUtil.formatarCPFCCNPJ(getCdcpfcnpj(), getCdfilial(),
//					getCdctrlcpfcnpj());
//		} else {
//			return null;
//		}
//	}

	/**
	 * @return o valor do cpssoa
	 */
	public Long getCpssoa() {
		return cpssoa;
	}

	/**
	 * @param cpssoa
	 *            seta o novo valor para o campo cpssoa
	 */
	public void setCpssoa(Long cpssoa) {
		this.cpssoa = cpssoa;
	}

	/**
	 * @return o valor da clearing formatada
	 */
	public String getClearingFormatted() {
		String descricaoCombo = null;

		if (getIcmaracompeexter() != null && getIcmaracompeexter().length() > 2) {
			descricaoCombo = getIcmaracompeexter().substring(0, 2)
					.concat(" - ").concat(getIcmaracompeexter().substring(2));
		} else {
			descricaoCombo = getIcmaracompeexter();
		}

		return descricaoCombo;
	}

	/**
	 * @return o valor do eciddebanqrswift
	 */
	public String getEciddebanqrswift() {
		return eciddebanqrswift;
	}

	/**
	 * @param eciddebanqrswift
	 *            seta o novo valor para o campo eciddebanqrswift
	 */
	public void setEciddebanqrswift(String eciddebanqrswift) {
		this.eciddebanqrswift = eciddebanqrswift;
	}

	/**
	 * @return o valor do ipaisbanqrswift
	 */
	public String getIpaisbanqrswift() {
		return ipaisbanqrswift;
	}

	/**
	 * @param ipaisbanqrswift
	 *            seta o novo valor para o campo ipaisbanqrswift
	 */
	public void setIpaisbanqrswift(String ipaisbanqrswift) {
		this.ipaisbanqrswift = ipaisbanqrswift;
	}

//	/**
//	 * @return o valor do ibanqrhedge
//	 */
//	public EnumSimNaoStr getIbanqrhedge() {
//		return ibanqrhedge;
//	}
//
//	/**
//	 * @param ibanqrhedge
//	 *            seta o novo valor para o campo ibanqrhedge
//	 */
//	public void setIbanqrhedge(EnumSimNaoStr ibanqrhedge) {
//		this.ibanqrhedge = ibanqrhedge;
//	}

	public String getDescmanut() {
		return descmanut;
	}

	public void setDescmanut(String descmanut) {
		this.descmanut = descmanut;
	}

	public String getTeladetalhe() {
		return teladetalhe;
	}

	public void setTeladetalhe(String teladetalhe) {
		this.teladetalhe = teladetalhe;
	}
}
