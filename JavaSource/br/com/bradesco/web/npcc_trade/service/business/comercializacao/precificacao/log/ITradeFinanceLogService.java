package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean.ListaHistoricoTarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;

/**
  * Nome: ITradeFinanceLogService.java
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
  * Registro  de Manutenção: 11/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public interface ITradeFinanceLogService extends Serializable {
    
    /**
     * 
     * Nome: getMsgRetorno
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
     */
    String getMsgRetorno();
    
    
    /**
     * 
     * Nome: Listar os LOGS
     * Prop�sito: 
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
    * Prop�sito: 
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
    * Prop�sito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manuten��o: 23/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequa��o ao padr�o hexavision.
    */
   public List<ListaHistoricoTarifaVO> obterHistoricoTarifaLog(TradeFinanceListaVO listaVO);
   
   /**
    * Nome: pesquisar dados do LOG
    * 
    * Prop�sito:
    *
    * @param :
    * @return :
    * @throws :
    * @exception :
    * @see : Referencias externas.
    *
    *      Registro de Manuten��o: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o
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
    *      Registro de Manuten��o: 12/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o
    *      hexavision.
    */

   public List<TradeFinanceListaVO> confirmarLogDetalhe(Long nBleto, Long nbletoAno);


}
