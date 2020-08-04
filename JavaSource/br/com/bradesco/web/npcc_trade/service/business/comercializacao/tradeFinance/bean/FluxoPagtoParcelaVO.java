/**
 *
 * Nome: FluxoPagtoParcelaVO.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 25/04/2016
 *   - Autor: BRQ
 *   - Responsavel: Equipe Web
 *   _ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.tradeFinance.bean;

import java.util.Date;

/**
 *
 * Nome: FluxoPagtoParcelaVO.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ <BR>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 25/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class FluxoPagtoParcelaVO implements Comparable<FluxoPagtoParcelaVO> {

    /**
     * TIPO JUROS
     * 
     * NPCCWYKE-REGISTRO.NPCCWYKE-LST-LIS.NPCCWYKE-TIPO-PCELA-TRADE
     */
    private String tipojuros = null;

    /**
     * NUMERO DA PARCELA
     */
    private Integer npceladsembtrade;

    /**
     * DATA DE VENCIMENTO DA PARCELA
     */
    private String dvctopcelatrade;
    private Date venctoFluxDate = null;

    /**
     * VALOR DA PARCELA
     */
    private String vpcelamesatrade;

    /**
     * PRAZO
     */
    private Integer tdianegocpcela;

    @Override
    public int compareTo(FluxoPagtoParcelaVO next) {
        Date dateComparer;
        Date dateActual;
        final int EQUAL = 0;

        int firstComparison = 0;
        int secondComparison = getTipojuros().compareTo(next.getTipojuros());
        int finalComparison = 0;

        dateActual = getVenctoFluxDate();
        dateComparer = next.getVenctoFluxDate();

        firstComparison = 0;
        if (dateActual.after(dateComparer)) {
            firstComparison = 1;
        }
        if (dateActual.before(dateComparer)) {
            firstComparison = -1;
        }
        // Segue a ordem de prioridade e retorna o resultado da comparação
        if (firstComparison != EQUAL) {
            finalComparison = firstComparison;
        } else {
            finalComparison = secondComparison * -1;
        }

        return finalComparison;
    }

    /**
     * @return o valor do npceladsembtrade
     */
    public Integer getNpceladsembtrade() {
        return npceladsembtrade;
    }

    /**
     * @param npceladsembtrade
     *            seta o novo valor para o campo npceladsembtrade
     */
    public void setNpceladsembtrade(Integer npceladsembtrade) {
        this.npceladsembtrade = npceladsembtrade;
    }

    /**
     * @return o valor do dvctopcelatrade
     */
    public String getDvctopcelatrade() {
        return dvctopcelatrade;
    }

    /**
     * @param dvctopcelatrade
     *            seta o novo valor para o campo dvctopcelatrade
     */
    public void setDvctopcelatrade(String dvctopcelatrade) {
        this.dvctopcelatrade = dvctopcelatrade;
    }

    /**
     * @return o valor do venctoFluxDate
     */
    public Date getVenctoFluxDate() {
        return venctoFluxDate;
    }

    /**
     * @param venctoFluxDate
     *            seta o novo valor para o campo venctoFluxDate
     */
    public void setVenctoFluxDate(Date venctoFluxDate) {
        this.venctoFluxDate = venctoFluxDate;
    }

    /**
     * @return o valor do vpcelamesatrade
     */
    public String getVpcelamesatrade() {
        return vpcelamesatrade;
    }

    /**
     * @param vpcelamesatrade
     *            seta o novo valor para o campo vpcelamesatrade
     */
    public void setVpcelamesatrade(String vpcelamesatrade) {
        this.vpcelamesatrade = vpcelamesatrade;
    }

    /**
     * @return o valor do tdianegocpcela
     */
    public Integer getTdianegocpcela() {
        return tdianegocpcela;
    }

    /**
     * @param tdianegocpcela
     *            seta o novo valor para o campo tdianegocpcela
     */
    public void setTdianegocpcela(Integer tdianegocpcela) {
        this.tdianegocpcela = tdianegocpcela;
    }

    /**
     * @return o valor do tipojuros
     */
    public String getTipojuros() {
        return tipojuros;
    }

    /**
     * @param tipojuros
     *            seta o novo valor para o campo tipojuros
     */
    public void setTipojuros(String tipojuros) {
        this.tipojuros = tipojuros;
    }

}
