/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/11/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarContratosGpRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAJ")
public class ConsultarContratosGpRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwajeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAJE")
    protected RICCWAJERequest riccwajeRequest = new RICCWAJERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAJERequest
     *
     * @return rICCWAJERequest
     */
    public RICCWAJERequest getRICCWAJERequest() {
        return riccwajeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAJERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAJERequest(RICCWAJERequest value) {
        this.riccwajeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarContratosGpRequest() {
        super();
    }
}
