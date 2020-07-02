package br.com.bradesco.web.ricc.view.bean.questionarioempresas.bean;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.BeanUtils;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.enums.ComentarioEnum;
import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.enums.SetorEnum;
import br.com.bradesco.web.ricc.enums.SituacaoRelatorioEnum;
import br.com.bradesco.web.ricc.enums.TipoFuncaoEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioempresas.QuestionarioEmpresasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.model.segmento.CapacidadeProdutivaVO;
import br.com.bradesco.web.ricc.model.segmento.CartaoVO;
import br.com.bradesco.web.ricc.model.segmento.CarteiraContratosVO;
import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.segmento.ConcorrenteVO;
import br.com.bradesco.web.ricc.model.segmento.DetalhamentoPatrimonioVO;
import br.com.bradesco.web.ricc.model.segmento.EndividamentoBancarioVO;
import br.com.bradesco.web.ricc.model.segmento.FaturamentoConsolidadoVO;
import br.com.bradesco.web.ricc.model.segmento.FaturamentoPorSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.FormaRecebimentoVO;
import br.com.bradesco.web.ricc.model.segmento.FornecedorVO;
import br.com.bradesco.web.ricc.model.segmento.HighlightsEmpresaVO;
import br.com.bradesco.web.ricc.model.segmento.ImportacoesExportacoesVO;
import br.com.bradesco.web.ricc.model.segmento.LinhaSegmentoVO;
import br.com.bradesco.web.ricc.model.segmento.PerspectivasVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.model.segmento.VolumeBradescoVO;
import br.com.bradesco.web.ricc.service.business.questionarioempresas.IEmpresasService;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.RiccMessages;
import br.com.bradesco.web.ricc.utils.SiteUtil;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.cadastro.bean.CadastramentoRicBean;
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean.QuestionarioAgronegocioBean;
import br.com.bradesco.web.ricc.view.bean.questionarioempresas.viewhelper.QuestionarioEmpresasViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.bean.QuestionarioImobiliarioBean;
import br.com.bradesco.web.ricc.view.bean.questionarioprojetos.bean.QuestionarioProjetoBean;
import br.com.bradesco.web.ricc.view.bean.questionariotransportes.bean.QuestionarioTransportesBean;

@SessionScoped
@Named(value = "questionarioEmpresasBean")
public class QuestionarioEmpresasBean extends AbstractBean<QuestionarioEmpresasViewHelper> {

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;

	@Inject
	@Named("empresasService")
	private IEmpresasService empresasService;
	
