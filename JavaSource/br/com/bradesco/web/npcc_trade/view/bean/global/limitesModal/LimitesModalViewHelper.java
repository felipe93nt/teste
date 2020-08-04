/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.global.limitesDisponiveis
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/03/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.limitesModal;

import br.com.bradesco.web.npcc_trade.utils.SiteUtil;

/**
 * Nome: LimitesModalViewHelper.java
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
 *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class LimitesModalViewHelper {

    /** Item selecionado na lista de banco emissor **/
    private String codItemSelecionadoLimite = SiteUtil.STRING_EMPTY;
    private String codItemSelecionadoProposta = SiteUtil.STRING_EMPTY;
    private Boolean itemSelecionado = Boolean.FALSE;
    private Boolean isConfirmaModallimite = Boolean.FALSE;
    private Boolean acaoConfirmacao = Boolean.FALSE;

	/** Variáveis de controle do MODAL **/
    private Boolean renderModal = Boolean.FALSE;

    /** Variáveis de com o id do modal **/
    private String modalId = "";

    /** Atributo de controle do MODAL para seleção de Propostas **/
    private Boolean tratarSelecionarProposta = Boolean.TRUE;
    
    private boolean selecaoObrigatoria = false;
    
    public Boolean getTratarSelecionarProposta() {
        return tratarSelecionarProposta;
    }

    public void setTratarSelecionarProposta(Boolean tratarSelecionarProposta) {
        this.tratarSelecionarProposta = tratarSelecionarProposta;
    }

	/**
     * @return o valor do codItemSelecionadoLimite
     */
    public String getCodItemSelecionadoLimite() {
        return codItemSelecionadoLimite;
    }

    /**
     * @param codItemSelecionadoLimite seta o novo valor para o campo codItemSelecionadoLimite
     */
    public void setCodItemSelecionadoLimite(String codItemSelecionadoLimite) {
        this.codItemSelecionadoLimite = codItemSelecionadoLimite;
    }

    /**
     * @return o valor do codItemSelecionadoProposta
     */
    public String getCodItemSelecionadoProposta() {
        if(getTratarSelecionarProposta().equals(Boolean.TRUE)) {    
            return codItemSelecionadoProposta;
         } else {
             return null;
         }
                
    }

    /**
     * @param codItemSelecionadoProposta seta o novo valor para o campo codItemSelecionadoProposta
     */
    public void setCodItemSelecionadoProposta(String codItemSelecionadoProposta) {
        this.codItemSelecionadoProposta = codItemSelecionadoProposta;
    }

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
     * @return o valor do itemSelecionado
     */
    public Boolean getItemSelecionado() {
        return itemSelecionado;
    }

    /**
     * @param itemSelecionado seta o novo valor para o campo itemSelecionado
     */
    public void setItemSelecionado(Boolean itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }
    
    public Boolean getIsConfirmaModallimite() {
		return isConfirmaModallimite;
	}

	public void setIsConfirmaModallimite(Boolean isConfirmaModallimite) {
		this.isConfirmaModallimite = isConfirmaModallimite;
	}

    /**
     * @return o valor do selecaoObrigatoria
     */
	public boolean isSelecaoObrigatoria() {
		return selecaoObrigatoria;
	}

    /**
     * @param selecaoObrigatoria seta o novo valor para o campo selecaoObrigatoria
     */
	public void setSelecaoObrigatoria(boolean selecaoObrigatoria) {
		this.selecaoObrigatoria = selecaoObrigatoria;
	}

    /**
     * @return o valor do acaoConfirmacao
     */
    public Boolean getAcaoConfirmacao() {
        return acaoConfirmacao;
    }

    /**
     * @param acaoConfirmacao seta o novo valor para o campo acaoConfirmacao
     */
    public void setAcaoConfirmacao(Boolean acaoConfirmacao) {
        this.acaoConfirmacao = acaoConfirmacao;
    }
}
