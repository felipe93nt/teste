package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean;

/**
  * Nome: DesenquadramentoPagamentoAntecipadoVO.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ - Francinaldo
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 20/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class DesenquadramentoPagamentoAntecipadoVO {

    /* DESC-PGTO     PIC  X(020). */
    private String descpgto = null;

    /* DPREVT-DSEMB  PIC  X(010). */
    private String dprevtdsemb = null;

    /* DPREVT-EMBRQ  PIC  X(010). */
    private String dprevtembrq = null;
    
    /**
     * Construtor
     * 
     * @param 
     */
    public DesenquadramentoPagamentoAntecipadoVO() {
        super();
    }

    /**
     * @return o valor do descpgto
     */
    public String getDescpgto() {
        return descpgto;
    }

    /**
     * @param descpgto seta o novo valor para o campo descpgto
     */
    public void setDescpgto(String descpgto) {
        this.descpgto = descpgto;
    }

    /**
     * @return o valor do dprevtdsemb
     */
    public String getDprevtdsemb() {
        return dprevtdsemb;
    }

    /**
     * @param dprevtdsemb seta o novo valor para o campo dprevtdsemb
     */
    public void setDprevtdsemb(String dprevtdsemb) {
        this.dprevtdsemb = dprevtdsemb;
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
}
