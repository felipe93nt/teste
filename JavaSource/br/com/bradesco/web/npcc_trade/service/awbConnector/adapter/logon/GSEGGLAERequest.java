/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon
 * 
 * Propósito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Criação: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Parâmetros de Compilação: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;


/**
 * Nome: GSEGGLAERequest
 * Propósito: Classe filha do adapter Logon
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
public class GSEGGLAERequest extends AnnotatedAdapter {
	
	/** Atributo codlayout. */
	@Adapter(transactionField = "GSEGAE-BLOCO-HEADER.GSEGAE-COD-LAYOUT")
	private String codlayout = "GSEGGLAE";
	
	/** Atributo tamlayout. */
	@Adapter(transactionField = "GSEGAE-BLOCO-HEADER.GSEGAE-TAM-LAYOUT")
	private Integer tamlayout = 41;
	
	/** Atributo idtpauten. */
	@Adapter(transactionField = "GSEGAE-REGISTRO.GSEGAE-BLOCO-ENTRADA.GSEGAE-ID-TP-AUTEN")
	private String idtpauten = "";
	
	/** Atributo indatlzpsw. */
	@Adapter(transactionField = "GSEGAE-REGISTRO.GSEGAE-BLOCO-ENTRADA.GSEGAE-IND-ATLZ-PSWD")
	private String indatlzpsw = "";
	
	/** Atributo pswdatual. */
	@Adapter(transactionField = "GSEGAE-REGISTRO.GSEGAE-BLOCO-ENTRADA.GSEGAE-PSWD-ATUAL")
	private String pswdatual = "";
	
	/** Atributo pswdnova. */
	@Adapter(transactionField = "GSEGAE-REGISTRO.GSEGAE-BLOCO-ENTRADA.GSEGAE-PSWD-NOVA")
	private String pswdnova = "";
	
	/** Atributo pswdconf. */
	@Adapter(transactionField = "GSEGAE-REGISTRO.GSEGAE-BLOCO-ENTRADA.GSEGAE-PSWD-CONF")
	private String pswdconf = "";
	
	/**
	 * Nome: getCodlayout
	 * Recupera o valor do atributo 'codlayout'.
	 *
	 * @return valor do atributo 'codlayout'
	 * @see
	 */
	public String getCodlayout() {
		return codlayout;
	}
	
	/**
	 * Nome: setCodlayout
	 * Registra o valor do atributo 'codlayout'.
	 *
	 * @param codlayout valor do atributo codlayout
	 * @see
	 */
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}
	
	/**
	 * Nome: getTamlayout
	 * Recupera o valor do atributo 'tamlayout'.
	 *
	 * @return valor do atributo 'tamlayout'
	 * @see
	 */
	public Integer getTamlayout() {
		return tamlayout;
	}
	
	/**
	 * Nome: setTamlayout
	 * Registra o valor do atributo 'tamlayout'.
	 *
	 * @param tamlayout valor do atributo tamlayout
	 * @see
	 */
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}
	
	/**
	 * Nome: getIdtpauten
	 * Recupera o valor do atributo 'idtpauten'.
	 *
	 * @return valor do atributo 'idtpauten'
	 * @see
	 */
	public String getIdtpauten() {
		return idtpauten;
	}
	
	/**
	 * Nome: setIdtpauten
	 * Registra o valor do atributo 'idtpauten'.
	 *
	 * @param idtpauten valor do atributo idtpauten
	 * @see
	 */
	public void setIdtpauten(String idtpauten) {
		this.idtpauten = idtpauten;
	}
	
	/**
	 * Nome: getIndatlzpsw
	 * Recupera o valor do atributo 'indatlzpsw'.
	 *
	 * @return valor do atributo 'indatlzpsw'
	 * @see
	 */
	public String getIndatlzpsw() {
		return indatlzpsw;
	}
	
	/**
	 * Nome: setIndatlzpsw
	 * Registra o valor do atributo 'indatlzpsw'.
	 *
	 * @param indatlzpsw valor do atributo indatlzpsw
	 * @see
	 */
	public void setIndatlzpsw(String indatlzpsw) {
		this.indatlzpsw = indatlzpsw;
	}
	
	/**
	 * Nome: getPswdatual
	 * Recupera o valor do atributo 'pswdatual'.
	 *
	 * @return valor do atributo 'pswdatual'
	 * @see
	 */
	public String getPswdatual() {
		return pswdatual;
	}
	
	/**
	 * Nome: setPswdatual
	 * Registra o valor do atributo 'pswdatual'.
	 *
	 * @param pswdatual valor do atributo pswdatual
	 * @see
	 */
	public void setPswdatual(String pswdatual) {
		this.pswdatual = pswdatual;
	}
	
	/**
	 * Nome: getPswdnova
	 * Recupera o valor do atributo 'pswdnova'.
	 *
	 * @return valor do atributo 'pswdnova'
	 * @see
	 */
	public String getPswdnova() {
		return pswdnova;
	}
	
	/**
	 * Nome: setPswdnova
	 * Registra o valor do atributo 'pswdnova'.
	 *
	 * @param pswdnova valor do atributo pswdnova
	 * @see
	 */
	public void setPswdnova(String pswdnova) {
		this.pswdnova = pswdnova;
	}
	
	/**
	 * Nome: getPswdconf
	 * Recupera o valor do atributo 'pswdconf'.
	 *
	 * @return valor do atributo 'pswdconf'
	 * @see
	 */
	public String getPswdconf() {
		return pswdconf;
	}
	
	/**
	 * Nome: setPswdconf
	 * Registra o valor do atributo 'pswdconf'.
	 *
	 * @param pswdconf valor do atributo pswdconf
	 * @see
	 */
	public void setPswdconf(String pswdconf) {
		this.pswdconf = pswdconf;
	}
}