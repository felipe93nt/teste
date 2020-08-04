/**
 * Nome: br.com.bradesco.web.npcc.view.bean.global.alertasClienteModal
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 05/01/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2016
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.alertasClienteModal;

import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * Nome: AlertasClienteModalViewHelper.java
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
 *      Registro de Manuten��o: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public class AlertasClienteModalViewHelper implements Serializable {

    private static final long serialVersionUID = -3291553511461698661L;
    
    private Boolean renderModal = Boolean.FALSE;
    
    private String modalId;
    
    /**
     * URL para acesso ao relat�rio auditor desenvolvido no NPCP
     */
    private String url = SiteUtil.STRING_EMPTY;

    /**
     * @return o valor do renderModal
     */
    public Boolean getRenderModal() {
        return renderModal;
    }

    /**
     * @param renderModal seta o novo valor para o campo renderModal
     */
    public void setRenderModal(Boolean renderModal) {
        this.renderModal = renderModal;
    }

    /**
     * @return o valor do modalId
     */
    public String getModalId() {
        return modalId;
    }

    /**
     * @param modalId seta o novo valor para o campo modalId
     */
    public void setModalId(String modalId) {
        this.modalId = modalId;
    }

    /**
     * @return o valor do url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url seta o novo valor para o campo url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
