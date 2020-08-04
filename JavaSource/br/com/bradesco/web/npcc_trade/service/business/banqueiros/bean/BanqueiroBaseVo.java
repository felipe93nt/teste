/**
 *
 * Nome: BanqueiroVO.java
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
//import br.com.bradesco.web.npcd.service.gcc.InfoDocumentoGccVO;

/**
 *
 * Nome: BanqueiroVO.java Propósito:
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
public class BanqueiroBaseVo extends BanqueirosDadosSpecVo implements
		Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 2343796440274773340L;

	/** Variavel do tipo String. */
	private String ctpogrpbanqr = null;

	/** Variavel do tipo CpfDataType. */
	private String cpfFormatado = null;

	/** Variavel do tipo CnpjDataType. */
	private String cnpjFormatado = null;

	/** Variavel do tipo CpfDataType. */
	private CpfDataType cpf = null;

	/** Variavel do tipo CnpjDataType. */
	private CnpjDataType cnpj = null;

	/** Variavel do tipo Integer. */
	private Integer cbco = null;

	/** Variavel do tipo Integer. */
	private Integer cpssoapoltcexpsi = null;

	/** Variavel do tipo Integer. */
	private Integer cclasfundbanqr = null;

	/** Variavel do tipo String. */
	private String rjustfbanqrmsgem = null;

	/** Variavel do tipo Integer. */
	private Integer ctpoorgnzfincr = null;

	/** Variavel do tipo String. */
	private String ewebbanqrcmbio = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdconvecmbio = null;

	/** Variavel do tipo Integer. */
	private Integer cindcdbanqrscrtz = null;

	/** Variavel do tipo Integer. */
	private Integer cbanqrscrtzprinc = null;

	/** Variavel do tipo Date. */
	private Date dinicscrtzbanqr = null;

	/** Variavel do tipo Date. */
	private Date dfimscrtzbanqr = null;

	/** Variavel do tipo String. */
	private String dinicscrtzbanqrformated = null;

	/** Variavel do tipo String. */
	private String dfimscrtzbanqrformated = null;

	/** Variavel do tipo String. */
	private String itpoorgnzfincr = null;

	/** Variavel do tipo Integer. */
	private Integer ntpositbanqr = null;

	/** Variavel do tipo String. */
	private String itpogrpbanqr = null;

	/** Variavel do tipo String. */
	private String rjustfrejeicmbio = null;

	/** Variavel do tipo Integer. */
	private Integer crejeicmbio = null;

	/** Variavel do tipo String. */
	private String banqrhedge = null;

	/**
	 * Variavel para controle se foi de carga, caso sim, não se deve habilitar
	 * edição de swift.
	 */
	private boolean flgswiftcarga = false;

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaCodSwift = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaConta = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaClearing = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaEndereco = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaMotivos = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaBloqueios = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaClienteCadu = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaMotivosBloqueioDireita = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaMotivosBloqueioEsquerda = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaMotivosAtivosDireita = new ArrayList<BanqueirosDadosSpecVo>();

	/** Variavel do tipo List<BanqueirosDadosSpecVo>. */
	private List<BanqueirosDadosSpecVo> listaMotivosAtivosEsquerda = new ArrayList<BanqueirosDadosSpecVo>();

