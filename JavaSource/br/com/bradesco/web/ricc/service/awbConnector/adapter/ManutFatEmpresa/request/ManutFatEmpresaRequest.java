/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 14/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutFatEmpresa.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutFatEmpresaRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABY")
public class ManutFatEmpresaRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwbyeRequest
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWBYE")
    protected RICCWBYERequest riccwbyeRequest = new RICCWBYERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWBYERequest
     *
     * @return rICCWBYERequest
     */
    public RICCWBYERequest getRICCWBYERequest() {
        return riccwbyeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWBYERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWBYERequest(RICCWBYERequest value) {
        this.riccwbyeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutFatEmpresaRequest() {
        super();
    }
}
