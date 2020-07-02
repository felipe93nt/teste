/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 07/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: CopiarRelatorioResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACO")
public class CopiarRelatorioResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwcosResponse
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWCOS")
    protected RICCWCOSResponse riccwcosResponse = new RICCWCOSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWCOSResponse
     *
     * @return rICCWCOSResponse
     */
    public RICCWCOSResponse getRICCWCOSResponse() {
        return riccwcosResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCOSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCOSResponse(RICCWCOSResponse value) {
        this.riccwcosResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public CopiarRelatorioResponse() {
        super();
    }
}
