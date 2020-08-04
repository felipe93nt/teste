package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAvalistaInc;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 11:16
 */
public class Npccwk9sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA.NPCCWK9S-CUNIC-PSSOA-CMBIO")
	private Long lista_cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA.NPCCWK9S-DOCUMENTO")
	private String lista_documento = null;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA.NPCCWK9S-CD-CPFCNPJ")
	private Integer lista_cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA.NPCCWK9S-CD-FILIAL")
	private Integer lista_cdfilial = 0;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA.NPCCWK9S-CD-CTRL-CPFCNPJ")
	private Integer lista_cdctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA.NPCCWK9S-NM-NOME-CLIENTE")
	private String lista_nmnomecliente = null;

	@Adapter(transactionField = "NPCCWK9S-REGISTRO.NPCCWK9S-LISTA.NPCCWK9S-QUALIFICACAO")
	private String lista_qualificacao = null;
	
	public Long getLista_cunicpssoacmbio() {
		return lista_cunicpssoacmbio;
	}
	public void setLista_cunicpssoacmbio(Long lista_cunicpssoacmbio) {
		this.lista_cunicpssoacmbio = lista_cunicpssoacmbio;
	}

	public String getLista_documento() {
		return lista_documento;
	}
	public void setLista_documento(String lista_documento) {
		this.lista_documento = lista_documento;
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

	public String getLista_qualificacao() {
		return lista_qualificacao;
	}
	public void setLista_qualificacao(String lista_qualificacao) {
		this.lista_qualificacao = lista_qualificacao;
	}
    
}