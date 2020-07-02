/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 26/06/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutParamRelatorioRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACN")
public class ManutParamRelatorioRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcneRequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWCNE")
    protected RICCWCNERequest riccwcneRequest = new RICCWCNERequest();

    /**
     * Propósito:  Retornar o valor de rICCWCNERequest
     *
     * @return rICCWCNERequest
     */
    public RICCWCNERequest getRICCWCNERequest() {
        return riccwcneRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCNERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCNERequest(RICCWCNERequest value) {
        this.riccwcneRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutParamRelatorioRequest() {
        super();
    }
}
