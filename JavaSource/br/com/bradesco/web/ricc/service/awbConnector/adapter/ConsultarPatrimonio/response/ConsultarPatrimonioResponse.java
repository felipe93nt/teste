/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 05/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPatrimonio.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarPatrimonioResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de rICCWACSResponse
     *
     * @return rICCWACSResponse
     */
    public RICCWACSResponse getRICCWACSResponse() {
        return riccwacsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWACSResponse
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
