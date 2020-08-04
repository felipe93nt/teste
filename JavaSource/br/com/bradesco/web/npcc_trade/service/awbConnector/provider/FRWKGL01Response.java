/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.provider
 * 
 * Propósito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Criação: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Parâmetros de Compilação: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.provider;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.FRWKParameters;

/**
 * Nome: FRWKGL01Response
 * Propósito:  Classe filha response generica
 * Equipe: AWB Conectores
 * Parametro de compilação: -d.
 *
 * @author william.santos CPM Braxis Copyright (c) 2011
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 * <p>Registro de Manutenção:
 * <li>Data : </li>
 * <li>Autor: </li>
 * <li>Responsável: </li>
 * </p>
 */
public class FRWKGL01Response extends AnnotatedAdapter {
	
	/**
	 * Construtor Padrão
	 * Instancia um novo objeto FRWKGL01Response.
	 */
	public FRWKGL01Response() {
		super.setParameter(new FRWKParameters());
	}
	
	//FRWKGL01
	/** Atributo frwkcodlayout. */
	@Adapter(transactionField = "FRWKGL01-HEADER.FRWKGL01-COD-LAYOUT")
	private String frwkcodlayout = "FRWKGL01";
	
	/** Atributo frwktamlayout. */
	@Adapter(transactionField = "FRWKGL01-HEADER.FRWKGL01-TAM-LAYOUT")
	private String frwktamlayout = "216";
	
	/** Atributo codretorno. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-RETORNO.FRWKGL01-COD-RETORNO")
	private String codretorno = "0";
	
	/** Atributo tamlayoutresto. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-TAM-LAYOUT-RESTO")
	private String tamlayoutresto = "";
	
	/** Atributo cidtfdsess. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-CIDTFD-SESS")
	private String cidtfdsess = "";
	
	/** Atributo noperfluxo. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-NOPER-FLUXO")
	private String noperfluxo = "";
	
	/** Atributo ifluxoexter. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-IFLUXO-EXTER")
	private String ifluxoexter = "";
	
	/** Atributo empresaoperante. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-EMPRESA-OPERANTE")
	private String empresaoperante = "";
	
	/** Atributo dependoperante. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-DEPEND-OPERANTE")
	private String dependoperante = "";
	
	/** Atributo ccanal. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-CCANAL")
	private String ccanal = "";
	
	/** Atributo cidtfdperif. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-CIDTFD-PERIF")
	private String cidtfdperif = "";
	
	/** Atributo idioma. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-IDIOMA")
	private String idioma = "";
	
	/** Atributo dtlocal. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-DT-LOCAL")
	private String dtlocal = "";
	
	/** Atributo hrlocal. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-HR-LOCAL")
	private String hrlocal = "";
	
	/** Atributo ifluxomonet. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-IFLUXO-MONET")
	private String ifluxomonet = "";
	
	/** Atributo ifluxologout. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-IFLUXO-LOGOUT")
	private String ifluxologout = "";
	
	/** Atributo ifluxoparal. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-IFLUXO-PARAL")
	private String ifluxoparal = "";
	
	/** Atributo ifluxodados. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-IFLUXO-DADOS")
	private String ifluxodados = "";
	
	/** Atributo tusuarsegrc. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-TUSUAR-SEGRC")
	private String tusuarsegrc = "";
	
	/** Atributo cautensegrc. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-CAUTEN-SEGRC")
	private String cautensegrc = "";
	
	/** Atributo tusuarautor. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-TUSUAR-AUTOR")
	private String tusuarautor = "";
	
	/** Atributo cusuarautor. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-CUSUAR-AUTOR")
	private String cusuarautor = "";
	
	/** Atributo inicblseg. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-INIC-BLSEG")
	private String inicblseg = "";
	
	/** Atributo tamblseg. */
	@Adapter(transactionField = "FRWKGL01-REGISTRO.FRWKGL01-BLOCO-ENTR-SAID.FRWKGL01-TAM-BLSEG")
	private String tamblseg = "";
	//frwk02
	/** Atributo frwk2codlayout. */
	@Adapter(transactionField = "FRWKEBL2-HEADER.FRWKEBL2-COD-LAYOUT")
	private String frwk2codlayout = "";
	
	/** Atributo frwk2tamlayout. */
	@Adapter(transactionField = "FRWKEBL2-HEADER.FRWKEBL2-TAM-LAYOUT")
	private String frwk2tamlayout = "";
	
