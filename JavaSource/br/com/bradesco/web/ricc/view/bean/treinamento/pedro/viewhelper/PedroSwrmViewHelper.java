package br.com.bradesco.web.ricc.view.bean.treinamento.pedro.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClientePedroVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class PedroSwrmViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String nome, cpf, rg, dataNascimento, sexo, logradouro,
			numeroLogradouro, complemento, bairro, cidade, estado, cep,
			telefone, celular, email;

	private ClientePedroVO clienteVO = new ClientePedroVO();

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
		return siteUtil.pedroCarregarComboCidade();
	}

	@Override
	public void inicializar() {
	}

	public List<SelectItem> getComboEstado() {
		return siteUtil.pedroCarregarComboEstado();
	}

	public List<SelectItem> getComboSexo() {
		return siteUtil.pedroCarregarComboSexo();
	}

	public ClientePedroVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClientePedroVO clienteVO) {
		this.clienteVO = clienteVO;
	}

}
