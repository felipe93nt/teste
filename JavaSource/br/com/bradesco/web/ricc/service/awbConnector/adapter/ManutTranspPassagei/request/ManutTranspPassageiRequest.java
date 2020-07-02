/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassagei.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassagei.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutTranspPassageiRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB1")
public class ManutTranspPassageiRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb1ERequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWB1E")
    protected RICCWB1ERequest riccwb1ERequest = new RICCWB1ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWB1ERequest
     *
     * @return rICCWB1ERequest
     */
    public RICCWB1ERequest getRICCWB1ERequest() {
        return riccwb1ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWB1ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB1ERequest(RICCWB1ERequest value) {
        this.riccwb1ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutTranspPassageiRequest() {
        super();
    }
}
