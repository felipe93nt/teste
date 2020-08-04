package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.parametroUnidadeExterna;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.IParametroUnidadeExternaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.FaixaOperacaoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.parametroUnidadeExterna.bean.ParametroUnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.service.business.banqueiros.IBanqueirosService;
//import br.com.bradesco.web.npcc_trade.service.business.global.banqueiroModal.bean.BanqueiroModalVO;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.banqueiroModal.BanqueiroModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;

/**
 * Nome: faixaOperacaoBean.java
 * 
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : Bradesco S.A.<BR/>
 *         Equipe : CD <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 */
@Named("parametroUnidadeExternaBean")
@SessionScoped
public class ParametroUnidadeExternaBean extends BaseBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 788720892802156144L;

    /* Objeto utilizado nas telas de Inclus�o / Altera��o/ Exclus�o / Consulta */
    private ParametroUnidadeExternaVO parametroUnidadeExternaVO = new ParametroUnidadeExternaVO();
    
    /* Objeto utilizado nas telas de Inclus�o / Altera��o/ Exclus�o / Consulta */
    private FaixaOperacaoVO faixaOperacaoVO = new FaixaOperacaoVO();

	@Inject
	@Named("parametroUnidadeExternaService")
	private IParametroUnidadeExternaService service;

	@Inject
	@Named("commonService")
	private ICommonService commonService;

	@Inject
	@Named("selectItemBean")
	private SelectItemBean selectItemBean;

	@Inject
	@Named("banqueiroModalBean")
	private BanqueiroModalBean banqueiroModalBean;
    
	@Inject
	@Named("banqueirosService")
	private IBanqueirosService banqueirosService;

	private final String FLUXO_PESQUISA = "NPCCIAUW";

	private final String REDIRECT_INICIO = "parametroUnidadeExternaList";

	private final String FORMULARIO = "formParametroUnidadeExterna";

	/** Variavel do tipo TarifaAutomaticaViewHelper. */
	private ParametroUnidadeExternaViewHelper viewHelper = new ParametroUnidadeExternaViewHelper();

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public ParametroUnidadeExternaBean() {
		super();
	}

	/**
	 * 
	 * Nome: iniciar Prop�sito:
	 *
	 * @param : <BR/>
	 * @return :
	 *
	 * @throws :
	 * 
	 * @exception :
	 *
	 * @see : Referencias externas.
	 *
	 */
	public String iniciar() {

		// Recarrega p�gina se n�o for um postback ou se foi marcado para
		// recaregar
		if (!isPostback() || getIniciarPagina()) {
			setIniciarPagina(false);

            // limpa campos da tela de lista
            getViewHelper().setCodItemSelecionadoLista(null);
			getViewHelper().setNomeStateIdLista(FLUXO_PESQUISA);
            getViewHelper().setRenderModal(Boolean.FALSE);
            getViewHelper().setDisabledBtnIncluir(true);

			// Limpa as listas
			limparListas();

			// combo produtos
			List<SelectItem> produtos = selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                    EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                    EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo());
	        produtos.add(new SelectItem(99999999, "Demais produtos"));
			getViewHelper().setComboProdutos(produtos);

			// combo moedas
			List<SelectItem> moedas = selectItemBean.getMoeda();
			moedas.add(new SelectItem(Numeros.NUM99999, "Demais moedas"));
			getViewHelper().setComboMoedas(moedas);
			
            getViewHelper().setFiltro(new ParametroUnidadeExternaVO());
            
		}
		
		return REDIRECT_INICIO;
	}

	/**
	 * Nome: actionCloseModal
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	public void actionCloseModal(ActionEvent e) {
		getViewHelper().setRenderModalSalvar(false);
	}

	/**
	 * Nome: limparListas
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	public void limparListas() {
		getParametroUnidadeExternaVO().setListaFaixaOperacao(new ArrayList<FaixaOperacaoVO>());
        parametroUnidadeExternaVO = new ParametroUnidadeExternaVO();
	}

    /**
     * 
     * Nome: getSelectItemRadioLista
     * 
     * Prop�sito: Retorna a lista de select item para a lista
     *
     *
     * @see : Referencias externas.
     */
    public List<SelectItem> getSelectItemRadioLista() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
        SiteUtil.atualizarSelectItem(getParametroUnidadeExternaVO().getListaFaixaOperacao(), selectItemRadioLista);
        return selectItemRadioLista;
    }

	/**
	 * Nome: pesquisar
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 *
	 */
	public void pesquisar(AjaxBehaviorEvent e) {
		// Limpa as listas
		limparListas();
		
		// Valida o form
		if (!SiteUtil.validarCampos(FORMULARIO)) {

			// Executa chamada CWS - Fluxo: NPCCIAUW
			setParametroUnidadeExternaVO(service.pesquisar(this.getViewHelper().getFiltro()));
		    this.getViewHelper().setCodItemSelecionadoLista(null);

		    // se lista vazia exibe mensagem de retorno do mainframe
		    if (getParametroUnidadeExternaVO().getListaFaixaOperacao().size() == 0) {
	            getViewHelper().setDisabledBtnIncluir(false);
		        BradescoFacesUtils.addInfoModalMessage(service.getMsgRetorno(), false);
		    }
		}
	}

	/**
	 * 
	 * Nome: paginar
	 * 
	 * Prop�sito: Retornar os dados conforme pagina��o
	 * 
	 * @param ActionEvent
	 *
	 * @see : Referencias externas.
	 */
	public void paginar(ActionEvent event) {
		// Limpa as listas
		limparListas();
		
		// Executa chamada CWS - Fluxo: NPCCIAUW
		setParametroUnidadeExternaVO(service.pesquisar(getViewHelper().getFiltro()));

		this.getViewHelper().setCodItemSelecionadoLista(0);
	    
        getViewHelper().setDisabledBtnIncluir(true);
        getViewHelper().setDisabledBtnAlterar(false);
        getViewHelper().setDisabledBtnExcluir(false);
	}

    /**
     * Nome: listenerIncluirFaixa
     * 
     * Prop�sito: Metodo do bot�o "Incluir Faixa"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void listenerIncluirFaixa(AjaxBehaviorEvent e) {

		// Valida o form
		if (!SiteUtil.validarCampos(FORMULARIO)) {
    	
	    	FaixaOperacaoVO itemLista = new FaixaOperacaoVO();
	
	    	itemLista.setCindcdtpomanut(parametroUnidadeExternaVO.getCindcdtpomanut());
	    	itemLista.setValorDe(faixaOperacaoVO.getValorDe());
	    	itemLista.setValorAte(faixaOperacaoVO.getValorAte());
	    	itemLista.getBanco().setIbanqrcmbio(faixaOperacaoVO.getBanco().getIbanqrcmbio());
	    	itemLista.getBanco().setCbanqrcmbio(faixaOperacaoVO.getBanco().getCbanqrcmbio());
	    	itemLista.getBanco().setImunintlcmbio(faixaOperacaoVO.getBanco().getImunintlcmbio());
	    	itemLista.getBanco().setCidbanqrswift(faixaOperacaoVO.getBanco().getCidbanqrswift());
	    	
	    	// Adiciona os dados na lista.
	    	getParametroUnidadeExternaVO().getListaFaixaOperacao().add(itemLista);
	    	
	    	Collections.sort(getParametroUnidadeExternaVO().getListaFaixaOperacao());

		    limpaCamposForm();
		}

    }

    /**
     * Nome: listenerCarregarFaixaAlteracao
     * 
     * Prop�sito: Metodo do bot�o "Alterar Faixa"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void listenerCarregarFaixaAlteracao(AjaxBehaviorEvent e) {
    	
		// valida se foi selecionado um item na lista
		if (getViewHelper().getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return;
        }
		
    	FaixaOperacaoVO itemLista = this.getParametroUnidadeExternaVO().getListaFaixaOperacao().get(SiteUtil.getInt(getViewHelper().getCodItemSelecionadoLista()));
		
		faixaOperacaoVO.setValorDe(itemLista.getValorDe());
		faixaOperacaoVO.setValorAte(itemLista.getValorAte());
		faixaOperacaoVO.getBanco().setIbanqrcmbio(itemLista.getBanco().getIbanqrcmbio());
		faixaOperacaoVO.getBanco().setCbanqrcmbio(itemLista.getBanco().getCbanqrcmbio());
		faixaOperacaoVO.getBanco().setImunintlcmbio(itemLista.getBanco().getImunintlcmbio());
		faixaOperacaoVO.getBanco().setCidbanqrswift(itemLista.getBanco().getCidbanqrswift());
		
		getViewHelper().setModoAlteracaoFaixa(true);
    	
    }
    /**
     * Nome: listenerAlterarFaixa
     * 
     * Prop�sito: Metodo do bot�o "Alterar Faixa"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void listenerAlterarFaixa(AjaxBehaviorEvent e) {
    	
		// Valida o form
		if (!SiteUtil.validarCampos(FORMULARIO)) {
    	
	    	FaixaOperacaoVO itemLista = this.getParametroUnidadeExternaVO().getListaFaixaOperacao().get(SiteUtil.getInt(getViewHelper().getCodItemSelecionadoLista()));
			
			// Remove o item selecionado.
			if(!this.getParametroUnidadeExternaVO().getListaFaixaOperacao().remove(itemLista)) {
	            NpcFacesUtils.addInfoModalMessage("Faixa n�o encontrada.", false);
	            return;
	    	}

			itemLista = new FaixaOperacaoVO();
	
	    	itemLista.setCindcdtpomanut(parametroUnidadeExternaVO.getCindcdtpomanut());
	    	itemLista.setValorDe(faixaOperacaoVO.getValorDe());
	    	itemLista.setValorAte(faixaOperacaoVO.getValorAte());
	    	itemLista.getBanco().setIbanqrcmbio(faixaOperacaoVO.getBanco().getIbanqrcmbio());
	    	itemLista.getBanco().setCbanqrcmbio(faixaOperacaoVO.getBanco().getCbanqrcmbio());
	    	itemLista.getBanco().setImunintlcmbio(faixaOperacaoVO.getBanco().getImunintlcmbio());
	    	itemLista.getBanco().setCidbanqrswift(faixaOperacaoVO.getBanco().getCidbanqrswift());
	    	
	    	// Adiciona os dados na lista.
	    	getParametroUnidadeExternaVO().getListaFaixaOperacao().add(itemLista);
	    	
	    	Collections.sort(getParametroUnidadeExternaVO().getListaFaixaOperacao());

		    limpaCamposForm();
		    
			getViewHelper().setModoAlteracaoFaixa(false);
		}
    }
    
    /**
     * Nome: listenerRemoverFaixa
     * 
     * Prop�sito: Metodo do bot�o "Remover Faixa"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void listenerRemoverFaixa(AjaxBehaviorEvent e) {
    	
		// valida se foi selecionado um item na lista
		if (getViewHelper().getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return;
        }
		
    	FaixaOperacaoVO itemLista = this.getParametroUnidadeExternaVO().getListaFaixaOperacao().get(SiteUtil.getInt(getViewHelper().getCodItemSelecionadoLista()));
		
		// Remove o item selecionado.
		if(!this.getParametroUnidadeExternaVO().getListaFaixaOperacao().remove(itemLista)) {
            NpcFacesUtils.addInfoModalMessage("Faixa n�o encontrada.", false);
            return;
    	}
    	
		this.getViewHelper().setCodItemSelecionadoLista(0);
    }
    
    /**
     * Nome: listenerCancelarAlteracaoFaixa
     * 
     * Prop�sito: Metodo do bot�o "Cancelar alera��o Faixa"
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void  listenerCancelarAlteracaoFaixa(AjaxBehaviorEvent e) {
    	
	    limpaCamposForm();
		getViewHelper().setModoAlteracaoFaixa(false);
    }
    
    /**
     * Nome: listenerPesquisarUnidadeExterna
     * 
     * Prop�sito: Metodo para abrir o modal de pesquisa de Unidade Externa / Banco Correspondente
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void listenerPesquisarBanqueiro(AjaxBehaviorEvent e) {
    	
		banqueiroModalBean.setBanqueiroModalVO(faixaOperacaoVO.getBanco());
		banqueiroModalBean.getViewHelper().setModalId(
				"formParametroUnidadeExterna\\:modalBanqueiro");
		banqueiroModalBean.openModal();
    		
    }

    /**
     * Nome: listenerTrocaMoeda
     * 
     * Prop�sito: Metodo para troca de moeda
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void listenerTrocaMoeda(AjaxBehaviorEvent e) {
    	
        // limpa campos da tela de lista
        getViewHelper().setCodItemSelecionadoLista(null);
        getViewHelper().setRenderModal(Boolean.FALSE);
        getViewHelper().setDisabledBtnIncluir(true);

		// Limpa as listas
		limparListas();

    }

    /**
     * Nome: listenerTrocaProduto
     * 
     * Prop�sito: Metodo para troca de produto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void listenerTrocaProduto(AjaxBehaviorEvent e) {
    	
        // limpa campos da tela de lista
        getViewHelper().setCodItemSelecionadoLista(null);
        getViewHelper().setRenderModal(Boolean.FALSE);
        getViewHelper().setDisabledBtnIncluir(true);

		// Limpa as listas
		limparListas();

    }
    /**
     * Nome: limpaCamposForm
     * 
     * Prop�sito: Metodo de limpesa dos campos do form
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void limpaCamposForm() {
	    parametroUnidadeExternaVO.setCidbanqrswift(null);
	    parametroUnidadeExternaVO.setIbanqrcmbio(null);
	    parametroUnidadeExternaVO.setNtpositcmbio(0);
	    parametroUnidadeExternaVO.setTipoPesquisaBanqueiro(0);
	    setFaixaOperacaoVO(new FaixaOperacaoVO());
    }
    /**
     * Nome: getItensRadioListaFaixas
     * 
     * Prop�sito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public List<SelectItem> getItensRadioListaFaixas() {
    	
    		List<SelectItem> list = new ArrayList<SelectItem>();
    		
    		// Percorre todos os itens da lista afim de criar os respectivos radio
    		// buttons
    		for (int index = 0; index < getParametroUnidadeExternaVO().getListaFaixaOperacao().size(); index++) {
    			list.add(new SelectItem(index, "", ""));
    		}
    		
    		return list;
    	
    }
    
	
    /**
	 * 
	 * Nome: incluir
	 * 
	 * Prop�sito: Carrega os dados da tela de inclus�o
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
    public String incluir() {

		// Valida o form
		if (!SiteUtil.validarCampos(FORMULARIO)) {
    	
			this.getParametroUnidadeExternaVO().setCprodtservc(getViewHelper().getFiltro().getCprodtservc());
			this.getParametroUnidadeExternaVO().setCindcdeconmmoeda(getViewHelper().getFiltro().getCindcdeconmmoeda());
	
	        // desabilita o modal de confirma��o
	        getViewHelper().setRenderModal(Boolean.FALSE);
	
	        parametroUnidadeExternaVO.setFuncao("I");
			
			getViewHelper().setModoAlteracaoFaixa(false);
			
			limpaCamposForm();

			return "parametroUnidadeExternaIncl";
		}
		
		return null;
    }
	
    /**
     * 
     * Nome: alterar
     * 
     * Prop�sito: Carrega os dados da tela de altera��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public String alterar() {

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);
        getViewHelper().setCodItemSelecionadoLista(0);
        
        parametroUnidadeExternaVO.setFuncao("A");
		
		getViewHelper().setModoAlteracaoFaixa(false);
		
		limpaCamposForm();		
		
        return "parametroUnidadeExternaAlt";
    }

    /**
     * 
     * Nome: excluir
     * 
     * Prop�sito: Carrega modal de confirma��o de exclus�o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
    public void excluir() {

        parametroUnidadeExternaVO.setFuncao("E");
        
		// habilita o modal de confirma��o
		getViewHelper().setRenderModal(Boolean.TRUE);
    	
    }

    /**
     * 
     * Nome: actionConfirmarExcluir
     * 
     * Prop�sito: Executa o metodo de exclus�o modelo de boleto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */

    public void actionConfirmarExcluir() {
        
        String result = SiteUtil.STRING_EMPTY;
        
        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);
        
        // Chama o servi�o para realizar a exclus�o
        result = service.manutencao(this.getParametroUnidadeExternaVO());
        
        setIniciarPagina(true);
        
        // Exibe a mensagem de exclusa� e retorna para Lista
        BradescoFacesUtils.addInfoModalMessage(result, "#{parametroUnidadeExternaBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);

    }
	
    /**
     * 
     * Nome: validarForm
     * 
     * Prop�sito: Valida os dados da tela de inclus�o e altera��o e habilita o modal de confirma��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */

    public void validarForm(ActionEvent ae) {

        // valida campos obrigat�rios
        if (!SiteUtil.validarCampos(FORMULARIO)) {
            
            // habilita o modal de confirma��o
            getViewHelper().setRenderModal(Boolean.TRUE);
        }

    }
    
    /**
     * 
     * Nome: confirmarForm
     * 
     * Prop�sito: Valida os dados da tela de inclus�o e altera��o e habilita o modal de confirma��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */

    public void confirmarForm(ActionEvent ae) {

        // habilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.TRUE);

    }
    
    /**
     * 
     * Nome: actionConfirmar
     * 
     * Prop�sito: Executa o metodo de confirma��o da inclus�o ou altera��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */

    public void actionConfirmar() {

        String result = SiteUtil.STRING_EMPTY;

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);

        result = service.manutencao(this.getParametroUnidadeExternaVO());
        
        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{parametroUnidadeExternaBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }
    
    /**
     * 
     * Nome: actionVoltar
     * 
     * Prop�sito: A��o executada pelo bot�o voltar das telas de inclur, alterar e
     * detalhar
     *
     * @return : String de navega��o
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     */
    public String actionVoltar() {
    	this.setIniciarPagina(true);
    	return "parametroUnidadeExternaList";
    }

	/**
	 * Nome: actionFecharModal
	 * 
	 * Prop�sito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
	public void actionFecharModal(ActionEvent e) {
		getViewHelper().setRenderModal(false);
	}

	/**
	 * @return o valor do viewHelper
	 */
	public ParametroUnidadeExternaViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper
	 *            seta o novo valor para o campo viewHelper
	 */
	public void setViewHelper(ParametroUnidadeExternaViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public FaixaOperacaoVO getFaixaOperacaoVO() {
		return faixaOperacaoVO;
	}

	public void setFaixaOperacaoVO(FaixaOperacaoVO faixaOperacaoVO) {
		this.faixaOperacaoVO = faixaOperacaoVO;
	}

	public ParametroUnidadeExternaVO getParametroUnidadeExternaVO() {
		return parametroUnidadeExternaVO;
	}

	public void setParametroUnidadeExternaVO(ParametroUnidadeExternaVO parametroUnidadeExternaVO) {
		this.parametroUnidadeExternaVO = parametroUnidadeExternaVO;
	}
}
