package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer.bean.CotacoesaVencerVO;

public interface ICotacoesaVencerService extends Serializable  {

	
    /**
     * Nome: getCotacoesaVencer
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/08/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<CotacoesaVencerVO> getCotacoesaVencer(Integer qtddias);
    
    
}
