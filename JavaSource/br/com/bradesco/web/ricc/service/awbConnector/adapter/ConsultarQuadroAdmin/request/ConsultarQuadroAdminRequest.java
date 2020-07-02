/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAdmin.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarQuadroAdminRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAB")
public class ConsultarQuadroAdminRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwabeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWABE")
    protected RICCWABERequest riccwabeRequest = new RICCWABERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWABERequest
     *
     * @return rICCWABERequest
     */
    public RICCWABERequest getRICCWABERequest() {
        return riccwabeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWABERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWABERequest(RICCWABERequest value) {
        this.riccwabeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarQuadroAdminRequest() {
        super();
    }
}
