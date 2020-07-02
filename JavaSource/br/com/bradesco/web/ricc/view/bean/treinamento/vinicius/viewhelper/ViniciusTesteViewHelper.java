package br.com.bradesco.web.ricc.view.bean.treinamento.vinicius.viewhelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteEnzoVO;
import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ViniciusTesteViewHelper extends AbstractViewHelper {

private static final long serialVersionUID = -1116835804304222911L;
	
	private List<ListaCheckboxVO> listaCheckboxSelecionada = new ArrayList<ListaCheckboxVO>();

	private List<ListaCheckboxVO> listaCheckbox = new ArrayList<ListaCheckboxVO>();
	
	private String enzoInputText;

	private String enzoOutputText;
	
	private String nome;
	private String cpf;
	private String rg;
	private Date dataNascimento = new Date();
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

	private String cidadeComboBox;
	private String estadoComboBox;

	private ClienteEnzoVO cliente = new ClienteEnzoVO();

	public ClienteEnzoVO getCliente() {
		return cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCliente(ClienteEnzoVO cliente) {
		this.cliente = cliente;
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
		listaCheckbox = carregarListaCheckbox();
		listaCheckboxSelecionada = new ArrayList<ListaCheckboxVO>();
		capturarUsuario();
		consultaCliente();
	}
	
	public void capturarUsuario(){
		this.enzoOutputText = "Digite os dados exigidos!";
	}
	
	public List<ListaCheckboxVO> carregarListaCheckbox() {

		listaCheckbox = new ArrayList<ListaCheckboxVO>();

		ListaCheckboxVO obParam = new ListaCheckboxVO();
		obParam.setCodigo(1);
		obParam.setDescricao("Feminino");
		listaCheckbox.add(obParam);

		ListaCheckboxVO obParam2 = new ListaCheckboxVO();
		obParam2.setCodigo(1);
		obParam2.setDescricao("Masculino");
		listaCheckbox.add(obParam2);

		return listaCheckbox;
	}
	
	public List<SelectItem> getComboCidade() {   
		return siteUtil.carregarEnzoComboCidade(); 
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.carregarEnzoComboEstado();
	}

	public List<ListaCheckboxVO> getListaCheckboxSelecionada() {
		return listaCheckboxSelecionada;
	}

	public void setListaCheckboxSelecionada(
			List<ListaCheckboxVO> listaCheckboxSelecionada) {
		this.listaCheckboxSelecionada = listaCheckboxSelecionada;
	}

	public List<ListaCheckboxVO> getListaCheckbox() {
		return listaCheckbox;
	}

	public void setListaCheckbox(List<ListaCheckboxVO> listaCheckbox) {
		this.listaCheckbox = listaCheckbox;
	}

	public String getEnzoInputText() {
		return enzoInputText;
	}

	public void setEnzoInputText(String enzoInputText) {
		this.enzoInputText = enzoInputText;
	}

	public String getEnzoOutputText() {
		return enzoOutputText;
	}

	public void setEnzoOutputText(String enzoOutputText) {
		this.enzoOutputText = enzoOutputText;
	}


	public String getCidadeComboBox() {
		return cidadeComboBox;
	}

	public void setCidadeComboBox(String cidadeComboBox) {
		this.cidadeComboBox = cidadeComboBox;
	}

	public String getEstadoComboBox() {
		return estadoComboBox;
	}

	public void setEstadoComboBox(String estadoComboBox) {
		this.estadoComboBox = estadoComboBox;
	}

	public void consultaCliente() {
		cliente = new ClienteEnzoVO();

		cliente.setNome("Julio");
		cliente.setRg("51.896.465-4");
		cliente.setCpf("431.195.318-20");
		cliente.setDataNascimento("10/01/2000");
		cliente.setSexo("Masculino");

		cliente.setLogradouro("TesteL");
		cliente.setNumero("123");
		cliente.setComplemento("test");
		cliente.setBairro("TesteB");
		cliente.setCidade("São Paulo");
		cliente.setEstado("São Paulo");
		cliente.setCep("05.563-000");

		cliente.setTelefone("(11) 3781-8242");
		cliente.setCelular("(11) 95154-6098");
		cliente.setEmail("teste@teste.com");
	}
}
