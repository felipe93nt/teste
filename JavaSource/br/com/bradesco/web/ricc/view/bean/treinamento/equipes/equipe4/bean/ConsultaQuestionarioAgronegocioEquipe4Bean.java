package br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe4.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPlantadaGraosVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.GraosFibrasVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.service.business.questionarioagronegocio.IQuestionarioAgronegocioService;
import br.com.bradesco.web.ricc.service.business.questionarioagronegocio.impl.GraoFibraAux;
import br.com.bradesco.web.ricc.service.business.questionariosegmento.ISegmentoService;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.bean.QuestionarioAgronegocioBean.ObjectUsinas;
import br.com.bradesco.web.ricc.view.bean.treinamento.equipes.equipe4.viewhelper.ConsultaQuestionarioAgronegocioEquipe4ViewHelper;

@SessionScoped
@Named(value = "consultaQuestionarioAgronegocioEquipe4Bean")
public class ConsultaQuestionarioAgronegocioEquipe4Bean extends AbstractBean<ConsultaQuestionarioAgronegocioEquipe4ViewHelper> {

	private static final long serialVersionUID = -2740349095047942026L;
	
	public static final int COD_SOJA = 1;

	public static final int COD_MILHO = 2;

	public static final int COD_ALGODAO = 3;

	@Inject
	@Named("questionarioAgronegocioService")
	private IQuestionarioAgronegocioService questionarioAgronegocioService;
	
	@Inject
	@Named("segmentoService")
	private ISegmentoService segmentoService;
	
	private String paginaAnterior = "";

	@Override
	public String iniciarPagina() {
		
		setViewHelper(new ConsultaQuestionarioAgronegocioEquipe4ViewHelper());
		viewHelper.inicializar();
		
		return RiccConstants.TELA_EQUIPE4BEAN_CONSULTA_QUESTIONARIO_AGRONEGOCIO;
	}
	
	public void selecionarAba(ActionEvent e) {
		String id = e.getComponent().getId();
		if (id.equals("btnAbaGraosFibras")) {
			getViewHelper().setRenderAbaGraosFibras(Boolean.TRUE);
			getViewHelper().setRenderAbaUsinas(Boolean.FALSE);
		} else if (id.equals("btnAbaUsinas")) {
			getViewHelper().setRenderAbaGraosFibras(Boolean.FALSE);
			getViewHelper().setRenderAbaUsinas(Boolean.TRUE);
		}
	}

	public void carregarDados() {
		carregarNomeProdutor();
		listarAreaPropria();
		listarAreaArrendada();
		carregarDadosGraoMilho();
		carregarDadosGraoSoja();
		carregarDadosFibraAlgodao();
		carregarDadosUsinas();
		
		calcularTotalizadoresGraosFibras();
		calcularTotalizadoresUsinas();
		
		siteUtil.retirarMensagemDuplicada();

	}
	
	private void calcularTotalizadoresUsinas() {
		moagemTotal1(null);
		moagemTotal2(null);
		moagemTotal3(null);
		moagemTotalProjetado(null);
		
		terraTotal1(null);
		terraTotal2(null);
		terraTotal3(null);
		terraTotalProjetado(null);
	}

