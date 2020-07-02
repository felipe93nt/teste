/**
 * Nome: br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.response 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Data da Criação: 01/07/2019 
 * Compilador: 1.5 
 * Parâmetros de Compilação: -d 
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.ManutBalancoEmpresa.response;

import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;

/**
 * Nome: ManutBalancoEmpresaResponse 
 * Propósito: Classe gerada automaticamente a partir de um xsd
 * Equipe: Projetos Estruturais 
 * Parametro de compilação: -d. 

 * @author Capgemini
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 */
@TransactionDescriptor(connector = "CWS", name="RICCIABM")
public class ManutBalancoEmpresaResponse extends FrameworkHeaderResponse {

    /**
     * Construtor Padrao
     * @see
     */
    public ManutBalancoEmpresaResponse() {
        super();
    }
}
