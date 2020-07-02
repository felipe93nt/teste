/**
 * 
 */
package br.com.bradesco.web.ricc.view.bean.treinamento.anderson.viewhelper;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.ricc.model.treinamento.ClienteAndersonVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

/**
 * @author amendes
 *
 */
public class AndersonClienteViewhelper extends AbstractViewHelper {
	private static final long serialVersionUID = -111683580430422356L;
	
	private String nome;
	private CpfDataType cpf;
	private String rg;
	private Date dataNascimento;
	private String sexo;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private List<SelectItem> comboCidade;
	private String estado;
	private String cep;
	
	private String telefone;
	private String celular;
	private String email;
	private ClienteAndersonVO andersonClienteVO = new ClienteAndersonVO();
	
	
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
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
	
	public ClienteAndersonVO getAndersonClienteVO() {
		return andersonClienteVO;
	}
	public void setAndersonClienteVO(ClienteAndersonVO andersonClienteVO) {
		this.andersonClienteVO = andersonClienteVO;
	}
	public List<SelectItem> getComboCidade() {
		return siteUtil.carregarAndersonCidades();
	}
	
	public List<SelectItem> getComboEstado() {
		return siteUtil.carregarAndersonEstados();
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
	
	public void carregarConsulta(){	
		andersonClienteVO.setNome("Anderson Mendes de Souza");
		andersonClienteVO.setCpf("447.837.828-22");	
		andersonClienteVO.setRg("46.490.397-X");		
		andersonClienteVO.setDataNascimento("02/06/1995");		
		andersonClienteVO.setSexo("Masculino");		
		andersonClienteVO.setLogradouro("Rua Prof Queiros Filho");		
		andersonClienteVO.setNumero("392");
		andersonClienteVO.setComplemento("ap. 72");	
		andersonClienteVO.setBairro("Jd silveira");
		andersonClienteVO.setCidade("Barueri");		
		andersonClienteVO.setEstado("São Paulo");		
		andersonClienteVO.setCep("06434-080");		
		andersonClienteVO.setTelefone("(11); 8364-6699");		
		andersonClienteVO.setCelular("(11)98364-6699");		
		andersonClienteVO.setEmail("anderson.mendes@foursys.com.br");
	}
	
	
	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		carregarConsulta();
	}
	
	public void limpar(){
		
		nome=null;
		cpf=null;
		rg=null;
		dataNascimento=null;
		sexo=null;
		
		logradouro=null;
		numero=null;
		complemento=null;
		bairro=null;
		cidade=null;
		
		estado=null;
		cep=null;
		
		telefone=null;
		celular=null;
		email=null;
		
		
	}
	
	
	
	
	
	

}
