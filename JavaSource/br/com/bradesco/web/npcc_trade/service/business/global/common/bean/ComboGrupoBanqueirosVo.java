/**
*
* Nome: ComboGrupoBanqueirosVo.java
* Prop�sito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compila��o -d
*
* @see : Referencias externas. 
*
* Registro  de Manuten��o: 16/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padr�o hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;


/**
 *
 * Nome: ComboGrupoBanqueirosVo.java
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 16/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
public class ComboGrupoBanqueirosVo {
	
	/** Variavel do tipo String. */
	private String ctpogrpbanqr = null;
	
	/** Variavel do tipo String. */
	private String igrpbanqrcmbio = null;
	
	/** 
	 * M�todo construtor da classe.
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
