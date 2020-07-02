/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarReciprocidaRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAM")
public class ConsultarReciprocidaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwameRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAME")
    protected RICCWAMERequest riccwameRequest = new RICCWAMERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAMERequest
     *
     * @return rICCWAMERequest
     */
    public RICCWAMERequest getRICCWAMERequest() {
        return riccwameRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAMERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAMERequest(RICCWAMERequest value) {
        this.riccwameRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarReciprocidaRequest() {
        super();
    }
}
