package br.com.bradesco.web.ricc.view.bean.questionarioagronegocio.viewhelper;

import java.io.Serializable;

import javax.faces.event.AjaxBehaviorEvent;

import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaArrendadaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.AreaPropriaAgronegocioVO;
import br.com.bradesco.web.ricc.model.cadastro.questionarioagronegocio.QuestionarioAgronegocioVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

/**
 * @name QuestionarioAgronegocioViewHelper
 * @author Foursys
 * @see QuestionarioAgronegocioViewHelper.java
 * @version 1.0
 * @since 12/09/2018
 */
public class QuestionarioAgronegocioViewHelper extends AbstractViewHelper
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6865033632937524057L;

	/**
	 * Atributo model Tipo QuestionarioAgronegocioVO
	 */
	private QuestionarioAgronegocioVO model;
	/**
	 * Atributo renderAbaGraosFibras Tipo Boolean
	 */
	private Boolean renderAbaGraosFibras;
	/**
	 * Atributo renderAbaUsinas Tipo Boolean
	 */
	private Boolean renderAbaUsinas;
	/**
	 * Atributo desabilitaIncluirAreaHectare Tipo Boolean
	 */
	private Boolean desabilitaIncluirAreaPropria = Boolean.FALSE;
	/**
	 * Atributo desabilitaIncluirAreaArrendada Tipo Boolean
	 */
	private Boolean desabilitaIncluirAreaArrendada = Boolean.FALSE;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractViewHelper#inicializar()
	 */
	@Override
	public void inicializar() {
		model = new QuestionarioAgronegocioVO();
		renderAbaGraosFibras = Boolean.TRUE;
		renderAbaUsinas = Boolean.FALSE;
	}

	/**
	 * @description
	 * @name desabilitaIncluirAreaPropria
	 * @see QuestionarioAgronegocioViewHelper
	 * @param e
	 * @return void
	 */
	public void desabilitaIncluirAreaPropria(AjaxBehaviorEvent e) {
		AreaPropriaAgronegocioVO campos = model.getAbaGraos().getAreaPropria();
		if (siteUtil.isEmptyOrNull(campos.getDescricao())) {
			setDesabilitaIncluirAreaPropria(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getAreaTotal())) {
			setDesabilitaIncluirAreaPropria(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getAreaProdutiva())) {
			setDesabilitaIncluirAreaPropria(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getCidade())) {
			setDesabilitaIncluirAreaPropria(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getValorMercado())) {
			setDesabilitaIncluirAreaPropria(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getValorMercadoHectare())) {
			setDesabilitaIncluirAreaPropria(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getIsAreaCedida())) {
			setDesabilitaIncluirAreaPropria(Boolean.FALSE);
		} else {
			setDesabilitaIncluirAreaPropria(Boolean.TRUE);
		}
	}

	/**
	 * @description
	 * @name desabilitaIncluirAreaArrendada
	 * @see QuestionarioAgronegocioViewHelper
	 * @param e
	 * @return void
	 */
	public void desabilitaIncluirAreaArrendada(AjaxBehaviorEvent e) {
		AreaArrendadaAgronegocioVO campos = model.getAbaGraos()
				.getAreaArrendada();
		if (siteUtil.isEmptyOrNull(campos.getDescricao())) {
			setDesabilitaIncluirAreaArrendada(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getAreaTotal())) {
			setDesabilitaIncluirAreaArrendada(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getAreaProdutiva())) {
			setDesabilitaIncluirAreaArrendada(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getCidade())) {
			setDesabilitaIncluirAreaArrendada(Boolean.FALSE);
		} else if (siteUtil.isEmptyOrNull(campos.getCustoArrendamento())) {
			setDesabilitaIncluirAreaArrendada(Boolean.FALSE);
		} else {
			setDesabilitaIncluirAreaArrendada(Boolean.TRUE);
		}
	}

	/**
	 * @return the model
	 */
	public QuestionarioAgronegocioVO getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(QuestionarioAgronegocioVO model) {
		this.model = model;
	}

	/**
	 * @return the renderAbaGraosFibras
	 */
	public Boolean getRenderAbaGraosFibras() {
		return renderAbaGraosFibras;
	}

	/**
	 * @param renderAbaGraosFibras
	 *            the renderAbaGraosFibras to set
	 */
	public void setRenderAbaGraosFibras(Boolean renderAbaGraosFibras) {
		this.renderAbaGraosFibras = renderAbaGraosFibras;
	}

	/**
	 * @return the renderAbaUsinas
	 */
	public Boolean getRenderAbaUsinas() {
		return renderAbaUsinas;
	}

	/**
	 * @param renderAbaUsinas
	 *            the renderAbaUsinas to set
	 */
	public void setRenderAbaUsinas(Boolean renderAbaUsinas) {
		this.renderAbaUsinas = renderAbaUsinas;
	}

	/**
	 * @return the desabilitaIncluirAreaPropria
	 */
	public Boolean getDesabilitaIncluirAreaPropria() {
		return desabilitaIncluirAreaPropria;
	}

	/**
	 * @param desabilitaIncluirAreaPropria
	 *            the desabilitaIncluirAreaPropria to set
	 */
	public void setDesabilitaIncluirAreaPropria(
			Boolean desabilitaIncluirAreaPropria) {
		this.desabilitaIncluirAreaPropria = desabilitaIncluirAreaPropria;
	}

	/**
	 * @return the desabilitaIncluirAreaArrendada
	 */
	public Boolean getDesabilitaIncluirAreaArrendada() {
		return desabilitaIncluirAreaArrendada;
	}

	/**
	 * @param desabilitaIncluirAreaArrendada
	 *            the desabilitaIncluirAreaArrendada to set
	 */
	public void setDesabilitaIncluirAreaArrendada(
			Boolean desabilitaIncluirAreaArrendada) {
		this.desabilitaIncluirAreaArrendada = desabilitaIncluirAreaArrendada;
	}

}
