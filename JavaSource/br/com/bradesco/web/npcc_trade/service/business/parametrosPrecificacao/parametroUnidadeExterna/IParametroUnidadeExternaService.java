/**
 *
 * Nome: IParametroUnidadeExternaService.java
 * Propósito: <p> </p>
 *
 * @author : Bradesco S.A.<BR/>
 * Equipe : CD Curitiba<BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 */
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.ParametroUnidadeExternaVO;

/**
 *
 * Nome: IParametroUnidadeExternaService.java Propósito:
 * <p>
 * </p>
 *
 * @author : Bradesco S.A.<BR/>
 *         Equipe : CD <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 */
public interface IParametroUnidadeExternaService {

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
	 */
	ParametroUnidadeExternaVO pesquisar(ParametroUnidadeExternaVO filtro);

	/**
	 * Nome: detalhar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	ParametroUnidadeExternaVO detalhar(ParametroUnidadeExternaVO filtro);

	/**
	 * Nome: manutencao
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	String manutencao(ParametroUnidadeExternaVO parametroOperacao);
	/**
	 * Nome: msgRetorno
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
    String getMsgRetorno();
}
