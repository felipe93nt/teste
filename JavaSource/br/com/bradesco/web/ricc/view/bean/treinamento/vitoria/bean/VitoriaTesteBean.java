package br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.bean;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteVitoriaVO;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.RiccMessages;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.viewhelper.VitoriaTesteViewHelper;

/**
 * @name VitoriaTesteBean
 * @author Vitoria Teofilo - Foursys
 * @see VitoriaTesteBean.java
 * @version 1.0
 * @since 06/05/2020
 */
@SessionScoped
@Named(value = "vitoriaTesteBean")
public class VitoriaTesteBean extends AbstractBean<VitoriaTesteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";
	private ClienteVitoriaVO clienteVO = new ClienteVitoriaVO();
	
	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new VitoriaTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_VITORIA_TESTE_CADASTRO;
	}

	public String iniciarPaginaConsulta() {
		this.viewHelper = new VitoriaTesteViewHelper();
		this.viewHelper.inicializar();

		return RiccConstants.TELA_TREINAMENTO_VITORIA_TESTE_CONSULTA;
	}

	/**
	 * @description
	 * @name salvar
	 * @see VitoriaTesteBean
	 * @return String
	 */
	public String salvar() {
		if (validarCamposCliente()) {
			clienteVO = new ClienteVitoriaVO();

			List<ClienteVitoriaVO> listaCadastramento = viewHelper
					.getListaCadastramento();
			clienteVO.setNome(viewHelper.getNome());
			clienteVO.setCpf(viewHelper.getCpf());
			clienteVO.setRg(viewHelper.getRg());
			clienteVO.setDataNascimento(viewHelper.getDataNascimento());
			clienteVO.setSexo(viewHelper.getSexo());
			clienteVO.setLogradouro(viewHelper.getLogradouro());
			clienteVO.setNumeroLogradouro(viewHelper.getNumeroLogradouro());
			clienteVO.setComplemento(viewHelper.getComplemento());
			clienteVO.setBairro(viewHelper.getBairro());
			clienteVO.setCidade(viewHelper.getCidade());
			clienteVO.setEstado(viewHelper.getEstado());
			clienteVO.setCep(viewHelper.getCep());
			clienteVO.setTelefone(viewHelper.getTelefone());
			clienteVO.setCelular(viewHelper.getCelular());
			clienteVO.setEmail(viewHelper.getEmail());
			listaCadastramento.add(clienteVO);
			viewHelper.setListaCadastramento(listaCadastramento);

			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
			viewHelper.setHabilitarTabela(Boolean.TRUE);

		}
		return null;
	}

	public String consultar() {
		
		ClienteVitoriaVO itemSelecionado = getViewHelper().getItemSelecionado()
				.get(0);
		
		this.viewHelper.getClienteVO().setNome(itemSelecionado.getNome());
		this.viewHelper.getClienteVO().setCpf(itemSelecionado.getCpf());
		this.viewHelper.getClienteVO().setRg(itemSelecionado.getRg());
		this.viewHelper.getClienteVO().setDataNascimento(itemSelecionado.getDataNascimento());
		this.viewHelper.getClienteVO().setSexo(itemSelecionado.getSexo());
		this.viewHelper.getClienteVO().setLogradouro(itemSelecionado.getLogradouro());
		this.viewHelper.getClienteVO().setNumeroLogradouro(itemSelecionado.getNumeroLogradouro());
		this.viewHelper.getClienteVO().setComplemento(itemSelecionado.getComplemento());
		this.viewHelper.getClienteVO().setBairro(itemSelecionado.getBairro());
		this.viewHelper.getClienteVO().setCidade(itemSelecionado.getCidade());
		this.viewHelper.getClienteVO().setEstado(itemSelecionado.getEstado());
		this.viewHelper.getClienteVO().setCep(itemSelecionado.getCep());
		this.viewHelper.getClienteVO().setTelefone(itemSelecionado.getTelefone());
		this.viewHelper.getClienteVO().setCelular(itemSelecionado.getCelular());
		this.viewHelper.getClienteVO().setEmail(itemSelecionado.getEmail());
		
			
		
		return RiccConstants.TELA_TREINAMENTO_VITORIA_TESTE_CONSULTA;
	}

	

	/**
	 * @description Método para limpar todos os campos da tela de cadastro de
	 *              cliente
	 * @name validarCamposPesquisa
	 * @see VitoriaTesteBean
	 * @return void
	 */
	public void limparCampos() {
		VitoriaTesteViewHelper model = this.viewHelper;
		model.setNome(VAZIO);
		model.setCpf(VAZIO);
		model.setRg(VAZIO);
		model.setDataNascimento(VAZIO);
		model.setSexo(VAZIO);
		model.setLogradouro(VAZIO);
		model.setNumeroLogradouro(VAZIO);
		model.setComplemento(VAZIO);
		model.setBairro(VAZIO);
		model.setCidade(VAZIO);
		model.setEstado(VAZIO);
		model.setCep(VAZIO);
		model.setTelefone(VAZIO);
		model.setCelular(VAZIO);
		model.setEmail(VAZIO);
	}
	

	/**
	 * @description Método para validar os campos da tela de cadastro de cliente
	 *              antes de salvar
	 * @name validarCamposCliente
	 * @see VitoriaTesteBean
	 * @return boolean
	 */
	public boolean validarCamposCliente() {
		VitoriaTesteViewHelper model = this.viewHelper;

		String camposNaoPreenchidos = "";
		String msg_treinamento_pedro_campos_obrigatorios = "Os seguintes campos são obrigatórios:";

		if (siteUtil.isEmptyOrNull(model.getNome())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Nome,";
		}
		if (siteUtil.isEmptyOrNull(model.getCpf())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - CPF,";
		}
		if (siteUtil.isEmptyOrNull(model.getRg())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - RG,";
		}
		if (siteUtil.isEmptyOrNull(model.getDataNascimento())) {
			camposNaoPreenchidos = camposNaoPreenchidos
					+ " - Data de nascimento,";
		}
		if (siteUtil.isEmptyOrNull(model.getSexo())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Sexo,";
		}
		if (siteUtil.isEmptyOrNull(model.getLogradouro())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Logradouro,";
		}
		if (siteUtil.isEmptyOrNull(model.getNumeroLogradouro())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Número,";
		}
		if (siteUtil.isEmptyOrNull(model.getBairro())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Bairro,";
		}
		if (siteUtil.isEmptyOrNull(model.getCidade())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Cidade,";
		}
		if (siteUtil.isEmptyOrNull(model.getEstado())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Estado,";
		}
		if (siteUtil.isEmptyOrNull(model.getCep())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - CEP,";
		}
		if (siteUtil.isEmptyOrNull(model.getTelefone())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Telefone,";
		}
		if (siteUtil.isEmptyOrNull(model.getCelular())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Celular,";
		} 
		if (siteUtil.isNotEmptyOrNull(camposNaoPreenchidos)) {
			BradescoFacesUtils.addInfoModalMessage(
					msg_treinamento_pedro_campos_obrigatorios, false);
			String camposNaoPreenchidosArray[] = camposNaoPreenchidos
					.split(",");
			for (int i = 0; i < camposNaoPreenchidosArray.length; i++) {
				BradescoFacesUtils.addInfoModalMessage(
						camposNaoPreenchidosArray[i], false);
			}
			return false;
		} else {
			return true;
		}

	}

	

	public String incluirCidade() {

		if (validarIncluirCidade()) {
			VitoriaTesteViewHelper cidade = new VitoriaTesteViewHelper();
			List<SelectItem> listaCidades = viewHelper.getComboCidade();
			listaCidades.add(new SelectItem(viewHelper.getCidade()));

			cidade.setComboCidade(listaCidades);

			fecharModal();

			RiccMessages.getInstance().getMsgInclusaoSucesso();

		}
		limparCampoCidade();
		return "listaCidades";
	}

	public void limparCampoCidade() {
		VitoriaTesteViewHelper model = this.viewHelper;
		model.setCidade(VAZIO);
	}

	public boolean validarIncluirCidade() {
		VitoriaTesteViewHelper model = this.viewHelper;
		String camposNaoPreenchidos = "";
		String msg_treinamento_pedro_campos_obrigatorios = "Informe, campo obrigatório!";

		if (siteUtil.isEmptyOrNull(model.getCidade())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Cidade,";
		}
		if (siteUtil.isNotEmptyOrNull(camposNaoPreenchidos)) {
			BradescoFacesUtils.addInfoModalMessage(
					msg_treinamento_pedro_campos_obrigatorios, false);
			String camposNaoPreenchidosArray[] = camposNaoPreenchidos
					.split(",");
			for (int i = 0; i < camposNaoPreenchidosArray.length; i++) {
				BradescoFacesUtils.addInfoModalMessage(
						camposNaoPreenchidosArray[i], false);
			}
			return false;
		} else {
			return true;
		}
	}

	public String incluirEstado() {
		if (validarIncluirEstado()) {
			VitoriaTesteViewHelper estado = new VitoriaTesteViewHelper();
			List<SelectItem> listaEstados = viewHelper.getComboEstado();
			listaEstados.add(new SelectItem(viewHelper.getEstado()));

			estado.setComboCidade(listaEstados);

			fecharModalEstado();

			RiccMessages.getInstance().getMsgInclusaoSucesso();
		}
		limparCampoEstado();
		return "listaEstados";
	}

	public boolean validarIncluirEstado() {
		VitoriaTesteViewHelper model = this.viewHelper;
		String camposNaoPreenchidos = "";
		String msg_treinamento_pedro_campos_obrigatorios = "Informe, campo obrigatório!";

		if (siteUtil.isEmptyOrNull(model.getEstado())) {
			camposNaoPreenchidos = camposNaoPreenchidos + " - Estado,";
		}
		if (siteUtil.isNotEmptyOrNull(camposNaoPreenchidos)) {
			BradescoFacesUtils.addInfoModalMessage(
					msg_treinamento_pedro_campos_obrigatorios, false);
			String camposNaoPreenchidosArray[] = camposNaoPreenchidos
					.split(",");
			for (int i = 0; i < camposNaoPreenchidosArray.length; i++) {
				BradescoFacesUtils.addInfoModalMessage(
						camposNaoPreenchidosArray[i], false);
			}
			return false;
		} else {
			return true;
		}
	}

	public void limparCampoEstado() {
		VitoriaTesteViewHelper model = this.viewHelper;
		model.setEstado(VAZIO);
	}

	public void abrirModal() {
		viewHelper.setRenderModal(Boolean.TRUE);
	}

	public void fecharModal() {
		viewHelper.setRenderModal(Boolean.FALSE);
	}

	public void abrirModalEstado() {
		viewHelper.setRenderModalEstado(Boolean.TRUE);
	}

	public void fecharModalEstado() {
		viewHelper.setRenderModalEstado(Boolean.FALSE);
	}
	
	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnConsultar(Boolean.TRUE);
		}
	}
	public String voltar() {

		return paginaAnterior;
	}
	public String voltarConsultar() {
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		return RiccConstants.TELA_TREINAMENTO_VITORIA_TESTE_CADASTRO;
	}
	

}
