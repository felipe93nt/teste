package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import java.util.ArrayList;
import java.util.List;

public class CalcPrazoTotalOperLcVO {
    
    /* NPCCWX3E-DLIM-EMBRQ-CMBIO        = DATA DO EMBARQUE             */
    private String dlimembrqcmbio = null;

    /* NPCCWX3E-CPRZ-NEGOC-CMBIO        = INDICADOR DE PRAZO           */
    private String cprznegoccmbio = null;

    /* NPCCWX3E-TDIA-VALDD-CARTA        = PRAZO PARA CARTA             */
    private Integer tdiavalddcarta = 0;

    /* NPCCWX3E-TDIA-VALDD-LETRA        = PRAZO PARA LETRA             */
    private Integer tdiavalddletra = 0;

    /* NPCCWX3E-TDIA-PGTO-CARTA         = LISTA PRAZO DA PARCELA L/C   */
    private List<Integer> listaTdiapgtocarta = new ArrayList<Integer>();

    /**
     * @return o valor do dlimembrqcmbio
     */
    public String getDlimembrqcmbio() {
        return dlimembrqcmbio;
    }

    /**
     * @param dlimembrqcmbio seta o novo valor para o campo dlimembrqcmbio
     */
    public void setDlimembrqcmbio(String dlimembrqcmbio) {
        this.dlimembrqcmbio = dlimembrqcmbio;
    }

    /**
     * @return o valor do cprznegoccmbio
     */
    public String getCprznegoccmbio() {
        return cprznegoccmbio;
    }

    /**
     * @param cprznegoccmbio seta o novo valor para o campo cprznegoccmbio
     */
    public void setCprznegoccmbio(String cprznegoccmbio) {
        this.cprznegoccmbio = cprznegoccmbio;
    }

    /**
     * @return o valor do tdiavalddcarta
     */
    public Integer getTdiavalddcarta() {
        return tdiavalddcarta;
    }

    /**
     * @param tdiavalddcarta seta o novo valor para o campo tdiavalddcarta
     */
    public void setTdiavalddcarta(Integer tdiavalddcarta) {
        this.tdiavalddcarta = tdiavalddcarta;
    }

    /**
     * @return o valor do tdiavalddletra
     */
    public Integer getTdiavalddletra() {
        return tdiavalddletra;
    }

    /**
     * @param tdiavalddletra seta o novo valor para o campo tdiavalddletra
     */
    public void setTdiavalddletra(Integer tdiavalddletra) {
        this.tdiavalddletra = tdiavalddletra;
    }

    /**
     * @return o valor do listaTdiapgtocarta
     */
    public List<Integer> getListaTdiapgtocarta() {
        return listaTdiapgtocarta;
    }

    /**
     * @param listaTdiapgtocarta seta o novo valor para o campo listaTdiapgtocarta
     */
    public void setListaTdiapgtocarta(List<Integer> listaTdiapgtocarta) {
        this.listaTdiapgtocarta = listaTdiapgtocarta;
    }

}
