package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.GarantiaAdicionaCons;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/03/16 08:12
 */
public class Npccwypsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYPS-REGISTRO.NPCCWYPS-LISTA.NPCCWYPS-CD-GARNT")
	private Integer lista_cdgarnt = 0;

	@Adapter(transactionField = "NPCCWYPS-REGISTRO.NPCCWYPS-LISTA.NPCCWYPS-DS-GARNT")
	private String lista_dsgarnt = null;

	@Adapter(transactionField = "NPCCWYPS-REGISTRO.NPCCWYPS-LISTA.NPCCWYPS-CINDCD-ECONM-MOE-GAR")
	private Integer lista_cindcdeconmmoegar = 0;

	@Adapter(transactionField = "NPCCWYPS-REGISTRO.NPCCWYPS-LISTA.NPCCWYPS-DVCTO-GARANT-CMBIO")
	private String lista_dvctogarantcmbio = null;
	
	public Integer getLista_cdgarnt() {
		return lista_cdgarnt;
	}
	public void setLista_cdgarnt(Integer lista_cdgarnt) {
		this.lista_cdgarnt = lista_cdgarnt;
	}

	public String getLista_dsgarnt() {
		return lista_dsgarnt;
	}
	public void setLista_dsgarnt(String lista_dsgarnt) {
		this.lista_dsgarnt = lista_dsgarnt;
	}

	public Integer getLista_cindcdeconmmoegar() {
		return lista_cindcdeconmmoegar;
	}
	public void setLista_cindcdeconmmoegar(Integer lista_cindcdeconmmoegar) {
		this.lista_cindcdeconmmoegar = lista_cindcdeconmmoegar;
	}

	public String getLista_dvctogarantcmbio() {
		return lista_dvctogarantcmbio;
	}
	public void setLista_dvctogarantcmbio(String lista_dvctogarantcmbio) {
		this.lista_dvctogarantcmbio = lista_dvctogarantcmbio;
	}
    
}