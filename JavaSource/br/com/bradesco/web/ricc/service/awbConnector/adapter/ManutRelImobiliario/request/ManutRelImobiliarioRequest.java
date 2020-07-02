/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelImobiliario.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutRelImobiliarioRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACK")
public class ManutRelImobiliarioRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwckeRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWCKE")
    protected RICCWCKERequest riccwckeRequest = new RICCWCKERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCKERequest
     *
     * @return rICCWCKERequest
     */
    public RICCWCKERequest getRICCWCKERequest() {
        return riccwckeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCKERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCKERequest(RICCWCKERequest value) {
        this.riccwckeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutRelImobiliarioRequest() {
        super();
    }
}
