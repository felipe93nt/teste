/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarEstruSociet.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarEstruSocietResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAY")
public class ConsultarEstruSocietResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwaysResponse
     */
    @CommareaBlock(layoutSize = 4400, layoutCode = "RICCWAYS")
    protected RICCWAYSResponse riccwaysResponse = new RICCWAYSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAYSResponse
     *
     * @return rICCWAYSResponse
     */
    public RICCWAYSResponse getRICCWAYSResponse() {
        return riccwaysResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAYSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAYSResponse(RICCWAYSResponse value) {
        this.riccwaysResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarEstruSocietResponse() {
        super();
    }
}
