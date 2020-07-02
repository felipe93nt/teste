package br.com.bradesco.web.ricc.view.bean.treinamento.claudio.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.ClienteClaudioVO;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ClaudioTesteViewHelper extends AbstractViewHelper {
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
	
	private Boolean renderModal = Boolean.FALSE;
	
	private Boolean btnConsultar = Boolean.FALSE;
	
	private String cliente;
	
	private Boolean btnConsulta = Boolean.FALSE;
	
	private ClienteClaudioVO vo = new ClienteClaudioVO();
	
	public ClienteClaudioVO getVo() {
		return vo;
	}

	public void setVo(ClienteClaudioVO vo) {
		this.vo = vo;
	}

	private List<CadastramentoVO> listaClientes;
	
	private String informacoesPessoais;
	private String contato;
	private String endereco;

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

	public Boolean getBtnConsulta() {
		return btnConsulta;
	}

	public void setBtnConsulta(Boolean btnConsulta) {
		this.btnConsulta = btnConsulta;
	}
	
	public List<CadastramentoVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<CadastramentoVO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}



	private String comboBoxCidade;
	private String comboBoxEstado;
	
	@Override
	public void inicializar() {
		listaCheckbox = carregarListaCheckBox();
		
		capturarUsuario();
	}
	
	public void capturarUsuario(){
		this.informacoesPessoais = "";
		this.endereco = "";
		this.contato = "";
	}

	public List<ListaCheckboxVO> carregarListaCheckBox() {

		listaCheckbox = new ArrayList<ListaCheckboxVO>();

		ListaCheckboxVO obParam = new ListaCheckboxVO();
		obParam.setCodigo(1);
		obParam.setDescricao("--Selecione o Sexo--");
		listaCheckbox.add(obParam);
		
		ListaCheckboxVO obParam1 = new ListaCheckboxVO();
		obParam1.setCodigo(1);
		obParam1.setDescricao("Masculino");
		listaCheckbox.add(obParam1);

		ListaCheckboxVO obParam2 = new ListaCheckboxVO();
		obParam2.setCodigo(1);
		obParam2.setDescricao("Feminino");
		listaCheckbox.add(obParam2);
		
		return listaCheckbox;
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.enricoCarregarComboEstado();
	}

	public List<SelectItem> getComboCidade() {
		return siteUtil.enricoCarregarComboCidade();
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

	public String getInformacoesPessoais() {
		return informacoesPessoais;
	}

	public void setInformacoesPessoais(String informacoesPessoais) {
		this.informacoesPessoais = informacoesPessoais;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComboBoxCidade() {
		return comboBoxCidade;
	}

	public void setComboBoxCidade(String comboBoxCidade) {
		this.comboBoxCidade = comboBoxCidade;
	}

	public String getComboBoxEstado() {
		return comboBoxEstado;
	}

	public void setComboBoxEstado(String comboBoxEstado) {
		this.comboBoxEstado = comboBoxEstado;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public void dadosfake(){
		vo = new ClienteClaudioVO();
	
		vo.setNome("Cladio");
		vo.setCpf("111.123.111-11");
		vo.setRg("11.111.111-1");
		vo.setDataNascimento("11/01/1999");
		vo.setSexo("Masculino");
		vo.setLogradouro("Rua Bezerra");
		vo.setNumero("173");
		vo.setComplemento("Casa 1");
		vo.setBairro("Umuarama");
		vo.setCidade("Osasco");
		vo.setEstado("São Paulo");
		vo.setCep("06028-220");
		vo.setTelefone("(11)3654-0464");
		vo.setCelular("(11)97115-5819");
		vo.setEmail("claudioteste@gmail.com");
		
	}
	

}
