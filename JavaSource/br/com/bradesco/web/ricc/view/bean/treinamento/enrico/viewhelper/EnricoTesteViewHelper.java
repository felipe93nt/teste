package br.com.bradesco.web.ricc.view.bean.treinamento.enrico.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteEnricoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class EnricoTesteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String sexo;
	private String estado;
	private String cidade;
	private String logradouro;
	private String bairro;
	private String numero;
	private String complemento;
	private String cep;
	private String celular;
	private String telefone;
	private String email;

	private ClienteEnricoVO cliente = new ClienteEnricoVO();
	

	
	
	@Override
	public void inicializar() {
		capturarUsuario();	
		clienteConsulta();
		
	}

	public void capturarUsuario() {

		this.nome = "";
		this.cpf = "";
		this.rg = "";
		this.dataNascimento = "";
		this.sexo = "";
		this.estado = "";
		this.cidade = "";
		this.logradouro = "";
		this.bairro = "";
		this.numero = "";
		this.complemento = "";
		this.cep = "";
		this.celular = "";
		this.telefone = "";
		this.email = "";

	}
	
	public ClienteEnricoVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEnricoVO cliente) {
		this.cliente = cliente;
	}

	public List<SelectItem> getComboEnricoEstado() {
		return siteUtil.enricoCarregarComboEstado();
	}

	public List<SelectItem> getComboEnricoCidade() {
		return siteUtil.enricoCarregarComboCidade();
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
		cliente= new ClienteEnricoVO();
		cliente.setNome("Natalia de Almeida Silva");
		cliente.setBairro("Jardim Belval");
		cliente.setCelular("(11) 96763-2343");
		cliente.setCep("06.420-360");
		cliente.setCidade("Barueri");
		cliente.setComplemento("Casa 3");
		cliente.setCpf("480.893.788/38");
		cliente.setTelefone("(11) 4189-3132");
		cliente.setLogradouro("Rua Santos Dummont");
		cliente.setNumero("09");
		cliente.setDataNascimento("27/12/1997");
		cliente.setEmail("natalia@gmail.com");
		cliente.setEstado("São Paulo");
		cliente.setRg("234.567.891");
		cliente.setSexo("Feminino");
		
	}
 } 
	 