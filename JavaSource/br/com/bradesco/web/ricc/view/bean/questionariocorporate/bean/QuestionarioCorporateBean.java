package br.com.bradesco.web.ricc.view.bean.questionariocorporate.bean;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
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
import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.enums.SetorEnum;
import br.com.bradesco.web.ricc.enums.SituacaoRelatorioEnum;
import br.com.bradesco.web.ricc.enums.TipoFuncaoEnum;
import br.com.bradesco.web.ricc.enums.TipoManutencaoEnum;
import br.com.bradesco.web.ricc.exception.RiccException;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariocorporate.QuadroAtivosCorporateVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariocorporate.QuestionarioCorporateVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioimobiliario.QuestionarioImobiliarioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioprojeto.QuestionarioProjetoVO;
import br.com.bradesco.web.ricc.model.cadastro.questionariotransportes.QuestionarioTransportesVO;
import br.com.bradesco.web.ricc.model.questionario.ComentarioVO;
import br.com.bradesco.web.ricc.model.segmento.CarteiraContratosVO;
import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.segmento.ConcorrenteVO;
import br.com.bradesco.web.ricc.model.segmento.EndividamentoBancarioVO;
import br.com.bradesco.web.ricc.model.segmento.FormaRecebimentoVO;
import br.com.bradesco.web.ricc.model.segmento.FornecedorVO;
import br.com.bradesco.web.ricc.model.segmento.HighlightsEmpresaVO;
import br.com.bradesco.web.ricc.model.segmento.ImportacoesExportacoesVO;
import br.com.bradesco.web.ricc.model.segmento.PerspectivasVO;
import br.com.bradesco.web.ricc.model.segmento.QuadroAdministrativoVO;
import br.com.bradesco.web.ricc.model.segmento.VolumeBradescoVO;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.utils.RiccMessages;
import br.com.bradesco.web.ricc.utils.SiteUtil;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.cadastro.bean.CadastramentoRicBean;
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean.QuestionarioAgronegocioBean;
import br.com.bradesco.web.ricc.view.bean.questionariocorporate.viewhelper.QuestionarioCorporateViewHelper;
import br.com.bradesco.web.ricc.view.bean.questionarioimobiliario.bean.QuestionarioImobiliarioBean;
import br.com.bradesco.web.ricc.view.bean.questionarioprojetos.bean.QuestionarioProjetoBean;
import br.com.bradesco.web.ricc.view.bean.questionariotransportes.bean.QuestionarioTransportesBean;

@SessionScoped
@Named(value = "questionarioCorporateBean")
public class QuestionarioCorporateBean extends AbstractBean<QuestionarioCorporateViewHelper> {

	/**
	 * Atributo segmentoService 
	 * Tipo ISegmentoService
	 */
	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;
	
	private ArrayList<String> mensagens = new ArrayList<String>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6100622338098132505L;
	
	@Override
	public String iniciarPagina() {
		setViewHelper(new QuestionarioCorporateViewHelper());
		viewHelper.inicializar();
		if (viewHelper.getModel().getListaSetor().isEmpty()) {
			viewHelper.setComboSetor(siteUtil.carregarListaSetor());
		}
		this.viewHelper.getModel().setCodSegmentoRelatorio(
				String.valueOf(SegmentoEnum.CORPORATE.getCodigo()));
		try {
			carregarCopiaLista();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
		siteUtil.retirarMensagemDuplicada();
		return RiccConstants.TELA_QUESTIONARIO_CORPORATE;
	}
	
	public void carregarDados() {
		
		if (siteUtil.isNotEmptyOrNull(viewHelper.getModel().getCodRelatorio())) {
			consultaComentarios();
			consultaSegmento();
			listarQuadroAtivos();
			listarQuadroAdm();
			listarFornecedores();
			listarClientes();
			listarFormaRecebimento();
			listarConcorrentes();
			listarCarteiraContratos();
			consultaHighlightsEmpresa();
			listarEndividamentoBancario();
			consultaMercadoExterno();
			consultaPerspectivaEmpresa();
			listarSetor();
		}
	}
	
	public void carregarCopiaLista() throws IllegalAccessException, InvocationTargetException {
		copiarQuadroAtivos();
		copiarQuadroAdministrativo();
		copiarFornecedores();
		copiarCliente();
		copiarRecebimento();
		copiarConcorrentes();
		copiarCarteiraContratos();
		copiarEndividamento();
	}
	
	public void carregarManutencaoRelatorioSegmento(TipoManutencaoEnum tipoManutencao) {
		segmentoService.manutencaoRelatorioSegmento(this.getViewHelper()
				.getModel(), tipoManutencao);
	}
	
	public void consultaSegmento() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		try {
			segmentoService.consultaSegmento(model);
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void consultaComentarios() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		// COMENTÁRIOS - CODTIPO(SEQUENCIAIS)

		try {
			// DETALHE SEGMENTO - 1(1,2)
			List<ComentarioVO> comentarioSegmento = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_SEGMENTO);
			model.setDescAtividadeEmpresa(comentarioSegmento.get(0).getComentario());
			model.setOrganogramaControleAcionario(comentarioSegmento.get(1)
					.getComentario());
			
			// QUADRO ATIVOS - 11(1)
			ComentarioVO comentarioQuadroAtivos = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_QUADRO_ATIVOS).get(0);
			model.setDescQuadroAtivos(comentarioQuadroAtivos.getComentario());
			
			// QUADRO ADM - 2(1)
			ComentarioVO comentarioQuadroAdm = segmentoService.consultaComentarios(
					model, RiccConstants.TIPO_COMENTARIO_QUADRO_ADM).get(0);
			model.setDescQuadroAdministrativo(comentarioQuadroAdm.getComentario());

			// CLIENTE/FORNECEDOR - 5(1,2,3)
			List<ComentarioVO> comentarioClienteFornecedor = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_CLIENTE_FORNECEDOR);

			// SEQUENCIAL 1 - FORNECEDORES
			model.setDescFornecedor(comentarioClienteFornecedor.get(0).getComentario());
			
			// SEQUENCIAL 2 - FORMA RECEBIMENTO
			model.setDescFormaRecebimento(comentarioClienteFornecedor.get(1).getComentario());
			
			// SEQUENCIAL 3 - CONCORRENTES
			model.setDescConcorrente(comentarioClienteFornecedor.get(2).getComentario());
			
			// CARTEIRA 6(1)
			ComentarioVO comentarioCarteira = segmentoService.consultaComentarios(
					model, RiccConstants.TIPO_COMENTARIO_CONTRATOS_CLIENTE).get(0);
			model.setDescCarteira(comentarioCarteira.getComentario());

