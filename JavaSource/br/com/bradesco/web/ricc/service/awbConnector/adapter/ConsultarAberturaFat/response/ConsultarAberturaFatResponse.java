/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 22/10/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarAberturaFatResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAE")
public class ConsultarAberturaFatResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaesResponse
     */
    @CommareaBlock(layoutSize = 600, layoutCode = "RICCWAES")
    protected RICCWAESResponse riccwaesResponse = new RICCWAESResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAESResponse
     *
     * @return rICCWAESResponse
     */
    public RICCWAESResponse getRICCWAESResponse() {
        return riccwaesResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAESResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAESResponse(RICCWAESResponse value) {
        this.riccwaesResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarAberturaFatResponse() {
        super();
    }
}
