package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConsBeneficAfiancado;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/09/16 10:19
 */
public class Npccwzmerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZME-HEADER.NPCCWZME-COD-LAYOUT")
	private String codlayout = "NPCCWZME";

	@Adapter(transactionField = "NPCCWZME-HEADER.NPCCWZME-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCCWZME-REGISTRO.NPCCWZME-CUNIC-PSSOA")
	private Long cunicpssoa = 0L;

	@Adapter(transactionField = "NPCCWZME-REGISTRO.NPCCWZME-FLAG-BENE-OR-AFIA")
	private Integer flagbeneorafia = 0;

	@Adapter(transactionField = "NPCCWZME-REGISTRO.NPCCWZME-CCLUB")
	private Long cclub = 0L;

	@Adapter(transactionField = "NPCCWZME-REGISTRO.NPCCWZME-CD-CPFCNPJ")
	private Integer cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWZME-REGISTRO.NPCCWZME-CD-FILIAL")
	private Integer cdfilial = 0;

	@Adapter(transactionField = "NPCCWZME-REGISTRO.NPCCWZME-CD-CTRL-CPFCNPJ")
	private Integer cdctrlcpfcnpj = 0;
	
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

	public Long getCunicpssoa() {
		return cunicpssoa;
	}
	public void setCunicpssoa(Long cunicpssoa) {
		this.cunicpssoa = cunicpssoa;
	}

	public Integer getFlagbeneorafia() {
		return flagbeneorafia;
	}
	public void setFlagbeneorafia(Integer flagbeneorafia) {
		this.flagbeneorafia = flagbeneorafia;
	}

	public Long getCclub() {
		return cclub;
	}
	public void setCclub(Long cclub) {
		this.cclub = cclub;
	}

	public Integer getCdcpfcnpj() {
		return cdcpfcnpj;
	}
	public void setCdcpfcnpj(Integer cdcpfcnpj) {
		this.cdcpfcnpj = cdcpfcnpj;
	}

	public Integer getCdfilial() {
		return cdfilial;
	}
	public void setCdfilial(Integer cdfilial) {
		this.cdfilial = cdfilial;
	}

	public Integer getCdctrlcpfcnpj() {
		return cdctrlcpfcnpj;
	}
	public void setCdctrlcpfcnpj(Integer cdctrlcpfcnpj) {
		this.cdctrlcpfcnpj = cdctrlcpfcnpj;
	}
    
}