/**
 * Nome: br.com.bradesco.web.npcc_garantias.view.bean.global.desenquadradas
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 12/05/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.desenquadradaModal;

/**
 * Nome: DesenquadradasViewHelper.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ - Francinaldo Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 12/05/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class DesenquadramentoViewHelper {

    private Boolean renderModalDesenquadradas = Boolean.FALSE;
    private String modalId = "";
    private Integer botaoAcionado = 0;
    private Integer telaOrigem = 0;

    /**
     * @return o valor do renderModalDesenquadradas
     */
    public Boolean getRenderModalDesenquadradas() {
        return renderModalDesenquadradas;
    }

    /**
     * @param renderModalDesenquadradas seta o novo valor para o campo renderModalDesenquadradas
     */
    public void setRenderModalDesenquadradas(Boolean renderModalDesenquadradas) {
        this.renderModalDesenquadradas = renderModalDesenquadradas;
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
     * @return o valor do botaoAcionado
     */
    public Integer getBotaoAcionado() {
        return botaoAcionado;
    }

    /**
     * @param botaoAcionado seta o novo valor para o campo botaoAcionado
     */
    public void setBotaoAcionado(Integer botaoAcionado) {
        this.botaoAcionado = botaoAcionado;
    }

    /**
     * @return o valor do telaOrigem
     */
    public Integer getTelaOrigem() {
        return telaOrigem;
    }

    /**
     * @param telaOrigem seta o novo valor para o campo telaOrigem
     */
    public void setTelaOrigem(Integer telaOrigem) {
        this.telaOrigem = telaOrigem;
    }

}
