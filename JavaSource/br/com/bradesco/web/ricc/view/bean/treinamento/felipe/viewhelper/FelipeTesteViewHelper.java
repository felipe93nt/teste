/**
 * 
 */
package br.com.bradesco.web.ricc.view.bean.treinamento.felipe.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteFelipeVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

/**
 * @author fcorrea
 *
 */
public class FelipeTesteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String nome;
	private String cpf;
	private String rg;
	private String dataNasc;
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

	private String atencao;

	private List<SelectItem> listaCidade;

	private List<SelectItem> listaEstado;

	private String novaCidade;

	private String novoEstado = null;

	private Boolean btnConsultar = Boolean.FALSE;

	private List<ClienteFelipeVO> listaClienteSelecionado = new ArrayList<ClienteFelipeVO>();

	// private ClienteFelipeVO clienteSelecionado = new ClienteFelipeVO();

	private List<ClienteFelipeVO> listaClientes = new ArrayList<ClienteFelipeVO>();

	private ClienteFelipeVO cliente = new ClienteFelipeVO();

	@Override
	public void inicializar() {
		capturarUsuario();
	}

	public void capturarUsuario() {
		this.atencao = "Dados do cliente abaixo!";
	}

	public ClienteFelipeVO getCliente() {
		// carregarDados();
		return cliente;
	}

	
	public List<SelectItem> getListaCidade() {
		return listaCidade;
	}

	public void setListaCidade(List<SelectItem> listaCidade) {
		this.listaCidade = listaCidade;
	}

	public List<SelectItem> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<SelectItem> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public String getNovaCidade() {
		return novaCidade;
	}

	public void setNovaCidade(String novaCidade) {
		this.novaCidade = novaCidade;
	}

	public String getNovoEstado() {
		return novoEstado;
	}

	public void setNovoEstado(String novoEstado) {
		this.novoEstado = novoEstado;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public List<ClienteFelipeVO> getListaClienteSelecionado() {
		return listaClienteSelecionado;
	}

	public void setListaClienteSelecionado(
			List<ClienteFelipeVO> listaClienteSelecionado) {
		this.listaClienteSelecionado = listaClienteSelecionado;
	}

	// public ClienteFelipeVO getClienteSelecionado() {
	// return clienteSelecionado;
	// }
	//
	// public void setClienteSelecionado(ClienteFelipeVO clienteSelecionado) {
	// this.clienteSelecionado = clienteSelecionado;
	// }

	public List<ClienteFelipeVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteFelipeVO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void setCliente(ClienteFelipeVO cliente) {
		this.cliente = cliente;
	}

	public String getAtencao() {
		return atencao;
	}

	public void setAtencao(String atencao) {
		this.atencao = atencao;
	}

	public List<SelectItem> getComboCidade() {
		if(novaCidade == null || novaCidade == ""){
			listaCidade = siteUtil.carregarComboCidadeAndre();
		}else{
			for (SelectItem item : listaCidade) {
				if(item.getLabel().equals(novaCidade)){
					return listaCidade;	
				}
			}
			listaCidade.add(new SelectItem(novaCidade, novaCidade));
		}
		return listaCidade;
	}

	public List<SelectItem> getComboEstado() {
		if (novoEstado == null || novoEstado == "") {
			listaEstado = siteUtil.carregarComboEstadoAndre();
		} else {
			for (SelectItem item : listaEstado) {
				if(item.getLabel().equals(novoEstado)){
					return listaEstado;	
				}
			}
			listaEstado.add(new SelectItem(novoEstado, novoEstado));
		}
		return listaEstado;
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
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

	// metodo pra carregar dados do cliente moc
	// public void carregarDados(){
	// cliente.setNome(clienteSelecionado.getNome());
	// cliente.setCpf(clienteSelecionado.getCpf());
	// cliente.setRg(clienteSelecionado.getRg());
	// cliente.setDataNasc(clienteSelecionado.getDataNasc());
	// cliente.setSexo(clienteSelecionado.getSexo());
	// cliente.setLogradouro(clienteSelecionado.getLogradouro());
	// cliente.setNumero(clienteSelecionado.getNumero());
	// cliente.setComplemento(clienteSelecionado.getComplemento());
	// cliente.setBairro(clienteSelecionado.getBairro());
	// cliente.setCidade(clienteSelecionado.getCidade());
	// cliente.setEstado(clienteSelecionado.getEstado());
	// cliente.setCep(clienteSelecionado.getCep());
	// cliente.setTelefone(clienteSelecionado.getTelefone());
	// cliente.setCelular(clienteSelecionado.getCelular());
	// cliente.setEmail(clienteSelecionado.getEmail());
	// }

}