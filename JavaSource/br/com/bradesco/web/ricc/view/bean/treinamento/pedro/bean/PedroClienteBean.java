package br.com.bradesco.web.ricc.view.bean.treinamento.pedro.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.pedro.viewhelper.PedroClienteViewHelper;

/**
 * @name PedroClienteBean
 * @author Pedro Bido - Foursys
 * @see PedroClienteBean.java
 * @version 1.0
 * @since 06/05/2020
 */
@SessionScoped
@Named(value = "pedroClienteBean")
public class PedroClienteBean extends AbstractBean<PedroClienteViewHelper> {
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
		this.viewHelper = new PedroClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_PEDRO_CLIENTE;
	}

	/**
	 * @description
	 * @name salvar
	 * @see PedroClienteBean
	 * @return String
	 */
	public String salvar() {
		if (validarCamposCliente()) {
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		}
		return null;
	}

	public String voltar() {

		return paginaAnterior;
	}

	/**
	 * @description Método para limpar todos os campos da tela de cadastro de
	 *              cliente
	 * @name validarCamposPesquisa
	 * @see PedroClienteBean
	 * @return void
	 */
	public void limparCampos() {
		PedroClienteViewHelper model = this.viewHelper;
		model.setNome(VAZIO);
		model.setCpf(VAZIO);
		model.setRg(VAZIO);
		model.setDataNascimento(VAZIO);
		model.setSexo(VAZIO);
		model.setLogradouro(VAZIO);
		model.setNumeroLogradouro(VAZIO);
		model.setComplemento(VAZIO);
		model.setBairro(VAZIO);
		model.setCidade(VAZIO);
		model.setEstado(VAZIO);
		model.setCep(VAZIO);
		model.setTelefone(VAZIO);
		model.setCelular(VAZIO);
		model.setEmail(VAZIO);
	}

	/**
	 * @description Método para validar os campos da tela de cadastro de cliente
	 *              antes de salvar
	 * @name validarCamposCliente
	 * @see PedroClienteBean
	 * @return boolean
	 */
	public boolean validarCamposCliente() {
		PedroClienteViewHelper model = this.viewHelper;

		String camposNaoPreenchidos = "";
		String msg_treinamento_pedro_campos_obrigatorios = "Os seguintes campos são obrigatórios:";

		if (siteUtil.isEmptyOrNull(model.getNome())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Nome,";
		}
		if (siteUtil.isEmptyOrNull(model.getCpf())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - CPF,";
		}
		if (siteUtil.isEmptyOrNull(model.getRg())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - RG,";
		}
		if (siteUtil.isEmptyOrNull(model.getDataNascimento())) {
			camposNaoPreenchidos = camposNaoPreenchidos
					+ " - Data de nascimento,";
		}
		if (siteUtil.isEmptyOrNull(model.getSexo())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Sexo,";
		}
		if (siteUtil.isEmptyOrNull(model.getLogradouro())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Logradouro,";
		}
		if (siteUtil.isEmptyOrNull(model.getNumeroLogradouro())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Número,";
		}
		if (siteUtil.isEmptyOrNull(model.getBairro())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Bairro,";
		}
		if (siteUtil.isEmptyOrNull(model.getCidade())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Cidade,";
		}
		if (siteUtil.isEmptyOrNull(model.getEstado())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Estado,";
		}
		if (siteUtil.isEmptyOrNull(model.getCep())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - CEP,";
		}
		if (siteUtil.isEmptyOrNull(model.getTelefone())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Telefone,";
		}
		if (siteUtil.isEmptyOrNull(model.getCelular())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Celular,";
		} else if (model.getCelular().length() != 14) {
			BradescoFacesUtils.addInfoModalMessage(
					"Número de celular inválido.", false);
			return false;
		}
		if (siteUtil.isNotEmptyOrNull(camposNaoPreenchidos)) {
			BradescoFacesUtils.addInfoModalMessage(
					msg_treinamento_pedro_campos_obrigatorios, false);
			String camposNaoPreenchidosArray[] = camposNaoPreenchidos
					.split(",");
			for (int i = 0; i < camposNaoPreenchidosArray.length; i++) {
				BradescoFacesUtils.addInfoModalMessage(
						camposNaoPreenchidosArray[i], false);
			}
			return false;
		} else {
			return true;
		}

	}

}
