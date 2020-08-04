package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.MercadoriasList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:19
 */
public class Npccwxgsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-NMCADO-CMBIO-TRADE")
	private Integer lista_nmcadocmbiotrade = 0;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-CMCADO-OPER-CMBIO")
	private Integer lista_cmcadoopercmbio = 0;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-RMCADO-OPER-CMBIO")
	private String lista_rmcadoopercmbio = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-CPAIS")
	private Integer lista_cpais = 0;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-IPAIS")
	private String lista_ipais = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-CUNIC-PSSOA-MCADO")
	private Long lista_cunicpssoamcado = 0L;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-IUNIC-PSSOA-MCADO")
	private String lista_iunicpssoamcado = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-CPAIS-BNEFC")
	private Integer lista_cpaisbnefc = 0;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-IPAIS-BNEFC")
	private String lista_ipaisbnefc = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-DPREVT-EMBRQ")
	private String lista_dprevtembrq = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-DPREVT-INIC-EMBRQ")
	private String lista_dprevtinicembrq = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-DPREVT-FIM-EMBRQ")
	private String lista_dprevtfimembrq = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-CPAIS-EMBRQ")
	private Integer lista_cpaisembrq = 0;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-IPAIS-EMBRQ")
	private String lista_ipaisembrq = null;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-NPCELA-DSEMB-CARTA")
	private Integer lista_npceladsembcarta = 0;

	@Adapter(transactionField = "NPCCWXGS-REGISTRO.NPCCWXGS-LISTA.NPCCWXGS-NDSEMB-CMBIO-TRADE")
	private Integer lista_ndsembcmbiotrade = 0;
	
	public Integer getLista_nmcadocmbiotrade() {
		return lista_nmcadocmbiotrade;
	}
	public void setLista_nmcadocmbiotrade(Integer lista_nmcadocmbiotrade) {
		this.lista_nmcadocmbiotrade = lista_nmcadocmbiotrade;
	}

	public Integer getLista_cmcadoopercmbio() {
		return lista_cmcadoopercmbio;
	}
	public void setLista_cmcadoopercmbio(Integer lista_cmcadoopercmbio) {
		this.lista_cmcadoopercmbio = lista_cmcadoopercmbio;
	}

	public String getLista_rmcadoopercmbio() {
		return lista_rmcadoopercmbio;
	}
	public void setLista_rmcadoopercmbio(String lista_rmcadoopercmbio) {
		this.lista_rmcadoopercmbio = lista_rmcadoopercmbio;
	}

	public Integer getLista_cpais() {
		return lista_cpais;
	}
	public void setLista_cpais(Integer lista_cpais) {
		this.lista_cpais = lista_cpais;
	}

	public String getLista_ipais() {
		return lista_ipais;
	}
	public void setLista_ipais(String lista_ipais) {
		this.lista_ipais = lista_ipais;
	}

	public Long getLista_cunicpssoamcado() {
		return lista_cunicpssoamcado;
	}
	public void setLista_cunicpssoamcado(Long lista_cunicpssoamcado) {
		this.lista_cunicpssoamcado = lista_cunicpssoamcado;
	}

	public String getLista_iunicpssoamcado() {
		return lista_iunicpssoamcado;
	}
	public void setLista_iunicpssoamcado(String lista_iunicpssoamcado) {
		this.lista_iunicpssoamcado = lista_iunicpssoamcado;
	}

	public Integer getLista_cpaisbnefc() {
		return lista_cpaisbnefc;
	}
	public void setLista_cpaisbnefc(Integer lista_cpaisbnefc) {
		this.lista_cpaisbnefc = lista_cpaisbnefc;
	}

	public String getLista_ipaisbnefc() {
		return lista_ipaisbnefc;
	}
	public void setLista_ipaisbnefc(String lista_ipaisbnefc) {
		this.lista_ipaisbnefc = lista_ipaisbnefc;
	}

	public String getLista_dprevtembrq() {
		return lista_dprevtembrq;
	}
	public void setLista_dprevtembrq(String lista_dprevtembrq) {
		this.lista_dprevtembrq = lista_dprevtembrq;
	}

	public String getLista_dprevtinicembrq() {
		return lista_dprevtinicembrq;
	}
	public void setLista_dprevtinicembrq(String lista_dprevtinicembrq) {
		this.lista_dprevtinicembrq = lista_dprevtinicembrq;
	}

	public String getLista_dprevtfimembrq() {
		return lista_dprevtfimembrq;
	}
	public void setLista_dprevtfimembrq(String lista_dprevtfimembrq) {
		this.lista_dprevtfimembrq = lista_dprevtfimembrq;
	}

	public Integer getLista_cpaisembrq() {
		return lista_cpaisembrq;
	}
	public void setLista_cpaisembrq(Integer lista_cpaisembrq) {
		this.lista_cpaisembrq = lista_cpaisembrq;
	}

	public String getLista_ipaisembrq() {
		return lista_ipaisembrq;
	}
	public void setLista_ipaisembrq(String lista_ipaisembrq) {
		this.lista_ipaisembrq = lista_ipaisembrq;
	}

	public Integer getLista_npceladsembcarta() {
		return lista_npceladsembcarta;
	}
	public void setLista_npceladsembcarta(Integer lista_npceladsembcarta) {
		this.lista_npceladsembcarta = lista_npceladsembcarta;
	}

	public Integer getLista_ndsembcmbiotrade() {
		return lista_ndsembcmbiotrade;
	}
	public void setLista_ndsembcmbiotrade(Integer lista_ndsembcmbiotrade) {
		this.lista_ndsembcmbiotrade = lista_ndsembcmbiotrade;
	}
    
}