/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao
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
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
public interface ITradeFinanceNegociacaoService extends Serializable {
    
    /**
     * 
     * Nome: getMsgRetorno
     *  
     * Propósito: Fornece mensagem de retorno enviado pelo mainframe na execução dos fluxos
     *
     * @param : <BR/>
     * @return : String
     *
     * @throws : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    String getMsgRetorno();
    

    /**
     * Nome: getComboMercadorias
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TradeFinNegocListasVO> getMercadoriasModalList(TrdFinNegMercadoriaVO filtro);

    /**
     * Nome: getOperacoesVinculadas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TrdFinNegOperVincVO> getOperacoesVinculadas(TrdFinNegOperVincVO OpVcVO);

    /**
     * Nome: getConverterValorParaMoedaLimite
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String getConverterValorParaMoedaLimite(TrdFinNegocInclVO negocInclVO);

    /**
     * Nome: getFluxoPagtoDePrincipalJuros
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean getFluxoPagtoDePrincipalJuros(TrdFinNegFluxoPagtoVO flxPagtoVO, boolean prazoOperacaoAjustado);

    /**
     * Nome: getClienteDadosRatingSegmento
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void getClienteDadosRatingSegmento(TrdFinNegocInclVO trdFinNegocVO);
    
    /**
     * Nome: getSpreadNegociado
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegComissaoVO getSpreadNegociado(TrdFinNegComissaoVO ComissaoVO, List<TrdFinNegComissaoVO> listaFluxo,
            ComissaoCollection comissaoAdicional, Integer prazoMedio, String ptxfixacmbio);
    
    /**
     * Nome: getCustoExterno
     * 
     * Propósito: Calcular campos do include de precificação
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 06/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public Boolean getCustoExterno(TrdFinNegPrecificacaoVO precificacaoVO);
     
     
     
     /* INCLUIR */
     
    /**
     * Nome: incluirFinimpOuRefinimpDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirFinimpOuRefinimpDireto(TrdFinNegocInclVO finDiretoVO);
    
    /**
     * Nome: incluirFinimpOuRefinimpIndireto
     * 
     * Propósito: Finimp Indireto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirFinimpOuRefinimpIndireto(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirLei4131
     * 
     * Propósito: Incluir cotação LEI 4131
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirLei4131(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirPPE
     * 
     * Propósito: Incluir cotação PPE
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirPPE(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirWorkingCapital
     * 
     * Propósito: Incluir cotação Working Capital
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirWorkingCapital(TrdFinNegocInclVO finIndiretoVO);

    /**
     * Nome: incluirFluxoPagtoComissaoExternaFinOuRefinDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirFluxoPagtoComissaoExternaFinOuRefinDireto(TrdFinNegComissaoVO comissaoVO, Integer codProduto);

    /**
     * Nome: incluirFluxoPagtoComissaoInternaFinOuRefinDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirFluxoPagtoComissaoInternaFinOuRefinDireto(TrdFinNegComissaoVO comissaoVO, Integer codProduto);
    
    public void incluirFluxoPagtoComissaoInternaFinOuRefinDireto(TrdFinNegComissaoVO itemListaComissaoInt, Integer codigo, String ccomiscartanacio);

    /**
     * Nome: incluirFluxoPagtoPrincJurosFinimpDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirFluxoPagtoPrincJurosFinimpDireto(TrdFinNegFluxoPagtoVO flxPgtVO);
    
    
    /**
     * Nome: incluirFluxoPagtoPrincJurosNCEAditarFaKe
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirFluxoPagtoPrincJurosNCEAditarFaKe(TrdFinNegFluxoPagtoVO flxPgtVO);

    /**
     * Nome: incluirGarantiasVinculosTarifasObservacoesFinOuRefinDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirGarantiasVinculosTarifasObsFinOuRefinDireto(TrdFinNegocInclVO finDiretoVO, TrdFinNegPrecificacaoVO precificacaoVO);

    
    
    
    /* ALTERAR */

