/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 01/07/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutBalancoEmpresaRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABM")
public class ManutBalancoEmpresaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbmeRequest
     */
    @CommareaBlock(layoutSize = 802, layoutCode = "RICCWBME")
    protected RICCWBMERequest riccwbmeRequest = new RICCWBMERequest();

    /**
     * Propósito:  Retornar o valor de rICCWBMERequest
     *
     * @return rICCWBMERequest
     */
    public RICCWBMERequest getRICCWBMERequest() {
        return riccwbmeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBMERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBMERequest(RICCWBMERequest value) {
        this.riccwbmeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutBalancoEmpresaRequest() {
        super();
    }
}
