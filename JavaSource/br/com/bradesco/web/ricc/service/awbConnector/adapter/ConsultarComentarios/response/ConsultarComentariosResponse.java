/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarComentariosResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA9")
public class ConsultarComentariosResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwa9SResponse
     */
    @CommareaBlock(layoutSize = 20200, layoutCode = "RICCWA9S")
    protected RICCWA9SResponse riccwa9SResponse = new RICCWA9SResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWA9SResponse
     *
     * @return rICCWA9SResponse
     */
    public RICCWA9SResponse getRICCWA9SResponse() {
        return riccwa9SResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWA9SResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA9SResponse(RICCWA9SResponse value) {
        this.riccwa9SResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarComentariosResponse() {
        super();
    }
}
