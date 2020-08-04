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
 * Prop�sito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padr�o
 *      hexavision.
 */
@Named("tipoClausulaBean")
@SessionScoped
public class TipoClausulaBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /* Objeto utilizado nas telas de Inclus�o / Altera��o/ Exclus�o */
    private TipoClausulaVO tipoClausulaVO = new TipoClausulaVO();

    /* Vari�veis de apoio a tela */
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
     * Prop�sito: Carrega dados iniciais da tela
     *
     * @param :
     * @return : String de navega��o
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String iniciar() {

        // Recarrega p�gina se n�o for um postback ou se foi marcado para recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);
            
            // reinicia campos de controle da p�gina
            getViewHelper().setCodItemSelecionadoLista(Numeros.ZERO);
            getViewHelper().setRenderModal(Boolean.FALSE);
    
            // chama MF para carregar a lista
            setLista(tipoClausulaService.listar());
            
            // reinicia pagina��o
            getViewHelper().setNomeStateIdLista("NPCCIAOC");
        }
        
        return "tipoClausulaList";
    }

    /**
     * ,
     * 
     * Nome: paginar
     * 
     * Prop�sito: Metodo excutado pelo controle de pagina��o da AWB
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public void paginar(ActionEvent event) {
        setLista(tipoClausulaService.listar());
    }

    /**
     * 
     * Nome: incluir
     * 
     * Prop�sito: Carrega os dados da tela de inclus�o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String incluir() {

        tipoClausulaVO = new TipoClausulaVO();

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);

        return "tipoClausulaIncl";
    }

    /**
     * 
     * Nome: alterar
     * 
     * Prop�sito: Carrega os dados da tela de altera��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public String alterar() {

        // desabilita o modal de confirma��o
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
    	* Prop�sito: Valida os dados para realizar a exlus�o de um registro
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manuten��o: 01/12/2015
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequa��o ao padr�o hexavision.
     */
    public void excluir() {

        // valida se foi selecionado um item na lista
        if (viewHelper.getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro para excluir", false);
            return;
        }

        // Copia os dados do objeto selecionado na lista.
        SiteUtil.copyPropertiesObjects(lista.get(viewHelper.getCodItemSelecionadoLista()), tipoClausulaVO);

        // habilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.TRUE);
    }

    /**
     * 
     * Nome: validarForm
     * 
     * Prop�sito: Valida os dados da tela de inclus�o e altera��o e habilita o modal de confirma��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public void validarForm(ActionEvent ae) {

        // valida campos obrigat�rios
        if (!SiteUtil.validarCampos("formTipoClausula")) {
            
            // habilita o modal de confirma��o
            getViewHelper().setRenderModal(Boolean.TRUE);
        }

    }

    /**
     * 
     * Nome: actionFecharModal
     * 
     * Prop�sito: Metodo executado ao cancelar o modal de confirma��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void actionFecharModal(ActionEvent ae) {
        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);
    }

    /**
     * 
     * Nome: actionConfirmar
     * 
     * Prop�sito: Executa o metodo de confirma��o da inclus�o ou altera��o
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public void actionConfirmar() {

        String result = SiteUtil.STRING_EMPTY;

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);

        // Se campo "Ctpoclauscmbio" preenchido ent�o alterar se n�o incluir
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
     * Prop�sito: Executa o metodo de confirma��o do modal de excluir
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public void actionConfirmarExcluir() {

        String result = SiteUtil.STRING_EMPTY;

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);
        
        //Chama o servi�o para realizar a exclus�o
        result = tipoClausulaService.excluir(tipoClausulaVO);
       
        setIniciarPagina(true);
        
        //Exibe a mensagem de exclusa� e retorna para Lista
        BradescoFacesUtils.addInfoModalMessage(result, "#{tipoClausulaBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }


    /**
     * 
     * Nome: actionVoltar
     * 
     * Prop�sito: A��o executada pelo bot�o voltar
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public String actionVoltar() {
        return "tipoClausulaList";
    }

    /**
     * 
     * Nome: getSelectItemRadioLista
     * 
     * Prop�sito: Monta a lista de SelectItem utilizada para montar os radio da lista
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
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
