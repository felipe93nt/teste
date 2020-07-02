/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroAtivo.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarQuadroAtivoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAN")
public class ConsultarQuadroAtivoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaneRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWANE")
    protected RICCWANERequest riccwaneRequest = new RICCWANERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWANERequest
     *
     * @return rICCWANERequest
     */
    public RICCWANERequest getRICCWANERequest() {
        return riccwaneRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWANERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWANERequest(RICCWANERequest value) {
        this.riccwaneRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarQuadroAtivoRequest() {
        super();
    }
}
