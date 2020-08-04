package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.fluxoPgtoModal;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;

public interface IFluxoPgtoModalService {
    
    /**
    * Nome: calcularDataVencimentoOuPrazo
    * 
    * Propósito: 
     * @param linhaAlterada 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 11/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void  calcularDataVencimentoOuPrazo(TrdFinNegFluxoPagtoVO flxPgtVO, TrdFinNegParcelaVO irregularVO);
    
    /**
    * Nome: calcularDataVencimentoOuPrazo
    * 
    * Propósito: 
     * @param linhaAlterada 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 11/08/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void  calcularDataVencimentoOuPrazoLinha(TrdFinNegocInclVO tradeFinNegocVO, TrdFinNegFluxoPagtoVO flxPgtVO, TrdFinNegParcelaVO irregularVO, Integer linhaAlterada);
}
