/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarLocVeiculosResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAV")
public class ConsultarLocVeiculosResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwavsResponse
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWAVS")
    protected RICCWAVSResponse riccwavsResponse = new RICCWAVSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWAVSResponse
     *
     * @return rICCWAVSResponse
     */
    public RICCWAVSResponse getRICCWAVSResponse() {
        return riccwavsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAVSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAVSResponse(RICCWAVSResponse value) {
        this.riccwavsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarLocVeiculosResponse() {
        super();
    }
}
