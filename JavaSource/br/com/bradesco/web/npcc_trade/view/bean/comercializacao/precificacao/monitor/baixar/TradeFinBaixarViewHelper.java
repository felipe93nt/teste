package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.baixar;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;


/**
 * 
  * Nome: TradeFinMonitBaixarViewHelper.java
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
  * Registro  de Manutenção: 31/12/2015
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class TradeFinBaixarViewHelper {
	
    private boolean renderModal = false;
    
    private List<SelectItem> comboMoedaItens = new ArrayList<SelectItem>();
    
    private List<SelectItem> comboMotivosPerdaItens = new ArrayList<SelectItem>();

    /**
     * @return o valor do renderModal
     */
    public boolean isRenderModal() {
        return renderModal;
    }

    /**
     * @param renderModal seta o novo valor para o campo renderModal
     */
    public void setRenderModal(boolean renderModal) {
        this.renderModal = renderModal;
    }

    /**
     * @return o valor do comboMoedaItens
     */
    public List<SelectItem> getComboMoedaItens() {
        return comboMoedaItens;
    }

    /**
     * @param comboMoedaItens seta o novo valor para o campo comboMoedaItens
     */
    public void setComboMoedaItens(List<SelectItem> comboMoedaItens) {
        this.comboMoedaItens = comboMoedaItens;
    }

    /**
     * @return o valor do comboMotivosPerdaItens
     */
    public List<SelectItem> getComboMotivosPerdaItens() {
        return comboMotivosPerdaItens;
    }

    /**
     * @param comboMotivosPerdaItens seta o novo valor para o campo comboMotivosPerdaItens
     */
    public void setComboMotivosPerdaItens(List<SelectItem> comboMotivosPerdaItens) {
        this.comboMotivosPerdaItens = comboMotivosPerdaItens;
    }
        
	
}
