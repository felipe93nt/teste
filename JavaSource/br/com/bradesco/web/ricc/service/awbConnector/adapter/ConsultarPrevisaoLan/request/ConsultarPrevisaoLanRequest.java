/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarPrevisaoLanRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA3")
public class ConsultarPrevisaoLanRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa3ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA3E")
    protected RICCWA3ERequest riccwa3ERequest = new RICCWA3ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA3ERequest
     *
     * @return rICCWA3ERequest
     */
    public RICCWA3ERequest getRICCWA3ERequest() {
        return riccwa3ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA3ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA3ERequest(RICCWA3ERequest value) {
        this.riccwa3ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarPrevisaoLanRequest() {
        super();
    }
}
