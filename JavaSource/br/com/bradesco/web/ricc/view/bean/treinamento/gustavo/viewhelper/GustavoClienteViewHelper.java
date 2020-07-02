package br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.viewhelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteGustavoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class GustavoClienteViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1116835804304222911L;

	private String nome;
	private String rg;
	private String cpf;
	private String sexo;

	private Date dataNascimento;
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	private String cidade;
	private String estado;
	private String bairro;

	private String telefone;
	private String celular;
	private String email;
	private ClienteGustavoVO clienteGustavoVO = new ClienteGustavoVO();
	private List<ClienteGustavoVO> listaClienteGustavoVO = new ArrayList<ClienteGustavoVO>();

	@Override
	public void inicializar() {

	}

	
	
	public List<ClienteGustavoVO> getListaClienteGustavoVO() {
		return listaClienteGustavoVO;
	}



	public void setListaClienteGustavoVO(
			List<ClienteGustavoVO> listaClienteGustavoVO) {
		this.listaClienteGustavoVO = listaClienteGustavoVO;
	}



	public ClienteGustavoVO getClienteGustavoVO() {
		return clienteGustavoVO;
	}


	public void setClienteGustavoVO(ClienteGustavoVO clienteGustavoVO) {
		this.clienteGustavoVO = clienteGustavoVO;
	}


	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<SelectItem> getComboCidades() {
		return siteUtil.carregarComboBoxCidadesGustavo();
	}

	public List<SelectItem> getComboEstados() {
		return siteUtil.carregarComboBoxEstadosGustavo();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

}
