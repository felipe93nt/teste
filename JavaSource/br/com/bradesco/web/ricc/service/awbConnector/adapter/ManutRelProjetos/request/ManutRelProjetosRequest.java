/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelProjetos.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutRelProjetosRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACM")
public class ManutRelProjetosRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcmeRequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWCME")
    protected RICCWCMERequest riccwcmeRequest = new RICCWCMERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCMERequest
     *
     * @return rICCWCMERequest
     */
    public RICCWCMERequest getRICCWCMERequest() {
        return riccwcmeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCMERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCMERequest(RICCWCMERequest value) {
        this.riccwcmeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutRelProjetosRequest() {
        super();
    }
}
