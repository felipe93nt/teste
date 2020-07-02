/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutReciprocidadeGp.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutReciprocidadeGp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutReciprocidadeGpRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABT")
public class ManutReciprocidadeGpRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbteRequest
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWBTE")
    protected RICCWBTERequest riccwbteRequest = new RICCWBTERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBTERequest
     *
     * @return rICCWBTERequest
     */
    public RICCWBTERequest getRICCWBTERequest() {
        return riccwbteRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBTERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBTERequest(RICCWBTERequest value) {
        this.riccwbteRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutReciprocidadeGpRequest() {
        super();
    }
}
