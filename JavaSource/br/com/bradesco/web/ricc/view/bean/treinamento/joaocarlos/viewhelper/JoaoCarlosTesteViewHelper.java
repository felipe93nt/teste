package br.com.bradesco.web.ricc.view.bean.treinamento.joaocarlos.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteJoaoCarlosVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class JoaoCarlosTesteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String sexo;

	private String logradouro;
	private String numeroLogradouro;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String novaCidade;
	private String estado;
	private String novoEstado;

	private List<SelectItem> comboCidade;
	private List<SelectItem> comboEstado;

	private String telefone;
	private String celular;
	private String email;

	private List<ClienteJoaoCarlosVO> listaClientes = null;

	private List<ClienteJoaoCarlosVO> itemSelecionado = new ArrayList<ClienteJoaoCarlosVO>();
	
	private ClienteJoaoCarlosVO vo;

	private Boolean renderModalCidade = Boolean.FALSE;

	private Boolean renderModalEstado = Boolean.FALSE;
	
	private Boolean renderTabelaCliente = Boolean.FALSE;
	
	private Boolean btnConsultar = Boolean.FALSE;

	@Override
	public void inicializar() {
		listaClientes = new ArrayList<ClienteJoaoCarlosVO>();
		vo = new ClienteJoaoCarlosVO();
		comboCidade = siteUtil.carregarComboCidadeJoaoCarlos();
		comboEstado = siteUtil.carregarComboEstadoJoaoCarlos();
		renderModalCidade = Boolean.FALSE;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public List<ClienteJoaoCarlosVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteJoaoCarlosVO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<ClienteJoaoCarlosVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteJoaoCarlosVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public ClienteJoaoCarlosVO getVo() {
		return vo;
	}

	public void setVo(ClienteJoaoCarlosVO vo) {
		this.vo = vo;
	}

	public Boolean getRenderModalCidade() {
		return renderModalCidade;
	}

	public void setRenderModalCidade(Boolean renderModalCidade) {
		this.renderModalCidade = renderModalCidade;
	}

	public Boolean getRenderModalEstado() {
		return renderModalEstado;
	}

	public void setRenderModalEstado(Boolean renderModalEstado) {
		this.renderModalEstado = renderModalEstado;
	}

	public Boolean getRenderTabelaCliente() {
		return renderTabelaCliente;
	}

	public void setRenderTabelaCliente(Boolean renderTabelaCliente) {
		this.renderTabelaCliente = renderTabelaCliente;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}
	
	

	
}
