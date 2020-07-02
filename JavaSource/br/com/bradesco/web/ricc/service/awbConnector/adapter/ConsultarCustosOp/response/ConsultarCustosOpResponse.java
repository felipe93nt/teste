/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 13/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCustosOpResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAQ")
public class ConsultarCustosOpResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaqsResponse
     */
    @CommareaBlock(layoutSize = 250, layoutCode = "RICCWAQS")
    protected RICCWAQSResponse riccwaqsResponse = new RICCWAQSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAQSResponse
     *
     * @return rICCWAQSResponse
     */
    public RICCWAQSResponse getRICCWAQSResponse() {
        return riccwaqsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAQSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAQSResponse(RICCWAQSResponse value) {
        this.riccwaqsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCustosOpResponse() {
        super();
    }
}
