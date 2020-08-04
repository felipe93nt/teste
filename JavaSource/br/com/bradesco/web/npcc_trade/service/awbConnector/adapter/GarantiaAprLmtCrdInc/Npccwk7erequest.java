package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAprLmtCrdInc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/04/18 15:27
 */
public class Npccwk7erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK7E-HEADER.NPCCWK7E-COD-LAYOUT")
	private String codlayout = "NPCCWK7E";

	@Adapter(transactionField = "NPCCWK7E-HEADER.NPCCWK7E-TAM-LAYOUT")
	private Integer tamlayout = 63;

	@Adapter(transactionField = "NPCCWK7E-REGISTRO.NPCCWK7E-NCONTR-LIM")
	private Long ncontrlim = 0L;

	@Adapter(transactionField = "NPCCWK7E-REGISTRO.NPCCWK7E-CPRODT-SERVC-OPER")
	private Integer cprodtservcoper = 0;

	@Adapter(transactionField = "NPCCWK7E-REGISTRO.NPCCWK7E-CCPF-CNPJ")
	private Integer ccpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK7E-REGISTRO.NPCCWK7E-CFLIAL-CPF-CNPJ")
	private Integer cflialcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK7E-REGISTRO.NPCCWK7E-CCTRL-CPF-CNPJ")
	private Integer cctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK7E-REGISTRO.NPCCWK7E-NPPSTA-PONTU-CMBIO")
	private Long nppstapontucmbio = 0L;
	
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

	public Long getNcontrlim() {
		return ncontrlim;
	}
	public void setNcontrlim(Long ncontrlim) {
		this.ncontrlim = ncontrlim;
	}

	public Integer getCprodtservcoper() {
		return cprodtservcoper;
	}
	public void setCprodtservcoper(Integer cprodtservcoper) {
		this.cprodtservcoper = cprodtservcoper;
	}

	public Integer getCcpfcnpj() {
		return ccpfcnpj;
	}
	public void setCcpfcnpj(Integer ccpfcnpj) {
		this.ccpfcnpj = ccpfcnpj;
	}

	public Integer getCflialcpfcnpj() {
		return cflialcpfcnpj;
	}
	public void setCflialcpfcnpj(Integer cflialcpfcnpj) {
		this.cflialcpfcnpj = cflialcpfcnpj;
	}

	public Integer getCctrlcpfcnpj() {
		return cctrlcpfcnpj;
	}
	public void setCctrlcpfcnpj(Integer cctrlcpfcnpj) {
		this.cctrlcpfcnpj = cctrlcpfcnpj;
	}

	public Long getNppstapontucmbio() {
		return nppstapontucmbio;
	}
	public void setNppstapontucmbio(Long nppstapontucmbio) {
		this.nppstapontucmbio = nppstapontucmbio;
	}
    
}