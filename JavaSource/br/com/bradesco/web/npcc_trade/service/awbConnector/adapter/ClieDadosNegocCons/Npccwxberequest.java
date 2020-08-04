package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ClieDadosNegocCons;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 29/03/17 15:55
 */
public class Npccwxberequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXBE-HEADER.NPCCWXBE-COD-LAYOUT")
	private String codlayout = "NPCCWXBE";

	@Adapter(transactionField = "NPCCWXBE-HEADER.NPCCWXBE-TAM-LAYOUT")
	private Integer tamlayout = 39;

	@Adapter(transactionField = "NPCCWXBE-REGISTRO.NPCCWXBE-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWXBE-REGISTRO.NPCCWXBE-TIPO-PESSOA")
	private String tipopessoa = null;

	@Adapter(transactionField = "NPCCWXBE-REGISTRO.NPCCWXBE-CD-CPFCNPJ")
	private Integer cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWXBE-REGISTRO.NPCCWXBE-CD-FILIAL")
	private Integer cdfilial = 0;

	@Adapter(transactionField = "NPCCWXBE-REGISTRO.NPCCWXBE-CD-CTRL-CPFCNPJ")
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

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	public String getTipopessoa() {
		return tipopessoa;
	}
	public void setTipopessoa(String tipopessoa) {
		this.tipopessoa = tipopessoa;
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