package br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl;

import br.com.bradesco.data.connector.Adapter;
import br.com.bradesco.data.connector.AnnotatedAdapter;
import java.util.List;

/**
 * Arquivo gerado automaticamente em 18/10/16 15:41
 */
public class Npccwylerequest extends AnnotatedAdapter {

	@Adapter(transactionField = "NPCCWYLE-HEADER.NPCCWYLE-COD-LAYOUT")
	private String codlayout = "NPCCWYLE";

	@Adapter(transactionField = "NPCCWYLE-HEADER.NPCCWYLE-TAM-LAYOUT")
	private Integer tamlayout = 4794;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = 0L;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-CFLUXO-PERDC-CMBIO")
	private Integer cfluxoperdccmbio = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-CINDCD-ECONM-MOEDA")
	private Integer cindcdeconmmoeda = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-VPREVT-COMIS-CMBIO")
	private String vprevtcomiscmbio = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-VMIN-COBR-COMIS")
	private String vmincobrcomis = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-VTX-SPREAD-APROV")
	private String vtxspreadaprov = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-VTX-SPREAD-NEGOC")
	private String vtxspreadnegoc = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-PTX-FLAT-PNALT")
	private String ptxflatpnalt = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-HINCL-REG")
	private String hinclreg = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-PCOMIS-NEGOC-CMBIO")
	private String pcomisnegoccmbio = null;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-QPCELA-CMBIO-TRADE")
	private Integer qpcelacmbiotrade = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-CCOBR-COMIS-CMBIO")
	private Integer ccobrcomiscmbio = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-CCOBR-COMIS-INTRN")
	private Integer ccobrcomisintrn = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-CMOMEN-COBR-CMBIO")
	private Integer cmomencobrcmbio = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-CPRODT-SERVC")
	private Integer cprodtservc = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-QTD-OC-LIST")
	private Integer qtdoclist = 0;

	@Adapter(transactionField = "NPCCWYLE-REGISTRO.NPCCWYLE-LST-LIS", isAnnotatedAdapter = true, nameClass = "br.com.bradesco.web.npcc_trade.service.awbConnector.adapter.FnDrFlxPgtCmssInIncl.Npccwylerequest_lstlis")
	private List<Npccwylerequest_lstlis> lstlis = null;
	
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

	public String getHinclreg() {
		return hinclreg;
	}
	public void setHinclreg(String hinclreg) {
		this.hinclreg = hinclreg;
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

	public List<Npccwylerequest_lstlis> getLstlis() {
		return lstlis;
	}
	public void setLstlis( List<Npccwylerequest_lstlis> lstlis) {
		this.lstlis = lstlis;
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
	public String getPcomisnegoccmbio() {
		return pcomisnegoccmbio;
	}
	public void setPcomisnegoccmbio(String pcomisnegoccmbio) {
		this.pcomisnegoccmbio = pcomisnegoccmbio;
	}
    
}