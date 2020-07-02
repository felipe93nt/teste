package br.com.bradesco.web.ricc.view.bean.treinamento.vinicius.bean;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.vinicius.viewhelper.ViniciusTesteViewHelper;

public class ViniciusTesteBean extends AbstractBean<ViniciusTesteViewHelper>{
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "";
	private String campo = "";

	
	@Override
	public String iniciarPagina() {
		this.viewHelper = new ViniciusTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_VINICIUS_CADASTRO;
	}

	
	public String iniciarTeste() {
		this.viewHelper = new ViniciusTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_VINICIUS_TESTE;
	}


	public boolean validarCampos() {

		// EnzoClienteViewHelper enzoClienteViewHelper = new
		// EnzoClienteViewHelper();

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			campo += "Nome<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			campo += "CPF<Br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			campo += "RG<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			campo += "Data de Nascimento<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			campo += "Sexo<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			campo += "Logradouro<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			campo += "Numero<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			campo += "Bairro<br>";
		}

		if (viewHelper.getCidadeComboBox().equals(
				"Opção 1 - ComboBox Treinamento")) {
			campo += "Cidade<br>";
		}

		if (viewHelper.getEstadoComboBox().equals(
				"Opção 1 - ComboBox Treinamento")) {
			campo += "Estado<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			campo += "CEP<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			campo += "Telefone<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			campo += "Celular<br>";
			return false;
		}

		return true;
	}

	/**
	 * @description
	 * @name salvar
	 * @see viniciusClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {

		if (validarCampos()) {

			String retorno = "Exemplo salvo com sucesso!";

			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		} else {
			BradescoFacesUtils.addInfoModalMessage("Informe os Dados:<br><br>"
					+ campo + "<br>Campos Obrigatórios!", Boolean.FALSE);
			campo = "";

		}
		return null;
	}

	public String voltar() {

		return paginaAnterior;
	}
}
