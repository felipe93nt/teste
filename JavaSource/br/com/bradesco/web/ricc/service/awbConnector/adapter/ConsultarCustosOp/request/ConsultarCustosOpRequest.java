/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 13/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCustosOpRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAQ")
public class ConsultarCustosOpRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaqeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAQE")
    protected RICCWAQERequest riccwaqeRequest = new RICCWAQERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAQERequest
     *
     * @return rICCWAQERequest
     */
    public RICCWAQERequest getRICCWAQERequest() {
        return riccwaqeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAQERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAQERequest(RICCWAQERequest value) {
        this.riccwaqeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCustosOpRequest() {
        super();
    }
}
