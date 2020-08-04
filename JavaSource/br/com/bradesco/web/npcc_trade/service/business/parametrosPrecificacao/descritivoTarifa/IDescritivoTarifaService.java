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
package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa;

import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.bean.DescritivoTarifaVO;

/**
 *
 * Nome: IParticipantesService.java Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRadesco s.a.<BR/>
 *         Equipe : CD <BR>
 * @version: 1.6 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 */
public interface IDescritivoTarifaService {

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
	 */
	List<DescritivoTarifaVO> pesquisar(DescritivoTarifaVO filtro);

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
	 */
	List<DescritivoTarifaVO> pesquisarLog(DescritivoTarifaVO filtro);

	/**
	 * Nome: incluir
	 * 
	 * Prop�sito:
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
	 * Prop�sito:
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
	 * Prop�sito:
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
     * Prop�sito: Fornece mensagem de retorno enviado pelo mainframe na execu��o
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
