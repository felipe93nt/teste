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
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 04/03/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public interface IGarantiasModalService extends Serializable {

	/**
    * 
   	* Nome: getGarantiaAdicionais
   	* 
   	* Propósito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manutenção: 04/02/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequação ao padrão hexavision.
    */
   public List<GarantiasVO> getGarantiaAdicionais(Long nbletonegoccmbio, String hinclreghist);
   
   /**
    * 
   	* Nome: getGarantiasAprovList
   	* 
   	* Propósito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manutenção: 04/02/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequação ao padrão hexavision.
    */
   public List<GarantiasVO> getGarantiasAprovList(Long nbletonegoccmbio, String horalogmanut);
   
   /**
    * 
   	* Nome: getGarantiasAvaList
   	* 
   	* Propósito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manutenção: 04/02/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequação ao padrão hexavision.
    */
   public List<GarantiasAvaListaVO> getGarantiasAvaList(Long nbletonegoccmbio, String hinclreghist);

   /**
	 * 
	* Nome: getAvalistasAprLmtCreditoList
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 22/02/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	 */
   public List<GarantiasAvaAprLmtCreditoVO> getAvalistasAprLmtCreditoList(Long nseqcontrlim, Long nppstapontucmbio, 
           Integer ccpfcnpj, Integer cflialcnpj, Integer cctrlcpfcnpj);
   
   /**
    * 
   	* Nome: getGarantiasAprovadasInclusao
   	* 
   	* Propósito: 
   	*
   	* @param : 
   	* @return : 
   	* @throws :
   	* @exception : 
   	* @see : Referencias externas.	
   	*
   	* Registro  de Manutenção: 14/03/2016
   	*        - Autor: BRQ
   	*        - Responsavel: Equipe Web
   	*        - Adequação ao padrão hexavision.
    */
   public List<GarantiasVO> getGarantiasAprovadasInclusao(Integer codProd, 
			Integer cpfCnpj, Integer cFilial, Integer ctrl, Long ncontrlim, Long nppstapontucmbio);
	
	/**
	 * 
		* Nome: getAvalistasCadastroInclusao
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 22/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public List<GarantiasAvaListaVO> getAvalistasCadastroInclusao(Long cunicpssoa, Integer ctpovnclo);
 
   
}
