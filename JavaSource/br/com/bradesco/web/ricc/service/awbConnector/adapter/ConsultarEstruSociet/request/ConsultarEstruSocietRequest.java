/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarEstruSocietRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAY")
public class ConsultarEstruSocietRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwayeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAYE")
    protected RICCWAYERequest riccwayeRequest = new RICCWAYERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAYERequest
     *
     * @return rICCWAYERequest
     */
    public RICCWAYERequest getRICCWAYERequest() {
        return riccwayeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAYERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAYERequest(RICCWAYERequest value) {
        this.riccwayeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarEstruSocietRequest() {
        super();
    }
}
