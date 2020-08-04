/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.commonXml
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 16/06/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */

package br.com.bradesco.web.npcc_trade.service.business.global.commonXml;

import java.util.Map;


/**
*
* Nome: ICommonXmlService
* Prop�sito: TODO <br/>
*
* Data: 13/07/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
public interface ICommonXmlService {

	 	/**
		* 
		* Nome: getSimNao
		* Prop�sito: 
		*
		* @param : 
		*       <BR/>
		* @return : 
		*
		* @throws :
		* 
		* @exception : 
		*
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 24/07/2015
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
		*/
	public Map<Integer, Object> getSimNao();
	
		/**
		* Nome: getMoeda
		* 
		* Prop�sito: Carrega os dados do Combo de Moeda 
		*
		* @param : 
		*       <BR/>
		* @return : 
		*
		* @throws :
		* 
		* @exception : 
		*
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 13/08/2015
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
		*/
	public Map<Integer, Object> getMoeda();

}

