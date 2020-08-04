package br.com.bradesco.web.npcc_trade.view.bean.global.liborTravadaBean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TradeFinanceDesembolsoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegocInclVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoAltBean;
import br.com.bradesco.web.npcc_trade.view.bean.comercializacao.precificacao.negociacao.TradeFinanceNegociacaoInclBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.fluxoPgtoManutModal.FluxoPgtoManutModalBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named(value = "liborTravadaModalBean")
@SessionScoped
public class LiborTravadaModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = -1043959195126812090L;
	
	private LiborTravaModalViewHelper viewHelper = new LiborTravaModalViewHelper();
	
	private TrdFinNegocInclVO tradeFinNegocVO;
    private TradeFinanceDesembolsoVO desembolsoForfaitingVO;
    
    @Inject
    @Named("fluxoPgtoManutModalBean")
    protected FluxoPgtoManutModalBean fluxoPgtoManutModalBean;
    
    @Inject
    @Named("tradeFinanceNegociacaoInclBean")
    protected TradeFinanceNegociacaoInclBean tradeFinanceNegociacaoInclBean;
    
    @Inject
    @Named("tradeFinanceNegociacaoAltBean")
    protected TradeFinanceNegociacaoAltBean tradeFinanceNegociacaoAltBean;
	    
	 /**
     * Nome: listenerIncluirLiborTravada
     * 
     * Propósito: 
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void incluirLiborTravada() {
        getViewHelper().setChamador("Precificacao");
    	getViewHelper().setLiborTravada(getTradeFinNegocVO().getVtravaliborcmbio());
        getViewHelper().setRenderModalLiborTravada(Boolean.TRUE);

    }

    public void incluirLiborTravadaDesembolso() {
        getViewHelper().setChamador("Desembolso");
        getViewHelper().setLiborTravada(getDesembolsoForfaitingVO().getVtxliborcmbio());
        getViewHelper().setRenderModalLiborTravada(Boolean.TRUE);

    }

    /**
     * Nome: confirmaLiborTravada
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmaLiborTravada() {
    	Integer eventoForfaiting = Numeros.NUM0;
            
// IN2833078(Kanban BRQ) - ERRO AO INCLUIR LIBOR FIXA EM BOLETO DE FORFAITING        	
// OC4529622 - ERROS BOLETO FORFAIT        	
        try {
            if (getViewHelper().getChamador().equals("Precificacao")) {
                getTradeFinNegocVO().setVtravaliborcmbio(getViewHelper().getLiborTravada());
            }

            if (getViewHelper().getChamador().equals("Desembolso")) {
                getDesembolsoForfaitingVO().setVtxliborcmbio(getViewHelper().getLiborTravada());
            }
            
            if (getDesembolsoForfaitingVO() != null && getDesembolsoForfaitingVO().getEventoForfaiting() != null) {
                eventoForfaiting = getDesembolsoForfaitingVO().getEventoForfaiting();
                getDesembolsoForfaitingVO().setEventoForfaiting(eventoForfaiting + Numeros.NUM10);
                
            }
    		if (getTradeFinNegocVO().getListaFluxos().size() <= Numeros.ZERO && temFluxoPagamento()) {
                NpcFacesUtils.addInfoModalMessage("Fluxo de Pagamento não incluído.", false);
                return "";
            } else {
// IN2833078(Kanban BRQ) - ERRO AO INCLUIR LIBOR FIXA EM BOLETO DE FORFAITING        	
// OC4529622 - ERROS BOLETO FORFAIT        	
//            	if (fluxoPgtoManutModalBean.getItemListaFluxoPgto().getListaParcelasFluxoPgto() == null || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getListaParcelasFluxoPgto().isEmpty()) {
//            		fluxoPgtoManutModalBean.setItemListaFluxoPgto(getTradeFinNegocVO().getListaFluxos().get(0));
//    			}
            	if (temFluxoPagamento()) {
                	if (fluxoPgtoManutModalBean.getItemListaFluxoPgto().getListaParcelasFluxoPgto() == null || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getListaParcelasFluxoPgto().isEmpty()) {
                		fluxoPgtoManutModalBean.setItemListaFluxoPgto(getTradeFinNegocVO().getListaFluxos().get(0));
        			}
    			}
            	
            	if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Sim") || getTradeFinNegocVO().getCcomiscartanacio().equals("1")) && fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(viewHelper.getLiborTravada())) {
            		BigDecimal custoTotal = null;
            		if (tradeFinanceNegociacaoInclBean.getTrdFinNegPrecificacaoVO().getSpreadclean() != null) {
            			custoTotal = calcularLiborTravadaMaisOverLibor(viewHelper.getLiborTravada(), tradeFinanceNegociacaoInclBean.getTrdFinNegPrecificacaoVO().getSpreadclean());
    				} else if (tradeFinanceNegociacaoAltBean.getTrdFinNegPrecificacaoVO().getSpreadclean() != null) {
    					custoTotal = calcularLiborTravadaMaisOverLibor(viewHelper.getLiborTravada(), tradeFinanceNegociacaoAltBean.getTrdFinNegPrecificacaoVO().getSpreadclean());
    				}
            		if (fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(custoTotal.toString())) {
            			if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || 
            					(fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0)) {
            				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
            			} else {
            				fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
            			}
            		}
            	} else if (getTradeFinNegocVO().getListaComissaoInterna() != null && getTradeFinNegocVO().getListaComissaoInterna().size() > 0 ) {
            		if ((getTradeFinNegocVO().getCcomiscartanacio().equals("Não") || getTradeFinNegocVO().getCcomiscartanacio().equals("2")) && fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(viewHelper.getLiborTravada())) {
            			BigDecimal custoTotal = null;
                		if (tradeFinanceNegociacaoInclBean.getTrdFinNegPrecificacaoVO().getSpreadclean() != null) {
                			custoTotal = calcularLiborTravadaMaisOverLibor(viewHelper.getLiborTravada(), tradeFinanceNegociacaoInclBean.getTrdFinNegPrecificacaoVO().getSpreadclean(), tradeFinanceNegociacaoInclBean.getItemListaComissaoInterna().getVtxspreadtot());
    					} else if (tradeFinanceNegociacaoAltBean.getTrdFinNegPrecificacaoVO().getSpreadclean() != null) {
    						custoTotal = calcularLiborTravadaMaisOverLibor(viewHelper.getLiborTravada(), tradeFinanceNegociacaoAltBean.getTrdFinNegPrecificacaoVO().getSpreadclean(), tradeFinanceNegociacaoAltBean.getItemListaComissaoInterna().getVtxspreadtot());
    					}
                		
            			if (fluxoPgtoManutModalBean.taxaFixaMaiorQueZero(custoTotal.toString())) {
                			if ((fluxoPgtoManutModalBean.getItemListaFluxoPgto().getCodJurosPeriodicidade() == 14 || fluxoPgtoManutModalBean.getItemListaFluxoPgto().getNomeJurosPeriodicidade().equals("Inicial")) || (fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrjuros() % fluxoPgtoManutModalBean.getItemListaFluxoPgto().getQtdeocorrprinc() != 0)) {
                				fluxoPgtoManutModalBean.calcularJurosPeriodicidadeDiferente(custoTotal.toString().replace(".",","));
                			} else {
                				fluxoPgtoManutModalBean.calcularJuros(custoTotal.toString().replace(".",","));
                			}
                		}
            		}
            	}
    		}
			
		} catch (Exception e) {
            NpcFacesUtils.addInfoModalMessage("Erro Confirmar Libor Travada.", false);
            return "";
		}
        
        return "/content/global/liborTravadaModal/liborTravadaModalClose.xhtml";
    }
    
    private BigDecimal calcularLiborTravadaMaisOverLibor(String vtravaliborcmbio, String pOverlibor) {
    	if (pOverlibor == null || pOverlibor.equals("")) {
    		pOverlibor = "0,00";
		}
    	if (vtravaliborcmbio == null || vtravaliborcmbio.equals("")) {
    		vtravaliborcmbio = "0,00";
		}
    	pOverlibor = pOverlibor.replace(".",",");
    	vtravaliborcmbio = vtravaliborcmbio.replace(".",",");
    	
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(pOverlibor.replaceAll("\\.","").replace(",","."));
		
		return liborTravada.add(overlibor);
	}
    
    private BigDecimal calcularLiborTravadaMaisOverLibor(String vtravaliborcmbio, String ptxcustototal, String vtxspreadtot) {
    	ptxcustototal = ptxcustototal.replace(".",",");
		BigDecimal liborTravada = new BigDecimal(vtravaliborcmbio.replaceAll("\\.","").replace(",","."));
		BigDecimal overlibor = new BigDecimal(ptxcustototal.replaceAll("\\.","").replace(",","."));
		BigDecimal spredTotal = new BigDecimal(vtxspreadtot.replaceAll("\\.","").replace(",","."));
		
		overlibor = liborTravada.add(overlibor);
		
		return overlibor.add(spredTotal);
	}
    
    public Boolean temFluxoPagamento(){
    	
    	//produtos que nao tem fluxo de pagamento
    	if(getTradeFinNegocVO().getProduto().isBndesPos() 
                || getTradeFinNegocVO().getProduto().isBndesPre()
                || getTradeFinNegocVO().getProduto().isGarantia()
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.LC_IMPORTACAO)
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.PROEX)
                || getTradeFinNegocVO().getProduto().equals(EnumProduto.PRODUTO_FORFAITING)){
    		
    		return Boolean.FALSE;
    		
    	}else{
    		
    		return Boolean.TRUE;
    	}
    	
    }
    
    /**
     * Nome: closeModalLiborTravada
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalLiborTravada(ActionEvent event) {

        // desabilita modal
        getViewHelper().setRenderModalLiborTravada(Boolean.FALSE);
    }

	public LiborTravaModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(LiborTravaModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public TrdFinNegocInclVO getTradeFinNegocVO() {
		return tradeFinNegocVO;
	}

	public void setTradeFinNegocVO(TrdFinNegocInclVO tradeFinNegocVO) {
		this.tradeFinNegocVO = tradeFinNegocVO;
	}

    /**
     * @return o valor do desembolsoForfaitingVO
     */
    public TradeFinanceDesembolsoVO getDesembolsoForfaitingVO() {
        return desembolsoForfaitingVO;
    }

    /**
     * @param desembolsoForfaitingVO seta o novo valor para o campo desembolsoForfaitingVO
     */
    public void setDesembolsoForfaitingVO(TradeFinanceDesembolsoVO desembolsoForfaitingVO) {
        this.desembolsoForfaitingVO = desembolsoForfaitingVO;
    }

}
