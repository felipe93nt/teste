package br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.gustavo.viewhelper.GustavoClienteConsultaViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Gustavo Garcia - Foursys
 * @see GustavoClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "gustavoClienteConsultaBean")
public class GustavoClienteConsultaBean extends AbstractBean<GustavoClienteConsultaViewHelper> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 720577693145196748L;
	/**
	 * 
	 */

	private String paginaAnterior = "nav_index";

	@Override
	public String iniciarPagina() {
		this.viewHelper = new GustavoClienteConsultaViewHelper();
		this.viewHelper.inicializar();
		
		return RiccConstants.TELA_TREINAMENTO_GUSTAVO_CONSULTA;
	}
	
	
	
	public String voltar() {

		return paginaAnterior;
	}
	
	
	
	
	
	
	
	

}
