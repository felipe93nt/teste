package br.com.bradesco.web.ricc.view.bean.permissoes.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.permissoes.InstrucoesVO;
import br.com.bradesco.web.ricc.model.permissoes.MtVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.permissoes.viewhelper.AlterarPermissoesViewHelper;

/**
 * @name AlterarPermissoesBean
 * @author Foursys
 * @version 1.0
 * @since 01/07/2020
 */
@SessionScoped
@Named(value = "alterarPermissoesBean")
public class AlterarPermissoesBean extends
AbstractBean<AlterarPermissoesViewHelper> {
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
		setViewHelper(new AlterarPermissoesViewHelper());
		viewHelper.inicializar();
		carregarListaInstrucoesVO();
		carregarListaMtVO();
		return RiccConstants.TELA_PARAMETRIZACAO_ALTERAR_PERMISSOES;
	}

	public String voltar() {
		return paginaAnterior;
	}
	
	private void carregarListaInstrucoesVO() {
		InstrucoesVO i1 = new InstrucoesVO();
		i1.setIdentificacao("BBDEBRSPSPO BANCO BRADESCO S/A-SÃO PAULO");
		viewHelper.getListaInstrucoesVO().add(i1);
		InstrucoesVO i2 = new InstrucoesVO();
		i2.setIdentificacao("BBDEBRSPRJO BANCO BRADESCO S/A-RIO DE JANEIRO");
		viewHelper.getListaInstrucoesVO().add(i2);
		InstrucoesVO i3 = new InstrucoesVO();
		i3.setIdentificacao("HSBCBRPRCTA BANCO HSBC BRASIL S/A-CURITIBA");
		viewHelper.getListaInstrucoesVO().add(i3);
		InstrucoesVO i4 = new InstrucoesVO();
		i4.setIdentificacao("");
		viewHelper.getListaInstrucoesVO().add(i4);
	}
	
	private void carregarListaMtVO() {
		MtVO m1 = new MtVO();
		m1.setIdentificacao("103");
		viewHelper.getListaMtVO().add(m1);
		MtVO m2 = new MtVO();
		m2.setIdentificacao("202 COV");
		viewHelper.getListaMtVO().add(m2);
		MtVO m3 = new MtVO();
		m3.setIdentificacao("7**");
		viewHelper.getListaMtVO().add(m3);
		MtVO m4 = new MtVO();
		m4.setIdentificacao("");
		viewHelper.getListaMtVO().add(m4);
	}
	
	public void habilitarBotoesInstrucoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnRemoverInstrucoesAutorizadas(Boolean.FALSE);
		if (!this.viewHelper.getListaInstrucaoSelecionadaVO().isEmpty()) {
			this.viewHelper.setBtnRemoverInstrucoesAutorizadas(Boolean.TRUE);
		}
	}
	
	public void habilitarBotoesMensagensAutorizadas(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnRemoverMensagensAutorizadas(Boolean.FALSE);
		if (!this.viewHelper.getListaMtSelecionadaVO().isEmpty()) {
			this.viewHelper.setBtnRemoverMensagensAutorizadas(Boolean.TRUE);
		}
	}
}