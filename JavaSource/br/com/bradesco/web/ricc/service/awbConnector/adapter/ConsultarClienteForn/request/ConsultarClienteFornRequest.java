/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarClienteForn.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarClienteFornRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAO")
public class ConsultarClienteFornRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaoeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAOE")
    protected RICCWAOERequest riccwaoeRequest = new RICCWAOERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAOERequest
     *
     * @return rICCWAOERequest
     */
    public RICCWAOERequest getRICCWAOERequest() {
        return riccwaoeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAOERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAOERequest(RICCWAOERequest value) {
        this.riccwaoeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarClienteFornRequest() {
        super();
    }
}
