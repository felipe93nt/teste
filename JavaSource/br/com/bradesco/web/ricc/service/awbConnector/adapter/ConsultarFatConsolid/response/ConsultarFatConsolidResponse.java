/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarFatConsolidResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAK")
public class ConsultarFatConsolidResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaksResponse
     */
    @CommareaBlock(layoutSize = 850, layoutCode = "RICCWAKS")
    protected RICCWAKSResponse riccwaksResponse = new RICCWAKSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAKSResponse
     *
     * @return rICCWAKSResponse
     */
    public RICCWAKSResponse getRICCWAKSResponse() {
        return riccwaksResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAKSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAKSResponse(RICCWAKSResponse value) {
        this.riccwaksResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarFatConsolidResponse() {
        super();
    }
}
