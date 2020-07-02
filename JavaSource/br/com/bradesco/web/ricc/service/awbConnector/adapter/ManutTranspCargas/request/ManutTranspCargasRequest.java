/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspCargas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspCargas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutTranspCargasRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABW")
public class ManutTranspCargasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbweRequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWBWE")
    protected RICCWBWERequest riccwbweRequest = new RICCWBWERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBWERequest
     *
     * @return rICCWBWERequest
     */
    public RICCWBWERequest getRICCWBWERequest() {
        return riccwbweRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBWERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBWERequest(RICCWBWERequest value) {
        this.riccwbweRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutTranspCargasRequest() {
        super();
    }
}
