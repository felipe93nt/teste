/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 20/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutUsinasRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACE")
public class ManutUsinasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwceeRequest
     */
    @CommareaBlock(layoutSize = 1206, layoutCode = "RICCWCEE")
    protected RICCWCEERequest riccwceeRequest = new RICCWCEERequest();

    /**
     * Propósito:  Retornar o valor de rICCWCEERequest
     *
     * @return rICCWCEERequest
     */
    public RICCWCEERequest getRICCWCEERequest() {
        return riccwceeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCEERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCEERequest(RICCWCEERequest value) {
        this.riccwceeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutUsinasRequest() {
        super();
    }
}
