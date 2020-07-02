package br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteGustavoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class GustavoTesteViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1116835804304222911L;

	private String nome;
	private String nomeCidade;
	private String nomeEstado;
	private Boolean RenderModalCidade;
	private Boolean RenderModalEstado;
	private String rg;
	private String cpf;
	private String sexo;
	private List<ClienteGustavoVO> itemSelecionado;
	private ClienteGustavoVO selecionado;
	private String dataNascimento;
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	private String cidade;
	private String estado;
	private String bairro;
	private Boolean tabela;
	private String telefone;
	private String celular;
	private String email;
	private Boolean btnConsultar;

	private List<ClienteGustavoVO> listaTabela;
	private List<ClienteGustavoVO> listaClienteGustavoVO;
	private List<SelectItem> listaCidades = new ArrayList<SelectItem>();
	private List<SelectItem> listaEstados = new ArrayList<SelectItem>();

	@Override
	public void inicializar() {
		listaTabela = new ArrayList<ClienteGustavoVO>();
		listaClienteGustavoVO = new ArrayList<ClienteGustavoVO>();
		itemSelecionado = new ArrayList<ClienteGustavoVO>();

		tabela = false;

	}

	public Boolean getTabela() {
		return tabela;
	}

	public void setTabela(Boolean tabela) {
		this.tabela = tabela;
	}

	public List<ClienteGustavoVO> getListaClienteGustavoVO() {
		return listaClienteGustavoVO;
	}

	public List<ClienteGustavoVO> getListaTabela() {
		return listaTabela;
	}

	public void setListaTabela(List<ClienteGustavoVO> listaTabela) {
		this.listaTabela = listaTabela;
	}

	public List<SelectItem> getListaCidades() {

		return listaCidades;
	}

	public ClienteGustavoVO getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(ClienteGustavoVO selecionado) {
		this.selecionado = selecionado;
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

	public void setListaClienteGustavoVO(
			List<ClienteGustavoVO> listaClienteGustavoVO) {
		this.listaClienteGustavoVO = listaClienteGustavoVO;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getRenderModalCidade() {
		return RenderModalCidade;
	}

	public void setRenderModalCidade(Boolean renderModalCidade) {
		RenderModalCidade = renderModalCidade;
	}

	public Boolean getRenderModalEstado() {
		return RenderModalEstado;
	}

	public void setRenderModalEstado(Boolean renderModalEstado) {
		RenderModalEstado = renderModalEstado;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public List<ClienteGustavoVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteGustavoVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<SelectItem> getComboCidades() {
		return siteUtil.carregarComboBoxCidadesGustavo();
	}

	public List<SelectItem> getComboEstados() {
		return siteUtil.carregarComboBoxEstadosGustavo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

}
