/**
 * Nome: br.com.bradesco.web.piloto.service.awbConnector.adapter.logon
 *
 * Propósito: Classes de uso comum para a funcionalidade
 *
 * Data da Criação: 17/02/2011
 *
 * Compilador: 1.5.0_11
 * Parâmetros de Compilação: -d
 *
 */
package br.com.bradesco.web.ricc.service.awbConnector.adapter.logon;

import br.com.bradesco.data.connector.commarea.annotations.legacy.Legacy;
import br.com.bradesco.data.connector.commarea.annotations.transaction.TransactionDescriptor;
import br.com.bradesco.data.connector.commarea.annotations.types.CommareaBlock;
import br.com.bradesco.data.connector.header.response.FrameworkHeaderResponse;

/**
 * Nome: LogonResponse
 * Propósito: Classe pai response do adapter Logon
 * Equipe: AWB Conectores
 * Parametro de compilação: -d.
 *
 * @author william.santos CPM Braxis Copyright (c) 2011
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 * <p>Registro de Manutenção:
 * <li>Data : </li>
 * <li>Autor: </li>
 * <li>Responsável: </li>
 * </p>
 */
@SuppressWarnings("deprecation")
@Legacy
@TransactionDescriptor(connector = "CWS", name="GSEGGLAF")
public class LogonResponse extends FrameworkHeaderResponse {

	@CommareaBlock(layoutSize = 270, layoutCode = "GSEGGLAF")
	private GSEGGLAFResponse gsegglafResponse = null;

	/**
	 * Nome: getGsegglafResponse
	 * Recupera o valor do atributo 'gsegglafResponse'.
	 *
	 * @return valor do atributo 'gsegglafResponse'
	 * @see
	 */
	public GSEGGLAFResponse getGsegglafResponse() {
		return gsegglafResponse;
	}

	/**
	 * Nome: setGsegglafResponse
	 * Registra o valor do atributo 'gsegglafResponse'.
	 *
	 * @param gsegglafResponse valor do atributo gsegglaf response
	 * @see
	 */
	public void setGsegglafResponse(GSEGGLAFResponse gsegglafResponse) {
		this.gsegglafResponse = gsegglafResponse;
	}
}
