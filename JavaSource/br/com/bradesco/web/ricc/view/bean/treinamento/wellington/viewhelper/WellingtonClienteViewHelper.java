package br.com.bradesco.web.ricc.view.bean.treinamento.wellington.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteWellingtonVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class WellingtonClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;
	
	private String nomeCompleto;
	private String cpf;
	private String rg;
	private String dataNascimento;
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

	@Override
	public void inicializar() {
	}

	public void carregarVO(ClienteWellingtonVO cliente){
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.rg = cliente.getRg();
		this.dataNascimento = cliente.getDataNascimento();
		this.sexo = cliente.getSexo();
		this.logradouro = cliente.getLogradouro();
		this.numero = cliente.getNumero();
		this.complemento = cliente.getComplemento();
		this.bairro = cliente.getBairro();
		this.cidade = cliente.getCidade();
		this.estado = cliente.getEstado();
		this.cep = cliente.getCep();
		this.telefone = cliente.getTelefone();
		this.celular = cliente.getCelular();
		this.email = cliente.getEmail();
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.wellingtonCarregarExemploComboEstado();
	}
	
	public List<SelectItem> getComboCidade() {
		return siteUtil.wellingtonCarregarExemploComboCidade();
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


}
