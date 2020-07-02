package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe3.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.enums.SetorEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioaltovarejo.QuestionarioAltoVarejoVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.model.segmento.CapacidadeProdutivaVO;
import br.com.bradesco.web.ricc.model.segmento.CarteiraContratosVO;
import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.segmento.ConcorrenteVO;
import br.com.bradesco.web.ricc.model.segmento.DetalhamentoPatrimonioVO;
import br.com.bradesco.web.ricc.model.segmento.EndividamentoBancarioVO;
import br.com.bradesco.web.ricc.model.segmento.FaturamentoConsolidadoVO;
import br.com.bradesco.web.ricc.model.segmento.FormaRecebimentoVO;
import br.com.bradesco.web.ricc.model.segmento.FornecedorVO;
import br.com.bradesco.web.ricc.model.segmento.HighlightsEmpresaVO;
import br.com.bradesco.web.ricc.model.segmento.ImportacoesExportacoesVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe3.viewhelper.Equipe3ConsultaAltoVarejoViewHelper;

@SessionScoped
@Named(value = "equipe3ConsultaQuestionarioAltoVarejoBean")

public class Equipe3ConsultaQuestionarioAltoVarejoBean extends
		AbstractBean<Equipe3ConsultaAltoVarejoViewHelper> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725604575174726605L;
	private Equipe3ConsultaAltoVarejoViewHelper viewHelper = null;

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;

	@Override
	public String iniciarPagina() {
		carregarDados();

		return RiccConstants.TREINAMENTO_EQUIPE_3_CONSULTA;
	}

	public Equipe3ConsultaAltoVarejoViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(Equipe3ConsultaAltoVarejoViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public void carregarDados() {
		listarSegmento();
		listarQuadroAdm();
		listarPatrimonio();
		listarCapacidadeProdutiva();
		listarFornecedor();
		listarCliente();
		listarFormaRecebimento();
		listarConcorrente();
		listarContrato();
		listarFaturamentoConsolidado();
		listarFaturamentoSegmento();
		listarHighlightsEmpresa();
		listarDividas();
		listarMercadoExterno();
		consultaComentarios();
		listarSetor();
	}

	public void listarSegmento() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		try {
			segmentoService.consultaSegmento(model);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarQuadroAdm() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaAdms(new ArrayList<QuadroAdministrativoVO>());

		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setListaAdms(segmentoService
					.consultaQuadroAdministrativo(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarPatrimonio() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaPatrimonio(new ArrayList<DetalhamentoPatrimonioVO>());

		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			StringBuilder builder = new StringBuilder();
			model.setListaPatrimonio(segmentoService
					.consultaDetalhamentoPatrimonio(model, builder));
			model.setTotalPatrimonio(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarCapacidadeProdutiva() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaCapacidade(new ArrayList<CapacidadeProdutivaVO>());
		model.setCapacidadeSelecionado(new ArrayList<CapacidadeProdutivaVO>());
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		StringBuilder totalCapacidade = new StringBuilder();
		StringBuilder totalProducao = new StringBuilder();
		try {
			model.setListaCapacidade(segmentoService
					.consultaCapacidadeProdutiva(model, totalCapacidade,
							totalProducao));
			model.setTotalCapacidade(totalCapacidade.toString());
			model.setTotalProducao(totalProducao.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	public void listarFornecedor() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaFornecedor(new ArrayList<FornecedorVO>());

		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		try {
			model.setListaFornecedor(segmentoService.consultaFornecedor(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarCliente() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaCliente(new ArrayList<ClienteVO>());

		model.getCliente().setNumSequencial(Numeros.UM.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		try {
			model.setListaCliente(segmentoService.consultaCliente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	public void listarFormaRecebimento() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

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

	public void listarConcorrente() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaConcorrentes(new ArrayList<ConcorrenteVO>());

		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		model.getRecebimento().setTipoCliente(
				RiccConstants.COD_TIPO_CONCORRENTE);

		try {
			model.setListaConcorrentes(segmentoService
					.consultaConcorrente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarContrato() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaContrato(new ArrayList<CarteiraContratosVO>());

		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		StringBuilder totalContrato = new StringBuilder();
		StringBuilder totalSaldo = new StringBuilder();
		try {
			model.setListaContrato(segmentoService.consultaCarteiraContratos(
					model, totalContrato, totalSaldo));
			model.setTotalContrato(totalContrato.toString());
			model.setTotalSaldoContrato(totalSaldo.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarFaturamentoConsolidado() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());

		try {
			List<FaturamentoConsolidadoVO> retornoMainframe = segmentoService
					.consultaFaturamentoConsolidado(model);
			model.setFaturamentoA(retornoMainframe.get(0));
			model.setFaturamentoB(retornoMainframe.get(1));
			model.setFaturamentoC(retornoMainframe.get(2));

		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarFaturamentoSegmento() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());

		try {
			model.setFaturamento(segmentoService
					.consultaFaturamentoSegmento(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarHighlightsEmpresa() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());

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

	public void listarDividas() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaDividas(new ArrayList<EndividamentoBancarioVO>());

		model.getRecebimento().setNumSequencial(Numeros.UM.toString());

		try {
			StringBuilder builder = new StringBuilder();
			model.setListaDividas(segmentoService
					.consultaEndividamentoBancario(model, builder));
			model.setTotalSaldo(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarMercadoExterno() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());

		try {
			StringBuilder builder = new StringBuilder();
			List<ImportacoesExportacoesVO> retornoMainframe = segmentoService
					.consultaImportacoesExportacoes(model, builder);
			model.setMoedaExportacao(builder.toString());
			model.setImportacaoExportacaoA(retornoMainframe.get(0));
			model.setImportacaoExportacaoB(retornoMainframe.get(1));
			model.setImportacaoExportacaoC(retornoMainframe.get(2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarReciprocidades() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());

		try {
			model.setVolume(segmentoService.consultaVolumeBradesco(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarCartoes() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());

		try {
			model.setListaCartao(segmentoService.consultaCartoes(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaComentarios() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();
		try {
			// DETALHE SEGMENTO - 1(1,2)
			List<ComentarioVO> comentarioSegmento = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_SEGMENTO);
			model.setDescAtividade(comentarioSegmento.get(0).getComentario());
			model.setDescOrganograma(comentarioSegmento.get(1).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// QUADRO ADM - 2(1)
			List<ComentarioVO> comentarioQuadroAdm = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_QUADRO_ADM);
			model.setDescPlanoSucessao(comentarioQuadroAdm.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// PATRIMONIO - 3(1)
			List<ComentarioVO> comentarioPatrimonio = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_PATRIMONIO);
			model.setComentPatrimonio(comentarioPatrimonio.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// CAPACIDADE PRODUTIVA - 4(1)
			List<ComentarioVO> comentarioCapacidadeProdutiva = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_CAPAC_PRODUTIVA);
			model.setDescCapacidadeProd(comentarioCapacidadeProdutiva.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// CLIENTE/FORNECEDOR - 5(1,2,3)
			List<ComentarioVO> comentarioClienteFornecedor = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_CLIENTE_FORNECEDOR);

			// SEQUENCIAL 1 - FORNECEDORES
			model.setDescFornecedores(comentarioClienteFornecedor.get(0)
					.getComentario());
			// SEQUENCIAL 2 - FORMA RECEBIMENTO
			model.setDescRecebimento(comentarioClienteFornecedor.get(1)
					.getComentario());
			// SEQUENCIAL 3 - CONCORRENTES
			model.setDescConcorrentes(comentarioClienteFornecedor.get(2)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// CARTEIRA 6(1)
			List<ComentarioVO> comentarioCarteira = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_CONTRATOS_CLIENTE);
			model.setDescContrato(comentarioCarteira.get(0).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// FATURAMENTO CONSOLIDADO - 7(1)
			List<ComentarioVO> comentarioHighlightsEmpresa = segmentoService
					.consultaComentarios(
							model,
							RiccConstants.TIPO_COMENTARIO_FATURAMENTO_CONSOLIDADO);
			model.setDescFaturamento(comentarioHighlightsEmpresa.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// HIGHLIGHTS EMPRESA - 8(1)
			List<ComentarioVO> comentarioHighlightsEmpresa = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_BALANCO_EMPRESA);
			model.setDescBalanco(comentarioHighlightsEmpresa.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// ENDIVIDAMENTO BANCARIO - 9(1)
			List<ComentarioVO> comentarioEndividamento = segmentoService
					.consultaComentarios(
							model,
							RiccConstants.TIPO_COMENTARIO_ENDIVIDAMENTO_BANCARIO);
			model.setDescDivida(comentarioEndividamento.get(0).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// RECIPROCIDADES 10(1)
			List<ComentarioVO> comentarioReciprocidade = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_RECIPROCIDADE);
			model.setDescCartao(comentarioReciprocidade.get(0).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarSetor() {
		QuestionarioAltoVarejoVO model = viewHelper.getModel();

		model.setListaSetor(new ArrayList<TipoQuestionarioVO>());

		try {
			model.setListaSetor(segmentoService.consultaSetores(model));
			siteUtil.carregarComboSetor(viewHelper.getComboSetor(),
					model.getListaSetor());
		} catch (RiccException e) {
			if (!e.getMessage().equals(RiccConstants.MAINFRAME_CONSULTA_VAZIA)) {
				BradescoFacesUtils.addErrorModalMessage(e.getCause()
						.getMessage(), null,
						BradescoViewExceptionActionType.ACTION);
			}
		}
	}

	public String consultarSetor() {
		try {
			TipoQuestionarioVO setorSelecionadoTabela = viewHelper.getModel()
					.getSetorSelecionado().get(0);
			QuestionarioAltoVarejoVO model = this.viewHelper.getModel();
			Integer codigoSetor = setorSelecionadoTabela.getCodigo().intValue();
			String retorno = "";
			String paginaAnterior = RiccConstants.TREINAMENTO_EQUIPE_3_CONSULTA;

			if (SetorEnum.AGRONEGOCIO.getCodigo().equals(codigoSetor)) {
				Equipe3AgronegocioBean bean = (Equipe3AgronegocioBean) FacesUtils
						.getManagedBean(RiccConstants.BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO_EQUIPE3);
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModelAgronegocio()
						.setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModelAgronegocio()
						.setCodSegmento(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModelAgronegocio()
						.setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModelAgronegocio()
						.setDescGrupo(model.getNomeGrupo());
				bean.carregarDados();
				bean.setPaginaAnterior(paginaAnterior);

			} else if (SetorEnum.IMOBILIARIO.getCodigo().equals(codigoSetor)) {
				Equipe3ConsultaQuestionarioImobiliarioBean bean = (Equipe3ConsultaQuestionarioImobiliarioBean) FacesUtils
						.getManagedBean("equipe3ConsultaQuestionarioImobiliarioBean");
				retorno = bean.iniciarPagina();
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
				bean.setPaginaAnterior(paginaAnterior);

			} else if (SetorEnum.PROJETOS.getCodigo().equals(codigoSetor)) {
				Equipe3ProjetoBean bean = (Equipe3ProjetoBean) FacesUtils
						.getManagedBean(RiccConstants.BEAN_CONSULTA_QUESTIONARIO_PROJETOS_EQUIPE3);
				retorno = bean.iniciarPagina();

				bean.getViewHelper().getModel()
						.setCodGrupo(model.getCodGrupo());
				bean.getViewHelper()
						.getModel()
						.setCodSegmentoRelatorio(
								model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel()
						.setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel()
						.setNomeGrupo(model.getNomeGrupo());
				bean.carregarDados();
				bean.setPaginaAnterior(paginaAnterior);

			} else if (SetorEnum.TRANSPORTE.getCodigo().equals(codigoSetor)) {
				Equipe3TransportesBean bean = (Equipe3TransportesBean) FacesUtils
						.getManagedBean(RiccConstants.BEAN_CONSULTA_QUESTIONARIO_TRANSPORTE_EQUIPE3);
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModel()
						.setCodGrupo(model.getCodGrupo());
				bean.getViewHelper()
						.getModel()
						.setCodSegmentoRelatorio(
								model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel()
						.setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel()
						.setNomeGrupo(model.getNomeGrupo());
				bean.carregarDados();
				bean.setPaginaAnterior(paginaAnterior);

			}
			viewHelper.getModel().getSetorSelecionado().clear();
			return retorno;
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		return VAZIO;
	}

	public String voltar() {
		return "nav_index";
	}
}
