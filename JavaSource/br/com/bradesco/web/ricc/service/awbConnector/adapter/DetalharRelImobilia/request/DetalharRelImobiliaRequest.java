/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelImobilia.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelImobiliaRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABE")
public class DetalharRelImobiliaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbeeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWBEE")
    protected RICCWBEERequest riccwbeeRequest = new RICCWBEERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBEERequest
     *
     * @return rICCWBEERequest
     */
    public RICCWBEERequest getRICCWBEERequest() {
        return riccwbeeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBEERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBEERequest(RICCWBEERequest value) {
        this.riccwbeeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelImobiliaRequest() {
        super();
    }
}
