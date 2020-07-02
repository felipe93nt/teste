/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/11/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCapacidadeResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAD")
public class ConsultarCapacidadeResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwadsResponse
     */
    @CommareaBlock(layoutSize = 3300, layoutCode = "RICCWADS")
    protected RICCWADSResponse riccwadsResponse = new RICCWADSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWADSResponse
     *
     * @return rICCWADSResponse
     */
    public RICCWADSResponse getRICCWADSResponse() {
        return riccwadsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWADSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWADSResponse(RICCWADSResponse value) {
        this.riccwadsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCapacidadeResponse() {
        super();
    }
}
