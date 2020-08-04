package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.modeloBoletoModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;

public interface IModeloBoletoModalService extends Serializable {
	
	/**
	 * 
		* Nome: getListaModBoleto
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
	 */
	public List<ModeloBoletoVO> getListaModBoleto(ModeloBoletoVO modeloBoletoVO);
}
