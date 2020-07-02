package br.com.bradesco.web.ricc.view.bean.manutencaotemplate.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.manutencaotemplate.viewhelper.ConsultarTemplateViewHelper;

/**
 * @name ConsultarTemplateBean
 * @author Foursys
 * @version 1.0
 * @since 16/06/2020
 */

@SessionScoped
@Named(value = "consultarTemplateBean")
public class ConsultarTemplateBean extends
AbstractBean<ConsultarTemplateViewHelper> {
	

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;

	private String paginaAnterior = "nav_index";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.Swrm.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new ConsultarTemplateViewHelper());
		viewHelper.inicializar();
		return RiccConstants.TELA_MANUTENCAO_CONSULTAR_TEMPLATE;
	}

	public String voltar() {
		return paginaAnterior;
	}

}
