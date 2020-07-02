/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 17/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelTranspResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABF")
public class DetalharRelTranspResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwbfsResponse
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBFS")
    protected RICCWBFSResponse riccwbfsResponse = new RICCWBFSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWBFSResponse
     *
     * @return rICCWBFSResponse
     */
    public RICCWBFSResponse getRICCWBFSResponse() {
        return riccwbfsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBFSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBFSResponse(RICCWBFSResponse value) {
        this.riccwbfsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelTranspResponse() {
        super();
    }
}
