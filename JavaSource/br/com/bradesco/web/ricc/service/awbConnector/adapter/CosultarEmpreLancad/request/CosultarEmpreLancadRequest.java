/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 14/12/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CosultarEmpreLancad.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: CosultarEmpreLancadRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

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
     * Prop�sito:  Retornar o valor de rICCWAZERequest
     *
     * @return rICCWAZERequest
     */
    public RICCWAZERequest getRICCWAZERequest() {
        return riccwazeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWAZERequest
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
