package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliCambioConsultaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/01/16 16:11
 */
public class Npcdweyerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWEYE-HEADER.NPCDWEYE-COD-LAYOUT")
	private String codlayout = "NPCDWEYE";

	@Adapter(transactionField = "NPCDWEYE-HEADER.NPCDWEYE-TAM-LAYOUT")
	private Integer tamlayout = 49;

	@Adapter(transactionField = "NPCDWEYE-REGISTRO.NPCDWEYE-TIPO-PESQUISA")
	private Integer tipopesquisa = 0;

	@Adapter(transactionField = "NPCDWEYE-REGISTRO.NPCDWEYE-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCDWEYE-REGISTRO.NPCDWEYE-CPSSOA")
	private Long cpssoa = 0L;

	@Adapter(transactionField = "NPCDWEYE-REGISTRO.NPCDWEYE-CD-CPFCNPJ")
	private Integer cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCDWEYE-REGISTRO.NPCDWEYE-CD-FILIAL")
	private Integer cdfilial = 0;

	@Adapter(transactionField = "NPCDWEYE-REGISTRO.NPCDWEYE-CD-CTRL-CPFCNPJ")
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

	public Integer getTipopesquisa() {
		return tipopesquisa;
	}
	public void setTipopesquisa(Integer tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	public Long getCpssoa() {
		return cpssoa;
	}
	public void setCpssoa(Long cpssoa) {
		this.cpssoa = cpssoa;
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