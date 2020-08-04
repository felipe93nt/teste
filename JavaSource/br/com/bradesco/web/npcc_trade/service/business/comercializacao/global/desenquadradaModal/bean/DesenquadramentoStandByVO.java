package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean;

/**
  * Nome: DesenquadramentoStandByVO.java
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
public class DesenquadramentoStandByVO {

    /* DESC-STAND    PIC  X(020). */
    private String descstand = null;

    /* TDIA-MAX      PIC  9(005). */
    private Integer tdiamax = null;

    /* TDIA-VALDD    PIC  9(005). */
    private Integer tdiavaldd = null;
    
    /**
     * Construtor
     * 
     * @param 
     */
    public DesenquadramentoStandByVO() {
        super();
    }

    /**
     * @return o valor do descstand
     */
    public String getDescstand() {
        return descstand;
    }

    /**
     * @param descstand seta o novo valor para o campo descstand
     */
    public void setDescstand(String descstand) {
        this.descstand = descstand;
    }

    /**
     * @return o valor do tdiamax
     */
    public Integer getTdiamax() {
        return tdiamax;
    }

    /**
     * @param tdiamax seta o novo valor para o campo tdiamax
     */
    public void setTdiamax(Integer tdiamax) {
        this.tdiamax = tdiamax;
    }

    /**
     * @return o valor do tdiavaldd
     */
    public Integer getTdiavaldd() {
        return tdiavaldd;
    }

    /**
     * @param tdiavaldd seta o novo valor para o campo tdiavaldd
     */
    public void setTdiavaldd(Integer tdiavaldd) {
        this.tdiavaldd = tdiavaldd;
    }
}
