package br.com.bradesco.web.ricc.view.bean.treinamento.isaac.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteIsaacVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.SiteUtil;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.isaac.viewhelper.IsaacTesteViewHelper;

/**
 * @name isaacTesteBean
 * @author Isaac Batista - Foursys
 * @see IsaacTesteBean.java
 * @version 1.0
 * @since 04/05/2020
 */
@SessionScoped
@Named(value = "isaacTesteBean")
public class IsaacTesteBean extends AbstractBean<IsaacTesteViewHelper> {

	private static final long serialVersionUID = -6473037990504221688L;
	private String paginaAnterior = "nav_index";
	protected SiteUtil siteUtil = SiteUtil.getInstance();
	private String mensagemErro = "Favor preencher os campos: " + "<br> <br>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */

	@Override
	public String iniciarPagina() {
		this.viewHelper = new IsaacTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ISAAC_TESTE;
	}

	public String iniciarPaginaConsulta() {
		this.viewHelper = new IsaacTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ISAAC_TESTE_CONSULTA;
	}

	/**
	 * @description
	 * @name salvar
	 * @see IsaacTesteBean
	 * @return
	 * @return String
	 */
	String vazio = null;

	private ClienteIsaacVO clienteVO;

	public static String formataData(Date data) {

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(data);
		return dataFormatada;

	}

	public String salvar() {
		if (validarCamposObrigatorios()) {

			clienteVO = new ClienteIsaacVO();
			List<ClienteIsaacVO> listarCliente = viewHelper.getListarCliente();

			clienteVO.setBairro(viewHelper.getBairro());
			clienteVO.setCelular(viewHelper.getCelular());
			clienteVO.setCep(viewHelper.getCep());
			clienteVO.setCidade(viewHelper.getCidade());
			clienteVO.setComplemento(viewHelper.getComplemento());
			clienteVO.setCpf(viewHelper.getCpf());
			clienteVO.setDataNascimento(formataData(viewHelper
					.getDataNascimento()));
			clienteVO.setEmail(viewHelper.getEmail());
			clienteVO.setEstado(viewHelper.getEstado());
			clienteVO.setLogradouro(viewHelper.getLogradouro());
			clienteVO.setNomeCompleto(viewHelper.getNomeCompleto());
			clienteVO.setNumeroLogradouro(viewHelper.getNumeroLogradouro());
			clienteVO.setRg(viewHelper.getRg());
			clienteVO.setSexo(viewHelper.getSexo().toString());
			clienteVO.setTelefone(viewHelper.getTelefone());

			listarCliente.add(clienteVO);
			viewHelper.setListarCliente(listarCliente);

			String retorno = "Cliente salvo com sucesso!";
			limparCamposCadastro();
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		}
		return null;
	}

	public String voltar() {
		return paginaAnterior;
	}

	private void limparCamposCadastro() {
		this.viewHelper.setNomeCompleto(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setEmail(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setTelefone(null);
	}

	public boolean validarCamposObrigatorios() {

		boolean retorno = true;
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNomeCompleto())) {
			String mensagem = "Informe Nome";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			String mensagem = "Informe CPF";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			String mensagem = "Informe RG";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			String mensagem = "Informe Data Nascimento";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getSexo())) {
			String mensagem = "Informe Sexo";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			String mensagem = "Informe Logradouro";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())) {
			String mensagem = "Informe Numero";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			String mensagem = "Informe Bairro";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (this.viewHelper.getCidade().equals(
				RiccConstants.TREINAMENTO_ISAAC_CIDADE)) {
			String mensagem = "Informe Cidade";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (this.viewHelper.getEstado().equals(
				RiccConstants.TREINAMENTO_ISAAC_ESTADO)) {
			String mensagem = "Informe Estado";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			String mensagem = "Informe CEP";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			String mensagem = "Informe Telefone";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			String mensagem = "Informe Celular";
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			retorno = false;
		}

		return retorno;

	}

	public String telaConsulta() {
		ClienteIsaacVO itemSelecionado = getViewHelper().getItemSelecionado()
				.get(0);

		viewHelper.getClienteVO().setBairro(itemSelecionado.getBairro());
		viewHelper.getClienteVO().setCelular(itemSelecionado.getCelular());
		viewHelper.getClienteVO().setCep(itemSelecionado.getCep());
		viewHelper.getClienteVO().setCidade(itemSelecionado.getCidade());
		viewHelper.getClienteVO().setComplemento(
				itemSelecionado.getComplemento());
		viewHelper.getClienteVO().setCpf(itemSelecionado.getCpf());
		viewHelper.getClienteVO().setDataNascimento(
				itemSelecionado.getDataNascimento());
		viewHelper.getClienteVO().setEmail(itemSelecionado.getEmail());
		viewHelper.getClienteVO().setEstado(itemSelecionado.getEstado());
		viewHelper.getClienteVO()
				.setLogradouro(itemSelecionado.getLogradouro());
		viewHelper.getClienteVO().setNomeCompleto(
				itemSelecionado.getNomeCompleto());
		viewHelper.getClienteVO().setNumeroLogradouro(
				itemSelecionado.getNumeroLogradouro());
		viewHelper.getClienteVO().setRg(itemSelecionado.getRg());
		viewHelper.getClienteVO().setSexo(itemSelecionado.getSexo().toString());
		viewHelper.getClienteVO().setTelefone(itemSelecionado.getTelefone());

		return RiccConstants.TELA_TREINAMENTO_ISAAC_TESTE_CONSULTA;
	}

	// public void habilitarBotoes(AjaxBehaviorEvent ae) {
	// ClienteIsaacVO cadastro = null;
	// String usuarioLogado = null;
	// this.viewHelper.setBtnConsultar(Boolean.FALSE);
	// if (!this.viewHelper.getItemitemSelecionado().isEmpty()) {
	//
	// cadastro = this.viewHelper.getItemitemSelecionado().get(Numeros.ZERO);
	// usuarioLogado = BradescoCommonServiceFactory.getSecurityManager()
	// .getUserId().trim().toUpperCase();
	//
	// this.viewHelper.setBtnConsultar(Boolean.TRUE);
	//
	// }
	//
	// }

	public void abrirModalIncluir() {
		viewHelper.setRenderModalIncluir(Boolean.TRUE);
	}

	public void fecharModal() {
		viewHelper.setRenderModal(Boolean.FALSE);
	}

	public void fecharModalIncluir() {
		viewHelper.setRenderModalIncluir(Boolean.FALSE);
	}

	public void abrirModal() {
		viewHelper.setRenderModal(Boolean.TRUE);
	}

	public String adicionar() {
		List<SelectItem> lista = viewHelper.getCarregarComboCidade();
		lista.add(new SelectItem(viewHelper.getCidade()));
		viewHelper.setCarregarComboCidade(lista);

		return "lista";
	}

}
