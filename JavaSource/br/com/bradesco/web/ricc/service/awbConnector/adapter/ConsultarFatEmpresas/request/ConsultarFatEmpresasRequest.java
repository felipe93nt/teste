/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarFatEmpresasRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAR")
public class ConsultarFatEmpresasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwareRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWARE")
    protected RICCWARERequest riccwareRequest = new RICCWARERequest();

    /**
     * Propósito:  Retornar o valor de rICCWARERequest
     *
     * @return rICCWARERequest
     */
    public RICCWARERequest getRICCWARERequest() {
        return riccwareRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWARERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWARERequest(RICCWARERequest value) {
        this.riccwareRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarFatEmpresasRequest() {
        super();
    }
}
