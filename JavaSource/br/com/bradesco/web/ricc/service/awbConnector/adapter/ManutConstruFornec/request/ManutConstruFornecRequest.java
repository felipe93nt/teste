/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutConstruFornec.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutConstruFornec.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutConstruFornecRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB3")
public class ManutConstruFornecRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb3ERequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWB3E")
    protected RICCWB3ERequest riccwb3ERequest = new RICCWB3ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWB3ERequest
     *
     * @return rICCWB3ERequest
     */
    public RICCWB3ERequest getRICCWB3ERequest() {
        return riccwb3ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWB3ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB3ERequest(RICCWB3ERequest value) {
        this.riccwb3ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutConstruFornecRequest() {
        super();
    }
}
