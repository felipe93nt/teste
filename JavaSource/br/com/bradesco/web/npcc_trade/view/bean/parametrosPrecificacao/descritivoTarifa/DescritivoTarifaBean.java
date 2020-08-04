package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.descritivoTarifa;
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
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.IDescritivoTarifaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.descritivoTarifa.bean.DescritivoTarifaVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;

/**
 * Nome: DescritivoTarifaBean.java
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
@Named("descritivoTarifaBean")
@SessionScoped
public class DescritivoTarifaBean extends BaseBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 788720892802156144L;

    /* Objeto utilizado nas telas de Inclus�o / Altera��o/ Exclus�o */
    private DescritivoTarifaVO descritivoTarifaVO = new DescritivoTarifaVO();

	@Inject
	@Named("descritivoTarifaService")
	private IDescritivoTarifaService service;

	@Inject
	@Named("commonService")
	private ICommonService commonService;

	@Inject
	@Named("selectItemBean")
	private SelectItemBean selectItemBean;

	private final String FLUXO_PESQUISA = "NPCCIAUT";

	private final String REDIRECT_INICIO = "descritivoTarifaList";

	private final String FORMULARIO = "formDescritivoTarifa";

	/** Variavel do tipo List<TarifaAutomaticaVO>. */
	private List<DescritivoTarifaVO> listaPesquisa = new ArrayList<DescritivoTarifaVO>();

	/** Variavel do tipo TarifaAutomaticaViewHelper. */
	private DescritivoTarifaViewHelper viewHelper = new DescritivoTarifaViewHelper();

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public DescritivoTarifaBean() {
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

			getViewHelper().setComboProdutos(selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                    EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                    EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));
            getViewHelper().setFiltro(new DescritivoTarifaVO());
            
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
		setListaPesquisa(new ArrayList<DescritivoTarifaVO>());
        descritivoTarifaVO = new DescritivoTarifaVO();
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

			// Executa chamada CWS - Fluxo: NPCCIAUT - Books: NPCCWATE / NPCCWATS
			setListaPesquisa(service.pesquisar(this.getViewHelper().getFiltro()));
		    this.getViewHelper().setCodItemSelecionadoLista(null);
		    
            getViewHelper().setDisabledBtnIncluir(true);
            getViewHelper().setDisabledBtnAlterar(true);
            getViewHelper().setDisabledBtnExcluir(true);

		    // se lista vazia exibe mensagem de retorno do mainframe
		    if (getListaPesquisa().isEmpty()) {
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
		
		// Executa chamada CWS - Fluxo: NPCCIAUT - Books: NPCCWATE / NPCCWATS
		setListaPesquisa(service.pesquisar(getViewHelper().getFiltro()));

		this.getViewHelper().setCodItemSelecionadoLista(null);
	    
        getViewHelper().setDisabledBtnIncluir(true);
        getViewHelper().setDisabledBtnAlterar(true);
        getViewHelper().setDisabledBtnExcluir(true);
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

        setDescritivoTarifaVO(new DescritivoTarifaVO());

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);

		if (viewHelper.getCodItemSelecionadoLista() == null) {
			NpcFacesUtils.addInfoModalMessage("Selecione um Registro para incluir descri��o", false);
			return null;
		}
		
		// Carrega dados da tela de alterar
		carregaAlterar();
		
		descritivoTarifaVO.setOperAlteracao(false);
		
        return "descritivoTarifaIncl";
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

        setDescritivoTarifaVO(new DescritivoTarifaVO());

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);

		if (viewHelper.getCodItemSelecionadoLista() == null) {
			NpcFacesUtils.addInfoModalMessage("Selecione um Registro para alterar", false);
			return null;
		}
		
		// Carrega dados da tela de alterar
		carregaAlterar();
		
		descritivoTarifaVO.setOperAlteracao(true);
		
        return "descritivoTarifaAlt";
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
		DescritivoTarifaVO itemSelecionado = listaPesquisa.get(viewHelper.getCodItemSelecionadoLista());

		// recupera detalhes do modelo de boleto
		setDescritivoTarifaVO(itemSelecionado);

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
        
        // Chama o servi�o para realizar a exclus�o
        result = service.excluir(listaPesquisa.get(viewHelper.getCodItemSelecionadoLista()));
        
        setIniciarPagina(true);
        
        // Exibe a mensagem de exclusa� e retorna para Lista
        BradescoFacesUtils.addInfoModalMessage(result, "#{descritivoTarifaBean.iniciar}",
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
        if (!SiteUtil.validarCampos("formDescritivoTarifa")) {
            
            // habilita o modal de confirma��o
            getViewHelper().setRenderModal(Boolean.TRUE);
        }

    }
    
    public void atualizarBotoes(AjaxBehaviorEvent e) {

		// recupera item selecionado
		DescritivoTarifaVO itemSelecionado = listaPesquisa.get(viewHelper.getCodItemSelecionadoLista());
    	
    	if(itemSelecionado.getDalter().equals("")) {
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

        // Se campo "Ccondceconc" preenchido ent�o alterar se n�o incluir
        if (descritivoTarifaVO.isOperAlteracao()) {
            result = service.alterar(descritivoTarifaVO);
        } else {
            result = service.incluir(descritivoTarifaVO);
        }
        
        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{descritivoTarifaBean.iniciar}",
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
    		return "descritivoTarifaList";
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
		getViewHelper().setRenderModalSalvar(false);
	}

	/**
	 * @return o valor do listaPesquisa
	 */
	public List<DescritivoTarifaVO> getListaPesquisa() {
		return listaPesquisa;
	}

	/**
	 * @param listaPesquisa
	 *            seta o novo valor para o campo listaPesquisa
	 */
	public void setListaPesquisa(List<DescritivoTarifaVO> listaPesquisa) {
		this.listaPesquisa = listaPesquisa;
	}

	/**
	 * @return o valor do viewHelper
	 */
	public DescritivoTarifaViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper
	 *            seta o novo valor para o campo viewHelper
	 */
	public void setViewHelper(DescritivoTarifaViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public DescritivoTarifaVO getDescritivoTarifaVO() {
		return descritivoTarifaVO;
	}

	public void setDescritivoTarifaVO(DescritivoTarifaVO descritivoTarifaVO) {
		this.descritivoTarifaVO = descritivoTarifaVO;
	}

}
