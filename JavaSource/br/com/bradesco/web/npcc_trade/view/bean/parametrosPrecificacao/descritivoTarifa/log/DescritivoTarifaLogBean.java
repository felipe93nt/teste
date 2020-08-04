package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.descritivoTarifa.log;
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
 * Nome: DescritivoTarifaLogBean.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : Bradesco S.A.<BR/>
 *         Equipe : CD <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 */
@Named("descritivoTarifaLogBean")
@SessionScoped
public class DescritivoTarifaLogBean extends BaseBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 788720892802156144L;

    /* Objeto utilizado nas telas de Inclusão / Alteração/ Exclusão */
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

	private final String FLUXO_PESQUISA = "NPCCIAUU";

	private final String REDIRECT_INICIO = "descritivoTarifaLogList";

	private final String FORMULARIO = "formDescritivoTarifasLog";

	/** Variavel do tipo List<TarifaAutomaticaVO>. */
	private List<DescritivoTarifaVO> listaPesquisa = new ArrayList<DescritivoTarifaVO>();

	/** Variavel do tipo TarifaAutomaticaViewHelper. */
	private DescritivoTarifaLogViewHelper viewHelper = new DescritivoTarifaLogViewHelper();

	/**
	 * Construtor
	 * 
	 * @param
	 */
	public DescritivoTarifaLogBean() {
		super();
	}

	/**
	 * 
	 * Nome: iniciar Propósito:
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

		// Recarrega página se não for um postback ou se foi marcado para
		// recaregar
		if (!isPostback() || getIniciarPagina()) {
			setIniciarPagina(false);

            // limpa campos da tela de lista
            //getViewHelper().setCodItemSelecionadoLista(null);
			getViewHelper().setNomeStateIdLista(FLUXO_PESQUISA);
            getViewHelper().setRenderModal(Boolean.FALSE);

			// Limpa as listas
			limparListas();

	        getViewHelper().setFiltro(new DescritivoTarifaVO());
            
		}
		
		return REDIRECT_INICIO;
	}

	/**
	 * Nome: actionCloseModal
	 * 
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
	 */
//	public void actionCloseModal(ActionEvent e) {
//		getViewHelper().setRenderModalSalvar(false);
//	}

	/**
	 * Nome: limparListas
	 * 
	 * Propósito:
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
     * Propósito: Retorna a lista de select item para a lista
     *
     *
     * @see : Referencias externas.
//     */
//    public List<SelectItem> getSelectItemRadioLista() {
//        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
//        SiteUtil.atualizarSelectItem(listaPesquisa, selectItemRadioLista);
//        return selectItemRadioLista;
//    }

	/**
	 * Nome: pesquisar
	 * 
	 * Propósito:
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
		//Valida se o período é maior que trinta dias  
		if((SiteUtil.calculaDias(viewHelper.getFiltro().getDtinici(), viewHelper.getFiltro().getDtfinal()))>30)
		{ 
		        BradescoFacesUtils.addInfoModalMessage("Pesquisa com intervalo maior que 30 dias.", false);
		        return;
			}
		
		
		// Valida o form
		if (!SiteUtil.validarCampos(FORMULARIO)) {
			
	// Executa chamada CWS - Fluxo: NPCCIAUU - Books: NPCCWAXE / NPCCWAXS
			setListaPesquisa(service.pesquisarLog(this.getViewHelper().getFiltro()));
		    //this.getViewHelper().setCodItemSelecionadoLista(null);
			
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
	 * Propósito: Retornar os dados conforme paginação
	 * 
	 * @param ActionEvent
	 *
	 * @see : Referencias externas.
	 */
	public void paginar(ActionEvent event) {
		// Limpa as listas
		limparListas();
		
		// Executa chamada CWS - Fluxo: Fluxo: NPCCIAUU - Books: NPCCWAXE / NPCCWAXS
		setListaPesquisa(service.pesquisarLog(getViewHelper().getFiltro()));

		//this.getViewHelper().setCodItemSelecionadoLista(null);
	    
        
	}


    /**
     * 
     * Nome: actionConfirmar
     * 
     * Propósito: Executa o metodo de confirmação da inclusão ou alteração
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     */
//
//    public void actionConfirmar() {
//
//        String result = SiteUtil.STRING_EMPTY;
//
//        // desabilita o modal de confirmação
//        getViewHelper().setRenderModal(Boolean.FALSE);
//
//        // Se campo "Ccondceconc" preenchido então alterar se não incluir
//        if (descritivoTarifaVO.isOperAlteracao()) {
//            result = service.alterar(descritivoTarifaVO);
//        } else {
//            result = service.incluir(descritivoTarifaVO);
//        }
//        
//        setIniciarPagina(true);
//
//        BradescoFacesUtils.addInfoModalMessage(result, "#{DescritivoTarifaLogBean.iniciar}",
//                        BradescoViewExceptionActionType.ACTION, "submit", false);
//    }
//    
    /**
     * 
     * Nome: actionVoltar
     * 
     * Propósito: Ação executada pelo botão voltar das telas de inclur, alterar e
     * detalhar
     *
     * @return : String de navegação
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
	 * Propósito:
	 *
	 * @param :
	 * @return :
	 * @throws :
	 * @exception :
	 * @see : Referencias externas.
//	 */
//	public void actionFecharModal(ActionEvent e) {
//		getViewHelper().setRenderModalSalvar(false);
//	}

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
	public DescritivoTarifaLogViewHelper getViewHelper() {
		return viewHelper;
	}

	/**
	 * @param viewHelper
	 *            seta o novo valor para o campo viewHelper
	 */
	public void setViewHelper(DescritivoTarifaLogViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public DescritivoTarifaVO getDescritivoTarifaVO() {
		return descritivoTarifaVO;
	}

	public void setDescritivoTarifaVO(DescritivoTarifaVO descritivoTarifaVO) {
		this.descritivoTarifaVO = descritivoTarifaVO;
	}

}
