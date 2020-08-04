/**
 *
 * Nome: IBanqueiroService.java
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 05/10/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.bean.BanqueiroModalVO;

/**
 *
 * Nome: IBanqueiroService.java Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRADESCO S.A.<BR/>
 *         Equipe : Centro de Desenvolvimento - Curitiba <BR>
 * @version: 1.6 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 */
public interface IBanqueiroModalService {

	/**
	 * 
	 * Nome: getMsgRetorno
	 * 
	 * Prop�sito: Fornece mensagem de retorno enviado pelo mainframe na execu��o
	 * dos fluxos
	 *
	 * @param : <BR/>
	 * @return : String
	 *
	 * @throws : NpcdServiceBusinessException
	 *
	 * @see : Referencias externas.
	 */
	String getMsgRetorno();

	/**
	 * 
	 * Nome: listar
	 * 
	 * Prop�sito: Lista dados modal de banqueiros
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
	 *      Registro de Manuten��o: 06/10/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public List<BanqueiroModalVO> listar(BanqueiroModalVO filtro);

}
