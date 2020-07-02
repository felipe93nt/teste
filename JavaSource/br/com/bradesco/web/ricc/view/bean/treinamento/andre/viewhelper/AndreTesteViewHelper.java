package br.com.bradesco.web.ricc.view.bean.treinamento.andre.viewhelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteIsaacVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class AndreTesteViewHelper extends AbstractViewHelper {

	private static final long serialVersionUID = -585425884804023578L;
	private String nomeCompleto;
	private String cpf;
	private String rg;
	private Date dataNascimento = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private String dataFormatada = dateFormat.format(dataNascimento);
	private String sexo;
	private String logradouro;
	private String numeroLogradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String celular;
	private String email;
	private String addCidade;
	private String addEstado;
	public List<SelectItem> comboCidade;
	public List<SelectItem> comboEstado;

	ClienteIsaacVO clienteSelecionado;
	List<ClienteIsaacVO> cadastroSelecionado;
	private ClienteIsaacVO clienteVO = new ClienteIsaacVO();
	List<ClienteIsaacVO> listaClientes;

	@Override
	public void inicializar() {
		listaClientes = new ArrayList<ClienteIsaacVO>();
		getComboCidade();
		getComboEstado();
		// DadosConsulta();
	}
	
	
	public List<SelectItem> getComboCidade() {
		
		if (siteUtil.isNotEmptyOrNull(addCidade)) {
			List<SelectItem> comboCidade = siteUtil.carregarComboCidadeAndre();
		comboCidade.add(new SelectItem(addCidade));
			
		   return comboCidade;
		}
		return comboCidade;
	}
	
	public List<SelectItem> getComboEstado() {
		if (siteUtil.isNotEmptyOrNull(addEstado)) {
			List<SelectItem> comboEstado = siteUtil.carregarComboEstadoAndre();
		comboEstado.add(new SelectItem(addEstado));
			
		   return comboEstado;
		}
		return comboEstado;
	}


	public ClienteIsaacVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteIsaacVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public List<ClienteIsaacVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteIsaacVO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<SelectItem> getAndreComboTreinamentoCidade() {
		return siteUtil.carregarComboCidadeAndre();

	}

	public List<SelectItem> getAndreComboTreinamentoEstado() {
		return siteUtil.carregarComboEstadoAndre();
	}

	public List<ClienteIsaacVO> getCadastroSelecionado() {
		return cadastroSelecionado;
	}

	public void setCadastroSelecionado(List<ClienteIsaacVO> cadastroSelecionado) {
		this.cadastroSelecionado = cadastroSelecionado;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
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

	public ClienteIsaacVO getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(ClienteIsaacVO clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public String getAddCidade() {
		return addCidade;
	}

	public void setAddCidade(String addCidade) {
		this.addCidade = addCidade;
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

	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}
	
	public String getAddEstado() {
		return addEstado;
	}

	public void setAddEstado(String addEstado) {
		this.addEstado = addEstado;
	}



	public void DadosConsulta() {

		ClienteIsaacVO itemSelecionado = getListaClientes().get(0);

		clienteSelecionado = new ClienteIsaacVO();
		clienteSelecionado.setNomeCompleto(itemSelecionado.getNomeCompleto());
		clienteSelecionado.setCpf(itemSelecionado.getCpf());
		clienteSelecionado.setRg(itemSelecionado.getRg());
		clienteSelecionado.setDataNascimento(itemSelecionado
				.getDataNascimento());
		clienteSelecionado.setSexo(itemSelecionado.getSexo());
		clienteSelecionado.setLogradouro(itemSelecionado.getLogradouro());
		clienteSelecionado.setNumeroLogradouro(itemSelecionado
				.getNumeroLogradouro());
		clienteSelecionado.setComplemento(itemSelecionado.getComplemento());
		clienteSelecionado.setBairro(itemSelecionado.getBairro());
		clienteSelecionado.setCidade(itemSelecionado.getCidade());
		clienteSelecionado.setEstado(itemSelecionado.getEstado());
		clienteSelecionado.setCep(itemSelecionado.getCep());
		clienteSelecionado.setTelefone(itemSelecionado.getTelefone());
		clienteSelecionado.setCelular(itemSelecionado.getCelular());
		clienteSelecionado.setEmail(itemSelecionado.getEmail());
	}

}
