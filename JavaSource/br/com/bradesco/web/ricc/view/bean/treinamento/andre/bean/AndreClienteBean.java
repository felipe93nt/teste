package br.com.bradesco.web.ricc.view.bean.treinamento.andre.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.andre.viewhelper.AndreClienteViewHelper;

/**
 * 
 * @author atnunes
 *
 */

@SessionScoped
@Named(value = "andreClienteBean")
public class AndreClienteBean extends AbstractBean<AndreClienteViewHelper> {
	private static final long serialVersionUID = -2981707807329175557L;

	private String paginaAnterior = "";
	private String mensagem = "";

	@Override
	public String iniciarPagina() {
		this.viewHelper = new AndreClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ANDRE_CLIENTE;
	}
	
	public String iniciarPaginaConsulta() {
		this.viewHelper = new AndreClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ANDRE_CLIENTE_CONSULTAR;
		
	}

	public String salvar() {
		
		if (validarCampos()) {
			exibir();
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
		if (siteUtil.isEmptyOrNull(viewHelper.getData())) {
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
		if (siteUtil.isEmptyOrNull(viewHelper.getCidade())) {
			mensagem += "Cidade<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getEstado())) {
			mensagem += "Estado<br>";
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

	public void limparCampos(){
		viewHelper.setNome("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setData("");
		viewHelper.setSexo("");
		viewHelper.setLogradouro("");
		viewHelper.setNumero(0);
		viewHelper.setComplemento("");
		viewHelper.setBairro("");
		viewHelper.setCidade("");
		viewHelper.setEstado("");
		viewHelper.setCep("");
		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");
		
	}
	
	public void exibir() {
		System.out.println(viewHelper.getNome());
		System.out.println(viewHelper.getRg());
		System.out.println(viewHelper.getCpf());
		System.out.println(viewHelper.getData());
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
	}

	
	
}
