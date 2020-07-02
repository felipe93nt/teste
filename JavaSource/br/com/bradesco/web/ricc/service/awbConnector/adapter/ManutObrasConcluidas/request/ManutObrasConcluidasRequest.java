/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasConcluidas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutObrasConcluidasRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB8")
public class ManutObrasConcluidasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb8ERequest
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWB8E")
    protected RICCWB8ERequest riccwb8ERequest = new RICCWB8ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWB8ERequest
     *
     * @return rICCWB8ERequest
     */
    public RICCWB8ERequest getRICCWB8ERequest() {
        return riccwb8ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWB8ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB8ERequest(RICCWB8ERequest value) {
        this.riccwb8ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutObrasConcluidasRequest() {
        super();
    }
}
