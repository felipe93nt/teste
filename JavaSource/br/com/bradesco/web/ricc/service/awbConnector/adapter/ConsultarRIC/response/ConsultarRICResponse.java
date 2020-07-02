/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarRICResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAA")
public class ConsultarRICResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaasResponse
     */
    @CommareaBlock(layoutSize = 1100, layoutCode = "RICCWAAS")
    protected RICCWAASResponse riccwaasResponse = new RICCWAASResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAASResponse
     *
     * @return rICCWAASResponse
     */
    public RICCWAASResponse getRICCWAASResponse() {
        return riccwaasResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAASResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAASResponse(RICCWAASResponse value) {
        this.riccwaasResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarRICResponse() {
        super();
    }
}
