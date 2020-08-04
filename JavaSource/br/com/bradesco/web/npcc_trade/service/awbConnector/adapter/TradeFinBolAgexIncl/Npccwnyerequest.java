package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.TradeFinBolAgexIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 05/12/16 16:39
 */
public class Npccwnyerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWNYE-HEADER.NPCCWNYE-COD-LAYOUT")
	private String codlayout = "NPCCWNYE";

	@Adapter(transactionField = "NPCCWNYE-HEADER.NPCCWNYE-TAM-LAYOUT")
	private Integer tamlayout = 755;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-DFCHTO-BLETO-CMBIO")
	private String edfchtobletocmbio = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-CUNIC-CLI-CMBIO")
	private Long ecunicclicmbio = 0L;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-CPRODT-SERVC")
	private Integer ecprodtservc = 0;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-CMODLD-PRODT-CMBIO")
	private Integer ecmodldprodtcmbio = 0;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-CINDCD-ECONM-MOEDA")
	private Integer ecindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-NSEQ-CONTR-LIM")
	private Long enseqcontrlim = 0L;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-VNEGOC-MOEDA-ESTRG")
	private String evnegocmoedaestrg = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-VSDO-LIM-SENSI")
	private String evsdolimsensi = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-CBANQR-CMBIO")
	private Long ecbanqrcmbio = 0L;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-COPER-CMBIO-EXTER")
	private String ecopercmbioexter = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-VTX-SPREAD-NEGOC")
	private String evtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-TDIA-OPER-CMBIO")
	private Integer etdiaopercmbio = 0;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-DFIM-NEGOC-CMBIO")
	private String edfimnegoccmbio = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-RTOM-OBS-BLETO")
	private String ertomobsbleto = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-ROBS-BLETO-CMBIO")
	private String erobsbletocmbio = null;

	@Adapter(transactionField = "NPCCWNYE-REGISTRO.NPCCWNYE-E-CCATLG-GARNT-PRIN")
	private Integer eccatlggarntprin = 0;
	
	public String getCodlayout() {
		return codlayout;
	}
	public void setCodlayout(String codlayout) {
		this.codlayout = codlayout;
	}

	public Integer getTamlayout() {
		return tamlayout;
	}
	public void setTamlayout(Integer tamlayout) {
		this.tamlayout = tamlayout;
	}

	public String getEdfchtobletocmbio() {
		return edfchtobletocmbio;
	}
	public void setEdfchtobletocmbio(String edfchtobletocmbio) {
		this.edfchtobletocmbio = edfchtobletocmbio;
	}

	public Long getEcunicclicmbio() {
		return ecunicclicmbio;
	}
	public void setEcunicclicmbio(Long ecunicclicmbio) {
		this.ecunicclicmbio = ecunicclicmbio;
	}

	public Integer getEcprodtservc() {
		return ecprodtservc;
	}
	public void setEcprodtservc(Integer ecprodtservc) {
		this.ecprodtservc = ecprodtservc;
	}

	public Integer getEcmodldprodtcmbio() {
		return ecmodldprodtcmbio;
	}
	public void setEcmodldprodtcmbio(Integer ecmodldprodtcmbio) {
		this.ecmodldprodtcmbio = ecmodldprodtcmbio;
	}

	public Integer getEcindcdeconmmoeda() {
		return ecindcdeconmmoeda;
	}
	public void setEcindcdeconmmoeda(Integer ecindcdeconmmoeda) {
		this.ecindcdeconmmoeda = ecindcdeconmmoeda;
	}

	public Long getEnseqcontrlim() {
		return enseqcontrlim;
	}
	public void setEnseqcontrlim(Long enseqcontrlim) {
		this.enseqcontrlim = enseqcontrlim;
	}

	public String getEvnegocmoedaestrg() {
		return evnegocmoedaestrg;
	}
	public void setEvnegocmoedaestrg(String evnegocmoedaestrg) {
		this.evnegocmoedaestrg = evnegocmoedaestrg;
	}

	public String getEvsdolimsensi() {
		return evsdolimsensi;
	}
	public void setEvsdolimsensi(String evsdolimsensi) {
		this.evsdolimsensi = evsdolimsensi;
	}

	public Long getEcbanqrcmbio() {
		return ecbanqrcmbio;
	}
	public void setEcbanqrcmbio(Long ecbanqrcmbio) {
		this.ecbanqrcmbio = ecbanqrcmbio;
	}

	public String getEcopercmbioexter() {
		return ecopercmbioexter;
	}
	public void setEcopercmbioexter(String ecopercmbioexter) {
		this.ecopercmbioexter = ecopercmbioexter;
	}

	public String getEvtxspreadnegoc() {
		return evtxspreadnegoc;
	}
	public void setEvtxspreadnegoc(String evtxspreadnegoc) {
		this.evtxspreadnegoc = evtxspreadnegoc;
	}

	public Integer getEtdiaopercmbio() {
		return etdiaopercmbio;
	}
	public void setEtdiaopercmbio(Integer etdiaopercmbio) {
		this.etdiaopercmbio = etdiaopercmbio;
	}

	public String getEdfimnegoccmbio() {
		return edfimnegoccmbio;
	}
	public void setEdfimnegoccmbio(String edfimnegoccmbio) {
		this.edfimnegoccmbio = edfimnegoccmbio;
	}

	public String getErtomobsbleto() {
		return ertomobsbleto;
	}
	public void setErtomobsbleto(String ertomobsbleto) {
		this.ertomobsbleto = ertomobsbleto;
	}

	public String getErobsbletocmbio() {
		return erobsbletocmbio;
	}
	public void setErobsbletocmbio(String erobsbletocmbio) {
		this.erobsbletocmbio = erobsbletocmbio;
	}

	public Integer getEccatlggarntprin() {
		return eccatlggarntprin;
	}
	public void setEccatlggarntprin(Integer eccatlggarntprin) {
		this.eccatlggarntprin = eccatlggarntprin;
	}
    
}