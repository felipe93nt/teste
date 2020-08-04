/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.limitesModal.impl
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 02/03/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.limitesModal;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean.LimitesModalVO;

/**
 * Nome: ILimitesModalService.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public interface ILimitesModalService {

    /**
     * Nome: getListaCotacao
     * 
     * Prop�sito: Carrega a lista de Limites
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 03/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<LimitesModalVO> listarLimite(LimitesModalVO filtro);

    /**
     * Nome: getListaProposta
     * 
     * Prop�sito: Carrega a lista de propostas Pontuais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 03/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<LimitesModalVO> listarProposta(LimitesModalVO filtro);

}
