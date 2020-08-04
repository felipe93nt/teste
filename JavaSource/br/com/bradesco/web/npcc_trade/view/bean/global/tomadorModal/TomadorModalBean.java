package br.com.bradesco.web.npcc_trade.view.bean.global.tomadorModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.tomadorModal.ITomadorModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
  * Nome: TomadorModalBean.java
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
  * Registro  de Manutenção: 29/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named(value = "tomadorModalBean")
@SessionScoped
public class TomadorModalBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 3169166732668927612L;

    private TomadorModalViewHelper viewHelper = new TomadorModalViewHelper();

    private TradeFinNegocListasVO precificaVO = new TradeFinNegocListasVO();

    private List<TradeFinNegocListasVO> listaTomador = new ArrayList<TradeFinNegocListasVO>();
    
    private TradeFinNegocListasVO itemSelecionado = new TradeFinNegocListasVO();

    @Inject
    @Named("tomadorModalService")
    private ITomadorModalService tomadorModalService;
    
 
    /**
     * Nome: pesquisarTomadorPorNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisarTomadorPorNome() {
        getListaTomador().clear();
        
        if (viewHelper.getNomeTomador() == null || viewHelper.getNomeTomador().length() <= 0) {
            NpcFacesUtils.addInfoModalMessage("Preencha o campo Tomador.", false);
            return;
        }
        
        getViewHelper().setNomeStateIdListaSelTomador("NPCCIAI0");
        getViewHelper().setItemSelecListaTomador(null);
        setListaTomador(tomadorModalService.getTomadorModalList(viewHelper.getNomeTomador()));
        
        // habilita modal do Tomador
        getViewHelper().setRenderModal(Boolean.TRUE);

    }

    /**
     * Nome: getSelectItemRadioListaTomador
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioListaTomador() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();

        SiteUtil.atualizarSelectItem(getListaTomador(), selectItemRadioLista);

        return selectItemRadioLista;
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
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {
        
        // ao fechar o modal limpa a lista
        setPrecificaVO(null);
        setListaTomador(new ArrayList<TradeFinNegocListasVO>());
        getViewHelper().setRenderModal(Boolean.FALSE);
     
    }

    /**
     * Nome: selecionarTomador
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String selecionarTomador() {

        // valida se foi selecionado um item na lista
        if (viewHelper.getItemSelecListaTomador() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return null;
        }
        
        // recupera o item seleciona na lista
        TradeFinNegocListasVO itemSelecionado = listaTomador.get(getViewHelper().getItemSelecListaTomador());
        
        

        // Salva os dados do Tomador para uso nos outros serviços
        precificaVO.setCunicpssoacmbiot(itemSelecionado.getCunicpssoacmbiot());
        precificaVO.setNcunicpssoacmbiot(itemSelecionado.getNcunicpssoacmbiot());
        precificaVO.setCdclub(itemSelecionado.getCdclub());
        precificaVO.setCdcpfcnpj(itemSelecionado.getCdcpfcnpj());
        precificaVO.setCdctrlcpfcnpj(itemSelecionado.getCdctrlcpfcnpj());
        precificaVO.setCdfilial(itemSelecionado.getCdfilial());
       
        return "/content/global/tomadorModal/modalTomadorListClose.xhtml";
    }

    /**
     * Nome: paginarTomador
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 02/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginarTomador(ActionEvent event) {

        getViewHelper().setNomeStateIdListaSelTomador("NPCCIAI0");

        setListaTomador(tomadorModalService.getTomadorModalList(viewHelper.getNomeTomador()));
    }

 
    /**
     * @return o valor do viewHelper
     */
    public TomadorModalViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(TomadorModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do listaTomador
     */
    public List<TradeFinNegocListasVO> getListaTomador() {
        return listaTomador;
    }

    /**
     * @param listaTomador seta o novo valor para o campo listaTomador
     */
    public void setListaTomador(List<TradeFinNegocListasVO> listaTomador) {
        this.listaTomador = listaTomador;
    }

    /**
     * @return o valor do tomadorModalService
     */
    public ITomadorModalService getTomadorModalService() {
        return tomadorModalService;
    }

    /**
     * @param tomadorModalService seta o novo valor para o campo tomadorModalService
     */
    public void setTomadorModalService(ITomadorModalService tomadorModalService) {
        this.tomadorModalService = tomadorModalService;
    }

    /**
     * @return o valor do precificaVO
     */
    public TradeFinNegocListasVO getPrecificaVO() {
        return precificaVO;
    }

    /**
     * @param precificaVO seta o novo valor para o campo precificaVO
     */
    public void setPrecificaVO(TradeFinNegocListasVO precificaVO) {
        this.precificaVO = precificaVO;
    }

    /**
     * @return o valor do itemSelecionado
     */
    public TradeFinNegocListasVO getItemSelecionado() {
        return itemSelecionado;
    }

    /**
     * @param itemSelecionado seta o novo valor para o campo itemSelecionado
     */
    public void setItemSelecionado(TradeFinNegocListasVO itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

}
