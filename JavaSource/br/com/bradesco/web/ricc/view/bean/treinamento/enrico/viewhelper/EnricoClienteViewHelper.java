package br.com.bradesco.web.ricc.view.bean.treinamento.enrico.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteEnricoVO;
import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class EnricoClienteViewHelper extends AbstractViewHelper {
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
	
	private String informacoesPessoais;
	private String contato;
	private String endereco;
	
	private ClienteEnricoVO enricoclienteVO = new ClienteEnricoVO();
	
	public ClienteEnricoVO getEnricoclienteVO() {
		return enricoclienteVO;
	}

	public void setEnricoclienteVO(ClienteEnricoVO enricoclienteVO) {
		this.enricoclienteVO = enricoclienteVO;
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

	private String comboBoxCidade;
	private String comboBoxEstado;
	
	@Override
	public void inicializar() {
		listaCheckbox = carregarListaCheckBox();
		
		capturarUsuario();
	}
	
	public void dadosfake(){
		enricoclienteVO = new ClienteEnricoVO();
	
		enricoclienteVO.setNome("Enrico");
		enricoclienteVO.setCpf("473.123.378-05");
		enricoclienteVO.setRg("52.238.190-X");
		enricoclienteVO.setDataNascimento("09/06/1999");
		enricoclienteVO.setSexo("Masculino");
		enricoclienteVO.setLogradouro("Rua Victor Brecheret");
		enricoclienteVO.setNumero("520");
		enricoclienteVO.setComplemento("T8 8D");
		enricoclienteVO.setBairro("Vila Yara");
		enricoclienteVO.setCidade("Osasco");
		enricoclienteVO.setEstado("São Paulo");
		enricoclienteVO.setCep("06026-000");
		enricoclienteVO.setTelefone("(11)3699-0882");
		enricoclienteVO.setCelular("(11)97026-4661");
		enricoclienteVO.setEmail("cioffienrico@gmail.com");
		
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

}
