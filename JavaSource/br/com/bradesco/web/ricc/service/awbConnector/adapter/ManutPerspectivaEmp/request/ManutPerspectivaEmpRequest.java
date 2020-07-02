/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPerspectivaEmp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutPerspectivaEmpRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

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
     * Propósito:  Retornar o valor de rICCWBPERequest
     *
     * @return rICCWBPERequest
     */
    public RICCWBPERequest getRICCWBPERequest() {
        return riccwbpeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBPERequest
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
