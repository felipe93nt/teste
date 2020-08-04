package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.baixarbolAgex;

import java.io.Serializable;
import java.util.ArrayList;
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
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.BolAgexListService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexListVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.StatusBolAtzFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal.ClienteModalBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

/**
  * Nome: BaixarBoletoBean.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 19/07/2017
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named("baixarBoletoBean")
@SessionScoped
public class BaixarBoletoBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;
    
    private final String STATE_ID = "NPCCIATX-BAIXAR";

    private BaixarBoletoViewHelper viewHelper = new BaixarBoletoViewHelper();

    /* Objeto utilizado nas telas de Cliente */
    private ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();

    /* Objeto de entrada para a pesquisa */
    private BolAgexFiltroVO filtroVO = new BolAgexFiltroVO();
    /* Objeto de saída para a pesquisa */
    private BolAgexVO bolAgexVO = new BolAgexVO();
    /* objeto para o detalhar */
    private BolAgexListVO bolAgexListVO = new BolAgexListVO();
    /* objeto para excluir e confirmar */
    private StatusBolAtzFiltroVO filtroAtzExclVO = new StatusBolAtzFiltroVO();

    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;

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
     *      Registro de Manutenção: 20/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {

        // Recarrega página se não for um postback ou se foi marcado para
        // recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);

            setFiltroVO(new BolAgexFiltroVO());
            setViewHelper(new BaixarBoletoViewHelper());
            setBolAgexVO(new BolAgexVO());
            setClienteSelecaoVO(new ClienteSelecaoVO());
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
            getViewHelper().setComboProduto(
                    selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                            EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                            EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));
            
            getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
            getFiltroVO().setEstatus(Numeros.NUM59);
            
            this.getViewHelper().setNomeStateIdLista(STATE_ID);
        }

        return "baxEstorno";
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean validarCodigoListaRadio() {
        if (SiteUtil.isEmptyOrNull(getViewHelper().getCodlistRadio())) {
            NpcFacesUtils.addInfoModalMessage("Selecione um item", false);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteNome(AjaxBehaviorEvent e) {
        clienteSelecaoVO.setCodCpfCnpj(Numeros.UM);
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
        clienteModalBean.getViewHelper().setModalId("formBaixaEstorno\\:modalCliente");
        // clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado();
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal() {
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteCpfCnpj(AjaxBehaviorEvent e) {
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
        clienteModalBean.getViewHelper().setModalId("formTrdFinBolAgexIncl\\:modalCliente");
        // clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(getViewHelper().getCodCpfCnpjSelecionado());
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerMudaCpfCnpjCliente(AjaxBehaviorEvent e) {
        limpaCamposCliente();
    }
    
	/**
	* Nome: listenerMudaTelaStatus
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 17/07/2017
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public void listenerMudaTelaStatus(AjaxBehaviorEvent e) {
    	getFiltroVO().setEcprodtservc(null);
        setBolAgexVO(new BolAgexVO());
        setClienteSelecaoVO(new ClienteSelecaoVO());
        getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
        getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
        
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
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
     *      Registro de Manutenção: 06/10/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public void limparGrid(AjaxBehaviorEvent event) {
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
     *      Registro de Manutenção: 06/10/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public void limpar(AjaxBehaviorEvent event) {
    	setClienteSelecaoVO(new ClienteSelecaoVO());
    	filtroVO = new BolAgexFiltroVO();        
        setBolAgexVO(new BolAgexVO());
        this.clienteSelecaoVO.setCnpj(new CnpjDataType());
        this.clienteSelecaoVO.setCpf(new CpfDataType());
        this.clienteSelecaoVO.setNomeCliente(null);
        this.clienteSelecaoVO.setNomeBanco(null);
        this.clienteSelecaoVO.setCodAgencia(null);
        this.clienteSelecaoVO.setContaDv(null);      
        getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
        getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
        limparGrid(null);
    
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
            NpcFacesUtils.addInfoModalMessage("O campo Data deve ser preenchido.", false);
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean validarCpfCnpj() {
        Boolean retorno = Boolean.FALSE;
        if (getFiltroVO().getCnpj() == null && getFiltroVO().getCpf() == null) {
            NpcFacesUtils.addInfoModalMessage("O campo Cpf ou Cnpj deve ser preenchido.", false);
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisar(AjaxBehaviorEvent event) {
        if (!validarDatas()) {
            getFiltroVO().setEcunicclicmbio(getClienteSelecaoVO().getCodCliente());
            getFiltroVO().setEnbletonegoccmbioano(SiteUtil.getInt(getFiltroVO().getEnbletonegoccmbioano()));
            getFiltroVO().setDanobase(getFiltroVO().getEdanobase());
            this.getFiltroVO().setEcprodtservc(
                            this.getFiltroVO().getCprodtservc());
            
            if (filtroVO.getEstatus() == Numeros.ZERO) {
                filtroVO.setEstatus(Numeros.NUM98);
            }
            
            if (SiteUtil.isEmptyOrNull(clienteSelecaoVO.getCnpj().getCnpjCampo1())) {

                getFiltroVO().setCnpj(getFiltroVO().getCnpj());

            } else if (SiteUtil.isEmptyOrNull(clienteSelecaoVO.getCpf().getCpfCampo1())) {

                getFiltroVO().setCpf(clienteSelecaoVO.getCpf());
               
            }
            
            filtroVO.setEstatus(Numeros.NUM98);
            filtroVO.setFlagBaixEstrn(getViewHelper().getCodSelelecionarTela());
            bolAgexVO = bolAgexListService.pesquisar(filtroVO, STATE_ID);
        }
    }

    /**
     * 
     * Nome: validarFormExcluir
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
    public void validarFormBaixar(ActionEvent ae) {

        // valida campos obrigatórios
        if (!SiteUtil.validarCampos("formBaixarBoleto")) {

            getViewHelper().setRenderModalBaixar(Boolean.TRUE);
        }
    }

    /**
     * 
     * Nome: validarFormConfirmar
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
    public void validarFormEstorno(ActionEvent ae) {
        // valida campos obrigatórios
        if (!SiteUtil.validarCampos("formEstornoBoleto")) {

            getViewHelper().setRenderModalEstorno(Boolean.TRUE);
        }
    }

    /**
     * 
     * Nome: actionConfirmarEstorno
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
    public void actionConfirmarEstorno() {

        String result = SiteUtil.STRING_EMPTY;

        getViewHelper().setRenderModalEstorno(Boolean.TRUE);

        // getFiltroAtzExclVO().setEstatusbletocmbio(Numeros.NUM59);
        getFiltroAtzExclVO().setEstatusbletocmbio(Numeros.NUM60);
        getFiltroAtzExclVO().setEstatusbletoanter(getBolAgexListVO().getSstatus());

        getFiltroAtzExclVO().setEnbletonegoccmbio(getBolAgexListVO().getSnbletonegoccmbio());
        getFiltroAtzExclVO().setEsaldbletocmbio(getBolAgexListVO().getSvsdolimsensi());
        getFiltroAtzExclVO().setEvultestrnbaixa(getBolAgexListVO().getSvultestrncmbio());

        getFiltroAtzExclVO().setEtmaxcontrprodt(getBolAgexListVO().getStdiaopercmbio());
        getFiltroAtzExclVO().setEcindcdmoedautlzd(getBolAgexListVO().getScindcdeconmmoeda());

        result = bolAgexListService.excluirConfirm(getFiltroAtzExclVO());

        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{baixarBoletoBean.iniciar}",
                BradescoViewExceptionActionType.ACTION, "submit", false);
    }

    /**
     * 
     * Nome: actionConfirmar
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
    public void actionConfirmarBaixar() {
        String result = SiteUtil.STRING_EMPTY;

        getViewHelper().setRenderModalBaixar(Boolean.FALSE);
        getFiltroAtzExclVO().setEstatusbletocmbio(Numeros.NUM58); // Pendente de
                                                                  // Baixa
        getFiltroAtzExclVO().setEstatusbletoanter(getBolAgexListVO().getSstatus());

        getFiltroAtzExclVO().setEnbletonegoccmbio(getBolAgexListVO().getSnbletonegoccmbio());

        getFiltroAtzExclVO().setEsaldbletocmbio(getBolAgexListVO().getSvsdolimsensi());
        getFiltroAtzExclVO().setEvultestrnbaixa(getBolAgexListVO().getSvultbaixacmbio());

        getFiltroAtzExclVO().setEtmaxcontrprodt(getBolAgexListVO().getStdiaopercmbio());
        getFiltroAtzExclVO().setEcindcdmoedautlzd(getBolAgexListVO().getScindcdeconmmoeda());

        result = bolAgexListService.excluirConfirm(getFiltroAtzExclVO());

        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{baixarBoletoBean.iniciar}",
                BradescoViewExceptionActionType.ACTION, "submit", false);
    }

    /**
     * 
     * Nome: actionFecharModalExcluir
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
    public void actionFecharModalEstorno(ActionEvent ae) {
        getViewHelper().setRenderModalEstorno(Boolean.FALSE);
    }

    /**
     * 
     * Nome: actionFecharModalBaixar
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
    public void actionFecharModalBaixar(ActionEvent ae) {
        getViewHelper().setRenderModalBaixar(Boolean.FALSE);
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginar() {
    	 setBolAgexVO(bolAgexListService.pesquisar(filtroVO,STATE_ID));
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
     *      Registro de Manutenção: 22/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
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
     * Nome: baixar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 20/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String baixar() {
        int indice = SiteUtil.getInt(getViewHelper().getCodlistRadio());
        if (validarCodigoListaRadio()) {
            bolAgexListVO = bolAgexVO.getLista().get(indice);
            bolAgexListVO.setSvultbaixacmbio(SiteUtil.STRING_EMPTY);
            bolAgexListVO.setSvultestrncmbio(SiteUtil.STRING_EMPTY);
            bolAgexListVO.setSdescstatus(bolAgexVO.getLista().get(indice).getSdescstatus());
            return "baxBolAgex";
        }
        return "baxEstorno";
    }

    /**
     * 
     * Nome: baixarEstorno
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 20/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String baixarEstorno() {
        int indice = SiteUtil.getInt(getViewHelper().getCodlistRadio());
        if (validarCodigoListaRadio()) {
            bolAgexListVO = bolAgexVO.getLista().get(indice);
            bolAgexListVO.setSvultbaixacmbio(SiteUtil.STRING_EMPTY);
            bolAgexListVO.setSvultestrncmbio(SiteUtil.STRING_EMPTY);
            bolAgexListVO.setSdescstatus(bolAgexVO.getLista().get(indice).getSdescstatus());
            return "estBolAgex";
        }
        return "baxEstorno";
    }

	/**
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
	 * Registro  de Manutenção: 19/07/2017
	 *        - Autor: BRQ
	 *        - Responsavel: Equipe Web
	 *        - Adequação ao padrão hexavision.
	 */
    public String voltar() {
        return "baxEstorno";
    }

    /**
     * Construtor
     * 
     * @param
     */
    public BaixarBoletoBean() {
        super();
    }

    /**
     * @return o valor do viewHelper
     */
    public BaixarBoletoViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper
     *            seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(BaixarBoletoViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do clienteSelecaoVO
     */
    public ClienteSelecaoVO getClienteSelecaoVO() {
        return clienteSelecaoVO;
    }

    /**
     * @param clienteSelecaoVO
     *            seta o novo valor para o campo clienteSelecaoVO
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
     * @param filtroVO
     *            seta o novo valor para o campo filtroVO
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
     * @param bolAgexVO
     *            seta o novo valor para o campo bolAgexVO
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
     * @param bolAgexListVO
     *            seta o novo valor para o campo bolAgexListVO
     */
    public void setBolAgexListVO(BolAgexListVO bolAgexListVO) {
        this.bolAgexListVO = bolAgexListVO;
    }

    /**
     * @return o valor do filtroAtzExclVO
     */
    public StatusBolAtzFiltroVO getFiltroAtzExclVO() {
        return filtroAtzExclVO;
    }

    /**
     * @param filtroAtzExclVO
     *            seta o novo valor para o campo filtroAtzExclVO
     */
    public void setFiltroAtzExclVO(StatusBolAtzFiltroVO filtroAtzExclVO) {
        this.filtroAtzExclVO = filtroAtzExclVO;
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
     * @return o valor do clienteModalBean
     */
    public ClienteModalBean getClienteModalBean() {
        return clienteModalBean;
    }

    /**
     * @param clienteModalBean
     *            seta o novo valor para o campo clienteModalBean
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
     * @param bolAgexListService
     *            seta o novo valor para o campo bolAgexListService
     */
    public void setBolAgexListService(BolAgexListService bolAgexListService) {
        this.bolAgexListService = bolAgexListService;
    }

}
