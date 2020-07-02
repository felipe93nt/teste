package br.com.bradesco.web.ricc.view.bean.treinamento.joaogil.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteJoaogilVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class JoaogilClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;
	
	private String nomeCompleto;
	
	private String cpf;
	
	private String rg;
	
	private String dataNascimento;
	
	private String sexo;
	
	private String estado;
	
	private String cidade;
	
	private String cep;
	
	private String bairro;
	
	private String logradouro;
	
	private String numeroLogradouro;
	
	private String complemento;
	
	private String telefone;
	
	private String celular;
	
	private String email;
	
	private ClienteJoaogilVO clienteVO = new ClienteJoaogilVO("Cliente Teste", "123.456.789-01", "12.345.678-9", "01/01/2000",
			"MASCULINO", "São Paulo", "São Paulo", "05.411-002", "Bairro teste", "Rua teste", "123", "Apto 10", "(11) 4002-8922",
			"(11) 12345-6789", "teste@teste.com");
	
	@Override
	public void inicializar() { }
	
	public List<SelectItem> getRadioSexo() {
		return siteUtil.joaogilCarregarRadioSexo();
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.joaogilCarregarComboEstado();
	}
	
	public List<SelectItem> getComboCidade() {
		return siteUtil.joaogilCarregarComboCidade();
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public ClienteJoaogilVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteJoaogilVO clienteVO) {
		this.clienteVO = clienteVO;
	}
	
}
