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
public class ComboGrupoBanqueirosVo {
	
	/** Variavel do tipo String. */
	private String ctpogrpbanqr = null;
	
	/** Variavel do tipo String. */
	private String igrpbanqrcmbio = null;
	
	/** 
	 * Método construtor da classe.
	 */
	public ComboGrupoBanqueirosVo() {
		super();

	}

	/**
	 * @return o valor do ctpogrpbanqr
	 */
	public String getCtpogrpbanqr() {
		return ctpogrpbanqr;
	}

	/**
	 * @param ctpogrpbanqr seta o novo valor para o campo ctpogrpbanqr
	 */
	public void setCtpogrpbanqr(String ctpogrpbanqr) {
		this.ctpogrpbanqr = ctpogrpbanqr;
	}

	/**
	 * @return o valor do igrpbanqrcmbio
	 */
	public String getIgrpbanqrcmbio() {
		return igrpbanqrcmbio;
	}

	/**
	 * @param igrpbanqrcmbio seta o novo valor para o campo igrpbanqrcmbio
	 */
	public void setIgrpbanqrcmbio(String igrpbanqrcmbio) {
		this.igrpbanqrcmbio = igrpbanqrcmbio;
	}

}
