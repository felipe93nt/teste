/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarAreaProdutoRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA5")
public class ConsultarAreaProdutoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa5ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA5E")
    protected RICCWA5ERequest riccwa5ERequest = new RICCWA5ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA5ERequest
     *
     * @return rICCWA5ERequest
     */
    public RICCWA5ERequest getRICCWA5ERequest() {
        return riccwa5ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA5ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA5ERequest(RICCWA5ERequest value) {
        this.riccwa5ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarAreaProdutoRequest() {
        super();
    }
}
