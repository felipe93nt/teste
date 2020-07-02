/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarContrTranspResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAU")
public class ConsultarContrTranspResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwausResponse
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWAUS")
    protected RICCWAUSResponse riccwausResponse = new RICCWAUSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAUSResponse
     *
     * @return rICCWAUSResponse
     */
    public RICCWAUSResponse getRICCWAUSResponse() {
        return riccwausResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAUSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAUSResponse(RICCWAUSResponse value) {
        this.riccwausResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarContrTranspResponse() {
        super();
    }
}
