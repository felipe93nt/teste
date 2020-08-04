/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean
 * Prop�sito: Classe comum para a funcionalidade
 * Data da Cria��o: 30/11/2015
 *
 * @author thiagoito / BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Par�metros de Compila��o: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.clausula;

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
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.IClausulaService;
import br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.clausula.bean.ClausulaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

/**
 *
 * Nome: ClausulaBean 
 * 
 * Prop�sito: Bean para a funcinalidade <br/>
 *
 * Data: 30/11/2015 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
@Named("clausulaBean")
@SessionScoped
public class ClausulaBean extends BaseBean implements Serializable {

    /**
     * Atributes
     */
    private static final long serialVersionUID = 1L;

    /* Objeto utilizado nas telas de Inclus�o / Altera��o / Detalhe */
    private ClausulaVO clausulaVO = new ClausulaVO();

    /* Vari�veis de apoio a tela */
    private ClausulaViewHelper viewHelper = new ClausulaViewHelper();

    /* Lista para montar a Grid */
    private List<ClausulaVO> lista = new ArrayList<ClausulaVO>();
    
    @Inject
    @Named("clausulaService")
    private IClausulaService clausulaService;
    
    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;
    

    /**
     * Construtor
     * 
     * @param
     */
    public ClausulaBean() {
        super();
    }

    /**
     * 
     * Nome: iniciar
     * 
     * Prop�sito: Iniciar dados da tela
     * 
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String iniciar() {

        // Recarrega p�gina se n�o for um postback ou se foi marcado para recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);
            
            getViewHelper().setCodItemSelecionadoLista(Numeros.ZERO);
            getViewHelper().setRenderModal(Boolean.FALSE);
    
            setLista(new ArrayList<ClausulaVO>());
            getViewHelper().setNomeStateIdLista("NPCCIAOI");
            
            // Carrega combo
            getViewHelper().setComboTipoClausulaItens(selectItemBean.getTipoClausula());
            getViewHelper().setFiltroTipoClausula(Numeros.ZERO);

        }
        
        return "clausulaList";
    }
    
    /**
     * Nome: pesquisar
     * 
     * Prop�sito: Verifica campos obrigat�rios e realiza pesquisa atrav�s do formul�rio preenchido
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void pesquisar() {
        // valida campos obrigat�rios
        if (!SiteUtil.validarCampos("formClausula")) {

            // limpar lista
            limparClausulas();
            
            // carrega dados da lista
            this.setLista(clausulaService.listar(this.getViewHelper().getFiltroTipoClausula()));

            // se lista vazia exibe mensagem de retorno do mainframe
            if (getLista().isEmpty()) {
                BradescoFacesUtils.addInfoModalMessage(clausulaService.getMsgRetorno(), false);
            }
        }
    }

    /**
     * 
     * Nome: limparClausulas
     * 
     * Prop�sito: Limpa lista de clausulas para nova pesquisa
     * 
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    private void limparClausulas() {
    	this.setLista(new ArrayList<ClausulaVO>());
	}

	/**
     * 
     * Nome: paginar
     * 
     * Prop�sito: Retornar os dados conforme pagina��o
     * 
     * @param ActionEvent
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void paginar(ActionEvent event) {
        setLista(clausulaService.listar(this.getViewHelper().getFiltroTipoClausula()));
    }

    /**
     * 
     * Nome: incluir
     * 
     * Prop�sito: Carrega tela de inclus�o
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String incluir() {

    	clausulaVO = new ClausulaVO();
        getViewHelper().setRenderModal(Boolean.FALSE);

        return "clausulaIncl";
    }

    /**
     * 
     * Nome: alterar
     * 
     * Prop�sito: Carrega dados da tela de altera��o
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String alterar() {

        getViewHelper().setRenderModal(Boolean.FALSE);

        // valida se foi selecionado um item na lista
        if (viewHelper.getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro para alterar", false);
            return null;
        }
        
        // recupera objeto selecionado na lista
        ClausulaVO obj = lista.get(getViewHelper().getCodItemSelecionadoLista());
        
        // carrega detalhes da clausula
        clausulaVO = clausulaService.detalhar(obj.getCclauscontrcmbio());
        
        return "clausulaAlt";
    }

    /**
     * 
     * Nome: detalhar
     * 
     * Prop�sito: Carrega dados da tela de detalhe
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String detalhar() {

        if (viewHelper.getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro para detalhar", false);
            return null;
        }
        
        // recupera objeto selecionado na lista
        ClausulaVO obj = lista.get(getViewHelper().getCodItemSelecionadoLista());
        
        // carrega detalhes da clausula
        clausulaVO = clausulaService.detalhar(obj.getCclauscontrcmbio());

        return "clausulaDet";
    }

    /**
     * 
    	* Nome: excluir
    	* 
    	* Prop�sito: Verificar se foi selecionado um registro e excluir
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

        // recupera objeto selecionado na lista
        ClausulaVO obj = lista.get(getViewHelper().getCodItemSelecionadoLista());
        
        // carrega detalhes da clausula
        clausulaVO = clausulaService.detalhar(obj.getCclauscontrcmbio());

        // habilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.TRUE);
    }
    
    /**
     * 
     * Nome: duplicar
     * 
     * Prop�sito: Copia os dados da tela e preenche na tela de inclusao
     *
     * @return : String de navega��o
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 02/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String duplicar() {

        getViewHelper().setRenderModal(Boolean.FALSE);

        if (viewHelper.getCodItemSelecionadoLista() == null) {
            NpcFacesUtils.addInfoModalMessage("Selecione um Registro para duplicar", false);
            return null;
        }
        
       
        // recupera objeto selecionado na lista
        ClausulaVO obj = lista.get(getViewHelper().getCodItemSelecionadoLista());
        
        // carrega detalhes da clausula
        clausulaVO = clausulaService.detalhar(obj.getCclauscontrcmbio());
        
        // Limpa o Id da Cl�usula para ser uma nova inclus�o
        clausulaVO.setCclauscontrcmbio(null);
        
        return "clausulaIncl";
    }
    
    /**
     * 
     * Nome: validarForm
     * 
     * Prop�sito: A��o que executa a valida��o do formul�rio e abre o modal de confirma��o das telas de inclus�o e
     * altera��o
     * 
     * @return : Navega��o por mensagem
     * 
     * @throws : NpccServiceBusinessException
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void validarForm(ActionEvent ae) {

        // valida campos obrigat�rios
        if (!SiteUtil.validarCampos("formClausula")) {
            
            getViewHelper().setRenderModal(Boolean.TRUE);
        }

    }

    /**
     * 
     * Nome: actionFecharModal
     * 
     * Prop�sito: A��o do bot�o fechar do modal das telas de inclus�o e altera��o
     * 
     * @see : Referencias externas.
     * 
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void actionFecharModal(ActionEvent ae) {
        getViewHelper().setRenderModal(Boolean.FALSE);
    }

    /**
     * 
     * Nome: actionConfirmar
     * 
     * Prop�sito: A��o exucuta pelo bot�o confirmar das telas de inclus�o e altera��o
     *
     * @return : Navega��o por mensagem
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public void actionConfirmar() {

        String result = SiteUtil.STRING_EMPTY;
        getViewHelper().setRenderModal(Boolean.FALSE);

        if (SiteUtil.isEmptyOrNull(clausulaVO.getCclauscontrcmbio())) {
            result = clausulaService.incluir(clausulaVO);

        } else {
            result = clausulaService.alterar(clausulaVO);
        }
        
        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{clausulaBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }
    
    /**
     * 
     * Nome: actionConfirmarExcluir
     * 
     * Prop�sito: Executa o metodo de confirma��o para excluir item
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 01/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */

    public void actionConfirmarExcluir() {

        String result = SiteUtil.STRING_EMPTY;

        // desabilita o modal de confirma��o
        getViewHelper().setRenderModal(Boolean.FALSE);
        
        //Chama o servi�o para realizar a exclus�o
        result = clausulaService.excluir(clausulaVO);
       
        setIniciarPagina(true);
        
        //Exibe a mensagem de exclusa� e retorna para Lista
        BradescoFacesUtils.addInfoModalMessage(result, "#{clausulaBean.iniciar}",
                        BradescoViewExceptionActionType.ACTION, "submit", false);
    }

    /**
     * 
     * Nome: actionVoltar
     * 
     * Prop�sito: A��o exucuta pelo bot�o voltar das telas de inclur, alterar e detalhar
     *
     * @return : String de navega��o
     *
     * @throws : NpccServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 30/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequa��o ao padr�o hexavision.
     */
    public String actionVoltar() {
        return "clausulaList";
    }

    /**
     * 
     * Nome: getSelectItemRadioLista
     * 
     * Prop�sito: Retorna a lista de select item para a lista
     *
     *
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
     * @return o valor do lista
     */
    public List<ClausulaVO> getLista() {
        return lista;
    }
 

    /**
     * @param list seta o novo valor para o campo lista
     */
    public void setLista(List<ClausulaVO> list) {
        this.lista = list;
    }

    /**
     * @return o valor do formaLiquidacaoVO
     */
    public ClausulaVO getClausulaVO() {
        return clausulaVO;
    }

    /**
     * @param formaLiquidacaoVO seta o novo valor para o campo formaLiquidacaoVO
     */
    public void setClausulaVO(ClausulaVO clausulaVO) {
        this.clausulaVO = clausulaVO;
    }

    /**
     * @return o valor do viewHelper
     */
    public ClausulaViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(ClausulaViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }
    
    /**
     * @return o valor do selectItemBean
     */
    public SelectItemBean getSelectItemBean() {
        return selectItemBean;
    }

    /**
     * @param selectItemBean seta o novo valor para o campo selectItemBean
     */
    public void setSelectItemBean(SelectItemBean selectItemBean) {
        this.selectItemBean = selectItemBean;
    }

}
