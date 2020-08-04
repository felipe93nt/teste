/**
 * Nome: br.com.bradesco.web.npcc_trade.service.awbConnector.provider
 * 
 * Prop�sito: Classes de uso comum para a funcionalidade 
 * 
 * Data da Cria��o: 17/02/2011
 * 
 * Compilador: 1.5.0_11
 * Par�metros de Compila��o: -d 
 * 
 */
package br.com.bradesco.web.npcc_trade.service.awbConnector.provider;

import br.com.bradesco.data.connector.Adapter;

/**
 * Nome: GenericoResponse
 * Prop�sito: Classe pai request generica
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
public class GenericoResponse extends FRWKGL01Response {
	
	/** Atributo dados transacao. */
	@Adapter(transactionField = "OUT-MSG.OUT-DADOSTRANSACAO")
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
