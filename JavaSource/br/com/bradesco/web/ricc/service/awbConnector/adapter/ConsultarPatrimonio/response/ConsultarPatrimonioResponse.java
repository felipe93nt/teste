/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 05/09/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarPatrimonioResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAC")
public class ConsultarPatrimonioResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwacsResponse
     */
    @CommareaBlock(layoutSize = 3000, layoutCode = "RICCWACS")
    protected RICCWACSResponse riccwacsResponse = new RICCWACSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWACSResponse
     *
     * @return rICCWACSResponse
     */
    public RICCWACSResponse getRICCWACSResponse() {
        return riccwacsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWACSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWACSResponse(RICCWACSResponse value) {
        this.riccwacsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarPatrimonioResponse() {
        super();
    }
}
