/**
 *
 * Nome: IBanqueirosService.java
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 09/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
package br.com.bradesco.web.npcc_trade.service.business.banqueiros;

import java.io.Serializable;
//import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean.BanqueiroBaseVo;
//import br.com.bradesco.web.npcd.service.business.banqueiros.banqueiros.bean.BanqueirosDadosSpecVo;
import br.com.bradesco.web.npcc_trade.service.business.banqueiros.bean.BanqueirosFiltroVo;

/**
 *
 * Nome: IBanqueirosService.java Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 09/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */
public interface IBanqueirosService extends Serializable {

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
	 *
	 *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	String getMsgRetorno();

	/**
	 * 
	 * Nome: banqueirosListaSwift Prop�sito:
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
	 *      Registro de Manuten��o: 09/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueirosListaSwift(BanqueirosFiltroVo dadosFiltro);

	/**
	 * 
	 * Nome: banqueiroListManut Prop�sito:
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
	 *      Registro de Manuten��o: 24/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public BanqueiroBaseVo banqueiroListManut(BanqueirosFiltroVo dadosFiltro);

	/**
	 * 
	 * Nome: banqueiroAprovList Prop�sito:
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
	 *      Registro de Manuten��o: 11/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroAprovList();

	/**
	 * 
	 * Nome: banqueiroRevisaoList Prop�sito:
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
	 *      Registro de Manuten��o: 11/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroRevisaoList();

	/**
	 * 
	 * Nome: banqueirosIncl Prop�sito:
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
	 *      Registro de Manuten��o: 17/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueirosIncl(BanqueiroBaseVo dadosInclusao);

	/**
	 * Nome: banqueiroAlt
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 16/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroAlt(BanqueiroBaseVo dadosAlteracao);

	/**
	 * 
	 * Nome: banqueiroDet Prop�sito:
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
	 *      Registro de Manuten��o: 24/11/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDet(BanqueiroBaseVo dadosEntrada);

	/**
	 * 
	 * Nome: banqueiroBloqueioDet Prop�sito:
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
	 *      Registro de Manuten��o: 11/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroBloqueioDet(BanqueiroBaseVo dadosEntrada);

	/**
	 * 
	 * Nome: banqueiroBloqDesbloq Prop�sito:
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
	 *      Registro de Manuten��o: 14/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroBloqDesbloq(BanqueiroBaseVo dadosEntrada,
//			String tipoOperacao);

	/**
	 * Nome: motivoBanqueiroList
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 21/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public List<BanqueirosDadosSpecVo> motivoBanqueiroList(Integer funcao,
//			boolean apenasAtivos);

	/**
	 * Nome: banqueiroDetAproBloq
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 18/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDetAproBloq(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: banqueiroAprovDet
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 22/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroAprovDet(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: banqueiroAprovacao
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 23/12/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroAprovacao(BanqueiroBaseVo dadosAprovacao);

	/**
	 * Nome: banqueiroRejeitar
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 13/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroRejeitar(BanqueiroBaseVo dadosRejeicao);

	/**
	 * Nome: banqueiroDetAproAssoc
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 19/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDetAproAssoc(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: banqueiroDetAproAlt
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 20/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public BanqueiroBaseVo banqueiroDetAproAlt(BanqueiroBaseVo dadosEntrada);

	/**
	 * Nome: listarCadu
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 22/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public List<BanqueirosDadosSpecVo> banqueiroCliCaduList(
//			BanqueirosDadosSpecVo dadosCliente);

	/**
	 * Nome: banqueiroRevisarManu
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroRevisarManu(BanqueiroBaseVo dadosRevisao);

	/**
	 * Nome: banqueiroRevisarBloq
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroRevisarBloq(BanqueiroBaseVo dadosRevisao);

	/**
	 * Nome: banqueiroRevisarAsso
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroRevisarAsso(BanqueiroBaseVo dadosRevisao);

	/**
	 * Nome: banqueiroExcluirManu
	 * 
	 * Prop�sito: Excluir manuten��o de banqueiro.
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 25/01/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public String banqueiroExcluirManu(BanqueiroBaseVo dadosExclusao);

	/**
	 * Nome: consultarSolicitacaoPendente
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 23/02/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	void consultarSolicitacaoPendente(Long cunicpssoacmbio, Long cpssoa);

	/**
	 * Nome: banqueiroGerarLog
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 19/09/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
//	public void banqueiroGerarLog(Long codigo);
}
