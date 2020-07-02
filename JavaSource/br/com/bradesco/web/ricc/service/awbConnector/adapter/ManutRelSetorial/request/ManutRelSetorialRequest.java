/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSetorial.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSetorial.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutRelSetorialRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACH")
public class ManutRelSetorialRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcheRequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWCHE")
    protected RICCWCHERequest riccwcheRequest = new RICCWCHERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCHERequest
     *
     * @return rICCWCHERequest
     */
    public RICCWCHERequest getRICCWCHERequest() {
        return riccwcheRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCHERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCHERequest(RICCWCHERequest value) {
        this.riccwcheRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutRelSetorialRequest() {
        super();
    }
}
