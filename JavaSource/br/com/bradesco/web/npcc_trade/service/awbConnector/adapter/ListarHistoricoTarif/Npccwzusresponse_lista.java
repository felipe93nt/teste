package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ListarHistoricoTarif;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 24/06/16 14:20
 */
public class Npccwzusresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-CINDCD-DESP-TARF")
	private Integer lista_cindcddesptarf = 0;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-CCONDC-ECONC")
	private Integer lista_ccondceconc = 0;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-NTARIF-BLETO-CMBIO")
	private Integer lista_ntarifbletocmbio = 0;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-CTPO-DESP-CMBIO")
	private Integer lista_ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-NDESP-BLETO-CMBIO")
	private Long lista_ndespbletocmbio = 0L;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-ITPO-DESP-CMBIO")
	private String lista_itpodespcmbio = null;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWZUS-REGISTRO.NPCCWZUS-LISTA.NPCCWZUS-VDESP-BLETO-CMBIO")
	private String lista_vdespbletocmbio = null;
	
	public Integer getLista_cindcddesptarf() {
		return lista_cindcddesptarf;
	}
	public void setLista_cindcddesptarf(Integer lista_cindcddesptarf) {
		this.lista_cindcddesptarf = lista_cindcddesptarf;
	}

	public Integer getLista_ccondceconc() {
		return lista_ccondceconc;
	}
	public void setLista_ccondceconc(Integer lista_ccondceconc) {
		this.lista_ccondceconc = lista_ccondceconc;
	}

	public Integer getLista_ntarifbletocmbio() {
		return lista_ntarifbletocmbio;
	}
	public void setLista_ntarifbletocmbio(Integer lista_ntarifbletocmbio) {
		this.lista_ntarifbletocmbio = lista_ntarifbletocmbio;
	}

	public Integer getLista_ctpodespcmbio() {
		return lista_ctpodespcmbio;
	}
	public void setLista_ctpodespcmbio(Integer lista_ctpodespcmbio) {
		this.lista_ctpodespcmbio = lista_ctpodespcmbio;
	}

	public Long getLista_ndespbletocmbio() {
		return lista_ndespbletocmbio;
	}
	public void setLista_ndespbletocmbio(Long lista_ndespbletocmbio) {
		this.lista_ndespbletocmbio = lista_ndespbletocmbio;
	}

	public String getLista_itpodespcmbio() {
		return lista_itpodespcmbio;
	}
	public void setLista_itpodespcmbio(String lista_itpodespcmbio) {
		this.lista_itpodespcmbio = lista_itpodespcmbio;
	}

	public Integer getLista_cindcdeconmmoeda() {
		return lista_cindcdeconmmoeda;
	}
	public void setLista_cindcdeconmmoeda(Integer lista_cindcdeconmmoeda) {
		this.lista_cindcdeconmmoeda = lista_cindcdeconmmoeda;
	}

	public String getLista_isglindcdfonte() {
		return lista_isglindcdfonte;
	}
	public void setLista_isglindcdfonte(String lista_isglindcdfonte) {
		this.lista_isglindcdfonte = lista_isglindcdfonte;
	}

	public String getLista_vdespbletocmbio() {
		return lista_vdespbletocmbio;
	}
	public void setLista_vdespbletocmbio(String lista_vdespbletocmbio) {
		this.lista_vdespbletocmbio = lista_vdespbletocmbio;
	}
    
}