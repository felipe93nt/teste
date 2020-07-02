/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarQuadroAdminResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAB")
public class ConsultarQuadroAdminResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwabsResponse
     */
    @CommareaBlock(layoutSize = 5600, layoutCode = "RICCWABS")
    protected RICCWABSResponse riccwabsResponse = new RICCWABSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWABSResponse
     *
     * @return rICCWABSResponse
     */
    public RICCWABSResponse getRICCWABSResponse() {
        return riccwabsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWABSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWABSResponse(RICCWABSResponse value) {
        this.riccwabsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarQuadroAdminResponse() {
        super();
    }
}
