/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutencaoRIC.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutencaoRICRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABH")
public class ManutencaoRICRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbheRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBHE")
    protected RICCWBHERequest riccwbheRequest = new RICCWBHERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBHERequest
     *
     * @return rICCWBHERequest
     */
    public RICCWBHERequest getRICCWBHERequest() {
        return riccwbheRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBHERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBHERequest(RICCWBHERequest value) {
        this.riccwbheRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutencaoRICRequest() {
        super();
    }
}
