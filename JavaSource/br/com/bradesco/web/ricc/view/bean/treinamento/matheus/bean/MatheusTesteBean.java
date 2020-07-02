package br.com.bradesco.web.ricc.view.bean.treinamento.matheus.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.ricc.model.treinamento.ClienteMatheusVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.matheus.viewhelper.MatheusTesteViewHelper;

/**
 * @description Classe respons�vel pelo Bean da nossa Tela de Teste Cadastro
 * @author mpoda
 * @since 18/05/2020
 * @version 1.0
 */
@SessionScoped
@Named(value = "matheusTesteBean")
public class MatheusTesteBean extends AbstractBean<MatheusTesteViewHelper> {
	private static final long serialVersionUID = -6473037990504221688L;
	private String paginaAnterior = "nav_index";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new MatheusTesteViewHelper();
		this.viewHelper.inicializar();
		carregaListaCidadesPadrao();
		carregaListaEstadosPadrao();
		return RiccConstants.TELA_TREINAMENTO_MATHEUS_TESTE_CADASTRO;
	}

	public String iniciarPaginaConsulta() {
		this.viewHelper = new MatheusTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_MATHEUS_TESTE_CONSULTA;
	}

	/**
	 * @description M�todo salvar (inserir) da tela de Cadastro de Cliente,
	 *              respons�vel por adicionar o nosso cadastro na tabela
	 * @name salvar
	 * @see MatheusTesteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validarCamposObrigatorios()) {
			String retorno = "Cliente salvo com Sucesso!";

			habilitadorDeTabela();
			ClienteMatheusVO clienteCadastrado = new ClienteMatheusVO();
			clienteCadastrado.setNome(this.viewHelper.getNome());
			clienteCadastrado.setCpf(this.viewHelper.getCpf() + "");
			clienteCadastrado.setRg(this.viewHelper.getRg());
			clienteCadastrado.setDataNascimento(this.viewHelper
					.getDataNascimento());
			clienteCadastrado.setSexo(this.viewHelper.getSexo());
			clienteCadastrado.setLogradouro(this.viewHelper.getLogradouro());
			clienteCadastrado.setNumeroLogradouro(this.viewHelper
					.getNumeroLogradouro());
			clienteCadastrado.setComplemento(this.viewHelper.getComplemento());
			clienteCadastrado.setBairro(this.viewHelper.getBairro());
			clienteCadastrado.setCidade(this.viewHelper.getCidade());
			clienteCadastrado.setEstado(this.viewHelper.getEstado());
			clienteCadastrado.setCep(this.viewHelper.getCep());
			clienteCadastrado.setTelefone(this.viewHelper.getTelefone());
			clienteCadastrado.setCelular(this.viewHelper.getCelular());
			clienteCadastrado.setEmail(this.viewHelper.getEmail());

			viewHelper.getListaCadastramento().add(clienteCadastrado);
			viewHelper.limparCampos();
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);

		}
		return null;
	}

	// M�TODOS DA PARTE DE CIDADE E ESTADO
	/**
	 * @description M�todo criado para adicionarmos uma nova cidade atrav�s do
	 *              Modal;
	 * @name cadastrarNovaCidade
	 * @see MatheusTesteBean
	 * @return void
	 */
	public void cadastrarNovaCidade() {
		viewHelper.getListaCidades().add(
				new SelectItem(viewHelper.getNomeCidadeModal(), viewHelper
						.getNomeCidadeModal()));
		viewHelper.limparModalCidade();
		for (SelectItem teste : viewHelper.getListaCidades()) {
			System.out.println(teste.getLabel());
		}
	}

	/**
	 * @description M�todo criado para adicionarmos um novo Estado atrav�s do
	 *              Modal;
	 * @name cadastrarNovoEstado
	 * @see MatheusTesteBean
	 * @return void
	 */
	public void cadastrarNovoEstado() {
		viewHelper.getListaEstados().add(
				new SelectItem(viewHelper.getNomeEstadoModal(), viewHelper
						.getNomeEstadoModal()));
		viewHelper.limparModalEstado();
		for (SelectItem teste : viewHelper.getListaEstados()) {
			System.out.println(teste.getLabel());
		}
	}

	/**
	 * @description M�todo respons�vel pelo carregamento inicial da combobox de
	 *              Cidade;
	 * @name carregaListaCidadesPadrao
	 * @see MatheusTesteBean
	 * @return void
	 */
	public void carregaListaCidadesPadrao() {
		viewHelper.getListaCidades().addAll(
				siteUtil.carregarComboCidadeMatheus());
	}

	/**
	 * @description M�todo respons�vel pelo carregamento inicial da combobox de
	 *              Estado;
	 * @name carregaListaEstadosPadrao
	 * @see MatheusTesteBean
	 * @return void
	 */
	public void carregaListaEstadosPadrao() {
		viewHelper.getListaEstados().addAll(
				siteUtil.carregarComboEstadoMatheus());
	}

	// M�TODOS RESPONS�VEIS DOS BOT�ES VOLTAR DA TELA DE CADASTRO E DE CONSULTA
	/**
	 * @description Volta para o index (Tela inicial)
	 * @name voltar
	 * @see MatheusTesteBean
	 * @return string
	 * @return caminho para o Index
	 */
	public String voltar() {
		return paginaAnterior;
	}

	/**
	 * @description Volta para a tela de Cadastro Teste Matheus
	 * @name voltarConsulta
	 * @see MatheusTesteBean
	 * @return string
	 * @return caminho para a tela de cadastro
	 */
	public String voltarConsulta() {
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		return RiccConstants.TELA_TREINAMENTO_MATHEUS_TESTE_CADASTRO;
	}

	// M�TODOS RESPONS�VEIS PELA TABELA
	/**
	 * @description Altera o boolean do rendered do panel da Tabela, para que
	 *              possa ser exibida
	 * @name habilitadorDeTabela
	 * @see MatheusTesteBean
	 * @return void
	 */
	public void habilitadorDeTabela() {
		this.viewHelper.setHabilitarTabela(true);
	}

	/**
	 * @description Ao selecionarmos uma linha na nossa tabela, o bot�o
	 *              consultar ser� habilitado
	 * @name habilitarBotao
	 * @see MatheusTesteBean
	 * @return void
	 * @param AjaxBehaviorEvent
	 */
	public void habilitarBotao(AjaxBehaviorEvent ae) {
		ClienteMatheusVO cadastro = null;
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			cadastro = this.viewHelper.getItemSelecionado().get(Numeros.ZERO);
			this.viewHelper.setBtnConsultar(Boolean.TRUE);
		}
	}

	/**
	 * @description M�todo de Valida��o F�scia dos campos da tela Cadstro de
	 *              Cliente
	 * @name validar
	 * @see MatheusClienteBean
	 * @return boolean
	 */
	public boolean validarCamposObrigatorios() {
		boolean retorno = true;
		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			BradescoFacesUtils.addInfoModalMessage("Nome Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			BradescoFacesUtils.addInfoModalMessage("CPF Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			BradescoFacesUtils.addInfoModalMessage("RG Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			BradescoFacesUtils.addInfoModalMessage(
					"Data de Nascimento Obrigat�ria!", Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			BradescoFacesUtils.addInfoModalMessage("Sexo Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			BradescoFacesUtils.addInfoModalMessage("Logradouro Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumeroLogradouro())) {
			BradescoFacesUtils.addInfoModalMessage("N�mero Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			BradescoFacesUtils.addInfoModalMessage("Bairro Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (this.viewHelper.getCidade().equals("Op��o 0 - Selecione a Cidade")) {
			BradescoFacesUtils.addInfoModalMessage("Cidade Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (this.viewHelper.getEstado().equals("Op��o 0 - Selecione o Estado")) {
			BradescoFacesUtils.addInfoModalMessage("Estado Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			BradescoFacesUtils.addInfoModalMessage("Cep Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			BradescoFacesUtils.addInfoModalMessage("Telefone Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			BradescoFacesUtils.addInfoModalMessage("Celular Obrigat�rio!",
					Boolean.FALSE);
			retorno = Boolean.FALSE;
		}
		return retorno;
	}

	/**
	 * @description Respons�vel por armazenar o item selecionado em uma vari�vel
	 *              e chamar a tela de Consulta, populando os campos com esse
	 *              objeto selecionado
	 * @name consultar
	 * @see MatheusTesteBean
	 * @return String
	 * @return Tela de Consulta Teste Matheus
	 */
	public String consultar() {
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_MATHEUS_TESTE_CONSULTA;
	}
}
