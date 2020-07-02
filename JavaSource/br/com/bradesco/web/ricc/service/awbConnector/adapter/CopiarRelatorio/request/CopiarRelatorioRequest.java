/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.request 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 07/09/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.CopiarRelatorio.request;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.request.FrameworkHeaderRequest;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: CopiarRelatorioRequest 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIACO")
public class CopiarRelatorioRequest extends FrameworkHeaderRequest {

    /**
     * Atributo riccwcoeRequest
     */
    @CommareaBlock(layoutSize = 100, layoutCode = "RICCWCOE")
    protected RICCWCOERequest riccwcoeRequest = new RICCWCOERequest();

    /**
     * Prop�sito:  Retornar o valor de rICCWCOERequest
     *
     * @return rICCWCOERequest
     */
    public RICCWCOERequest getRICCWCOERequest() {
        return riccwcoeRequest;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWCOERequest
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWCOERequest(RICCWCOERequest value) {
        this.riccwcoeRequest = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public CopiarRelatorioRequest() {
        super();
    }
}
