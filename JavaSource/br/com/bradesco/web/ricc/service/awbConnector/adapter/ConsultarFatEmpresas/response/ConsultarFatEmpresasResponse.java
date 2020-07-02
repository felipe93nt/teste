/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.response 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Data da Cria��o: 27/08/2018 
 * Compilador: 1.5 
 * Par�metros de Compila��o: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ConsultarFatEmpresas.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;

/**
 * Nome: ConsultarFatEmpresasResponse 
 * Prop�sito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compila��o: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIAAR")
public class ConsultarFatEmpresasResponse extends FrameworkHeaderResponse {

    /**
     * Atributo riccwarsResponse
     */
    @CommareaBlock(layoutSize = 500, layoutCode = "RICCWARS")
    protected RICCWARSResponse riccwarsResponse = new RICCWARSResponse();

    /**
     * Prop�sito:  Retornar o valor de rICCWARSResponse
     *
     * @return rICCWARSResponse
     */
    public RICCWARSResponse getRICCWARSResponse() {
        return riccwarsResponse;
    }

    /**
     * Prop�sito:  Atribuir valor ao rICCWARSResponse
     *
     * @param value novo valor a ser atribuido para o campo 
     */
    public void setRICCWARSResponse(RICCWARSResponse value) {
        this.riccwarsResponse = value;
    }

    /**
     * Construtor Padrao
     * @see
     */
    public ConsultarFatEmpresasResponse() {
        super();
    }
}
