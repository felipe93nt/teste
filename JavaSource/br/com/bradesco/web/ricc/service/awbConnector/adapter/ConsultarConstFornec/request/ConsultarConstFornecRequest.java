/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 03/04/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarConstFornecRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAW")
public class ConsultarConstFornecRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwaweRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAWE")
    protected RICCWAWERequest riccwaweRequest = new RICCWAWERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWAWERequest
     *
     * @return rICCWAWERequest
     */
    public RICCWAWERequest getRICCWAWERequest() {
        return riccwaweRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAWERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAWERequest(RICCWAWERequest value) {
        this.riccwaweRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarConstFornecRequest() {
        super();
    }
}
