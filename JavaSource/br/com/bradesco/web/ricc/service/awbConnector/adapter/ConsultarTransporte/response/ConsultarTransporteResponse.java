/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarTransporteResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAP")
public class ConsultarTransporteResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwapsResponse
     */
    @CommareaBlock(layoutSize = 250, layoutCode = "RICCWAPS")
    protected RICCWAPSResponse riccwapsResponse = new RICCWAPSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAPSResponse
     *
     * @return rICCWAPSResponse
     */
    public RICCWAPSResponse getRICCWAPSResponse() {
        return riccwapsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAPSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAPSResponse(RICCWAPSResponse value) {
        this.riccwapsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarTransporteResponse() {
        super();
    }
}
