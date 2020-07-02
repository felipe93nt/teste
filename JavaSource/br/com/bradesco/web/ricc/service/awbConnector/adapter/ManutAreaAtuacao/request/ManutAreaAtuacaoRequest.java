/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaAtuacao.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaAtuacao.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutAreaAtuacaoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACB")
public class ManutAreaAtuacaoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcbeRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWCBE")
    protected RICCWCBERequest riccwcbeRequest = new RICCWCBERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCBERequest
     *
     * @return rICCWCBERequest
     */
    public RICCWCBERequest getRICCWCBERequest() {
        return riccwcbeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCBERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCBERequest(RICCWCBERequest value) {
        this.riccwcbeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutAreaAtuacaoRequest() {
        super();
    }
}
