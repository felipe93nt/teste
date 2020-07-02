/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 05/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarAreaProduto.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarAreaProdutoResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA5")
public class ConsultarAreaProdutoResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa5SResponse
     */
    @CommareaBlock(layoutSize = 9800, layoutCode = "RICCWA5S")
    protected RICCWA5SResponse riccwa5SResponse = new RICCWA5SResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWA5SResponse
     *
     * @return rICCWA5SResponse
     */
    public RICCWA5SResponse getRICCWA5SResponse() {
        return riccwa5SResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWA5SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA5SResponse(RICCWA5SResponse value) {
        this.riccwa5SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarAreaProdutoResponse() {
        super();
    }
}
