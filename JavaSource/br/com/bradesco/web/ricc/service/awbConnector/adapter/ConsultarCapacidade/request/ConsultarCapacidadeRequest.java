/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/11/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCapacidadeRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAD")
public class ConsultarCapacidadeRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwadeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWADE")
    protected RICCWADERequest riccwadeRequest = new RICCWADERequest();

    /**
     * Propósito:  Retornar o valor de rICCWADERequest
     *
     * @return rICCWADERequest
     */
    public RICCWADERequest getRICCWADERequest() {
        return riccwadeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWADERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWADERequest(RICCWADERequest value) {
        this.riccwadeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCapacidadeRequest() {
        super();
    }
}