	/** Atributo qtidadeprot. */
	@Adapter(transactionField = "FRWKEBL2-REGISTRO.FRWKEBL2-QTIDADE-PROT")
	private String qtidadeprot = "";
	
	/** Atributo cctrocusto. */
	@Adapter(transactionField = "FRWKEBL2-REGISTRO.FRWKEBL2-ESTR-PROT.FRWKEBL2-PROT.FRWKEBL2-CCTRO-CUSTO")
	private String cctrocusto = "";
	
	/** Atributo protocolo. */
	@Adapter(transactionField = "FRWKEBL2-REGISTRO.FRWKEBL2-ESTR-PROT.FRWKEBL2-PROT.FRWKEBL2-PROTOCOLO")
	private String protocolo = "";
	//frwk 03
	/** Atributo frwk3codlayout. */
	@Adapter(transactionField = "FRWKEBL3-HEADER.FRWKEBL3-COD-LAYOUT")
	private String frwk3codlayout = "";
	
	/** Atributo frwk3tamlayout. */
	@Adapter(transactionField = "FRWKEBL3-HEADER.FRWKEBL3-TAM-LAYOUT")
	private String frwk3tamlayout = "";
	
	/** Atributo qtidademens. */
	@Adapter(transactionField = "FRWKEBL3-REGISTRO.FRWKEBL3-QTIDADE-MENS")
	private String qtidademens = "";
	
	/** Atributo codmens. */
	@Adapter(transactionField = "FRWKEBL3-REGISTRO.FRWKEBL3-ESTR-MSG.FRWKEBL3-MSG.FRWKEBL3-COD-MENS")
	private String codmens = "";
	
	/** Atributo tipmens. */
	@Adapter(transactionField = "FRWKEBL3-REGISTRO.FRWKEBL3-ESTR-MSG.FRWKEBL3-MSG.FRWKEBL3-TIP-MENS")
	private String tipmens = "";
	
	/** Atributo nivmens. */
	@Adapter(transactionField = "FRWKEBL3-REGISTRO.FRWKEBL3-ESTR-MSG.FRWKEBL3-MSG.FRWKEBL3-NIV-MENS")
	private String nivmens = "";
	
	/** Atributo tammens. */
	@Adapter(transactionField = "FRWKEBL3-REGISTRO.FRWKEBL3-ESTR-MSG.FRWKEBL3-MSG.FRWKEBL3-TAM-MENS")
	private String tammens = "";
	
	/** Atributo texmens. */
	@Adapter(transactionField = "FRWKEBL3-REGISTRO.FRWKEBL3-ESTR-MSG.FRWKEBL3-MSG.FRWKEBL3-TEX-MENS")
	private String texmens = "";
	//GSEGGLAA
	/** Atributo gsegcodlayout. */
	@Adapter(transactionField = "GSEGBB-BLOCO-HEADER.GSEGBB-COD-LAYOUT")
	private String gsegcodlayout = "GSEGGLAA";
	
	/** Atributo gsegtamlayout. */
	@Adapter(transactionField = "GSEGBB-BLOCO-HEADER.GSEGBB-TAM-LAYOUT")
	private String gsegtamlayout = "230";
	
	/** Atributo ticketsgrca. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-TICKET-SGRCA")
	private String ticketsgrca = "";
	
	/** Atributo frmtusuario. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-FRMT-USUARIO")
	private String frmtusuario = "";
	
	/** Atributo idusuario. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-ID-USUARIO")
	private String idusuario = "";
	
	/** Atributo tipousuario. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-TIPO-USUARIO")
	private String tipousuario = "";
	
	/** Atributo solicass. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-RESP-SOLIC-ASS")
	private String solicass = "";
	
	/** Atributo solicalcad. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-RESP-SOLIC-ALCAD")
	private String solicalcad = "";
	
	/** Atributo solicexec. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-RESP-SOLIC-EXEC")
	private String solicexec = "";
	
	/** Atributo reftancode. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-REF-TANCODE")
	private String reftancode = "";
	
	/** Atributo celtancode. */
	@Adapter(transactionField = "GSEGBB-REGISTRO.GSEGBB-BLOCO-SAIDA.GSEGBB-CEL-TANCODE")
	private String celtancode = "";
	
	/**
	 * Nome: getFrwkcodlayout
	 * Recupera o valor do atributo 'frwkcodlayout'.
	 *
	 * @return valor do atributo 'frwkcodlayout'
	 * @see
	 */
	public String getFrwkcodlayout() {
		return frwkcodlayout;
	}
	
