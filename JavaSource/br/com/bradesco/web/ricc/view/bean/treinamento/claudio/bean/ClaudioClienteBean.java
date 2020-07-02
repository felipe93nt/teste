package br.com.bradesco.web.ricc.view.bean.treinamento.claudio.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.claudio.viewhelper.ClaudioClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Claudio Leite - Foursys
 * @see ClaudioClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "claudioClienteBean")
public class ClaudioClienteBean extends AbstractBean<ClaudioClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "";
	private String mensagem = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new ClaudioClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_CLAUDIO_CLIENTE;
	}

	/**
	 * @description
	 * @name salvar
	 * @see ClaudioClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {

		if (validarCampos()) {
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		} else {
			BradescoFacesUtils.addInfoModalMessage("Informe os Dados:<br><br>"
					+ mensagem + "<br>Campos Obrigatórios!", Boolean.FALSE);
			mensagem = "";

		}

		return "";
	}
	
	
	public String iniciarConsulta() {
		this.viewHelper = new ClaudioClienteViewHelper();
		this.viewHelper.popularCampos();
		
		return RiccConstants.TELA_CLAUDIO_CLIENTE_CONSULTA;
	}

	public String voltar() {
		limparCampos();
		return paginaAnterior;
	}

	public boolean validarCampos() {

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			mensagem += "Nome<br>";

		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			mensagem += "CPF<Br>";

		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			mensagem += "RG<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			mensagem += "Data de Nascimento<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			mensagem += "Sexo<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			mensagem += "Logradouro<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			mensagem += "Numero<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			mensagem += "Bairro<br>";
		}
		
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			mensagem += "CEP<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			mensagem += "Telefone<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			mensagem += "Celular<br>";

			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public void limparCampos() {
		viewHelper.setNome("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setDataNascimento("");
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

}
