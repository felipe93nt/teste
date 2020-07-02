/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarExposicao.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarExposicaoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAG")
public class ConsultarExposicaoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwageRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAGE")
    protected RICCWAGERequest riccwageRequest = new RICCWAGERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAGERequest
     *
     * @return rICCWAGERequest
     */
    public RICCWAGERequest getRICCWAGERequest() {
        return riccwageRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAGERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAGERequest(RICCWAGERequest value) {
        this.riccwageRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarExposicaoRequest() {
        super();
    }
}