	/**
	 * Nome: setFrwkcodlayout
	 * Registra o valor do atributo 'frwkcodlayout'.
	 *
	 * @param frwkcodlayout valor do atributo frwkcodlayout
	 * @see
	 */
	public void setFrwkcodlayout(String frwkcodlayout) {
		this.frwkcodlayout = frwkcodlayout;
	}
	
	/**
	 * Nome: getFrwktamlayout
	 * Recupera o valor do atributo 'frwktamlayout'.
	 *
	 * @return valor do atributo 'frwktamlayout'
	 * @see
	 */
	public String getFrwktamlayout() {
		return frwktamlayout;
	}
	
	/**
	 * Nome: setFrwktamlayout
	 * Registra o valor do atributo 'frwktamlayout'.
	 *
	 * @param tamlayout valor do atributo frwktamlayout
	 * @see
	 */
	public void setFrwktamlayout(String tamlayout) {
		this.frwktamlayout = tamlayout;
	}
	
	/**
	 * Nome: getCodretorno
	 * Recupera o valor do atributo 'codretorno'.
	 *
	 * @return valor do atributo 'codretorno'
	 * @see
	 */
	public String getCodretorno() {
		return codretorno;
	}
	
	/**
	 * Nome: setCodretorno
	 * Registra o valor do atributo 'codretorno'.
	 *
	 * @param codretorno valor do atributo codretorno
	 * @see
	 */
	public void setCodretorno(String codretorno) {
		this.codretorno = codretorno;
	}
	
	/**
	 * Nome: getTamlayoutresto
	 * Recupera o valor do atributo 'tamlayoutresto'.
	 *
	 * @return valor do atributo 'tamlayoutresto'
	 * @see
	 */
	public String getTamlayoutresto() {
		return tamlayoutresto;
	}
	
	/**
	 * Nome: setTamlayoutresto
	 * Registra o valor do atributo 'tamlayoutresto'.
	 *
	 * @param tamlayoutresto valor do atributo tamlayoutresto
	 * @see
	 */
	public void setTamlayoutresto(String tamlayoutresto) {
		this.tamlayoutresto = tamlayoutresto;
	}
	
	/**
	 * Nome: getCidtfdsess
	 * Recupera o valor do atributo 'cidtfdsess'.
	 *
	 * @return valor do atributo 'cidtfdsess'
	 * @see
	 */
	public String getCidtfdsess() {
		return cidtfdsess;
	}
	
	/**
	 * Nome: setCidtfdsess
	 * Registra o valor do atributo 'cidtfdsess'.
	 *
	 * @param cidtfdsess valor do atributo cidtfdsess
	 * @see
	 */
	public void setCidtfdsess(String cidtfdsess) {
		this.cidtfdsess = cidtfdsess;
	}
	
	/**
	 * Nome: getNoperfluxo
	 * Recupera o valor do atributo 'noperfluxo'.
	 *
	 * @return valor do atributo 'noperfluxo'
	 * @see
	 */
	public String getNoperfluxo() {
		return noperfluxo;
	}
	
	/**
	 * Nome: setNoperfluxo
	 * Registra o valor do atributo 'noperfluxo'.
	 *
	 * @param noperfluxo valor do atributo noperfluxo
	 * @see
	 */
	public void setNoperfluxo(String noperfluxo) {
		this.noperfluxo = noperfluxo;
	}
	
	/**
	 * Nome: getIfluxoexter
	 * Recupera o valor do atributo 'ifluxoexter'.
	 *
	 * @return valor do atributo 'ifluxoexter'
	 * @see
	 */
	public String getIfluxoexter() {
		return ifluxoexter;
	}
	
	/**
	 * Nome: setIfluxoexter
	 * Registra o valor do atributo 'ifluxoexter'.
	 *
	 * @param ifluxoexter valor do atributo ifluxoexter
	 * @see
	 */
	public void setIfluxoexter(String ifluxoexter) {
		this.ifluxoexter = ifluxoexter;
	}
	
	/**
	 * Nome: getEmpresaoperante
	 * Recupera o valor do atributo 'empresaoperante'.
	 *
	 * @return valor do atributo 'empresaoperante'
	 * @see
	 */
	public String getEmpresaoperante() {
		return empresaoperante;
	}
	
	/**
	 * Nome: setEmpresaoperante
	 * Registra o valor do atributo 'empresaoperante'.
	 *
	 * @param empresaoperante valor do atributo empresaoperante
	 * @see
	 */
	public void setEmpresaoperante(String empresaoperante) {
		this.empresaoperante = empresaoperante;
	}
	
