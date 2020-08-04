/**
 *
 * Nome: TarifaVO.java
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


/**
 *
 * Nome: TarifaVO.java 
 * 
 * Propósito:
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
public class TarifaVO {
    
    /**
     * TOTAL DE TARIFA + DESPESA EM USD
     */
    private Integer totusdtrfadeps;
    
    /**
     * TOTAL DE TARIFA + DESPESA EM BRL
     */
    private Integer totbrltrfadeps;
    
    /**
     * IDENT. DE DESPESA OU TARIFA 1 = TARIFA | 2 = DESPESA
     */
    private Integer cindcddesptarf;
    
    /**
     * CONDICAO ECONOMICA TARIFA
     */
    private Integer ccondceconc;
    
    /**
     * NUMERO TARIFA BOLETO
     */
    private Integer ntarifbletocmbio;
    
    /**
     * TIPO DESPESA CAMBIO
     */
    private Integer ctpodespcmbio;
    
    /**
     * NUMERO DESPESA BOLETO CAMBIO
     */
    private Long ndespbletocmbio;
    
    /**
     * DESCRICAO DA TARIFA/DESPESA
     */
    private String itpodespcmbio;
    
    /**
     * CODIGO DA MOEDA
     */
    private Integer cindcdeconmmoeda;
    
    /**
     * VALOR DA TARIFA/DESPESA 
     */
    private String vdespbletocmbio;
    
    /**
     * TOTAL EM BRL
     */
    private String totbrldesptarf;
    
    /**
     * TOTAL EM USD
     */
    private String totusddesptarf;
    
    private String isglindcdfonte = null;

    private String descrdesptarif = null;

    /**
     * @return o valor do totusdtrfadeps
     */
    public Integer getTotusdtrfadeps() {
        return totusdtrfadeps;
    }

    /**
     * @param totusdtrfadeps seta o novo valor para o campo totusdtrfadeps
     */
    public void setTotusdtrfadeps(Integer totusdtrfadeps) {
        this.totusdtrfadeps = totusdtrfadeps;
    }

    /**
     * @return o valor do totbrltrfadeps
     */
    public Integer getTotbrltrfadeps() {
        return totbrltrfadeps;
    }

    /**
     * @param totbrltrfadeps seta o novo valor para o campo totbrltrfadeps
     */
    public void setTotbrltrfadeps(Integer totbrltrfadeps) {
        this.totbrltrfadeps = totbrltrfadeps;
    }

    /**
     * @return o valor do cindcddesptarf
     */
    public Integer getCindcddesptarf() {
        return cindcddesptarf;
    }

    /**
     * @param cindcddesptarf seta o novo valor para o campo cindcddesptarf
     */
    public void setCindcddesptarf(Integer cindcddesptarf) {
        this.cindcddesptarf = cindcddesptarf;
    }

    /**
     * @return o valor do ccondceconc
     */
    public Integer getCcondceconc() {
        return ccondceconc;
    }

    /**
     * @param ccondceconc seta o novo valor para o campo ccondceconc
     */
    public void setCcondceconc(Integer ccondceconc) {
        this.ccondceconc = ccondceconc;
    }

    /**
     * @return o valor do ntarifbletocmbio
     */
    public Integer getNtarifbletocmbio() {
        return ntarifbletocmbio;
    }

    /**
     * @param ntarifbletocmbio seta o novo valor para o campo ntarifbletocmbio
     */
    public void setNtarifbletocmbio(Integer ntarifbletocmbio) {
        this.ntarifbletocmbio = ntarifbletocmbio;
    }

    /**
     * @return o valor do ctpodespcmbio
     */
    public Integer getCtpodespcmbio() {
        return ctpodespcmbio;
    }

    /**
     * @param ctpodespcmbio seta o novo valor para o campo ctpodespcmbio
     */
    public void setCtpodespcmbio(Integer ctpodespcmbio) {
        this.ctpodespcmbio = ctpodespcmbio;
    }

    /**
     * @return o valor do ndespbletocmbio
     */
    public Long getNdespbletocmbio() {
        return ndespbletocmbio;
    }

    /**
     * @param ndespbletocmbio seta o novo valor para o campo ndespbletocmbio
     */
    public void setNdespbletocmbio(Long ndespbletocmbio) {
        this.ndespbletocmbio = ndespbletocmbio;
    }

    /**
     * @return o valor do itpodespcmbio
     */
    public String getItpodespcmbio() {
        return itpodespcmbio;
    }

    /**
     * @param itpodespcmbio seta o novo valor para o campo itpodespcmbio
     */
    public void setItpodespcmbio(String itpodespcmbio) {
        this.itpodespcmbio = itpodespcmbio;
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
     * @return o valor do vdespbletocmbio
     */
    public String getVdespbletocmbio() {
        return vdespbletocmbio;
    }

    /**
     * @param vdespbletocmbio seta o novo valor para o campo vdespbletocmbio
     */
    public void setVdespbletocmbio(String vdespbletocmbio) {
        this.vdespbletocmbio = vdespbletocmbio;
    }

    /**
     * @return o valor do totbrldesptarf
     */
    public String getTotbrldesptarf() {
        return totbrldesptarf;
    }

    /**
     * @param totbrldesptarf seta o novo valor para o campo totbrldesptarf
     */
    public void setTotbrldesptarf(String totbrldesptarf) {
        this.totbrldesptarf = totbrldesptarf;
    }

    /**
     * @return o valor do totusddesptarf
     */
    public String getTotusddesptarf() {
        return totusddesptarf;
    }

    /**
     * @param totusddesptarf seta o novo valor para o campo totusddesptarf
     */
    public void setTotusddesptarf(String totusddesptarf) {
        this.totusddesptarf = totusddesptarf;
    }

    /**
     * @return o valor do isglindcdfonte
     */
    public String getIsglindcdfonte() {
        return isglindcdfonte;
    }

    /**
     * @param isglindcdfonte seta o novo valor para o campo isglindcdfonte
     */
    public void setIsglindcdfonte(String isglindcdfonte) {
        this.isglindcdfonte = isglindcdfonte;
    }

    /**
     * @return o valor do descrdesptarif
     */
    public String getDescrdesptarif() {
        return descrdesptarif;
    }

    /**
     * @param descrdesptarif seta o novo valor para o campo descrdesptarif
     */
    public void setDescrdesptarif(String descrdesptarif) {
        this.descrdesptarif = descrdesptarif;
    }
}
