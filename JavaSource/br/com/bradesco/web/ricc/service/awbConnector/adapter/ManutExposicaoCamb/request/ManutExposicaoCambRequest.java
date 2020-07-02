/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutExposicaoCamb.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutExposicaoCambRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABN")
public class ManutExposicaoCambRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbneRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWBNE")
    protected RICCWBNERequest riccwbneRequest = new RICCWBNERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBNERequest
     *
     * @return rICCWBNERequest
     */
    public RICCWBNERequest getRICCWBNERequest() {
        return riccwbneRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBNERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBNERequest(RICCWBNERequest value) {
        this.riccwbneRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutExposicaoCambRequest() {
        super();
    }
}
