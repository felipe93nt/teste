package br.com.bradesco.web.npcc_trade.view.bean.parametrizacao;
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
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.IComissaoDesembolsoService;
import br.com.bradesco.web.npcc_trade.service.business.parametrizacao.bean.ComissaoDesembolsoVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;

/**
 * Nome: ComissaoDesembolsoBean.java
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
@Named("comissaoDesembolsoBean")
@SessionScoped
public class ComissaoDesembolsoBean extends BaseBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 788720892802156144L;

    /* Objeto utilizado nas telas de Inclus�o / Altera��o/ Exclus�o */
    private ComissaoDesembolsoVO comissaoDesembolsoVO = new ComissaoDesembolsoVO();

	@Inject
	@Named("comissaodesembolsoService")
	private IComissaoDesembolsoService service;

	@Inject
	@Named("commonService")
	private ICommonService commonService;

	@Inject
	@Named("selectItemBean")
	private SelectItemBean selectItemBean;

	private final String FLUXO_PESQUISA = "NPCCIAU0";

	private final String REDIRECT_INICIO = "parametrizacaoComissDesemb";

	private final String FORMULARIO = "formComissaoDesembolcons";

	/** Variavel do tipo List<TarifaAutomaticaVO>. */
	private List<ComissaoDesembolsoVO> listaPesquisa = new ArrayList<ComissaoDesembolsoVO>();

	/** Variavel do tipo TarifaAutomaticaViewHelper. */
	private ComissaoDesembolsoViewHelper viewHelper = new ComissaoDesembolsoViewHelper();

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public ComissaoDesembolsoBean() {
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

			// Limpa as listas
			limparListas();

			List<SelectItem> produtos = selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                    EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                    EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo());
            
			produtos.add(new SelectItem(99999999, "Demais produtos"));
			getViewHelper().setComboProdutos(produtos);
			
			// combo moedas
			List<SelectItem> moeda = selectItemBean.getMoeda();
			getViewHelper().setComboMoeda(moeda);  
			
			getViewHelper().setFiltro(new ComissaoDesembolsoVO());
			 
		    getViewHelper().setDisabledBtnIncluir(true);
            getViewHelper().setDisabledBtnAlterar(true);
            getViewHelper().setDisabledBtnExcluir(true);
               
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
		setListaPesquisa(new ArrayList<ComissaoDesembolsoVO>());
        comissaoDesembolsoVO = new ComissaoDesembolsoVO();
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
        SiteUtil.atualizarSelectItem(listaPesquisa, selectItemRadioLista);
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
	public void pesquisar() {
		// Limpa as listas
		limparListas();
		
		// Valida o form
		if (!SiteUtil.validarCampos(FORMULARIO)) {
			
			// Executa chamada CWS - Fluxo: NPCCIAU0 - Books: NPCCWJ6E / NPCCWJ6S
			setListaPesquisa(service.pesquisar(this.getViewHelper().getFiltro(), 2));
		    this.getViewHelper().setCodItemSelecionadoLista(null);
			    
		    getViewHelper().setDisabledBtnIncluir(true);
	        getViewHelper().setDisabledBtnAlterar(true);
	        getViewHelper().setDisabledBtnExcluir(true);
	
		    // se lista vazia exibe mensagem de retorno do mainframe
		    if (getListaPesquisa().size() == 0) {
		        BradescoFacesUtils.addInfoModalMessage(service.getMsgRetorno(), false);
		        getViewHelper().setDisabledBtnIncluir(false);
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
		
		// Executa chamada CWS - Fluxo: NPCCIAU0 - Books: NPCCWJ6E / NPCCWJ6S
		setListaPesquisa(service.pesquisar(getViewHelper().getFiltro(), 2));

		this.getViewHelper().setCodItemSelecionadoLista(null);
	    
        getViewHelper().setDisabledBtnIncluir(false);
        getViewHelper().setDisabledBtnAlterar(false);
        getViewHelper().setDisabledBtnExcluir(false);
        
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

        setComissaoDesembolsoVO(new ComissaoDesembolsoVO());

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);

		comissaoDesembolsoVO.setFuncao("I");
		comissaoDesembolsoVO.setCindcdeconmmoeda(viewHelper.getFiltro().getCindcdeconmmoeda());
		comissaoDesembolsoVO.setCprodtservc(viewHelper.getFiltro().getCprodtservc());
		comissaoDesembolsoVO.setCprodtdesc(viewHelper.getFiltro().getCprodtdesc());
		comissaoDesembolsoVO.setVcomisfixa(viewHelper.getFiltro().getVcomisfixa());
		comissaoDesembolsoVO.setVlimcomisfixa(viewHelper.getFiltro().getVlimcomisfixa());
		return "parametrizacaoComissaoDesembIncl";
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

    	setComissaoDesembolsoVO(new ComissaoDesembolsoVO());

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);

		if (viewHelper.getCodItemSelecionadoLista() == null) {
			NpcFacesUtils.addInfoModalMessage("Selecione um Registro para alterar", false);
			return null;
		}
		
		// Carrega dados da tela de alterar
		carregaAlterar();
		
		comissaoDesembolsoVO.setFuncao("A");

		return "parametrizacaoComissaoDesembAlt";
    }
    /**
     * Nome: carregaAlterar
     * 
     * Prop�sito: Carrega dados da tela de alterar
     * 
     * @return : String de navega��o
     * 
     * @see : Referencias externas.
     * 
     */
    private void carregaAlterar() {

		// recupera item selecionado
		ComissaoDesembolsoVO itemSelecionado = listaPesquisa.get(viewHelper.getCodItemSelecionadoLista());

		// recupera detalhes do modelo de boleto
		setComissaoDesembolsoVO(itemSelecionado);

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

		// valida se foi selecionado um item na lista
		if (viewHelper.getCodItemSelecionadoLista() == null) {
			NpcFacesUtils.addInfoModalMessage("Selecione um Registro para excluir", false);
			return;
		}

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
        
        setComissaoDesembolsoVO(listaPesquisa.get(viewHelper.getCodItemSelecionadoLista()));
		comissaoDesembolsoVO.setFuncao("E");
        
        // Chama o servi�o para realizar a exclus�o
        result = service.manutencao(comissaoDesembolsoVO);
        
        setIniciarPagina(true);
        
        // Exibe a mensagem de exclusa� e retorna para Lista
        BradescoFacesUtils.addInfoModalMessage(result, "#{comissaoDesembolsoBean.iniciar}",
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
        if (!SiteUtil.validarCampos("formComissaoDesembolcons")) {
            
            // habilita o modal de confirma��o
            getViewHelper().setRenderModal(Boolean.TRUE);
        }

    }
    
    public void atualizarBotoes(AjaxBehaviorEvent e) {

		// recupera item selecionado
		ComissaoDesembolsoVO itemSelecionado = listaPesquisa.get(viewHelper.getCodItemSelecionadoLista());
    	
    	if(itemSelecionado.getCprodtservc().equals("")||itemSelecionado.getCindcdeconmmoeda().equals(null) ) {
	    	getViewHelper().setDisabledBtnIncluir(false);
	    	getViewHelper().setDisabledBtnAlterar(true);
	    	getViewHelper().setDisabledBtnExcluir(true);
    	}
	    else {
	    	getViewHelper().setDisabledBtnIncluir(true);
	    	getViewHelper().setDisabledBtnAlterar(false);
	    	getViewHelper().setDisabledBtnExcluir(false);
	    }
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

        result = service.manutencao(comissaoDesembolsoVO);
        
        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{comissaoDesembolsoBean.iniciar}",
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
    	
    		return "parametrizacaoComissDesemb";
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
	 * @return o valor do listaPesquisa
	 */
	public List<ComissaoDesembolsoVO> getListaPesquisa() {
		return listaPesquisa;
	}

	/**
	 * @param listaPesquisa
	 *            seta o novo valor para o campo listaPesquisa
	 */
	public void setListaPesquisa(List<ComissaoDesembolsoVO> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	/**
	 * @return o valor do viewHelper
	 */
	public ComissaoDesembolsoViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper
	 *            seta o novo valor para o campo viewHelper
	 */
	public void setViewHelper(ComissaoDesembolsoViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public ComissaoDesembolsoVO getComissaoDesembolsoVO() {
		return comissaoDesembolsoVO;
	}

	public void setComissaoDesembolsoVO(ComissaoDesembolsoVO comissaoDesembolsoVO) {
		this.comissaoDesembolsoVO = comissaoDesembolsoVO;
	}

}
