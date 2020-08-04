package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComboPais;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 18/12/15 15:53
 */
public class Npcdwa3sresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWA3S-REGISTRO.NPCDWA3S-LISTA.NPCDWA3S-CD-PAIS-AGEO")
	private Integer lista_cdpaisageo = 0;

	@Adapter(transactionField = "NPCDWA3S-REGISTRO.NPCDWA3S-LISTA.NPCDWA3S-NOME-PAIS")
	private String lista_nomepais = null;

	@Adapter(transactionField = "NPCDWA3S-REGISTRO.NPCDWA3S-LISTA.NPCDWA3S-CD-PAIS-BACEN")
	private String lista_cdpaisbacen = null;
	
	public Integer getLista_cdpaisageo() {
		return lista_cdpaisageo;
	}
	public void setLista_cdpaisageo(Integer lista_cdpaisageo) {
		this.lista_cdpaisageo = lista_cdpaisageo;
	}

	public String getLista_nomepais() {
		return lista_nomepais;
	}
	public void setLista_nomepais(String lista_nomepais) {
		this.lista_nomepais = lista_nomepais;
	}

	public String getLista_cdpaisbacen() {
		return lista_cdpaisbacen;
	}
	public void setLista_cdpaisbacen(String lista_cdpaisbacen) {
		this.lista_cdpaisbacen = lista_cdpaisbacen;
	}
    
}