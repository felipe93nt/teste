/**
*
* Nome: ComissaoParcelaVO.java
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
* Nome: ComissaoParcelaVO.java
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
*  - Autor: BRQ
*  - Responsavel: Equipe Web
*  _ Ajuste para deixar no padrão hexavision.
*/
public class ComissaoParcelaVO {

    /**
     * NUMERO DA BOLETO NEGOCIACAO
     */
    private Integer nbletonegoccmbio;
    
    /**
     * NUMERO DA COMISSAO INTERNA
     */
    private Integer ncomisintrntrade;
    
    /**
     * NUMERO DA PARCELA INTERNA
     */
    private Integer npcelacomisintrn;
    
    /**
     * NUMERO DA PARCELA EXTERNA
     */
    private Integer npcelacomisexter = 0;
    
    /**
     * VENCIMENTO DA PARCELA
     */
    private String  dvctopcelatrade;
    
    /**
     * VALOR DA PARCELA
     */
    private String vpcelacomiscmbio;
    
    /**
     * PRAZO DA PARCELA
     */
    private Integer prazoparcela;
    
    /**
     * NPCCWYLE - Book de inclusão/alteração
     */
    private String vcustofincrcmbio = null;

    /**
     * @return o valor do nbletonegoccmbio
     */
    public Integer getNbletonegoccmbio() {
        return nbletonegoccmbio;
    }

    /**
     * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
     */
    public void setNbletonegoccmbio(Integer nbletonegoccmbio) {
        this.nbletonegoccmbio = nbletonegoccmbio;
    }

    /**
     * @return o valor do ncomisintrntrade
     */
    public Integer getNcomisintrntrade() {
        return ncomisintrntrade;
    }

    /**
     * @param ncomisintrntrade seta o novo valor para o campo ncomisintrntrade
     */
    public void setNcomisintrntrade(Integer ncomisintrntrade) {
        this.ncomisintrntrade = ncomisintrntrade;
    }

    /**
     * @return o valor do npcelacomisintrn
     */
    public Integer getNpcelacomisintrn() {
        return npcelacomisintrn;
    }

    /**
     * @param npcelacomisintrn seta o novo valor para o campo npcelacomisintrn
     */
    public void setNpcelacomisintrn(Integer npcelacomisintrn) {
        this.npcelacomisintrn = npcelacomisintrn;
    }

    /**
     * @return o valor do dvctopcelatrade
     */
    public String getDvctopcelatrade() {
        return dvctopcelatrade;
    }

    /**
     * @param dvctopcelatrade seta o novo valor para o campo dvctopcelatrade
     */
    public void setDvctopcelatrade(String dvctopcelatrade) {
        this.dvctopcelatrade = dvctopcelatrade;
    }

    /**
     * @return o valor do vpcelacomiscmbio
     */
    public String getVpcelacomiscmbio() {
        return vpcelacomiscmbio;
    }

    /**
     * @param vpcelacomiscmbio seta o novo valor para o campo vpcelacomiscmbio
     */
    public void setVpcelacomiscmbio(String vpcelacomiscmbio) {
        this.vpcelacomiscmbio = vpcelacomiscmbio;
    }

    /**
     * @return o valor do prazoparcela
     */
    public Integer getPrazoparcela() {
        return prazoparcela;
    }

    /**
     * @param prazoparcela seta o novo valor para o campo prazoparcela
     */
    public void setPrazoparcela(Integer prazoparcela) {
        this.prazoparcela = prazoparcela;
    }

    /**
     * @return o valor do vcustofincrcmbio
     */
    public String getVcustofincrcmbio() {
        return vcustofincrcmbio;
    }

    /**
     * @param vcustofincrcmbio seta o novo valor para o campo vcustofincrcmbio
     */
    public void setVcustofincrcmbio(String vcustofincrcmbio) {
        this.vcustofincrcmbio = vcustofincrcmbio;
    }

    /**
     * @return o valor do npcelacomisexter
     */
    public Integer getNpcelacomisexter() {
        return npcelacomisexter;
    }

    /**
     * @param npcelacomisexter seta o novo valor para o campo npcelacomisexter
     */
    public void setNpcelacomisexter(Integer npcelacomisexter) {
        this.npcelacomisexter = npcelacomisexter;
    } 

}
