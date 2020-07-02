package br.com.bradesco.web.ricc.view.bean.manutencaomensagem.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.manutencaomensagem.viewhelper.ManutencaoMensagemViewHelper;

/**
 * @name ManutencaoMensagemSwrmBean
 * @author Foursys
 * @version 1.0
 * @since 08/06/2020
 */
@SessionScoped
@Named(value = "manutencaoMensagemBean")
public class ManutencaoMensagemBean extends
		AbstractBean<ManutencaoMensagemViewHelper> {

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
		setViewHelper(new ManutencaoMensagemViewHelper());
		viewHelper.inicializar();
		return RiccConstants.TELA_MANUTENCAO_MENSAGEM_CONSULTA;
	}

	public String voltar() {
		return paginaAnterior;
	}
}
