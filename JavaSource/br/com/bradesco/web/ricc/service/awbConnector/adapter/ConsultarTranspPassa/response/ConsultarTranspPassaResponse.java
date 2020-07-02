/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarTranspPassaResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAT")
public class ConsultarTranspPassaResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwatsResponse
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWATS")
    protected RICCWATSResponse riccwatsResponse = new RICCWATSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWATSResponse
     *
     * @return rICCWATSResponse
     */
    public RICCWATSResponse getRICCWATSResponse() {
        return riccwatsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWATSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWATSResponse(RICCWATSResponse value) {
        this.riccwatsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarTranspPassaResponse() {
        super();
    }
}
