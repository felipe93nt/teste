/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutTranspPassas.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutTranspPassasRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB0")
public class ManutTranspPassasRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb0ERequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWB0E")
    protected RICCWB0ERequest riccwb0ERequest = new RICCWB0ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWB0ERequest
     *
     * @return rICCWB0ERequest
     */
    public RICCWB0ERequest getRICCWB0ERequest() {
        return riccwb0ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWB0ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB0ERequest(RICCWB0ERequest value) {
        this.riccwb0ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutTranspPassasRequest() {
        super();
    }
}
