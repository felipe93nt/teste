/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPerspectiva.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarPerspectivaResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAI")
public class ConsultarPerspectivaResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaisResponse
     */
    @CommareaBlock(layoutSize = 210, layoutCode = "RICCWAIS")
    protected RICCWAISResponse riccwaisResponse = new RICCWAISResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAISResponse
     *
     * @return rICCWAISResponse
     */
    public RICCWAISResponse getRICCWAISResponse() {
        return riccwaisResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAISResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAISResponse(RICCWAISResponse value) {
        this.riccwaisResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarPerspectivaResponse() {
        super();
    }
}