			// HIGHLIGHTS EMPRESA - 8(1)
			ComentarioVO comentarioHighlightsEmpresa = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_BALANCO_EMPRESA).get(0);
			model.setDescSituacaoFinanceira(comentarioHighlightsEmpresa.getComentario());
			
			// ENDIVIDAMENTO BANCARIO - 9(1)
			ComentarioVO comentarioEndividamento = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_ENDIVIDAMENTO_BANCARIO)
					.get(0);
			model.setDescEndividamentoBancario(comentarioEndividamento.getComentario());

			// MERCADO EXTERNO - 12(1,2)
			List<ComentarioVO> comentariosMercadoExterno = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_EXP_CAMBIAL);
			
			// SEQUENCIAL 1 - PRINCIPAIS PAISES...
			model.setPrincipaisPaisesExportaImporta(comentariosMercadoExterno.get(0).getComentario());

			// SEQUENCIAL 2 - DETALHES VARIACAO CAMBIAL
			model.setDetalheProtecaoCambialEmpresa(comentariosMercadoExterno.get(1).getComentario());

			// PERSPECTIVA EMPRESA 13(1,2)
			List<ComentarioVO> comentariosPerspectiva = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_PERSPECTIVAS);
			
			// SEQUENCIAL 1 - DETALHAR ESTRATEGIA
			model.setDetalheEstrategiaProjecao(comentariosPerspectiva.get(0).getComentario());
			// SEQUENCIAL 2 - PRINCIPAIS INVESTIMENTOS
			model.setDetalhePrincipaisInvestimentos(comentariosPerspectiva.get(1).getComentario());

			// RECIPROCIDADES 10(1)
			ComentarioVO comentarioReciprocidade = segmentoService
					.consultaComentarios(model,
							RiccConstants.TIPO_COMENTARIO_RECIPROCIDADE).get(0);
			model.setDescReciprocidades(comentarioReciprocidade.getComentario());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void listarQuadroAtivos() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		try {
			model.getQuadroAtivosSelecionado().clear();
			model.setListaQuadroAtivos(new ArrayList<QuadroAtivosCorporateVO>());
			model.setListaQuadroAtivos(segmentoService
					.consultaQuadroAtivos(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaQuadroAtivos().size() < Numeros.DEZ){
			model.getListaQuadroAtivos().add(new QuadroAtivosCorporateVO());
		}
		try {
			copiarQuadroAtivos();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	public void incluirAtivos() {
		if (validarCamposQuadroAtivos()) {
			QuadroAtivosCorporateVO dados = getViewHelper().getModel().getQuadroAtivos();
			QuestionarioCorporateVO model = viewHelper.getModel();
			
			QuadroAtivosCorporateVO ativos = new QuadroAtivosCorporateVO(
					dados.getConcessoesProjetosSpes(), dados.getPorcParticipacao(), dados.getInformacoesRelevantes());
			
			try {
				segmentoService.manutencaoQuadroAtivos(model, ativos, TipoManutencaoEnum.INCLUSAO.getCodigoString());
				getViewHelper().getModel().setQuadroAtivos(new QuadroAtivosCorporateVO());
//				RiccMessages.getInstance().getMsgInclusaoSucesso();
				listarQuadroAtivos();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}
		}
	}
	
	public boolean validarCamposQuadroAtivos() {
		QuadroAtivosCorporateVO model = viewHelper.getModel().getQuadroAtivos();
		if(siteUtil.isEmptyOrNull(model.getConcessoesProjetosSpes())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_concessoes_projetos_SPES");
			return false;
		}
		if(siteUtil.isEmptyOrNull(model.getPorcParticipacao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_porcent_participacao");
			return false;
		}
		if(siteUtil.isEmptyOrNull(model.getInformacoesRelevantes())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_infos_relevantes");
			return false;
		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getPorcParticipacao()).doubleValue() > 100.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
//			return false;
//		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getPorcParticipacao()).doubleValue() == 0.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
//			return false;
//		}
		return true;
	}
	
	public void excluirAtivos() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		QuadroAtivosCorporateVO ativoSelecionado = model.getQuadroAtivosSelecionado().get(0);
		
		viewHelper.getModel().setQuadroAtivosSelecionado(new ArrayList<QuadroAtivosCorporateVO>());
		try {
			segmentoService.manutencaoQuadroAtivos(model, ativoSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
			listarQuadroAtivos();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	public void listarQuadroAdm() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		try {
			model.getQuadroAdministrativoSelecionado().clear();
			model.setListaQuadroAdministrativo(new ArrayList<QuadroAdministrativoVO>());
			model.setListaQuadroAdministrativo(segmentoService
					.consultaQuadroAdministrativo(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while (model.getListaQuadroAdministrativo().size() < Numeros.CINCO) {
			model.getListaQuadroAdministrativo().add(
					new QuadroAdministrativoVO());
		}
		try {
			copiarQuadroAdministrativo();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	public void incluirAdministrativos() {
		if (validarCamposAdministrativos()) {
			QuestionarioCorporateVO model = getViewHelper()
					.getModel();

			model.setCodSegmentoRelatorio(Numeros.UM.toString());
			model.getQuadroAdministrativo().setNumSequencial(
					Numeros.ZERO.toString());

			try {
				segmentoService.manutencaoQuadroAdministrativo(model,
						model.getQuadroAdministrativo(),
						RiccConstants.MANUTENCAO_INCLUSAO);
//				RiccMessages.getInstance().getMsgInclusaoSucesso();
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
				return;
			}

			model.setQuadroAdministrativo(new QuadroAdministrativoVO());
			listarQuadroAdm();
		}
	}

	public void excluirAdministrativos() {
		QuestionarioCorporateVO model = getViewHelper()
				.getModel();
		QuadroAdministrativoVO itemSelecionado = model
				.getQuadroAdministrativoSelecionado().get(0);

		model.setQuadroAdministrativoSelecionado(new ArrayList<QuadroAdministrativoVO>());
		try {
			segmentoService.manutencaoQuadroAdministrativo(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		listarQuadroAdm();
	}
	
	public boolean validarCamposAdministrativos() {
		QuadroAdministrativoVO model = viewHelper.getModel().getQuadroAdministrativo();
		if(siteUtil.isEmptyOrNull(model.getAdministrador())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_administradores");
			return false;
		}
		if(siteUtil.isEmptyOrNull(model.getCargo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_cargo");
			return false;
		}
		return true;
	}
	
	public void listarFornecedores() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		try {
			model.getFornecedorSelecionado().clear();
			model.setListaFornecedor(new ArrayList<FornecedorVO>());
			model.setListaFornecedor(segmentoService
					.consultaFornecedor(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaFornecedor().size() < Numeros.CINCO){
			model.getListaFornecedor().add(new FornecedorVO());
		}
		try {
			copiarFornecedores();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	public void incluirFornecedores() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getFornecedor().setNumSequencial(Numeros.ZERO.toString());
		model.getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		
//		if (siteUtil.valueToMainframeBigDecimal(model.getFornecedor().getPorcentagem()).doubleValue() > 100.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
//			return;
//		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getFornecedor().getPorcentagem()).doubleValue() == 0.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
//			return;
//		}
		
		try {
			segmentoService.manutencaoFornecedor(model, model.getFornecedor(),
					RiccConstants.MANUTENCAO_INCLUSAO);
//			RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setFornecedor(new FornecedorVO());
		listarFornecedores();
	}
	
	public void excluirFornecedores() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		FornecedorVO fornecedor = model.getFornecedorSelecionado().get(0);
		fornecedor.setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);

		model.setFornecedorSelecionado(new ArrayList<FornecedorVO>());
		try {
			segmentoService.manutencaoFornecedor(model, fornecedor,
					RiccConstants.MANUTENCAO_EXCLUSAO);
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		listarFornecedores();
	}
	
	public boolean validarCamposPrincipaisFornecedores() {
		FornecedorVO model = viewHelper.getModel().getFornecedor();
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
	
	public void listarClientes() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.getCliente().setNumSequencial(Numeros.UM.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		try {
			model.getClienteSelecionado().clear();
			model.setListaCliente(new ArrayList<ClienteVO>());
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
	
	public void copiarCliente() throws IllegalAccessException, InvocationTargetException{
		ArrayList<ClienteVO> listaCopia = new ArrayList<ClienteVO>();
		ClienteVO voCopia = null;
		for (ClienteVO itemTabela : this.viewHelper.getModel().getListaCliente()) {
			voCopia = new ClienteVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getCliente())){
				voCopia.setCliente("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getPorcentagem())){
				voCopia.setPorcentagem("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaCliente(listaCopia);
	}
	
	public void copiarConcorrentes() throws IllegalAccessException, InvocationTargetException{
		ArrayList<ConcorrenteVO> listaCopia = new ArrayList<ConcorrenteVO>();
		ConcorrenteVO voCopia = null;
		for (ConcorrenteVO itemTabela : this.viewHelper.getModel().getListaConcorrente()) {
			voCopia = new ConcorrenteVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getConcorrente())){
				voCopia.setConcorrente("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaConcorrente(listaCopia);
	}
	
	public void copiarCarteiraContratos()throws IllegalAccessException, InvocationTargetException{
		ArrayList<CarteiraContratosVO> listaCopia = new ArrayList<CarteiraContratosVO>();
		CarteiraContratosVO voCopia = null;
		for (CarteiraContratosVO itemTabela : this.viewHelper.getModel().getListaCarteira()) {
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
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaCarteira(listaCopia);
	}
	
	public void copiarEndividamento()throws IllegalAccessException, InvocationTargetException{
		ArrayList<EndividamentoBancarioVO> listaCopia = new ArrayList<EndividamentoBancarioVO>();
		EndividamentoBancarioVO voCopia = null;
		for (EndividamentoBancarioVO itemTabela : this.viewHelper.getModel().getListaEndividamento()) {
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
			if(siteUtil.isEmptyOrNull(voCopia.getAmortizacao())){
				voCopia.setAmortizacao("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getDescGarantia())){
				voCopia.setDescGarantia("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaEndividamento(listaCopia);
	}
	
	

	public void incluirClientes() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getCliente().setNumSequencial(Numeros.ZERO.toString());
		model.getCliente().setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

//		if (siteUtil.valueToMainframeBigDecimal(model.getCliente().getPorcentagem()).doubleValue() > 100.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
//			return;
//		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getCliente().getPorcentagem()).doubleValue() == 0.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
//			return;
//		}
		
		
		try {
			segmentoService.manutencaoCliente(model, model.getCliente(),
					RiccConstants.MANUTENCAO_INCLUSAO);
//			RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setCliente(new ClienteVO());
		listarClientes();
	}
	
	public void excluirClientes() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		ClienteVO cliente = model.getClienteSelecionado().get(0);
		cliente.setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);

		model.setClienteSelecionado(new ArrayList<ClienteVO>());
		try {
			segmentoService.manutencaoCliente(model, cliente,
					RiccConstants.MANUTENCAO_EXCLUSAO);
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		listarClientes();
	}
	
	public void listarFormaRecebimento() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.getRecebimento().setNumSequencial(Numeros.UM.toString());
		model.getRecebimento().setTipoCliente(
				RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);

		try {
			model.getRecebimentoSelecionado().clear();
			model.setListaRecebimento(new ArrayList<FormaRecebimentoVO>());
			model.setListaRecebimento(segmentoService
					.consultaFormaRecebimento(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaRecebimento().size() < Numeros.CINCO){
			model.getListaRecebimento().add(new FormaRecebimentoVO());
		}
		try {
			copiarRecebimento();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	public void copiarRecebimento() throws IllegalAccessException, InvocationTargetException{
		ArrayList<FormaRecebimentoVO> listaCopia = new ArrayList<FormaRecebimentoVO>();
		FormaRecebimentoVO voCopia = null;
		for (FormaRecebimentoVO itemTabela : this.viewHelper.getModel().getListaRecebimento()) {
			voCopia = new FormaRecebimentoVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getFormaRecebimento())){
				voCopia.setFormaRecebimento("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getPorcentagem())){
				voCopia.setPorcentagem("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaRecebimento(listaCopia);
		
	}

	public void incluirFormaRecebimento() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getRecebimento().setNumSequencial(Numeros.ZERO.toString());
		model.getRecebimento().setTipoCliente(
				RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
		
//		if (siteUtil.valueToMainframeBigDecimal(model.getRecebimento().getPorcentagem()).doubleValue() > 100.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual maior que 100,00%!", Boolean.FALSE);
//			return;
//		}
//		if (siteUtil.valueToMainframeBigDecimal(model.getRecebimento().getPorcentagem()).doubleValue() == 0.00) {
//			BradescoFacesUtils.addInfoModalMessage("Valor percentual deve ser maior que 0,00%!", Boolean.FALSE);
//			return;
//		}
		try {
			segmentoService.manutencaoFormaRecebimento(model,
					model.getRecebimento(), RiccConstants.MANUTENCAO_INCLUSAO);
//			RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setRecebimento(new FormaRecebimentoVO());
		listarFormaRecebimento();
	}
	
	public void excluirFormaRecebimento() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		FormaRecebimentoVO recebimento = this.viewHelper.getModel()
				.getRecebimentoSelecionado().get(0);
		recebimento.setTipoCliente(
				RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);

		model.setRecebimentoSelecionado(new ArrayList<FormaRecebimentoVO>());
		try {
			segmentoService.manutencaoFormaRecebimento(model,
					recebimento, RiccConstants.MANUTENCAO_EXCLUSAO);
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		listarFormaRecebimento();
	}
	
	public boolean validarCamposFormaRecebimento() {
		FormaRecebimentoVO model = viewHelper.getModel().getRecebimento();
		if(siteUtil.isEmptyOrNull(model.getFormaRecebimento())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_forma_recebimento");
			return false;
		}
		if(siteUtil.isEmptyOrNull(model.getPorcentagem())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_percentual");
			return false;
		}
		
		return true;
	}
	
	public void listarConcorrentes() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.getConcorrente().setNumSequencial(Numeros.UM.toString());
		model.getConcorrente().setTipoCliente(
				RiccConstants.COD_TIPO_CONCORRENTE);

		try {
			model.getConcorrenteSelecionado().clear();
			model.setListaConcorrente(new ArrayList<ConcorrenteVO>());
			model.setListaConcorrente(segmentoService
					.consultaConcorrente(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaConcorrente().size() < Numeros.CINCO){
			model.getListaConcorrente().add(new ConcorrenteVO());
		}
		try {
			copiarConcorrentes();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	public void incluirPrincipaisConcorrentes() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getConcorrente().setNumSequencial(Numeros.ZERO.toString());
		model.getConcorrente().setTipoCliente(
				RiccConstants.COD_TIPO_CONCORRENTE);

		try {
			segmentoService.manutencaoConcorrente(model,
					model.getConcorrente(), RiccConstants.MANUTENCAO_INCLUSAO);
//			RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}

		model.setConcorrente(new ConcorrenteVO());
		listarConcorrentes();
	}
	
	public void excluirPrincipaisConcorrentes() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		ConcorrenteVO concorrente = this.viewHelper.getModel().getConcorrenteSelecionado().get(0);
		concorrente.setTipoCliente(
				RiccConstants.COD_TIPO_CONCORRENTE);

		model.setConcorrenteSelecionado(new ArrayList<ConcorrenteVO>());
		try {
			segmentoService.manutencaoConcorrente(model,
					concorrente, RiccConstants.MANUTENCAO_EXCLUSAO);
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		listarConcorrentes();
	}
	
	public boolean validarCamposPrincipaisConcorrentes() {
		ConcorrenteVO model = viewHelper.getModel().getConcorrente();
		if(siteUtil.isEmptyOrNull(model.getConcorrente())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_principais_concorrentes");
			return false;
		}
		return true;
	}
	
	public void listarCarteiraContratos() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		StringBuilder totalContrato = new StringBuilder();
		StringBuilder totalSaldo = new StringBuilder();
		try {
			model.getCarteiraSelecionado().clear();
			model.setListaCarteira(new ArrayList<CarteiraContratosVO>());
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
			copiarCarteiraContratos();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());	
		}
	}
	
	public void incluirCarteiraContratos() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		if (siteUtil.isEmptyOrNull(model.getCarteira().getDataTermino())) {
			BradescoFacesUtils.addInfoModalMessage("Data inválida!", Boolean.FALSE);
			return;
		}
		
		try {
			segmentoService.manutencaoCarteiraContratos(model,
					model.getCarteira(), RiccConstants.MANUTENCAO_INCLUSAO);
//			RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		model.setCarteira(new CarteiraContratosVO());
		listarCarteiraContratos();
	}
	
	public void excluirCarteiraContratos() {
		QuestionarioCorporateVO model = getViewHelper()
				.getModel();
		CarteiraContratosVO itemSelecionado = model
				.getCarteiraSelecionado().get(0);

		model.setCarteiraSelecionado(new ArrayList<CarteiraContratosVO>());
		try {
			segmentoService.manutencaoCarteiraContratos(model,
					itemSelecionado, RiccConstants.MANUTENCAO_EXCLUSAO);
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		listarCarteiraContratos();
	}
	
	public boolean validarCamposCarteiraContratos() {
		CarteiraContratosVO model = viewHelper.getModel().getCarteira();
		if(siteUtil.isEmptyOrNull(model.getProjetoObraServico())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_projeto_obra_servicos");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getCliente())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_cliente");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getValorContrato())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_valor_contrato");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getSaldoPerformar())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_saldo_performar");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getDataTermino())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_data_termino");
			return false;
		}
		return true;
	}	
	
	public void consultaHighlightsEmpresa() {
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
	
	public void listarEndividamentoBancario() { 
		StringBuilder builder = new StringBuilder();
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.getEndividamentoSelecionado().clear();
			model.setListaEndividamento(new ArrayList<EndividamentoBancarioVO>());
			model.setListaEndividamento(segmentoService
					.consultaEndividamentoBancario(model, builder));
			model.setEndividamentoTotalSaldo(builder.toString());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		while(model.getListaEndividamento().size() < 15){
			model.getListaEndividamento().add(new EndividamentoBancarioVO());
		}
		try {
			copiarEndividamento();
		} catch (IllegalAccessException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		} catch (InvocationTargetException e) {
			BradescoFacesUtils.addErrorModalMessage(e.getMessage());
		}
	}
	
	public void incluirEndividamentoBancario() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		model.getEndividamento().setNumSequencial(Numeros.ZERO.toString());
		
		if (siteUtil.isEmptyOrNull(model.getEndividamento().getVencimentoFinal())) {
			BradescoFacesUtils.addInfoModalMessage("Data inválida!", Boolean.FALSE);
			return;
		}
		try {
			segmentoService.manutencaoEndividamentoBancario(model,
					model.getEndividamento(), TipoManutencaoEnum.INCLUSAO);
//			RiccMessages.getInstance().getMsgInclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		model.setEndividamento(new EndividamentoBancarioVO());
		listarEndividamentoBancario();
	}
	
	public void excluirEndividamentoBancario() {
		QuestionarioCorporateVO model = getViewHelper()
				.getModel();
		EndividamentoBancarioVO itemSelecionado = model
				.getEndividamentoSelecionado().get(0);

		model.setEndividamentoSelecionado(new ArrayList<EndividamentoBancarioVO>());
		try {
			segmentoService.manutencaoEndividamentoBancario(model,
					itemSelecionado, TipoManutencaoEnum.EXCLUSAO);
//			RiccMessages.getInstance().getMsgExclusaoSucesso();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
			return;
		}
		
		model.setEndividamentoTotalSaldo("");
		model.getListaEndividamento().clear();
		listarEndividamentoBancario();
	}

	public boolean validarCamposEndividamentoBancario() {
		EndividamentoBancarioVO model = viewHelper.getModel().getEndividamento();
		if(siteUtil.isEmptyOrNull(model.getInstituicaoFinanceira())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_instituicao_financeira");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getModalidade())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_modalidade");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getSaldo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_saldo_reais");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getVencimentoFinal())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_venc_final");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getAmortizacao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_amortizacao");
			return false;
		}
		
		if(siteUtil.isEmptyOrNull(model.getDescGarantia())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_garantia");
			return false;
		}
		
		return true;
	}
	
	public void consultaMercadoExterno() {
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
	
	public void consultaPerspectivaEmpresa() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());

		try {
			model.setProjecao(segmentoService.consultaPerspectivas(model));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
//	public void consultaReciprocidades() {
//		QuestionarioCorporateVO model = viewHelper.getModel();
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
//	public void listarCartao() {
//		QuestionarioCorporateVO model = viewHelper.getModel();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
//
//		try {
//			model.getListaCartao().clear();
//			model.getCartaoSelecionado().clear();
//			model.setListaCartao(segmentoService.consultaCartoes(model));
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//	}
//	
//	public void incluirCartao() {
//		QuestionarioCorporateVO model = viewHelper.getModel();
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
//		model.setCartao(new CartaoVO());
//		listarCartao();
//	}
//	
//	public void excluirCartao(){
//		QuestionarioCorporateVO model = viewHelper.getModel(); 
//		CartaoVO _itemSelecionado = model.getCartaoSelecionado().get(0);
//		
//		viewHelper.getModel().setCartaoSelecionado(new ArrayList<CartaoVO>());
//		try {
//			segmentoService.manutencaoCartoes(model, 
//					_itemSelecionado, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
////			RiccMessages.getInstance().getMsgExclusaoSucesso();
//			listarCartao();
//		} catch (Exception e) {
//			siteUtil.trataExceptionRecebida(e);
//		}
//	}
	
	public void listarSetor() {
		QuestionarioCorporateVO model = viewHelper.getModel();
		try {
			viewHelper.getModel().setSetorSelecionado(new ArrayList<TipoQuestionarioVO>());
			model.setListaSetor(segmentoService.consultaSetores(model));
			siteUtil.carregarComboSetor(viewHelper.getComboSetor(), model.getListaSetor());
			viewHelper.setComboSetor(siteUtil.carregarComboSetor(
					viewHelper.getComboSetor(), model.getListaSetor()));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void incluirSetor() {
		QuestionarioCorporateVO model = viewHelper.getModel();
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
					viewHelper.getModel().setFlagSetorAgricola("1");
					break;
				//IMOBILIÁRIO
				case 2:
					QuestionarioImobiliarioVO imob = new QuestionarioImobiliarioVO();
					segmentoService.manutencaoSetorImobiliario(model, imob, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getModel().setFlagSetorImobiliario("1");
					break;
				//PROJETOS
				case 3:
					QuestionarioProjetoVO proj = new QuestionarioProjetoVO();
					segmentoService.manutencaoSetorProjetos(model, proj, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getModel().setFlagSetorProjeto("1");
					break;
				//TRANSPORTE
				case 4:
					QuestionarioTransportesVO tran = new QuestionarioTransportesVO();
					segmentoService.manutencaoSetorTransporte(model, tran, TipoManutencaoEnum.INCLUSAO);
					viewHelper.getModel().setFlagSetorTransporte("1");
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
		QuestionarioCorporateVO model = viewHelper.getModel();
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
					viewHelper.getModel().setFlagSetorAgricola("2");
					break;
				//IMOBILIÁRIO
				case 2:
					QuestionarioImobiliarioVO imob = new QuestionarioImobiliarioVO();
					segmentoService.manutencaoSetorImobiliario(model, imob, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getModel().setFlagSetorImobiliario("2");
					break;
				//PROJETOS
				case 3:
					QuestionarioProjetoVO proj = new QuestionarioProjetoVO();
					segmentoService.manutencaoSetorProjetos(model, proj, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getModel().setFlagSetorProjeto("2");
					break;
				//TRANSPORTE
				case 4:
					QuestionarioTransportesVO tran = new QuestionarioTransportesVO();
					segmentoService.manutencaoSetorTransporte(model, tran, TipoManutencaoEnum.EXCLUSAO);
					viewHelper.getModel().setFlagSetorTransporte("2");
					break;
				}
				
//				siteUtil.getMessages().getMsgExclusaoSucesso();
				
			} catch (Exception e) {
				siteUtil.trataExceptionRecebida(e);
			}
			
			viewHelper.getModel().getSetorSelecionado().clear();
			listarSetor();
		}
	}
	
	/**
	 * @description 
	 *  1 - Agronegocio
	 *  2 - Imobiliario
	 *  3 - Transporte
	 *  4 - Projetos
	 * 
	 * @name alterarSetor
	 * @see QuestionarioCorporateBean
	 * @return
	 * @return String
	 */
	public String alterarSetor() {
		try {
			TipoQuestionarioVO setorSelecionadoTabela = viewHelper.getModel().getSetorSelecionado().get(0);
			QuestionarioCorporateVO model = this.viewHelper.getModel();
			Integer codigoSetor = setorSelecionadoTabela.getCodigo().intValue();
			String retorno = "";
			String paginaAnterior = RiccConstants.TELA_QUESTIONARIO_CORPORATE;
			
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
			viewHelper.getModel().getSetorSelecionado().clear();
			return retorno;
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		return VAZIO;
	}
	
	private boolean validarAnosIguais(){
		
		boolean ret = true;
		
		if(isAnosIguais(viewHelper.getModel().getVolumeA().getAno(), 
				viewHelper.getModel().getVolumeB().getAno(),
				viewHelper.getModel().getVolumeC().getAno(), 
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
		QuestionarioCorporateVO model = viewHelper.getModel();
		if (siteUtil.isEmptyOrNull(model.getNomeRelatorio())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_nome_relatorio");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getDescAtividadeEmpresa())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_quest_corporate_descrever");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getOrganogramaControleAcionario())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_quest_corporate_Organograma");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getAdministracao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_administracao");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getPlanoSucessao())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_plano_sucessao");
			retorno = false;
		}
		if(model.getListaQuadroAdministrativo().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem("label_quadro_administrativo");
			retorno = false;
		}
		if(siteUtil.isEmptyOrNull(model.getDescQuadroAdministrativo())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_detalhar_plano_sucessao");
			retorno = false;
		}
		if(model.getListaFornecedor().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem("label_fornecedores");
			retorno = false;
		}
		if(model.getListaCliente().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem("label_clientes");
			retorno = false;
		}
		if(model.getListaRecebimento().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem("label_forma_recebimento");
			retorno = false;
		}
		if(model.getListaConcorrente().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem("label_principais_concorrentes");
			retorno = false;
		}
		if(siteUtil.isEmptyOrNull(model.getInformarAtraso())) {
			siteUtil.getMessages().getMsgCampoObrigatorio("label_informar_atraso");
			retorno = false;
		}
		if (siteUtil.isEmptyOrNull(model.getNomeHighlightsEmpresa())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_highlights_empresa");
			retorno = false;
		}
		if(!validarCamposHighlights()) {
			siteUtil.getMessages().getMsgColunaObrigatoria(
					"label_highlights_empresa");
			retorno = false;
		}
//		if(!validarPreenchimentoHighlights()){
//			retorno = false;
//		}
		if(siteUtil.isEmptyOrNull(model.getDescSituacaoFinanceira())) {
			siteUtil.getMessages().getMsgCampoObrigatorio(
					"label_comentarios_situacao_atual");
			retorno = false;
		}
		if(model.getListaEndividamento().isEmpty()) {
			siteUtil.getMessages().getMsgListaDeveConterItem(
					"label_endividamento_bancario");
			retorno = false;
		}
		if (!validarCamposMercadoExterno()) {
			retorno = false;
		}
		if (!validarCamposReciprocidades()) {
//			siteUtil.getMessages().getMsgCampoObrigatorio(
//					"label_bradesco_ano_atual");
			retorno = false;
		}
//		if(model.getListaCartao().isEmpty()) {
//			siteUtil.getMessages().getMsgListaDeveConterItem("label_cartoes_m");
//			retorno = false;
//		}
		
		return retorno;
	}
	
	public boolean validarCamposHighlights() {
		HighlightsEmpresaVO a = viewHelper.getModel().getBalancoA();
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
	
	public boolean validarPreenchimentoHighlights() {
//		HighlightsEmpresaVO a = viewHelper.getModel().getBalancoA();
		HighlightsEmpresaVO b = viewHelper.getModel().getBalancoB();
		HighlightsEmpresaVO c = viewHelper.getModel().getBalancoC();
		
		if (siteUtil.isEmptyOrNull(b.getBalanco())) {
			if(siteUtil.isNotEmptyOrNull(b.getReceitaLiquida())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getContasAReceber())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getEstoques())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getGerBrutaCaixa())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getMargemOperacional())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getLucroPrejuizoLiquido())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getPatrimonioLiquido())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getEndividamentoFinanceiroTotal())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getDisponibilidades())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(b.getEndividamentoFinanceiroLiquido())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
		} else if (siteUtil.isEmptyOrNull(c.getBalanco())) {
			if(siteUtil.isNotEmptyOrNull(c.getReceitaLiquida())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getContasAReceber())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getEstoques())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getGerBrutaCaixa())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getMargemOperacional())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getLucroPrejuizoLiquido())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getPatrimonioLiquido())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getEndividamentoFinanceiroTotal())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getDisponibilidades())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
			if(siteUtil.isNotEmptyOrNull(c.getEndividamentoFinanceiroLiquido())){
				siteUtil.getMessages().getMsgCampoObrigatorio(
						"label_balanco");
				return false;
			}
		} 
			return true;
	}
	
	/**
	 * @return
	 */
	public boolean validarCamposMercadoExterno() {
		ImportacoesExportacoesVO a = viewHelper.getModel().getVolumeA();
		ImportacoesExportacoesVO b = viewHelper.getModel().getVolumeB();
		ImportacoesExportacoesVO c = viewHelper.getModel().getVolumeC();
		
		// Moeda vazio -> false se o primeiro ano estiver inválido
		if (siteUtil.isEmptyOrNull(viewHelper.getModel().getMoedaExportacao())
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
	
	public boolean validarCamposReciprocidades() {
		VolumeBradescoVO volume = getViewHelper().getModel().getVolumeBradesco();
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
	
	public void salvar() {
		
		if(!validarAnosIguais()){
			return;
		}
		
		try {
			QuestionarioCorporateVO model = viewHelper.getModel();
			quadroAtivos();
			quadroAdministrativo();
			fornecedores();
			cliente();
			recebimento();
			principaisConcorrentes();
			carteiraContratos();
			endividamento();
			segmentoService.manutencaoComentarios(model, retornaListComentariosSegmento(), RiccConstants.MANUTENCAO_ALTERACAO);
			segmentoService.manutencaoComentarios(model, retornaListComentariosAtivo(), RiccConstants.MANUTENCAO_ALTERACAO);
			segmentoService.manutencaoComentarios(model, retornaListComentariosAdm(), RiccConstants.MANUTENCAO_ALTERACAO);
			segmentoService.manutencaoComentarios(model, retornaListComentariosFornecedor(), RiccConstants.MANUTENCAO_ALTERACAO);
			segmentoService.manutencaoComentarios(model, retornaListComentariosFormaRecebimento(), RiccConstants.MANUTENCAO_ALTERACAO);
			segmentoService.manutencaoComentarios(model, retornaListComentariosConcorrente(), RiccConstants.MANUTENCAO_ALTERACAO);
			segmentoService.manutencaoComentarios(model, retornaListComentariosContrato(), RiccConstants.MANUTENCAO_ALTERACAO);
			
			salvarHighlightsEmpresa();
			segmentoService.manutencaoComentarios(model, retornaListComentariosHighlights(), RiccConstants.MANUTENCAO_ALTERACAO);
			
			segmentoService.manutencaoComentarios(model, retornaListComentariosDividas(), RiccConstants.MANUTENCAO_ALTERACAO);
			
			salvarMercadoExterno();
			segmentoService.manutencaoComentarios(model, retornaListComentariosMercadoExterno(), RiccConstants.MANUTENCAO_ALTERACAO);
			
			salvarPerspectivas();
			segmentoService.manutencaoComentarios(model, retornaListComentariosPerspectivaEmpresa(), RiccConstants.MANUTENCAO_ALTERACAO);
			
			segmentoService.manutencaoComentarios(model, retornaListComentariosReciprocidades(), RiccConstants.MANUTENCAO_ALTERACAO);
			segmentoService.manutencaoRelatorioSegmento(model, TipoManutencaoEnum.ALTERACAO);
			segmentoService.manutencaoRelatorioInfoCredito(model, TipoFuncaoEnum.SALVAR, SituacaoRelatorioEnum.PENDENTE, SegmentoEnum.CORPORATE);

			if(mensagens.size() == 0){
				RiccMessages.getInstance().getMsgSalvarSucesso();
			}
			mensagens.clear();
			
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	private void endividamento() {
		int contador = 0;
		for (EndividamentoBancarioVO itemTabela : viewHelper.getModel().getListaEndividamento()) {
			if (!itemTabela.equals(viewHelper.getModel().getCopiaListaEndividamento().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0 &&
						siteUtil.isNotEmptyOrNull(itemTabela.getInstituicaoFinanceira()) &&
						siteUtil.isNotEmptyOrNull(itemTabela.getModalidade()) && 
						siteUtil.isNotEmptyOrNull(itemTabela.getSaldo()) && 
						siteUtil.isNotEmptyOrNull(itemTabela.getVencimentoFinal()) && 
						siteUtil.isNotEmptyOrNull(itemTabela.getAmortizacao()) && 
						siteUtil.isNotEmptyOrNull(itemTabela.getDescGarantia())){
					try {
						viewHelper.getModel().setEndividamento(itemTabela);
						segmentoService.manutencaoEndividamentoBancario(viewHelper.getModel(),
								itemTabela, TipoManutencaoEnum.INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0 &&
						siteUtil.isEmptyOrNull(itemTabela.getInstituicaoFinanceira()) && 
						siteUtil.isEmptyOrNull(itemTabela.getModalidade()) && 
						siteUtil.isEmptyOrNull(itemTabela.getSaldo()) && 
						siteUtil.isEmptyOrNull(itemTabela.getVencimentoFinal()) && 
						siteUtil.isEmptyOrNull(itemTabela.getAmortizacao()) && 
						siteUtil.isEmptyOrNull(itemTabela.getDescGarantia())) {
					try {
						QuestionarioCorporateVO model = getViewHelper().getModel();
						segmentoService.manutencaoEndividamentoBancario(model,
									itemTabela, TipoManutencaoEnum.EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if(itemTabela.getNumSequencial() == viewHelper.getModel().getCopiaListaEndividamento().get(contador).getNumSequencial()){ 
						try {
							QuestionarioCorporateVO model = viewHelper.getModel();
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

	public void recebimento() {
		int contador = 0;
		for (FormaRecebimentoVO itemTabela : viewHelper.getModel().getListaRecebimento()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
			viewHelper.getModel().getCopiaListaRecebimento().get(contador).setTipoCliente(RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
			if (!itemTabela.equals(viewHelper.getModel().getCopiaListaRecebimento().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0 &&
						siteUtil.isNotEmptyOrNull(itemTabela.getFormaRecebimento()) &&
						siteUtil.isNotEmptyOrNull(itemTabela.getPorcentagem())){
					try {
						viewHelper.getModel().setRecebimento(itemTabela);
						segmentoService.manutencaoFormaRecebimento(viewHelper.getModel(),
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0 &&
						siteUtil.isEmptyOrNull(itemTabela.getFormaRecebimento()) &&
						siteUtil.isEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						QuestionarioCorporateVO model = viewHelper.getModel();
						itemTabela.setTipoCliente(
								RiccConstants.COD_TIPO_FORMA_RECEBIMENTO);
						segmentoService.manutencaoFormaRecebimento(model,
								itemTabela, RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if(itemTabela.getNumSequencial() == viewHelper.getModel().getCopiaListaRecebimento().get(contador).getNumSequencial()){ 
						try {
							viewHelper.getModel().setRecebimento(itemTabela);
							FormaRecebimentoVO dados = getViewHelper().getModel().getRecebimento();
							QuestionarioCorporateVO model = viewHelper.getModel();
							FormaRecebimentoVO ativos = new FormaRecebimentoVO(
									dados.getFormaRecebimento(), dados.getPorcentagem());
							ativos.setNumSequencial(itemTabela.getNumSequencial());
							segmentoService.manutencaoFormaRecebimento(model,
									model.getRecebimento(), RiccConstants.MANUTENCAO_INCLUSAO);
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

	public void fornecedores() {
		int contador = 0;
		viewHelper.getModel().getFornecedor().setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
		for (FornecedorVO itemTabela : viewHelper.getModel().getListaFornecedor()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
			viewHelper.getModel().getCopiaListaFornecedor().get(contador).setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
			if (!itemTabela.equals(viewHelper.getModel().getCopiaListaFornecedor().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0 &&
						siteUtil.isNotEmptyOrNull(itemTabela.getFornecedor()) && 
						siteUtil.isNotEmptyOrNull(itemTabela.getPorcentagem())){
					try {
						viewHelper.getModel().setFornecedor(itemTabela);
						segmentoService.manutencaoFornecedor(viewHelper.getModel(), itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0 &&
						siteUtil.isEmptyOrNull(itemTabela.getFornecedor()) && 
						siteUtil.isEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						QuestionarioCorporateVO model = viewHelper.getModel();
						itemTabela.setTipoCliente(RiccConstants.COD_TIPO_FORNECEDOR);
						segmentoService.manutencaoFornecedor(model, itemTabela,
								RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if(itemTabela.getNumSequencial() == viewHelper.getModel().getCopiaListaFornecedor().get(contador).getNumSequencial()){ 
						try {
							viewHelper.getModel().setFornecedor(itemTabela);
							FornecedorVO dados = getViewHelper().getModel().getFornecedor();
							QuestionarioCorporateVO model = viewHelper.getModel();
							FornecedorVO ativos = new FornecedorVO(
									dados.getFornecedor(), dados.getPorcentagem());
							ativos.setNumSequencial(itemTabela.getNumSequencial());
							segmentoService.manutencaoFornecedor(model, model.getFornecedor(),
									RiccConstants.MANUTENCAO_INCLUSAO);
						} catch (Exception e) {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
				}
			}
			contador ++;
		}
		listarFornecedores();
	}

	//Logica Quadro Administrativo
	public void quadroAdministrativo() {
		int contador = 0;
		for (QuadroAdministrativoVO itemTabela : viewHelper.getModel().getListaQuadroAdministrativo()) {
			if (!itemTabela.equals(viewHelper.getModel().getCopiaListaQuadroAdministrativo().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0 &&
						siteUtil.isNotEmptyOrNull(itemTabela.getAdministrador()) &&
						siteUtil.isNotEmptyOrNull(itemTabela.getCargo())){
					try {
						viewHelper.getModel().setQuadroAdministrativo(itemTabela);
						segmentoService.manutencaoQuadroAdministrativo(viewHelper.getModel(),
								itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0 &&
						siteUtil.isEmptyOrNull(itemTabela.getAdministrador()) && 
						siteUtil.isEmptyOrNull(itemTabela.getCargo())) {
					try {
						QuestionarioCorporateVO model = viewHelper.getModel();
						segmentoService.manutencaoQuadroAdministrativo(model, itemTabela, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if(itemTabela.getNumSequencial() == viewHelper.getModel().getCopiaListaQuadroAdministrativo().get(contador).getNumSequencial()){ 
						try {
							viewHelper.getModel().setQuadroAdministrativo(itemTabela);
							QuadroAdministrativoVO dados = getViewHelper().getModel().getQuadroAdministrativo();
							QuestionarioCorporateVO model = viewHelper.getModel();
							QuadroAdministrativoVO ativos = new QuadroAdministrativoVO(
									dados.getAdministrador(), dados.getCargo());
							ativos.setNumSequencial(itemTabela.getNumSequencial());
							segmentoService.manutencaoQuadroAdministrativo(model, ativos, TipoManutencaoEnum.INCLUSAO.getCodigoString());
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

	//Logica Quadro Ativos  
	
	public void quadroAtivos() {
		int contador = 0;
		for (QuadroAtivosCorporateVO itemTabela : viewHelper.getModel().getListaQuadroAtivos()) {
			if (!itemTabela.equals(viewHelper.getModel().getCopiaListaQuadroAtivos().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0 &&
						siteUtil.isNotEmptyOrNull(itemTabela.getConcessoesProjetosSpes()) &&
						siteUtil.isNotEmptyOrNull(itemTabela.getPorcParticipacao()) &&
						siteUtil.isNotEmptyOrNull(itemTabela.getInformacoesRelevantes())){
					try {
						viewHelper.getModel().setQuadroAtivos(itemTabela);
						segmentoService.manutencaoQuadroAtivos(viewHelper.getModel(), itemTabela, TipoManutencaoEnum.INCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0 &&
						siteUtil.isEmptyOrNull(itemTabela.getConcessoesProjetosSpes()) &&
						siteUtil.isEmptyOrNull(itemTabela.getPorcParticipacao()) &&
						siteUtil.isEmptyOrNull(itemTabela.getInformacoesRelevantes())) {
					try {
						QuestionarioCorporateVO model = viewHelper.getModel();
						segmentoService.manutencaoQuadroAtivos(model, itemTabela, TipoManutencaoEnum.EXCLUSAO.getCodigoString());
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if(itemTabela.getNumSequencial() == viewHelper.getModel().getCopiaListaQuadroAtivos().get(contador).getNumSequencial()){ 
						try {
							viewHelper.getModel().setQuadroAtivos(itemTabela);
							QuadroAtivosCorporateVO dados = getViewHelper().getModel().getQuadroAtivos();
							QuestionarioCorporateVO model = viewHelper.getModel();
							QuadroAtivosCorporateVO ativos = new QuadroAtivosCorporateVO(
									dados.getConcessoesProjetosSpes(), dados.getPorcParticipacao(), dados.getInformacoesRelevantes());
							ativos.setNumSequencial(itemTabela.getNumSequencial());
							segmentoService.manutencaoQuadroAtivos(model, ativos, TipoManutencaoEnum.INCLUSAO.getCodigoString());
						} catch (Exception e) {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
				}
			}
			contador ++;
		}
		listarQuadroAtivos();		
	}
	
	//Logica Cliente
	public void cliente() {
		int contador = 0;
		for (ClienteVO itemTabela : viewHelper.getModel().getListaCliente()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);
			viewHelper.getModel().getCopiaListaCliente().get(contador).setTipoCliente(RiccConstants.COD_TIPO_CLIENTE);			
			if (!itemTabela.equals(viewHelper.getModel().getCopiaListaCliente().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0 &&
						siteUtil.isNotEmptyOrNull(itemTabela.getCliente()) &&
						siteUtil.isNotEmptyOrNull(itemTabela.getPorcentagem())){
					try {
						viewHelper.getModel().setCliente(itemTabela);
						segmentoService.manutencaoCliente(viewHelper.getModel(), itemTabela,
								RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0 &&
						siteUtil.isEmptyOrNull(itemTabela.getCliente()) &&
						siteUtil.isEmptyOrNull(itemTabela.getPorcentagem())) {
					try {
						QuestionarioCorporateVO model = viewHelper.getModel();
						segmentoService.manutencaoCliente(model, itemTabela, RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if(itemTabela.getNumSequencial() == viewHelper.getModel().getCopiaListaCliente().get(contador).getNumSequencial()){ 
						try {
							viewHelper.getModel().setCliente(itemTabela);
							ClienteVO dados = getViewHelper().getModel().getCliente();
							QuestionarioCorporateVO model = viewHelper.getModel();
							ClienteVO ativos = new ClienteVO(
									dados.getCliente(), dados.getPorcentagem());
							ativos.setNumSequencial(itemTabela.getNumSequencial());
							segmentoService.manutencaoCliente(model, model.getCliente(),
									RiccConstants.MANUTENCAO_INCLUSAO);
						} catch (Exception e) {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
				}
			}
			contador ++;
		}
		listarClientes();		
	}
	
	public void principaisConcorrentes(){
		int contador = 0;
		for (ConcorrenteVO itemTabela : viewHelper.getModel().getListaConcorrente()) {
			itemTabela.setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
			viewHelper.getModel().getCopiaListaConcorrente().get(contador).setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
			if (!itemTabela.equals(viewHelper.getModel().getCopiaListaConcorrente().get(contador))) {
				//INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0 &&
						siteUtil.isNotEmptyOrNull(itemTabela.getConcorrente())){
					try {
						viewHelper.getModel().setConcorrente(itemTabela);
						segmentoService.manutencaoConcorrente(viewHelper.getModel(),
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0 &&
						siteUtil.isEmptyOrNull(itemTabela.getConcorrente())) {
					try {
						QuestionarioCorporateVO model = viewHelper.getModel();
						itemTabela.setTipoCliente(RiccConstants.COD_TIPO_CONCORRENTE);
							segmentoService.manutencaoConcorrente(model,
									itemTabela, RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
				//ALTERAÇÃO
				} else if(itemTabela.getNumSequencial() == viewHelper.getModel().getCopiaListaConcorrente().get(contador).getNumSequencial()){ 
						try {
							viewHelper.getModel().setConcorrente(itemTabela);
							ConcorrenteVO dados = getViewHelper().getModel().getConcorrente();
							QuestionarioCorporateVO model = viewHelper.getModel();
							ConcorrenteVO ativos = new ConcorrenteVO(
									dados.getConcorrente());
							ativos.setNumSequencial(itemTabela.getNumSequencial());
							segmentoService.manutencaoConcorrente(model,
									model.getConcorrente(), RiccConstants.MANUTENCAO_INCLUSAO);
						} catch (Exception e) {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
				}
			}
			contador ++;
		}
		listarConcorrentes();	
	}
	
	private void carteiraContratos() {
		int contador = 0;
		for (CarteiraContratosVO itemTabela : viewHelper.getModel()
				.getListaCarteira()) {
			if (!itemTabela.equals(viewHelper.getModel()
					.getCopiaListaCarteira().get(contador))) {
				// INCLUSÃO
				if (Integer.parseInt(itemTabela.getNumSequencial()) == 0
						&& siteUtil.isNotEmptyOrNull(itemTabela.getProjetoObraServico())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getCliente())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getValorContrato())
						&& siteUtil.isNotEmptyOrNull(itemTabela.getSaldoPerformar()) 
						&& siteUtil.isNotEmptyOrNull(itemTabela.getDataTermino())) {
					try {
						viewHelper.getModel().setCarteira(itemTabela);
						segmentoService.manutencaoCarteiraContratos(viewHelper.getModel(),
								itemTabela, RiccConstants.MANUTENCAO_INCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// EXCLUSÃO
				} else if (Integer.parseInt(itemTabela.getNumSequencial()) > 0
						&& siteUtil.isEmptyOrNull(itemTabela.getProjetoObraServico())
						&& siteUtil.isEmptyOrNull(itemTabela.getCliente())
						&& siteUtil.isEmptyOrNull(itemTabela.getValorContrato())
						&& siteUtil.isEmptyOrNull(itemTabela.getSaldoPerformar()) 
						&& siteUtil.isEmptyOrNull(itemTabela.getDataTermino())) {
					try {
						QuestionarioCorporateVO model = getViewHelper()
								.getModel();
						segmentoService.manutencaoCarteiraContratos(model,
								itemTabela, RiccConstants.MANUTENCAO_EXCLUSAO);
					} catch (Exception e) {
						siteUtil.trataExceptionRecebida(e);
						mensagens.add(e.getMessage());
					}
					// ALTERAÇÃO
				} else if (itemTabela.getNumSequencial() == viewHelper
						.getModel().getCopiaListaCarteira().get(contador)
						.getNumSequencial()) {
						try {
							QuestionarioCorporateVO model = viewHelper
									.getModel();
							segmentoService.manutencaoCarteiraContratos(model, itemTabela,
									RiccConstants.MANUTENCAO_INCLUSAO);
						} catch (Exception e) {
							siteUtil.trataExceptionRecebida(e);
							mensagens.add(e.getMessage());
						}
				}
			}
			contador++;
		}
		listarCarteiraContratos();
	}

	public String concluir() {
		
		if(!validarAnosIguais()){
			return "";
		}
		
		try {
			if (validarCamposObrigatorios()) {
				QuestionarioCorporateVO model = viewHelper.getModel();
				segmentoService.manutencaoComentarios(model, retornaListComentariosSegmento(), RiccConstants.MANUTENCAO_ALTERACAO);
				segmentoService.manutencaoComentarios(model, retornaListComentariosAtivo(), RiccConstants.MANUTENCAO_ALTERACAO);
				segmentoService.manutencaoComentarios(model, retornaListComentariosAdm(), RiccConstants.MANUTENCAO_ALTERACAO);
				segmentoService.manutencaoComentarios(model, retornaListComentariosFornecedor(), RiccConstants.MANUTENCAO_ALTERACAO);
				segmentoService.manutencaoComentarios(model, retornaListComentariosFormaRecebimento(), RiccConstants.MANUTENCAO_ALTERACAO);
				segmentoService.manutencaoComentarios(model, retornaListComentariosConcorrente(), RiccConstants.MANUTENCAO_ALTERACAO);
				segmentoService.manutencaoComentarios(model, retornaListComentariosContrato(), RiccConstants.MANUTENCAO_ALTERACAO);
				
				salvarHighlightsEmpresa();
				segmentoService.manutencaoComentarios(model, retornaListComentariosHighlights(), RiccConstants.MANUTENCAO_ALTERACAO);
				
				segmentoService.manutencaoComentarios(model, retornaListComentariosDividas(), RiccConstants.MANUTENCAO_ALTERACAO);
				
				salvarMercadoExterno();
				segmentoService.manutencaoComentarios(model, retornaListComentariosMercadoExterno(), RiccConstants.MANUTENCAO_ALTERACAO);
				
				salvarPerspectivas();
				segmentoService.manutencaoComentarios(model, retornaListComentariosPerspectivaEmpresa(), RiccConstants.MANUTENCAO_ALTERACAO);
				
				segmentoService.manutencaoComentarios(model, retornaListComentariosReciprocidades(), RiccConstants.MANUTENCAO_ALTERACAO);
				segmentoService.manutencaoRelatorioInfoCredito(model, TipoFuncaoEnum.CONCLUIR, SituacaoRelatorioEnum.ATIVO, SegmentoEnum.CORPORATE);
				RiccMessages.getInstance().getMsgConcluirSucessoFowardCadastramento();
			}
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		return null;
	}
	
	public void salvarPerspectivas() throws RiccException {
		
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		
		PerspectivasVO perspectiva = model.getProjecao();
		
		segmentoService.manutencaoPerspectivas(model, perspectiva, TipoManutencaoEnum.MANUTENCAO.getCodigoString());
	}
	
//	public void salvarReciprocidades() throws RiccException {
//		
//		QuestionarioCorporateVO model = viewHelper.getModel();
//		model.setCodSegmentoRelatorio(Numeros.UM.toString());
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
	
	public void salvarMercadoExterno() throws RiccException {
		
		List<ImportacoesExportacoesVO> listaVolume = new ArrayList<ImportacoesExportacoesVO>();
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		ImportacoesExportacoesVO importExportA = model.getVolumeA();
		ImportacoesExportacoesVO importExportB = model.getVolumeB();
		ImportacoesExportacoesVO importExportC = model.getVolumeC();
		listaVolume.add(importExportA);
		listaVolume.add(importExportB);
		listaVolume.add(importExportC);
		
		if (siteUtil.isNotEmptyOrNull(model.getVolumeC().getMes())) {
			int mes = Integer.parseInt(model.getVolumeC().getMes());
			if (mes < 1 || mes > 12) {
				throw new IllegalArgumentException("Campo Mês de 'Exposição cambial' inválido");
			}
		}
		segmentoService.manutencaoImportacoesExportacoes(model, listaVolume, 
				TipoManutencaoEnum.MANUTENCAO.getCodigoString(), model.getMoedaExportacao());
		
	}
	
	public void salvarHighlightsEmpresa() throws RiccException {
		List<HighlightsEmpresaVO> listaHighlightsEmpresa = new ArrayList<HighlightsEmpresaVO>();
		QuestionarioCorporateVO model = viewHelper.getModel();
		model.setCodSegmentoRelatorio(Numeros.UM.toString());
		HighlightsEmpresaVO balancoA = model.getBalancoA();
		HighlightsEmpresaVO balancoB = model.getBalancoB();
		HighlightsEmpresaVO balancoC = model.getBalancoC();
		listaHighlightsEmpresa.add(balancoA);
		listaHighlightsEmpresa.add(balancoB);
		listaHighlightsEmpresa.add(balancoC);
			segmentoService.manutencaoHighlightsEmpresa(
				model, listaHighlightsEmpresa,TipoManutencaoEnum.MANUTENCAO, model.getNomeHighlightsEmpresa());
	}
	
	public void botaoNovoHighlights(){
		viewHelper.getModel().setBalancoA(viewHelper.getModel().getBalancoB());
		viewHelper.getModel().setBalancoB(viewHelper.getModel().getBalancoC());
		viewHelper.getModel().setBalancoC(new HighlightsEmpresaVO());
	}
	
	public List<ComentarioVO> retornaListComentariosSegmento(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("1");
		comentario.setComentario(viewHelper.getModel().getDescAtividadeEmpresa());
		comentarios.add(comentario);
		
		comentario = new ComentarioVO();
		comentario.setCodSequencial("2");
		comentario.setCodTipo("1");
		comentario.setComentario(viewHelper.getModel().getOrganogramaControleAcionario());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosAdm(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("2");
		comentario.setComentario(viewHelper.getModel().getDescQuadroAdministrativo());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosFornecedor(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("5");
		comentario.setComentario(viewHelper.getModel().getDescFornecedor());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosFormaRecebimento(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("2");
		comentario.setCodTipo("5");
		comentario.setComentario(viewHelper.getModel().getDescFormaRecebimento());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosConcorrente(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("3");
		comentario.setCodTipo("5");
		comentario.setComentario(viewHelper.getModel().getDescConcorrente());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosContrato(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("6");
		comentario.setComentario(viewHelper.getModel().getDescCarteira());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosAtivo(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("11");
		comentario.setComentario(viewHelper.getModel().getDescQuadroAtivos());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	
	public List<ComentarioVO> retornaListComentariosHighlights(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("8");
		comentario.setComentario(viewHelper.getModel().getDescSituacaoFinanceira());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosDividas(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("9");
		comentario.setComentario(viewHelper.getModel().getDescEndividamentoBancario());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosMercadoExterno(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("12");
		comentario.setComentario(viewHelper.getModel().getPrincipaisPaisesExportaImporta());
		comentarios.add(comentario);
		
		comentario = new ComentarioVO();
		comentario.setCodSequencial("2");
		comentario.setCodTipo("12");
		comentario.setComentario(viewHelper.getModel().getDetalheProtecaoCambialEmpresa());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosPerspectivaEmpresa(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("13");
		comentario.setComentario(viewHelper.getModel().getDetalheEstrategiaProjecao());
		comentarios.add(comentario);
		
		comentario = new ComentarioVO();
		comentario.setCodSequencial("2");
		comentario.setCodTipo("13");
		comentario.setComentario(viewHelper.getModel().getDetalhePrincipaisInvestimentos());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public List<ComentarioVO> retornaListComentariosReciprocidades(){
		List<ComentarioVO> comentarios = new ArrayList<ComentarioVO>();
		ComentarioVO comentario = new ComentarioVO();
		comentario.setCodSequencial("1");
		comentario.setCodTipo("10");
		comentario.setComentario(viewHelper.getModel().getDescReciprocidades());
		comentarios.add(comentario);
		
		return comentarios;
	}
	
	public void copiarQuadroAtivos() throws IllegalAccessException, InvocationTargetException{
		ArrayList<QuadroAtivosCorporateVO> listaCopia = new ArrayList<QuadroAtivosCorporateVO>();
		QuadroAtivosCorporateVO voCopia = null;
		for (QuadroAtivosCorporateVO itemTabela : this.viewHelper.getModel().getListaQuadroAtivos()) {
			voCopia = new QuadroAtivosCorporateVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getConcessoesProjetosSpes())){
				voCopia.setConcessoesProjetosSpes("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getPorcParticipacao())){
				voCopia.setPorcParticipacao("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getInformacoesRelevantes())){
				voCopia.setInformacoesRelevantes("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaQuadroAtivos(listaCopia);
	}	
	
	public void copiarQuadroAdministrativo() throws IllegalAccessException, InvocationTargetException{
		ArrayList<QuadroAdministrativoVO> listaCopia = new ArrayList<QuadroAdministrativoVO>();
		QuadroAdministrativoVO voCopia = null;
		for (QuadroAdministrativoVO itemTabela : this.viewHelper.getModel().getListaQuadroAdministrativo()) {
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
		viewHelper.getModel().setCopiaListaQuadroAdministrativo(listaCopia);
	}
	
	public void copiarFornecedores() throws IllegalAccessException, InvocationTargetException{
		ArrayList<FornecedorVO> listaCopia = new ArrayList<FornecedorVO>();
		FornecedorVO voCopia = null;
		for (FornecedorVO itemTabela : this.viewHelper.getModel().getListaFornecedor()) {
			voCopia = new FornecedorVO();
			BeanUtils.copyProperties(voCopia, itemTabela);
			if(siteUtil.isEmptyOrNull(voCopia.getFornecedor())){
				voCopia.setFornecedor("");
			}
			if(siteUtil.isEmptyOrNull(voCopia.getPorcentagem())){
				voCopia.setPorcentagem("");
			}
			listaCopia.add(voCopia);
			listaCopia.get(0);
		}
		viewHelper.getModel().setCopiaListaFornecedor(listaCopia);
	}	
	
	
	public void carteiraContratosTotal(AjaxBehaviorEvent e) {
		BigInteger somaValorContrato = new BigInteger("0");
		BigInteger somaSaldoPerformar = new BigInteger("0");
		for (CarteiraContratosVO itemTabela : viewHelper.getModel().getListaCarteira()) {
			if(siteUtil.isNotEmptyOrNull(itemTabela.getValorContrato())){
				somaValorContrato = somaValorContrato.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getValorContrato())));
			}
			if(siteUtil.isNotEmptyOrNull(itemTabela.getSaldoPerformar())){
				somaSaldoPerformar = somaSaldoPerformar.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getSaldoPerformar())));
			}
		}
		getViewHelper().getModel().setTotalContrato(somaValorContrato.toString());
		getViewHelper().getModel().setTotalSaldoContrato(somaSaldoPerformar.toString());
	}
	
	public void endividamentoTotal(AjaxBehaviorEvent e) {
		BigInteger soma = new BigInteger("0");
		for (EndividamentoBancarioVO itemTabela : viewHelper.getModel().getListaEndividamento()) {
			if(siteUtil.isNotEmptyOrNull(itemTabela.getSaldo())){
				soma = soma.add(new BigInteger(siteUtil.retirarMascaraNumericos(itemTabela.getSaldo())));
			}
		}
		getViewHelper().getModel().setEndividamentoTotalSaldo(soma.toString());
	}
	
	public String voltar() {
		return ((CadastramentoRicBean) FacesUtils
				.getManagedBean(RiccConstants.BEAN_CADASTRAMENTO_RIC))
				.carregarListaCadastramento();
	}

}
