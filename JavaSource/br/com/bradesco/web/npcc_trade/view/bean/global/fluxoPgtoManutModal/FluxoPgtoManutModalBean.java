package br.com.bradesco.web.npcc_trade.view.bean.global.fluxoPgtoManutModal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.view.components.UIEditableColumn.UIEditableColumn;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.comissaoIntExtModal.IComissaoInternaExternaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.fluxoPgtoModal.IFluxoPgtoModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.ITradeFinanceNegociacaoService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegComissaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegFluxoPagtoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegParcelaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoAltBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoInclBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * Nome: FluxoPgtoManutModalBean.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 01/07/2016 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
@Named("fluxoPgtoManutModalBean")
@SessionScoped
public class FluxoPgtoManutModalBean implements Serializable {
    
    @Inject
    @Named("fluxoPgtoModalService")
    private IFluxoPgtoModalService fluxoPgtoModalService;
    
    @Inject
    @Named("tradeFinanceNegociacaoService")
    protected ITradeFinanceNegociacaoService tradeFinanceNegociacaoService;
    
    @Inject
    @Named("tradeFinanceNegociacaoInclBean")
    protected TradeFinanceNegociacaoInclBean tradeFinanceNegociacaoInclBean;
    
    @Inject
    @Named("tradeFinanceNegociacaoAltBean")
    protected TradeFinanceNegociacaoAltBean tradeFinanceNegociacaoAltBean;
    
    @Inject
    @Named("commonService")
    protected ICommonService commonService;
    
    @Inject
    @Named("comissaoInternaExternaModalService")
    private IComissaoInternaExternaModalService comissaoInternaExternaModalService;
    
	/** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    private TrdFinNegFluxoPagtoVO itemListaFluxoPgto = new TrdFinNegFluxoPagtoVO();
    private TrdFinNegFluxoPagtoVO itemListaFluxoPgtoAux = new TrdFinNegFluxoPagtoVO();
    
    private TrdFinNegParcelaVO itemListaParcelaIrreg = new TrdFinNegParcelaVO();

    private FluxoPgtoManutModalViewHelper viewHelper = new FluxoPgtoManutModalViewHelper();

    private Boolean confirmarManutencao = Boolean.FALSE;
    
    /** Atributo editar percentual cdi. */
    private Boolean editarPercentualCdi = true;
    
    private int qtdPrincipal = 0;
    private int qtdJuros = 0;
    
    private Boolean renderModal = Boolean.FALSE;
        
	private Boolean editado = Boolean.FALSE;
    
	private int linhaEditada;

	private String colunaEditada;

	private String valorAtual;

	private String novoValor;
	
	private String mensagem = null;
	
	private int tipoAcessoIncluirEvento = Numeros.ZERO;
	
	private BigDecimal somaValor = new BigDecimal("0.00");
	
	private Integer somaPrazoParcela = 0;
	
	private Boolean isAlterarCotacao = Boolean.FALSE;
	
	public String showModal() {
		somaPrazoValor();
		String retorno = "";
		if (somaValor.compareTo(new BigDecimal(itemListaFluxoPgto.getVprevtdsembcmbio().replaceAll("\\.","").replace(",","."))) != 0) {
			this.renderModal = Boolean.TRUE;
			setMensagem("A Soma das Parcelas Esta Diferente do Valor da Operação! \n Deseja Continuar?");
			retorno = "/content/global/fluxoPgtoManutModal/modalFluxoPgtoManut.xhtml";
		} else if (!somaPrazoParcela.equals(itemListaFluxoPgto.getTdiaopercmbio())) {
			this.renderModal = Boolean.TRUE;
			setMensagem("A Soma do Prazo das Parcelas Esta Diferente do Prazo da Operação! \n Deseja Continuar?");
			retorno = "/content/global/fluxoPgtoManutModal/modalFluxoPgtoManut.xhtml";
		} else {
			this.renderModal = Boolean.FALSE;
			retorno = confirmarModal();
		}
		return retorno;
	}
	
	private void somaPrazoValor() {
		somaValor = new BigDecimal("0.00");
		somaPrazoParcela = 0;
		for (int i = 0; i < itemListaFluxoPgto.getListaParcelasFluxoPgto().size(); i++) {
			Integer prazoParcela = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTdianegocpcela();
			somaPrazoParcela = somaPrazoParcela + prazoParcela;
			if (itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTpparcela().equals("P")) {
				String valorString = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorPrincipalParcelaFluxoPgto();
				if (SiteUtil.isEmptyOrNull(valorString)) {
					valorString = new BigDecimal("0.00").toString();
				}
				BigDecimal somaValorAux = new BigDecimal(valorString.replaceAll("\\.","").replace(",","."));
				somaValor = somaValorAux.add(somaValor);
			}
		}
	}

