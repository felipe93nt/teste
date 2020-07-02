/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarReciprocidaResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAM")
public class ConsultarReciprocidaResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwamsResponse
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWAMS")
    protected RICCWAMSResponse riccwamsResponse = new RICCWAMSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAMSResponse
     *
     * @return rICCWAMSResponse
     */
    public RICCWAMSResponse getRICCWAMSResponse() {
        return riccwamsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAMSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAMSResponse(RICCWAMSResponse value) {
        this.riccwamsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarReciprocidaResponse() {
        super();
    }
}
