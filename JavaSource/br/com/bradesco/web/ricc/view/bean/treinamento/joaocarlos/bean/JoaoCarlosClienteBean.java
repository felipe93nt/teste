package br.com.bradesco.web.ricc.view.bean.treinamento.joaocarlos.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.SiteUtil;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.joaocarlos.viewhelper.JoaoCarlosClienteViewHelper;

/**
 * @name JoaoCarlosClienteBean
 * @author João Carlos - Foursys
 * @see JoaoCarlosClienteBean.java
 * @version 1.0
 * @since 04/05/2020
 */
@SessionScoped
@Named(value = "joaoCarlosClienteBean")
public class JoaoCarlosClienteBean extends
		AbstractBean<JoaoCarlosClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	protected SiteUtil siteUtil = SiteUtil.getInstance();

	private String mensagemErro = "Favor preencher os campos: " + "<br> <br>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new JoaoCarlosClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_JOAOCARLOS_CADASTRO_CLIENTE;
	}

	/**
	 * @description
	 * @name salvar
	 * @see JoaoCarlosClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		String retorno = "Cliente salvo com sucesso!";
		if (validar()) {
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparDados();
		}	
		
		return null;
	}

	public boolean validar() {
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNome())) {
			mensagemErro += "- Nome" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			mensagemErro += "- CPF" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			mensagemErro += "- RG" + "<br> <br>"; 
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			mensagemErro += "- Data de nascimento" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getSexo())) {
			mensagemErro += "- Sexo" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			mensagemErro += " - Logradouro" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())) {
			mensagemErro += "- Número" + "<br> <br>"; 
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			mensagemErro += "- Bairro" + "<br> <br>"; 
		}
		if (this.viewHelper.getCidade().equals("Selecione a cidade")) {
			mensagemErro += "- Cidade" + "<br> <br>";
		}
		if (this.viewHelper.getEstado().equals("Selecione o Estado")) {
			mensagemErro += " - Estado" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			mensagemErro += " - CEP" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			mensagemErro += "- Telefone" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			mensagemErro += "- Celular" + "<br> <br>";
		}

		if (!mensagemErro.equals("Favor preencher os campos: <br> <br>")) {
			BradescoFacesUtils.addErrorModalMessage(mensagemErro);
			mensagemErro = "Favor preencher os campos: " + "<br> <br>";
			return false;
		}

		return true;
	}
	
	public void limparDados(){
		this.viewHelper.setNome(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setBairro(null);	
		this.viewHelper.setComplemento(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setTelefone(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setEmail(null);
	}

	public String voltar() {

		return paginaAnterior;
	}

}
