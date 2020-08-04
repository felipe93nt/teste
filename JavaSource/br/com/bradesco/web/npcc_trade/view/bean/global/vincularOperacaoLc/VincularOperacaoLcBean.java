/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.global.VincularOperacaoLc
 * Propósito: Classe comum para o controle do modal de cliente
 * Data da Criação: 05/01/2016
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.vincularOperacaoLc;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;

/**
 *
 * Nome: VincularOperacaoLcBean
 * 
 * Propósito: Bean de controle para modal de vincular operação a um LC
 *
 * Data: 05/01/2016 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2016 <br/>
 *
 * @version 1.0
 * @see
 */
@Named(value = "vincularOperacaoLcBean")
@SessionScoped
public class VincularOperacaoLcBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /** Variavel de auxilio a tela */
    private VincularOperacaoLcModalViewHelper viewHelper = new VincularOperacaoLcModalViewHelper();
    
    private VincularOperacaoLcVO vincularOperacaoLcVO = new VincularOperacaoLcVO();

    /**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa do cliente
     *
     * @param : 
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal(AjaxBehaviorEvent event) {
        getViewHelper().setRenderModal(Boolean.TRUE);
    }
    
    /**
     * Nome: closeModalCliente
     * 
     * Propósito: Fecha modal cliente
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal() {
        getViewHelper().setRenderModal(Boolean.FALSE);
    }
    
    /**
     * @return o valor do viewHelper
     */
    public VincularOperacaoLcModalViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper
     *            seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(VincularOperacaoLcModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }
    
    /**
     * @return o valor do vincularOperacaoLcVO
     */
    public VincularOperacaoLcVO getVincularOperacaoLcVO() {
        return vincularOperacaoLcVO;
    }

    /**
     * @param vincularOperacaoLcVO seta o novo valor para o campo vincularOperacaoLcVO
     */
    public void setVincularOperacaoLcVO(VincularOperacaoLcVO vincularOperacaoLcVO) {
        this.vincularOperacaoLcVO = vincularOperacaoLcVO;
    }

}