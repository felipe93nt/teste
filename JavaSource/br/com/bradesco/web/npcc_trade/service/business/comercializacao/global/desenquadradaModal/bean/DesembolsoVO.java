package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean;

/**
  * Nome: DesembolsoVO.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  Banco Bradescro - Sergio Costa Ferreira
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
*/
public class DesembolsoVO {

    /* SPREAD-DESEMB    PIC 9(004)V9(09). */
    private Double spreadDesemb = null;      

    /**
     * Construtor
     * 
     * @param 
     */
    public DesembolsoVO() {
        super();
    }

    /**
     * @return o valor do spred do desembolso
     */
    public Double getSpreadDesemb() {
        return spreadDesemb;
    }

    /**
     * @param spreadDesemb seta o novo valor para o campo spreadDesemb
     */
    public void setSpreadDesemb(Double spreadDesemb) {
        this.spreadDesemb = spreadDesemb;
    }
}
