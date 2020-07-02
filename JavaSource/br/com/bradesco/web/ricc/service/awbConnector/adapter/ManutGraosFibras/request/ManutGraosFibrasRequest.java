/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutGraosFibras.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutGraosFibrasRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACD")
public class ManutGraosFibrasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcdeRequest
     */
    @CommareaBlock(layoutSize = 1800, layoutCode = "RICCWCDE")
    protected RICCWCDERequest riccwcdeRequest = new RICCWCDERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCDERequest
     *
     * @return rICCWCDERequest
     */
    public RICCWCDERequest getRICCWCDERequest() {
        return riccwcdeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCDERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCDERequest(RICCWCDERequest value) {
        this.riccwcdeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutGraosFibrasRequest() {
        super();
    }
}
