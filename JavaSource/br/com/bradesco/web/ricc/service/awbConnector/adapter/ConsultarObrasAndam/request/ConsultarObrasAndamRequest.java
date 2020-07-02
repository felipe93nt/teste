/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 29/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarObrasAndam.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarObrasAndamRequest 
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
public class ConsultarObrasAndamRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa2ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA2E")
    protected RICCWA2ERequest riccwa2ERequest = new RICCWA2ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA2ERequest
     *
     * @return rICCWA2ERequest
     */
    public RICCWA2ERequest getRICCWA2ERequest() {
        return riccwa2ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA2ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA2ERequest(RICCWA2ERequest value) {
        this.riccwa2ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarObrasAndamRequest() {
        super();
    }
}
