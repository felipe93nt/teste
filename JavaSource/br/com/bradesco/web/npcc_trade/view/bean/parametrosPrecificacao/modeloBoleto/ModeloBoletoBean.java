/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 30/11/2015
 *
 * @author thiagoito / BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.modeloBoleto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaAprLmtCreditoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasAvaListaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean.GarantiasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ComissaoInternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FluxoPagamentoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.FundingVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaRebateVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.ListaTaxaDescontoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.MercadoriaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.bean.TarifaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ListaDespesasVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.IModeloBoletoService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ClausulasBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoBndesPosVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoBndesPreVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoNceVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoVO;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.ModeloBoletoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.boletoModal.BoletoModalBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

/**
 *
 * Nome: ClausulasBean
 * 
 * Prop�sito: Bean para a funcinalidade <br/>
 *
 * Data: 30/11/2015 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
@Named("modeloBoletoBean")
@SessionScoped
public class ModeloBoletoBean extends BaseBean implements Serializable {
    
    private final String STR_DATA = "__/__/____";

    private final String STR_TEXTO = "____";
    
    /**
     * Atributes
     */
    private static final long serialVersionUID = 1L;

    /* Objeto utilizado nas telas de Inclus�o / Altera��o / Detalhe */
    private ModeloBoletoVO modeloBoletoVO = new ModeloBoletoVO();

    /* Vari�veis de apoio a tela */
    private ModeloBoletoViewHelper viewHelper = new ModeloBoletoViewHelper();

    /* Lista para montar a Grid */
    private List<ModeloBoletoVO> lista = new ArrayList<ModeloBoletoVO>();

    @Inject
    @Named("modeloBoletoService")
    private IModeloBoletoService modeloBoletoService;

    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;

    @Inject
    @Named("commonService")
    private ICommonService commonService;

    /**
     * Inje��o do conector GCC.
     */
    @Inject
    private BoletoModalBean boletoModalBean;

    /**
     * Construtor
     * 
     * @param
     */
    public ModeloBoletoBean() {
        super();
    }

    /**
     * 
     * Nome: iniciar
     * 
     * Prop�sito: Iniciar dados da tela
     * 
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String iniciar() {

        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.iniciar <<<<<<<<<<<");
            
            // Recarrega p�gina se n�o for um postback ou se foi marcado para recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);
            
                // limpa campos da tela de lista
                getViewHelper().setCodItemSelecionadoLista(null);
                getViewHelper().setNomeStateIdLista("NPCCIAOO");
                setLista(new ArrayList<ModeloBoletoVO>());
                getViewHelper().setRenderModal(Boolean.FALSE);
        
                // limpa lista dualList
                limparListas();
        
                // Carrega combo de produto
                getViewHelper().setComboProdutoItens(
                        selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                                EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(), EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));
                getViewHelper().setFiltroProduto(Numeros.ZERO);
    
            }
            
            return "modeloBoletoList";
        
        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.iniciar <<<<<<<<<<<");
        }
        
    }

    /**
     * 
     * Nome: pesquisar
     * 
     * Prop�sito: Efetua a pesquisa de Produtos
     *
     * @param : <BR/>
     *
     * @exception : BradescoFacesUtils Message Info
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 28/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void pesquisar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.pesquisar <<<<<<<<<<<");
    		
    		// valida campos obrigat�rios
    		if (!SiteUtil.validarCampos("formModeloBoleto")) {
    			
    		    // carrega dados da lista
    		    this.setLista(modeloBoletoService.listar(this.getViewHelper().getFiltroProduto()));
    		    this.getViewHelper().setCodItemSelecionadoLista(Numeros.ZERO);
    		    
    		    // se lista vazia exibe mensagem de retorno do mainframe
    		    if (getLista().isEmpty()) {
    		        BradescoFacesUtils.addInfoModalMessage(modeloBoletoService.getMsgRetorno(), false);
    		    }
    		}
    	} finally {
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.pesquisar <<<<<<<<<<<");
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
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void paginar(ActionEvent event) {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.paginar <<<<<<<<<<<");
    		
    		setLista(modeloBoletoService.listar(getViewHelper().getFiltroProduto()));

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.paginar <<<<<<<<<<<");
    	}

    }

    /**
     * 
     * Nome: incluir
     * 
     * Prop�sito: Carrega primeira tela de inclus�o com a lista de tipos de
     * clausula
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String incluir() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.incluir <<<<<<<<<<<");
    		
    		limparListas();
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		modeloBoletoVO = new ModeloBoletoVO();
    		getViewHelper().setListaEsquerda(commonService.getComboTipoClausulasVO());
    		getViewHelper().setListaDireita(new ArrayList<ComboTipoClausulaVO>());
    		
    		return "modeloBoletoIncl";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.incluir <<<<<<<<<<<");
    	}

    }

    /**
     * 
     * Nome: carregarComboTipoClausula
     * 
     * Prop�sito: Carrega combo de tipo clausula selecionados no dual list
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void carregarComboTipoClausula() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.carregarComboTipoClausula <<<<<<<<<<<");
    		
    		
    		List<SelectItem> selecionados = new ArrayList<SelectItem>();
    		
    		selecionados.add(new SelectItem(Numeros.ZERO, "Selecione..."));
    		
    		// percore a lista retornada do mainframe montando a lista de SelectItem
    		for (Iterator<ComboTipoClausulaVO> iterator = getViewHelper().getListaDireita().iterator(); iterator.hasNext();) {
    			ComboTipoClausulaVO comboVO = iterator.next();
    			selecionados.add(new SelectItem(comboVO.getCtpoclauscmbio(), comboVO.getItpoclauscmbio()));
    		}
    		
    		getViewHelper().setComboTipoClausula(selecionados);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.carregarComboTipoClausula <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: incluirClausulas
     * 
     * Prop�sito: Carrega segunda tela de inclus�o com a lista de clausula
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String incluirClausulas() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.incluirClausulas <<<<<<<<<<<");
    		
    		String result = null;
    		
    		// valida campos obrigat�rios
    		if (!SiteUtil.validarCampos("formModeloBoleto")) {
    			
    		    // carrega combo de tipo clausula selecionados no dual list
    		    carregarComboTipoClausula();
    		    
    		    /*
    		     * Verifica se a lista da direita est� vazia, assim n�o permite a
    		     * mudan�a de tela quando selecionado o bot�o confirmar
    		     */
    		    if (getViewHelper().getListaDireita().isEmpty()) {
    		        
    		        // Caso a lista da direita vazia, exibe o modal de mensagem
    		        NpcFacesUtils.addInfoModalMessage("O campo Tipo de Cla�sulas Inseridas � obrigat�rio.", false);
    		    } else {
    		        
    		        if (SiteUtil.isEmptyOrNull(modeloBoletoVO.getCmodcontrcmbio())) {
    		            getViewHelper().setFiltroClausula(Numeros.ZERO);
    		            getViewHelper().setListaDireitaClausula(new ArrayList<ComboClausulaVO>());
    		            getViewHelper().setListaEsquerdaClausula(new ArrayList<ComboClausulaVO>());

    		            result = "modeloBoletoInclClausula";
    		        } else {
    		            
    		            // verifica se foi removido algum tipo de clausula
    		            if (getViewHelper().getListaDireita().size() < getViewHelper().getInseridas().size()) {
    		                List<Integer> remove = new ArrayList<Integer>();
                            
                            for (Map.Entry<Integer, List<ComboClausulaVO>> entry : getViewHelper().getInseridas().entrySet()) {
                                boolean flag = true;
                                
                                for (ComboTipoClausulaVO tipoClausula : getViewHelper().getListaDireita()) {
                                    if (entry.getKey().equals(tipoClausula.getCtpoclauscmbio())) {
                                        flag = false;
                                        break;
                                    }
                                }
                                
                                if (flag) {
                                    remove.add(entry.getKey());
                                }
                            }
                            
                            for (Integer tipoClausulaId : remove) {
                                getViewHelper().getInseridas().remove(tipoClausulaId);
                            }
    		            }
    		            
    		            result = "modeloBoletoAltClausula";
    		        }
    		    }
    		}
    		
    		return result;
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.incluirClausulas <<<<<<<<<<<");
    	}

    }

    /**
     * 
     * Nome: carregaListaClausula
     * 
     * Prop�sito: Controle das lista de clausulas inseridas e � inserir
     *
     * @param : <BR/>
     *
     * @exception : BradescoFacesUtils Message Info
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 28/07/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void carregaListaClausula(AjaxBehaviorEvent e) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.carregaListaClausula <<<<<<<<<<<");
    		
    		// Salva o estado atual das lista de cl�usulas inseridas e � inseir
    		salvarListasClausulas();
    		
    		// Carrega as lista de cl�usulas inseridas e � inseir
    		carregarListasClausulas();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.carregaListaClausula <<<<<<<<<<<");
    	}

    }

    /**
     * 
     * Nome: salvarListasClausulas
     * 
     * Prop�sito: Salva o estado atual das lista de cl�usulas inseridas e �
     * inseir
     *
     * @return :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void salvarListasClausulas() {
        // verifica se a itens inseridos
        if (!getViewHelper().getListaDireitaClausula().isEmpty()) {

            Integer tipoClausula = getViewHelper().getListaDireitaClausula().get(Numeros.ZERO).getCtpoclauscmbio();

            // verifica se j� foi inserido clausulas do tipo selecionado
            if (getViewHelper().getInseridas().containsKey(tipoClausula)) {
                // limpa lista
                getViewHelper().getInseridas().put(tipoClausula, new ArrayList<ComboClausulaVO>());
                // adiciona todos os itens selecionados
                getViewHelper().getInseridas().get(tipoClausula).addAll(getViewHelper().getListaDireitaClausula());
            } else {
                getViewHelper().getInseridas().put(tipoClausula, getViewHelper().getListaDireitaClausula());
            }

            // guarda status da lista de disponiveis
            getViewHelper().getDisponiveis().put(tipoClausula, new ArrayList<ComboClausulaVO>());
            getViewHelper().getDisponiveis().get(tipoClausula).addAll(getViewHelper().getListaEsquerdaClausula());

        } 
        // trata se a lista de inseridas foi limpa
        else if (!getViewHelper().getListaEsquerdaClausula().isEmpty()) {

            Integer tipoClausula = getViewHelper().getListaEsquerdaClausula().get(Numeros.ZERO).getCtpoclauscmbio();

            // limpa lista de inseridas
            getViewHelper().getInseridas().remove(tipoClausula);

            // guarda status da lista de disponiveis
            getViewHelper().getDisponiveis().put(tipoClausula, new ArrayList<ComboClausulaVO>());
            getViewHelper().getDisponiveis().get(tipoClausula).addAll(getViewHelper().getListaEsquerdaClausula());

        }
    }

    /**
     * 
     * Nome: carregarListasClausulas
     * 
     * Prop�sito: Carrega as lista de cl�usulas inseridas e � inseir
     *
     * @return :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void carregarListasClausulas() {

        // Limpa listas de controle do dualList
        viewHelper.setListaEsquerdaClausula(new ArrayList<ComboClausulaVO>());
        viewHelper.setListaDireitaClausula(new ArrayList<ComboClausulaVO>());

        // se tipo clausula selecionado
        if (!SiteUtil.isEmptyOrNull(getViewHelper().getFiltroClausula())) {

            // Carrega lista de clausulas disponiveis
            if (!getViewHelper().getDisponiveis().containsKey(getViewHelper().getFiltroClausula())) {
                getViewHelper().setListaEsquerdaClausula(
                        commonService.getComboClausulaVO(getViewHelper().getFiltroClausula()));
                getViewHelper().getDisponiveis().put(getViewHelper().getFiltroClausula(),
                        getViewHelper().getListaEsquerdaClausula());
            } else {
                getViewHelper().setListaEsquerdaClausula(
                        getViewHelper().getDisponiveis().get(getViewHelper().getFiltroClausula()));
            }

            // verifica se j� existem clausulas selecionadas para o filtro atual
            if (getViewHelper().getInseridas().containsKey(getViewHelper().getFiltroClausula())) {

                // coloca itens j� inseridos na lista da direita
                getViewHelper().setListaDireitaClausula(
                        getViewHelper().getInseridas().get(getViewHelper().getFiltroClausula()));

            }
        }
    }

    /**
     * 
     * Nome: alterar
     * 
     * Prop�sito: Carrega dados da tela de altera��o
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String alterar() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.alterar <<<<<<<<<<<");
    		
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    		if (viewHelper.getCodItemSelecionadoLista() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro para alterar", false);
    			return null;
    		}
    		
    		// Carrega dados da tela de alterar
    		carregaAlterarDuplicar();
    		
    		return "modeloBoletoAlt";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.alterar <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: duplicar
     * 
     * Prop�sito: Copia os dados da tela e preenche na tela de inclusao
     * 
     * @return : String de navega��o
     * 
     * @see : Referencias externas.
     * 
     * Registro de Manuten��o: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web
     * - Adequa��o ao padr�o hexavision.
     */
    public String duplicar() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.duplicar <<<<<<<<<<<");
    		
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    		if (viewHelper.getCodItemSelecionadoLista() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro para duplicar", false);
    			return null;
    		}
    		
    		// Carrega dados da tela de duplicar
    		carregaAlterarDuplicar();
    		
    		// Zero c�digo do boleto para inserir um novo
    		modeloBoletoVO.setCmodcontrcmbio(Numeros.ZERO);
    		
    		return "modeloBoletoIncl";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.duplicar <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: carregaAlterarDuplicar
     * 
     * Prop�sito: Carrega dados da tela de alterar e duplicar
     * 
     * @return : String de navega��o
     * 
     * @see : Referencias externas.
     * 
     * Registro de Manuten��o: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web
     * - Adequa��o ao padr�o hexavision.
     */
    private void carregaAlterarDuplicar() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.carregaAlterarDuplicar <<<<<<<<<<<");
    		
    		// limpar vari�veis
    		limparListas();
    		
    		// recupera item selecionado
    		ModeloBoletoVO itemSelecionado = lista.get(viewHelper.getCodItemSelecionadoLista());
    		
    		// recupera detalhes do modelo de boleto
    		setModeloBoletoVO(modeloBoletoService.detalhar(itemSelecionado.getCmodcontrcmbio()));
    		
    		// carrega lista de tipos de clausulas � inserir
    		getViewHelper().setListaEsquerda(commonService.getComboTipoClausulasVO());
    		
    		// percorre a lista de clausulas cadastradas para o modelo de boleto
    		for (Iterator<ComboClausulaVO> iterator = getModeloBoletoVO().getLista().iterator(); iterator.hasNext();) {
    			ComboClausulaVO clausula = (ComboClausulaVO) iterator.next();
    			List<ComboClausulaVO> listaClausula = null;
    			
    			// carrega o MAP de clausulas disponiveis
    			if (getViewHelper().getDisponiveis().containsKey(clausula.getCtpoclauscmbio())) {
    				listaClausula = getViewHelper().getDisponiveis().get(clausula.getCtpoclauscmbio());
    			} else {
    				// Carrega lista de clausulas disponiveis
    				listaClausula = commonService.getComboClausulaVO(clausula.getCtpoclauscmbio());
    				getViewHelper().getDisponiveis().put(clausula.getCtpoclauscmbio(), listaClausula);
    			}
    			
    			// remove da lista de disponiveis a clausula j� inserida
    			for (int i = 0; i < listaClausula.size(); i++) {
    				ComboClausulaVO item = listaClausula.get(i);
    				if (item.getCclauscontrcmbio().equals(clausula.getCclauscontrcmbio())) {
    					listaClausula.remove(i);
    					break;
    				}
    			}
    			
    			// insere a clausula no MAP de inseridas
    			if (getViewHelper().getInseridas().containsKey(clausula.getCtpoclauscmbio())) {
    				getViewHelper().getInseridas().get(clausula.getCtpoclauscmbio()).add(clausula);
    			} else {
    				List<ComboClausulaVO> list = new ArrayList<ComboClausulaVO>();
    				list.add(clausula);
    				getViewHelper().getInseridas().put(clausula.getCtpoclauscmbio(), list);
    			}
    			
    			// remove o tipo clausula j� inserida
    			for (int indexTipoClausula = 0; indexTipoClausula < getViewHelper().getListaEsquerda().size(); indexTipoClausula++) {
    				
    				ComboTipoClausulaVO tipoClausula = getViewHelper().getListaEsquerda().get(indexTipoClausula);
    				
    				if (tipoClausula.getCtpoclauscmbio().equals(clausula.getCtpoclauscmbio())) {
    					// remove inseridas das diponiveis
    					getViewHelper().getListaEsquerda().remove(indexTipoClausula);
    					
    					// adiciona nas inseridas
    					getViewHelper().getListaDireita().add(tipoClausula);
    					
    					break;
    				}
    			}
    		}

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.carregaAlterarDuplicar <<<<<<<<<<<");
    	}
    	
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
     *
     *      Registro de Manuten��o: 01/12/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void excluir() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.excluir <<<<<<<<<<<");
    		
    		// valida se foi selecionado um item na lista
    		if (viewHelper.getCodItemSelecionadoLista() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um Registro para excluir", false);
    			return;
    			
    		}
    		
    		// habilita o modal de confirma��o
    		getViewHelper().setRenderModal(Boolean.TRUE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.excluir <<<<<<<<<<<");
    	}
    	
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
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public void actionConfirmarExcluir() {
        
        try{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.actionConfirmarExcluir <<<<<<<<<<<");
            
            String result = SiteUtil.STRING_EMPTY;
            
            // desabilita o modal de confirma��o
            getViewHelper().setRenderModal(Boolean.FALSE);
            
            // Chama o servi�o para realizar a exclus�o
            result = modeloBoletoService.excluir(lista.get(viewHelper.getCodItemSelecionadoLista()));
            
            setIniciarPagina(true);
            
            // Exibe a mensagem de exclusa� e retorna para Lista
            BradescoFacesUtils.addInfoModalMessage(result, "#{modeloBoletoBean.iniciar}",
                            BradescoViewExceptionActionType.ACTION, "submit", false);

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.actionConfirmarExcluir <<<<<<<<<<<");
        }
        
    }

    /**
     * 
     * Nome: validarForm
     * 
     * Prop�sito: A��o que executa a valida��o do formul�rio e abre o modal de
     * confirma��o das telas de inclus�o e altera��o
     * 
     * @return : Navega��o por mensagem
     * 
     * @throws : NpccServiceBusinessException
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void validarForm(ActionEvent ae) {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.validarForm <<<<<<<<<<<");
    		
    		// Salva o estado atual das lista de cl�usulas inseridas e � inseir
    		salvarListasClausulas();
    		
    		// valida campos obrigat�rios
    		if (getViewHelper().getInseridas().isEmpty()) {
    			// exibe o modal com as mensagems lan�adas pelas valida��es.
    			NpcFacesUtils.addInfoModalMessage("O campo Cl�usulas Inseridas � obrigat�rio.", false);
    		} else if(SiteUtil.isEmptyOrNull(getModeloBoletoVO().getCprodtservc())) {
    			NpcFacesUtils.addInfoModalMessage("O campo Produto � obrigat�rio.", false);
    		} else {
    			getViewHelper().setRenderModal(Boolean.TRUE);
    		}
    		
    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.validarForm <<<<<<<<<<<");
    	}

    }

    /**
     * 
     * Nome: actionFecharModal
     * 
     * Prop�sito: A��o do bot�o fechar do modal das telas de inclus�o e
     * altera��o
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void actionFecharModal(ActionEvent ae) {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.actionFecharModal <<<<<<<<<<<");
    		
    		getViewHelper().setRenderModal(Boolean.FALSE);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.actionFecharModal <<<<<<<<<<<");
    	}
    	
    }

    /**
     * 
     * Nome: actionConfirmar
     * 
     * Prop�sito: A��o exucuta pelo bot�o confirmar das telas de inclus�o e
     * altera��o
     *
     * @return : Navega��o por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void actionConfirmar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.actionConfirmar <<<<<<<<<<<");
    		
    		String result = SiteUtil.STRING_EMPTY;
    		getViewHelper().setRenderModal(Boolean.FALSE);
    		
    		// carrega clausulas inseridas
    		modeloBoletoVO.setLista(new ArrayList<ComboClausulaVO>());
    		for (List<ComboClausulaVO> list : getViewHelper().getInseridas().values()) {
    			modeloBoletoVO.getLista().addAll(list);
    		}
    		
    		// incluir
    		if (SiteUtil.isEmptyOrNull(modeloBoletoVO.getCmodcontrcmbio())) {
    			result = modeloBoletoService.incluir(modeloBoletoVO);
    		}
    		// alterar
    		else {
    			result = modeloBoletoService.alterar(modeloBoletoVO);
    		}
    		
    		setIniciarPagina(true);
    		
    		BradescoFacesUtils.addInfoModalMessage(result, "#{modeloBoletoBean.iniciar}",
    						BradescoViewExceptionActionType.ACTION, "submit", false);

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.actionConfirmar <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: visualizar
     * 
     * Prop�sito: Visualizar modelo boleto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String visualizar() {
        
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.visualizar <<<<<<<<<<<");
    		
    		if (viewHelper.getCodItemSelecionadoLista() == null) {
    			NpcFacesUtils.addInfoModalMessage("Selecione um registro.", false);
    			return null;
    		}
    		
    		carregaAlterarDuplicar();
    		
    		return montarBoleto();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.visualizar <<<<<<<<<<<");
    	}

    }
    
    /**
     * Nome: preVisualizar
     * 
     * Prop�sito: Visualizar modelo boleto na telas de alterar e incluir
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String preVisualizar() {
        
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.preVisualizar <<<<<<<<<<<");
    		
    		return montarBoleto();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.preVisualizar <<<<<<<<<<<");
    	}
    	
    }

    /**
     * Nome: montarBoleto
     * 
     * Prop�sito: Carrega os dados do boleto e retorna a view
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 22/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private String montarBoleto() {
        
        DadosBoletoVO dadosBoleto = carregarDadosBoleto(EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())));
        
        for (ComboTipoClausulaVO tipoClausula : getViewHelper().getListaDireita()) {
            ClausulasBoletoVO clausulasBoleto = new ClausulasBoletoVO();
            
            tipoClausula.setItpoclauscmbio(dadosBoleto.getNextNumeroClausula() + tipoClausula.getItpoclauscmbio());
            
            clausulasBoleto.setTipoClausula(tipoClausula);
            clausulasBoleto.setClausulas((List<ComboClausulaVO>) getViewHelper().getInseridas().get(tipoClausula.getCtpoclauscmbio()));
            dadosBoleto.getClausulas().add(clausulasBoleto);
        }
        
        if (EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())).isGarantia()) {
        	dadosBoleto.setSubTitulo(SiteUtil.buscarDescricao(this.getViewHelper().getComboProdutoItens(), this.getModeloBoletoVO().getCprodtservc()));
        	dadosBoleto.setRenderDadosBanqueiro(true);
        }

        if (EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())).isBndesPos()) {
        	dadosBoleto.setSubTitulo(SiteUtil.buscarDescricao(this.getViewHelper().getComboProdutoItens(), this.getModeloBoletoVO().getCprodtservc()));
        }
        
        if (EnumProduto.LC_IMPORTACAO.getCodigo().equals(this.getModeloBoletoVO().getCprodtservc())) {
        	dadosBoleto.setRenderDadosBanqueiro(true);
        }
        
        // carrega template, t�tulo e subtitulo do boleto a partir do produto
        dadosBoleto.setTemplateAndCabecalho(EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())));
        
        // BNDES POS - Converte o tipo do objetos para tratar a lista de clausulas
        BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("dadosBoleto", dadosBoleto);
        
        return dadosBoleto.getTemplate();
    }
    
    /**
     * Nome: visualizarModeloBoleto
     * 
     * Prop�sito: Habilita modal de visualizar boleto
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 08/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void visualizarModeloBoleto(AjaxBehaviorEvent ajaxBehaviorEvent) {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.visualizarModeloBoleto <<<<<<<<<<<");
    		
    		// set modal id
    		boletoModalBean.getViewHelper().setModalId("formModeloBoleto\\:modalBoleto");
    		
    		
    		DadosBoletoVO dadosBoleto = carregarDadosBoleto(EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())));
    		
    		for (ComboTipoClausulaVO tipoClausula : getViewHelper().getListaDireita()) {
    			ClausulasBoletoVO clausulasBoleto = new ClausulasBoletoVO();
    			
    			tipoClausula.setItpoclauscmbio(dadosBoleto.getNextNumeroClausula() + tipoClausula.getItpoclauscmbio());
    			
    			clausulasBoleto.setTipoClausula(tipoClausula);
    			clausulasBoleto.setClausulas((List<ComboClausulaVO>) getViewHelper().getInseridas().get(tipoClausula.getCtpoclauscmbio()));
    			dadosBoleto.getClausulas().add(clausulasBoleto);
    		}
    		
            if (EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())).isGarantia()) {
            	dadosBoleto.setSubTitulo(SiteUtil.buscarDescricao(this.getViewHelper().getComboProdutoItens(), this.getModeloBoletoVO().getCprodtservc()));
            	dadosBoleto.setRenderDadosBanqueiro(true);
            }
    		
            if (EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())).isBndesPos()) {
            	dadosBoleto.setSubTitulo(SiteUtil.buscarDescricao(this.getViewHelper().getComboProdutoItens(), this.getModeloBoletoVO().getCprodtservc()));
            }
            
    		// carrega template, t�tulo e subtitulo do boleto a partir do produto
    		dadosBoleto.setTemplateAndCabecalho(EnumProduto.fromCode(SiteUtil.getInt(this.getModeloBoletoVO().getCprodtservc())));
    		
    		boletoModalBean.setDadosBoleto(dadosBoleto);
    		
    		// abre modal para anexar arquivo
    		boletoModalBean.openModal();

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.visualizarModeloBoleto <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: actionVoltar
     * 
     * Prop�sito: A��o exucuta pelo bot�o voltar das telas de inclur, alterar e
     * detalhar
     *
     * @return : String de navega��o
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionVoltar() {
    	
    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.actionVoltar <<<<<<<<<<<");
    		
    		return "modeloBoletoList";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.actionVoltar <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: actionVoltarInclClausula
     * 
     * Prop�sito: A��o exucuta pelo bot�o voltar das telas de inclur, alterar e
     * detalhar
     *
     * @return : String de navega��o
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionVoltarInclClausula() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.actionVoltarInclClausula <<<<<<<<<<<");
    		
    		// Salva o estado atual das lista de cl�usulas inseridas e � inseir
    		salvarListasClausulas();
    		
    		return "modeloBoletoIncl";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.actionVoltarInclClausula <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: actionVoltarAltClausula
     * 
     * Prop�sito: A��o exucuta pelo bot�o voltar das telas de inclur, alterar e
     * detalhar
     *
     * @return : String de navega��o
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionVoltarAltClausula() {

    	try{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ModeloBoletoBean.actionVoltarAltClausula <<<<<<<<<<<");
    		
    		// Salva o estado atual das lista de cl�usulas inseridas e � inseir
    		salvarListasClausulas();
    		
    		return "modeloBoletoAlt";

    	}finally{
    		BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ModeloBoletoBean.actionVoltarAltClausula <<<<<<<<<<<");
    	}
    }

    /**
     * 
     * Nome: limparListas
     * 
     * Prop�sito: Limpa vari�veis de controle do dualList
     *
     * @return : String de navega��o
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void limparListas() {
        modeloBoletoVO = new ModeloBoletoVO();
        getViewHelper().setListaEsquerda(new ArrayList<ComboTipoClausulaVO>());
        getViewHelper().setListaDireita(new ArrayList<ComboTipoClausulaVO>());
        getViewHelper().setFiltroClausula(Numeros.ZERO);
        getViewHelper().setListaDireitaClausula(new ArrayList<ComboClausulaVO>());
        getViewHelper().setListaEsquerdaClausula(new ArrayList<ComboClausulaVO>());
        getViewHelper().setInseridas(new HashMap<Integer, List<ComboClausulaVO>>());
        getViewHelper().setDisponiveis(new HashMap<Integer, List<ComboClausulaVO>>());
    }
    
    /**
     * 
     * Nome: getSelectItemRadioLista
     * 
     * Prop�sito: Retorna a lista de select item para a lista
     *
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public List<SelectItem> getSelectItemRadioLista() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
        SiteUtil.atualizarSelectItem(lista, selectItemRadioLista);
        return selectItemRadioLista;
    }
    
    private DadosBoletoVO carregarDadosBoleto(EnumProduto produto) {
        
        DadosBoletoVO dadosBoleto;
        
        // BNDES POS - Instancia para modelo de boleto BDES POS
        if(produto.isBndesPos()) {
            dadosBoleto = new DadosBoletoBndesPosVO();
        // BNDES PRE - Instancia para modelo de boleto BDES PRE
        } else if(produto.isBndesPre()) {
            dadosBoleto = new DadosBoletoBndesPreVO();
        // NCE - NOTA DE CR�DITO � EXPORTA��O
        } else if(produto.isNce()) {
            dadosBoleto = new DadosBoletoNceVO();            
        } else {
            dadosBoleto = new DadosBoletoVO();
        }
        
        dadosBoleto.getDadosBasico().setCprodtservc(produto.getCodigo());
        dadosBoleto.getDadosBasico().setPcelasfndng(new ArrayList<FundingVO>());
        dadosBoleto.getDadosBasico().setRestricoes(new ArrayList<String>());
        dadosBoleto.getDadosBasico().setNbletonegoccmbio(Numeros.NUM0_LONG);
        dadosBoleto.getDadosBasico().setCunicclicmbio(Numeros.NUM0_LONG);        
        dadosBoleto.getDadosBasico().setCunicpssoacmbio(Numeros.NUM0_LONG);      
        dadosBoleto.getDadosBasico().setNcunicclicmbio(STR_TEXTO);
        dadosBoleto.getDadosBasico().setNomecompletocli(STR_TEXTO);
        dadosBoleto.getDadosBasico().setCpfcnpj(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setCflial(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setCctrl(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setNctabcriacmbio(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setDigtcctabcria(STR_TEXTO);
        dadosBoleto.getDadosBasico().setCbco(Numeros.ZERO);     
        dadosBoleto.getDadosBasico().setNomesocial(STR_TEXTO);           
        dadosBoleto.getDadosBasico().setCagbcria(Numeros.ZERO); 
        dadosBoleto.getDadosBasico().setCctabcriaclicmbio(Numeros.NUM0_LONG);    
        dadosBoleto.getDadosBasico().setCidade(STR_TEXTO);   
        dadosBoleto.getDadosBasico().setEstado(STR_TEXTO);   
        dadosBoleto.getDadosBasico().setCpssoajurid(Numeros.NUM0_LONG);          
        dadosBoleto.getDadosBasico().setNsequndorgnz(Numeros.ZERO);         
        dadosBoleto.getDadosBasico().setNomeundorgnz(STR_TEXTO);                
        dadosBoleto.getDadosBasico().setCrting(STR_TEXTO);   
        dadosBoleto.getDadosBasico().setCtposgmtocli(Numeros.ZERO);         
        dadosBoleto.getDadosBasico().setDtposgmtocli(STR_DATA);         
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setNomecttclicmbio(STR_TEXTO);      
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setTelcttclicmbio(STR_TEXTO);       
        dadosBoleto.getDadosBasico().setCprodtservc(Numeros.ZERO);          
        dadosBoleto.getDadosBasico().setDprodtservc(STR_TEXTO);          
        dadosBoleto.getDadosBasico().setCmodldprodtcmbio(Numeros.ZERO);     
        dadosBoleto.getDadosBasico().setDmodldprodtcmbio(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setCtponegoccmbio(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setDescrctc(STR_TEXTO);
        dadosBoleto.getDadosBasico().setCsitbletocmbio(Numeros.ZERO);       
        dadosBoleto.getDadosBasico().setDsitbletocmbio(STR_TEXTO);       
        dadosBoleto.getDadosBasico().setDvalddnegoccmbio(STR_DATA);     
        dadosBoleto.getDadosBasico().setCusuarinclt(STR_TEXTO);          
        dadosBoleto.getDadosBasico().setNusuarinclt(STR_TEXTO);          
        dadosBoleto.getDadosBasico().setNseqcontrlim(Numeros.NUM0_LONG);
        dadosBoleto.getDadosBasico().setNppstapontucmbio(Numeros.NUM0_LONG);
        dadosBoleto.getDadosBasico().setCindcdeconmmoeda(Numeros.ZERO);     
        dadosBoleto.getDadosBasico().setSimbleconmmoeda("R$");      
        dadosBoleto.getDadosBasico().setDescreconmmoeda(STR_TEXTO);      
        dadosBoleto.getDadosBasico().setVnegocmoedaestrg("0.00");     
        dadosBoleto.getDadosBasico().setTdiaopercmbio(Numeros.ZERO);        
        dadosBoleto.getDadosBasico().setCeconmmoedadsemb(Numeros.ZERO);    
        dadosBoleto.getDadosBasico().setSimbleconmdsemb(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setDescreconmdsemb(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setDprevtdsembcmbio(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setCeconmmoedalim(Numeros.ZERO);       
        dadosBoleto.getDadosBasico().setSimbleconmlim(STR_TEXTO);        
        dadosBoleto.getDadosBasico().setDescreconmlim(STR_TEXTO);        
        dadosBoleto.getDadosBasico().setVmoedalimgerc(STR_TEXTO);        
        dadosBoleto.getDadosBasico().setCindcdnegocswap(STR_TEXTO);      
        dadosBoleto.getDadosBasico().setCindcdnegoclibor(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setCnegocswapfluxo(STR_TEXTO);      
        dadosBoleto.getDadosBasico().setCnegocswapestrg(STR_TEXTO);      
        dadosBoleto.getDadosBasico().setCtpocotactx(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setDescrptax(STR_TEXTO);
        dadosBoleto.getDadosBasico().setPtxswapcmpdo(STR_TEXTO);         
        dadosBoleto.getDadosBasico().setCindcdnegoccarta(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setTdiavalddletra(Numeros.ZERO);       
        dadosBoleto.getDadosBasico().setCcomiscartanacio(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setCindcdnegocarbtr(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setCbanqrcmbio(Numeros.NUM0_LONG);
        dadosBoleto.getDadosBasico().setNbanqrcmbio(STR_TEXTO);          
        dadosBoleto.getDadosBasico().setDbcoextcmbio(STR_TEXTO);         
        dadosBoleto.getDadosBasico().setTdiaopercmbioprcf(Numeros.ZERO);    
        dadosBoleto.getDadosBasico().setDcotacfndngcmbio(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setPtxfixacmbio(STR_TEXTO);         
        dadosBoleto.getDadosBasico().setCindcdeconmlibor(Numeros.ZERO);     
        dadosBoleto.getDadosBasico().setSimbleconmlibor(STR_TEXTO);      
        dadosBoleto.getDadosBasico().setTmesliborcmbio(Numeros.ZERO);       
        dadosBoleto.getDadosBasico().setVtxliborcmbio(STR_TEXTO);        
        dadosBoleto.getDadosBasico().setVtravaliborcmbio(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setVimpstnegoccmbio(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setViofnegoccmbio(STR_TEXTO);       
        dadosBoleto.getDadosBasico().setVtxmoracmbio(STR_TEXTO);         
        dadosBoleto.getDadosBasico().setCbasejuromora(Numeros.ZERO);        
        dadosBoleto.getDadosBasico().setVmultanegoccmbio(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setCsegurtrnspmcado(STR_TEXTO);     
        dadosBoleto.getDadosBasico().setCsegurmcadoorgnz(STR_TEXTO);     
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setNomerof(STR_TEXTO);  
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setTelrof(STR_TEXTO);   
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setCpfrof(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setCargorof(STR_TEXTO); 
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setEmailrof(STR_TEXTO); 
        dadosBoleto.getDadosBasico().setCmodcontrcmbio(Numeros.ZERO);       
        dadosBoleto.getDadosBasico().setDmodcontrcmbio(STR_TEXTO);       
        dadosBoleto.getDadosBasico().setQprzmedcmbio(Numeros.ZERO);       
        dadosBoleto.getDadosBasico().setQprzmedcmbioano(STR_TEXTO);       
        dadosBoleto.getDadosBasico().setDescctotal(STR_TEXTO);           
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao1(STR_TEXTO);           
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao2(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao3(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao4(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao5(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao6(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao7(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao8(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao9(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setObservacao10(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setOutrasespcs(STR_TEXTO);          
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setDivergente(STR_TEXTO);           
        dadosBoleto.getDadosBasico().setCunicpssoacmbiot(Numeros.NUM0_LONG);     
        dadosBoleto.getDadosBasico().setNcunicpssoacmbiot(STR_TEXTO);    
        dadosBoleto.getDadosBasico().setCrtinglvgemdnhe(STR_TEXTO);    
        dadosBoleto.getDadosBasico().setPercreentrg(STR_TEXTO); 
        dadosBoleto.getDadosBasico().setPercdientrg(STR_TEXTO); 
        dadosBoleto.getDadosBasico().setCindcdcontrfalt(Numeros.ZERO); 
        dadosBoleto.getDadosBasico().setDabertctacli(STR_TEXTO);    
        dadosBoleto.getDadosBasico().setDfundcnasc(STR_TEXTO);           
        dadosBoleto.getDadosBasico().setQdiavencdcontr(Numeros.ZERO);           
        dadosBoleto.getDadosBasico().setQcontrdoctopend(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setDfchtobletocmbio(STR_TEXTO);         
        dadosBoleto.getDadosBasico().setDprodtservc(STR_TEXTO);   
        dadosBoleto.getDadosBasico().setCmodldprodtdesc(STR_TEXTO);         
        dadosBoleto.getDadosBasico().setCeconmmoedadesc(STR_TEXTO);    
        dadosBoleto.getDadosBasico().setVtxrentbcmbio(STR_TEXTO);
        dadosBoleto.getDadosBasico().setPareceroperador(STR_TEXTO);      
        dadosBoleto.getDadosBasico().setParecerdsn(STR_TEXTO);           
        dadosBoleto.getDadosBasico().setNbletocmbioano(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setDinclreg(STR_DATA);
        dadosBoleto.getDadosBasico().setFuncionario(STR_TEXTO);
        dadosBoleto.getDadosBasico().setPzroprdiaano(STR_TEXTO);
        dadosBoleto.getDadosBasico().setCmovtcincel(STR_TEXTO);
        dadosBoleto.getDadosBasico().setDmodcontrcmbio(STR_TEXTO);
        dadosBoleto.getDadosBasico().setRinfoenvolmdia(STR_TEXTO);
        dadosBoleto.getDadosBasico().setTxtinformativo(STR_TEXTO);
        dadosBoleto.getDadosBasico().setReentregue(STR_TEXTO);
        dadosBoleto.getDadosBasico().setDientregue(STR_TEXTO);
        dadosBoleto.getDadosBasico().setCpfCnpjFormatado(STR_TEXTO);
        dadosBoleto.getDadosBasico().setCctabcriacmbio(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setSimbleconmdsemb(STR_TEXTO); 
        
        //Lista de parcelas de Funding 
        FundingVO fundingVO = new FundingVO();
        fundingVO.setcexterreftfndng(STR_TEXTO);
        fundingVO.setcindcdeconmmoeda(Numeros.ZERO);
        fundingVO.setvpcelafndngcmbio(STR_TEXTO);
        fundingVO.setdescreconmmoeda(STR_TEXTO);
        dadosBoleto.getDadosBasico().getPcelasfndng().add(fundingVO);
        
        //Lista de restric�es
        dadosBoleto.getDadosBasico().getRestricoes().add(STR_TEXTO);
        
        ComissaoExternaVO ext = new ComissaoExternaVO();
        ext.seticondeconc(STR_TEXTO);
        ext.setisglindcdfonte(STR_TEXTO);
        ext.setvpcelacomiscmbio("0.00");
        ext.setTipoComissao(EnumTipoComissao.BANQUEIRO);
        dadosBoleto.getComissaoExtList().add(ext);
        
        ComissaoInternaVO interna = new ComissaoInternaVO();
        interna.setPcomisnegoccmbio(STR_TEXTO);
        interna.setCcobrcomiscmbio(Numeros.ZERO);
        interna.setIsglindcdeconmmoeda(STR_TEXTO);
        interna.setVmincobrcomis("0.00");
        dadosBoleto.getComissaoIntList().add(interna);
        
        FluxoPagamentoVO pgto = new FluxoPagamentoVO();
        pgto.setDprevtdsembcmbio(STR_DATA);
        pgto.setDvctopcelatrade(STR_DATA);
        pgto.setTipojuros(STR_TEXTO); 
        pgto.setVpcelamesatrade("0.00");
        pgto.setLista(new ArrayList<FluxoPagamentoVO>());
        pgto.getLista().add(pgto);
        dadosBoleto.getFluxoPgtList().add(pgto);
        
        MercadoriaVO mercadoria = new MercadoriaVO();
        mercadoria.setIunicpssoamcado(STR_TEXTO); 
        mercadoria.setIpaisbnefc(STR_TEXTO);
        dadosBoleto.getMercadoriaList().add(mercadoria);
        
        TarifaVO tarifa = new TarifaVO();
        tarifa.setItpodespcmbio(STR_TEXTO);
        tarifa.setIsglindcdfonte(STR_TEXTO); 
        tarifa.setVdespbletocmbio("0.00");
        dadosBoleto.getTarifaList().add(tarifa);
        
        GarantiasVO adicionais = new GarantiasVO();
        adicionais.setRcomplgarntcmbio(STR_TEXTO);
        adicionais.setVtxgarntcmbio(STR_TEXTO);
        adicionais.setCindcdgarntprinc(STR_TEXTO);
        dadosBoleto.getGarantiaAdicionalList().add(adicionais);
        
        GarantiasAvaAprLmtCreditoVO aprov = new GarantiasAvaAprLmtCreditoVO();
        aprov.setNmnomecliente(STR_TEXTO);
        aprov.setCpfcnpjformatado(STR_TEXTO);
        aprov.setCdoctopssoaempr(STR_TEXTO);
        dadosBoleto.getGarantiasAprlmtList().add(aprov);
        
        GarantiasVO aprovLst = new GarantiasVO();
        aprovLst.setRcomplgarntcmbio(STR_TEXTO);
        aprovLst.setVtxgarntcmbio(STR_TEXTO);
        aprovLst.setCindcdgarntprinc(STR_TEXTO);
        dadosBoleto.getGarantiasAprovList().add(aprovLst);
        
        GarantiasAvaListaVO ava = new GarantiasAvaListaVO();
        ava.setNmnomecliente(STR_TEXTO);
        ava.setCpfcnpjformatado(STR_TEXTO);
        ava.setQualificacao(STR_TEXTO);
        dadosBoleto.getGarantiasAvaList().add(ava);
        
        // PROEX
        
        //Raxa Equaliza��o
        dadosBoleto.getDadosBasico().setPtxequalcmbio(STR_TEXTO);
        
        //Forma Amortiza��o
		dadosBoleto.getDadosBasico().getObsCotacaoVO().setFormamor(STR_TEXTO);
		
        //Despesas (Confer�ncia, Controles e Registros)
		dadosBoleto.getDadosBasico().getObsCotacaoVO().setDespconf(STR_TEXTO);
        
        //Lista Rebate
		ListaRebateVO rebate = new ListaRebateVO();
		rebate.setRebate(STR_TEXTO);
		List<ListaRebateVO> listaRebate = new ArrayList<ListaRebateVO>();
		listaRebate.add(rebate);
		dadosBoleto.getDadosBasico().getObsCotacaoVO().setListaRebate(listaRebate);

        //Despesas (Desconto das NTNs)
		dadosBoleto.getDadosBasico().getObsCotacaoVO().setDespdesc(STR_TEXTO);
		
        //Lista Taxa de Desconto
		ListaTaxaDescontoVO taxaDesc = new ListaTaxaDescontoVO();
        taxaDesc.setTxades(STR_TEXTO);
    	List<ListaTaxaDescontoVO> listaTaxa = new ArrayList<ListaTaxaDescontoVO>();
		listaTaxa.add(taxaDesc);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setListaTaxa(listaTaxa);
        
        //Validade da Proposta
		dadosBoleto.getDadosBasico().setDinicvalddcmbio(STR_DATA);
		dadosBoleto.getDadosBasico().setDfimnegoccmbio(STR_DATA);
        
        //Credor / Garantias 
		dadosBoleto.getDadosBasico().setDbcocred(STR_TEXTO);	
		dadosBoleto.getDadosBasico().getObsCotacaoVO().setGarantias(STR_TEXTO);
		
		// Finalidade / Garantias
		dadosBoleto.getDadosBasico().getObsCotacaoVO().setFinalidade(STR_TEXTO);
		dadosBoleto.getDadosBasico().setImunindcmbio(STR_TEXTO);
		
		// Despesas com Desembolso - Comiss�o do Banqueiro / Pagamento
		ListaDespesasVO despDesemb = new ListaDespesasVO();
		despDesemb.setNtpodespcmbio(STR_TEXTO);
		despDesemb.setNindcdeconmmoeda(STR_TEXTO);
		despDesemb.setVdespbletocmbio("0.00");
		despDesemb.setNidtfdrespdesp(STR_TEXTO);
		despDesemb.setCtpodespcmbio(Numeros.ZERO);
        dadosBoleto.getListaDespesasExteriorDesemb().add(despDesemb);

		// Carta de Cr�dito de Importa��o - Especifica��o da Opera��o
        dadosBoleto.getDadosBasico().setVlimcobervar(STR_TEXTO);
        dadosBoleto.getDadosBasico().setCindcdembrqpcial(STR_TEXTO);
        dadosBoleto.getDadosBasico().setNindcdembrqpcial(STR_TEXTO);
        dadosBoleto.getDadosBasico().setDlimembrqcmbio(STR_TEXTO);

        // BNDES PRE
        dadosBoleto.getDadosBasico().setTdiacarenprinc(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setQpcelatradeprinc(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setCidtfdbndesgrp(Numeros.ZERO);
        dadosBoleto.getDadosBasico().setPagtefincrcmbio(STR_TEXTO);  
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setCustfin(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setPagajuro(STR_TEXTO);
        dadosBoleto.getDadosBasico().getObsCotacaoVO().setPartbnds(STR_TEXTO);
        dadosBoleto.getDadosBasico().setGrupomercadoriaboleto(STR_TEXTO);
        
        return dadosBoleto;
    }

    /**
     * @return o valor do lista
     */
    public List<ModeloBoletoVO> getLista() {
        return lista;
    }

    /**
     * @param lista
     *            seta o novo valor para o campo lista
     */
    public void setLista(List<ModeloBoletoVO> lista) {
        this.lista = lista;
    }

    /**
     * @return o valor do modeloBoletoVO
     */
    public ModeloBoletoVO getModeloBoletoVO() {
        return modeloBoletoVO;
    }

    /**
     * @param modeloBoletoVO
     *            seta o novo valor para o campo modeloBoletoVO
     */
    public void setModeloBoletoVO(ModeloBoletoVO modeloBoletoVO) {
        this.modeloBoletoVO = modeloBoletoVO;
    }

    /**
     * @return o valor do viewHelper
     */
    public ModeloBoletoViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper
     *            seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(ModeloBoletoViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do selectItemBean
     */
    public SelectItemBean getSelectItemBean() {
        return selectItemBean;
    }

    /**
     * @param selectItemBean
     *            seta o novo valor para o campo selectItemBean
     */
    public void setSelectItemBean(SelectItemBean selectItemBean) {
        this.selectItemBean = selectItemBean;
    }

    /**
     * @return o valor do boletoModalBean
     */
    public BoletoModalBean getBoletoModalBean() {
        return boletoModalBean;
    }

    /**
     * @param boletoModalBean
     *            seta o novo valor para o campo boletoModalBean
     */
    public void setBoletoModalBean(BoletoModalBean boletoModalBean) {
        this.boletoModalBean = boletoModalBean;
    }

}
