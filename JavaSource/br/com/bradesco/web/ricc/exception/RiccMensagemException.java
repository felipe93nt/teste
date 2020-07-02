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
 * Centro de Desenvolvimento - DDS Bradesco 2016
 * Nome: BpmhException.
 * Prop�sito: BpmhException.
 * Equipe: bpmh
 *
 * @author m126112
 * @version 1.0
 * @see
 * @date 23/11/2016-14:41:55
 */
public class RiccMensagemException extends BradescoApplicationException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5847517764760442208L;

    /**
     * Construtor Padr�o
     * Prop�sito: Instancia um novo objeto BpmhException.
     *
     * @param arg0 the arg 0
     */
	public RiccMensagemException(String arg0) {
	  super(arg0);
	}


}
