package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaAprLmtCreditoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;

/**
 * 
  * Nome: IGarantiasModalService.java
  * 
  * Prop�sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 04/03/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
 */
public interface IGarantiasModalService extends Serializable {

	/**
    * 
   	* Nome: getGarantiaAdicionais
   	* 
   	* Prop�sito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manuten��o: 04/02/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequa��o ao padr�o hexavision.
    */
   public List<GarantiasVO> getGarantiaAdicionais(Long nbletonegoccmbio, String hinclreghist);
   
   /**
    * 
   	* Nome: getGarantiasAprovList
   	* 
   	* Prop�sito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manuten��o: 04/02/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequa��o ao padr�o hexavision.
    */
   public List<GarantiasVO> getGarantiasAprovList(Long nbletonegoccmbio, String horalogmanut);
   
   /**
    * 
   	* Nome: getGarantiasAvaList
   	* 
   	* Prop�sito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manuten��o: 04/02/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequa��o ao padr�o hexavision.
    */
   public List<GarantiasAvaListaVO> getGarantiasAvaList(Long nbletonegoccmbio, String hinclreghist);

   /**
	 * 
	* Nome: getAvalistasAprLmtCreditoList
	* 
	* Prop�sito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manuten��o: 22/02/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequa��o ao padr�o hexavision.
	 */
   public List<GarantiasAvaAprLmtCreditoVO> getAvalistasAprLmtCreditoList(Long nseqcontrlim, Long nppstapontucmbio, 
           Integer ccpfcnpj, Integer cflialcnpj, Integer cctrlcpfcnpj);
   
   /**
    * 
   	* Nome: getGarantiasAprovadasInclusao
   	* 
   	* Prop�sito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manuten��o: 14/03/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequa��o ao padr�o hexavision.
    */
   public List<GarantiasVO> getGarantiasAprovadasInclusao(Integer codProd, 
			Integer cpfCnpj, Integer cFilial, Integer ctrl, Long ncontrlim, Long nppstapontucmbio);
	
	/**
	 * 
		* Nome: getAvalistasCadastroInclusao
		* 
		* Prop�sito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 22/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public List<GarantiasAvaListaVO> getAvalistasCadastroInclusao(Long cunicpssoa, Integer ctpovnclo);
 
   
}
