/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 03/04/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarConstFornec.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarConstFornecResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAW")
public class ConsultarConstFornecResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwawsResponse
     */
    @CommareaBlock(layoutSize = 2200, layoutCode = "RICCWAWS")
    protected RICCWAWSResponse riccwawsResponse = new RICCWAWSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAWSResponse
     *
     * @return rICCWAWSResponse
     */
    public RICCWAWSResponse getRICCWAWSResponse() {
        return riccwawsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAWSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAWSResponse(RICCWAWSResponse value) {
        this.riccwawsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarConstFornecResponse() {
        super();
    }
}
