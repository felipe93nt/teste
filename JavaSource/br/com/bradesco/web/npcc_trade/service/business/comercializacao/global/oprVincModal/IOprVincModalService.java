package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.oprVincModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegOperVincVO;

public interface IOprVincModalService extends Serializable{
	
	public List<TrdFinNegOperVincVO> getOperacoesVinculadas(TrdFinNegOperVincVO OpVcVO);

}
