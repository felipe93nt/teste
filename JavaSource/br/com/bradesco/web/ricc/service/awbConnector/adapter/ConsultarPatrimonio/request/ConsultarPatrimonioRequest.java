/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarPatrimonioRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAC")
public class ConsultarPatrimonioRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaceRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWACE")
    protected RICCWACERequest riccwaceRequest = new RICCWACERequest();

    /**
     * Propósito:  Retornar o valor de rICCWACERequest
     *
     * @return rICCWACERequest
     */
    public RICCWACERequest getRICCWACERequest() {
        return riccwaceRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWACERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWACERequest(RICCWACERequest value) {
        this.riccwaceRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarPatrimonioRequest() {
        super();
    }
}