	/**
	 * Nome: getDependoperante
	 * Recupera o valor do atributo 'dependoperante'.
	 *
	 * @return valor do atributo 'dependoperante'
	 * @see
	 */
	public String getDependoperante() {
		return dependoperante;
	}
	
	/**
	 * Nome: setDependoperante
	 * Registra o valor do atributo 'dependoperante'.
	 *
	 * @param dependoperante valor do atributo dependoperante
	 * @see
	 */
	public void setDependoperante(String dependoperante) {
		this.dependoperante = dependoperante;
	}
	
	/**
	 * Nome: getCcanal
	 * Recupera o valor do atributo 'ccanal'.
	 *
	 * @return valor do atributo 'ccanal'
	 * @see
	 */
	public String getCcanal() {
		return ccanal;
	}
	
	/**
	 * Nome: setCcanal
	 * Registra o valor do atributo 'ccanal'.
	 *
	 * @param ccanal valor do atributo ccanal
	 * @see
	 */
	public void setCcanal(String ccanal) {
		this.ccanal = ccanal;
	}
	
	/**
	 * Nome: getCidtfdperif
	 * Recupera o valor do atributo 'cidtfdperif'.
	 *
	 * @return valor do atributo 'cidtfdperif'
	 * @see
	 */
	public String getCidtfdperif() {
		return cidtfdperif;
	}
	
	/**
	 * Nome: setCidtfdperif
	 * Registra o valor do atributo 'cidtfdperif'.
	 *
	 * @param cidtfdperif valor do atributo cidtfdperif
	 * @see
	 */
	public void setCidtfdperif(String cidtfdperif) {
		this.cidtfdperif = cidtfdperif;
	}
	
	/**
	 * Nome: getIdioma
	 * Recupera o valor do atributo 'idioma'.
	 *
	 * @return valor do atributo 'idioma'
	 * @see
	 */
	public String getIdioma() {
		return idioma;
	}
	
	/**
	 * Nome: setIdioma
	 * Registra o valor do atributo 'idioma'.
	 *
	 * @param idioma valor do atributo idioma
	 * @see
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	/**
	 * Nome: getDtlocal
	 * Recupera o valor do atributo 'dtlocal'.
	 *
	 * @return valor do atributo 'dtlocal'
	 * @see
	 */
	public String getDtlocal() {
		return dtlocal;
	}
	
	/**
	 * Nome: setDtlocal
	 * Registra o valor do atributo 'dtlocal'.
	 *
	 * @param dtlocal valor do atributo dtlocal
	 * @see
	 */
	public void setDtlocal(String dtlocal) {
		this.dtlocal = dtlocal;
	}
	
	/**
	 * Nome: getHrlocal
	 * Recupera o valor do atributo 'hrlocal'.
	 *
	 * @return valor do atributo 'hrlocal'
	 * @see
	 */
	public String getHrlocal() {
		return hrlocal;
	}
	
	/**
	 * Nome: setHrlocal
	 * Registra o valor do atributo 'hrlocal'.
	 *
	 * @param hrlocal valor do atributo hrlocal
	 * @see
	 */
	public void setHrlocal(String hrlocal) {
		this.hrlocal = hrlocal;
	}
	
	/**
	 * Nome: getIfluxomonet
	 * Recupera o valor do atributo 'ifluxomonet'.
	 *
	 * @return valor do atributo 'ifluxomonet'
	 * @see
	 */
	public String getIfluxomonet() {
		return ifluxomonet;
	}
	
	/**
	 * Nome: setIfluxomonet
	 * Registra o valor do atributo 'ifluxomonet'.
	 *
	 * @param ifluxomonet valor do atributo ifluxomonet
	 * @see
	 */
	public void setIfluxomonet(String ifluxomonet) {
		this.ifluxomonet = ifluxomonet;
	}
	
	/**
	 * Nome: getIfluxologout
	 * Recupera o valor do atributo 'ifluxologout'.
	 *
	 * @return valor do atributo 'ifluxologout'
	 * @see
	 */
	public String getIfluxologout() {
		return ifluxologout;
	}
	
	/**
	 * Nome: setIfluxologout
	 * Registra o valor do atributo 'ifluxologout'.
	 *
	 * @param ifluxologout valor do atributo ifluxologout
	 * @see
	 */
	public void setIfluxologout(String ifluxologout) {
		this.ifluxologout = ifluxologout;
	}
	
