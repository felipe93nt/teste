package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.IncluirComplGarantia;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 13/07/16 21:26
 */
public class Npccwyierequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYIE-HEADER.NPCCWYIE-COD-LAYOUT")
	private String codlayout = "NPCCWYIE";

	@Adapter(transactionField = "NPCCWYIE-HEADER.NPCCWYIE-TAM-LAYOUT")
	private Integer tamlayout = 84;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-CUNIC-PSSOA-CMBIO-B")
	private Long cunicpssoacmbiob = 0L;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-CUNIC-PSSOA-CMBIO-A")
	private Long cunicpssoacmbioa = 0L;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-CINDCD-CNTRA-GARNT")
	private String cindcdcntragarnt = null;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-TDIA-CNTRA-GARNT")
	private Integer tdiacntragarnt = 0;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-DVCTO-CNTRA-GARNT")
	private String dvctocntragarnt = null;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-DABERT-CNTRA-GARNT")
	private String dabertcntragarnt = null;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-CINDCD-RENOV-CNTRA")
	private String cindcdrenovcntra = null;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-QDIA-ALERT-CNTRA")
	private Integer qdiaalertcntra = 0;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-DALERT-VCTO-CNTRA")
	private String dalertvctocntra = null;

	@Adapter(transactionField = "NPCCWYIE-REGISTRO.NPCCWYIE-CINDCD-CUSTO-EXTER")
	private String cindcdcustoexter = null;
	
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

	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	public Long getCunicpssoacmbiob() {
		return cunicpssoacmbiob;
	}
	public void setCunicpssoacmbiob(Long cunicpssoacmbiob) {
		this.cunicpssoacmbiob = cunicpssoacmbiob;
	}

	public Long getCunicpssoacmbioa() {
		return cunicpssoacmbioa;
	}
	public void setCunicpssoacmbioa(Long cunicpssoacmbioa) {
		this.cunicpssoacmbioa = cunicpssoacmbioa;
	}

	public String getCindcdcntragarnt() {
		return cindcdcntragarnt;
	}
	public void setCindcdcntragarnt(String cindcdcntragarnt) {
		this.cindcdcntragarnt = cindcdcntragarnt;
	}

	public Integer getTdiacntragarnt() {
		return tdiacntragarnt;
	}
	public void setTdiacntragarnt(Integer tdiacntragarnt) {
		this.tdiacntragarnt = tdiacntragarnt;
	}

	public String getDvctocntragarnt() {
		return dvctocntragarnt;
	}
	public void setDvctocntragarnt(String dvctocntragarnt) {
		this.dvctocntragarnt = dvctocntragarnt;
	}

	public String getDabertcntragarnt() {
		return dabertcntragarnt;
	}
	public void setDabertcntragarnt(String dabertcntragarnt) {
		this.dabertcntragarnt = dabertcntragarnt;
	}

	public String getCindcdrenovcntra() {
		return cindcdrenovcntra;
	}
	public void setCindcdrenovcntra(String cindcdrenovcntra) {
		this.cindcdrenovcntra = cindcdrenovcntra;
	}

	public Integer getQdiaalertcntra() {
		return qdiaalertcntra;
	}
	public void setQdiaalertcntra(Integer qdiaalertcntra) {
		this.qdiaalertcntra = qdiaalertcntra;
	}

	public String getDalertvctocntra() {
		return dalertvctocntra;
	}
	public void setDalertvctocntra(String dalertvctocntra) {
		this.dalertvctocntra = dalertvctocntra;
	}

	public String getCindcdcustoexter() {
		return cindcdcustoexter;
	}
	public void setCindcdcustoexter(String cindcdcustoexter) {
		this.cindcdcustoexter = cindcdcustoexter;
	}
    
}