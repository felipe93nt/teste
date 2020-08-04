package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.divisaoInternacional;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;

public class ConsultaDivInternacViewHelper {

    private List<SelectItem> comboStatus = new ArrayList<SelectItem>();
    private List<SelectItem> comboTipoCotacao = new ArrayList<SelectItem>();
    private List<SelectItem> comboProduto = new ArrayList<SelectItem>();
    private CalendarioPeriodo periodoCotacao = new CalendarioPeriodo();
    

    /**
     * @return o valor do comboStatus
     */
    public List<SelectItem> getComboStatus() {
        return comboStatus;
    }

    /**
     * @param comboStatus seta o novo valor para o campo comboStatus
     */
    public void setComboStatus(List<SelectItem> comboStatus) {
        this.comboStatus = comboStatus;
    }

    /**
     * @return o valor do comboTipoCotacao
     */
    public List<SelectItem> getComboTipoCotacao() {
        return comboTipoCotacao;
    }

    /**
     * @param comboTipoCotacao seta o novo valor para o campo comboTipoCotacao
     */
    public void setComboTipoCotacao(List<SelectItem> comboTipoCotacao) {
        this.comboTipoCotacao = comboTipoCotacao;
    }

    /**
     * @return o valor do comboProduto
     */
    public List<SelectItem> getComboProduto() {
        return comboProduto;
    }

    /**
     * @param comboProduto seta o novo valor para o campo comboProduto
     */
    public void setComboProduto(List<SelectItem> comboProduto) {
        this.comboProduto = comboProduto;
    }

    /**
     * @return o valor do periodoCotacao
     */
    public CalendarioPeriodo getPeriodoCotacao() {
        return periodoCotacao;
    }

    /**
     * @param periodoCotacao seta o novo valor para o campo periodoCotacao
     */
    public void setPeriodoCotacao(CalendarioPeriodo periodoCotacao) {
        this.periodoCotacao = periodoCotacao;
    }
    
}
