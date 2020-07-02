/**
 * 
 */
package br.com.bradesco.web.ricc.view.bean.treinamento.felipe.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteFelipeVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.felipe.viewhelper.FelipeTesteViewHelper;

/**
 * @author fcorrea
 *
 */
@SessionScoped
@Named(value = "felipeTesteBean")
public class FelipeTesteBean extends AbstractBean<FelipeTesteViewHelper> {
	/**
*
*/
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	private ClienteFelipeVO clienteSelecionado = new ClienteFelipeVO();

	private String paginaCadastro = RiccConstants.TELA_FELIPE_TESTE_CLIENTE_CADASTRO;

	public ClienteFelipeVO getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(ClienteFelipeVO clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public String iniciarPagina() {
		this.viewHelper = new FelipeTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_FELIPE_TESTE_CLIENTE_CADASTRO;
	}

	public String iniciarPaginaConsulta() {
//		this.viewHelper = new FelipeTesteViewHelper();
//		this.viewHelper.inicializar();
		carregarDados();
		return RiccConstants.TELA_FELIPE_TESTE_CLIENTE_CONSULTA;
	}

	/**
	 * @description
	 * @name salvar
	 * @see FelipeTesteBean
	 * @return String
	 */
	public String salvar() {
		if (validarCampos()) {
		ClienteFelipeVO cliente = new ClienteFelipeVO();
		cliente.setNome(viewHelper.getNome());
		cliente.setCpf(viewHelper.getCpf());
		cliente.setRg(viewHelper.getRg());
		cliente.setDataNasc(viewHelper.getDataNasc());
		cliente.setSexo(viewHelper.getSexo());
		cliente.setLogradouro(viewHelper.getLogradouro());
		cliente.setNumero(viewHelper.getNumero());
		cliente.setComplemento(viewHelper.getComplemento());
		cliente.setBairro(viewHelper.getBairro());
		cliente.setCidade(viewHelper.getCidade());
		cliente.setEstado(viewHelper.getEstado());
		cliente.setCep(viewHelper.getCep());
		cliente.setTelefone(viewHelper.getTelefone());
		cliente.setCelular(viewHelper.getCelular());
		cliente.setEmail(viewHelper.getEmail());
		viewHelper.getListaClientes().add(cliente);
		String retorno = "Cliente salvo com sucesso!";
		BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		// System.out.println(viewHelper.getListaCadastramento().get(0).getNome());
		limparCampos();
		}
		return null;
	}

	// public void habilitarBotoes(AjaxBehaviorEvent ae){
	// if (!this.viewHelper.getClienteSelecionado().isEmpty()) {
	//
	// }
	// }


	// public String consultar() {
	// ClienteFelipeVO itemSelecionado = getViewHelper().getClienteSelecionado()
	// .get(0);
	// String retorno = "";
	// if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
	//
	// iniciarPaginaConsulta();
	// retorno = RiccConstants.TELA_FELIPE_TESTE_CLIENTE_CONSULTA;
	// }
	// return retorno;
	//
	// }

	/** metodo para voltar para o index
	 * 
	 * @return String
	 */
	public String voltar() {

		return paginaAnterior;
	}

	/** metodo para voltar para tela de cadastro
	 * 
	 * @return String
	 */
	public String voltarCadastro() {

		return paginaCadastro;
	}

	/** metodo de validar campos para salvar
	 * 
	 * @return boolean
	 */
	public boolean validarCampos() {
		boolean retorno = true;
		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_guilherme_nome_completo");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_cpf");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_rg");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getDataNasc())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_guilherme_data_nascimento");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_radio_sexo");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_logradouro");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_numero");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_bairro");
			retorno = false;
		}

		if (viewHelper.getCidade().equals("0")) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_combobox_cidade");
			retorno = false;
		}

		if (viewHelper.getEstado().equals("0")) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_combobox_estado");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_cep");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_telefone");
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_treinamento_felipe_celular");
			retorno = false;
		}

		return retorno;
	}
	
//	public void salvarCidade() {
//		if(viewHelper.getNovaCidade() == null || viewHelper.getNovaCidade() == ""){
//			
//		}else{			
//			viewHelper.getListaCidade().add(new SelectItem(viewHelper.getNovaCidade(), viewHelper.getNovaCidade()));
//		}
//		
//	}

	/** metodo pra carregar dados do cliente
	 * 
	 */
	public void carregarDados() {
		viewHelper.getCliente().setNome(clienteSelecionado.getNome());
		viewHelper.getCliente().setCpf(clienteSelecionado.getCpf());
		viewHelper.getCliente().setRg(clienteSelecionado.getRg());
		viewHelper.getCliente().setDataNasc(clienteSelecionado.getDataNasc());
		viewHelper.getCliente().setSexo(clienteSelecionado.getSexo());
		viewHelper.getCliente().setLogradouro(
				clienteSelecionado.getLogradouro());
		viewHelper.getCliente().setNumero(clienteSelecionado.getNumero());
		viewHelper.getCliente().setComplemento(
				clienteSelecionado.getComplemento());
		viewHelper.getCliente().setBairro(clienteSelecionado.getBairro());
		viewHelper.getCliente().setCidade(clienteSelecionado.getCidade());
		viewHelper.getCliente().setEstado(clienteSelecionado.getEstado());
		viewHelper.getCliente().setCep(clienteSelecionado.getCep());
		viewHelper.getCliente().setTelefone(clienteSelecionado.getTelefone());
		viewHelper.getCliente().setCelular(clienteSelecionado.getCelular());
		viewHelper.getCliente().setEmail(clienteSelecionado.getEmail());
	}

	/** metodo para limpar campos da tela
	 * 
	 */
	public void limparCampos() {

		viewHelper.setNome(null);
		viewHelper.setCpf(null);
		viewHelper.setRg(null);
		viewHelper.setDataNasc(null);
		viewHelper.setSexo(null);
		viewHelper.setLogradouro(null);
		viewHelper.setNumero(null);
		viewHelper.setComplemento("");
		viewHelper.setBairro(null);
		viewHelper.setCidade("0");
		viewHelper.setEstado("0");
		viewHelper.setCep(null);
		viewHelper.setTelefone(null);
		viewHelper.setCelular(null);
		viewHelper.setEmail("");

	}

}// fim da classe
