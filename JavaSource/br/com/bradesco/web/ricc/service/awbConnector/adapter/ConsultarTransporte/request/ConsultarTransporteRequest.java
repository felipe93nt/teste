/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTransporte.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarTransporteRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAP")
public class ConsultarTransporteRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwapeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAPE")
    protected RICCWAPERequest riccwapeRequest = new RICCWAPERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAPERequest
     *
     * @return rICCWAPERequest
     */
    public RICCWAPERequest getRICCWAPERequest() {
        return riccwapeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAPERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAPERequest(RICCWAPERequest value) {
        this.riccwapeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarTransporteRequest() {
        super();
    }
}
