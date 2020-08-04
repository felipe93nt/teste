package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ModeloBoletoDet;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 03/07/18 11:13
 */
public class Npccwvosresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-LISTA.NPCCWVOS-CTPO-CLAUS-CMBIO")
	private Integer lista_ctpoclauscmbio = 0;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-LISTA.NPCCWVOS-ITPO-CLAUS-CMBIO")
	private String lista_itpoclauscmbio = null;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-LISTA.NPCCWVOS-CCLAUS-MOD-CMBIO")
	private Integer lista_cclausmodcmbio = 0;

	@Adapter(transactionField = "NPCCWVOS-REGISTRO.NPCCWVOS-LISTA.NPCCWVOS-RCLAUS-MOD-CMBIO")
	private String lista_rclausmodcmbio = null;
	
	public Integer getLista_ctpoclauscmbio() {
		return lista_ctpoclauscmbio;
	}
	public void setLista_ctpoclauscmbio(Integer lista_ctpoclauscmbio) {
		this.lista_ctpoclauscmbio = lista_ctpoclauscmbio;
	}

	public String getLista_itpoclauscmbio() {
		return lista_itpoclauscmbio;
	}
	public void setLista_itpoclauscmbio(String lista_itpoclauscmbio) {
		this.lista_itpoclauscmbio = lista_itpoclauscmbio;
	}

	public Integer getLista_cclausmodcmbio() {
		return lista_cclausmodcmbio;
	}
	public void setLista_cclausmodcmbio(Integer lista_cclausmodcmbio) {
		this.lista_cclausmodcmbio = lista_cclausmodcmbio;
	}

	public String getLista_rclausmodcmbio() {
		return lista_rclausmodcmbio;
	}
	public void setLista_rclausmodcmbio(String lista_rclausmodcmbio) {
		this.lista_rclausmodcmbio = lista_rclausmodcmbio;
	}
    
}