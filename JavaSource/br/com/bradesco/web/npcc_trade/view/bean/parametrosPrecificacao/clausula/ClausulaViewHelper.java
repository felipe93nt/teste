/**
 *
 * Nome: ClausulaViewHelper.java
 * Propósito: <p>Classe de auxílio para dados na tela. </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 30/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.clausula;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

/**
 *
 * Nome: ClausulaViewHelper.java Propósito:
 * <p>
 * Classe de auxílio para dados na tela.
 * </p>
 *
 * @author : BRQ <BR>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 30/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class ClausulaViewHelper {

    /**
     * Indice do radio selecionado na grid
     */
    private Integer codItemSelecionadoLista = Numeros.UM;

    /**
     * Variavel utilizada para definir o state id da lista de log
     */
    private String nomeStateIdLista = null;

    /**
     * Variavel utilizada para filtrar resultados da pesquisa
     */
    private Integer filtroTipoClausula = Numeros.ZERO;

    /**
     * 
     */
    private boolean renderFacets = Boolean.FALSE;
    
    /**
     * 
     */
    private List<SelectItem> comboTipoClausulaItens = new ArrayList<SelectItem>();

    /**
     * Construtor
     * 
     * @param
     */
    public ClausulaViewHelper() {
        super();
    }

    /**
     * Variável de controle do modal de confirmação
     */
    Boolean renderModal = Boolean.FALSE;

    /**
     * @return o valor do codItemSelecionadoLista
     */
    public Integer getCodItemSelecionadoLista() {
        return codItemSelecionadoLista;
    }

    /**
     * @param codItemSelecionadoLista
     *            seta o novo valor para o campo codItemSelecionadoLista
     */
    public void setCodItemSelecionadoLista(Integer codItemSelecionadoLista) {
        this.codItemSelecionadoLista = codItemSelecionadoLista;
    }

    /**
     * @return o valor do renderModal
     */
    public Boolean getRenderModal() {
        return renderModal;
    }

    /**
     * @param renderModal
     *            seta o novo valor para o campo renderModal
     */
    public void setRenderModal(Boolean renderModal) {
        this.renderModal = renderModal;
    }

    /**
     * @return o valor do nomeStateIdLista
     */
    public String getNomeStateIdLista() {
        return nomeStateIdLista;
    }

    /**
     * @param nomeStateIdLista
     *            seta o novo valor para o campo nomeStateIdLista
     */
    public void setNomeStateIdLista(String nomeStateIdLista) {
        this.nomeStateIdLista = nomeStateIdLista;
    }

    /**
     * @return o valor do renderFacets
     */
    public boolean isRenderFacets() {
        return renderFacets;
    }

    /**
     * @param renderFacets
     *            seta o novo valor para o campo renderFacets
     */
    public void setRenderFacets(boolean renderFacets) {
        this.renderFacets = renderFacets;
    }

    /**
     * @return o valor do filtroTipoClausula
     */
    public Integer getFiltroTipoClausula() {
        return filtroTipoClausula;
    }

    /**
     * @param filtroTipoClausula
     *            seta o novo valor para o campo filtroTipoClausula
     */
    public void setFiltroTipoClausula(Integer filtroTipoClausula) {
        this.filtroTipoClausula = filtroTipoClausula;
    }

    /**
     * @return o valor do comboTipoClausulaItens
     */
    public List<SelectItem> getComboTipoClausulaItens() {
        return comboTipoClausulaItens;
    }

    /**
     * @param comboTipoClausulaItens seta o novo valor para o campo comboTipoClausulaItens
     */
    public void setComboTipoClausulaItens(List<SelectItem> comboTipoClausulaItens) {
        this.comboTipoClausulaItens = comboTipoClausulaItens;
    }

}
