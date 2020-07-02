/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatConsolidado.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatConsolidado.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutFatConsolidadoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABR")
public class ManutFatConsolidadoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbreRequest
     */
    @CommareaBlock(layoutSize = 900, layoutCode = "RICCWBRE")
    protected RICCWBRERequest riccwbreRequest = new RICCWBRERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBRERequest
     *
     * @return rICCWBRERequest
     */
    public RICCWBRERequest getRICCWBRERequest() {
        return riccwbreRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBRERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBRERequest(RICCWBRERequest value) {
        this.riccwbreRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutFatConsolidadoRequest() {
        super();
    }
}
