package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;



/**
  * Nome: BeneficiarioAfiancadorVO.java
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
  * Registro  de Manutenção: 11/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class AfiancadorVO {
    /** COD CLIENTE **/
    private String cunicpssoadcmbio = null;
    /** PAIS **/
    private String ipaiscmbio = null;
    /** CIDADE **/
    private String iciddcmbio = null;
    /** ENDERECO **/
    private String logrdcmbio = null;
    /**
     * @return o valor do cunicpssoadcmbio
     */
    public String getCunicpssoadcmbio() {
        return cunicpssoadcmbio;
    }
    /**
     * @param cunicpssoadcmbio seta o novo valor para o campo cunicpssoadcmbio
     */
    public void setCunicpssoadcmbio(String cunicpssoadcmbio) {
        this.cunicpssoadcmbio = cunicpssoadcmbio;
    }
    /**
     * @return o valor do ipaiscmbio
     */
    public String getIpaiscmbio() {
        return ipaiscmbio;
    }
    /**
     * @param ipaiscmbio seta o novo valor para o campo ipaiscmbio
     */
    public void setIpaiscmbio(String ipaiscmbio) {
        this.ipaiscmbio = ipaiscmbio;
    }
    /**
     * @return o valor do iciddcmbio
     */
    public String getIciddcmbio() {
        return iciddcmbio;
    }
    /**
     * @param iciddcmbio seta o novo valor para o campo iciddcmbio
     */
    public void setIciddcmbio(String iciddcmbio) {
        this.iciddcmbio = iciddcmbio;
    }
    /**
     * @return o valor do logrdcmbio
     */
    public String getLogrdcmbio() {
        return logrdcmbio;
    }
    /**
     * @param logrdcmbio seta o novo valor para o campo logrdcmbio
     */
    public void setLogrdcmbio(String logrdcmbio) {
        this.logrdcmbio = logrdcmbio;
    }
    
    
    
}
