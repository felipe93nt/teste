/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelAgricolaResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de rICCWBDSResponse
     *
     * @return rICCWBDSResponse
     */
    public RICCWBDSResponse getRICCWBDSResponse() {
        return riccwbdsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBDSResponse
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