    /**
     * Nome: alterarFinimpOuRefinimpDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarFinimpOuRefinimpDireto(TrdFinNegocInclVO finDiretoVO);
    
    /**
     * Nome: alterarFinimpOuRefinimpIndireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarFinimpOuRefinimpIndireto(TrdFinNegocInclVO finDiretoVO);
    
    /**
     * Nome: incluirLei4131
     * 
     * Propósito: Incluir cotação LEI 4131
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarLei4131(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirPPE
     * 
     * Propósito: Incluir cotação PPE
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarPPE(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirWorkingCapital
     * 
     * Propósito: Incluir cotação Working Capital
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarWorkingCapital(TrdFinNegocInclVO finIndiretoVO);
    
    /**
     * Nome: incluirForfaiting
     * 
     * Propósito: Incluir cotação Forfaiting
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarForfaiting(TrdFinNegocInclVO cotacao);
    
    /**
     * Nome: alterarGarantiasVinculosTarifasObsFinOuRefinDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarGarantiasVinculosTarifasObs(TrdFinNegocInclVO finDiretoVO, TrdFinNegPrecificacaoVO precificacaoVO);
    
    /**
     * Nome: alterarFluxoPagtoPrincJuros
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegFluxoPagtoVO alterarFluxoPagtoPrincJuros(TrdFinNegFluxoPagtoVO flxPgtVO, List<TrdFinNegMercadoriaVO> listaMercadoria);

    /**
     * Nome: alterarFluxoPagtoComissaoInternaFinOuRefinDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegComissaoVO alterarFluxoPagtoComissaoInterna(TrdFinNegComissaoVO comissaoVO, Integer codProduto);

    /**
     * Nome: alterarFluxoPagtoComissaoExternaFinOuRefinDireto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegComissaoVO alterarFluxoPagtoComissaoExterna(TrdFinNegComissaoVO comissaoVO, Integer codProduto);

    
    /**
     * Nome: fluxoValidacao
     * 
     * Propï¿½sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 02/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrï¿½o hexavision.
     */
    public String fluxoValidacao(TrdFinNegocInclVO finDiretoVO,
                    TrdFinNegPrecificacaoVO precifVO,
                    Integer tipoAcesso,
                    List<TradeFinanceDesembolsoVO> listaDesembolso);
    
    /**
    * Nome: calcTaxasForfaiting
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 13/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public Boolean calcTaxasForfaiting(TaxasForfaitingVO TxVO);
    
    /**
     * Nome: incluirForfaiting
     * 
     * Propósito: Incluir cotação Forfaiting
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO incluirForfaiting(TrdFinNegocInclVO finIndiretoVO);

    /**
    * Nome: incluirDesembolsoForfaiting
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 14/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void incluirDesembolsoForfaiting(TradeFinanceDesembolsoVO desembolsoVO);
    
    /**
    * Nome: incluirDadosBasicosGp1Gp3
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 20/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public TrdFinNegocInclVO incluirDadosBasicosGp1Gp3(TrdFinNegocInclVO finDiretoVO) throws NpccTradeWebException;

    /**
     * Nome: alterarDadosBasicosGp1Gp3
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 20/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public TrdFinNegocInclVO alterarDadosBasicosGp1Gp3(TrdFinNegocInclVO finDiretoVO, TradeFinanceVO dadosBasicos);
    
    
    /**
    * Nome: incluirAlterarObservacoesCotacao
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 31/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void incluirAlterarObservacoesCotacao(ObservacoesCotacaoVO obsVO);

    /**
     * Nome: calcCustoTotalForfaiting
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 01/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String calcCustoTotalForfaiting(TrdFinNegPrecificacaoVO trdFinNegPrecificacaoVO, TrdFinNegocInclVO custoTotalForfaiting,
                    String vtxspreadnegoc,
                    String vtravaliborcmbio,
                    Integer przliborcmbio,
                    String vtxliborcmbio);
    
    /**
    * Nome: calcularSomatoria
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 16/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public Double calcularSomatoria(Double juros, Double pagamento);
    

    /**
    * Nome: alterarDesembolsoEouMercadoriaForfainting
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 25/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void alterarDesembolsoEouMercadoriaForfainting(TradeFinanceDesembolsoVO desembolsoVO,
                    List<TrdFinNegMercadoriaVO> listaMercadoria);
    
    /**
    * Nome: incluirParcelasDesembolso
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 24/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void incluirParcelasDesembolso (Long numBoleto, String registroManutencao, List<ParcelaVO> listaParcelas);
    
    /**
    * Nome: calcularPrazoTotalOperacaoLC
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 27/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public int calcularPrazoTotalOperacaoLC(CalcPrazoTotalOperLcVO calcPrazoTotalOperLcVO);

    /**
    * Nome: incluirAlterarDespesasFunindgLC
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 24/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void incluirAlterarDespesasFundingLC(Long numBoleto, String registroManutencao, ListaCotacoesExternasVO cotacaoFunding, String flagProc);        

    /**
    * Nome: calcularPrazosMediosOperacaoDesembolso
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 11/07/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public Boolean calcularPrazosMediosOperacaoDesembolso(TrdFinNegFluxoPagtoVO flxPagtoVO,
                    List<TrdFinNegFluxoPagtoVO> listaFluxo);

    /**
    * Nome: calcularPrazoMedioComAnaliseFluxoPagto
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 03/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public Boolean calcularPrazoMedioComAnaliseFluxoPagto(TrdFinNegFluxoPagtoVO flxPagtoVO,
                    TrdFinNegocInclVO trdFinNegVO);
    
    /**
     * Nome: incluirComplGarantia
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 13/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String incluirComplGarantia(TrdFinNegocInclVO saida, Long nbletonegoccmbio);
    
    	/**
    	* Nome: alterarComplGarantia
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 25/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public String alterarComplGarantia (TrdFinNegocInclVO saidaDados, Long nbletonegoccmbio);
    
    	/**
    	* Nome: obterBeneficiarioAfiancador
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 25/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public BeneficiarioVO obterBeneficiario(TrdFinNegMercadoriaVO saida, Integer flagbeneorafia);
    
    
    	/**
    	* Nome: obterAfiancador
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public BeneficiarioVO obterAfiancador(TradeFinNegocListasVO saida, Integer flagbeneorafia);

	/**
	* Nome: fluxoValidacaoPagamento
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 10/10/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	public Integer fluxoValidacaoPagamento(TrdFinNegocInclVO tradeFinNegocVO);

	/**
    * Nome: operVinculadaLcIncl
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 31/05/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void operVinculadaLcIncl(VincularOperacaoLcVO vo);
    
    /**
     * Nome: validStatusVinculoLc
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 31/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public VincularOperacaoLcVO validStatusVinculoLc(VincularOperacaoLcVO vo);
     
     /**
      * Nome: inecIndicadorEconomico
      * 
      * Propósito: 
      *
      * @param : 
      * @return : 
      * @throws :
      * @exception : 
      * @see : Referencias externas.  
      *
      * Registro  de Manutenção: 13/12/2016
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequação ao padrão hexavision.
      */
     public Integer inecIndicadorEconomico(Integer ecindcdeconm);
     
