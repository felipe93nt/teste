package br.com.bradesco.web.npcc_trade.view.bean.global.mercadoriaModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.util.Numeros;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.mercadoriaModal.impl.MercadoriaModalServiceImpl;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

@Named(value = "mercadoriaModalBean")
@SessionScoped
public class MercadoriaModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1163714343508597860L;
	
	private MercadoriaModalViewHelper viewHelper = new MercadoriaModalViewHelper();
	private TrdFinNegMercadoriaVO mercadoriaVO = new TrdFinNegMercadoriaVO();
	
	private List<TradeFinNegocListasVO> listaSelMercadoria = new ArrayList<TradeFinNegocListasVO>();
	
	@Inject
	@Named("mercadoriaModalService")
	protected MercadoriaModalServiceImpl mercadoriaModalService;
	
    /**
     * Nome: listenerPesquisarMercadoriaPorNome
     * 
     * Propósito: Metodo para abrir o modal de pesquisa de garantias
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisarMercadoriaPorNome() {

        if (getMercadoriaVO().getRmcadoopercmbio().length() <= 0) {
            NpcFacesUtils.addInfoModalMessage("Preencha o campo Mercadoria.", false);
            return;
        }
        setListaSelMercadoria(mercadoriaModalService.getMercadoriasModalList(getMercadoriaVO()));
        getViewHelper().setItemSelecListaMercadoria(Numeros.ZERO);
        getViewHelper().setRenderModalMercadoria(Boolean.TRUE);

    }

    /**
     * Nome: selecionarMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String selecionarMercadoria() {

        // valida se foi selecionado um item na lista
        if (getViewHelper().getItemSelecListaMercadoria() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            return null;
        }

        // Apresenta dados da lista na tela
        getMercadoriaVO().setRmcadoopercmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
                .getRmcadoopercmbio());

        // Salva os dados do Mercadoria para uso nos outros serviços

        getMercadoriaVO().setCmcadoopercmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
                .getCmcadoopercmbio());
        getMercadoriaVO().setNtpositcmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
                .getNtpositcmbio());
        getMercadoriaVO().setCindcdlicenmcado(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
                .getCindcdlicenmcado());
        getMercadoriaVO().setCmcadorestcmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
                .getCmcadorestcmbio());
        getMercadoriaVO().setCunicpssoacmbio(getListaSelMercadoria().get(getViewHelper().getItemSelecListaMercadoria())
                .getCunicpssoacmbio());

        getViewHelper().setRenderModalMercadoria(Boolean.FALSE);
        
        return "/content/global/mercadoriaModal/mercadoriaModalClose.xhtml";
    }

    /**
     * Nome: closeModalMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModalMercadoria(ActionEvent event) {

        // ao fechar o modal limpa a lista
        setListaSelMercadoria(new ArrayList<TradeFinNegocListasVO>());

        // desabilita modal
        getViewHelper().setRenderModalMercadoria(Boolean.FALSE);
    }

    /**
     * Nome: getSelectItemRadioListaMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioListaMercadoria() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();

        SiteUtil.atualizarSelectItem(getListaSelMercadoria(), selectItemRadioLista);

        return selectItemRadioLista;
    }

    /**
     * Nome: paginarMercadoria
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 29/03/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginarMercadoria(ActionEvent event) {
        setListaSelMercadoria(mercadoriaModalService.getMercadoriasModalList(getMercadoriaVO()));
    }

	public TrdFinNegMercadoriaVO getMercadoriaVO() {
		return mercadoriaVO;
	}

	public void setMercadoriaVO(TrdFinNegMercadoriaVO mercadoriaVO) {
		this.mercadoriaVO = mercadoriaVO;
	}

	public MercadoriaModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(MercadoriaModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public List<TradeFinNegocListasVO> getListaSelMercadoria() {
		return listaSelMercadoria;
	}

	public void setListaSelMercadoria(List<TradeFinNegocListasVO> listaSelMercadoria) {
		this.listaSelMercadoria = listaSelMercadoria;
	}
	
    
}
