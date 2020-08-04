package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.monitor.baixar;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.ITradeFinanceMonitService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.TradeFinanceBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * 
 * Nome: TradeFinMonitBaixarBean.java
 * 
 * Propósito:
 * <p>
 * Bean para funcionalidade da tela Baixar Trade Finance
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 22/12/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */

@Named("tradeFinBaixarBean")
@SessionScoped
public class TradeFinBaixarBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /**
     * Objeto auxiliar da tela Monitor - Trade Finance
     */
    private TradeFinBaixarViewHelper viewHelper = new TradeFinBaixarViewHelper();

    private TradeFinanceVO tradeFinanceVO = new TradeFinanceVO();
    private String dataAtual;
    
    private List<SelectItem> comboMotivosPerdaItens = new ArrayList<SelectItem>();
    private List<SelectItem> comboMoeda =  new ArrayList<SelectItem>();
    
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
    public TradeFinBaixarBean() {
        super();
    }

    /**
     * 
     * Nome: iniciar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinBaixarBean.iniciar <<<<<<<<<<<");
    		
    		getViewHelper().setComboMoedaItens(selectItemBean.getMoeda());
    		
    		getViewHelper().setComboMotivosPerdaItens(selectItemBean.getComboMotivoPerda());
    		
    		return "tradeFinMntFinBaixarList";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinBaixarBean.iniciar <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: validarForm
     * 
     * Propósito: Ação que executa a validação do formulário e abre o modal de
     * confirmação das telas de inclusão e alteração
     * 
     * @return : Navegação por mensagem
     * 
     * @throws : NpccServiceBusinessException
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarForm(ActionEvent ae) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinBaixarBean.validarForm <<<<<<<<<<<");
    		
    		Boolean valid = true;
    		
    		valid &= !SiteUtil.validarCamposExcl("formTradeFinMonitDet", "comboMoedaBaixar");
    		
    		if(!SiteUtil.isValueZero(tradeFinanceBean.getTradeFinanceVO().getVpnaltanteccmbio()) 
    				&& SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getCindcdeconmpnalt())) {
    			
    			NpcFacesUtils.addInfoModalMessage("Informe o campo moeda",false);
    			valid = false;
    		}
    		if(SiteUtil.isValueZero(tradeFinanceBean.getTradeFinanceVO().getVpnaltanteccmbio()) 
    				&& !SiteUtil.isEmptyOrNull(tradeFinanceBean.getTradeFinanceVO().getCindcdeconmpnalt())) {
    			
    			NpcFacesUtils.addInfoModalMessage("Informe o campo taxa de compromisso",false);
    			valid = false;
    		}
    		
    		// valida campos obrigatórios
    		if (valid) {
    			
    		    viewHelper.setRenderModal(Boolean.TRUE);
    		}
    		

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinBaixarBean.validarForm <<<<<<<<<<<");
    	}

    }

    /**
     * 
     * Nome: actionVoltar
     * 
     * Propósito: Ação exucuta pelo botão voltar das telas de inclur, alterar e
     * detalhar
     *
     * @return : String de navegação
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionVoltar() {
        return "tradeFinMonitList";
    }

    /**
     * 
     * Nome: actionConfirmar
     * 
     * Propósito: Ação exucuta pelo botão confirmar das telas de inclusão e
     * alteração
     *
     * @return : Navegação por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionConfirmar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinBaixarBean.actionConfirmar <<<<<<<<<<<");
    		
    		String result = SiteUtil.STRING_EMPTY;
    		viewHelper.setRenderModal(Boolean.FALSE);
    		tradeFinanceVO = tradeFinanceBean.getTradeFinanceVO();
    		tradeFinanceVO.setCsitbletocmbio(33);
    		
    		result = tradeFinanceMonitService.confirmarBaixar(tradeFinanceVO);
    		
    		// Redireciona para a tela de consulta (Menu Dinâmico) 
            BradescoFacesUtils.addInfoModalMessage(result, 
                    "#{tradeFinMonitBean.retomarPesquisaMonit}",
                    BradescoViewExceptionActionType.ACTION, "submit", false);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinBaixarBean.actionConfirmar <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: actionFechar
     * 
     * Propósito: Ação do botão fechar do modal das telas de inclusão e
     * alteração
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionFechar(ActionEvent ae) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinBaixarBean.actionFechar <<<<<<<<<<<");
    		
    		viewHelper.setRenderModal(Boolean.FALSE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinBaixarBean.actionFechar <<<<<<<<<<<");
    	}
    	
    }

    	/**
    	* Nome: getDataAtual
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
    public String getDataAtual() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinBaixarBean.getDataAtual <<<<<<<<<<<");
    		
    		Date data = new Date();
    		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    		dataAtual = formatador.format(data);
    		return dataAtual;

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinBaixarBean.getDataAtual <<<<<<<<<<<");
    	}
    }
    
    /**
     * @param dataAtual seta o novo valor para o campo dataAtual
     */
    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    /**
     * @param tradeFinanceVO seta o novo valor para o campo tradeFinanceVO
     */
    public TradeFinanceVO getTradeFinanceVO() {
        return tradeFinanceVO;
    }

    /**
     * @param tradeFinanceVO seta o novo valor para o campo tradeFinanceVO
     */
    public void setTradeFinanceVO(TradeFinanceVO tradeFinanceVO) {
        this.tradeFinanceVO = tradeFinanceVO;
    }

    /**
     * @return o valor do viewHelper
     */
    public TradeFinBaixarViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(TradeFinBaixarViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
	public List<SelectItem> getComboMotivosPerdaItens() {
		if(comboMotivosPerdaItens.isEmpty()){
			setComboMotivosPerdaItens(selectItemBean.getComboMotivoPerda());
		}
		return comboMotivosPerdaItens;
	}

	/**
     * @param comboMotivosPerdaItens seta o novo valor para o campo comboMotivosPerdaItens
     */
	public void setComboMotivosPerdaItens(List<SelectItem> comboMotivosPerdaItens) {
		this.comboMotivosPerdaItens = comboMotivosPerdaItens;
	}

	/**
     * @param comboMoeda seta o novo valor para o campo comboMoeda
     */
	public List<SelectItem> getComboMoeda() {
		if(comboMoeda.isEmpty()){
			setComboMoeda(selectItemBean.getMoeda());
		}
		return comboMoeda;
	}

	/**
     * @param comboMoeda seta o novo valor para o campo comboMoeda
     */
	public void setComboMoeda(List<SelectItem> comboMoeda) {
		this.comboMoeda = comboMoeda;
	}
 
}
