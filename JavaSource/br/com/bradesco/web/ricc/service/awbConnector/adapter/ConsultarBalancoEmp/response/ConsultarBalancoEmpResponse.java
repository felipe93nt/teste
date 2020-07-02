/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 01/07/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarBalancoEmp.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarBalancoEmpResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAF")
public class ConsultarBalancoEmpResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwafsResponse
     */
    @CommareaBlock(layoutSize = 802, layoutCode = "RICCWAFS")
    protected RICCWAFSResponse riccwafsResponse = new RICCWAFSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAFSResponse
     *
     * @return rICCWAFSResponse
     */
    public RICCWAFSResponse getRICCWAFSResponse() {
        return riccwafsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAFSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAFSResponse(RICCWAFSResponse value) {
        this.riccwafsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarBalancoEmpResponse() {
        super();
    }
}
