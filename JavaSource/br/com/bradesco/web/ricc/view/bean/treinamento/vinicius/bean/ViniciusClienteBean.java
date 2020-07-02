package br.com.bradesco.web.ricc.view.bean.treinamento.vinicius.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.vinicius.viewhelper.ViniciusClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Vinicius Santos - Foursys
 * @see ViniciusClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "viniciusClienteBean")
public class ViniciusClienteBean extends AbstractBean<ViniciusClienteViewHelper> {
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
		this.viewHelper = new ViniciusClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_VINICIUS_CADASTRO;
	}

	
	public String iniciarConsulta() {
		this.viewHelper = new ViniciusClienteViewHelper();
		this.viewHelper.geraCliente();
		return RiccConstants.TELA_TREINAMENTO_VINICIUS_CONSULTA;
	}

	/**
	 * @description
	 * @name salvar
	 * @see ViniciusClienteBean
	 * @return
	 * @return String
	 */

	public void limparCampos() {
		viewHelper.setNome("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setData("");
		viewHelper.setSexo("");
		viewHelper.setLogradouro("");
		viewHelper.setNumero(0);
		viewHelper.setComplemento("");
		viewHelper.setBairro("");
		viewHelper.setCidade("");
		viewHelper.setEstado("");
		viewHelper.setCep("");
		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");

	}

	public void exibir() {
		System.out.println(viewHelper.getNome());
		System.out.println(viewHelper.getRg());
		System.out.println(viewHelper.getCpf());
		System.out.println(viewHelper.getData());
		System.out.println(viewHelper.getSexo());
		System.out.println(viewHelper.getLogradouro());
		System.out.println(viewHelper.getNumero());
		System.out.println(viewHelper.getComplemento());
		System.out.println(viewHelper.getBairro());
		System.out.println(viewHelper.getCidade());
		System.out.println(viewHelper.getEstado());
		System.out.println(viewHelper.getCep());
		System.out.println(viewHelper.getTelefone());
		System.out.println(viewHelper.getCelular());
		System.out.println(viewHelper.getEmail());
	}

	public String salvar() {

		if (validarCampos()) {
			exibir();
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		}

		return "";
	}

	public boolean validarCampos() {
		boolean retorno = true;

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Nome",Boolean.FALSE);
			retorno = false;
		}
		
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o CPF",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o RG",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getData())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Data de Nascimento",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Sexo",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Logradouro",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Numero",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Bairro",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCidade())) {
			BradescoFacesUtils.addInfoModalMessage("Informe a Cidade",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getEstado())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Estado",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o CEP",Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Telefone",Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Celular",Boolean.FALSE);
			retorno = false;

		}
		return retorno;
	}

	public String voltar() {

		return paginaAnterior;
	}
	
	
}
