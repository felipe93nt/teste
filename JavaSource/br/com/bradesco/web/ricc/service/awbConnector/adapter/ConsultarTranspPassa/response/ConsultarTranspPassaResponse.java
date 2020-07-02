/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarTranspPassaResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWATSResponse
     *
     * @return rICCWATSResponse
     */
    public RICCWATSResponse getRICCWATSResponse() {
        return riccwatsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWATSResponse
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
