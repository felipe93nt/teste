package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.utils;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;

/**
 * 
  * Nome: ProdutoAgrupamentoUtils.java
  * 
  * Prop�sito: <p> Classe utilitaria para o agrupamentos </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 04/02/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
 */
public class ProdutoAgrupamentoUtils {

    /**
     * 
    	* Nome: obterCodigoGrupo
    	* 
    	* Prop�sito: Obter codigo de agrupamento do produto 
    	*
    	* @param : codigoProduto
    	* @return : codigo do agrupamento
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 04/02/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
     */
    public static Integer obterCodigoGrupo(Integer codigoProduto){
        
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ProdutoAgrupamentoUtils.obterCodigoGrupo <<<<<<<<<<<");
    		
    		Integer codigoAgrupamento = null;
    		
    		for(EnumProduto produtoEnum : EnumProduto.values()){
    			if(produtoEnum.getCodigo().equals(codigoProduto)){
    				codigoAgrupamento = produtoEnum.getCodigo();
    				break;
    			}
    		}
    		return codigoAgrupamento;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ProdutoAgrupamentoUtils.obterCodigoGrupo <<<<<<<<<<<");
    	}
    	
    }
}
