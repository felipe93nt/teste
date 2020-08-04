package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.Garantiasavallist;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 04/10/16 15:49
 */
public class Npccwjqsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CUNIC-PSSOA-CMBIO")
	private Long lista_cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CPSSOA")
	private Long lista_cpssoa = 0L;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-DOCUMENTO")
	private String lista_documento = null;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-EMPRESA")
	private Long lista_cdempresa = 0L;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-CPFCNPJ")
	private Integer lista_cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-FILIAL")
	private Integer lista_cdfilial = 0;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-CTRL-CPFCNPJ")
	private Integer lista_cdctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-NM-NOME-CLIENTE")
	private String lista_nmnomecliente = null;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-NM-CONJUGE")
	private String lista_nmconjuge = null;

	@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-QUALIFICACAO")
	private String lista_qualificacao = null;
	
	public Long getLista_cunicpssoacmbio() {
		return lista_cunicpssoacmbio;
	}
	public void setLista_cunicpssoacmbio(Long lista_cunicpssoacmbio) {
		this.lista_cunicpssoacmbio = lista_cunicpssoacmbio;
	}

	public Long getLista_cpssoa() {
		return lista_cpssoa;
	}
	public void setLista_cpssoa(Long lista_cpssoa) {
		this.lista_cpssoa = lista_cpssoa;
	}

	public String getLista_documento() {
		return lista_documento;
	}
	public void setLista_documento(String lista_documento) {
		this.lista_documento = lista_documento;
	}

	public Long getLista_cdempresa() {
		return lista_cdempresa;
	}
	public void setLista_cdempresa(Long lista_cdempresa) {
		this.lista_cdempresa = lista_cdempresa;
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

	public String getLista_nmconjuge() {
		return lista_nmconjuge;
	}
	public void setLista_nmconjuge(String lista_nmconjuge) {
		this.lista_nmconjuge = lista_nmconjuge;
	}

	public String getLista_qualificacao() {
		return lista_qualificacao;
	}
	public void setLista_qualificacao(String lista_qualificacao) {
		this.lista_qualificacao = lista_qualificacao;
	}
    
}