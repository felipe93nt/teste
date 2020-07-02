/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarProdUsinas.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarProdUsinasResponse 
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
public class ConsultarProdUsinasResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa8SResponse
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWA8S")
    protected RICCWA8SResponse riccwa8SResponse = new RICCWA8SResponse();

    /**
     * Propósito:  Retornar o valor de rICCWA8SResponse
     *
     * @return rICCWA8SResponse
     */
    public RICCWA8SResponse getRICCWA8SResponse() {
        return riccwa8SResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA8SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA8SResponse(RICCWA8SResponse value) {
        this.riccwa8SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarProdUsinasResponse() {
        super();
    }
}
