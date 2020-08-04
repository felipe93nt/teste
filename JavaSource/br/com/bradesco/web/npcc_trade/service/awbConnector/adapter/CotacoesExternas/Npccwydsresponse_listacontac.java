package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CotacoesExternas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 31/10/17 12:30
 */
public class Npccwydsresponse_listacontac extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-CFNDNG")
	private Long listacontac_cfndng = 0L;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-CBANQR-CMBIO-FNDNG")
	private Long listacontac_cbanqrcmbiofndng = 0L;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-NBANQR-CMBIO-FNDNG")
	private String listacontac_nbanqrcmbiofndng = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-PRACA-CMBIO-FNDNG")
	private String listacontac_pracacmbiofndng = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-CBANQR-CMBIO-RCDOR")
	private Long listacontac_cbanqrcmbiorcdor = 0L;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-NBANQR-CMBIO-RCDOR")
	private String listacontac_nbanqrcmbiorcdor = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-PRACA-CMBIO-RCDOR")
	private String listacontac_pracacmbiorcdor = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-CBANQR-CMBIO-AVISO")
	private Long listacontac_cbanqrcmbioaviso = 0L;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-NBANQR-CMBIO-AVISO")
	private String listacontac_nbanqrcmbioaviso = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-PRACA-CMBIO-AVISO")
	private String listacontac_pracacmbioaviso = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-DCOTAC-FNDNG-CMBIO")
	private String listacontac_dcotacfndngcmbio = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-DLIM-FNDNG-CMBIO")
	private String listacontac_dlimfndngcmbio = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-CINDCD-FNDNG-UTLZD")
	private String listacontac_cindcdfndngutlzd = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-NINDCD-FNDNG-UTLZD")
	private String listacontac_nindcdfndngutlzd = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-CUSUAR-MANUT")
	private String listacontac_cusuarmanut = null;

	@Adapter(transactionField = "NPCCWYDS-SAIDA.NPCCWYDS-LISTA-CONTAC.NPCCWYDS-NUSUAR-MANUT")
	private String listacontac_nusuarmanut = null;
	
	public Long getListacontac_cfndng() {
		return listacontac_cfndng;
	}
	public void setListacontac_cfndng(Long listacontac_cfndng) {
		this.listacontac_cfndng = listacontac_cfndng;
	}

	public Long getListacontac_cbanqrcmbiofndng() {
		return listacontac_cbanqrcmbiofndng;
	}
	public void setListacontac_cbanqrcmbiofndng(Long listacontac_cbanqrcmbiofndng) {
		this.listacontac_cbanqrcmbiofndng = listacontac_cbanqrcmbiofndng;
	}

	public String getListacontac_nbanqrcmbiofndng() {
		return listacontac_nbanqrcmbiofndng;
	}
	public void setListacontac_nbanqrcmbiofndng(String listacontac_nbanqrcmbiofndng) {
		this.listacontac_nbanqrcmbiofndng = listacontac_nbanqrcmbiofndng;
	}

	public String getListacontac_pracacmbiofndng() {
		return listacontac_pracacmbiofndng;
	}
	public void setListacontac_pracacmbiofndng(String listacontac_pracacmbiofndng) {
		this.listacontac_pracacmbiofndng = listacontac_pracacmbiofndng;
	}

	public Long getListacontac_cbanqrcmbiorcdor() {
		return listacontac_cbanqrcmbiorcdor;
	}
	public void setListacontac_cbanqrcmbiorcdor(Long listacontac_cbanqrcmbiorcdor) {
		this.listacontac_cbanqrcmbiorcdor = listacontac_cbanqrcmbiorcdor;
	}

	public String getListacontac_nbanqrcmbiorcdor() {
		return listacontac_nbanqrcmbiorcdor;
	}
	public void setListacontac_nbanqrcmbiorcdor(String listacontac_nbanqrcmbiorcdor) {
		this.listacontac_nbanqrcmbiorcdor = listacontac_nbanqrcmbiorcdor;
	}

	public String getListacontac_pracacmbiorcdor() {
		return listacontac_pracacmbiorcdor;
	}
	public void setListacontac_pracacmbiorcdor(String listacontac_pracacmbiorcdor) {
		this.listacontac_pracacmbiorcdor = listacontac_pracacmbiorcdor;
	}

	public Long getListacontac_cbanqrcmbioaviso() {
		return listacontac_cbanqrcmbioaviso;
	}
	public void setListacontac_cbanqrcmbioaviso(Long listacontac_cbanqrcmbioaviso) {
		this.listacontac_cbanqrcmbioaviso = listacontac_cbanqrcmbioaviso;
	}

	public String getListacontac_nbanqrcmbioaviso() {
		return listacontac_nbanqrcmbioaviso;
	}
	public void setListacontac_nbanqrcmbioaviso(String listacontac_nbanqrcmbioaviso) {
		this.listacontac_nbanqrcmbioaviso = listacontac_nbanqrcmbioaviso;
	}

	public String getListacontac_pracacmbioaviso() {
		return listacontac_pracacmbioaviso;
	}
	public void setListacontac_pracacmbioaviso(String listacontac_pracacmbioaviso) {
		this.listacontac_pracacmbioaviso = listacontac_pracacmbioaviso;
	}

	public String getListacontac_dcotacfndngcmbio() {
		return listacontac_dcotacfndngcmbio;
	}
	public void setListacontac_dcotacfndngcmbio(String listacontac_dcotacfndngcmbio) {
		this.listacontac_dcotacfndngcmbio = listacontac_dcotacfndngcmbio;
	}

	public String getListacontac_dlimfndngcmbio() {
		return listacontac_dlimfndngcmbio;
	}
	public void setListacontac_dlimfndngcmbio(String listacontac_dlimfndngcmbio) {
		this.listacontac_dlimfndngcmbio = listacontac_dlimfndngcmbio;
	}

	public String getListacontac_cindcdfndngutlzd() {
		return listacontac_cindcdfndngutlzd;
	}
	public void setListacontac_cindcdfndngutlzd(String listacontac_cindcdfndngutlzd) {
		this.listacontac_cindcdfndngutlzd = listacontac_cindcdfndngutlzd;
	}

	public String getListacontac_nindcdfndngutlzd() {
		return listacontac_nindcdfndngutlzd;
	}
	public void setListacontac_nindcdfndngutlzd(String listacontac_nindcdfndngutlzd) {
		this.listacontac_nindcdfndngutlzd = listacontac_nindcdfndngutlzd;
	}

	public String getListacontac_cusuarmanut() {
		return listacontac_cusuarmanut;
	}
	public void setListacontac_cusuarmanut(String listacontac_cusuarmanut) {
		this.listacontac_cusuarmanut = listacontac_cusuarmanut;
	}

	public String getListacontac_nusuarmanut() {
		return listacontac_nusuarmanut;
	}
	public void setListacontac_nusuarmanut(String listacontac_nusuarmanut) {
		this.listacontac_nusuarmanut = listacontac_nusuarmanut;
	}
    
}