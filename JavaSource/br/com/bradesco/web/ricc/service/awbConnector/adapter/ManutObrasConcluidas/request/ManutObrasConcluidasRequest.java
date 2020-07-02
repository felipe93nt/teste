/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutObrasConcluidasRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB8")
public class ManutObrasConcluidasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb8ERequest
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWB8E")
    protected RICCWB8ERequest riccwb8ERequest = new RICCWB8ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWB8ERequest
     *
     * @return rICCWB8ERequest
     */
    public RICCWB8ERequest getRICCWB8ERequest() {
        return riccwb8ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWB8ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB8ERequest(RICCWB8ERequest value) {
        this.riccwb8ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutObrasConcluidasRequest() {
        super();
    }
}
