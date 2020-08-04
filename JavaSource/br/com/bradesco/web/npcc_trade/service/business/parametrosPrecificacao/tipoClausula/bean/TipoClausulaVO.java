package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.bean;

import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;
/**
 * 
  * Nome: TipoClausulaVO.java
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
  * Registro  de Manutenção: 27/11/2015
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class TipoClausulaVO extends BaseVO{
	
	
	/** CODIGO IDENTIF. MODELO BOLETO */
     private Integer cmodcontrcmbio = null;

     
     /**  CODIGO IDENTIFI. TIPO DE CLAUSULA*/
     private Integer ctpoclauscmbio  = null;
  
     /**   NOME TIPO CLAUSULA  */
           
     private String itpoclauscmbio = null;

    /**
     * @return o valor do cmodcontrcmbio
     */
    public Integer getCmodcontrcmbio() {
        return cmodcontrcmbio;
    }

    /**
     * @param cmodcontrcmbio seta o novo valor para o campo cmodcontrcmbio
     */
    public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
        this.cmodcontrcmbio = cmodcontrcmbio;
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
