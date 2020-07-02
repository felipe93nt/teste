/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 29/04/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarObrasConcluResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA1")
public class ConsultarObrasConcluResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa1SResponse
     */
    @CommareaBlock(layoutSize = 16700, layoutCode = "RICCWA1S")
    protected RICCWA1SResponse riccwa1SResponse = new RICCWA1SResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWA1SResponse
     *
     * @return rICCWA1SResponse
     */
    public RICCWA1SResponse getRICCWA1SResponse() {
        return riccwa1SResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWA1SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA1SResponse(RICCWA1SResponse value) {
        this.riccwa1SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarObrasConcluResponse() {
        super();
    }
}
