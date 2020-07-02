/**
 * Nome: br.com.bradesco.web.piloto.service.awbConnector.adapter.logon
 *
 * Propósito: Classes de uso comum para a funcionalidade
 *
 * Data da Criação: 17/02/2011
 *
 * Compilador: 1.5.0_11
 * Parâmetros de Compilação: -d
 *
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.logon;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.data.connector.AnnotatedAdapter;
import br.com.bradesco.data.connector.commarea.annotations.legacy.Legacy;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaContainer;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaField;


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
@SuppressWarnings("deprecation")
@Legacy
public class GSEGGLAFResponse extends AnnotatedAdapter {

	/** Atributo codlayout. */
	@CommareaField(name = { "GSEGAF-BLOCO-HEADER","GSEGAF-COD-LAYOUT" }, usage = "DISPLAY", maxLength = 8, fieldNumber = 1, pic = "X(008)", maxBytes = 8)
	private String codlayout = "GSEGGLAF";

	/** Atributo tamlayout. */
	@CommareaField(name = { "GSEGAF-BLOCO-HEADER","GSEGAF-TAM-LAYOUT" }, usage = "DISPLAY", maxLength = 5, fieldNumber = 2, pic = "9(005)", maxBytes = 5)
	private Integer tamlayout = 270;

	/** Atributo retcode. */
	@CommareaField(name = { "GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-RET-CODE" }, usage = "DISPLAY", maxLength = 2, fieldNumber = 3, pic = "X(002)", maxBytes = 2)
	private String retcode = "";

	/** Atributo idusuario. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-ID-USUARIO" }, usage = "DISPLAY", maxLength = 30, fieldNumber = 4, pic = "X(030)", maxBytes = 30)
	private String idusuario = "";

	/** Atributo nomeusuar. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-NOME-USUAR" }, usage = "DISPLAY", maxLength = 40, fieldNumber = 5, pic = "X(040)", maxBytes = 40)
	private String nomeusuar = "";

	/** Atributo tipousuario. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-TIPO-USUARIO" }, usage = "DISPLAY", maxLength = 1, fieldNumber = 6, pic = "X(001)", maxBytes = 1)
	private String tipousuario = "";

	/** Atributo codempresa. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-COD-EMPRESA" }, usage = "DISPLAY", maxLength = 10, fieldNumber = 7, pic = "9(010)", maxBytes = 10)
	private String codempresa = "";

	/** Atributo coddepend. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-COD-DEPEND" }, usage = "DISPLAY", maxLength = 5, fieldNumber = 8, pic = "9(005)", maxBytes = 5)
	private String coddepend = "";

	/** Atributo codsessao. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-COD-SECAO" }, usage = "DISPLAY", maxLength = 3, fieldNumber = 9, pic = "9(003)", maxBytes = 3)
	private String codsessao = "";

	/** Atributo tpalcad. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-INDCD-TP-ALCAD" }, usage = "DISPLAY", maxLength = 3, fieldNumber = 10, pic = "X(003)", maxBytes = 3)
	private String tpalcad = "";

	/** Atributo indmaisperfil. */
	@CommareaField(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA","GSEGAF-IND-MAIS-PERFIL" }, usage = "DISPLAY", maxLength = 1, fieldNumber = 11, pic = "X(001)", maxBytes = 1)
	private String indmaisperfil = "";

	/** Atributo qtdperfil. */
	@CommareaField(name = { "GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA", "GSEGAF-GRP-PERFIL","GSEGAF-QTDE-PERFIL" }, usage = "DISPLAY", maxLength = 2, fieldNumber = 12, pic = "9(002)", maxBytes = 2)
	private Integer qtdperfil = 0;

	/** Atributo codperfil"," */
	@CommareaContainer(name = {"GSEGAF-REGISTRO", "GSEGAF-BLOCO-SAIDA", "GSEGAF-GRP-PERFIL", "GSEGAF-COD-PERFIL"}, dependsOn="GSEGAF-QTDE-PERFIL", fieldNumber=13, maxOccurs=20, minOccurs=1, type=String.class)
	private List<String> codperfil = new ArrayList<String>();


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
        if (codperfil == null) {
        	codperfil = new ArrayList<String>();
        }
        return this.codperfil;
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