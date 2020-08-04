package br.com.bradesco.web.npcc_trade.view.bean.global.garantiasModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.IGarantiasModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaAprLmtCreditoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.ItemSelecionavelVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboMoedaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoGarantiaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
  * Nome: GarantiasModalBean.java
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
  * Registro  de Manutenção: 02/03/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
@Named(value = "garantiasModalBean")
@SessionScoped
public class GarantiasModalBean implements Serializable{
	
	private static final long serialVersionUID = 5061869935238096710L;
    private GarantiasModalViewHelper viewHelper = new GarantiasModalViewHelper();
	private ResourceBundle bundle;
	private List<GarantiasVO> listaGarantiasAdicionais = new ArrayList<GarantiasVO>();
	private List<GarantiasVO> listaGarantiasAdicionaisOriginal = new ArrayList<GarantiasVO>();
	private List<GarantiasVO> listaGarantiasAdicTemp = new ArrayList<GarantiasVO>();
    private List<ItemSelecionavelVO<GarantiasAvaListaVO>> listaGarantiasAva = new ArrayList<ItemSelecionavelVO<GarantiasAvaListaVO>>();
    private List<GarantiasVO> listaGarantiasAprov = new ArrayList<GarantiasVO>();
    private List<GarantiasAvaAprLmtCreditoVO> listaGarantiasAprLmt = new ArrayList<GarantiasAvaAprLmtCreditoVO>();
    private List<SelectItem> comboTipoGarantia;
    private List<ComboTipoGarantiaVO> listaTipoGarantia;
    private List<SelectItem> comboMoedaGarantia;
    private List<ComboMoedaVO> listaMoedaGarantia;

	private List<GarantiasVO> listaGarantiasInclusao = new ArrayList<GarantiasVO>();
	private List<GarantiasAvaListaVO> listaAvalistasInclusao = new ArrayList<GarantiasAvaListaVO>();

	private Integer codProduto = 0;
	private Integer ccpfcnpj = 0;
	private Integer cflialcpfcnpj = 0;
	private Integer cctrlcpfcnpj = 0;
    private Long cunicpssoacmbio = 0L;
    private String ncunicclicmbio;
    private String dprodtservc;
    private Long nbletonegoccmbio = 0L;
    private Long nseqcontrlim = 0L;
    private Long nppstapontucmbio = 0L;
    private String hinclreghist;
    
    @Inject
    @Named("garantiasModalService")
    private IGarantiasModalService garantiasModalService;
    
    @Inject
    @Named("commonService")
    private ICommonService commonService;
    
	@Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;
    
