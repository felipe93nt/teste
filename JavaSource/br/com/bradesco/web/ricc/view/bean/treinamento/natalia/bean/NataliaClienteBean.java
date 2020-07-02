package br.com.bradesco.web.ricc.view.bean.treinamento.natalia.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.treinamento.ClienteNataliaVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.natalia.viewhelper.NataliaClienteViewHelper;

@SessionScoped
@Named(value = "nataliaClienteBean")
public class NataliaClienteBean extends AbstractBean<NataliaClienteViewHelper>{
	private static final long serialVersionUID = 1L;
	
	private String paginaAnterior = "";

	@Override
	public String iniciarPagina() {
		this.viewHelper = new NataliaClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_NATALIA_CLIENTE;
	}
	
	public String iniciaPagina(){
		this.viewHelper = new NataliaClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_NATALIA_CONSULTA;
	}

	
	public String salvar() {
	
		if(valida()){
			try{
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limpar();
		
		}catch(Exception e){
			siteUtil.trataExceptionRecebida(e);
		 }
		}
		return null;
	}
	
	
	public String voltar() {

		return "nav_index";
	}
	
	public boolean  valida(){
		
		boolean retorno = true;
		
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNomeCompleto())){
			String msg = "O campo Nome é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())){
			String msg = "O campo CPF é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())){
			String msg = "O campo RG é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())){
			String msg = "O campo Data Nascimento é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyZeroOrNull(this.viewHelper.getSexo())){
			String msg = "O campo Sexo é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())){
			String msg = "O campo Logradouro é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())){
			String msg = "O campo Numero é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())){
			String msg = "O campo Bairro é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		
		if (this.viewHelper.getCidade().equals(RiccConstants.TREINAMENTO_NATALIA_CIDADE_1)){
			String msg = "O campo Cidade é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (this.viewHelper.getEstado().equals(RiccConstants.TREINAMENTO_NATALIA_ESTADO_1)){
			String msg = "O campo Estado é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())){
			String msg = "O campo CEP é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())){
			String msg = "O campo Telefone é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())){
			String msg = "O campo Celular é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		 return retorno;
	}

	private void limpar() {
		
		this.viewHelper.setNomeCompleto(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setTelefone(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setEmail(null);
	
	}

}


