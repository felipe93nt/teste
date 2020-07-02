/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: CosultarEmpreLancadResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAZ")
public class CosultarEmpreLancadResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwazsResponse
     */
    @CommareaBlock(layoutSize = 2100, layoutCode = "RICCWAZS")
    protected RICCWAZSResponse riccwazsResponse = new RICCWAZSResponse();

    /**
     * Propósito:  Retornar o valor de rICCWAZSResponse
     *
     * @return rICCWAZSResponse
     */
    public RICCWAZSResponse getRICCWAZSResponse() {
        return riccwazsResponse;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAZSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAZSResponse(RICCWAZSResponse value) {
        this.riccwazsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public CosultarEmpreLancadResponse() {
        super();
    }
}
