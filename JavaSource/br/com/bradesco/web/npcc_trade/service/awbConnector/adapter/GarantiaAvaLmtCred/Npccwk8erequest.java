package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 13:31
 */
public class Npccwk8erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK8E-HEADER.NPCCWK8E-COD-LAYOUT")
	private String codlayout = "NPCCWK8E";

	@Adapter(transactionField = "NPCCWK8E-HEADER.NPCCWK8E-TAM-LAYOUT")
	private Integer tamlayout = 55;

	@Adapter(transactionField = "NPCCWK8E-REGISTRO.NPCCWK8E-NSEQ-CONTR-LIM")
	private Long nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWK8E-REGISTRO.NPCCWK8E-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;

	@Adapter(transactionField = "NPCCWK8E-REGISTRO.NPCCWK8E-CCPF-CNPJ")
	private Integer ccpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK8E-REGISTRO.NPCCWK8E-CFLIAL-CNPJ")
	private Integer cflialcnpj = 0;

	@Adapter(transactionField = "NPCCWK8E-REGISTRO.NPCCWK8E-CCTRL-CPF-CNPJ")
	private Integer cctrlcpfcnpj = 0;
	
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

	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}
	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}

	public Long getNppstapontucmbio() {
		return nppstapontucmbio;
	}
	public void setNppstapontucmbio(Long nppstapontucmbio) {
		this.nppstapontucmbio = nppstapontucmbio;
	}

	public Integer getCcpfcnpj() {
		return ccpfcnpj;
	}
	public void setCcpfcnpj(Integer ccpfcnpj) {
		this.ccpfcnpj = ccpfcnpj;
	}

	public Integer getCflialcnpj() {
		return cflialcnpj;
	}
	public void setCflialcnpj(Integer cflialcnpj) {
		this.cflialcnpj = cflialcnpj;
	}

	public Integer getCctrlcpfcnpj() {
		return cctrlcpfcnpj;
	}
	public void setCctrlcpfcnpj(Integer cctrlcpfcnpj) {
		this.cctrlcpfcnpj = cctrlcpfcnpj;
	}
    
}