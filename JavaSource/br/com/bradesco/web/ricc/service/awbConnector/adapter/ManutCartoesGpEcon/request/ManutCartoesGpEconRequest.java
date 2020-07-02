/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCartoesGpEcon.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCartoesGpEcon.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutCartoesGpEconRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABO")
public class ManutCartoesGpEconRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwboeRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBOE")
    protected RICCWBOERequest riccwboeRequest = new RICCWBOERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBOERequest
     *
     * @return rICCWBOERequest
     */
    public RICCWBOERequest getRICCWBOERequest() {
        return riccwboeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBOERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBOERequest(RICCWBOERequest value) {
        this.riccwboeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutCartoesGpEconRequest() {
        super();
    }
}
