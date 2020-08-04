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
package br.com.bradesco.web.npcc_trade.service.business.parametrizacao;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.bean.ComissaoDesembolsoVO;

/**
 *
 * Nome: IParticipantesService.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRadesco s.a.<BR/>
 *         Equipe : CD <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 */
public interface IComissaoDesembolsoService {

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
	List<ComissaoDesembolsoVO> pesquisar(ComissaoDesembolsoVO filtro, Integer tipoAcesso);

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
	 */
	List<ComissaoDesembolsoVO> pesquisarLog(ComissaoDesembolsoVO filtro);

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
	String manutencao(ComissaoDesembolsoVO ComissaoDesembolsoVO);
    String getMsgRetorno();
}
