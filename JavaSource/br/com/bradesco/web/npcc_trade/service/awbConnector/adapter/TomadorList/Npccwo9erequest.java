package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/05/16 11:24
 */
public class Npccwo9erequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWO9E-HEADER.NPCCWO9E-COD-LAYOUT")
	private String codlayout = "NPCCWO9E";

	@Adapter(transactionField = "NPCCWO9E-HEADER.NPCCWO9E-TAM-LAYOUT")
	private Integer tamlayout = 102;

	@Adapter(transactionField = "NPCCWO9E-REGISTRO.NPCCWO9E-NTPO-PAPEL-CMBIO")
	private Integer ntpopapelcmbio = 0;

	@Adapter(transactionField = "NPCCWO9E-REGISTRO.NPCCWO9E-TIPO-PESQUISA")
	private Integer tipopesquisa = 0;

	@Adapter(transactionField = "NPCCWO9E-REGISTRO.NPCCWO9E-CD-CPFCNPJ")
	private Integer cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWO9E-REGISTRO.NPCCWO9E-CD-FILIAL")
	private Integer cdfilial = 0;

	@Adapter(transactionField = "NPCCWO9E-REGISTRO.NPCCWO9E-CD-CTRL-CPFCNPJ")
	private Integer cdctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWO9E-REGISTRO.NPCCWO9E-NM-NOME-CLIENTE")
	private String nmnomecliente = null;
	
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

	public Integer getNtpopapelcmbio() {
		return ntpopapelcmbio;
	}
	public void setNtpopapelcmbio(Integer ntpopapelcmbio) {
		this.ntpopapelcmbio = ntpopapelcmbio;
	}

	public Integer getTipopesquisa() {
		return tipopesquisa;
	}
	public void setTipopesquisa(Integer tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
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

	public String getNmnomecliente() {
		return nmnomecliente;
	}
	public void setNmnomecliente(String nmnomecliente) {
		this.nmnomecliente = nmnomecliente;
	}
    
}