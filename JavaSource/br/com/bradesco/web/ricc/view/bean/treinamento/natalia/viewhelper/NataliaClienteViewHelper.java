package br.com.bradesco.web.ricc.view.bean.treinamento.natalia.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteNataliaVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class NataliaClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 1L;

	private String nomeCompleto;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String sexo;
	private String estado;
	private String cidade;
	private String logradouro;
	private String bairro;
	private String numeroLogradouro;
	private String complemento;
	private String cep;
	private String celular;
	private String telefone;
	private String email;

	private ClienteNataliaVO cliente = new ClienteNataliaVO();
	
	
	@Override
	public void inicializar() {
		capturarUsuario();	
		clienteConsulta();
		
	}


	public void capturarUsuario() {

		this.nomeCompleto = "";
		this.cpf = "";
		this.rg = "";
		this.dataNascimento = "";
		this.sexo = "";
		this.estado = "";
		this.cidade = "";
		this.logradouro = "";
		this.bairro = "";
		this.numeroLogradouro = "";
		this.complemento = "";
		this.cep = "";
		this.celular = "";
		this.telefone = "";
		this.email = "";

	}
	
	

	public ClienteNataliaVO getCliente() {
		return cliente;
	}


	public void setCliente(ClienteNataliaVO cliente) {
		this.cliente = cliente;
	}


	public List<SelectItem> getComboNataliaEstado() {
		return siteUtil.carregarNataliaEstado();
	}

	public List<SelectItem> getComboNataliaCidade() {
		return siteUtil.carregarNataliaCidade();
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void clienteConsulta(){
		cliente= new ClienteNataliaVO();
		cliente.setNomeCompleto("Natalia de Almeida Silva");
		cliente.setBairro("Jardim Belval");
		cliente.setCelular("(11) 96763-2343");
		cliente.setCep("06.420-360");
		cliente.setCidade("Barueri");
		cliente.setComplemento("Casa 3");
		cliente.setCpf("480.893.788/38");
		cliente.setTelefone("(11) 4189-3132");
		cliente.setLogradouro("Rua Santos Dummont");
		cliente.setNumeroLogradouro("09");
		cliente.setDataNascimento("27/12/1997");
		cliente.setEmail("natalia@gmail.com");
		cliente.setEstado("S�o Paulo");
		cliente.setRg("234.567.891");
		cliente.setSexo("Feminino");
		
	}
 } 
	 

