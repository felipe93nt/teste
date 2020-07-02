/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 18/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCompraTerreResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA0")
public class ConsultarCompraTerreResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa0SResponse
     */
    @CommareaBlock(layoutSize = 7400, layoutCode = "RICCWA0S")
    protected RICCWA0SResponse riccwa0SResponse = new RICCWA0SResponse();

    /**
     * Propósito:  Retornar o valor de rICCWA0SResponse
     *
     * @return rICCWA0SResponse
     */
    public RICCWA0SResponse getRICCWA0SResponse() {
        return riccwa0SResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA0SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA0SResponse(RICCWA0SResponse value) {
        this.riccwa0SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCompraTerreResponse() {
        super();
    }
}
