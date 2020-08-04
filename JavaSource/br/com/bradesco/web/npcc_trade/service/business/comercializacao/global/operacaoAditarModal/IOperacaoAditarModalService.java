package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.operacaoAditarModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.OperacaoAditarVO;

public interface IOperacaoAditarModalService extends Serializable{
	
	public List<OperacaoAditarVO> getOperacoes(OperacaoAditarVO OpVcVO);

}
