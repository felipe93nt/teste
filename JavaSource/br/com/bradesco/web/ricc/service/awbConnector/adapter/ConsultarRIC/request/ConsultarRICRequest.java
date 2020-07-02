/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 05/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRIC.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarRICRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAA")
public class ConsultarRICRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaaeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAAE")
    protected RICCWAAERequest riccwaaeRequest = new RICCWAAERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAAERequest
     *
     * @return rICCWAAERequest
     */
    public RICCWAAERequest getRICCWAAERequest() {
        return riccwaaeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAAERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAAERequest(RICCWAAERequest value) {
        this.riccwaaeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarRICRequest() {
        super();
    }
}
