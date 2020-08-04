package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.funding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.constants.Numeros;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FundingVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.TradeFinanceBean;

/**
  * Nome: TradeFinFundingBean.java
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
  * Registro  de Manutenção: 01/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named("tradeFinFundingBean")
@SessionScoped
public class TradeFinFundingBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = -8792398111399108090L;
	
	private FundingVO fundingVO = new FundingVO();
	private List<SelectItem> moedaList = new ArrayList<SelectItem>();
	private TradeFinFundingViewHelper viewHelper = new TradeFinFundingViewHelper(); 
	
	@Inject
    @Named("tradeFinanceBean")
    private TradeFinanceBean tradeFinanceBean;
	
	@Inject
    @Named("tradeFinanceMonitService")
    private ITradeFinanceMonitService tradeFinanceMonitService;
	
	@Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;
	
	    /**
	     * Construtor
	     * 
	     * @param 
	     */
	public TradeFinFundingBean() {
		super();
	}
	
	/**
     * 
     * Nome: incluirReferencia
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirReferencia(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinFundingBean.incluirReferencia <<<<<<<<<<<");
    		
    		// valida campos obrigatórios
    		if (!SiteUtil.validarCampos("formTradeFinMonitDet")) {
    		    if (tradeFinanceBean.getTradeFinanceVO().getPcelasfndng().size() < Numeros.VINTE) {
    		        fundingVO.setdescreconmmoeda(descricaoMoeda(fundingVO.getcindcdeconmmoeda()));
    		        tradeFinanceBean.getTradeFinanceVO().getPcelasfndng().add(fundingVO);
    		        fundingVO = new FundingVO();
    		    }
    		}
    		

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinFundingBean.incluirReferencia <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
     * Nome: getSelectItemRef
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRef() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinFundingBean.getSelectItemRef <<<<<<<<<<<");
    		
    		List<SelectItem> list = new ArrayList<SelectItem>();
    		for (int index = 0; index < tradeFinanceBean.getTradeFinanceVO().getPcelasfndng().size(); index++) {
    			list.add(new SelectItem(index, ""));
    		}
    		return list;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinFundingBean.getSelectItemRef <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: excluirReferencia
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void excluirReferencia(AjaxBehaviorEvent ajaxBehaviorEvent) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinFundingBean.excluirReferencia <<<<<<<<<<<");
    		
    		if (viewHelper.getRefSelecionado() != null) {
    			tradeFinanceBean.getTradeFinanceVO().getPcelasfndng().remove(viewHelper.getRefSelecionado().intValue());
    			viewHelper.setRefSelecionado(null);
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinFundingBean.excluirReferencia <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
    	* Nome: confirmarFunding
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void confirmarFunding(ActionEvent ae) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinFundingBean.confirmarFunding <<<<<<<<<<<");
    		
    		viewHelper.setRenderModal(Boolean.TRUE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinFundingBean.confirmarFunding <<<<<<<<<<<");
    	}

    }
    
    /**
     * 
     * Nome: confirmarFundingIncl
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void confirmarFundingIncl() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinFundingBean.confirmarFundingIncl <<<<<<<<<<<");
            
            String result = "";
            
            viewHelper.setRenderModal(Boolean.FALSE);
            
            result = tradeFinanceMonitService.confirmarDadosFunding(tradeFinanceBean.getTradeFinanceVO().getNbletonegoccmbio(),
                    tradeFinanceBean.getTradeFinanceVO().getPcelasfndng(), tradeFinanceBean.getTradeFinanceVO().getVnegocmoedaestrg(), tradeFinanceBean.getTradeFinanceVO().getCindcdeconmmoeda());
            
            
         // Redireciona para a tela de consulta (Menu Dinâmico) 
            BradescoFacesUtils.addInfoModalMessage(result, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false); 

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinFundingBean.confirmarFundingIncl <<<<<<<<<<<");
        }
        
    }
    
    /**
     * 
    	* Nome: descricaoMoeda
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private String descricaoMoeda(Integer cod) {
        if (cod != null) {
            List<SelectItem> lista = moedaList;
            for (int i = 0; i < lista.size(); i++) {
                SelectItem item = lista.get(i);
                if (item.getValue().equals(cod)) {
                    return item.getLabel();
                }
            }
        }
        return "";
    }
    
    	/**
    	* Nome: detalhar
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 01/07/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public String detalhar(){
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinFundingBean.detalhar <<<<<<<<<<<");
    		
    		// [ACESSO EXTERNO] Garante que não ira adotar o comportamento de acesso externo
    		getTradeFinanceBean().setExternalAccess(false);
    		
    		// FINIMP DIRETO (1644)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_FINIMP_DIRETO.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("finimpDiretoFndg");
    			return "finimpDiretoCons";
    		}
    		
    		// REFINIMP DIRETO (1646)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_REFINIMP_DIRETO.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("refinimpDiretoFndg");
    			return "refinimpDiretoCons";
    		}
    		
    		// FINIMP INDIRETO (2692)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_FINIMP_INDIRETO.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("finimpIndiretoFndg");
    			return "finimpIndiretoCons";
    		}
    		
    		// REFINIMP INDIRETO (1717)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_REFINIMP_INDIRETO.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("refinimpIndiretoFndg");
    			return "refinimpIndiretoCons";
    		}
    		
    		// LEI 4131 (2010)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_LEI_4131.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("lei4131Fndg");
    			return "lei4131Cons";
    		}
    		
    		// PPE (1642)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_P_P_E.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("cotacaoPPEFndg");
    			return "cotacaoPPECons";
    		}
    		
    		// WORKING CAPITAL (2011)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_WORKING_CAPITAL.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("workingCapitalFndg");
    			return "workingCapitalCons";
    		}
    		
    		// FORFAITING (644)
    		if (tradeFinanceBean.getTradeFinanceVO().getCprodtservc().equals(EnumProduto.PRODUTO_FORFAITING.getCodigo()) == Boolean.TRUE) {
    			
    			tradeFinanceBean.getViewHelper().setPaginaOrigem("forfaitingFndg");
    			return "forfaitingCons";
    		}
    		
    		return null;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinFundingBean.detalhar <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * 
    	* Nome: actionFechar
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 23/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void actionFechar(ActionEvent ae) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinFundingBean.actionFechar <<<<<<<<<<<");
    		
    		viewHelper.setRenderModal(Boolean.FALSE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinFundingBean.actionFechar <<<<<<<<<<<");
    	}
    	
     }

    
    /**
     * @return o valor do moedaList
     */
	public List<SelectItem> getMoedaList() {
		if(moedaList.isEmpty()){
			setMoedaList(selectItemBean.getMoeda());
		}
		return moedaList;
	}

    /**
     * @return o valor do fundingVO
     */
    public FundingVO getFundingVO() {
        return fundingVO;
    }

    /**
     * @param fundingVO seta o novo valor para o campo fundingVO
     */
    public void setFundingVO(FundingVO fundingVO) {
        this.fundingVO = fundingVO;
    }

    /**
     * @return o valor do viewHelper
     */
    public TradeFinFundingViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(TradeFinFundingViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do tradeFinanceBean
     */
    public TradeFinanceBean getTradeFinanceBean() {
        return tradeFinanceBean;
    }

    /**
     * @param tradeFinanceBean seta o novo valor para o campo tradeFinanceBean
     */
    public void setTradeFinanceBean(TradeFinanceBean tradeFinanceBean) {
        this.tradeFinanceBean = tradeFinanceBean;
    }

    /**
     * @return o valor do tradeFinanceMonitService
     */
    public ITradeFinanceMonitService getTradeFinanceMonitService() {
        return tradeFinanceMonitService;
    }

    /**
     * @param tradeFinanceMonitService seta o novo valor para o campo tradeFinanceMonitService
     */
    public void setTradeFinanceMonitService(ITradeFinanceMonitService tradeFinanceMonitService) {
        this.tradeFinanceMonitService = tradeFinanceMonitService;
    }

    /**
     * @return o valor do selectItemBean
     */
    public SelectItemBean getSelectItemBean() {
        return selectItemBean;
    }

    /**
     * @param selectItemBean seta o novo valor para o campo selectItemBean
     */
    public void setSelectItemBean(SelectItemBean selectItemBean) {
        this.selectItemBean = selectItemBean;
    }

    /**
     * @param moedaList seta o novo valor para o campo moedaList
     */
    public void setMoedaList(List<SelectItem> moedaList) {
        this.moedaList = moedaList;
    }

	
}
