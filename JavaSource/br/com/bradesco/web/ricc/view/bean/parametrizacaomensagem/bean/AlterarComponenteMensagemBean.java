package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper.AlterarComponenteMensagemViewHelper;

/**
 * @name ComponenteMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 26/06/2020
 */
@SessionScoped
@Named(value = "alterarComponenteMensagemBean")
public class AlterarComponenteMensagemBean extends
		AbstractBean<AlterarComponenteMensagemViewHelper> {

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;

	private String paginaAnterior = RiccConstants.TELA_PARAMETRIZACAO_CONSULTAR_COMPONENTE_MENSAGEM;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.Swrm.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new AlterarComponenteMensagemViewHelper());
		viewHelper.inicializar();
		return RiccConstants.TELA_PARAMETRIZACAO_ALTERAR_COMPONENTES_MENSAGEM;
	}

	public String voltar() {
		return paginaAnterior;
	}
}
