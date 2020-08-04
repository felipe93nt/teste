/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao
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
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.InformacaoPilotoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.BeneficiarioVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.CalcPrazoTotalOperLcVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaCotacoesExternasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ObservacoesCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TaxasForfaitingVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegPrecificacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.VincularOperacaoLcVO;

/**
 * Nome: ITradeFinanceNegociacaoService.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
public interface ITradeFinanceNegociacaoService extends Serializable {
    
    /**
     * 
     * Nome: getMsgRetorno
     *  
     * Prop�sito: Fornece mensagem de retorno enviado pelo mainframe na execu��o dos fluxos
     *
     * @param : <BR/>
     * @return : String
     *
     * @throws : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    String getMsgRetorno();
    

    /**
     * Nome: getComboMercadorias
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<TradeFinNegocListasVO> getMercadoriasModalList(TrdFinNegMercadoriaVO filtro);

    /**
     * Nome: getOperacoesVinculadas
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<TrdFinNegOperVincVO> getOperacoesVinculadas(TrdFinNegOperVincVO OpVcVO);

    /**
     * Nome: getConverterValorParaMoedaLimite
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String getConverterValorParaMoedaLimite(TrdFinNegocInclVO negocInclVO);

    /**
     * Nome: getFluxoPagtoDePrincipalJuros
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public Boolean getFluxoPagtoDePrincipalJuros(TrdFinNegFluxoPagtoVO flxPagtoVO, boolean prazoOperacaoAjustado);

    /**
     * Nome: getClienteDadosRatingSegmento
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void getClienteDadosRatingSegmento(TrdFinNegocInclVO trdFinNegocVO);
    
    /**
     * Nome: getSpreadNegociado
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegComissaoVO getSpreadNegociado(TrdFinNegComissaoVO ComissaoVO, List<TrdFinNegComissaoVO> listaFluxo,
            ComissaoCollection comissaoAdicional, Integer prazoMedio, String ptxfixacmbio);
    
    /**
     * Nome: getCustoExterno
     * 
     * Prop�sito: Calcular campos do include de precifica��o
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 06/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
     public Boolean getCustoExterno(TrdFinNegPrecificacaoVO precificacaoVO);
     
     
     
     /* INCLUIR */
     
    /**
     * Nome: incluirFinimpOuRefinimpDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO incluirFinimpOuRefinimpDireto(TrdFinNegocInclVO finDiretoVO);
    
    /**
     * Nome: incluirFinimpOuRefinimpIndireto
     * 
     * Prop�sito: Finimp Indireto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO incluirFinimpOuRefinimpIndireto(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirLei4131
     * 
     * Prop�sito: Incluir cota��o LEI 4131
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO incluirLei4131(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirPPE
     * 
     * Prop�sito: Incluir cota��o PPE
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO incluirPPE(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirWorkingCapital
     * 
     * Prop�sito: Incluir cota��o Working Capital
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO incluirWorkingCapital(TrdFinNegocInclVO finIndiretoVO);

    /**
     * Nome: incluirFluxoPagtoComissaoExternaFinOuRefinDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void incluirFluxoPagtoComissaoExternaFinOuRefinDireto(TrdFinNegComissaoVO comissaoVO, Integer codProduto);

    /**
     * Nome: incluirFluxoPagtoComissaoInternaFinOuRefinDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void incluirFluxoPagtoComissaoInternaFinOuRefinDireto(TrdFinNegComissaoVO comissaoVO, Integer codProduto);
    
    public void incluirFluxoPagtoComissaoInternaFinOuRefinDireto(TrdFinNegComissaoVO itemListaComissaoInt, Integer codigo, String ccomiscartanacio);

    /**
     * Nome: incluirFluxoPagtoPrincJurosFinimpDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void incluirFluxoPagtoPrincJurosFinimpDireto(TrdFinNegFluxoPagtoVO flxPgtVO);
    
    
    /**
     * Nome: incluirFluxoPagtoPrincJurosNCEAditarFaKe
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void incluirFluxoPagtoPrincJurosNCEAditarFaKe(TrdFinNegFluxoPagtoVO flxPgtVO);

    /**
     * Nome: incluirGarantiasVinculosTarifasObservacoesFinOuRefinDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void incluirGarantiasVinculosTarifasObsFinOuRefinDireto(TrdFinNegocInclVO finDiretoVO, TrdFinNegPrecificacaoVO precificacaoVO);

    
    
    
    /* ALTERAR */

    /**
     * Nome: alterarFinimpOuRefinimpDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarFinimpOuRefinimpDireto(TrdFinNegocInclVO finDiretoVO);
    
    /**
     * Nome: alterarFinimpOuRefinimpIndireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarFinimpOuRefinimpIndireto(TrdFinNegocInclVO finDiretoVO);
    
    /**
     * Nome: incluirLei4131
     * 
     * Prop�sito: Incluir cota��o LEI 4131
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarLei4131(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirPPE
     * 
     * Prop�sito: Incluir cota��o PPE
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarPPE(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirWorkingCapital
     * 
     * Prop�sito: Incluir cota��o Working Capital
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarWorkingCapital(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirForfaiting
     * 
     * Prop�sito: Incluir cota��o Forfaiting
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarForfaiting(TrdFinNegocInclVO cotacao);
    
    /**
     * Nome: alterarGarantiasVinculosTarifasObsFinOuRefinDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 04/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarGarantiasVinculosTarifasObs(TrdFinNegocInclVO finDiretoVO, TrdFinNegPrecificacaoVO precificacaoVO);
    
    /**
     * Nome: alterarFluxoPagtoPrincJuros
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegFluxoPagtoVO alterarFluxoPagtoPrincJuros(TrdFinNegFluxoPagtoVO flxPgtVO, List<TrdFinNegMercadoriaVO> listaMercadoria);

    /**
     * Nome: alterarFluxoPagtoComissaoInternaFinOuRefinDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegComissaoVO alterarFluxoPagtoComissaoInterna(TrdFinNegComissaoVO comissaoVO, Integer codProduto);

    /**
     * Nome: alterarFluxoPagtoComissaoExternaFinOuRefinDireto
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegComissaoVO alterarFluxoPagtoComissaoExterna(TrdFinNegComissaoVO comissaoVO, Integer codProduto);

    
    /**
     * Nome: fluxoValidacao
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manuten��o: 02/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String fluxoValidacao(TrdFinNegocInclVO finDiretoVO,
                    TrdFinNegPrecificacaoVO precifVO,
                    Integer tipoAcesso,
                    List<TradeFinanceDesembolsoVO> listaDesembolso);
    
    /**
    * Nome: calcTaxasForfaiting
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 13/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public Boolean calcTaxasForfaiting(TaxasForfaitingVO TxVO);
    
    /**
     * Nome: incluirForfaiting
     * 
     * Prop�sito: Incluir cota��o Forfaiting
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO incluirForfaiting(TrdFinNegocInclVO finIndiretoVO);

    /**
    * Nome: incluirDesembolsoForfaiting
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 14/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public void incluirDesembolsoForfaiting(TradeFinanceDesembolsoVO desembolsoVO);
    
    /**
    * Nome: incluirDadosBasicosGp1Gp3
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 20/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public TrdFinNegocInclVO incluirDadosBasicosGp1Gp3(TrdFinNegocInclVO finDiretoVO) throws NpccTradeWebException;

    /**
     * Nome: alterarDadosBasicosGp1Gp3
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 20/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public TrdFinNegocInclVO alterarDadosBasicosGp1Gp3(TrdFinNegocInclVO finDiretoVO, TradeFinanceVO dadosBasicos);
    
    
    /**
    * Nome: incluirAlterarObservacoesCotacao
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 31/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public void incluirAlterarObservacoesCotacao(ObservacoesCotacaoVO obsVO);

    /**
     * Nome: calcCustoTotalForfaiting
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manuten��o: 01/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String calcCustoTotalForfaiting(TrdFinNegPrecificacaoVO trdFinNegPrecificacaoVO, TrdFinNegocInclVO custoTotalForfaiting,
                    String vtxspreadnegoc,
                    String vtravaliborcmbio,
                    Integer przliborcmbio,
                    String vtxliborcmbio);
    
    /**
    * Nome: calcularSomatoria
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 16/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public Double calcularSomatoria(Double juros, Double pagamento);
    

    /**
    * Nome: alterarDesembolsoEouMercadoriaForfainting
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 25/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public void alterarDesembolsoEouMercadoriaForfainting(TradeFinanceDesembolsoVO desembolsoVO,
                    List<TrdFinNegMercadoriaVO> listaMercadoria);
    
    /**
    * Nome: incluirParcelasDesembolso
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 24/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public void incluirParcelasDesembolso (Long numBoleto, String registroManutencao, List<ParcelaVO> listaParcelas);
    
    /**
    * Nome: calcularPrazoTotalOperacaoLC
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 27/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public int calcularPrazoTotalOperacaoLC(CalcPrazoTotalOperLcVO calcPrazoTotalOperLcVO);

    /**
    * Nome: incluirAlterarDespesasFunindgLC
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 24/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public void incluirAlterarDespesasFundingLC(Long numBoleto, String registroManutencao, ListaCotacoesExternasVO cotacaoFunding, String flagProc);        

    /**
    * Nome: calcularPrazosMediosOperacaoDesembolso
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 11/07/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public Boolean calcularPrazosMediosOperacaoDesembolso(TrdFinNegFluxoPagtoVO flxPagtoVO,
                    List<TrdFinNegFluxoPagtoVO> listaFluxo);

    /**
    * Nome: calcularPrazoMedioComAnaliseFluxoPagto
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 03/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public Boolean calcularPrazoMedioComAnaliseFluxoPagto(TrdFinNegFluxoPagtoVO flxPagtoVO,
                    TrdFinNegocInclVO trdFinNegVO);
    
    /**
     * Nome: incluirComplGarantia
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 13/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String incluirComplGarantia(TrdFinNegocInclVO saida, Long nbletonegoccmbio);
    
    	/**
    	* Nome: alterarComplGarantia
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 25/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public String alterarComplGarantia (TrdFinNegocInclVO saidaDados, Long nbletonegoccmbio);
    
    	/**
    	* Nome: obterBeneficiarioAfiancador
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 25/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public BeneficiarioVO obterBeneficiario(TrdFinNegMercadoriaVO saida, Integer flagbeneorafia);
    
    
    	/**
    	* Nome: obterAfiancador
    	* 
    	* Prop�sito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 28/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
    	*/
    public BeneficiarioVO obterAfiancador(TradeFinNegocListasVO saida, Integer flagbeneorafia);

	/**
	* Nome: fluxoValidacaoPagamento
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 10/10/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
	public Integer fluxoValidacaoPagamento(TrdFinNegocInclVO tradeFinNegocVO);

	/**
    * Nome: operVinculadaLcIncl
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 31/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
    public void operVinculadaLcIncl(VincularOperacaoLcVO vo);
    
    /**
     * Nome: validStatusVinculoLc
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 31/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
     public VincularOperacaoLcVO validStatusVinculoLc(VincularOperacaoLcVO vo);
     
     /**
      * Nome: inecIndicadorEconomico
      * 
      * Prop�sito: 
      *
      * @param : 
      * @return : 
      * @throws :
      * @exception : 
      * @see : Referencias externas.  
      *
      * Registro  de Manuten��o: 13/12/2016
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequa��o ao padr�o hexavision.
      */
     public Integer inecIndicadorEconomico(Integer ecindcdeconm);
     
     /**
      * Nome: desfazimentoIncl
      * 
      * Proposito: Desfazer Inclus�o
      *
      * @param :
      * @return :
      * @throws :
      * @exception :
      * @see : Referencias externas.
      *
      *      Registro de Manuten��o: 26/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
      */
     public Long desfazimentoIncl(Long nbletonegcmbio);
     
     /**
      * Nome: desfazimentoAlt
      * 
      * Proposito: Desfazer Altera��o
      *
      * @param :
      * @return :
      * @throws :
      * @exception :
      * @see : Referencias externas.
      *
      *      Registro de Manuten��o: 26/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
      */
     public Long desfazimentoAlt(Long nbletonegcmbio);
     
     /**
      * Nome: baixarSaldoForfaiting
      * 
      * Prop�sito: 
      *
      * @param : 
      * @return : 
      * @throws :
      * @exception : 
      * @see : Referencias externas.  
      *
      * Registro  de Manuten��o: 24/06/2016
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequa��o ao padr�o hexavision.
      */
     public void baixarSaldoForfaiting(TrdFinNegocInclVO negociacaoVO, TradeFinanceDesembolsoVO desembVO);
     
     /**
      * Nome: somaAboutValorLimite
      * 
      * Prop�sito: Somar o percentual do about no valor na moeda do limite
      *
      * @param :
      * @return :
      * @throws :
      * @exception :
      * @see : Referencias externas.
      *
      *      Registro de Manuten��o: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
      */
     public String somaAboutValorLimite(TrdFinNegocInclVO negocInclVO);
     
     /**
      * Nome: consultarSituacaoPiloto
      * 
      * Prop�sito: 
      *
      * @param : 
      * @return : 
      * @throws :
      * @exception : 
      * @see : Referencias externas.  
      *
      * Registro  de Manuten��o: 16/05/2017
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequa��o ao padr�o hexavision.
      */
     public InformacaoPilotoVO consultarSituacaoPiloto(Long codigoUnicoCliente);


     public TrdFinNegFluxoPagtoVO alterarFluxoPagtoPrincJurosCtcPend(TrdFinNegFluxoPagtoVO itemDesembolso, List<MercadoriaVO> listaSelMercadoria);
}
