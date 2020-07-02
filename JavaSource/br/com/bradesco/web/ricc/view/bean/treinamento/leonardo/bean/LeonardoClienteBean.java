package br.com.bradesco.web.ricc.view.bean.treinamento.leonardo.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.leonardo.viewhelper.LeonardoClienteViewHelper;

/**
 * @name LeonardoClienteBean
 * @author Leonardo Lopo - Foursys
 * @see LeonardoClienteBean.java
 * @version 1.0
 * @since 04/05/2020
 */

@SessionScoped
@Named(value = "leonardoClienteBean")
public class LeonardoClienteBean extends
		AbstractBean<LeonardoClienteViewHelper> {

	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	@Override
	public String iniciarPagina() {
		this.viewHelper = new LeonardoClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_LEONARDO_CLIENTE;
	}
	
	public String iniciarPaginaConsulta() {
		this.viewHelper = new LeonardoClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_LEONARDO_CLIENTE_CONSULTA;
	}

	public boolean validarCamposObrigatorios() {
		boolean retorno = true;

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			BradescoFacesUtils.addInfoModalMessage("Nome Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			BradescoFacesUtils.addInfoModalMessage("CPF Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			BradescoFacesUtils.addInfoModalMessage("RG Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			BradescoFacesUtils.addInfoModalMessage("Data de Nascimento Obrigatória!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			BradescoFacesUtils.addInfoModalMessage("Sexo Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			BradescoFacesUtils.addInfoModalMessage("Logradouro Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			BradescoFacesUtils.addInfoModalMessage("Número Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			BradescoFacesUtils.addInfoModalMessage("Bairro Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCidade())) {
			BradescoFacesUtils.addInfoModalMessage("Cidade Obrigatória!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getEstado())) {
			BradescoFacesUtils.addInfoModalMessage("Estado Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			BradescoFacesUtils.addInfoModalMessage("Cep Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			BradescoFacesUtils.addInfoModalMessage("Telefone Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			BradescoFacesUtils.addInfoModalMessage("Celular Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}

		return retorno;
	}

	/**
	 * @description
	 * @name salvar
	 * @see LeonardoClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validarCamposObrigatorios()) {
			String retorno = "Cliente salvo com Sucesso!";

			System.out.println("Nome: " + viewHelper.getNome());
			System.out.println("CPF: " + viewHelper.getCpf());
			System.out.println("RG: " + viewHelper.getRg());
			System.out.println("Data de Nascimento: " + viewHelper.getDataNascimento());
			System.out.println("Sexo: " + viewHelper.getSexo());
			System.out.println("Logradouro: " + viewHelper.getLogradouro());
			System.out.println("Número: " + viewHelper.getNumero());
			System.out.println("Complemento: " + viewHelper.getComplemento());
			System.out.println("Bairro: " + viewHelper.getBairro());
			System.out.println("Cidade: " + viewHelper.getCidade());
			System.out.println("Estado: " + viewHelper.getEstado());
			System.out.println("Cep: " + viewHelper.getCep());
			System.out.println("Telefone: " + viewHelper.getTelefone());
			System.out.println("Celular: " + viewHelper.getCelular());
			System.out.println("Email: " + viewHelper.getEmail());

			viewHelper.limparCampos();
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);

		}
		return null;
	}
	

	public String voltar() {

		return paginaAnterior;
	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

}
