/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 26/06/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharParamRelatResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABB")
public class DetalharParamRelatResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwbbsResponse
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWBBS")
    protected RICCWBBSResponse riccwbbsResponse = new RICCWBBSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWBBSResponse
     *
     * @return rICCWBBSResponse
     */
    public RICCWBBSResponse getRICCWBBSResponse() {
        return riccwbbsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBBSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBBSResponse(RICCWBBSResponse value) {
        this.riccwbbsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharParamRelatResponse() {
        super();
    }
}
