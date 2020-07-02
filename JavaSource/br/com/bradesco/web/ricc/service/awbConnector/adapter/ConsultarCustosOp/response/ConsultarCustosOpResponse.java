/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 13/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCustosOpResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWAQSResponse
     *
     * @return rICCWAQSResponse
     */
    public RICCWAQSResponse getRICCWAQSResponse() {
        return riccwaqsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAQSResponse
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
