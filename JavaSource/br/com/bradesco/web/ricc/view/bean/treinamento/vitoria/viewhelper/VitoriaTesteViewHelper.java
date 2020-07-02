package br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteVitoriaVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class VitoriaTesteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;
	
	
	private List<ClienteVitoriaVO> itemSelecionado = new ArrayList<ClienteVitoriaVO>();
	
	private List<ClienteVitoriaVO> listaCadastramento = null;
	private Boolean renderModal = Boolean.FALSE;
	private Boolean renderModalEstado = Boolean.FALSE;
	private ClienteVitoriaVO modelPesquisa  = null;
	private List<SelectItem> comboCidade;
	private List<SelectItem> comboEstado;
	private Boolean btnConsultar = Boolean.FALSE;
	private Boolean habilitarTabela= Boolean.FALSE;
	
	private String nome, cpf, rg, dataNascimento, sexo, logradouro,
			numeroLogradouro, complemento, bairro, cidade, estado, cep,
			telefone, celular, email;

	private ClienteVitoriaVO clienteVO = new ClienteVitoriaVO();
	

	@Override
	public void inicializar() {
		comboEstado = siteUtil.pedroCarregarComboEstado();
		comboCidade = siteUtil.pedroCarregarComboCidade();
		renderModal = Boolean.FALSE;
		renderModalEstado = Boolean.FALSE;
		habilitarTabela= Boolean.FALSE;
		listaCadastramento = new ArrayList<ClienteVitoriaVO>();
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

	public List<SelectItem> getComboCidade() {
		return comboCidade;
	}

	public void setComboCidade(List<SelectItem> comboCidade) {
		this.comboCidade = comboCidade;
	}

	public List<SelectItem> getComboEstado() {
		return comboEstado;
	}

	public void setComboEstado(List<SelectItem> comboEstado) {
		this.comboEstado = comboEstado;
	}

	public List<SelectItem> getComboSexo() {
		return siteUtil.pedroCarregarComboSexo();
	}

	public ClienteVitoriaVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteVitoriaVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public List<ClienteVitoriaVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteVitoriaVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<ClienteVitoriaVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<ClienteVitoriaVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}

	public Boolean getRenderModal() {
		return renderModal;
	}


	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}
	

	public ClienteVitoriaVO getModelPesquisa() {
		return modelPesquisa;
	}

	public void setModelPesquisa(ClienteVitoriaVO modelPesquisa) {
		this.modelPesquisa = modelPesquisa;
	}

	public Boolean getRenderModalEstado() {
		return renderModalEstado;
	}

	public void setRenderModalEstado(Boolean renderModalEstado) {
		this.renderModalEstado = renderModalEstado;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public Boolean getHabilitarTabela() {
		return habilitarTabela;
	}

	public void setHabilitarTabela(Boolean habilitarTabela) {
		this.habilitarTabela = habilitarTabela;
	}
	
	

}
