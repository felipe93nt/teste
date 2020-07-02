/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 14/12/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: CosultarEmpreLancadRequest 
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
public class CosultarEmpreLancadRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwazeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWAZE")
    protected RICCWAZERequest riccwazeRequest = new RICCWAZERequest();

    /**
     * Propósito:  Retornar o valor de rICCWAZERequest
     *
     * @return rICCWAZERequest
     */
    public RICCWAZERequest getRICCWAZERequest() {
        return riccwazeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWAZERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWAZERequest(RICCWAZERequest value) {
        this.riccwazeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public CosultarEmpreLancadRequest() {
        super();
    }
}
