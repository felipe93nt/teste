/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 27/11/2015
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.bean.ClausulaVO;

/**
*
* Nome: IClausulaService
* 
* Prop�sito: Interface para o servi�o <br/>
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
	 * Registro  de Manuten��o: 01/02/2016
	 *        - Autor: BRQ
	 *        - Responsavel: Equipe Web
	 *        - Adequa��o ao padr�o hexavision.
	 */
	String getMsgRetorno();
	
	/**
     * 
     * Nome: getLista 
     * 
     * Prop�sito: Obt�m lista de itens ClausulaVO
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
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    List<ClausulaVO> listar(Integer tipoClausula);
    
    /**
     * 
     * Nome: incluir 
     * Prop�sito: Incluir ClausulaVO
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
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String incluir(ClausulaVO obj);
    
    /**
     * 
     * Nome: alterar 
     * Prop�sito: alterar ClausulaVO
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
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String alterar(ClausulaVO obj);

    /**
     * 
     * Nome: excluir
     * Prop�sito: excluir ClausulaVO
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
     *      Registro de Manuten��o: 01/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
	String excluir(ClausulaVO clausulaVO);
	
	/**
     * 
     * Nome: detalhar
     * 
     * Prop�sito: Obter dados da Cl�usula e enviar pra p�gina seguinte
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
     *      Registro de Manuten��o: 04/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
	public ClausulaVO detalhar(Integer idClausula);
}
