/**
 * Nome: br.com.bradesco.web.npcc_garantias.view.bean.global.desenquadradas
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 12/05/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.desenquadradaModal;

/**
 * Nome: DesenquadradasViewHelper.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ - Francinaldo Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 12/05/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
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
