/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common
 * 
 * Prop�sito: Uso exclusivo do Bradesco, cont�m
 *            informa��es a respeito do Cambio.
 * 
 * Data da Cria��o: 25/08/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compila��o -d
 */
package br.com.bradesco.web.npcc_trade.service.business.global.common;

import java.util.Date;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.bean.OperadorVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MotivoPerdaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ComboCotacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ComboTipoDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegPrecificacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboModalidadeVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboMoedaOperacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboMoedaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboPaisRestricaoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboPaisVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboProdutoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboSegmentoVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoGarantiaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboUnidadeNegocioVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ListaSituacaoBoletoVO;

/**
 * Nome: ICommonService.java
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
 *      Registro de Manuten��o: 25/08/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */
public interface ICommonService {

    /**
     * Nome: getComboMoeda
     * 
     * Prop�sito: Carrega o Combo de Moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    List<ComboMoedaVO> getComboMoeda();

    /**
     * Nome: getComboPais
     * 
     * Prop�sito: Carrega o Combo de Pais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    List<ComboPaisVO> getComboPais(Integer cpais, String tipoCombo);
    
    /**
     * 
     * Nome: detalhar Prop�sito: detalhar PaisVO
     *
     * @param : Integer
     * @return : PaisVO
     *
     * @throws : NpcdServiceBusinessException
     * 
     * @exception : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public ComboPaisVO getDetalhesPais(Integer id);

    /**
     * 
     * Nome: getComboTipoClausulaVOs
     * 
     * Prop�sito: Carrega o Combo do Tipo Clausula
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public List<ComboTipoClausulaVO> getComboTipoClausulasVO();
    
    /**
     * 
     * Nome: getComboTipoClausulaVOs
     * 
     * Prop�sito: Carrega o Combo do Tipo Clausula
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public List<ComboModeloBoletoVO> getComboModeloBoletoVO(Integer codProduto);

	/**
	* Nome: getComboProduto
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 14/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
    public List<ComboProdutoVO> getComboProduto(Integer codMesa,
    		Integer ProntoOuFuturo, Integer CompraOuVenda);

	/**
	* Nome: getComboMoedaOperacao
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 17/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
    public List<ComboMoedaOperacaoVO> getComboMoedaOperacao(Integer codProduto);
    
	/**
	* Nome: getComboPeriodicidade
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 23/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
	public List<ComboCotacaoVO> getComboPeriodicidade(Integer codFluxo);

	/**
	* Nome: getComboTipoComissoes
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 22/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
	public List<ComboCotacaoVO> getComboTipoComissoes(Integer codProduto, Integer tela);
    
    /**
     * Nome: getComboClausulaVO
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manuten��o: 17/12/2015
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<ComboClausulaVO> getComboClausulaVO(Integer codTipoClausula);

	/**
	* Nome: getListaUniExterna
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 24/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
    public List<TradeFinNegocListasVO> getListaUniExterna(TrdFinNegPrecificacaoVO filtro);
	
    /**
     * Nome: getComboMoeda
     * 
     * Prop�sito: Carrega o Combo de Moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    List<MotivoPerdaVO> getComboMotivoPerda(Integer codIdt);

	/**
	* Nome: getComboTarifas
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 12/01/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
	public List<ComboCotacaoVO> getComboTarifas(Integer codProduto, String filtro);
	
	/**
	 * 
		* Nome: getComboSegmento
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 26/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<ComboSegmentoVO> getComboSegmento();
	
	/**
	 * 
		* Nome: getComboPaisRestricao
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 26/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<ComboPaisRestricaoVO> getComboPaisRestricao();
	
	/**
	 * 
		* Nome: listarPaginacaoAutomaticaUnidExterna
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 29/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<TradeFinNegocListasVO> listarPaginacaoAutomaticaUnidExterna();
	
	/**
	 * 
		* Nome: getUnidadeNegocioList
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 29/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<ComboUnidadeNegocioVO> getComboUnidadeNegocioList();
	
	/**
	 * 
		* Nome: getListaSituacaoBoleto
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 29/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<ListaSituacaoBoletoVO> getListaSituacaoBoleto(Integer codMesa, Integer csitbleto);

    /**
     * 
     * Nome: getListaSituacaoBoletoAgex
     * 
     * Prop�sito: Retorna lista de situa��o para Trade - Boleto Agex - Consulta
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 29/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
//	public List<ListaSituacaoBoletoVO> getListaSituacaoBoletoAgex(Integer codMesa, Integer csitbleto, String ctipoPesquisa);	
	public List<ListaSituacaoBoletoVO> getListaSituacaoBoletoAgex(Integer codMesa, Integer csitbleto, Integer ctipoPesquisa);	
	
	
	/**
	* Nome: detalharTarifaDespesa
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 08/03/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	*/
	public TrdFinNegTarifaVO detalharTarifaDespesa(Long cusuarlimcmbio,
		Integer ctpodespcmbio, String dtpodespcmbio, String ntpositcmbio);
	
	/**
	 * 
		* Nome: listarGarantiasAdicionais
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 08/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<ComboTipoGarantiaVO> listarGarantiasAdicionais(Integer cdProd);

    /**
    * Nome: getDataLimiteCotacao
    * 
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 05/04/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
	public Date getDataLimiteCotacao(Date dataAtual);
	
    /**
     * Nome: getDataLimiteCotacao
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: /04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public Date getDataVencimentoSaque(Date dataAtual, Integer tpliquidacao, Integer prazoletras);
	
    /**
     * Nome: getPrazoFinanciamento
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     */
    public Integer getPrazoFinanciamento(Date dataDesenbolso, Integer tpliquidacao, Date dataVencimento);
	
    /**
     * Nome: getDataVencimentoFianca
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manuten��o: 12/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public Date getDataVencimentoFianca(Date dataPrevistaEmissao, int diasPrazoOperacao);

    /**
     * 
     * Nome: getComboTomador
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 04/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adeq/o/oua��o ao padr�o hexavision.
     */
    public List<TradeFinanceListaVO> getComboTomador(Long aprovCredito);
    
    /**
    * Nome: getComboModalidade
    * 
    * Prop�sito: Carrega a lista de modalidades
    *
    * @param : cprodtservc
    * @return : List<ComboModalidadeVO> 
    * @see : Referencias externas.  
    *
    */
    public List<ComboModalidadeVO> getComboModalidade(Integer cprodtservc);
    
    /**
     * 
     * Nome: getComboOperador
     * Prop�sito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<OperadorVO> getComboOperador();
    
    /**
     * 
     * Nome: getComboTipoDespesas
     * Prop�sito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     *
     * @throws :
     * 
     * @exception : 
     *
     * @see : Referencias externas. 
     *
     * Registro  de Manuten��o: 22/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public List<ComboTipoDespesasVO> getComboTipoDespesas();   
    
    /**
     * Nome: validarDiaUtil
     * 
     * Prop�sito: Verifica se a data � dia �til no pais informado.
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 14/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public Boolean validarDiaUtil(Date data, Integer pais, String tpodata, Integer cpaisInec, Integer cpaisbenef, Integer cindcdeconmmoeda);
}
