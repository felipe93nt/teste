package br.com.bradesco.web.ricc.view.bean.treinamento.felipe.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteFelipeVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class FelipeExperimentoViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;
	
	private String nome;
	private String cpf;
	private String rg;
	private String dataNasc;
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
	private List<ClienteFelipeVO> itemSelecionado = new ArrayList<ClienteFelipeVO>();
	private List<ClienteFelipeVO> listaClienteVO = new ArrayList<ClienteFelipeVO>();
	private ClienteFelipeVO clienteVO = new ClienteFelipeVO();
	private Boolean renderModalCidade = Boolean.FALSE;
	private Boolean renderModalEstado = Boolean.FALSE;
	private Boolean renderTableClientes = Boolean.FALSE;
	private Boolean btnConsultar = Boolean.FALSE;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
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

	public List<ClienteFelipeVO> getListaClienteVO() {
		return listaClienteVO;
	}

	public void setListaClienteVO(List<ClienteFelipeVO> listaClienteVO) {
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

	public List<ClienteFelipeVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteFelipeVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public ClienteFelipeVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteFelipeVO clienteVO) {
		this.clienteVO = clienteVO;
	}
}
