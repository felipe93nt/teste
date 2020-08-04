/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 11/11/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;

/**
 * Nome: ComboCidadeIntVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 11/11/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class ComboCidadeIntVO {

    /** CODIGO CIDADE - PIC 9(010) */
    private Long cmunintlcmbio = null;

    /** IMUN-INTL-CMBIO = NOME DA CIDADE - PIC X(040) */
    private String imunintlcmbio = null;

    /** IINGLS-INTL-CMBIO = NOME DA CIDADE EM INGLES - PIC X(040) */
    private String iinglsintlcmbio = null;

    /** CPAIS = CODIGO PAIS - PIC 9(003) */
    private Integer cpais = null;

    /** CD-PAIS = CODIGO DO PAIS BACEN - PIC X(010) */
    private String cdpais = null;

    /** NOME-PAIS = NOME DO PAIS - PIC X(060) */
    private String nomepais = null;

    /** SGL-PAIS-ISO - PIC X(002) */
    private String sglpaisiso = null;

    /**
     * @return o valor do cmunintlcmbio
     */
    public Long getCmunintlcmbio() {
        return cmunintlcmbio;
    }

    /**
     * @param cmunintlcmbio seta o novo valor para o campo cmunintlcmbio
     */
    public void setCmunintlcmbio(Long cmunintlcmbio) {
        this.cmunintlcmbio = cmunintlcmbio;
    }

    /**
     * @return o valor do imunintlcmbio
     */
    public String getImunintlcmbio() {
        return imunintlcmbio;
    }

    /**
     * @param imunintlcmbio seta o novo valor para o campo imunintlcmbio
     */
    public void setImunintlcmbio(String imunintlcmbio) {
        this.imunintlcmbio = imunintlcmbio;
    }

    /**
     * @return o valor do iinglsintlcmbio
     */
    public String getIinglsintlcmbio() {
        return iinglsintlcmbio;
    }

    /**
     * @param iinglsintlcmbio seta o novo valor para o campo iinglsintlcmbio
     */
    public void setIinglsintlcmbio(String iinglsintlcmbio) {
        this.iinglsintlcmbio = iinglsintlcmbio;
    }

    /**
     * @return o valor do cpais
     */
    public Integer getCpais() {
        return cpais;
    }

    /**
     * @param cpais seta o novo valor para o campo cpais
     */
    public void setCpais(Integer cpais) {
        this.cpais = cpais;
    }

    /**
     * @return o valor do cdpais
     */
    public String getCdpais() {
        return cdpais;
    }

    /**
     * @param cdpais seta o novo valor para o campo cdpais
     */
    public void setCdpais(String cdpais) {
        this.cdpais = cdpais;
    }

    /**
     * @return o valor do nomepais
     */
    public String getNomepais() {
        return nomepais;
    }

    /**
     * @param nomepais seta o novo valor para o campo nomepais
     */
    public void setNomepais(String nomepais) {
        this.nomepais = nomepais;
    }

    /**
     * @return o valor do sglpaisiso
     */
    public String getSglpaisiso() {
        return sglpaisiso;
    }

    /**
     * @param sglpaisiso seta o novo valor para o campo sglpaisiso
     */
    public void setSglpaisiso(String sglpaisiso) {
        this.sglpaisiso = sglpaisiso;
    }

}
