/**
 * 
 */
package br.com.bradesco.web.ricc.view.bean.treinamento.anderson.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.AwbMapBuilder;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.treinamento.ClienteAndersonVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.cadastro.bean.CadastramentoRicBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.anderson.viewhelper.AndersonClienteViewhelper;
import br.com.bradesco.web.ricc.view.bean.treinamento.anderson.viewhelper.AndersonTesteCadastroViewhelper;

/**
 * @author amendes
 *
 */

@SessionScoped
@Named(value = "andersonTesteCadastroBean")
public class AndersonTesteCadastroBean extends
		AbstractBean<AndersonTesteCadastroViewhelper> {

	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";

	public String iniciarPagina() {
		this.viewHelper = new AndersonTesteCadastroViewhelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ANDERSON_TESTE_CADASTRO;
	}

	public String iniciarPaginaConsulta() {
		// this.viewHelper = new AndersonTesteCadastroViewhelper();
		carregarConsulta();
		return RiccConstants.TELA_ANDERSON_TESTE_CONSULTA;
	}

	/**
	 * @description
	 * @name salvar
	 * @see AndersonTesteCadastroBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (valida()) {
			String retorno = "Cliente salvo com sucesso!";
			// List<String> lista = new ArrayList<String>();
			// lista.add("Cliente salvo com sucesso! teste");
			System.out.println(viewHelper.getNome());
			System.out.println(viewHelper.getRg());
			System.out.println(viewHelper.getCpf());
			System.out.println(viewHelper.getDataNascimento());
			System.out.println(viewHelper.getSexo());
			System.out.println(viewHelper.getLogradouro());
			System.out.println(viewHelper.getNumero());
			System.out.println(viewHelper.getComplemento());
			System.out.println(viewHelper.getBairro());
			System.out.println(viewHelper.getCidade());
			System.out.println(viewHelper.getEstado());
			System.out.println(viewHelper.getCep());
			System.out.println(viewHelper.getTelefone());
			System.out.println(viewHelper.getCelular());
			System.out.println(viewHelper.getEmail());

			ClienteAndersonVO andersonClienteVO = new ClienteAndersonVO();

			andersonClienteVO.setNome(viewHelper.getNome());
			andersonClienteVO.setCpf(viewHelper.getCpf());
			andersonClienteVO.setRg(viewHelper.getRg());
			andersonClienteVO.setDataNascimento(viewHelper.getDataNascimento());
			andersonClienteVO.setSexo(viewHelper.getSexo());
			andersonClienteVO.setLogradouro(viewHelper.getLogradouro());
			andersonClienteVO.setNumero(viewHelper.getNumero());
			andersonClienteVO.setComplemento(viewHelper.getComplemento());
			andersonClienteVO.setBairro(viewHelper.getBairro());
			andersonClienteVO.setCidade(viewHelper.getCidade());
			andersonClienteVO.setEstado(viewHelper.getEstado());
			andersonClienteVO.setCep(viewHelper.getCep());
			andersonClienteVO.setTelefone(viewHelper.getTelefone());
			andersonClienteVO.setCelular(viewHelper.getCelular());
			andersonClienteVO.setEmail(viewHelper.getEmail());

			viewHelper.getListaCadastramento().add(andersonClienteVO);

			//BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			viewHelper.setRenderizarTabela(Boolean.TRUE);
			viewHelper.setBtnConsultar(Boolean.FALSE);
			viewHelper.getItemSelecionado().clear();
			///viewHelper.limpar();
		}
		return null;
	}

	public String voltar() {
		viewHelper.setBtnConsultar(Boolean.FALSE);
		return RiccConstants.TELA_ANDERSON_TESTE_CADASTRO;
	}

	public boolean valida() {
		boolean aux = false;
		boolean aux2 = false;

		String retorno = "";

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {

			BradescoFacesUtils
					.addErrorModalMessage("Preencher nome, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {

			BradescoFacesUtils
					.addErrorModalMessage("Preencher CPF, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher RG, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher data de nascimento, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher sexo, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher logradouro, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher numero, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher bairro, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCidade())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher cidade, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getEstado())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher estado, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher cep, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher telefone, Campo Obrigatório!!");
			aux = true;
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher celular, Campo Obrigatório!!");
			aux = true;
		}

		if (viewHelper.getCpf().replace(".", "").replace("-", "").trim()
				.length() < 11) {

			if (!aux) {
				BradescoFacesUtils.addErrorModalMessage("CPF Inválido!!");
				aux2 = true;
			}

		}

		if (viewHelper.getRg().replace(".", "").replace("-", "").trim()
				.length() < 8) {

			if (!aux) {
				BradescoFacesUtils.addErrorModalMessage("RG Inválido!!");
				aux2 = true;
			}

		}

		if (viewHelper.getDataNascimento().replace("/", "").trim().length() < 6) {

			if (!aux) {
				BradescoFacesUtils.addErrorModalMessage("Data Inválida!!");
				aux2 = true;
			}

		}

		if (viewHelper.getCep().replace(".", "").replace("-", "").trim()
				.length() < 8) {

			if (!aux) {
				BradescoFacesUtils.addErrorModalMessage("Cep Inválido!!");
				aux2 = true;
			}

		}

		if (viewHelper.getTelefone().replace("(", "").replace(")", "")
				.replace("-", "").trim().length() < 10) {

			if (!aux) {
				BradescoFacesUtils.addErrorModalMessage("Telefone Inválido!!");
				aux2 = true;
			}

		}

		if (viewHelper.getCelular().replace("(", "").replace(")", "")
				.replace("-", "").trim().length() < 11) {

			if (!aux) {
				BradescoFacesUtils.addErrorModalMessage("Celular Inválido!!");
				aux2 = true;
			}

		}

		if (aux || aux2) {

			return false;
		}

		return true;
	}

	/**
	 * @description
	 * @name paginar
	 * @see CadastramentoRicBean
	 * @param ae
	 * @return void
	 */
	public void paginar(ActionEvent ae) {
		// this.carregarListaCadastramento();
		viewHelper.getItemSelecionado().clear();
	}

	/**
	 * @description
	 * @name habilitarBotoes
	 * @see CadastramentoRicBean
	 * @return
	 * @return String
	 */
	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		ClienteAndersonVO cadastro = null;

		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		// System.out.println(viewHelper.getItemSelecionado().get(0).getNome());
		this.viewHelper.setItemSelecionado(viewHelper.getItemSelecionado());
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {

			this.viewHelper.setBtnConsultar(Boolean.TRUE);

		}

	}

	public void carregarConsulta() {
		// andersonClienteVO = itemSelecionado.get(0);
		try {
			this.viewHelper.getAndersonClienteVO().setNome(
					this.viewHelper.getItemSelecionado().get(0).getNome());
			this.viewHelper.getAndersonClienteVO().setCpf(
					this.viewHelper.getItemSelecionado().get(0).getCpf());
			this.viewHelper.getAndersonClienteVO().setRg(
					this.viewHelper.getItemSelecionado().get(0).getRg());
			this.viewHelper.getAndersonClienteVO().setDataNascimento(
					this.viewHelper.getItemSelecionado().get(0)
							.getDataNascimento());
			this.viewHelper.getAndersonClienteVO().setSexo(
					this.viewHelper.getItemSelecionado().get(0).getSexo());
			this.viewHelper.getAndersonClienteVO()
					.setLogradouro(
							this.viewHelper.getItemSelecionado().get(0)
									.getLogradouro());
			this.viewHelper.getAndersonClienteVO().setNumero(
					this.viewHelper.getItemSelecionado().get(0).getNumero());
			this.viewHelper.getAndersonClienteVO().setComplemento(
					this.viewHelper.getItemSelecionado().get(0)
							.getComplemento());
			this.viewHelper.getAndersonClienteVO().setBairro(
					this.viewHelper.getItemSelecionado().get(0).getBairro());
			this.viewHelper.getAndersonClienteVO().setCidade(
					this.viewHelper.getItemSelecionado().get(0).getCidade());
			this.viewHelper.getAndersonClienteVO().setEstado(
					this.viewHelper.getItemSelecionado().get(0).getEstado());
			this.viewHelper.getAndersonClienteVO().setCep(
					this.viewHelper.getItemSelecionado().get(0).getCep());
			this.viewHelper.getAndersonClienteVO().setTelefone(
					this.viewHelper.getItemSelecionado().get(0).getTelefone());
			this.viewHelper.getAndersonClienteVO().setCelular(
					this.viewHelper.getItemSelecionado().get(0).getCelular());
			this.viewHelper.getAndersonClienteVO().setEmail(
					this.viewHelper.getItemSelecionado().get(0).getEmail());
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

	public String cadastrarCidade() {
		if (siteUtil.isEmptyOrNull(viewHelper.getNomeCidade())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher Nome da Cidade, Campo Obrigatório!!");

		} else {
			this.viewHelper.getAddCidades().add(
					new SelectItem(this.viewHelper.getNomeCidade(),
							this.viewHelper.getNomeCidade()));
			this.viewHelper.setCidade(this.viewHelper.getNomeCidade());
			this.viewHelper.setNomeCidade("");
			BradescoFacesUtils
					.addErrorModalMessage("Cidade inserida com sucesso!!");
			this.viewHelper.setShowModal(Boolean.FALSE);
		}

		return "";
	}

	public String cadastrarEstado() {
		if (siteUtil.isEmptyOrNull(viewHelper.getNomeEstado())) {
			BradescoFacesUtils
					.addErrorModalMessage("Preencher Nome do Estado, Campo Obrigatório!!");

		} else {

			this.viewHelper.getAddEstados().add(
					new SelectItem(this.viewHelper.getNomeEstado(),
							this.viewHelper.getNomeEstado()));
			this.viewHelper.setEstado(this.viewHelper.getNomeEstado());
			this.viewHelper.setNomeEstado("");

			BradescoFacesUtils
					.addErrorModalMessage("Estado inserido com sucesso!!");
			this.viewHelper.setShowModal(Boolean.FALSE);
			//System.out.println(this.viewHelper.getEstado());
		}

		return "";
	}

}
