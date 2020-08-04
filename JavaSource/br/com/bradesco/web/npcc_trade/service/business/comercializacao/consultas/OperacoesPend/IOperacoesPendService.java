package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend;

import java.io.Serializable;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.bean.OperacoesPendTotaisVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.bean.OperacoesPendVO;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.operacoesPend.OperacoesPendViewHelper;



public interface IOperacoesPendService  extends Serializable{

    /**
     * Nome: getOperacoesPend
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<OperacoesPendVO> getOperacoesPend(OperacoesPendViewHelper operPend);
	
    /**
     * Nome: getOperacoesPendTotais
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 13/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */ 
	public List<OperacoesPendTotaisVO> getOperacoesPendTotais(OperacoesPendViewHelper operPendTotais, Integer flagLista);
	
	
	   /**
	    * Nome: pesquisarCotacoesExportacao
	    * 
	    * Propósito: 
	    *
	    * @param : 
	    * @return : 
	    * @throws :
	    * @exception : 
	    * @see : Referencias externas. 
	    *
	    * Registro  de Manutenção: 08/07/2016
	    *        - Autor: BRQ
	    *        - Responsavel: Equipe Web
	    *        - Adequação ao padrão hexavision.
	    */
	   public List<OperacoesPendVO> pesquisarCotacoesExportacao(OperacoesPendViewHelper operPend);
	
}
