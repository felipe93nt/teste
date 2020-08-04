/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.prazoStandby
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 01/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.prazoStandby;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.IPrazoStandbyService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.prazoStandby.bean.PrazoStandbyVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

/**
 * Nome: parametrizaPrazoStandbyBean.java
 * 
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 01/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
@Named("prazoStandbyBean")
@SessionScoped
public class PrazoStandbyBean extends BaseBean implements Serializable {

    /**
     * Atributes
     */
    private static final long serialVersionUID = 1L;

    /* Objeto utilizado nas telas de Inclusão / Alteração / Detalhe */
    private PrazoStandbyVO prazoStandbyVO = new PrazoStandbyVO();

    /* Variáveis de apoio a tela */
    private PrazoStandbyViewHelper viewHelper = new PrazoStandbyViewHelper();

    @Inject
    @Named("prazoStandbyService")
    private IPrazoStandbyService prazoStandbyService;

    /**
     * 
     * Nome: iniciar
     * 
     * Propósito: Iniciar dados da tela
     * 
     * @return : String de navegação
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {

        // Recarrega página se não for um postback ou se foi marcado para recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);
            
        	viewHelper.setDisabledBtnAlterar(false);
        	viewHelper.setDisabledBtnIncluir(true);
        	
        	if (getPrazoStandbyVO().getTdiamaxcredt().equals(viewHelper.getTdiamaxcredt()) == false ||
        			getPrazoStandbyVO().getTdiamaxcredt().equals(Numeros.ZERO)) {
            	setPrazoStandbyVO(prazoStandbyService.getPrazoStandby());
    			if (getPrazoStandbyVO().getTdiamaxcredt() == null) {
    		        BradescoFacesUtils.addInfoModalMessage(getPrazoStandbyVO().getTexmens(), false);
    				
    		    	viewHelper.setDisabledBtnAlterar(true);
    		    	viewHelper.setDisabledBtnIncluir(false);
    			}
    		}
        	
        	if (getPrazoStandbyVO().getTdiamaxcredt() == null) {
    			getPrazoStandbyVO().setTdiamaxcredt(0);
    		}
    		viewHelper.setTdiamaxcredt(getPrazoStandbyVO().getTdiamaxcredt());

        }
		
        return "prazoStandbyManut";
    }

    /**
     * Nome: incluir
     * 
     * Propósito: Carregar tela de alteração de contraparte
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluir(AjaxBehaviorEvent evento) {

        String result = SiteUtil.STRING_EMPTY;
        Integer iPrazo = 0;
        
        try {
        	iPrazo = viewHelper.getTdiamaxcredt().intValue();
		} catch (Exception e) {
	        NpcFacesUtils.addInfoModalMessage("Prazo inválido", false);
	        return;
		}
        
        getPrazoStandbyVO().setTdiamaxcredt(iPrazo);

        result = prazoStandbyService.incluiPrazoStandby(getPrazoStandbyVO().getTdiamaxcredt());

        viewHelper.setDisabledBtnAlterar(false);
        viewHelper.setDisabledBtnIncluir(true);
        
        setIniciarPagina(true);
        
        BradescoFacesUtils.addInfoModalMessage(result, "#{prazoStandbyBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }

    /**
     * Nome: alterar
     * 
     * Propósito: Carregar tela de alteração de contraparte
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void alterar(AjaxBehaviorEvent evento) {

        String result = SiteUtil.STRING_EMPTY;
        Integer iPrazo = 0;
        
        try {
        	iPrazo = viewHelper.getTdiamaxcredt().intValue();
		} catch (Exception e) {
	        NpcFacesUtils.addInfoModalMessage("Prazo inválido", false);
	        return;
		}
        
        getPrazoStandbyVO().setTdiamaxcredt(iPrazo);

        result = prazoStandbyService.alteraPrazoStandby(getPrazoStandbyVO().getTdiamaxcredt());

        setIniciarPagina(true);
        
        BradescoFacesUtils.addInfoModalMessage(result, "#{prazoStandbyBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }

	/**
	 * @return o valor do prazoStandbyVO
	 */
	public PrazoStandbyVO getPrazoStandbyVO() {
		return prazoStandbyVO;
	}

	/**
	 * @param prazoStandbyVO seta o novo valor para o campo prazoStandbyVO
	 */
	public void setPrazoStandbyVO(PrazoStandbyVO prazoStandbyVO) {
		this.prazoStandbyVO = prazoStandbyVO;
	}

	/**
	 * @return o valor do viewHelper
	 */
	public PrazoStandbyViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper seta o novo valor para o campo viewHelper
	 */
	public void setViewHelper(PrazoStandbyViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	/**
	 * @return o valor do prazoStandbyService
	 */
	public IPrazoStandbyService getPrazoStandbyService() {
		return prazoStandbyService;
	}

	/**
	 * @param prazoStandbyService seta o novo valor para o campo prazoStandbyService
	 */
	public void setPrazoStandbyService(IPrazoStandbyService prazoStandbyService) {
		this.prazoStandbyService = prazoStandbyService;
	}
}
