/**
 *
 * Nome: IBanqueirosService.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 09/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.banqueiros;

import java.io.Serializable;
//import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean.BanqueiroBaseVo;
//import br.com.bradesco.web.npcd.service.business.banqueiros.banqueiros.bean.BanqueirosDadosSpecVo;
import br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean.BanqueirosFiltroVo;

/**
 *
 * Nome: IBanqueirosService.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 09/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public interface IBanqueirosService extends Serializable {

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
	 *
	 *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	String getMsgRetorno();

	/**
	 * 
	 * Nome: banqueirosListaSwift Propósito:
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
	 *      Registro de Manutenção: 09/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueirosListaSwift(BanqueirosFiltroVo dadosFiltro);

	/**
	 * 
	 * Nome: banqueiroListManut Propósito:
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
	 *      Registro de Manutenção: 24/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public BanqueiroBaseVo banqueiroListManut(BanqueirosFiltroVo dadosFiltro);

	/**
	 * 
	 * Nome: banqueiroAprovList Propósito:
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
	 *      Registro de Manutenção: 11/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroAprovList();

	/**
	 * 
	 * Nome: banqueiroRevisaoList Propósito:
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
	 *      Registro de Manutenção: 11/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroRevisaoList();

	/**
	 * 
	 * Nome: banqueirosIncl Propósito:
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
	 *      Registro de Manutenção: 17/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueirosIncl(BanqueiroBaseVo dadosInclusao);

	/**
	 * Nome: banqueiroAlt
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 16/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroAlt(BanqueiroBaseVo dadosAlteracao);

	/**
	 * 
	 * Nome: banqueiroDet Propósito:
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
	 *      Registro de Manutenção: 24/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDet(BanqueiroBaseVo dadosEntrada);

	/**
	 * 
	 * Nome: banqueiroBloqueioDet Propósito:
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
	 *      Registro de Manutenção: 11/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroBloqueioDet(BanqueiroBaseVo dadosEntrada);

	/**
	 * 
	 * Nome: banqueiroBloqDesbloq Propósito:
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
	 *      Registro de Manutenção: 14/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroBloqDesbloq(BanqueiroBaseVo dadosEntrada,
//			String tipoOperacao);

	/**
	 * Nome: motivoBanqueiroList
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 21/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public List<BanqueirosDadosSpecVo> motivoBanqueiroList(Integer funcao,
//			boolean apenasAtivos);

	/**
	 * Nome: banqueiroDetAproBloq
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 18/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDetAproBloq(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: banqueiroAprovDet
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroAprovDet(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: banqueiroAprovacao
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 23/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroAprovacao(BanqueiroBaseVo dadosAprovacao);

	/**
	 * Nome: banqueiroRejeitar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroRejeitar(BanqueiroBaseVo dadosRejeicao);

	/**
	 * Nome: banqueiroDetAproAssoc
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDetAproAssoc(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: banqueiroDetAproAlt
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 20/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDetAproAlt(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: listarCadu
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 22/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public List<BanqueirosDadosSpecVo> banqueiroCliCaduList(
//			BanqueirosDadosSpecVo dadosCliente);

	/**
	 * Nome: banqueiroRevisarManu
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroRevisarManu(BanqueiroBaseVo dadosRevisao);

	/**
	 * Nome: banqueiroRevisarBloq
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroRevisarBloq(BanqueiroBaseVo dadosRevisao);

	/**
	 * Nome: banqueiroRevisarAsso
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroRevisarAsso(BanqueiroBaseVo dadosRevisao);

	/**
	 * Nome: banqueiroExcluirManu
	 * 
	 * Propósito: Excluir manutenção de banqueiro.
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public String banqueiroExcluirManu(BanqueiroBaseVo dadosExclusao);

	/**
	 * Nome: consultarSolicitacaoPendente
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 23/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	void consultarSolicitacaoPendente(Long cunicpssoacmbio, Long cpssoa);

	/**
	 * Nome: banqueiroGerarLog
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/09/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
//	public void banqueiroGerarLog(Long codigo);
}
