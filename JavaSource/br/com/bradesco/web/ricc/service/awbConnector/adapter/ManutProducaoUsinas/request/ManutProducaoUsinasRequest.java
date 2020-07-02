/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 25/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutProducaoUsinas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutProducaoUsinasRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACF")
public class ManutProducaoUsinasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcfeRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWCFE")
    protected RICCWCFERequest riccwcfeRequest = new RICCWCFERequest();

    /**
     * Propósito:  Retornar o valor de rICCWCFERequest
     *
     * @return rICCWCFERequest
     */
    public RICCWCFERequest getRICCWCFERequest() {
        return riccwcfeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCFERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCFERequest(RICCWCFERequest value) {
        this.riccwcfeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutProducaoUsinasRequest() {
        super();
    }
}
