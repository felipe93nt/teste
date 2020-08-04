package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.baixarbolAgex;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

/**
  * Nome: BaixarBoletoViewHelper.java
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
  * Registro  de Manutenção: 19/07/2017
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class BaixarBoletoViewHelper {

    private String codlistRadio = null;
    private String nomeStateIdLista = null;
    private List<Integer> lista = new ArrayList<Integer>();

    private String nomeStateIdListaSelCliente = null;
    private Boolean renderModalCliente = Boolean.FALSE;
    private boolean telaInicioNegociacao = Boolean.TRUE;

    /** Variável do tipo Integer. */
    private Integer codCpfCnpjSelecionado = Numeros.ZERO;
    /*Variável para selecionar se vai baixar ou estornar*/
    private Integer codSelelecionarTela = Numeros.DOIS;

    private Boolean renderModalBaixar = Boolean.FALSE;
    private Boolean renderModalEstorno = Boolean.FALSE;

    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboProduto = new ArrayList<SelectItem>();

    /**
     * Construtor
     * 
     * @param
     */
    public BaixarBoletoViewHelper() {
        super();
    }

    /**
     * @return o valor do codlistRadio
     */
    public String getCodlistRadio() {
        return codlistRadio;
    }
    /**
     * @param codlistRadio seta o novo valor para o campo codlistRadio
     */
    public void setCodlistRadio(String codlistRadio) {
        this.codlistRadio = codlistRadio;
    }


    /**
     * @return o valor do nomeStateIdLista
     */
    public String getNomeStateIdLista() {
        return nomeStateIdLista;
    }

    /**
     * @param STATE_ID seta o novo valor para o campo nomeStateIdLista
     */
    public void setNomeStateIdLista(String STATE_ID) {
        this.nomeStateIdLista = STATE_ID;
    }

    /**
     * @return o valor do lista
     */
    public List<Integer> getLista() {
        return lista;
    }

    /**
     * @param lista seta o novo valor para o campo lista
     */
    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }

    /**
     * @return o valor do nomeStateIdListaSelCliente
     */
    public String getNomeStateIdListaSelCliente() {
        return nomeStateIdListaSelCliente;
    }

    /**
     * @param nomeStateIdListaSelCliente seta o novo valor para o campo nomeStateIdListaSelCliente
     */
    public void setNomeStateIdListaSelCliente(String nomeStateIdListaSelCliente) {
        this.nomeStateIdListaSelCliente = nomeStateIdListaSelCliente;
    }

    /**
     * @return o valor do renderModalCliente
     */
    public Boolean getRenderModalCliente() {
        return renderModalCliente;
    }

    /**
     * @param renderModalCliente seta o novo valor para o campo renderModalCliente
     */
    public void setRenderModalCliente(Boolean renderModalCliente) {
        this.renderModalCliente = renderModalCliente;
    }

    /**
     * @return o valor do telaInicioNegociacao
     */
    public boolean isTelaInicioNegociacao() {
        return telaInicioNegociacao;
    }

    /**
     * @param telaInicioNegociacao seta o novo valor para o campo telaInicioNegociacao
     */
    public void setTelaInicioNegociacao(boolean telaInicioNegociacao) {
        this.telaInicioNegociacao = telaInicioNegociacao;
    }

    /**
     * @return o valor do codCpfCnpjSelecionado
     */
    public Integer getCodCpfCnpjSelecionado() {
        return codCpfCnpjSelecionado;
    }

    /**
     * @param codCpfCnpjSelecionado seta o novo valor para o campo codCpfCnpjSelecionado
     */
    public void setCodCpfCnpjSelecionado(Integer codCpfCnpjSelecionado) {
        this.codCpfCnpjSelecionado = codCpfCnpjSelecionado;
    }
    
    /**
     * @return o valor do comboProduto
     */
    public List<SelectItem> getComboProduto() {
        return comboProduto;
    }

    /**
     * @param comboProduto seta o novo valor para o campo comboProduto
     */
    public void setComboProduto(List<SelectItem> comboProduto) {
        this.comboProduto = comboProduto;
    }

    /**
     * @return o valor do renderModalBaixar
     */
    public Boolean getRenderModalBaixar() {
        return renderModalBaixar;
    }

    /**
     * @param renderModalBaixar seta o novo valor para o campo renderModalBaixar
     */
    public void setRenderModalBaixar(Boolean renderModalBaixar) {
        this.renderModalBaixar = renderModalBaixar;
    }

    /**
     * @return o valor do renderModalEstorno
     */
    public Boolean getRenderModalEstorno() {
        return renderModalEstorno;
    }

    /**
     * @param renderModalEstorno seta o novo valor para o campo renderModalEstorno
     */
    public void setRenderModalEstorno(Boolean renderModalEstorno) {
        this.renderModalEstorno = renderModalEstorno;
    }   
    
    /**
     * @return o valor do codSelelecionarTela
     */
    public Integer getCodSelelecionarTela() {
        return codSelelecionarTela;
    }

    /**
     * @param codSelelecionarTela seta o novo valor para o campo codSelelecionarTela
     */
    public void setCodSelelecionarTela(Integer codSelelecionarTela) {
        this.codSelelecionarTela = codSelelecionarTela;
    }
    
    /**
     * 
    	* Nome: getTipoPesquisaCpfCnpj
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 22/04/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getTipoPesquisaCpfCnpj() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM2, "CNPJ"));
        tipo.add(new SelectItem(Numeros.NUM3, "CPF"));
        return tipo;
    }
    
	/**
	 * Nome: getTipoPesquisaTela
	 * 
	 * Propósito: 
	 *
	 * @param : 
	 * @return : 
	 * @throws :
	 * @exception : 
	 * @see : Referencias externas.	
	 *
	 * Registro  de Manutenção: 19/07/2017
	 *        - Autor: BRQ
	 *        - Responsavel: Equipe Web
	 *        - Adequação ao padrão hexavision.
	 */
    public List<SelectItem> getTipoPesquisaTela() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM2, "Baixa"));
        tipo.add(new SelectItem(Numeros.NUM3, "Estorno"));
        return tipo;
    }

}
