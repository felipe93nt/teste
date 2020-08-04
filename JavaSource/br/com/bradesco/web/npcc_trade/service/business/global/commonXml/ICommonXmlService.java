/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.commonXml
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */

package br.com.bradesco.web.npcc_trade.service.business.global.commonXml;

import java.util.Map;


/**
*
* Nome: ICommonXmlService
* Propósito: TODO <br/>
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
		* Propósito: 
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
		* Registro  de Manutenção: 24/07/2015
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
		*/
	public Map<Integer, Object> getSimNao();
	
		/**
		* Nome: getMoeda
		* 
		* Propósito: Carrega os dados do Combo de Moeda 
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
		* Registro  de Manutenção: 13/08/2015
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
		*/
	public Map<Integer, Object> getMoeda();

}

