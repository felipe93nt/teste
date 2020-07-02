/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 25/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutProducaoUsinasRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACF")
public class ManutProducaoUsinasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcfeRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWCFE")
    protected RICCWCFERequest riccwcfeRequest = new RICCWCFERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCFERequest
     *
     * @return rICCWCFERequest
     */
    public RICCWCFERequest getRICCWCFERequest() {
        return riccwcfeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCFERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCFERequest(RICCWCFERequest value) {
        this.riccwcfeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutProducaoUsinasRequest() {
        super();
    }
}
