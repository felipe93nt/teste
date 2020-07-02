/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelAgricola.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelAgricola.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutRelAgricolaRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACJ")
public class ManutRelAgricolaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcjeRequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWCJE")
    protected RICCWCJERequest riccwcjeRequest = new RICCWCJERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCJERequest
     *
     * @return rICCWCJERequest
     */
    public RICCWCJERequest getRICCWCJERequest() {
        return riccwcjeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCJERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCJERequest(RICCWCJERequest value) {
        this.riccwcjeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutRelAgricolaRequest() {
        super();
    }
}
