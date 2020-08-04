package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexListVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.StatusBolAtzFiltroVO;

/**
 * 
 * Nome: BolAgexListService.java
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
 *      Registro de Manuten��o: 18/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
 */
public interface BolAgexListService {

	/**
	 * 
	 * Nome: incluirBoletoAgex
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 23/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public String incluirBoletoAgex(BolAgexFiltroVO filtroVO);

	/**
	 * 
	 * Nome: detalharBoletoAgex
	 * 
	 * Prop�sito: Recuperar informa��es detalhadas de boleto AGEX
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
	 *      Registro de Manuten��o: 29/07/2015 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public BolAgexVO detalharBoletoAgex(Integer codModeloBoleto);

	/**
	 * 
	 * Nome: capturarMensagemRetorno
	 * 
	 * Prop�sito: Capturar Mensagem de retorno de transa��o Mainframe
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public String capturarMensagemRetorno();

	/**
	 * 
	 * Nome: pesquisar
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public BolAgexVO pesquisar(BolAgexFiltroVO filtroVO ,String stateId);

	/**
	 * 
	 * Nome: excluirConfirm
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 19/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public String excluirConfirm(StatusBolAtzFiltroVO filtroVO);

	/**
	 * 
	 * Nome: consultaLogPesquisar
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manuten��o: 22/04/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequa��o ao padr�o hexavision.
	 */
	public BolAgexVO consultaLogPesquisar(BolAgexFiltroVO filtroVO);

}
