package br.com.bradesco.web.npcc_trade.view.bean.global.anexarArquivoGccModal;

import java.io.Serializable;

import org.apache.commons.fileupload.disk.DiskFileItem;

/**
 * 
  * Nome: AnexarArquivoGccModalViewHelper.java
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
  * Registro  de Manutenção: 20/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class AnexarArquivoGccModalViewHelper implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Boolean renderModal = Boolean.FALSE;
    
    private String modalId;
    
    private DiskFileItem arquivo;
    
    private String titleModal = "Anexar arquivo";
    
    private Boolean recarregaLista = Boolean.FALSE;
    
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
	 * @return o valor do serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
     * @return o valor do arquivo
     */
    public DiskFileItem getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo seta o novo valor para o campo arquivo
     */
    public void setArquivo(DiskFileItem arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * @return o valor do titleModal
     */
    public String getTitleModal() {
        return titleModal;
    }

    /**
     * @param titleModal seta o novo valor para o campo titleModal
     */
    public void setTitleModal(String titleModal) {
        this.titleModal = titleModal;
    }

    /**
     * @return o valor do recarregaLista
     */
    public Boolean getRecarregaLista() {
        return recarregaLista;
    }

    /**
     * @param recarregaLista seta o novo valor para o campo recarregaLista
     */
    public void setRecarregaLista(Boolean recarregaLista) {
        this.recarregaLista = recarregaLista;
    }
}
