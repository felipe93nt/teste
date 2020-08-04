package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 13/03/17 13:33
 */
public class Npccwymerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYME-HEADER.NPCCWYME-COD-LAYOUT")
	private String codlayout = "NPCCWYME";

	@Adapter(transactionField = "NPCCWYME-HEADER.NPCCWYME-TAM-LAYOUT")
	private Integer tamlayout = 3083;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-CCONDC-ECONC")
	private Integer ccondceconc = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-PCOMIS-NEGOC-CMBIO")
	private String pcomisnegoccmbio = null;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-PJURO-NEGOC-CMBIO")
	private String pjuronegoccmbio = null;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-CPERDC-JURO-CMBIO")
	private Integer cperdcjurocmbio = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-CFLUXO-PERDC-CMBIO")
	private Integer cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-QPCELA-CMBIO-TRADE")
	private Integer qpcelacmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-VPREVT-COMIS-CMBIO")
	private String vprevtcomiscmbio = null;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-CRESP-COMIS-EXTER")
	private Integer crespcomisexter = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWYME-REGISTRO.NPCCWYME-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssExIncl.Npccwymerequest_lstlis")
	private List<Npccwymerequest_lstlis> lstlis = null;
	
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

	public List<Npccwymerequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis( List<Npccwymerequest_lstlis> lstlis) {
		this.lstlis = lstlis;
	}
    
}