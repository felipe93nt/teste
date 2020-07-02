/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 13/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCustosOp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCustosOpRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAQ")
public class ConsultarCustosOpRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaqeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAQE")
    protected RICCWAQERequest riccwaqeRequest = new RICCWAQERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAQERequest
     *
     * @return rICCWAQERequest
     */
    public RICCWAQERequest getRICCWAQERequest() {
        return riccwaqeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAQERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAQERequest(RICCWAQERequest value) {
        this.riccwaqeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCustosOpRequest() {
        super();
    }
}
