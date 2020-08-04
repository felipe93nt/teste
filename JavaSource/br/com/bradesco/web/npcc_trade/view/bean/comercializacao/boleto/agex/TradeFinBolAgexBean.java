package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.agex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.unidadeExternaModal.bean.UnidadeExternaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.BolAgexListService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexListVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.global.clienteModal.bean.LimitesModalVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.ICommonService;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinBolAgex;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal.ClienteModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.limitesModal.LimitesModalBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.unidadeExternaModalbean.UnidadeExternaModalBean;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

/**
 * 
 * Nome: TradeFinBolAgexBean.java
 * 
 * Propósito:
 * <p>
 * Bean para funcionalidade da tela Boleto Agex - Trade Finance
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 */
@Named("tradeFinBolAgexBean")
@SessionScoped
public class TradeFinBolAgexBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;
    
    private final String STATE_ID = "NPCCIATX-CONSULTA";

    private TradeFinBolAgexViewHelper viewHelper = new TradeFinBolAgexViewHelper();

    private BolAgexFiltroVO filtroVO = new BolAgexFiltroVO();

    private List<BolAgexListVO> lista = new ArrayList<BolAgexListVO>();
    private BolAgexVO listaBoletoAgex = new BolAgexVO();
    private List<SelectItem> produto = new ArrayList<SelectItem>();
    private List<SelectItem> moeda = new ArrayList<SelectItem>();
    private BolAgexVO bolAgexVO = new BolAgexVO();
    private BolAgexListVO bolAgexListVO = new BolAgexListVO();

    /* Lista para montar a Grid */
    private List<BolAgexListVO> listaModalLimite = new ArrayList<BolAgexListVO>();
    private List<BolAgexListVO> listaSelCliente = new ArrayList<BolAgexListVO>();

    private ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();
    private TradeFinNegocListasVO clienteSelecionado = new TradeFinNegocListasVO();
    private LimitesModalVO limitesSelecaoVO = new LimitesModalVO();

    private List<SelectItem> status = new ArrayList<SelectItem>();

    private BolAgexListVO boletoSelecionado = new BolAgexListVO();
    private BolAgexVO boletoSelecaoVO = new BolAgexVO();

    protected UnidadeExternaVO externaVO = new UnidadeExternaVO();

    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;

    @Inject
    @Named("tradeFinBolAgexBean")
    private TradeFinBolAgexBean tradeFinBolAgexBean;

    @Inject
    @Named("clienteModalBean")
    private ClienteModalBean clienteModalBean;

    @Inject
    @Named("limitesModalBean")
    private LimitesModalBean limitesModalBean;

    @Inject
    @Named("commonService")
    private ICommonService commonService;

    @Inject
    @Named("unidadeExternaModalBean")
    protected UnidadeExternaModalBean unidadeExternaModalBean;

    @Inject
    @Named("bolAgexListService")
    private BolAgexListService bolAgexListService;

    /**
     * Construtor
     * 
     * @param
     */
    public TradeFinBolAgexBean() {
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
     */
    public String iniciar() {
        // Recarrega página se não for um postback ou se foi marcado para
        // recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);

            setClienteSelecaoVO(new ClienteSelecaoVO());
            setLimitesSelecaoVO(new LimitesModalVO());
            setFiltroVO(new BolAgexFiltroVO());
            getFiltroVO().setDanobase(Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
            setViewHelper(new TradeFinBolAgexViewHelper());
            setLista(new ArrayList<BolAgexListVO>());

            getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));

            this.setProduto(selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                            EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                            EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));

            this.setMoeda(selectItemBean.getMoeda());
            
            this.getViewHelper().setNomeStateIdLista(STATE_ID);
        }

        return "tradeFinBolAgexIncl";
    }

    /**
     * Nome: callbackChangeComboProduto
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/02/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void callbackChangeComboProduto(AjaxBehaviorEvent e) {
        setLimitesSelecaoVO(new LimitesModalVO());
    }

    /**
     * 
     * Nome: pesquisarUnidadeExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModalUnidadeExterna(AjaxBehaviorEvent ajaxBehaviorEvent) {
        this.getFiltroVO().getUnidadeExternaVO()
                        .setTipoPesquisaUnidExt(EnumTradeFinBolAgex.PESQUISA_UNID_EXTERNA_POR_NOME.getCodigo());
        this.getUnidadeExternaModalBean().setExternaVO(getFiltroVO().getUnidadeExternaVO());
        this.getUnidadeExternaModalBean().getViewHelper().setModalId("formTrdFinBolAgexIncl\\:content_modalUnidExt");
        this.getUnidadeExternaModalBean().getViewHelper().setModalidade(Numeros.UM);
        this.getUnidadeExternaModalBean().pesquisarUnidExtPorNome();
    }

    /**
     * 
     * Nome: validarForm
     * 
     * Propósito: Ação que executa a validação do formulário e abre o modal de confirmação das telas de inclusão e
     * alteração
     * 
     * @return : Navegação por mensagem
     * 
     * @throws : NpccServiceBusinessException
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void validarForm(AjaxBehaviorEvent e) {

        // valida campos obrigatórios
        if (!SiteUtil.validarCamposExcl("formTrdFinBolAgexIncl", "inputLimites")) {

            // Validar demais regras
            if (getFiltroVO().getVencimento() != null && getFiltroVO().getFechamento() != null
                            && getFiltroVO().getVencimento().before(getFiltroVO().getFechamento())) {

                NpcFacesUtils.addInfoModalMessage("Data de Vencimento menor que a Data de Fechamento", false);
                return;
            }
        }

        if (getFiltroVO().getVencimento() == null) {
            NpcFacesUtils.addInfoModalMessage("Data de Vencimento é obrigatória", false);
            return;
        }

        if (getFiltroVO().getFechamento() == null) {
            NpcFacesUtils.addInfoModalMessage("Data de Fechamento é obrigatória ", false);
            return;
        }

        getViewHelper().setRenderModal(Boolean.TRUE);
    }

    /**
     * Nome: confirmarInclusao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/02/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void confirmarInclusao() {

        String result = SiteUtil.STRING_EMPTY;
        getViewHelper().setRenderModal(Boolean.FALSE);

        this.getFiltroVO().setCunicpssoacmbio(this.getClienteSelecaoVO().getCunicpssoacmbio());
        this.getFiltroVO().setCunicclicmbio(this.getClienteSelecaoVO().getCodCliente());

        // Verifica a nulidade, Unidade Externa não é obrigatória
        if (getUnidadeExternaModalBean().getViewHelper().getItemSelecListaUnidExt() != null
                        && getUnidadeExternaModalBean().getViewHelper().getItemSelecListaUnidExt() < getUnidadeExternaModalBean()
                                        .getListaUniExterna().size()) {

            getFiltroVO().setCbcoextcmbio(
                            this.getUnidadeExternaModalBean()
                                            .getListaUniExterna()
                                            .get(getUnidadeExternaModalBean().getViewHelper()
                                                            .getItemSelecListaUnidExt()).getCbanqrcmbio());
        } else {
            getFiltroVO().setCbcoextcmbio(0L);
        }

        // Limite Selecionado
        if (this.getLimitesSelecaoVO() != null) {
            // Número limite gerencial (modal)
            this.getFiltroVO().setNcontrlim(this.getLimitesSelecaoVO().getNcontrlim());

            // Valor Saldo Limite Disponível (modal)
            this.getFiltroVO().setVdispnlimgerc(this.getLimitesSelecaoVO().getVdispnlimgerc());

            this.getFiltroVO().setCcatlggarntprinc(this.getLimitesSelecaoVO().getCcatlggarntprinc());
        }

        result = bolAgexListService.incluirBoletoAgex(this.getFiltroVO());

        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{tradeFinBolAgexBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }

    /**
     * 
     * Nome: listenerMudaCpfCnpjCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerMudaCpfCnpjCliente(AjaxBehaviorEvent e) {
        this.clienteSelecaoVO.setNomeCliente(null);
        this.clienteSelecaoVO.setCnpj(new CnpjDataType());
        this.clienteSelecaoVO.setCpf(new CpfDataType());
    }

    /**
     * 
     * Nome: listenerPesquisarClienteNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesqClienteNomeIncl(AjaxBehaviorEvent e) {
        getViewHelper().setCodCpfCnpjSelecionado(clienteSelecaoVO.getCodCpfCnpj());
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
        clienteModalBean.getViewHelper().setModalId("formTrdFinBolAgexIncl\\:modalCliente");
        clienteModalBean.getViewHelper().setPesqCpf(Boolean.FALSE);
        clienteModalBean.openModal();
        getViewHelper().setRenderModalCliente(Boolean.TRUE);
    }

    /**
     * Nome: listenerPesqClienteNomeCons
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/02/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesqClienteNomeCons(AjaxBehaviorEvent e) {
        getViewHelper().setCodCpfCnpjSelecionado(clienteSelecaoVO.getCodCpfCnpj());
        clienteSelecaoVO.setCodCpfCnpj(Numeros.UM);
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
        clienteModalBean.getViewHelper().setModalId("formTrdFinBolAgexConsBol\\:modalCliente");
        clienteModalBean.getViewHelper().setPesqCpf(Boolean.FALSE);
        clienteModalBean.openModal();
        getViewHelper().setRenderModalCliente(Boolean.TRUE);
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
     *      Registro de Manutenção: 07/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal() {
        if (clienteSelecaoVO.getCodCpfCnpj() != Numeros.UM) {
            getViewHelper().setCodCpfCnpjSelecionado(clienteSelecaoVO.getCodCpfCnpj());
        } else {
            clienteSelecaoVO.setCodCpfCnpj(getViewHelper().getCodCpfCnpjSelecionado());
        }

        getViewHelper().setRenderModalCliente(Boolean.FALSE);
        getViewHelper().setRenderModalLimite(Boolean.FALSE);
        getViewHelper().setRenderModal(Boolean.FALSE);
    }

    /**
     * 
     * Nome: listenerPesquisarClienteCpfCnpj
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteCpfCnpj(AjaxBehaviorEvent e) {
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
        clienteModalBean.setClienteSelecionado(clienteSelecionado);
        clienteModalBean.getViewHelper().setModalId("formTrdFinBolAgexIncl\\:modalCliente");
        clienteModalBean.getViewHelper().setPesqCpf(Boolean.TRUE);
        clienteModalBean.openModal();
        getViewHelper().setRenderModalCliente(Boolean.TRUE);
    }

    /**
     * 
     * Nome: listenerPesquisarClienteCpfCnpj
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteCpfCnpjCons(AjaxBehaviorEvent e) {
        clienteSelecaoVO.setNomeCliente(null);
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
        clienteModalBean.setClienteSelecionado(clienteSelecionado);
        clienteModalBean.getViewHelper().setModalId("formTrdFinBolAgexConsBol\\:modalCliente");
        clienteModalBean.getViewHelper().setPesqCpf(Boolean.TRUE);
        clienteModalBean.openModal();
        getViewHelper().setRenderModalCliente(Boolean.TRUE);
    }

    /**
     * 
     * Nome: limparGrid
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/10/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void limparGrid(AjaxBehaviorEvent event) {
        listaBoletoAgex = null;
        setListaBoletoAgex(listaBoletoAgex);
        bolAgexVO = null;
    	setBolAgexVO(bolAgexVO);    	
    }
    
    /**
     * 
     * Nome: callbackMudarCliente
     * 
     * Propósito: Limpar campo de cliente quando o campo é alterado na pesquisa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/03/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    
    public void callbackMudarCliente(AjaxBehaviorEvent event){
    	if(SiteUtil.isEmptyOrNull(clienteSelecaoVO.getNomeCliente())){
    		  	setClienteSelecaoVO(new ClienteSelecaoVO());
    	}
    	limparGrid(event);
    }

    /**
     * 
     * Nome: limpar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void limpar(AjaxBehaviorEvent event) {
    	 setClienteSelecaoVO(new ClienteSelecaoVO());
    	filtroVO = new BolAgexFiltroVO();    	
        setBolAgexVO(new BolAgexVO());        
        clienteSelecaoVO.setCodCpfCnpj(Numeros.DOIS);
        this.filtroVO.setNomeCliente(null);
        getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
        limparGrid(null);

    }

    /**
     * Nome: validaDatas
     * 
     * Propósito: valida datas de fechamento e vencimento
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/02/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void validaDatas(AjaxBehaviorEvent e) {
        int prazo = Numeros.UM;
        if (getFiltroVO().getFechamento() != null && getFiltroVO().getVencimento() != null) {

            if (getFiltroVO().getVencimento().before(getFiltroVO().getFechamento())) {
                BradescoFacesUtils.addInfoModalMessage("Data de Vencimento deve ser superior a Data de Fechamento",
                                false);

                getFiltroVO().setVencimento(getFiltroVO().getFechamento());
            }
        }
        try {
            if (!SiteUtil.isEmptyOrNull(getFiltroVO().getVencimento())) {
                prazo = SiteUtil.calculaDias(getFiltroVO().getFechamento(), getFiltroVO().getVencimento());
                getFiltroVO().setTdiaprazo(prazo);
            } else {
                getFiltroVO().setVencimento(
                                SiteUtil.calculaData(getFiltroVO().getFechamento(), getFiltroVO().getTdiaprazo()));
            }
        } catch (Exception e1) {
            BradescoFacesUtils.addInfoModalMessage("Data inválida", false);
        }

    }

    /**
     * Nome: validaPrazo
     * 
     * Propósito: valida prazo
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/02/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void validaPrazo(AjaxBehaviorEvent e) {
        int prazo = filtroVO.getTdiaprazo();

        /** Se o prazo for zero apaga o campo */
        if (prazo == Numeros.ZERO) {
            getFiltroVO().setVencimento(null);
        } else {
            getFiltroVO().setVencimento(SiteUtil.calculaData(getFiltroVO().getFechamento(), prazo));
        }

    }

    /**
     * @return o valor do filtroVO
     */
    public BolAgexFiltroVO getFiltroVO() {
        return filtroVO;
    }

    /**
     * @param filtroVO seta o novo valor para o campo filtroVO
     */
    public void setFiltroVO(BolAgexFiltroVO filtroVO) {
        this.filtroVO = filtroVO;
    }

    /**
     * @return o valor do lista
     */
    public List<BolAgexListVO> getLista() {
        return lista;
    }

    /**
     * @param lista seta o novo valor para o campo lista
     */
    public void setLista(List<BolAgexListVO> lista) {
        this.lista = lista;
    }

    /**
     * @return o valor do listaBoletoAgex
     */
    public BolAgexVO getListaBoletoAgex() {
        return listaBoletoAgex;
    }

    /**
     * @param listaBoletoAgex o novo valor para o campo listaBoletoAgex
     */
    public void setListaBoletoAgex(BolAgexVO listaBoletoAgex) {
        this.listaBoletoAgex = listaBoletoAgex;
    }

    /**
     * @return o valor do produto
     */
    public List<SelectItem> getProduto() {
        return produto;
    }

    /**
     * @param produto o novo valor para o campo produto
     */
    public void setProduto(List<SelectItem> produto) {
        this.produto = produto;
    }

    /**
     * @return o valor do viewHelper
     */
    public TradeFinBolAgexViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper o novo valor para o campo viewHelper
     */
    public void setViewHelper(TradeFinBolAgexViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do status
     */
    public List<SelectItem> getStatus() {
        return status;
    }

    /**
     * @param status o novo valor para o campo status
     */
    public void setStatus(List<SelectItem> status) {
        this.status = status;
    }

    /**
     * @return o valor do bolAgexVO
     */
    public BolAgexVO getBolAgexVO() {
        return bolAgexVO;
    }

    /**
     * @param bolAgexVO o novo valor para o campo bolAgexVO
     */
    public void setBolAgexVO(BolAgexVO bolAgexVO) {
        this.bolAgexVO = bolAgexVO;
    }

    /**
     * @return o valor do bolAgexListVO
     */
    public BolAgexListVO getBolAgexListVO() {
        return bolAgexListVO;
    }

    /**
     * @param bolAgexListVO o novo valor para o campo bolAgexListVO
     */
    public void setBolAgexListVO(BolAgexListVO bolAgexListVO) {
        this.bolAgexListVO = bolAgexListVO;
    }

    /**
     * 
     * Nome: getSelectItemRadioCtc
     * 
     * Propósito: preencher lista auxiliar para selecao de flux de pagamentos na tela
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 14/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioCtc() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getLista().size(); index++) {
            list.add(new SelectItem(index, ""));
        }
        return list;
    }

    /**
     * @return o valor do clienteSelecaoVO
     */
    public ClienteSelecaoVO getClienteSelecaoVO() {
        return clienteSelecaoVO;
    }

    /**
     * @param clienteSelecaoVO o novo valor para o campo clienteSelecaoVO
     */
    public void setClienteSelecaoVO(ClienteSelecaoVO clienteSelecaoVO) {
        this.clienteSelecaoVO = clienteSelecaoVO;
    }

    /**
     * 
     * Nome: listenerPesquisarLimites
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarLimites(AjaxBehaviorEvent e) {
        this.getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCodCliente());
        limitesSelecaoVO.setCunicpssoacmbio(getClienteSelecaoVO().getCunicpssoacmbio());
        limitesSelecaoVO.setProduto(this.getFiltroVO().getCprodtservc());

        limitesModalBean.setLimiteVO(limitesSelecaoVO);

        limitesModalBean.getViewHelper().setModalId("formTrdFinBolAgexIncl\\:modalLimite");

        limitesModalBean.getViewHelper().setCodItemSelecionadoLimite(null);
        limitesModalBean.getViewHelper().setCodItemSelecionadoProposta(null);
        limitesModalBean.getViewHelper().setItemSelecionado(Boolean.FALSE);

        limitesModalBean.setListaLimites(new ArrayList<LimitesModalVO>());
        limitesModalBean.setListaPropostas(new ArrayList<LimitesModalVO>());
        limitesModalBean.getViewHelper().setTratarSelecionarProposta(Boolean.FALSE);

        limitesModalBean.openModal(true);

        // Se não houver nenhum limite exibe a mensagem
        if (limitesModalBean.getListaLimites().size() == 0) {
            NpcFacesUtils.addInfoModalMessage("Limite de Crédito não encontrado.", EnumButtonBehavior.CLOSE);
            getViewHelper().setRenderModalLimite(Boolean.FALSE);
        } else {
            getViewHelper().setRenderModalLimite(Boolean.TRUE);
        }
    }

    /**
     * Nome: closeModalLimitesInclusao
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/02/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalLimitesInclusao() {
        getViewHelper().setRenderModalLimite(Boolean.FALSE);

        // Verifica se deve exibir o modal de confirmar da inclusão
        if (limitesModalBean.getViewHelper().getAcaoConfirmacao()) {
            limitesModalBean.getViewHelper().setAcaoConfirmacao(false);

            validarForm(null);
        }
    }

    /**
     * Nome: closeModalLimites
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/02/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String closeModalLimites() {
        getViewHelper().setRenderModalLimite(Boolean.FALSE);
        return "/content/global/limitesModal/closeModalLimites.xhtml";
    }

    /**
     * @return o valor do limitesSelecaoVO
     */
    public LimitesModalVO getLimitesSelecaoVO() {
        return limitesSelecaoVO;
    }

    /**
     * @param limitesSelecaoVO seta o novo valor para o campo limitesSelecaoVO
     */
    public void setLimitesSelecaoVO(LimitesModalVO limitesSelecaoVO) {
        this.limitesSelecaoVO = limitesSelecaoVO;
    }

    /**
     * @return o valor do listaModalLimite
     */
    public List<BolAgexListVO> getListaModalLimite() {
        return listaModalLimite;
    }

    /**
     * @param listaModalLimite seta o novo valor para o campo listaModalLimite
     */
    public void setListaModalLimite(List<BolAgexListVO> listaModalLimite) {
        this.listaModalLimite = listaModalLimite;
    }

    /**
     * @return o valor do listaSelCliente
     */
    public List<BolAgexListVO> getListaSelCliente() {
        return listaSelCliente;
    }

    /**
     * @param listaSelCliente seta o novo valor para o campo listaSelCliente
     */
    public void setListaSelCliente(List<BolAgexListVO> listaSelCliente) {
        this.listaSelCliente = listaSelCliente;
    }

    /**
     * 
     * Nome: consultarBoletoAgex
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
    public String consultarBoletoAgex() {

        // Recarrega página se não for um postback ou se foi marcado para
        // recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);

            setClienteSelecaoVO(new ClienteSelecaoVO());
            filtroVO = new BolAgexFiltroVO();
            filtroVO.setDanobase(Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
            viewHelper = new TradeFinBolAgexViewHelper();

            getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));

            lista = new ArrayList<BolAgexListVO>();
            setListaBoletoAgex(new BolAgexVO());
            produto =
                            selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                                            EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                                            EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo());

            setStatus(selectItemBean.getListaSituacaoBoletoAgex(Numeros.ZERO));
        }

        return "tradeFinBolAgexConsBol";
    }

    /**
     * 
     * Nome: pesquisarBoletoAgex
     * 
     * Propósito: Efetua a pesquisa de Boletos AGEX
     *
     * @param : <BR/>
     *
     * @exception : BradescoFacesUtils Message Info
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisarBoletoAgex() {

        // valida campos obrigatórios
        if (!SiteUtil.validarCampos("formTrdFinBolAgexConsBol")) {

            this.getFiltroVO().setCunicclicmbio(getClienteSelecaoVO().getCunicpssoacmbio());

            if (getFiltroVO().getDataInicioFim() == null || getFiltroVO().getDataInicioFim().getInicio() == null
                            || getFiltroVO().getDataInicioFim().getFim() == null) {
                NpcFacesUtils.addInfoModalMessage("Período da pesquisa deve ser informado!", false);
                return;
            }

            this.getFiltroVO().setFlagBaixEstrn(Numeros.ZERO);

            this.getFiltroVO().setEcprodtservc(this.getFiltroVO().getCprodtservc());
            this.getFiltroVO().setEcunicclicmbio(this.getFiltroVO().getCunicclicmbio());
            this.getFiltroVO().setEnbletonegoccmbioano(this.getFiltroVO().getNbletocmbioano());
            this.getFiltroVO().setEdanobase(this.getFiltroVO().getEdanobase());
            this.getFiltroVO().setEstatus(this.getFiltroVO().getCsitbletocmbio());

            // carrega dados da lista
            this.setListaBoletoAgex(bolAgexListService.pesquisar(this.getFiltroVO(), STATE_ID));

            // se lista vazia exibe mensagem de retorno do mainframe
            if (this.getListaBoletoAgex().getLista().isEmpty()) {
                NpcFacesUtils.addInfoModalMessage(bolAgexListService.capturarMensagemRetorno(), false);
            }
        }
    }

    /**
     * 
     * Nome: getSelectItemRadioLista
     * 
     * Propósito: Monta a lista de SelectItem utilizada para montar os radio da lista
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioLista() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
        SiteUtil.atualizarSelectItem(this.getListaBoletoAgex().getLista(), selectItemRadioLista);
        return selectItemRadioLista;
    }

    /**
     * 
     * Nome: detalharBoletoAgex
     * 
     * Propósito: Efetua a pesquisa de Boletos AGEX
     *
     * @param : <BR/>
     *
     * @exception : BradescoFacesUtils Message Info
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 28/07/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String detalharBoletoAgex() {
        // valida se foi selecionado um item na lista
        if (getViewHelper().getItemSelecListaSelBoleto() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return null;
        }

        getBoletoSelecionado().setSncunicclicmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSncunicclicmbio());
        getBoletoSelecionado().setCpfCnpjFormatado(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getCpfCnpjFormatado());
        getBoletoSelecionado().setScprodtdesc(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getScprodtdesc());
        getBoletoSelecionado().setSnbletonegoccmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSnbletonegoccmbio());
        getBoletoSelecionado().setScbcoextcmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getScbcoextcmbio());
        getBoletoSelecionado().setScopercmbioexter(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getScopercmbioexter());
        getBoletoSelecionado()
                        .setStomador(getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getStomador());
        getBoletoSelecionado().setSobservacao(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSobservacao());
        getBoletoSelecionado().setSvtxspreadnegoc(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSvtxspreadnegoc());
        getBoletoSelecionado().setSdfchtobletocmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSdfchtobletocmbio());
        getBoletoSelecionado().setStdiaopercmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getStdiaopercmbio());
        getBoletoSelecionado().setSdfimnegoccmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSdfimnegoccmbio());
        getBoletoSelecionado().setSisglindcdfonte(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSisglindcdfonte());
        getBoletoSelecionado().setSvnegocmoedaestrg(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSvnegocmoedaestrg());
        getBoletoSelecionado().setSvsdolimsensi(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSvsdolimsensi());
        getBoletoSelecionado().setScbanqrcmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getScbanqrcmbio());
        getBoletoSelecionado().setSdcbanqrcmbio(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSdcbanqrcmbio());
        getBoletoSelecionado().setBanqrCodNom(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getBanqrCodNom());
        getBoletoSelecionado().setStatusCodDesc(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getStatusCodDesc());
        getBoletoSelecionado().setNbletocmbioano(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getNbletocmbioano());
        getBoletoSelecionado().setSdanobase(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getSdanobase());
        getBoletoSelecionado().setRefBradesco(
                        getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
                                        .getRefBradesco());
        getBoletoSelecionado().setSdescstatus(getListaBoletoAgex().getLista().get(getViewHelper().getItemSelecListaSelBoleto())
        								.getSdescstatus());
        return "tradeFinBolAgexDetlhBol";

    }

    /**
     * 
     * Nome: actionVoltar
     * 
     * Propósito: Ação executada pelo botão voltar
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    public String actionVoltar() {
        return "tradeFinBolAgexConsBol";
    }

    /**
     * @return the boletoSelecaoVO
     */
    public BolAgexVO getBoletoSelecaoVO() {
        return boletoSelecaoVO;
    }

    /**
     * @param boletoSelecaoVO the boletoSelecaoVO to set
     */
    public void setBoletoSelecaoVO(BolAgexVO boletoSelecaoVO) {
        this.boletoSelecaoVO = boletoSelecaoVO;
    }

    /**
     * @return the boletoSelecionado
     */
    public BolAgexListVO getBoletoSelecionado() {
        return boletoSelecionado;
    }

    /**
     * @param boletoSelecionado the boletoSelecionado to set
     */
    public void setBoletoSelecionado(BolAgexListVO boletoSelecionado) {
        this.boletoSelecionado = boletoSelecionado;
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
     *      Registro de Manutenção: 03/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginar(ActionEvent event) {
        this.setListaBoletoAgex(bolAgexListService.pesquisar(this.getFiltroVO(), STATE_ID));
    }

    /**
     * @return o valor do unidadeExternaModalBean
     */
    public UnidadeExternaModalBean getUnidadeExternaModalBean() {
        return unidadeExternaModalBean;
    }

    /**
     * @param unidadeExternaModalBean seta o novo valor para o campo unidadeExternaModalBean
     */
    public void setUnidadeExternaModalBean(UnidadeExternaModalBean unidadeExternaModalBean) {
        this.unidadeExternaModalBean = unidadeExternaModalBean;
    }

    /**
     * @return the moeda
     */
    public List<SelectItem> getMoeda() {
        return moeda;
    }

    /**
     * @param moeda the moeda to set
     */
    public void setMoeda(List<SelectItem> moeda) {
        this.moeda = moeda;
    }

}
