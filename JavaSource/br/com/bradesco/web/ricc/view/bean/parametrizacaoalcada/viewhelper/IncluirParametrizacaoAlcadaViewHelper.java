package br.com.bradesco.web.ricc.view.bean.parametrizacaoalcada.viewhelper;

import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class IncluirParametrizacaoAlcadaViewHelper extends AbstractViewHelper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1657673372699105232L;
	
	private Boolean btnIncluir = Boolean.TRUE;


	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
	}


	/**
	 * @return the btnIncluir
	 */
	public Boolean getBtnIncluir() {
		return btnIncluir;
	}


	/**
	 * @param btnIncluir the btnIncluir to set
	 */
	public void setBtnIncluir(Boolean btnIncluir) {
		this.btnIncluir = btnIncluir;
	}
	
}
