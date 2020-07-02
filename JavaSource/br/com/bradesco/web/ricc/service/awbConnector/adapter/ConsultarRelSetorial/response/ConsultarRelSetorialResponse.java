/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarRelSetorialResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABA")
public class ConsultarRelSetorialResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwbasResponse
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWBAS")
    protected RICCWBASResponse riccwbasResponse = new RICCWBASResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWBASResponse
     *
     * @return rICCWBASResponse
     */
    public RICCWBASResponse getRICCWBASResponse() {
        return riccwbasResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBASResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBASResponse(RICCWBASResponse value) {
        this.riccwbasResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarRelSetorialResponse() {
        super();
    }
}