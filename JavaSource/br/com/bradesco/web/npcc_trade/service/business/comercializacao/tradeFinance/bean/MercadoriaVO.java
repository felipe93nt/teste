/**
 *
 * Nome: MercadoriaVO.java
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
 * Nome: MercadoriaVO.java Propósito:
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
public class MercadoriaVO {
    
    private Integer ndsembcmbiotrade = 0;
    
    /**
     * NUMERO DA PARCELA MERCADORIA
     */
    private Integer nmcadocmbiotrade;
    
    /**
     * CODIGO DA MERCADORIA
     */
    private Integer cmcadoopercmbio;
    
    /**
     * DESCRICAO DA MERCADORIA
     */
    private String rmcadoopercmbio; 
    
    /** 
     * CODIGO DO PAIS DE ORIGEM
     */
    private Integer cpais;   
    
    /**
     * NOME DO PAIS DE ORIGEM
     */
    private String ipais;   
    
    /**
     * CODIGO DO BENEFICIARIO
     */
    private Long cunicpssoamcado; 
    
    /**
     * NOME DO BENEFICIARIO
     */
    private String iunicpssoamcado;
    
    /**
     * CODIGO DO PAIS DO BENEFICIARIO
     */
    private Integer cpaisbnefc;      
    
    /**
     * NOME DO PAIS DO BENEFICIARIO
     */
    private String ipaisbnefc;    
    
    /**
     * PREVISAO DE EMBARQUE
     */
    private String dprevtembrq;
    
    /**
     * DATA INICIO EMBARQUE
     */
    private String dprevtinicembrq;
    
    /**
     * DATA FIM EMBARQUE
     */
    private String dprevtfimembrq;
    
    /**
     * CODIGO PAIS EMBARQUE
     */
    private Integer cpaisembrq;
    
    /**
     * NOME PAIS EMBARQUE
     */
    private String ipaisembrq;
    
    /**
     * NUMERO DESEMBOLSO 
     */
    private Integer npceladsembcarta;
    
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
     * @return o valor do nmcadocmbiotrade
     */
    public Integer getNmcadocmbiotrade() {
        return nmcadocmbiotrade;
    }

    /**
     * @param nmcadocmbiotrade seta o novo valor para o campo nmcadocmbiotrade
     */
    public void setNmcadocmbiotrade(Integer nmcadocmbiotrade) {
        this.nmcadocmbiotrade = nmcadocmbiotrade;
    }

    /**
     * @return o valor do cmcadoopercmbio
     */
    public Integer getCmcadoopercmbio() {
        return cmcadoopercmbio;
    }

    /**
     * @param cmcadoopercmbio seta o novo valor para o campo cmcadoopercmbio
     */
    public void setCmcadoopercmbio(Integer cmcadoopercmbio) {
        this.cmcadoopercmbio = cmcadoopercmbio;
    }

    /**
     * @return o valor do rmcadoopercmbio
     */
    public String getRmcadoopercmbio() {
        return rmcadoopercmbio;
    }

    /**
     * @param rmcadoopercmbio seta o novo valor para o campo rmcadoopercmbio
     */
    public void setRmcadoopercmbio(String rmcadoopercmbio) {
        this.rmcadoopercmbio = rmcadoopercmbio;
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
     * @return o valor do ipais
     */
    public String getIpais() {
        return ipais;
    }

    /**
     * @param ipais seta o novo valor para o campo ipais
     */
    public void setIpais(String ipais) {
        this.ipais = ipais;
    }

    /**
     * @return o valor do cunicpssoamcado
     */
    public Long getCunicpssoamcado() {
        return cunicpssoamcado;
    }

    /**
     * @param cunicpssoamcado seta o novo valor para o campo cunicpssoamcado
     */
    public void setCunicpssoamcado(Long cunicpssoamcado) {
        this.cunicpssoamcado = cunicpssoamcado;
    }

    /**
     * @return o valor do iunicpssoamcado
     */
    public String getIunicpssoamcado() {
        return iunicpssoamcado;
    }

    /**
     * @param iunicpssoamcado seta o novo valor para o campo iunicpssoamcado
     */
    public void setIunicpssoamcado(String iunicpssoamcado) {
        this.iunicpssoamcado = iunicpssoamcado;
    }

    /**
     * @return o valor do cpaisbnefc
     */
    public Integer getCpaisbnefc() {
        return cpaisbnefc;
    }

    /**
     * @param cpaisbnefc seta o novo valor para o campo cpaisbnefc
     */
    public void setCpaisbnefc(Integer cpaisbnefc) {
        this.cpaisbnefc = cpaisbnefc;
    }

    /**
     * @return o valor do ipaisbnefc
     */
    public String getIpaisbnefc() {
        return ipaisbnefc;
    }

    /**
     * @param ipaisbnefc seta o novo valor para o campo ipaisbnefc
     */
    public void setIpaisbnefc(String ipaisbnefc) {
        this.ipaisbnefc = ipaisbnefc;
    }

    /**
     * @return o valor do dprevtembrq
     */
    public String getDprevtembrq() {
        return dprevtembrq;
    }

    /**
     * @param dprevtembrq seta o novo valor para o campo dprevtembrq
     */
    public void setDprevtembrq(String dprevtembrq) {
        this.dprevtembrq = dprevtembrq;
    }

    /**
     * @return o valor do dprevtinicembrq
     */
    public String getDprevtinicembrq() {
        return dprevtinicembrq;
    }

    /**
     * @param dprevtinicembrq seta o novo valor para o campo dprevtinicembrq
     */
    public void setDprevtinicembrq(String dprevtinicembrq) {
        this.dprevtinicembrq = dprevtinicembrq;
    }

    /**
     * @return o valor do dprevtfimembrq
     */
    public String getDprevtfimembrq() {
        return dprevtfimembrq;
    }

    /**
     * @param dprevtfimembrq seta o novo valor para o campo dprevtfimembrq
     */
    public void setDprevtfimembrq(String dprevtfimembrq) {
        this.dprevtfimembrq = dprevtfimembrq;
    }

    /**
     * @return o valor do cpaisembrq
     */
    public Integer getCpaisembrq() {
        return cpaisembrq;
    }

    /**
     * @param cpaisembrq seta o novo valor para o campo cpaisembrq
     */
    public void setCpaisembrq(Integer cpaisembrq) {
        this.cpaisembrq = cpaisembrq;
    }

    /**
     * @return o valor do ipaisembrq
     */
    public String getIpaisembrq() {
        return ipaisembrq;
    }

    /**
     * @param ipaisembrq seta o novo valor para o campo ipaisembrq
     */
    public void setIpaisembrq(String ipaisembrq) {
        this.ipaisembrq = ipaisembrq;
    }

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

    
}
