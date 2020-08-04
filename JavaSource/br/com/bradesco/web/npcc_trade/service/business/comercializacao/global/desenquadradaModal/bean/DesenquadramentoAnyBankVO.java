package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean;

/**
  * Nome: DesenquadramentoAnyBankVO.java
  * 
  * Prop�sito: <p> </p>
  *
  * @author :  BRQ - Francinaldo
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 20/05/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
*/
public class DesenquadramentoAnyBankVO {

    /* DESC-ANY      PIC  X(020). */
    private String descany = null;      

    /* CONDICAO      PIC  X(005). */
    private String condicao = null;
    
    /**
     * Construtor
     * 
     * @param 
     */
    public DesenquadramentoAnyBankVO() {
        super();
    }

    /**
     * @return o valor do descany
     */
    public String getDescany() {
        return descany;
    }

    /**
     * @param descany seta o novo valor para o campo descany
     */
    public void setDescany(String descany) {
        this.descany = descany;
    }

    /**
     * @return o valor do condicao
     */
    public String getCondicao() {
        return condicao;
    }

    /**
     * @param condicao seta o novo valor para o campo condicao
     */
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
}
