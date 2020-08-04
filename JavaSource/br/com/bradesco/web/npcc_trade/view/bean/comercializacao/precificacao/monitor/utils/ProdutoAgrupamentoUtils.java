package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.utils;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;

/**
 * 
  * Nome: ProdutoAgrupamentoUtils.java
  * 
  * Propósito: <p> Classe utilitaria para o agrupamentos </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 04/02/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class ProdutoAgrupamentoUtils {

    /**
     * 
    	* Nome: obterCodigoGrupo
    	* 
    	* Propósito: Obter codigo de agrupamento do produto 
    	*
    	* @param : codigoProduto
    	* @return : codigo do agrupamento
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 04/02/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
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
