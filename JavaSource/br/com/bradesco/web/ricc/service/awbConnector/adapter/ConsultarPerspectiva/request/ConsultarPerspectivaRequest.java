/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarPerspectivaRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAI")
public class ConsultarPerspectivaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaieRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAIE")
    protected RICCWAIERequest riccwaieRequest = new RICCWAIERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAIERequest
     *
     * @return rICCWAIERequest
     */
    public RICCWAIERequest getRICCWAIERequest() {
        return riccwaieRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAIERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAIERequest(RICCWAIERequest value) {
        this.riccwaieRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarPerspectivaRequest() {
        super();
    }
}
