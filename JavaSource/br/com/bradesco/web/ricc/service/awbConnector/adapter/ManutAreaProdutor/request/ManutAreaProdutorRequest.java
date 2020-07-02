/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutAreaProdutor.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutAreaProdutorRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACC")
public class ManutAreaProdutorRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcceRequest
     */
    @CommareaBlock(layoutSize = 400, layoutCode = "RICCWCCE")
    protected RICCWCCERequest riccwcceRequest = new RICCWCCERequest();

    /**
     * Propósito:  Retornar o valor de rICCWCCERequest
     *
     * @return rICCWCCERequest
     */
    public RICCWCCERequest getRICCWCCERequest() {
        return riccwcceRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCCERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCCERequest(RICCWCCERequest value) {
        this.riccwcceRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutAreaProdutorRequest() {
        super();
    }
}
