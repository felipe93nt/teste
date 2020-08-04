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

import java.util.List;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;


/**
 * Nome: GSEGGLAFResponse
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
public class GSEGGLAFResponse extends AnnotatedAdapter {
	
	/** Atributo codlayout. */
	@Adapter(transactionField = "GSEGAF-BLOCO-HEADER.GSEGAF-COD-LAYOUT")
	private String codlayout = "GSEGGLAF";
	
	/** Atributo tamlayout. */
	@Adapter(transactionField = "GSEGAF-BLOCO-HEADER.GSEGAF-TAM-LAYOUT")
	private Integer tamlayout = 270;
	
	/** Atributo retcode. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-RET-CODE")
	private String retcode = "";
	
	/** Atributo idusuario. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-ID-USUARIO")
	private String idusuario = "";
	
	/** Atributo nomeusuar. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-NOME-USUAR")
	private String nomeusuar = "";
	
	/** Atributo tipousuario. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-TIPO-USUARIO")
	private String tipousuario = "";
	
	/** Atributo codempresa. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-COD-EMPRESA")
	private String codempresa = "";
	
	/** Atributo coddepend. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-COD-DEPEND")
	private String coddepend = "";
	
	/** Atributo codsessao. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-COD-SECAO")
	private String codsessao = "";
	
	/** Atributo tpalcad. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-INDCD-TP-ALCAD")
	private String tpalcad = "";
	
	/** Atributo indmaisperfil. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-IND-MAIS-PERFIL")
	private String indmaisperfil = "";
	
	/** Atributo qtdperfil. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-GRP-PERFIL.GSEGAF-QTDE-PERFIL")
	private Integer qtdperfil = 0;
	
	/** Atributo codperfil. */
	@Adapter(transactionField = "GSEGAF-REGISTRO.GSEGAF-BLOCO-SAIDA.GSEGAF-GRP-PERFIL.GSEGAF-COD-PERFIL")
	private List<String> codperfil = null;
	
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
	 * Nome: getRetcode
	 * Recupera o valor do atributo 'retcode'.
	 *
	 * @return valor do atributo 'retcode'
	 * @see
	 */
	public String getRetcode() {
		return retcode;
	}
	
	/**
	 * Nome: setRetcode
	 * Registra o valor do atributo 'retcode'.
	 *
	 * @param retcode valor do atributo retcode
	 * @see
	 */
	public void setRetcode(String retcode) {
		this.retcode = retcode;
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
	 * Nome: getNomeusuar
	 * Recupera o valor do atributo 'nomeusuar'.
	 *
	 * @return valor do atributo 'nomeusuar'
	 * @see
	 */
	public String getNomeusuar() {
		return nomeusuar;
	}
	
	/**
	 * Nome: setNomeusuar
	 * Registra o valor do atributo 'nomeusuar'.
	 *
	 * @param nomeusuar valor do atributo nomeusuar
	 * @see
	 */
	public void setNomeusuar(String nomeusuar) {
		this.nomeusuar = nomeusuar;
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
	 * Nome: getCodempresa
	 * Recupera o valor do atributo 'codempresa'.
	 *
	 * @return valor do atributo 'codempresa'
	 * @see
	 */
	public String getCodempresa() {
		return codempresa;
	}
	
	/**
	 * Nome: setCodempresa
	 * Registra o valor do atributo 'codempresa'.
	 *
	 * @param codempresa valor do atributo codempresa
	 * @see
	 */
	public void setCodempresa(String codempresa) {
		this.codempresa = codempresa;
	}
	
	/**
	 * Nome: getCoddepend
	 * Recupera o valor do atributo 'coddepend'.
	 *
	 * @return valor do atributo 'coddepend'
	 * @see
	 */
	public String getCoddepend() {
		return coddepend;
	}
	
	/**
	 * Nome: setCoddepend
	 * Registra o valor do atributo 'coddepend'.
	 *
	 * @param coddepend valor do atributo coddepend
	 * @see
	 */
	public void setCoddepend(String coddepend) {
		this.coddepend = coddepend;
	}
	
	/**
	 * Nome: getCodsessao
	 * Recupera o valor do atributo 'codsessao'.
	 *
	 * @return valor do atributo 'codsessao'
	 * @see
	 */
	public String getCodsessao() {
		return codsessao;
	}
	
	/**
	 * Nome: setCodsessao
	 * Registra o valor do atributo 'codsessao'.
	 *
	 * @param codsessao valor do atributo codsessao
	 * @see
	 */
	public void setCodsessao(String codsessao) {
		this.codsessao = codsessao;
	}
	
	/**
	 * Nome: getTpalcad
	 * Recupera o valor do atributo 'tpalcad'.
	 *
	 * @return valor do atributo 'tpalcad'
	 * @see
	 */
	public String getTpalcad() {
		return tpalcad;
	}
	
	/**
	 * Nome: setTpalcad
	 * Registra o valor do atributo 'tpalcad'.
	 *
	 * @param tpalcad valor do atributo tpalcad
	 * @see
	 */
	public void setTpalcad(String tpalcad) {
		this.tpalcad = tpalcad;
	}
	
	/**
	 * Nome: getIndmaisperfil
	 * Recupera o valor do atributo 'indmaisperfil'.
	 *
	 * @return valor do atributo 'indmaisperfil'
	 * @see
	 */
	public String getIndmaisperfil() {
		return indmaisperfil;
	}
	
	/**
	 * Nome: setIndmaisperfil
	 * Registra o valor do atributo 'indmaisperfil'.
	 *
	 * @param indmaisperfil valor do atributo indmaisperfil
	 * @see
	 */
	public void setIndmaisperfil(String indmaisperfil) {
		this.indmaisperfil = indmaisperfil;
	}
	
	/**
	 * Nome: getQtdperfil
	 * Recupera o valor do atributo 'qtdperfil'.
	 *
	 * @return valor do atributo 'qtdperfil'
	 * @see
	 */
	public Integer getQtdperfil() {
		return qtdperfil;
	}
	
	/**
	 * Nome: setQtdperfil
	 * Registra o valor do atributo 'qtdperfil'.
	 *
	 * @param qtdperfil valor do atributo qtdperfil
	 * @see
	 */
	public void setQtdperfil(Integer qtdperfil) {
		this.qtdperfil = qtdperfil;
	}
	
	/**
	 * Nome: getCodperfil
	 * Recupera o valor do atributo 'codperfil'.
	 *
	 * @return valor do atributo 'codperfil'
	 * @see
	 */
	public List<String> getCodperfil() {
		return codperfil;
	}
	
	/**
	 * Nome: setCodperfil
	 * Registra o valor do atributo 'codperfil'.
	 *
	 * @param codperfil valor do atributo codperfil
	 * @see
	 */
	public void setCodperfil(List<String> codperfil) {
		this.codperfil = codperfil;
	}
}