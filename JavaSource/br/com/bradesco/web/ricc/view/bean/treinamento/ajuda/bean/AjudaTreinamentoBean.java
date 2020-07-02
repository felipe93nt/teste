package br.com.bradesco.web.ricc.view.bean.treinamento.ajuda.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.ajuda.viewhelper.AjudaTreinamentoViewHelper;

/**
 * @name AjudaTreinamentoBean
 * @author Diego Munhoz - Foursys
 * @see Equipe4Bean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "ajudaTreinamentoBean")
public class AjudaTreinamentoBean extends
		AbstractBean<AjudaTreinamentoViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;
	
	private String paginaAnterior = "";

	/*
	 * (non-Javadoc)
	 *
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new AjudaTreinamentoViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_TREINAMENTO_AJUDA;
	}


	/**
	 * @description
	 * @name salvar
	 * @see AjudaTreinamentoBean
	 * @return
	 * @return String
	 */
	public String salvar() {
		String retorno = "Exemplo salvo com sucesso!";
		
		BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
		
		return null;
	}
	
	public String voltar() {

		return paginaAnterior;
	}

}
