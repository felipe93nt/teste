package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;

import java.io.Serializable;

/**
 * 
 * Nome: ComboClasulaVO.java
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
 *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class ComboClausulaVO implements Serializable{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -132231L;
    
    /**
     * CODIGO IDENTIFI. TIPO CLAUSULA
     */
    private Integer ctpoclauscmbio = null;
    
    /**
     * CODIGO IDENTIFICADOR DA CLAUSULA
     */
    private Integer cclauscontrcmbio = null;
    
    /**
     * DESCRICAO CLAUSULA
     */
    private String rclauscontrcmbio = null;
    
    private String itpoclauscmbio = null;
    
    /**
     * 
         * Construtor
         * 
         * @param
     */
    public ComboClausulaVO(){
        super();
    }

    /**
     * @return o valor do ctpoclauscmbio
     */
    public Integer getCtpoclauscmbio() {
        return ctpoclauscmbio;
    }

    /**
     * @param ctpoclauscmbio seta o novo valor para o campo ctpoclauscmbio
     */
    public void setCtpoclauscmbio(Integer ctpoclauscmbio) {
        this.ctpoclauscmbio = ctpoclauscmbio;
    }

    /**
     * @return o valor do cclauscontrcmbio
     */
    public Integer getCclauscontrcmbio() {
        return cclauscontrcmbio;
    }

    /**
     * @param cclauscontrcmbio seta o novo valor para o campo cclauscontrcmbio
     */
    public void setCclauscontrcmbio(Integer cclauscontrcmbio) {
        this.cclauscontrcmbio = cclauscontrcmbio;
    }

    /**
     * @return o valor do rclauscontrcmbio
     */
    public String getRclauscontrcmbio() {
        return rclauscontrcmbio;
    }

    /**
     * @param rclauscontrcmbio seta o novo valor para o campo rclauscontrcmbio
     */
    public void setRclauscontrcmbio(String rclauscontrcmbio) {
        this.rclauscontrcmbio = rclauscontrcmbio;
    }

    /**
     * @return o valor do itpoclauscmbio
     */
    public String getItpoclauscmbio() {
        return itpoclauscmbio;
    }

    /**
     * @param itpoclauscmbio seta o novo valor para o campo itpoclauscmbio
     */
    public void setItpoclauscmbio(String itpoclauscmbio) {
        this.itpoclauscmbio = itpoclauscmbio;
    }

}
