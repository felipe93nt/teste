package br.com.bradesco.web.ricc.view.bean.treinamento.joaogil.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteJoaogilVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;
import br.com.bradesco.web.ricc.view.bean.treinamento.joaogil.bean.JoaogilTesteBean;

public class JoaogilTesteViewHelper extends AbstractViewHelper{
	private static final long serialVersionUID = -1116835804304222911L;
	
	private String nome;
	
	private String cpf;
	
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
	
	private Boolean renderModalCidade = Boolean.FALSE;
	
	private List<SelectItem> listaNovasCidades = new ArrayList<SelectItem>();
	
	private String novaCidade = "";

	private Boolean renderModalEstado = Boolean.FALSE;
	
	private List<SelectItem> listaNovosEstados = new ArrayList<SelectItem>();
	
	private String novoEstado = "";
	
	private List<ClienteJoaogilVO> itemSelecionado = new ArrayList<ClienteJoaogilVO>();
	
	private List<ClienteJoaogilVO> listaCadastramento = new ArrayList<ClienteJoaogilVO>();
	
	private ClienteJoaogilVO cliente = new ClienteJoaogilVO();
	
	private Boolean btnConsultar = Boolean.FALSE;
	
	@Override
	public void inicializar() {	}

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
	
	public Boolean getRenderModalCidade() {
		return renderModalCidade;
	}


	public void setRenderModalCidade(Boolean renderModalCidade) {
		this.renderModalCidade = renderModalCidade;
	}
	
	public List<SelectItem> getListaNovasCidades() {
		return listaNovasCidades;
	}
	
	public void setListaNovasCidades(List<SelectItem> listaNovasCidades) {
		this.listaNovasCidades = listaNovasCidades;
	}

	public String getNovaCidade() {
		return novaCidade;
	}

	public void setNovaCidade(String novaCidade) {
		this.novaCidade = novaCidade;
	}

	public Boolean getRenderModalEstado() {
		return renderModalEstado;
	}

	public void setRenderModalEstado(Boolean renderModalEstado) {
		this.renderModalEstado = renderModalEstado;
	}

	public List<SelectItem> getListaNovosEstados() {
		return listaNovosEstados;
	}

	public void setListaNovosEstados(List<SelectItem> listaNovosEstados) {
		this.listaNovosEstados = listaNovosEstados;
	}

	public String getNovoEstado() {
		return novoEstado;
	}

	public void setNovoEstado(String novoEstado) {
		this.novoEstado = novoEstado;
	}
	
	public List<ClienteJoaogilVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteJoaogilVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
	
	public List<ClienteJoaogilVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<ClienteJoaogilVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}
	
	public ClienteJoaogilVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteJoaogilVO cliente) {
		this.cliente = cliente;
	}
	
	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}
	
	//FIM DOS GETTERS E SETTERS

	/**
	 * @description Método para carregar a combo cidade com uma lista de constantes
	 * @name comboCidade
	 * @see JoaogilTesteBean 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getComboCidade(){
		return siteUtil.joaogilCarregarComboCidade();
	}
	
	/**
	 * @description Método para carregar a combo estado com uma lista de constantes
	 * @name comboEstado
	 * @see JoaogilTesteBean 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getComboEstado(){
		return siteUtil.joaogilCarregarComboEstado();
	}

}
