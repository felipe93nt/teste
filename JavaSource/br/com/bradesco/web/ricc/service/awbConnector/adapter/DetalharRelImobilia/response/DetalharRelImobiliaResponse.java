/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelImobiliaResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABE")
public class DetalharRelImobiliaResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwbesResponse
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWBES")
    protected RICCWBESResponse riccwbesResponse = new RICCWBESResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWBESResponse
     *
     * @return rICCWBESResponse
     */
    public RICCWBESResponse getRICCWBESResponse() {
        return riccwbesResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBESResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBESResponse(RICCWBESResponse value) {
        this.riccwbesResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelImobiliaResponse() {
        super();
    }
}
