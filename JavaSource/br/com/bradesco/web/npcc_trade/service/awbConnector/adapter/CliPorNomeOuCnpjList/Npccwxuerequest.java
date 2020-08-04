package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/02/17 13:37
 */
public class Npccwxuerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXUE-HEADER.NPCCWXUE-COD-LAYOUT")
	private String codlayout = "NPCCWXUE";

	@Adapter(transactionField = "NPCCWXUE-HEADER.NPCCWXUE-TAM-LAYOUT")
	private Integer tamlayout = 79;

	@Adapter(transactionField = "NPCCWXUE-REGISTRO.NPCCWXUE-IND-PESQUISA")
	private Integer indpesquisa = 0;

	@Adapter(transactionField = "NPCCWXUE-REGISTRO.NPCCWXUE-NM-NOME-CLIENTE")
	private String nmnomecliente = null;

	@Adapter(transactionField = "NPCCWXUE-REGISTRO.NPCCWXUE-CD-CPFCNPJ")
	private Integer cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWXUE-REGISTRO.NPCCWXUE-CD-FILIAL")
	private Integer cdfilial = 0;

	@Adapter(transactionField = "NPCCWXUE-REGISTRO.NPCCWXUE-CD-CTRL-CPFCNPJ")
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

	public Integer getIndpesquisa() {
		return indpesquisa;
	}
	public void setIndpesquisa(Integer indpesquisa) {
		this.indpesquisa = indpesquisa;
	}

	public String getNmnomecliente() {
		return nmnomecliente;
	}
	public void setNmnomecliente(String nmnomecliente) {
		this.nmnomecliente = nmnomecliente;
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