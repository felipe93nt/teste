/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 29/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarObrasAndamResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA2")
public class ConsultarObrasAndamResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa2SResponse
     */
    @CommareaBlock(layoutSize = 22300, layoutCode = "RICCWA2S")
    protected RICCWA2SResponse riccwa2SResponse = new RICCWA2SResponse();

    /**
     * Propósito:  Retornar o valor de rICCWA2SResponse
     *
     * @return rICCWA2SResponse
     */
    public RICCWA2SResponse getRICCWA2SResponse() {
        return riccwa2SResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA2SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA2SResponse(RICCWA2SResponse value) {
        this.riccwa2SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarObrasAndamResponse() {
        super();
    }
}
