package br.com.bradesco.web.ricc.view.bean.parametrizacaoalcada.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.parametrizacaoalcada.AlcadaVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacaoalcada.viewhelper.ConsultarParametrizacaoAlcadaViewHelper;

/**
 * @name ComponenteMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 23/06/2020
 */
@SessionScoped
@Named(value = "consultarParametrizacaoAlcadaBean")
public class ConsultarParametrizacaoAlcadaBean extends
		AbstractBean<ConsultarParametrizacaoAlcadaViewHelper> {

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
		setViewHelper(new ConsultarParametrizacaoAlcadaViewHelper());
		viewHelper.inicializar();
		carregarListaAlcadaVO();
		return RiccConstants.TELA_PARAMETRIZACAO_CONSULTAR_ALCADA;
	}

	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnAlterar(Boolean.FALSE);
		this.viewHelper.setBtnExcluir(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnAlterar(Boolean.TRUE);
			this.viewHelper.setBtnExcluir(Boolean.TRUE);
		}
	}
	
	public void carregarListaAlcadaVO() {
		AlcadaVO alcada = new AlcadaVO();
		
		alcada.setIdentidade("001");
		alcada.setValorMaximoAlcada("-");
		alcada.setNivelMinimoUm("1");
		alcada.setNivelMinimoDois("2");
		alcada.setUltimaAlteracao("F6543210   30/06/2020 15:47");
		viewHelper.getListaAlcadaVO().add(alcada);
		
		alcada = new AlcadaVO();
		
		alcada.setIdentidade("002");
		alcada.setValorMaximoAlcada("10.000,00");
		alcada.setNivelMinimoUm("0");
		alcada.setNivelMinimoDois("1");
		alcada.setUltimaAlteracao("F6543210   30/06/2020 15:50");
		viewHelper.getListaAlcadaVO().add(alcada);
		
		alcada = new AlcadaVO();
		
		alcada.setIdentidade("003");
		alcada.setValorMaximoAlcada("25.000,00");
		alcada.setNivelMinimoUm("1");
		alcada.setNivelMinimoDois("1");
		alcada.setUltimaAlteracao("F6543210   30/06/2020 15:52");
		viewHelper.getListaAlcadaVO().add(alcada);
		
		alcada = new AlcadaVO();
		
		alcada.setIdentidade("004");
		alcada.setValorMaximoAlcada("100.000,00");
		alcada.setNivelMinimoUm("1");
		alcada.setNivelMinimoDois("2");
		alcada.setUltimaAlteracao("F6543210   30/06/2020 15:55");
		viewHelper.getListaAlcadaVO().add(alcada);
		
		alcada = new AlcadaVO();
		
		alcada.setIdentidade("005");
		alcada.setValorMaximoAlcada("1.000.000,00");
		alcada.setNivelMinimoUm("2");
		alcada.setNivelMinimoDois("3");
		alcada.setUltimaAlteracao("F6543210   30/06/2020 15:58");
		viewHelper.getListaAlcadaVO().add(alcada);

		alcada = new AlcadaVO();
		
		alcada.setIdentidade("006");
		alcada.setValorMaximoAlcada("999.999.999,00");
		alcada.setNivelMinimoUm("3");
		alcada.setNivelMinimoDois("3");
		alcada.setUltimaAlteracao("F6543210   30/06/2020 16:00");
		viewHelper.getListaAlcadaVO().add(alcada);
	
	}
	
	public String voltar() {
		return paginaAnterior;
	}
}