     /**
      * Nome: desfazimentoIncl
      * 
      * Proposito: Desfazer Inclusão
      *
      * @param :
      * @return :
      * @throws :
      * @exception :
      * @see : Referencias externas.
      *
      *      Registro de Manutenção: 26/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
      */
     public Long desfazimentoIncl(Long nbletonegcmbio);
     
     /**
      * Nome: desfazimentoAlt
      * 
      * Proposito: Desfazer Alteração
      *
      * @param :
      * @return :
      * @throws :
      * @exception :
      * @see : Referencias externas.
      *
      *      Registro de Manutenção: 26/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
      */
     public Long desfazimentoAlt(Long nbletonegcmbio);
     
     /**
      * Nome: baixarSaldoForfaiting
      * 
      * Propósito: 
      *
      * @param : 
      * @return : 
      * @throws :
      * @exception : 
      * @see : Referencias externas.  
      *
      * Registro  de Manutenção: 24/06/2016
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequação ao padrão hexavision.
      */
     public void baixarSaldoForfaiting(TrdFinNegocInclVO negociacaoVO, TradeFinanceDesembolsoVO desembVO);
     
     /**
      * Nome: somaAboutValorLimite
      * 
      * Propósito: Somar o percentual do about no valor na moeda do limite
      *
      * @param :
      * @return :
      * @throws :
      * @exception :
      * @see : Referencias externas.
      *
      *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
      */
     public String somaAboutValorLimite(TrdFinNegocInclVO negocInclVO);
     
     /**
      * Nome: consultarSituacaoPiloto
      * 
      * Propósito: 
      *
      * @param : 
      * @return : 
      * @throws :
      * @exception : 
      * @see : Referencias externas.  
      *
      * Registro  de Manutenção: 16/05/2017
      *        - Autor: BRQ
      *        - Responsavel: Equipe Web
      *        - Adequação ao padrão hexavision.
      */
     public InformacaoPilotoVO consultarSituacaoPiloto(Long codigoUnicoCliente);


     public TrdFinNegFluxoPagtoVO alterarFluxoPagtoPrincJurosCtcPend(TrdFinNegFluxoPagtoVO itemDesembolso, List<MercadoriaVO> listaSelMercadoria);
}
