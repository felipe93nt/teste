/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 07/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: CopiarRelatorioResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWCOSResponse
     *
     * @return rICCWCOSResponse
     */
    public RICCWCOSResponse getRICCWCOSResponse() {
        return riccwcosResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCOSResponse
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
