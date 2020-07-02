/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaAtuacao.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarAreaAtuacaoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA4")
public class ConsultarAreaAtuacaoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa4ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA4E")
    protected RICCWA4ERequest riccwa4ERequest = new RICCWA4ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWA4ERequest
     *
     * @return rICCWA4ERequest
     */
    public RICCWA4ERequest getRICCWA4ERequest() {
        return riccwa4ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWA4ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA4ERequest(RICCWA4ERequest value) {
        this.riccwa4ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarAreaAtuacaoRequest() {
        super();
    }
}
