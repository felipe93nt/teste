package br.com.bradesco.web.npcc_trade.view.bean.global.boletoModal;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean.DadosBoletoVO;

/**
 *   * Nome: BoletoModalBean.java
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
  * Registro  de Manutenção: 20/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
@Named(value = "boletoModalBean")
@SessionScoped
public class BoletoModalBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /** Variavel de alxilio a tela */
    private BoletoModalViewHelper viewHelper = new BoletoModalViewHelper();
    
    private DadosBoletoVO dadosBoleto = null;

    /**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa de nome ou login do usuario
     *
     * @param : tipoPesquisa
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal() {
    	    
        BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("dadosBoleto", dadosBoleto);
        
        // habilita modal do usuario
        viewHelper.setRenderModal(Boolean.TRUE);
        
    }

    /**
     * 
     * Nome: selecionar
     * 
     * Propósito: Obter o usuario selecionado no modal, o valor é passado por
     * referência
     *
     * @return : Tela que fecha o modal
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String selecionar() {

        return "/content/global/boletoModal/closeModalBoleto.xhtml";
    }

    /**
     * Nome: closeModal
     * 
     * Propósito: Fecha modal usuario
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {

        // desabilita modal
        viewHelper.setRenderModal(Boolean.FALSE);
        
    }

    /**
     * @return o valor do viewHelper
     */
    public BoletoModalViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(BoletoModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do dadosBoleto
     */
    public DadosBoletoVO getDadosBoleto() {
        return dadosBoleto;
    }

    /**
     * @param dadosBoleto seta o novo valor para o campo dadosBoleto
     */
    public void setDadosBoleto(DadosBoletoVO dadosBoleto) {
        this.dadosBoleto = dadosBoleto;
    }

}