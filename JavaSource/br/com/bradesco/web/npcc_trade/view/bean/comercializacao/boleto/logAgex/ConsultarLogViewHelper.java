package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.logAgex;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.Numeros;



public class ConsultarLogViewHelper {

    private String codlistRadio = null;
    private String nomeStateIdLista = null;
    private List<Integer> lista = new ArrayList<Integer>();

    private String nomeStateIdListaSelCliente = null;
    private Boolean renderModalCliente = Boolean.FALSE;
    private boolean telaInicioNegociacao = Boolean.TRUE;

    /** Variável do tipo Integer. */
    private Integer codCpfCnpjSelecionado = Numeros.ZERO;

    /**
     * Construtor
     * 
     * @param
     */
    public ConsultarLogViewHelper() {
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
     * @param nomeStateIdLista seta o novo valor para o campo nomeStateIdLista
     */
    public void setNomeStateIdLista(String nomeStateIdLista) {
        this.nomeStateIdLista = nomeStateIdLista;
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
    
    public List<SelectItem> getTipoPesquisaCpfCnpj() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM2, "CNPJ"));
        tipo.add(new SelectItem(Numeros.NUM3, "CPF"));
        return tipo;
    }

}
