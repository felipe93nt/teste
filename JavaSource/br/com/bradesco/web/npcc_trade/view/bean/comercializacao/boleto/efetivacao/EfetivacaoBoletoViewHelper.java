package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.efetivacao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public class EfetivacaoBoletoViewHelper {

    private String codlistRadio = null;
    private String nomeStateIdLista = null;   
    private String modalId = null;
    
    private String nomeStateIdListaSelCliente = null;
    private Boolean renderModalCliente = Boolean.FALSE;
    private boolean telaInicioNegociacao = Boolean.TRUE;
    
    /** Variável do tipo Integer. */
    private Integer codCpfCnpjSelecionado = Numeros.DOIS;
    
    /** Variável do tipo List<SelectItem>. */
    private List<SelectItem> comboProduto = new ArrayList<SelectItem>();
    
    private Boolean renderModalExcluir = Boolean.FALSE;
    private Boolean renderModalConfirmar = Boolean.FALSE;
    
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
     * @param state_id seta o novo valor para o campo nomeStateIdLista
     */
    public void setNomeStateIdLista(String state_id) {
        this.nomeStateIdLista = state_id;
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
     * @return o valor do modalId
     */
    public String getModalId() {
        return modalId;
    }

    /**
     * @param modalId seta o novo valor para o campo modalId
     */
    public void setModalId(String modalId) {
        this.modalId = modalId;
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
    	* Registro  de Manutenção: 19/04/2016
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
     * @return o valor do renderModalExcluir
     */
    public Boolean getRenderModalExcluir() {
        return renderModalExcluir;
    }

    /**
     * @param renderModalExcluir seta o novo valor para o campo renderModalExcluir
     */
    public void setRenderModalExcluir(Boolean renderModalExcluir) {
        this.renderModalExcluir = renderModalExcluir;
    }

    /**
     * @return o valor do renderModalConfirmar
     */
    public Boolean getRenderModalConfirmar() {
        return renderModalConfirmar;
    }

    /**
     * @param renderModalConfirmar seta o novo valor para o campo renderModalConfirmar
     */
    public void setRenderModalConfirmar(Boolean renderModalConfirmar) {
        this.renderModalConfirmar = renderModalConfirmar;
    }

   
    
    

}
