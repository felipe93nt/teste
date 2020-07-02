/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 26/06/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarDuplaValidaResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAH")
public class ConsultarDuplaValidaResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwahsResponse
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWAHS")
    protected RICCWAHSResponse riccwahsResponse = new RICCWAHSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAHSResponse
     *
     * @return rICCWAHSResponse
     */
    public RICCWAHSResponse getRICCWAHSResponse() {
        return riccwahsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAHSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAHSResponse(RICCWAHSResponse value) {
        this.riccwahsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarDuplaValidaResponse() {
        super();
    }
}
