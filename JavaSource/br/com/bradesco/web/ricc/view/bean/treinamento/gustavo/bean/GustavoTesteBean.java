package br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteGustavoVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.viewhelper.GustavoTesteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Gustavo Garcia - Foursys
 * @see GustavoClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "gustavoTesteBean")
public class GustavoTesteBean extends AbstractBean<GustavoTesteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	@Override
	public String iniciarPagina() {
		this.viewHelper = new GustavoTesteViewHelper();
		this.viewHelper.inicializar();
		carregaListaCidades();
		carregaListaEstados();

		return RiccConstants.TELA_TREINAMENTO_TESTE_GUSTAVO;
	}

	public String voltar() {

		return paginaAnterior;
	}

	public String validaPreenchimento(String nomeCampo, Object vazio) {
		String retorno = "";
		if ((vazio == null) || (vazio.equals("") || vazio.equals("0"))) {

			retorno = "O campo " + nomeCampo + " é obrigatório!" + "</br>";
			return retorno;
		}
		return retorno;
	}

	public String validaSalvar() {
		String retorno = "";
		retorno += validaPreenchimento("Nome", viewHelper.getNome());
		retorno += validaPreenchimento("Cpf", viewHelper.getCpf());
		retorno += validaPreenchimento("RG", viewHelper.getRg());
		retorno += validaPreenchimento("Data Nascimento",
				viewHelper.getDataNascimento());
		retorno += validaPreenchimento("Sexo", viewHelper.getSexo());

		retorno += validaPreenchimento("Logradouro", viewHelper.getLogradouro());
		retorno += validaPreenchimento("Numero", viewHelper.getNumero());
		retorno += validaPreenchimento("Bairro", viewHelper.getBairro());
		retorno += validaPreenchimento("Cidade", viewHelper.getCidade());
		retorno += validaPreenchimento("Estado", viewHelper.getEstado());

		retorno += validaPreenchimento("Cep ", viewHelper.getCep());
		retorno += validaPreenchimento("Telefone ", viewHelper.getTelefone());
		retorno += validaPreenchimento("Celular", viewHelper.getCelular());

		return retorno;
	}

	public void carregaListaEstados() {
		viewHelper.getListaEstados().add(new SelectItem("Acre", "Acre"));
		viewHelper.getListaEstados().add(new SelectItem("Alagoas", "Alagoas"));
		viewHelper.getListaEstados().add(new SelectItem("Amapá", "Amapá"));
		viewHelper.getListaEstados()
				.add(new SelectItem("Amazonas", "Amazonas"));
		viewHelper.getListaEstados().add(new SelectItem("Bahia", "Bahia"));
		viewHelper.getListaEstados().add(
				new SelectItem("São Paulo", "São Paulo"));
		viewHelper.getListaEstados().add(
				new SelectItem("Rio de Janeiro", "Rio de Janeiro"));
		viewHelper.getListaEstados().add(
				new SelectItem("Rio Grande do Norte", "Rio Grande do Norte"));
		viewHelper.getListaEstados().add(
				new SelectItem("Rio Grande do Sul", "Rio Grande do Sul"));
		viewHelper.getListaEstados()
				.add(new SelectItem("Rondônia", "Rondônia"));

	}

	public void carregaListaCidades() {
		viewHelper.getListaCidades().add(
				new SelectItem("São Paulo", "São Paulo"));
		viewHelper.getListaCidades().add(new SelectItem("Barueri", "Barueri"));
		viewHelper.getListaCidades().add(new SelectItem("Itapevi", "Itapevi"));
		viewHelper.getListaCidades().add(
				new SelectItem("Rio de Janeiro", "Rio de Janeiro"));
		viewHelper.getListaCidades()
				.add(new SelectItem("Curitiba", "Curitiba"));
		viewHelper.getListaCidades().add(new SelectItem("Recife", "Recife"));
		viewHelper.getListaCidades().add(
				new SelectItem("João Pessoa", "João Pessoa"));
		viewHelper.getListaCidades()
				.add(new SelectItem("Teresina", "Teresina"));
		viewHelper.getListaCidades().add(new SelectItem("Natal", "Natal"));
		viewHelper.getListaCidades().add(
				new SelectItem("Porto Alegre", "Porto Alegre"));

	}

	public void limparCampos() {
		viewHelper.setNome("");
		viewHelper.setRg("");
		viewHelper.setCpf("");
		viewHelper.setSexo("");

		viewHelper.setDataNascimento("");
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

	public String voltarPaginaConsulta() {
		viewHelper.setBtnConsultar(false);
		return RiccConstants.TELA_TREINAMENTO_TESTE_GUSTAVO;
	}

	public void paginar(ActionEvent ae) {
		this.carregaTabela();
	}

	public void carregaTabela() {
		for (ClienteGustavoVO clienteGustavoVO : viewHelper
				.getListaClienteGustavoVO()) {
			viewHelper.getListaTabela().add(clienteGustavoVO);
		}

	}

	public String salvar() {
		if (validaSalvar().equals("")) {

			String retorno = "Cliente salvo com sucesso!";
			ClienteGustavoVO cliente = new ClienteGustavoVO();
			cliente.setNome(viewHelper.getNome());
			cliente.setRg(viewHelper.getRg());
			cliente.setCpf(viewHelper.getCpf());
			cliente.setSexo(viewHelper.getSexo());
			cliente.setNumero(viewHelper.getNumero());
			cliente.setDataNascimento(viewHelper.getDataNascimento());
			cliente.setLogradouro(viewHelper.getLogradouro());
			cliente.setCep(viewHelper.getCep());
			cliente.setComplemento(viewHelper.getComplemento());
			cliente.setCidade(viewHelper.getCidade());
			cliente.setEstado(viewHelper.getEstado());
			cliente.setBairro(viewHelper.getBairro());
			cliente.setTelefone(viewHelper.getTelefone());
			cliente.setCelular(viewHelper.getCelular());
			cliente.setEmail(viewHelper.getEmail());

			viewHelper.getListaClienteGustavoVO().add(cliente);
			paginar(null);
			viewHelper.setTabela(true);
			limparCampos();

			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);

		} else {

			BradescoFacesUtils.addInfoModalMessage(validaSalvar(),
					Boolean.FALSE);

		}

		return RiccConstants.TELA_TREINAMENTO_TESTE_GUSTAVO;

	}

	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnConsultar(Boolean.FALSE);

		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnConsultar(Boolean.TRUE);

		}

	}

	public String consultar() {
		for (ClienteGustavoVO itemSelecionado : viewHelper.getItemSelecionado()) {
			viewHelper.setSelecionado(itemSelecionado);
		}
		return RiccConstants.TELA_TREINAMENTO_TESTE_GUSTAVO_CONSULTA;
	}

	// *************** MODAL***************

	public void abrirModalCidade() {
		inicializarCamposModal();// Limpa os campos do modal ao abri-lo
		viewHelper.setRenderModalCidade(Boolean.TRUE);
	}

	public void fecharModalCidade() {
		viewHelper.setRenderModalCidade(Boolean.FALSE);
	}

	public void inicializarCamposModal() {
		viewHelper.setNomeCidade("");

	}

	public void adicionaCidades() {
		String retorno = validaModal();
		if (retorno.equals("")) {
			viewHelper.getListaCidades().add(
					new SelectItem(viewHelper.getNomeCidade(), viewHelper
							.getNomeCidade()));
			fecharModalCidade();
		} else {
			BradescoFacesUtils.addErrorModalMessage(retorno);
		}
	}

	public String validaModal() {
		String retorno = "";
		if (viewHelper.getRenderModalCidade()) {
			if (viewHelper.getNomeCidade().trim().equals("")) {
				retorno = "Campo Cidade é obrigatorio!";
			}
		} else {
			if (viewHelper.getNomeEstado().trim().equals("")) {
				retorno = "Campo Estado é obrigatorio!";
			}
		}

		return retorno;
	}

	public void abrirModalEstado() {
		inicializarCamposModalEstado();// Limpa os campos do modal ao abri-lo
		viewHelper.setRenderModalEstado(Boolean.TRUE);
	}

	public void fecharModalEstado() {
		viewHelper.setRenderModalEstado(Boolean.FALSE);
	}

	public void inicializarCamposModalEstado() {
		viewHelper.setNomeEstado("");

	}

	public void adicionaEstado() {
		String retorno = validaModal();
		if (retorno.equals("")) {
			viewHelper.getListaEstados().add(
					new SelectItem(viewHelper.getNomeEstado(), viewHelper
							.getNomeEstado()));
			fecharModalEstado();
		} else {
			BradescoFacesUtils.addErrorModalMessage(retorno);
		}
	}
}
