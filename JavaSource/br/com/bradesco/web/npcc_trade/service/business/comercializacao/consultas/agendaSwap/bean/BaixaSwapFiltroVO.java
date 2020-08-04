package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap.bean;

public class BaixaSwapFiltroVO {
    
    /** NUMERO DO BOLETO **/
    private Long nbletonegoccmbio = 0L;

    /** NUMERO DO DESEMBOLSO **/
    private Integer ndsembcmbiotrade = 0;

    /** NUMERO DA PARCELA **/
    private Integer npceladsembtrade = 0;

    /** TIPO DA PARCELA (P - PRINCIPAL, J - JUROS) **/
    private String tpparcela = null;

    /**
     * @return o valor do nbletonegoccmbio
     */
    public Long getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Long nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    /**
     * @return o valor do ndsembcmbiotrade
     */
    public Integer getNdsembcmbiotrade() {
        return ndsembcmbiotrade;
    }

    /**
     * @param ndsembcmbiotrade seta o novo valor para o campo ndsembcmbiotrade
     */
    public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
        this.ndsembcmbiotrade = ndsembcmbiotrade;
    }

    /**
     * @return o valor do npceladsembtrade
     */
    public Integer getNpceladsembtrade() {
        return npceladsembtrade;
    }

    /**
     * @param npceladsembtrade seta o novo valor para o campo npceladsembtrade
     */
    public void setNpceladsembtrade(Integer npceladsembtrade) {
        this.npceladsembtrade = npceladsembtrade;
    }

    /**
     * @return o valor do tpparcela
     */
    public String getTpparcela() {
        return tpparcela;
    }

    /**
     * @param tpparcela seta o novo valor para o campo tpparcela
     */
    public void setTpparcela(String tpparcela) {
        this.tpparcela = tpparcela;
    }
    
}
