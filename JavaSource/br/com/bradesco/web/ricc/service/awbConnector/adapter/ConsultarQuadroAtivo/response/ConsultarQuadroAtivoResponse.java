/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarQuadroAtivoResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAN")
public class ConsultarQuadroAtivoResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwansResponse
     */
    @CommareaBlock(layoutSize = 17700, layoutCode = "RICCWANS")
    protected RICCWANSResponse riccwansResponse = new RICCWANSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWANSResponse
     *
     * @return rICCWANSResponse
     */
    public RICCWANSResponse getRICCWANSResponse() {
        return riccwansResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWANSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWANSResponse(RICCWANSResponse value) {
        this.riccwansResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarQuadroAtivoResponse() {
        super();
    }
}
