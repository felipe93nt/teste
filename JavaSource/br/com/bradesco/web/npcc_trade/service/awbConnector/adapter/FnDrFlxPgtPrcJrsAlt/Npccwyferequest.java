package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 04/05/16 15:23
 */
public class Npccwyferequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYFE-HEADER.NPCCWYFE-COD-LAYOUT")
	private String codlayout = "NPCCWYFE";

	@Adapter(transactionField = "NPCCWYFE-HEADER.NPCCWYFE-TAM-LAYOUT")
	private Integer tamlayout = 7925;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-NDSEMB-CMBIO-TRADE")
	private Integer ndsembcmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-HMANUT-REG")
	private String hmanutreg = null;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-VPREVT-DSEMB-CMBIO")
	private String vprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-DPREVT-DSEMB-CMBIO")
	private String dprevtdsembcmbio = null;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-TDIA-CAREN-PRINC")
	private Integer tdiacarenprinc = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-CFLUXO-LIQDC-PRINC")
	private Integer cfluxoliqdcprinc = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-QPCELA-TRADE-PRINC")
	private Integer qpcelatradeprinc = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-TDIA-CAREN-JURO")
	private Integer tdiacarenjuro = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-TDIA-FINAN-DSEMB")
	private Integer tdiafinandsemb = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-CFLUXO-LIQDC-JURO")
	private Integer cfluxoliqdcjuro = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-QPCELA-TRADE-JURO")
	private Integer qpcelatradejuro = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-QTD-OC-MERC")
	private Integer qtdocmerc = 0;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Npccwyferequest_lstlis")
	private List<Npccwyferequest_lstlis> lstlis = null;

	@Adapter(transactionField = "NPCCWYFE-REGISTRO.NPCCWYFE-LST-MER", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtPrcJrsAlt.Npccwyferequest_lstmer")
	private List<Npccwyferequest_lstmer> lstmer = null;
	
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

	public Integer getNdsembcmbiotrade() {
		return ndsembcmbiotrade;
	}
	public void setNdsembcmbiotrade(Integer ndsembcmbiotrade) {
		this.ndsembcmbiotrade = ndsembcmbiotrade;
	}

	public String getHmanutreg() {
		return hmanutreg;
	}
	public void setHmanutreg(String hmanutreg) {
		this.hmanutreg = hmanutreg;
	}

	public String getVprevtdsembcmbio() {
		return vprevtdsembcmbio;
	}
	public void setVprevtdsembcmbio(String vprevtdsembcmbio) {
		this.vprevtdsembcmbio = vprevtdsembcmbio;
	}

	public String getDprevtdsembcmbio() {
		return dprevtdsembcmbio;
	}
	public void setDprevtdsembcmbio(String dprevtdsembcmbio) {
		this.dprevtdsembcmbio = dprevtdsembcmbio;
	}

	public Integer getTdiacarenprinc() {
		return tdiacarenprinc;
	}
	public void setTdiacarenprinc(Integer tdiacarenprinc) {
		this.tdiacarenprinc = tdiacarenprinc;
	}

	public Integer getCfluxoliqdcprinc() {
		return cfluxoliqdcprinc;
	}
	public void setCfluxoliqdcprinc(Integer cfluxoliqdcprinc) {
		this.cfluxoliqdcprinc = cfluxoliqdcprinc;
	}

	public Integer getQpcelatradeprinc() {
		return qpcelatradeprinc;
	}
	public void setQpcelatradeprinc(Integer qpcelatradeprinc) {
		this.qpcelatradeprinc = qpcelatradeprinc;
	}

	public Integer getTdiacarenjuro() {
		return tdiacarenjuro;
	}
	public void setTdiacarenjuro(Integer tdiacarenjuro) {
		this.tdiacarenjuro = tdiacarenjuro;
	}

	public Integer getTdiafinandsemb() {
		return tdiafinandsemb;
	}
	public void setTdiafinandsemb(Integer tdiafinandsemb) {
		this.tdiafinandsemb = tdiafinandsemb;
	}

	public Integer getCfluxoliqdcjuro() {
		return cfluxoliqdcjuro;
	}
	public void setCfluxoliqdcjuro(Integer cfluxoliqdcjuro) {
		this.cfluxoliqdcjuro = cfluxoliqdcjuro;
	}

	public Integer getQpcelatradejuro() {
		return qpcelatradejuro;
	}
	public void setQpcelatradejuro(Integer qpcelatradejuro) {
		this.qpcelatradejuro = qpcelatradejuro;
	}

	public Integer getCmomencobrcmbio() {
		return cmomencobrcmbio;
	}
	public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
		this.cmomencobrcmbio = cmomencobrcmbio;
	}

	public Integer getQtdoclist() {
		return qtdoclist;
	}
	public void setQtdoclist(Integer qtdoclist) {
		this.qtdoclist = qtdoclist;
	}

	public Integer getQtdocmerc() {
		return qtdocmerc;
	}
	public void setQtdocmerc(Integer qtdocmerc) {
		this.qtdocmerc = qtdocmerc;
	}

	public List<Npccwyferequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis( List<Npccwyferequest_lstlis> lstlis) {
		this.lstlis = lstlis;
	}

	public List<Npccwyferequest_lstmer> getLstmer() {
		return lstmer;
	}
	public void setLstmer( List<Npccwyferequest_lstmer> lstmer) {
		this.lstmer = lstmer;
	}
    
}