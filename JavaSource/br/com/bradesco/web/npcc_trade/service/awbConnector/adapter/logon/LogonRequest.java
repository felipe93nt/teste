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
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Nome: LogonRequest
 * Prop�sito: Classe pai request do adapter Logon
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
public class LogonRequest extends FRWKGL01Request {
	
	/** Atributo gsegglae request. */
	@Adapter(isTransactionBlock = true)
	GSEGGLAERequest gsegglaeRequest = null;
	
	/**
	 * Nome: getGsegglaeRequest
	 * Recupera o valor do atributo 'gsegglaeRequest'.
	 *
	 * @return valor do atributo 'gsegglaeRequest'
	 * @see
	 */
	public GSEGGLAERequest getGsegglaeRequest() {
		return gsegglaeRequest;
	}
	
	/**
	 * Nome: setGsegglaeRequest
	 * Registra o valor do atributo 'gsegglaeRequest'.
	 *
	 * @param gsegglaeRequest valor do atributo gsegglae request
	 * @see
	 */
	public void setGsegglaeRequest(GSEGGLAERequest gsegglaeRequest) {
		this.gsegglaeRequest = gsegglaeRequest;
	}
}
