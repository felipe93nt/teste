package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 13/03/17 09:43
 */
public class Npccwxserequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXSE-HEADER.NPCCWXSE-COD-LAYOUT")
	private String codlayout = "NPCCWXSE";

	@Adapter(transactionField = "NPCCWXSE-HEADER.NPCCWXSE-TAM-LAYOUT")
	private Integer tamlayout = 3089;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-NCOMIS-EXTER-TRADE")
	private Integer ncomisextertrade = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CCONDC-ECONC")
	private Integer ccondceconc = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-PCOMIS-NEGOC-CMBIO")
	private String pcomisnegoccmbio = null;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CPERDC-JURO-CMBIO")
	private Integer cperdcjurocmbio = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CBASE-CUSTO-CMBIO")
	private Integer cbasecustocmbio = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CFLUXO-PERDC-CMBIO")
	private Integer cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-QPCELA-CMBIO-TRADE")
	private Integer qpcelacmbiotrade = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-VPREVT-COMIS-CMBIO")
	private String vprevtcomiscmbio = null;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-CRESP-COMIS-EXTER")
	private Integer crespcomisexter = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWXSE-REGISTRO.NPCCWXSE-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExAlt.Npccwxserequest_lstlis")
	private List<Npccwxserequest_lstlis> lstlis = null;
	
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

	public Integer getNcomisextertrade() {
		return ncomisextertrade;
	}
	public void setNcomisextertrade(Integer ncomisextertrade) {
		this.ncomisextertrade = ncomisextertrade;
	}

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}

	public Integer getCcondceconc() {
		return ccondceconc;
	}
	public void setCcondceconc(Integer ccondceconc) {
		this.ccondceconc = ccondceconc;
	}

	public String getPcomisnegoccmbio() {
		return pcomisnegoccmbio;
	}
	public void setPcomisnegoccmbio(String pcomisnegoccmbio) {
		this.pcomisnegoccmbio = pcomisnegoccmbio;
	}

	public String getPjuronegoccmbio() {
		return pjuronegoccmbio;
	}
	public void setPjuronegoccmbio(String pjuronegoccmbio) {
		this.pjuronegoccmbio = pjuronegoccmbio;
	}

	public Integer getCperdcjurocmbio() {
		return cperdcjurocmbio;
	}
	public void setCperdcjurocmbio(Integer cperdcjurocmbio) {
		this.cperdcjurocmbio = cperdcjurocmbio;
	}

	public Integer getCbasecustocmbio() {
		return cbasecustocmbio;
	}
	public void setCbasecustocmbio(Integer cbasecustocmbio) {
		this.cbasecustocmbio = cbasecustocmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}

	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}

	public Integer getCmomencobrcmbio() {
		return cmomencobrcmbio;
	}
	public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
		this.cmomencobrcmbio = cmomencobrcmbio;
	}

	public Integer getQpcelacmbiotrade() {
		return qpcelacmbiotrade;
	}
	public void setQpcelacmbiotrade(Integer qpcelacmbiotrade) {
		this.qpcelacmbiotrade = qpcelacmbiotrade;
	}

	public String getVprevtcomiscmbio() {
		return vprevtcomiscmbio;
	}
	public void setVprevtcomiscmbio(String vprevtcomiscmbio) {
		this.vprevtcomiscmbio = vprevtcomiscmbio;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Integer getCrespcomisexter() {
		return crespcomisexter;
	}
	public void setCrespcomisexter(Integer crespcomisexter) {
		this.crespcomisexter = crespcomisexter;
	}

	public Integer getQtdoclist() {
		return qtdoclist;
	}
	public void setQtdoclist(Integer qtdoclist) {
		this.qtdoclist = qtdoclist;
	}

	public List<Npccwxserequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis( List<Npccwxserequest_lstlis> lstlis) {
		this.lstlis = lstlis;
	}
    
}