/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean.global.limitesDisponiveis
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 02/03/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.limitesModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean.LimitesModalVO;
import br.com.bradesco.web.npcc_trade.service.business.global.limitesModal.ILimitesModalService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * Nome: LimitesModalBean.java
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
 *      Registro de Manutenção: 02/03/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */

@Named(value = "limitesModalBean")
@SessionScoped
public class LimitesModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1L;

	private LimitesModalVO limiteVO = new LimitesModalVO();
	private List<LimitesModalVO> listaLimites = new ArrayList<LimitesModalVO>();
	private List<LimitesModalVO> listaPropostas = new ArrayList<LimitesModalVO>();
	private LimitesModalViewHelper viewHelper = new LimitesModalViewHelper();

	@Inject
	@Named("limitesModalService")
	private ILimitesModalService limitesModalService;

	/**
	 * Nome: openModal
	 * 
	 * Propósito: Efetua a Listagem de Limite e Proposta
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void openModal() {		
		/** Lista de Propostas */
	    if (getViewHelper().getTratarSelecionarProposta().equals(true)) {
            try {
                setListaPropostas(limitesModalService.listarProposta(limiteVO));
            } catch (NpccTradeWebException e) {
                setListaPropostas(new ArrayList<LimitesModalVO>());
            }
        } else {
            setListaPropostas(new ArrayList<LimitesModalVO>());
        }

		/** Lista de Limites */
		try {
			setListaLimites(limitesModalService.listarLimite(limiteVO));
		} catch (NpccTradeWebException e) {
			setListaLimites(new ArrayList<LimitesModalVO>());
		}
		
		getViewHelper().setCodItemSelecionadoLimite(null);
		getViewHelper().setCodItemSelecionadoProposta(null);
		getViewHelper().setItemSelecionado(false);
		getViewHelper().setSelecaoObrigatoria(false);
		getViewHelper().setAcaoConfirmacao(false);
		
		getViewHelper().setRenderModal(true);
	}
	
	/**
	 * Nome: openModal
	 * 
	 * Propósito: Efetua a Listagem de Limite e Proposta
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void openModal(boolean selecaoObrigatoria) {
		openModal();
		
		getViewHelper().setSelecaoObrigatoria(selecaoObrigatoria);
	}

	/**
	 * Nome: selecionaListaLimites
	 * 
	 * Propósito: Limpa a Lista de Propostas
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void selecionaListaLimites(AjaxBehaviorEvent event) {
		getViewHelper().setCodItemSelecionadoProposta(null);
		getViewHelper().setItemSelecionado(true);
	}

	/**
	 * Nome: selecionaListaPropostas
	 * 
	 * Propósito: Limpa a Seleção da Lista de Propostas
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 11/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void selecionaListaPropostas(AjaxBehaviorEvent event) {
		getViewHelper().setCodItemSelecionadoLimite(null);
		getViewHelper().setItemSelecionado(true);
	}

	/**
	 * Nome: closeModal
	 * 
	 * Propósito: Fecha o Modal de Milite e Proposta
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
    public void closeModal(ActionEvent event) {
		setListaLimites(new ArrayList<LimitesModalVO>());
		setListaPropostas(new ArrayList<LimitesModalVO>());
		getViewHelper().setRenderModal(false);
		getViewHelper().setItemSelecionado(false);
		getViewHelper().setIsConfirmaModallimite(false);
		getViewHelper().setAcaoConfirmacao(false);
	}
	
	
	/**
	 * Nome: getSelectItemRadioLimite
	 * 
	 * Propósito: Carrega o RadioButton da Lista de Limites
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getSelectItemRadioLimite() {
		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
		SiteUtil.atualizarSelectItem(listaLimites, selectItemRadioLista);
		return selectItemRadioLista;
	}

	/**
	 * Nome: getSelectItemRadioProposta
	 * 
	 * Propósito: Carrega o RadioButton da Lista de Propostas
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public List<SelectItem> getSelectItemRadioProposta() {
		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
		SiteUtil.atualizarSelectItem(listaPropostas, selectItemRadioLista);
		return selectItemRadioLista;
	}

	/**
	 * Nome: selecionar
	 * 
	 * Propósito: Preenche os dados da Ocorrencia selecionada
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public String selecionar() {
	    
	    // se não tem limite e proposta apenas fecha modal
		viewHelper.setIsConfirmaModallimite(true);
		
	    if(getListaLimites().size() > Numeros.ZERO || getListaPropostas().size() > Numeros.ZERO) {	        
	    	LimitesModalVO obj = new LimitesModalVO();
	    	
	        // valida se foi selecionado um item na lista
	        if ((getViewHelper().getItemSelecionado() == null || !getViewHelper().getItemSelecionado())
	        		&& getViewHelper().isSelecaoObrigatoria()) {
	            NpcFacesUtils.addInfoModalMessage("Selecione um Limite de Crédito.", false);
	            return null;
	        }
	        
	        if (getViewHelper().getCodItemSelecionadoLimite() != null &&
	                getViewHelper().getCodItemSelecionadoLimite().length() > Numeros.ZERO) {
	            obj = getListaLimites().get(SiteUtil.getInt(
	                    getViewHelper().getCodItemSelecionadoLimite()));
	        }
	      
	        if (getViewHelper().getCodItemSelecionadoProposta() != null &&
	                getViewHelper().getCodItemSelecionadoProposta().length() > Numeros.ZERO) {
	            obj = getListaPropostas().get(SiteUtil.getInt(
	                    getViewHelper().getCodItemSelecionadoProposta()));
	        }
	        
		    // carrega os dados do item selecionado
		    getLimiteVO().setCindcdeconmmoeda(obj.getCindcdeconmmoeda());
		    getLimiteVO().setCprodtservcoper(obj.getCprodtservcoper());
		    getLimiteVO().setCprodtservc(obj.getCprodtservc());
		    getLimiteVO().setCpssoajurid(obj.getCpssoajurid());
		    getLimiteVO().setCpssoajuriddesc(obj.getCpssoajuriddesc());
		    getLimiteVO().setDescrprodtlimite(obj.getDescrprodtlimite());
		    getLimiteVO().setDvctolimgerc(obj.getDvctolimgerc());
		    getLimiteVO().setVenclimite(obj.getVenclimite());
		    getLimiteVO().setVdispnlimgerc(obj.getVdispnlimgerc());
		    getLimiteVO().setVutlzdlimgerc(obj.getVutlzdlimgerc());
		    getLimiteVO().setCcatlggarntprinc(obj.getCcatlggarntprinc());
		    getLimiteVO().setDescrgarntprinc(obj.getDescrgarntprinc());
		    getLimiteVO().setDescrmoeda(obj.getDescrmoeda());
		    getLimiteVO().setPspreadprodt(obj.getPspreadprodt());
		    getLimiteVO().setPvctolimgerc(obj.getPvctolimgerc());
		    getLimiteVO().setNseqcontrppl(obj.getNseqcontrppl());
		    getLimiteVO().setNcontrlim(obj.getNcontrlim());
		    
	    }
	    
		setListaLimites(new ArrayList<LimitesModalVO>());
		setListaPropostas(new ArrayList<LimitesModalVO>());
		
		getViewHelper().setAcaoConfirmacao(true);
		
		return "/content/global/limitesModal/closeModalLimites.xhtml";
	}

	/**
	 * Nome: paginarLimite
	 * 
	 * Propósito: Efetua a Paginação da Lista de Limites
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void paginarLimites(ActionEvent event) {
		setListaLimites(limitesModalService.listarLimite(limiteVO));
	}

	/**
	 * Nome: paginarProposta
	 * 
	 * Propósito: Efetua a Paginação da Lista de Propostas
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel:
	 *      Equipe Web - Adequação ao padrão hexavision.
	 */
	public void paginarPropostas(ActionEvent event) {
		setListaPropostas(limitesModalService.listarProposta(limiteVO));
	}

	/**
	 * @return o valor do limiteVO
	 */
	public LimitesModalVO getLimiteVO() {
		return limiteVO;
	}

	/**
	 * @param limiteVO
	 *            seta o novo valor para o campo limiteVO
	 */
	public void setLimiteVO(LimitesModalVO limiteVO) {
		this.limiteVO = limiteVO;
	}

	/**
	 * @return o valor do listaLimites
	 */
	public List<LimitesModalVO> getListaLimites() {
		return listaLimites;
	}

	/**
	 * @param listaLimites
	 *            seta o novo valor para o campo listaLimites
	 */
	public void setListaLimites(List<LimitesModalVO> listaLimites) {
		this.listaLimites = listaLimites;
	}

	/**
	 * @return o valor do listaPropostas
	 */
	public List<LimitesModalVO> getListaPropostas() {
		return listaPropostas;
	}

	/**
	 * @param listaPropostas
	 *            seta o novo valor para o campo listaPropostas
	 */
	public void setListaPropostas(List<LimitesModalVO> listaPropostas) {
		this.listaPropostas = listaPropostas;
	}

	/**
	 * @return o valor do viewHelper
	 */
	public LimitesModalViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper
	 *            seta o novo valor para o campo viewHelper
	 */
	public void setViewHelper(LimitesModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	/**
	 * @return o valor do limitesModalService
	 */
	public ILimitesModalService getLimitesModalService() {
		return limitesModalService;
	}

	/**
	 * @param limitesModalService
	 *            seta o novo valor para o campo limitesModalService
	 */
	public void setLimitesModalService(ILimitesModalService limitesModalService) {
		this.limitesModalService = limitesModalService;
	}
	
}
