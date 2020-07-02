package br.com.bradesco.web.ricc.view.bean.treinamento.enzo.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.ClienteClaudioVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class EnzoTesteViewHelper extends AbstractViewHelper {
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
	
	
	
	
	private List<ClienteClaudioVO> itemSelecionado = new ArrayList<ClienteClaudioVO>();
	
	public List<ClienteClaudioVO> getItemSelecionado() {
		return itemSelecionado;
	}
	
	
	
	private List<ClienteClaudioVO> listaCadastramento = null;
	
	public List<ClienteClaudioVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<ClienteClaudioVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}
	private Boolean renderModal = Boolean.FALSE;
	
	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	private TipoQuestionarioVO segmentoSelecionado = null;
	
	public TipoQuestionarioVO getSegmentoSelecionado() {
		return segmentoSelecionado;
	}

	public void setSegmentoSelecionado(TipoQuestionarioVO segmentoSelecionado) {
		this.segmentoSelecionado = segmentoSelecionado;
	}

	private List<TipoQuestionarioVO> listaSegmento = null;
	
	public List<TipoQuestionarioVO> getListaSegmento() {
		return listaSegmento;
	}

	public void setListaSegmento(List<TipoQuestionarioVO> listaSegmento) {
		this.listaSegmento = listaSegmento;
	}

	private List<TipoQuestionarioVO> listaSetorSelecionado = null;
	
	public List<TipoQuestionarioVO> getListaSetorSelecionado() {
		return listaSetorSelecionado;
	}

	public void setListaSetorSelecionado(
			List<TipoQuestionarioVO> listaSetorSelecionado) {
		this.listaSetorSelecionado = listaSetorSelecionado;
	}
	private List<TipoQuestionarioVO> listaSetor = null;
	
	
	public List<TipoQuestionarioVO> getListaSetor() {
		return listaSetor;
	}

	public void setListaSetor(List<TipoQuestionarioVO> listaSetor) {
		this.listaSetor = listaSetor;
	}

	public void setItemSelecionado(List<ClienteClaudioVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
	
	
	
	
	
	@Override
	public void inicializar() {
		listaCheckbox = carregarListaCheckbox();
		capturarUsuario();
		
		listaCadastramento = new ArrayList<ClienteClaudioVO>();
		segmentoSelecionado = new TipoQuestionarioVO();
		listaSetorSelecionado = new ArrayList<TipoQuestionarioVO>();
		listaSegmento = siteUtil.carregarListaSegmento();
		listaSetor = siteUtil.carregarListaSetor();
		renderModal = Boolean.FALSE;
	}
	
	public void capturarUsuario(){
		this.exemploOutputText = "Exemplo de informa��o em OutputText!";
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
		vo.setNome("oi");
		vo.setCpf("426.895.358-23");
		vo.setRg("50.826.498-4");
		vo.setDataNascimento("05/11/2000");
		vo.setSexo("Masculino");
		vo.setLogradouro("L");
		vo.setNumero("123");
		vo.setComplemento("asd");
		vo.setBairro("a");
		vo.setEstado("ad");
		vo.setCidade("adx");
		vo.setCep("05563000");
		vo.setTelefone("(11)37818242");
		vo.setCelular("(11)951546098");
		vo.setEmail("E@E.com");
		
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