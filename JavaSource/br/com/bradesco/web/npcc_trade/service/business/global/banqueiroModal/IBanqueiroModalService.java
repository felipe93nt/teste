/**
 *
 * Nome: IBanqueiroService.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 05/10/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.bean.BanqueiroModalVO;

/**
 *
 * Nome: IBanqueiroService.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRADESCO S.A.<BR/>
 *         Equipe : Centro de Desenvolvimento - Curitiba <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 */
public interface IBanqueiroModalService {

	/**
	 * 
	 * Nome: getMsgRetorno
	 * 
	 * Propósito: Fornece mensagem de retorno enviado pelo mainframe na execução
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
	 * Propósito: Lista dados modal de banqueiros
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
	 *      Registro de Manutenção: 06/10/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<BanqueiroModalVO> listar(BanqueiroModalVO filtro);

}
