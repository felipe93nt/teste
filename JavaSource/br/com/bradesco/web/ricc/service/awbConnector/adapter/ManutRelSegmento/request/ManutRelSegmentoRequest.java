/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSegmento.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelSegmento.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutRelSegmentoRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACI")
public class ManutRelSegmentoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcieRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWCIE")
    protected RICCWCIERequest riccwcieRequest = new RICCWCIERequest();

    /**
     * Propósito:  Retornar o valor de rICCWCIERequest
     *
     * @return rICCWCIERequest
     */
    public RICCWCIERequest getRICCWCIERequest() {
        return riccwcieRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCIERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCIERequest(RICCWCIERequest value) {
        this.riccwcieRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutRelSegmentoRequest() {
        super();
    }
}
