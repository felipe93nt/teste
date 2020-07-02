/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarTranspPassa.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarTranspPassaRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAT")
public class ConsultarTranspPassaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwateRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWATE")
    protected RICCWATERequest riccwateRequest = new RICCWATERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWATERequest
     *
     * @return rICCWATERequest
     */
    public RICCWATERequest getRICCWATERequest() {
        return riccwateRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWATERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWATERequest(RICCWATERequest value) {
        this.riccwateRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarTranspPassaRequest() {
        super();
    }
}
