/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAberturaFat.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 23/10/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAberturaFat.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutAberturaFatRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABL")
public class ManutAberturaFatRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbleRequest
     */
    @CommareaBlock(layoutSize = 600, layoutCode = "RICCWBLE")
    protected RICCWBLERequest riccwbleRequest = new RICCWBLERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBLERequest
     *
     * @return rICCWBLERequest
     */
    public RICCWBLERequest getRICCWBLERequest() {
        return riccwbleRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBLERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBLERequest(RICCWBLERequest value) {
        this.riccwbleRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutAberturaFatRequest() {
        super();
    }
}
