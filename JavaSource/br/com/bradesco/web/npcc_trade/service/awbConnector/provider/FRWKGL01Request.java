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


/**
 * Nome: FRWKGL01Request
 * Propósito:  Classe filha generica
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
public class FRWKGL01Request extends AnnotatedAdapter {
	
	/**
	 * Construtor Padrão
	 * Instancia um novo objeto FRWKGL01Request.
	 */
	public FRWKGL01Request() {
		//super.setParameter(new FRWKParameters());
	}

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
	
	//GSEGGLAA
	/** Atributo gsegcodlayout. */
	@Adapter(transactionField = "GSEGAA-BLOCO-HEADER.GSEGAA-COD-LAYOUT")
	private String gsegcodlayout = "GSEGGLAA";
	
	/** Atributo gsegtamlayout. */
	@Adapter(transactionField = "GSEGAA-BLOCO-HEADER.GSEGAA-TAM-LAYOUT")
	private String gsegtamlayout = "230";
	
	/** Atributo ticketsgrca. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-TICKET-SGRCA")
	private String ticketsgrca = "";
	
	/** Atributo frmtusuario. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-FRMT-USUARIO")
	private String frmtusuario = "";
	
	/** Atributo idusuario. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-ID-USUARIO")
	private String idusuario = "";
	
	/** Atributo indcdass. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-INDCD-ASS")
	private String indcdass = "";
	
	/** Atributo indcdalcad. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-INDCD-ALCAD")
	private String indcdalcad = "";
	
	/** Atributo idtpass. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-ID-TP-ASS")
	private String idtpass = "";
	
	/** Atributo frmtusuarioass. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-FRMT-USUARIO-ASS")
	private String frmtusuarioass = "";
	
	/** Atributo idusuarioass. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-ID-USUARIO-ASS")
	private String idusuarioass = "";
	
	/** Atributo criptass. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-INDCD-CRIPT-ASS")
	private String criptass = "";
	
	/** Atributo chvvalid. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-CHV-VALID")
	private String chvvalid = "";
	
	/** Atributo param01. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-PARAM-01")
	private String param01 = "";
	
	/** Atributo param02. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-PARAM-02")
	private String param02 = "";
	
	/** Atributo param03. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-PARAM-03")
	private String param03 = "";
	
	/** Atributo param04. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ASS.GSEGAA-PARAM-04")
	private String param04 = "";
	
	/** Atributo idusuarioalcada. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ALCAD.GSEGAA-ID-USUARIO-ALCAD")
	private String idusuarioalcada = "";
	
	/** Atributo senhaalcad. */
	@Adapter(transactionField = "GSEGAA-REGISTRO.GSEGAA-BLOCO-ALCAD.GSEGAA-SENHA-ALCAD")
	private String senhaalcad = "";
	
	/** Atributo versaoaplic. */
	@Adapter(transactionField = "FRWKW090-BLOCO-ENTRADA.FRWKW090-VERSAO-APLIC")
	private String versaoaplic = "";
	
	/** Atributo qtderegpag. */
	@Adapter(transactionField = "FRWKW090-BLOCO-ENTRADA.FRWKW090-QTDE-REG-PAG")
	private String qtderegpag = "";
	
	/** Atributo qtderegmain. */
	@Adapter(transactionField = "FRWKW090-BLOCO-ENTRADA.FRWKW090-QTDE-REG-MAIN")
	private String qtderegmain = "";
	
	/** Atributo frwkw090codlayout. */
	@Adapter(transactionField = "FRWKW090-BLOCO-HEADER.FRWKW090-COD-LAYOUT")
	private String frwkw090codlayout = "FRWKW090";
	
	/** Atributo frwkw090tamlayout. */
	@Adapter(transactionField = "FRWKW090-BLOCO-HEADER.FRWKW090-TAM-LAYOUT")
	private String frwkw090tamlayout = "26";

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
	 * Nome: getIndcdass
	 * Recupera o valor do atributo 'indcdass'.
	 *
	 * @return valor do atributo 'indcdass'
	 * @see
	 */
	public String getIndcdass() {
		return indcdass;
	}
	
	/**
	 * Nome: setIndcdass
	 * Registra o valor do atributo 'indcdass'.
	 *
	 * @param indcdass valor do atributo indcdass
	 * @see
	 */
	public void setIndcdass(String indcdass) {
		this.indcdass = indcdass;
	}
	
	/**
	 * Nome: getIndcdalcad
	 * Recupera o valor do atributo 'indcdalcad'.
	 *
	 * @return valor do atributo 'indcdalcad'
	 * @see
	 */
	public String getIndcdalcad() {
		return indcdalcad;
	}
	
	/**
	 * Nome: setIndcdalcad
	 * Registra o valor do atributo 'indcdalcad'.
	 *
	 * @param indcdalcad valor do atributo indcdalcad
	 * @see
	 */
	public void setIndcdalcad(String indcdalcad) {
		this.indcdalcad = indcdalcad;
	}
	
	/**
	 * Nome: getIdtpass
	 * Recupera o valor do atributo 'idtpass'.
	 *
	 * @return valor do atributo 'idtpass'
	 * @see
	 */
	public String getIdtpass() {
		return idtpass;
	}
	
	/**
	 * Nome: setIdtpass
	 * Registra o valor do atributo 'idtpass'.
	 *
	 * @param idtpass valor do atributo idtpass
	 * @see
	 */
	public void setIdtpass(String idtpass) {
		this.idtpass = idtpass;
	}
	
	/**
	 * Nome: getFrmtusuarioass
	 * Recupera o valor do atributo 'frmtusuarioass'.
	 *
	 * @return valor do atributo 'frmtusuarioass'
	 * @see
	 */
	public String getFrmtusuarioass() {
		return frmtusuarioass;
	}
	
	/**
	 * Nome: setFrmtusuarioass
	 * Registra o valor do atributo 'frmtusuarioass'.
	 *
	 * @param frmtusuarioass valor do atributo frmtusuarioass
	 * @see
	 */
	public void setFrmtusuarioass(String frmtusuarioass) {
		this.frmtusuarioass = frmtusuarioass;
	}
	
	/**
	 * Nome: getIdusuarioass
	 * Recupera o valor do atributo 'idusuarioass'.
	 *
	 * @return valor do atributo 'idusuarioass'
	 * @see
	 */
	public String getIdusuarioass() {
		return idusuarioass;
	}
	
	/**
	 * Nome: setIdusuarioass
	 * Registra o valor do atributo 'idusuarioass'.
	 *
	 * @param idusuarioass valor do atributo idusuarioass
	 * @see
	 */
	public void setIdusuarioass(String idusuarioass) {
		this.idusuarioass = idusuarioass;
	}
	
	/**
	 * Nome: getCriptass
	 * Recupera o valor do atributo 'criptass'.
	 *
	 * @return valor do atributo 'criptass'
	 * @see
	 */
	public String getCriptass() {
		return criptass;
	}
	
	/**
	 * Nome: setCriptass
	 * Registra o valor do atributo 'criptass'.
	 *
	 * @param criptass valor do atributo criptass
	 * @see
	 */
	public void setCriptass(String criptass) {
		this.criptass = criptass;
	}
	
	/**
	 * Nome: getChvvalid
	 * Recupera o valor do atributo 'chvvalid'.
	 *
	 * @return valor do atributo 'chvvalid'
	 * @see
	 */
	public String getChvvalid() {
		return chvvalid;
	}
	
	/**
	 * Nome: setChvvalid
	 * Registra o valor do atributo 'chvvalid'.
	 *
	 * @param chvvalid valor do atributo chvvalid
	 * @see
	 */
	public void setChvvalid(String chvvalid) {
		this.chvvalid = chvvalid;
	}
	
	/**
	 * Nome: getParam01
	 * Recupera o valor do atributo 'param01'.
	 *
	 * @return valor do atributo 'param01'
	 * @see
	 */
	public String getParam01() {
		return param01;
	}
	
	/**
	 * Nome: setParam01
	 * Registra o valor do atributo 'param01'.
	 *
	 * @param param01 valor do atributo param01
	 * @see
	 */
	public void setParam01(String param01) {
		this.param01 = param01;
	}
	
	/**
	 * Nome: getParam02
	 * Recupera o valor do atributo 'param02'.
	 *
	 * @return valor do atributo 'param02'
	 * @see
	 */
	public String getParam02() {
		return param02;
	}
	
	/**
	 * Nome: setParam02
	 * Registra o valor do atributo 'param02'.
	 *
	 * @param param02 valor do atributo param02
	 * @see
	 */
	public void setParam02(String param02) {
		this.param02 = param02;
	}
	
	/**
	 * Nome: getParam03
	 * Recupera o valor do atributo 'param03'.
	 *
	 * @return valor do atributo 'param03'
	 * @see
	 */
	public String getParam03() {
		return param03;
	}
	
	/**
	 * Nome: setParam03
	 * Registra o valor do atributo 'param03'.
	 *
	 * @param param03 valor do atributo param03
	 * @see
	 */
	public void setParam03(String param03) {
		this.param03 = param03;
	}
	
	/**
	 * Nome: getParam04
	 * Recupera o valor do atributo 'param04'.
	 *
	 * @return valor do atributo 'param04'
	 * @see
	 */
	public String getParam04() {
		return param04;
	}
	
	/**
	 * Nome: setParam04
	 * Registra o valor do atributo 'param04'.
	 *
	 * @param param04 valor do atributo param04
	 * @see
	 */
	public void setParam04(String param04) {
		this.param04 = param04;
	}
	
	/**
	 * Nome: getIdusuarioalcada
	 * Recupera o valor do atributo 'idusuarioalcada'.
	 *
	 * @return valor do atributo 'idusuarioalcada'
	 * @see
	 */
	public String getIdusuarioalcada() {
		return idusuarioalcada;
	}
	
	/**
	 * Nome: setIdusuarioalcada
	 * Registra o valor do atributo 'idusuarioalcada'.
	 *
	 * @param idusuarioalcada valor do atributo idusuarioalcada
	 * @see
	 */
	public void setIdusuarioalcada(String idusuarioalcada) {
		this.idusuarioalcada = idusuarioalcada;
	}
	
	/**
	 * Nome: getSenhaalcad
	 * Recupera o valor do atributo 'senhaalcad'.
	 *
	 * @return valor do atributo 'senhaalcad'
	 * @see
	 */
	public String getSenhaalcad() {
		return senhaalcad;
	}
	
	/**
	 * Nome: setSenhaalcad
	 * Registra o valor do atributo 'senhaalcad'.
	 *
	 * @param senhaalcad valor do atributo senhaalcad
	 * @see
	 */
	public void setSenhaalcad(String senhaalcad) {
		this.senhaalcad = senhaalcad;
	}

	/**
	 * Nome: getVersaoaplic
	 * Recupera o valor do atributo 'versaoaplic'.
	 *
	 * @return valor do atributo 'versaoaplic'
	 * @see
	 */
	public String getVersaoaplic() {
		return versaoaplic;
	}
	
	/**
	 * Nome: setVersaoaplic
	 * Registra o valor do atributo 'versaoaplic'.
	 *
	 * @param versaoaplic valor do atributo versaoaplic
	 * @see
	 */
	public void setVersaoaplic(String versaoaplic) {
		this.versaoaplic = versaoaplic;
	}
	
	/**
	 * Nome: getQtderegpag
	 * Recupera o valor do atributo 'qtderegpag'.
	 *
	 * @return valor do atributo 'qtderegpag'
	 * @see
	 */
	public String getQtderegpag() {
		return qtderegpag;
	}
	
	/**
	 * Nome: setQtderegpag
	 * Registra o valor do atributo 'qtderegpag'.
	 *
	 * @param qtderegpag valor do atributo qtderegpag
	 * @see
	 */
	public void setQtderegpag(String qtderegpag) {
		this.qtderegpag = qtderegpag;
	}
	
	/**
	 * Nome: getQtderegmain
	 * Recupera o valor do atributo 'qtderegmain'.
	 *
	 * @return valor do atributo 'qtderegmain'
	 * @see
	 */
	public String getQtderegmain() {
		return qtderegmain;
	}
	
	/**
	 * Nome: setQtderegmain
	 * Registra o valor do atributo 'qtderegmain'.
	 *
	 * @param qtderegmain valor do atributo qtderegmain
	 * @see
	 */
	public void setQtderegmain(String qtderegmain) {
		this.qtderegmain = qtderegmain;
	}
	
	/**
	 * Nome: getFrwkw090codlayout
	 * Recupera o valor do atributo 'frwkw090codlayout'.
	 *
	 * @return valor do atributo 'frwkw090codlayout'
	 * @see
	 */
	public String getFrwkw090codlayout() {
		return frwkw090codlayout;
	}
	
	/**
	 * Nome: setFrwkw090codlayout
	 *
	 * @param frwkw090codlayout valor do atributo frwkw090codlayout
	 * @see
	 */
	public void setFrwkw090codlayout(String frwkw090codlayout) {
		this.frwkw090codlayout = frwkw090codlayout;
	}
	
	/**
	 * Nome: getFrwkw090tamlayout
	 * Recupera o valor do atributo 'frwkw090tamlayout'.
	 *
	 * @return valor do atributo 'frwkw090tamlayout'
	 * @see
	 */
	public String getFrwkw090tamlayout() {
		return frwkw090tamlayout;
	}
	
	/**
	 * Nome: setFrwkw090tamlayout
	 * Registra o valor do atributo 'frwkw090tamlayout'.
	 *
	 * @param frwkw090tamlayout valor do atributo frwkw090tamlayout
	 * @see
	 */
	public void setFrwkw090tamlayout(String frwkw090tamlayout) {
		this.frwkw090tamlayout = frwkw090tamlayout;
	}
	
	
	
}
