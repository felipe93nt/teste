package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TomadorList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/05/16 11:24
 */
public class Npccwo9sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-CUNIC-PSSOA-CMBIO")
	private Long lista_cunicpssoacmbio = 0L;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-ID-CLUB")
	private String lista_idclub = null;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-CD-CLUB")
	private Long lista_cdclub = 0L;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-CD-EMPRESA")
	private Long lista_cdempresa = 0L;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-CD-CPFCNPJ")
	private Integer lista_cdcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-CD-FILIAL")
	private Integer lista_cdfilial = 0;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-CD-CTRL-CPFCNPJ")
	private Integer lista_cdctrlcpfcnpj = 0;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-NM-NOME-CLIENTE")
	private String lista_nmnomecliente = null;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-SEGMENTO")
	private String lista_segmento = null;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-IPAIS-GEOGR")
	private String lista_ipaisgeogr = null;

	@Adapter(transactionField = "NPCCWO9S-REGISTRO.NPCCWO9S-LISTA.NPCCWO9S-ICIDDE-ENDER")
	private String lista_iciddeender = null;
	
	public Long getLista_cunicpssoacmbio() {
		return lista_cunicpssoacmbio;
	}
	public void setLista_cunicpssoacmbio(Long lista_cunicpssoacmbio) {
		this.lista_cunicpssoacmbio = lista_cunicpssoacmbio;
	}

	public String getLista_idclub() {
		return lista_idclub;
	}
	public void setLista_idclub(String lista_idclub) {
		this.lista_idclub = lista_idclub;
	}

	public Long getLista_cdclub() {
		return lista_cdclub;
	}
	public void setLista_cdclub(Long lista_cdclub) {
		this.lista_cdclub = lista_cdclub;
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

	public String getLista_segmento() {
		return lista_segmento;
	}
	public void setLista_segmento(String lista_segmento) {
		this.lista_segmento = lista_segmento;
	}

	public String getLista_ipaisgeogr() {
		return lista_ipaisgeogr;
	}
	public void setLista_ipaisgeogr(String lista_ipaisgeogr) {
		this.lista_ipaisgeogr = lista_ipaisgeogr;
	}

	public String getLista_iciddeender() {
		return lista_iciddeender;
	}
	public void setLista_iciddeender(String lista_iciddeender) {
		this.lista_iciddeender = lista_iciddeender;
	}
    
}