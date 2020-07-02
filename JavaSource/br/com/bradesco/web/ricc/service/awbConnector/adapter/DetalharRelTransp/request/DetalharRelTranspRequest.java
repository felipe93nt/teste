/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 17/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelTransp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelTranspRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABF")
public class DetalharRelTranspRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbfeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWBFE")
    protected RICCWBFERequest riccwbfeRequest = new RICCWBFERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBFERequest
     *
     * @return rICCWBFERequest
     */
    public RICCWBFERequest getRICCWBFERequest() {
        return riccwbfeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBFERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBFERequest(RICCWBFERequest value) {
        this.riccwbfeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelTranspRequest() {
        super();
    }
}
