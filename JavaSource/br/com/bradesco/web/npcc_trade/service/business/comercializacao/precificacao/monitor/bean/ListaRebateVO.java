package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;

/**
  * Nome: ListaRebateVO.java
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
  * Registro  de Manutenção: 24/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class ListaRebateVO {

    private String rebate = null;

    /**
     * @return o valor do rebate
     */
    public String getRebate() {
        return rebate;
    }

    /**
     * @param rebate seta o novo valor para o campo rebate
     */
    public void setRebate(String rebate) {
        this.rebate = rebate;
    }
}
