/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 18/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCompraTerre.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCompraTerreRequest 
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
public class ConsultarCompraTerreRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa0ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA0E")
    protected RICCWA0ERequest riccwa0ERequest = new RICCWA0ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA0ERequest
     *
     * @return rICCWA0ERequest
     */
    public RICCWA0ERequest getRICCWA0ERequest() {
        return riccwa0ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA0ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA0ERequest(RICCWA0ERequest value) {
        this.riccwa0ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCompraTerreRequest() {
        super();
    }
}
