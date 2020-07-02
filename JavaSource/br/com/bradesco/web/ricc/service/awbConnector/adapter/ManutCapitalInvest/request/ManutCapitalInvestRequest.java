/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCapitalInvest.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutCapitalInvestRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABZ")
public class ManutCapitalInvestRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbzeRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWBZE")
    protected RICCWBZERequest riccwbzeRequest = new RICCWBZERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBZERequest
     *
     * @return rICCWBZERequest
     */
    public RICCWBZERequest getRICCWBZERequest() {
        return riccwbzeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBZERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBZERequest(RICCWBZERequest value) {
        this.riccwbzeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutCapitalInvestRequest() {
        super();
    }
}
