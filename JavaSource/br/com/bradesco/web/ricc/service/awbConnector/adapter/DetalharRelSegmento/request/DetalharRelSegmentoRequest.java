/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelSegmento.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelSegmentoRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABC")
public class DetalharRelSegmentoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbceRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWBCE")
    protected RICCWBCERequest riccwbceRequest = new RICCWBCERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBCERequest
     *
     * @return rICCWBCERequest
     */
    public RICCWBCERequest getRICCWBCERequest() {
        return riccwbceRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBCERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBCERequest(RICCWBCERequest value) {
        this.riccwbceRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelSegmentoRequest() {
        super();
    }
}
