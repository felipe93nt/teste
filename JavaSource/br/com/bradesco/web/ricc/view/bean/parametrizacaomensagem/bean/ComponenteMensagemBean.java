package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper.ComponenteMensagemViewHelper;

/**
 * @name ComponenteMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 23/06/2020
 */
@SessionScoped
@Named(value = "componenteMensagemBean")
public class ComponenteMensagemBean extends
		AbstractBean<ComponenteMensagemViewHelper> {

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
		setViewHelper(new ComponenteMensagemViewHelper());
		viewHelper.inicializar();
		return RiccConstants.TELA_PARAMETRIZACAO_COMPONENTES_MENSAGEM;
	}

	public String voltar() {
		return paginaAnterior;
	}
}
