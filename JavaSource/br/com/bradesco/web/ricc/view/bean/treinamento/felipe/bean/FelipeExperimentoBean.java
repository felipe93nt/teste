package br.com.bradesco.web.ricc.view.bean.treinamento.felipe.bean;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteFelipeVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.felipe.viewhelper.FelipeExperimentoViewHelper;

@SessionScoped
@Named(value = "felipeExperimentoBean")
public class FelipeExperimentoBean extends AbstractBean<FelipeExperimentoViewHelper>{

	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";
	
	@Override
	public String iniciarPagina() {
		this.viewHelper = new FelipeExperimentoViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_FELIPE_EXPERIENCIA_CLIENTE_CADASTRO;
	}
	/**
	 * @description
	 * @name salvar
	 * @see FelipeExperienciaBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		if (validaSalvar()) {
			String retorno = "Salvo com sucesso!";
			ClienteFelipeVO clienteVO = new ClienteFelipeVO();
			clienteVO.setNome(this.viewHelper.getNome());
			clienteVO.setCpf(this.viewHelper.getCpf());
			clienteVO.setRg(this.viewHelper.getRg());
			clienteVO.setDataNasc(this.viewHelper.getDataNasc());
			clienteVO.setSexo(this.viewHelper.getSexo());
			clienteVO.setLogradouro(this.viewHelper.getLogradouro());
			clienteVO.setNumero(this.viewHelper.getNumero());
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
				.getNome())) {
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
				.getDataNasc())) {
			String datavaziamsg = "Data de Nascimento - Campo Obrigatório.";
			mensagem += datavaziamsg + "<br> <br>";
		} else {

			if (viewHelper.getDataNasc().length() != 10) {
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
		if (viewHelper.getEstado().equals("")||viewHelper.getEstado()==null) {
			String estadomsg = "Estado - Campo Obrigatório.";
			mensagem += estadomsg + "<br> <br>";
		}
		if (viewHelper.getCidade().equals("")||viewHelper.getCidade()==null) {
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
		viewHelper.setNome("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setDataNasc("");
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
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnConsultar(Boolean.TRUE);
		}
	}

	public String consultar() {
		ClienteFelipeVO itemSelecionado = getViewHelper().getItemSelecionado()
				.get(0);
		viewHelper.getClienteVO().setNome(itemSelecionado.getNome());
		viewHelper.getClienteVO().setCpf(itemSelecionado.getCpf());
		viewHelper.getClienteVO().setRg(itemSelecionado.getRg());
		viewHelper.getClienteVO().setDataNasc(
				itemSelecionado.getDataNasc());
		viewHelper.getClienteVO().setSexo(itemSelecionado.getSexo());
		viewHelper.getClienteVO()
				.setLogradouro(itemSelecionado.getLogradouro());
		viewHelper.getClienteVO().setNumero(
				itemSelecionado.getNumero());
		viewHelper.getClienteVO().setComplemento(
				itemSelecionado.getComplemento());
		viewHelper.getClienteVO().setBairro(itemSelecionado.getBairro());
		viewHelper.getClienteVO().setEstado(itemSelecionado.getEstado());
		viewHelper.getClienteVO().setCidade(itemSelecionado.getCidade());
		viewHelper.getClienteVO().setCep(itemSelecionado.getCep());
		viewHelper.getClienteVO().setTelefone(itemSelecionado.getTelefone());
		viewHelper.getClienteVO().setCelular(itemSelecionado.getCelular());
		viewHelper.getClienteVO().setEmail(itemSelecionado.getEmail());
		paginaAnterior = RiccConstants.TELA_FELIPE_EXPERIENCIA_CLIENTE_CADASTRO;
		this.viewHelper.setBtnConsultar(Boolean.FALSE);
		return RiccConstants.TELA_FELIPE_EXPERIENCIA_CLIENTE_CONSULTA;
	}

}
