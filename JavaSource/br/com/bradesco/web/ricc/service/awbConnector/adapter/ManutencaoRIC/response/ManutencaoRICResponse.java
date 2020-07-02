/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutencaoRICResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABH")
public class ManutencaoRICResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwbhsResponse
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWBHS")
    protected RICCWBHSResponse riccwbhsResponse = new RICCWBHSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWBHSResponse
     *
     * @return rICCWBHSResponse
     */
    public RICCWBHSResponse getRICCWBHSResponse() {
        return riccwbhsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBHSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBHSResponse(RICCWBHSResponse value) {
        this.riccwbhsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutencaoRICResponse() {
        super();
    }
}
