/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 26/06/2019 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutParamRelatorio.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ManutParamRelatorioRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACN")
public class ManutParamRelatorioRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcneRequest
     */
    @CommareaBlock(layoutSize = 200, layoutCode = "RICCWCNE")
    protected RICCWCNERequest riccwcneRequest = new RICCWCNERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCNERequest
     *
     * @return rICCWCNERequest
     */
    public RICCWCNERequest getRICCWCNERequest() {
        return riccwcneRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCNERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCNERequest(RICCWCNERequest value) {
        this.riccwcneRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ManutParamRelatorioRequest() {
        super();
    }
}
