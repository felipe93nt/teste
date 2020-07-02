/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutPerspectivaEmpRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABP")
public class ManutPerspectivaEmpRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbpeRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBPE")
    protected RICCWBPERequest riccwbpeRequest = new RICCWBPERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBPERequest
     *
     * @return rICCWBPERequest
     */
    public RICCWBPERequest getRICCWBPERequest() {
        return riccwbpeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBPERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBPERequest(RICCWBPERequest value) {
        this.riccwbpeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutPerspectivaEmpRequest() {
        super();
    }
}
