/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 20/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarUsinas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarUsinasRequest 
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
public class ConsultarUsinasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa7ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA7E")
    protected RICCWA7ERequest riccwa7ERequest = new RICCWA7ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA7ERequest
     *
     * @return rICCWA7ERequest
     */
    public RICCWA7ERequest getRICCWA7ERequest() {
        return riccwa7ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA7ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA7ERequest(RICCWA7ERequest value) {
        this.riccwa7ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarUsinasRequest() {
        super();
    }
}
