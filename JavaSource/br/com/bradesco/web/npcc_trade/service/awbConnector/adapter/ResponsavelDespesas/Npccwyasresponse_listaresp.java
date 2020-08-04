package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ResponsavelDespesas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/12/16 11:33
 */
public class Npccwyasresponse_listaresp extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-CFNDNG")
	private Long listaresp_cfndng = 0L;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-CBANQR-CMBIO")
	private Long listaresp_cbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-NBANQR-CMBIO")
	private String listaresp_nbanqrcmbio = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-NFUNC-RESP")
	private String listaresp_nfuncresp = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-IMUN-IND-CMBIO")
	private String listaresp_imunindcmbio = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-IPAIS")
	private String listaresp_ipais = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-CID-BANQR-SWIFT")
	private String listaresp_cidbanqrswift = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-CINDCD-FNDNG-UTLZD")
	private String listaresp_cindcdfndngutlzd = null;

	@Adapter(transactionField = "NPCCWYAS-SAIDA.NPCCWYAS-LISTA-RESP.NPCCWYAS-NINDCD-FNDNG-UTLZD")
	private String listaresp_nindcdfndngutlzd = null;
	
	public Long getListaresp_cfndng() {
		return listaresp_cfndng;
	}
	public void setListaresp_cfndng(Long listaresp_cfndng) {
		this.listaresp_cfndng = listaresp_cfndng;
	}

	public Long getListaresp_cbanqrcmbio() {
		return listaresp_cbanqrcmbio;
	}
	public void setListaresp_cbanqrcmbio(Long listaresp_cbanqrcmbio) {
		this.listaresp_cbanqrcmbio = listaresp_cbanqrcmbio;
	}

	public String getListaresp_nbanqrcmbio() {
		return listaresp_nbanqrcmbio;
	}
	public void setListaresp_nbanqrcmbio(String listaresp_nbanqrcmbio) {
		this.listaresp_nbanqrcmbio = listaresp_nbanqrcmbio;
	}

	public String getListaresp_nfuncresp() {
		return listaresp_nfuncresp;
	}
	public void setListaresp_nfuncresp(String listaresp_nfuncresp) {
		this.listaresp_nfuncresp = listaresp_nfuncresp;
	}

	public String getListaresp_imunindcmbio() {
		return listaresp_imunindcmbio;
	}
	public void setListaresp_imunindcmbio(String listaresp_imunindcmbio) {
		this.listaresp_imunindcmbio = listaresp_imunindcmbio;
	}

	public String getListaresp_ipais() {
		return listaresp_ipais;
	}
	public void setListaresp_ipais(String listaresp_ipais) {
		this.listaresp_ipais = listaresp_ipais;
	}

	public String getListaresp_cidbanqrswift() {
		return listaresp_cidbanqrswift;
	}
	public void setListaresp_cidbanqrswift(String listaresp_cidbanqrswift) {
		this.listaresp_cidbanqrswift = listaresp_cidbanqrswift;
	}

	public String getListaresp_cindcdfndngutlzd() {
		return listaresp_cindcdfndngutlzd;
	}
	public void setListaresp_cindcdfndngutlzd(String listaresp_cindcdfndngutlzd) {
		this.listaresp_cindcdfndngutlzd = listaresp_cindcdfndngutlzd;
	}

	public String getListaresp_nindcdfndngutlzd() {
		return listaresp_nindcdfndngutlzd;
	}
	public void setListaresp_nindcdfndngutlzd(String listaresp_nindcdfndngutlzd) {
		this.listaresp_nindcdfndngutlzd = listaresp_nindcdfndngutlzd;
	}
    
}