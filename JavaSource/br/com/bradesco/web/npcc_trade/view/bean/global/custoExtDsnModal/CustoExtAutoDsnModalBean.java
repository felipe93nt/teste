/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.global.custoExtDsnModal
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 29/04/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.custoExtDsnModal;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * Nome: CustoExtAutoDsnModalBean.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 29/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */
@Named(value = "custoExtAutoDsnModalBean")
@SessionScoped
public class CustoExtAutoDsnModalBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 697082233646550474L;

    public final static int BTN_CONFIRMAR = 1;
    public final static int BTN_CANCELAR = 2;

    private CustoExtAutoDsnModalViewHelper viewHelper = new CustoExtAutoDsnModalViewHelper();

    private TrdFinNegocInclVO tradeFinNegocVO = new TrdFinNegocInclVO();

    /**
     * Construtor
     * 
     * @param
     */
    public CustoExtAutoDsnModalBean() {
        super();
    }

    /**
     * 
     * Nome: openModal
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 11/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void openModal(AjaxBehaviorEvent event) {
        viewHelper.setBotaoAcionado(BTN_CANCELAR);
        viewHelper.setTxtMotivo("");
        viewHelper.setRenderModal(Boolean.TRUE);
    }

    /**
     * Nome: closeModal
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 10/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void closeModal(ActionEvent event) {
        viewHelper.setRenderModal(Boolean.FALSE);
    }

    public void closeModalCotarCustoExterno() {
        viewHelper.setRenderModal(Boolean.FALSE);
    }

    /**
     * Nome: confirmarModalMotivo
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 10/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String confirmarModalMotivo() {
        
        if(SiteUtil.isEmptyOrNull(getViewHelper().getTxtMotivo())) {
            
            NpcFacesUtils.addInfoModalMessage("O campo " + viewHelper.getLabelMotivo() + " � obrigat�rio.", EnumButtonBehavior.SUBMIT);
            
            return null;
        }
        
        viewHelper.setBotaoAcionado(BTN_CONFIRMAR);
        getTradeFinNegocVO().setMotivo(viewHelper.getTxtMotivo());

        return "/content/global/custoExtDsnModal/custoExtAutoDsnModalClose.xhtml";
    }

    /**
     * Nome: getViewHelper
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 10/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public CustoExtAutoDsnModalViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * Nome: setViewHelper
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 10/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void setViewHelper(CustoExtAutoDsnModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do tradeFinNegocVO
     */
    public TrdFinNegocInclVO getTradeFinNegocVO() {
        return tradeFinNegocVO;
    }

    /**
     * @param tradeFinNegocVO
     *            seta o novo valor para o campo tradeFinNegocVO
     */
    public void setTradeFinNegocVO(TrdFinNegocInclVO tradeFinNegocVO) {
        this.tradeFinNegocVO = tradeFinNegocVO;
    }

}
