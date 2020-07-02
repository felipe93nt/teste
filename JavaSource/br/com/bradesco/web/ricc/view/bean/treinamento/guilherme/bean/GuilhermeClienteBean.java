package br.com.bradesco.web.ricc.view.bean.treinamento.guilherme.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.guilherme.viewhelper.GuilhermeClienteViewHelper;

/**
 * @name GuilhermeClienteBean
 * @author Guilherme Tomaz - Foursys
 * @see GuilhermeClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "guilhermeClienteBean")
public class GuilhermeClienteBean extends
		AbstractBean<GuilhermeClienteViewHelper> {
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
		this.viewHelper = new GuilhermeClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_GUILHERME_CLIENTE_INSERIR;
	}

	public String iniciarPaginaConsulta() {
		this.viewHelper = new GuilhermeClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_GUILHERME_CLIENTE_CONSULTAR;
	}

	/**
	 * @description
	 * @name salvar
	 * @see GuilhermeClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validarCampos().equals("")) {
			String retorno = "Cliente cadastrado com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		}

		return null;
	}

	public String voltar() {

		return paginaAnterior;
	}

	public String validarCampos() {
		StringBuilder mensagem = new StringBuilder();
		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			mensagem.append("O campo Nome � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			mensagem.append("O campo CPF � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			mensagem.append("O campo RG � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			mensagem.append("O campo Data de Nascimento � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			mensagem.append("O campo Sexo � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			mensagem.append("O campo Logradouro � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumeroLogradouro())) {
			mensagem.append("O campo N�mero � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			mensagem.append("O campo Bairro � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCidade().replace("0", ""))) {
			mensagem.append("O campo Cidade � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getEstado().replace("0", ""))) {
			mensagem.append("O campo Estado � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			mensagem.append("O campo CEP � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			mensagem.append("O campo Telefone � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			mensagem.append("O campo Celular � Obrigat�rio");
			mensagem.append("<br> <br>");
		}
		if (!mensagem.toString().equals("")) {
			BradescoFacesUtils.addErrorModalMessage(mensagem.toString());
		}

		return mensagem.toString();
	}

	
}