	/**
	 * Nome: getIfluxoparal
	 * Recupera o valor do atributo 'ifluxoparal'.
	 *
	 * @return valor do atributo 'ifluxoparal'
	 * @see
	 */
	public String getIfluxoparal() {
		return ifluxoparal;
	}
	
	/**
	 * Nome: setIfluxoparal
	 * Registra o valor do atributo 'ifluxoparal'.
	 *
	 * @param ifluxoparal valor do atributo ifluxoparal
	 * @see
	 */
	public void setIfluxoparal(String ifluxoparal) {
		this.ifluxoparal = ifluxoparal;
	}
	
	/**
	 * Nome: getIfluxodados
	 * Recupera o valor do atributo 'ifluxodados'.
	 *
	 * @return valor do atributo 'ifluxodados'
	 * @see
	 */
	public String getIfluxodados() {
		return ifluxodados;
	}
	
	/**
	 * Nome: setIfluxodados
	 * Registra o valor do atributo 'ifluxodados'.
	 *
	 * @param ifluxodados valor do atributo ifluxodados
	 * @see
	 */
	public void setIfluxodados(String ifluxodados) {
		this.ifluxodados = ifluxodados;
	}
	
	/**
	 * Nome: getTusuarsegrc
	 * Recupera o valor do atributo 'tusuarsegrc'.
	 *
	 * @return valor do atributo 'tusuarsegrc'
	 * @see
	 */
	public String getTusuarsegrc() {
		return tusuarsegrc;
	}
	
	/**
	 * Nome: setTusuarsegrc
	 * Registra o valor do atributo 'tusuarsegrc'.
	 *
	 * @param tusuarsegrc valor do atributo tusuarsegrc
	 * @see
	 */
	public void setTusuarsegrc(String tusuarsegrc) {
		this.tusuarsegrc = tusuarsegrc;
	}
	
	/**
	 * Nome: getCautensegrc
	 * Recupera o valor do atributo 'cautensegrc'.
	 *
	 * @return valor do atributo 'cautensegrc'
	 * @see
	 */
	public String getCautensegrc() {
		return cautensegrc;
	}
	
	/**
	 * Nome: setCautensegrc
	 * Registra o valor do atributo 'cautensegrc'.
	 *
	 * @param cautensegrc valor do atributo cautensegrc
	 * @see
	 */
	public void setCautensegrc(String cautensegrc) {
		this.cautensegrc = cautensegrc;
	}
	
	/**
	 * Nome: getTusuarautor
	 * Recupera o valor do atributo 'tusuarautor'.
	 *
	 * @return valor do atributo 'tusuarautor'
	 * @see
	 */
	public String getTusuarautor() {
		return tusuarautor;
	}
	
	/**
	 * Nome: setTusuarautor
	 * Registra o valor do atributo 'tusuarautor'.
	 *
	 * @param tusuarautor valor do atributo tusuarautor
	 * @see
	 */
	public void setTusuarautor(String tusuarautor) {
		this.tusuarautor = tusuarautor;
	}
	
	/**
	 * Nome: getCusuarautor
	 * Recupera o valor do atributo 'cusuarautor'.
	 *
	 * @return valor do atributo 'cusuarautor'
	 * @see
	 */
	public String getCusuarautor() {
		return cusuarautor;
	}
	
	/**
	 * Nome: setCusuarautor
	 * Registra o valor do atributo 'cusuarautor'.
	 *
	 * @param cusuarautor valor do atributo cusuarautor
	 * @see
	 */
	public void setCusuarautor(String cusuarautor) {
		this.cusuarautor = cusuarautor;
	}
	
	/**
	 * Nome: getInicblseg
	 * Recupera o valor do atributo 'inicblseg'.
	 *
	 * @return valor do atributo 'inicblseg'
	 * @see
	 */
	public String getInicblseg() {
		return inicblseg;
	}
	
	/**
	 * Nome: setInicblseg
	 * Registra o valor do atributo 'inicblseg'.
	 *
	 * @param inicblseg valor do atributo inicblseg
	 * @see
	 */
	public void setInicblseg(String inicblseg) {
		this.inicblseg = inicblseg;
	}
	
	/**
	 * Nome: getTamblseg
	 * Recupera o valor do atributo 'tamblseg'.
	 *
	 * @return valor do atributo 'tamblseg'
	 * @see
	 */
	public String getTamblseg() {
		return tamblseg;
	}
	
	/**
	 * Nome: setTamblseg
	 * Registra o valor do atributo 'tamblseg'.
	 *
	 * @param tamblseg valor do atributo tamblseg
	 * @see
	 */
	public void setTamblseg(String tamblseg) {
		this.tamblseg = tamblseg;
	}
	
