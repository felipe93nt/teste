package br.com.bradesco.web.ricc.view.bean.treinamento.wellington.viewhelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteWellingtonVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;
import br.com.bradesco.web.ricc.view.bean.treinamento.wellington.bean.WellingtonTesteBean;

public class WellingtonTesteViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1116835804304222911L;

	private String nome;
	private String rg;
	private String cpf;
	private String sexo;

	private Date dataNascimento;
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	private String cidade;
	private String estado;
	private String bairro;

	private String telefone;
	private String celular;
	private String email;

	private String estadoAux;
	private String ufAux;
	private String cidadeAux;
	private ClienteWellingtonVO clienteWellingtonVO = new ClienteWellingtonVO();
	private List<ClienteWellingtonVO> listaClienteWellingtonVO = new ArrayList<ClienteWellingtonVO>();
	private List<ClienteWellingtonVO> itemSelecionado = new ArrayList<ClienteWellingtonVO>();
	private List<ClienteWellingtonVO> listaCadastramento = new ArrayList<ClienteWellingtonVO>();
	private List<SelectItem> comboEstado;
	private List<SelectItem> comboCidade;
	
	private Boolean btnConsultar = Boolean.TRUE;
	private Boolean renderModalCidade = Boolean.FALSE;
	private Boolean renderModalEstado = Boolean.FALSE;
	private Boolean tabela = Boolean.FALSE;
	

	@Override
	public void inicializar() {
		verificarTabela();
		comboEstado = getComboEstados();
		adicionarEstadosUsuario();
		comboCidade = getComboCidades();
		adicionarCidadesUsuario();
		adicionarClientesCadastrados();
	}

	public void verificarTabela(){
		if (!WellingtonTesteBean.clientesCadastrados.isEmpty()){
			tabela = true;
		}
	}
	
	public void adicionarEstadosUsuario() {
		List<SelectItem> estadosAdicionados = WellingtonTesteBean.estadosAdicionados;
		for (SelectItem selectItem : estadosAdicionados) {
			comboEstado.add(selectItem);
		}
	}
	
	public void adicionarCidadesUsuario() {
		List<SelectItem> cidadesAdicionadas = WellingtonTesteBean.cidadesAdicionadas;
		for (SelectItem selectItem : cidadesAdicionadas) {
			comboCidade.add(selectItem);
		}
	}
	
	public void adicionarClientesCadastrados() {
		List<ClienteWellingtonVO> clientesAdicionados = WellingtonTesteBean.clientesCadastrados;
		for (ClienteWellingtonVO selectItem : clientesAdicionados) {
			listaCadastramento.add(selectItem);
		}
	}

	public List<ClienteWellingtonVO> getListaClienteWellingtonVO() {
		return listaClienteWellingtonVO;
	}

	public void setListaClienteWellingtonVO(
			List<ClienteWellingtonVO> listaClienteWellingtonVO) {
		this.listaClienteWellingtonVO = listaClienteWellingtonVO;
	}

	public ClienteWellingtonVO getClienteWellingtonVO() {
		return clienteWellingtonVO;
	}

	public void setClienteWellingtonVO(ClienteWellingtonVO clienteWellingtonVO) {
		this.clienteWellingtonVO = clienteWellingtonVO;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<SelectItem> getComboCidades() {
		return siteUtil.pedroCarregarComboCidade();
	}

	public List<SelectItem> getComboEstados() {
		return siteUtil.pedroCarregarComboEstado();
	}

	public List<SelectItem> getComboEstado() {
		return comboEstado;
	}

	public void setComboEstado(List<SelectItem> comboEstado) {
		this.comboEstado = comboEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public List<ClienteWellingtonVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteWellingtonVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<ClienteWellingtonVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<ClienteWellingtonVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}

	public Boolean getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public Boolean getRenderModalCidade() {
		return renderModalCidade;
	}

	public void setRenderModalCidade(Boolean renderModalCidade) {
		this.renderModalCidade = renderModalCidade;
	}

	public Boolean getRenderModalEstado() {
		return renderModalEstado;
	}

	public void setRenderModalEstado(Boolean renderModalEstado) {
		this.renderModalEstado = renderModalEstado;
	}

	public String getEstadoAux() {
		return estadoAux;
	}

	public void setEstadoAux(String estadoAux) {
		this.estadoAux = estadoAux;
	}

	public String getUfAux() {
		return ufAux;
	}

	public void setUfAux(String ufAux) {
		this.ufAux = ufAux;
	}

	public List<SelectItem> getComboCidade() {
		return comboCidade;
	}

	public void setComboCidade(List<SelectItem> comboCidade) {
		this.comboCidade = comboCidade;
	}

	public String getCidadeAux() {
		return cidadeAux;
	}

	public void setCidadeAux(String cidadeAux) {
		this.cidadeAux = cidadeAux;
	}

	public Boolean getTabela() {
		return tabela;
	}

	public void setTabela(Boolean tabela) {
		this.tabela = tabela;
	}
	
	
}
