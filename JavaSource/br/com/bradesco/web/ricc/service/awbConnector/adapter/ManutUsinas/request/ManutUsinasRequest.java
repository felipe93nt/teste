/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 20/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutUsinas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutUsinasRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACE")
public class ManutUsinasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwceeRequest
     */
    @CommareaBlock(layoutSize = 1206, layoutCode = "RICCWCEE")
    protected RICCWCEERequest riccwceeRequest = new RICCWCEERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCEERequest
     *
     * @return rICCWCEERequest
     */
    public RICCWCEERequest getRICCWCEERequest() {
        return riccwceeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCEERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCEERequest(RICCWCEERequest value) {
        this.riccwceeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutUsinasRequest() {
        super();
    }
}
