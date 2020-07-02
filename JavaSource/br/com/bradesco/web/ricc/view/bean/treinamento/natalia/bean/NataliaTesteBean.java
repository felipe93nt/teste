package br.com.bradesco.web.ricc.view.bean.treinamento.natalia.bean;

import java.util.List;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.docx4j.model.datastorage.XPathEnhancerParser.nameTest_return;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.treinamento.ClienteNataliaVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.natalia.viewhelper.NataliaTesteViewHelper;

@SessionScoped
@Named(value = "nataliaTesteBean")
public class NataliaTesteBean extends AbstractBean<NataliaTesteViewHelper> {
	private static final long serialVersionUID = 1L;
	private ClienteNataliaVO cliente = new ClienteNataliaVO();
	private List<ClienteNataliaVO> consulta = null;

	@Override
	public String iniciarPagina() {
		this.viewHelper = new NataliaTesteViewHelper();
		this.viewHelper.inicializar();

		return RiccConstants.TELA_TREINAMENTO_NATALIA_TESTE_CADASTRO;
	}

	public String iniciaPagina() {
		this.viewHelper = new NataliaTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_NATALIA_TESTE_CONSULTA;
	}

	public String salvar() {
		if (valida()) {

			try {
				

				String retorno = "Cliente salvo com sucesso!";
				BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
				limpar();

			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}

		}
		return null;
	}

	public String voltar() {

		return "nav_index";
	}

	//
	// private void carregarDadosCadastro() {
	// NataliaTesteBean bean = (NataliaTesteBean)
	// FacesUtils.getManagedBean(RiccConstants.TELA_TREINAMENTO_NATALIA_TESTE_CONSULTA);
	// viewHelper.getModel().setNomeCompleto(bean.getViewHelper().getModel().getNomeCompleto());
	// viewHelper.getModel().setCpf(bean.getViewHelper().getModel().getCpf());
	// viewHelper.getModel().setRg(bean.getViewHelper().getModel().getRg());
	// viewHelper.getModel().setDataNascimento(bean.getViewHelper().getModel().getDataNascimento());
	// viewHelper.getModel().setSexo(bean.getViewHelper().getModel().getSexo());
	// viewHelper.getModel().setLogradouro(bean.getViewHelper().getModel().getLogradouro());
	// viewHelper.getModel().setNumeroLogradouro(bean.getViewHelper().getModel().getNumeroLogradouro());;
	// viewHelper.getModel().setBairro(bean.getViewHelper().getModel().getBairro());
	// viewHelper.getModel().setComplemento(bean.getViewHelper().getModel().getComplemento());
	// viewHelper.getModel().setCidade(bean.getViewHelper().getModel().getCidade());
	// viewHelper.getModel().setEstado(bean.getViewHelper().getModel().getEstado());
	// viewHelper.getModel().setTelefone(bean.getViewHelper().getModel().getTelefone());
	// viewHelper.getModel().setCelular(bean.getViewHelper().getModel().getCelular());
	// viewHelper.getModel().setEmail(bean.getViewHelper().getModel().getEmail());
	// }
	public boolean valida() {

		boolean retorno = true;

		if (siteUtil.isEmptyOrNull(this.viewHelper.getNomeCompleto())) {
			String msg = "O campo Nome é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCpf())) {
			String msg = "O campo CPF é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getRg())) {
			String msg = "O campo RG é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getDataNascimento())) {
			String msg = "O campo Data Nascimento é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyZeroOrNull(this.viewHelper.getSexo())) {
			String msg = "O campo Sexo é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getLogradouro())) {
			String msg = "O campo Logradouro é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getNumeroLogradouro())) {
			String msg = "O campo Numero é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getBairro())) {
			String msg = "O campo Bairro é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}

		if (this.viewHelper.getCidade().equals(
				RiccConstants.TREINAMENTO_NATALIA_CIDADE_1)) {
			String msg = "O campo Cidade é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (this.viewHelper.getEstado().equals(
				RiccConstants.TREINAMENTO_NATALIA_ESTADO_1)) {
			String msg = "O campo Estado é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCep())) {
			String msg = "O campo CEP é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getTelefone())) {
			String msg = "O campo Telefone é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(this.viewHelper.getCelular())) {
			String msg = "O campo Celular é obrigatório!";
			BradescoFacesUtils.addInfoModalMessage(msg, Boolean.FALSE);
			retorno = false;
		}
		return retorno;
	}

	private void limpar() {

		this.viewHelper.setNomeCompleto(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setTelefone(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setEmail(null);

	}

	public ClienteNataliaVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteNataliaVO cliente) {
		this.cliente = cliente;
	}

	public List<ClienteNataliaVO> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<ClienteNataliaVO> consulta) {
		this.consulta = consulta;
	}

	//
	// public void clienteConsulta() {
	//
	//
	// viewHelper.getNomeCompleto();
	// viewHelper.getCelular();
	// viewHelper.getCep();
	// viewHelper.getCidade();
	// viewHelper.getComplemento();
	// viewHelper.getCpf();
	// viewHelper.getDataNascimento();
	// viewHelper.getEmail();
	// viewHelper.getEstado();
	// viewHelper.getLogradouro();
	// viewHelper.getNomeCompleto();
	// viewHelper.getNumeroLogradouro();
	// viewHelper.getRg();
	// viewHelper.getSexo();
	// viewHelper.getTelefone();
	// }

	public void abrirModal() {

	
		viewHelper.setRenderModal(Boolean.FALSE);
	
	
	}

	
	
}
