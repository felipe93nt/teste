/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarProdUsinasRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA8")
public class ConsultarProdUsinasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa8ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA8E")
    protected RICCWA8ERequest riccwa8ERequest = new RICCWA8ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA8ERequest
     *
     * @return rICCWA8ERequest
     */
    public RICCWA8ERequest getRICCWA8ERequest() {
        return riccwa8ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA8ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA8ERequest(RICCWA8ERequest value) {
        this.riccwa8ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarProdUsinasRequest() {
        super();
    }
}
