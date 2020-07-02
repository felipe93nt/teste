/**
 * 
 */
package br.com.bradesco.web.ricc.view.bean.treinamento.anderson.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.anderson.viewhelper.AndersonClienteViewhelper;

/**
 * @author amendes
 *
 */

@SessionScoped
@Named(value = "andersonClienteBean")
public class AndersonClienteBean extends
		AbstractBean<AndersonClienteViewhelper> {
	
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	public String iniciarPagina() {
		this.viewHelper = new AndersonClienteViewhelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ANDERSON_CLIENTE_CADASTRO;
	}
	
	public String iniciarPaginaConsulta() {
		this.viewHelper = new AndersonClienteViewhelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ANDERSON_CLIENTE_CONSULTA;
	}
	
	

	/**
	 * @description
	 * @name salvar
	 * @see AndersonClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (valida()) {
			String retorno = "Cliente salvo com sucesso!";
			// List<String> lista = new ArrayList<String>();
			// lista.add("Cliente salvo com sucesso! teste");
			System.out.println(viewHelper.getNome());
			System.out.println(viewHelper.getRg());
			System.out.println(viewHelper.getCpf());
			System.out.println(viewHelper.getDataNascimento());
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

			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			viewHelper.limpar();
		}
		return null;
	}

	public String voltar() {

		return paginaAnterior;
	}

	public boolean valida() {
		boolean aux = false;

		String retorno = "";

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {			
			
			BradescoFacesUtils.addErrorModalMessage("Preencher nome, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			
			BradescoFacesUtils.addErrorModalMessage("Preencher CPF, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher RG, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher data de nascimento, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher sexo, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher logradouro, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher numero, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher bairro, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCidade())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher cidade, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getEstado())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher estado, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			BradescoFacesUtils.addErrorModalMessage("Preencher cep, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {			
			BradescoFacesUtils.addErrorModalMessage("Preencher telefone, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {			
			BradescoFacesUtils.addErrorModalMessage("Preencher celular, Campo Obrigatório!!");
			aux = true;
		}

		if (aux) {
			
			return false;
		}

		return true;
	}


	
	

}
