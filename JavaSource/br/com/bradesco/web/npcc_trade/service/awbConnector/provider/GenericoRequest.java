/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.provider
 * 
 * Propósito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Criação: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Parâmetros de Compilação: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.provider;

import br.com.bradesco.data.connector.Adapter;

/**
 * Nome: GenericoRequest
 * Propósito: Classe pai response generica
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
public class GenericoRequest extends FRWKGL01Request {
	
	/** Atributo dados transacao. */
	@Adapter(transactionField = "IN-MSG.IN-DADOSTRANSACAO")
	private String dadosTransacao = "";
	
	/**
	 * Nome: getDadosTransacao
	 * Recupera o valor do atributo 'dadosTransacao'.
	 *
	 * @return valor do atributo 'dadosTransacao'
	 * @see
	 */
	public String getDadosTransacao() {
		return dadosTransacao;
	}
	
	/**
	 * Nome: setDadosTransacao
	 * Registra o valor do atributo 'dadosTransacao'.
	 *
	 * @param dadosTransacao valor do atributo dados transacao
	 * @see
	 */
	public void setDadosTransacao(String dadosTransacao) {
		this.dadosTransacao = dadosTransacao;
	}
}
