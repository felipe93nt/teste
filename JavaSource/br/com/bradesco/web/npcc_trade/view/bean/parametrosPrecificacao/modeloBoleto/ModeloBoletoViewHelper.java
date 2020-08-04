/**
 *
 * Nome: FormaLiquidacaoViewHelper.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 14/07/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.modeloBoleto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoClausulaVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;


/**
 *
 * Nome: FormaLiquidacaoViewHelper.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ <BR>
 *         Equipe : Web <BR>
 * @version: 1.6 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 14/07/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class ModeloBoletoViewHelper {

    /**
     * Indice do radio selecionado na grid
     */
    private Integer codItemSelecionadoLista = null;

    /**
     * Variavel utilizada para definier o state id da lista de log
     */
    private String nomeStateIdLista = null;
    /**
     * Variavel utilizada para definier o valor do produto
     */
    private Integer filtroProduto = Numeros.ZERO;
    /**
     * Variavel utilizada para definier o valor da clausula
     */
    private Integer filtroClausula = Numeros.ZERO;
    
    /**
     * Variavel utilizada para definier o combo de tipo de clausula lado direito
     */
    private List<ComboTipoClausulaVO> listaDireita = new ArrayList<ComboTipoClausulaVO>();

    /**
     * Variavel utilizada para definier o combo de tipo de clausula lado esquerdo
     */
    private List<ComboTipoClausulaVO> listaEsquerda = new ArrayList<ComboTipoClausulaVO>();
    
    /**
     * Variavel utilizada para definier o combo  de clausula lado direito
     */
    private List<ComboClausulaVO> listaDireitaClausula = new ArrayList<ComboClausulaVO>();
    
    /**
     * Variavel utilizada para definier o combo  de clausula lado direito
     */
    private List<ComboClausulaVO> listaEsquerdaClausula = new ArrayList<ComboClausulaVO>();
    
    /**
     * Variavel utilizada para definier clausulas disponiveis
     */
    private Map<Integer, List<ComboClausulaVO>> disponiveis = new HashMap<Integer, List<ComboClausulaVO>>();
    
    /**
     * Variavel utilizada para definier clausulas inseridas 
     */
    private Map<Integer, List<ComboClausulaVO>> inseridas = new HashMap<Integer, List<ComboClausulaVO>>();
    
    /**
     * Variavel utilizada para definier combo de tipo clausulas 
     */
    private List<SelectItem> comboTipoClausula = new ArrayList<SelectItem>();

    /**
     * Variavel utilizada para definier comboProdutosItens 
     */
    private List<SelectItem> comboProdutoItens = new ArrayList<SelectItem>();

    
    public List<SelectItem> getComboTipoClausula() {
        return comboTipoClausula;
    }

    public void setComboTipoClausula(List<SelectItem> listSelectItem) {
        this.comboTipoClausula = listSelectItem;
    }

    /**
     * Construtor
     * 
     * @param
     */
    public ModeloBoletoViewHelper() {
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
     * @return o valor do filtroProduto
     */
    public Integer getFiltroProduto() {
        return filtroProduto;
    }
    
    /**
     * @param filtroProduto
     *            seta o novo valor para o campo filtroProduto
     */
    public void setFiltroProduto(Integer filtroProduto) {
        this.filtroProduto = filtroProduto;
    }
    
    /**
     * @return o valor da lista filtroClausula
     */
    public Integer getFiltroClausula() {
        return filtroClausula;
    }

    /**
     * @param filtroClausula
     *            seta o novo valor para o campo filtroClausula
     */
    public void setFiltroClausula(Integer filtroClausula) {
        this.filtroClausula = filtroClausula;
    }

    /**
     * @return o valor do comboProdutoItens
     */
    public List<SelectItem> getComboProdutoItens() {
        return comboProdutoItens;
    }

    /**
     * @param comboProdutoItens
     *            seta o novo valor para o campo comboProdutoItens
     */
    public void setComboProdutoItens(List<SelectItem> comboProdutoItens) {
        this.comboProdutoItens = comboProdutoItens;
    }

    /**
     * @return o valor do listaDireita
     */
    public List<ComboTipoClausulaVO> getListaDireita() {
        return listaDireita;
    }

    /**
     * @param listaDireita
     *            seta o novo valor para o campo listaDireita
     */
    public void setListaDireita(List<ComboTipoClausulaVO> listaDireita) {
        this.listaDireita = listaDireita;
    }

    /**
     * @return o valor do listaEsquerda
     */
    public List<ComboTipoClausulaVO> getListaEsquerda() {
        return listaEsquerda;
    }

    /**
     * @param listaEsquerda
     *            seta o novo valor para o campo listaEsquerda
     */
    public void setListaEsquerda(List<ComboTipoClausulaVO> listaEsquerda) {
        this.listaEsquerda = listaEsquerda;
    }

    /**
     * @return o valor do listaEsquerdaClausula
     */
    public List<ComboClausulaVO> getListaEsquerdaClausula() {
        return listaEsquerdaClausula;
    }

    /**
     * @param listaEsquerdaClausula
     *            seta o novo valor para o campo listaEsquerdaClausula
     */
    public void setListaEsquerdaClausula(List<ComboClausulaVO> listaEsquerdaClausula) {
        this.listaEsquerdaClausula = listaEsquerdaClausula;
    }

    /**
     * @return o valor do listaDireitaClausula
     */
    public List<ComboClausulaVO> getListaDireitaClausula() {
        return listaDireitaClausula;
    }

    /**
     * @param listaDireitaClausula
     *            seta o novo valor para o campo listaDireitaClausula
     */
    public void setListaDireitaClausula(List<ComboClausulaVO> listaDireitaClausula) {
        this.listaDireitaClausula = listaDireitaClausula;
    }

    /**
     * @return o valor do inseridas
     */
    public Map<Integer, List<ComboClausulaVO>> getInseridas() {
        return inseridas;
    }

    /**
     * @param inseridas seta o novo valor para o campo inseridas
     */
    public void setInseridas(Map<Integer, List<ComboClausulaVO>> inseridas) {
        this.inseridas = inseridas;
    }

    /**
     * @return o valor do disponiveis
     */
    public Map<Integer, List<ComboClausulaVO>> getDisponiveis() {
        return disponiveis;
    }

    /**
     * @param disponiveis seta o novo valor para o campo disponiveis
     */
    public void setDisponiveis(Map<Integer, List<ComboClausulaVO>> disponiveis) {
        this.disponiveis = disponiveis;
    }

}
