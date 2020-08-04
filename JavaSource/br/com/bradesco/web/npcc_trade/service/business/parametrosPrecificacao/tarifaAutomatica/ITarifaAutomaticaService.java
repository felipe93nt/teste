/**
 *
 * Nome: IParticipantesService.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 29/02/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaVO;

/**
 *
 * Nome: IParticipantesService.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 29/02/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public interface ITarifaAutomaticaService {

	/**
	 * Nome: obterOperacoes
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	List<TarifaAutomaticaVO> obterOperacoes(int produto);

	/**
	 * Nome: pesquisar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	List<TarifaAutomaticaVO> pesquisar(TarifaAutomaticaFiltroVO filtro);

	/**
	 * Nome: pesquisarLog
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	List<TarifaAutomaticaVO> pesquisarLog(TarifaAutomaticaFiltroVO filtro);

	/**
	 * Nome: salvar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	String salvar(List<TarifaAutomaticaVO> tarifas);
}
