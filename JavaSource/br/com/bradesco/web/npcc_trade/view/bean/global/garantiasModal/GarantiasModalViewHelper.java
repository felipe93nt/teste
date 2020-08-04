package br.com.bradesco.web.npcc_trade.view.bean.global.garantiasModal;

import java.io.Serializable;

/**
 * 
  * Nome: GarantiasModalViewHelper.java
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
  * Registro  de Manutenção: 02/03/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class GarantiasModalViewHelper implements Serializable{
	
	private static final long serialVersionUID = 4971400401433033210L;
	/**
	 * Número máximo de linhas que podem ser adicionadas 
	 * na tabela de garantias adicionais.
	 */
	public final Integer MAX_LIST_GARANTIAS_ADC = 10;
	private Boolean renderModal = Boolean.FALSE;
    private String modalId;
    private Boolean editavel = Boolean.FALSE;
    private String itemSelecionadoTipoGarantiaAdic = null;
    private String obsGarantiaAdc;
    private String percentualGarantiaAdc;
    private String cindcdeconmmoegar = null;
    
    
	/**
	 * @return the renderModal
	 */
	public Boolean getRenderModal() {
		return renderModal;
	}

	/**
	 * @param renderModal the renderModal to set
	 */
	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}

	/**
	 * @return the modalId
	 */
	public String getModalId() {
		return modalId;
	}

	/**
	 * @param modalId the modalId to set
	 */
	public void setModalId(String modalId) {
		this.modalId = modalId;
	}

	/**
	 * @return the editavel
	 */
	public Boolean getEditavel() {
		return editavel;
	}

	/**
	 * @param editavel the editavel to set
	 */
	public void setEditavel(Boolean editavel) {
		this.editavel = editavel;
	}

	/**
	 * @return the itemSelecionadoTipoGarantiaAdic
	 */
	public String getItemSelecionadoTipoGarantiaAdic() {
		return itemSelecionadoTipoGarantiaAdic;
	}

	/**
	 * @param itemSelecionadoTipoGarantiaAdic the itemSelecionadoTipoGarantiaAdic to set
	 */
	public void setItemSelecionadoTipoGarantiaAdic(
			String itemSelecionadoTipoGarantiaAdic) {
		this.itemSelecionadoTipoGarantiaAdic = itemSelecionadoTipoGarantiaAdic;
	}

	/**
	 * @return the obsGarantiaAdc
	 */
	public String getObsGarantiaAdc() {
		return obsGarantiaAdc;
	}

	/**
	 * @param obsGarantiaAdc the obsGarantiaAdc to set
	 */
	public void setObsGarantiaAdc(String obsGarantiaAdc) {
		this.obsGarantiaAdc = obsGarantiaAdc;
	}

	/**
	 * @return the percentualGarantiaAdc
	 */
	public String getPercentualGarantiaAdc() {
		return percentualGarantiaAdc;
	}

	/**
	 * @return the moedaGarantiaAdc
	 */
	public String getCindcdeconmmoegar() {
		return cindcdeconmmoegar;
	}

	/**
	 * @param percentualGarantiaAdc the percentualGarantiaAdc to set
	 */
	public void setPercentualGarantiaAdc(String percentualGarantiaAdc) {
		this.percentualGarantiaAdc = percentualGarantiaAdc;
	}

	/**
	 * @param moedaGarantiaAdc the moedaGarantiaAdc to set
	 */
	public void setCindcdeconmmoegar(String cindcdeconmmoegar) {
		this.cindcdeconmmoegar = cindcdeconmmoegar;
	}

}