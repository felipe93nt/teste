/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAdmin.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAdmin.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutQuadroAdminRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABI")
public class ManutQuadroAdminRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbieRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBIE")
    protected RICCWBIERequest riccwbieRequest = new RICCWBIERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBIERequest
     *
     * @return rICCWBIERequest
     */
    public RICCWBIERequest getRICCWBIERequest() {
        return riccwbieRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBIERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBIERequest(RICCWBIERequest value) {
        this.riccwbieRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutQuadroAdminRequest() {
        super();
    }
}
