/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutDuplaValidacao.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 04/01/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutDuplaValidacao.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutDuplaValidacaoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABO")
public class ManutDuplaValidacaoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwboeRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWBOE")
    protected RICCWBOERequest riccwboeRequest = new RICCWBOERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBOERequest
     *
     * @return rICCWBOERequest
     */
    public RICCWBOERequest getRICCWBOERequest() {
        return riccwboeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBOERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBOERequest(RICCWBOERequest value) {
        this.riccwboeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutDuplaValidacaoRequest() {
        super();
    }
}
