/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutClienteFornec.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutClienteFornec.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutClienteFornecRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABV")
public class ManutClienteFornecRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbveRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBVE")
    protected RICCWBVERequest riccwbveRequest = new RICCWBVERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBVERequest
     *
     * @return rICCWBVERequest
     */
    public RICCWBVERequest getRICCWBVERequest() {
        return riccwbveRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBVERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBVERequest(RICCWBVERequest value) {
        this.riccwbveRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutClienteFornecRequest() {
        super();
    }
}
