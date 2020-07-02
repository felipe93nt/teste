/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutLocVeiculos.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutLocVeiculosRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB2")
public class ManutLocVeiculosRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb2ERequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWB2E")
    protected RICCWB2ERequest riccwb2ERequest = new RICCWB2ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWB2ERequest
     *
     * @return rICCWB2ERequest
     */
    public RICCWB2ERequest getRICCWB2ERequest() {
        return riccwb2ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWB2ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB2ERequest(RICCWB2ERequest value) {
        this.riccwb2ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutLocVeiculosRequest() {
        super();
    }
}
