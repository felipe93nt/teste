package br.com.bradesco.web.ricc.view.bean.treinamento.guilherme.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteGuilhermeVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class GuilhermeTesteViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private String atencao;
	private String nome;
	private String cpf;
	private String rg;
	private String data;
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

	private List<ClienteGuilhermeVO> listaClientes = new ArrayList<ClienteGuilhermeVO>();

	private List<SelectItem> listaCidade = new ArrayList<SelectItem>();
	private List<SelectItem> listaEstado = new ArrayList<SelectItem>();
	private String cidadeInserida;
	private String estadoInserido;

	private Boolean renderModal = false;

	private ClienteGuilhermeVO clienteVO = new ClienteGuilhermeVO();;
	private List<ClienteGuilhermeVO> clienteSelecionado = new ArrayList<ClienteGuilhermeVO>();

	private String paginaAnteriorConsulta = RiccConstants.TELA_GUILHERME_TESTE_CADASTRO;

	@Override
	public void inicializar() {
		capturarUsuario();
	}

	public String inicializarConsulta() {
		if (clienteSelecionado.isEmpty()) {
			String retorno = "Selecione um cliente para consultar";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			return RiccConstants.TELA_GUILHERME_TESTE_CADASTRO;
		} else {
			consultarCliente();
			return RiccConstants.TELA_GUILHERME_TESTE_CONSULTA;
		}

	}

	public void capturarUsuario() {
		this.atencao = "Preencha todos os campos abaixo!";
	}

	public String getAtencao() {
		return atencao;
	}

	public void setAtencao(String atencao) {
		this.atencao = atencao;
	}

	public ClienteGuilhermeVO getGuilhermeVO() {
		return clienteVO;
	}

	public void setGuilhermeVO(ClienteGuilhermeVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public ClienteGuilhermeVO consultarCliente() {

		this.clienteVO = clienteSelecionado.get(0);

		return this.clienteVO;

	}

	public List<SelectItem> getComboCidade() {

		for (SelectItem selectItem : listaCidade) {
			if (selectItem.getLabel().equals(cidadeInserida)) {
				return listaCidade;
			}
		}

		if (!siteUtil.isEmptyOrNull(cidadeInserida)) {
			listaCidade.add(new SelectItem(cidadeInserida));
			return listaCidade;
		} else if (siteUtil.isEmptyOrNull(cidadeInserida)
				&& listaCidade.size() > 10) {
			return listaCidade;
		} else {
			listaCidade.clear();
			return carregarComboCidadesGuilherme();

		}
	}

	public List<SelectItem> getComboEstado() {
		for (SelectItem selectItem : listaEstado) {
			if (selectItem.getLabel().equals(estadoInserido)) {
				return listaEstado;
			}
		}

		if (!siteUtil.isEmptyOrNull(estadoInserido)) {
			listaEstado.add(new SelectItem(estadoInserido));
			return listaEstado;
		} else if (siteUtil.isEmptyOrNull(estadoInserido)
				&& listaEstado.size() > 5) {
			return listaEstado;
		} else {
			listaEstado.clear();
			return carregarComboEstadosGuilherme();

		}

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<ClienteGuilhermeVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteGuilhermeVO> listaClientes) {
		this.listaClientes = listaClientes;
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

	public String getCidadeInserida() {
		return cidadeInserida;
	}

	public void setCidadeInserida(String cidadeInserida) {
		this.cidadeInserida = cidadeInserida;
	}

	public String getEstadoInserido() {
		return estadoInserido;
	}

	public void setEstadoInserido(String estadoInserido) {
		this.estadoInserido = estadoInserido;
	}

	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	public List<ClienteGuilhermeVO> getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(
			List<ClienteGuilhermeVO> clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public ClienteGuilhermeVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteGuilhermeVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public void geraCliente() {

		ClienteGuilhermeVO clienteNovo = new ClienteGuilhermeVO();
		clienteNovo.setNome(nome);
		clienteNovo.setDataNascimento(data);
		clienteNovo.setRg(rg);
		clienteNovo.setCpf(cpf);
		clienteNovo.setSexo(sexo);
		clienteNovo.setLogradouro(logradouro);
		clienteNovo.setNumeroLogradouro(numero + "");
		clienteNovo.setComplemento(complemento);
		clienteNovo.setBairro(bairro);
		clienteNovo.setCidade(cidade);
		clienteNovo.setEstado(estado);
		clienteNovo.setCep(cep);
		clienteNovo.setTelefone(telefone);
		clienteNovo.setCelular(celular);
		clienteNovo.setEmail(email);

		carregarTabela(clienteNovo);

	}

	public List<ClienteGuilhermeVO> carregarTabela(ClienteGuilhermeVO cliente) {

		listaClientes.add(cliente);

		return listaClientes;
	}

	public List<SelectItem> carregarComboCidadesGuilherme() {
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_1, "Cotia"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_2, "Osasco"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_3,
				"Pelourinho"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_4,
				"Belo Horizonte"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_5, "Palmas"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_6, "Macaé"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_7,
				"Rio Negrinho"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_8, "Jandira"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_9, "Mauá"));
		listaCidade.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_CIDADE_10,
				"Passa Quatro"));

		return listaCidade;
	}

	public List<SelectItem> carregarComboEstadosGuilherme() {
		listaEstado
				.add(new SelectItem(
						RiccConstants.TREINAMENTO_GUILHERME_TESTE_ESTADO_1,
						"São Paulo"));
		listaEstado.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_ESTADO_2,
				"Rio de Janeiro"));
		listaEstado.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_ESTADO_3,
				"Minas Gerais"));
		listaEstado
				.add(new SelectItem(
						RiccConstants.TREINAMENTO_GUILHERME_TESTE_ESTADO_4,
						"Tocantins"));
		listaEstado.add(new SelectItem(
				RiccConstants.TREINAMENTO_GUILHERME_TESTE_ESTADO_5,
				"Santa Catarina"));

		return listaEstado;
	}

	public String voltarConsulta() {
		return paginaAnteriorConsulta;
	}
}
