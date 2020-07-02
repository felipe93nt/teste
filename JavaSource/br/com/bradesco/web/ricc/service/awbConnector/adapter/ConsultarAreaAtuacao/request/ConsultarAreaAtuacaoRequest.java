/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarAreaAtuacaoRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA4")
public class ConsultarAreaAtuacaoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa4ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA4E")
    protected RICCWA4ERequest riccwa4ERequest = new RICCWA4ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA4ERequest
     *
     * @return rICCWA4ERequest
     */
    public RICCWA4ERequest getRICCWA4ERequest() {
        return riccwa4ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA4ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA4ERequest(RICCWA4ERequest value) {
        this.riccwa4ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarAreaAtuacaoRequest() {
        super();
    }
}
