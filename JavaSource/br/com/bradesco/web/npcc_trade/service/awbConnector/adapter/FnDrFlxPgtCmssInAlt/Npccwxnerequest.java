package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:50
 */
public class Npccwxnerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWXNE-HEADER.NPCCWXNE-COD-LAYOUT")
	private String codlayout = "NPCCWXNE";

	@Adapter(transactionField = "NPCCWXNE-HEADER.NPCCWXNE-TAM-LAYOUT")
	private Integer tamlayout = 4797;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-NCOMIS-INTRN-CMBIO")
	private Integer ncomisintrncmbio = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-CFLUXO-PERDC-CMBIO")
	private Integer cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-VPREVT-COMIS-CMBIO")
	private String vprevtcomiscmbio = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-VMIN-COBR-COMIS")
	private String vmincobrcomis = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-VTX-SPREAD-APROV")
	private String vtxspreadaprov = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-PTX-FLAT-PNALT")
	private String ptxflatpnalt = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-PCOMIS-NEGOC-CMBIO")
	private String pcomisnegoccmbio = null;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-QPCELA-CMBIO-TRADE")
	private Integer qpcelacmbiotrade = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-CCOBR-COMIS-CMBIO")
	private Integer ccobrcomiscmbio = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-CCOBR-COMIS-INTRN")
	private Integer ccobrcomisintrn = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWXNE-REGISTRO.NPCCWXNE-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInAlt.Npccwxnerequest_lstlis")
	private List<Npccwxnerequest_lstlis> lstlis = null;
	
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

	public Integer getNcomisintrncmbio() {
		return ncomisintrncmbio;
	}
	public void setNcomisintrncmbio(Integer ncomisintrncmbio) {
		this.ncomisintrncmbio = ncomisintrncmbio;
	}

	public Integer getCfluxoperdccmbio() {
		return cfluxoperdccmbio;
	}
	public void setCfluxoperdccmbio(Integer cfluxoperdccmbio) {
		this.cfluxoperdccmbio = cfluxoperdccmbio;
	}

	public Integer getCindcdeconmmoeda() {
		return cindcdeconmmoeda;
	}
	public void setCindcdeconmmoeda(Integer cindcdeconmmoeda) {
		this.cindcdeconmmoeda = cindcdeconmmoeda;
	}
	public String getVprevtcomiscmbio() {
		return vprevtcomiscmbio;
	}
	public void setVprevtcomiscmbio(String vprevtcomiscmbio) {
		this.vprevtcomiscmbio = vprevtcomiscmbio;
	}
	public String getVmincobrcomis() {
		return vmincobrcomis;
	}
	public void setVmincobrcomis(String vmincobrcomis) {
		this.vmincobrcomis = vmincobrcomis;
	}
	public String getVtxspreadaprov() {
		return vtxspreadaprov;
	}
	public void setVtxspreadaprov(String vtxspreadaprov) {
		this.vtxspreadaprov = vtxspreadaprov;
	}
	public String getVtxspreadnegoc() {
		return vtxspreadnegoc;
	}
	public void setVtxspreadnegoc(String vtxspreadnegoc) {
		this.vtxspreadnegoc = vtxspreadnegoc;
	}
	public String getPtxflatpnalt() {
		return ptxflatpnalt;
	}
	public void setPtxflatpnalt(String ptxflatpnalt) {
		this.ptxflatpnalt = ptxflatpnalt;
	}
	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
	}
	public String getPcomisnegoccmbio() {
		return pcomisnegoccmbio;
	}
	public void setPcomisnegoccmbio(String pcomisnegoccmbio) {
		this.pcomisnegoccmbio = pcomisnegoccmbio;
	}
	public Integer getQpcelacmbiotrade() {
		return qpcelacmbiotrade;
	}
	public void setQpcelacmbiotrade(Integer qpcelacmbiotrade) {
		this.qpcelacmbiotrade = qpcelacmbiotrade;
	}
	public Integer getCcobrcomiscmbio() {
		return ccobrcomiscmbio;
	}
	public void setCcobrcomiscmbio(Integer ccobrcomiscmbio) {
		this.ccobrcomiscmbio = ccobrcomiscmbio;
	}
	public Integer getCcobrcomisintrn() {
		return ccobrcomisintrn;
	}
	public void setCcobrcomisintrn(Integer ccobrcomisintrn) {
		this.ccobrcomisintrn = ccobrcomisintrn;
	}
	public Integer getCmomencobrcmbio() {
		return cmomencobrcmbio;
	}
	public void setCmomencobrcmbio(Integer cmomencobrcmbio) {
		this.cmomencobrcmbio = cmomencobrcmbio;
	}
	public Integer getCprodtservc() {
		return cprodtservc;
	}
	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}
	public Integer getQtdoclist() {
		return qtdoclist;
	}
	public void setQtdoclist(Integer qtdoclist) {
		this.qtdoclist = qtdoclist;
	}
	public List<Npccwxnerequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis(List<Npccwxnerequest_lstlis> lstlis) {
		this.lstlis = lstlis;
	}

}