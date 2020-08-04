package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.logAgex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.BolAgexListService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexListVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal.ClienteModalBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

@Named("consultarLogBean")
@SessionScoped
public class ConsultarLogBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    private ConsultarLogViewHelper viewHelper = new ConsultarLogViewHelper();
    
    /* Objeto utilizado nas telas de Cliente */
    private ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();
    
    /*Objeto de entrada para a pesquisa*/
    private BolAgexFiltroVO filtroVO = new BolAgexFiltroVO();
    /*Objeto de saída para a pesquisa*/
    private BolAgexVO bolAgexVO = new BolAgexVO();
    /*objeto para o detalhar*/
    private BolAgexListVO bolAgexListVO = new BolAgexListVO();
    
    
    @Inject
    @Named("clienteModalBean")
    private ClienteModalBean clienteModalBean;
    
    @Inject
    @Named("bolAgexListService")
    private BolAgexListService bolAgexListService;
    
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
	 * Registro  de Manutenção: 20/04/2016
	 *        - Autor: BRQ
	 *        - Responsavel: Equipe Web
	 *        - Adequação ao padrão hexavision.
     */
    public String iniciar() {    	
    	// Recarrega página se não for um postback ou se foi marcado para recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);
            
            setFiltroVO(new BolAgexFiltroVO());
            setViewHelper(new ConsultarLogViewHelper());
            setBolAgexVO(new BolAgexVO());
            setClienteSelecaoVO(new ClienteSelecaoVO());
                    
            getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
            
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
        }
        
        return "pesqLog";
    }
    /**
     * 
    	* Nome: voltar
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 12/05/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public String voltar(){
        return "pesqLog";    
    }
    
    /**
     * 
    	* Nome: detalhar
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 20/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public String detalhar() {
        int indice = SiteUtil.getInt(getViewHelper().getCodlistRadio());
        if(validarCodigoListaRadio()){           
            bolAgexListVO = bolAgexVO.getLista().get(indice);
            return "detLog"; 
        }
        return "pesqLog";
    }
    /**
     * 
    	* Nome: validarCodigoListaRadio
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public Boolean validarCodigoListaRadio(){
        if(SiteUtil.isEmptyOrNull(getViewHelper().getCodlistRadio())){
            NpcFacesUtils.addInfoModalMessage("Selecione um item", false);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    /**
     * 
    	* Nome: getSelectItemRadioLista
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioLista() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getBolAgexVO().getLista().size(); index++) {
            list.add(new SelectItem(index, "", ""));
        }
        return list;
    }
    /**
     * 
    	* Nome: paginar
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void paginar(){
    	this.setBolAgexVO(bolAgexListService.consultaLogPesquisar(this.getFiltroVO()));
     //   bolAgexVO = bolAgexListService.consultaLogPesquisar(filtroVO);
    }
    /**
     * 
    	* Nome: listeneruisarClienteNome
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteNome(AjaxBehaviorEvent e) {
       
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);     
        clienteModalBean.getViewHelper().setModalId("formConsultarLog\\:modalCliente");
        clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(Numeros.UM);
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
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void closeModal(){
    	if(clienteSelecaoVO.getCodCpfCnpj() != Numeros.UM){
        	getViewHelper().setCodCpfCnpjSelecionado(clienteSelecaoVO.getCodCpfCnpj());
    	} else {
    		clienteSelecaoVO.setCodCpfCnpj(getViewHelper().getCodCpfCnpjSelecionado());
    	}
        getViewHelper().setRenderModalCliente(Boolean.FALSE);
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
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteCpfCnpj(AjaxBehaviorEvent e) {
    	clienteSelecaoVO.setNomeBanco(null);
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);     
        clienteModalBean.getViewHelper().setModalId("formConsultarLog\\:modalCliente");
        clienteModalBean.getViewHelper().setPesqCpf(Boolean.TRUE);
        clienteModalBean.openModal();
        getViewHelper().setRenderModalCliente(Boolean.TRUE);
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
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void listenerMudaCpfCnpjCliente(AjaxBehaviorEvent e) {
        limpaCamposCliente();
    }
    /**
     * 
        * Nome: limpaCamposCliente
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 18/04/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
     */
    private void limpaCamposCliente() {
        this.clienteSelecaoVO.setCnpj(new CnpjDataType());
        this.clienteSelecaoVO.setCpf(new CpfDataType());
        this.clienteSelecaoVO.setNomeCliente(null);
        this.clienteSelecaoVO.setNomeBanco(null);
        this.clienteSelecaoVO.setCodAgencia(null);
        this.clienteSelecaoVO.setContaDv(null);
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
     *      Registro de Manutenção: 30/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public void limparGrid(AjaxBehaviorEvent event) {
    	
    	bolAgexVO = null;
    	setBolAgexVO(bolAgexVO);
    
    }
    
    /**
     * 
     * Nome: limpar
     * 
     * Propósito: limpa campos e grid após pressionar botão limpar
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/12/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public void limpar(AjaxBehaviorEvent event){
    	setClienteSelecaoVO(new ClienteSelecaoVO());
        setFiltroVO(new BolAgexFiltroVO());
        setBolAgexVO(new BolAgexVO());
        limpaCamposCliente();
        clienteSelecaoVO.setCodCpfCnpj(Numeros.DOIS);
        getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
    }

    /**
     * 
     * Nome: validarDatas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean validarDatas() {
        Boolean retorno = Boolean.FALSE;

        if (getFiltroVO().getDataInicioFim().getInicio() == null
                        || getFiltroVO().getDataInicioFim().getFim() == null) {
            retorno = true;
            NpcFacesUtils.addInfoModalMessage("O campo Data é obrigatório.", false);
        } else if (getFiltroVO().getDataInicioFim().getFim()
                        .before(getFiltroVO().getDataInicioFim().getInicio())) {

            NpcFacesUtils.addInfoModalMessage("O campo Data Inicial é maior que Data Final.", false);
            retorno = true;
        }

        return retorno;
    }
    /**
     * 
    	* Nome: validarCpfCnpj
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public Boolean validarCpfCnpj(){
        Boolean retorno = Boolean.FALSE;
        if(getFiltroVO().getCnpj() == null && getFiltroVO().getCpf() == null){
           BradescoFacesUtils.addGlobalErrorFacesMessage("O campo Cpf ou Cnpj deve ser preenchido.", ""); 
           retorno = Boolean.TRUE;
        }
        return retorno;
    }
    /**
     * 
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
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void pesquisar(AjaxBehaviorEvent event){
        
        // valida campos
        if(!validarDatas()){

            getFiltroVO().setEcunicclicmbio(getClienteSelecaoVO().getCodCliente());
            bolAgexVO = bolAgexListService.consultaLogPesquisar(filtroVO);
            
            
        }  
        viewHelper.setNomeStateIdLista("NPCCIAT1");
    }

    /**
     * Construtor
     * 
     * @param
     */
    public ConsultarLogBean() {
        super();
    }

    /**
     * @return o valor do viewHelper
     */
    public ConsultarLogViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(ConsultarLogViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }
    /**
     * @return o valor do clienteSelecaoVO
     */
    public ClienteSelecaoVO getClienteSelecaoVO() {
        return clienteSelecaoVO;
    }
    /**
     * @param clienteSelecaoVO seta o novo valor para o campo clienteSelecaoVO
     */
    public void setClienteSelecaoVO(ClienteSelecaoVO clienteSelecaoVO) {
        this.clienteSelecaoVO = clienteSelecaoVO;
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
     * @return o valor do bolAgexVO
     */
    public BolAgexVO getBolAgexVO() {
        return bolAgexVO;
    }
    /**
     * @param bolAgexVO seta o novo valor para o campo bolAgexVO
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
     * @param bolAgexListVO seta o novo valor para o campo bolAgexListVO
     */
    public void setBolAgexListVO(BolAgexListVO bolAgexListVO) {
        this.bolAgexListVO = bolAgexListVO;
    }
    /**
     * @return o valor do clienteModalBean
     */
    public ClienteModalBean getClienteModalBean() {
        return clienteModalBean;
    }
    /**
     * @param clienteModalBean seta o novo valor para o campo clienteModalBean
     */
    public void setClienteModalBean(ClienteModalBean clienteModalBean) {
        this.clienteModalBean = clienteModalBean;
    }
    /**
     * @return o valor do bolAgexListService
     */
    public BolAgexListService getBolAgexListService() {
        return bolAgexListService;
    }
    /**
     * @param bolAgexListService seta o novo valor para o campo bolAgexListService
     */
    public void setBolAgexListService(BolAgexListService bolAgexListService) {
        this.bolAgexListService = bolAgexListService;
    }
    
    
}
