package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ComissaoExternaDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 23/06/16 19:25
 */
public class Npccwxksresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-LISTA.NPCCWXKS-NPCELA-COMIS-EXTER")
	private Integer lista_npcelacomisexter = 0;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-LISTA.NPCCWXKS-DVCTO-PCELA-TRADE")
	private String lista_dvctopcelatrade = null;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-LISTA.NPCCWXKS-VPCELA-COMIS-CMBIO")
	private String lista_vpcelacomiscmbio = null;

	@Adapter(transactionField = "NPCCWXKS-REGISTRO.NPCCWXKS-LISTA.NPCCWXKS-PRAZO-PARCELA")
	private Integer lista_prazoparcela = 0;
	
	public Integer getLista_npcelacomisexter() {
		return lista_npcelacomisexter;
	}
	public void setLista_npcelacomisexter(Integer lista_npcelacomisexter) {
		this.lista_npcelacomisexter = lista_npcelacomisexter;
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