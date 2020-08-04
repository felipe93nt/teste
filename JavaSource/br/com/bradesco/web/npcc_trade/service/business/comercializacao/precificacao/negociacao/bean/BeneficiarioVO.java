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
public class BeneficiarioVO {
    /** COD CLIENTE **/
    private String cunicpssoadcmbio = null;
    
    /** CODIGO DO BENEFICIARIO UTILIZADO NO INCLUIR COMPL GARANTIA **/
    private Long cunicpssoacmbiob = 0L;

    /** CODIGO DO AFIANCADO UTILIZADO NO INCLUIR COMPL GARANTIA**/
    private Long cunicpssoacmbioa = 0L;
   
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
    /**
     * @return o valor do cunicpssoacmbiob
     */
    public Long getCunicpssoacmbiob() {
        return cunicpssoacmbiob;
    }
    /**
     * @param cunicpssoacmbiob seta o novo valor para o campo cunicpssoacmbiob
     */
    public void setCunicpssoacmbiob(Long cunicpssoacmbiob) {
        this.cunicpssoacmbiob = cunicpssoacmbiob;
    }
    /**
     * @return o valor do cunicpssoacmbioa
     */
    public Long getCunicpssoacmbioa() {
        return cunicpssoacmbioa;
    }
    /**
     * @param cunicpssoacmbioa seta o novo valor para o campo cunicpssoacmbioa
     */
    public void setCunicpssoacmbioa(Long cunicpssoacmbioa) {
        this.cunicpssoacmbioa = cunicpssoacmbioa;
    }
    
}
