package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexListVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.StatusBolAtzFiltroVO;

/**
 * 
 * Nome: BolAgexListService.java
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
 *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public interface BolAgexListService {

	/**
	 * 
	 * Nome: incluirBoletoAgex
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 23/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String incluirBoletoAgex(BolAgexFiltroVO filtroVO);

	/**
	 * 
	 * Nome: detalharBoletoAgex
	 * 
	 * Propósito: Recuperar informações detalhadas de boleto AGEX
	 *
	 * @param : filtroProduto
	 * @return : TradeFinBolAgexVO
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 29/07/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public BolAgexVO detalharBoletoAgex(Integer codModeloBoleto);

	/**
	 * 
	 * Nome: capturarMensagemRetorno
	 * 
	 * Propósito: Capturar Mensagem de retorno de transação Mainframe
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String capturarMensagemRetorno();

	/**
	 * 
	 * Nome: pesquisar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public BolAgexVO pesquisar(BolAgexFiltroVO filtroVO ,String stateId);

	/**
	 * 
	 * Nome: excluirConfirm
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String excluirConfirm(StatusBolAtzFiltroVO filtroVO);

	/**
	 * 
	 * Nome: consultaLogPesquisar
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public BolAgexVO consultaLogPesquisar(BolAgexFiltroVO filtroVO);

}
