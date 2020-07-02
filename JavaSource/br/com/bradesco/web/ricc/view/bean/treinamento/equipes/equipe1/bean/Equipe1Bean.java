package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.enums.SetorEnum;
import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.RetornoPesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariocorporate.QuadroAtivosCorporateVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariocorporate.QuestionarioCorporateVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.segmento.ConcorrenteVO;
import br.com.bradesco.web.ricc.model.segmento.EndividamentoBancarioVO;
import br.com.bradesco.web.ricc.model.segmento.FormaRecebimentoVO;
import br.com.bradesco.web.ricc.model.segmento.FornecedorVO;
import br.com.bradesco.web.ricc.model.segmento.HighlightsEmpresaVO;
import br.com.bradesco.web.ricc.model.segmento.ImportacoesExportacoesVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.service.business.cadastro.ICadastramentoRicService;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe1.viewhelper.Equipe1ViewHelper;

/**
 * @name Equipe1Bean
 * @author Equipe 1 - André Nunes, Isaac Maciel, João Carlos e João Gil
 * @see Equipe1ViewHelper.java
 * @version 1.0
 * @since 11/05/2020
 */
@SessionScoped
@Named(value = "equipe1Bean")
public class Equipe1Bean extends AbstractBean<Equipe1ViewHelper> {

	private static final long serialVersionUID = 1L;

	private CadastramentoVO cadastramentoVO;
	private PesquisaCadastramentoVO modelPesquisa = new PesquisaCadastramentoVO();
	private RetornoPesquisaCadastramentoVO retornoMainframe;

	@Inject
	@Named("cadastramentoRicService")
	private ICadastramentoRicService cadastramentoRicService;
	
	@Inject
    @Named("segmentoService")
    private ISegmentoService segmentoService;

	@Override
	public String iniciarPagina() {
		this.viewHelper = new Equipe1ViewHelper();
		this.viewHelper.inicializar();
		carregarCadastramentoVO();
		carregarLabels();
		carregarDados();
		return RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE;
	}

	public void carregarCadastramentoVO() {
		retornoMainframe = new RetornoPesquisaCadastramentoVO();
		modelPesquisa.setNumGrupo("9");
		modelPesquisa.setStatus("2");
		modelPesquisa.setTipoPesquisa(2);
		try {
			retornoMainframe = cadastramentoRicService.carregarListaCadastro(modelPesquisa);
			List<CadastramentoVO> listaAuxCadastroVO = (retornoMainframe.getListaCadastro());
			for (CadastramentoVO cadastramentoVO : listaAuxCadastroVO) {
				if (cadastramentoVO.getCodRelatorio() == 563) {
					this.cadastramentoVO = cadastramentoVO;
					break;
				}
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void carregarLabels() {

		CadastramentoVO itemSelecionado = this.cadastramentoVO;
		viewHelper.getModel().setCodRelatorio(itemSelecionado.getCodRelatorio().toString());
		viewHelper.getModel().setCodGrupo(retornoMainframe.getCodGrupo());
		viewHelper.getModel().setNomeGrupo(retornoMainframe.getNomeGrupo());	
		viewHelper.getModel().setNomeRelatorio(cadastramentoVO.getNomeRelatorio());

		
	}
	
	private void carregarDados() {

		if (siteUtil.isNotEmptyOrNull(viewHelper.getModel().getCodRelatorio())) {
			consultaComentarios();
			consultarSegmento();
			listarQuadroAtivos();
			listarQuadroAdm();
			listarFornecedor();
			listarCliente();
			listarFormaRecebimento();
			listarConcorrente();
			listarCarteiraContratos();
			consultaHighlightsEmpresa();
			listarEndividamentoBancario();
			consultaMercadoExterno();
			consultaPerspectivaEmpresa();
			listarSetor();
		}
	}

	private void consultaComentarios() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		// COMENTÁRIOS - CODTIPO(SEQUENCIAIS)

		try {
			// DETALHE SEGMENTO - 1(1,2)
			List<ComentarioVO> comentarioSegmento = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_SEGMENTO);
			model.setDescAtividadeEmpresa(comentarioSegmento.get(0)
					.getComentario());
			model.setOrganogramaControleAcionario(comentarioSegmento.get(1)
					.getComentario());

			// QUADRO ATIVOS - 11(1)
			ComentarioVO comentarioQuadroAtivos = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_QUADRO_ATIVOS).get(0);
			model.setDescQuadroAtivos(comentarioQuadroAtivos.getComentario());

			// QUADRO ADM - 2(1)
			ComentarioVO comentarioQuadroAdm = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_QUADRO_ADM).get(0);
			model.setDescQuadroAdministrativo(comentarioQuadroAdm
					.getComentario());

			// CLIENTE/FORNECEDOR - 5(1,2,3)
			List<ComentarioVO> comentarioClienteFornecedor = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_CLIENTE_FORNECEDOR);

