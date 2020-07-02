/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarExposicaoResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAG")
public class ConsultarExposicaoResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwagsResponse
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWAGS")
    protected RICCWAGSResponse riccwagsResponse = new RICCWAGSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAGSResponse
     *
     * @return rICCWAGSResponse
     */
    public RICCWAGSResponse getRICCWAGSResponse() {
        return riccwagsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAGSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAGSResponse(RICCWAGSResponse value) {
        this.riccwagsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarExposicaoResponse() {
        super();
    }
}
