/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarPrevisaoLan.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarPrevisaoLanResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA3")
public class ConsultarPrevisaoLanResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa3SResponse
     */
    @CommareaBlock(layoutSize = 5300, layoutCode = "RICCWA3S")
    protected RICCWA3SResponse riccwa3SResponse = new RICCWA3SResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWA3SResponse
     *
     * @return rICCWA3SResponse
     */
    public RICCWA3SResponse getRICCWA3SResponse() {
        return riccwa3SResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWA3SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA3SResponse(RICCWA3SResponse value) {
        this.riccwa3SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarPrevisaoLanResponse() {
        super();
    }
}
