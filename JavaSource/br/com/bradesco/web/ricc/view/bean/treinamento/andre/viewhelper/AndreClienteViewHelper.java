package br.com.bradesco.web.ricc.view.bean.treinamento.andre.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteAndreVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

/**
 * 
 * @author atnunes
 *
 */

public class AndreClienteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1125943304793985365L;

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

	private List<ClienteAndreVO> consultaCliente = null;
	
	private ClienteAndreVO cvo = new ClienteAndreVO();

	@Override
	public void inicializar() {
	//	capturarCliente();
		consultarCliente();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<SelectItem> getComboCidade() {
		return siteUtil.carregarComboCidadeAndre();
	}

	public List<SelectItem> getComboEstado() {
		return siteUtil.carregarComboEstadoAndre();
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

	public ClienteAndreVO getCvo() {
		return cvo;
	}

	public void setCvo(ClienteAndreVO cvo) {
		this.cvo = cvo;
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

	public List<ClienteAndreVO> getConsultaCliente() {
		return consultaCliente;
	}

	public void setConsultaCliente(ArrayList<ClienteAndreVO> arrayList) {
		this.consultaCliente = arrayList;
	}

//	public void carregarCliente() {
//
//		setConsultaCliente(new ArrayList<ClienteAndreVO>());
//		getConsultaCliente().add(
//				new ClienteAndreVO("Andre", "316.196.708-95", "35.049.480-0",
//						"18/05/1982", "M", "SP", "Osasco", "Rua", "Bairro",
//						"123", "a42", "06.233-030", "(11) 3993-4222",
//						"(11) 95689-2569", "a@b.com"));
//
//	}

	
	public void capturarCliente(){
		this.nome = "André";
		this.cpf = "316.196.708-95";
		this.rg = "35.049.480-0";
		this.data = "18/05/1982";
		this.sexo = "M";
		this.logradouro = "Rua";
		this.numero = 123;
		this.bairro = "Bairro";
		this.cidade = "Osasco";
		this.estado = "SP";
		this.complemento = "a42";
		this.cep = "06.233-030";
		this.telefone = "(11) 3993-4222";
		this.celular = "(11) 95689-2569";
		this.email = "a@b.com";
	
	}
	
	   public void consultarCliente(){
	         cvo = new ClienteAndreVO();
	        
	         cvo.setNome("André Nunes");
	         cvo.setCpf("316.325.369.15");
	         cvo.setRg("35.215.145-5");
	         cvo.setData("15/10/2000");
	         cvo.setSexo("Masculino");
	         cvo.setLogradouro("Rua teste");
	         cvo.setNumero("123");
	         cvo.setComplemento("a42");
	         cvo.setBairro("Bairro");
	         cvo.setCidade("Cidade");
	         cvo.setEstado("Estado");
	         cvo.setCep("35.123.15");
	         cvo.setTelefone("(11) 3545-5896");
	         cvo.setCelular("(11) 35698-5968");
	         cvo.setEmail("a@b.com");
	        
	       
	       
	    }
}
