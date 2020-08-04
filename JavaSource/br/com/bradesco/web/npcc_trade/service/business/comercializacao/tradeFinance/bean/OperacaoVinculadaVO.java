/**
 *
 * Nome: OperacaoVinculadaVO.java
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

import br.com.bradesco.web.aq.view.components.UICalendarPeriod.CalendarPeriodDataType;

/**
 *
 * Nome: OperacaoVinculadaVO.java Propósito:
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
public class OperacaoVinculadaVO {
    
    /**
     * numero da operacao vinculada
     */
    private long nbletonegocvnclo; // usado na tela de consulta
    private Long numoperacao = 0L; // usado na tela de inclusao
    
    /**
     * codigo do produto
     */
    private Integer cprodtservc;
    
    /**
     * descricao do produto
     */
    private String iprodtservc;
    
    /**
     * codigo da moeda
     */
    private Integer cindcdeconmmoeda;
    
    /**
     * simbolo da moeda
     */
    private String iindcdeconmmoeda;
    
    /**
     * valor moeda estrangeira
     */
    private String vnegocmoedaestr; // usado na tela de consulta
    private String vnegocmoedaestrg = null; // usado na tela de inclusão
    private String valorMoeda = null; // usado na tela de inclusão
    
    
    
    
    /**** Campos da Entrada  *****/
    
    private Long cunicclicmbio = 0L;

    private CalendarPeriodDataType dataPesquisa = null;
    private String datainio = null;
    private String datafim = null;

    /**** Campos da Saída  *****/

    private Long nbletonegoccmbio = 0L;

    private String dvalddnegoccmbio = null;

    private String dataVencimento = null;
    
    


    /**
     * @return o valor do nbletonegocvnclo
     */
    public long getNbletonegocvnclo() {
        return nbletonegocvnclo;
    }

    /**
     * @param nbletonegocvnclo seta o novo valor para o campo nbletonegocvnclo
     */
    public void setNbletonegocvnclo(long nbletonegocvnclo) {
        this.nbletonegocvnclo = nbletonegocvnclo;
    }

    /**
     * @return o valor do cprodtservc
     */
    public Integer getCprodtservc() {
        return cprodtservc;
    }

    /**
     * @param cprodtservc seta o novo valor para o campo cprodtservc
     */
    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }

    /**
     * @return o valor do iprodtservc
     */
    public String getIprodtservc() {
        return iprodtservc;
    }

    /**
     * @param iprodtservc seta o novo valor para o campo iprodtservc
     */
    public void setIprodtservc(String iprodtservc) {
        this.iprodtservc = iprodtservc;
    }

    /**
     * @return o valor do cindcdeconmmoeda
     */
    public Integer getCindcdeconmmoeda() {
        return cindcdeconmmoeda;
    }

    /**
     * @param cindcdeconmmoeda seta o novo valor para o campo cindcdeconmmoeda
     */
    public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
        this.cindcdeconmmoeda = cindcdeconmmoeda;
    }

    /**
     * @return o valor do iindcdeconmmoeda
     */
    public String getIindcdeconmmoeda() {
        return iindcdeconmmoeda;
    }

    /**
     * @param iindcdeconmmoeda seta o novo valor para o campo iindcdeconmmoeda
     */
    public void setIindcdeconmmoeda(String iindcdeconmmoeda) {
        this.iindcdeconmmoeda = iindcdeconmmoeda;
    }

    /**
     * @return o valor do vnegocmoedaestr
     */
    public String getVnegocmoedaestr() {
        return vnegocmoedaestr;
    }

    /**
     * @param vnegocmoedaestr seta o novo valor para o campo vnegocmoedaestr
     */
    public void setVnegocmoedaestr(String vnegocmoedaestr) {
        this.vnegocmoedaestr = vnegocmoedaestr;
    }

    /**
     * @return o valor do cunicclicmbio
     */
    public Long getCunicclicmbio() {
        return cunicclicmbio;
    }

    /**
     * @param cunicclicmbio seta o novo valor para o campo cunicclicmbio
     */
    public void setCunicclicmbio(Long cunicclicmbio) {
        this.cunicclicmbio = cunicclicmbio;
    }

    /**
     * @return o valor do dataPesquisa
     */
    public CalendarPeriodDataType getDataPesquisa() {
        return dataPesquisa;
    }

    /**
     * @param dataPesquisa seta o novo valor para o campo dataPesquisa
     */
    public void setDataPesquisa(CalendarPeriodDataType dataPesquisa) {
        this.dataPesquisa = dataPesquisa;
    }

    /**
     * @return o valor do datainio
     */
    public String getDatainio() {
        return datainio;
    }

    /**
     * @param datainio seta o novo valor para o campo datainio
     */
    public void setDatainio(String datainio) {
        this.datainio = datainio;
    }

    /**
     * @return o valor do datafim
     */
    public String getDatafim() {
        return datafim;
    }

    /**
     * @param datafim seta o novo valor para o campo datafim
     */
    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }

    /**
     * @return o valor do numoperacao
     */
    public Long getNumoperacao() {
        return numoperacao;
    }

    /**
     * @param numoperacao seta o novo valor para o campo numoperacao
     */
    public void setNumoperacao(Long numoperacao) {
        this.numoperacao = numoperacao;
    }

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
     * @return o valor do dvalddnegoccmbio
     */
    public String getDvalddnegoccmbio() {
        return dvalddnegoccmbio;
    }

    /**
     * @param dvalddnegoccmbio seta o novo valor para o campo dvalddnegoccmbio
     */
    public void setDvalddnegoccmbio(String dvalddnegoccmbio) {
        this.dvalddnegoccmbio = dvalddnegoccmbio;
    }

    /**
     * @return o valor do dataVencimento
     */
    public String getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento seta o novo valor para o campo dataVencimento
     */
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return o valor do vnegocmoedaestrg
     */
    public String getVnegocmoedaestrg() {
        return vnegocmoedaestrg;
    }

    /**
     * @param vnegocmoedaestrg seta o novo valor para o campo vnegocmoedaestrg
     */
    public void setVnegocmoedaestrg(String vnegocmoedaestrg) {
        this.vnegocmoedaestrg = vnegocmoedaestrg;
    }

    /**
     * @return o valor do valorMoeda
     */
    public String getValorMoeda() {
        return valorMoeda;
    }

    /**
     * @param valorMoeda seta o novo valor para o campo valorMoeda
     */
    public void setValorMoeda(String valorMoeda) {
        this.valorMoeda = valorMoeda;
    }

}
