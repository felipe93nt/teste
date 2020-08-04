package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstatCotacoesList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 25/10/16 17:51
 */
public class Npccwzderequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZDE-HEADER.NPCCWZDE-COD-LAYOUT")
	private String codlayout = "NPCCWZDE";

	@Adapter(transactionField = "NPCCWZDE-HEADER.NPCCWZDE-TAM-LAYOUT")
	private Integer tamlayout = 34;

	@Adapter(transactionField = "NPCCWZDE-REGISTRO.NPCCWZDE-TIPO-PESQ")
	private Integer tipopesq = 0;

	@Adapter(transactionField = "NPCCWZDE-REGISTRO.NPCCWZDE-DTPER-INI")
	private String dtperini = null;

	@Adapter(transactionField = "NPCCWZDE-REGISTRO.NPCCWZDE-DTPER-FIM")
	private String dtperfim = null;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public Integer getTipopesq() {
		return tipopesq;
	}
	public void setTipopesq(Integer tipopesq) {
		this.tipopesq = tipopesq;
	}

	public String getDtperini() {
		return dtperini;
	}
	public void setDtperini(String dtperini) {
		this.dtperini = dtperini;
	}

	public String getDtperfim() {
		return dtperfim;
	}
	public void setDtperfim(String dtperfim) {
		this.dtperfim = dtperfim;
	}
    
}