/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCustosOperacion.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCustosOperacion.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutCustosOperacionRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABX")
public class ManutCustosOperacionRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbxeRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBXE")
    protected RICCWBXERequest riccwbxeRequest = new RICCWBXERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBXERequest
     *
     * @return rICCWBXERequest
     */
    public RICCWBXERequest getRICCWBXERequest() {
        return riccwbxeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBXERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBXERequest(RICCWBXERequest value) {
        this.riccwbxeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutCustosOperacionRequest() {
        super();
    }
}
