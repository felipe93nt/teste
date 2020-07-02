/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutContratosGpEcon.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutContratosGpEconRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de rICCWBQERequest
     *
     * @return rICCWBQERequest
     */
    public RICCWBQERequest getRICCWBQERequest() {
        return riccwbqeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBQERequest
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
