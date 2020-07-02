package br.com.bradesco.web.ricc.view.bean.treinamento.matheus.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.ricc.model.treinamento.ClienteMatheusVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;
import br.com.bradesco.web.ricc.view.bean.treinamento.matheus.bean.MatheusTesteBean;

/**
 * @description Classe ViewHelper da tela de Cadastro de Cliente Teste
 * @author mpoda
 * @since 18/05/2020
 * @version 1.0
 */
public class MatheusTesteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	// ATRIBUTOS BÁSICOS
	private String nome;

	private CpfDataType cpf;

	private String rg;

	private String dataNascimento;

	private String sexo;

	private String logradouro;

	private String numeroLogradouro;

	private String bairro;

	private String complemento;

	private String cidade;

	private String estado;

	private String cep;

	private String telefone;

	private String celular;

	private String email;

	private String exemploOutputText;

	private String exemploComboBox;

	private ClienteMatheusVO cliente = new ClienteMatheusVO();

	private List<ClienteMatheusVO> itemSelecionado = new ArrayList<ClienteMatheusVO>();

	private List<ClienteMatheusVO> listaCadastramento = new ArrayList<ClienteMatheusVO>();

	private boolean habilitarTabela = Boolean.FALSE;

	private SelectItem novaCidade;

	private String nomeCidadeModal;

	private String nomeEstadoModal;

	private ClienteMatheusVO clienteConsulta = new ClienteMatheusVO();

	private ClienteMatheusVO clienteCadastrado = new ClienteMatheusVO();

	private boolean renderModal = Boolean.FALSE;

	private boolean btnConsultar = Boolean.FALSE;

	private List<SelectItem> listaCidades = new ArrayList<SelectItem>();;

	private List<SelectItem> listaEstados = new ArrayList<SelectItem>();;

	/**
	 * @description Usado para popular componentes na tela
	 * @name inicializar
	 * @see MatheusClienteViewHelper
	 * @return void
	 */
	@Override
	public void inicializar() {
		renderModal = Boolean.FALSE;
		obtemCliente();
	}

	// GETTERS E SETTERS

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CpfDataType getCpf() {
		return cpf;
	}

	public void setCpf(CpfDataType cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExemploOutputText() {
		return exemploOutputText;
	}

	public void setExemploOutputText(String exemploOutputText) {
		this.exemploOutputText = exemploOutputText;
	}

	public String getExemploComboBox() {
		return exemploComboBox;
	}

	public void setExemploComboBox(String exemploComboBox) {
		this.exemploComboBox = exemploComboBox;
	}

	public ClienteMatheusVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteMatheusVO cliente) {
		this.cliente = cliente;
	}

	public List<ClienteMatheusVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteMatheusVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<ClienteMatheusVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<ClienteMatheusVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}

	public boolean isHabilitarTabela() {
		return habilitarTabela;
	}

	public void setHabilitarTabela(boolean habilitarTabela) {
		this.habilitarTabela = habilitarTabela;
	}

	public SelectItem getNovaCidade() {
		return novaCidade;
	}

	public void setNovaCidade(SelectItem novaCidade) {
		this.novaCidade = novaCidade;
	}

	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	public String getNomeCidadeModal() {
		return nomeCidadeModal;
	}

	public void setNomeCidadeModal(String nomeCidadeModal) {
		this.nomeCidadeModal = nomeCidadeModal;
	}

	public List<SelectItem> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<SelectItem> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public List<SelectItem> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<SelectItem> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public boolean isBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public void setRenderModal(boolean renderModal) {
		this.renderModal = renderModal;
	}

	public ClienteMatheusVO getClienteConsulta() {
		return clienteConsulta;
	}

	public void setClienteConsulta(ClienteMatheusVO clienteConsulta) {
		this.clienteConsulta = clienteConsulta;
	}

	public ClienteMatheusVO getClienteCadastrado() {
		return clienteCadastrado;
	}

	public void setClienteCadastrado(ClienteMatheusVO clienteCadastrado) {
		this.clienteCadastrado = clienteCadastrado;
	}

	public String getNomeEstadoModal() {
		return nomeEstadoModal;
	}

	public void setNomeEstadoModal(String nomeEstadoModal) {
		this.nomeEstadoModal = nomeEstadoModal;
	}

	// MÉTODOS

	/**
	 * @description Método para limpar campos da tela
	 * @name limparCamposTelaCadastroCliente
	 * @see MatheusTesteBean
	 * @return
	 */

	/**
	 * @description Método para limpar campos da tela
	 * @name limparCampos
	 * @see MatheusTesteBean
	 * @return
	 */
	public void limparCampos() {
		nome = null;
		cpf = null;
		rg = null;
		dataNascimento = null;
		sexo = null;
		logradouro = null;
		numeroLogradouro = null;
		complemento = null;
		bairro = null;
		cidade = null;
		estado = null;
		cep = null;
		telefone = null;
		celular = null;
		email = null;
	}

	/**
	 * @description Método para limpar campos do modal Cidade
	 * @name limparModalCidade
	 * @see MatheusTesteBean
	 * @return
	 */
	public void limparModalCidade() {
		nomeCidadeModal = null;
	}

	/**
	 * @description Método para limpar campos do modal Estado
	 * @name limparModalCidade
	 * @see MatheusTesteBean
	 * @return
	 */
	public void limparModalEstado() {
		nomeEstadoModal = null;
	}

	/**
	 * @description Método responsável por popular com o objeto selecionado
	 * @name obtemCliente
	 * @see MatheusTesteBean
	 * @return ClienteMatheusVO
	 */
	public ClienteMatheusVO obtemCliente() {
		for (ClienteMatheusVO clienteConsulta2 : getItemSelecionado()) {
			clienteConsulta2.getNome();
			clienteConsulta2.getCpf();
			clienteConsulta2.getRg();
			clienteConsulta2.getDataNascimento();
			clienteConsulta2.getSexo();
			clienteConsulta2.getLogradouro();
			clienteConsulta2.getNumeroLogradouro();
			clienteConsulta2.getComplemento();
			clienteConsulta2.getBairro();
			clienteConsulta2.getCidade();
			clienteConsulta2.getEstado();
			clienteConsulta2.getCep();
			clienteConsulta2.getCelular();
			clienteConsulta2.getTelefone();
			clienteConsulta2.getEmail();
			clienteConsulta = clienteConsulta2;
		}
		return clienteConsulta;
	}

}
