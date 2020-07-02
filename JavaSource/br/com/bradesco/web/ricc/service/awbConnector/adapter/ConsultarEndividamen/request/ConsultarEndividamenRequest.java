/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 05/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarEndividamenRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAL")
public class ConsultarEndividamenRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaleRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWALE")
    protected RICCWALERequest riccwaleRequest = new RICCWALERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWALERequest
     *
     * @return rICCWALERequest
     */
    public RICCWALERequest getRICCWALERequest() {
        return riccwaleRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWALERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWALERequest(RICCWALERequest value) {
        this.riccwaleRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarEndividamenRequest() {
        super();
    }
}
