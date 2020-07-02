/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarGraosFibras.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarGraosFibrasRequest 
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
public class ConsultarGraosFibrasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa6ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA6E")
    protected RICCWA6ERequest riccwa6ERequest = new RICCWA6ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA6ERequest
     *
     * @return rICCWA6ERequest
     */
    public RICCWA6ERequest getRICCWA6ERequest() {
        return riccwa6ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA6ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA6ERequest(RICCWA6ERequest value) {
        this.riccwa6ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarGraosFibrasRequest() {
        super();
    }
}
