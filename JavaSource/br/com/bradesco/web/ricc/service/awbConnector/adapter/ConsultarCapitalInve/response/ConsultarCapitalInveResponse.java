/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCapitalInveResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAS")
public class ConsultarCapitalInveResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwassResponse
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWASS")
    protected RICCWASSResponse riccwassResponse = new RICCWASSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWASSResponse
     *
     * @return rICCWASSResponse
     */
    public RICCWASSResponse getRICCWASSResponse() {
        return riccwassResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWASSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWASSResponse(RICCWASSResponse value) {
        this.riccwassResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCapitalInveResponse() {
        super();
    }
}