			// SEQUENCIAL 1 - FORNECEDORES
			model.setDescFornecedor(comentarioClienteFornecedor.get(0)
					.getComentario());

			// SEQUENCIAL 2 - FORMA RECEBIMENTO
			model.setDescFormaRecebimento(comentarioClienteFornecedor.get(1)
					.getComentario());

			// SEQUENCIAL 3 - CONCORRENTES
			model.setDescConcorrente(comentarioClienteFornecedor.get(2)
					.getComentario());

			// CARTEIRA 6(1)
			ComentarioVO comentarioCarteira = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_CONTRATOS_CLIENTE)
					.get(0);
			model.setDescCarteira(comentarioCarteira.getComentario());

			// HIGHLIGHTS EMPRESA - 8(1)
			ComentarioVO comentarioHighlightsEmpresa = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_BALANCO_EMPRESA).get(
							0);
			model.setDescSituacaoFinanceira(comentarioHighlightsEmpresa
					.getComentario());

			// ENDIVIDAMENTO BANCARIO - 9(1)
			ComentarioVO comentarioEndividamento = segmentoService
					.consultaComentarios(
							model,
							RiccConstants.TIPO_COMENTARIO_ENDIVIDAMENTO_BANCARIO)
					.get(0);
			model.setDescEndividamentoBancario(comentarioEndividamento
					.getComentario());

			// MERCADO EXTERNO - 12(1,2)
			List<ComentarioVO> comentariosMercadoExterno = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_EXP_CAMBIAL);

			// SEQUENCIAL 1 - PRINCIPAIS PAISES...
			model.setPrincipaisPaisesExportaImporta(comentariosMercadoExterno
					.get(0).getComentario());

			// SEQUENCIAL 2 - DETALHES VARIACAO CAMBIAL
			model.setDetalheProtecaoCambialEmpresa(comentariosMercadoExterno
					.get(1).getComentario());

			// PERSPECTIVA EMPRESA 13(1,2)
			List<ComentarioVO> comentariosPerspectiva = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_PERSPECTIVAS);

			// SEQUENCIAL 1 - DETALHAR ESTRATEGIA
			model.setDetalheEstrategiaProjecao(comentariosPerspectiva.get(0)
					.getComentario());
			// SEQUENCIAL 2 - PRINCIPAIS INVESTIMENTOS
			model.setDetalhePrincipaisInvestimentos(comentariosPerspectiva.get(
					1).getComentario());

			// RECIPROCIDADES 10(1)
			ComentarioVO comentarioReciprocidade = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_RECIPROCIDADE).get(0);
			model.setDescReciprocidades(comentarioReciprocidade.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	private void consultarSegmento() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		try {
			segmentoService.consultaSegmento(model);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void listarQuadroAtivos() {
		QuestionarioCorporateVO model = this.viewHelper.getModel();
		
		model.setListaQuadroAtivos(new ArrayList<QuadroAtivosCorporateVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		try {
			this.viewHelper.getModel().setListaQuadroAtivos(segmentoService.consultaQuadroAtivos(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void listarQuadroAdm() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		
		model.setListaQuadroAdministrativo(new ArrayList<QuadroAdministrativoVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setListaQuadroAdministrativo(segmentoService
					.consultaQuadroAdministrativo(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void listarFornecedor() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		
		model.setListaFornecedor(new ArrayList<FornecedorVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		try {
			model.setListaFornecedor(segmentoService
					.consultaFornecedor(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void listarCliente() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		
		model.setListaCliente(new ArrayList<ClienteVO>());
		
		model.getCliente().setNumSequencial(Numeros.UM.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		try {
			model.setListaCliente(segmentoService.consultaCliente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void listarFormaRecebimento() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		
		model.setListaRecebimento(new ArrayList<FormaRecebimentoVO>());
		
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		model.getRecebimento().setTipoCliente(
				RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);

		try {
			model.setListaRecebimento(segmentoService
					.consultaFormaRecebimento(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void listarConcorrente() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		
		model.setListaConcorrente(new ArrayList<ConcorrenteVO>());
		
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		model.getRecebimento().setTipoCliente(
				RiccConstants.COD_TIPO_CONCORRENTE);

		try {
			model.setListaConcorrente(segmentoService
					.consultaConcorrente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarCarteiraContratos() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		StringBuilder totalContrato = new StringBuilder();
		StringBuilder totalSaldo = new StringBuilder();
		try {
			model.getListaCarteira().clear();
			model.getCarteiraSelecionado().clear();
			model.setListaCarteira(segmentoService
					.consultaCarteiraContratos(model, totalContrato, totalSaldo));
			model.setTotalContrato(totalContrato.toString());
			model.setTotalSaldoContrato(totalSaldo.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaHighlightsEmpresa() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		try {
			StringBuilder builder = new StringBuilder();
			List<HighlightsEmpresaVO> retornoMainframe = segmentoService
					.consultaHighlightsEmpresa(model, builder);
			model.setNomeHighlightsEmpresa(builder.toString());
			model.setBalancoA(retornoMainframe.get(0));
			model.setBalancoB(retornoMainframe.get(1));
			model.setBalancoC(retornoMainframe.get(2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void listarEndividamentoBancario() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		
		model.setListaEndividamento(new ArrayList<EndividamentoBancarioVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			StringBuilder builder = new StringBuilder();
			model.setListaEndividamento(segmentoService
					.consultaEndividamentoBancario(model, builder));
			model.setEndividamentoTotalSaldo(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaMercadoExterno() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			StringBuilder builder = new StringBuilder();
			List<ImportacoesExportacoesVO> retornoMainframe = segmentoService
					.consultaImportacoesExportacoes(model, builder);
			model.setMoedaExportacao(builder.toString());
			model.setVolumeA(retornoMainframe.get(0));
			model.setVolumeB(retornoMainframe.get(1));
			model.setVolumeC(retornoMainframe.get(2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaPerspectivaEmpresa() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setProjecao(segmentoService.consultaPerspectivas(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void listarSetor() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		try {
			model.setListaSetor(segmentoService.consultaSetores(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public String consultarSetor() {
		String retorno = VAZIO;
		try {
			TipoQuestionarioVO setorSelecionadoTabela = viewHelper.getModel().getSetorSelecionado().get(0);
			QuestionarioCorporateVO model = this.viewHelper.getModel();
			Integer codigoSetor = setorSelecionadoTabela.getCodigo().intValue();
			String paginaAnterior = RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_CORPORATE;
			
			if (SetorEnum.AGRONEGOCIO.getCodigo().equals(codigoSetor)) {
				Equipe1ConsultaQuestionarioAgronegocioBean bean = (Equipe1ConsultaQuestionarioAgronegocioBean) FacesUtils
						.getManagedBean(RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_AGRONEGOCIO_BEAN);
				retorno = bean.iniciarPagina();
				bean.setPaginaAnterior(paginaAnterior);
				bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModel().setCodSegmento(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel().setDescGrupo(model.getNomeGrupo());
				bean.carregarDados();
				
			} else if (SetorEnum.IMOBILIARIO.getCodigo().equals(codigoSetor)) {
                Equipe1ConsultaQuestionarioImobiliarioBean bean = (Equipe1ConsultaQuestionarioImobiliarioBean) FacesUtils
                        .getManagedBean(RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_IMOBILIARIO_BEAN);
                bean.setCodGrupoEconomico(viewHelper.getModel().getCodGrupo());
                bean.setDescGrupoEconomico(viewHelper.getModel().getNomeGrupo());
                bean.setCodRelatorio(viewHelper.getModel().getCodRelatorio());
                retorno = bean.iniciarPagina();
                bean.setPaginaAnterior(paginaAnterior);
                bean.getViewHelper().getModel()
                        .setCodGrupoEconomico(model.getCodGrupo());
                bean.getViewHelper()
                        .getModel()
                        .setCodSegmentoRelatorio(
                                model.getCodSegmentoRelatorio());
                bean.getViewHelper().getModel()
                        .setCodRelatorio(model.getCodRelatorio());
                bean.getViewHelper().getModel()
                        .setDescGrupoEconomico(model.getNomeGrupo());
                bean.carregarDados();
				
			} else if (SetorEnum.PROJETOS.getCodigo().equals(codigoSetor)) {
                Equipe1ConsultaQuestionarioProjetoBean bean = (Equipe1ConsultaQuestionarioProjetoBean) FacesUtils
                        .getManagedBean(RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_PROJETO_BEAN);
                retorno = bean.iniciarPagina();
                bean.setPaginaAnterior(paginaAnterior);
                bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
                bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
                bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
                bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
                bean.carregarDados();
				
			} else if (SetorEnum.TRANSPORTE.getCodigo().equals(codigoSetor)) {
                Equipe1ConsultaQuestionarioTransportesBean bean = (Equipe1ConsultaQuestionarioTransportesBean) FacesUtils
                        .getManagedBean(RiccConstants.TREINAMENTO_EQUIPE1_CONSULTA_TRANSPORTES_BEAN);
                retorno = bean.iniciarPagina();
                bean.setPaginaAnterior(paginaAnterior);
                bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
                bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
                bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
                bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
                bean.carregarDados();

            }
			viewHelper.getModel().getSetorSelecionado().clear();
			return retorno;
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		return retorno;
	}
	
	public String voltar() {
        return "nav_index";
    }
}
