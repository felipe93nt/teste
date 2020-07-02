/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 07/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutCapacidadeProdRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABK")
public class ManutCapacidadeProdRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbkeRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBKE")
    protected RICCWBKERequest riccwbkeRequest = new RICCWBKERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBKERequest
     *
     * @return rICCWBKERequest
     */
    public RICCWBKERequest getRICCWBKERequest() {
        return riccwbkeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBKERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBKERequest(RICCWBKERequest value) {
        this.riccwbkeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutCapacidadeProdRequest() {
        super();
    }
}
