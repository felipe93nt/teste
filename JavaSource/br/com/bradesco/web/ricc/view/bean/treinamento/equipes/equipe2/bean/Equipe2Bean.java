package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe2.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.enums.SetorEnum;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioempresas.QuestionarioEmpresasVO;
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
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean.ConsultaQuestionarioAgronegocioBean;
import br.com.bradesco.web.ricc.view.bean.questionarioprojetos.bean.ConsultaQuestionarioProjetoBean;
import br.com.bradesco.web.ricc.view.bean.questionariotransportes.bean.ConsultaQuestionarioTransportesBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe2.viewhelper.Equipe2ViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Foursys
 * @see Equipe2Bean.java
 * @version 1.0
 * @since 11/05/2020
 */
@SessionScoped
@Named(value = "equipe2Bean")
public class Equipe2Bean extends
		AbstractBean<Equipe2ViewHelper> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -703704182033539022L;

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;
	private String paginaInicial = "nav_index";
	
	@Override
    public String iniciarPagina() {
        setViewHelper(new Equipe2ViewHelper());
        viewHelper.inicializar();
        viewHelper
                .receberParametros(
                        RiccConstants.TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2_CODGRUPO,
                        RiccConstants.TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2_NOMEGRUPO,
                        RiccConstants.TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2_CODRELATORIO);
        carregarDados();
        return RiccConstants.TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2;
    }
	
	private void carregarDados() {

		if (siteUtil.isNotEmptyOrNull(viewHelper.getModel().getCodRelatorio())) {
			consultaComentarios();
			consultarSegmento();
			listarQuadroAdm();
			listarPatrimonio();
			listarCapacidadeProdutiva();
			listarFornecedor();
			listarCliente();
			listarFormaRecebimento();
			listarConcorrente();
			listarCarteiraContratos();
			consultaFaturamentoConsolidado();
			consultarFaturamentoSegmento();
			consultaHighlightsEmpresa();
			listarEndividamentoBancario();
			consultaMercadoExterno();
			consultaPerspectivaEmpresa();
			listarSetor();
		}
	}


	private void consultaComentarios() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		try {
			// DETALHE SEGMENTO - 1(1,2)
			List<ComentarioVO> comentarioSegmento = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_SEGMENTO);
			model.setDescAtividadeEmpresa(comentarioSegmento.get(0)
					.getComentario());
			model.setOrganogramaControleAcionario(comentarioSegmento.get(1)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// QUADRO ADM - 2(1)
			List<ComentarioVO> comentarioQuadroAdm = segmentoService.consultaComentarios(
					model, RiccConstants.TIPO_COMENTARIO_QUADRO_ADM);
			model.setDescQuadroAdministrativo(comentarioQuadroAdm.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// PATRIMONIO - 3(1)
			List<ComentarioVO> comentarioPatrimonio = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_PATRIMONIO);
			model.setDescDetalhamentoPatrimonio(comentarioPatrimonio.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// CAPACIDADE PRODUTIVA - 4(1)
			List<ComentarioVO> comentarioCapacidadeProdutiva = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_CAPAC_PRODUTIVA);
				model.setDescCapacidadeProdutiva(comentarioCapacidadeProdutiva
						.get(0).getComentario());
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
			model.setDescConcorrente(comentarioClienteFornecedor.get(2)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		try {
			// CARTEIRA 6(1)
			List<ComentarioVO> comentarioCarteira = segmentoService.consultaComentarios(
					model, RiccConstants.TIPO_COMENTARIO_CONTRATOS_CLIENTE);
				model.setDescCarteira(comentarioCarteira.get(0).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// HIGHLIGHTS EMPRESA - 8(1)
			List<ComentarioVO> comentarioHighlightsEmpresa = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_BALANCO_EMPRESA);
			model.setDescFaturamento(comentarioHighlightsEmpresa.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		try {
			// ENDIVIDAMENTO BANCARIO - 9(1)
			List<ComentarioVO> comentarioEndividamento = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_ENDIVIDAMENTO_BANCARIO);
			model.setDescEndividamentoBancario(comentarioEndividamento.get(
					0).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// MERCADO EXTERNO - 12(1,2)
			List<ComentarioVO> comentariosMercadoExterno = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_EXP_CAMBIAL);
		
			// SEQUENCIAL 1 - PRINCIPAIS PAISES...
			model.setPaisesExportaImporta(comentariosMercadoExterno.get(0)
					.getComentario());
			// SEQUENCIAL 2 - DETALHES VARIACAO CAMBIAL
			model.setDetalheProtecaoCambialEmpresa(comentariosMercadoExterno
					.get(1).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// PERSPECTIVA EMPRESA 13(1,2)
			List<ComentarioVO> comentariosPerspectiva = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_PERSPECTIVAS);
			
		
			// SEQUENCIAL 1 - DETALHAR ESTRATEGIA
			model.setDetalheEstrategiaProjecao(comentariosPerspectiva
					.get(0).getComentario());
			// SEQUENCIAL 2 - PRINCIPAIS INVESTIMENTOS
			model.setDetalheInvestimentosConcluidosPlanejados(comentariosPerspectiva
					.get(1).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// RECIPROCIDADES 10(1)
			List<ComentarioVO> comentarioReciprocidade = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_RECIPROCIDADE);
			model.setDescReciprocidades(comentarioReciprocidade.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultarSegmento() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		try {
			segmentoService.consultaSegmento(model);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void listarQuadroAdm() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
		model.setListaQuadroAdministrativo(new ArrayList<QuadroAdministrativoVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setListaQuadroAdministrativo(segmentoService
					.consultaQuadroAdministrativo(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void listarPatrimonio() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
		model.setListaDetalhamentoPatrimonio(new ArrayList<DetalhamentoPatrimonioVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			StringBuilder builder = new StringBuilder();
			model.setListaDetalhamentoPatrimonio(segmentoService
					.consultaDetalhamentoPatrimonio(model, builder));
			model.setValorTotalPatrimonio(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	public void listarCapacidadeProdutiva() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
		model.setListaCapacidadeProdutiva(new ArrayList<CapacidadeProdutivaVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCapacidadeProdutivaSelecionado().clear();
		model.getListaCapacidadeProdutiva().clear();
		
		StringBuilder totalCapacidade = new StringBuilder();
		StringBuilder totalProducao = new StringBuilder();
		try {
			model.setListaCapacidadeProdutiva(segmentoService
					.consultaCapacidadeProdutiva(model, totalCapacidade, totalProducao));
			model.setTotalCapacidade(totalCapacidade.toString());
			model.setTotalProducao(totalProducao.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	private void listarFornecedor() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
		model.setListaFornecedores(new ArrayList<FornecedorVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		try {
			model.setListaFornecedores(segmentoService
					.consultaFornecedor(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void listarCliente() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
		model.setListaClientes(new ArrayList<ClienteVO>());
		
		model.getCliente().setNumSequencial(Numeros.UM.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		try {
			model.setListaClientes(segmentoService.consultaCliente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void listarFormaRecebimento() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
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
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
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
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
		model.setListaCarteira(new ArrayList<CarteiraContratosVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getListaCarteira().clear();
		model.getCarteiraSelecionado().clear();
		StringBuilder totalContrato = new StringBuilder();
		StringBuilder totalSaldo = new StringBuilder();
		try {
			model.setListaCarteira(segmentoService
					.consultaCarteiraContratos(model, totalContrato, totalSaldo));
			model.setTotalContrato(totalContrato.toString());
			model.setTotalSaldoContrato(totalSaldo.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void consultaFaturamentoConsolidado() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		try {

			List<FaturamentoConsolidadoVO> retornoMainframe = segmentoService
					.consultaFaturamentoConsolidado(model);
			model.setFaturamentoConsolidadoA(retornoMainframe.get(0));
			model.setFaturamentoConsolidadoB(retornoMainframe.get(1));
			model.setFaturamentoConsolidadoC(retornoMainframe.get(2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void consultarFaturamentoSegmento() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setFaturamentoSegmento(segmentoService
					.consultaFaturamentoSegmento(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void consultaHighlightsEmpresa() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		try {
			StringBuilder builder = new StringBuilder();
			List<HighlightsEmpresaVO> retornoMainframe = segmentoService
					.consultaHighlightsEmpresa(model, builder);
			model.setNomeHighlightsEmpresa(builder.toString());
			model.setHighlightsA(retornoMainframe.get(0));
			model.setHighlightsB(retornoMainframe.get(1));
			model.setHighlightsC(retornoMainframe.get(2));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void listarEndividamentoBancario() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		
		model.setListaEndividamentoBancario(new ArrayList<EndividamentoBancarioVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			StringBuilder builder = new StringBuilder();
			model.setListaEndividamentoBancario(segmentoService
					.consultaEndividamentoBancario(model, builder));
			model.setTotalSaldoEndividamentoBancario(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	private void consultaMercadoExterno() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
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
		QuestionarioEmpresasVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setPerspectiva(segmentoService.consultaPerspectivas(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

//	private void consultaReciprocidades() {
//		QuestionarioEmpresasVO model = viewHelper.getModel();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
//
//		try {
//			model.setVolumeBradesco(segmentoService
//					.consultaVolumeBradesco(model));
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//		
//	}
//
//	private void listarCartoes() {
//		QuestionarioEmpresasVO model = viewHelper.getModel();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
//
//		try {
//			model.setListaCartao(segmentoService.consultaCartoes(model));
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//		
//	}

	private void listarSetor() {
		QuestionarioEmpresasVO model = viewHelper.getModel();
		try {
			model.setListaSetor(segmentoService.consultaSetores(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}
	
	public String consultarSetor() {
        try {
            TipoQuestionarioVO setorSelecionadoTabela = viewHelper.getModel().getSetorSelecionado().get(0);
            QuestionarioEmpresasVO model = this.viewHelper.getModel();
            Integer codigoSetor = setorSelecionadoTabela.getCodigo().intValue();
            String retorno = "";
            String paginaAnterior = RiccConstants.TELA_CONSULTA_QUESTIONARIO_EMPRESAS_EQUIPE2;
            
            if (SetorEnum.AGRONEGOCIO.getCodigo().equals(codigoSetor)) {
                ConsultaQuestionarioAgronegocioBean bean = (ConsultaQuestionarioAgronegocioBean) FacesUtils
                        .getManagedBean(RiccConstants.BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO);
                retorno = bean.iniciarPagina();
                bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
                bean.getViewHelper().getModel().setCodSegmento(model.getCodSegmentoRelatorio());
                bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
                bean.getViewHelper().getModel().setDescGrupo(model.getNomeGrupo());
                bean.carregarDados();
                bean.setPaginaAnterior(paginaAnterior);
                
            } else if (SetorEnum.IMOBILIARIO.getCodigo().equals(codigoSetor)) {
                Equipe2ConsultaQuestionarioImobiliarioBean bean = (Equipe2ConsultaQuestionarioImobiliarioBean) FacesUtils
                        .getManagedBean(RiccConstants.BEAN_CONSULTA_QUESTIONARIO_IMOBILIARIO_EQUIPE2);
                
                retorno = bean.iniciarPagina();
                bean.setPaginaAnterior(paginaAnterior);
                
            } else if (SetorEnum.PROJETOS.getCodigo().equals(codigoSetor)) {
                ConsultaQuestionarioProjetoBean bean = (ConsultaQuestionarioProjetoBean) FacesUtils
                        .getManagedBean(RiccConstants.BEAN_CONSULTA_QUESTIONARIO_PROJETOS);
                retorno = bean.iniciarPagina();
                bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
                bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
                bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
                bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
                bean.carregarDados();
                bean.setPaginaAnterior(paginaAnterior);
                
            } else if (SetorEnum.TRANSPORTE.getCodigo().equals(codigoSetor)) {
                ConsultaQuestionarioTransportesBean bean = (ConsultaQuestionarioTransportesBean) FacesUtils
                        .getManagedBean(RiccConstants.BEAN_CONSULTA_QUESTIONARIO_TRANSPORTES);
                retorno = bean.iniciarPagina();
                bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
                bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
                bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
                bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
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
        return paginaInicial;
    }


}
