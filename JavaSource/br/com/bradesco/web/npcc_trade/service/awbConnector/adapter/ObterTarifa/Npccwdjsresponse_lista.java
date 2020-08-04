package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.ObterTarifa;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 16/08/16 16:41
 */
public class Npccwdjsresponse_lista extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-CINDCD-DESP-TARF")
	private Integer lista_cindcddesptarf = 0;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-CCONDC-ECONC")
	private Integer lista_ccondceconc = 0;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-NTARIF-BLETO-CMBIO")
	private Integer lista_ntarifbletocmbio = 0;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-CTPO-DESP-CMBIO")
	private Integer lista_ctpodespcmbio = 0;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-NDESP-BLETO-CMBIO")
	private Long lista_ndespbletocmbio = 0L;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-ITPO-DESP-CMBIO")
	private String lista_itpodespcmbio = null;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-CINDCD-ECONM-MOEDA")
	private Integer lista_cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-ISGL-INDCD-FONTE")
	private String lista_isglindcdfonte = null;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-VDESP-BLETO-CMBIO")
	private String lista_vdespbletocmbio = null;

	@Adapter(transactionField = "NPCCWDJS-REGISTRO.NPCCWDJS-LISTA.NPCCWDJS-CTARIF-CMBIO-AUTOM")
	private String lista_ctarifcmbioautom = null;
	
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

	public String getLista_ctarifcmbioautom() {
		return lista_ctarifcmbioautom;
	}
	public void setLista_ctarifcmbioautom(String lista_ctarifcmbioautom) {
		this.lista_ctarifcmbioautom = lista_ctarifcmbioautom;
	}
    
}