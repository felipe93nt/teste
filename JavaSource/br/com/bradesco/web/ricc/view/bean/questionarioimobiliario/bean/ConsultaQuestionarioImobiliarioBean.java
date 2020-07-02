package br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.enums.ComentarioEnum;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AbaQuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.AreaAtuacaoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.HistoricoLancamentosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.LandBankVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasAndamentoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.ObrasConcluidasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.service.business.questionarioimobiliario.IQuestionarioImobiliarioService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.cadastro.bean.CadastramentoRicBean;
import br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.viewhelper.ConsultaQuestionarioImobiliarioViewHelper;

@SessionScoped
@Named(value = "consultaQuestionarioImobiliarioBean")
public class ConsultaQuestionarioImobiliarioBean extends AbstractBean<ConsultaQuestionarioImobiliarioViewHelper> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1831732357444374217L;
	private String paginaAnterior = "";

	@Inject
	@Named("questionarioImobiliarioService")
    private IQuestionarioImobiliarioService questionarioImobiliarioService = null;
	
	@Override
	public String iniciarPagina() {
		setViewHelper(new ConsultaQuestionarioImobiliarioViewHelper());
		viewHelper.inicializar();
		
		carregarDadosCadastro();
		carregarDados();
		
		return RiccConstants.TELA_CONSULTA_QUESTIONARIO_IMOBILIARIO;
	}
	
	private void carregarDadosCadastro() {
		CadastramentoRicBean bean = (CadastramentoRicBean) FacesUtils
				.getManagedBean(RiccConstants.BEAN_CADASTRAMENTO_RIC);
		viewHelper.getModel().setCodGrupoEconomico(
				bean.getViewHelper().getModelPesquisa().getNumGrupoLabel());
		viewHelper.getModel().setDescGrupoEconomico(
				bean.getViewHelper().getModelPesquisa().getNomeGrupoLabel());
		viewHelper.getModel().setCodRelatorio(
				String.valueOf(bean.getViewHelper().getItemSelecionado().get(0)
						.getCodRelatorio()));
	}
	
	public void carregarDados() {

		consultaDetalheSetorImobiliario();
		listarAreaAtuacao();
		listarHistoricoLancamentos();
		listarLandBank();
		listarObrasAndamento();
		listarObrasConcluidas();
		consultaComentarios();
	}
	
	private void consultaDetalheSetorImobiliario(){
		
		QuestionarioImobiliarioVO model = viewHelper.getModel();
		
		try {
			model.setQuestionario(questionarioImobiliarioService.consultaDetalheSetorImobiliario(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
	}

	public void listarAreaAtuacao() {

		AbaQuestionarioImobiliarioVO questionario = viewHelper
				.getModel().getQuestionario();
		
		questionario.setListaAreaAtuacao(new ArrayList<AreaAtuacaoVO>());
		questionario.setAreaAtuacaoSelecionado(new ArrayList<AreaAtuacaoVO>());
		
		try {
			questionario.setListaAreaAtuacao(questionarioImobiliarioService
					.consultaAreaAtuacao(viewHelper
							.getModel()));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
	}

	public void listarHistoricoLancamentos() {

		AbaQuestionarioImobiliarioVO questionario = viewHelper
				.getModel().getQuestionario();
		questionario.setListaHistoricoLancamentos(new ArrayList<HistoricoLancamentosVO>());
		questionario.setHistoricoLancamentosSelecionado(new ArrayList<HistoricoLancamentosVO>());
		
		StringBuilder vgvTotal = new StringBuilder();
		StringBuilder qtdTotal = new StringBuilder();
		
		try {
			questionario.setListaHistoricoLancamentos(questionarioImobiliarioService.consultaHistoricoLancamentos(
					viewHelper.getModel(), vgvTotal, qtdTotal));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		questionario.setVgvTotal(vgvTotal.toString());
		questionario.setQtdTotal(qtdTotal.toString());
		
	}
	
	public void listarLandBank(){
		AbaQuestionarioImobiliarioVO questionario = viewHelper
				.getModel().getQuestionario();
		questionario.setListaLandBank(new ArrayList<LandBankVO>());
		questionario.setLandBankSelecionado(new ArrayList<LandBankVO>());
		StringBuilder totalTerreno = new StringBuilder();
		StringBuilder totalProjetada = new StringBuilder();
		try {
			questionario.setListaLandBank(questionarioImobiliarioService.consultaLandBank(
					viewHelper.getModel(), totalTerreno, totalProjetada));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		questionario.setTotalTerreno(totalTerreno.toString());
		questionario.setTotalProjetada(totalProjetada.toString());
	}
	
	public void listarObrasAndamento(){
		
		QuestionarioImobiliarioVO questionario = viewHelper.getModel();
		
		questionario.setListaObrasAndamento(new ArrayList<ObrasAndamentoVO>());
		questionario.setObrasAndamentoSelecionado(new ArrayList<ObrasAndamentoVO>());
		
		StringBuilder sb = new StringBuilder();
		
		try {
			QuestionarioImobiliarioVO retorno =
					questionarioImobiliarioService.consultaObrasAndamento(
							viewHelper.getModel(), sb);
			
			questionario.setListaObrasAndamento(retorno.getListaObrasAndamento());
					
			questionario.setTotalCustoObra(retorno.getTotalCustoObra());
			questionario.setTotalCustoIncorrer(retorno.getTotalCustoIncorrer());
			questionario.setTotalVenda(retorno.getTotalVenda());
			questionario.setTotalVendaPermuta(retorno.getTotalVendaPermuta());
			questionario.setTotalQuantidadeEstoque(retorno.getTotalQuantidadeEstoque());
			questionario.setTotalUnidadeSemPermuta(retorno.getTotalUnidadeSemPermuta());
			questionario.setTotalUnidadePermuta(retorno.getTotalUnidadePermuta());
			questionario.setTotalValorRecibo(retorno.getTotalValorRecibo());
			questionario.setTotalValorReciboPreChave(retorno.getTotalValorReciboPreChave());
			questionario.setTotalValorReciboPosChave(retorno.getTotalValorReciboPosChave());
			questionario.setTotalValorContrato(retorno.getTotalValorContrato());
			questionario.setTotalSaldoLiberar(retorno.getTotalSaldoLiberar());
			questionario.setTotalSaldoDevedorAndamento(retorno.getTotalSaldoDevedorAndamento());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
	}
	
	public void listarObrasConcluidas(){
		
		QuestionarioImobiliarioVO questionario = viewHelper.getModel();
		
		questionario.setListaObrasConcluidas(new ArrayList<ObrasConcluidasVO>());
		questionario.setObrasConcluidasSelecionado(new ArrayList<ObrasConcluidasVO>());
		
		StringBuilder sb = new StringBuilder();
		
		try {
			QuestionarioImobiliarioVO retorno =
					questionarioImobiliarioService.consultaObrasConcluidas(
							viewHelper.getModel(), sb);
			
			questionario.setListaObrasConcluidas(retorno.getListaObrasConcluidas());
							
			questionario.setTotalRecebidos(retorno.getTotalRecebidos());
			questionario.setTotal12Meses(retorno.getTotal12Meses());
			questionario.setTotal12A36(retorno.getTotal12A36());
			questionario.setTotalApos36(retorno.getTotalApos36());
			questionario.setTotalUnidades(retorno.getTotalUnidades());
			questionario.setTotalValorEstoque(retorno.getTotalValorEstoque());
			questionario.setTotalSaldoDevedor(retorno.getTotalSaldoDevedor());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
	}
	
	private void consultaComentarios() {

		QuestionarioImobiliarioVO model = viewHelper.getModel();
		
		try {
			// OBRAS ANDAMENTO / CONCLUÍDAS - 14
			List<ComentarioVO> comentarioObras = questionarioImobiliarioService.consultaComentarios(model,
							ComentarioEnum.OBRAS);

			// SEQUENCIAL 1 - ANDAMENTO
			model.getObrasAndamento().setDescObrasAndamento(comentarioObras.get(0)
					.getComentario());
			// SEQUENCIAL 2 - CONCLUÍDAS
			model.getObrasConcluidas().setDescObrasConcluidas(comentarioObras.get(1)
					.getComentario());

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}
	
	public void selecionarAba(ActionEvent event) {
		String id = event.getComponent().getId();
		if (id.equals("btnAbaQuestionario")) {
			getViewHelper().setRenderAbaQuestionario(Boolean.TRUE);
			getViewHelper().setRenderAbaObrasAndamento(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasConcluidas(Boolean.FALSE);
		} else if (id.equals("btnAbaAndamento")) {
			getViewHelper().setRenderAbaQuestionario(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasAndamento(Boolean.TRUE);
			getViewHelper().setRenderAbaObrasConcluidas(Boolean.FALSE);
		} else if (id.equals("btnAbaConcluidas")) {
			getViewHelper().setRenderAbaQuestionario(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasAndamento(Boolean.FALSE);
			getViewHelper().setRenderAbaObrasConcluidas(Boolean.TRUE);
		}
	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String voltar() {
		return paginaAnterior;
	}

}
