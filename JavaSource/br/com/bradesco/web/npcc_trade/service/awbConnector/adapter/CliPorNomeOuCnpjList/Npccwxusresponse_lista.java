package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.CliPorNomeOuCnpjList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 20/02/17 13:37
 */
public class Npccwxusresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-CUNIC-PSSOA-CMBIO")
	private Long lista_cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-IREDZD-PSSOA-CMBIO")
	private String lista_iredzdpssoacmbio = null;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-CD-CPFCNPJ")
	private Integer lista_cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-CD-FILIAL")
	private Integer lista_cdfilial = 0;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-CD-CTRL-CPFCNPJ")
	private Integer lista_cdctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-NCTA-BCRIA-CMBIO")
	private Integer lista_nctabcriacmbio = 0;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-BCO-NOME")
	private String lista_bconome = null;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-CAG-BCRIA")
	private Integer lista_cagbcria = 0;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-CCTA-BCRIA-CLI")
	private Long lista_cctabcriacli = 0L;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-CDIG-BCRIA-CLI")
	private String lista_cdigbcriacli = null;

	@Adapter(transactionField = "NPCCWXUS-REGISTRO.NPCCWXUS-LISTA.NPCCWXUS-PILOTO-ATIVO")
	private String lista_pilotoativo = null;
	
	public Long getLista_cunicpssoacmbio() {
		return lista_cunicpssoacmbio;
	}
	public void setLista_cunicpssoacmbio(Long lista_cunicpssoacmbio) {
		this.lista_cunicpssoacmbio = lista_cunicpssoacmbio;
	}

	public String getLista_iredzdpssoacmbio() {
		return lista_iredzdpssoacmbio;
	}
	public void setLista_iredzdpssoacmbio(String lista_iredzdpssoacmbio) {
		this.lista_iredzdpssoacmbio = lista_iredzdpssoacmbio;
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

	public Integer getLista_nctabcriacmbio() {
		return lista_nctabcriacmbio;
	}
	public void setLista_nctabcriacmbio(Integer lista_nctabcriacmbio) {
		this.lista_nctabcriacmbio = lista_nctabcriacmbio;
	}

	public String getLista_bconome() {
		return lista_bconome;
	}
	public void setLista_bconome(String lista_bconome) {
		this.lista_bconome = lista_bconome;
	}

	public Integer getLista_cagbcria() {
		return lista_cagbcria;
	}
	public void setLista_cagbcria(Integer lista_cagbcria) {
		this.lista_cagbcria = lista_cagbcria;
	}

	public Long getLista_cctabcriacli() {
		return lista_cctabcriacli;
	}
	public void setLista_cctabcriacli(Long lista_cctabcriacli) {
		this.lista_cctabcriacli = lista_cctabcriacli;
	}

	public String getLista_cdigbcriacli() {
		return lista_cdigbcriacli;
	}
	public void setLista_cdigbcriacli(String lista_cdigbcriacli) {
		this.lista_cdigbcriacli = lista_cdigbcriacli;
	}

	public String getLista_pilotoativo() {
		return lista_pilotoativo;
	}
	public void setLista_pilotoativo(String lista_pilotoativo) {
		this.lista_pilotoativo = lista_pilotoativo;
	}
    
}