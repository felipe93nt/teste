/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 01/07/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarBalancoEmpRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAF")
public class ConsultarBalancoEmpRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwafeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAFE")
    protected RICCWAFERequest riccwafeRequest = new RICCWAFERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAFERequest
     *
     * @return rICCWAFERequest
     */
    public RICCWAFERequest getRICCWAFERequest() {
        return riccwafeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAFERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAFERequest(RICCWAFERequest value) {
        this.riccwafeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarBalancoEmpRequest() {
        super();
    }
}
