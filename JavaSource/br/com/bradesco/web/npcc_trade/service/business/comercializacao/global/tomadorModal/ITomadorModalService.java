/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.tomadorModal
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 23/05/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.tomadorModal;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;

/**
 * Nome: ITomadorModalService.java
 * 
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 23/05/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
public interface ITomadorModalService {

    /**
    * Nome: getTomadorModalList
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 23/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public List<TradeFinNegocListasVO> getTomadorModalList(String nomeTomador);

}
