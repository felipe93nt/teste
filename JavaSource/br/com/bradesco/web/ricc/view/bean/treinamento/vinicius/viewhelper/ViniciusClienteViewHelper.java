package br.com.bradesco.web.ricc.view.bean.treinamento.vinicius.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.ClienteViniciusVO;
import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ViniciusClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private List<ListaCheckboxVO> listaCheckboxSelecionada = new ArrayList<ListaCheckboxVO>();

	private List<ListaCheckboxVO> listaCheckbox = new ArrayList<ListaCheckboxVO>();

	private String exemploInputText;

	private String clienteOutputText;

	private String exemploComboBox;

	private String comboboxCidade;

	private String comboboxEstado;

	private String nome;

	private String cpf;

	private String rg;

	private String data;

	private String sexo;

	private String logradouro;

	private int numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String estado;

	private String cep;

	private String telefone;

	private String celular;

	private String email;

	ClienteViniciusVO viniciusVO = new ClienteViniciusVO();
	
	@Override
	public void inicializar() {
		listaCheckbox = carregarListaCheckbox();
		listaCheckboxSelecionada = new ArrayList<ListaCheckboxVO>();
		capturarUsuario();
	}

	public void capturarUsuario() {
		this.clienteOutputText = "Exemplo de informação em OutputText!";
	}

	public List<ListaCheckboxVO> carregarListaCheckbox() {

		listaCheckbox = new ArrayList<ListaCheckboxVO>();

		ListaCheckboxVO obParam = new ListaCheckboxVO();
		obParam.setCodigo(1);
		obParam.setDescricao("Opção 1");
		listaCheckbox.add(obParam);

		ListaCheckboxVO obParam2 = new ListaCheckboxVO();
		obParam2.setCodigo(1);
		obParam2.setDescricao("Opção 2");
		listaCheckbox.add(obParam2);

		ListaCheckboxVO obParam3 = new ListaCheckboxVO();
		obParam3.setCodigo(1);
		obParam3.setDescricao("Opção 3");
		listaCheckbox.add(obParam3);

		ListaCheckboxVO obParam4 = new ListaCheckboxVO();
		obParam4.setCodigo(1);
		obParam4.setDescricao("Opção 4");
		listaCheckbox.add(obParam4);

		return listaCheckbox;
	}
	
	public ClienteViniciusVO getViniciusVO() {
		return viniciusVO;
	}

	public void setViniciusVO(ClienteViniciusVO viniciusVO) {
		this.viniciusVO = viniciusVO;
	}

	public List<SelectItem> getComboTreinamento() {
		return siteUtil.carregarExemploComboTreinamento();
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

	public String getExemploInputText() {
		return exemploInputText;
	}

	public void setExemploInputText(String exemploInputText) {
		this.exemploInputText = exemploInputText;
	}

	public String getClienteOutputText() {
		return clienteOutputText;
	}

	public void setClienteOutputText(String clienteOutputText) {
		this.clienteOutputText = clienteOutputText;
	}

	public String getExemploComboBox() {
		return exemploComboBox;
	}

	public void setExemploComboBox(String exemploComboBox) {
		this.exemploComboBox = exemploComboBox;
	}

	public List<SelectItem> getComboCidade() {
		return siteUtil.comboViniciusCidade();
	}

	public List<SelectItem> getComboEstado() {
		return siteUtil.comboViniciusEstado();
	}

	public String getComboboxCidade() {
		return comboboxCidade;
	}

	public void setComboboxCidade(String comboboxCidade) {
		this.comboboxCidade = comboboxCidade;
	}

	public void setComboboxEstado(String comboboxEstado) {
		this.comboboxEstado = comboboxEstado;
	}

	public String getComboboxEstado() {
		return comboboxEstado;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public void geraCliente(){
		viniciusVO = new ClienteViniciusVO();
		
		viniciusVO.setNome("Vinicius");
		viniciusVO.setData("26/11/2000");
		viniciusVO.setRg("54.196.036-0");
		viniciusVO.setCpf("457.445.881-71");
		viniciusVO.setSexo("masculino");
		viniciusVO.setLogradouro("R. Robert Kennedy");
		viniciusVO.setNumero("560");
		viniciusVO.setComplemento("");
		viniciusVO.setBairro("Jd. Veloso");
		viniciusVO.setCidade("Osasco");
		viniciusVO.setEstado("São Paulo");
		viniciusVO.setCep("06144-110");
		viniciusVO.setTelefone("(11)4400-2308");
		viniciusVO.setCelular("(11)96239-3267");
		viniciusVO.setEmail("vinisantos.xf2@gmail.com");
	}

}
