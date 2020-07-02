/**
 * Nome: br.com.bradesco.web.bpmh.exception.BpmhExceptionHandler.java<BR/>
 * Propósito: Classe bpmh<BR/>
 *
 * Compilador: 1.6<BR/>
 * Data da Criação: 23/11/2016-14:42:20<BR/>
 * Parâmetros de Compilação -d<BR/>
 * Registro de Manutenção: 23/11/2016<BR/>
 *
 * - Autor: m126112 <BR/>
 * - Responsável: Equipe bpmh
 */

package br.com.bradesco.web.ricc.exception;

import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.handler.BradescoApplicationExceptionHandler;


/**
 * Centro de Desenvolvimento - DDS Bradesco 2016
 * Nome: BpmhExceptionHandler.
 * Propósito: BpmhExceptionHandler.
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
     * Construtor Padrão
     * Propósito: Instancia um novo objeto BpmhExceptionHandler.
     */
    public RiccExceptionHandler() {
        super();
    }
}
