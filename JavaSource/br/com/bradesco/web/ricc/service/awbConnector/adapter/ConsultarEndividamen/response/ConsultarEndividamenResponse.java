/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEndividamen.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarEndividamenResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAL")
public class ConsultarEndividamenResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwalsResponse
     */
    @CommareaBlock(layoutSize = 13800, layoutCode = "RICCWALS")
    protected RICCWALSResponse riccwalsResponse = new RICCWALSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWALSResponse
     *
     * @return rICCWALSResponse
     */
    public RICCWALSResponse getRICCWALSResponse() {
        return riccwalsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWALSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWALSResponse(RICCWALSResponse value) {
        this.riccwalsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarEndividamenResponse() {
        super();
    }
}
