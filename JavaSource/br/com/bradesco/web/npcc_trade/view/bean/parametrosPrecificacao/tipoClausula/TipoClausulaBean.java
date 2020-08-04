package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.tipoClausula;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.ITipoClausulaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.tipoClausula.bean.TipoClausulaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

/**
 * 
 * Nome: TipoClausulaBean.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
@Named("tipoClausulaBean")
@SessionScoped
public class TipoClausulaBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /* Objeto utilizado nas telas de Inclusão / Alteração/ Exclusão */
    private TipoClausulaVO tipoClausulaVO = new TipoClausulaVO();

    /* Variáveis de apoio a tela */
    private TipoClausulaViewHelper viewHelper = new TipoClausulaViewHelper();

    /* Lista para montar a Grid */
    private List<TipoClausulaVO> lista = new ArrayList<TipoClausulaVO>();

    @Inject
    @Named("tipoClausulaService")
    private ITipoClausulaService tipoClausulaService;

    /**
     * 
     * Nome: iniciar
     * 
     * Propósito: Carrega dados iniciais da tela
     *
     * @param :
     * @return : String de navegação
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {

        // Recarrega página se não for um postback ou se foi marcado para recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);
            
            // reinicia campos de controle da página
            getViewHelper().setCodItemSelecionadoLista(Numeros.ZERO);
            getViewHelper().setRenderModal(Boolean.FALSE);
    
            // chama MF para carregar a lista
            setLista(tipoClausulaService.listar());
            
            // reinicia paginação
            getViewHelper().setNomeStateIdLista("NPCCIAOC");
        }
        
        return "tipoClausulaList";
    }

    /**
     * ,
     * 
     * Nome: paginar
     * 
     * Propósito: Metodo excutado pelo controle de paginação da AWB
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    public void paginar(ActionEvent event) {
        setLista(tipoClausulaService.listar());
    }

    /**
     * 
     * Nome: incluir
     * 
     * Propósito: Carrega os dados da tela de inclusão
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String incluir() {

        tipoClausulaVO = new TipoClausulaVO();

        // desabilita o modal de confirmação
        getViewHelper().setRenderModal(Boolean.FALSE);

        return "tipoClausulaIncl";
    }

    /**
     * 
     * Nome: alterar
     * 
     * Propósito: Carrega os dados da tela de alteração
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    public String alterar() {

        // desabilita o modal de confirmação
        getViewHelper().setRenderModal(Boolean.FALSE);

        // valida se foi selecionado um item na lista
        if (viewHelper.getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro para alterar", false);
            return null;
        }

        // Copia os dados do objeto selecionado na lista.
        SiteUtil.copyPropertiesObjects(lista.get(viewHelper.getCodItemSelecionadoLista()), tipoClausulaVO);

        return "tipoClausulaAlt";
    }

    /**
     * 
    	* Nome: excluir
    	* 
    	* Propósito: Valida os dados para realizar a exlusão de um registro
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 01/12/2015
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void excluir() {

        // valida se foi selecionado um item na lista
        if (viewHelper.getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro para excluir", false);
            return;
        }

        // Copia os dados do objeto selecionado na lista.
        SiteUtil.copyPropertiesObjects(lista.get(viewHelper.getCodItemSelecionadoLista()), tipoClausulaVO);

        // habilita o modal de confirmação
        getViewHelper().setRenderModal(Boolean.TRUE);
    }

    /**
     * 
     * Nome: validarForm
     * 
     * Propósito: Valida os dados da tela de inclusão e alteração e habilita o modal de confirmação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    public void validarForm(ActionEvent ae) {

        // valida campos obrigatórios
        if (!SiteUtil.validarCampos("formTipoClausula")) {
            
            // habilita o modal de confirmação
            getViewHelper().setRenderModal(Boolean.TRUE);
        }

    }

    /**
     * 
     * Nome: actionFecharModal
     * 
     * Propósito: Metodo executado ao cancelar o modal de confirmação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionFecharModal(ActionEvent ae) {
        // desabilita o modal de confirmação
        getViewHelper().setRenderModal(Boolean.FALSE);
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
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    public void actionConfirmar() {

        String result = SiteUtil.STRING_EMPTY;

        // desabilita o modal de confirmação
        getViewHelper().setRenderModal(Boolean.FALSE);

        // Se campo "Ctpoclauscmbio" preenchido então alterar se não incluir
        if (SiteUtil.isEmptyOrNull(tipoClausulaVO.getCtpoclauscmbio())) {
            result = tipoClausulaService.incluir(tipoClausulaVO);
        } else {
            result = tipoClausulaService.alterar(tipoClausulaVO);
        }
        
        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{tipoClausulaBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }
    
    
    /**
     * 
     * Nome: actionConfirmarExcluir
     * 
     * Propósito: Executa o metodo de confirmação do modal de excluir
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */

    public void actionConfirmarExcluir() {

        String result = SiteUtil.STRING_EMPTY;

        // desabilita o modal de confirmação
        getViewHelper().setRenderModal(Boolean.FALSE);
        
        //Chama o serviço para realizar a exclusão
        result = tipoClausulaService.excluir(tipoClausulaVO);
       
        setIniciarPagina(true);
        
        //Exibe a mensagem de exclusaõ e retorna para Lista
        BradescoFacesUtils.addInfoModalMessage(result, "#{tipoClausulaBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
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
        return "tipoClausulaList";
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
        SiteUtil.atualizarSelectItem(lista, selectItemRadioLista);
        return selectItemRadioLista;
    }

    /**
     * @return o valor do tipoClausulaVO
     */
    public TipoClausulaVO getTipoClausulaVO() {
        return tipoClausulaVO;
    }

    /**
     * @param tipoClausulaVO seta o novo valor para o campo tipoClausulaVO
     */
    public void setTipoClausulaVO(TipoClausulaVO tipoClausulaVO) {
        this.tipoClausulaVO = tipoClausulaVO;
    }

    /**
     * @return o valor do viewHelper
     */
    public TipoClausulaViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(TipoClausulaViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do lista
     */
    public List<TipoClausulaVO> getLista() {
        return lista;
    }

    /**
     * @param lista seta o novo valor para o campo lista
     */
    public void setLista(List<TipoClausulaVO> lista) {
        this.lista = lista;
    }

}
