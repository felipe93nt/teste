package br.com.bradesco.web.ricc.view.bean.parametrizacao.bean;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.parametrizacao.ListaObrigatoriedadeParamVO;
import br.com.bradesco.web.ricc.service.business.parametrizacao.IParametrizacaoRelatorioService;
import br.com.bradesco.web.ricc.utils.Numeros;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacao.viewhelper.ParametrizacaoRelatorioViewHelper;

/**
 * @name ParametrizacaoRelatorioBean
 * @author Foursys
 * @see ParametrizacaoRelatorioBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "parametrizacaoRelatorioBean")
public class ParametrizacaoRelatorioBean extends
		AbstractBean<ParametrizacaoRelatorioViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	/**
	 * Atributo parametrizacaoRelatorioService Tipo
	 * IParametrizacaoRelatorioService
	 */
	@Inject
	@Named("parametrizacaoRelatorioService")
	private IParametrizacaoRelatorioService parametrizacaoRelatorioService;

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new ParametrizacaoRelatorioViewHelper();
		this.viewHelper.inicializar();
		this.detalhar();
		return RiccConstants.TELA_PARAMETRIZACAO_RELATORIO;
	}

	/**
	 * @description
	 * @name detalhar
	 * @see ParametrizacaoRelatorioBean
	 * @return void
	 */
	public void detalhar() {
		try {
			this.viewHelper
					.setRelatorioParametrizacaoVo(this.parametrizacaoRelatorioService
							.detalharRelatorio());
			this.viewHelper
					.setListaObrigatoriedadeSelecionada(new ArrayList<ListaObrigatoriedadeParamVO>());
			this.viewHelper.setListaObrigatoriedadeSelecionada(this.viewHelper
					.getRelatorioParametrizacaoVo().getListaObrigatoriedade());
			this.habilitarCampo();
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
	}

	/**
	 * @description
	 * @name salvar
	 * @see ParametrizacaoRelatorioBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		String retorno = "";

		if(altoVarejoSelecionado() &&
				siteUtil.isEmptyOrNull(viewHelper.getRelatorioParametrizacaoVo().getRiscoTotal())){
			BradescoFacesUtils.addInfoModalMessage("Campo Risco Total é obrigatório!", false);
			return null;
		}
		
		try {
			this.viewHelper.getRelatorioParametrizacaoVo()
					.setListaObrigatoriedade(
							this.viewHelper
									.getListaObrigatoriedadeSelecionada());
			retorno = this.parametrizacaoRelatorioService
					.salvarRelatorio(this.viewHelper
							.getRelatorioParametrizacaoVo());
			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			
			detalhar();
			
		} catch (Exception e) {
			siteUtil.trataExceptionRecebida(e);
		}
		
		return null;
	}

	private boolean altoVarejoSelecionado() {
		for (ListaObrigatoriedadeParamVO vo : viewHelper.getListaObrigatoriedadeSelecionada()) {
			if (Long.valueOf(vo.getCodigo()).equals(RiccConstants.SEGMENTO_ALTOVAREJO)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @description
	 * @name habilitarCampo
	 * @see ParametrizacaoRelatorioBean
	 * @return void
	 */
	public void habilitarCampo () {
		this.viewHelper.setRiscoTotalInput(false);
		for (ListaObrigatoriedadeParamVO item : viewHelper.getListaObrigatoriedadeSelecionada()) {
			if (RiccConstants.SEGMENTO_ALTOVAREJO.equals(Long.valueOf(item.getCodigo()))) {
				viewHelper.setRiscoTotalInput(true);
			}
		}
	}

	/**
	 * @description
	 * @name habilitaRiscoTotal
	 * @see ParametrizacaoRelatorioBean
	 * @param e
	 * @return void
	 */
	public void habilitaRiscoTotal(AjaxBehaviorEvent e) {
		boolean checkVarejo = Boolean.FALSE;
		this.viewHelper.setRiscoTotalInput(Boolean.FALSE);

		for (ListaObrigatoriedadeParamVO vo : this.viewHelper
				.getListaObrigatoriedadeSelecionada()) {
			if (vo.getCodigo() == Numeros.TRES) {
				checkVarejo = true;
			}
		}

		if (checkVarejo) {
			this.viewHelper.setRiscoTotalInput(Boolean.TRUE);
		} else {
			this.viewHelper.setRiscoTotalInput(Boolean.FALSE);
		}
	}
}
