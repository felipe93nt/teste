package br.com.bradesco.web.ricc.view.bean.treinamento.felipe.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.felipe.viewhelper.FelipeClienteViewHelper;

/**
 * @name FelipeClienteBean
 * @author Felipe Romon - Foursys
 * @see FelipeCleinteBean.java
 * @version 1.0
 * @since 04/05/2020
 */
@SessionScoped
@Named(value = "felipeClienteBean")
public class FelipeClienteBean extends AbstractBean<FelipeClienteViewHelper> {
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
		this.viewHelper = new FelipeClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_FELIPE_CLIENTE_INSERIR;
	}

	/**
	 * @description
	 * @name salvar
	 * @see FelipeClienteBean
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
	
	//metodo para voltar para o index
	public String voltar() {

		return paginaAnterior;
	}
	
	//metodo de validar campos para salvar
	public boolean validaCampos() {
		boolean retorno = true;
		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_nome");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_cpf");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_rg");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getDataNasc())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_dataNasc");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_radio_sexo");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_logradouro");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_numero");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_bairro");
			retorno = false;
		}

		if (viewHelper.getCidade().equals("0")) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_combobox_cidade");
			retorno = false;
		}

		if (viewHelper.getEstado().equals("0")) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_combobox_estado");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_cep");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_telefone");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_celular");
			retorno = false;
		}

		return retorno;
	}

	//metodo para limpar campos da tela
	public void limparCampos() {

		viewHelper.setNome(null);
		viewHelper.setCpf(null);
		viewHelper.setRg(null);
		viewHelper.setDataNasc(null);
		viewHelper.setSexo(null);
		viewHelper.setLogradouro(null);
		viewHelper.setNumero(null);
		viewHelper.setComplemento(null);
		viewHelper.setBairro(null);
		viewHelper.setCidade("0");
		viewHelper.setEstado("0");
		viewHelper.setCep(null);
		viewHelper.setTelefone(null);
		viewHelper.setCelular(null);
		viewHelper.setEmail(null);
		
	}

}//fim da classe
