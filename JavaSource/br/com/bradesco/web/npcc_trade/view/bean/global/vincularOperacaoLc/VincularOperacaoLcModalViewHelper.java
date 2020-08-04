/**
 * Nome: br.com.bradesco.web.npcc.view.bean.global.vincularOperacaoLcModalViewHelper
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 05/01/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2016
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.vincularOperacaoLc;

import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * Nome: VincularOperacaoLcModalViewHelper.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class VincularOperacaoLcModalViewHelper implements Serializable {

    private static final long serialVersionUID = -3291553511461698661L;
    
    private Boolean renderModal = Boolean.FALSE;
    
    private String mesagemConfirmacao = SiteUtil.STRING_EMPTY;
    
    private String mesagemNumeroCotacao = SiteUtil.STRING_EMPTY;
    
    private String perguntaOperacao = SiteUtil.STRING_EMPTY;
    
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
     * @return o valor do mesagemConfirmacao
     */
    public String getMesagemConfirmacao() {
        return mesagemConfirmacao;
    }

    /**
     * @param mesagemConfirmacao seta o novo valor para o campo mesagemConfirmacao
     */
    public void setMesagemConfirmacao(String mesagemConfirmacao) {
        this.mesagemConfirmacao = mesagemConfirmacao;
    }

    /**
     * @return o valor do mesagemNumeroCotacao
     */
    public String getMesagemNumeroCotacao() {
        return mesagemNumeroCotacao;
    }

    /**
     * @param mesagemNumeroCotacao seta o novo valor para o campo mesagemNumeroCotacao
     */
    public void setMesagemNumeroCotacao(String mesagemNumeroCotacao) {
        this.mesagemNumeroCotacao = mesagemNumeroCotacao;
    }

    /**
     * @return o valor do perguntaOperacao
     */
    public String getPerguntaOperacao() {
        return perguntaOperacao;
    }

    /**
     * @param perguntaOperacao seta o novo valor para o campo perguntaOperacao
     */
    public void setPerguntaOperacao(String perguntaOperacao) {
        this.perguntaOperacao = perguntaOperacao;
    }
}
