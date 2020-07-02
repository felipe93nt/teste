package br.com.bradesco.web.ricc.view.bean.treinamento.joaocarlos.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteJoaoCarlosVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.joaocarlos.viewhelper.JoaoCarlosTesteViewHelper;

/**
 * @name JoaoCarlosTesteBean
 * @author João Carlos - Foursys
 * @see JoaoCarlosTesteBean.java
 * @version 1.0
 * @since 18/05/2020
 */
@SessionScoped
@Named(value = "joaoCarlosTesteBean")
public class JoaoCarlosTesteBean extends
		AbstractBean<JoaoCarlosTesteViewHelper> {

	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	private String mensagemErro = "Favor preencher os campos: " + "<br> <br>";

	private ClienteJoaoCarlosVO vo;

	@Override
	public String iniciarPagina() {
		this.viewHelper = new JoaoCarlosTesteViewHelper(); 
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TESTE_JOAOCARLOS_CADASTRO;
	}

	public String salvar() {
		String retorno = "Cliente salvo com sucesso";
		if (validar()) {
			vo = new ClienteJoaoCarlosVO();
			vo.setNome(this.viewHelper.getNome());
			vo.setRg(this.viewHelper.getRg());
			vo.setCpf(this.viewHelper.getCpf());
			vo.setDataNascimento(this.viewHelper.getDataNascimento());
			vo.setSexo(this.viewHelper.getSexo());
			vo.setLogradouro(this.viewHelper.getLogradouro());
			vo.setNumeroLogradouro(this.viewHelper.getNumeroLogradouro());
			vo.setComplemento(this.viewHelper.getComplemento());
			vo.setBairro(this.viewHelper.getBairro());
			vo.setCidade(this.viewHelper.getCidade());
			vo.setEstado(this.viewHelper.getEstado());
			vo.setCep(this.viewHelper.getCep());
			vo.setTelefone(this.viewHelper.getTelefone());
			vo.setCelular(this.viewHelper.getCelular());
			vo.setEmail(this.viewHelper.getEmail());
			this.viewHelper.getListaClientes().add(vo);
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparDados();
			abrirTabela();
		}
		return null;
	}
	
	
	public String consultar(){
		ClienteJoaoCarlosVO itemSelecionado = getViewHelper().getItemSelecionado().get(0);
		
		if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
			vo.setNome(itemSelecionado.getNome());
			vo.setCpf(itemSelecionado.getCpf());
			vo.setRg(itemSelecionado.getRg());
			vo.setDataNascimento(itemSelecionado.getDataNascimento());
			vo.setSexo(itemSelecionado.getSexo());
			vo.setLogradouro(itemSelecionado.getLogradouro());
			vo.setNumeroLogradouro(itemSelecionado.getNumeroLogradouro());
			vo.setComplemento(itemSelecionado.getComplemento());
			vo.setBairro(itemSelecionado.getBairro());
			vo.setCep(itemSelecionado.getCep());
			vo.setCidade(itemSelecionado.getCidade());
			vo.setEstado(itemSelecionado.getEstado());
			vo.setTelefone(itemSelecionado.getTelefone());
			vo.setCelular(itemSelecionado.getCelular());
			vo.setEmail(itemSelecionado.getEmail());
			this.viewHelper.setVo(vo);
		} else {
			siteUtil.getMessages().getMsgSelecioneUmItemLista("label_cadastro");
		}
		
		return RiccConstants.TELA_TESTE_JOAOCARLOS_CONSULTA;
	}

	public boolean validar() {
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNome())) {
			mensagemErro += "- Nome" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			mensagemErro += "- CPF" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			mensagemErro += "- RG" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			mensagemErro += "- Data de nascimento" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getSexo())) {
			mensagemErro += "- Sexo" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			mensagemErro += " - Logradouro" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())) {
			mensagemErro += "- Número" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			mensagemErro += "- Bairro" + "<br> <br>";
		}
		if (this.viewHelper.getCidade().equals("Selecione a cidade")) {
			mensagemErro += "- Cidade" + "<br> <br>";
		}
		if (this.viewHelper.getEstado().equals("Selecione o Estado")) {
			mensagemErro += " - Estado" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			mensagemErro += " - CEP" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			mensagemErro += "- Telefone" + "<br> <br>";
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			mensagemErro += "- Celular" + "<br> <br>";
		}

		if (!mensagemErro.equals("Favor preencher os campos: <br> <br>")) {
			BradescoFacesUtils.addInfoModalMessage(mensagemErro, Boolean.FALSE);
			mensagemErro = "Favor preencher os campos: " + "<br> <br>";
			return false;
		}

		return true;
	}

	public void limparDados() {
		this.viewHelper.setNome(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setTelefone(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setEmail(null);
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
	}
	

	public void abrirModalCidade() {
		viewHelper.setRenderModalCidade(Boolean.TRUE);
	}

	public void fecharModalCidade() {
		viewHelper.setRenderModalCidade(Boolean.FALSE);
	}

	public void abrirModalEstado() {
		viewHelper.setRenderModalEstado(Boolean.TRUE);
	}

	public void fecharModalEstado() {
		viewHelper.setRenderModalEstado(Boolean.FALSE);
	}

	public void abrirTabela(){
		viewHelper.setRenderTabelaCliente(Boolean.TRUE);
	}
	
	public void incluirCidade() {
			if (validarCampoModalCidade()) {
				this.viewHelper.getComboCidade().add(new SelectItem(this.viewHelper.getNovaCidade()));
				this.viewHelper.setNovaCidade(null);
				BradescoFacesUtils.addInfoModalMessage("Cidade cadastrada com êxito", Boolean.FALSE);
				fecharModalCidade();
		}
	}
	
	public void incluirEstado() {
		if (validarCampoModalEstado()) {
			this.viewHelper.getComboEstado().add(new SelectItem(this.viewHelper.getNovoEstado()));
			this.viewHelper.setNovoEstado(null);
			BradescoFacesUtils.addInfoModalMessage("Estado cadastrado com êxito", Boolean.FALSE);
			fecharModalEstado();
		}
	}
	
	public boolean validarCampoModalCidade(){
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNovaCidade())) {
			BradescoFacesUtils.addInfoModalMessage("Preencha o campo cidade", Boolean.FALSE);
			return false;
		}
		return true;
	}
	
	public boolean validarCampoModalEstado(){
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNovoEstado())) {
			BradescoFacesUtils.addInfoModalMessage("Preencha o campo estado", Boolean.FALSE);
			return false;
		}
		return true;
	}
	
	public String voltar() {
		return paginaAnterior;
	}
	
	public String voltarConsulta(){
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		return RiccConstants.TELA_TESTE_JOAOCARLOS_CADASTRO;
	}
	
	public void habilitarBotaoConsultar(AjaxBehaviorEvent ae){
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		
		if (!this.viewHelper.getItemSelecionado().isEmpty()){
			this.viewHelper.setBtnConsultar(Boolean.TRUE);
		}
		
	}
}
