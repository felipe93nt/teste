/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasAndamento.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutObrasAndamento.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutObrasAndamentoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB9")
public class ManutObrasAndamentoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb9ERequest
     */
    @CommareaBlock(layoutSize = 600, layoutCode = "RICCWB9E")
    protected RICCWB9ERequest riccwb9ERequest = new RICCWB9ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWB9ERequest
     *
     * @return rICCWB9ERequest
     */
    public RICCWB9ERequest getRICCWB9ERequest() {
        return riccwb9ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWB9ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB9ERequest(RICCWB9ERequest value) {
        this.riccwb9ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutObrasAndamentoRequest() {
        super();
    }
}
