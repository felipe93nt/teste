/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 01/07/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarBalancoEmpRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de rICCWAFERequest
     *
     * @return rICCWAFERequest
     */
    public RICCWAFERequest getRICCWAFERequest() {
        return riccwafeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAFERequest
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
