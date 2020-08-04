package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;

public interface IUnidadeExternaModalService extends Serializable {
	
	/**
	 * 
		* Nome: getListaUniExterna
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 18/04/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<UnidadeExternaVO> getListaUniExterna(UnidadeExternaVO unidadeExternaVO, Integer bcCorrDesemb);
}
