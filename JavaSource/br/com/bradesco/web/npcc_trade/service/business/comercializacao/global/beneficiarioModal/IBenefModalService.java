package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.beneficiarioModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;

public interface IBenefModalService extends Serializable {
	
	public List<TradeFinNegocListasVO> getListaBeneficiario(TrdFinNegMercadoriaVO filtro);

}
