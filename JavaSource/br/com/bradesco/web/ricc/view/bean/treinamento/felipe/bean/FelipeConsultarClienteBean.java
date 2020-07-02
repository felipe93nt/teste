package br.com.bradesco.web.ricc.view.bean.treinamento.felipe.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.felipe.viewhelper.FelipeClienteViewHelper;


@SessionScoped
@Named(value = "felipeConsultarClienteBean")
public class FelipeConsultarClienteBean extends AbstractBean<FelipeClienteViewHelper> {
	/**
*
*/
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new FelipeClienteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_FELIPE_CLIENTE_CONSULTAR;
	}

	
	//metodo para voltar para o index
	public String voltar() {

		return paginaAnterior;
	}
	

	
	

}//fim da classe

