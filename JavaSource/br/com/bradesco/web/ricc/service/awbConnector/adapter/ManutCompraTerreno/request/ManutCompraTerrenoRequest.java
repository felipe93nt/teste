/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutCompraTerrenoRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB7")
public class ManutCompraTerrenoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb7ERequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWB7E")
    protected RICCWB7ERequest riccwb7ERequest = new RICCWB7ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWB7ERequest
     *
     * @return rICCWB7ERequest
     */
    public RICCWB7ERequest getRICCWB7ERequest() {
        return riccwb7ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWB7ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB7ERequest(RICCWB7ERequest value) {
        this.riccwb7ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutCompraTerrenoRequest() {
        super();
    }
}
