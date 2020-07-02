/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.DetalharRelProjetos.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: DetalharRelProjetosResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABG")
public class DetalharRelProjetosResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwbgsResponse
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWBGS")
    protected RICCWBGSResponse riccwbgsResponse = new RICCWBGSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWBGSResponse
     *
     * @return rICCWBGSResponse
     */
    public RICCWBGSResponse getRICCWBGSResponse() {
        return riccwbgsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWBGSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBGSResponse(RICCWBGSResponse value) {
        this.riccwbgsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public DetalharRelProjetosResponse() {
        super();
    }
}
