package br.com.bradesco.web.ricc.view.bean.treinamento.isaac.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteIsaacVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.ajuda.bean.AjudaTreinamentoBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.isaac.viewhelper.IsaacClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Diego Munhoz - Foursys
 * @see Equipe4Bean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "isaacClienteBean")
public class IsaacClienteBean extends AbstractBean<IsaacClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new IsaacClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ISAAC;

	}

	public String iniciarPaginaConsulta() {
		this.viewHelper = new IsaacClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ISAAC_CONSULTA;

	}

	/**
	 * @description
	 * @name salvar
	 * @see AjudaTreinamentoBean
	 * @return
	 * @return String
	 */

	String vazio = null;


	public String salvar() {
		if (validarCamposObrigatorios()) {
			
			String retorno = "Cliente salvo com sucesso!";
			limparCamposCadastro();
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		}
		return null;
	}

	public String voltar() {

		return paginaAnterior;
	}

	private void limparCamposCadastro() {
		this.viewHelper.setNomeCompleto(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setEmail(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setTelefone(null);

	}

	public boolean validarCamposObrigatorios() {

		boolean retorno = true;
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNomeCompleto())) {
			String mensagem = "Informe Nome";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			String mensagem = "Informe CPF";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			String mensagem = "Informe RG";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			String mensagem = "Informe Data Nascimento";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getSexo())) {
			String mensagem = "Informe Sexo";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			String mensagem = "Informe Logradouro";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())) {
			String mensagem = "Informe Numero";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			String mensagem = "Informe Bairro";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (this.viewHelper.getCidade().equals(
				RiccConstants.TREINAMENTO_ISAAC_CIDADE)) {
			String mensagem = "Informe Cidade";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (this.viewHelper.getEstado().equals(
				RiccConstants.TREINAMENTO_ISAAC_ESTADO)) {
			String mensagem = "Informe Estado";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			String mensagem = "Informe CEP";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			String mensagem = "Informe Telefone";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			String mensagem = "Informe Celular";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		return retorno;

	}

}
