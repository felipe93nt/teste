package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.agendaSwap.bean.BaixaSwapFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceListaVO;

public interface IAgendaSwapService extends Serializable {
       
    /**
     * Nome: getListaAgendaSwap
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<TradeFinanceListaVO> getListaAgendaSwap(TradeFinanceFiltroVO filtro);
    
    /**
     * Nome: baixar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String baixar(BaixaSwapFiltroVO filtro);
}