	private void calcularTotalizadoresGraosFibras() {
		graoAreaPlantada1Total(null);
		graoAreaPlantada2Total(null);
		graoAreaPlantada3Total(null);
		graoAreaPlantadaProjetadoTotal(null);
		
		graoProducaoTotal1(null);
		graoProducaoTotal2(null);
		graoProducaoTotal3(null);
		graoProducaoTotalProjetado(null);
		
		milhoAreaPlantada1Total(null);
		milhoAreaPlantada2Total(null);
		milhoAreaPlantada3Total(null);
		milhoAreaPlantadaProjetadoTotal(null);
		
		milhoProducaoTotal1(null);
		milhoProducaoTotal2(null);
		milhoProducaoTotal3(null);
		milhoProducaoTotalProjetado(null);
		
		calcularValoresSafra1(null);
		calcularValoresSafra2(null);
		calcularValoresSafra3(null);
		calcularValoresSafra4(null);
	}
	
	
	private void carregarDadosUsinas() {
		try {
			viewHelper.getModel().getAbaUsinas().setNomeUsina(questionarioAgronegocioService.consultaNomeUsina(viewHelper.getModel()));
			consultarUsinas();
			consultarProducaoUsinas();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	private void consultarUsinas(){
		try {
		List<ObjectUsinas> listaRetorno = questionarioAgronegocioService.consultaUsinas(viewHelper.getModel());

		for(ObjectUsinas usina : listaRetorno){
			switch (usina.getNumSequencialUsina()) {
			case 1:
				viewHelper.getModel().getAbaUsinas().setAnoAreaCorte1(usina.getAreaCorte());
				try {
					viewHelper.getModel().getAbaUsinas().getAnoAreaCorte1().setIdadeMediaCanavial(
							usina.getAreaCorte().getIdadeMediaCanavial().substring(0, usina.getAreaCorte().getIdadeMediaCanavial().length() -1));
				} catch (Exception e) {
					// TODO: handle exception
				}
				viewHelper.getModel().getAbaUsinas().setAnoCogeracaoEnergia1(usina.getCogeracaoEnergias());
				viewHelper.getModel().getAbaUsinas().setAnoMoagem1(usina.getMoagem());
				viewHelper.getModel().getAbaUsinas().setAnoProdutividade1(usina.getProdutividade());
				viewHelper.getModel().getAbaUsinas().setAnoTerra1(usina.getTerra());
				break;
			case 2:
				viewHelper.getModel().getAbaUsinas().setAnoAreaCorte2(usina.getAreaCorte());
				try {
					viewHelper.getModel().getAbaUsinas().getAnoAreaCorte2().setIdadeMediaCanavial(
							usina.getAreaCorte().getIdadeMediaCanavial().substring(0, usina.getAreaCorte().getIdadeMediaCanavial().length() -1));
				} catch (Exception e) {
					// TODO: handle exception
				}
				viewHelper.getModel().getAbaUsinas().setAnoCogeracaoEnergia2(usina.getCogeracaoEnergias());
				viewHelper.getModel().getAbaUsinas().setAnoMoagem2(usina.getMoagem());
				viewHelper.getModel().getAbaUsinas().setAnoProdutividade2(usina.getProdutividade());
				viewHelper.getModel().getAbaUsinas().setAnoTerra2(usina.getTerra());
				break;
			case 3:
				viewHelper.getModel().getAbaUsinas().setAnoAreaCorte3(usina.getAreaCorte());
				try {
					viewHelper.getModel().getAbaUsinas().getAnoAreaCorte3().setIdadeMediaCanavial(
							usina.getAreaCorte().getIdadeMediaCanavial().substring(0, usina.getAreaCorte().getIdadeMediaCanavial().length() -1));
				} catch (Exception e) {
					// TODO: handle exception
				}
				viewHelper.getModel().getAbaUsinas().setAnoCogeracaoEnergia3(usina.getCogeracaoEnergias());
				viewHelper.getModel().getAbaUsinas().setAnoMoagem3(usina.getMoagem());
				viewHelper.getModel().getAbaUsinas().setAnoProdutividade3(usina.getProdutividade());
				viewHelper.getModel().getAbaUsinas().setAnoTerra3(usina.getTerra());
				break;
			case 4:
				viewHelper.getModel().getAbaUsinas().setAnoAreaCorteProjetado(usina.getAreaCorte());
				try {
					viewHelper.getModel().getAbaUsinas().getAnoAreaCorteProjetado().setIdadeMediaCanavial(
							usina.getAreaCorte().getIdadeMediaCanavial().substring(0, usina.getAreaCorte().getIdadeMediaCanavial().length() -1));
				} catch (Exception e) {
					// TODO: handle exception
				}
				viewHelper.getModel().getAbaUsinas().setAnoCogeracaoEnergiaProjetado(usina.getCogeracaoEnergias());
				viewHelper.getModel().getAbaUsinas().setAnoMoagemProjetado(usina.getMoagem());
				viewHelper.getModel().getAbaUsinas().setAnoProdutividadeProjetado(usina.getProdutividade());
				viewHelper.getModel().getAbaUsinas().setAnoTerraProjetado(usina.getTerra());
				break;
			default:
				break;
			}
		}
		}catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	private void consultarProducaoUsinas(){

		try{
			List<ObjectUsinas> listaRetorno = questionarioAgronegocioService.consultaProducaoUsinas(viewHelper.getModel());

			int sequencial = 1;

			for(ObjectUsinas usina : listaRetorno){
				switch (sequencial) {
				case 1:
					viewHelper.getModel().getAbaUsinas().setAnoProducao1(usina.getProducao());
					break;
				case 2:
					viewHelper.getModel().getAbaUsinas().setAnoProducao2(usina.getProducao());
					break;
				case 3:
					viewHelper.getModel().getAbaUsinas().setAnoProducao3(usina.getProducao());
					break;
				case 4:
					viewHelper.getModel().getAbaUsinas().setAnoProducaoProjetado(usina.getProducao());
					break;
				default:
					break;
				}
				sequencial++;
			}
		}catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}

	}

	private void carregarDadosFibraAlgodao() {
		try {
			List<GraoFibraAux> listaAlgodao = questionarioAgronegocioService.consultarGraosFibras(viewHelper.getModel(), COD_ALGODAO);

			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().setAnoSafra1(new GraoFibraAux().mapearSaidaFibra(listaAlgodao.get(0)));
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().setAnoSafra2(new GraoFibraAux().mapearSaidaFibra(listaAlgodao.get(1)));
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().setAnoSafra3(new GraoFibraAux().mapearSaidaFibra(listaAlgodao.get(2)));
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().setAnoSafraProjetado(new GraoFibraAux().mapearSaidaFibra(listaAlgodao.get(3)));
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void carregarDadosGraoSoja() {
	    try {
			List<GraoFibraAux> listaSoja = questionarioAgronegocioService.consultarGraosFibras(viewHelper.getModel(), COD_SOJA);

			getViewHelper().getModel().getAbaGraos().getGraoSoja().setAnoSafra1(new GraoFibraAux().mapearSaidaGrao(listaSoja.get(0)));
			getViewHelper().getModel().getAbaGraos().getGraoSoja().setAnoSafra2(new GraoFibraAux().mapearSaidaGrao(listaSoja.get(1)));
			getViewHelper().getModel().getAbaGraos().getGraoSoja().setAnoSafra3(new GraoFibraAux().mapearSaidaGrao(listaSoja.get(2)));
			getViewHelper().getModel().getAbaGraos().getGraoSoja().setAnoSafraProjetado(new GraoFibraAux().mapearSaidaGrao(listaSoja.get(3)));
			AreaPlantadaGraosVO areaPlantada = getViewHelper().getModel().getAbaGraos().getGraoSoja().getAnoSafra1();
			getViewHelper().getModel().getAbaGraos().getGraoSoja().setPesoSacaSementes(areaPlantada.getPesoSacaSementes());
			getViewHelper().getModel().getAbaGraos().getGraoSoja().setPesoSacaMediaSemente(areaPlantada.getPesoSacaMediaSemente());
			
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	private void carregarDadosGraoMilho() {
		try {
			List<GraoFibraAux> listaMilho = questionarioAgronegocioService.consultarGraosFibras(viewHelper.getModel(), COD_MILHO);

			getViewHelper().getModel().getAbaGraos().getGraoMilho().setAnoSafra1(new GraoFibraAux().mapearSaidaGrao(listaMilho.get(0)));
			getViewHelper().getModel().getAbaGraos().getGraoMilho().setAnoSafra2(new GraoFibraAux().mapearSaidaGrao(listaMilho.get(1)));
			getViewHelper().getModel().getAbaGraos().getGraoMilho().setAnoSafra3(new GraoFibraAux().mapearSaidaGrao(listaMilho.get(2)));
			getViewHelper().getModel().getAbaGraos().getGraoMilho().setAnoSafraProjetado(new GraoFibraAux().mapearSaidaGrao(listaMilho.get(3)));
			AreaPlantadaGraosVO areaPlantada = getViewHelper().getModel().getAbaGraos().getGraoMilho().getAnoSafra1();
			getViewHelper().getModel().getAbaGraos().getGraoMilho().setPesoSacaSementes(areaPlantada.getPesoSacaSementes());
			getViewHelper().getModel().getAbaGraos().getGraoMilho().setPesoSacaMediaSemente(areaPlantada.getPesoSacaMediaSemente());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void carregarNomeProdutor() {
		try {
			QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
			GraosFibrasVO retorno = this.questionarioAgronegocioService.listarAreaPropria(
							RiccConstants.NOME_PRODUTOR, agro.getCodGrupo(),
							agro.getCodRelatorio());
			this.viewHelper.getModel().getAbaGraos().setNomeProdutor(retorno.getNomeProdutor());
			
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void listarAreaPropria() {
		try {
			QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
			GraosFibrasVO vo = agro.getAbaGraos();

			GraosFibrasVO retorno = this.questionarioAgronegocioService.listarAreaPropria(
							RiccConstants.AREA_PROPRIA, agro.getCodGrupo(),
							agro.getCodRelatorio());
			vo.setNomeProdutor(retorno.getNomeProdutor());
			vo.setListaAreaPropria(retorno.getListaAreaPropria());
			
			viewHelper.getModel().getAbaGraos().setSomaAreaTotalPropria(retorno.getSomaAreaTotalPropria());
			viewHelper.getModel().getAbaGraos().setSomaAreaProdutivaPropria(retorno.getSomaAreaProdutivaPropria());
			viewHelper.getModel().getAbaGraos().setSomaValorMercado(retorno.getSomaValorMercado());
			viewHelper.getModel().getAbaGraos().setSomaValorMercadoHectares(retorno.getSomaValorMercadoHectares());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public void listarAreaArrendada() {
		try {
			QuestionarioAgronegocioVO agro = this.viewHelper.getModel();
			GraosFibrasVO vo = agro.getAbaGraos();

			GraosFibrasVO retorno = this.questionarioAgronegocioService
					.listarAreaArrendada(RiccConstants.AREA_ARRENDADA,
							agro.getCodGrupo(), agro.getCodRelatorio());
			vo.setListaAreaArrendada(retorno.getListaAreaArrendada());
			
			viewHelper.getModel().getAbaGraos().setSomaAreaTotalArrendada(retorno.getSomaAreaTotalArrendada());
			viewHelper.getModel().getAbaGraos().setSomaAreaProdutivaArrendada(retorno.getSomaAreaProdutivaArrendada());
			viewHelper.getModel().getAbaGraos().setSomaCustoArrendamento(retorno.getSomaCustoArrendamento());
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}
	
	public String voltar(){
		return paginaAnterior;
	}
	
	public void graoAreaPlantada1Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra1().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra1().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja().getAnoSafra1()
				.setAreaTotal(calculo.toPlainString());

	}

	public void graoAreaPlantada2Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra2().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra2().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja().getAnoSafra2()
				.setAreaTotal(calculo.toPlainString());

	}

	public void graoAreaPlantada3Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra3().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra3().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja().getAnoSafra3()
				.setAreaTotal(calculo.toPlainString());

	}

	public void graoAreaPlantadaProjetadoTotal(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafraProjetado().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafraProjetado().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja()
				.getAnoSafraProjetado().setAreaTotal(calculo.toPlainString());

	}
	
	public void milhoAreaPlantada1Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra1().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra1().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho().getAnoSafra1()
				.setAreaTotal(calculo.toPlainString());

	}

	public void milhoAreaPlantada2Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra2().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra2().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho().getAnoSafra2()
				.setAreaTotal(calculo.toPlainString());

	}

	public void milhoAreaPlantada3Total(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra3().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra3().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho().getAnoSafra3()
				.setAreaTotal(calculo.toPlainString());

	}

	public void milhoAreaPlantadaProjetadoTotal(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafraProjetado().getAreaPropria()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafraProjetado().getAreaArrendada()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho()
				.getAnoSafraProjetado().setAreaTotal(calculo.toPlainString());

	}

	// Produção total realizada/projetada (saca de 60kg):
	public void graoProducaoTotal1(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra1().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra1().getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja().getAnoSafra1()
				.setProducaoTotal(calculo.toPlainString());

	}

	public void graoProducaoTotal2(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra2().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra2().getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja().getAnoSafra2()
				.setProducaoTotal(calculo.toPlainString());

	}

	public void graoProducaoTotal3(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra3().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafra3().getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja().getAnoSafra3()
				.setProducaoTotal(calculo.toPlainString());

	}

	public void graoProducaoTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafraProjetado().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoSoja().getAnoSafraProjetado()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoSoja()
				.getAnoSafraProjetado()
				.setProducaoTotal(calculo.toPlainString());

	}
	
	public void milhoProducaoTotal1(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra1().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra1().getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho().getAnoSafra1()
				.setProducaoTotal(calculo.toPlainString());

	}

	public void milhoProducaoTotal2(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra2().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra2().getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho().getAnoSafra2()
				.setProducaoTotal(calculo.toPlainString());

	}

	public void milhoProducaoTotal3(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra3().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafra3().getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho().getAnoSafra3()
				.setProducaoTotal(calculo.toPlainString());

	}

	public void milhoProducaoTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafraProjetado().getProducaoGraos()));
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getGraoMilho().getAnoSafraProjetado()
						.getProducaoSementes()));

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getGraoMilho()
				.getAnoSafraProjetado()
				.setProducaoTotal(calculo.toPlainString());

	}

	//Fibras
	public void calcularValoresSafra1(AjaxBehaviorEvent e) {
		try {
			//Area Propria
			BigDecimal areaPropria = new BigDecimal(
					siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
							.getFibraAlgodao().getAnoSafra1().getAreaPropria().replace(".", "")));
			//area Arrendada
			BigDecimal areaArrendada = new BigDecimal(
					siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
							.getFibraAlgodao().getAnoSafra1().getAreaArrendada().replace(".", "")));
			
			// Total Area Plantada
			BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().setAreaTotal(totalAreaPlantada.toPlainString());
			
			//Pluma em arroba/hectares
			BigDecimal plumaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().getPlumaHectare());
			
			//Caroco em arroba/hectares
			BigDecimal carocoHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().getCarocoHectare());
			
