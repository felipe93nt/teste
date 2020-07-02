package br.com.bradesco.web.ricc.view.bean.treinamento.guilherme.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteGuilhermeVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class GuilhermeClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
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
	private String atencao;

	private ClienteGuilhermeVO clienteVO = new ClienteGuilhermeVO();
	
	@Override
	public void inicializar() {
		capturarUsuario();
		consultarCliente();
	}

	public void capturarUsuario() {
		this.atencao = "Dados do cliente abaixo!";
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

	public String getAtencao() {
		return atencao;
	}

	public void setAtencao(String atencao) {
		this.atencao = atencao;
	}

	public List<SelectItem> getComboCidade() {
		return siteUtil.carregarComboCidadesGuilherme();
	}

	public List<SelectItem> getComboEstado() {
		return siteUtil.carregarComboEstadosGuilherme();
	}
	
	

	public ClienteGuilhermeVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteGuilhermeVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public ClienteGuilhermeVO consultarCliente() {

		this.clienteVO.setNome("Guilherme Tomaz");
		this.clienteVO.setCpf("123.456.789-10");
		this.clienteVO.setRg("12.212.412");
		this.clienteVO.setDataNascimento("02/01/2001");
		this.clienteVO.setSexo("Masculino");
		this.clienteVO.setLogradouro("Rua Aracaju");
		this.clienteVO.setNumeroLogradouro("542");
		this.clienteVO.setComplemento("Casa 3");
		this.clienteVO.setBairro("Parque Turiguara");
		this.clienteVO.setCidade("Cotia");
		this.clienteVO.setEstado("São Paulo");
		this.clienteVO.setCep("06.703-300");
		this.clienteVO.setTelefone("(11)4002-8922");
		this.clienteVO.setCelular("(11)94002-8922");
		this.clienteVO.setEmail("guilherme@teste.com");

		return this.clienteVO;
	}
}
