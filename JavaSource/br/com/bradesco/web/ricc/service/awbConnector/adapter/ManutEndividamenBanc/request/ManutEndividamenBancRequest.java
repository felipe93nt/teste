/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEndividamenBanc.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEndividamenBanc.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutEndividamenBancRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABS")
public class ManutEndividamenBancRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbseRequest
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWBSE")
    protected RICCWBSERequest riccwbseRequest = new RICCWBSERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBSERequest
     *
     * @return rICCWBSERequest
     */
    public RICCWBSERequest getRICCWBSERequest() {
        return riccwbseRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBSERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBSERequest(RICCWBSERequest value) {
        this.riccwbseRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutEndividamenBancRequest() {
        super();
    }
}
