package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operadorModal.bean.OperadorVO;

public interface IOperadorModalService extends Serializable {

	public List<OperadorVO> pesquisarOperador(OperadorVO operadorVO);
}
