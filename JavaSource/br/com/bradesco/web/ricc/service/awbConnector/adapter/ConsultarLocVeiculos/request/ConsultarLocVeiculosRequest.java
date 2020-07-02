/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarLocVeiculos.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarLocVeiculosRequest 
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
public class ConsultarLocVeiculosRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaveRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAVE")
    protected RICCWAVERequest riccwaveRequest = new RICCWAVERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAVERequest
     *
     * @return rICCWAVERequest
     */
    public RICCWAVERequest getRICCWAVERequest() {
        return riccwaveRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAVERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAVERequest(RICCWAVERequest value) {
        this.riccwaveRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarLocVeiculosRequest() {
        super();
    }
}
