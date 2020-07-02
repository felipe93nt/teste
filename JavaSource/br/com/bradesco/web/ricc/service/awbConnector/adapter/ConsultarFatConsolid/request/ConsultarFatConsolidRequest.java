/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatConsolid.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarFatConsolidRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAK")
public class ConsultarFatConsolidRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwakeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAKE")
    protected RICCWAKERequest riccwakeRequest = new RICCWAKERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAKERequest
     *
     * @return rICCWAKERequest
     */
    public RICCWAKERequest getRICCWAKERequest() {
        return riccwakeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAKERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAKERequest(RICCWAKERequest value) {
        this.riccwakeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarFatConsolidRequest() {
        super();
    }
}
