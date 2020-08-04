package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;


/**
 * Nome: ListaParcelasDesembolsoVO.java
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
 * Registro  de Manutenção: 10/06/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class ListaParcelasDesembolsoVO {

    /** NUMERO DA PARCELA **/
    private Integer npceladsembcarta = 0;

    /** VALOR DA PARCELA **/
    private String vpcelacreditprevt = null;

    /** PERCENTUAL DA PARCELA ***/
    private String vpcelacartaprevt = null;

    /** CODIGO PRAZO **/
    private Integer cprzpcelacarta = 0;

    /** DESCRIçãO DO PRAZO **/
    private String nprzpcelacarta = null;

    /** QUANTIDADE DE DIAS PGTO **/
    private Integer tdiapgtocarta = 0;

    /**
     * @return o valor do npceladsembcarta
     */
    public Integer getNpceladsembcarta() {
        return npceladsembcarta;
    }

    /**
     * @param npceladsembcarta seta o novo valor para o campo npceladsembcarta
     */
    public void setNpceladsembcarta(Integer npceladsembcarta) {
        this.npceladsembcarta = npceladsembcarta;
    }

    /**
     * @return o valor do vpcelacreditprevt
     */
    public String getVpcelacreditprevt() {
        return vpcelacreditprevt;
    }

    /**
     * @param vpcelacreditprevt seta o novo valor para o campo vpcelacreditprevt
     */
    public void setVpcelacreditprevt(String vpcelacreditprevt) {
        this.vpcelacreditprevt = vpcelacreditprevt;
    }

    /**
     * @return o valor do vpcelacartaprevt
     */
    public String getVpcelacartaprevt() {
        return vpcelacartaprevt;
    }

    /**
     * @param vpcelacartaprevt seta o novo valor para o campo vpcelacartaprevt
     */
    public void setVpcelacartaprevt(String vpcelacartaprevt) {
        this.vpcelacartaprevt = vpcelacartaprevt;
    }

    /**
     * @return o valor do cprzpcelacarta
     */
    public Integer getCprzpcelacarta() {
        return cprzpcelacarta;
    }

    /**
     * @param cprzpcelacarta seta o novo valor para o campo cprzpcelacarta
     */
    public void setCprzpcelacarta(Integer cprzpcelacarta) {
        this.cprzpcelacarta = cprzpcelacarta;
    }

    /**
     * @return o valor do nprzpcelacarta
     */
    public String getNprzpcelacarta() {
        return nprzpcelacarta;
    }

    /**
     * @param nprzpcelacarta seta o novo valor para o campo nprzpcelacarta
     */
    public void setNprzpcelacarta(String nprzpcelacarta) {
        this.nprzpcelacarta = nprzpcelacarta;
    }

    /**
     * @return o valor do tdiapgtocarta
     */
    public Integer getTdiapgtocarta() {
        return tdiapgtocarta;
    }

    /**
     * @param tdiapgtocarta seta o novo valor para o campo tdiapgtocarta
     */
    public void setTdiapgtocarta(Integer tdiapgtocarta) {
        this.tdiapgtocarta = tdiapgtocarta;
    }
    
    

}
