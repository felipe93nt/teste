/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutAreaProdutorRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACC")
public class ManutAreaProdutorRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcceRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWCCE")
    protected RICCWCCERequest riccwcceRequest = new RICCWCCERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCCERequest
     *
     * @return rICCWCCERequest
     */
    public RICCWCCERequest getRICCWCCERequest() {
        return riccwcceRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCCERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCCERequest(RICCWCCERequest value) {
        this.riccwcceRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutAreaProdutorRequest() {
        super();
    }
}
