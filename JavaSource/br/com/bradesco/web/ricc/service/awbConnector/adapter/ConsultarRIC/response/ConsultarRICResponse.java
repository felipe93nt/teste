/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 05/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarRICResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de rICCWAASResponse
     *
     * @return rICCWAASResponse
     */
    public RICCWAASResponse getRICCWAASResponse() {
        return riccwaasResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAASResponse
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
