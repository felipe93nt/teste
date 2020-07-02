/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAtivos.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroAtivos.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutQuadroAtivosRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABU")
public class ManutQuadroAtivosRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbueRequest
     */
    @CommareaBlock(layoutSize = 800, layoutCode = "RICCWBUE")
    protected RICCWBUERequest riccwbueRequest = new RICCWBUERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBUERequest
     *
     * @return rICCWBUERequest
     */
    public RICCWBUERequest getRICCWBUERequest() {
        return riccwbueRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBUERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBUERequest(RICCWBUERequest value) {
        this.riccwbueRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutQuadroAtivosRequest() {
        super();
    }
}
