package br.com.bradesco.web.ricc.view.bean.treinamento.wellington.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.treinamento.ClienteGustavoVO;
import br.com.bradesco.web.ricc.model.treinamento.ClienteWellingtonVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.bean.ConsultaQuestionarioAltoVarejoBean;
import br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.viewhelper.ConsultaAltoVarejoViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionariocorporate.bean.ConsultaQuestionarioCorporateBean;
import br.com.bradesco.web.ricc.view.bean.questionariocorporate.viewhelper.ConsultaQuestionarioCorporateViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionarioempresas.bean.ConsultaQuestionarioEmpresasBean;
import br.com.bradesco.web.ricc.view.bean.questionarioempresas.viewhelper.ConsultaQuestionarioEmpresasViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.bean.ConsultaQuestionarioLargeCorporateBean;
import br.com.bradesco.web.ricc.view.bean.questionariolargecorporate.viewhelper.ConsultaQuestionarioLargeCorporateViewHelper;
import br.com.bradesco.web.ricc.view.bean.treinamento.wellington.viewhelper.WellingtonTesteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Gustavo Garcia - Foursys
 * @see WellingtonTesteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "wellingtonTesteBean")
public class WellingtonTesteBean extends
		AbstractBean<WellingtonTesteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	public static List<SelectItem> estadosAdicionados = new ArrayList<SelectItem>();
	public static List<SelectItem> cidadesAdicionadas = new ArrayList<SelectItem>();
	public static List<ClienteWellingtonVO> clientesCadastrados = new ArrayList<ClienteWellingtonVO>();

	@Override
	public String iniciarPagina() {
		this.viewHelper = new WellingtonTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_TESTE_INSERIR_CLIENTE;
	}

	public String voltar() {
		String aux = paginaAnterior;
		paginaAnterior = "nav_index";
		return aux;
	}

	public String validaPreenchimento(String nomeCampo, Object vazio) {
		String retorno = "";
		if ((vazio == null) || (vazio.equals("") || vazio.equals("0"))) {

			retorno = "O campo " + nomeCampo + " é obrigatório!" + "</br>";
			return retorno;
		}
		return retorno;
	}

	public String validaSalvar() {
		String retorno = "";
		retorno += validaPreenchimento("Nome", viewHelper.getNome());
		retorno += validaPreenchimento("Cpf", viewHelper.getCpf());
		retorno += validaPreenchimento("RG", viewHelper.getRg());
		retorno += validaPreenchimento("Data Nascimento",
				viewHelper.getDataNascimento());
		retorno += validaPreenchimento("Sexo", viewHelper.getSexo());

		retorno += validaPreenchimento("Logradouro", viewHelper.getLogradouro());
		retorno += validaPreenchimento("Numero", viewHelper.getNumero());
		retorno += validaPreenchimento("Bairro", viewHelper.getBairro());
		retorno += validaPreenchimento("Cidade", viewHelper.getCidade());
		retorno += validaPreenchimento("Estado", viewHelper.getEstado());

		retorno += validaPreenchimento("Cep ", viewHelper.getCep());
		retorno += validaPreenchimento("Telefone ", viewHelper.getTelefone());
		retorno += validaPreenchimento("Celular", viewHelper.getCelular());
		
		return retorno;
	}

	public void limparCampos() {
		viewHelper.setNome("");
		viewHelper.setRg("");
		viewHelper.setCpf("");
		viewHelper.setSexo("");

		viewHelper.setDataNascimento(null);
		viewHelper.setLogradouro("");
		viewHelper.setNumero("");
		viewHelper.setCep("");
		viewHelper.setComplemento("");
		viewHelper.setCidade("");
		viewHelper.setEstado("");
		viewHelper.setBairro("");

		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");

	}

	public String salvar() {

		if (validaSalvar().equals("")) {
			ClienteWellingtonVO cliente = new ClienteWellingtonVO();
			cliente.setNomeCompleto(viewHelper.getNome());
			cliente.setRg(viewHelper.getRg());
			cliente.setCpf(viewHelper.getCpf());
			cliente.setSexo(viewHelper.getSexo());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			cliente.setDataNascimento(formato.format(viewHelper
					.getDataNascimento()));
			cliente.setLogradouro(viewHelper.getLogradouro());
			cliente.setNumero(viewHelper.getNumero());
			cliente.setComplemento(viewHelper.getComplemento());
			cliente.setBairro(viewHelper.getBairro());
			cliente.setCidade(viewHelper.getCidade());
			cliente.setEstado(viewHelper.getEstado());
			cliente.setCep(viewHelper.getCep());
			cliente.setTelefone(viewHelper.getTelefone());
			cliente.setCelular(viewHelper.getCelular());
			cliente.setEmail(viewHelper.getEmail());
			viewHelper.getListaCadastramento().add(cliente);
			clientesCadastrados.add(cliente);
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			viewHelper.setTabela(Boolean.TRUE);
			limparCampos();
		} else {
			BradescoFacesUtils.addInfoModalMessage(validaSalvar(),
					Boolean.FALSE);
		}
		return null;
	}

	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		if (!viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnConsultar(Boolean.FALSE);
		}
	}

	public void abrirModalEstado() {
		// inicializarCamposModal(); Limpa os campos do modal ao abri-lo
		viewHelper.setRenderModalEstado(Boolean.TRUE);
	}

	public void abrirModalCidade() {
		// inicializarCamposModal(); Limpa os campos do modal ao abri-lo
		viewHelper.setRenderModalCidade(Boolean.TRUE);
	}

	public void fecharModalEstado() {
		viewHelper.setEstadoAux("");
		viewHelper.setUfAux("");
		viewHelper.setRenderModalEstado(Boolean.FALSE);
	}

	public void fecharModalCidade() {
		viewHelper.setCidadeAux("");
		viewHelper.setRenderModalCidade(Boolean.FALSE);
	}

	public void incluirEstado() {

		if (validaEstado().equals("")) {
			String retorno = "Estado salvo com sucesso!";
			viewHelper.getComboEstado().add(
					new SelectItem(viewHelper.getEstadoAux()
							+ " - " + viewHelper.getUfAux(), viewHelper.getUfAux()));
			estadosAdicionados.add(new SelectItem(viewHelper.getEstadoAux()
					+ " - " + viewHelper.getUfAux(), viewHelper.getUfAux()));
			fecharModalEstado();

			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);

		} else {
			BradescoFacesUtils.addInfoModalMessage(validaEstado(),
					Boolean.FALSE);
		}

	}

	public void incluirCidade() {

		if (validaCidade().equals("")) {
			String retorno = "Cidade salva com sucesso!";
			viewHelper.getComboCidade().add(
					new SelectItem(viewHelper.getCidadeAux(), viewHelper
							.getCidadeAux()));
			cidadesAdicionadas.add(new SelectItem(viewHelper.getComboCidade()
					.size(), viewHelper.getCidadeAux()));
			fecharModalCidade();
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		} else {
			BradescoFacesUtils.addInfoModalMessage(validaCidade(),
					Boolean.FALSE);
		}
	}

	public String validaEstado() {
		String retorno = "";
		retorno += validaPreenchimento("Estado", viewHelper.getEstadoAux());
		retorno += validaPreenchimento("UF", viewHelper.getUfAux());

		return retorno;
	}

	public String validaCidade() {
		String retorno = "";
		retorno += validaPreenchimento("Cidade", viewHelper.getCidadeAux());
		return retorno;
	}

	public String consultar() {
		ClienteWellingtonVO itemSelecionado = getViewHelper()
				.getItemSelecionado().get(0);

		viewHelper.getClienteWellingtonVO().setNomeCompleto(
				itemSelecionado.getNomeCompleto());
		viewHelper.getClienteWellingtonVO().setRg(itemSelecionado.getRg());
		viewHelper.getClienteWellingtonVO().setCpf(itemSelecionado.getCpf());
		viewHelper.getClienteWellingtonVO().setDataNascimento(
				itemSelecionado.getDataNascimento());
		viewHelper.getClienteWellingtonVO().setSexo(itemSelecionado.getSexo());
		viewHelper.getClienteWellingtonVO().setLogradouro(
				itemSelecionado.getLogradouro());
		viewHelper.getClienteWellingtonVO().setNumero(
				itemSelecionado.getNumero());
		viewHelper.getClienteWellingtonVO().setComplemento(
				itemSelecionado.getComplemento());
		viewHelper.getClienteWellingtonVO().setBairro(
				itemSelecionado.getBairro());
		viewHelper.getClienteWellingtonVO().setCidade(
				itemSelecionado.getCidade());
		viewHelper.getClienteWellingtonVO().setEstado(
				itemSelecionado.getEstado());
		viewHelper.getClienteWellingtonVO().setCep(itemSelecionado.getCep());
		viewHelper.getClienteWellingtonVO().setTelefone(
				itemSelecionado.getTelefone());
		viewHelper.getClienteWellingtonVO().setCelular(
				itemSelecionado.getCelular());
		viewHelper.getClienteWellingtonVO()
				.setEmail(itemSelecionado.getEmail());
		paginaAnterior = RiccConstants.TELA_TREINAMENTO_TESTE_INSERIR_CLIENTE;
		return RiccConstants.TELA_TREINAMENTO_TESTE_CONSULTAR_CLIENTE;
	}

}
