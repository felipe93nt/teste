package br.com.bradesco.web.npcc_trade.view.bean.parametrosPrecificacao.tipoClausula;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

/**
  * Nome: TipoClausulaViewHelper.java
  * 
  * Prop�sito: Classe de auxilio do Bean tipoClausulaBean
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 07/12/2015
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
*/
public class TipoClausulaViewHelper {
	/**
	 * Indice do radio selecionado na grid
	 */
	
	private Integer codItemSelecionadoLista = Numeros.ZERO;
	
	/**
     *  Variavel utilizada para definier o state id da lista de log 
     */
    private String nomeStateIdLista = null;

	    /**
	     * Construtor
	     * 
	     * @param 
	     */
    public TipoClausulaViewHelper() {

		super();
	}
	
	/**
     * Vari�vel de controle do modal de confirma��o
     */
    Boolean renderModal = Boolean.FALSE;

	/**
	 * @return o valor do codItemSelecionadoLista
	 */
	public Integer getCodItemSelecionadoLista() {
		return codItemSelecionadoLista;
	}

	/**
	 * @param codItemSelecionadoLista seta o novo valor para o campo codItemSelecionadoLista
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
     * @param renderModal seta o novo valor para o campo renderModal
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
     * @param nomeStateIdLista seta o novo valor para o campo nomeStateIdLista
     */
    public void setNomeStateIdLista(String nomeStateIdLista) {
        this.nomeStateIdLista = nomeStateIdLista;
    }


}
