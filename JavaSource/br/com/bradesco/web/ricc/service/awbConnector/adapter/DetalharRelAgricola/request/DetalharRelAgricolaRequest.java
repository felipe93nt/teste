/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelAgricola.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelAgricolaRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABD")
public class DetalharRelAgricolaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbdeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWBDE")
    protected RICCWBDERequest riccwbdeRequest = new RICCWBDERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBDERequest
     *
     * @return rICCWBDERequest
     */
    public RICCWBDERequest getRICCWBDERequest() {
        return riccwbdeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBDERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBDERequest(RICCWBDERequest value) {
        this.riccwbdeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelAgricolaRequest() {
        super();
    }
}
