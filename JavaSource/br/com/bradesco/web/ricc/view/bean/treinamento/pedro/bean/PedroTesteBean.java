package br.com.bradesco.web.ricc.view.bean.treinamento.pedro.bean;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClientePedroVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.pedro.viewhelper.PedroTesteViewHelper;

/**
 * @name PedroTesteCadastroBean
 * @author Pedro Bido - Foursys
 * @see PedroTesteBean.java
 * @version 1.0
 * @since 18/05/2020
 */
@SessionScoped
@Named(value = "pedroTesteBean")
public class PedroTesteBean extends AbstractBean<PedroTesteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new PedroTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TREINAMENTO_PEDRO_TESTE_CADASTRO_INICIAR;
	}

	/**
	 * @description
	 * @name salvar
	 * @see PedroTesteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validaSalvar()) {
			String retorno = "Salvo com sucesso!";
			ClientePedroVO clienteVO = new ClientePedroVO();
			clienteVO.setNome(this.viewHelper.getNomeCompleto());
			clienteVO.setCpf(this.viewHelper.getCpf());
			clienteVO.setRg(this.viewHelper.getRg());
			clienteVO.setDataNascimento(this.viewHelper.getDataNascimento());
			clienteVO.setSexo(this.viewHelper.getSexo());
			clienteVO.setLogradouro(this.viewHelper.getLogradouro());
			clienteVO.setNumeroLogradouro(this.viewHelper.getNumero());
			clienteVO.setComplemento(this.viewHelper.getComplemento());
			clienteVO.setBairro(this.viewHelper.getBairro());
			clienteVO.setEstado(this.viewHelper.getEstado());
			clienteVO.setCidade(this.viewHelper.getCidade());
			clienteVO.setCep(this.viewHelper.getCep());
			clienteVO.setTelefone(this.viewHelper.getTelefone());
			clienteVO.setCelular(this.viewHelper.getCelular());
			clienteVO.setEmail(this.viewHelper.getEmail());
			this.viewHelper.getListaClienteVO().add(clienteVO);
			exibirTableClientes();
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		}
		return null;
	}

	public void exibirTableClientes() {
		viewHelper.setRenderTableClientes(Boolean.TRUE);
	}

	public String voltar() {

		return paginaAnterior;
	}

	public boolean validaSalvar() {
		String mensagem = "";
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper
				.getNomeCompleto())) {
			String nomemsg = "Nome - Campo Obrigatório.";
			mensagem += nomemsg + "<br> <br>";
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getCpf())) {
			String cpfvaziomsg = "CPF - Campo Obrigatório.";
			mensagem += cpfvaziomsg + "<br> <br>";
		} else {

			if (viewHelper.getCpf().length() != 14) {
				String cpfmsg = "CPF - Campo Incompleto.";
				mensagem += cpfmsg + "<br> <br>";
			}
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getRg())) {
			String rgvaziomsg = "RG - Campo Obrigatório.";
			mensagem += rgvaziomsg + "<br> <br>";
		} else {

			if (viewHelper.getRg().length() != 12
					&& viewHelper.getRg().length() != 11
					&& viewHelper.getRg().length() != 10) {
				String rgmsg = "RG - Campo Incompleto.";
				mensagem += rgmsg + "<br> <br>";
			}
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper
				.getDataNascimento())) {
			String datavaziamsg = "Data de Nascimento - Campo Obrigatório.";
			mensagem += datavaziamsg + "<br> <br>";
		} else {

			if (viewHelper.getDataNascimento().length() != 10) {
				String datamsg = "Data de Nascimento - Campo Incompleto.";
				mensagem += datamsg + "<br> <br>";
			}
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getSexo())) {
			String sexomsg = "Sexo - Campo Obrigatório.";
			mensagem += sexomsg + "<br> <br>";
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getLogradouro())) {
			String logradouromsg = "Logradouro - Campo Obrigatório.";
			mensagem += logradouromsg + "<br> <br>";
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getNumero())) {
			String numeromsg = "Número - Campo Obrigatório.";
			mensagem += numeromsg + "<br> <br>";
		}

		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getBairro())) {
			String bairromsg = "Bairro - Campo Obrigatório.";
			mensagem += bairromsg + "<br> <br>";
		}
		if (viewHelper.getEstado().equals(
				RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1)) {
			String estadomsg = "Estado - Campo Obrigatório.";
			mensagem += estadomsg + "<br> <br>";
		}
		if (viewHelper.getCidade().equals(
				RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1)) {
			String cidademsg = "Cidade - Campo Obrigatório.";
			mensagem += cidademsg + "<br> <br>";
		}
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getCep())) {
			String cepvaziomsg = "CEP - Campo Obrigatório.";
			mensagem += cepvaziomsg + "<br> <br>";
		} else {

			if (viewHelper.getCep().length() != 9) {
				String cepmsg = "CEP - Campo Incompleto.";
				mensagem += cepmsg + "<br> <br>";
			}
		}
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getTelefone())) {
			String telefonevaziomsg = "Telefone - Campo Obrigatório.";
			mensagem += telefonevaziomsg + "<br> <br>";
		} else {

			if (viewHelper.getTelefone().length() != 13) {
				String telefonemsg = "Telefone - Campo Incompleto.";
				mensagem += telefonemsg + "<br> <br>";
			}
		}
		if (!siteUtil.validaUmCampoPreenchidoString(viewHelper.getCelular())) {
			String celularvaziomsg = "Celular - Campo Obrigatório.";
			mensagem += celularvaziomsg + "<br> <br>";
		} else {

			if (viewHelper.getCelular().length() != 14) {
				String celularmsg = "Celular - Campo Incompleto.";
				mensagem += celularmsg + "<br> <br>";

			}
		}

		if (siteUtil.validaUmCampoPreenchidoString(mensagem)) {
			BradescoFacesUtils.addInfoModalMessage(mensagem, Boolean.FALSE);
			return false;
		} else {
			return true;
		}
	}

	public void limparCampos() {
		viewHelper.setNomeCompleto("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setDataNascimento("");
		viewHelper.setSexo("");
		viewHelper.setLogradouro("");
		viewHelper.setNumero("");
		viewHelper.setComplemento("");
		viewHelper.setBairro("");
		viewHelper.setEstado(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1);
		viewHelper.setCidade(RiccConstants.TREINAMENTO_WELLINGTON_OPCAO_1);
		viewHelper.setCep("");
		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");
	}

	public void abrirModalCidade() {
		viewHelper.setCidadeIncluir(VAZIO);
		viewHelper.setRenderModalCidade(Boolean.TRUE);
	}

	public void fecharModalCidade() {
		viewHelper.setRenderModalCidade(Boolean.FALSE);
	}

	public void incluirCidade() {
		List<SelectItem> listaCidadesCombo = this.viewHelper.getComboCidade();
		listaCidadesCombo.add(new SelectItem(viewHelper.getCidadeIncluir()));
		viewHelper.setComboCidade(listaCidadesCombo);
		fecharModalCidade();
	}

	public void abrirModalEstado() {
		viewHelper.setEstadoIncluir(VAZIO);
		viewHelper.setRenderModalEstado(Boolean.TRUE);
	}

	public void fecharModalEstado() {
		viewHelper.setRenderModalEstado(Boolean.FALSE);
	}

	public void incluirEstado() {
		List<SelectItem> listaEstadosCombo = this.viewHelper.getComboEstado();
		listaEstadosCombo.add(new SelectItem(viewHelper.getEstadoIncluir()
				.toUpperCase()));
		viewHelper.setComboEstado(listaEstadosCombo);
		fecharModalEstado();
	}

	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().equals(VAZIO)) {
			this.viewHelper.setBtnConsultar(Boolean.TRUE);
		}
	}

	public String consultar() {
		ClientePedroVO itemSelecionado = getViewHelper().getItemSelecionado()
				.get(0);
		viewHelper.getClienteVO().setNome(itemSelecionado.getNome());
		viewHelper.getClienteVO().setCpf(itemSelecionado.getCpf());
		viewHelper.getClienteVO().setRg(itemSelecionado.getRg());
		viewHelper.getClienteVO().setDataNascimento(
				itemSelecionado.getDataNascimento());
		viewHelper.getClienteVO().setSexo(itemSelecionado.getSexo());
		viewHelper.getClienteVO()
				.setLogradouro(itemSelecionado.getLogradouro());
		viewHelper.getClienteVO().setNumeroLogradouro(
				itemSelecionado.getNumeroLogradouro());
		viewHelper.getClienteVO().setComplemento(
				itemSelecionado.getComplemento());
		viewHelper.getClienteVO().setBairro(itemSelecionado.getBairro());
		viewHelper.getClienteVO().setEstado(itemSelecionado.getEstado());
		viewHelper.getClienteVO().setCidade(itemSelecionado.getCidade());
		viewHelper.getClienteVO().setCep(itemSelecionado.getCep());
		viewHelper.getClienteVO().setTelefone(itemSelecionado.getTelefone());
		viewHelper.getClienteVO().setCelular(itemSelecionado.getCelular());
		viewHelper.getClienteVO().setEmail(itemSelecionado.getEmail());
		paginaAnterior = RiccConstants.TREINAMENTO_PEDRO_TESTE_CADASTRO_INICIAR;
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		return RiccConstants.TREINAMENTO_PEDRO_TESTE_CONSULTA_INICIAR;
	}

}
