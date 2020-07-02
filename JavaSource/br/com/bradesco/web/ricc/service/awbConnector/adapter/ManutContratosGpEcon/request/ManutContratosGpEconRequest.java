/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutContratosGpEconRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABQ")
public class ManutContratosGpEconRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbqeRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWBQE")
    protected RICCWBQERequest riccwbqeRequest = new RICCWBQERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBQERequest
     *
     * @return rICCWBQERequest
     */
    public RICCWBQERequest getRICCWBQERequest() {
        return riccwbqeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBQERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBQERequest(RICCWBQERequest value) {
        this.riccwbqeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutContratosGpEconRequest() {
        super();
    }
}
