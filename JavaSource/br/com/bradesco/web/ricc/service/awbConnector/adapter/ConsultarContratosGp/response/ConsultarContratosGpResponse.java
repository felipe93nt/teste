/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 14/11/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContratosGp.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarContratosGpResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAJ")
public class ConsultarContratosGpResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwajsResponse
     */
    @CommareaBlock(layoutSize = 11300, layoutCode = "RICCWAJS")
    protected RICCWAJSResponse riccwajsResponse = new RICCWAJSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAJSResponse
     *
     * @return rICCWAJSResponse
     */
    public RICCWAJSResponse getRICCWAJSResponse() {
        return riccwajsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAJSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAJSResponse(RICCWAJSResponse value) {
        this.riccwajsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarContratosGpResponse() {
        super();
    }
}
