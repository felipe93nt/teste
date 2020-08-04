/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/12/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
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
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 02/12/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public interface ITradeFinanceMonitService extends Serializable {

    /**
     * 
     * Nome: obterOperacaoVinculada
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<OperacaoVinculadaVO> obterOperacaoVinculada(Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterMercadoria
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<MercadoriaVO> obterMercadoria(Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterTarifa
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TarifaVO> obterTarifa(Long nBleto);

    /**
     * 
     * Nome: obterTarifa
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws ParseException 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public TradeFinanceVO obterDadosBasicos(TradeFinanceListaVO listaVO, Integer funcao);

    /**
     * 
     * Nome: obterComissaoInterna
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ComissaoInternaVO> comissaoInternaDet(Long nBleto, Integer nComissao, String hinclreghist);

    /**
     * 
     * Nome: obterComissaoExterna
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ComissaoExternaVO> comissaoExternaDet(Long nBleto, Integer nComissao, String hinclreghist);

    /**
     * 
     * Nome: obterComissaoInterna
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ComissaoInternaVO> obterComissaoInterna(Long nBleto, String hinclreghist, String vtxspreadtot);

    /**
     * 
     * Nome: obterComissaoInterna
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public ComissaoCollection obterComissaoExterna(Long nBleto, String hinclreghist);


    /**
     * 
     * Nome: obterFluxoPgtList
     * 
     * Propósito: Obter uma lista de fluxo de pagamento
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<FluxoPagamentoVO> obterFluxoPgtList(Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterFluxoPgtDet
     * 
     * Propósito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public FluxoPagamentoVO obterFluxoPgtDet(FluxoPagamentoVO fluxoPagamento, Long nBleto, String hinclreghist);

    /**
     * 
     * Nome: obterConfirmarPerda
     * 
     * Propósito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String confirmarPerda(TradeFinanceVO dadosConfirmaPerda, Integer csitbleto);


    /**
     * 
     * Nome: obterConfirmarBaixar
     * 
     * Propósito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String confirmarBaixar(TradeFinanceVO tradeFinanceVO);

    /**
     * 
     * Nome: obterConfirmarBaixar
     * 
     * Propósito: Obter lista de cotacoes pendentes
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesPend(TradeFinanceFiltroVO filtroVO);


    /**
     * Nome: obterCotacoesPendExportacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesPendExportacao(TradeFinanceFiltroVO filter);

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
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    String getMsgRetorno();

    /**
     * 
     * Nome: cotacoesFechadas
     * 
     * Propósito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesFechadas(TradeFinanceFiltroVO filtroVO);

    /**
     * 
     * Nome: cotacoesFechadas
     * 
     * Propósito: Obter detalhes do fluxo de pagamento selecionado
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 21/01/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> obterCotacoesFechadasExportacao(TradeFinanceFiltroVO filter);

    /**
     * 
     * Nome: confirmarDadosFunding
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 01/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String confirmarDadosFunding(Long nBleto, List<FundingVO> lista, String valorME, Integer codMoeda);

    /**
     * 
     * Nome: pesquisarCotacoes
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 04/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> pesquisarCotacoes(TradeFinanceFiltroVO filtroVO);
    
    /**
     * Nome: pesquisarCotacoesExportacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 08/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> pesquisarCotacoesExportacao(TradeFinanceFiltroVO filter);

    /**
     * Nome: obterDesembolsoForFaiting
     * 
     * PropÃ³sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de ManutenÃ§Ã£o: 29/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - AdequaÃ§Ã£o ao padrÃ£o hexavision.
     */
    public void obterDesembolsoForFaiting(TradeFinanceListaVO listaVO, TradeFinanceVO dadosBasicosForfaitingVO, String hinclreghist);

    /**
     * 
     * Nome: obterDadosBasicosForFaiting
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 05/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public TradeFinanceVO obterDadosBasicosForFaiting(TradeFinanceListaVO listaVO, Integer funcao);

    /**
     * 
     * Nome: obterCotacoesDiverg
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 04/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<DeParaListaVO> obterCotacoesDiverg(TradeFinanceListaVO listaVO);

    /**
     * 
     * Nome: alterarCotacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 16/02/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String alterarCustoExterno(String atuaComiss, CustoExternoVO custoExternoVO);

    /**
     * 
     * Nome: listaDataDesembolso
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 04/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<DataDesembolsoVO> listaDataDesembolso(Long nbletonegoccmbio);

    /**
     * 
     * Nome: obterProrrogacaoPrevisaoDesembolso
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 04/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String obterProrrogacaoPrevisaoDesembolso(Long nBleto, Integer ndsemb, Integer caditv);

    /**
     * 
     * Nome: incluirProrrogacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 06/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirProrrogacao(TrdFinNegocInclVO negocInclVO);

    /**
     * 
     * Nome: obterDadosBasicosCompl
     * 
     * Propósito: Obter dados complemento dos dados básicos
     *
     * @param : TradeFinanceListaVO listaVO
     * 
     * @return : ObservacoesCotacaoVO
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public ObservacoesCotacaoVO obterDadosBasicosCompl(TradeFinanceListaVO listaVO);

    /**
     * 
     * Nome: obterDadosBasicosCompl
     * 
     * Propósito: Obter dados complemento dos dados básicos
     *
     * @param : TradeFinanceListaVO listaVO
     *          String hinclreghist - Parametro utilizado apenas na consulta de log
     * 
     * @return : ObservacoesCotacaoVO
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public ObservacoesCotacaoVO obterDadosBasicosCompl(TradeFinanceListaVO listaVO, String hinclreghist);

    /**
     * Nome: obterCotacoesExternas
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 10/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public CotacoesExternasVO obterCotacoesExternas(Long numBoleto, String hmanut, Integer cindcdaprovbanq);
        


    /**
     * Nome: obterDespesas
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 10/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ListaDespesasVO> obterDespesas(Long codFunding, Long numBoleto, String hmanut);


    /**
     * Nome: obterParcelasDesembolso
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ListaParcelasDesembolsoVO> obterParcelasDesembolso(TradeFinanceListaVO listaVO, String hmanut);


    /**
     * Nome: obterResponsavelDespesas
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public ResponsavelDespesaVO obterResponsavelDespesas(Long numBleto, String hmanut, Integer cindcdaprovbanq);


	/**
	* Nome: obterCotacoesPendente
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 07/07/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
public List<TradeFinanceListaVO> obterCotacoesPendente(TradeFinanceFiltroVO filtroVO);


	/**
	* Nome: obterConsBenefAfianc
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 22/07/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
public BeneficiarioVO obterConsBenefAfianc(Long cunicpssoacmbio, Integer flagbeneorafia, Long cpssoaJuridic, TradeFinanceVO saidaDados);


	/**
	* Nome: aprovarBanqueiro
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 05/08/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
public String aprovarBanqueiro(Long codFunding, Long numBoleto);


    /**
     * Nome: validaDataAprovRespDesp
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 21/10/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
public String validaDataAprovRespDesp(CotacoesExternasVO dadosSaida, ResponsavelDespesaVO listaDespesa, TradeFinanceVO produto);

/**
 * Nome: obterCotacoesPendenteExportacao
 * 
 * Propósito: 
 *
 * @param : 
 * @return : 
 * @throws :
 * @exception : 
 * @see : Referencias externas.  
 *
 * Registro  de Manutenção: 17/11/2016
 *        - Autor: BRQ
 *        - Responsavel: Equipe Web
 *        - Adequação ao padrão hexavision.
 */
public List<TradeFinanceListaVO> obterCotacoesPendenteExportacao(TradeFinanceFiltroVO filtroVO);

/**
 * 
 * Nome: confirmarFormalizacao
 * 
 * Propósito:
 *
 * @param :
 * @return :
 * @throws :
 * @exception :
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 13/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
 */
public String confirmarFormalizacao(TradeFinanceVO tradeFinanceVO, Integer csitbleto);

/**
 * Nome: gerarArquivoBacthMonitor
 * 
 * Propósito: 
 *
 * @param : 
 * @return : 
 * @throws :
 * @exception : 
 * @see : Referencias externas.  
 *
 * Registro  de Manutenção: 05/08/2016
 *        - Autor: BRQ
 *        - Responsavel: Equipe Web
 *        - Adequação ao padrão hexavision.
 */
public String gerarArquivoBacthMonitor(TradeFinanceFiltroVO filtroVO);


}  

