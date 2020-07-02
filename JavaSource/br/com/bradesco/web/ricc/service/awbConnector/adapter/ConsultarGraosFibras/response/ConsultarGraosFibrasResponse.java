/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarGraosFibrasResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA6")
public class ConsultarGraosFibrasResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa6SResponse
     */
    @CommareaBlock(layoutSize = 1800, layoutCode = "RICCWA6S")
    protected RICCWA6SResponse riccwa6SResponse = new RICCWA6SResponse();

    /**
     * Propósito:  Retornar o valor de rICCWA6SResponse
     *
     * @return rICCWA6SResponse
     */
    public RICCWA6SResponse getRICCWA6SResponse() {
        return riccwa6SResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA6SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA6SResponse(RICCWA6SResponse value) {
        this.riccwa6SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarGraosFibrasResponse() {
        super();
    }
}
