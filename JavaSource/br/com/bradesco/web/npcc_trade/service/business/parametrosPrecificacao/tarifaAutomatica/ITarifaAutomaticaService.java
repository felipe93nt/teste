/**
 *
 * Nome: IParticipantesService.java
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 29/02/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tarifaAutomatica.bean.TarifaAutomaticaVO;

/**
 *
 * Nome: IParticipantesService.java Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 29/02/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */
public interface ITarifaAutomaticaService {

	/**
	 * Nome: obterOperacoes
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	List<TarifaAutomaticaVO> obterOperacoes(int produto);

	/**
	 * Nome: pesquisar
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	List<TarifaAutomaticaVO> pesquisar(TarifaAutomaticaFiltroVO filtro);

	/**
	 * Nome: pesquisarLog
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	List<TarifaAutomaticaVO> pesquisarLog(TarifaAutomaticaFiltroVO filtro);

	/**
	 * Nome: salvar
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 21/06/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	String salvar(List<TarifaAutomaticaVO> tarifas);
}
