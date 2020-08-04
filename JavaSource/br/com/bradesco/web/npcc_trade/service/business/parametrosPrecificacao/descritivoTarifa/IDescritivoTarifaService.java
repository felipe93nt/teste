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
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.bean.DescritivoTarifaVO;

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
public interface IDescritivoTarifaService {

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
	List<DescritivoTarifaVO> pesquisar(DescritivoTarifaVO filtro);

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
	List<DescritivoTarifaVO> pesquisarLog(DescritivoTarifaVO filtro);

	/**
	 * Nome: incluir
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	String incluir(DescritivoTarifaVO descritivoTarifaVO);
	/**
	 * Nome: alterar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	String alterar(DescritivoTarifaVO descritivoTarifaVO);
	/**
	 * Nome: excluir
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	String excluir(DescritivoTarifaVO descritivoTarifaVO);
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
     * @throws : NpccTradeServiceBusinessException
     *
     * @see : Referencias externas.
     */
    String getMsgRetorno();
}
