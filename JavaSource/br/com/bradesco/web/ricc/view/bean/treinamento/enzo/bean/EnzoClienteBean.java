package br.com.bradesco.web.ricc.view.bean.treinamento.enzo.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.enzo.viewhelper.EnzoClienteViewHelper;

/**
 * @name EnzoClienteBean
 * @author eknascimento - Foursys
 * @see EnzoClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "enzoClienteBean")
public class EnzoClienteBean extends AbstractBean<EnzoClienteViewHelper> {
	/**
	 *
	 */

	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "";
	private String campo = "";

	
	public String iniciarPagina() {
		this.viewHelper = new EnzoClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ENZO_ESTADO_SP;
	}

	public String iniciarPaginaDois() {
		this.viewHelper = new EnzoClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ENZO_ESTADO_SP2;
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
	 * @see EnzoClienteBean
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
