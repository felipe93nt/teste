/**
 *
 * Nome: LogDeParaBoletosVO.java
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 03/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;



/**
*
* Nome: LogDeParaBoletosVO.java
* Prop�sito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compila��o -d
*
* @see : Referencias externas. 
*
* Registro  de Manuten��o: 03/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padr�o hexavision.
*/
public class MotivoPerdaVO {
    
    /**
     *  CODIGO DO MOTIVO
     */
    private Integer cmotvobletocmbio = 0;

    /**
     * DESCRICAO DO MOTIVO
     */
    private String rmotvobletocmbio = null;

	public Integer getCmotvobletocmbio() {
		return cmotvobletocmbio;
	}

	public void setCmotvobletocmbio(Integer cmotvobletocmbio) {
		this.cmotvobletocmbio = cmotvobletocmbio;
	}

	public String getRmotvobletocmbio() {
		return rmotvobletocmbio;
	}

	public void setRmotvobletocmbio(String rmotvobletocmbio) {
		this.rmotvobletocmbio = rmotvobletocmbio;
	}
    
    

}
