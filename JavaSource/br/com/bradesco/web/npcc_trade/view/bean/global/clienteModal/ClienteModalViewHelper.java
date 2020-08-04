package br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal;

import br.com.bradesco.web.npcc_trade.utils.Numeros;

public class ClienteModalViewHelper {

	private String itemSelecListaSelCliente = null;
	private Integer codCpfCnpjSelecionado = Numeros.ZERO;
	private Boolean renderModalCliente = Boolean.FALSE;
	private String nomeStateIdListaSelCliente = null;
	private String modalId;
	private boolean renderCpfCnpj = Boolean.TRUE;
	private boolean pesqCpf = Boolean.FALSE;
	
	private boolean isConfirmar = Boolean.FALSE;

    /**
     * @return o valor do itemSelecListaSelCliente
     */
    public String getItemSelecListaSelCliente() {
        return itemSelecListaSelCliente;
    }

    /**
     * @param itemSelecListaSelCliente seta o novo valor para o campo itemSelecListaSelCliente
     */
    public void setItemSelecListaSelCliente(String itemSelecListaSelCliente) {
        this.itemSelecListaSelCliente = itemSelecListaSelCliente;
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
     * @return o valor do renderCpfCnpj
     */
    public boolean isRenderCpfCnpj() {
        return renderCpfCnpj;
    }

    /**
     * @param renderCpfCnpj seta o novo valor para o campo renderCpfCnpj
     */
    public void setRenderCpfCnpj(boolean renderCpfCnpj) {
        this.renderCpfCnpj = renderCpfCnpj;
    }

    /**
     * @return o valor do pesqCpf
     */
    public boolean isPesqCpf() {
        return pesqCpf;
    }

    /**
     * @param pesqCpf seta o novo valor para o campo pesqCpf
     */
    public void setPesqCpf(boolean pesqCpf) {
        this.pesqCpf = pesqCpf;
    }

    /**
     * @return o valor do isConfirmar
     */
    public boolean isConfirmar() {
        return isConfirmar;
    }

    /**
     * @param isConfirmar seta o novo valor para o campo isConfirmar
     */
    public void setConfirmar(boolean isConfirmar) {
        this.isConfirmar = isConfirmar;
    }
	
	
	
}
