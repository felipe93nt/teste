/**
 * Nome: br.com.bradesco.web.bpmh.exception.BpmhException.java<BR/>
 * Propósito: Classe bpmh<BR/>
 *
 * Compilador: 1.6<BR/>
 * Data da Criação: 23/11/2016-14:41:53<BR/>
 * Parâmetros de Compilação -d<BR/>
 * Registro de Manutenção: 23/11/2016<BR/>
 *
 * - Autor: m126112 <BR/>
 * - Responsável: Equipe bpmh
 */

package br.com.bradesco.web.ricc.exception;

import br.com.bradesco.web.aq.application.error.BradescoApplicationException;

/**
 * Centro de Desenvolvimento - DDS Bradesco 2016 Nome: BpmhException. Propósito:
 * BpmhException. Equipe: bpmh
 *
 * @author m126112
 * @version 1.0
 * @see
 * @date 23/11/2016-14:41:55
 */
public class RiccException extends BradescoApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5847517764760442208L;

	/**
	 * Construtor Padrão Propósito: Instancia um novo objeto BpmhException.
	 */
	public RiccException() {
		super();
	}

	/**
	 * Construtor Padrão Propósito: Instancia um novo objeto BpmhException.
	 *
	 * @param arg0
	 *            the arg 0
	 */
	public RiccException(String arg0) {
		super(arg0);
	}

	/**
	 * Construtor Padrão Propósito: Instancia um novo objeto BpmhException.
	 *
	 * @param arg0
	 *            the arg 0
	 * @param arg1
	 *            the arg 1
	 */
	public RiccException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Construtor Padrão Propósito: Instancia um novo objeto BpmhException.
	 *
	 * @param arg0
	 *            the arg 0
	 */
	public RiccException(Throwable arg0) {
		super(arg0);
	}
}
