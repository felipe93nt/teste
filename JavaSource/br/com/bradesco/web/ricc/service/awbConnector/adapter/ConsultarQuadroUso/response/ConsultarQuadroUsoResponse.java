/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 03/04/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarQuadroUsoResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAX")
public class ConsultarQuadroUsoResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaxsResponse
     */
    @CommareaBlock(layoutSize = 4400, layoutCode = "RICCWAXS")
    protected RICCWAXSResponse riccwaxsResponse = new RICCWAXSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAXSResponse
     *
     * @return rICCWAXSResponse
     */
    public RICCWAXSResponse getRICCWAXSResponse() {
        return riccwaxsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAXSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAXSResponse(RICCWAXSResponse value) {
        this.riccwaxsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarQuadroUsoResponse() {
        super();
    }
}
