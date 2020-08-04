/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 13/07/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.service.business;

import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
/**
*
* Nome: NpccTradeServiceBusinessException
* Propósito: TODO <br/>
*
* Data: 13/07/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
public class NpccTradeServiceBusinessException extends NpccTradeException {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1L;

	/*
	 * */
	public NpccTradeServiceBusinessException() {
		super();
	}

	/*
     * */
	public NpccTradeServiceBusinessException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/*
     * */
	public NpccTradeServiceBusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/*
     * */
	public NpccTradeServiceBusinessException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
     * Construtor
     * 
     * @param message
     * @param cause
     * @param code
     */
    public NpccTradeServiceBusinessException(final String message, final Throwable cause, final String code) {
        super(message, cause, code);
    }
}
