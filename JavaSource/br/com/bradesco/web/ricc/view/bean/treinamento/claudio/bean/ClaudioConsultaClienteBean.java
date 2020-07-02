package br.com.bradesco.web.ricc.view.bean.treinamento.claudio.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.claudio.viewhelper.ClaudioClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Claudio Leite - Foursys
 * @see ClaudioClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "claudioConsultaClienteBean")
public class ClaudioConsultaClienteBean extends AbstractBean<ClaudioClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new ClaudioClienteViewHelper();
		this.viewHelper.popularCampos();
		
		return RiccConstants.TELA_CLAUDIO_CLIENTE_CONSULTA;
	}
}
