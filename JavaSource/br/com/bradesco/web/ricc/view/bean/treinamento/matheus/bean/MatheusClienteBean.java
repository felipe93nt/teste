package br.com.bradesco.web.ricc.view.bean.treinamento.matheus.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.matheus.viewhelper.MatheusClienteViewHelper;

/**
 * @name MatheusClienteBean
 * @author Matheus Poda - Foursys
 * @see MatheusClienteBean.java
 * @version 1.0
 * @since 04/05/2020
 */
@SessionScoped
@Named(value = "matheusClienteBean")
public class MatheusClienteBean extends AbstractBean<MatheusClienteViewHelper> {
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new MatheusClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_MATHEUS_CLIENTE;
	}
	public String iniciarPaginaConsulta() {
		this.viewHelper = new MatheusClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_MATHEUS_CLIENTE_CONSULTAR;
	}

	/**
	 * @description Método salvar (inserir) da tela de Cadastro de Cliente (!No
	 *              momento apenas mostrando um modal)
	 * @name salvar
	 * @see MatheusClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (valicadaoFisicaCamposTela()) {
			String retorno = "Cliente inserido com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);	
			this.viewHelper.limparCamposTelaCadastroCliente();
		}
		return null;
	}

	public String voltar() {

		return paginaAnterior;
	}

	/**
	 * @description Método de Validação Físcia dos campos da tela Cadstro de
	 *              Cliente
	 * @name validar
	 * @see MatheusClienteBean
	 * @return boolean
	 */
	public boolean valicadaoFisicaCamposTela() {
		boolean aux=false;
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNome())) {
			String retorno = "Favor Preencher o campo Nome!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			String retorno = "Favor Preencher o campo CPF!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			String retorno = "Favor Preencher o campo RG!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			String retorno = "Favor Preencher o campo Data de Nascimento!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getSexo())) {
			String retorno = "Favor Preencher o campo Sexo!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			String retorno = "Favor Preencher o campo Logradouro!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())) {
			String retorno = "Favor Preencher o campo Número Logradouro!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			String retorno = "Favor Preencher o campo Bairro!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (this.viewHelper.getCidade().equals("Opção 0 - Selecione a Cidade")) {
			String retorno = "Favor Preencher o campo Cidade!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (this.viewHelper.getEstado().equals("Opção 0 - Selecione o Estado")) {
			String retorno = "Favor Preencher o campo Estado!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			String retorno = "Favor Preencher o campo CEP!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			String retorno = "Favor Preencher o campo Telefone!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			String retorno = "Favor Preencher o campo Celular!";
			BradescoFacesUtils.addErrorModalMessage(retorno);
			aux= Boolean.TRUE;
		}
		
		if (aux) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
