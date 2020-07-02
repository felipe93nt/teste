package br.com.bradesco.web.ricc.view.bean.treinamento.claudio.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.ClienteClaudioVO;
import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ClaudioClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private List<ListaCheckboxVO> listaCheckbox = new ArrayList<ListaCheckboxVO>();
	
	private String nome;
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

	private String exemploOutputText;
	
	private String estadoComboBox;
	
	private String cidadeComboBox;
	
	private ClienteClaudioVO vo = new ClienteClaudioVO();
	
	@Override
	public void inicializar() {
		listaCheckbox = carregarListaCheckbox();
		capturarUsuario();
	}
	
	public void capturarUsuario(){
		this.exemploOutputText = "Exemplo de informação em OutputText!";
	}

	public List<ListaCheckboxVO> carregarListaCheckbox() {

		listaCheckbox = new ArrayList<ListaCheckboxVO>();

		ListaCheckboxVO obParam = new ListaCheckboxVO();
		obParam.setCodigo(1);
		obParam.setDescricao("Masculino");
		listaCheckbox.add(obParam);

		ListaCheckboxVO obParam2 = new ListaCheckboxVO();
		obParam2.setCodigo(1);
		obParam2.setDescricao("Feminino");
		listaCheckbox.add(obParam2);

		return listaCheckbox;
	}
	
	public void popularCampos(){
		vo = new ClienteClaudioVO();
		vo.setNome("Claudio de Sousa");
		vo.setCpf("489.137.489-10");
		vo.setRg("50.718.938-3");
		vo.setDataNascimento("11/01/1999");
		vo.setSexo("Masculino");
		vo.setLogradouro("Rua bezerra");
		vo.setNumero("173");
		vo.setComplemento("Casa A");
		vo.setBairro("Umuarama");
		vo.setEstado("São Paulo");
		vo.setCidade("Osasco");
		vo.setCep("06028220");
		vo.setTelefone("(11)3654-0464");
		vo.setCelular("(11)97115-5819");
		vo.setEmail("leite.claudio99@gmail.com");
		
	}
	
	public ClienteClaudioVO getClienteClaudioVO() {
		return vo;
	}

	public void setclienteClaudioVO(ClienteClaudioVO vo) {
		this.vo = vo;
	}
	
	public List<SelectItem> getComboCidade() {
		return siteUtil.carregarExemploComboCidadeClaudio();
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.carregarExemploComboEstadoClaudio();
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

	public String getExemploOutputText() {
		return exemploOutputText;
	}

	public void setExemploOutputText(String exemploOutputText) {
		this.exemploOutputText = exemploOutputText;
	}

	public String getEstadoComboBox() {
		return estadoComboBox;
	}

	public void setEstadoComboBox(String estadoComboBox) {
		this.estadoComboBox = estadoComboBox;
	}

	public String getCidadeComboBox() {
		return cidadeComboBox;
	}

	public void setCidadeComboBox(String cidadeComboBox) {
		this.cidadeComboBox = cidadeComboBox;
	}

	public ClienteClaudioVO getVo() {
		return vo;
	}

	public void setVo(ClienteClaudioVO vo) {
		this.vo = vo;
	}
}
