package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.OperacoesPendTotais;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 28/09/16 12:52
 */
public class Npccwzosresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZOS-REGISTRO.NPCCWZOS-LISTA.NPCCWZOS-NOME-UND-ORGNZ")
	private String lista_nomeundorgnz = null;

	@Adapter(transactionField = "NPCCWZOS-REGISTRO.NPCCWZOS-LISTA.NPCCWZOS-VPREVT-DSEMB-CMBIO")
	private Double lista_vprevtdsembcmbio = 0D;

	@Adapter(transactionField = "NPCCWZOS-REGISTRO.NPCCWZOS-LISTA.NPCCWZOS-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;
	
	public String getLista_nomeundorgnz() {
		return lista_nomeundorgnz;
	}
	public void setLista_nomeundorgnz(String lista_nomeundorgnz) {
		this.lista_nomeundorgnz = lista_nomeundorgnz;
	}

	public Double getLista_vprevtdsembcmbio() {
		return lista_vprevtdsembcmbio;
	}
	public void setLista_vprevtdsembcmbio(Double lista_vprevtdsembcmbio) {
		this.lista_vprevtdsembcmbio = lista_vprevtdsembcmbio;
	}

	public String getLista_isglindcdfonte() {
		return lista_isglindcdfonte;
	}
	public void setLista_isglindcdfonte(String lista_isglindcdfonte) {
		this.lista_isglindcdfonte = lista_isglindcdfonte;
	}
    
}