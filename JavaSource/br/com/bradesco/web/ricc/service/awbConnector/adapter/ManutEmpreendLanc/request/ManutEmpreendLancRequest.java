/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEmpreendLanc.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 10/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEmpreendLanc.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutEmpreendLancRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB6")
public class ManutEmpreendLancRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb6ERequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWB6E")
    protected RICCWB6ERequest riccwb6ERequest = new RICCWB6ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWB6ERequest
     *
     * @return rICCWB6ERequest
     */
    public RICCWB6ERequest getRICCWB6ERequest() {
        return riccwb6ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWB6ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB6ERequest(RICCWB6ERequest value) {
        this.riccwb6ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutEmpreendLancRequest() {
        super();
    }
}
