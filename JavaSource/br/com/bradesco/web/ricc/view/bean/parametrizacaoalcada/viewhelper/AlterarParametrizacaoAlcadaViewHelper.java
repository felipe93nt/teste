package br.com.bradesco.web.ricc.view.bean.parametrizacaoalcada.viewhelper;

import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class AlterarParametrizacaoAlcadaViewHelper extends AbstractViewHelper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1657673372699105232L;
	
	private Boolean btnConfirmar = Boolean.TRUE;


	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the btnConfirmar
	 */
	public Boolean getBtnConfirmar() {
		return btnConfirmar;
	}


	/**
	 * @param btnConfirmar the btnConfirmar to set
	 */
	public void setBtnConfirmar(Boolean btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}
	
}
