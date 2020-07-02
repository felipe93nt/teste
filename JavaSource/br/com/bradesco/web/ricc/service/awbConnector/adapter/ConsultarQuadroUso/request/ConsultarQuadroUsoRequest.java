/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 03/04/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarQuadroUso.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarQuadroUsoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAX")
public class ConsultarQuadroUsoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaxeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAXE")
    protected RICCWAXERequest riccwaxeRequest = new RICCWAXERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAXERequest
     *
     * @return rICCWAXERequest
     */
    public RICCWAXERequest getRICCWAXERequest() {
        return riccwaxeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAXERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAXERequest(RICCWAXERequest value) {
        this.riccwaxeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarQuadroUsoRequest() {
        super();
    }
}
