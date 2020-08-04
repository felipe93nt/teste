/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.global.common
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 25/08/2015
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
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
 *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public interface ICommonService {

    /**
     * Nome: getComboMoeda
     * 
     * Propósito: Carrega o Combo de Moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    List<ComboMoedaVO> getComboMoeda();

    /**
     * Nome: getComboPais
     * 
     * Propósito: Carrega o Combo de Pais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    List<ComboPaisVO> getComboPais(Integer cpais, String tipoCombo);
    
    /**
     * 
     * Nome: detalhar Propósito: detalhar PaisVO
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
     *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public ComboPaisVO getDetalhesPais(Integer id);

    /**
     * 
     * Nome: getComboTipoClausulaVOs
     * 
     * Propósito: Carrega o Combo do Tipo Clausula
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */

    public List<ComboTipoClausulaVO> getComboTipoClausulasVO();
    
    /**
     * 
     * Nome: getComboTipoClausulaVOs
     * 
     * Propósito: Carrega o Combo do Tipo Clausula
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */

    public List<ComboModeloBoletoVO> getComboModeloBoletoVO(Integer codProduto);

	/**
	* Nome: getComboProduto
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 14/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public List<ComboProdutoVO> getComboProduto(Integer codMesa,
    		Integer ProntoOuFuturo, Integer CompraOuVenda);

	/**
	* Nome: getComboMoedaOperacao
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 17/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public List<ComboMoedaOperacaoVO> getComboMoedaOperacao(Integer codProduto);
    
	/**
	* Nome: getComboPeriodicidade
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 23/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	public List<ComboCotacaoVO> getComboPeriodicidade(Integer codFluxo);

	/**
	* Nome: getComboTipoComissoes
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 22/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	public List<ComboCotacaoVO> getComboTipoComissoes(Integer codProduto, Integer tela);
    
    /**
     * Nome: getComboClausulaVO
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 17/12/2015
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ComboClausulaVO> getComboClausulaVO(Integer codTipoClausula);

	/**
	* Nome: getListaUniExterna
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 24/12/2015
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public List<TradeFinNegocListasVO> getListaUniExterna(TrdFinNegPrecificacaoVO filtro);
	
    /**
     * Nome: getComboMoeda
     * 
     * Propósito: Carrega o Combo de Moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 25/08/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    List<MotivoPerdaVO> getComboMotivoPerda(Integer codIdt);

	/**
	* Nome: getComboTarifas
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 12/01/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	public List<ComboCotacaoVO> getComboTarifas(Integer codProduto, String filtro);
	
	/**
	 * 
		* Nome: getComboSegmento
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 26/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<ComboSegmentoVO> getComboSegmento();
	
	/**
	 * 
		* Nome: getComboPaisRestricao
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 26/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<ComboPaisRestricaoVO> getComboPaisRestricao();
	
	/**
	 * 
		* Nome: listarPaginacaoAutomaticaUnidExterna
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 29/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<TradeFinNegocListasVO> listarPaginacaoAutomaticaUnidExterna();
	
	/**
	 * 
		* Nome: getUnidadeNegocioList
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 29/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<ComboUnidadeNegocioVO> getComboUnidadeNegocioList();
	
	/**
	 * 
		* Nome: getListaSituacaoBoleto
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 29/02/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<ListaSituacaoBoletoVO> getListaSituacaoBoleto(Integer codMesa, Integer csitbleto);

    /**
     * 
     * Nome: getListaSituacaoBoletoAgex
     * 
     * Propósito: Retorna lista de situação para Trade - Boleto Agex - Consulta
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
//	public List<ListaSituacaoBoletoVO> getListaSituacaoBoletoAgex(Integer codMesa, Integer csitbleto, String ctipoPesquisa);	
	public List<ListaSituacaoBoletoVO> getListaSituacaoBoletoAgex(Integer codMesa, Integer csitbleto, Integer ctipoPesquisa);	
	
	
	/**
	* Nome: detalharTarifaDespesa
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 08/03/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	public TrdFinNegTarifaVO detalharTarifaDespesa(Long cusuarlimcmbio,
		Integer ctpodespcmbio, String dtpodespcmbio, String ntpositcmbio);
	
	/**
	 * 
		* Nome: listarGarantiasAdicionais
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 08/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<ComboTipoGarantiaVO> listarGarantiasAdicionais(Integer cdProd);

    /**
    * Nome: getDataLimiteCotacao
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 05/04/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
	public Date getDataLimiteCotacao(Date dataAtual);
	
    /**
     * Nome: getDataLimiteCotacao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: /04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Date getDataVencimentoSaque(Date dataAtual, Integer tpliquidacao, Integer prazoletras);
	
    /**
     * Nome: getPrazoFinanciamento
     * 
     * Propósito: 
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
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     * Registro  de Manutenção: 12/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public Date getDataVencimentoFianca(Date dataPrevistaEmissao, int diasPrazoOperacao);

    /**
     * 
     * Nome: getComboTomador
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adeq/o/ouação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> getComboTomador(Long aprovCredito);
    
    /**
    * Nome: getComboModalidade
    * 
    * Propósito: Carrega a lista de modalidades
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
     * Propósito: 
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
     * Registro  de Manutenção: 21/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<OperadorVO> getComboOperador();
    
    /**
     * 
     * Nome: getComboTipoDespesas
     * Propósito: 
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
     * Registro  de Manutenção: 22/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public List<ComboTipoDespesasVO> getComboTipoDespesas();   
    
    /**
     * Nome: validarDiaUtil
     * 
     * Propósito: Verifica se a data é dia útil no pais informado.
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean validarDiaUtil(Date data, Integer pais, String tpodata, Integer cpaisInec, Integer cpaisbenef, Integer cindcdeconmmoeda);
}
