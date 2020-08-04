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
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 13/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<OperacoesPendVO> getOperacoesPend(OperacoesPendViewHelper operPend);
	
    /**
     * Nome: getOperacoesPendTotais
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 13/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */ 
	public List<OperacoesPendTotaisVO> getOperacoesPendTotais(OperacoesPendViewHelper operPendTotais, Integer flagLista);
	
	
	   /**
	    * Nome: pesquisarCotacoesExportacao
	    * 
	    * Prop�sito: 
	    *
	    * @param : 
	    * @return : 
	    * @throws :
	    * @exception : 
	    * @see : Referencias externas. 
	    *
	    * Registro  de Manuten��o: 08/07/2016
	    *        - Autor: BRQ
	    *        - Responsavel: Equipe Web
	    *        - Adequa��o ao padr�o hexavision.
	    */
	   public List<OperacoesPendVO> pesquisarCotacoesExportacao(OperacoesPendViewHelper operPend);
	
}
