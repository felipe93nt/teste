/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarContrTransp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarContrTranspRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAU")
public class ConsultarContrTranspRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaueRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAUE")
    protected RICCWAUERequest riccwaueRequest = new RICCWAUERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAUERequest
     *
     * @return rICCWAUERequest
     */
    public RICCWAUERequest getRICCWAUERequest() {
        return riccwaueRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAUERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAUERequest(RICCWAUERequest value) {
        this.riccwaueRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarContrTranspRequest() {
        super();
    }
}
