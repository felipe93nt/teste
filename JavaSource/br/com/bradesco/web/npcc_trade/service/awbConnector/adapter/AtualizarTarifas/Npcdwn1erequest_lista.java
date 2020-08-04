package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AtualizarTarifas;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 22/06/16 11:12
 */
public class Npcdwn1erequest_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCDWN1E-REGISTRO.NPCDWN1E-LISTA.NPCDWN1E-L-CPRODT-SERVC")
	private Integer lista_lcprodtservc = 0;

	@Adapter(transactionField = "NPCDWN1E-REGISTRO.NPCDWN1E-LISTA.NPCDWN1E-L-COPER")
	private Integer lista_lcoper = 0;

	@Adapter(transactionField = "NPCDWN1E-REGISTRO.NPCDWN1E-LISTA.NPCDWN1E-L-CCONDC-ECONC")
	private Integer lista_lccondceconc = 0;

	@Adapter(transactionField = "NPCDWN1E-REGISTRO.NPCDWN1E-LISTA.NPCDWN1E-L-IND-AUT")
	private String lista_lindaut = null;

	public Integer getLista_lcprodtservc() {
		return lista_lcprodtservc;
	}

	public void setLista_lcprodtservc(Integer lista_lcprodtservc) {
		this.lista_lcprodtservc = lista_lcprodtservc;
	}

	public Integer getLista_lcoper() {
		return lista_lcoper;
	}

	public void setLista_lcoper(Integer lista_lcoper) {
		this.lista_lcoper = lista_lcoper;
	}

	public Integer getLista_lccondceconc() {
		return lista_lccondceconc;
	}

	public void setLista_lccondceconc(Integer lista_lccondceconc) {
		this.lista_lccondceconc = lista_lccondceconc;
	}

	public String getLista_lindaut() {
		return lista_lindaut;
	}

	public void setLista_lindaut(String lista_lindaut) {
		this.lista_lindaut = lista_lindaut;
	}

}