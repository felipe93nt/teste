package br.com.bradesco.web.ricc.view.bean.treinamento.guilherme.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.guilherme.viewhelper.GuilhermeTesteViewHelper;

/**
 * @name GuilhermeTesteBean
 * @author Guilherme Tomaz - Foursys
 * @see GuilhermeTesteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "guilhermeTesteBean")
public class GuilhermeTesteBean extends AbstractBean<GuilhermeTesteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	private String paginaConsulta = RiccConstants.TELA_GUILHERME_TESTE_CONSULTA;

	@Override
	public String iniciarPagina() {
		this.viewHelper = new GuilhermeTesteViewHelper();
		this.viewHelper.inicializar();

		return RiccConstants.TELA_GUILHERME_TESTE_CADASTRO;
	}

	public String iniciarConsulta() {
		this.viewHelper = new GuilhermeTesteViewHelper();
		this.viewHelper.inicializarConsulta();
		return paginaConsulta;
	}

	public void limparCampos() {
		viewHelper.setNome("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setData("");
		viewHelper.setSexo("");
		viewHelper.setLogradouro("");
		viewHelper.setNumero("");
		viewHelper.setComplemento("");
		viewHelper.setBairro("");
		viewHelper.setCidade("");
		viewHelper.setEstado("");
		viewHelper.setCep("");
		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");

	}

	public String salvar() {
		if (validarCampos()) {
			viewHelper.geraCliente();
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		}
		return "";
	}

	public boolean validarCampos() {
		boolean retorno = true;

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Nome",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getData())) {
			BradescoFacesUtils.addInfoModalMessage(
					"Informe o Data de Nascimento", Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o CPF",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o RG",
					Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Sexo",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Logradouro",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Numero",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Bairro",
					Boolean.FALSE);
			retorno = false;
		}
		if (viewHelper.getCidade().equals("0")) {
			BradescoFacesUtils.addInfoModalMessage("Informe a Cidade",
					Boolean.FALSE);
			retorno = false;
		}
		if (viewHelper.getEstado().equals("0")) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Estado",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o CEP",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Telefone",
					Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			BradescoFacesUtils.addInfoModalMessage("Informe o Celular",
					Boolean.FALSE);
			retorno = false;

		}
		return retorno;
	}

	public String voltar() {

		return paginaAnterior;
	}

}
