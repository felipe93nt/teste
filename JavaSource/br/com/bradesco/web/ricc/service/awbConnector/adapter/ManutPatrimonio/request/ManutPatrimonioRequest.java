/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPatrimonio.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPatrimonio.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutPatrimonioRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABJ")
public class ManutPatrimonioRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbjeRequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWBJE")
    protected RICCWBJERequest riccwbjeRequest = new RICCWBJERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBJERequest
     *
     * @return rICCWBJERequest
     */
    public RICCWBJERequest getRICCWBJERequest() {
        return riccwbjeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBJERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBJERequest(RICCWBJERequest value) {
        this.riccwbjeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutPatrimonioRequest() {
        super();
    }
}
