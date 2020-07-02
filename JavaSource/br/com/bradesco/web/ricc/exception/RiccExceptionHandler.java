/**
 * Nome: br.com.bradesco.web.bpmh.exception.BpmhExceptionHandler.java<BR/>
 * Prop�sito: Classe bpmh<BR/>
 *
 * Compilador: 1.6<BR/>
 * Data da Cria��o: 23/11/2016-14:42:20<BR/>
 * Par�metros de Compila��o -d<BR/>
 * Registro de Manuten��o: 23/11/2016<BR/>
 *
 * - Autor: m126112 <BR/>
 * - Respons�vel: Equipe bpmh
 */

package br.com.bradesco.web.ricc.exception;

import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.handler.BradescoApplicationExceptionHandler;


/**
 * Centro de Desenvolvimento - DDS Bradesco 2016
 * Nome: BpmhExceptionHandler.
 * Prop�sito: BpmhExceptionHandler.
 * Equipe: bpmh
 *
 * @author m126112
 * @version 1.0
 * @see
 * @date 23/11/2016-14:42:22
 */
@Named("bpmhExceptionHandler")
public class RiccExceptionHandler extends BradescoApplicationExceptionHandler {

    /**
     * Construtor Padr�o
     * Prop�sito: Instancia um novo objeto BpmhExceptionHandler.
     */
    public RiccExceptionHandler() {
        super();
    }
}
