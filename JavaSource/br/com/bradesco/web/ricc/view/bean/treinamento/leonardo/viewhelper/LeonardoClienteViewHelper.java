package br.com.bradesco.web.ricc.view.bean.treinamento.leonardo.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.ricc.model.treinamento.ClienteLeonardoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class LeonardoClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String exemploInputText;

	private String exemploOutputText;

	private String nome;
	private CpfDataType cpf;
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

	private ClienteLeonardoVO clienteVO = new ClienteLeonardoVO();

	@Override
	public void inicializar() {
		geraCliente();
	}

	public void limparCampos() {
		nome = null;
		cpf = null;
		rg = null;
		dataNascimento = null;
		sexo = null;
		logradouro = null;
		numero = null;
		complemento = null;
		bairro = null;
		cidade = null;
		estado = null;
		cep = null;
		telefone = null;
		celular = null;
		email = null;
	}

	public void geraCliente() {
		
		clienteVO.setNome("Leonardo");
		clienteVO.setCpf("471.213.123-12");
		clienteVO.setRg("39.929.929-1");
		clienteVO.setDataNascimento("01/06/1998");
		clienteVO.setSexo("Masculino");

		clienteVO.setLogradouro("Alameda Santos");
		clienteVO.setNumero("594");
		clienteVO.setComplemento("Casa 1");
		clienteVO.setBairro("Carrao");
		clienteVO.setCidade("Osasco");
		clienteVO.setEstado("São Paulo");
		clienteVO.setCep("06205-000");

		clienteVO.setTelefone("(11) 3656-5675");
		clienteVO.setCelular("(11) 97958-8839");
		clienteVO.setEmail("leolopo@teste.com");

	}

	public List<SelectItem> getComboCidade() {
		return siteUtil.carregarComboLeonardoCidade();
	}

	public List<SelectItem> getComboEstado() {
		return siteUtil.carregarComboLeonardoEstado();
	}

	public String getExemploInputText() {
		return exemploInputText;
	}

	public void setExemploInputText(String exemploInputText) {
		this.exemploInputText = exemploInputText;
	}

	public String getExemploOutputText() {
		return exemploOutputText;
	}

	public void setExemploOutputText(String exemploOutputText) {
		this.exemploOutputText = exemploOutputText;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CpfDataType getCpf() {
		return cpf;
	}

	public void setCpf(CpfDataType cpf) {
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

	public ClienteLeonardoVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteLeonardoVO clienteVO) {
		this.clienteVO = clienteVO;
	}

}
