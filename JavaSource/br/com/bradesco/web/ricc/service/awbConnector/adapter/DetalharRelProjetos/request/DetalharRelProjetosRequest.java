/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelProjetosRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABG")
public class DetalharRelProjetosRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbgeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWBGE")
    protected RICCWBGERequest riccwbgeRequest = new RICCWBGERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBGERequest
     *
     * @return rICCWBGERequest
     */
    public RICCWBGERequest getRICCWBGERequest() {
        return riccwbgeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBGERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBGERequest(RICCWBGERequest value) {
        this.riccwbgeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelProjetosRequest() {
        super();
    }
}
