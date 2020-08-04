/**
 *
 * Nome: LogDeParaBoletosVO.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 03/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean;



/**
*
* Nome: LogDeParaBoletosVO.java
* Propósito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 03/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
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
