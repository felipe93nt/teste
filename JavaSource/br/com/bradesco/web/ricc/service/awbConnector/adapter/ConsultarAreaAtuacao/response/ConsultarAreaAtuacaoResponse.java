/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarAreaAtuacaoResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA4")
public class ConsultarAreaAtuacaoResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa4SResponse
     */
    @CommareaBlock(layoutSize = 4600, layoutCode = "RICCWA4S")
    protected RICCWA4SResponse riccwa4SResponse = new RICCWA4SResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWA4SResponse
     *
     * @return rICCWA4SResponse
     */
    public RICCWA4SResponse getRICCWA4SResponse() {
        return riccwa4SResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWA4SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA4SResponse(RICCWA4SResponse value) {
        this.riccwa4SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarAreaAtuacaoResponse() {
        super();
    }
}
