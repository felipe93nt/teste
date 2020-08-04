/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 27/11/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.bean.ClausulaVO;

/**
*
* Nome: IClausulaService
* 
* Propósito: Interface para o serviço <br/>
*
* Data: 27/11/2015 <br/>
* @author BRQ <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
public interface IClausulaService extends Serializable {
	
	/**
	 * 
	 * Nome: getMsgRetorno
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
	 * Registro  de Manutenção: 01/02/2016
	 *        - Autor: BRQ
	 *        - Responsavel: Equipe Web
	 *        - Adequação ao padrão hexavision.
	 */
	String getMsgRetorno();
	
	/**
     * 
     * Nome: getLista 
     * 
     * Propósito: Obtém lista de itens ClausulaVO
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    List<ClausulaVO> listar(Integer tipoClausula);
    
    /**
     * 
     * Nome: incluir 
     * Propósito: Incluir ClausulaVO
     *
     * @param : ClausulaVO
     * @return : Boolean
     *
     * @throws : NpccTradeServiceBusinessException
     * 
     * @exception : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    String incluir(ClausulaVO obj);
    
    /**
     * 
     * Nome: alterar 
     * Propósito: alterar ClausulaVO
     *
     * @param : ClausulaVO
     * @return : Boolean
     *
     * @throws : NpccTradeServiceBusinessException
     * 
     * @exception : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    String alterar(ClausulaVO obj);

    /**
     * 
     * Nome: excluir
     * Propósito: excluir ClausulaVO
     *
     * @param : ClausulaVO
     * @return : String
     *
     * @throws : NpccTradeServiceBusinessException
     * 
     * @exception : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
	String excluir(ClausulaVO clausulaVO);
	
	/**
     * 
     * Nome: detalhar
     * 
     * Propósito: Obter dados da Cláusula e enviar pra página seguinte
     *
     * @param : Id da Clausula selecionada
     * @return : Clausula
     *
     * @throws : NpccServiceBusinessException
     * 
     * @exception : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
	public ClausulaVO detalhar(Integer idClausula);
}
