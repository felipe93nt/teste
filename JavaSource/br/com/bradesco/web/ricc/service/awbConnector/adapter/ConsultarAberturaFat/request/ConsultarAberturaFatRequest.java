/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 22/10/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAberturaFat.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarAberturaFatRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAE")
public class ConsultarAberturaFatRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaeeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAEE")
    protected RICCWAEERequest riccwaeeRequest = new RICCWAEERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAEERequest
     *
     * @return rICCWAEERequest
     */
    public RICCWAEERequest getRICCWAEERequest() {
        return riccwaeeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAEERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAEERequest(RICCWAEERequest value) {
        this.riccwaeeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarAberturaFatRequest() {
        super();
    }
}
