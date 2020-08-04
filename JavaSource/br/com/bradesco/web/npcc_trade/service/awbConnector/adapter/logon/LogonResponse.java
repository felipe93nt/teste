/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon
 * 
 * Prop�sito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Cria��o: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Par�metros de Compila��o: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Response;

/**
 * Nome: LogonResponse
 * Prop�sito: Classe pai response do adapter Logon
 * Equipe: AWB Conectores
 * Parametro de compila��o: -d.
 *
 * @author william.santos CPM Braxis Copyright (c) 2011
 * @version 1.0
 * @return: NA.
 * @throws: NA.
 * @see: NA.
 * <p>Registro de Manuten��o:
 * <li>Data : </li>
 * <li>Autor: </li>
 * <li>Respons�vel: </li>
 * </p>
 */
public class LogonResponse extends FRWKGL01Response {
	
	/** Atributo gsegglaf response. */
	@Adapter(isTransactionBlock = true)
	GSEGGLAFResponse gsegglafResponse = null;
	
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
