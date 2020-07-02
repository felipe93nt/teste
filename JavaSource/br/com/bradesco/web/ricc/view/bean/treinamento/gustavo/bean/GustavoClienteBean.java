package br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.viewhelper.GustavoClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Gustavo Garcia - Foursys
 * @see GustavoClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "gustavoClienteBean")
public class GustavoClienteBean extends AbstractBean<GustavoClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;
	
	private String paginaAnterior = "nav_index";

	@Override
	public String iniciarPagina() {
		this.viewHelper = new GustavoClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_GUSTAVO;
	}
	
	
	
	public String voltar() {

		return paginaAnterior;
	}
	
	public String validaPreenchimento(String nomeCampo, Object vazio) {
          String retorno = "";
		if ((vazio == null) || (vazio.equals("") || vazio.equals("0"))) {
			
			retorno = "O campo "+nomeCampo +" é obrigatório!"+"</br>";
			return retorno;
		}
		return retorno;
	}
	
	
	public String validaSalvar(){
		String retorno = "";
		retorno += validaPreenchimento("Nome",viewHelper.getNome());
		retorno += validaPreenchimento("Cpf",viewHelper.getCpf());
		retorno += validaPreenchimento("RG",viewHelper.getRg());
	    retorno += validaPreenchimento("Data Nascimento",viewHelper.getDataNascimento());
		retorno += validaPreenchimento("Sexo",viewHelper.getSexo());
		
		retorno += validaPreenchimento("Logradouro",viewHelper.getLogradouro());
		retorno += validaPreenchimento("Numero",viewHelper.getNumero());
		retorno += validaPreenchimento("Bairro",viewHelper.getBairro());
		retorno += validaPreenchimento("Cidade",viewHelper.getCidade());
		retorno += validaPreenchimento("Estado",viewHelper.getEstado());
	
		retorno += validaPreenchimento("Cep ",viewHelper.getCep());
		retorno += validaPreenchimento("Telefone ",viewHelper.getTelefone());
		retorno += validaPreenchimento("Celular",viewHelper.getCelular());
		
		return retorno;
	}
	public void limparCampos(){
		viewHelper.setNome("");
		viewHelper.setRg("");
		viewHelper.setCpf("");
		viewHelper.setSexo("");

		viewHelper.setDataNascimento(null);
		viewHelper.setLogradouro("");
		viewHelper.setNumero("");
		viewHelper.setCep("");
		viewHelper.setComplemento("");
		viewHelper.setCidade("");
		viewHelper.setEstado("");
		viewHelper.setBairro("");

		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");
		
	}
	
	public String salvar() {
		
		if(validaSalvar().equals("")){
			String retorno = "Cliente salvo com sucesso!";
	        
		BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		limparCampos();
		}else{
	    BradescoFacesUtils.addInfoModalMessage(validaSalvar(), Boolean.FALSE);
		}
		return null;
	}

}
