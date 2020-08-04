/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.limitesModal.impl
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/03/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.limitesModal;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean.LimitesModalVO;

/**
 * Nome: ILimitesModalService.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public interface ILimitesModalService {

    /**
     * Nome: getListaCotacao
     * 
     * Propósito: Carrega a lista de Limites
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<LimitesModalVO> listarLimite(LimitesModalVO filtro);

    /**
     * Nome: getListaProposta
     * 
     * Propósito: Carrega a lista de propostas Pontuais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<LimitesModalVO> listarProposta(LimitesModalVO filtro);

}