    /**
     * 
    	* Nome: iniciar
    	* 
    	* Propósito: inicializar campos
    	*
    	* @param : list List<GarantiasVO>
    	* @return : uma lista de List<ItemSelecionavelVO<GarantiasVO>>
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 02/03/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    @PostConstruct
    public void iniciar(){
    	bundle = ResourceBundle.getBundle("br.com.bradesco.web.npcc_trade.view.bundle.Messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
    }
    
    public void resetBeanGarantia(){

    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.resetBeanGarantia <<<<<<<<<<<");
	    	
	    	listaGarantiasAdicionais = new ArrayList<GarantiasVO>();
	    	listaGarantiasAdicionaisOriginal = new ArrayList<GarantiasVO>();
	    	listaGarantiasAdicTemp = new ArrayList<GarantiasVO>();
	        listaGarantiasAva = new ArrayList<ItemSelecionavelVO<GarantiasAvaListaVO>>();
	        listaGarantiasAprov = new ArrayList<GarantiasVO>();
	        listaGarantiasAprLmt = new ArrayList<GarantiasAvaAprLmtCreditoVO>();
	
	        listaGarantiasInclusao = new ArrayList<GarantiasVO>();
	    	listaAvalistasInclusao = new ArrayList<GarantiasAvaListaVO>();
	
	    	codProduto = 0;
	    	ccpfcnpj = 0;
	    	cflialcpfcnpj = 0;
	    	cctrlcpfcnpj = 0;
	        cunicpssoacmbio = 0L;
	        ncunicclicmbio = "";
	        dprodtservc = "";
	        nbletonegoccmbio = 0L;
	        nseqcontrlim = 0L;
	        nppstapontucmbio = 0L;
	        hinclreghist = "";
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.resetBeanGarantia <<<<<<<<<<<");
    	}
    }
    
    /**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa das garantais
     *
     * @param : tipoPesquisa
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal(AjaxBehaviorEvent event) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.openModal <<<<<<<<<<<");
	    	
	    	carregarGarantias();
	        viewHelper.setEditavel(Boolean.FALSE);
	        viewHelper.setRenderModal(Boolean.TRUE);
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.openModal <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: openModalInclusao
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 07/03/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void openModalInclusao(AjaxBehaviorEvent event) {
    	
    	try{
    		
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.openModalInclusao <<<<<<<<<<<");
	    	
	        //setListaGarantiasAdicionais(new ArrayList<GarantiasVO>());
	        setListaGarantiasAdicTemp(new ArrayList<GarantiasVO>());
	        	        
	    	carregarGarantiasInclusao();
	    	
	    	// Limpa a lista de garantias adicionais antes de abrir o modal de Garantias
	
	    	viewHelper.setEditavel(Boolean.TRUE);
	    	viewHelper.setRenderModal(Boolean.TRUE);
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.openModalInclusao <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: openModalInclusao
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 07/03/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void openModalGarantias() {
    	
    	try{
    		
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.openModalInclusao <<<<<<<<<<<");
	    	
	        setListaGarantiasAdicTemp(new ArrayList<GarantiasVO>());
	        	        
	        carregarGarantias();
	    	
	    	// Limpa a lista de garantias adicionais antes de abrir o modal de Garantias
	
	    	viewHelper.setEditavel(Boolean.TRUE);
	    	viewHelper.setRenderModal(Boolean.TRUE);
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.openModalInclusao <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: closeModal
    	* 
    	* Propósito: Fechar o modal de Garantias 
    	*
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 21/01/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void closeModal() {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.closeModal <<<<<<<<<<<");
	    	
	        // desabilita modal
	        viewHelper.setRenderModal(Boolean.FALSE);
	        
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.closeModal <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: confirmarGarantias
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 15/03/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public String confirmarGarantias(){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.confirmarGarantias <<<<<<<<<<<");
	    	
	    	preparListaInclusao();
	    	
	    	listaGarantiasAdicionaisOriginal.clear();
	    	listaGarantiasAdicionaisOriginal.addAll(listaGarantiasAdicionais);
	    	
	    	listaGarantiasAdicTemp = new ArrayList<GarantiasVO>();
	    	
	    	viewHelper.setModalId("formTradeFinMonitDet\\:content_modalGarantias");
	    	closeModal();
	    	
	    	return "/content/comercializacao/precificacao/negociacao/tradeFinNegModalGarantiaClose.xhtml";
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.confirmarGarantias <<<<<<<<<<<");
    	}
    }
    
    public void preparListaInclusao() {
        
        listaGarantiasInclusao = extrairListaGarantiasInclusao();
        listaAvalistasInclusao = extrairListaGarantiasAvalistas();
    }
    
    public String cancelarGarantias(){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.cancelarGarantias <<<<<<<<<<<");
	
	    	listaGarantiasAdicionais.clear();
	    	listaGarantiasAdicionais.addAll(listaGarantiasAdicionaisOriginal);
	    	
	    	listaGarantiasAdicTemp = new ArrayList<GarantiasVO>();
	    	                
	    	viewHelper.setModalId("formTradeFinMonitDet\\:content_modalGarantias");

	    	closeModal();
	    	
	    	return "/content/comercializacao/precificacao/negociacao/tradeFinNegModalGarantiaClose.xhtml";
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.cancelarGarantias <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: carregarGarantias
    	* 
    	* Propósito: carrega as listas de garantias para de tela de consulta
    	*
    	* @param : list List<GarantiasVO>
    	* @return : uma lista de List<ItemSelecionavelVO<GarantiasVO>>
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 02/03/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void carregarGarantias(){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.carregarGarantias <<<<<<<<<<<");
	    	
	    	// Busca avalistas do cadastro
	    	listaGarantiasAva = getGarantiasAvalistasAsItem(garantiasModalService.getGarantiasAvaList(getNbletonegoccmbio(), getHinclreghist()));
	
			// Busca garantia aprovadas no limite de credito
			listaGarantiasAprov = garantiasModalService.getGarantiasAprovList(getNbletonegoccmbio(), getHinclreghist());
	
			// Busca avalistas aprovados no limite de credito
			if(!SiteUtil.isEmptyOrNull(getNseqcontrlim()) 
			        || !SiteUtil.isEmptyOrNull(getNppstapontucmbio())) {
			    listaGarantiasAprLmt = garantiasModalService.getAvalistasAprLmtCreditoList(getNseqcontrlim(), nppstapontucmbio, ccpfcnpj, cflialcpfcnpj, cctrlcpfcnpj);
			}
			
			//Busca garantias adicionais
			listaGarantiasAdicionais = garantiasModalService.getGarantiaAdicionais(getNbletonegoccmbio(), getHinclreghist());
			listaGarantiasAdicionaisOriginal.addAll(listaGarantiasAdicionais);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.carregarGarantias <<<<<<<<<<<");
    	}
    }
    
    
    /**
     * 
    	* Nome: carregarGarantiasInclusao
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
    public void atualizarValorGarantiasAprovadas(AjaxBehaviorEvent e){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.atualizarValorGarantiasAprovadas <<<<<<<<<<<");
	  	
	    	setListaGarantiasAprLmt(getListaGarantiasAprLmt());
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.atualizarValorGarantiasAprovadas <<<<<<<<<<<");
    	}    	
    }
    
    /**
     * 
    	* Nome: carregarGarantiasInclusao
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
    public void carregarGarantiasInclusao(){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.carregarGarantiasInclusao <<<<<<<<<<<");
	
	    	if (!SiteUtil.isEmptyOrNull(codProduto) && !SiteUtil.isEmptyOrNull(getCunicpssoacmbio())) {
	    		// Busca garantia aprovadas no limite de credito
	    		
	    		if(listaGarantiasAprov.size() == 0)
	    			listaGarantiasAprov = garantiasModalService.getGarantiasAprovadasInclusao(codProduto, ccpfcnpj, cflialcpfcnpj, cctrlcpfcnpj, nseqcontrlim, nppstapontucmbio);
	    		
	    		// Busca avalistas aprovados no limite de credito
	    		listaGarantiasAprLmt = new ArrayList<GarantiasAvaAprLmtCreditoVO>();
	    		if(!SiteUtil.isEmptyOrNull(getNseqcontrlim())) {
	    			listaGarantiasAprLmt = garantiasModalService.getAvalistasAprLmtCreditoList(getNseqcontrlim(), nppstapontucmbio, ccpfcnpj, cflialcpfcnpj, cctrlcpfcnpj);            
	    		}
	    		
	    		listaGarantiasAdicTemp.addAll(listaGarantiasAdicionais);
	    		
	    		// Busca avalistas do cadastro
	    		listaGarantiasAva = getGarantiasAvalistasAsItem(garantiasModalService
	    				.getAvalistasCadastroInclusao(getCunicpssoacmbio(), 
	    						EnumTradeFinance.TIPO_VINCULO_AVALISTA.getCodigo()));
	    	}
	    	
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.carregarGarantiasInclusao <<<<<<<<<<<");
    	}    	
    }
            
    /**
     * 
    	* Nome: getGarantiasAvalistasAsItem
    	* 
    	* Propósito: Converter uma lista de GarantiasVO para um de ItemSelecionavelVO
    	*
    	* @param : list List<GarantiasAvaListaVO>
    	* @return : uma lista de List<ItemSelecionavelVO<GarantiasAvaListaVO>>
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/01/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private List<ItemSelecionavelVO<GarantiasAvaListaVO>> getGarantiasAvalistasAsItem(List<GarantiasAvaListaVO> list){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.getGarantiasAvalistasAsItem <<<<<<<<<<<");
	    	
	    	List<ItemSelecionavelVO<GarantiasAvaListaVO>> resultList = new ArrayList<ItemSelecionavelVO<GarantiasAvaListaVO>>();
	    	for(GarantiasAvaListaVO obj: list){
	    		ItemSelecionavelVO<GarantiasAvaListaVO> item = new ItemSelecionavelVO<GarantiasAvaListaVO>(obj); 
	    		resultList.add(item);
	    	}
	    	
	    	return resultList;
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.getGarantiasAvalistasAsItem <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: extrairListaGarantiasAvalistas
    	* 
    	* Propósito: Extrair lista de garantias adicionais da lista de itens selecionaveis
    	*
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 04/02/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public List<GarantiasAvaListaVO> extrairListaGarantiasAvalistas(){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.extrairListaGarantiasAvalistas <<<<<<<<<<<");
	    	
	    	List<GarantiasAvaListaVO> avalistas = new ArrayList<GarantiasAvaListaVO>();
	    	
	    	for(ItemSelecionavelVO<GarantiasAvaListaVO> avalista: listaGarantiasAva){
	    		if(avalista.isSelecionado()){
	    			avalistas.add(avalista.getVo());
	    		}
	    		if (avalistas.size() >= EnumTradeFinance.MAX_LISTA_INCLUSAO_COTACAO.getCodigo()) {
	    			return avalistas;
				}
	    	}
	    	
	    	return avalistas;
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.extrairListaGarantiasAvalistas <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: extrairListaGarantiasInclusao
    	* 
    	* Propósito: Extrair lista de garantias adicionais incluidas
    	*
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 04/02/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public List<GarantiasVO> extrairListaGarantiasInclusao(){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.extrairListaGarantiasInclusao <<<<<<<<<<<");
	    	
	    	String dataVenc = "";
	    	List<GarantiasVO> listaGarantias = new ArrayList<GarantiasVO>();
	    	
	    	for(GarantiasVO garantia: listaGarantiasAprov){
	    		garantia.setCidtfdgarntadcio(Numeros.DOIS);
	    		
	    		if (garantia.getDvctogarntcmbio() != null &&
	    				garantia.getDvctogarntcmbio().length() > Numeros.ZERO) {
	    			dataVenc = garantia.getDvctogarntcmbio();
				}
	    		
	    		listaGarantias.add(garantia);
	    		if (listaGarantias.size() >= EnumTradeFinance.MAX_LISTA_INCLUSAO_COTACAO.getCodigo()) {
	    			return listaGarantias;
				}
	    	}
	
	    	for(GarantiasVO garantia: listaGarantiasAdicionais){
	    		garantia.setCidtfdgarntadcio(Numeros.UM);
	    		garantia.setCindcdgarntprinc("S");
	    		garantia.setDvctogarntcmbio(dataVenc);
	    		listaGarantias.add(garantia);
	    		if (listaGarantias.size() >= EnumTradeFinance.MAX_LISTA_INCLUSAO_COTACAO.getCodigo()) {
	    			return listaGarantias;
				}
	    	}
	    	
	    	return listaGarantias;
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.extrairListaGarantiasInclusao <<<<<<<<<<<");
    	}
    }
    
    /**

    	* Nome: incluirGarantiaAdicional
    	* 
    	* Propósito: incluir garantias adicionais 
    	*
    	* @param : ajaxBehaviorEvent
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/01/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void incluirGarantiaAdicional(AjaxBehaviorEvent event){
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.incluirGarantiaAdicional <<<<<<<<<<<");
	    	
	    	Integer codTipoGaran = Numeros.ZERO;
	    	
	    	if(getViewHelper().getPercentualGarantiaAdc().equals("")){
	    	    NpcFacesUtils.addInfoModalMessage("Informe os campos de Garantias Adicionais.", false);
	    	    return;
	    	}
	    	
	    	if(listaGarantiasAdicionais.size() >= viewHelper.MAX_LIST_GARANTIAS_ADC.intValue()){
	    		BradescoFacesUtils.addErrorModalMessage(bundle.getString("mensagem_aviso_limite_garantias_adicionais"));
	    	} else {
	        	GarantiasVO vo = new GarantiasVO();
	        	codTipoGaran = SiteUtil.getInt(viewHelper.getItemSelecionadoTipoGarantiaAdic());
	        	vo.setCcaractpogarnt(codTipoGaran);
	        	
	        	for (int j = 0; j < listaTipoGarantia.size(); j++) {
	    			if (listaTipoGarantia.get(j).getCdgarnt().equals(codTipoGaran)) {
	    	        	vo.setDvctogarntcmbio(listaTipoGarantia.get(j).getDvctogarantcmbio());
	    			}
	    		}
	        	vo.setIcaractpogarnt(viewHelper.getItemSelecionadoTipoGarantiaAdic());
	        	vo.setVtxgarntcmbio(viewHelper.getPercentualGarantiaAdc().toString());
	        	vo.setRcomplgarntcmbio(viewHelper.getObsGarantiaAdc());
	        	vo.setDescrGaran(descricaoGarantia(viewHelper.getItemSelecionadoTipoGarantiaAdic()));
	        	vo.setDescrMoedaGar(descricaoMoedaGarantia(viewHelper.getCindcdeconmmoegar()));
	        	vo.setCindcdeconmmoegar(SiteUtil.getInt(viewHelper.getCindcdeconmmoegar()));
	        	listaGarantiasAdicionais.add(vo);
	    	}
	    	
	    	viewHelper.setObsGarantiaAdc(null);
	    	viewHelper.setPercentualGarantiaAdc(null);
	    	viewHelper.setItemSelecionadoTipoGarantiaAdic(null);
	    	viewHelper.setCindcdeconmmoegar(null);
	    	
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.incluirGarantiaAdicional <<<<<<<<<<<");
    	}
    }
    
    /**
     * 
    	* Nome: excluirGarantiaAdicional
    	* 
    	* Propósito: excluir garantias adicionais 
    	*
    	* @param : ajaxBehaviorEvent
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 29/01/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void excluirGarantiaAdicional(AjaxBehaviorEvent event) {
    	
    	try{
    		
	    	BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.excluirGarantiaAdicional <<<<<<<<<<<");
	    	
	        if (SiteUtil.isEmptyOrNull(viewHelper.getItemSelecionadoTipoGarantiaAdic())) {
	            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
	            return;
	        }
	        listaGarantiasAdicionais.remove(SiteUtil.getInt(viewHelper.getItemSelecionadoTipoGarantiaAdic()));
			
			viewHelper.setItemSelecionadoTipoGarantiaAdic(null);
			
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.excluirGarantiaAdicional <<<<<<<<<<<");
    	}
    } 
    
    
	public List<SelectItem> getComboTipoGarantia() {

		try{
			
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.getComboTipoGarantia <<<<<<<<<<<");
		    
			if(comboTipoGarantia == null || comboTipoGarantia.size() == Numeros.ZERO){
			    listaTipoGarantia = commonService.listarGarantiasAdicionais(codProduto);
			    comboTipoGarantia = new ArrayList<SelectItem>();
		        for (Iterator<ComboTipoGarantiaVO> ite = listaTipoGarantia.iterator(); ite.hasNext();) {
		            ComboTipoGarantiaVO combo = ite.next();
		            comboTipoGarantia.add(new SelectItem(combo.getCdgarnt(), combo.getCdgarnt() + "-" + combo.getDsgarnt()));
		        }
			}
			
			return comboTipoGarantia;
			
		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.getComboTipoGarantia <<<<<<<<<<<");
    	}
	}

	private String descricaoGarantia(String cod){

		try{
			
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.descricaoGarantia <<<<<<<<<<<");
			
			for(SelectItem item : getComboTipoGarantia()){
				if(item.getValue().toString().equals(cod)){
					return item.getLabel();
				}
			}
	
			return "";
			
		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.descricaoGarantia <<<<<<<<<<<");
    	}
	}
	
	public void setComboTipoGarantia(List<SelectItem> comboTipoGarantia) {
		this.comboTipoGarantia = comboTipoGarantia;
	}

    /**
     * Select item para campos Moeda. Dados do MF
	 * - Autor: SCF
     */
    public List<SelectItem> getComboMoedaGarantia() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        List<ComboMoedaVO> listMoeda = commonService.getComboMoeda();

