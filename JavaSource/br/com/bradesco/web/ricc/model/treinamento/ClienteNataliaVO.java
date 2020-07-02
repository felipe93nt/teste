package br.com.bradesco.web.ricc.model.treinamento;

public class ClienteNataliaVO {

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

	public ClienteNataliaVO(){}
	public ClienteNataliaVO(String nomeCompleto, String cpf, String rg,
			String dataNascimento, String sexo, String estado, String cidade,
			String logradouro, String bairro, String numeroLogradouro,
			String complemento, String cep, String celular, String telefone,
			String email) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.estado = estado;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numeroLogradouro = numeroLogradouro;
		this.complemento = complemento;
		this.cep = cep;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
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

}
