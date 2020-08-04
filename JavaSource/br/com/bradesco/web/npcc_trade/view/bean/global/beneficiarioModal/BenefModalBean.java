package br.com.bradesco.web.npcc_trade.view.bean.global.beneficiarioModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.util.Numeros;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.beneficiarioModal.impl.BenefModalServiceImpl;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TrdFinNegMercadoriaVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTradeFinance;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
  * Nome: BenefModalBean.java
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
  * Registro  de Manutenção: 20/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named(value = "benefModalBean")
@SessionScoped
public class BenefModalBean implements Serializable {

	/** Variavel do tipo long. */
	private static final long serialVersionUID = 1163714343508597860L;
	
	private BenefModalViewHelper viewHelper = new BenefModalViewHelper();
	
	/** Variavel de Entrada do Serviço **/
	private TrdFinNegMercadoriaVO beneficiario = new TrdFinNegMercadoriaVO();
	
	/** Variavel que retorna os parâmetros do TrdFinNegMercadoriaVO( Entrada do Serviço) **/
	private List<TradeFinNegocListasVO> benefSelecionadoVO = new ArrayList<TradeFinNegocListasVO>();
	
	@Inject
	@Named("benefModalService")
	protected BenefModalServiceImpl benefModalService;
	
	
	/**
	* Nome: selecionar
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 20/07/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public String selecionar() {

        // valida selecionado
        if (getBenefSelecionadoVO().isEmpty() || getViewHelper().getItemSelecListaBeneficiario() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um registro.", false);
            return null;
        }

        // recupera o item seleciona na lista de banqueiros
        TradeFinNegocListasVO itemSelecionado = getBenefSelecionadoVO().get(getViewHelper().getItemSelecListaBeneficiario());
        
        // Apresenta dados da lista na tela
        beneficiario.setIpssoacmbio(itemSelecionado.getIpssoacmbio());
        beneficiario.setIredzdpssoacmbio(itemSelecionado.getIredzdpssoacmbio());
        beneficiario.setCunicpssoamcado(itemSelecionado.getCunicpssoacmbio());
        beneficiario.setCunicpssoacmbio(itemSelecionado.getCunicpssoacmbio());
        beneficiario.setIciddeender(itemSelecionado.getIciddeender());
        beneficiario.setIpaiscoplt(itemSelecionado.getIpaiscoplt());
        
 
        return "/content/global/beneficiarioModal/beneficiarioModalClose.xhtml";
    }


    /**
     * Nome: openModal
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 20/07/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void openModal() {
        
        // Limpa lista.
        setBenefSelecionadoVO(new ArrayList<TradeFinNegocListasVO>());

        if (getBeneficiario().getIpssoacmbio().length() <= 0) {
            NpcFacesUtils.addInfoModalMessage("Preencha o campo " + getViewHelper().getNomeCampo()  +" .", false);
            return;
        }
        
        getBeneficiario().setTipoPesquisaBeneficiario(EnumTradeFinance.PESQUISA_BENEFICIARIO_POR_NOME.getCodigo());
        setBenefSelecionadoVO(benefModalService.getListaBeneficiario(getBeneficiario()));

        getViewHelper().setItemSelecListaBeneficiario(Numeros.ZERO);
       
        // habilita modal do Beneficiario / Afiancador
        getViewHelper().setRenderModalBeneficiario(Boolean.TRUE);
    }


    /**
     * Nome: closeModalBeneficiario
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
    public void closeModalBeneficiario(ActionEvent event) {

        // ao fechar o modal limpa a lista
        setBenefSelecionadoVO(new ArrayList<TradeFinNegocListasVO>());

        // desabilita modal
        getViewHelper().setRenderModalBeneficiario(Boolean.FALSE);
    }

    /**
     * Nome: getSelectItemRadioListaBeneficiario
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
    public List<SelectItem> getSelectItemRadioListaBeneficiario() {
        List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();

        SiteUtil.atualizarSelectItem(getBenefSelecionadoVO(), selectItemRadioLista);

        return selectItemRadioLista;
    }

    /**
     * Nome: paginarBeneficiario
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
    public void paginarBeneficiario(ActionEvent event) {
        setBenefSelecionadoVO(benefModalService.getListaBeneficiario(getBeneficiario()));
    }
    
    /**
     * @return o valor do viewHelper
     */
    public BenefModalViewHelper getViewHelper() {
        return viewHelper;
    }


    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(BenefModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }
   
    /**
     * @return o valor do benefModalService
     */
    public BenefModalServiceImpl getBenefModalService() {
        return benefModalService;
    }

    /**
     * @param benefModalService seta o novo valor para o campo benefModalService
     */
    public void setBenefModalService(BenefModalServiceImpl benefModalService) {
        this.benefModalService = benefModalService;
    }

    /**
     * @return o valor do benefSelecionadoVO
     */
    public List<TradeFinNegocListasVO> getBenefSelecionadoVO() {
        return benefSelecionadoVO;
    }


    /**
     * @param benefSelecionadoVO seta o novo valor para o campo benefSelecionadoVO
     */
    public void setBenefSelecionadoVO(List<TradeFinNegocListasVO> benefSelecionadoVO) {
        this.benefSelecionadoVO = benefSelecionadoVO;
    }


    /**
     * @return o valor do beneficiario
     */
    public TrdFinNegMercadoriaVO getBeneficiario() {
        return beneficiario;
    }


    /**
     * @param beneficiario seta o novo valor para o campo beneficiario
     */
    public void setBeneficiario(TrdFinNegMercadoriaVO beneficiario) {
        this.beneficiario = beneficiario;
    }
}
