package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal;

import java.io.Serializable;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;

public interface IComissaoInternaExternaModalService extends Serializable {

	public Boolean gerarParcelasComissaoExterna(TrdFinNegComissaoVO ComissaoVO);
	
	/**
     * Nome: getComissaoInterna
     * 
     * Propósito: Gerar itens da lista de Comissão Interna
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrï¿½o hexavision.
     */
    public Boolean getComissaoInterna(TrdFinNegComissaoVO comissaoVO, 
            TrdFinNegFluxoPagtoVO fluxoPagamento);
	
	public void  calcularDataVencimentoOuPrazo(TrdFinNegComissaoVO flxPgtVO, TrdFinNegParcelaVO irregularVO);

	public Boolean calculoJuros(TrdFinNegComissaoVO itemComissaoInterna, TrdFinNegFluxoPagtoVO itemListaFluxoPgto, String taxaDeJuros);
}
