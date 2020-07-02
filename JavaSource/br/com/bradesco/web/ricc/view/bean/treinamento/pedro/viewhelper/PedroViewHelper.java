package br.com.bradesco.web.ricc.view.bean.treinamento.pedro.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClientePedroVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class PedroViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String nomeCompleto;
	private String cpf;
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
	private String cidadeIncluir;
	private String estadoIncluir;
	private List<SelectItem> comboCidade;
	private List<SelectItem> comboEstado;
	private List<ClientePedroVO> itemSelecionado = new ArrayList<ClientePedroVO>();
	private List<ClientePedroVO> listaClienteVO = new ArrayList<ClientePedroVO>();
	private List<ClientePedroVO> listaClientesSalvosVO = new ArrayList<ClientePedroVO>();
	private ClientePedroVO clienteVO = new ClientePedroVO();
	private Boolean renderModalCidade = Boolean.FALSE;
	private Boolean renderModalEstado = Boolean.FALSE;
	private Boolean renderTableClientes = Boolean.FALSE;
	private Boolean btnConsultar = Boolean.FALSE;
	private String cpfPesquisa;
	
	@Override
	public void inicializar() {
		setRenderModalCidade(Boolean.FALSE);
		comboCidade = siteUtil.pedroCarregarComboCidade();
		comboEstado = siteUtil.pedroCarregarComboEstado();
	}

	public List<SelectItem> getComboEstado() {
		return comboEstado;
	}

	public List<SelectItem> getComboCidade() {
		return comboCidade;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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

	public Boolean getRenderModalCidade() {
		return renderModalCidade;
	}

	public void setRenderModalCidade(Boolean renderModalCidade) {
		this.renderModalCidade = renderModalCidade;
	}

	public String getCidadeIncluir() {
		return cidadeIncluir;
	}

	public void setCidadeIncluir(String cidadeIncluir) {
		this.cidadeIncluir = cidadeIncluir;
	}

	public void setComboCidade(List<SelectItem> comboCidade) {
		this.comboCidade = comboCidade;
	}

	public Boolean getRenderTableClientes() {
		return renderTableClientes;
	}

	public void setRenderTableClientes(Boolean renderTableClientes) {
		this.renderTableClientes = renderTableClientes;
	}

	public List<ClientePedroVO> getListaClienteVO() {
		return listaClienteVO;
	}

	public void setListaClienteVO(List<ClientePedroVO> listaClienteVO) {
		this.listaClienteVO = listaClienteVO;
	}

	public Boolean getRenderModalEstado() {
		return renderModalEstado;
	}

	public void setRenderModalEstado(Boolean renderModalEstado) {
		this.renderModalEstado = renderModalEstado;
	}

	public String getEstadoIncluir() {
		return estadoIncluir;
	}

	public void setEstadoIncluir(String estadoIncluir) {
		this.estadoIncluir = estadoIncluir;
	}

	public void setComboEstado(List<SelectItem> comboEstado) {
		this.comboEstado = comboEstado;
	}

	public List<ClientePedroVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClientePedroVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public ClientePedroVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClientePedroVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public String getCpfPesquisa() {
		return cpfPesquisa;
	}

	public void setCpfPesquisa(String cpfPesquisa) {
		this.cpfPesquisa = cpfPesquisa;
	}

	public List<ClientePedroVO> getListaClientesSalvosVO() {
		return listaClientesSalvosVO;
	}

	public void setListaClientesSalvosVO(List<ClientePedroVO> listaClientesSalvosVO) {
		this.listaClientesSalvosVO = listaClientesSalvosVO;
	}
}
