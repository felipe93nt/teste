package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoInternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:04
 */
public class Npccwxfsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-LISTA.NPCCWXFS-NPCELA-COMIS-INTRN")
	private Integer lista_npcelacomisintrn = 0;

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-LISTA.NPCCWXFS-DVCTO-PCELA-TRADE")
	private String lista_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-LISTA.NPCCWXFS-VPCELA-COMIS-CMBIO")
	private String lista_vpcelacomiscmbio = null;

	@Adapter(transactionField = "NPCCWXFS-REGISTRO.NPCCWXFS-LISTA.NPCCWXFS-PRAZO-PARCELA")
	private Integer lista_prazoparcela = 0;
	
	public Integer getLista_npcelacomisintrn() {
		return lista_npcelacomisintrn;
	}
	public void setLista_npcelacomisintrn(Integer lista_npcelacomisintrn) {
		this.lista_npcelacomisintrn = lista_npcelacomisintrn;
	}

	public String getLista_dvctopcelatrade() {
		return lista_dvctopcelatrade;
	}
	public void setLista_dvctopcelatrade(String lista_dvctopcelatrade) {
		this.lista_dvctopcelatrade = lista_dvctopcelatrade;
	}

	public String getLista_vpcelacomiscmbio() {
		return lista_vpcelacomiscmbio;
	}
	public void setLista_vpcelacomiscmbio(String lista_vpcelacomiscmbio) {
		this.lista_vpcelacomiscmbio = lista_vpcelacomiscmbio;
	}

	public Integer getLista_prazoparcela() {
		return lista_prazoparcela;
	}
	public void setLista_prazoparcela(Integer lista_prazoparcela) {
		this.lista_prazoparcela = lista_prazoparcela;
	}
    
}