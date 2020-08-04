package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.AlterarComplGarantia;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;

/**
 * Arquivo gerado automaticamente em 12/12/16 15:24
 */
public class Npccwwjerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWWJE-HEADER.NPCCWWJE-COD-LAYOUT")
	private String codlayout = "NPCCWWJE";

	@Adapter(transactionField = "NPCCWWJE-HEADER.NPCCWWJE-TAM-LAYOUT")
	private Integer tamlayout = 113;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-CUNIC-PSSOA-CMBIO-B")
	private Long cunicpssoacmbiob = 0L;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-CUNIC-PSSOA-CMBIO-A")
	private Long cunicpssoacmbioa = 0L;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-CINDCD-CNTRA-GARNT")
	private String cindcdcntragarnt = null;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-TDIA-CNTRA-GARNT")
	private Integer tdiacntragarnt = 0;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-DVCTO-CNTRA-GARNT")
	private String dvctocntragarnt = null;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-DABERT-CNTRA-GARNT")
	private String dabertcntragarnt = null;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-CINDCD-RENOV-CNTRA")
	private String cindcdrenovcntra = null;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-QDIA-ALERT-CNTRA")
	private Integer qdiaalertcntra = 0;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-DALERT-VCTO-CNTRA")
	private String dalertvctocntra = null;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-CINDCD-CUSTO-EXTER")
	private String cindcdcustoexter = null;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-HINCL-REG-HIST")
	private String hinclreghist = null;

	@Adapter(transactionField = "NPCCWWJE-REGISTRO.NPCCWWJE-CSIT-BLETO-CMBIO")
	private Integer csitbletocmbio = 0;
	
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

	public String getHinclreghist() {
		return hinclreghist;
	}
	public void setHinclreghist(String hinclreghist) {
		this.hinclreghist = hinclreghist;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}
	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}
    
}