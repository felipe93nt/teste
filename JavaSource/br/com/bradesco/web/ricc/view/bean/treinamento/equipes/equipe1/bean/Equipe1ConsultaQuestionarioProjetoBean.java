package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.ConstrutoresFornecedoresVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.UsosFontesVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.service.business.questionarioprojeto.IQuestionarioProjetoService;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.viewhelper.Equipe1ConsultaQuestionarioProjetoViewHelper;

/**
 * @name Equipe1ConsultaQuestionarioProjetoBean
 * @author Equipe 1 - Andr� Nunes, Isaac Maciel, Jo�o Carlos e Jo�o Gil
 * @see Equipe1ConsultaQuestionarioProjetoViewHelper.java
 * @version 1.0
 * @since 11/05/2020
 */
@SessionScoped
@Named(value = "equipe1ConsultaQuestionarioProjetoBean")
public class Equipe1ConsultaQuestionarioProjetoBean extends AbstractBean<Equipe1ConsultaQuestionarioProjetoViewHelper> {

	private static final long serialVersionUID = 8068886362299034108L;
	
	@Inject
	@Named("questionarioProjetoService")
	private IQuestionarioProjetoService questionarioProjetoService;
	
	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;
	
	private String paginaAnterior = "";
	private List<UsosFontesVO> listaTempUsosFontes = new ArrayList<UsosFontesVO>();
	private List<ConstrutoresFornecedoresVO> listaTempConstForn = new ArrayList<ConstrutoresFornecedoresVO>();
	
	@Override
	public String iniciarPagina() {
		setViewHelper(new Equipe1ConsultaQuestionarioProjetoViewHelper());
		viewHelper.inicializar();
		
		return RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE_PROJETO;
	}

	public void carregarDados() {
		//consulta relat�rio
		consultaRelatorioProjeto();

		//consulta estrutura societ�ria
		listarEstruturaSocietaria();
		
		//consulta usos e fontes
		listarUsosFontes();
		
		//consulta fontes
		listarFontes();
		
		//consulta construtores e fornecedores
		listarConstrutoresFornecedores();
		
		//consulta fornecedores
		listarFornecedores();
		
		//consulta coment�rios
		consultaComentarios();
		
		siteUtil.retirarMensagemDuplicada();
	}

	private void consultaComentarios(){
		QuestionarioProjetoVO model = viewHelper.getModel();
		
		try {
			/*
			 * Sequ�ncia de coment�rio
			 * Descri��o do projeto - 1/0
			 * Detalhar fontes de financiamento - 2/1
			 * Status de licenciamento socioambiental - 3/2
			 */
			List<ComentarioVO> _comentarios = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_PROJETOS);
			
			model.setDescProjeto(_comentarios.get(0).getComentario());
			model.setDescFonteFinanStatus(_comentarios.get(1).getComentario());
			model.setDescComentariosStatusLicenciamento(_comentarios.get(2).getComentario());
			
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	private void listarConstrutoresFornecedores() {
		QuestionarioProjetoVO model = viewHelper.getModel(); 
		try {
			model.setListConstrutoresFornecedores(questionarioProjetoService.consultaConstrutoresFornecedores(model, 1));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	private void listarFornecedores() {
		QuestionarioProjetoVO model = viewHelper.getModel(); 
		try {
			model.setListFornecedores(questionarioProjetoService.consultaConstrutoresFornecedores(model, 2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	private void listarUsosFontes() {
		QuestionarioProjetoVO model = viewHelper.getModel(); 

		model.getListUsosFontesSelecionado().clear();
		try {
			model.setListUsosFontes(questionarioProjetoService.consultaQuadroUsosFontes(model, 1));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		if(model.getListUsosFontes().size() != 0){
			model.getUsosFontes().setDtInicio(model.getListUsosFontes().get(0).getDtInicio());
			model.getUsosFontes().setDtTermino(model.getListUsosFontes().get(0).getDtTermino());
		}
	}
	
	private void listarFontes() {
		QuestionarioProjetoVO model = viewHelper.getModel(); 
		try {
			model.setListaFontes(questionarioProjetoService.consultaQuadroUsosFontes(model, 2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		if(model.getListaFontes().size() != 0){
			model.getUsosFontes().setDtInicio(model.getListaFontes().get(0).getDtInicio());
			model.getUsosFontes().setDtTermino(model.getListaFontes().get(0).getDtTermino());
		}
	}
	
	private void listarEstruturaSocietaria() {
		QuestionarioProjetoVO model = viewHelper.getModel(); 

		model.getListEstruturaSocietariaSelecionado().clear();
		model.getListEstruturaSocietaria().clear();
		try {
			model.setListEstruturaSocietaria(questionarioProjetoService.consultaEstruturaSocietaria(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaRelatorioProjeto() {
		QuestionarioProjetoVO model = viewHelper.getModel();
		try {
			QuestionarioProjetoVO modelRetorno = questionarioProjetoService.consultaRelatorioProjeto(model);
			model.setNomeProjeto(modelRetorno.getNomeProjeto());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public String voltar(){
		return paginaAnterior;
	}
	
	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}
	
	public List<UsosFontesVO> getListaTempUsosFontes() {
		return listaTempUsosFontes;
	}

	public void setListaTempUsosFontes(List<UsosFontesVO> listaTempUsosFontes) {
		this.listaTempUsosFontes = listaTempUsosFontes;
	}

	public List<ConstrutoresFornecedoresVO> getListaTempConstForn() {
		return listaTempConstForn;
	}

	public void setListaTempConstForn(
			List<ConstrutoresFornecedoresVO> listaTempConstForn) {
		this.listaTempConstForn = listaTempConstForn;
	}
	
}
