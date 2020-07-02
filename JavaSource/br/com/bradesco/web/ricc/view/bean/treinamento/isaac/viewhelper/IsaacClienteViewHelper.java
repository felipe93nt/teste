package br.com.bradesco.web.ricc.view.bean.treinamento.isaac.viewhelper;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteIsaacVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class IsaacClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String nomeCompleto;
	private String cpf;
	private String rg;
	private Date dataNascimento = new Date();
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

	private ClienteIsaacVO clienteVO = new ClienteIsaacVO();
	
	public List<SelectItem> getIsaacComboTreinamentoCidade() {
		return siteUtil.carregarIsaacComboCidade();
	}

	public List<SelectItem> getIsaacComboTreinamentoEstado() {
		return siteUtil.carregarIsaacComboEstado();
	}
	
	public ClienteIsaacVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteIsaacVO clienteVO) {
		this.clienteVO = clienteVO;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void inicializar() {
		DadosConsulta();
	}


	
	
	public void DadosConsulta(){
		
		clienteVO= new ClienteIsaacVO();
		
		clienteVO.setBairro(getBairro());
		clienteVO.setCelular(getCelular());
		clienteVO.setCep(getCep());
		clienteVO.setCidade(getCidade());
		clienteVO.setComplemento(getComplemento());
		clienteVO.setCpf(getCep());
		clienteVO.setDataNascimento(getDataNascimento().toString());
		clienteVO.setEmail(getEmail());
		clienteVO.setEstado(getEstado());
		clienteVO.setLogradouro(getLogradouro());
		clienteVO.setNomeCompleto(getNomeCompleto());
		clienteVO.setNumeroLogradouro(getNumeroLogradouro());
		clienteVO.setRg(getRg());
		clienteVO.setSexo(getSexo());
		clienteVO.setTelefone(getTelefone());
	}
}
