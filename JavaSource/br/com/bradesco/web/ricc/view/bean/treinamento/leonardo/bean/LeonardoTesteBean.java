/**
 * 
 */
package br.com.bradesco.web.ricc.view.bean.treinamento.leonardo.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteLeonardoVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.leonardo.viewhelper.LeonardoTesteViewHelper;

/**
 * @author llopo
 *
 */

@SessionScoped
@Named(value = "leonardoTesteBean")
public class LeonardoTesteBean extends AbstractBean<LeonardoTesteViewHelper> {

	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	public String iniciarPagina() {
		this.viewHelper = new LeonardoTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_LEONARDO_TESTE_CADASTRO;
	}

	public String iniciarPaginaConsulta() {
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_LEONARDO_TESTE_CONSULTA;
	}

	/**
	 * @description
	 * @name salvar
	 * @see LeonardoTesteBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validarCamposObrigatorios()) {
			String retorno = "Cliente salvo com sucesso!";
			ClienteLeonardoVO cl = new ClienteLeonardoVO();

			cl.setNome((viewHelper.getNome()));
			cl.setRg((viewHelper.getRg()));
			cl.setCpf(viewHelper.getCpf() + "");
			cl.setDataNascimento(viewHelper.getDataNascimento());
			cl.setSexo(viewHelper.getSexo());
			cl.setLogradouro(viewHelper.getLogradouro());
			cl.setNumero(viewHelper.getNumero());
			cl.setComplemento(viewHelper.getComplemento());
			cl.setBairro(viewHelper.getBairro());
			cl.setCidade(viewHelper.getCidade());
			cl.setEstado(viewHelper.getEstado());
			cl.setCep(viewHelper.getCep());
			cl.setTelefone(viewHelper.getTelefone());
			cl.setCelular(viewHelper.getCelular());
			cl.setEmail(viewHelper.getEmail());

			viewHelper.inicializaCliente(cl);

			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			carregarListaClientes();
		}
		return null;
	}

	public String carregarListaClientes() {

		viewHelper.setListaClientes(viewHelper.adicionaLista());
		viewHelper.setTabela(Boolean.TRUE);
		viewHelper.limparCampos();

		return RiccConstants.TELA_TREINAMENTO_LEONARDO_TESTE_CADASTRO;
	}

	public String voltar() {

		return paginaAnterior;
	}

	public boolean validarCamposObrigatorios() {
		boolean retorno = true;

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			BradescoFacesUtils.addInfoModalMessage("Nome Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			BradescoFacesUtils.addInfoModalMessage("CPF Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			BradescoFacesUtils.addInfoModalMessage("RG Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			BradescoFacesUtils.addInfoModalMessage(
					"Data de Nascimento Obrigatória!", Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			BradescoFacesUtils.addInfoModalMessage("Sexo Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			BradescoFacesUtils.addInfoModalMessage("Logradouro Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			BradescoFacesUtils.addInfoModalMessage("Número Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			BradescoFacesUtils.addInfoModalMessage("Bairro Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCidade())) {
			BradescoFacesUtils.addInfoModalMessage("Cidade Obrigatória!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getEstado())) {
			BradescoFacesUtils.addInfoModalMessage("Estado Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			BradescoFacesUtils.addInfoModalMessage("Cep Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			BradescoFacesUtils.addInfoModalMessage("Telefone Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			BradescoFacesUtils.addInfoModalMessage("Celular Obrigatório!",
					Boolean.FALSE);
			retorno = false;
		}

		return retorno;
	}

	// Modal de Cidade
	public void abrirModalIncluirCidade() {
		viewHelper.setRenderModalIncluirCidade(Boolean.TRUE);
	}

	public void incluirCidade() {

		if (siteUtil.isEmptyOrNull(viewHelper.getNovaCidade())) {
			BradescoFacesUtils.addInfoModalMessage(
					"Entre com a Cidade a ser Inserida!", Boolean.FALSE);
		} else {
			viewHelper.setComboCidade(viewHelper.atualizaComboCidade(viewHelper
					.getNovaCidade()));
			System.out.println(viewHelper.getNovaCidade());
			fecharModalIncluirCidade();
			BradescoFacesUtils.addInfoModalMessage(
					"Cidade Inserida com Sucesso!", Boolean.FALSE);

		}
	}

	public void fecharModalIncluirCidade() {
		viewHelper.setRenderModalIncluirCidade(Boolean.FALSE);
		viewHelper.setNovaCidade(null);

	}

	// Modal de Estado
	public void abrirModalIncluirEstado() {
		viewHelper.setRenderModalIncluirEstado(Boolean.TRUE);
	}

	public void incluirEstado() {

		if (siteUtil.isEmptyOrNull(viewHelper.getNovoEstado())) {
			BradescoFacesUtils.addInfoModalMessage(
					"Entre com o Estado a ser Inserido!", Boolean.FALSE);
		} else {
			viewHelper.setComboEstado(viewHelper.atualizaComboEstado(viewHelper
					.getNovoEstado()));
			System.out.println(viewHelper.getNovoEstado());
			fecharModalIncluirEstado();
			BradescoFacesUtils.addInfoModalMessage(
					"Estado Inserido com Sucesso!", Boolean.FALSE);
		}

	}

	public void fecharModalIncluirEstado() {
		viewHelper.setRenderModalIncluirEstado(Boolean.FALSE);
		viewHelper.setNovoEstado(null);

	}

	//métodos para consulta
	public String consultar() {

		ClienteLeonardoVO itemSelecionado = viewHelper.getItemSelecionado()
				.get(0);
		viewHelper.setLeonardoClienteVO(itemSelecionado);

		return iniciarPaginaConsulta();
	}

	public String voltarConsulta() {
		return RiccConstants.TELA_TREINAMENTO_LEONARDO_TESTE_CADASTRO;
	}

}
