package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;

import java.io.Serializable;

/**
 * 
 * 
 * Nome: ComboTipoClausulaVO.java
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
 *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public class ComboTipoClausulaVO implements Serializable{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -784468677938776379L;

    /** NOME TIPO CLAUSULA */
    private String itpoclauscmbio = null;
    
    
    /**  CODIGO IDENTIFI. TIPO DE CLAUSULA*/
    private Integer ctpoclauscmbio  = null;
    
    /**
     * 
         * Construtor
         * 
         * @param
     */
    public ComboTipoClausulaVO() {

        super();

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

}
