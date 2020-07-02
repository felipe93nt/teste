/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarClienteFornResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWAOSResponse
     *
     * @return rICCWAOSResponse
     */
    public RICCWAOSResponse getRICCWAOSResponse() {
        return riccwaosResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAOSResponse
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