			//Fibrilha em arroba/hectares
			BigDecimal fibrilhaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().getFibrilhaHectare());
			
			//Total realizada / Projetada
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().setTotalHectare(new BigDecimal(0).add(plumaHectare).add(carocoHectare).add(fibrilhaHectare).toPlainString());
			
			//pluma arroba
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().setPlumaProducao(totalAreaPlantada.multiply(plumaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
			
			//Caroco arroba
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().setCarocoProducao(totalAreaPlantada.multiply(carocoHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
			
			//Fibrilha arroba
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().setFibrilhaProducao(totalAreaPlantada.multiply(fibrilhaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
			
			//Total producao 
			BigDecimal pluma = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().getPlumaProducao().replace(".", ""));
			BigDecimal caroco = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().getCarocoProducao().replace(".", ""));
			BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().getFibrilhaProducao().replace(".", ""));
			getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra1().setTotalProducao(new BigDecimal(0).add(pluma).add(caroco).add(fibrilha).toPlainString());
		} catch (Exception e1) {
			siteUtil.log(e1);
		}
	}
	
	public void calcularValoresSafra2(AjaxBehaviorEvent e) {
		//Area Propria
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getFibraAlgodao().getAnoSafra2().getAreaPropria()));
		//area Arrendada
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getFibraAlgodao().getAnoSafra2().getAreaArrendada()));
		
		// Total Area Plantada
		BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().setAreaTotal(totalAreaPlantada.toPlainString());
		
		//Pluma em arroba/hectares
		BigDecimal plumaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().getPlumaHectare());
		
		//Caroco em arroba/hectares
		BigDecimal carocoHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().getCarocoHectare());
		
		//Fibrilha em arroba/hectares
		BigDecimal fibrilhaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().getFibrilhaHectare());
		
		//Total realizada / Projetada
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().setTotalHectare(new BigDecimal(0).add(plumaHectare).add(carocoHectare).add(fibrilhaHectare).toPlainString());
		
		//pluma arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().setPlumaProducao(totalAreaPlantada.multiply(plumaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Caroco arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().setCarocoProducao(totalAreaPlantada.multiply(carocoHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Fibrilha arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().setFibrilhaProducao(totalAreaPlantada.multiply(fibrilhaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Total producao 
		BigDecimal pluma = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().getPlumaProducao());
		BigDecimal caroco = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().getCarocoProducao());
		BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().getFibrilhaProducao());
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra2().setTotalProducao(new BigDecimal(0).add(pluma).add(caroco).add(fibrilha).toPlainString());
	}
	
	public void calcularValoresSafra3(AjaxBehaviorEvent e) {
		//Area Propria
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getFibraAlgodao().getAnoSafra3().getAreaPropria()));
		//area Arrendada
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getFibraAlgodao().getAnoSafra3().getAreaArrendada()));
		
		// Total Area Plantada
		BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().setAreaTotal(totalAreaPlantada.toPlainString());
		
		//Pluma em arroba/hectares
		BigDecimal plumaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().getPlumaHectare());
		
		//Caroco em arroba/hectares
		BigDecimal carocoHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().getCarocoHectare());
		
		//Fibrilha em arroba/hectares
		BigDecimal fibrilhaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().getFibrilhaHectare());
		
		//Total realizada / Projetada
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().setTotalHectare(new BigDecimal(0).add(plumaHectare).add(carocoHectare).add(fibrilhaHectare).toPlainString());
		
		//pluma arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().setPlumaProducao(totalAreaPlantada.multiply(plumaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Caroco arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().setCarocoProducao(totalAreaPlantada.multiply(carocoHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Fibrilha arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().setFibrilhaProducao(totalAreaPlantada.multiply(fibrilhaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Total producao 
		BigDecimal pluma = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().getPlumaProducao());
		BigDecimal caroco = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().getCarocoProducao());
		BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().getFibrilhaProducao());
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafra3().setTotalProducao(new BigDecimal(0).add(pluma).add(caroco).add(fibrilha).toPlainString());
	}
	
	public void calcularValoresSafra4(AjaxBehaviorEvent e) {
		//Area Propria
		BigDecimal areaPropria = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getFibraAlgodao().getAnoSafraProjetado().getAreaPropria()));
		//area Arrendada
		BigDecimal areaArrendada = new BigDecimal(
				siteUtil.retirarMascaraNumericos(getViewHelper().getModel().getAbaGraos()
						.getFibraAlgodao().getAnoSafraProjetado().getAreaArrendada()));
		
		// Total Area Plantada
		BigDecimal totalAreaPlantada = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().setAreaTotal(totalAreaPlantada.toPlainString());
		
		//Pluma em arroba/hectares
		BigDecimal plumaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().getPlumaHectare());
		
		//Caroco em arroba/hectares
		BigDecimal carocoHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().getCarocoHectare());
		
		//Fibrilha em arroba/hectares
		BigDecimal fibrilhaHectare = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().getFibrilhaHectare());
		
		//Total realizada / Projetada
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().setTotalHectare(new BigDecimal(0).add(plumaHectare).add(carocoHectare).add(fibrilhaHectare).toPlainString());
		
		//pluma arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().setPlumaProducao(totalAreaPlantada.multiply(plumaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Caroco arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().setCarocoProducao(totalAreaPlantada.multiply(carocoHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Fibrilha arroba
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().setFibrilhaProducao(totalAreaPlantada.multiply(fibrilhaHectare).setScale(0, RoundingMode.HALF_EVEN).toPlainString());
		
		//Total producao 
		BigDecimal pluma = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().getPlumaProducao());
		BigDecimal caroco = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().getCarocoProducao());
		BigDecimal fibrilha = new BigDecimal(getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().getFibrilhaProducao());
		getViewHelper().getModel().getAbaGraos().getFibraAlgodao().getAnoSafraProjetado().setTotalProducao(new BigDecimal(0).add(pluma).add(caroco).add(fibrilha).toPlainString());
	}

	
	
	

	/************************************************************/
	/*															*/
	/* Aba "usinas de A&A" */
	/*															*/
	/************************************************************/

	// Moagem (k tons)
	public void moagemTotal1(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem1().getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem1().getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem1().getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));
		getViewHelper().getModel().getAbaUsinas().getAnoMoagem1()
				.setTotalMoagem(calculo.toPlainString());
	}

	public void moagemTotal2(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem2().getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem2().getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem2().getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));
		getViewHelper().getModel().getAbaUsinas().getAnoMoagem2()
				.setTotalMoagem(calculo.toPlainString());
	}

	public void moagemTotal3(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem3().getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem3().getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagem3().getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));
		getViewHelper().getModel().getAbaUsinas().getAnoMoagem3()
				.setTotalMoagem(calculo.toPlainString());
	}

	public void moagemTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal canaPropriaAreaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagemProjetado()
						.getCanaAreaPropria());
		BigDecimal canaPropriaAreaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagemProjetado()
						.getCanaAreaArrendada());
		BigDecimal canaTerceiros = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoMoagemProjetado()
						.getCanaTerceiros());

		BigDecimal calculo = canaPropriaAreaPropria
				.add(canaPropriaAreaArrendada.add(canaTerceiros));
		getViewHelper().getModel().getAbaUsinas().getAnoMoagemProjetado()
				.setTotalMoagem(calculo.toPlainString());
	}

	// Terra (ha)
	public void terraTotal1(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaUsinas()
						.getAnoTerra1().getAreaPropria());
		BigDecimal areaArrendada = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaUsinas()
						.getAnoTerra1().getAreaArrendada());

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaUsinas().getAnoTerra1()
				.setAreaTotal(calculo.toPlainString());

	}

	public void terraTotal2(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaUsinas()
						.getAnoTerra2().getAreaPropria());
		BigDecimal areaArrendada = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaUsinas()
						.getAnoTerra2().getAreaArrendada());

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaUsinas().getAnoTerra2()
				.setAreaTotal(calculo.toPlainString());

	}

	public void terraTotal3(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaUsinas()
						.getAnoTerra3().getAreaPropria());
		BigDecimal areaArrendada = siteUtil.valueToMainframeBigDecimal(getViewHelper().getModel().getAbaUsinas()
						.getAnoTerra3().getAreaArrendada());

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaUsinas().getAnoTerra3()
				.setAreaTotal(calculo.toPlainString());

	}

	public void terraTotalProjetado(AjaxBehaviorEvent e) {
		BigDecimal areaPropria = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerraProjetado().getAreaPropria());
		BigDecimal areaArrendada = siteUtil
				.valueToMainframeBigDecimal(getViewHelper().getModel()
						.getAbaUsinas().getAnoTerraProjetado()
						.getAreaArrendada());

		BigDecimal calculo = areaPropria.add(areaArrendada);
		getViewHelper().getModel().getAbaUsinas().getAnoTerraProjetado()
				.setAreaTotal(calculo.toPlainString());

	}

	public String getPaginaAnterior() {
		return paginaAnterior;
	}

	public void setPaginaAnterior(String paginaAnterior) {
		this.paginaAnterior = paginaAnterior;
	}

}
