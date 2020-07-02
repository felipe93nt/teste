/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 20/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarUsinasResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA7")
public class ConsultarUsinasResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa7SResponse
     */
    @CommareaBlock(layoutSize = 1206, layoutCode = "RICCWA7S")
    protected RICCWA7SResponse riccwa7SResponse = new RICCWA7SResponse();

    /**
     * Propósito:  Retornar o valor de rICCWA7SResponse
     *
     * @return rICCWA7SResponse
     */
    public RICCWA7SResponse getRICCWA7SResponse() {
        return riccwa7SResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA7SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA7SResponse(RICCWA7SResponse value) {
        this.riccwa7SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarUsinasResponse() {
        super();
    }
}
