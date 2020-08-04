/**
*
* Nome: ComboGrupoBanqueirosVo.java
* Propósito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 16/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
 *
 * Nome: ComboGrupoBanqueirosVo.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 16/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class ComboRelacaoVinculoVO {
	
	/** CODIGO VINCULO PAGADOR/RECEBEDOR PIC 9(002). */
    private Integer cvnclopgdorrcdor = null;
	
	/** NOME VINCULO PAGADOR/RECEBEDOR PIC X(050). */
    private String rvnclopgdorrcdor = null;
	
	/** 
	 * Método construtor da classe.
	 */
	public ComboRelacaoVinculoVO() {
		super();

	}

    /**
     * @return o valor do cvnclopgdorrcdor
     */
    public Integer getCvnclopgdorrcdor() {
        return cvnclopgdorrcdor;
    }

    /**
     * @param cvnclopgdorrcdor seta o novo valor para o campo cvnclopgdorrcdor
     */
    public void setCvnclopgdorrcdor(Integer cvnclopgdorrcdor) {
        this.cvnclopgdorrcdor = cvnclopgdorrcdor;
    }

    /**
     * @return o valor do rvnclopgdorrcdor
     */
    public String getRvnclopgdorrcdor() {
        return rvnclopgdorrcdor;
    }

    /**
     * @param rvnclopgdorrcdor seta o novo valor para o campo rvnclopgdorrcdor
     */
    public void setRvnclopgdorrcdor(String rvnclopgdorrcdor) {
        this.rvnclopgdorrcdor = rvnclopgdorrcdor;
    }

}