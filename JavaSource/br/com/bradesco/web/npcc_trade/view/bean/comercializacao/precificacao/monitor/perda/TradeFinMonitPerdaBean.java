package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.perda;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.TradeFinanceBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * 
  * Nome: TradeFinMonitBaixarBean.java
  * 
  * Prop�sito: <p>Bean para funcionalidade da tela Baixar Trade Finance </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 22/12/2015
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
 */

@Named("tradeFinMonitPerdaBean")
@SessionScoped
public class TradeFinMonitPerdaBean implements Serializable  {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Objeto auxiliar da tela Monitor - Trade Finance 
	 */
	private TradeFinMonitPerdaViewHelper viewHelper = new TradeFinMonitPerdaViewHelper(); 
	
	@Inject
    @Named("tradeFinanceMonitService")
    private ITradeFinanceMonitService tradeFinanceMonitService;
	
	@Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;
	
	@Inject
    @Named("tradeFinanceBean")
    private TradeFinanceBean tradeFinanceBean;

	    /**
	     * Construtor
	     * 
	     * @param 
	     */
	public TradeFinMonitPerdaBean() {
		super();
	}
	
	/**
	 * 
		* Nome: iniciar
		* 
		* Prop�sito:
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manuten��o: 11/01/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequa��o ao padr�o hexavision.
	 */
	public String iniciar(){
		
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitPerdaBean.iniciar <<<<<<<<<<<");
			
			viewHelper = new TradeFinMonitPerdaViewHelper(); 
//	    	viewHelper.setComboMotivosPerdaItens(selectItemBean.getComboMotivoPerda(viewHelper.getFiltroMotivoPerda()));
			
			return "tradeFinMntFinPerdaList";

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitPerdaBean.iniciar <<<<<<<<<<<");
		}
		
	}
	
	 /**
     * 
     * Nome: validarForm
     * 
     * Prop�sito: A��o que executa a valida��o do formul�rio e abre o modal de confirma��o das telas de inclus�o e
     * altera��o
     * 
     * @return : Navega��o por mensagem
     * 
     * @throws : NpccServiceBusinessException
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void validarForm(AjaxBehaviorEvent event) {

		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitPerdaBean.validarForm <<<<<<<<<<<");
			
			// valida campos obrigat�rios
			if (SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getCmotvobletocmbio())) {
				NpcFacesUtils.addInfoModalMessage("O campo Motivo � obrigat�rio.", false);
				return;
			}
			
			viewHelper.setRenderModal(Boolean.TRUE);

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitPerdaBean.validarForm <<<<<<<<<<<");
		}
		
    }
    
    /**
     * 
     * Nome: actionVoltar
     * 
     * Prop�sito: A��o exucuta pelo bot�o voltar das telas de inclur, alterar e detalhar
     *
     * @return : String de navega��o
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionVoltar() {
    	
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitPerdaBean.actionVoltar <<<<<<<<<<<");
			
			return "tradeFinMonitList";

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitPerdaBean.actionVoltar <<<<<<<<<<<");
		}
		
    }
    
    
    /**
     * 
     * Nome: actionConfirmar
     * 
     * Prop�sito: A��o exucuta pelo bot�o confirmar das telas de inclus�o e altera��o
     *
     * @return : Navega��o por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void actionConfirmar() {
    	
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitPerdaBean.actionConfirmar <<<<<<<<<<<");
			
			String result = SiteUtil.STRING_EMPTY;
			viewHelper.setRenderModal(Boolean.FALSE);
			result =  tradeFinanceMonitService.confirmarPerda(tradeFinanceBean.getTradeFinanceVO(), Numeros.TRES);
			
			// Redireciona para a tela de consulta (Menu Din�mico) 
            BradescoFacesUtils.addInfoModalMessage(result, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitPerdaBean.actionConfirmar <<<<<<<<<<<");
		}
        
    }
    
    /**
     * 
     * Nome: actionFechar
     * 
     * Prop�sito: A��o do bot�o fechar do modal das telas de inclus�o e altera��o
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void actionFechar(ActionEvent ae) {
    	
    	try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitPerdaBean.actionFechar <<<<<<<<<<<");
			
			viewHelper.setRenderModal(Boolean.FALSE);

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitPerdaBean.actionFechar <<<<<<<<<<<");
		}
    }

    /**
     * @return o valor do viewHelper
     */
    public TradeFinMonitPerdaViewHelper getViewHelper() {
    	
    	try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinMonitPerdaBean.getViewHelper <<<<<<<<<<<");
			
			return viewHelper;

		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinMonitPerdaBean.getViewHelper <<<<<<<<<<<");
		}
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(TradeFinMonitPerdaViewHelper viewHelper) {
        this.viewHelper = viewHelper;
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


}
