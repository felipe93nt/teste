/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 07/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapacidadeProd.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutCapacidadeProdRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de rICCWBKERequest
     *
     * @return rICCWBKERequest
     */
    public RICCWBKERequest getRICCWBKERequest() {
        return riccwbkeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBKERequest
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
