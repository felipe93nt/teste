/**
 * Nome: br.com.bradesco.web.npcc_garantias.view.bean.global.desenquadradas
 * 
 * Propósito: Uso exclusivo do Bradesco, contém informações a respeito do Cambio.
 * 
 * Data da Criação: 12/05/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web - Francinaldo
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.6
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.desenquadradaModal;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.IDesenquadradaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.bean.DesenquadramentoVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoStr;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 * Nome: DesenquadradasBean.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ - Francinaldo Equipe : Web
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 12/05/2016
 * 
 *      Responsavel: Equipe Web _ Ajuste para deixar no padrão hexavision.
 */
@Named(value = "desenquadradasModalBean")
@SessionScoped
public class DesenquadradasModalBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -5690879140033546460L;    

    private DesenquadramentoViewHelper viewHelper = new DesenquadramentoViewHelper();
    private DesenquadramentoVO desenquadradas = new DesenquadramentoVO();

	public final static int BTN_CONFIRMAR = 1;
    public final static int BTN_CANCELAR = 2;
    
    @Inject
    @Named("desenquadradaModalService")
    private IDesenquadradaModalService desenquadradaModalService = null;
    
    /**
     * Nome: openModal
     * 
     * Propósito: Carrega a Lista de Operações Desenquadradas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016
     * 
     *      Autor: BRQ - Francinaldo
     * 
     *      Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal() {
        getViewHelper().setBotaoAcionado(BTN_CANCELAR);
        
		if (getDesenquadradas().getProduto().isBndesPos()
		        || getDesenquadradas().getProduto().isBndesPre()) {
		    
		    // BNDES Pre e Pos deve converter valor de meses para dias
		    desenquadradas.setTdiaopercmbio(desenquadradas.getTdiaopercmbio() * 30);
		    
			// BNDES Pos e Pre envia a "Margem Agente" para o Spread
			desenquadradas.setPspreadtxcmbio(desenquadradas.getPagtefincrcmbio());
		}
		
		// Se operação com SWAP = SIM, preencher texto na justificativa
		if(!SiteUtil.isEmptyOrNull(desenquadradas.getCindcdnegocswap())
		        && desenquadradas.getCindcdnegocswap().equalsIgnoreCase(EnumSimNaoStr.SIM.getCodigo())) {

		    desenquadradas.setJustificativa("Operação com SWAP, SPREAD ALL IN = " + desenquadradas.getPtxswapcmpdo() + " % A.A.");
		} else {
		    desenquadradas.setJustificativa("");
		}
		
        desenquadradaModalService.pesquisar(desenquadradas);
    }

    /**
     * Nome: closeModal
     * 
     * Propósito: Fecha o Modal de Operações Desenquadradas
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016
     * 
     *      Autor: BRQ - Francinaldo
     * 
     *      Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {
        
        getViewHelper().setRenderModalDesenquadradas(Boolean.FALSE);
    }

    /**
     * Nome: confirmar
     * 
     * Propósito: Confirmar Operação Desenquadrada
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016
     * 
     *      Autor: BRQ - Francinaldo
     * 
     *      Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String confirmar() {
        
        if (SiteUtil.isEmptyOrNull(desenquadradas.getJustificativa())) {
            NpcFacesUtils.addInfoModalMessage("O campo justificativa é obrigatório.", EnumButtonBehavior.SUBMIT);

            return null;
        } else {
            getViewHelper().setBotaoAcionado(BTN_CONFIRMAR);

            return "/content/global/desenquadradaModal/closeModalDesenquadradas.xhtml";
        }
    }

    /**
     * @return o valor do viewHelper
     */
    public DesenquadramentoViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(DesenquadramentoViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do desenquadradas
     */
    public DesenquadramentoVO getDesenquadradas() {
        return desenquadradas;
    }

    /**
     * @param desenquadradas seta o novo valor para o campo desenquadradas
     */
    public void setDesenquadradas(DesenquadramentoVO desenquadradas) {
        this.desenquadradas = desenquadradas;
    }
}
