package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.perda;

/**
  * Nome: TradeFinMonitPerdaViewHelper.java
  * 
  * Prop�sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 16/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
*/
public class TradeFinMonitPerdaViewHelper {
	
	private Boolean renderModal = Boolean.FALSE;
	private Boolean renderFechar = Boolean.FALSE;
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
     * @return o valor do renderFechar
     */
    public Boolean getRenderFechar() {
        return renderFechar;
    }
    /**
     * @param renderFechar seta o novo valor para o campo renderFechar
     */
    public void setRenderFechar(Boolean renderFechar) {
        this.renderFechar = renderFechar;
    }

	
}