	/**
     * 
     * Nome: openModal
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 20/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal() {

    	try{
    		itemListaFluxoPgtoAux = new TrdFinNegFluxoPagtoVO();
    		itemListaFluxoPgtoAux.setListaParcelasFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto());
    		
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.openModal <<<<<<<<<<<");
    		
    		getViewHelper().setRenderModal(Boolean.TRUE);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.openModal <<<<<<<<<<<");
    	}

    }

    /**
     * Nome: confirmarModal
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/07/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmarModal() {
    	Double valorSoma = new Double(0);
    	Double valorTotal = SiteUtil.webMoedaToDouble(itemListaFluxoPgto.getVprevtdsembcmbio());
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.confirmarModal <<<<<<<<<<<");
    		
    		if (itemListaFluxoPgto.isPeriodicidadeIrregular() == true) {
    			conferirListaParcela();
    			
    			if (qtdPrincipal != itemListaFluxoPgto.getQtdeocorrprinc()) {
    				NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Principal divergente com as incluídas.", EnumButtonBehavior.SUBMIT);
    				return null;
    			}
    			
    			if (qtdJuros != itemListaFluxoPgto.getQtdeocorrjuros()) {
    				NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Juros divergente com as incluídas.", EnumButtonBehavior.SUBMIT);
    				return null;
    			}
    			
    			//Inicio - Verifica se o total das parcelas não excede ou é menor que o Valor Total
    			for(TrdFinNegParcelaVO negParcelaVO : itemListaFluxoPgto.getListaParcelasFluxoPgto()){    
    			    
    			    valorSoma += SiteUtil.webMoedaToDouble(negParcelaVO.getValorPrincipalParcelaFluxoPgto());
    			}
    			
    			if(valorSoma.compareTo(valorTotal) != 0){
    			    NpcFacesUtils.addInfoModalMessage("Soma dos valores das parcelas deve ser igual ao Valor Total.", EnumButtonBehavior.SUBMIT);
    			    return null;
    			}
    			//Fim - Verifica se o total das parcelas não excede ou é menor que o Valor Total
    			setItemListaParcelaIrreg(new TrdFinNegParcelaVO());
    		}
    		
			if (!somaPrazoParcela.equals(itemListaFluxoPgto.getTdiaopercmbio())) {
				itemListaFluxoPgto.setTdiaopercmbio(somaPrazoParcela);
				itemListaFluxoPgto.setTdiafinandsemb(somaPrazoParcela);
	    		
				if (!isAlterarCotacao()) {
	    			tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setTdiaopercmbio(somaPrazoParcela);
	    			if (!tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaFluxos().isEmpty()) {
	    				tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaFluxos().get(0).setTdiafinandsemb(somaPrazoParcela);
					}
				} else {
					tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().setTdiaopercmbio(somaPrazoParcela);
					if (!tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaFluxos().isEmpty()) {
						tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaFluxos().get(0).setTdiafinandsemb(somaPrazoParcela);
					}
				}
			}
    		
			if (somaValor.compareTo(new BigDecimal(itemListaFluxoPgto.getVprevtdsembcmbio().replaceAll("\\.","").replace(",","."))) != 0) {
				itemListaFluxoPgto.setVprevtdsembcmbio(SiteUtil.formatarValorWeb(somaValor));
	    		if (!isAlterarCotacao()) {
	    			tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().setVnegocmoedaestrg(itemListaFluxoPgto.getVprevtdsembcmbio());
					//Atualiza valores de comissao do banqueiro e Banco correspondente quando valor ME é alterado
					tradeFinanceNegociacaoInclBean.setBancoCorrespondenteParametro();
					if (!tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaFluxos().isEmpty()) {
	    				tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaFluxos().get(0).setVprevtdsembcmbio(itemListaFluxoPgto.getVprevtdsembcmbio());
	    			}
				} else {
					tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().setVnegocmoedaestrg(itemListaFluxoPgto.getVprevtdsembcmbio());
					//Atualiza valores de comissao do banqueiro e Banco correspondente quando valor ME é alterado
					tradeFinanceNegociacaoInclBean.setBancoCorrespondenteParametro();
					if (!tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaFluxos().isEmpty()) {
						tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaFluxos().get(0).setVprevtdsembcmbio(itemListaFluxoPgto.getVprevtdsembcmbio());
					}
				}
			}
			
			setItemListaFluxoPgtoAux(itemListaFluxoPgto);
			this.renderModal = Boolean.FALSE;
    		confirmarManutencao = Boolean.TRUE;
    		return "/content/global/fluxoPgtoManutModal/modalFluxoPgtoManutClose.xhtml";
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.confirmarModal <<<<<<<<<<<");
    	}
    	
    }
    
	public String btnCancelarFluxoPagamento() {
    	try{
			if (isAlterarCotacao == false) {
//	    		if (!tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaFluxos().isEmpty()) {
//	    			tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaFluxos().get(0).setListaParcelasFluxoPgto(tradeFinanceNegociacaoInclBean.getItemListaFluxoPgtoBackUp());
//				}
//	    		tradeFinanceNegociacaoInclBean.getItemListaFluxoPgto().setListaParcelasFluxoPgto(tradeFinanceNegociacaoInclBean.getItemListaFluxoPgtoBackUp());
//	    		tradeFinanceNegociacaoInclBean.getItemListaFluxoPgtoAux().setListaParcelasFluxoPgto(tradeFinanceNegociacaoInclBean.getItemListaFluxoPgtoBackUp());
			} else if (isAlterarCotacao == true) {
// IN2672152 - 13/06/19 - EM BOLETAGEM DE UM REFINIMP COM DOIS DESEMBOLSOS ESTÁ COM ERRO DE PARCELAS NO FLUXO DE PAGAMENTO
//	    		if (!tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaFluxos().isEmpty()) {
//	    			tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaFluxos().get(0).setListaParcelasFluxoPgto(tradeFinanceNegociacaoAltBean.getItemListaFluxoPgtoBackUp());
//				}
	    		tradeFinanceNegociacaoAltBean.getItemListaFluxoPgto().setListaParcelasFluxoPgto(tradeFinanceNegociacaoAltBean.getItemListaFluxoPgtoBackUp());
	    		tradeFinanceNegociacaoAltBean.getItemListaFluxoPgtoAux().setListaParcelasFluxoPgto(tradeFinanceNegociacaoAltBean.getItemListaFluxoPgtoBackUp());
			}
    		
    		return "/content/global/fluxoPgtoManutModal/modalFluxoPgtoManutClose.xhtml";
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.btnCancelarFluxoPagamento <<<<<<<<<<<");
    	}
    }
    
	/**
	* Nome: actionFecharModalConfirma
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
	public void actionFecharModalConfirma(ActionEvent e) {
		try{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] TradeFinanceNegociacaoInclBean.actionFecharModalConfirma <<<<<<<<<<<");
			if (EnumTradeFinance.ACESSO_CONFIRMAR_INCLUIR.getCodigo().equals(getTipoAcessoIncluirEvento())) {
				viewHelper.setRenderModal(Boolean.FALSE);
			}
			
			if (EnumTradeFinance.ACESSO_COTAR_CUSTO_EXTERNO.getCodigo().equals(getTipoAcessoIncluirEvento())) {
				viewHelper.setRenderModal(Boolean.FALSE);
				return;
			}
			setTipoAcessoIncluirEvento(Numeros.ZERO);
			setRenderModal(false);		
		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] TradeFinanceNegociacaoInclBean.actionFecharModalConfirma <<<<<<<<<<<");
		}
	}

    /**
     * 
     * Nome: closeModal
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 20/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.closeModal <<<<<<<<<<<");
    		
    		setConfirmarManutencao(Boolean.FALSE);
            // Por: Cláudio Tadeu em 21/10/2019 - IN? - Problema com a inclusão do fluxo de paramento na inclusão de cotação.
			if (!isAlterarCotacao()) {
				if(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaFluxos().size() <= 0) {
		    		setConfirmarManutencao(Boolean.TRUE);
				}
			}
            // *****
    		
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.closeModal <<<<<<<<<<<");
    	}
    	
    }

    /**
    * Nome: listenerIncluirParcelaIrregular
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 29/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void listenerIncluirParcelaIrregular(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerIncluirParcelaIrregular <<<<<<<<<<<");
    		
    		String tipoParcela = null;
    		
    		if (getItemListaParcelaIrreg().getTdianegocpcela() < Numeros.NUM0) {
    			NpcFacesUtils.addInfoModalMessage("Prazo inválido.", EnumButtonBehavior.SUBMIT);
    			return;
    		} 
    		// valida prazo
    		else if(!verificaPrazo()){
    		    return;
    		}
    		
    		getItemListaParcelaIrreg().setDvctopcelatrade(SiteUtil.dateToString(getItemListaParcelaIrreg().
    				getDateVctopcelatrade(), "dd.MM.yyyy"));
    		
    		if (SiteUtil.isEmptyOrNull(getItemListaParcelaIrreg().getDvctopcelatrade()) == true) {
    			NpcFacesUtils.addInfoModalMessage("Vencimento inválido.", EnumButtonBehavior.SUBMIT);
    			return;
    		}
    		
    		if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getMensagem())) {
                NpcFacesUtils.addInfoModalMessage(itemListaParcelaIrreg.getMensagem(), EnumButtonBehavior.SUBMIT);
                return;
            }
    		
    		tipoParcela =  "P";//getItemListaParcelaIrreg().getTpparcela().toUpperCase();
    		
    		// verifica a parcela incluida
    		conferirListaParcela();
    		
    		if (tipoParcela.equals("P")) {
    			if (qtdPrincipal >= itemListaFluxoPgto.getQtdeocorrprinc()) {
    				NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Principal já incluídas.", EnumButtonBehavior.SUBMIT);
    				return;
    			}
    		} else {
    			if (qtdJuros >= itemListaFluxoPgto.getQtdeocorrjuros()) {
    				NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Juros já incluídas.", EnumButtonBehavior.SUBMIT);
    				return;
    			}
    		}
    		getItemListaParcelaIrreg().setTpparcela(tipoParcela);
    		
    		getItemListaParcelaIrreg().setVenctoFluxDate(getItemListaParcelaIrreg().getDateVctopcelatrade());
    		
    		getItemListaParcelaIrreg().setVencimentoFluxoPgto(SiteUtil.trocarPontoPorBarra(getItemListaParcelaIrreg().getDvctopcelatrade()));
    		    		
    		if ((SiteUtil.isEmptyOrNull(getItemListaParcelaIrreg().getValorPrincipalParcelaFluxoPgto()) 
	                || SiteUtil.isValueZero(getItemListaParcelaIrreg().getValorPrincipalParcelaFluxoPgto()))
	                && tipoParcela.equals("P")) {
    		    
    			NpcFacesUtils.addInfoModalMessage("Valor inválido.", EnumButtonBehavior.SUBMIT);
    			return;
    		}else if(verificaTotalParcela()){
    		    
        		getItemListaParcelaIrreg().setVpcelamesatrade(getItemListaParcelaIrreg().getValorParcelaFluxoPgto());
        		
        		getItemListaFluxoPgto().getListaParcelasFluxoPgto().add(getItemListaParcelaIrreg());
        		setItemListaParcelaIrreg(new TrdFinNegParcelaVO());
        		
        		getViewHelper().setDisabledValorQuandoIrregularTipoJuros(Boolean.FALSE);
        		
        		ordenarListaParcelasFluxoPgto();
        		
        		if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() == 0) {
        			getItemListaParcelaIrreg().setValorParcelaFluxoPgto(itemListaFluxoPgto.getVprevtdsembcmbio());
    			} else {
    				
    				String vPrinc = itemListaFluxoPgto.getVprevtdsembcmbio();
    				for (int i = 0; i < itemListaFluxoPgto.getListaParcelasFluxoPgto().size(); i++) {
    					itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb("0,00"));
    					
    					itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
    					itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
    					
    					vPrinc = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorSaldoDevedorFluxoPgto().replaceAll("\\.","").replace(",",".");
    					
    					String vParce = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorPrincipalParcelaFluxoPgto().replaceAll("\\.","").replace(",",".");
    					
    					BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));
    					
    					itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
    					vPrinc = saldoDevedor.toString();
    				}
    			}
        		
        		if (itemListaFluxoPgto.isTodasPeriodicidadeIrregular() == false) {
        			if (itemListaFluxoPgto.getCfluxoliqdcprinc().equals(EnumTradeFinance.
        					PERIODICIDADE_IRREGULAR.getCodigo()) == true) {
        				getItemListaParcelaIrreg().setTpparcela("P");
        			} else {
        				getItemListaParcelaIrreg().setTpparcela("J");
        			}
        		}
        		
        		if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 10) {
        			SiteUtil.reiniciarPaginacao();
        		}
        	}  
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerIncluirParcelaIrregular <<<<<<<<<<<");
    	}
    	
    }
    
    private int conferirListaParcela() {
        TrdFinNegParcelaVO itemFluxo = null;
        
        qtdPrincipal = 0;
        qtdJuros = 0;
        
        for (Iterator<TrdFinNegParcelaVO> iterator = getItemListaFluxoPgto().getListaParcelasFluxoPgto().iterator();
                        iterator.hasNext();) {
            itemFluxo = (TrdFinNegParcelaVO) iterator.next();
            
            if (itemFluxo.getTpparcela().equals("P")) {
                qtdPrincipal++;
            } else {
                qtdJuros++;
            }
            qtdJuros = qtdPrincipal;
        }
        
        return 0;
        
    }
    
    public void valueChangeListener(ValueChangeEvent e) {
	   	UIData data = (UIData) e.getComponent().findComponent("tableParcela");
	   	linhaEditada = data.getRowIndex();
	   	
	   	valorAtual = "";
	   	novoValor = "";
	   	
	   	if (e.getOldValue() != null && !e.getOldValue().toString().equals(null) && !e.getOldValue().toString().equals("")) {
	   		valorAtual = e.getOldValue().toString();
		}
	   	if (e.getNewValue() != null && !e.getNewValue().equals(null) && !e.getNewValue().equals("")) {
	   		novoValor = e.getNewValue().toString();
	   	}
	   	
	   	if (!tradeFinanceNegociacaoInclBean.getViewHelper().getFuncaoBotaoFluxo().equals("Excluir") && !tradeFinanceNegociacaoInclBean.getViewHelper().getFuncaoBotaoFluxo().equals("Incluir")) {
	   		tradeFinanceNegociacaoInclBean.getViewHelper().setFuncaoBotaoFluxo("Alterar");
		} else if (!tradeFinanceNegociacaoAltBean.getViewHelper().getFuncaoBotaoFluxo().equals("Excluir") && !tradeFinanceNegociacaoAltBean.getViewHelper().getFuncaoBotaoFluxo().equals("Incluir")) {
	   		tradeFinanceNegociacaoAltBean.getViewHelper().setFuncaoBotaoFluxo("Alterar");
		}
	   	
	   	UIEditableColumn coluna = (UIEditableColumn) e.getComponent().getParent();
	   	colunaEditada = coluna.getId();
	   	
	   	setEditado(true);
    }
    
    public void listenerTrocaPrazo(AjaxBehaviorEvent e) {
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
    		
    		itemListaParcelaIrreg.setVencimentoFluxoPgto(null);
    		itemListaParcelaIrreg.setDateVctopcelatrade(null);
    		
    		//O vencimento da parcela deve ser maior que da anterior
    		obterDtVencParcelaAnterior2();
    		
    		fluxoPgtoModalService.calcularDataVencimentoOuPrazo(itemListaFluxoPgto, itemListaParcelaIrreg);
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
    	}
    }
    
    public void listenerTrocaPrazo2(AjaxBehaviorEvent e) {
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaPrazo2 <<<<<<<<<<<");
    		listenerTrocaPrazo ();
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaPrazo2 <<<<<<<<<<<");
    	}
    }
    
	public String listenerTrocaPrazo () {
    	try{
    		TrdFinNegParcelaVO trdFinNegParcelaVO = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada);
    		if (getEditado() == true && trdFinNegParcelaVO.getNpceladsembtrade() == (linhaEditada +1)) {
    			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
    			
    			if (colunaEditada.equals("prazo")) {
    				if (validarLimiteParaEditarPrazo()) {
						setItemListaParcelaIrreg(trdFinNegParcelaVO);
    					//O vencimento da parcela deve ser maior que da anterior
    					if (!itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular")) {
    						itemListaParcelaIrreg.setVencimentoFluxoPgto(null);
    						itemListaParcelaIrreg.setDateVctopcelatrade(null);

    						obterDtVencParcelaAnterior2();
    						if (isAlterarCotacao == false) {
    							fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							} else if (isAlterarCotacao == true) {
								fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoAltBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							}
    					} else {
    						itemListaParcelaIrreg.setDateVctopcelatrade(null);

    						//O vencimento da parcela deve ser maior que da anterior
    						obterDtVencParcelaAnterior2();
    						itemListaParcelaIrreg.setDateVctopcelatrade(null);
    						fluxoPgtoModalService.calcularDataVencimentoOuPrazo(itemListaFluxoPgto, itemListaParcelaIrreg);

    						if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getMensagem())) {
    							setItemListaParcelaIrreg(new TrdFinNegParcelaVO());
    							NpcFacesUtils.addInfoModalMessage(itemListaParcelaIrreg.getMensagem(), EnumButtonBehavior.SUBMIT);
    						}
    					}
    					if(trdFinNegParcelaVO.getDateVctopcelatrade() == null) {
    						trdFinNegParcelaVO.setTdianegocpcela(Integer.parseInt(valorAtual));

    						itemListaParcelaIrreg.setVencimentoFluxoPgto(null);
    						itemListaParcelaIrreg.setDateVctopcelatrade(null);

    						obterDtVencParcelaAnterior2();
    						
    						if (isAlterarCotacao == false) {
    							fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							} else if (isAlterarCotacao == true) {
								fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoAltBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							}
    					} else if (linhaEditada < itemListaFluxoPgto.getListaParcelasFluxoPgto().size()-1 && !itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular")) {
    						itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada + 1).setTdianegocpcela(calcularProximaParcela(linhaEditada + 1));
    					}
    				} else {
    					trdFinNegParcelaVO.setTdianegocpcela(Integer.parseInt(valorAtual));
    					NpcFacesUtils.addInfoModalMessage("A nova data gerada deve estar entre a parcela anterior e a próxima parcela", EnumButtonBehavior.SUBMIT);
					}
    			} else if (colunaEditada.equals("vencimento")) {
    				if (validarLimiteParaEdicao()) {
    					setItemListaParcelaIrreg(trdFinNegParcelaVO);
    					//O vencimento da parcela deve ser maior que da anterior
    					if (!itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular")) {
    						itemListaParcelaIrreg.setTdianegocpcela(null);
    						obterDtVencParcelaAnteriorVencimento2();
    						if (isAlterarCotacao == false) {
    							fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							} else if (isAlterarCotacao == true) {
								fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoAltBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							}
    					} else {
    						itemListaParcelaIrreg.setTdianegocpcela(null);

    						//O vencimento da parcela deve ser maior que da anterior
    						obterDtVencParcelaAnterior2();

    						fluxoPgtoModalService.calcularDataVencimentoOuPrazo(itemListaFluxoPgto, itemListaParcelaIrreg);

    						if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getMensagem())) {
    							setItemListaParcelaIrreg(new TrdFinNegParcelaVO());
    							NpcFacesUtils.addInfoModalMessage(itemListaParcelaIrreg.getMensagem(), EnumButtonBehavior.SUBMIT);
    						}
    					}
    					if(trdFinNegParcelaVO.getTdianegocpcela() == null) {
    						trdFinNegParcelaVO.setVencimentoFluxoPgto(valorAtual);

    						itemListaParcelaIrreg.setTdianegocpcela(null);
    						obterDtVencParcelaAnteriorVencimento2();
    						if (isAlterarCotacao == false) {
    							fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							} else if (isAlterarCotacao == true) {
								fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoAltBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
							}
    					} else  if (linhaEditada < itemListaFluxoPgto.getListaParcelasFluxoPgto().size()-1 && !itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular")) {
    						itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada + 1).setTdianegocpcela(calcularProximaParcela(linhaEditada + 1));
    					}
    				} else {
    					trdFinNegParcelaVO.setVencimentoFluxoPgto(valorAtual);
    					NpcFacesUtils.addInfoModalMessage("A nova data deve estar entre a parcela anterior e a próxima parcela", EnumButtonBehavior.SUBMIT);
					}
    			} else if (colunaEditada.equals("principal")) {
					BigDecimal diferencaParcela = new BigDecimal("0.00");
					BigDecimal valorDistribuido = new BigDecimal("0.00");
					
					somaValor = new BigDecimal("0.00");
					int parcelaPrincEditada = 0;
					for (int i = 0; i <= linhaEditada; i++) {
						if (itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTpparcela().equals("P")) {
							parcelaPrincEditada ++;
						}
					}
					
					for (int i = 0; i < itemListaFluxoPgto.getListaParcelasFluxoPgto().size(); i++) {
						if (itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTpparcela().equals("P")) {
							NumberFormat nf2 = new java.text.DecimalFormat("#,###,##0.00");
							String valorString = nf2.format (new BigDecimal(itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorPrincipalParcelaFluxoPgto().replaceAll("\\.","").replace(",",".")));

							BigDecimal somaValorAux = new BigDecimal(valorString.replaceAll("\\.","").replace(",","."));
							
							if (i > linhaEditada) {
								int divisor = itemListaFluxoPgto.getQtdeocorrprinc() - parcelaPrincEditada;
								if (new BigDecimal(valorAtual.replaceAll("\\.","").replace(",",".")).compareTo(new BigDecimal(novoValor.replaceAll("\\.","").replace(",","."))) > 0) {
									diferencaParcela = new BigDecimal(valorAtual.replaceAll("\\.","").replace(",",".")).subtract(new BigDecimal(novoValor.replaceAll("\\.","").replace(",",".")));

									valorDistribuido = casasDecimais(2, diferencaParcela.divide(new BigDecimal(divisor), MathContext.DECIMAL32));

									BigDecimal valor1 = new BigDecimal(valorDistribuido.toString()).multiply(new BigDecimal(divisor));
									if (valor1.compareTo(diferencaParcela) < 0 && i == (itemListaFluxoPgto.getListaParcelasFluxoPgto().size() - 1)) {
										BigDecimal acertoParcela = diferencaParcela.subtract(valor1);
										valorDistribuido = valorDistribuido.add(acertoParcela);
										valorDistribuido = somaValorAux.add(valorDistribuido);
									} else if (valor1.compareTo(diferencaParcela) > 0 && i == (itemListaFluxoPgto.getListaParcelasFluxoPgto().size() - 1)) {
										BigDecimal acertoParcela = valor1.subtract(diferencaParcela);
										valorDistribuido = valorDistribuido.subtract(acertoParcela);
										valorDistribuido = somaValorAux.add(valorDistribuido);
									} else {
										valorDistribuido = somaValorAux.add(valorDistribuido);
									}
									somaValor = valorDistribuido.add(somaValor);
									itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(valorDistribuido));
								} else if (new BigDecimal(valorAtual.replaceAll("\\.","").replace(",",".")).compareTo(new BigDecimal(novoValor.replaceAll("\\.","").replace(",","."))) < 0) {
									diferencaParcela = new BigDecimal(novoValor.replaceAll("\\.","").replace(",",".")).subtract(new BigDecimal(valorAtual.replaceAll("\\.","").replace(",",".")));

									valorDistribuido = casasDecimais(2, diferencaParcela.divide(new BigDecimal(divisor), MathContext.DECIMAL32));

									BigDecimal valor1 = new BigDecimal(valorDistribuido.toString()).multiply(new BigDecimal(divisor));
									if (valor1.compareTo(diferencaParcela) < 0 && i == (itemListaFluxoPgto.getListaParcelasFluxoPgto().size() - 1)) {
										BigDecimal acertoParcela = diferencaParcela.subtract(valor1);
										valorDistribuido = valorDistribuido.add(acertoParcela);
										valorDistribuido = somaValorAux.subtract(valorDistribuido);
									} else if (valor1.compareTo(diferencaParcela) > 0 && i == (itemListaFluxoPgto.getListaParcelasFluxoPgto().size() - 1)) {
										BigDecimal acertoParcela = valor1.subtract(diferencaParcela);
										valorDistribuido = valorDistribuido.subtract(acertoParcela);
										valorDistribuido = somaValorAux.subtract(valorDistribuido);
									} else {
										valorDistribuido = somaValorAux.subtract(valorDistribuido);
									}

									somaValor = valorDistribuido.add(somaValor);
									itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(valorDistribuido));
								}
							} else {
								if (i == linhaEditada) {
									itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorPrincipalParcelaFluxoPgto(SiteUtil.formatarValorWeb(somaValorAux));
								}
								somaValor = somaValorAux.add(somaValor);
							}
						}
					}
					String vPrinc = somaValor.toString();
					for (int i = 0; i < itemListaFluxoPgto.getListaParcelasFluxoPgto().size(); i++) {
						if (itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTpparcela().equals("P")) {
							itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
							itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));

							vPrinc = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorSaldoDevedorFluxoPgto().replaceAll("\\.","").replace(",",".");

							String vParce = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorPrincipalParcelaFluxoPgto().replaceAll("\\.","").replace(",",".");

							BigDecimal saldoDevedor = new BigDecimal(vPrinc).subtract(new BigDecimal(vParce));

							itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(saldoDevedor.toString()));
							vPrinc = saldoDevedor.toString();
						} else {
							itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorParcelaFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
							itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorSaldoDevedorFluxoPgto(SiteUtil.formatarValorWeb(vPrinc));
						}
					}
				} else if (colunaEditada.equals("juros")) {
					
				}
    			if (tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getCcomiscartanacio() != null) {
        			if ((tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getCcomiscartanacio().equals("1")) 
        					&& taxaFixaMaiorQueZero(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getVtravaliborcmbio())) {
        				BigDecimal custoTotal = calcularCustoTotal(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getVtravaliborcmbio(), tradeFinanceNegociacaoInclBean.getItemListaComissaoInterna().getPtxcustoexter());
        				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
        					if ((getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || itemListaFluxoPgto.getNomeJurosPeriodicidade().equals("Inicial")) || getItemListaFluxoPgto().getQtdeocorrjuros() % getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
        						calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
        					} else {
        						calcularJuros(custoTotal.toString().replace(".",","));
        					}
        				}
        			} else if (tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaComissaoInterna() != null && tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getListaComissaoInterna().size() > 0 ) {
        				if ((tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || tradeFinanceNegociacaoInclBean.getTradeFinNegocVO().getCcomiscartanacio().equals("2"))
        						&& taxaFixaMaiorQueZero(tradeFinanceNegociacaoInclBean.getItemListaComissaoInterna().getVtravaliborcmbio())) {
        					BigDecimal custoTotal = calcularCustoTotal(tradeFinanceNegociacaoInclBean.getItemListaComissaoInterna().getVtravaliborcmbio(), tradeFinanceNegociacaoInclBean.getItemListaComissaoInterna().getPtxcustoexter(), tradeFinanceNegociacaoInclBean.getItemListaComissaoInterna().getVtxspreadtot());
        					if (taxaFixaMaiorQueZero(custoTotal.toString())) {
        						if ((getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || itemListaFluxoPgto.getNomeJurosPeriodicidade().equals("Inicial")) || getItemListaFluxoPgto().getQtdeocorrjuros() % getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
        							calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
        						} else {
        							calcularJuros(custoTotal.toString().replace(".",","));
        						}
        					}
        				}
        			}
				} else if (tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getCcomiscartanacio() != null) {
	    			if ((tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getCcomiscartanacio().equals("1")) 
	    					&& taxaFixaMaiorQueZero(tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getVtravaliborcmbio())) {
	    				BigDecimal custoTotal = calcularCustoTotal(tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getVtravaliborcmbio(), 
	    						tradeFinanceNegociacaoAltBean.getViewHelper().getValueComissaoCobranca());
	    				if (taxaFixaMaiorQueZero(custoTotal.toString())) {
	    					if ((getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || itemListaFluxoPgto.getNomeJurosPeriodicidade().equals("Inicial")) || getItemListaFluxoPgto().getQtdeocorrjuros() % getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    						calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
	    					} else {
	    						calcularJuros(custoTotal.toString().replace(".",","));
	    					}
	    				}
	    			} else if (tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaComissaoInterna() != null && tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getListaComissaoInterna().size() > 0 ) {
	    				if ((tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || tradeFinanceNegociacaoAltBean.getTradeFinNegocVO().getCcomiscartanacio().equals("2"))
	    						&& taxaFixaMaiorQueZero(tradeFinanceNegociacaoAltBean.getItemListaComissaoInterna().getVtravaliborcmbio())) {
	    					BigDecimal custoTotal = calcularCustoTotal(tradeFinanceNegociacaoAltBean.getItemListaComissaoInterna().getVtravaliborcmbio(), tradeFinanceNegociacaoAltBean.getItemListaComissaoInterna().getPtxcustoexter(), tradeFinanceNegociacaoAltBean.getItemListaComissaoInterna().getVtxspreadtot());
	    					if (taxaFixaMaiorQueZero(custoTotal.toString())) {
	    						if ((getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || itemListaFluxoPgto.getNomeJurosPeriodicidade().equals("Inicial")) || getItemListaFluxoPgto().getQtdeocorrjuros() % getItemListaFluxoPgto().getQtdeocorrprinc() != 0) {
	    							calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
	    						} else {
	    							calcularJuros(custoTotal.toString().replace(".",","));
	    						}
	    					}
	    				}
	    			}
				}

        		setEditado(false);
	    		colunaEditada = "";
			}
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaPrazo <<<<<<<<<<<");
    	}
    	return "/content/global/fluxoPgtoManutModal/modalFluxoPgtoManut.xhtml";
    }
    
	private boolean validarLimiteParaEditarPrazo() {
		if (novoValor == null || novoValor == "") {
			return false;
		}
		
		Integer valorSeguinte;
		if (linhaEditada < itemListaFluxoPgto.getListaParcelasFluxoPgto().size() -1) {
			valorSeguinte = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada +1).getTdianegocpcela();
		} else {
			valorSeguinte = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getTdianegocpcela();
		}
		
		if (Integer.parseInt(novoValor) > 0 && (Integer.parseInt(novoValor) < Integer.parseInt(valorAtual) + valorSeguinte || linhaEditada == itemListaFluxoPgto.getListaParcelasFluxoPgto().size() -1)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validarLimiteParaEdicao() {
		String dataEditadaTemp = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getVencimentoFluxoPgto();
		if (dataEditadaTemp.length() < 8 || dataEditadaTemp.length() > 10) {
			return false;
		} else if (dataEditadaTemp.length() != 10) {
			StringBuilder dataFormatada = new StringBuilder(itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getVencimentoFluxoPgto());
			dataFormatada.insert(2, "/");
			dataFormatada.insert(5, "/");
			itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).setVencimentoFluxoPgto(dataFormatada.toString());
			dataEditadaTemp = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getVencimentoFluxoPgto();
		}
		
		String dataAnterior = "";
		String dataSeguinte = "";
		if (linhaEditada == 0) {
			dataAnterior = itemListaFluxoPgto.getDprevtdsembcmbio();
		} else {
			dataAnterior = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada - 1).getVencimentoFluxoPgto();
		}
		
		if (linhaEditada < itemListaFluxoPgto.getListaParcelasFluxoPgto().size() -1) {
			dataSeguinte = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada + 1).getVencimentoFluxoPgto();
		} else {
			dataSeguinte = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getVencimentoFluxoPgto();
		}
		
		try {
			if (SiteUtil.stringToDate(dataEditadaTemp, "dd/MM/yyyy").after(SiteUtil.stringToDate(dataAnterior, "dd/MM/yyyy")) && 
					(SiteUtil.stringToDate(dataSeguinte, "dd/MM/yyyy").after(SiteUtil.stringToDate(dataEditadaTemp, "dd/MM/yyyy")) || linhaEditada == itemListaFluxoPgto.getListaParcelasFluxoPgto().size() -1)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean taxaFixaMaiorQueZero(String valor){
		boolean retorno = false;
		if (valor == null || valor.equals("")) {
			valor = "0.00";
		}
		BigDecimal seuBigdecimal = new BigDecimal(valor.replace(",", "."));
		if (seuBigdecimal.signum() > 0) {
			retorno = true;
		} else {
			retorno = false;
		}
		return retorno;
	}
	
    public int calcularProximaParcela(int i) {
    	String dataParcelaAtual = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getVencimentoFluxoPgto();
    	
    	String proximaParcela = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getVencimentoFluxoPgto();
    	
    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dataMaior = null;
		Date dataMenor = null;
		try {
			dataMaior = (Date)formatter.parse(proximaParcela);
			dataMenor = (Date)formatter.parse(dataParcelaAtual);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(dataMenor);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(dataMaior);

		Long diferencaDiasLong = ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24*60*60*1000));
   		
		int diferencaDias = Integer.valueOf((int) diferencaDiasLong.longValue());
		
   		System.out.println(diferencaDias);
   		
   		return diferencaDias;
	}
    
    public void calcularJurosMainFrame(TrdFinNegComissaoVO itemComissaoInterna, TrdFinNegFluxoPagtoVO itemListaFluxoPgto2, String taxaDeJuros) {
    	comissaoInternaExternaModalService.calculoJuros(itemComissaoInterna, itemListaFluxoPgto, taxaDeJuros);
    }
    
    public void calcularJurosPeriodicidadeDiferente(String taxaDeJuros) {
		//Saldo Devedor*(Libor Travada*Prazo Parcela)/360
		taxaDeJuros = taxaDeJuros.replaceAll("\\.","").replace(",",".");
		
		BigDecimal taxaDeJurosAux = new BigDecimal(taxaDeJuros).divide(new BigDecimal("100"));
		BigDecimal valor3;
		Integer prazoParcela = 0;
		for (int i = 0; i < itemListaFluxoPgto.getListaParcelasFluxoPgto().size(); i++) {
			String ValorJurosTemp = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorJurosParcelaFluxoPgto();
			if (!SiteUtil.isEmptyOrNull(ValorJurosTemp) && i < itemListaFluxoPgto.getListaParcelasFluxoPgto().size()) {
				String saldoDevedorAtual = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorParcelaFluxoPgto().replaceAll("\\.","").replace(",",".");
				if (itemListaFluxoPgto.getCodJurosPeriodicidade() == 14 || itemListaFluxoPgto.getNomeJurosPeriodicidade().equals("Inicial")) {
					prazoParcela = itemListaFluxoPgto.getTdiaopercmbio();
				} else if (prazoParcela == 0) {
					prazoParcela = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTdianegocpcela();
				}
				BigDecimal valor1 = new BigDecimal(taxaDeJurosAux.toString()).multiply(new BigDecimal(prazoParcela));
				BigDecimal resultado = casasDecimais(10, valor1.divide(new BigDecimal("360"), MathContext.DECIMAL32));

				valor3 = casasDecimais(10, new BigDecimal(saldoDevedorAtual).multiply(new BigDecimal(resultado.toString()), MathContext.DECIMAL32));

				itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(valor3.toString()));
				prazoParcela = 0;
			} else if ((itemListaFluxoPgto.getCodJurosPeriodicidade() != 14) && (!itemListaFluxoPgto.getNomeJurosPeriodicidade().equals("Inicial"))) {
				Integer prazoParcelaTemp = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTdianegocpcela();
				Integer prazoParcelaAux = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i+1).getTdianegocpcela();
				prazoParcela = prazoParcelaTemp + prazoParcelaAux;
			} else if (itemListaFluxoPgto.getCodJurosPeriodicidade() == 14 || itemListaFluxoPgto.getNomeJurosPeriodicidade().equals("Inicial")) {
				String saldoDevedorAtual = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorParcelaFluxoPgto().replaceAll("\\.","").replace(",",".");
				if (prazoParcela == 0) {
					prazoParcela = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTdianegocpcela();
				}
				BigDecimal valor1 = new BigDecimal(taxaDeJurosAux.toString()).multiply(new BigDecimal(prazoParcela));
				BigDecimal resultado = casasDecimais(10, valor1.divide(new BigDecimal("360"), MathContext.DECIMAL32));

				valor3 = casasDecimais(10, new BigDecimal(saldoDevedorAtual).multiply(new BigDecimal(resultado.toString()), MathContext.DECIMAL32));

				itemListaFluxoPgto.getListaParcelasFluxoPgto().get(0).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(valor3.toString()));
				prazoParcela = 0;
			}
		}
    }
    
	public void calcularJuros(String taxaDeJuros) {
		//Saldo Devedor*(Libor Travada*Prazo Parcela)/360
		taxaDeJuros = taxaDeJuros.replaceAll("\\.","").replace(",",".");
		
		BigDecimal taxaDeJurosAux = new BigDecimal(taxaDeJuros).divide(new BigDecimal("100"));
		BigDecimal valor3;
		for (int i = 0; i < itemListaFluxoPgto.getListaParcelasFluxoPgto().size(); i++) {
			String saldoDevedorAtual = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getValorParcelaFluxoPgto().replaceAll("\\.","").replace(",",".");

			Integer prazoParcela = itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).getTdianegocpcela();

			BigDecimal valor1 = new BigDecimal(taxaDeJurosAux.toString()).multiply(new BigDecimal(prazoParcela));
			BigDecimal resultado = casasDecimais(10, valor1.divide(new BigDecimal("360"), MathContext.DECIMAL32));

			valor3 = casasDecimais(10, new BigDecimal(saldoDevedorAtual).multiply(new BigDecimal(resultado.toString()), MathContext.DECIMAL32));

			itemListaFluxoPgto.getListaParcelasFluxoPgto().get(i).setValorJurosParcelaFluxoPgto(SiteUtil.formatarValorWeb(valor3.toString()));
		}
	}
    
	public BigDecimal casasDecimais(int casas, BigDecimal valor){
	    String quantCasas = "%."+casas+"f", textoValor = "0";
	    try {
	        textoValor = String.format(Locale.getDefault(), quantCasas, valor);
	    } catch(java.lang.IllegalArgumentException e) {
	        if(e.getMessage().equals("Digits < 0")){
	            textoValor = "0";
	        }
	        BradescoCommonServiceFactory.getLogManager().error(e.getMessage());
	    }
	    return new BigDecimal(textoValor.replace(",", "."));
	}
	
    private BigDecimal calcularCustoTotal(String vtravaliborcmbio, String ptxcustototal, String vtxspreadtot) {
    	ptxcustototal = ptxcustototal.replace(".",",");
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(ptxcustototal.replaceAll("\\.","").replace(",","."));
		BigDecimal spredTotal = new BigDecimal(vtxspreadtot.replaceAll("\\.","").replace(",","."));
		
		overlibor = liborTravada.add(overlibor);
		
		return overlibor.add(spredTotal);
	}
    
    private BigDecimal calcularCustoTotal(String vtravaliborcmbio, String ptxcustototal) {
    	if (vtravaliborcmbio == null) {
    		vtravaliborcmbio = "0.00";
		}
    	
    	if (ptxcustototal == null) {
    		ptxcustototal = "0.00";
		}
    	ptxcustototal = ptxcustototal.replace(".",",");
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(ptxcustototal.replaceAll("\\.","").replace(",","."));
		
		return liborTravada.add(overlibor);
	}
	
    public void listenerTrocaDataVencimento(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
    		
    		itemListaParcelaIrreg.setTdianegocpcela(null);
    		
    		//O vencimento da parcela deve ser maior que da anterior
    		obterDtVencParcelaAnterior();
    		
    		fluxoPgtoModalService.calcularDataVencimentoOuPrazo(itemListaFluxoPgto, itemListaParcelaIrreg);
    		
    		if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getMensagem())) {
    		    itemListaParcelaIrreg.setDateVctopcelatrade(null);
                itemListaParcelaIrreg.setTdianegocpcela(Numeros.ZERO);
    			NpcFacesUtils.addInfoModalMessage(itemListaParcelaIrreg.getMensagem(), EnumButtonBehavior.SUBMIT);
    		}
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
    	}
    	
    }
    
    public void listenerTrocaDataVencimento (TrdFinNegParcelaVO trdFinNegParcelaVO) {
    	try{
    		if (getEditado() == true && trdFinNegParcelaVO.getNpceladsembtrade() == (linhaEditada +1) && colunaEditada == "vencimento") {
	    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
	    		itemListaParcelaIrreg.setTdianegocpcela(null);
	    		setItemListaParcelaIrreg(trdFinNegParcelaVO);
	    		//O vencinto da parcela deve ser maior que da anterior
	    		obterDtVencParcelaAnteriorVencimento();
	    		
				if (isAlterarCotacao == false) {
					fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoInclBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
				} else if (isAlterarCotacao == true) {
					fluxoPgtoModalService.calcularDataVencimentoOuPrazoLinha(tradeFinanceNegociacaoAltBean.getTradeFinNegocVO(), itemListaFluxoPgto, itemListaParcelaIrreg , linhaEditada);
				}
	    		setEditado(false);
	    		colunaEditada = "";
    		}
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaDataVencimento <<<<<<<<<<<");
    	}
    }
    
    /**
    * Nome: listenerExcluirParcelaIrregular
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 29/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public void listenerExcluirParcelaIrregular(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerExcluirParcelaIrregular <<<<<<<<<<<");
    		
    		TrdFinNegParcelaVO itemParcela = null;
    		
    		// valida se foi selecionado um item na lista
    		if (SiteUtil.isEmptyOrNull(getViewHelper().getItemSelecListaParcelaComiss())) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um registro.", EnumButtonBehavior.SUBMIT);
    			return;
    		}
    		
    		itemParcela = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(Integer.parseInt(getViewHelper().getItemSelecListaParcelaComiss()));
    		
    		// Remove o item selecionado.
    		getItemListaFluxoPgto().getListaParcelasFluxoPgto().remove(itemParcela);
    		
    		getViewHelper().setItemSelecListaParcelaComiss(null);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerExcluirParcelaIrregular <<<<<<<<<<<");
    	}
    	
        
    }
    
    /**
     * Nome: listenerTrocaTipoParcelaIrregular
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 29/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void listenerTrocaTipoParcelaIrregular(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.listenerTrocaTipoParcelaIrregular <<<<<<<<<<<");
    		
    		if("J".equals(getItemListaParcelaIrreg().getTpparcela())){
    			viewHelper.setDisabledValorQuandoIrregularTipoJuros(Boolean.TRUE);
    			getItemListaParcelaIrreg().setValorParcelaFluxoPgto("0,00");
    		}else{
    			viewHelper.setDisabledValorQuandoIrregularTipoJuros(Boolean.FALSE);
    		}
    		
    		itemListaParcelaIrreg.setTdianegocpcela(null);
            itemListaParcelaIrreg.setDateVctopcelatrade(null);
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.listenerTrocaTipoParcelaIrregular <<<<<<<<<<<");
    	}
    	
    	
    }

    private void ordenarListaParcelasFluxoPgto() {
        int numParcela = 1;

        Collections.sort(getItemListaFluxoPgto().getListaParcelasFluxoPgto());

        numParcela = 1;
        for (TrdFinNegParcelaVO item : getItemListaFluxoPgto().getListaParcelasFluxoPgto()) {
            item.setNpceladsembtrade(numParcela++);
        }
        
    }
    
    /**
     * 
    	* Nome: obterDataVencimento
    	* 
    	* Propósito: Separado entre 'Principal' e 'Juros' a data de vencimento deve ser maior que a data da parcela anterior
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 15/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void obterDtVencParcelaAnterior2(){
    	if (getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() == 0) {
    		itemListaParcelaIrreg.setVencimentoFluxoPgto(itemListaFluxoPgto.getDprevtdsembcmbio());
		} else {
			int index = 0;
			if (linhaEditada > 0 && getEditado() == true) {
				index = linhaEditada - 1;
			} else if (linhaEditada == 0 && getEditado() == false) {
				index = getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() -1;
			}
			
			for (int i = index; i >= 0; i--) {
				TrdFinNegParcelaVO negParcelaVO;
				if (linhaEditada > 0 && (!itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular"))) {
					negParcelaVO = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(i);
					itemListaParcelaIrreg.setVencimentoFluxoPgto(negParcelaVO.getVencimentoFluxoPgto());
					break;
				} else if (linhaEditada > 0 && linhaEditada == i && itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular")) {
					negParcelaVO = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(linhaEditada);

					itemListaParcelaIrreg.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getVencimentoFluxoPgto()));
					itemListaParcelaIrreg.setVencimentoFluxoPgto(itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada-1).getVencimentoFluxoPgto());
				} else if (getEditado() == true && linhaEditada == i && linhaEditada == 0 && itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular")) {
					itemListaParcelaIrreg.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(itemListaFluxoPgto.getListaParcelasFluxoPgto().get(linhaEditada).getVencimentoFluxoPgto()));
					itemListaParcelaIrreg.setVencimentoFluxoPgto(itemListaFluxoPgto.getDprevtdsembcmbio());
				} else if (getEditado() == true && linhaEditada == i && linhaEditada == 0 && (!itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular"))) {
					itemListaParcelaIrreg.setVencimentoFluxoPgto(itemListaFluxoPgto.getDprevtdsembcmbio());				
				} else if (getEditado() == false && i == 0 && itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular")) {
					negParcelaVO = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() - 1);

					itemListaParcelaIrreg.setVencimentoFluxoPgto(negParcelaVO.getVencimentoFluxoPgto());
				}
			}
		}
    }
    
    public void obterDtVencParcelaAnterior(){
        //Caso não tenha parcela incluída, a primeira deve passar como parametro a data de previsao de desembolso
        itemListaParcelaIrreg.setVencimentoFluxoPgto(itemListaFluxoPgto.getDprevtdsembcmbio());
        for(int i = getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() -1 ; i >= 0; i--){
        	TrdFinNegParcelaVO negParcelaVO;
        	if (linhaEditada > 0) {
        		negParcelaVO = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(linhaEditada-1);
                
        		if(!SiteUtil.isEmptyOrNull(itemListaParcelaIrreg.getTpparcela()) && itemListaParcelaIrreg.getTpparcela().equals(negParcelaVO.getTpparcela())){
                    itemListaParcelaIrreg.setVencimentoFluxoPgto(negParcelaVO.getVencimentoFluxoPgto());
                    break;
        		}
			}
        }
    }
    
    public void obterDtVencParcelaAnteriorVencimento2(){
        //Caso não tenha parcela incluída, a primeira deve passar como parametro a data de previsao de desembolso
    	itemListaParcelaIrreg.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(itemListaParcelaIrreg.getVencimentoFluxoPgto()));
        itemListaParcelaIrreg.setVencimentoFluxoPgto(itemListaFluxoPgto.getDprevtdsembcmbio());
        for(int i = getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() -1 ; i >= 0; i--){
        	TrdFinNegParcelaVO negParcelaVO;
        	if (linhaEditada > 0 && getEditado() == true) {
        		negParcelaVO = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(linhaEditada-1);
                itemListaParcelaIrreg.setVencimentoFluxoPgto(negParcelaVO.getVencimentoFluxoPgto());
                break;
        	} else if (itemListaFluxoPgto.getNomePrincPeriodicidade().equals("Irregular") && getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() > 0) {
        		negParcelaVO = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(getItemListaFluxoPgto().getListaParcelasFluxoPgto().size()-1);
        		itemListaParcelaIrreg.setVencimentoFluxoPgto(negParcelaVO.getVencimentoFluxoPgto());
        		break;
			}
        }
    }
    
    public void obterDtVencParcelaAnteriorVencimento(){
        //Caso não tenha parcela incluída, a primeira deve passar como parametro a data de previsao de desembolso
    	itemListaParcelaIrreg.setDateVctopcelatrade(SiteUtil.dataMainframeToWeb(itemListaParcelaIrreg.getVencimentoFluxoPgto()));
        itemListaParcelaIrreg.setVencimentoFluxoPgto(itemListaFluxoPgto.getDprevtdsembcmbio());
        for(int i = getItemListaFluxoPgto().getListaParcelasFluxoPgto().size() -1 ; i >= 0; i--){
        	TrdFinNegParcelaVO negParcelaVO;
        	if (linhaEditada > 0) {
        		negParcelaVO = getItemListaFluxoPgto().getListaParcelasFluxoPgto().get(linhaEditada-1);
                itemListaParcelaIrreg.setVencimentoFluxoPgto(negParcelaVO.getVencimentoFluxoPgto());
                break;
			} 
        }
    }
    
    /**
     * 
    	* Nome: listenerVerificaTotalParcela
    	* 
    	* Propósito: Verificar se o valor da parcela ou a somatória delas não ultrapassa o Valor Total 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 16/09/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private boolean verificaTotalParcela() {
        boolean valido = Boolean.TRUE;
        if (!SiteUtil.isEmptyOrNull(getItemListaParcelaIrreg().getValorPrincipalParcelaFluxoPgto()) 
                && !SiteUtil.isValueZero(getItemListaParcelaIrreg().getValorPrincipalParcelaFluxoPgto())
                && getItemListaParcelaIrreg().getTpparcela().equals("P")) {
            
            Double valorTotal = SiteUtil.webMoedaToDouble(itemListaFluxoPgto.getVprevtdsembcmbio());
            Double valorSoma = SiteUtil.webMoedaToDouble(itemListaParcelaIrreg.getValorPrincipalParcelaFluxoPgto());
            
            conferirListaParcela();
            
            if (qtdPrincipal >= itemListaFluxoPgto.getQtdeocorrprinc() && valorSoma.compareTo(valorTotal) != 0) {
                NpcFacesUtils.addInfoModalMessage("Qtde. Parcelas do Principal já incluídas.", EnumButtonBehavior.SUBMIT);
                NpcFacesUtils.addInfoModalMessage("A soma dos valores das parcelas deve ser igual ao Valor Total.", EnumButtonBehavior.SUBMIT);
                valido = Boolean.FALSE;
            }
            
            if(valorSoma.compareTo(valorTotal) <= 0){
                for(TrdFinNegParcelaVO negParcelaVO : itemListaFluxoPgto.getListaParcelasFluxoPgto()){
                    valorSoma += SiteUtil.webMoedaToDouble(negParcelaVO.getValorPrincipalParcelaFluxoPgto());
                    
                    if(valorSoma.compareTo(valorTotal) > 0){
                        itemListaParcelaIrreg.setValorPrincipalParcelaFluxoPgto("0,00");
                        NpcFacesUtils.addInfoModalMessage("Soma dos valores das parcelas não deve ser superior ao Valor Total.", EnumButtonBehavior.SUBMIT);
                        valido = Boolean.FALSE;
                        break;
                    }
                }
            }else{
                NpcFacesUtils.addInfoModalMessage("Valor superior ao Valor Total.", EnumButtonBehavior.SUBMIT);
                valido = Boolean.FALSE;
            }
        }
        return valido;
    }
    
    /**
     * 
    	* Nome: verificaPrazo
    	* 
    	* Propósito: A soma dos prazos de cada parcela irregular não deve ultrapassar o Prazo Operação (Dias) 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 04/10/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    private boolean verificaPrazo(){
        boolean valido = Boolean.TRUE;
        
        Integer prazoSomaP = itemListaParcelaIrreg.getTdianegocpcela();
        Integer prazoSomaJ = itemListaParcelaIrreg.getTdianegocpcela();
        Integer prazoTotal = itemListaFluxoPgto.getTdiaopercmbio();
        
        if(prazoSomaP.compareTo(prazoTotal) <= 0){
            for(TrdFinNegParcelaVO negParcelaVO : itemListaFluxoPgto.getListaParcelasFluxoPgto()){
                
                if(negParcelaVO.getTpparcela().equals("P") 
                        && negParcelaVO.getTpparcela().equals(itemListaParcelaIrreg.getTpparcela())) {
                    prazoSomaP += negParcelaVO.getTdianegocpcela();
                    if(prazoSomaP.compareTo(prazoTotal) > 0){
                        NpcFacesUtils.addInfoModalMessage("Soma dos prazos das parcelas Principal não deve ser superior ao Prazo Operação.", EnumButtonBehavior.SUBMIT);
                        valido = Boolean.FALSE;
                        break;
                    }
                    
                }else if(negParcelaVO.getTpparcela().equals("J")
                         && itemListaFluxoPgto.getCodJurosPeriodicidade().equals(EnumTradeFinance.PERIODICIDADE_IRREGULAR.getCodigo())
                         && negParcelaVO.getTpparcela().equals(itemListaParcelaIrreg.getTpparcela())){
                    
                    prazoSomaJ += negParcelaVO.getTdianegocpcela();
                    if(prazoSomaJ.compareTo(prazoTotal) > 0){
                        NpcFacesUtils.addInfoModalMessage("Soma dos prazos das parcelas Juros não deve ser superior ao Prazo Operação.", EnumButtonBehavior.SUBMIT);
                        valido = Boolean.FALSE;
                        break;
                    }
                }
            }
        }else{
            NpcFacesUtils.addInfoModalMessage("Prazo superior ao Prazo Operação.", EnumButtonBehavior.SUBMIT);
            valido = Boolean.FALSE;
        }
        return valido;
    }
    
    
    /**
    * Nome: getItensRadioListaParcelaComiss
    * 
    * Propósito: 
    *
    * @param : 
    * @return : 
    * @throws :
    * @exception : 
    * @see : Referencias externas.  
    *
    * Registro  de Manutenção: 29/06/2016
    *        - Autor: BRQ
    *        - Responsavel: Equipe Web
    *        - Adequação ao padrão hexavision.
    */
    public List<SelectItem> getItensRadioListaParcelaComiss() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] FluxoPgtoManutModalBean.getItensRadioListaParcelaComiss <<<<<<<<<<<");
    		
    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getItemListaFluxoPgto().getListaParcelasFluxoPgto().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] FluxoPgtoManutModalBean.getItensRadioListaParcelaComiss <<<<<<<<<<<");
    	}
    	
    }
    
    /**
     * @return o valor do viewHelper
     */
    public FluxoPgtoManutModalViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(FluxoPgtoManutModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do itemListaFluxoPgto
     */
    public TrdFinNegFluxoPagtoVO getItemListaFluxoPgto() {
        return itemListaFluxoPgto;
    }

    /**
     * @param itemListaFluxoPgto seta o novo valor para o campo itemListaFluxoPgto
     */
    public void setItemListaFluxoPgto(TrdFinNegFluxoPagtoVO itemListaFluxoPgto) {
        this.itemListaFluxoPgto = itemListaFluxoPgto;
    }
    
    public TrdFinNegFluxoPagtoVO getItemListaFluxoPgtoAux() {
		return itemListaFluxoPgtoAux;
	}

	public void setItemListaFluxoPgtoAux(TrdFinNegFluxoPagtoVO itemListaFluxoPgtoAux) {
		this.itemListaFluxoPgtoAux = itemListaFluxoPgtoAux;
	}

    /**
     * @return o valor do confirmarManutencao
     */
    public Boolean getConfirmarManutencao() {
        return confirmarManutencao;
    }

    /**
     * @param confirmarManutencao seta o novo valor para o campo confirmarManutencao
     */
    public void setConfirmarManutencao(Boolean confirmarManutencao) {
        this.confirmarManutencao = confirmarManutencao;
    }

    /**
     * @return o valor do itemListaParcelaIrreg
     */
    public TrdFinNegParcelaVO getItemListaParcelaIrreg() {
        return itemListaParcelaIrreg;
    }

    /**
     * @param itemListaParcelaIrreg seta o novo valor para o campo itemListaParcelaIrreg
     */
    public void setItemListaParcelaIrreg(TrdFinNegParcelaVO itemListaParcelaIrreg) {
        this.itemListaParcelaIrreg = itemListaParcelaIrreg;
    }
    
    /**
     * Nome: getEditarPercentualCdi
     * @return Retorna o valor do campo 'editarPercentualCdi'.
     * @see Referências externas.
     */
    public Boolean getEditarPercentualCdi() {
        return editarPercentualCdi;
    }

    /**
     * Nome: setEditarPercentualCdi
     * @param paramEditarPercentualCdi - O valor do campo 'editarPercentualCdi' a determinar.
     * @see Referências externas.
     */
    public void setEditarPercentualCdi(Boolean paramEditarPercentualCdi) {
        editarPercentualCdi = paramEditarPercentualCdi;
    }
    
	public Boolean isAlterarCotacao() {
		return isAlterarCotacao;
	}

	public void setIsAlterarCotacao(Boolean isAlterarCotacao) {
		this.isAlterarCotacao = isAlterarCotacao;
	}

	public Boolean getEditado() {
		return editado;
	}

	public void setEditado(Boolean editado) {
		this.editado = editado;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Integer getSomaPrazoParcela() {
		return somaPrazoParcela;
	}

	public void setSomaPrazoParcela(Integer somaPrazoParcela) {
		this.somaPrazoParcela = somaPrazoParcela;
	}

	public BigDecimal getSomaValor() {
		return somaValor;
	}

	public void setSomaValor(BigDecimal somaValor) {
		this.somaValor = somaValor;
	}
	
	public Boolean getRenderModal() {
		return renderModal;
	}
	
	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}
	
    public String getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(String valorAtual) {
		this.valorAtual = valorAtual;
	}

	public String getNovoValor() {
		return novoValor;
	}

	public void setNovoValor(String novoValor) {
		this.novoValor = novoValor;
	}

	public String getColunaEditada() {
		return colunaEditada;
	}

	public void setColunaEditada(String colunaEditada) {
		this.colunaEditada = colunaEditada;
	}

	public int getLinhaEditada() {
		return linhaEditada;
	}

	public void setLinhaEditada(int linhaEditada) {
		this.linhaEditada = linhaEditada;
	}
	
	private int getTipoAcessoIncluirEvento() {
    	return tipoAcessoIncluirEvento;
	}

	private void setTipoAcessoIncluirEvento(int tipoAcessoIncluirEvento) {
		this.tipoAcessoIncluirEvento = tipoAcessoIncluirEvento;
	}
	
	public void actionListenerCancelarModal(ActionEvent ae) {
		renderModal = Boolean.FALSE;
	}
	
	public void actionListenerConfirmarModal(ActionEvent ae) {
		renderModal = Boolean.FALSE;
	}
}
