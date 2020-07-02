package br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.bean;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
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
import br.com.bradesco.web.ricc.model.cadastro.questionarioaltovarejo.QuestionarioAltoVarejoVO;
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
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.model.segmento.VolumeBradescoVO;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.RiccMessages;
import br.com.bradesco.web.ricc.utils.SiteUtil;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.cadastro.bean.CadastramentoRicBean;
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean.QuestionarioAgronegocioBean;
import br.com.bradesco.web.ricc.view.bean.questionarioaltovarejo.viewhelper.AltoVarejoViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.bean.QuestionarioImobiliarioBean;
import br.com.bradesco.web.ricc.view.bean.questionarioprojetos.bean.QuestionarioProjetoBean;
import br.com.bradesco.web.ricc.view.bean.questionariotransportes.bean.QuestionarioTransportesBean;

@SessionScoped
@Named(value = "questionarioAltoVarejoBean")
public class QuestionarioAltoVarejoBean extends AbstractBean<AltoVarejoViewHelper> {

	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;
	
	/**
	 *
	 */
	private static final long serialVersionUID = 5170650375364066861L;
	private AltoVarejoViewHelper viewHelper = null;
	private ArrayList<String> mensagens = new ArrayList<String>();

	@Override
	public String iniciarPagina() {
		setViewHelper(new AltoVarejoViewHelper());
		viewHelper.inicializar();
		if (getViewHelper().getAltoVarejoVO().getListaSetor().isEmpty()) {
			viewHelper.setComboSetor(siteUtil.carregarListaSetor());
		}
		this.viewHelper.getAltoVarejoVO().setCodSegmentoRelatorio(Numeros.UM.toString());
		try {
			carregarCopiaLista();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
		siteUtil.retirarMensagemDuplicada();
		return RiccConstants.TELA_QUESTIONARIO_ALTOVAREJO;
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
		consultarFaturamentoSegmento();
		listarHighlightsEmpresa();
		listarDividas();
		listarMercadoExterno();
		listarSetor();
		consultaComentarios();
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
	
	public void carregarManutencaoRelatorioSegmento(TipoManutencaoEnum tipoManutencao) {
		segmentoService.manutencaoRelatorioSegmento(this.getViewHelper()
				.getAltoVarejoVO(), tipoManutencao);
	}

	public void salvar() {
		
		if(!validarAnosIguais()){
			return;
		}
		
		try {
			QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
			
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
			salvarFaturamentoSegmento();
			manutencaoComentarios(model);
			manutencaoSegmento(model, TipoFuncaoEnum.SALVAR, SituacaoRelatorioEnum.PENDENTE);
			if(mensagens.size() == 0){
				RiccMessages.getInstance().getMsgSalvarSucesso();
			}
			mensagens.clear();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}

	public String concluir() {
		
		if(!validarAnosIguais()){
			return "";
		}
		
		try {
			if (validarCamposObrigatorios()) {
				QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
				
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
				salvarFaturamentoSegmento();
				manutencaoComentarios(model);
				manutencaoSegmento(model, TipoFuncaoEnum.CONCLUIR, SituacaoRelatorioEnum.ATIVO);

				RiccMessages.getInstance().getMsgConcluirSucessoFowardCadastramento();
				
				return voltar();
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		return null;
	}
	
	private void manutencaoComentarios(QuestionarioAltoVarejoVO model) throws RiccException {
		segmentoService.manutencaoComentarios(model, retornaListComentariosSegmento(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosAdm(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosPatrimonio(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosCapacidadeProdutiva(), "");
		
		segmentoService.manutencaoComentarios(model, retornaListComentariosFornecedor(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosCliente(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosConcorrente(), "");
		
		segmentoService.manutencaoComentarios(model, retornaListComentariosContrato(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosFaturamento(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosHighlights(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosDividas(), "");
		segmentoService.manutencaoComentarios(model, retornaListComentariosReciprocidades(), "");
	}
	
	private void manutencaoSegmento(QuestionarioAltoVarejoVO model, TipoFuncaoEnum tipoFuncao, SituacaoRelatorioEnum situacaoRelatorio) throws RiccException {
		segmentoService.manutencaoRelatorioInfoCredito(model, tipoFuncao, situacaoRelatorio, SegmentoEnum.ALTO_VAREJO);
		segmentoService.manutencaoRelatorioSegmento(model, TipoManutencaoEnum.ALTERACAO);
	}
	
	public List<ComentarioVO> retornaListComentariosSegmento(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
			comentario.setCodTipo(ComentarioEnum.ATIVIDADES_EMPRESA.getCodigo());
			comentario.setCodSequencial(ComentarioEnum.ATIVIDADES_EMPRESA.getNumSequencial());
		if(siteUtil.isNotEmptyOrNull(viewHelper.getAltoVarejoVO().getDescAtividade())){
			comentario.setComentario(viewHelper.getAltoVarejoVO().getDescAtividade());
		}else{
			comentario.setComentario("");
		}
			comentarios.add(comentario);
			comentario = new ComentarioVO();
			comentario.setCodTipo(ComentarioEnum.ORGANOGRAMA_EMPRESA.getCodigo());
			comentario.setCodSequencial(ComentarioEnum.ORGANOGRAMA_EMPRESA.getNumSequencial());
		if(siteUtil.isNotEmptyOrNull(viewHelper.getAltoVarejoVO().getDescOrganograma())){
			comentario.setComentario(viewHelper.getAltoVarejoVO().getDescOrganograma());
		}else{
			comentario.setComentario("");
		}
			comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosAdm(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.PLANO_SUCESSAO.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.PLANO_SUCESSAO.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescPlanoSucessao());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosPatrimonio(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.PATRIMONIO.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.PATRIMONIO.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getComentPatrimonio());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosCapacidadeProdutiva(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.CAPACIDADE_PRODUTIVA.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.CAPACIDADE_PRODUTIVA.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescCapacidadeProd());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosFornecedor(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.FORNECEDORES.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.FORNECEDORES.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescFornecedores());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosCliente(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.FORMA_RECEBIMENTO.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.FORMA_RECEBIMENTO.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescRecebimento());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosConcorrente(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.CONCORRENTES.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.CONCORRENTES.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescConcorrentes());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosContrato(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.CARTEIRA.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.CARTEIRA.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescContrato());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosFaturamento(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.FATURAMENTO_CONSOLIDADO.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.FATURAMENTO_CONSOLIDADO.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescFaturamento());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosHighlights(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.HIGHLIGHTS_EMPRESA.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.HIGHLIGHTS_EMPRESA.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescBalanco());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosDividas(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.ENDIVIDAMENTO_BANCARIO.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.ENDIVIDAMENTO_BANCARIO.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescDivida());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosReciprocidades(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodTipo(ComentarioEnum.RECIPROCIDADES.getCodigo());
		comentario.setCodSequencial(ComentarioEnum.RECIPROCIDADES.getNumSequencial());
		comentario.setComentario(viewHelper.getAltoVarejoVO().getDescCartao());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public void quadroAdministrativo() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (QuadroAdministrativoVO itemTabela : viewHelper.getAltoVarejoVO().getListaAdms()) {
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaAdms().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaAdms().get(contador).getNumSequencial()){
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
	
	public boolean validarCamposQuadroAdministrativo() {
		QuadroAdministrativoVO model = viewHelper.getAltoVarejoVO()
				.getAdministrador();
		if (siteUtil.isEmptyOrNull(model.getAdministrador())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio(
					"label_administradores");
			return false;
		}
		if (siteUtil.isEmptyOrNull(model.getCargo())) {
			RiccMessages.getInstance().getMsgCampoObrigatorio("label_cargo");
			return false;
		}
		return true;
	}

	public void incluirAdministrador() {
		if (validarCamposQuadroAdministrativo()) {
			QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
			model.setCodSegmentoRelatorio(Numeros.UM.toString());
			model.getAdministrador().setNumSequencial(Numeros.ZERO.toString());

			try {
				segmentoService.manutencaoQuadroAdministrativo(
						model, model.getAdministrador(),
						TipoManutencaoEnum.INCLUSAO.getCodigoString());
				//RiccMessages.getInstance().getMsgInclusaoSucesso();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}
			
			model.setAdministrador(new QuadroAdministrativoVO());
			
			listarQuadroAdm();
		}
	}

	public void excluirAdministrador() {
		QuestionarioAltoVarejoVO model = getViewHelper().getAltoVarejoVO();
		QuadroAdministrativoVO itemSelecionado = model.getAdmsSelecionado().get(0);

		model.setAdmsSelecionado(new ArrayList<QuadroAdministrativoVO>());
		try {
			segmentoService.manutencaoQuadroAdministrativo(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		model.getAdmsSelecionado().clear();
		model.getListaAdms().clear();
		listarQuadroAdm();
	}
	
	public void detalhamentoPatrimonio() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (DetalhamentoPatrimonioVO itemTabela : viewHelper.getAltoVarejoVO().getListaPatrimonio()) {
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaPatrimonio().get(contador))) {
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
				} else if (itemTabela.getSequencialPatrimonio() == viewHelper.getAltoVarejoVO().getCopiaListaPatrimonio().get(contador).getSequencialPatrimonio()){
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

	public void incluirDetalhamentoPatrimonio() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getPatrimonio().setSequencialPatrimonio(
				Numeros.ZERO.toString());
		try {
			segmentoService.manutencaoDetalhamentoPatrimonio(model, model.getPatrimonio(), TipoManutencaoEnum.INCLUSAO.getCodigoString());
			//RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		getViewHelper().getAltoVarejoVO().setPatrimonio(new DetalhamentoPatrimonioVO());
		listarPatrimonio();
	}

	public void excluirDetalhamentoPatrimonio() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		DetalhamentoPatrimonioVO _itemSelecionado = model.getPatrimonioSelecionado().get(0);
		
		viewHelper.getAltoVarejoVO().setPatrimonioSelecionado(new ArrayList<DetalhamentoPatrimonioVO>());
		try{
			segmentoService.manutencaoDetalhamentoPatrimonio(model, _itemSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.getListaPatrimonio().clear();
		model.setTotalPatrimonio("");
		listarPatrimonio();
	}
	
	public void capacidadeProdutiva() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (CapacidadeProdutivaVO itemTabela : viewHelper.getAltoVarejoVO().getListaCapacidade()) {
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaCapacidade().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaCapacidade().get(contador).getNumSequencial()){
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

		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();

		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCapacidadeProd()
				.setNumSequencial(Numeros.ZERO.toString());
		
		if (siteUtil.valueToMainframeBigDecimal(model.getCapacidadeProd().getUtilizacaoPercentual()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
		
		if (siteUtil.valueToMainframeBigDecimal(model.getCapacidadeProd().getUtilizacaoPercentual()).doubleValue() < 0.01) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior 0,00%!", Boolean.FALSE);
			return;
		}

		try {
			segmentoService.manutencaoCapacidadeProdutiva(model,
					model.getCapacidadeProd(),
					RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setCapacidadeProd(new CapacidadeProdutivaVO());
		listarCapacidadeProdutiva();
	}

	public void excluirCapacidadeProdutiva() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		CapacidadeProdutivaVO _itemSelecionado = model.getCapacidadeSelecionado().get(0);
		
		viewHelper.getAltoVarejoVO().setPatrimonioSelecionado(new ArrayList<DetalhamentoPatrimonioVO>());
		try{
			segmentoService.manutencaoCapacidadeProdutiva(viewHelper.getAltoVarejoVO(), 
					_itemSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.getListaCapacidade().clear();
		listarCapacidadeProdutiva();
	}
	
	public void fornecedores() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		int contador = 0;
		for (FornecedorVO itemTabela : viewHelper.getAltoVarejoVO().getListaFornecedor()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
			viewHelper.getAltoVarejoVO().getCopiaListaFornecedor().get(contador).setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaFornecedor().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaFornecedor().get(contador).getNumSequencial()){
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

	public void incluirFornecedores() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setNumSequencial(Numeros.ZERO.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		
		if (siteUtil.valueToMainframeBigDecimal(model.getFornecedor().getPorcentagem()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
		
//		if (siteUtil.valueToMainframeBigDecimal(model.getFornecedor().getPorcentagem()).doubleValue() < 0.01) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior 0,00%!", Boolean.FALSE);
//			return;
//		}
		
		try {
			segmentoService.manutencaoFornecedor(model, model.getFornecedor(),
					RiccConstants.MANUTENCAO_INCLUSAO);
			//RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setFornecedor(new FornecedorVO());
		listarFornecedor();
	}

	public void excluirFornecedores() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		FornecedorVO fornecedor = model.getFornecedorSelecionado().get(0);
		fornecedor.setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);

		model.setFornecedorSelecionado(new ArrayList<FornecedorVO>());
		try {
			segmentoService.manutencaoFornecedor(model, fornecedor,
					RiccConstants.MANUTENCAO_EXCLUSAO);
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.getListaFornecedor().clear();
		listarFornecedor();
	}
	
	public void clientes() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (ClienteVO itemTabela : viewHelper.getAltoVarejoVO().getListaCliente()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);
			viewHelper.getAltoVarejoVO().getCopiaListaCliente().get(contador).setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaCliente().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaCliente().get(contador).getNumSequencial()){
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

	public void incluirClientes() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCliente().setNumSequencial(Numeros.ZERO.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		if (siteUtil.valueToMainframeBigDecimal(model.getCliente().getPorcentagem()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getCliente().getPorcentagem()).doubleValue() < 0.01) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior 0,00%!", Boolean.FALSE);
//			return;
//		}
		try {
			segmentoService.manutencaoCliente(model, model.getCliente(),
					RiccConstants.MANUTENCAO_INCLUSAO);
			//RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setCliente(new ClienteVO());
		listarCliente();
	}

	public void excluirClientes() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		ClienteVO cliente = model.getClienteSelecionado().get(0);
		cliente.setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		model.setClienteSelecionado(new ArrayList<ClienteVO>());
		try {
			segmentoService.manutencaoCliente(model, cliente,
					RiccConstants.MANUTENCAO_EXCLUSAO);
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.getListaCliente().clear();
		listarCliente();
	}
	
	public void recebimento() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (FormaRecebimentoVO itemTabela : viewHelper.getAltoVarejoVO().getListaRecebimento()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
			viewHelper.getAltoVarejoVO().getCopiaListaRecebimento().get(contador).setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaRecebimento().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaRecebimento().get(contador).getNumSequencial()){
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

	public void incluirRecebimento() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getRecebimento().setNumSequencial(Numeros.ZERO.toString());
		model.getRecebimento().setTipoCliente(
				RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);

		if (siteUtil.valueToMainframeBigDecimal(model.getRecebimento().getPorcentagem()).doubleValue() > 100.00) {
			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
			return;
		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getRecebimento().getPorcentagem()).doubleValue() < 0.01) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior 0,00%!", Boolean.FALSE);
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

	public void excluirRecebimento() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		FormaRecebimentoVO _itemSelecionado = model.getRecebimentoSelecionado().get(0);
		
		_itemSelecionado.setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
		
		viewHelper.getAltoVarejoVO().setRecebimentoSelecionado(new ArrayList<FormaRecebimentoVO>());
		try{
			segmentoService.manutencaoFormaRecebimento(model, 
					_itemSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
			//RiccMessages.getInstance().getMsgExclusaoSucesso();			
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.getListaRecebimento().clear();
		listarFormaRecebimento();
	}
	
	public void concorrentes() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (ConcorrenteVO itemTabela : viewHelper.getAltoVarejoVO().getListaConcorrentes()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
			viewHelper.getAltoVarejoVO().getCopiaListaConcorrentes().get(contador).setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaConcorrentes().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaConcorrentes().get(contador).getNumSequencial()){
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

	public void incluirConcorrentes() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getConcorrente().setNumSequencial(Numeros.ZERO.toString());
		model.getConcorrente().setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);

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

	public void excluirConcorrentes() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		ConcorrenteVO _itemSelecionado = model.getConcorrentesSelecionado().get(0);
		_itemSelecionado.setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);

		viewHelper.getAltoVarejoVO().setConcorrentesSelecionado(new ArrayList<ConcorrenteVO>());
		try{
			segmentoService.manutencaoConcorrente(model, 
					_itemSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.getListaConcorrentes().clear();
		listarConcorrente();
	}
	
	public void contrato() { 
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (CarteiraContratosVO itemTabela : viewHelper.getAltoVarejoVO().getListaContrato()) {
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaContrato().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaContrato().get(contador).getNumSequencial()){
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
		listarContrato();
	}

	public void incluirContrato() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getContrato().setNumSequencial(Numeros.ZERO.toString());
		
		if (siteUtil.isEmptyOrNull(model.getContrato().getDataTermino())) {
			BradescoFacesUtils.addInfoModalMessage("Data inválida!", Boolean.FALSE);
			return;
		}

		try {
			segmentoService.manutencaoCarteiraContratos(model,
					model.getContrato(), RiccConstants.MANUTENCAO_INCLUSAO);
//			siteUtil.getMessages().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.setContrato(new CarteiraContratosVO());
		listarContrato();
	
	}

	public void excluirContrato() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		CarteiraContratosVO _itemSelecionado = model.getContratoSelecionado().get(0);
		
		viewHelper.getAltoVarejoVO().setContratoSelecionado(new ArrayList<CarteiraContratosVO>());
		try{
			segmentoService.manutencaoCarteiraContratos(model, 
					_itemSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.getListaContrato().clear();
		listarContrato();
	}
	

	// 7.Situação Econômica-Financeira

	public void salvarAberturaFaturamento() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		FaturamentoPorSegmentoVO faturamentoSegmento = model.getFaturamento();
		
		try {
			segmentoService.manutencaoFaturamentoSegmento(model, faturamentoSegmento, TipoManutencaoEnum.INCLUSAO);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
	}
	
	public void divida(){
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (EndividamentoBancarioVO itemTabela : viewHelper.getAltoVarejoVO().getListaDividas()) {
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaDividas().get(contador))) {
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
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaDividas().get(contador).getNumSequencial()){
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
		listarDividas();
	}
	

	public void incluirDivida() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getDivida().setNumSequencial(Numeros.ZERO.toString());
		
		if (siteUtil.isEmptyOrNull(model.getDivida().getVencimentoFinal())) {
			BradescoFacesUtils.addInfoModalMessage("Data inválida!", Boolean.FALSE);
			return;
		}
		
		try {
			segmentoService.manutencaoEndividamentoBancario(model,
					model.getDivida(), TipoManutencaoEnum.INCLUSAO);
			model.setDivida(null);
			//RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			model.setDivida(null);
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		model.setDivida(new EndividamentoBancarioVO());
		listarDividas();
	}

	public void excluirDivida() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		EndividamentoBancarioVO _itemSelecionado = model.getDividasSelecionado().get(0);
		
		viewHelper.getAltoVarejoVO().setDividasSelecionado(new ArrayList<EndividamentoBancarioVO>());
		try{
			segmentoService.manutencaoEndividamentoBancario(model, _itemSelecionado, TipoManutencaoEnum.EXCLUSAO);
			//RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		model.getListaDividas().clear();
		model.setTotalSaldo("");
		listarDividas();
	}

	// 10.Reciprocidades não capturadas na aba "reciprocidade" no CLIM/ANAC
	
	public void cartao(){
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		int contador = 0;
		for (CartaoVO itemTabela : viewHelper.getAltoVarejoVO().getListaCartao()) {
			if (!itemTabela.equals(viewHelper.getAltoVarejoVO().getCopiaListaCartao().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getQuantidade())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getResultado())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getBandeira())
						) {
					try {
						segmentoService.manutencaoCartoes(model, itemTabela, 
								TipoManutencaoEnum.INCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getQuantidade())
						&& siteUtil.isEmptyOrNull(itemTabela.getResultado())
						&& siteUtil.isEmptyOrNull(itemTabela.getBandeira())
						) {
					try {
						segmentoService.manutencaoCartoes(model, itemTabela, 
								TipoManutencaoEnum.EXCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
					}
				//ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper.getAltoVarejoVO().getCopiaListaDividas().get(contador).getNumSequencial()){
					try {
						segmentoService.manutencaoCartoes(model, itemTabela, 
								TipoManutencaoEnum.INCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
					}
				}
			}
			contador ++;
		}
		listarDividas();
	}

//	public void incluirCartao() {
//		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
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
//
//	public void excluirCartao() {
//		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();  
//		CartaoVO _itemSelecionado = model.getCartaoSelecionado().get(0);
//		
//		viewHelper.getAltoVarejoVO().setCartaoSelecionado(new ArrayList<CartaoVO>());
//		try{
//			segmentoService.manutencaoCartoes(model, 
//					_itemSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
//			//RiccMessages.getInstance().getMsgExclusaoSucesso();
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//			return;
//		}
//		
//		model.getListaCartao().clear();
//		listarCartoes();
//	}

	// setor
	public void incluirSetor() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
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
					viewHelper.getAltoVarejoVO().setFlagSetorAgricola("1");
					break;
				//IMOBILIÁRIO
				case 2:
					QuestionarioImobiliarioVO imob = new QuestionarioImobiliarioVO();
					segmentoService.manutencaoSetorImobiliario(model, imob, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getAltoVarejoVO().setFlagSetorImobiliario("1");
					break;
				//PROJETOS
				case 3:
					QuestionarioProjetoVO proj = new QuestionarioProjetoVO();
					segmentoService.manutencaoSetorProjetos(model, proj, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getAltoVarejoVO().setFlagSetorProjeto("1");
					break;
				//TRANSPORTE
				case 4:
					QuestionarioTransportesVO tran = new QuestionarioTransportesVO();
					segmentoService.manutencaoSetorTransporte(model, tran, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getAltoVarejoVO().setFlagSetorTransporte("1");
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
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		if (siteUtil.isEmptyOrNull(model.getSetorSelecionado().get(0))) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_setor");
		} else {
			
			try {
				Integer tipoSetor = segmentoService.manutencaoSetores(model, model.getSetorSelecionado().get(0),
						TipoManutencaoEnum.EXCLUSAO.getCodigoString());
				
				switch (tipoSetor) {
				//AGRONEGÓCIO
				case 1:
					QuestionarioAgronegocioVO agro = new QuestionarioAgronegocioVO();
					segmentoService.manutencaoSetorAgro(model, agro, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getAltoVarejoVO().setFlagSetorAgricola("2");
					break;
				//IMOBILIÁRIO
				case 2:
					QuestionarioImobiliarioVO imob = new QuestionarioImobiliarioVO();
					segmentoService.manutencaoSetorImobiliario(model, imob, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getAltoVarejoVO().setFlagSetorImobiliario("2");
					break;
				//PROJETOS
				case 3:
					QuestionarioProjetoVO proj = new QuestionarioProjetoVO();
					segmentoService.manutencaoSetorProjetos(model, proj, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getAltoVarejoVO().setFlagSetorProjeto("2");
					break;
				//TRANSPORTE
				case 4:
					QuestionarioTransportesVO tran = new QuestionarioTransportesVO();
					segmentoService.manutencaoSetorTransporte(model, tran, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getAltoVarejoVO().setFlagSetorTransporte("2");
					break;
				}
				
//				siteUtil.getMessages().getMsgExclusaoSucesso();
				
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}

			viewHelper.getAltoVarejoVO().getSetorSelecionado().clear();
			listarSetor();
		}
	}

	public String alterarSetor() {
		try {
			TipoQuestionarioVO setorSelecionadoTabela = viewHelper.getAltoVarejoVO().getSetorSelecionado().get(0);
			QuestionarioAltoVarejoVO model = this.viewHelper.getAltoVarejoVO();
			Integer codigoSetor = setorSelecionadoTabela.getCodigo().intValue();
			String retorno = "";
			String paginaAnterior = RiccConstants.TELA_QUESTIONARIO_ALTOVAREJO;
			
			if (SetorEnum.AGRONEGOCIO.getCodigo().equals(codigoSetor)) {
				QuestionarioAgronegocioBean bean = (QuestionarioAgronegocioBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModel().setCodSegmento(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel().setDescGrupo(model.getNomeGrupo());
				bean.carregarDadosTela();
				bean.setPaginaAnterior(paginaAnterior);
				
			} else if (SetorEnum.IMOBILIARIO.getCodigo().equals(codigoSetor)) {
				QuestionarioImobiliarioBean bean = (QuestionarioImobiliarioBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getQuestionarioImobiliarioVO().setCodGrupoEconomico(model.getCodGrupo());
				bean.getViewHelper().getQuestionarioImobiliarioVO().setDescGrupoEconomico(model.getNomeGrupo());
				bean.getViewHelper().getQuestionarioImobiliarioVO().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getQuestionarioImobiliarioVO().setVersaoOrigem(model.getVersaoOrigem());
				bean.carregarDados();
				bean.setPaginaAnterior(paginaAnterior);
				
			} else if (SetorEnum.PROJETOS.getCodigo().equals(codigoSetor)) {
				QuestionarioProjetoBean bean = (QuestionarioProjetoBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
				bean.carregarDados();
				bean.setPaginaAnterior(paginaAnterior);
				
			} else if (SetorEnum.TRANSPORTE.getCodigo().equals(codigoSetor)) {
				QuestionarioTransportesBean bean = (QuestionarioTransportesBean) FacesUtils.getManagedBean(setorSelecionadoTabela.getNomeBean());
				retorno = bean.iniciarPagina();
				bean.getViewHelper().getModel().setCodGrupo(model.getCodGrupo());
				bean.getViewHelper().getModel().setCodSegmentoRelatorio(model.getCodSegmentoRelatorio());
				bean.getViewHelper().getModel().setCodRelatorio(model.getCodRelatorio());
				bean.getViewHelper().getModel().setNomeGrupo(model.getNomeGrupo());
				bean.carregarDados();
				bean.setPaginaAnterior(paginaAnterior);
			}
			viewHelper.getAltoVarejoVO().getSetorSelecionado().clear();
			return retorno;
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		return VAZIO;
	}
	
	private boolean validarAnosIguais(){
		
		boolean ret = true;
		
		if(isAnosIguais(viewHelper.getAltoVarejoVO().getFaturamentoA().getAno(), 
				viewHelper.getAltoVarejoVO().getFaturamentoB().getAno(),
				viewHelper.getAltoVarejoVO().getFaturamentoC().getAno(), 
				"Os anos do quadro Faturamento Consolidado devem ser diferentes")){
			
			ret = false;
		}
		
		if(isAnosIguais(viewHelper.getAltoVarejoVO().getFaturamento().getAno1(), 
				viewHelper.getAltoVarejoVO().getFaturamento().getAno2(),
				viewHelper.getAltoVarejoVO().getFaturamento().getAno3(), 
				"Os anos do quadro Abertura Faturamento devem ser diferentes")){
			
			ret = false;
		}
		
		if(isAnosIguais(viewHelper.getAltoVarejoVO().getImportacaoExportacaoA().getAno(), 
				viewHelper.getAltoVarejoVO().getImportacaoExportacaoB().getAno(),
				viewHelper.getAltoVarejoVO().getImportacaoExportacaoC().getAno(), 
				"Os anos do quadro Mercado Externo devem ser diferentes")){
			
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
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		boolean retorno = true;
		if (siteUtil.isEmptyOrNull(model.getNomeRelatorio())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_nome_relatorio");
			retorno = false;
		}
		
		if (siteUtil.isEmptyOrNull(model.getDescAtividade())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_quest_corporate_descrever");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getDescOrganograma())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_quest_corporate_Organograma");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getAdministracao())
				|| siteUtil.isEmptyOrNull(model.getPlanoSucessao())) {
			siteUtil.getMessages().getMsgCamposObrigatoriosTodos(
					"label_quadro_administrativo");
			retorno = false;
		}
		if (model.getListaAdms().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_administracao");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getDescPlanoSucessao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_detalhar_plano_sucessao");
			retorno = false;
		}
		if (model.getListaFornecedor().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_fornecedores");
			retorno = false;
		}
		if (model.getListaCliente().isEmpty()) {
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
		if (model.getListaConcorrentes().isEmpty()) {
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
		
//		if (siteUtil.isEmptyOrNull(model.getNomeHighlightsEmpresa())) {
//			siteUtil.getMessages().getMsgCampoObrigatorio(
//					"label_highlights_empresa");
//			retorno = false;
//		}
		
//		if (!validarCamposHighlights()) {
//			siteUtil.getMessages().getMsgColunaObrigatoria(
//					"label_highlights_empresa");
//			retorno = false;
//		}
		
		if (siteUtil.isEmptyOrNull(model.getDescBalanco())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_comentarios_situacao_atual");
			retorno = false;
		}
		if (model.getListaDividas().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_endividamento_bancario");
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
		if (!validarCamposMercadoExterno()) {
			retorno = false;
		}
//		if (model.getListaCartao().isEmpty()) {
//			siteUtil.getMessages().getMsgListaDeveConterItem(
//					"label_cartoes_m");
//			retorno = false;
//		}
		
		return retorno;
	}

	public boolean validarCamposReciprocidades() {
		VolumeBradescoVO volume = getViewHelper().getAltoVarejoVO()
				.getVolume();
		if(siteUtil.isEmptyOrNull(volume.getAno()) || siteUtil.isEmptyOrNull(volume.getMes())){
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
			if (siteUtil
					.isNotEmptyOrNull(volume.getCreditoConsignadoQtdFuncionarios())) {
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

	public String voltar() {
		return ((CadastramentoRicBean) FacesUtils
				.getManagedBean(RiccConstants.BEAN_CADASTRAMENTO_RIC))
				.carregarListaCadastramento();
	}

	public void listarSegmento(){
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setNomeRelatorio(RiccConstants.VAZIO);
		model.setAdministracao(RiccConstants.VAZIO);
		model.setPlanoSucessao(RiccConstants.VAZIO);
		model.setInformarAtraso(RiccConstants.VAZIO);
		
		try {
			segmentoService.consultaSegmento(model);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarQuadroAdm() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setListaAdms(new ArrayList<QuadroAdministrativoVO>());
		model.setAdmsSelecionado(new ArrayList<QuadroAdministrativoVO>());
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		try {
			model.setListaAdms(
					segmentoService.consultaQuadroAdministrativo(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaAdms().size() < Numeros.CINCO){
			model.getListaAdms().add(new QuadroAdministrativoVO());
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
		for (QuadroAdministrativoVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaAdms()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaAdms(listaCopia);
	}
	
	public void listarPatrimonio() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setListaPatrimonio(new ArrayList<DetalhamentoPatrimonioVO>());
		model.setPatrimonioSelecionado(new ArrayList<DetalhamentoPatrimonioVO>());
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		try {
			StringBuilder builder = new StringBuilder();
			model.setListaPatrimonio(segmentoService
					.consultaDetalhamentoPatrimonio(model, builder));
			model.setTotalPatrimonio(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaPatrimonio().size() < Numeros.DEZ){
			model.getListaPatrimonio().add(new DetalhamentoPatrimonioVO());
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
		for (DetalhamentoPatrimonioVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaPatrimonio()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaPatrimonio(listaCopia);
	}
	
	
	public void listarCapacidadeProdutiva() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setListaCapacidade(new ArrayList<CapacidadeProdutivaVO>());
		model.setCapacidadeSelecionado(new ArrayList<CapacidadeProdutivaVO>());
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		StringBuilder totalCapacidade = new StringBuilder();
		StringBuilder totalProducao = new StringBuilder();
		try {
			model.setListaCapacidade(segmentoService
					.consultaCapacidadeProdutiva(model, totalCapacidade, totalProducao));
			model.setTotalCapacidade(totalCapacidade.toString());
			model.setTotalProducao(totalProducao.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaCapacidade().size() < Numeros.DEZ){
			model.getListaCapacidade().add(new CapacidadeProdutivaVO());
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
		for (CapacidadeProdutivaVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaCapacidade()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaCapacidade(listaCopia);
	}
	
	public void listarFornecedor() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setListaFornecedor(new ArrayList<FornecedorVO>());
		
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		try {
			model.setListaFornecedor(segmentoService.consultaFornecedor(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaFornecedor().size() < Numeros.CINCO){
			model.getListaFornecedor().add(new FornecedorVO());
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
		for (FornecedorVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaFornecedor()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaFornecedor(listaCopia);
	}
	
	public void listarCliente() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setListaCliente(new ArrayList<ClienteVO>());
		
		model.getCliente().setNumSequencial(Numeros.UM.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);
		
		try {
			model.setListaCliente(segmentoService.consultaCliente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaCliente().size() < Numeros.CINCO){
			model.getListaCliente().add(new ClienteVO());
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
		for (ClienteVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaCliente()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaCliente(listaCopia);
	}
	
	public void listarFormaRecebimento() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setListaRecebimento(new ArrayList<FormaRecebimentoVO>());
		
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		model.getRecebimento().setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
		
		try {
			model.setListaRecebimento(segmentoService.consultaFormaRecebimento(model));
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
		for (FormaRecebimentoVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaRecebimento()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaRecebimento(listaCopia);
	}
	
	public void listarConcorrente() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setListaConcorrentes(new ArrayList<ConcorrenteVO>());
		
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		model.getRecebimento().setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
		
		try {
			model.setListaConcorrentes(segmentoService.consultaConcorrente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaConcorrentes().size() < Numeros.CINCO){
			model.getListaConcorrentes().add(new ConcorrenteVO());
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
		for (ConcorrenteVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaConcorrentes()) {
			voCopia = new ConcorrenteVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getConcorrente())){
				voCopia.setConcorrente("");
			}
			
			listaCopia.add(voCopia);
		}
		viewHelper.getAltoVarejoVO().setCopiaListaConcorrentes(listaCopia);
	}
	
	public void listarContrato() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setListaContrato(new ArrayList<CarteiraContratosVO>());
		
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		StringBuilder totalContrato = new StringBuilder();
		StringBuilder totalSaldo = new StringBuilder();
		try {
			model.setListaContrato(segmentoService.consultaCarteiraContratos(model, totalContrato, totalSaldo));
			model.setTotalContrato(totalContrato.toString());
			model.setTotalSaldoContrato(totalSaldo.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaContrato().size() < 30){
			model.getListaContrato().add(new CarteiraContratosVO());
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
		for (CarteiraContratosVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaContrato()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaContrato(listaCopia);
	}
	
//	public void salvarReciprocidades() throws RiccException {
//		
//		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
//		
//		if (siteUtil.isNotEmptyOrNull(model.getVolume().getMes())) {
//			int mes = Integer.parseInt(model.getVolume().getMes());
//			if(mes < 1 || mes > 12){
//				throw new IllegalArgumentException("Campo Mês de 'Reciprocidades não capturadas' Inválido");
//			}
//		}
//
//		segmentoService.manutencaoVolumeBradesco(model,
//				model.getVolume(),TipoManutencaoEnum.MANUTENCAO.getCodigoString());
//	}
	
	public void salvarMercadoExterno(){
		
		List<ImportacoesExportacoesVO> listaVolume = new ArrayList<ImportacoesExportacoesVO>();
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		ImportacoesExportacoesVO importExportA = model.getImportacaoExportacaoA();
		ImportacoesExportacoesVO importExportB = model.getImportacaoExportacaoB();
		ImportacoesExportacoesVO importExportC = model.getImportacaoExportacaoC();
		listaVolume.add(importExportA);
		listaVolume.add(importExportB);
		listaVolume.add(importExportC);
		
		if (siteUtil.isNotEmptyOrNull(model.getImportacaoExportacaoC().getMes())) {
			int mes = Integer.parseInt(model.getImportacaoExportacaoC().getMes());
			if(mes < 1 || mes > 12){
				throw new IllegalArgumentException("Campo Mês de 'Mercado Externo' inválido");
			}
		}

		segmentoService.manutencaoImportacoesExportacoes(model, listaVolume,
				TipoManutencaoEnum.MANUTENCAO.getCodigoString(),
				model.getMoedaExportacao());
		
	}
	
	public void salvarHighlightsEmpresa() throws RiccException {
		List<HighlightsEmpresaVO> listaHighlightsEmpresa = new ArrayList<HighlightsEmpresaVO>();
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		HighlightsEmpresaVO balancoA = model.getBalancoA();
//		if (siteUtil.valueToMainframeBigDecimal(model.getBalancoA().getMargemOperacional()).doubleValue() > 100.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual Balanço A maior que 100,00%!", Boolean.FALSE);
//			return;
//		}
		HighlightsEmpresaVO balancoB = model.getBalancoB();
//		if (siteUtil.valueToMainframeBigDecimal(model.getBalancoB().getMargemOperacional()).doubleValue() > 100.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual Balanço B maior que 100,00%!", Boolean.FALSE);
//			return;
//		}
		HighlightsEmpresaVO balancoC = model.getBalancoC();
//		if (siteUtil.valueToMainframeBigDecimal(model.getBalancoC().getMargemOperacional()).doubleValue() > 100.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual Balanço C maior que 100,00%!", Boolean.FALSE);
//			return;
//		}
		listaHighlightsEmpresa.add(balancoA);
		listaHighlightsEmpresa.add(balancoB);
		listaHighlightsEmpresa.add(balancoC);
		
		segmentoService.manutencaoHighlightsEmpresa(
				model, listaHighlightsEmpresa,TipoManutencaoEnum.MANUTENCAO, model.getNomeHighlightsEmpresa());
	}
	
	public void botaoNovoHighlights(){
		viewHelper.getAltoVarejoVO().setBalancoA(viewHelper.getAltoVarejoVO().getBalancoB());
		viewHelper.getAltoVarejoVO().setBalancoB(viewHelper.getAltoVarejoVO().getBalancoC());
		viewHelper.getAltoVarejoVO().setBalancoC(new HighlightsEmpresaVO());
	}

	public void salvarFaturamentoConsolidado() throws RiccException {
		List<FaturamentoConsolidadoVO> listaFaturamento = new ArrayList<FaturamentoConsolidadoVO>();
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		FaturamentoConsolidadoVO faturamentoA = model.getFaturamentoA();
		FaturamentoConsolidadoVO faturamentoB = model.getFaturamentoB();
		FaturamentoConsolidadoVO faturamentoC = model.getFaturamentoC();
		listaFaturamento.add(faturamentoA);
		listaFaturamento.add(faturamentoB);
		listaFaturamento.add(faturamentoC);
		
		segmentoService.manutencaoFaturamentoConsolidado(model, listaFaturamento, "0");
		
		listarFaturamentoConsolidado();
		
	}
	
	public void listarFaturamentoConsolidado() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setFaturamentoA(new FaturamentoConsolidadoVO());
		model.setFaturamentoB(new FaturamentoConsolidadoVO());
		model.setFaturamentoC(new FaturamentoConsolidadoVO());
		
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		
		try {
			List<FaturamentoConsolidadoVO> retornoMainframe = segmentoService.consultaFaturamentoConsolidado(model);
			model.setFaturamentoA(retornoMainframe.get(0));
			model.setFaturamentoB(retornoMainframe.get(1));
			model.setFaturamentoC(retornoMainframe.get(2));
			
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void consultarFaturamentoSegmento() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		try {
			model.setFaturamento(segmentoService.consultaFaturamentoSegmento(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void salvarFaturamentoSegmento() throws RiccException {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();

		segmentoService.manutencaoFaturamentoSegmento(model,
				model.getFaturamento(),
				TipoManutencaoEnum.MANUTENCAO);
	}
	
	public void listarHighlightsEmpresa() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setNomeHighlightsEmpresa(RiccConstants.VAZIO);
		model.setBalancoA(new HighlightsEmpresaVO());
		model.setBalancoB(new HighlightsEmpresaVO());
		model.setBalancoC(new HighlightsEmpresaVO());
		
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
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
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
		while(model.getListaDividas().size() < 15){
			model.getListaDividas().add(new EndividamentoBancarioVO());
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
		for (EndividamentoBancarioVO itemTabela : this.viewHelper.getAltoVarejoVO().getListaDividas()) {
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
		viewHelper.getAltoVarejoVO().setCopiaListaDividas(listaCopia);
	}

	public void listarMercadoExterno() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		model.setMoedaExportacao(RiccConstants.VAZIO);
		model.setImportacaoExportacaoA(new ImportacoesExportacoesVO());
		model.setImportacaoExportacaoB(new ImportacoesExportacoesVO());
		model.setImportacaoExportacaoC(new ImportacoesExportacoesVO());
		
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
	
//	public void listarReciprocidades() {
//		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
//		
//		model.setVolume(new VolumeBradescoVO());
//		
//		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
//		
//		try {
//			model.setVolume(segmentoService.consultaVolumeBradesco(model));
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//	}
//	
//	public void listarCartoes() {
//		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
//		
//		model.setListaCartao(new ArrayList<CartaoVO>());
//		
//		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
//		
//		try {
//			model.setListaCartao(segmentoService.consultaCartoes(model));
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//	}
	
	public boolean validarCamposFaturamentoConsolidado() {
		FaturamentoConsolidadoVO fat = viewHelper.getAltoVarejoVO()
				.getFaturamentoA();
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
		
		if(siteUtil.isNotEmptyOrNull(viewHelper.getAltoVarejoVO().getFaturamentoB().getAno()) ||
				siteUtil.isNotEmptyOrNull(viewHelper.getAltoVarejoVO().getFaturamentoC().getAno()) ){
			
			int anoA = Integer.parseInt(viewHelper.getAltoVarejoVO().getFaturamentoA().getAno());
			int anoB = Integer.parseInt(viewHelper.getAltoVarejoVO().getFaturamentoB().getAno());
			int anoC = Integer.parseInt(viewHelper.getAltoVarejoVO().getFaturamentoC().getAno());
			
			// Anos posteriores não podem ser menores
			if (anoA > anoB || anoB > anoC) {
				siteUtil.getMessages().getMsgInformada("msg_faturamento_consolidado_ano_invalido");
				return false;
			} 
		}
		return true;
	}
	
	public boolean validarCamposAberturaFaturamento() {
		FaturamentoPorSegmentoVO faturamento = viewHelper.getAltoVarejoVO().getFaturamento();

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
	
//	public boolean validarCamposHighlights() {
//		HighlightsEmpresaVO a = viewHelper.getAltoVarejoVO().getBalancoA();
//		if (siteUtil.isEmptyOrNull(a.getBalanco())) {
//			return false;
//		} else {
//			if(siteUtil.isEmptyOrNull(a.getReceitaLiquida())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getContasAReceber())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getEstoques())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getGerBrutaCaixa())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getMargemOperacional())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getLucroPrejuizoLiquido())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getPatrimonioLiquido())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getEndividamentoFinanceiroTotal())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getDisponibilidades())) {
//				return false;
//			} else if(siteUtil.isEmptyOrNull(a.getEndividamentoFinanceiroLiquido())) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	public boolean validarCamposMercadoExterno() {
		ImportacoesExportacoesVO a = viewHelper.getAltoVarejoVO().getImportacaoExportacaoA();
		ImportacoesExportacoesVO b = viewHelper.getAltoVarejoVO().getImportacaoExportacaoB();
		ImportacoesExportacoesVO c = viewHelper.getAltoVarejoVO().getImportacaoExportacaoC();
		
		// Moeda vazio -> false se o primeiro ano estiver inválido
		if (siteUtil.isEmptyOrNull(viewHelper.getAltoVarejoVO().getMoedaExportacao())
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
	
	public void listarSetor() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		
		try {
			model.setListaSetor(segmentoService.consultaSetores(model));
			viewHelper.setComboSetor(siteUtil.carregarComboSetor(
					viewHelper.getComboSetor(), model.getListaSetor()));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	private void consultaComentarios() {
		QuestionarioAltoVarejoVO model = viewHelper.getAltoVarejoVO();
		try {
			// DETALHE SEGMENTO - 1(1,2)
			List<ComentarioVO> comentarioSegmento = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_SEGMENTO);
			model.setDescAtividade(comentarioSegmento.get(0)
					.getComentario());
			model.setDescOrganograma(comentarioSegmento.get(1)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// QUADRO ADM - 2(1)
			List<ComentarioVO> comentarioQuadroAdm = segmentoService.consultaComentarios(
					model, RiccConstants.TIPO_COMENTARIO_QUADRO_ADM);
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
				model.setDescCapacidadeProd(comentarioCapacidadeProdutiva
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
			model.setDescConcorrentes(comentarioClienteFornecedor.get(2)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		try {
			// CARTEIRA 6(1)
			List<ComentarioVO> comentarioCarteira = segmentoService.consultaComentarios(
					model, RiccConstants.TIPO_COMENTARIO_CONTRATOS_CLIENTE);
				model.setDescContrato(comentarioCarteira.get(0).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		try {
			// FATURAMENTO CONSOLIDADO - 7(1)
			List<ComentarioVO> comentarioHighlightsEmpresa = segmentoService
					.consultaComentarios(model,
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
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_ENDIVIDAMENTO_BANCARIO);
			model.setDescDivida(comentarioEndividamento.get(
					0).getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

		try {
			// RECIPROCIDADES 10(1)
			List<ComentarioVO> comentarioReciprocidade = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_RECIPROCIDADE);
			model.setDescCartao(comentarioReciprocidade.get(0)
					.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	//calcular total patrimonio Real Time
	public void patrimonioTotal(AjaxBehaviorEvent e) {
		BigInteger soma = new BigInteger("0");
		for (DetalhamentoPatrimonioVO itemTabela : viewHelper.getAltoVarejoVO().getListaPatrimonio()) {
			if(siteUtil.isNotEmptyOrNull(itemTabela.getValorPatrimonio())){
				soma = soma.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getValorPatrimonio())));
			}
		}
		getViewHelper().getAltoVarejoVO().setTotalPatrimonio(soma.toString());
	}
	
	public void capacidadeProdutivaTotal(AjaxBehaviorEvent e) {
		BigInteger somaProducao = new BigInteger("0");
		BigInteger somaUtilizada = new BigInteger("0");
		for (CapacidadeProdutivaVO itemTabela : viewHelper.getAltoVarejoVO().getListaCapacidade()) {
			if(siteUtil.isNotEmptyOrNull(itemTabela.getProducao())){
				somaProducao = somaProducao.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getProducao())));
			}
			if(siteUtil.isNotEmptyOrNull(itemTabela.getUtilizada())){
				somaUtilizada = somaUtilizada.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getUtilizada())));
			}
		}
		getViewHelper().getAltoVarejoVO().setTotalCapacidade(somaProducao.toString());
		getViewHelper().getAltoVarejoVO().setTotalProducao(somaUtilizada.toString());
	}
	
	public void carteiraContratosTotal(AjaxBehaviorEvent e) {
		BigInteger somaValorContrato = new BigInteger("0");
		BigInteger somaSaldoPerformar = new BigInteger("0");
		for (CarteiraContratosVO itemTabela : viewHelper.getAltoVarejoVO().getListaContrato()) {
			if(siteUtil.isNotEmptyOrNull(itemTabela.getValorContrato())){
				somaValorContrato = somaValorContrato.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getValorContrato())));
			}
			if(siteUtil.isNotEmptyOrNull(itemTabela.getSaldoPerformar())){
				somaSaldoPerformar = somaSaldoPerformar.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getSaldoPerformar())));
			}
		}
		getViewHelper().getAltoVarejoVO().setTotalContrato(somaValorContrato.toString());
		getViewHelper().getAltoVarejoVO().setTotalSaldoContrato(somaSaldoPerformar.toString());
	}
	
	public void faturamentoConsolidadoTotalGeral(AjaxBehaviorEvent e) {
		
		faturamentoConsolidadoTotalA(e);
		faturamentoConsolidadoTotalB(e);
		faturamentoConsolidadoTotalC(e);
		
	}
	
	public void faturamentoConsolidadoTotalA(AjaxBehaviorEvent e) {
		BigInteger janeiro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getJaneiro());
		BigInteger fevereiro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getFevereiro());
		BigInteger marco = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getMarco());
		BigInteger abril = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getAbril());
		BigInteger maio = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getMaio());
		BigInteger junho = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getJunho());
		BigInteger julho = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getJulho());
		BigInteger agosto = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getAgosto());
		BigInteger setembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getSetembro());
		BigInteger outubro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getOutubro());
		BigInteger novembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getNovembro());
		BigInteger dezembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoA().getDezembro());
		
		BigDecimal total = new BigDecimal("0");
		BigDecimal media = new BigDecimal("0");
		
		total = new BigDecimal (janeiro.add(fevereiro).add(marco).add(abril).add(maio).add(junho).add(julho).add(agosto).
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
		
		getViewHelper().getAltoVarejoVO().getFaturamentoA().setTotalFaturamento(total.setScale(0, RoundingMode.HALF_EVEN).toString());
		getViewHelper().getAltoVarejoVO().getFaturamentoA().setMediaFaturamento(media.setScale(0, RoundingMode.HALF_EVEN).toString());
	}
	
	public void faturamentoConsolidadoTotalB(AjaxBehaviorEvent e) {
		BigInteger janeiro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getJaneiro());
		BigInteger fevereiro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getFevereiro());
		BigInteger marco = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getMarco());
		BigInteger abril = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getAbril());
		BigInteger maio = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getMaio());
		BigInteger junho = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getJunho());
		BigInteger julho = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getJulho());
		BigInteger agosto = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getAgosto());
		BigInteger setembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getSetembro());
		BigInteger outubro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getOutubro());
		BigInteger novembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getNovembro());
		BigInteger dezembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoB().getDezembro());
		
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
		
		getViewHelper().getAltoVarejoVO().getFaturamentoB().setTotalFaturamento(total.setScale(0, RoundingMode.HALF_EVEN).toString());
		getViewHelper().getAltoVarejoVO().getFaturamentoB().setMediaFaturamento(media.setScale(0, RoundingMode.HALF_EVEN).toString());
	}
	
	public void faturamentoConsolidadoTotalC(AjaxBehaviorEvent e) {
		BigInteger janeiro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getJaneiro());
		BigInteger fevereiro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getFevereiro());
		BigInteger marco = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getMarco());
		BigInteger abril = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getAbril());
		BigInteger maio = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getMaio());
		BigInteger junho = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getJunho());
		BigInteger julho = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getJulho());
		BigInteger agosto = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getAgosto());
		BigInteger setembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getSetembro());
		BigInteger outubro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getOutubro());
		BigInteger novembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getNovembro());
		BigInteger dezembro = siteUtil.valueToMainframeBigInteger(viewHelper.getAltoVarejoVO().getFaturamentoC().getDezembro());
		
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
		
		getViewHelper().getAltoVarejoVO().getFaturamentoC().setTotalFaturamento(total.setScale(0, RoundingMode.HALF_EVEN).toString());
		getViewHelper().getAltoVarejoVO().getFaturamentoC().setMediaFaturamento(media.setScale(0, RoundingMode.HALF_EVEN).toString());
	}
	
	public void endividamentoTotal(AjaxBehaviorEvent e) {
		BigInteger soma = new BigInteger("0");
		for (EndividamentoBancarioVO itemTabela : viewHelper.getAltoVarejoVO().getListaDividas()) {
			if(siteUtil.isNotEmptyOrNull(itemTabela.getSaldo())){
				soma = soma.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getSaldo())));
			}
		}
		getViewHelper().getAltoVarejoVO().setTotalSaldo(soma.toString());
	}

	public AltoVarejoViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(AltoVarejoViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}
	
}
