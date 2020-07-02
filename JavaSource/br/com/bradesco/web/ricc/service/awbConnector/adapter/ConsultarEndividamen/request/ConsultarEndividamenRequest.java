/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarEndividamenRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWALERequest
     *
     * @return rICCWALERequest
     */
    public RICCWALERequest getRICCWALERequest() {
        return riccwaleRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWALERequest
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
