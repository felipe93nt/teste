/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelAgricolaResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABD")
public class DetalharRelAgricolaResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwbdsResponse
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWBDS")
    protected RICCWBDSResponse riccwbdsResponse = new RICCWBDSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWBDSResponse
     *
     * @return rICCWBDSResponse
     */
    public RICCWBDSResponse getRICCWBDSResponse() {
        return riccwbdsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBDSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBDSResponse(RICCWBDSResponse value) {
        this.riccwbdsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelAgricolaResponse() {
        super();
    }
}
