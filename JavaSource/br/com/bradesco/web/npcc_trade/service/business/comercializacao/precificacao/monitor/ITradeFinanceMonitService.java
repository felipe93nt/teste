/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 02/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoInternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.CustoExternoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DataDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.DeParaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FundingVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoVinculadaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ComissaoCollection;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.BeneficiarioVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaParcelasDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.view.bean.ResponsavelDespesaVO;

/**
 * Nome: ITradeFinanceNegociacaoService.java
 * 
 * Prop�sito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compila��o -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manuten��o: 02/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padr�o hexavision.
 */
public interface ITradeFinanceMonitService extends Serializable {

    /**
     * 
     * Nome: obterOperacaoVinculada
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<OperacaoVinculadaVO> obterOperacaoVinculada(Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterMercadoria
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<MercadoriaVO> obterMercadoria(Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterTarifa
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<TarifaVO> obterTarifa(Long nBleto);

    /**
     * 
     * Nome: obterTarifa
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws ParseException 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public TradeFinanceVO obterDadosBasicos(TradeFinanceListaVO listaVO, Integer funcao);

    /**
     * 
     * Nome: obterComissaoInterna
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<ComissaoInternaVO> comissaoInternaDet(Long nBleto, Integer nComissao, String hinclreghist);

    /**
     * 
     * Nome: obterComissaoExterna
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<ComissaoExternaVO> comissaoExternaDet(Long nBleto, Integer nComissao, String hinclreghist);

    /**
     * 
     * Nome: obterComissaoInterna
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<ComissaoInternaVO> obterComissaoInterna(Long nBleto, String hinclreghist, String vtxspreadtot);

    /**
     * 
     * Nome: obterComissaoInterna
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public ComissaoCollection obterComissaoExterna(Long nBleto, String hinclreghist);


    /**
     * 
     * Nome: obterFluxoPgtList
     * 
     * Prop�sito: Obter uma lista de fluxo de pagamento
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<FluxoPagamentoVO> obterFluxoPgtList(Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterFluxoPgtDet
     * 
     * Prop�sito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public FluxoPagamentoVO obterFluxoPgtDet(FluxoPagamentoVO fluxoPagamento, Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterConfirmarPerda
     * 
     * Prop�sito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String confirmarPerda(TradeFinanceVO dadosConfirmaPerda, Integer csitbleto);


    /**
     * 
     * Nome: obterConfirmarBaixar
     * 
     * Prop�sito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String confirmarBaixar(TradeFinanceVO tradeFinanceVO);

    /**
     * 
     * Nome: obterConfirmarBaixar
     * 
     * Prop�sito: Obter lista de cotacoes pendentes
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesPend(TradeFinanceFiltroVO filtroVO);


    /**
     * Nome: obterCotacoesPendExportacao
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesPendExportacao(TradeFinanceFiltroVO filter);

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
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String getMsgRetorno();

    /**
     * 
     * Nome: cotacoesFechadas
     * 
     * Prop�sito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesFechadas(TradeFinanceFiltroVO filtroVO);

    /**
     * 
     * Nome: cotacoesFechadas
     * 
     * Prop�sito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesFechadasExportacao(TradeFinanceFiltroVO filter);

    /**
     * 
     * Nome: confirmarDadosFunding
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 01/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String confirmarDadosFunding(Long nBleto, List<FundingVO> lista, String valorME, Integer codMoeda);

    /**
     * 
     * Nome: pesquisarCotacoes
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 04/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<TradeFinanceListaVO> pesquisarCotacoes(TradeFinanceFiltroVO filtroVO);
    
    /**
     * Nome: pesquisarCotacoesExportacao
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<TradeFinanceListaVO> pesquisarCotacoesExportacao(TradeFinanceFiltroVO filter);

    /**
     * Nome: obterDesembolsoForFaiting
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 29/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void obterDesembolsoForFaiting(TradeFinanceListaVO listaVO, TradeFinanceVO dadosBasicosForfaitingVO, String hinclreghist);

    /**
     * 
     * Nome: obterDadosBasicosForFaiting
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 05/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public TradeFinanceVO obterDadosBasicosForFaiting(TradeFinanceListaVO listaVO, Integer funcao);

    /**
     * 
     * Nome: obterCotacoesDiverg
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 04/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<DeParaListaVO> obterCotacoesDiverg(TradeFinanceListaVO listaVO);

    /**
     * 
     * Nome: alterarCotacao
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 16/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String alterarCustoExterno(String atuaComiss, CustoExternoVO custoExternoVO);

    /**
     * 
     * Nome: listaDataDesembolso
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 04/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<DataDesembolsoVO> listaDataDesembolso(Long nbletonegoccmbio);

    /**
     * 
     * Nome: obterProrrogacaoPrevisaoDesembolso
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 04/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String obterProrrogacaoPrevisaoDesembolso(Long nBleto, Integer ndsemb, Integer caditv);

    /**
     * 
     * Nome: incluirProrrogacao
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 06/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO incluirProrrogacao(TrdFinNegocInclVO negocInclVO);

    /**
     * 
     * Nome: obterDadosBasicosCompl
     * 
     * Prop�sito: Obter dados complemento dos dados b�sicos
     *
     * @param : TradeFinanceListaVO listaVO
     * 
     * @return : ObservacoesCotacaoVO
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public ObservacoesCotacaoVO obterDadosBasicosCompl(TradeFinanceListaVO listaVO);

    /**
     * 
     * Nome: obterDadosBasicosCompl
     * 
     * Prop�sito: Obter dados complemento dos dados b�sicos
     *
     * @param : TradeFinanceListaVO listaVO
     *          String hinclreghist - Parametro utilizado apenas na consulta de log
     * 
     * @return : ObservacoesCotacaoVO
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public ObservacoesCotacaoVO obterDadosBasicosCompl(TradeFinanceListaVO listaVO, String hinclreghist);

    /**
     * Nome: obterCotacoesExternas
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 10/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public CotacoesExternasVO obterCotacoesExternas(Long numBoleto, String hmanut, Integer cindcdaprovbanq);
        


    /**
     * Nome: obterDespesas
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 10/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<ListaDespesasVO> obterDespesas(Long codFunding, Long numBoleto, String hmanut);


    /**
     * Nome: obterParcelasDesembolso
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<ListaParcelasDesembolsoVO> obterParcelasDesembolso(TradeFinanceListaVO listaVO, String hmanut);


    /**
     * Nome: obterResponsavelDespesas
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 13/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public ResponsavelDespesaVO obterResponsavelDespesas(Long numBleto, String hmanut, Integer cindcdaprovbanq);


	/**
	* Nome: obterCotacoesPendente
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 07/07/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
public List<TradeFinanceListaVO> obterCotacoesPendente(TradeFinanceFiltroVO filtroVO);


	/**
	* Nome: obterConsBenefAfianc
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 22/07/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
public BeneficiarioVO obterConsBenefAfianc(Long cunicpssoacmbio, Integer flagbeneorafia, Long cpssoaJuridic, TradeFinanceVO saidaDados);


	/**
	* Nome: aprovarBanqueiro
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 05/08/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
public String aprovarBanqueiro(Long codFunding, Long numBoleto);


    /**
     * Nome: validaDataAprovRespDesp
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 21/10/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
public String validaDataAprovRespDesp(CotacoesExternasVO dadosSaida, ResponsavelDespesaVO listaDespesa, TradeFinanceVO produto);

/**
 * Nome: obterCotacoesPendenteExportacao
 * 
 * Prop�sito: 
 *
 * @param : 
 * @return : 
 * @throws :
 * @exception : 
 * @see : Referencias externas.  
 *
 * Registro  de Manuten��o: 17/11/2016
 *        - Autor: BRQ
 *        - Responsavel: Equipe Web
 *        - Adequa��o ao padr�o hexavision.
 */
public List<TradeFinanceListaVO> obterCotacoesPendenteExportacao(TradeFinanceFiltroVO filtroVO);

/**
 * 
 * Nome: confirmarFormalizacao
 * 
 * Prop�sito:
 *
 * @param :
 * @return :
 * @throws :
 * @exception :
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
 */
public String confirmarFormalizacao(TradeFinanceVO tradeFinanceVO, Integer csitbleto);

/**
 * Nome: gerarArquivoBacthMonitor
 * 
 * Prop�sito: 
 *
 * @param : 
 * @return : 
 * @throws :
 * @exception : 
 * @see : Referencias externas.  
 *
 * Registro  de Manuten��o: 05/08/2016
 *        - Autor: BRQ
 *        - Responsavel: Equipe Web
 *        - Adequa��o ao padr�o hexavision.
 */
public String gerarArquivoBacthMonitor(TradeFinanceFiltroVO filtroVO);


}  

