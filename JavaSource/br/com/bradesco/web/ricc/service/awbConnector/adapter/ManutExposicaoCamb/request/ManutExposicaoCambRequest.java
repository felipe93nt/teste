/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutExposicaoCambRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABN")
public class ManutExposicaoCambRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbneRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWBNE")
    protected RICCWBNERequest riccwbneRequest = new RICCWBNERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBNERequest
     *
     * @return rICCWBNERequest
     */
    public RICCWBNERequest getRICCWBNERequest() {
        return riccwbneRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBNERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBNERequest(RICCWBNERequest value) {
        this.riccwbneRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutExposicaoCambRequest() {
        super();
    }
}
