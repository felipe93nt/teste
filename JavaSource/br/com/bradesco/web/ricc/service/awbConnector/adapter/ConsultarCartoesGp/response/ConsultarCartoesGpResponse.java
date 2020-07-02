/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCartoesGp.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCartoesGpResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAH")
public class ConsultarCartoesGpResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwahsResponse
     */
    @CommareaBlock(layoutSize = 3400, layoutCode = "RICCWAHS")
    protected RICCWAHSResponse riccwahsResponse = new RICCWAHSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAHSResponse
     *
     * @return rICCWAHSResponse
     */
    public RICCWAHSResponse getRICCWAHSResponse() {
        return riccwahsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAHSResponse
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
    public ConsultarCartoesGpResponse() {
        super();
    }
}
