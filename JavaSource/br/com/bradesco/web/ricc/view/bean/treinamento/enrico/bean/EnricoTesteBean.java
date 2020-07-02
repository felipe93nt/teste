package br.com.bradesco.web.ricc.view.bean.treinamento.enrico.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteEnricoVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.enrico.viewhelper.EnricoTesteViewHelper;

@SessionScoped
@Named(value = "enricoTesteBean")
public class EnricoTesteBean extends AbstractBean<EnricoTesteViewHelper>{
	private static final long serialVersionUID = 1L;
	
	private String paginaAnterior = "";
	private ClienteEnricoVO cadastrados = new ClienteEnricoVO();
	
	private List<ClienteEnricoVO> listaCadastramento = new ArrayList<ClienteEnricoVO>();
	
	private List<ClienteEnricoVO> itemSelecionado = new ArrayList<ClienteEnricoVO>();
	
	@Override
	public String iniciarPagina() {
		this.viewHelper = new EnricoTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ENRICO_TESTE_CADASTRO;
	}
	
	public String consultar(){
		this.viewHelper = new EnricoTesteViewHelper();
		
		return RiccConstants.TELA_ENRICO_TESTE_CONSULTA;
	}

	public String salvar() {
	
		if(valida()){
			
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);		
		
			cadastrados = new ClienteEnricoVO();
			listaCadastramento = new ArrayList<ClienteEnricoVO>();
						
			cadastrados.setNome(this.viewHelper.getNome());
			cadastrados.setCpf(this.viewHelper.getCpf());
			cadastrados.setRg(this.viewHelper.getRg());
			cadastrados.setDataNascimento(this.viewHelper.getDataNascimento());
			cadastrados.setSexo(this.viewHelper.getSexo());
			cadastrados.setLogradouro(this.viewHelper.getLogradouro());
			cadastrados.setNumero(this.viewHelper.getNumero());
			cadastrados.setComplemento(this.viewHelper.getComplemento());
			cadastrados.setBairro(this.viewHelper.getBairro());
			cadastrados.setCidade(this.viewHelper.getCidade());
			cadastrados.setEstado(this.viewHelper.getEstado());
			cadastrados.setCep(this.viewHelper.getCep());
			cadastrados.setTelefone(this.viewHelper.getTelefone());
			cadastrados.setCelular(this.viewHelper.getCelular());
			cadastrados.setEmail(this.viewHelper.getEmail());
			
			listaCadastramento.add(cadastrados);
						
			limpar();	
		}
		return "";
	}
	
	
	public String voltar() {

		return "nav_index";
	}
	
	public boolean  valida(){
		
		boolean retorno = true;
		
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNome())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_nome");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_cpf");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_rg");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_data_nascimento");
			retorno = false;
		}
		if (siteUtil.isEmptyZeroOrNull(this.viewHelper.getSexo())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_sexo");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_logradouro");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumero())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_numero");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_bairro");
			retorno = false;
		}
		
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCidade())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_combobox_cidade");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getEstado())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_combobox_estado");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_cep");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_telefone");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())){
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_enrico_celular");
			retorno = false;
		}
		 return retorno;
	}

	private void limpar() {
		
		this.viewHelper.setNome(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumero(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setTelefone(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setEmail(null);
	
	}

	public ClienteEnricoVO getCadastrados() {
		return cadastrados;
	}

	public void setCadastrados(ClienteEnricoVO cadastrados) {
		this.cadastrados = cadastrados;
	}

	public List<ClienteEnricoVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<ClienteEnricoVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}

	public List<ClienteEnricoVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteEnricoVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	
	
}