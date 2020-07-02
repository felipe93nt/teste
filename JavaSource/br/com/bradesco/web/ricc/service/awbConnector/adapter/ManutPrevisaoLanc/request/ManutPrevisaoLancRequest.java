/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPrevisaoLanc.request 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 27/08/2018 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutPrevisaoLanc.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutPrevisaoLancRequest 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACA")
public class ManutPrevisaoLancRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcaeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWCAE")
    protected RICCWCAERequest riccwcaeRequest = new RICCWCAERequest();

    /**
     * Propósito:  Retornar o valor de rICCWCAERequest
     *
     * @return rICCWCAERequest
     */
    public RICCWCAERequest getRICCWCAERequest() {
        return riccwcaeRequest;
    }

    /**
     * Propósito:  Atribuir valor ao rICCWCAERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCAERequest(RICCWCAERequest value) {
        this.riccwcaeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutPrevisaoLancRequest() {
        super();
    }
}
