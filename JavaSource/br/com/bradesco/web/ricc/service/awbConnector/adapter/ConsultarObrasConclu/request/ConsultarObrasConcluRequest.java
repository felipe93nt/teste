/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 29/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasConclu.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarObrasConcluRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWA1ERequest
     *
     * @return rICCWA1ERequest
     */
    public RICCWA1ERequest getRICCWA1ERequest() {
        return riccwa1ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA1ERequest
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
