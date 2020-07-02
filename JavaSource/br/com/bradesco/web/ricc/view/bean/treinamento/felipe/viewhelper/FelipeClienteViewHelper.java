package br.com.bradesco.web.ricc.view.bean.treinamento.felipe.viewhelper;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteFelipeVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class FelipeClienteViewHelper extends AbstractViewHelper {
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
	
	
	private ClienteFelipeVO cliente = new ClienteFelipeVO();

	
	@Override
	public void inicializar() {
	}
	
	public ClienteFelipeVO getCliente() {
		carregarDados();
		return cliente;
	}

	public void setCliente(ClienteFelipeVO cliente) {
		this.cliente = cliente;
	}

	public List<SelectItem> getComboCidade() {
		return siteUtil.felipeCarregarExemploComboCidade();
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.felipeCarregarExemploComboEstado();
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
	
	//metodo pra carregar dados do cliente
	public void carregarDados(){
		cliente.setNome("Felipe Romon Domingues Correa");
		cliente.setCpf("413.308.658-98");
		cliente.setRg("37.608.424.8");
		cliente.setDataNasc("25/11/1991");
		cliente.setSexo("M");
		cliente.setLogradouro("Rua Augusto Perroni");
		cliente.setNumero("797");
		cliente.setComplemento("Bloco B");
		cliente.setBairro("Vila Butantã");
		cliente.setCidade("São Paulo");
		cliente.setEstado("São Paulo");
		cliente.setCep("05.539-020");
		cliente.setTelefone("(11)3721-7075");
		cliente.setCelular("(11)97609-0787");
		cliente.setEmail("felipe.correa@foursys.com.br");
	}
	
		
}
