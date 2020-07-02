/**
 * 
 */
package br.com.bradesco.web.ricc.view.bean.treinamento.anderson.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ClienteAndersonVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

/**
 * @author amendes
 *
 */
public class AndersonTesteCadastroViewhelper extends AbstractViewHelper {
	private static final long serialVersionUID = -111683580430422356L;

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
	private String NomeCidade;
	private List<SelectItem> addCidades;
	private List<SelectItem> addEstados;
	private String estado;
	private String nomeEstado;
	private String cep;

	private String telefone;
	private String celular;
	private String email;
	private ClienteAndersonVO andersonClienteVO = new ClienteAndersonVO();
	private boolean renderizarTabela;
	private boolean btnConsultar;
	private boolean showModal;
	/**
	 * Atributo listaCadastramento Tipo List<ClienteAndersonVO>
	 */
	private List<ClienteAndersonVO> listaCadastramento = new ArrayList<ClienteAndersonVO>();
	/**
	 * Atributo itemSelecionado Tipo List<ClienteAndersonVO>
	 */
	private List<ClienteAndersonVO> itemSelecionado = new ArrayList<ClienteAndersonVO>();

	private List<ClienteAndersonVO> cadastros = new ArrayList<ClienteAndersonVO>();

	public List<ClienteAndersonVO> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<ClienteAndersonVO> cadastros) {
		this.cadastros = cadastros;
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

	public ClienteAndersonVO getAndersonClienteVO() {
		return andersonClienteVO;
	}

	public void setAndersonClienteVO(ClienteAndersonVO andersonClienteVO) {
		this.andersonClienteVO = andersonClienteVO;
	}

	public List<SelectItem> getComboCidade() {
		return getAddCidades();
	}

	public List<SelectItem> getComboEstado() {
		return getAddEstados();
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

	public List<ClienteAndersonVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<ClienteAndersonVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}

	public List<ClienteAndersonVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ClienteAndersonVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public boolean isRenderizarTabela() {
		return renderizarTabela;
	}

	public void setRenderizarTabela(boolean renderizarTabela) {
		this.renderizarTabela = renderizarTabela;
	}

	public boolean isBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public List<SelectItem> getAddCidades() {
		return addCidades;
	}

	public void setAddCidades(List<SelectItem> addcidades) {
		this.addCidades = addcidades;
	}

	public List<SelectItem> getAddEstados() {
		return addEstados;
	}

	public void setAddEstados(List<SelectItem> addEstados) {
		this.addEstados = addEstados;
	}

	public String getNomeCidade() {
		return NomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		NomeCidade = nomeCidade;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}	

	public boolean isShowModal() {
		return showModal;
	}

	public void setShowModal(boolean showModal) {
		this.showModal = showModal;
	}

	public void carregarConsulta() {
		// andersonClienteVO = itemSelecionado.get(0);
		try {

			andersonClienteVO.setNome(itemSelecionado.get(0).getNome());
			andersonClienteVO.setCpf(itemSelecionado.get(0).getCpf());
			andersonClienteVO.setRg(itemSelecionado.get(0).getRg());
			andersonClienteVO.setDataNascimento(itemSelecionado.get(0)
					.getDataNascimento());
			andersonClienteVO.setSexo(itemSelecionado.get(0).getSexo());
			andersonClienteVO.setLogradouro(itemSelecionado.get(0)
					.getLogradouro());
			andersonClienteVO.setNumero(itemSelecionado.get(0).getNumero());
			andersonClienteVO.setComplemento(itemSelecionado.get(0)
					.getComplemento());
			andersonClienteVO.setBairro(itemSelecionado.get(0).getBairro());
			andersonClienteVO.setCidade(itemSelecionado.get(0).getCidade());
			andersonClienteVO.setEstado(itemSelecionado.get(0).getEstado());
			andersonClienteVO.setCep(itemSelecionado.get(0).getCep());
			andersonClienteVO.setTelefone(itemSelecionado.get(0).getTelefone());
			andersonClienteVO.setCelular(itemSelecionado.get(0).getCelular());
			andersonClienteVO.setEmail(itemSelecionado.get(0).getEmail());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*
		 * andersonClienteVO.setNome("Anderson Mendes de Souza");
		 * andersonClienteVO.setCpf("447.837.828-22");
		 * andersonClienteVO.setRg("46.490.397-X");
		 * andersonClienteVO.setDataNascimento("02/06/1995");
		 * andersonClienteVO.setSexo("Masculino");
		 * andersonClienteVO.setLogradouro("Rua Prof Queiros Filho");
		 * andersonClienteVO.setNumero("392");
		 * andersonClienteVO.setComplemento("ap. 72");
		 * andersonClienteVO.setBairro("Jd silveira");
		 * andersonClienteVO.setCidade("Barueri");
		 * andersonClienteVO.setEstado("São Paulo");
		 * andersonClienteVO.setCep("06434-080");
		 * andersonClienteVO.setTelefone("(11); 8364-6699");
		 * andersonClienteVO.setCelular("(11)98364-6699");
		 * andersonClienteVO.setEmail("anderson.mendes@foursys.com.br");
		 */
	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		try {
			this.showModal = Boolean.FALSE;
			this.addEstados = siteUtil.carregarAndersonEstados();
			this.addCidades = siteUtil.carregarAndersonCidades();
			renderizarTabela = Boolean.FALSE;
			btnConsultar = Boolean.FALSE;
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	public void limpar() {

		nome = null;
		cpf = null;
		rg = null;
		dataNascimento = null;
		sexo = null;

		logradouro = null;
		numero = null;
		complemento = null;
		bairro = null;
		cidade = null;

		estado = null;
		cep = null;

		telefone = null;
		celular = null;
		email = null;

	}

}
