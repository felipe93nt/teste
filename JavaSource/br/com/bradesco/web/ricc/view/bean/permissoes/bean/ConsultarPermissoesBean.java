package br.com.bradesco.web.ricc.view.bean.permissoes.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.permissoes.PermissoesVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.permissoes.viewhelper.ConsultarPermissoesViewHelper;

/**
 * @name ConsultarPermissoesBean
 * @author Foursys
 * @version 1.0
 * @since 01/07/2020
 */

@SessionScoped
@Named(value = "consultarPermissoesBean")
public class ConsultarPermissoesBean extends
		AbstractBean<ConsultarPermissoesViewHelper> {

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
		setViewHelper(new ConsultarPermissoesViewHelper());
		viewHelper.inicializar();
		carregarListaPermissoesMock();
		return RiccConstants.TELA_CONSULTAR_PERMISSOES;
	}

	public String voltar() {
		return paginaAnterior;
	}

	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnAlterar(Boolean.FALSE);
		this.viewHelper.setBtnExcluir(Boolean.FALSE);
		this.viewHelper.setBtnDetalhar(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnAlterar(Boolean.TRUE);
			this.viewHelper.setBtnExcluir(Boolean.TRUE);
			this.viewHelper.setBtnDetalhar(Boolean.TRUE);
		}
	}

	public void carregarListaPermissoesMock() {
		PermissoesVO p1 = new PermissoesVO("M34567890",
				"SICRANO DE TAL E SILVA", "BBDEBRSPSPO",
				"BANCO BRADESCO S/A – SÃO PAULO", "0",
				"F12345678 30/06/2020 13:50");
		PermissoesVO p2 = new PermissoesVO("I34567899 ",
				"BELTRANO ANTONIO BARROS", "HSBCBRPRCTA",
				"BANCO HSBC BRASIL S/A – CURITIBA", "3",
				"G34567891 30/06/2020 13:45");
		PermissoesVO p3 = new PermissoesVO("M12345678 ",
				"FULANO DE TAL E SOUZA", "BBDEBRSPOCO",
				"BANCO BRADESCO S/A – CENTRO DE OPERAÇÕES", "-",
				"M45678901 30/06/2020 13:35");
		this.viewHelper.getListaPermissoesVO().add(p1);
		this.viewHelper.getListaPermissoesVO().add(p2);
		this.viewHelper.getListaPermissoesVO().add(p3);
	}

}
