/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroUso.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutQuadroUso.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutQuadroUsoRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB4")
public class ManutQuadroUsoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb4ERequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWB4E")
    protected RICCWB4ERequest riccwb4ERequest = new RICCWB4ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWB4ERequest
     *
     * @return rICCWB4ERequest
     */
    public RICCWB4ERequest getRICCWB4ERequest() {
        return riccwb4ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWB4ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB4ERequest(RICCWB4ERequest value) {
        this.riccwb4ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutQuadroUsoRequest() {
        super();
    }
}
