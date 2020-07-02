/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutFatEmpresaRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABY")
public class ManutFatEmpresaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbyeRequest
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWBYE")
    protected RICCWBYERequest riccwbyeRequest = new RICCWBYERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBYERequest
     *
     * @return rICCWBYERequest
     */
    public RICCWBYERequest getRICCWBYERequest() {
        return riccwbyeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBYERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBYERequest(RICCWBYERequest value) {
        this.riccwbyeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutFatEmpresaRequest() {
        super();
    }
}
