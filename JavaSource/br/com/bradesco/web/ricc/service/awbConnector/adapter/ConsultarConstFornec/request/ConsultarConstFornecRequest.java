/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarConstFornecRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAW")
public class ConsultarConstFornecRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaweRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAWE")
    protected RICCWAWERequest riccwaweRequest = new RICCWAWERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAWERequest
     *
     * @return rICCWAWERequest
     */
    public RICCWAWERequest getRICCWAWERequest() {
        return riccwaweRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAWERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAWERequest(RICCWAWERequest value) {
        this.riccwaweRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarConstFornecRequest() {
        super();
    }
}
