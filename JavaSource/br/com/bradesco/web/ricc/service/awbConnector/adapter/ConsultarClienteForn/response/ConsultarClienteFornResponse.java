/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarClienteFornResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAO")
public class ConsultarClienteFornResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaosResponse
     */
    @CommareaBlock(layoutSize = 4900, layoutCode = "RICCWAOS")
    protected RICCWAOSResponse riccwaosResponse = new RICCWAOSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAOSResponse
     *
     * @return rICCWAOSResponse
     */
    public RICCWAOSResponse getRICCWAOSResponse() {
        return riccwaosResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAOSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAOSResponse(RICCWAOSResponse value) {
        this.riccwaosResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarClienteFornResponse() {
        super();
    }
}
