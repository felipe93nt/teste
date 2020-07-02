/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarReciprocida.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarReciprocidaResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWAMSResponse
     *
     * @return rICCWAMSResponse
     */
    public RICCWAMSResponse getRICCWAMSResponse() {
        return riccwamsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAMSResponse
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
