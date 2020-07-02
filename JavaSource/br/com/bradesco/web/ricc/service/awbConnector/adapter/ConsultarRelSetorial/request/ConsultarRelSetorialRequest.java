/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarRelSetorial.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarRelSetorialRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABA")
public class ConsultarRelSetorialRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbaeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWBAE")
    protected RICCWBAERequest riccwbaeRequest = new RICCWBAERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBAERequest
     *
     * @return rICCWBAERequest
     */
    public RICCWBAERequest getRICCWBAERequest() {
        return riccwbaeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBAERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBAERequest(RICCWBAERequest value) {
        this.riccwbaeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarRelSetorialRequest() {
        super();
    }
}