	private ArrayList<String> mensagens = new ArrayList<String>();

	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	@Override
	public String iniciarPagina() {
		setViewHelper(new QuestionarioEmpresasViewHelper());
		viewHelper.inicializar();
		if (viewHelper.getQuestionarioEmpresasVO().getListaSetor().isEmpty()) {
			viewHelper.setComboSetor(siteUtil.carregarListaSetor());
		}
		viewHelper.getQuestionarioEmpresasVO().setCodSegmentoRelatorio(
				String.valueOf(SegmentoEnum.EMPRESAS.getCodigo()));
		
//		parametrizacaoManual();
//		carregarDados();
		try {
			carregarCopiaLista();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
		
		siteUtil.retirarMensagemDuplicada();
		return RiccConstants.TELA_QUESTIONARIO_EMPRESAS;
	}

	public void carregarDados() {
		
		if (siteUtil.isNotEmptyOrNull(viewHelper.getQuestionarioEmpresasVO()
				.getCodRelatorio())) {
			
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
			consultaComentarios();
		}
	}
	
	public void carregarCopiaLista() throws IllegalAccessException, InvocationTargetException {
		copiarQuadroAdm();
		copiarDetalhamentoPatrimonio();
		copiarCapacidadeProdutiva();
		copiarFornecedor();
		copiarCliente();
		copiarFormaRecebimento();
		copiarConcorrente();
		copiarContrato();
		copiarDividas();
	}

	public void parametrizacaoManual() {
		viewHelper.getQuestionarioEmpresasVO().setCodGrupo("71");
		viewHelper.getQuestionarioEmpresasVO().setNomeGrupo("CASTROL");
		viewHelper.getQuestionarioEmpresasVO().setCodRelatorio("1");
	}

	public String salvar() {
		
		if(!validarAnosIguais()){
			return "";
		}
		
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		try {
			quadroAdministrativo();
			detalhamentoPatrimonio();
			capacidadeProdutiva();
			fornecedores();
			clientes();
			recebimento();
			concorrentes();
			contrato();
			divida();
			
			salvarFaturamentoConsolidado();
			salvarHighlightsEmpresa();
			salvarMercadoExterno();
			salvarPerspectivaEmpresa();
			salvarFaturamentoSegmento();
			manutencaoComentarios();
			manutencaoSegmento(TipoFuncaoEnum.SALVAR,
					SituacaoRelatorioEnum.PENDENTE);
			
			if(mensagens.size() == 0){
				RiccMessages.getInstance().getMsgSalvarSucesso();
			}
			mensagens.clear();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		return "";
	}

	public String concluir() {
		
		if(!validarAnosIguais()){
			return "";
		}
		
		try{
			if (validarCamposObrigatorios()) {
				
				quadroAdministrativo();
				detalhamentoPatrimonio();
				capacidadeProdutiva();
				fornecedores();
				clientes();
				recebimento();
				concorrentes();
				contrato();
				divida();
				
				salvarFaturamentoConsolidado();
				salvarHighlightsEmpresa();
				salvarMercadoExterno();
				salvarPerspectivaEmpresa();
				salvarFaturamentoSegmento();
				manutencaoComentarios();
				manutencaoSegmento(TipoFuncaoEnum.CONCLUIR,
						SituacaoRelatorioEnum.ATIVO);
				
				siteUtil.getMessages().getMsgConcluirSucessoFowardCadastramento();
				
				return voltar();
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		return null;
	}
	
	public void manutencaoComentarios() throws RiccException {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		
		manutencaoComentarioSegmento(model);
		manutencaoComentarioQuadroAdm(model);
		manutencaoComentarioPatrimonio(model);
		manutencaoComentarioCapacidadeProdutiva(model);
		manutencaoComentariosFornecedor(model);
		manutencaoComentarioCarteira(model);
		manutencaoComentarioHighlights(model);
		manutencaoComentarioEndividamento(model);
		manutencaoComentarioMercadoExterno(model);
		manutencaoComentarioPerspectiva(model);
		manutencaoComentarioReciprocidade(model);
	}

	private void manutencaoComentarioReciprocidade(QuestionarioEmpresasVO model) {
		List<ComentarioVO> reciprocidade = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO(
				ComentarioEnum.RECIPROCIDADES.getCodigo(),
				ComentarioEnum.RECIPROCIDADES.getNumSequencial(),
				model.getDescReciprocidades());
		reciprocidade.add(comentario);
		segmentoService.manutencaoComentarios(model, reciprocidade,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioPerspectiva(QuestionarioEmpresasVO model) {
		List<ComentarioVO> perspectiva = new ArrayList<ComentarioVO>();
		ComentarioVO paises = new ComentarioVO(
				ComentarioEnum.DETALHE_ESTRATEGIA.getCodigo(),
				ComentarioEnum.DETALHE_ESTRATEGIA.getNumSequencial(),
				model.getDetalheEstrategiaProjecao());
		perspectiva.add(paises);
		ComentarioVO protecaoCambial = new ComentarioVO(
				ComentarioEnum.PRINCIPAIS_INVESTIMENTOS.getCodigo(),
				ComentarioEnum.PRINCIPAIS_INVESTIMENTOS.getNumSequencial(),
				model.getDetalheInvestimentosConcluidosPlanejados());
		perspectiva.add(protecaoCambial);
		segmentoService.manutencaoComentarios(model, perspectiva,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioMercadoExterno(QuestionarioEmpresasVO model) {
		List<ComentarioVO> mercadoExterno = new ArrayList<ComentarioVO>();
		ComentarioVO paises = new ComentarioVO(
				ComentarioEnum.PAISES_EXPORTACAO.getCodigo(),
				ComentarioEnum.PAISES_EXPORTACAO.getNumSequencial(),
				model.getPaisesExportaImporta());
		mercadoExterno.add(paises);
		ComentarioVO protecaoCambial = new ComentarioVO(
				ComentarioEnum.PROTECAO_CAMBIAL.getCodigo(),
				ComentarioEnum.PROTECAO_CAMBIAL.getNumSequencial(),
				model.getDetalheProtecaoCambialEmpresa());
		mercadoExterno.add(protecaoCambial);
		segmentoService.manutencaoComentarios(model, mercadoExterno,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioEndividamento(QuestionarioEmpresasVO model) {
			List<ComentarioVO> endividamento = new ArrayList<ComentarioVO>();
			ComentarioVO comentario = new ComentarioVO(
					ComentarioEnum.ENDIVIDAMENTO_BANCARIO.getCodigo(),
					ComentarioEnum.ENDIVIDAMENTO_BANCARIO.getNumSequencial(),
					model.getDescEndividamentoBancario());
			endividamento.add(comentario);
			segmentoService.manutencaoComentarios(model, endividamento,
					TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioHighlights(QuestionarioEmpresasVO model) {
		List<ComentarioVO> highlights = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO(
				ComentarioEnum.HIGHLIGHTS_EMPRESA.getCodigo(),
				ComentarioEnum.HIGHLIGHTS_EMPRESA.getNumSequencial(),
				model.getDescFaturamento());
		highlights.add(comentario);
		segmentoService.manutencaoComentarios(model, highlights,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioCarteira(QuestionarioEmpresasVO model) {
		List<ComentarioVO> carteira = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO(
				ComentarioEnum.CARTEIRA.getCodigo(),
				ComentarioEnum.CARTEIRA.getNumSequencial(),
				model.getDescCarteira());
		carteira.add(comentario);
		segmentoService.manutencaoComentarios(model, carteira,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentariosFornecedor(QuestionarioEmpresasVO model) {
		List<ComentarioVO> clienteFornecedor = new ArrayList<ComentarioVO>();
		ComentarioVO fornecedor = new ComentarioVO(
				ComentarioEnum.FORNECEDORES.getCodigo(),
				ComentarioEnum.FORNECEDORES.getNumSequencial(),
				model.getDescFornecedores());
		ComentarioVO formaRecebimento = new ComentarioVO(
				ComentarioEnum.FORMA_RECEBIMENTO.getCodigo(),
				ComentarioEnum.FORMA_RECEBIMENTO.getNumSequencial(),
				model.getDescRecebimento());
		ComentarioVO concorrente = new ComentarioVO(
				ComentarioEnum.CONCORRENTES.getCodigo(),
				ComentarioEnum.CONCORRENTES.getNumSequencial(),
				model.getDescConcorrente());
		clienteFornecedor.add(fornecedor);
		clienteFornecedor.add(formaRecebimento);
		clienteFornecedor.add(concorrente);
		segmentoService.manutencaoComentarios(model, clienteFornecedor,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioCapacidadeProdutiva(
			QuestionarioEmpresasVO model) {
		List<ComentarioVO> capacidade = new ArrayList<ComentarioVO>();
		ComentarioVO capacidadeProdutiva = new ComentarioVO(
				ComentarioEnum.CAPACIDADE_PRODUTIVA.getCodigo(),
				ComentarioEnum.CAPACIDADE_PRODUTIVA.getNumSequencial(),
				model.getDescCapacidadeProdutiva());
		capacidade.add(capacidadeProdutiva);
		segmentoService.manutencaoComentarios(model, capacidade,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioPatrimonio(QuestionarioEmpresasVO model) {
		List<ComentarioVO> detalhamentoPatrimonio = new ArrayList<ComentarioVO>();
		ComentarioVO patrimonio = new ComentarioVO(
				ComentarioEnum.PATRIMONIO.getCodigo(),
				ComentarioEnum.PATRIMONIO.getNumSequencial(),
				model.getDescDetalhamentoPatrimonio());
		detalhamentoPatrimonio.add(patrimonio);
		segmentoService.manutencaoComentarios(model, detalhamentoPatrimonio,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioQuadroAdm(QuestionarioEmpresasVO model) {
		List<ComentarioVO> quadroAdm = new ArrayList<ComentarioVO>();
		ComentarioVO planoSucessao = new ComentarioVO(
				ComentarioEnum.PLANO_SUCESSAO.getCodigo(),
				ComentarioEnum.PLANO_SUCESSAO.getNumSequencial(),
				model.getDescQuadroAdministrativo());
		quadroAdm.add(planoSucessao);
		segmentoService.manutencaoComentarios(model, quadroAdm,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	private void manutencaoComentarioSegmento(QuestionarioEmpresasVO model) {
		List<ComentarioVO> segmento = new ArrayList<ComentarioVO>();
		ComentarioVO atividadeEmpresa = new ComentarioVO(
				ComentarioEnum.ATIVIDADES_EMPRESA.getCodigo(),
				ComentarioEnum.ATIVIDADES_EMPRESA.getNumSequencial(),
				model.getDescAtividadeEmpresa());
		segmento.add(atividadeEmpresa);
		ComentarioVO organograma = new ComentarioVO(
				ComentarioEnum.ORGANOGRAMA_EMPRESA.getCodigo(),
				ComentarioEnum.ORGANOGRAMA_EMPRESA.getNumSequencial(),
				model.getOrganogramaControleAcionario());
		segmento.add(organograma);
		segmentoService.manutencaoComentarios(model, segmento,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}

	public void consultarSegmento() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		try {
			segmentoService.consultaSegmento(model);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void manutencaoSegmento(TipoFuncaoEnum tipoFuncao,
			SituacaoRelatorioEnum situacaoRelatorio) throws RiccException {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		segmentoService.manutencaoRelatorioInfoCredito(model, tipoFuncao,
				situacaoRelatorio, SegmentoEnum.EMPRESAS);
		segmentoService.manutencaoRelatorioSegmento(model, TipoManutencaoEnum.ALTERACAO);
	}
	
	public void listarQuadroAdm() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setListaQuadroAdministrativo(new ArrayList<QuadroAdministrativoVO>());
		model.setQuadroAdministrativoSelecionado(new ArrayList<QuadroAdministrativoVO>());
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setListaQuadroAdministrativo(segmentoService
					.consultaQuadroAdministrativo(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaQuadroAdministrativo().size() < Numeros.CINCO){
			model.getListaQuadroAdministrativo().add(new QuadroAdministrativoVO());
		}
		try {
			copiarQuadroAdm();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarQuadroAdm() throws IllegalAccessException, InvocationTargetException{
		ArrayList<QuadroAdministrativoVO> listaCopia = new ArrayList<QuadroAdministrativoVO>();
		QuadroAdministrativoVO voCopia = null;
		for (QuadroAdministrativoVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaQuadroAdministrativo()) {
			voCopia = new QuadroAdministrativoVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getAdministrador())){
				voCopia.setAdministrador("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getCargo())){
				voCopia.setCargo("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaQuadroAdministrativo(listaCopia);
	}
	
	public void quadroAdministrativo() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (QuadroAdministrativoVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaQuadroAdministrativo()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaQuadroAdministrativo().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getAdministrador())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCargo())) {
					try {
						segmentoService.manutencaoQuadroAdministrativo(model, itemTabela, 
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getAdministrador())
						&& siteUtil.isEmptyOrNull(itemTabela.getCargo())) {
					try {
						segmentoService.manutencaoQuadroAdministrativo(model, itemTabela, 
								RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaQuadroAdministrativo().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoQuadroAdministrativo(model, itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarQuadroAdm();
	}

	public void incluirQuadroAdm() {
		QuestionarioEmpresasVO model = getViewHelper()
				.getQuestionarioEmpresasVO();
		if (validarCamposQuadroAdm()) {

			model.setCodSegmentoRelatorio(Numeros.UM.toString());
			model.getQuadroAdministrativo().setNumSequencial(
					Numeros.ZERO.toString());

			try {
				segmentoService.manutencaoQuadroAdministrativo(model,
						model.getQuadroAdministrativo(),
						RiccConstants.MANUTENCAO_INCLUSAO);
//				siteUtil.getMessages().getMsgInclusaoSucesso();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}

		}
		model.setQuadroAdministrativo(new QuadroAdministrativoVO());
		listarQuadroAdm();
	}

	public void excluirQuadroAdm() {
		QuestionarioEmpresasVO model = getViewHelper()
				.getQuestionarioEmpresasVO();
		QuadroAdministrativoVO itemSelecionado = model
				.getQuadroAdministrativoSelecionado().get(0);

		try {
			segmentoService.manutencaoQuadroAdministrativo(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		listarQuadroAdm();
	}

	public void listarPatrimonio() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.setListaDetalhamentoPatrimonio(new ArrayList<DetalhamentoPatrimonioVO>());
		model.setValorTotalPatrimonio("");
		model.getDetalhamentoPatrimonioSelecionado().clear();
		try {
			StringBuilder builder = new StringBuilder();
			model.setListaDetalhamentoPatrimonio(segmentoService
					.consultaDetalhamentoPatrimonio(model, builder));
			model.setValorTotalPatrimonio(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaDetalhamentoPatrimonio().size() < Numeros.DEZ){
			model.getListaDetalhamentoPatrimonio().add(new DetalhamentoPatrimonioVO());
		}
		try {
			copiarDetalhamentoPatrimonio();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarDetalhamentoPatrimonio() throws IllegalAccessException, InvocationTargetException{
		ArrayList<DetalhamentoPatrimonioVO> listaCopia = new ArrayList<DetalhamentoPatrimonioVO>();
		DetalhamentoPatrimonioVO voCopia = null;
		for (DetalhamentoPatrimonioVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaDetalhamentoPatrimonio()) {
			voCopia = new DetalhamentoPatrimonioVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getPatrimonio())){
				voCopia.setPatrimonio("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getValorPatrimonio())){
				voCopia.setValorPatrimonio("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaDetalhamentoPatrimonio(listaCopia);
	}
	
	public void detalhamentoPatrimonio() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (DetalhamentoPatrimonioVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaDetalhamentoPatrimonio()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaDetalhamentoPatrimonio().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getSequencialPatrimonio()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getPatrimonio())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getValorPatrimonio())) {
					try {
						segmentoService.manutencaoDetalhamentoPatrimonio(model, itemTabela, 
								TipoManutencaoEnum.INCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getSequencialPatrimonio()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getPatrimonio())
						&& siteUtil.isEmptyOrNull(itemTabela.getValorPatrimonio())) {
					try {
						segmentoService.manutencaoDetalhamentoPatrimonio(model, itemTabela, 
								TipoManutencaoEnum.EXCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getSequencialPatrimonio() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaDetalhamentoPatrimonio().get(contador).getSequencialPatrimonio()){
					try {
						segmentoService.manutencaoDetalhamentoPatrimonio(model, itemTabela, 
								TipoManutencaoEnum.INCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarPatrimonio();
	}

	public void incluirPatrimonio() {
		QuestionarioEmpresasVO model = getViewHelper()
				.getQuestionarioEmpresasVO();

		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getDetalhamentoPatrimonio().setSequencialPatrimonio(
				Numeros.ZERO.toString());

		try {
			segmentoService.manutencaoDetalhamentoPatrimonio(model,
					model.getDetalhamentoPatrimonio(),
					RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setDetalhamentoPatrimonio(new DetalhamentoPatrimonioVO());
		model.getDetalhamentoPatrimonioSelecionado().clear();
		listarPatrimonio();
	}

	public void excluirPatrimonio() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		DetalhamentoPatrimonioVO itemSelecionado = model
				.getDetalhamentoPatrimonioSelecionado().get(0);

		try {
			segmentoService.manutencaoDetalhamentoPatrimonio(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		listarPatrimonio();
	}

	public void listarCapacidadeProdutiva() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCapacidadeProdutivaSelecionado().clear();
		model.setListaCapacidadeProdutiva(new ArrayList<CapacidadeProdutivaVO>());
		
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
		while(model.getListaCapacidadeProdutiva().size() < Numeros.DEZ){
			model.getListaCapacidadeProdutiva().add(new CapacidadeProdutivaVO());
		}
		try {
			copiarCapacidadeProdutiva();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarCapacidadeProdutiva() throws IllegalAccessException, InvocationTargetException{
		ArrayList<CapacidadeProdutivaVO> listaCopia = new ArrayList<CapacidadeProdutivaVO>();
		CapacidadeProdutivaVO voCopia = null;
		for (CapacidadeProdutivaVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaCapacidadeProdutiva()) {
			voCopia = new CapacidadeProdutivaVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getPlantas())){
				voCopia.setPlantas("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getProducao())){
				voCopia.setProducao("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getUtilizada())){
				voCopia.setUtilizada("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getUtilizacaoPercentual())){
				voCopia.setUtilizacaoPercentual("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaCapacidadeProdutiva(listaCopia);
	}
	
	public void capacidadeProdutiva() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (CapacidadeProdutivaVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaCapacidadeProdutiva()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaCapacidadeProdutiva().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getPlantas())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getProducao())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getUtilizada())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getUtilizacaoPercentual())) {
					try {
						segmentoService.manutencaoCapacidadeProdutiva(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getPlantas())
						&& siteUtil.isEmptyOrNull(itemTabela.getProducao())
						&& siteUtil.isEmptyOrNull(itemTabela.getUtilizada())
						&& siteUtil.isEmptyOrNull(itemTabela.getUtilizacaoPercentual())) {
					try {
						segmentoService.manutencaoCapacidadeProdutiva(model, 
								itemTabela, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaCapacidadeProdutiva().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoCapacidadeProdutiva(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarCapacidadeProdutiva();
	}

	public void incluirCapacidadeProdutiva() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();

		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCapacidadeProdutiva()
				.setNumSequencial(Numeros.ZERO.toString());
		
		if (siteUtil.valueToMainframeBigDecimal(model.getCapacidadeProdutiva().getUtilizacaoPercentual()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
		if (siteUtil.valueToMainframeBigDecimal(model.getCapacidadeProdutiva().getUtilizacaoPercentual()).doubleValue() == 0.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
			return;
		}
		

		try {
			segmentoService.manutencaoCapacidadeProdutiva(model,
					model.getCapacidadeProdutiva(),
					RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setCapacidadeProdutiva(new CapacidadeProdutivaVO());
		listarCapacidadeProdutiva();
	}

	public void excluirCapacidadeProdutiva() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		CapacidadeProdutivaVO itemSelecionado = model
				.getCapacidadeProdutivaSelecionado().get(0);

		try {
			segmentoService.manutencaoCapacidadeProdutiva(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.getCapacidadeProdutivaSelecionado().clear();
		listarCapacidadeProdutiva();
	}

	public void listarFornecedor() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		model.setListaFornecedores(new ArrayList<FornecedorVO>());
		model.getFornecedorSelecionado().clear();
		try {
			model.setListaFornecedores(segmentoService
					.consultaFornecedor(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaFornecedores().size() < Numeros.CINCO){
			model.getListaFornecedores().add(new FornecedorVO());
		}
		try {
			copiarFornecedor();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarFornecedor() throws IllegalAccessException, InvocationTargetException{
		ArrayList<FornecedorVO> listaCopia = new ArrayList<FornecedorVO>();
		FornecedorVO voCopia = null;
		for (FornecedorVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaFornecedores()) {
			voCopia = new FornecedorVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getFornecedor())){
				voCopia.setFornecedor("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getPorcentagem())){
				voCopia.setPorcentagem("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaFornecedores(listaCopia);
	}
	
	public void fornecedores() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		int contador = 0;
		for (FornecedorVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaFornecedores()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
			viewHelper.getQuestionarioEmpresasVO().getCopiaListaFornecedores().get(contador).setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaFornecedores().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getFornecedor())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						segmentoService.manutencaoFornecedor(model, itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getFornecedor())
						&& siteUtil.isEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						segmentoService.manutencaoFornecedor(model, itemTabela,
								RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaFornecedores().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoFornecedor(model, itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarFornecedor();
	}

	public void incluirFornecedor() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setNumSequencial(Numeros.ZERO.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		if (siteUtil.valueToMainframeBigDecimal(model.getFornecedor().getPorcentagem()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getFornecedor().getPorcentagem()).doubleValue() == 0.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
//			return;
//		}
		try {
			segmentoService.manutencaoFornecedor(model, model.getFornecedor(),
					RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setFornecedor(new FornecedorVO());
		listarFornecedor();
	}

	public void excluirFornecedor() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		FornecedorVO itemSelecionado = model.getFornecedorSelecionado().get(0);
		itemSelecionado.setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		try {
			segmentoService.manutencaoFornecedor(model, itemSelecionado,
					RiccConstants.MANUTENCAO_EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.getFornecedorSelecionado().clear();
		listarFornecedor();
	}

	public void listarCliente() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.getCliente().setNumSequencial(Numeros.UM.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);
		model.setListaClientes(new ArrayList<ClienteVO>());
		model.getClienteSelecionado().clear();

		try {
			model.setListaClientes(segmentoService.consultaCliente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaClientes().size() < Numeros.CINCO){
			model.getListaClientes().add(new ClienteVO());
		}
		try {
			copiarCliente();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarCliente() throws IllegalAccessException, InvocationTargetException{
		ArrayList<ClienteVO> listaCopia = new ArrayList<ClienteVO>();
		ClienteVO voCopia = null;
		for (ClienteVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaClientes()) {
			voCopia = new ClienteVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getCliente())){
				voCopia.setCliente("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getPorcentagem())){
				voCopia.setPorcentagem("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaClientes(listaCopia);
	}
	
	public void clientes() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (ClienteVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaClientes()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);
			viewHelper.getQuestionarioEmpresasVO().getCopiaListaClientes().get(contador).setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaClientes().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCliente())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						segmentoService.manutencaoCliente(model, itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getCliente())
						&& siteUtil.isEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						segmentoService.manutencaoCliente(model, itemTabela,
								RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaClientes().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoCliente(model, itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarCliente();
	}

	public void incluirCliente() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCliente().setNumSequencial(Numeros.ZERO.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		if (siteUtil.valueToMainframeBigDecimal(model.getCliente().getPorcentagem()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getCliente().getPorcentagem()).doubleValue() == 0.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
//			return;
//		}
		try {
			segmentoService.manutencaoCliente(model, model.getCliente(),
					RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setCliente(new ClienteVO());
		listarCliente();
	}

	public void excluirCliente() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		ClienteVO itemSelecionado = model.getClienteSelecionado().get(0);
		itemSelecionado.setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		try {
			segmentoService.manutencaoCliente(model, itemSelecionado,
					RiccConstants.MANUTENCAO_EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.getClienteSelecionado().clear();
		listarCliente();
	}

	public void listarFormaRecebimento() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		model.getRecebimento().setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
		model.setListaRecebimento(new ArrayList<FormaRecebimentoVO>());
		model.getRecebimentoSelecionado().clear();

		try {
			model.setListaRecebimento(segmentoService
					.consultaFormaRecebimento(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaRecebimento().size() < Numeros.CINCO){
			model.getListaRecebimento().add(new FormaRecebimentoVO());
		}
		try {
			copiarFormaRecebimento();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarFormaRecebimento() throws IllegalAccessException, InvocationTargetException{
		ArrayList<FormaRecebimentoVO> listaCopia = new ArrayList<FormaRecebimentoVO>();
		FormaRecebimentoVO voCopia = null;
		for (FormaRecebimentoVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaRecebimento()) {
			voCopia = new FormaRecebimentoVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getFormaRecebimento())){
				voCopia.setFormaRecebimento("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getPorcentagem())){
				voCopia.setPorcentagem("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaRecebimento(listaCopia);
	}
	
	public void recebimento() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (FormaRecebimentoVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaRecebimento()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
			viewHelper.getQuestionarioEmpresasVO().getCopiaListaRecebimento().get(contador).setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaRecebimento().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getFormaRecebimento())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						segmentoService.manutencaoFormaRecebimento(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getFormaRecebimento())
						&& siteUtil.isEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						segmentoService.manutencaoFormaRecebimento(model,
								itemTabela, RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaRecebimento().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoFormaRecebimento(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarFormaRecebimento();
	}

	public void incluirFormaRecebimento() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getRecebimento().setNumSequencial(Numeros.ZERO.toString());
		model.getRecebimento().setTipoCliente(
				RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);

		if (siteUtil.valueToMainframeBigDecimal(model.getRecebimento().getPorcentagem()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getRecebimento().getPorcentagem()).doubleValue() == 0.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
//			return;
//		}
		try {
			segmentoService.manutencaoFormaRecebimento(model,
					model.getRecebimento(), RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setRecebimento(new FormaRecebimentoVO());
		listarFormaRecebimento();
	}

	public void excluirFormaRecebimento() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		FormaRecebimentoVO itemSelecionado = model.getRecebimentoSelecionado().get(0);
		itemSelecionado.setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);

		try {
			segmentoService.manutencaoFormaRecebimento(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.getRecebimentoSelecionado().clear();
		listarFormaRecebimento();
	}

	public void listarConcorrente() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.getConcorrente().setNumSequencial(Numeros.UM.toString());
		model.getConcorrente().setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
		model.setListaConcorrente(new ArrayList<ConcorrenteVO>());
		model.getConcorrenteSelecionado().clear();

		try {
			model.setListaConcorrente(segmentoService
					.consultaConcorrente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaConcorrente().size() < Numeros.CINCO){
			model.getListaConcorrente().add(new ConcorrenteVO());
		}
		try {
			copiarConcorrente();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarConcorrente() throws IllegalAccessException, InvocationTargetException{
		ArrayList<ConcorrenteVO> listaCopia = new ArrayList<ConcorrenteVO>();
		ConcorrenteVO voCopia = null;
		for (ConcorrenteVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaConcorrente()) {
			voCopia = new ConcorrenteVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getConcorrente())){
				voCopia.setConcorrente("");
			}
			
			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaConcorrente(listaCopia);
	}
	
	public void concorrentes() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (ConcorrenteVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaConcorrente()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
			viewHelper.getQuestionarioEmpresasVO().getCopiaListaConcorrente().get(contador).setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaConcorrente().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getConcorrente())) {
					try {
						segmentoService.manutencaoConcorrente(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getConcorrente())) {
					try {
						segmentoService.manutencaoConcorrente(model,
								itemTabela, RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaConcorrente().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoConcorrente(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarConcorrente();
	}

	public void incluirConcorrente() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getConcorrente().setNumSequencial(Numeros.ZERO.toString());
		model.getConcorrente().setTipoCliente(
				RiccConstants.COD_TIPO_CONCORRENTE);

		try {
			segmentoService.manutencaoConcorrente(model,
					model.getConcorrente(), RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setConcorrente(new ConcorrenteVO());
		listarConcorrente();
	}

	public void excluirConcorrente() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		ConcorrenteVO itemSelecionado = model.getConcorrenteSelecionado().get(0);
		itemSelecionado.setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);

		try {
			segmentoService.manutencaoConcorrente(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.getConcorrenteSelecionado().clear();
		listarConcorrente();
	}

	public void listarCarteiraContratos() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.setListaCarteira(new ArrayList<CarteiraContratosVO>());
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
		while(model.getListaCarteira().size() < 30){
			model.getListaCarteira().add(new CarteiraContratosVO());
		}
		try {
			copiarContrato();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarContrato() throws IllegalAccessException, InvocationTargetException{
		ArrayList<CarteiraContratosVO> listaCopia = new ArrayList<CarteiraContratosVO>();
		CarteiraContratosVO voCopia = null;
		for (CarteiraContratosVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaCarteira()) {
			voCopia = new CarteiraContratosVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getProjetoObraServico())){
				voCopia.setProjetoObraServico("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getCliente())){
				voCopia.setCliente("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getValorContrato())){
				voCopia.setValorContrato("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getSaldoPerformar())){
				voCopia.setSaldoPerformar("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getDataTermino())){
				voCopia.setDataTermino("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaCarteira(listaCopia);
	}
	
	public void contrato() { 
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (CarteiraContratosVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaCarteira()) {
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaCarteira().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getProjetoObraServico())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCliente())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getValorContrato())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getSaldoPerformar())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getDataTermino())
						) {
					try {
						segmentoService.manutencaoCarteiraContratos(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getProjetoObraServico())
						&& siteUtil.isEmptyOrNull(itemTabela.getCliente())
						&& siteUtil.isEmptyOrNull(itemTabela.getValorContrato())
						&& siteUtil.isEmptyOrNull(itemTabela.getSaldoPerformar())
						&& siteUtil.isEmptyOrNull(itemTabela.getDataTermino())
						) {
					try {
						segmentoService.manutencaoCarteiraContratos(model,
								itemTabela, RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaCarteira().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoCarteiraContratos(model,
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarCarteiraContratos();
	}
	
	public void incluirCarteiraContratos() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCarteira().setNumSequencial(Numeros.ZERO.toString());
		if (siteUtil.isEmptyOrNull(model.getCarteira().getDataTermino())) {
			BradescoFacesUtils.addInfoModalMessage("Data inválida!", Boolean.FALSE);
			return;
		}

		try {
			segmentoService.manutencaoCarteiraContratos(model,
					model.getCarteira(), RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.setCarteira(new CarteiraContratosVO());
		listarCarteiraContratos();
	}
	
	public void excluirCarteiraContratos() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		CarteiraContratosVO itemSelecionado = model.getCarteiraSelecionado().get(0);
		
		try {
			segmentoService.manutencaoCarteiraContratos(model, itemSelecionado,
					TipoManutencaoEnum.EXCLUSAO.getCodigoString());
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.setCarteiraSelecionado(new ArrayList<CarteiraContratosVO>());
		listarCarteiraContratos();
	}
	
	public void salvarFaturamentoConsolidado() throws RiccException {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		List<FaturamentoConsolidadoVO> listaFaturamento = new ArrayList<FaturamentoConsolidadoVO>();
		listaFaturamento.add(model.getFaturamentoConsolidadoA());
		listaFaturamento.add(model.getFaturamentoConsolidadoB());
		listaFaturamento.add(model.getFaturamentoConsolidadoC());
		
		segmentoService.manutencaoFaturamentoConsolidado(model, listaFaturamento, TipoManutencaoEnum.MANUTENCAO.getCodigoString());
		
		consultaFaturamentoConsolidado();
	}

	public void consultaFaturamentoConsolidado() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		try {

			List<FaturamentoConsolidadoVO> retornoMainframe = segmentoService
					.consultaFaturamentoConsolidado(model);
			if (!retornoMainframe.isEmpty()) {
				model.setFaturamentoConsolidadoA(retornoMainframe.get(0));
				model.setFaturamentoConsolidadoB(retornoMainframe.get(1));
				model.setFaturamentoConsolidadoC(retornoMainframe.get(2));
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void salvarFaturamentoSegmento() throws RiccException {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		
		segmentoService.manutencaoFaturamentoSegmento(model,
				model.getFaturamentoSegmento(),
				TipoManutencaoEnum.MANUTENCAO);
	}
	
	public void consultarFaturamentoSegmento() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setFaturamentoSegmento(segmentoService
					.consultaFaturamentoSegmento(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void salvarHighlightsEmpresa() throws RiccException {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		List<HighlightsEmpresaVO> listaBalanco = new ArrayList<HighlightsEmpresaVO>();
		listaBalanco.add(model.getHighlightsA());
		listaBalanco.add(model.getHighlightsB());
		listaBalanco.add(model.getHighlightsC());
		
		segmentoService
				.manutencaoHighlightsEmpresa(model, listaBalanco,
						TipoManutencaoEnum.MANUTENCAO,
						model.getNomeHighlightsEmpresa());
	}
	
	public void botaoNovoHighlights(){
		viewHelper.getQuestionarioEmpresasVO().setHighlightsA(viewHelper.getQuestionarioEmpresasVO().getHighlightsB());
		viewHelper.getQuestionarioEmpresasVO().setHighlightsB(viewHelper.getQuestionarioEmpresasVO().getHighlightsC());
		viewHelper.getQuestionarioEmpresasVO().setHighlightsC(new HighlightsEmpresaVO());
	}
	
	public void consultaHighlightsEmpresa() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
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
	
	public void listarEndividamentoBancario() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.setListaEndividamentoBancario(new ArrayList<EndividamentoBancarioVO>());
		model.getEndividamentoBancarioSelecionado().clear();
		model.setTotalSaldoEndividamentoBancario("");

		try {
			StringBuilder builder = new StringBuilder();
			model.setListaEndividamentoBancario(segmentoService
					.consultaEndividamentoBancario(model, builder));
			model.setTotalSaldoEndividamentoBancario(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaEndividamentoBancario().size() < 15){
			model.getListaEndividamentoBancario().add(new EndividamentoBancarioVO());
		}
		try {
			copiarDividas();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	private void copiarDividas() throws IllegalAccessException, InvocationTargetException{
		ArrayList<EndividamentoBancarioVO> listaCopia = new ArrayList<EndividamentoBancarioVO>();
		EndividamentoBancarioVO voCopia = null;
		for (EndividamentoBancarioVO itemTabela : this.viewHelper.getQuestionarioEmpresasVO().getListaEndividamentoBancario()) {
			voCopia = new EndividamentoBancarioVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getInstituicaoFinanceira())){
				voCopia.setInstituicaoFinanceira("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getModalidade())){
				voCopia.setModalidade("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getSaldo())){
				voCopia.setSaldo("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getVencimentoFinal())){
				voCopia.setVencimentoFinal("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getDescGarantia())){
				voCopia.setDescGarantia("");
			}
			listaCopia.add(voCopia);
		}
		viewHelper.getQuestionarioEmpresasVO().setCopiaListaEndividamentoBancario(listaCopia);
	}
	
	public void divida(){
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		int contador = 0;
		for (EndividamentoBancarioVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaEndividamentoBancario()) {
			if(itemTabela.getAmortizacao().equals("")){
				viewHelper.getQuestionarioEmpresasVO().getCopiaListaEndividamentoBancario().get(contador).setAmortizacao("");
			}
			if (!itemTabela.equals(viewHelper.getQuestionarioEmpresasVO().getCopiaListaEndividamentoBancario().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getInstituicaoFinanceira())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getModalidade())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getSaldo())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getVencimentoFinal())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getDescGarantia())
						) {
					try {
						segmentoService.manutencaoEndividamentoBancario(model,
								itemTabela, TipoManutencaoEnum.INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getInstituicaoFinanceira())
						&& siteUtil.isEmptyOrNull(itemTabela.getModalidade())
						&& siteUtil.isEmptyOrNull(itemTabela.getSaldo())
						&& siteUtil.isEmptyOrNull(itemTabela.getVencimentoFinal())
						&& siteUtil.isEmptyOrNull(itemTabela.getDescGarantia())
						) {
					try {
						segmentoService.manutencaoEndividamentoBancario(model,
								itemTabela, TipoManutencaoEnum.EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getQuestionarioEmpresasVO().getCopiaListaEndividamentoBancario().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoEndividamentoBancario(model,
								itemTabela, TipoManutencaoEnum.INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				}
			}
			contador ++;
		}
		listarEndividamentoBancario();
	}

	public void incluirEndividamentoBancario() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		EndividamentoBancarioVO endividamento = model.getEndividamentoBancario();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		endividamento.setNumSequencial(Numeros.ZERO.toString());
		if (siteUtil.isEmptyOrNull(endividamento.getVencimentoFinal())) {
			BradescoFacesUtils.addInfoModalMessage("Data inválida!", Boolean.FALSE);
			return;
		}
		
		try {
			segmentoService.manutencaoEndividamentoBancario(model, endividamento,
					TipoManutencaoEnum.INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.setEndividamentoBancario(new EndividamentoBancarioVO());
		listarEndividamentoBancario();
	}
	
	public void excluirEndividamentoBancario() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		EndividamentoBancarioVO endividamento = model.getEndividamentoBancarioSelecionado().get(0);
		
		try {
			segmentoService.manutencaoEndividamentoBancario(model, endividamento,
					TipoManutencaoEnum.EXCLUSAO);
//			siteUtil.getMessages().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		model.setTotalSaldoEndividamentoBancario("");
		model.setEndividamentoBancarioSelecionado(new ArrayList<EndividamentoBancarioVO>());
		model.getListaEndividamentoBancario().clear();
		listarEndividamentoBancario();
	}
	
	public void consultaMercadoExterno() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
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

	public void salvarMercadoExterno() throws RiccException {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		List<ImportacoesExportacoesVO> listaVolume = new ArrayList<ImportacoesExportacoesVO>(3);
		listaVolume.add(model.getVolumeA());
		listaVolume.add(model.getVolumeB());
		listaVolume.add(model.getVolumeC());
		
		if (siteUtil.isNotEmptyOrNull(model.getVolumeC().getMes())) {
			int mes = Integer.parseInt(model.getVolumeC().getMes());
			if (mes < 1 || mes > 12) {
				throw new IllegalArgumentException("Campo Mês de 'Exposição cambial' inválido");
			}
		}
		segmentoService.manutencaoImportacoesExportacoes(model, listaVolume, 
				TipoManutencaoEnum.MANUTENCAO.getCodigoString(), model.getMoedaExportacao());
		
	}
	
	public void consultaPerspectivaEmpresa() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setPerspectiva(segmentoService.consultaPerspectivas(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void salvarPerspectivaEmpresa() throws RiccException {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		segmentoService.manutencaoPerspectivas(model, model.getPerspectiva(),
				TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}
	
//	public void consultaReciprocidades() {
//		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
//
//		try {
//			model.setVolumeBradesco(segmentoService
//					.consultaVolumeBradesco(model));
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//	}
//
//	public void salvarReciprocidades() throws RiccException {
//		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
//		
//		if (siteUtil.isNotEmptyOrNull(model.getVolumeBradesco().getMes())) {
//			int mes = Integer.parseInt(model.getVolumeBradesco().getMes());
//			if(mes < 1 || mes > 12){
//				throw new IllegalArgumentException("Campo Mês de 'Reciprocidades não capturadas' Inválido");
//			}
//		}
//
//		segmentoService.manutencaoVolumeBradesco(model,
//				model.getVolumeBradesco(),TipoManutencaoEnum.MANUTENCAO.getCodigoString());
//		
//	}
//	
//	public void incluirCartao() {
//		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
//		CartaoVO cartao = model.getCartao();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
//		cartao.setNumSequencial(Numeros.ZERO.toString());
//		
//		try {
//			segmentoService.manutencaoCartoes(model, cartao, TipoManutencaoEnum.INCLUSAO.getCodigoString());
////			siteUtil.getMessages().getMsgInclusaoSucesso();
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//			return;
//		}
//		
//		model.setCartao(new CartaoVO());
//		listarCartoes();
//	}
//	
//	public void excluirCartao() {
//		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
//		CartaoVO cartao = model.getCartaoSelecionado().get(0);
//		
//		try {
//			segmentoService.manutencaoCartoes(model, cartao,
//					TipoManutencaoEnum.EXCLUSAO.getCodigoString());
////			siteUtil.getMessages().getMsgExclusaoSucesso();
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//			return;
//		}
//		
//		listarCartoes();
//	}
//	
//	public void listarCartoes() {
//		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
//		model.getListaCartao().clear();
//		model.getCartaoSelecionado().clear();
//
//		try {
//			model.setListaCartao(segmentoService.consultaCartoes(model));
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//	}

	public void listarSetor() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		try {
			model.setListaSetor(segmentoService.consultaSetores(model));
			viewHelper.setComboSetor(siteUtil.carregarComboSetor(
					viewHelper.getComboSetor(), model.getListaSetor()));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	public void incluirSetor() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		if (siteUtil.isEmptyOrNull(model.getSetor())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_setor");
		} else {
			try {
				Integer tipoSetor = segmentoService.manutencaoSetores(model, model.getSetor(),
						TipoManutencaoEnum.INCLUSAO.getCodigoString());
				
				switch (tipoSetor) {
				//AGRONEGÓCIO
				case 1:
					QuestionarioAgronegocioVO agro = new QuestionarioAgronegocioVO();
					segmentoService.manutencaoSetorAgro(model, agro, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorAgricola("1");
					break;
				//IMOBILIÁRIO
				case 2:
					QuestionarioImobiliarioVO imob = new QuestionarioImobiliarioVO();
					segmentoService.manutencaoSetorImobiliario(model, imob, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorImobiliario("1");
					break;
				//PROJETOS
				case 3:
					QuestionarioProjetoVO proj = new QuestionarioProjetoVO();
					segmentoService.manutencaoSetorProjetos(model, proj, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorProjeto("1");
					break;
				//TRANSPORTE
				case 4:
					QuestionarioTransportesVO tran = new QuestionarioTransportesVO();
					segmentoService.manutencaoSetorTransporte(model, tran, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorTransporte("1");
					break;
				}
				
				model.setSetor(null);
				
				/*
				 * Não exibe mensagem de INCLUIDO COM SUCESSO
				 * quando inclui um novo relatório
				 * Novo relatório = Status provisório
				 */
//				if (SituacaoRelatorioEnum.isNotSituacaoProvisorio(model.getCodSituacaoRelatorio())) {
//					siteUtil.getMessages().getMsgInclusaoSucesso();
//				}
				
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}
			
			listarSetor();
		}
		
	}

	public void excluirSetor() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		TipoQuestionarioVO itemSelecionado = model.getSetorSelecionado().get(0);
		if (siteUtil.isEmptyOrNull(itemSelecionado)) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_setor");
		} else {
			try {
				Integer tipoSetor = segmentoService.manutencaoSetores(model, itemSelecionado,
						TipoManutencaoEnum.EXCLUSAO.getCodigoString());
				
				switch (tipoSetor) {
				//AGRONEGÓCIO
				case 1:
					QuestionarioAgronegocioVO setor = new QuestionarioAgronegocioVO();
					segmentoService.manutencaoSetorAgro(model, setor, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorAgricola("2");
					break;
				//IMOBILIÁRIO
				case 2:
					QuestionarioImobiliarioVO imob = new QuestionarioImobiliarioVO();
					segmentoService.manutencaoSetorImobiliario(model, imob, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorImobiliario("2");
					break;
				//PROJETOS
				case 3:
					QuestionarioProjetoVO proj = new QuestionarioProjetoVO();
					segmentoService.manutencaoSetorProjetos(model, proj, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorProjeto("2");
					break;
				//TRANSPORTE
				case 4:
					QuestionarioTransportesVO tran = new QuestionarioTransportesVO();
					segmentoService.manutencaoSetorTransporte(model, tran, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getQuestionarioEmpresasVO().setFlagSetorTransporte("2");
					break;
				}
				
//				siteUtil.getMessages().getMsgExclusaoSucesso();
				
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}
			
			viewHelper.getQuestionarioEmpresasVO().getSetorSelecionado().clear();
			listarSetor();
		}
		
	}

	public String alterarSetor() {
		String retorno = "";
		try {
			TipoQuestionarioVO setorSelecionadoTabela = viewHelper.getQuestionarioEmpresasVO().getSetorSelecionado().get(0);
			QuestionarioEmpresasVO model = this.viewHelper.getQuestionarioEmpresasVO();
			Integer codigoSetor = setorSelecionadoTabela.getCodigo().intValue();
			String paginaAnterior = RiccConstants.TELA_QUESTIONARIO_EMPRESAS;
			
			if (SetorEnum.AGRONEGOCIO.getCodigo().equals(codigoSetor)) {
				QuestionarioAgronegocioBean bean = (QuestionarioAgronegocioBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModel().setCodSegmento(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel().setDescGrupo(model.getNomeGrupo());
				bean.setPaginaAnterior(paginaAnterior);
				bean.carregarDadosTela();
				
			} else if (SetorEnum.IMOBILIARIO.getCodigo().equals(codigoSetor)) {
				QuestionarioImobiliarioBean bean = (QuestionarioImobiliarioBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getQuestionarioImobiliarioVO().setCodGrupoEconomico(model.getCodGrupo());
				bean.getViewHelper().getQuestionarioImobiliarioVO().setDescGrupoEconomico(model.getNomeGrupo());
				bean.getViewHelper().getQuestionarioImobiliarioVO().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getQuestionarioImobiliarioVO().setVersaoOrigem(model.getVersaoOrigem());
				bean.setPaginaAnterior(paginaAnterior);
				bean.carregarDados();
				
			} else if (SetorEnum.PROJETOS.getCodigo().equals(codigoSetor)) {
				QuestionarioProjetoBean bean = (QuestionarioProjetoBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
				bean.setPaginaAnterior(paginaAnterior);
				bean.carregarDados();
				
			} else if (SetorEnum.TRANSPORTE.getCodigo().equals(codigoSetor)) {
				QuestionarioTransportesBean bean = (QuestionarioTransportesBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
				bean.setPaginaAnterior(paginaAnterior);
				bean.carregarDados();
			}
			viewHelper.getQuestionarioEmpresasVO().getSetorSelecionado().clear();
			return retorno;
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		return retorno;
	}

	public void consultaComentarios() {
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
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
	
	private boolean validarAnosIguais(){
		
		boolean ret = true;
		
		if(isAnosIguais(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getAno(), 
				viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getAno(),
				viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getAno(), 
				"Os anos do quadro Faturamento Consolidado devem ser diferentes")){
			
			ret = false;
		}
		
		if(isAnosIguais(viewHelper.getQuestionarioEmpresasVO().getFaturamentoSegmento().getAno1(), 
				viewHelper.getQuestionarioEmpresasVO().getFaturamentoSegmento().getAno2(),
				viewHelper.getQuestionarioEmpresasVO().getFaturamentoSegmento().getAno3(), 
				"Os anos do quadro Abertura Faturamento devem ser diferentes")){
			
			ret = false;
		}
		
		if(isAnosIguais(viewHelper.getQuestionarioEmpresasVO().getVolumeA().getAno(), 
				viewHelper.getQuestionarioEmpresasVO().getVolumeB().getAno(),
				viewHelper.getQuestionarioEmpresasVO().getVolumeC().getAno(), 
				"Os anos do quadro Exposição Cambial devem ser diferentes")){
			
			ret = false;
		}
		
		return ret;
	}
	
	private boolean isAnosIguais(String ano1, String ano2, String ano3, String msg){
		if(SiteUtil.getInstance().isNotEmptyOrNull(ano1)){
			if(ano1.equals(ano2)){
				BradescoFacesUtils.addInfoModalMessage(msg, false);
				return true;
			}
			
			if(ano1.equals(ano3)){
				BradescoFacesUtils.addInfoModalMessage(msg, false);
				return true;
			}
			
		}
		
		if(SiteUtil.getInstance().isNotEmptyOrNull(ano2)){
			if(ano2.equals(ano3)){
				BradescoFacesUtils.addInfoModalMessage(msg, false);
				return true;
			}
		}
		
		return false;
	}

	public boolean validarCamposObrigatorios() {
		boolean retorno = true;
		QuestionarioEmpresasVO model = viewHelper.getQuestionarioEmpresasVO();
		if (siteUtil.isEmptyOrNull(model.getNomeRelatorio())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_nome_relatorio");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getDescAtividadeEmpresa())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_quest_corporate_descrever");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getOrganogramaControleAcionario())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_quest_corporate_Organograma");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getAdministracao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_administracao");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getPlanoSucessao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_plano_sucessao");
			retorno = false;
		}
		if (model.getListaQuadroAdministrativo().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_quadro_administrativo");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getDescQuadroAdministrativo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_detalhar_plano_sucessao");
			retorno = false;
		}
		if (model.getListaDetalhamentoPatrimonio().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_detalhamento_patrimonio");
			retorno = false;
		}
		if (model.getListaFornecedores().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_fornecedores");
			retorno = false;
		}
		if (model.getListaClientes().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem("label_clientes");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getInformarAtraso())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_informar_atraso");
			retorno = false;
		}
		if (model.getListaRecebimento().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_forma_recebimento");
			retorno = false;
		}
		if (model.getListaConcorrente().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_principais_concorrentes");
			retorno = false;
		}
		if (!validarCamposFaturamentoConsolidado()) {
			siteUtil.getMessages().getMsgColunaObrigatoria(
					"label_faturamento_consolidado");
			retorno = false;
		}
		if (!validarCamposAberturaFaturamento()) {
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getNomeHighlightsEmpresa())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_highlights_empresa");
			retorno = false;
		}
		if (!validarCamposHighlights()) {
			siteUtil.getMessages().getMsgColunaObrigatoria(
					"label_highlights_empresa");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getDescFaturamento())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_comentarios_situacao_atual");
			retorno = false;
		}
		if (model.getListaEndividamentoBancario().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_endividamento_bancario");
			retorno = false;
		}
		if (!validarCamposMercadoExterno()) {
			retorno = false;
		}
		if (!validarCamposPerspectivas()) {
			siteUtil.getMessages().getMsgCamposObrigatoriosTodos(
					"label_projecao_enc_ano_fiscal");
			retorno = false;
		}
		if (!validarCamposReciprocidades()) {
//			siteUtil.getMessages().getMsgCampoObrigatorio(
//					"label_bradesco_ano_atual");
			retorno = false;
		}
//		if (!validarDatasFaturamentoConsolidado()) {
//			retorno = false;
//		}
		if (siteUtil.isEmptyOrNull(model.getDetalheEstrategiaProjecao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_detalhar_estrategia");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model
				.getDetalheInvestimentosConcluidosPlanejados())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_principais_investimentos_concluidos");
			retorno = false;
		}
//		if (model.getListaCartao().isEmpty()) {
//			siteUtil.getMessages().getMsgListaDeveConterItem("label_cartoes_m");
//			retorno = false;
//		}
		return retorno;
	}

	public boolean validarCamposQuadroAdm() {
		QuadroAdministrativoVO model = viewHelper.getQuestionarioEmpresasVO()
				.getQuadroAdministrativo();
		if (siteUtil.isEmptyOrNull(model.getAdministrador())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_administradores");
			return false;
		}
		if (siteUtil.isEmptyOrNull(model.getCargo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_cargo");
			return false;
		}
		return true;
	}

	public boolean validarCamposFornecedor() {
		FornecedorVO model = viewHelper.getQuestionarioEmpresasVO().getFornecedor();
		if(siteUtil.isEmptyOrNull(model.getFornecedor())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_fornecedores");
			return false;
		}
		if(siteUtil.isEmptyOrNull(model.getPorcentagem())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_percentual");
			return false;
		}
		return true;
	}
	
	public boolean validarCamposFaturamentoConsolidado() {
		FaturamentoConsolidadoVO fat = viewHelper.getQuestionarioEmpresasVO()
				.getFaturamentoConsolidadoA();
		if (siteUtil.isEmptyOrNull(fat.getAno())) {
			return false;
		} else {
			if (siteUtil.isEmptyOrNull(fat.getJaneiro())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getFevereiro())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getMarco())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getAbril())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getMaio())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getJunho())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getJulho())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getAgosto())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getSetembro())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getOutubro())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getNovembro())) {
				return false;
			} else if (siteUtil.isEmptyOrNull(fat.getDezembro())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validarDatasFaturamentoConsolidado (){
		if(siteUtil.isNotEmptyOrNull(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getAno()) ||
				siteUtil.isNotEmptyOrNull(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getAno()) ){
			
			int anoA = Integer.parseInt(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getAno());
			int anoB = Integer.parseInt(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getAno());
			int anoC = Integer.parseInt(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getAno());
			
			// Anos posteriores não podem ser menores
			if (anoA > anoB || anoB > anoC) {
				siteUtil.getMessages().getMsgInformada("msg_faturamento_consolidado_ano_invalido");
				return false;
			} 
		}
		return true;
	}

	public boolean validarCamposAberturaFaturamento() {
		FaturamentoPorSegmentoVO faturamento = viewHelper.getQuestionarioEmpresasVO().getFaturamentoSegmento();

		Integer ano1 = siteUtil.tratarParametroInteger(faturamento.getAno1());
		Integer ano2 = siteUtil.tratarParametroInteger(faturamento.getAno2());
		Integer ano3 = siteUtil.tratarParametroInteger(faturamento.getAno3());
		
		LinhaSegmentoVO linha1 = faturamento.getLinha1();
		LinhaSegmentoVO linha2 = faturamento.getLinha2();
		LinhaSegmentoVO linha3 = faturamento.getLinha3();
		LinhaSegmentoVO linha4 = faturamento.getLinha4();
		LinhaSegmentoVO linha5 = faturamento.getLinha5();
		LinhaSegmentoVO linha6 = faturamento.getLinha6();
		
		if (!dateUtil.validarAno(ano1, 1900, 2099)) {
			siteUtil.getMessages().getMsgInformada("msg_ano_abertura_faturamento_invalido");
			return false;
		}
		if (!dateUtil.validarAno(ano2, 1900, 2099)) {
			siteUtil.getMessages().getMsgInformada("msg_ano_abertura_faturamento_invalido");
			return false;
		}
		if (!dateUtil.validarAno(ano3, 1900, 2099)) {
			siteUtil.getMessages().getMsgInformada("msg_ano_abertura_faturamento_invalido");
			return false;
		}
		
		if (siteUtil.isEmptyOrNull(linha1.getDescricao())) {
			if (siteUtil.isNotEmptyOrNull(linha1.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha1.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha1.getPorcentagem3())) {
				
				siteUtil.getMessages().getMsgInformada("msg_desc_abertura_faturamento_obrigatorio");
				return false;
			}
		}
		
		if (siteUtil.isEmptyOrNull(linha2.getDescricao())) {
			if (siteUtil.isNotEmptyOrNull(linha2.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha2.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha2.getPorcentagem3())) {
				
				siteUtil.getMessages().getMsgInformada("msg_desc_abertura_faturamento_obrigatorio");
				return false;
			}
		}
		
		if (siteUtil.isEmptyOrNull(linha3.getDescricao())) {
			if (siteUtil.isNotEmptyOrNull(linha3.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha3.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha3.getPorcentagem3())) {
				
				siteUtil.getMessages().getMsgInformada("msg_desc_abertura_faturamento_obrigatorio");
				return false;
			}
		}
		
		if (siteUtil.isEmptyOrNull(linha4.getDescricao())) {
			if (siteUtil.isNotEmptyOrNull(linha4.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha4.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha4.getPorcentagem3())) {
				
				siteUtil.getMessages().getMsgInformada("msg_desc_abertura_faturamento_obrigatorio");
				return false;
			}
		}
		
		if (siteUtil.isEmptyOrNull(linha5.getDescricao())) {
			if (siteUtil.isNotEmptyOrNull(linha5.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha5.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha5.getPorcentagem3())) {
			
				siteUtil.getMessages().getMsgInformada("msg_desc_abertura_faturamento_obrigatorio");
				return false;
			}
		}
		
		if (siteUtil.isEmptyOrNull(linha6.getDescricao())) {
			if (siteUtil.isNotEmptyOrNull(linha6.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha6.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha6.getPorcentagem3())) {
				
				siteUtil.getMessages().getMsgInformada("msg_desc_abertura_faturamento_obrigatorio");
				return false;
			}
		}
		
		if (siteUtil.isEmptyOrNull(faturamento.getAno1())) {
			if (siteUtil.isNotEmptyOrNull(linha1.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha2.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha3.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha4.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha5.getPorcentagem1()) ||
				siteUtil.isNotEmptyOrNull(linha6.getPorcentagem1())) {
				
				siteUtil.getMessages().getMsgInformada("msg_ano_abertura_faturamento_obrigatorio");
				return false;
				
			}
		}
		if (siteUtil.isEmptyOrNull(faturamento.getAno2())) {
			if (siteUtil.isNotEmptyOrNull(linha1.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha2.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha3.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha4.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha5.getPorcentagem2()) ||
				siteUtil.isNotEmptyOrNull(linha6.getPorcentagem2())) {
				
				siteUtil.getMessages().getMsgInformada("msg_ano_abertura_faturamento_obrigatorio");
				return false;
					
			}
		}
		if (siteUtil.isEmptyOrNull(faturamento.getAno3())) {
			if (siteUtil.isNotEmptyOrNull(linha1.getPorcentagem3()) ||
				siteUtil.isNotEmptyOrNull(linha2.getPorcentagem3()) ||
				siteUtil.isNotEmptyOrNull(linha3.getPorcentagem3()) ||
				siteUtil.isNotEmptyOrNull(linha4.getPorcentagem3()) ||
				siteUtil.isNotEmptyOrNull(linha5.getPorcentagem3()) ||
				siteUtil.isNotEmptyOrNull(linha6.getPorcentagem3())) {
				
				siteUtil.getMessages().getMsgInformada("msg_ano_abertura_faturamento_obrigatorio");
				return false;
					
			}
		}
		return true;
	}
	
	public boolean validarCamposHighlights() {
		HighlightsEmpresaVO a = viewHelper.getQuestionarioEmpresasVO().getHighlightsA();
		if (siteUtil.isEmptyOrNull(a.getBalanco())) {
			return false;
		} else {
			if(siteUtil.isEmptyOrNull(a.getReceitaLiquida())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getContasAReceber())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getEstoques())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getGerBrutaCaixa())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getMargemOperacional())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getLucroPrejuizoLiquido())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getPatrimonioLiquido())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getEndividamentoFinanceiroTotal())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getDisponibilidades())) {
				return false;
			} else if(siteUtil.isEmptyOrNull(a.getEndividamentoFinanceiroLiquido())) {
				return false;
			}
		}
		return true;
	}

	public boolean validarCamposReciprocidades() {
		VolumeBradescoVO volume = getViewHelper().getQuestionarioEmpresasVO()
				.getVolumeBradesco();
		if (siteUtil.isEmptyOrNull(volume.getAno()) || siteUtil.isEmptyOrNull(volume.getMes())) {
			if (siteUtil.isNotEmptyOrNull(volume.getCobrancaValor())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getCobrancaQuantidade())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getCobrancaResultLiq())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getPagforValor())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getPagforQuantidade())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getPagforResultLiq())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getPtrbValor())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getPtrbQuantidade())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getNetEmpresaValor())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getNetEmpresaQuantidade())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getFolhaPabValor())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getFolhaPabQtdFuncionarios())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getFolhaPabResultado())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getCreditoConsignadoValor())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getCreditoConsignadoQtdFuncionarios())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
			if (siteUtil.isNotEmptyOrNull(volume.getCreditoConsignadoResultado())) {
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_bradesco_ano_atual");
				return false;
			}
		} 
		return true;
	}
	
	public boolean validarCamposMercadoExterno() {
		ImportacoesExportacoesVO a = viewHelper.getQuestionarioEmpresasVO().getVolumeA();
		ImportacoesExportacoesVO b = viewHelper.getQuestionarioEmpresasVO().getVolumeB();
		ImportacoesExportacoesVO c = viewHelper.getQuestionarioEmpresasVO().getVolumeC();
		
		// Moeda vazio -> false se o primeiro ano estiver inválido
		if (siteUtil.isEmptyOrNull(viewHelper.getQuestionarioEmpresasVO().getMoedaExportacao())
				&& siteUtil.isNotEmptyOrNull(a.getAno())) {
			siteUtil.getMessages().getMsgInformada("msg_moeda_obrigatoria");
			return false;
		} else {
			// Ano vazio -> true se import/export vazio
			// Os anos anteriores devem estar preenchidos ao preencher os seguintes
			if (siteUtil.isEmptyOrNull(a.getAno())) {
				if (siteUtil.isNotEmptyOrNull(b.getAno())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_invalido");
					return false;
				}
				
				if (siteUtil.isNotEmptyOrNull(a.getImportacao())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_obrigatorio");
					return false;
				} else if (siteUtil.isNotEmptyOrNull(a.getExportacao())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_obrigatorio");
					return false;
				}
				
			} else if(siteUtil.isEmptyOrNull(b.getAno())) {
				
				if (siteUtil.isNotEmptyOrNull(c.getAno())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_invalido");
					return false;
				}
				
				if (siteUtil.isNotEmptyOrNull(b.getImportacao())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_obrigatorio");
					return false;
				} else if (siteUtil.isNotEmptyOrNull(b.getExportacao())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_obrigatorio");
					return false;
				}
				
			} else if (siteUtil.isEmptyOrNull(c.getAno())) {
				
				if (siteUtil.isNotEmptyOrNull(c.getMes())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_mes_obrigatorio");
					return false;
				}
				
				if (siteUtil.isNotEmptyOrNull(c.getImportacao())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_obrigatorio");
					return false;
				} else if (siteUtil.isNotEmptyOrNull(c.getExportacao())) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_obrigatorio");
					return false;
				}
				
			} else {
				
				int anoA = Integer.parseInt(a.getAno());
				int anoB = Integer.parseInt(b.getAno());
				int anoC = Integer.parseInt(c.getAno());
				
				// Anos posteriores não podem ser menores
				if (anoA > anoB || anoB > anoC) {
					siteUtil.getMessages().getMsgInformada("msg_mercado_externo_ano_invalido");
					return false;
				} else {
					return true;
				}
			}
			return true;
		}
	}

	public boolean validarCamposPerspectivas() {
		PerspectivasVO perspectiva = viewHelper.getQuestionarioEmpresasVO()
				.getPerspectiva();
		if (siteUtil.isEmptyOrNull(perspectiva.getFaturamento())) {
			return false;
		} else if (siteUtil.isEmptyOrNull(perspectiva.getEbitda())) {
			return false;
		} else if (siteUtil.isEmptyOrNull(perspectiva.getLucroLiquido())) {
			return false;
		} else if (siteUtil.isEmptyOrNull(perspectiva.getDividaBancaria())) {
			return false;
		} else if (siteUtil.isEmptyOrNull(perspectiva.getPosicaoCaixa())) {
			return false;
		}
		return true;
	}
	
	//calcular total patrimonio Real Time
		public void patrimonioTotal(AjaxBehaviorEvent e) {
			BigInteger soma = new BigInteger("0");
			for (DetalhamentoPatrimonioVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaDetalhamentoPatrimonio()) {
				if(siteUtil.isNotEmptyOrNull(itemTabela.getValorPatrimonio())){
					soma = soma.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getValorPatrimonio())));
				}
			}
			getViewHelper().getQuestionarioEmpresasVO().setValorTotalPatrimonio(soma.toString());
		}
		
		public void capacidadeProdutivaTotal(AjaxBehaviorEvent e) {
			BigInteger somaProducao = new BigInteger("0");
			BigInteger somaUtilizada = new BigInteger("0");
			for (CapacidadeProdutivaVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaCapacidadeProdutiva()) {
				if(siteUtil.isNotEmptyOrNull(itemTabela.getProducao())){
					somaProducao = somaProducao.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getProducao())));
				}
				if(siteUtil.isNotEmptyOrNull(itemTabela.getUtilizada())){
					somaUtilizada = somaUtilizada.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getUtilizada())));
				}
			}
			getViewHelper().getQuestionarioEmpresasVO().setTotalCapacidade(somaProducao.toString());
			getViewHelper().getQuestionarioEmpresasVO().setTotalProducao(somaUtilizada.toString());
		}
		
		public void carteiraContratosTotal(AjaxBehaviorEvent e) {
			BigInteger somaValorContrato = new BigInteger("0");
			BigInteger somaSaldoPerformar = new BigInteger("0");
			for (CarteiraContratosVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaCarteira()) {
				if(siteUtil.isNotEmptyOrNull(itemTabela.getValorContrato())){
					somaValorContrato = somaValorContrato.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getValorContrato())));
				}
				if(siteUtil.isNotEmptyOrNull(itemTabela.getSaldoPerformar())){
					somaSaldoPerformar = somaSaldoPerformar.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getSaldoPerformar())));
				}
			}
			getViewHelper().getQuestionarioEmpresasVO().setTotalContrato(somaValorContrato.toString());
			getViewHelper().getQuestionarioEmpresasVO().setTotalSaldoContrato(somaSaldoPerformar.toString());
		}
		
		public void faturamentoConsolidadoTotalGeral(AjaxBehaviorEvent e) {
			
			faturamentoConsolidadoTotalA(e);
			faturamentoConsolidadoTotalB(e);
			faturamentoConsolidadoTotalC(e);
			
		}
		
		public void faturamentoConsolidadoTotalA(AjaxBehaviorEvent e) {
			BigInteger janeiro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getJaneiro());
			BigInteger fevereiro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getFevereiro());
			BigInteger marco = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getMarco());
			BigInteger abril = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getAbril());
			BigInteger maio = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getMaio());
			BigInteger junho = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getJunho());
			BigInteger julho = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getJulho());
			BigInteger agosto = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getAgosto());
			BigInteger setembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getSetembro());
			BigInteger outubro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getOutubro());
			BigInteger novembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getNovembro());
			BigInteger dezembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().getDezembro());
			
			BigDecimal total = new BigDecimal("0");
			BigDecimal media = new BigDecimal("0");
			
			total = new BigDecimal(janeiro.add(fevereiro).add(marco).add(abril).add(maio).add(junho).add(julho).add(agosto).
					add(setembro).add(outubro).add(novembro).add(dezembro));
			
			int count = 0;
			
			if(janeiro != BigInteger.ZERO) count++;
			if(fevereiro != BigInteger.ZERO) count++;
			if(marco != BigInteger.ZERO) count++;
			if(abril != BigInteger.ZERO) count++;
			if(maio != BigInteger.ZERO) count++;
			if(junho != BigInteger.ZERO) count++;
			if(julho != BigInteger.ZERO) count++;
			if(agosto != BigInteger.ZERO) count++;
			if(setembro != BigInteger.ZERO) count++;
			if(outubro != BigInteger.ZERO) count++;
			if(novembro != BigInteger.ZERO) count++;
			if(dezembro != BigInteger.ZERO) count++;
			
			media = total.divide(new BigDecimal(count), RoundingMode.HALF_EVEN);
			
			getViewHelper().getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().setTotalFaturamento(total.setScale(0, RoundingMode.HALF_EVEN).toString());
			getViewHelper().getQuestionarioEmpresasVO().getFaturamentoConsolidadoA().setMediaFaturamento(media.setScale(0, RoundingMode.HALF_EVEN).toString());
		}
		
		public void faturamentoConsolidadoTotalB(AjaxBehaviorEvent e) {
			BigInteger janeiro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getJaneiro());
			BigInteger fevereiro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getFevereiro());
			BigInteger marco = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getMarco());
			BigInteger abril = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getAbril());
			BigInteger maio = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getMaio());
			BigInteger junho = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getJunho());
			BigInteger julho = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getJulho());
			BigInteger agosto = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getAgosto());
			BigInteger setembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getSetembro());
			BigInteger outubro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getOutubro());
			BigInteger novembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getNovembro());
			BigInteger dezembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().getDezembro());
			
			BigDecimal total = new BigDecimal("0");
			BigDecimal media = new BigDecimal("0");
			
			total = new BigDecimal(janeiro.add(fevereiro).add(marco).add(abril).add(maio).add(junho).add(julho).add(agosto).
					add(setembro).add(outubro).add(novembro).add(dezembro));
			
			int count = 0;
			
			if(janeiro != BigInteger.ZERO) count++;
			if(fevereiro != BigInteger.ZERO) count++;
			if(marco != BigInteger.ZERO) count++;
			if(abril != BigInteger.ZERO) count++;
			if(maio != BigInteger.ZERO) count++;
			if(junho != BigInteger.ZERO) count++;
			if(julho != BigInteger.ZERO) count++;
			if(agosto != BigInteger.ZERO) count++;
			if(setembro != BigInteger.ZERO) count++;
			if(outubro != BigInteger.ZERO) count++;
			if(novembro != BigInteger.ZERO) count++;
			if(dezembro != BigInteger.ZERO) count++;
			
			media = total.divide(new BigDecimal(count), RoundingMode.HALF_EVEN);
			
			getViewHelper().getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().setTotalFaturamento(total.setScale(0, RoundingMode.HALF_EVEN).toString());
			getViewHelper().getQuestionarioEmpresasVO().getFaturamentoConsolidadoB().setMediaFaturamento(media.setScale(0, RoundingMode.HALF_EVEN).toString());
		}
		
		public void faturamentoConsolidadoTotalC(AjaxBehaviorEvent e) {
			BigInteger janeiro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getJaneiro());
			BigInteger fevereiro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getFevereiro());
			BigInteger marco = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getMarco());
			BigInteger abril = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getAbril());
			BigInteger maio = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getMaio());
			BigInteger junho = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getJunho());
			BigInteger julho = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getJulho());
			BigInteger agosto = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getAgosto());
			BigInteger setembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getSetembro());
			BigInteger outubro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getOutubro());
			BigInteger novembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getNovembro());
			BigInteger dezembro = siteUtil.valueToMainframeBigInteger(viewHelper.getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().getDezembro());
			
			BigDecimal total = new BigDecimal("0");
			BigDecimal media = new BigDecimal("0");
			
			total = new BigDecimal(janeiro.add(fevereiro).add(marco).add(abril).add(maio).add(junho).add(julho).add(agosto).
					add(setembro).add(outubro).add(novembro).add(dezembro));
			
			int count = 0;
			
			if(janeiro != BigInteger.ZERO) count++;
			if(fevereiro != BigInteger.ZERO) count++;
			if(marco != BigInteger.ZERO) count++;
			if(abril != BigInteger.ZERO) count++;
			if(maio != BigInteger.ZERO) count++;
			if(junho != BigInteger.ZERO) count++;
			if(julho != BigInteger.ZERO) count++;
			if(agosto != BigInteger.ZERO) count++;
			if(setembro != BigInteger.ZERO) count++;
			if(outubro != BigInteger.ZERO) count++;
			if(novembro != BigInteger.ZERO) count++;
			if(dezembro != BigInteger.ZERO) count++;
			
			media = total.divide(new BigDecimal(count), RoundingMode.HALF_EVEN);
			
			getViewHelper().getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().setTotalFaturamento(total.setScale(0, RoundingMode.HALF_EVEN).toString());
			getViewHelper().getQuestionarioEmpresasVO().getFaturamentoConsolidadoC().setMediaFaturamento(media.setScale(0, RoundingMode.HALF_EVEN).toString());
		}
		
		public void endividamentoTotal(AjaxBehaviorEvent e) {
			BigInteger soma = new BigInteger("0");
			for (EndividamentoBancarioVO itemTabela : viewHelper.getQuestionarioEmpresasVO().getListaEndividamentoBancario()) {
				if(siteUtil.isNotEmptyOrNull(itemTabela.getSaldo())){
					soma = soma.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getSaldo())));
				}
			}
			getViewHelper().getQuestionarioEmpresasVO().setTotalSaldoEndividamentoBancario(soma.toString());
		}

	public String voltar() {
		
		return ((CadastramentoRicBean) FacesUtils
				.getManagedBean(RiccConstants.BEAN_CADASTRAMENTO_RIC))
				.carregarListaCadastramento();
	}

}
