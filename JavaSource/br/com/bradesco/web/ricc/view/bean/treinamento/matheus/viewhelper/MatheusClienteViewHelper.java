package br.com.bradesco.web.ricc.view.bean.treinamento.matheus.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteMatheusVO;
import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;
import br.com.bradesco.web.ricc.view.bean.treinamento.matheus.bean.MatheusClienteBean;

/**
 * @name MatheusClienteViewHelper
 * @author mpoda
 * @see MatheusClienteViewHelper.java
 * @version 1.0
 * @since 04/05/2020	
 */
public class MatheusClienteViewHelper extends AbstractViewHelper{
	private static final long serialVersionUID = -1116835804304222911L;
	
	private List<ListaCheckboxVO> listaCheckboxSelecionada = new ArrayList<ListaCheckboxVO>();

	private List<ListaCheckboxVO> listaCheckbox = new ArrayList<ListaCheckboxVO>();
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String dataNascimento;

	private String sexo;
	
	private String logradouro;
	
	private String numeroLogradouro;
	
	private String bairro;
	
	private String complemento;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
	private String telefone;
	
	private String celular;
	
	private String email;
	
	private String exemploOutputText;
	
	private String exemploComboBox;
	
	private ClienteMatheusVO cliente = new ClienteMatheusVO();
	

	/**
	 * @description Usado para popular componentes na tela
	 * @name inicializar
	 * @see MatheusClienteViewHelper
	 * @return void
	 */
	@Override
	public void inicializar() {
		carregarTelaConsultar();
	}
	
	
//	public void capturarUsuario(){
//		this.exemploOutputText = "Exemplo de informação em OutputText!";
//	}

//	public List<ListaCheckboxVO> carregarListaCheckbox() {
//
//		listaCheckbox = new ArrayList<ListaCheckboxVO>();
//
//		ListaCheckboxVO obParam = new ListaCheckboxVO();
//		obParam.setCodigo(1);
//		obParam.setDescricao("Opção 1");
//		listaCheckbox.add(obParam);
//
//		ListaCheckboxVO obParam2 = new ListaCheckboxVO();
//		obParam2.setCodigo(1);
//		obParam2.setDescricao("Opção 2");
//		listaCheckbox.add(obParam2);
//
//		ListaCheckboxVO obParam3 = new ListaCheckboxVO();
//		obParam3.setCodigo(1);
//		obParam3.setDescricao("Opção 3");
//		listaCheckbox.add(obParam3);
//
//		ListaCheckboxVO obParam4 = new ListaCheckboxVO();
//		obParam4.setCodigo(1);
//		obParam4.setDescricao("Opção 4");
//		listaCheckbox.add(obParam4);
//
//		return listaCheckbox;
//	}
	
	//COMEÇO DOS GETTERS E SETTERS
	
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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


	public String getExemploOutputText() {
		return exemploOutputText;
	}

	public void setExemploOutputText(String exemploOutputText) {
		this.exemploOutputText = exemploOutputText;
	}

	public String getExemploComboBox() {
		return exemploComboBox;
	}

	public void setExemploComboBox(String exemploComboBox) {
		this.exemploComboBox = exemploComboBox;
	}
	
	
	
	public ClienteMatheusVO getcliente() {
		return cliente;
	}


	public void setcliente(ClienteMatheusVO cliente) {
		this.cliente = cliente;
	}


	//FIM DOS GETTERS E SETTERS
	/**
	 * @description Método para carregar a combo cidade com uma lista de constantes
	 * @name comboCidade
	 * @see MatheusClienteBean 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getComboCidade(){
		return siteUtil.carregarComboCidadeMatheus();
	}
	
	/**
	 * @description Método para carregar a combo estado com uma lista de constantes
	 * @name comboEstado
	 * @see MatheusClienteBean 
	 * @return List<SelectItem>
	 */
	public List<SelectItem> getComboEstado(){
		return siteUtil.carregarComboEstadoMatheus();
	}

	/**
	 * @description Método para limpar campos da tela
	 * @name limparCamposTelaCadastroCliente
	 * @see MatheusClienteBean
	 * @return 
	 */
	public void limparCamposTelaCadastroCliente(){
			nome=null;
			cpf=null;
			rg=null;
			dataNascimento=null;
			sexo=null;
			logradouro=null;
			numeroLogradouro=null;
			complemento=null;
			bairro=null;
			cidade=null;
			estado=null;
			cep=null;
			telefone=null;
			celular=null;
			email=null;
	}
	
	public void carregarTelaConsultar(){
		cliente.setNome("Matheus Poda");
		cliente.setCpf("488.729.658-45");
		cliente.setRg("56.555.888-9");
		cliente.setDataNascimento("23/10/2000");
		cliente.setSexo("M");
		cliente.setLogradouro("Avenida Edmundo Amaral");
		cliente.setNumeroLogradouro("130");
		cliente.setBairro("Jd Piratininga");
		cliente.setCidade("Osasco");
		cliente.setEstado("São Paulo");
		cliente.setCep("06230-150");
		cliente.setTelefone("(11)4857-8563");
		cliente.setCelular("(11)97508-3389");
		cliente.setEmail("matheus.poda@gmail.com");
	}
}
