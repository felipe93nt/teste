/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 21/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutRelTransporte.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutRelTransporteRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACL")
public class ManutRelTransporteRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcleRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWCLE")
    protected RICCWCLERequest riccwcleRequest = new RICCWCLERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCLERequest
     *
     * @return rICCWCLERequest
     */
    public RICCWCLERequest getRICCWCLERequest() {
        return riccwcleRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCLERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCLERequest(RICCWCLERequest value) {
        this.riccwcleRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutRelTransporteRequest() {
        super();
    }
}
