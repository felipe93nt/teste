/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 14/11/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarCapacidade.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarCapacidadeResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAD")
public class ConsultarCapacidadeResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwadsResponse
     */
    @CommareaBlock(layoutSize = 3300, layoutCode = "RICCWADS")
    protected RICCWADSResponse riccwadsResponse = new RICCWADSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWADSResponse
     *
     * @return rICCWADSResponse
     */
    public RICCWADSResponse getRICCWADSResponse() {
        return riccwadsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWADSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWADSResponse(RICCWADSResponse value) {
        this.riccwadsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarCapacidadeResponse() {
        super();
    }
}
