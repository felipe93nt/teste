package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean.EstatisticaCotacoesVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean.EstatisticasCotacoesFechadaPerdidaVO;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;

public interface IEstatisticasCotacoesService extends Serializable  {

	
    /**
     * Nome: getEstatisticasCotacoes
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/08/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public EstatisticaCotacoesVO getEstatisticasCotacoes(CalendarioPeriodo filtroData, Integer tipoPesquisa);
    public List<EstatisticasCotacoesFechadaPerdidaVO> getEstatisticasCotacoesFechadasPerdidas(Integer anoBase);
    
    
}
