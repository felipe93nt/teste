/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 26/06/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharParamRelat.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharParamRelatRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABB")
public class DetalharParamRelatRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbbeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWBBE")
    protected RICCWBBERequest riccwbbeRequest = new RICCWBBERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBBERequest
     *
     * @return rICCWBBERequest
     */
    public RICCWBBERequest getRICCWBBERequest() {
        return riccwbbeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBBERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBBERequest(RICCWBBERequest value) {
        this.riccwbbeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharParamRelatRequest() {
        super();
    }
}
