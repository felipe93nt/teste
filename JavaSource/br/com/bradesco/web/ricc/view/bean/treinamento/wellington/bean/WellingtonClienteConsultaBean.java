package br.com.bradesco.web.ricc.view.bean.treinamento.wellington.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.treinamento.ClienteWellingtonVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.wellington.viewhelper.WellingtonClienteViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Diego Munhoz - Foursys
 * @see WellingtonClienteBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "wellingtonClienteConsultaBean")
public class WellingtonClienteConsultaBean extends
		AbstractBean<WellingtonClienteViewHelper> {
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
		this.viewHelper = new WellingtonClienteViewHelper();
		viewHelper.carregarVO(mockCliente());
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_CONSULTAR_CLIENTE;
	}
	
	public ClienteWellingtonVO mockCliente(){
		return new ClienteWellingtonVO("Wellington Correia Martins","423.454.444-03","50.505.235-6","09/02/1995","Masculino","Al. Grajaú","249","Apto. 91","Alphaville","Barueri","São Paulo","02135-230","(19)3921-3737","(19)98754-5688","well@gmail.com");
	}

	public String voltar() {

		return paginaAnterior;
	}

}
