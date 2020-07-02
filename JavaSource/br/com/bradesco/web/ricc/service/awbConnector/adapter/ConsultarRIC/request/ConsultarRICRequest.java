/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarRICRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAA")
public class ConsultarRICRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaaeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAAE")
    protected RICCWAAERequest riccwaaeRequest = new RICCWAAERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAAERequest
     *
     * @return rICCWAAERequest
     */
    public RICCWAAERequest getRICCWAAERequest() {
        return riccwaaeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAAERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAAERequest(RICCWAAERequest value) {
        this.riccwaaeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarRICRequest() {
        super();
    }
}
