package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvaLmtCred;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 10/03/17 13:31
 */
public class Npccwk8sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-DOCUMENTO")
	private String lista_documento = null;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-NSEQ-CONTR-LIM")
	private Long lista_nseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-CD-CPFCNPJ")
	private Integer lista_cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-CD-FILIAL")
	private Integer lista_cdfilial = 0;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-CD-CTRL-CPFCNPJ")
	private Integer lista_cdctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-NM-NOME-CLIENTE")
	private String lista_nmnomecliente = null;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-CDOCTO-PSSOA-EMPR")
	private String lista_cdoctopssoaempr = null;

	@Adapter(transactionField = "NPCCWK8S-REGISTRO.NPCCWK8S-LISTA.NPCCWK8S-DINDCD-OBRIG-AVALS")
	private String lista_dindcdobrigavals = null;
	
	public String getLista_documento() {
		return lista_documento;
	}
	public void setLista_documento(String lista_documento) {
		this.lista_documento = lista_documento;
	}

	public Long getLista_nseqcontrlim() {
		return lista_nseqcontrlim;
	}
	public void setLista_nseqcontrlim(Long lista_nseqcontrlim) {
		this.lista_nseqcontrlim = lista_nseqcontrlim;
	}

	public Integer getLista_cdcpfcnpj() {
		return lista_cdcpfcnpj;
	}
	public void setLista_cdcpfcnpj(Integer lista_cdcpfcnpj) {
		this.lista_cdcpfcnpj = lista_cdcpfcnpj;
	}

	public Integer getLista_cdfilial() {
		return lista_cdfilial;
	}
	public void setLista_cdfilial(Integer lista_cdfilial) {
		this.lista_cdfilial = lista_cdfilial;
	}

	public Integer getLista_cdctrlcpfcnpj() {
		return lista_cdctrlcpfcnpj;
	}
	public void setLista_cdctrlcpfcnpj(Integer lista_cdctrlcpfcnpj) {
		this.lista_cdctrlcpfcnpj = lista_cdctrlcpfcnpj;
	}

	public String getLista_nmnomecliente() {
		return lista_nmnomecliente;
	}
	public void setLista_nmnomecliente(String lista_nmnomecliente) {
		this.lista_nmnomecliente = lista_nmnomecliente;
	}

	public String getLista_cdoctopssoaempr() {
		return lista_cdoctopssoaempr;
	}
	public void setLista_cdoctopssoaempr(String lista_cdoctopssoaempr) {
		this.lista_cdoctopssoaempr = lista_cdoctopssoaempr;
	}

	public String getLista_dindcdobrigavals() {
		return lista_dindcdobrigavals;
	}
	public void setLista_dindcdobrigavals(String lista_dindcdobrigavals) {
		this.lista_dindcdobrigavals = lista_dindcdobrigavals;
	}
    
}