//	/** Variavel do tipo List<BanqueirosDadosAntesDepoisVo>. */
//	private List<BanqueirosDadosAntesDepoisVo> listaAntesDepois = new ArrayList<BanqueirosDadosAntesDepoisVo>();
//
//	/** Variavel do tipo List<BanqueirosDadosAntesDepoisVo>. */
//	private List<BanqueirosDadosAntesDepoisVo> listaContaAproAlt = new ArrayList<BanqueirosDadosAntesDepoisVo>();
//
//	/** Variavel do tipo List<BanqueirosDadosAntesDepoisVo>. */
//	private List<BanqueirosDadosAntesDepoisVo> listaClearingAproAlt = new ArrayList<BanqueirosDadosAntesDepoisVo>();
//
//	/** Variavel do tipo List<BanqueirosDadosAntesDepoisVo>. */
//	private List<BanqueirosDadosAntesDepoisVo> listaEnderecoAproAlt = new ArrayList<BanqueirosDadosAntesDepoisVo>();
//
//	/** Variavel do tipo List<BanqueirosDadosAntesDepoisVo>. */
//	private List<BanqueirosDadosAntesDepoisVo> listaMotivosAproAlt = new ArrayList<BanqueirosDadosAntesDepoisVo>();
//
//	/**
//	 * Lista de EMAIL anexos.
//	 */
//	private List<InfoDocumentoGccVO> listaAnexos = new ArrayList<InfoDocumentoGccVO>();

	/**
	 * Método construtor da classe.
	 */
	public BanqueiroBaseVo() {
		super();

	}

	/**
	 * @return o valor do ctpogrpbanqr
	 */
	public String getCtpogrpbanqr() {
		return ctpogrpbanqr;
	}

	/**
	 * @param ctpogrpbanqr
	 *            seta o novo valor para o campo ctpogrpbanqr
	 */
	public void setCtpogrpbanqr(String ctpogrpbanqr) {
		this.ctpogrpbanqr = ctpogrpbanqr;
	}

	/**
	 * @return o valor do cpfFormatado
	 */
	public String getCpfFormatado() {
		return cpfFormatado;
	}

	/**
	 * @param cpfFormatado
	 *            seta o novo valor para o campo cpfFormatado
	 */
	public void setCpfFormatado(String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}

	/**
	 * @return o valor do cnpjFormatado
	 */
	public String getCnpjFormatado() {
		return cnpjFormatado;
	}

	/**
	 * @param cnpjFormatado
	 *            seta o novo valor para o campo cnpjFormatado
	 */
	public void setCnpjFormatado(String cnpjFormatado) {
		this.cnpjFormatado = cnpjFormatado;
	}

	/**
	 * @return o valor do cpf
	 */
	public CpfDataType getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            seta o novo valor para o campo cpf
	 */
	public void setCpf(CpfDataType cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return o valor do cnpj
	 */
	public CnpjDataType getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj
	 *            seta o novo valor para o campo cnpj
	 */
	public void setCnpj(CnpjDataType cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return o valor do cbco
	 */
	public Integer getCbco() {
		return cbco;
	}

	/**
	 * @param cbco
	 *            seta o novo valor para o campo cbco
	 */
	public void setCbco(Integer cbco) {
		this.cbco = cbco;
	}

	/**
	 * @return o valor do cpssoapoltcexpsi
	 */
	public Integer getCpssoapoltcexpsi() {
		return cpssoapoltcexpsi;
	}

	/**
	 * @param cpssoapoltcexpsi
	 *            seta o novo valor para o campo cpssoapoltcexpsi
	 */
	public void setCpssoapoltcexpsi(Integer cpssoapoltcexpsi) {
		this.cpssoapoltcexpsi = cpssoapoltcexpsi;
	}

	/**
	 * @return o valor do cclasfundbanqr
	 */
	public Integer getCclasfundbanqr() {
		return cclasfundbanqr;
	}

	/**
	 * @param cclasfundbanqr
	 *            seta o novo valor para o campo cclasfundbanqr
	 */
	public void setCclasfundbanqr(Integer cclasfundbanqr) {
		this.cclasfundbanqr = cclasfundbanqr;
	}

	/**
	 * @return o valor do rjustfbanqrmsgem
	 */
	public String getRjustfbanqrmsgem() {
		return rjustfbanqrmsgem;
	}

	/**
	 * @param rjustfbanqrmsgem
	 *            seta o novo valor para o campo rjustfbanqrmsgem
	 */
	public void setRjustfbanqrmsgem(String rjustfbanqrmsgem) {
		this.rjustfbanqrmsgem = rjustfbanqrmsgem;
	}

	/**
	 * @return o valor do ctpoorgnzfincr
	 */
	public Integer getCtpoorgnzfincr() {
		return ctpoorgnzfincr;
	}

	/**
	 * @param ctpoorgnzfincr
	 *            seta o novo valor para o campo ctpoorgnzfincr
	 */
	public void setCtpoorgnzfincr(Integer ctpoorgnzfincr) {
		this.ctpoorgnzfincr = ctpoorgnzfincr;
	}

	/**
	 * @return o valor do ewebbanqrcmbio
	 */
	public String getEwebbanqrcmbio() {
		return ewebbanqrcmbio;
	}

	/**
	 * @param ewebbanqrcmbio
	 *            seta o novo valor para o campo ewebbanqrcmbio
	 */
	public void setEwebbanqrcmbio(String ewebbanqrcmbio) {
		this.ewebbanqrcmbio = ewebbanqrcmbio;
	}

	/**
	 * @return o valor do cindcdconvecmbio
	 */
	public Integer getCindcdconvecmbio() {
		return cindcdconvecmbio;
	}

	/**
	 * @param cindcdconvecmbio
	 *            seta o novo valor para o campo cindcdconvecmbio
	 */
	public void setCindcdconvecmbio(Integer cindcdconvecmbio) {
		this.cindcdconvecmbio = cindcdconvecmbio;
	}

	/**
	 * @return o valor do cindcdbanqrscrtz
	 */
	public Integer getCindcdbanqrscrtz() {
		return cindcdbanqrscrtz;
	}

	/**
	 * @param cindcdbanqrscrtz
	 *            seta o novo valor para o campo cindcdbanqrscrtz
	 */
	public void setCindcdbanqrscrtz(Integer cindcdbanqrscrtz) {
		this.cindcdbanqrscrtz = cindcdbanqrscrtz;
	}

	/**
	 * @return o valor do cbanqrscrtzprinc
	 */
	public Integer getCbanqrscrtzprinc() {
		return cbanqrscrtzprinc;
	}

	/**
	 * @param cbanqrscrtzprinc
	 *            seta o novo valor para o campo cbanqrscrtzprinc
	 */
	public void setCbanqrscrtzprinc(Integer cbanqrscrtzprinc) {
		this.cbanqrscrtzprinc = cbanqrscrtzprinc;
	}

	/**
	 * @return o valor do dinicscrtzbanqr
	 */
	public Date getDinicscrtzbanqr() {
		return dinicscrtzbanqr;
	}

	/**
	 * @param dinicscrtzbanqr
	 *            seta o novo valor para o campo dinicscrtzbanqr
	 */
	public void setDinicscrtzbanqr(Date dinicscrtzbanqr) {
		this.dinicscrtzbanqr = dinicscrtzbanqr;
	}

	/**
	 * @return o valor do dfimscrtzbanqr
	 */
	public Date getDfimscrtzbanqr() {
		return dfimscrtzbanqr;
	}

	/**
	 * @param dfimscrtzbanqr
	 *            seta o novo valor para o campo dfimscrtzbanqr
	 */
	public void setDfimscrtzbanqr(Date dfimscrtzbanqr) {
		this.dfimscrtzbanqr = dfimscrtzbanqr;
	}

	/**
	 * @return o valor do dinicscrtzbanqrformated
	 */
	public String getDinicscrtzbanqrformated() {
		return dinicscrtzbanqrformated;
	}

	/**
	 * @param dinicscrtzbanqrformated
	 *            seta o novo valor para o campo dinicscrtzbanqrformated
	 */
	public void setDinicscrtzbanqrformated(String dinicscrtzbanqrformated) {
		this.dinicscrtzbanqrformated = dinicscrtzbanqrformated;
	}

	/**
	 * @return o valor do dfimscrtzbanqrformated
	 */
	public String getDfimscrtzbanqrformated() {
		return dfimscrtzbanqrformated;
	}

	/**
	 * @param dfimscrtzbanqrformated
	 *            seta o novo valor para o campo dfimscrtzbanqrformated
	 */
	public void setDfimscrtzbanqrformated(String dfimscrtzbanqrformated) {
		this.dfimscrtzbanqrformated = dfimscrtzbanqrformated;
	}

	/**
	 * @return o valor do itpoorgnzfincr
	 */
	public String getItpoorgnzfincr() {
		return itpoorgnzfincr;
	}

	/**
	 * @param itpoorgnzfincr
	 *            seta o novo valor para o campo itpoorgnzfincr
	 */
	public void setItpoorgnzfincr(String itpoorgnzfincr) {
		this.itpoorgnzfincr = itpoorgnzfincr;
	}

	/**
	 * @return o valor do ntpositbanqr
	 */
	public Integer getNtpositbanqr() {
		return ntpositbanqr;
	}

	/**
	 * @param ntpositbanqr
	 *            seta o novo valor para o campo ntpositbanqr
	 */
	public void setNtpositbanqr(Integer ntpositbanqr) {
		this.ntpositbanqr = ntpositbanqr;
	}

	/**
	 * @return o valor do itpogrpbanqr
	 */
	public String getItpogrpbanqr() {
		return itpogrpbanqr;
	}

	/**
	 * @param itpogrpbanqr
	 *            seta o novo valor para o campo itpogrpbanqr
	 */
	public void setItpogrpbanqr(String itpogrpbanqr) {
		this.itpogrpbanqr = itpogrpbanqr;
	}

	/**
	 * @return o valor do listaCodSwift
	 */
	public List<BanqueirosDadosSpecVo> getListaCodSwift() {
		return listaCodSwift;
	}

	/**
	 * @param listaCodSwift
	 *            seta o novo valor para o campo listaCodSwift
	 */
	public void setListaCodSwift(List<BanqueirosDadosSpecVo> listaCodSwift) {
		this.listaCodSwift = listaCodSwift;
	}

	/**
	 * @return o valor do listaConta
	 */
	public List<BanqueirosDadosSpecVo> getListaConta() {
		return listaConta;
	}

	/**
	 * @param listaConta
	 *            seta o novo valor para o campo listaConta
	 */
	public void setListaConta(List<BanqueirosDadosSpecVo> listaConta) {
		this.listaConta = listaConta;
	}

	/**
	 * @return o valor do listaClearing
	 */
	public List<BanqueirosDadosSpecVo> getListaClearing() {
		return listaClearing;
	}

	/**
	 * @param listaClearing
	 *            seta o novo valor para o campo listaClearing
	 */
	public void setListaClearing(List<BanqueirosDadosSpecVo> listaClearing) {
		this.listaClearing = listaClearing;
	}

	/**
	 * @return o valor do listaEndereco
	 */
	public List<BanqueirosDadosSpecVo> getListaEndereco() {
		return listaEndereco;
	}

	/**
	 * @param listaEndereco
	 *            seta o novo valor para o campo listaEndereco
	 */
	public void setListaEndereco(List<BanqueirosDadosSpecVo> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}

	/**
	 * @return o valor do listaMotivos
	 */
	public List<BanqueirosDadosSpecVo> getListaMotivos() {
		return listaMotivos;
	}

	/**
	 * @param listaMotivos
	 *            seta o novo valor para o campo listaMotivos
	 */
	public void setListaMotivos(List<BanqueirosDadosSpecVo> listaMotivos) {
		this.listaMotivos = listaMotivos;
	}

	/**
	 * @return o valor do listaBloqueios
	 */
	public List<BanqueirosDadosSpecVo> getListaBloqueios() {
		return listaBloqueios;
	}

	/**
	 * @param listaBloqueios
	 *            seta o novo valor para o campo listaBloqueios
	 */
	public void setListaBloqueios(List<BanqueirosDadosSpecVo> listaBloqueios) {
		this.listaBloqueios = listaBloqueios;
	}

	/**
	 * @return o valor do listaMotivosBloqueioDireita
	 */
	public List<BanqueirosDadosSpecVo> getListaMotivosBloqueioDireita() {
		return listaMotivosBloqueioDireita;
	}

	/**
	 * @param listaMotivosBloqueioDireita
	 *            seta o novo valor para o campo listaMotivosBloqueioDireita
	 */
	public void setListaMotivosBloqueioDireita(
			List<BanqueirosDadosSpecVo> listaMotivosBloqueioDireita) {
		this.listaMotivosBloqueioDireita = listaMotivosBloqueioDireita;
	}

	/**
	 * @return o valor do listaMotivosBloqueioEsquerda
	 */
	public List<BanqueirosDadosSpecVo> getListaMotivosBloqueioEsquerda() {

		// Certifica que haja um retorno nulo para não haver erro na
		// renderização do dual list
		if (listaMotivosBloqueioEsquerda == null) {
			return new ArrayList<BanqueirosDadosSpecVo>();
		}

		return listaMotivosBloqueioEsquerda;
	}

	/**
	 * @param listaMotivosBloqueioEsquerda
	 *            seta o novo valor para o campo listaMotivosBloqueioEsquerda
	 */
	public void setListaMotivosBloqueioEsquerda(
			List<BanqueirosDadosSpecVo> listaMotivosBloqueioEsquerda) {
		this.listaMotivosBloqueioEsquerda = listaMotivosBloqueioEsquerda;
	}

	/**
	 * @return o valor do rjustfrejeicmbio
	 */
	public String getRjustfrejeicmbio() {
		return rjustfrejeicmbio;
	}

	/**
	 * @param rjustfrejeicmbio
	 *            seta o novo valor para o campo rjustfrejeicmbio
	 */
	public void setRjustfrejeicmbio(String rjustfrejeicmbio) {
		this.rjustfrejeicmbio = rjustfrejeicmbio;
	}

	/**
	 * @return o valor do crejeicmbio
	 */
	public Integer getCrejeicmbio() {
		return crejeicmbio;
	}

	/**
	 * @param crejeicmbio
	 *            seta o novo valor para o campo crejeicmbio
	 */
	public void setCrejeicmbio(Integer crejeicmbio) {
		this.crejeicmbio = crejeicmbio;
	}

	/**
	 * @return o valor do listaMotivosAtivosDireita
	 */
	public List<BanqueirosDadosSpecVo> getListaMotivosAtivosDireita() {
		return listaMotivosAtivosDireita;
	}

	/**
	 * @param listaMotivosAtivosDireita
	 *            seta o novo valor para o campo listaMotivosAtivosDireita
	 */
	public void setListaMotivosAtivosDireita(
			List<BanqueirosDadosSpecVo> listaMotivosAtivosDireita) {
		this.listaMotivosAtivosDireita = listaMotivosAtivosDireita;
	}

	/**
	 * @return o valor do listaMotivosAtivosEsquerda
	 */
	public List<BanqueirosDadosSpecVo> getListaMotivosAtivosEsquerda() {

		// Certifica que haja um retorno nulo para não haver erro na
		// renderização do dual list
		if (listaMotivosAtivosEsquerda == null) {
			return new ArrayList<BanqueirosDadosSpecVo>();
		}

		return listaMotivosAtivosEsquerda;
	}

	/**
	 * @param listaMotivosAtivosEsquerda
	 *            seta o novo valor para o campo listaMotivosAtivosEsquerda
	 */
	public void setListaMotivosAtivosEsquerda(
			List<BanqueirosDadosSpecVo> listaMotivosAtivosEsquerda) {
		this.listaMotivosAtivosEsquerda = listaMotivosAtivosEsquerda;
	}

//	/**
//	 * @return o valor do listaContaAproAlt
//	 */
//	public List<BanqueirosDadosAntesDepoisVo> getListaContaAproAlt() {
//		return listaContaAproAlt;
//	}
//
//	/**
//	 * @param listaContaAproAlt
//	 *            seta o novo valor para o campo listaContaAproAlt
//	 */
//	public void setListaContaAproAlt(
//			List<BanqueirosDadosAntesDepoisVo> listaContaAproAlt) {
//		this.listaContaAproAlt = listaContaAproAlt;
//	}
//
//	/**
//	 * @return o valor do listaClearingAproAlt
//	 */
//	public List<BanqueirosDadosAntesDepoisVo> getListaClearingAproAlt() {
//		return listaClearingAproAlt;
//	}
//
//	/**
//	 * @param listaClearingAproAlt
//	 *            seta o novo valor para o campo listaClearingAproAlt
//	 */
//	public void setListaClearingAproAlt(
//			List<BanqueirosDadosAntesDepoisVo> listaClearingAproAlt) {
//		this.listaClearingAproAlt = listaClearingAproAlt;
//	}
//
//	/**
//	 * @return o valor do listaEnderecoAproAlt
//	 */
//	public List<BanqueirosDadosAntesDepoisVo> getListaEnderecoAproAlt() {
//		return listaEnderecoAproAlt;
//	}
//
//	/**
//	 * @param listaEnderecoAproAlt
//	 *            seta o novo valor para o campo listaEnderecoAproAlt
//	 */
//	public void setListaEnderecoAproAlt(
//			List<BanqueirosDadosAntesDepoisVo> listaEnderecoAproAlt) {
//		this.listaEnderecoAproAlt = listaEnderecoAproAlt;
//	}
//
//	/**
//	 * @return o valor do listaMotivosAproAlt
//	 */
//	public List<BanqueirosDadosAntesDepoisVo> getListaMotivosAproAlt() {
//		return listaMotivosAproAlt;
//	}
//
//	/**
//	 * @param listaMotivosAproAlt
//	 *            seta o novo valor para o campo listaMotivosAproAlt
//	 */
//	public void setListaMotivosAproAlt(
//			List<BanqueirosDadosAntesDepoisVo> listaMotivosAproAlt) {
//		this.listaMotivosAproAlt = listaMotivosAproAlt;
//	}
//
//	/**
//	 * @return o valor do listaAntesDepois
//	 */
//	public List<BanqueirosDadosAntesDepoisVo> getListaAntesDepois() {
//		return listaAntesDepois;
//	}
//
//	/**
//	 * @param listaAntesDepois
//	 *            seta o novo valor para o campo listaAntesDepois
//	 */
//	public void setListaAntesDepois(
//			List<BanqueirosDadosAntesDepoisVo> listaAntesDepois) {
//		this.listaAntesDepois = listaAntesDepois;
//	}

	/**
	 * @return o valor do listaClienteCadu
	 */
	public List<BanqueirosDadosSpecVo> getListaClienteCadu() {
		return listaClienteCadu;
	}

	/**
	 * @param listaClienteCadu
	 *            seta o novo valor para o campo listaClienteCadu
	 */
	public void setListaClienteCadu(List<BanqueirosDadosSpecVo> listaClienteCadu) {
		this.listaClienteCadu = listaClienteCadu;
	}

	/**
	 * @return o valor do banqrhedge
	 */
	public String getBanqrhedge() {
		return banqrhedge;
	}

	/**
	 * @param banqrhedge
	 *            seta o novo valor para o campo banqrhedge
	 */
	public void setBanqrhedge(String banqrhedge) {
		this.banqrhedge = banqrhedge;
	}

	/**
	 * @return o valor do flgswiftcarga
	 */
	public boolean getFlgswiftcarga() {
		return flgswiftcarga;
	}

	/**
	 * @param flgswiftcarga
	 *            seta o novo valor para o campo flgswiftcarga
	 */
	public void setFlgswiftcarga(boolean flgswiftcarga) {
		this.flgswiftcarga = flgswiftcarga;
	}

//	public List<InfoDocumentoGccVO> getListaAnexos() {
//		return listaAnexos;
//	}
//
//	public void setListaAnexos(List<InfoDocumentoGccVO> listaAnexos) {
//		this.listaAnexos = listaAnexos;
//	}

}
