package br.com.bradesco.web.ricc.view.bean.treinamento.leonardo.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.ricc.model.treinamento.ClienteLeonardoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class LeonardoTesteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -111683580430422356L;

	private String nome;
	private CpfDataType cpf;
	private String rg;
	private String dataNascimento;
	private String sexo;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	private String telefone;
	private String celular;
	private String email;
	private ClienteLeonardoVO leonardoClienteVO = null;
	private Boolean tabela = Boolean.FALSE;

	// variáveis da tabela de clientes
	private ArrayList<ClienteLeonardoVO> listaClientes = new ArrayList<ClienteLeonardoVO>();
	private ArrayList<ClienteLeonardoVO> itemSelecionado = new ArrayList<ClienteLeonardoVO>();

	public void inicializaCliente(ClienteLeonardoVO cliente) {
		cliente.setCpf(montaCpf(cliente.getCpf()));
		leonardoClienteVO = cliente;
	}

	public ArrayList<ClienteLeonardoVO> adicionaLista() {
		ArrayList<ClienteLeonardoVO> lista = listaClientes;
		lista.add(leonardoClienteVO);
		listaClientes = lista;

		return lista;
	}
	
	//método responsável por formatar o cpf recebido do componente cpf
	public String montaCpf(String cpf){
		String cpfNovo = "";
		String parte1 = cpf.substring(0,3);
		String parte2 = cpf.substring(3,6);
		String parte3 = cpf.substring(6,9);
		String parte4 = cpf.substring(9,11);
	
		cpfNovo = parte1+"."+parte2+"."+parte3+"-"+parte4;
		return cpfNovo;
	}

	// Modal de cidade e estado
	private Boolean renderModalIncluirCidade = Boolean.FALSE;

	private Boolean renderModalIncluirEstado = Boolean.FALSE;

	private String novaCidade = "";
	private String novoEstado = "";

	// Método de atualização de combos

	private List<SelectItem> comboCidade = siteUtil
			.carregarComboLeonardoCidade();

	private List<SelectItem> comboEstado = siteUtil
			.carregarComboLeonardoEstado();

	public List<SelectItem> atualizaComboCidade(String cidade) {

		List<SelectItem> lista = comboCidade;
		lista.add(new SelectItem(cidade, cidade));

		return lista;
	}

	public List<SelectItem> atualizaComboEstado(String estado) {

		List<SelectItem> lista = comboEstado;
		lista.add(new SelectItem(estado, estado));

		return lista;
	}

	//método de inicialização da página
	@Override
	public void inicializar() {
		renderModalIncluirCidade = Boolean.FALSE;
		renderModalIncluirEstado = Boolean.FALSE;

	}

	//método para limpar campos da tela de cadastro
	public void limparCampos() {

		nome = null;
		cpf = null;
		rg = null;
		dataNascimento = null;
		sexo = null;
		logradouro = null;
		numero = null;
		complemento = null;
		bairro = null;
		cidade = null;
		estado = null;
		cep = null;
		telefone = null;
		celular = null;
		email = null;

	}

	// Variaveis da classe ViewHelper

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public ClienteLeonardoVO getLeonardoClienteVO() {
		return leonardoClienteVO;
	}

	public void setLeonardoClienteVO(ClienteLeonardoVO leonardoClienteVO) {
		this.leonardoClienteVO = leonardoClienteVO;
	}

	public List<SelectItem> getComboCidade() {
		return comboCidade;
	}

	public List<SelectItem> getComboEstado() {
		return comboEstado;
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

	public ArrayList<ClienteLeonardoVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<ClienteLeonardoVO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<ClienteLeonardoVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(ArrayList<ClienteLeonardoVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public void setComboCidade(List<SelectItem> comboCidade) {
		this.comboCidade = comboCidade;
	}

	public void setComboEstado(List<SelectItem> comboEstado) {
		this.comboEstado = comboEstado;
	}

	// getter da cidade e estado para inclusão
	public String getNovaCidade() {
		return novaCidade;
	}

	public void setNovaCidade(String novaCidade) {
		this.novaCidade = novaCidade;
	}

	public String getNovoEstado() {
		return novoEstado;
	}

	public void setNovoEstado(String novoEstado) {
		this.novoEstado = novoEstado;
	}

	public Boolean getRenderModalIncluirCidade() {
		return renderModalIncluirCidade;
	}

	public void setRenderModalIncluirCidade(Boolean renderModalIncluirCidade) {
		this.renderModalIncluirCidade = renderModalIncluirCidade;
	}

	public Boolean getRenderModalIncluirEstado() {
		return renderModalIncluirEstado;
	}

	public void setRenderModalIncluirEstado(Boolean renderModalIncluirEstado) {
		this.renderModalIncluirEstado = renderModalIncluirEstado;
	}
	
	//getters e setters para visualização da tabela

	public Boolean getTabela() {
		return tabela;
	}

	public void setTabela(Boolean tabela) {
		this.tabela = tabela;
	}
	
	

}