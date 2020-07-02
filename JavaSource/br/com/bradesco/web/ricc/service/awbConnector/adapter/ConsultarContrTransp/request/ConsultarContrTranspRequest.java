/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarContrTranspRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAU")
public class ConsultarContrTranspRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaueRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAUE")
    protected RICCWAUERequest riccwaueRequest = new RICCWAUERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAUERequest
     *
     * @return rICCWAUERequest
     */
    public RICCWAUERequest getRICCWAUERequest() {
        return riccwaueRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAUERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAUERequest(RICCWAUERequest value) {
        this.riccwaueRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarContrTranspRequest() {
        super();
    }
}