	/**
	 * Nome: getGsegcodlayout
	 * Recupera o valor do atributo 'gsegcodlayout'.
	 *
	 * @return valor do atributo 'gsegcodlayout'
	 * @see
	 */
	public String getGsegcodlayout() {
		return gsegcodlayout;
	}
	
	//GSEG
	/**
	 * Nome: setGsegcodlayout
	 * Registra o valor do atributo 'gsegcodlayout'.
	 *
	 * @param gsegcodlayout valor do atributo gsegcodlayout
	 * @see
	 */
	public void setGsegcodlayout(String gsegcodlayout) {
		this.gsegcodlayout = gsegcodlayout;
	}
	
	/**
	 * Nome: getGsegtamlayout
	 * Recupera o valor do atributo 'gsegtamlayout'.
	 *
	 * @return valor do atributo 'gsegtamlayout'
	 * @see
	 */
	public String getGsegtamlayout() {
		return gsegtamlayout;
	}
	
	/**
	 * Nome: setGsegtamlayout
	 * Registra o valor do atributo 'gsegtamlayout'.
	 *
	 * @param gsegtamlayout valor do atributo gsegtamlayout
	 * @see
	 */
	public void setGsegtamlayout(String gsegtamlayout) {
		this.gsegtamlayout = gsegtamlayout;
	}
	
	/**
	 * Nome: getTicketsgrca
	 * Recupera o valor do atributo 'ticketsgrca'.
	 *
	 * @return valor do atributo 'ticketsgrca'
	 * @see
	 */
	public String getTicketsgrca() {
		return ticketsgrca;
	}
	
	/**
	 * Nome: setTicketsgrca
	 * Registra o valor do atributo 'ticketsgrca'.
	 *
	 * @param ticketsgrca valor do atributo ticketsgrca
	 * @see
	 */
	public void setTicketsgrca(String ticketsgrca) {
		this.ticketsgrca = ticketsgrca;
	}
	
	/**
	 * Nome: getFrmtusuario
	 * Recupera o valor do atributo 'frmtusuario'.
	 *
	 * @return valor do atributo 'frmtusuario'
	 * @see
	 */
	public String getFrmtusuario() {
		return frmtusuario;
	}
	
	/**
	 * Nome: setFrmtusuario
	 * Registra o valor do atributo 'frmtusuario'.
	 *
	 * @param frmtusuario valor do atributo frmtusuario
	 * @see
	 */
	public void setFrmtusuario(String frmtusuario) {
		this.frmtusuario = frmtusuario;
	}
	
	/**
	 * Nome: getIdusuario
	 * Recupera o valor do atributo 'idusuario'.
	 *
	 * @return valor do atributo 'idusuario'
	 * @see
	 */
	public String getIdusuario() {
		return idusuario;
	}
	
	/**
	 * Nome: setIdusuario
	 * Registra o valor do atributo 'idusuario'.
	 *
	 * @param idusuario valor do atributo idusuario
	 * @see
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	/**
	 * Nome: getFrwk2codlayout
	 * Recupera o valor do atributo 'frwk2codlayout'.
	 *
	 * @return valor do atributo 'frwk2codlayout'
	 * @see
	 */
	public String getFrwk2codlayout() {
		return frwk2codlayout;
	}
	
	/**
	 * Nome: setFrwk2codlayout
	 * Registra o valor do atributo 'frwk2codlayout'.
	 *
	 * @param frwk2codlayout valor do atributo frwk2codlayout
	 * @see
	 */
	public void setFrwk2codlayout(String frwk2codlayout) {
		this.frwk2codlayout = frwk2codlayout;
	}
	
	/**
	 * Nome: getFrwk2tamlayout
	 * Recupera o valor do atributo 'frwk2tamlayout'.
	 *
	 * @return valor do atributo 'frwk2tamlayout'
	 * @see
	 */
	public String getFrwk2tamlayout() {
		return frwk2tamlayout;
	}
	
	/**
	 * Nome: setFrwk2tamlayout
	 * Registra o valor do atributo 'frwk2tamlayout'.
	 *
	 * @param frwk2tamlayout valor do atributo frwk2tamlayout
	 * @see
	 */
	public void setFrwk2tamlayout(String frwk2tamlayout) {
		this.frwk2tamlayout = frwk2tamlayout;
	}
	
