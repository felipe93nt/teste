package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.ListaHistoricoTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;

/**
  * Nome: ITradeFinanceLogService.java
  * 
  * PropÃ³sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilaÃ§Ã£o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de ManutenÃ§Ã£o: 11/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrÃ£o hexavision.
*/
public interface ITradeFinanceLogService extends Serializable {
    
    /**
     * 
     * Nome: getMsgRetorno
     * Propï¿½sito: 
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
     */
    String getMsgRetorno();
    
    
    /**
     * 
     * Nome: Listar os LOGS
     * Propï¿½sito: 
     *
     * @param : 
     *       <BR/>
     * @return : 
     * @throws :
     * @exception : 
     *
     */
   List<TradeFinanceListaVO> listar(TradeFinanceFiltroVO filtro);
   
   
   /**
    * 
    * Nome: Confirmar os LOGS 
    * Propï¿½sito: 
    *
    * @param : 
    *       <BR/>
    * @return : 
    * @throws :
    * @exception : 
    *
    */
   
   public List<TradeFinanceListaVO> confirmar(Long nBleto, Long nbletoAno);
   
   
   /**
    * Nome: obterHistoricoTarifaLog
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 23/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
   public List<ListaHistoricoTarifaVO> obterHistoricoTarifaLog(TradeFinanceListaVO listaVO);
   
   /**
    * Nome: pesquisar dados do LOG
    * 
    * Propï¿½sito:
    *
    * @param :
    * @return :
    * @throws :
    * @exception :
    * @see : Referencias externas.
    *
    *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o
    *      hexavision.
    */
   public List<TradeFinanceListaVO> listarCotacoesExportacao(TradeFinanceFiltroVO filtro);
   
   /**
    * Nome: confirmar Log
    * 
    * Proposito: exportar lista de registro para excel
    *
    * @param :
    * @return :
    * @throws :
    * @exception :
    * @see : Referencias externas.
    *
    *      Registro de Manutenção: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão
    *      hexavision.
    */

   public List<TradeFinanceListaVO> confirmarLogDetalhe(Long nBleto, Long nbletoAno);


}