        for (Iterator<ComboMoedaVO> iterator = listMoeda.iterator(); iterator.hasNext();) {
            ComboMoedaVO comboMoedaVO = iterator.next();
            list.add(new SelectItem(comboMoedaVO.getCindcdeconmmoeda(), comboMoedaVO.getCindcdfontecons() + " - " 
                            + comboMoedaVO.getIsglindcdeconm() ));
        }

        return list;
    }
	
    /**
     * Select item para campos Moeda. Dados do MF
	 * - Autor: SCF
     */
	private String descricaoMoedaGarantia(String cod){

		try{
			
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] GarantiasModalBean.descricaoMoedaGarantia <<<<<<<<<<<");

	        List<ComboMoedaVO> listMoeda = commonService.getComboMoeda();

	        for (Iterator<ComboMoedaVO> iterator = listMoeda.iterator(); iterator.hasNext();) {
	            ComboMoedaVO comboMoedaVO = iterator.next();
				if(comboMoedaVO.getCindcdeconmmoeda().toString().equals(cod)){
					return comboMoedaVO.getIsglindcdeconm();
				}
	        }
			
			return "";
			
		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] GarantiasModalBean.descricaoMoedaGarantia <<<<<<<<<<<");
    	}
	}
	
	/**
	 * @param comboMoedaGarantia
	 */

	public void setComboMoedaGarantia(List<SelectItem> comboMoedaGarantia) {
		this.comboMoedaGarantia = comboMoedaGarantia;
	}

	/**
	 * @return the viewHelper
	 */
	public GarantiasModalViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper the viewHelper to set
	 */
	public void setViewHelper(GarantiasModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	/**
	 * @return the listaGarantiasAva
	 */
	public List<ItemSelecionavelVO<GarantiasAvaListaVO>> getListaGarantiasAva() {
		return listaGarantiasAva;
	}

	/**
	 * @param listaGarantiasAva the listaGarantiasAva to set
	 */
	public void setListaGarantiasAva(
			List<ItemSelecionavelVO<GarantiasAvaListaVO>> listaGarantiasAva) {
		this.listaGarantiasAva = listaGarantiasAva;
	}

	/**
	 * @return the listaGarantiasAprov
	 */
	public List<GarantiasVO> getListaGarantiasAprov() {
		return listaGarantiasAprov;
	}

	/**
	 * @param listaGarantiasAprov the listaGarantiasAprov to set
	 */
	public void setListaGarantiasAprov(
			List<GarantiasVO> listaGarantiasAprov) {
		this.listaGarantiasAprov = listaGarantiasAprov;
	}

	/**
	 * @return the listaGarantiasAprLmt
	 */
	public List<GarantiasAvaAprLmtCreditoVO> getListaGarantiasAprLmt() {
		return listaGarantiasAprLmt;
	}

	/**
	 * @param listaGarantiasAprLmt the listaGarantiasAprLmt to set
	 */
	public void setListaGarantiasAprLmt(
			List<GarantiasAvaAprLmtCreditoVO> listaGarantiasAprLmt) {
		this.listaGarantiasAprLmt = listaGarantiasAprLmt;
	}

	public List<SelectItem> getSelectItemRadioGarantiaAdc() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (int index = 0; index < getComboTipoGarantia().size(); index++) {
			list.add(new SelectItem (index, ""));
		}	
		return list;
	}

	public List<GarantiasVO> getListaGarantiasAdicionais() {
		return listaGarantiasAdicionais;
	}

	public void setListaGarantiasAdicionais(
			List<GarantiasVO> listaGarantiasAdicionais) {
		this.listaGarantiasAdicionais = listaGarantiasAdicionais;
	}
	
	public List<GarantiasVO> getListaGarantiasAdicTemp() {
		return listaGarantiasAdicTemp;
	}

	public void setListaGarantiasAdicTemp(
			List<GarantiasVO> listaGarantiasAdicTemp) {
		this.listaGarantiasAdicTemp = listaGarantiasAdicTemp;
	}

	/**
	 * @return o valor do codProduto
	 */
	public Integer getCodProduto() {
		return codProduto;
	}

	/**
	 * @param codProduto seta o novo valor para o campo codProduto
	 */
	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	/**
	 * @return o valor do ccpfcnpj
	 */
	public Integer getCcpfcnpj() {
		return ccpfcnpj;
	}

	/**
	 * @param ccpfcnpj seta o novo valor para o campo ccpfcnpj
	 */
	public void setCcpfcnpj(Integer ccpfcnpj) {
		this.ccpfcnpj = ccpfcnpj;
	}

	/**
	 * @return o valor do cflialcpfcnpj
	 */
	public Integer getCflialcpfcnpj() {
		return cflialcpfcnpj;
	}

	/**
	 * @param cflialcpfcnpj seta o novo valor para o campo cflialcpfcnpj
	 */
	public void setCflialcpfcnpj(Integer cflialcpfcnpj) {
		this.cflialcpfcnpj = cflialcpfcnpj;
	}

	/**
	 * @return o valor do cctrlcpfcnpj
	 */
	public Integer getCctrlcpfcnpj() {
		return cctrlcpfcnpj;
	}

	/**
	 * @param cctrlcpfcnpj seta o novo valor para o campo cctrlcpfcnpj
	 */
	public void setCctrlcpfcnpj(Integer cctrlcpfcnpj) {
		this.cctrlcpfcnpj = cctrlcpfcnpj;
	}

	/**
	 * @return o valor do cunicpssoacmbio
	 */
	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}

	/**
	 * @param cunicpssoacmbio seta o novo valor para o campo cunicpssoacmbio
	 */
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	/**
	 * @return o valor do listaGarantiasInclusao
	 */
	public List<GarantiasVO> getListaGarantiasInclusao() {
		return listaGarantiasInclusao;
	}

	/**
	 * @param listaGarantiasInclusao seta o novo valor para o campo listaGarantiasInclusao
	 */
	public void setListaGarantiasInclusao(
			List<GarantiasVO> listaGarantiasInclusao) {
		this.listaGarantiasInclusao = listaGarantiasInclusao;
	}

	/**
	 * @return o valor do listaAvalistasInclusao
	 */
	public List<GarantiasAvaListaVO> getListaAvalistasInclusao() {
		return listaAvalistasInclusao;
	}

	/**
	 * @param listaAvalistasInclusao seta o novo valor para o campo listaAvalistasInclusao
	 */
	public void setListaAvalistasInclusao(
			List<GarantiasAvaListaVO> listaAvalistasInclusao) {
		this.listaAvalistasInclusao = listaAvalistasInclusao;
	}

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}

	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}

	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}

	public String getNcunicclicmbio() {
		return ncunicclicmbio;
	}

	public void setNcunicclicmbio(String ncunicclicmbio) {
		this.ncunicclicmbio = ncunicclicmbio;
	}

	public String getDprodtservc() {
		return dprodtservc;
	}

	public void setDprodtservc(String dprodtservc) {
		this.dprodtservc = dprodtservc;
	}

	/**
	 * @return o valor do listaGarantiasAdicionaisOriginal
	 */
	public List<GarantiasVO> getListaGarantiasAdicionaisOriginal() {
		return listaGarantiasAdicionaisOriginal;
	}

	/**
	 * @param listaGarantiasAdicionaisOriginal seta o novo valor para o campo listaGarantiasAdicionaisOriginal
	 */
	public void setListaGarantiasAdicionaisOriginal(List<GarantiasVO> listaGarantiasAdicionaisOriginal) {
		this.listaGarantiasAdicionaisOriginal = listaGarantiasAdicionaisOriginal;
	}

    public String getHinclreghist() {
        return hinclreghist;
    }

    public void setHinclreghist(String hinclreghist) {
        this.hinclreghist = hinclreghist;
    }

    /**
     * @return o valor do nppstapontucmbio
     */
    public Long getNppstapontucmbio() {
        return nppstapontucmbio;
    }

    /**
     * @param nppstapontucmbio seta o novo valor para o campo nppstapontucmbio
     */
    public void setNppstapontucmbio(Long nppstapontucmbio) {
        this.nppstapontucmbio = nppstapontucmbio;
    }

}