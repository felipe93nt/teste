/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEstruturaSocie.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutEstruturaSocie.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutEstruturaSocieRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB5")
public class ManutEstruturaSocieRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb5ERequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWB5E")
    protected RICCWB5ERequest riccwb5ERequest = new RICCWB5ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWB5ERequest
     *
     * @return rICCWB5ERequest
     */
    public RICCWB5ERequest getRICCWB5ERequest() {
        return riccwb5ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWB5ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB5ERequest(RICCWB5ERequest value) {
        this.riccwb5ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutEstruturaSocieRequest() {
        super();
    }
}
