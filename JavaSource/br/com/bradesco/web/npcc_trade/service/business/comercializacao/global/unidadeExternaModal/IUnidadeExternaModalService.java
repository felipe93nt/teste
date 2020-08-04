package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;

public interface IUnidadeExternaModalService extends Serializable {
	
	/**
	 * 
		* Nome: getListaUniExterna
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 18/04/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<UnidadeExternaVO> getListaUniExterna(UnidadeExternaVO unidadeExternaVO, Integer bcCorrDesemb);
}
