/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapitalInve.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCapitalInveRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAS")
public class ConsultarCapitalInveRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaseRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWASE")
    protected RICCWASERequest riccwaseRequest = new RICCWASERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWASERequest
     *
     * @return rICCWASERequest
     */
    public RICCWASERequest getRICCWASERequest() {
        return riccwaseRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWASERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWASERequest(RICCWASERequest value) {
        this.riccwaseRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCapitalInveRequest() {
        super();
    }
}
