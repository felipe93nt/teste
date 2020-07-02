/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 29/04/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarObrasConcluRequest 
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
public class ConsultarObrasConcluRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa1ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA1E")
    protected RICCWA1ERequest riccwa1ERequest = new RICCWA1ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWA1ERequest
     *
     * @return rICCWA1ERequest
     */
    public RICCWA1ERequest getRICCWA1ERequest() {
        return riccwa1ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWA1ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA1ERequest(RICCWA1ERequest value) {
        this.riccwa1ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarObrasConcluRequest() {
        super();
    }
}
