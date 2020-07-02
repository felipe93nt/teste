/**
 * Nome: br.com.bradesco.web.bpmh.exception.BpmhException.java<BR/>
 * Prop�sito: Classe bpmh<BR/>
 *
 * Compilador: 1.6<BR/>
 * Data da Cria��o: 23/11/2016-14:41:53<BR/>
 * Par�metros de Compila��o -d<BR/>
 * Registro de Manuten��o: 23/11/2016<BR/>
 *
 * - Autor: m126112 <BR/>
 * - Respons�vel: Equipe bpmh
 */

package br.com.bradesco.web.ricc.exception;

import br.com.bradesco.web.aq.application.error.BradescoApplicationException;

/**
 * Centro de Desenvolvimento - DDS Bradesco 2016 Nome: BpmhException. Prop�sito:
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
	 * Construtor Padr�o Prop�sito: Instancia um novo objeto BpmhException.
	 */
	public RiccException() {
		super();
	}

	/**
	 * Construtor Padr�o Prop�sito: Instancia um novo objeto BpmhException.
	 *
	 * @param arg0
	 *            the arg 0
	 */
	public RiccException(String arg0) {
		super(arg0);
	}

	/**
	 * Construtor Padr�o Prop�sito: Instancia um novo objeto BpmhException.
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
	 * Construtor Padr�o Prop�sito: Instancia um novo objeto BpmhException.
	 *
	 * @param arg0
	 *            the arg 0
	 */
	public RiccException(Throwable arg0) {
		super(arg0);
	}
}
