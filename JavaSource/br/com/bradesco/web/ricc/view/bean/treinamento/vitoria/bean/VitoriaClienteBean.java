package br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.viewhelper.VitoriaClienteViewHelper;

/**
 * @name VitoriaClienteBean
 * @author Vitoria Furtado - Foursys
 * @see VitoriaClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "vitoriaClienteBean")
public class VitoriaClienteBean extends AbstractBean<VitoriaClienteViewHelper> {
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
		this.viewHelper = new VitoriaClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_VITORIA;
	}

	/**
	 * @description
	 * @name salvar
	 * @see VitoriaClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validaCampos()) {
			String retorno = "Cliente salvo com sucesso!";

			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);

			limparCampos();
		}
		return null;

	}

	public boolean validaCampos() {
		
		boolean volta= true;
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNome())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_nome");
			volta= false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_rg");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_cpf");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_dataNascimento");
			volta=false;
		}
		if (!siteUtil.validaUmCampoPreenchidoString(this.viewHelper.getSexo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_sexo");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_logradouro");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_numeroLogradouro");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_bairro");
			volta=false;
		}
		if (this.getViewHelper().getCidade()
				.equals((RiccConstants.TREINAMENTO_VITORIA_CIDADE_1))) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_cidade");
			volta=false;
		}
		if (this.getViewHelper().getEstado()
				.equals((RiccConstants.TREINAMENTO_VITORIA_ESTADO_1))) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_estado");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_cep");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_telefone");
			volta=false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_vitoria_celular");
			volta=false;
		}
		return volta;
	}

	public void limparCampos() {
		this.viewHelper.setNome(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setTelefone(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setEmail(null);
		this.viewHelper.setBairro(null);
	}

	public String voltar() {

		return paginaAnterior;
	}

}
