/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutComentarios.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutComentariosRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACG")
public class ManutComentariosRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcgeRequest
     */
    @CommareaBlock(layoutSize = 20200, layoutCode = "RICCWCGE")
    protected RICCWCGERequest riccwcgeRequest = new RICCWCGERequest();

    /**
     * Propósito:  Retornar o valor de rICCWCGERequest
     *
     * @return rICCWCGERequest
     */
    public RICCWCGERequest getRICCWCGERequest() {
        return riccwcgeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCGERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCGERequest(RICCWCGERequest value) {
        this.riccwcgeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutComentariosRequest() {
        super();
    }
}
