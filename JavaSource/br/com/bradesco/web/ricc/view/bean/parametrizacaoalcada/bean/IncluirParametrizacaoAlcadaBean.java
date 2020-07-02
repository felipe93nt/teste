package br.com.bradesco.web.ricc.view.bean.parametrizacaoalcada.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacaoalcada.viewhelper.IncluirParametrizacaoAlcadaViewHelper;

/**
 * @name ComponenteMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 23/06/2020
 */
@SessionScoped
@Named(value = "incluirParametrizacaoAlcadaBean")
public class IncluirParametrizacaoAlcadaBean extends
		AbstractBean<IncluirParametrizacaoAlcadaViewHelper> {

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 2818192176021735920L;

	private String paginaAnterior = "nav_index";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.Swrm.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new IncluirParametrizacaoAlcadaViewHelper());
		viewHelper.inicializar();
		return RiccConstants.TELA_PARAMETRIZACAO_INCLUIR_ALCADA;
	}

	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnIncluir(Boolean.TRUE);
	}
	
		public String voltar() {
		return paginaAnterior;
	}
}