	/**
	 * Nome: getQtidadeprot
	 * Recupera o valor do atributo 'qtidadeprot'.
	 *
	 * @return valor do atributo 'qtidadeprot'
	 * @see
	 */
	public String getQtidadeprot() {
		return qtidadeprot;
	}
	
	/**
	 * Nome: setQtidadeprot
	 * Registra o valor do atributo 'qtidadeprot'.
	 *
	 * @param qtidadeprot valor do atributo qtidadeprot
	 * @see
	 */
	public void setQtidadeprot(String qtidadeprot) {
		this.qtidadeprot = qtidadeprot;
	}
	
	/**
	 * Nome: getCctrocusto
	 * Recupera o valor do atributo 'cctrocusto'.
	 *
	 * @return valor do atributo 'cctrocusto'
	 * @see
	 */
	public String getCctrocusto() {
		return cctrocusto;
	}
	
	/**
	 * Nome: setCctrocusto
	 * Registra o valor do atributo 'cctrocusto'.
	 *
	 * @param cctrocusto valor do atributo cctrocusto
	 * @see
	 */
	public void setCctrocusto(String cctrocusto) {
		this.cctrocusto = cctrocusto;
	}
	
	/**
	 * Nome: getProtocolo
	 * Recupera o valor do atributo 'protocolo'.
	 *
	 * @return valor do atributo 'protocolo'
	 * @see
	 */
	public String getProtocolo() {
		return protocolo;
	}
	
	/**
	 * Nome: setProtocolo
	 * Registra o valor do atributo 'protocolo'.
	 *
	 * @param protocolo valor do atributo protocolo
	 * @see
	 */
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	
	/**
	 * Nome: getFrwk3codlayout
	 * Recupera o valor do atributo 'frwk3codlayout'.
	 *
	 * @return valor do atributo 'frwk3codlayout'
	 * @see
	 */
	public String getFrwk3codlayout() {
		return frwk3codlayout;
	}
	
	/**
	 * Nome: setFrwk3codlayout
	 * Registra o valor do atributo 'frwk3codlayout'.
	 *
	 * @param frwk3codlayout valor do atributo frwk3codlayout
	 * @see
	 */
	public void setFrwk3codlayout(String frwk3codlayout) {
		this.frwk3codlayout = frwk3codlayout;
	}
	
	/**
	 * Nome: getFrwk3tamlayout
	 * Recupera o valor do atributo 'frwk3tamlayout'.
	 *
	 * @return valor do atributo 'frwk3tamlayout'
	 * @see
	 */
	public String getFrwk3tamlayout() {
		return frwk3tamlayout;
	}
	
	/**
	 * Nome: setFrwk3tamlayout
	 * Registra o valor do atributo 'frwk3tamlayout'.
	 *
	 * @param frwk3tamlayout valor do atributo frwk3tamlayout
	 * @see
	 */
	public void setFrwk3tamlayout(String frwk3tamlayout) {
		this.frwk3tamlayout = frwk3tamlayout;
	}
	
	/**
	 * Nome: getQtidademens
	 * Recupera o valor do atributo 'qtidademens'.
	 *
	 * @return valor do atributo 'qtidademens'
	 * @see
	 */
	public String getQtidademens() {
		return qtidademens;
	}
	
	/**
	 * Nome: setQtidademens
	 * Registra o valor do atributo 'qtidademens'.
	 *
	 * @param qtidademens valor do atributo qtidademens
	 * @see
	 */
	public void setQtidademens(String qtidademens) {
		this.qtidademens = qtidademens;
	}
	
	/**
	 * Nome: getCodmens
	 * Recupera o valor do atributo 'codmens'.
	 *
	 * @return valor do atributo 'codmens'
	 * @see
	 */
	public String getCodmens() {
		return codmens;
	}
	
	/**
	 * Nome: setCodmens
	 * Registra o valor do atributo 'codmens'.
	 *
	 * @param codmens valor do atributo codmens
	 * @see
	 */
	public void setCodmens(String codmens) {
		this.codmens = codmens;
	}
	
	/**
	 * Nome: getTipmens
	 * Recupera o valor do atributo 'tipmens'.
	 *
	 * @return valor do atributo 'tipmens'
	 * @see
	 */
	public String getTipmens() {
		return tipmens;
	}
	
	/**
	 * Nome: setTipmens
	 * Registra o valor do atributo 'tipmens'.
	 *
	 * @param tipmens valor do atributo tipmens
	 * @see
	 */
	public void setTipmens(String tipmens) {
		this.tipmens = tipmens;
	}
	
