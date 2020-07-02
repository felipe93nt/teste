package br.com.bradesco.web.ricc.view.bean.treinamento.enzo.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.service.business.cadastro.ICadastramentoRicService;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.enzo.viewhelper.EnzoTesteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author eknascimento - Foursys
 * @see EnzoTesteBean.java
 * @version 1.0
 * @since 18/05/2020
 */
@SessionScoped
@Named(value = "enzoTesteBean")
public class EnzoTesteBean extends AbstractBean<EnzoTesteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "";
	private String mensagem = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new EnzoTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ENZO_TESTE_CADASTRO;
	}
	
	
	
	
	
	@Inject
	@Named("cadastramentoRicService")
	private ICadastramentoRicService cadastramentoRicService;

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;
	
	
	
	
	

	/**
	 * @description
	 * @name salvar
	 * @see EnzoTesteBean
	 * @return
	 * @return String
	 */
	public String salvar() {

		if (validarCampos()) {
			String retorno = "Cliente salvo com sucesso!";
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		} else {
			BradescoFacesUtils.addInfoModalMessage("Informe os Dados:<br><br>" + mensagem + "<br>Campos Obrigatórios!", Boolean.FALSE);
			mensagem = "";

		}

		return "";
	}

	// public String iniciarConsulta() {
	// this.viewHelper = new EnzoTesteViewHelper();
	// this.viewHelper.popularCampos();
	//
	// return RiccConstants.TELA_CLAUDIO_CLIENTE_CONSULTA;
	// }

	public String voltar() {
		limparCampos();
		return paginaAnterior;
	}

//	public String incluir() {
//		CadastramentoVO itemSelecionado = getViewHelper().getItemSelecionado()
//				.get(0);
//		String retorno = "";
//
//		ConsultaQuestionarioAltoVarejoBean bean = (ConsultaQuestionarioAltoVarejoBean) FacesUtils
//				.getManagedBean("consultaQuestionarioAltoVarejoBean");
//
//		bean.setViewHelper(new ConsultaAltoVarejoViewHelper());
//		bean.getViewHelper().inicializar();
//		bean.getViewHelper().getModel()
//				.setCodRelatorio(itemSelecionado.getCodRelatorio().toString());
//
//		retorno = bean.iniciarPagina();
//
//		return retorno;
//	}
//	
	
	public String consultar() {
		this.viewHelper = new EnzoTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_ENZO_TESTE_CONSULTA;
	}
	
	
	
	
	public String carregarListaCadastramento() {
			try {
				viewHelper.popularCampos();

			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}
			
		return RiccConstants.TELA_CADASTRO_RIC;
	}
	
	
	
	
	
	
	

	public boolean validarCampos() {

		if (siteUtil.isEmptyOrNull(viewHelper.getNome())) {
			mensagem += "Nome<br>";

		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			mensagem += "CPF<Br>";

		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			mensagem += "RG<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			mensagem += "Data de Nascimento<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			mensagem += "Sexo<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			mensagem += "Logradouro<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumero())) {
			mensagem += "Numero<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			mensagem += "Bairro<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			mensagem += "CEP<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			mensagem += "Telefone<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			mensagem += "Celular<br>";

			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public void limparCampos() {
		viewHelper.setNome("");
		viewHelper.setCpf("");
		viewHelper.setRg("");
		viewHelper.setDataNascimento("");
		viewHelper.setSexo("");
		viewHelper.setLogradouro("");
		viewHelper.setNumero("");
		viewHelper.setComplemento("");
		viewHelper.setBairro("");
		viewHelper.setCidade("");
		viewHelper.setEstado("");
		viewHelper.setCep("");
		viewHelper.setTelefone("");
		viewHelper.setCelular("");
		viewHelper.setEmail("");

	}

}
