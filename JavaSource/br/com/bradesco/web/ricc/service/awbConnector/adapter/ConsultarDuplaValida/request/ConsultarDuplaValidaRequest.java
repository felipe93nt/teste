/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarDuplaValida.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarDuplaValidaRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAH")
public class ConsultarDuplaValidaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaheRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAHE")
    protected RICCWAHERequest riccwaheRequest = new RICCWAHERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAHERequest
     *
     * @return rICCWAHERequest
     */
    public RICCWAHERequest getRICCWAHERequest() {
        return riccwaheRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAHERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAHERequest(RICCWAHERequest value) {
        this.riccwaheRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarDuplaValidaRequest() {
        super();
    }
}
