/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarComentarios.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarComentariosRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAA9")
public class ConsultarComentariosRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwa9ERequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWA9E")
    protected RICCWA9ERequest riccwa9ERequest = new RICCWA9ERequest();

    /**
     * Propósito:  Retornar o valor de rICCWA9ERequest
     *
     * @return rICCWA9ERequest
     */
    public RICCWA9ERequest getRICCWA9ERequest() {
        return riccwa9ERequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWA9ERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWA9ERequest(RICCWA9ERequest value) {
        this.riccwa9ERequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarComentariosRequest() {
        super();
    }
}
