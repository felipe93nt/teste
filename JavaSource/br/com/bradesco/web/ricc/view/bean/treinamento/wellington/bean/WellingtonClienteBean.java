package br.com.bradesco.web.ricc.view.bean.treinamento.wellington.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.wellington.viewhelper.WellingtonClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Diego Munhoz - Foursys
 * @see WellingtonClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "wellingtonClienteBean")
public class WellingtonClienteBean extends
		AbstractBean<WellingtonClienteViewHelper> {
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
		this.viewHelper = new WellingtonClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_INSERIR_CLIENTE;
	}

	/**
	 * @description
	 * @name salvar
	 * @see WellingtonClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validaSalvar()) {
			String retorno = "Salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		}
		return null;
	}

	public String voltar() {

		return paginaAnterior;
	}

	public boolean validaSalvar() {
		String mensagem = "";
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper
				.getNomeCompleto())) {
			String nomemsg = "Nome - Campo Obrigatório.";
			mensagem += nomemsg + "<br> <br>";
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getCpf())) {
			String cpfvaziomsg = "CPF - Campo Obrigatório.";
			mensagem += cpfvaziomsg + "<br> <br>";
		} else {

			if (viewHelper.getCpf().length() != 14) {
				String cpfmsg = "CPF - Campo Incompleto.";
				mensagem += cpfmsg + "<br> <br>";
			}
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getRg())) {
			String rgvaziomsg = "RG - Campo Obrigatório.";
			mensagem += rgvaziomsg + "<br> <br>";
		} else {

			if (viewHelper.getRg().length() != 12 && viewHelper.getRg().length() != 11 && viewHelper.getRg().length() != 10) {
				String rgmsg = "RG - Campo Incompleto.";
				mensagem += rgmsg + "<br> <br>";
			}
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper
				.getDataNascimento())) {
			String datavaziamsg = "Data de Nascimento - Campo Obrigatório.";
			mensagem += datavaziamsg + "<br> <br>";
		} else {

			if (viewHelper.getDataNascimento().length() != 10) {
				String datamsg = "Data de Nascimento - Campo Incompleto.";
				mensagem += datamsg + "<br> <br>";
			}
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getSexo())) {
			String sexomsg = "Sexo - Campo Obrigatório.";
			mensagem += sexomsg + "<br> <br>";
		}
		
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getLogradouro())) {
			String logradouromsg = "Logradouro - Campo Obrigatório.";
			mensagem += logradouromsg + "<br> <br>";
		}
		
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getNumero())) {
			String numeromsg = "Número - Campo Obrigatório.";
			mensagem += numeromsg + "<br> <br>";
		}
		
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getBairro())) {
			String bairromsg = "Bairro - Campo Obrigatório.";
			mensagem += bairromsg + "<br> <br>";
		}
		if (viewHelper.getEstado().equals(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1)) {
			String estadomsg = "Estado - Campo Obrigatório.";
			mensagem += estadomsg + "<br> <br>";
		}
		if (viewHelper.getCidade().equals(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1)) {
			String cidademsg = "Cidade - Campo Obrigatório.";
			mensagem += cidademsg + "<br> <br>";
		}
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getCep())) {
			String cepvaziomsg = "CEP - Campo Obrigatório.";
			mensagem += cepvaziomsg + "<br> <br>";
		}  else {

			if (viewHelper.getCep().length() != 9) {
				String cepmsg = "CEP - Campo Incompleto.";
				mensagem += cepmsg + "<br> <br>";
			}
		}
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getTelefone())) {
			String telefonevaziomsg = "Telefone - Campo Obrigatório.";
			mensagem += telefonevaziomsg + "<br> <br>";
		}  else {
			
			if (viewHelper.getTelefone().length() != 13) {
				String telefonemsg = "Telefone - Campo Incompleto.";
				mensagem += telefonemsg + "<br> <br>";
			}
		}
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getCelular())) {
			String celularvaziomsg = "Celular - Campo Obrigatório.";
			mensagem += celularvaziomsg + "<br> <br>";
		}  else {
			
			if (viewHelper.getCelular().length() != 14) {
				String celularmsg = "Celular - Campo Incompleto.";
				mensagem += celularmsg + "<br> <br>";
				
			}
		}	

		if (siteUtil.validaUmCampoPreenchidoString(mensagem)) {
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			return false;
		} else {
			return true;
		}
	}
	
	public void limparCampos(){
		viewHelper.setNomeCompleto("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setDataNascimento("");
		viewHelper.setSexo("");
		viewHelper.setLogradouro("");
		viewHelper.setNumero("");
		viewHelper.setComplemento("");
		viewHelper.setBairro("");
		viewHelper.setEstado(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1);
		viewHelper.setCidade(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1);
		viewHelper.setCep("");
		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");
	}
}
