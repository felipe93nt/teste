/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon
 * 
 * Propósito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Criação: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Parâmetros de Compilação: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.logon;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.web.npcc_trade.service.awbConnector.provider.FRWKGL01Request;

/**
 * Nome: LogonRequest
 * Propósito: Classe pai request do adapter Logon
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
