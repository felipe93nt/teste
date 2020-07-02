package br.com.bradesco.web.ricc.view.bean.treinamento.joaogil.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.joaogil.viewhelper.JoaogilClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Diego Munhoz - Foursys
 * @see JoaogilClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "joaogilClienteBean")
public class JoaogilClienteBean extends
		AbstractBean<JoaogilClienteViewHelper> {
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
		this.viewHelper = new JoaogilClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_JOAOGIL_CLIENTE;
	}
	
	public String iniciarConsulta() {
		this.viewHelper = new JoaogilClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_JOAOGIL_CONSULTA;
	}


	/**
	 * @description
	 * @name salvar
	 * @see JoaogilClienteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		String retorno = "Cliente salvo com sucesso!";
		if (validarTodosCamposEntradaString(this.viewHelper.getNomeCompleto(), this.viewHelper.getCpf(), this.viewHelper.getRg(), this.viewHelper.getDataNascimento(), this.viewHelper.getSexo(),
				this.viewHelper.getLogradouro(), this.viewHelper.getNumeroLogradouro(), this.viewHelper.getBairro(), this.viewHelper.getCidade(), this.viewHelper.getEstado(),
				this.viewHelper.getCep(), this.viewHelper.getTelefone(), this.viewHelper.getCelular())) {
		
			System.out.println("\n\n\n ============================== DADOS PESSOAIS ==============================\n");
			System.out.println("Nome.....................: " + this.viewHelper.getNomeCompleto());
			System.out.println("CPF......................: " + this.viewHelper.getCpf());
			System.out.println("RG.......................: " + this.viewHelper.getRg());
			System.out.println("Data de nascimento.......: " + this.viewHelper.getDataNascimento());
			System.out.println("Sexo.....................: " + this.viewHelper.getSexo());
		
			System.out.println("\n\n ========================== INFORMAÇÕES DE ENDERECO ==========================\n");
			System.out.println("Logradouro...............: " + this.viewHelper.getLogradouro());
			System.out.println("Número logradouro........: " + this.viewHelper.getNumeroLogradouro());
			System.out.println("Complemento..............: " + this.viewHelper.getComplemento());
			System.out.println("Bairro...................: " + this.viewHelper.getBairro());
			System.out.println("Cidade...................: " + this.viewHelper.getCidade());
			System.out.println("Estado...................: " + this.viewHelper.getEstado());
			System.out.println("CEP......................: " + this.viewHelper.getCep());
		
			System.out.println("\n\n =========================== INFORMAÇÕES DE CONTATO ===========================\n");
			System.out.println("Telefone.................: " + this.viewHelper.getTelefone());
			System.out.println("Celular..................: " + this.viewHelper.getCelular());
			System.out.println("Email....................: " + this.viewHelper.getEmail());
		
			System.out.println("\n\n ==============================================================================\n\n\n");
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		}
		return null;
	}
	
	public String voltar() {

		return paginaAnterior;
	}

	public boolean validarTodosCamposEntradaString(String... entrada) {
		String retornoUsuario = "";
		
		for (int i = 0; i < entrada.length; i++) {
			if (entrada[i] == null || "".equals(entrada[i])) {
				retornoUsuario += validaPreenchimento(i, retornoUsuario) + "<br>";
			}
		}
		if (retornoUsuario != "") {
			BradescoFacesUtils.addInfoModalMessage(retornoUsuario, Boolean.FALSE);
			return false;
		}

		return true;
	}

	public String validaPreenchimento(int entrada, String retornoUsuario) {
		switch (entrada) {
		case 0:
			retornoUsuario = "O campo nome completo é obrigatório";
			break;
		case 1:
			retornoUsuario = "O campo CPF é obrigatório";
			break;
		case 2:
			retornoUsuario = "O campo RG é obrigatório";
			break;
		case 3:
			retornoUsuario = "O campo data de nascimento é obrigatório";
			break;
		case 4:
			retornoUsuario = "O campo sexo é obrigatório";
			break;
		case 5:
			retornoUsuario = "O campo logradouro é obrigatório";
			break;
		case 6:			
			retornoUsuario = "O campo número logradouro é obrigatório";
			break;
		case 7:
			retornoUsuario = "O campo bairro é obrigatório";
			break;
		case 8:
			retornoUsuario = "O campo cidade é obrigatório";
			break;
		case 9:
			retornoUsuario = "O campo estado é obrigatório";
			break;
		case 10:
			retornoUsuario = "O campo CEP é obrigatório";
			break;
		case 11:
			retornoUsuario = "O campo telefone é obrigatório";
			break;
		case 12:
			retornoUsuario = "O campo celular é obrigatório";
			break;
		default:
			retornoUsuario = "";
		}
		return retornoUsuario;
	}
	
}
