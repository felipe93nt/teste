package br.com.bradesco.web.ricc.view.bean.treinamento.enrico.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.enrico.viewhelper.EnricoClienteViewHelper;

/**
 * @name EnricoClienteBean
 * @author Enrico Cioffi - Foursys
 * @see EnricoClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "enricoClienteBean")
public class EnricoClienteBean extends AbstractBean<EnricoClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	/**
	 * @description
	 * @name salvar
	 * @see EnricoClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
        if (validarCampos()) {

            try {
                String retorno = "Cliente salvo com sucesso!";
                limparCampos();
                BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
            } catch (Exception e) {

                String retorno = "Erro ao salvar Cliente";
                BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
            }
        }
        return null;
    }
	
	private void limparCampos() {
        this.viewHelper.setNome(null);
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
        this.viewHelper.setNumero(null);
        this.viewHelper.setRg(null);
        this.viewHelper.setSexo(null);
        this.viewHelper.setTelefone(null);

    }
	
	@Override
	public String iniciarPagina() {
		this.viewHelper = new EnricoClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ENRICO_CLIENTE;
	}
	
	public String iniciarPaginaConsulta() {
		this.viewHelper = new EnricoClienteViewHelper();
		this.viewHelper.dadosfake();
		return RiccConstants.TELA_ENRICO_CLIENTE_CONSULTA;
	}

	public boolean validarCampos() {
		boolean retorno = true;
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNome())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_nome");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_cpf");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_rg");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_data_nascimento");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getSexo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_sexo");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_logradouro");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumero())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_numero");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_bairro");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCidade())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_combobox_cidade");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getEstado())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_combobox_estado");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_cep");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_telefone");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_celular");
			retorno = false;
		}

		return retorno;
	}

	public String voltar() {

		return paginaAnterior;
	}

}
