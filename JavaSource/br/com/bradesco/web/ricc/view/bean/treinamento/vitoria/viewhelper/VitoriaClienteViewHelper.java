package br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteVitoriaVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class VitoriaClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	
	
	private String exemploComboBox;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String dataNascimento;
	
	private String sexo;
	
	private String logradouro;
	
	private String numeroLogradouro; 
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String estado; 
	
	private String cep; 
	
	private String telefone;
	
	private String celular;
	
	private String email; 
	
	
	
	@Override
	public void inicializar() {
		
//		clienteSelecionado = new ArrayList<ClienteVitoriaVO>();
	}
	
	private ClienteVitoriaVO cliente = new ClienteVitoriaVO();
	
	
	public ClienteVitoriaVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVitoriaVO cliente) {
		this.cliente = cliente;
	}

	public List<SelectItem> getComboCidade() {
		return siteUtil.carregarExemploComboCidadeVitoria();
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.carregarExemploComboEstadoVitoria();
	}
	
	

//	public List<ListaCheckboxVO> getListaCheckboxSelecionada() {
//		return listaCheckboxSelecionada;
//	}

//	public void setListaCheckboxSelecionada(
//			List<ListaCheckboxVO> listaCheckboxSelecionada) {
//		this.listaCheckboxSelecionada = listaCheckboxSelecionada;
//	}

//	public List<ListaCheckboxVO> getListaCheckbox() {
//		return listaCheckbox;
//	}

//	public void setListaCheckbox(List<ListaCheckboxVO> listaCheckbox) {
//		this.listaCheckbox = listaCheckbox;
//	}

	public String getExemploComboBox() {
		return exemploComboBox;
	}

	public void setExemploComboBox(String exemploComboBox) {
		this.exemploComboBox = exemploComboBox;
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
	
	
	

}
