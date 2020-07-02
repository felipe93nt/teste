/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutCompraTerreno.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutCompraTerrenoRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAB7")
public class ManutCompraTerrenoRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwb7ERequest
     */
    @CommareaBlock(layoutSize = 300, layoutCode = "RICCWB7E")
    protected RICCWB7ERequest riccwb7ERequest = new RICCWB7ERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWB7ERequest
     *
     * @return rICCWB7ERequest
     */
    public RICCWB7ERequest getRICCWB7ERequest() {
        return riccwb7ERequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWB7ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWB7ERequest(RICCWB7ERequest value) {
        this.riccwb7ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutCompraTerrenoRequest() {
        super();
    }
}
