package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ConEstCotFecPerdList;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 21/09/16 09:55
 */
public class Npccwzgsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-LISTA.NPCCWZGS-MES")
	private String lista_mes = null;

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-LISTA.NPCCWZGS-COT-FECHADA")
	private String lista_cotfechada = null;

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-LISTA.NPCCWZGS-COT-PERDIDA")
	private String lista_cotperdida = null;

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-LISTA.NPCCWZGS-COT-TOTAL")
	private String lista_cottotal = null;

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-LISTA.NPCCWZGS-FECHADO-VLT")
	private String lista_fechadovlt = null;

	@Adapter(transactionField = "NPCCWZGS-REGISTRO.NPCCWZGS-LISTA.NPCCWZGS-PERDIDO-VLT")
	private String lista_perdidovlt = null;
	
	public String getLista_mes() {
		return lista_mes;
	}
	public void setLista_mes(String lista_mes) {
		this.lista_mes = lista_mes;
	}

	public String getLista_cotfechada() {
		return lista_cotfechada;
	}
	public void setLista_cotfechada(String lista_cotfechada) {
		this.lista_cotfechada = lista_cotfechada;
	}

	public String getLista_cotperdida() {
		return lista_cotperdida;
	}
	public void setLista_cotperdida(String lista_cotperdida) {
		this.lista_cotperdida = lista_cotperdida;
	}

	public String getLista_cottotal() {
		return lista_cottotal;
	}
	public void setLista_cottotal(String lista_cottotal) {
		this.lista_cottotal = lista_cottotal;
	}

	public String getLista_fechadovlt() {
		return lista_fechadovlt;
	}
	public void setLista_fechadovlt(String lista_fechadovlt) {
		this.lista_fechadovlt = lista_fechadovlt;
	}

	public String getLista_perdidovlt() {
		return lista_perdidovlt;
	}
	public void setLista_perdidovlt(String lista_perdidovlt) {
		this.lista_perdidovlt = lista_perdidovlt;
	}
    
}