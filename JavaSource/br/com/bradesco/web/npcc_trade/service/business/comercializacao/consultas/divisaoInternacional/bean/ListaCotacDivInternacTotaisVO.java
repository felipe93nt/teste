package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean;

public class ListaCotacDivInternacTotaisVO {

    private String isglindcdeconm = null;

    private String vnegocmoedatot = null;

    /**
     * @return o valor do isglindcdeconm
     */
    public String getIsglindcdeconm() {
        return isglindcdeconm;
    }

    /**
     * @param isglindcdeconm seta o novo valor para o campo isglindcdeconm
     */
    public void setIsglindcdeconm(String isglindcdeconm) {
        this.isglindcdeconm = isglindcdeconm;
    }

    /**
     * @return o valor do vnegocmoedatot
     */
    public String getVnegocmoedatot() {
        return vnegocmoedatot;
    }

    /**
     * @param vnegocmoedatot seta o novo valor para o campo vnegocmoedatot
     */
    public void setVnegocmoedatot(String vnegocmoedatot) {
        this.vnegocmoedatot = vnegocmoedatot;
    }
        
}