	/**
	 * Nome: getNivmens
	 * Recupera o valor do atributo 'nivmens'.
	 *
	 * @return valor do atributo 'nivmens'
	 * @see
	 */
	public String getNivmens() {
		return nivmens;
	}
	
	/**
	 * Nome: setNivmens
	 * Registra o valor do atributo 'nivmens'.
	 *
	 * @param nivmens valor do atributo nivmens
	 * @see
	 */
	public void setNivmens(String nivmens) {
		this.nivmens = nivmens;
	}
	
	/**
	 * Nome: getTammens
	 * Recupera o valor do atributo 'tammens'.
	 *
	 * @return valor do atributo 'tammens'
	 * @see
	 */
	public String getTammens() {
		return tammens;
	}
	
	/**
	 * Nome: setTammens
	 * Registra o valor do atributo 'tammens'.
	 *
	 * @param tammens valor do atributo tammens
	 * @see
	 */
	public void setTammens(String tammens) {
		this.tammens = tammens;
	}
	
	/**
	 * Nome: getTexmens
	 * Recupera o valor do atributo 'texmens'.
	 *
	 * @return valor do atributo 'texmens'
	 * @see
	 */
	public String getTexmens() {
		return texmens;
	}
	
	/**
	 * Nome: setTexmens
	 * Registra o valor do atributo 'texmens'.
	 *
	 * @param texmens valor do atributo texmens
	 * @see
	 */
	public void setTexmens(String texmens) {
		this.texmens = texmens;
	}
	
	/**
	 * Nome: getTipousuario
	 * Recupera o valor do atributo 'tipousuario'.
	 *
	 * @return valor do atributo 'tipousuario'
	 * @see
	 */
	public String getTipousuario() {
		return tipousuario;
	}
	
	/**
	 * Nome: setTipousuario
	 * Registra o valor do atributo 'tipousuario'.
	 *
	 * @param tipousuario valor do atributo tipousuario
	 * @see
	 */
	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}
	
	/**
	 * Nome: getSolicass
	 * Recupera o valor do atributo 'solicass'.
	 *
	 * @return valor do atributo 'solicass'
	 * @see
	 */
	public String getSolicass() {
		return solicass;
	}
	
	/**
	 * Nome: setSolicass
	 * Registra o valor do atributo 'solicass'.
	 *
	 * @param solicass valor do atributo solicass
	 * @see
	 */
	public void setSolicass(String solicass) {
		this.solicass = solicass;
	}
	
	/**
	 * Nome: getSolicalcad
	 * Recupera o valor do atributo 'solicalcad'.
	 *
	 * @return valor do atributo 'solicalcad'
	 * @see
	 */
	public String getSolicalcad() {
		return solicalcad;
	}
	
	/**
	 * Nome: setSolicalcad
	 * Registra o valor do atributo 'solicalcad'.
	 *
	 * @param solicalcad valor do atributo solicalcad
	 * @see
	 */
	public void setSolicalcad(String solicalcad) {
		this.solicalcad = solicalcad;
	}
	
	/**
	 * Nome: getSolicexec
	 * Recupera o valor do atributo 'solicexec'.
	 *
	 * @return valor do atributo 'solicexec'
	 * @see
	 */
	public String getSolicexec() {
		return solicexec;
	}
	
	/**
	 * Nome: setSolicexec
	 * Registra o valor do atributo 'solicexec'.
	 *
	 * @param solicexec valor do atributo solicexec
	 * @see
	 */
	public void setSolicexec(String solicexec) {
		this.solicexec = solicexec;
	}
	
	/**
	 * Nome: getReftancode
	 * Recupera o valor do atributo 'reftancode'.
	 *
	 * @return valor do atributo 'reftancode'
	 * @see
	 */
	public String getReftancode() {
		return reftancode;
	}
	
	/**
	 * Nome: setReftancode
	 * Registra o valor do atributo 'reftancode'.
	 *
	 * @param reftancode valor do atributo reftancode
	 * @see
	 */
	public void setReftancode(String reftancode) {
		this.reftancode = reftancode;
	}
	
	/**
	 * Nome: getCeltancode
	 * Recupera o valor do atributo 'celtancode'.
	 *
	 * @return valor do atributo 'celtancode'
	 * @see
	 */
	public String getCeltancode() {
		return celtancode;
	}
	
	/**
	 * Nome: setCeltancode
	 * Registra o valor do atributo 'celtancode'.
	 *
	 * @param celtancode valor do atributo celtancode
	 * @see
	 */
	public void setCeltancode(String celtancode) {
		this.celtancode = celtancode;
	}
}
